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
import java.awt.Panel;
import javax.swing.JFileChooser;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.TextArea;

public class Frame1 {
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
					Frame1 window = new Frame1();
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
	public Frame1() {
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
		
		TextArea textArea = new TextArea();
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
					textArea.setText(bob.bobby);
			}
		});
		
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
		frame.getContentPane().add(btnChooseOutput);
		
		JButton RunButton = new JButton("Run");
		RunButton.setFont(new Font("Unispace", Font.PLAIN, 26));
		RunButton.setBackground(new Color(153, 50, 204));
		RunButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				String path = set;
				
				
				File temp = new File(path);
				try {
					TestCopy.copyFile(path, System.getProperty("user.dir") );
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
				try {
					QuickstartSample.Transcriber("./"+temp.getName());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				String god = QuickstartSample.bob;
				
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
		RunButton.setBounds(355, 475, 156, 75);
		frame.getContentPane().add(RunButton);
		
		JLabel Title = new JLabel("TRANSCRIBER");
		Title.setForeground(new Color(255, 215, 0));
		Title.setBackground(new Color(75, 0, 130));
		Title.setFont(new Font("Unispace", Font.PLAIN, 42));
		Title.setBounds(295, 25, 418, 61);
		frame.getContentPane().add(Title);
		

		
		
		
	
		FileSelect.setBounds(217, 122, 156, 75);
		frame.getContentPane().add(FileSelect);
		
		JLabel lblSelectedFile = new JLabel("Selected File:");
		lblSelectedFile.setForeground(new Color(255, 215, 0));
		lblSelectedFile.setFont(new Font("Unispace", Font.PLAIN, 18));
		lblSelectedFile.setBounds(10, 220, 160, 75);
		frame.getContentPane().add(lblSelectedFile);
		
		JLabel lblOutputLocation = new JLabel("Output Location:");
		lblOutputLocation.setForeground(new Color(255, 215, 0));
		lblOutputLocation.setFont(new Font("Unispace", Font.PLAIN, 18));
		lblOutputLocation.setBounds(10, 349, 176, 75);
		frame.getContentPane().add(lblOutputLocation);
		
		
		
		
		
		
		
		
		
		frame.setBounds(100, 100, 900, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

