package com.example.speech;
import javax.swing.JFileChooser;


public class app2 {
	



	
		String bobber1="";
		JFileChooser fileMans = new JFileChooser();
		
		public String Picker() throws Exception{
			fileMans.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			if (fileMans.showOpenDialog(null)==JFileChooser.APPROVE_OPTION) {
				
				java.io.File file = fileMans.getSelectedFile();
				
				
				bobber1=file.toString();
			
				
				
			}
			return bobber1;
		}
		
		
			
		}
	
