/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

/**
 *
 * @author fedem
 */
public class Registros {
    
    String[] cab =  new String[] {"2110","52551","Creacion","Proceso","0017","0016","76","0100237254","servicio","ARS","0","Nominas.txt","VALUGE SA","20",""};
    String[] r1 =   new String[] {"2210","52551","","BENEF","1","CBU","0000000000","Importe1","Importe2","","Fecha","cuil","","","",""};
    String[] r2 =   new String[] {"2220","52551","","BENEF","NOMBRE","","",""};
    String[] r3 =   new String[] {"2230","52551","","BENEF","","","",""};
    String[] r4 =   new String[] {"2240","52551","","BENEF","cocepto",""};
    String[] pie =  new String[] {"2910","52551","TOTALIMPO1","TOTALIMPO2","TOTALOP2210","TOTALREG",""};
    int[] longitudCab = {4,5,8,8,4,4,2,10,10,3,1,12,36,2,141};
    int[] longitudR1 =  {4,5,2,22,1,22,10,13,2,6,8,15,23,1,40,76};
    int[] longitudR2 =  {4,5,2,22,36,36,36,109};
    int[] longitudR3 =  {4,5,2,22,36,36,36,109};
    int[] longitudR4 =  {4,5,2,22,40,177};
    int[] longitudPie = {4,5,13,2,8,10,208};
    
    String inputPath;

    public String getInputPath() {
        return inputPath;
    }

    public void setInputPath(String inputPath) {
        this.inputPath = inputPath;
    }
    
    String outputPath;

    public String getOutputPath() {
        return outputPath;
    }

    public void setOutputPath(String outputPath) {
        this.outputPath = outputPath;
    }
    
    public String convert() throws IOException, BiffException{
        
        String beneficiario;
        String nombre;
        String cbu;
        String importe;
        String[] importeSplit;
        String cuil;
        int total1=0;
        int total2=0;
        int total2210=0;
        int totalReg;
        System.out.println(this.getOutputPath());
        File archivo = new File(this.getOutputPath());
        BufferedWriter bw;
        Workbook workbook;
        workbook = Workbook.getWorkbook(new File(this.getInputPath()));
        Sheet sheet = workbook.getSheet(0);
        if(!sheet.getCell(0, 0).getContents().equals("NOMINAS")){
            return "El Archivo no es correcto." + " Ingrese un nuevo archivo";
        }else{
            Date creacion = new Date();
            cab[2] = new SimpleDateFormat("yyyyMMdd").format(creacion);
            cab[3] = sheet.getCell(0, 1).getContents();
            cab[8] = sheet.getCell(2, 1).getContents().toUpperCase();
            String fechaVto = sheet.getCell(1, 1).getContents();
            String concepto = sheet.getCell(3, 1).getContents().toUpperCase();
            bw = new BufferedWriter(new FileWriter(archivo));
            this.writeFile(bw, cab, longitudCab);
            for (int fila = 2; fila < sheet.getRows(); fila++){
                beneficiario = sheet.getCell(0,fila).getContents();
                nombre = sheet.getCell(1,fila).getContents().toUpperCase();
                cbu = sheet.getCell(2,fila).getContents();
                importe = sheet.getCell(3,fila).getContents();
                importeSplit = importe.split(",");
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
                r2[3] = beneficiario;
                r2[4] = nombre;
                writeFile(bw, r2, longitudR2);
                r3[3] = beneficiario;
                writeFile(bw, r3, longitudR3);
                r4[3] = beneficiario;
                r4[4] = concepto;
                writeFile(bw, r4, longitudR4);
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
        return "";
    }
    
    private void writeFile(BufferedWriter bw, String[] data, int[] length) throws IOException{
        String formato ="";
        bw.newLine();
        for (int i = 0; i < data.length; i++){
            formato = "%-"+length[i]+"s";
            bw.write(String.format(formato, data[i]));
        }
    }
}
