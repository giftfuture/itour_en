package com.itour.base.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import info.monitorenter.cpdetector.CharsetPrinter;

public class FileCode {
	// Input file name  
    private String inputFileName;  
  
    // The encoding when reading input file  
    private String inputFileCode;  
  
    // Output file name  
    private String outputFileName;  
  
    // The encoding when write to a file  
    private String outputFileCode;  
  
    public static void main(String[] args) {  
  
        String destEncode="utf-8";  
        //System.out.println("system-issuesaa.doc".matches(".+\\.doc"));  
        //System.out.println("=======");  
        List<String> filelist = new ArrayList<String>();  
  
        List<String> acceptTypes = new ArrayList<String>();  
        acceptTypes.add("*.txt");  
        acceptTypes.add("*.java");  
        acceptTypes.add("*.html");  
        acceptTypes.add("*.log");  
        visitDirBydigui("E:\\workspace\\eclipse\\iloveyou", filelist, acceptTypes);  
        System.out.println(filelist.size());  
        for (String file : filelist) {  
              
            String oldencode=guessEncoding(file);  
            System.out.println(file+" "+oldencode);  
              
            write(file, destEncode, read(file,oldencode));    
        }  
  
    }  
  
    private static void visitDirBydigui(String dirpath, List<String> filelist,  
            List<String> acceptTypes) {  
        File dir = new File(dirpath);  
        File[] files = dir.listFiles();  
        if (files == null)  
            return;  
        for (int i = 0; i < files.length; i++) {  
            if (files[i].isDirectory()) {  
                visitDirBydigui(files[i].getAbsolutePath(), filelist,  
                        acceptTypes);  
            } else {  
                String strFileName = files[i].getAbsolutePath().toLowerCase();  
                // System.out.println("system-issuesaa.doc".matches(".+\\.doc"));  
                for (String type : acceptTypes) {  
                    if (strFileName.matches(".+\\" + type.substring(1))) {  
                        filelist.add(files[i].getAbsolutePath());  
                    }  
                }  
  
            }  
        }  
  
    }  
  
    public static String guessEncoding(String filename) {  
        try {  
            CharsetPrinter charsetPrinter = new CharsetPrinter();  
            String encode = charsetPrinter.guessEncoding(new File(filename));  
            return encode;  
        } catch (Exception e) {  
            throw new RuntimeException(e);  
        }  
    }  
    public static String read(String fileName, String encoding) {  
  
        String string = "";  
        try {  
            BufferedReader in = new BufferedReader(new InputStreamReader(  
                    new FileInputStream(fileName), encoding));  
  
            String str = "";  
            while ((str = in.readLine()) != null) {  
                string += str + "\n";  
            }  
            in.close();  
  
        } catch (Exception ex) {  
            ex.printStackTrace();  
        }  
        return string;  
    }  
    public static void write(String fileName, String encoding, String str) {  
        try {  
            Writer out = new BufferedWriter(new OutputStreamWriter(  
                    new FileOutputStream(fileName), encoding));  
            out.write(str);  
            out.close();  
        } catch (Exception ex) {  
            ex.printStackTrace();  
        }  
    }  
  
    public String getInputFileName() {  
        return inputFileName;  
    }  
  
    public void setInputFileName(String inputFileName) {  
        this.inputFileName = inputFileName;  
    }  
  
    public String getInputFileCode() {  
        return inputFileCode;  
    }  
  
    public void setInputFileCode(String inputFileCode) {  
        this.inputFileCode = inputFileCode;  
    }  
  
    public String getOutputFileName() {  
        return outputFileName;  
    }  
  
    public void setOutputFileName(String outputFileName) {  
        this.outputFileName = outputFileName;  
    }  
  
    public String getOutputFileCode() {  
        return outputFileCode;  
    }  
  
    public void setOutputFileCode(String outputFileCode) {  
        this.outputFileCode = outputFileCode;  
    }  
}
