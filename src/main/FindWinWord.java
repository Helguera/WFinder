package main;

import java.io.File;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicLong;

public class FindWinWord {

    private static final File POISONPILL = new File("");

    private static class RunnableDirSearch implements Runnable {

        private final BlockingQueue<File> dirQueue;
        private final BlockingQueue<File> fileQueue;
        private final AtomicLong count;
        private final int num;

        public RunnableDirSearch(final BlockingQueue<File> dirQueue, final BlockingQueue<File> fileQueue, final AtomicLong count, final int num) {
            this.dirQueue = dirQueue;
            this.fileQueue = fileQueue;
            this.count = count;
            this.num = num;
        }

        @Override
        public void run() {
            try {
                File dir = dirQueue.take();
                while (dir != POISONPILL) {
                    final File[] fi = dir.listFiles();
                    if (fi != null) {
                        for (final File element : fi) {
                            if (element.isDirectory()) {
                                count.incrementAndGet();
                                dirQueue.put(element);
                            } else {
                                fileQueue.put(element);
                            }
                        }
                    }
                    final long c = count.decrementAndGet();
                    if (c == 0) {
                        end();
                    }
                    dir = dirQueue.take();
                }
            } catch (final InterruptedException ie) {
                // file found or error
            }
        }

        private final void end() {
            try {
                fileQueue.put(POISONPILL);
            } catch (final InterruptedException e) {
                // empty
            }
            for (int i = 0; i < num; i++) {
                try {
                    dirQueue.put(POISONPILL);
                } catch (final InterruptedException e) {
                    // empty
                }
            }
        }
    }

    private static class CallableFileSearch implements Callable<File> {

        private final BlockingQueue<File> dirQueue;
        private final BlockingQueue<File> fileQueue;
        private final String name;
        private final int num;

        public CallableFileSearch(final BlockingQueue<File> dirQueue, final BlockingQueue<File> fileQueue, final String name, final int num) {
            this.dirQueue = dirQueue;
            this.fileQueue = fileQueue;
            this.name = name;
            this.num = num;
        }

        @Override
        public File call() throws Exception {
            File file = fileQueue.take();
            while (file != POISONPILL) {
                final String filename = file.getName().toLowerCase();
                final String lf = name.toLowerCase();
                if (filename.equalsIgnoreCase(name) || filename.startsWith(lf) || filename.endsWith(lf)) {
                    end();
                    return file;
                }
                file = fileQueue.take();
            }
            return null;
        }

        private final void end() {
            for (int i = 0; i < num; i++) {
                try {
                    dirQueue.put(POISONPILL);
                } catch (final InterruptedException e) {
                    // empty
                }
            }
        }
    }

    private final String filename = "WINWORD.EXE";
    private final File baseDir = new File("C:/");
    private final int concurrency = 6;
    private final AtomicLong count;
    
    private String result;
    
   

    public FindWinWord() {
        count = new AtomicLong(0);
    }

    public File find() {
        final ExecutorService ex = Executors.newFixedThreadPool(concurrency + 1);
        final BlockingQueue<File> dirQueue = new LinkedBlockingQueue<File>();
        final BlockingQueue<File> fileQueue = new LinkedBlockingQueue<File>(10000);
        for (int i = 0; i < concurrency; i++) {
            ex.submit(new RunnableDirSearch(dirQueue, fileQueue, count, concurrency));
        }
        count.incrementAndGet();
        dirQueue.add(baseDir);
        final Future<File> c = ex.submit(new CallableFileSearch(dirQueue, fileQueue, filename, concurrency));
        try {
            final File f = c.get();
            return f;
        } catch (final Exception e) {
            return null;
        } finally {
            ex.shutdownNow();
        }
    }

    /*public static void main(final String[] args) {
        final String filename = "WINWORD.EXE";
        final File baseDir = new File("C:/");
        final FindFile ff = new FindFile(filename);
        final long ini = System.currentTimeMillis();
        final File f = ff.find();
        final long end = System.currentTimeMillis();
        System.out.println(f + " " + (end - ini) + " ms");
    }*/
}
