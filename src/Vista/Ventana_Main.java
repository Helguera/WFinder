/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import main.FindWinWord;
import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.openpackaging.parts.WordprocessingML.MainDocumentPart;

/**
 *
 * @author Sociograph
 */
public class Ventana_Main extends javax.swing.JFrame {

    private ArrayList<Fichero> ficheros = new ArrayList<>();
    private String nomCarp;
    private Thread thread;
    private int multiple = 0;
    private String ruta_word;

    /**
     * Creates new form Ventana_Main
     */
    public Ventana_Main() {
        //Establece los botones al estilo de Windows
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception e) {
            System.out.println("UIManager Exception : " + e);
        }

        setLocationRelativeTo(null);    //La ventana aparece en el centro de la pantalla
        initComponents();
        TextPrompt placeholder = new TextPrompt("Texto a buscar...", searchTextField);  //Placeholder para la busqueda de texto
        placeholder.setForeground(Color.LIGHT_GRAY);
        placeholder.changeStyle(Font.ITALIC);

        lblTick.setVisible(false);
        lblLoading.setVisible(false);

        FindWinWord ff = new FindWinWord();
        File f = ff.find();
        ruta_word = f.toString();
        System.out.println(ruta_word);
    }

    public void getFiles(File carpeta) {
        String[] filesindir = carpeta.list();
        if (filesindir.length > 0) {
            Arrays.sort(filesindir);
        }
        for (String filesindir1 : filesindir) {
            if (isDocx(filesindir1)) {
                ficheros.add(new Fichero(filesindir1, nomCarp));

            }
        }

    }

    public static boolean isDocx(String file) {
        for (int i = file.length() - 1; i > -1; i--) {

            if (file.charAt(i) == '.') {
                if (file.substring(i + 1).equals("docx")) {
                    return true;
                }
            }
        }
        return false;
    }

    public String extractText(String text) {
        int index = text.indexOf(" -- ");
        return text.substring(index + 4);
    }

    public String extractFileName(String text) {
        int index = text.indexOf(" -- ");
        return text.substring(0, index);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        btnSeleccionarCarpeta = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        lblFolder = new javax.swing.JLabel();
        searchTextField = new javax.swing.JTextField();
        lblTick = new javax.swing.JLabel();
        pnlFich = new javax.swing.JScrollPane();
        lstDocs = new javax.swing.JList<>();
        chkSeleccionador = new javax.swing.JCheckBox();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        lblLoading = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstResult = new javax.swing.JList<>();
        jSeparator1 = new javax.swing.JSeparator();
        lblFich = new javax.swing.JLabel();
        lblSel = new javax.swing.JLabel();
        lblRes = new javax.swing.JLabel();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("WFinder v1.0");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        btnSeleccionarCarpeta.setText("Seleccionar Carpeta");
        btnSeleccionarCarpeta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarCarpetaActionPerformed(evt);
            }
        });

        btnBuscar.setText("Buscar");
        btnBuscar.setEnabled(false);
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        lblFolder.setText("Carpeta: ");

        searchTextField.setToolTipText("");
        searchTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchTextFieldActionPerformed(evt);
            }
        });
        searchTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                searchTextFieldKeyPressed(evt);
            }
        });

        lblTick.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTick.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Green-Tick.png"))); // NOI18N

        lstDocs.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstDocsValueChanged(evt);
            }
        });
        pnlFich.setViewportView(lstDocs);

        chkSeleccionador.setText("Seleccionar Todo");
        chkSeleccionador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkSeleccionadorActionPerformed(evt);
            }
        });

        lblLoading.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLoading.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/loading.gif"))); // NOI18N
        lblLoading.setVerifyInputWhenFocusTarget(false);

        lstResult.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lstResultMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(lstResult);

        jLayeredPane1.setLayer(lblLoading, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblLoading, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 606, Short.MAX_VALUE))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblLoading, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                    .addGap(0, 1, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        lblFich.setText("(0) Ficheros");

        lblSel.setText("(0) Seleccionados");

        lblRes.setText("(0) Resultados");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLayeredPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnSeleccionarCarpeta)
                                    .addComponent(chkSeleccionador))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblFolder, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblFich)
                                        .addGap(59, 59, 59)
                                        .addComponent(lblSel)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblTick, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(searchTextField)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(pnlFich, javax.swing.GroupLayout.PREFERRED_SIZE, 620, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblRes)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSeleccionarCarpeta)
                            .addComponent(lblFolder))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(chkSeleccionador)
                            .addComponent(lblFich)
                            .addComponent(lblSel)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblTick, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlFich, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblRes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jLayeredPane1.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchTextFieldActionPerformed

    private void btnSeleccionarCarpetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarCarpetaActionPerformed
        // TODO add your handling code here:
        ficheros.clear();
        if (lstDocs.getModel().getSize() >= 1) {
            lstDocs.clearSelection();
        }
        DefaultListModel listModel;
        listModel = new DefaultListModel();
        lstDocs.setModel(listModel);
        lblFolder.setText("");
        chkSeleccionador.setSelected(false);
        JFileChooser selector_carpeta = new JFileChooser();
        selector_carpeta.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        selector_carpeta.setDialogTitle("Selecciona carpeta");
        selector_carpeta.setAcceptAllFileFilterUsed(false);
        selector_carpeta.setVisible(true);
        if (selector_carpeta.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            nomCarp = selector_carpeta.getSelectedFile().toString();

            getFiles(selector_carpeta.getSelectedFile());
            if (ficheros.isEmpty()) {
                JOptionPane.showMessageDialog(null, "La carpeta seleccionada no contiene ficheros .docx", "Aviso", JOptionPane.WARNING_MESSAGE);
                lblTick.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cancel_icon.png")));
                lblTick.setVisible(true);
                lblTick.repaint();
                lblTick.validate();
            } else {
                lblTick.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Green-Tick.png")));
                lblTick.setVisible(true);
                lblTick.repaint();
                lblTick.validate();

                for (int i = 0; i < ficheros.size(); i++) {

                    listModel.addElement(ficheros.get(i).getNombre());
                }
                lblFolder.setText("Carpeta: " + selector_carpeta.getSelectedFile().toString());
                lblTick.setVisible(true);
            }

        } else {
            lblTick.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cancel_icon.png")));
            lblTick.setVisible(true);
            lblTick.repaint();
            lblTick.validate();
            listModel.removeAllElements();
            lstDocs.revalidate();
            
        }

        lblFich.setText("(" + lstDocs.getModel().getSize() + ") Ficheros");

        lblFich.revalidate();


    }//GEN-LAST:event_btnSeleccionarCarpetaActionPerformed

    private void chkSeleccionadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkSeleccionadorActionPerformed
        // TODO add your handling code here:
        if (chkSeleccionador.isSelected()) {
            lstDocs.setSelectionInterval(0, (lstDocs.getModel().getSize() - 1));
        } else {
            lstDocs.clearSelection();
            btnBuscar.setEnabled(false);
        }
    }//GEN-LAST:event_chkSeleccionadorActionPerformed

    private void lstDocsValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstDocsValueChanged
        // TODO add your handling code here:
        lblSel.setText("(" + lstDocs.getSelectedValuesList().size() + ") Seleccionados");
        lblSel.revalidate();
        btnBuscar.setEnabled(true);
    }//GEN-LAST:event_lstDocsValueChanged

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        //TODO add your handling code here:
        multiple = 0;
        thread = new Thread() {
            @Override
            public void run() {
                try {
                    boolean entrada = false;
                    if (searchTextField.getText().length() < 1) {
                        JOptionPane.showMessageDialog(null, "El campo de búsqueda no puede estar vacío", "Aviso", JOptionPane.WARNING_MESSAGE);
                    } else {
                        btnBuscar.setEnabled(false);
                        lblLoading.setVisible(true);
                        lblLoading.setEnabled(true);
                        DefaultListModel listModel;
                        listModel = new DefaultListModel();
                        lstResult.setModel(listModel);
                        String buscar = searchTextField.getText();

                        for (int i = 0; i < ficheros.size(); i++) {
                            for (int j = 0; j < lstDocs.getSelectedIndices().length; j++) {

                                if (ficheros.get(i).getNombre().equals(lstDocs.getSelectedValues()[j].toString())) {

                                    File doc = new File(ficheros.get(i).getRuta() + "\\" + ficheros.get(i).getNombre());

                                    WordprocessingMLPackage wordMLPackage = null;
                                    try {
                                        wordMLPackage = WordprocessingMLPackage.load(doc);
                                    } catch (Docx4JException ex) {
                                        Logger.getLogger(Ventana_Main.class.getName()).log(Level.SEVERE, null, ex);
                                    }

                                    MainDocumentPart mainDocumentPart = wordMLPackage.getMainDocumentPart();
                                    List<Object> textNodes = mainDocumentPart.getContent();
                                    for (Object obj : textNodes) {
                                        String text = (String) obj.toString();
                                        if (text.contains(buscar)) {

                                            btnBuscar.setEnabled(true);
                                            listModel.addElement(ficheros.get(i).getNombreSinDocx() + " -- " + text);
                                            entrada = true;
                                            multiple++;
                                        }
                                    }
                                }
                            }
                        }

                        if (!entrada && multiple < 1) {
                            //listModel.removeAllElements();
                            //lstResult.revalidate();
                            JOptionPane.showMessageDialog(null, "No se han encontrado coincidencias", "Aviso", JOptionPane.WARNING_MESSAGE);
                            btnBuscar.setEnabled(true);
                        }

                        lblRes.setText("(" + listModel.getSize() + ") Resultados");
                        lblRes.revalidate();
                        lblLoading.setVisible(false);
                        lblLoading.setEnabled(false);
                    }

                } catch (HeadlessException e) {

                }
            }
        };

        thread.start();
        btnBuscar.setEnabled(true);

    }//GEN-LAST:event_btnBuscarActionPerformed

    private void searchTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTextFieldKeyPressed

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnBuscar.doClick();
        }
    }//GEN-LAST:event_searchTextFieldKeyPressed

    private void lstResultMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstResultMouseClicked
        JList list = (JList) evt.getSource();
        if (evt.getClickCount() == 2) {
            //System.out.println("RUTA DEL ARCHIVO A ABRIR: "+extractFileName(lstResult.getSelectedValue()));
            //System.out.println("Texto: "+extractText(lstResult.getSelectedValue()));
            Ventana_Texto ventana_texto = new Ventana_Texto(ruta_word);
            ventana_texto.setVisible(true);
            ventana_texto.setTexto(extractText(lstResult.getSelectedValue()));
            ventana_texto.setButton(nomCarp + "\\" + extractFileName(lstResult.getSelectedValue()) + ".docx");
            ventana_texto.setNombre(extractFileName(lstResult.getSelectedValue()) + ".docx");
        }
    }//GEN-LAST:event_lstResultMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnSeleccionarCarpeta;
    private javax.swing.JCheckBox chkSeleccionador;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lblFich;
    private javax.swing.JLabel lblFolder;
    private javax.swing.JLabel lblLoading;
    private javax.swing.JLabel lblRes;
    private javax.swing.JLabel lblSel;
    private javax.swing.JLabel lblTick;
    private javax.swing.JList<String> lstDocs;
    private javax.swing.JList<String> lstResult;
    private javax.swing.JScrollPane pnlFich;
    private javax.swing.JTextField searchTextField;
    // End of variables declaration//GEN-END:variables
}
