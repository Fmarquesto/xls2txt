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
        String[] data = new String[5];
        int total1=0;
        int total2=0;
        int total2210=0;
        int totalReg;
        File archivo = new File(this.getOutputPath());
        BufferedWriter bw;
        Workbook workbook;
        workbook = Workbook.getWorkbook(new File(this.getInputPath()));
        Sheet sheet = workbook.getSheet(0);
        if(!sheet.getCell(0, 0).getContents().equals("FECHA DE PROCESO")){
            return "El Archivo no es correcto." + " Ingrese un nuevo archivo";
        }else{
            Date creacion = new Date();
            cab[2] = new SimpleDateFormat("yyyyMMdd").format(creacion);
            cab[3] = sheet.getCell(0, 1).getContents();
            cab[8] = sheet.getCell(2, 1).getContents().toUpperCase();
            String fechaVto = sheet.getCell(1, 1).getContents();
            String concepto = sheet.getCell(3, 1).getContents().toUpperCase();
            String res = checkCab(fechaVto,concepto,cab[3],cab[8]);
            if(!res.equals("")){
                return res;
            }
            bw = new BufferedWriter(new FileWriter(archivo));
            this.writeFile(bw, cab, longitudCab);
            for (int fila = 3; fila < sheet.getRows(); fila++){
                beneficiario = sheet.getCell(0,fila).getContents();
                if(beneficiario.equals("")){
                    return "";
                }
                nombre = sheet.getCell(3,fila).getContents().toUpperCase();
                cbu = sheet.getCell(1,fila).getContents();
                importe = sheet.getCell(5,fila).getContents();
                importeSplit = importe.split(",");
                cuil = "0000"+sheet.getCell(2,fila).getContents();
                res = checkData(beneficiario,nombre,cbu,importe,cuil);
                if(!res.equals("")){
                    return res;
                }
                r1[3] = beneficiario;
                r1[5] = cbu;
                r1[7] = new String (new char[13 - importeSplit[0].length()]).replace('\0', '0') + importeSplit[0];
                //System.out.println(importeSplit.length);
                if(importeSplit.length > 1 ){
                    if(importeSplit[1].length() == 1){
                        importeSplit[1] = importeSplit[1]+"0";
                    }
                    r1[8] = new String (new char[2 - importeSplit[1].length()]).replace('\0', '0') + importeSplit[1];
                    System.out.print(importeSplit[1]);
                } else {
                    r1[8] = "00";
                }
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
        for (int i = 0; i < data.length; i++){
            formato = "%-"+length[i]+"s";
            bw.write(String.format(formato, data[i]));
        }
        bw.newLine();
    }
    
    private String checkData(String beneficiario,String nombre,String cbu,String importe,String cuil){
        String error ="";
        if(beneficiario.length() != 18){
            error+= "El ID beneficiario debe tener 18 caracteres ("+beneficiario+"), reviselo. ";
        }
        if(nombre.length() > 36 || nombre.equals("")){
            error+="El Nombre es invalido ("+nombre+")";
        }
        if(cbu.length() != 22){
            error+="El CBU no es correcto "+cbu+" ";
        }
        if(cuil.length() != 15){
            error+="El cuil no es valido ("+cuil+") ";
        }
        if(importe.equals("")){
            error+="El importe para "+nombre+" no puede estar vacio";
        }
        return error;
        
    }
    
    private String checkCab(String vto, String concepto,String fechaProc, String Servicio){
        String error ="";
        if(vto.length() != 8 || fechaProc.length() != 8){
            error+="Verifique las fechas ingresadas. "+vto+" - "+fechaProc+" ";
        }else if (Integer.parseInt(vto) < Integer.parseInt(fechaProc)){
            error+="La fecha de proceso ("+fechaProc+") debe ser menor a la fecha de Acreditacion ("+vto+")";
        }
        if(concepto.length() >40 || concepto.equals("")){
            error+="el concepto ingresado no es valido. ";
        }
        if(Servicio.length() >10 || Servicio.equals("")){
            error+="El codigo de servicio no es valido";
        }
        return error;
    }
}
