/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.security.Principal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

/**
 *
 * @author fedem
 */
public class MainFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
        setLocationRelativeTo(null);
        URL url;
        url = getClass().getResource("/imagenes/icono.png");
        ImageIcon img = new ImageIcon(url);
        setIconImage(img.getImage());
        outputSearchBtn.setEnabled(false);
        convertBtn.setEnabled(false);
    }

    String fileInputPath ="";
    String fileOutputPath = "";
    int[] longitudCab = {4,5,8,8,4,4,2,10,10,3,1,12,36,2,141};

    public int getLongitudCab(int pos) {
        return longitudCab[pos];
    }
    int[] longitudR1 =  {4,5,2,22,1,22,10,13,2,6,8,15,23,1,40,76};
    int[] longitudR2 =  {4,5,2,22,36,36,36,109};
    int[] longitudR3 =  {4,5,2,22,36,36,36,109};
    int[] longitudR4 =  {4,5,2,22,40,177};
    int[] longitudPie = {4,5,13,2,8,10,208};
    public String getFileInputPath() {
        return fileInputPath;
    }

    public void setFileInputPath(String fileInputPath) {
        this.fileInputPath = fileInputPath;
    }

    public String getFileOutputPath() {
        return fileOutputPath;
    }

    public void setFileOutputPath(String fileOutputPath) {
        this.fileOutputPath = fileOutputPath;
    }
            
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtInputPath = new javax.swing.JTextField();
        inputSearchBtn = new javax.swing.JButton();
        txtOutputPath = new javax.swing.JTextField();
        outputSearchBtn = new javax.swing.JButton();
        exitBtn = new javax.swing.JButton();
        convertBtn = new javax.swing.JButton();
        convertRes = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Convertidor VALUGE");
        setResizable(false);

        txtInputPath.setEditable(false);
        txtInputPath.setText("seleccione el archivo excel \".xls\"");

        inputSearchBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/findFile.png"))); // NOI18N
        inputSearchBtn.setText("Cargar Archivo");
        inputSearchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputSearchBtnActionPerformed(evt);
            }
        });

        txtOutputPath.setEditable(false);
        txtOutputPath.setText("seleccione el directorio donde se guardara el archivo");

        outputSearchBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/finDir.png"))); // NOI18N
        outputSearchBtn.setText("Seleccione");
        outputSearchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                outputSearchBtnActionPerformed(evt);
            }
        });

        exitBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/exit.png"))); // NOI18N
        exitBtn.setText("Salir");
        exitBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitBtnMouseClicked(evt);
            }
        });

        convertBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/convert.png"))); // NOI18N
        convertBtn.setText("Convertir");
        convertBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                convertBtnActionPerformed(evt);
            }
        });

        convertRes.setEditable(false);
        convertRes.setText("resultado del proceso...");
        convertRes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                convertResActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtOutputPath, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                            .addComponent(txtInputPath))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(inputSearchBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(outputSearchBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(exitBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(convertBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(convertRes, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputSearchBtn)
                    .addComponent(txtInputPath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtOutputPath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(outputSearchBtn))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(convertBtn)
                    .addComponent(convertRes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(exitBtn))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void convertResActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_convertResActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_convertResActionPerformed

    private void exitBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitBtnMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_exitBtnMouseClicked

    private void inputSearchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputSearchBtnActionPerformed
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser(System.getProperty("user.home"));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivo Excel (.xls)", "xls");
        chooser.setFileFilter(filter);
        chooser.setAcceptAllFileFilterUsed(false);
        if(chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION){
            String inputPath = chooser.getSelectedFile().toString();
            txtInputPath.setText(inputPath);
            setFileInputPath(inputPath);
            outputSearchBtn.setEnabled(true);
            
        }
    }//GEN-LAST:event_inputSearchBtnActionPerformed

    private void outputSearchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_outputSearchBtnActionPerformed
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser(System.getProperty("user.home"));
        chooser.setDialogTitle("Guardar en...");
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);
        if(chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION){
            String outputPath = chooser.getSelectedFile().toString();
            txtOutputPath.setText(outputPath);
            setFileOutputPath(chooser.getSelectedFile()+"\\NOMINAS.NOM");
            convertBtn.setEnabled(true);
        }else{
            lanzarAlerta("Debe seleccionar un directorio destino");
        }
    }//GEN-LAST:event_outputSearchBtnActionPerformed

    private void convertBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_convertBtnActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            //lanzarAlerta(getFileInputPath());
            Workbook workbook = Workbook.getWorkbook(new File(getFileInputPath()));
            Sheet sheet = workbook.getSheet(0);
            String nombre ;
            String ruta;
            String formato ="";
            String codigo = "";
            ruta = getFileOutputPath();
            File archivo = new File(ruta);
            BufferedWriter bw;
            bw = new BufferedWriter(new FileWriter(archivo));
            for (int fila = 0; fila < sheet.getRows(); fila++){
                  for (int columna = 0; columna < sheet.getColumns(); columna++){
                      if(columna == 0){
                          codigo = sheet.getCell(columna, fila).getContents();
                      }
                      nombre = sheet.getCell(columna, fila).getContents();
                      
                      if(codigo.equals("2110") && columna <= 14){
                          formato = "%-"+longitudCab[columna]+"s";
                          bw.write(String.format(formato, nombre));
                      }else if(codigo.equals("2210") && columna <= 15){
                          formato = "%-"+longitudR1[columna]+"s";
                          bw.write(String.format(formato, nombre));
                      }else if(codigo.equals("2220") && columna <= 7){
                          formato = "%-"+longitudR2[columna]+"s";
                          bw.write(String.format(formato, nombre));
                      }else if(codigo.equals("2230") && columna <= 7){
                          formato = "%-"+longitudR3[columna]+"s";
                          bw.write(String.format(formato, nombre));
                      }else if(codigo.equals("2240") && columna <= 5){
                          formato = "%-"+longitudR4[columna]+"s";
                          bw.write(String.format(formato, nombre));
                      }else if(codigo.equals("2910") && columna <= 6){
                          formato = "%-"+longitudPie[columna]+"s";
                          bw.write(String.format(formato, nombre));
                      }
                      System.out.println(formato);
                  }
                  bw.newLine();
                  codigo = "";
             }
             bw.close();
             convertRes.setText("Archivo Creado en "+ruta);
        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            lanzarAlerta("Error reading or writing file");
        } catch (BiffException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex); 
            lanzarAlerta("Formato de Archivo incorrecto, Seleccione uno nuevamente");
            resetConfig();
        }
    }//GEN-LAST:event_convertBtnActionPerformed

    private void lanzarAlerta(String msj){
        JOptionPane.showMessageDialog(null, msj);
    }
    
    private void resetConfig(){
        txtInputPath.setText("seleccione el archivo excel \".xls\"");
        txtOutputPath.setText("seleccione el directorio donde se guardara el archivo");
        convertRes.setText("resultado del proceso...");
        outputSearchBtn.setEnabled(false);
        convertBtn.setEnabled(false);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton convertBtn;
    private javax.swing.JTextField convertRes;
    private javax.swing.JButton exitBtn;
    private javax.swing.JButton inputSearchBtn;
    private javax.swing.JButton outputSearchBtn;
    private javax.swing.JTextField txtInputPath;
    private javax.swing.JTextField txtOutputPath;
    // End of variables declaration//GEN-END:variables
}
