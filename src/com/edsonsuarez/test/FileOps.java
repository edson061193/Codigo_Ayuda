package com.edsonsuarez.test;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class FileOps {

    //static int indiceLatime = 0;
    private  static String PATH_PDF = "E:\\DESCARGAS\\eecc tarjeta visa banco de comercio_20201217_117";

    public static void main(String[] argv) throws IOException {
        File folder = new File(PATH_PDF);
        File[] listOfFiles = folder.listFiles();
        String filePathProperties = "E:/DESCARGAS/BASE_DATOS_26.txt";
        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {

                File f = new File(PATH_PDF+"\\"+listOfFiles[i].getName());

                try {
                    FileInputStream fis = new FileInputStream(filePathProperties);
                    InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
                    BufferedReader br = new BufferedReader(isr);

                    String line = "";
                    String nombrePdf = listOfFiles[i].getName();
                    int inicio = nombrePdf.indexOf("_");
                    int fin = nombrePdf.indexOf("_", inicio + 1);
                    String pdf = nombrePdf.substring(inicio+1,fin).replace(" ","");
                    /*System.out.println(pdf);
                    System.out.println("\n");*/

                    while ((line = br.readLine()) != null) {
                        String txtRow =  line.replace(" ","");
                        /*System.out.println(txtRow);*/
                        if (txtRow.contains(pdf)) {
                            /*System.out.println("nombre en pdf ===> "+pdf);
                            System.out.println("txt value ===> "+txtRow);*/
                            /*System.out.println(txtRow.substring(17,21));
                            System.out.println(txtRow.substring(txtRow.length()-9));
                            System.out.println("\n");*/
                            f.renameTo(new File(PATH_PDF+"\\"+"TCR_"+txtRow.substring(txtRow.length()-9)+"_"+txtRow.substring(17,21)+".pdf"));
                            break;
                        }
                    }

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
        System.out.println("conversion is done");
    }
}