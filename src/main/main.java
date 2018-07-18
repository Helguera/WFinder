package main;

import Vista.Ventana_Main;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.openpackaging.parts.WordprocessingML.MainDocumentPart;
import org.docx4j.wml.Text;

public class main {

    public static void main(String args[]) throws Docx4JException, JAXBException, IOException {
        Ventana_Main ventana = new Ventana_Main();
        ventana.setVisible(true);
        
        
        //JOptionPane.showMessageDialog(null, "My Goodness, this is so concise", "Warning", JOptionPane.WARNING_MESSAGE);
        
        /*File doc = new File("C:\\Users\\Sociograph\\Desktop\\prueba.docx");
        WordprocessingMLPackage wordMLPackage = WordprocessingMLPackage.load(doc);

        MainDocumentPart mainDocumentPart = wordMLPackage.getMainDocumentPart();
        List<Object> textNodes = mainDocumentPart.getContent();
        for (Object obj : textNodes) {
            String text = (String) obj.toString();
            System.out.println(text);
        }*/
        
        
        /*String filename = "WINWORD.EXE";
        File baseDir = new File("C:/");
        FindFile ff = new FindFile(filename, baseDir, 6);
        long ini = System.currentTimeMillis();
        File f = ff.find();
        Runtime runTime = Runtime.getRuntime();
        Process process = runTime.exec(f.toString());*/

    }

}
