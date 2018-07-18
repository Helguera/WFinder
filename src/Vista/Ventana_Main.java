/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.UIManager;
import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.openpackaging.parts.WordprocessingML.MainDocumentPart;

/**
 *
 * @author Sociograph
 */
public class Ventana_Main extends javax.swing.JFrame {

    private ArrayList<File> ficheros = new ArrayList<>();
    private String nomCarp;

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
    }

    public void getFiles(File carpeta) {
        String[] filesindir = carpeta.list();
        if (filesindir.length > 0) {
            Arrays.sort(filesindir);
        }
        for (String filesindir1 : filesindir) {
            if (isDocx(filesindir1)) {
                ficheros.add(new File(nomCarp + "\\" + filesindir1));
                System.out.println(filesindir1);
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSeleccionarCarpeta = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        lblFolder = new javax.swing.JLabel();
        searchTextField = new javax.swing.JTextField();
        lblTick = new javax.swing.JLabel();
        pnlFich = new javax.swing.JScrollPane();
        lstDocs = new javax.swing.JList<>();
        lblResult = new javax.swing.JLabel();
        chkSeleccionador = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstResult = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
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

        lblTick.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTick.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Green-Tick.png"))); // NOI18N

        lstDocs.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstDocsValueChanged(evt);
            }
        });
        pnlFich.setViewportView(lstDocs);

        lblResult.setText("Resultado:");

        chkSeleccionador.setText("Seleccionar Todo");
        chkSeleccionador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkSeleccionadorActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(lstResult);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSeleccionarCarpeta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblFolder, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblTick, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(searchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(pnlFich)
                            .addComponent(chkSeleccionador)
                            .addComponent(lblResult)
                            .addComponent(jScrollPane1))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTick, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnSeleccionarCarpeta)
                        .addComponent(lblFolder)))
                .addGap(17, 17, 17)
                .addComponent(chkSeleccionador)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlFich, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addComponent(lblResult)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchTextFieldActionPerformed

    private void btnSeleccionarCarpetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarCarpetaActionPerformed
        // TODO add your handling code here:
        JFileChooser selector_carpeta = new JFileChooser();
        selector_carpeta.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        selector_carpeta.setDialogTitle("Selecciona carpeta");
        selector_carpeta.setAcceptAllFileFilterUsed(false);
        selector_carpeta.setVisible(true);
        if (selector_carpeta.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            nomCarp = selector_carpeta.getSelectedFile().toString();
            lblFolder.setText("Carpeta: " + selector_carpeta.getSelectedFile().toString());
            lblTick.setVisible(true);
            getFiles(selector_carpeta.getSelectedFile());
            DefaultListModel listModel;
            listModel = new DefaultListModel();
            lstDocs.setModel(listModel);
            for (int i = 0; i < ficheros.size(); i++) {
                listModel.addElement(ficheros.get(i).toString());
            }

        } else {
            lblTick.setIcon(new ImageIcon("\\images\\cancel_icon.png"));
            lblTick.setVisible(true);
            repaint();
            validate();
        }
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
        btnBuscar.setEnabled(true);
    }//GEN-LAST:event_lstDocsValueChanged

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        DefaultListModel listModel;
        listModel = new DefaultListModel();
        String buscar = searchTextField.getText();
        System.out.println("ENtor 1");
        for (int i = 0; i < ficheros.size(); i++) {
            for (int j = 0; j < lstDocs.getSelectedIndices().length; j++) {
                System.out.println("ENtor" + i);
                if (ficheros.get(i).toString().equals(lstDocs.getSelectedValues()[j].toString())) {
                    System.out.println("ENtor IF");
                    File doc = ficheros.get(i);

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

                            lstResult.setModel(listModel);
                            listModel.addElement(text);
                            
                        }
                    }
                }
            }
        }


    }//GEN-LAST:event_btnBuscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnSeleccionarCarpeta;
    private javax.swing.JCheckBox chkSeleccionador;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblFolder;
    private javax.swing.JLabel lblResult;
    private javax.swing.JLabel lblTick;
    private javax.swing.JList<String> lstDocs;
    private javax.swing.JList<String> lstResult;
    private javax.swing.JScrollPane pnlFich;
    private javax.swing.JTextField searchTextField;
    // End of variables declaration//GEN-END:variables
}
