package com.example.speech;

import javax.swing.JFileChooser;




	public class app {
		String bobby="";
		JFileChooser fileMan = new JFileChooser();
		
		public String Picker() throws Exception{

			if (fileMan.showOpenDialog(null)==JFileChooser.APPROVE_OPTION) {
				
				java.io.File file = fileMan.getSelectedFile();
				
				
				bobby=file.toString();
			
				
				
			}
			return bobby;
		}
		
		
			
		}
	
