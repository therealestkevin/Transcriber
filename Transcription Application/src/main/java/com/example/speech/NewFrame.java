package com.example.speech;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.List;
import java.awt.Panel;
import javax.swing.JFileChooser;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import com.google.cloud.speech.v1p1beta1.SpeechRecognitionAlternative;
import com.google.cloud.speech.v1p1beta1.SpeechRecognitionResult;

import java.awt.TextArea;

public class NewFrame {
	public String set;
	public String set2;
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewFrame window = new NewFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public NewFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBackground(new Color(255, 215, 0));
		frame.getContentPane().setBackground(new Color(75, 0, 130));
		frame.getContentPane().setLayout(null);
		
		/*TextArea textArea = new TextArea();
		textArea.setBackground(new Color(255, 255, 255));
		textArea.setFont(new Font("Unispace", Font.PLAIN, 20));
		textArea.setEditable(false);
		textArea.setBounds(176, 220, 698, 75);
		frame.getContentPane().add(textArea);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setEditable(false);
		textArea_1.setFont(new Font("Unispace", Font.PLAIN, 20));
		textArea_1.setBounds(196, 348, 678, 76);
		frame.getContentPane().add(textArea_1);
		
		JButton FileSelect = new JButton("Choose File");
		FileSelect.setBackground(new Color(153, 50, 204));
		FileSelect.setForeground(new Color(0, 0, 0));
		FileSelect.setFont(new Font("Unispace", Font.PLAIN, 18));
		FileSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  app bob= new app();
				  try {
					bob.Picker();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
					set=bob.bobby;
					
			}
		});
		/*
		JButton btnChooseOutput = new JButton("Choose Output");
		btnChooseOutput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 app2 bob1= new app2();
				
				  try {
					bob1.Picker();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
					set2=bob1.bobber1;
					textArea_1.setText(bob1.bobber1);
			}
			
		});
		btnChooseOutput.setForeground(Color.BLACK);
		btnChooseOutput.setFont(new Font("Unispace", Font.PLAIN, 18));
		btnChooseOutput.setBackground(new Color(153, 50, 204));
		btnChooseOutput.setBounds(530, 122, 195, 75);
		frame.getContentPane().add(btnChooseOutput);*/
		
		
		
		JLabel Title = new JLabel("TRANSCRIBER");
		Title.setForeground(new Color(255, 215, 0));
		Title.setBackground(new Color(75, 0, 130));
		Title.setFont(new Font("Unispace", Font.PLAIN, 42));
		Title.setBounds(295, 11, 418, 61);
		frame.getContentPane().add(Title);
		

		
		
		
	
		/*FileSelect.setBounds(222, 122, 156, 75);
		frame.getContentPane().add(FileSelect);*/
		
		JLabel lblSelectedFile = new JLabel("Step 1:");
		lblSelectedFile.setForeground(new Color(255, 215, 0));
		lblSelectedFile.setFont(new Font("Unispace", Font.PLAIN, 18));
		lblSelectedFile.setBounds(25, 60, 160, 75);
		frame.getContentPane().add(lblSelectedFile);
		
		JLabel lblOutputLocation = new JLabel("Step 2:");
		lblOutputLocation.setForeground(new Color(255, 215, 0));
		lblOutputLocation.setFont(new Font("Unispace", Font.PLAIN, 18));
		lblOutputLocation.setBounds(25, 146, 78, 75);
		frame.getContentPane().add(lblOutputLocation);
		
		JTextArea txtrUseFfmpegTo = new JTextArea();
		txtrUseFfmpegTo.setFont(new Font("Monospaced", Font.PLAIN, 17));
		txtrUseFfmpegTo.setText("Use FFMPEG to convert your audio file to a .flac file");
		txtrUseFfmpegTo.setEditable(false);
		txtrUseFfmpegTo.setBounds(87, 83, 775, 53);
		frame.getContentPane().add(txtrUseFfmpegTo);
		
		JTextArea txtrUploadYourflac = new JTextArea();
		txtrUploadYourflac.setEditable(false);
		txtrUploadYourflac.setFont(new Font("Monospaced", Font.PLAIN, 17));
		txtrUploadYourflac.setText("Upload your .flac file to Google Cloud Storage bucket \"transcriberproject\"");
		txtrUploadYourflac.setBounds(87, 160, 775, 61);
		frame.getContentPane().add(txtrUploadYourflac);
		
		JLabel lblNewLabel = new JLabel("Step 3:");
		lblNewLabel.setForeground(new Color(255, 215, 0));
		lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblNewLabel.setBounds(25, 242, 88, 53);
		frame.getContentPane().add(lblNewLabel);
		
		JTextArea txtrInputTheExact = new JTextArea();
		txtrInputTheExact.setLineWrap(true);
		txtrInputTheExact.setFont(new Font("Monospaced", Font.PLAIN, 20));
		txtrInputTheExact.setText("Select the exact .flac file you uploaded to cloud storage below. For example: \"output.flac\"");
		txtrInputTheExact.setBounds(87, 242, 775, 66);
		frame.getContentPane().add(txtrInputTheExact);
			
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 17));
		textArea.setEditable(false);
		textArea.setBounds(309, 319, 539, 75);
		frame.getContentPane().add(textArea);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setEditable(false);
		textArea_1.setFont(new Font("Monospaced", Font.PLAIN, 17));
		textArea_1.setBounds(309, 400, 539, 75);
		frame.getContentPane().add(textArea_1);
		
		JButton btnSelectOutputLocation = new JButton("Select Output Location");
		btnSelectOutputLocation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				app2 bob1= new app2();
				
				  try {
					bob1.Picker();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
					set2=bob1.bobber1;
					textArea_1.setText(bob1.bobber1);
			}
			
		});
		btnSelectOutputLocation.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSelectOutputLocation.setBounds(10, 400, 272, 75);
		frame.getContentPane().add(btnSelectOutputLocation);
		
		
		JButton btnNewButton = new JButton("Select .flac File");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
					  app bob= new app();
					  try {
						bob.Picker();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
						set=bob.bobby;
						textArea.setText(set);
				}
			
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(10, 319, 272, 70);
		frame.getContentPane().add(btnNewButton);
		
		JButton RunButton = new JButton("Run");
		RunButton.setFont(new Font("Unispace", Font.PLAIN, 26));
		RunButton.setBackground(new Color(153, 50, 204));
		RunButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				String path = set;
				
				
				File temp = new File(path);
				try {
					Recognize.asyncRecognizeGcs("gs://transcriberproject/"+temp.getName());
				} catch (Exception e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				/*try {
					TestCopy.copyFile(path, System.getProperty("user.dir") );
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}yeah
				
				try {
					QuickstartSample.Transcriber("./"+temp.getName());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				String god = QuickstartSample.bob;
				*/
				String god=Recognize.god1;
				
				JOptionPane.showMessageDialog(null,god);
				
				try {
					File Transcription = new File(set2 + "/transcription.txt");
					FileOutputStream is = new FileOutputStream(Transcription);
					OutputStreamWriter osw = new OutputStreamWriter(is);
					Writer w = new BufferedWriter(osw);
					
				
					
					
					w.write(god);
					w.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
		
			}
		});
		RunButton.setBounds(348, 502, 102, 53);
		frame.getContentPane().add(RunButton);
		
		
		
		
		
		
		
		
		
		
		
		
		frame.setBounds(100, 100, 900, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

