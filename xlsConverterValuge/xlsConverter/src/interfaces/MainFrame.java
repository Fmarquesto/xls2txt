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
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
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
    //int totalReg = 0;
    //int total2210 = 0;
    int total1 = 0;
    int total2 = 0;
    boolean isr1 = false;
    boolean isr2 = false;
    boolean isr3 = false;
    boolean isr4 = false;
    String fileInputPath ="";
    String fileOutputPath = "";
    int[] longitudCab = {4,5,8,8,4,4,2,10,10,3,1,12,36,2,141};
    String[] cab =  new String[] {"2110","52551","Creacion","Proceso","0017","0016","76","0100237254","servicio","ARS","0","Nominas.txt","VALUGE SA","20",""};
    String[] r1 =   new String[] {"2210","52551","","BENEF","1","CBU","0000000000","Importe1","Importe2","","Fecha","cuil","","","",""};
    String[] r2 =   new String[] {"2220","52551","","BENEF","NOMBRE","","",""};
    String[] r3 =   new String[] {"2230","52551","","BENEF","","","",""};
    String[] r4 =   new String[] {"2240","52551","","BENEF","cocepto",""};
    String[] pie =  new String[] {"2910","52551","TOTALIMPO1","TOTALIMPO2","TOTALOP2210","TOTALREG",""};
    
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
        if(chooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION){
            String outputPath = chooser.getSelectedFile().toString();
            txtOutputPath.setText(outputPath);
            setFileOutputPath(chooser.getSelectedFile()+"\\Nominas.txt");
            convertBtn.setEnabled(true);
        }else{
            lanzarAlerta("Debe seleccionar un directorio destino");
        }
    }//GEN-LAST:event_outputSearchBtnActionPerformed

    private void convertBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_convertBtnActionPerformed
        // TODO add your handling code here:
        String valor ;
        String ruta;
        String formato ="";
        String codigo = "";
        String beneficiario = "";
        String cbu = "";
        String nombre = "";
        String concepto = "";
        String importe = "";
        String fechaVto = "";
        String cuil = "0000";
        int totalReg = 2;
        int total2210 = 0;
        ruta = getFileOutputPath();
        File archivo = new File(ruta);
        BufferedWriter bw;
        Workbook workbook;
        try {
            workbook = Workbook.getWorkbook(new File(getFileInputPath()));
            Sheet sheet = workbook.getSheet(0);
            lanzarAlerta(sheet.getCell(2, 1).getContents());
            if(!sheet.getCell(0, 0).getContents().equals("NOMINAS")){
                lanzarAlerta("El Archivo no es correcto");
                lanzarAlerta("Ingrese un nuevo archivo");
                resetConfig();
            }else{
                Date creacion = new Date();
                cab[2] = new SimpleDateFormat("yyyyMMdd").format(creacion);
                cab[3] = sheet.getCell(0, 1).getContents();
                cab[8] = sheet.getCell(2, 1).getContents().toUpperCase();
                fechaVto = sheet.getCell(1, 1).getContents();
                concepto = sheet.getCell(3, 1).getContents().toUpperCase();
                totalReg+=1;
                System.out.println(cab[8]);
                bw = new BufferedWriter(new FileWriter(archivo));
                for (int i = 0; i < cab.length; i++){
                    formato = "%-"+longitudCab[i]+"s";
                    bw.write(String.format(formato, cab[i]));
                }
                for (int fila = 2; fila < sheet.getRows(); fila++){
                    beneficiario = sheet.getCell(0,fila).getContents();
                    nombre = sheet.getCell(1,fila).getContents().toUpperCase();
//                    concepto = sheet.getCell(2,fila).getContents().toUpperCase();
                    cbu = sheet.getCell(2,fila).getContents();
                    importe = sheet.getCell(3,fila).getContents();
                    String[] importeSplit = importe.split(",");
                    lanzarAlerta(importe);
//                    fechaVto = sheet.getCell(5,fila).getContents();
                    cuil = "0000"+sheet.getCell(4,fila).getContents();
                    r1[3] = beneficiario;
                    r1[5] = cbu;
                    r1[7] = new String (new char[13 - importeSplit[0].length()]).replace('\0', '0') + importeSplit[0];
                    r1[8] = new String (new char[2 - importeSplit[1].length()]).replace('\0', '0') + importeSplit[1];
                    r1[10] = fechaVto;
                    r1[11] = cuil;
                    total1 += Integer.parseInt(r1[7]);
                    total2 += Integer.parseInt(r1[8]);
                    writeFile(bw, r1, longitudR1);
                    /*for (int i = 0; i < r1.length; i++){
                        formato = "%-"+longitudR1[i]+"s";
                        bw.write(String.format(formato, r1[i]));
                    }*/
                            
                    r2[3] = beneficiario;
                    r2[4] = nombre;
                    writeFile(bw, r2, longitudR2);
                    /*for (int i = 0; i < r2.length; i++){
                        formato = "%-"+longitudR2[i]+"s";
                        bw.write(String.format(formato, r2[i]));
                    }*/
                    
                    r3[3] = beneficiario;
                    writeFile(bw, r3, longitudR3);
                    /*for (int i = 0; i < r3.length; i++){
                        formato = "%-"+longitudR3[i]+"s";
                        bw.write(String.format(formato, r3[i]));
                    }*/
                    
                    r4[3] = beneficiario;
                    r4[4] = concepto;
                    writeFile(bw, r4, longitudR4);
                    /*for (int i = 0; i < r4.length; i++){
                        formato = "%-"+longitudR4[i]+"s";
                        bw.write(String.format(formato, r4[i]));
                    }*/
                    
                    total2210++;
                }
                totalReg = (total2210*4)+2;
                if(total2/100 != 0){
                    total1 += total2/100;
                    total2 = total2%100;
                }
                pie[2] = new String (new char[13 - String.valueOf(total1).length()]).replace('\0', '0') + String.valueOf(total1);
                pie[3] = new String (new char[2 - String.valueOf(total2).length()]).replace('\0', '0') + String.valueOf(total2);
                pie[4] = new String (new char[8 - String.valueOf(total2210).length()]).replace('\0', '0') + String.valueOf(total2210);
                pie[5] = new String (new char[10 - String.valueOf(totalReg).length()]).replace('\0', '0') + String.valueOf(totalReg);
                writeFile(bw, pie, longitudPie);
                bw.close();
                
            }
        } catch (IOException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BiffException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        /*try {
            bw = new BufferedWriter(new FileWriter(archivo));
            try {
            // TODO add your handling code here:
            //lanzarAlerta(getFileInputPath());
            Workbook workbook = Workbook.getWorkbook(new File(getFileInputPath()));
            Sheet sheet = workbook.getSheet(0);
            if(!sheet.getCell(0, 0).getContents().equals("2110")){
                lanzarAlerta("No se envio cabecera");
                lanzarAlerta("Ingrese un nuevo archivo");
                resetConfig();
            }else{
                Date creacion = new Date();
                cab[2] = new SimpleDateFormat("yyyyMMdd").format(creacion);
                cab[3] = sheet.getCell(3, 0).getContents();
                cab[8] = sheet.getCell(8, 0).getContents().toUpperCase();
                totalReg+=1;
                
                for (int i = 0; i < cab.length; i++){
                    formato = "%-"+longitudCab[i]+"s";
                    bw.write(String.format(formato, cab[i]));
                }
                
                
            }
            
            
            
            
            
           
            for (int fila = 1; fila < sheet.getRows(); fila++){
                //this.cargarFila(fila,sheet);
                bw.newLine();
                switch (sheet.getCell(0, fila).getContents()) {
                    case "2110":
                        lanzarAlerta("Se encontraron 2 cabeceras");
                        resetConfig();
                        break;
                    case "2210":
                        if (!checkNewReg()){
                            lanzarAlerta("Faltan datos del beneficiario"+beneficiario);
                        }
                        beneficiario = sheet.getCell(3,fila).getContents();
                        //new String (new char[13 - String.valueOf(total1).length()]).replace('\0', '0') + String.valueOf(total1);
                        r1[3] = beneficiario;
                        r1[5] = sheet.getCell(5,fila).getContents();
                        r1[7] = new String (new char[13 - sheet.getCell(7,fila).getContents().length()]).replace('\0', '0') + sheet.getCell(7,fila).getContents();
                        //r1[7] = sheet.getCell(7,fila).getContents();
                        r1[8] = sheet.getCell(8,fila).getContents();
                        r1[10] = sheet.getCell(10,fila).getContents();
                        r1[11] = sheet.getCell(11,fila).getContents();
                        total1 += Integer.parseInt(r1[7]);
                        total2 += Integer.parseInt(r1[8]);
                        total2210++;
                        totalReg++;
                        for (int i = 0; i < r1.length; i++){
                            formato = "%-"+longitudR1[i]+"s";
                            bw.write(String.format(formato, r1[i]));                    
                        }
                        lanzarAlerta("TOTAL 1:" + total1 + "TOTAL2: "+total2);
                        isr1 = true;
                        break;
                    case "2220":
                        r2[3] = beneficiario;
                        r2[4] = sheet.getCell(4,fila).getContents().toUpperCase();
                        totalReg++;
                        for (int i = 0; i < r2.length; i++){
                            formato = "%-"+longitudR2[i]+"s";
                            bw.write(String.format(formato, r2[i]));                    
                        }
                        isr2 = true;
                        break;
                    case "2230":
                        r3[3] = beneficiario;
                        totalReg++;
                        for (int i = 0; i < r3.length; i++){
                            formato = "%-"+longitudR3[i]+"s";
                            bw.write(String.format(formato, r3[i]));                    
                        }
                        isr3 = true;
                        break;
                    case "2240":
                        r4[3] = beneficiario;
                        r4[4] = sheet.getCell(4,fila).getContents();
                        totalReg++;
                        for (int i = 0; i < r4.length; i++){
                            formato = "%-"+longitudR4[i]+"s";
                            bw.write(String.format(formato, r4[i]));                    
                        }
                        isr4 = true;
                        if(!checkEndReg()){
                            lanzarAlerta("No se completaron los datos del beneficiario "+beneficiario);
                        }else{
                            setNewReg();
                        }
                        break;
                    case "2910":
                        totalReg++;
                        //String padded = new String(new char[width - toPad.length()]).replace('\0', fill) + toPad;
                        lanzarAlerta(total2%100);
                        lanzarAlerta(total2/100);
                        if(total2/100 != 0){
                            total1 += total2/100;
                            total2 = total2%100;
                        }
                        pie[2] = new String (new char[13 - String.valueOf(total1).length()]).replace('\0', '0') + String.valueOf(total1);
                        pie[3] = new String (new char[2 - String.valueOf(total2).length()]).replace('\0', '0') + String.valueOf(total2);
                        pie[4] = new String (new char[8 - String.valueOf(total2210).length()]).replace('\0', '0') + String.valueOf(total2210);
                        pie[5] = new String (new char[10 - String.valueOf(totalReg).length()]).replace('\0', '0') + String.valueOf(totalReg);
                        for (int i = 0; i< pie.length; i++){
                            formato= "%-"+longitudPie[i]+"s";
                            bw.write(String.format(formato, pie[i]));
                        }
                        break;
                    default:
                        
                        break;
                }/*
                  for (int columna = 0; columna < sheet.getColumns(); columna++){
                      if(columna == 0){
                          codigo = sheet.getCell(columna, fila).getContents();
                      }
                      valor = sheet.getCell(columna, fila).getContents();
                      
                      if(codigo.equals("2110")){
                          
                      }else if(codigo.equals("2210") && columna <= 15){
                          //formato = "%-"+longitudR1[columna]+"s";
                          //bw.write(String.format(formato, nombre));
                      }else if(codigo.equals("2220") && columna <= 7){
                          //formato = "%-"+longitudR2[columna]+"s";
                          //bw.write(String.format(formato, nombre));
                      }else if(codigo.equals("2230") && columna <= 7){
                          //formato = "%-"+longitudR3[columna]+"s";
                          //bw.write(String.format(formato, nombre));
                      }else if(codigo.equals("2240") && columna <= 5){
                          //formato = "%-"+longitudR4[columna]+"s";
                          //bw.write(String.format(formato, nombre));
                      }else if(codigo.equals("2910") && columna <= 6){
                          //formato = "%-"+longitudPie[columna]+"s";
                          //bw.write(String.format(formato, nombre));
                      }
                      System.out.println(formato);
                  }
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
        } catch (IOException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        
        
    }//GEN-LAST:event_convertBtnActionPerformed

    private void writeFile(BufferedWriter bw, String[] data, int[] length) throws IOException{
        String formato ="";
        bw.newLine();
        for (int i = 0; i < data.length; i++){
            formato = "%-"+length[i]+"s";
            bw.write(String.format(formato, data[i]));
        }
    }
    
    private void lanzarAlerta(String msj){
        JOptionPane.showMessageDialog(null, msj);
    }
    private void lanzarAlerta(int valor){
        JOptionPane.showMessageDialog(null, valor);
    }
    
    private void resetConfig(){
        txtInputPath.setText("seleccione el archivo excel \".xls\"");
        txtOutputPath.setText("seleccione el directorio donde se guardara el archivo");
        convertRes.setText("resultado del proceso...");
        outputSearchBtn.setEnabled(false);
        convertBtn.setEnabled(false);
    }
    
    private boolean checkNewReg(){
        if(!isr1 && !isr2 && !isr3 && !isr4){
            return true;
        }
        return false;
    }
    
    private boolean checkEndReg(){
        if(isr1 && isr2 && isr3 && isr4){
            return true;
        }
        return false;
    }
    
    private void setNewReg(){
        isr1 = false;
        isr2 = false;
        isr3 = false;
        isr4 = false;
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
