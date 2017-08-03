package com.itour.base.util;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.gjt.jclasslib.io.ClassFileWriter;
import org.gjt.jclasslib.structures.CPInfo;
import org.gjt.jclasslib.structures.ClassFile;
import org.gjt.jclasslib.structures.InvalidByteCodeException;
import org.gjt.jclasslib.structures.constants.ConstantUtf8Info;

public class ModifyByteClass {

	public static void main(String[] args) {
		  try {
			String filePath = "C:\\Main.class";  
			    FileInputStream fis = new FileInputStream(filePath);  
			   DataInput di = new DataInputStream(fis);  
			    ClassFile cf = new ClassFile();  
			    cf.read(di);  
			    CPInfo[] infos = cf.getConstantPool();  
  
			    int count = infos.length;  
			    for (int i = 0; i < count; i++) {  
			        if (infos[i] != null) {  
			            System.out.print(i);  
			            System.out.print(" = ");  
			            System.out.print(infos[i].getVerbose());  
			            System.out.print(" = ");  
			            System.out.println(infos[i].getTagVerbose());  
			            if (i == 21) {//刚刚找到的是21位置  
			                ConstantUtf8Info uInfo = (ConstantUtf8Info) infos[i]; //刚刚那里是CONSTANT_Utf-8_info所以这里要用这个  
			                uInfo.setBytes("baidu".getBytes());  
			                infos[i] = uInfo;  
			            }  
			        }  
			    }  
			    //这种方式也可以，一样的  
			  // if(infos[count] != null) { 
			   //     ConstantUtf8Info uInfo = (ConstantUtf8Info) infos[i]; //刚刚那里是CONSTANT_Utf-8_info所以这里要用这个 
			    //    uInfo.setBytes("baidu".getBytes()); 
			   //     infos[count] = uInfo; 
			    //}  
			      
			    cf.setConstantPool(infos);  
			    fis.close();  
			    File f = new File(filePath);  
			    ClassFileWriter.writeToFile(f, cf);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (InvalidByteCodeException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 

	}

}
