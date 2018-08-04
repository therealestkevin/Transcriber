package com.example.speech;

import java.io.File;
import java.io.IOException;

//import org.eclipse.core.resources.IWorkspace;
//import org.eclipse.core.resources.ResourcesPlugin;

import org.apache.commons.io.FileUtils;

public class TestCopy {
	public static void main (String[]args) throws IOException {
	
		//copyFile("C:/Users/kevin_wuf1s2j/Desktop/Test.txt", "C:/Users/kevin_wuf1s2j/Desktop/bob");
	System.out.println(System.getProperty("user.dir"));
	
	}
	public static void copyFile(String string, String string2) throws IOException {
	    File file = new File(string);
	    File dest = new File(string2);
	   
		FileUtils.copyFileToDirectory(file, dest);
	}
}
