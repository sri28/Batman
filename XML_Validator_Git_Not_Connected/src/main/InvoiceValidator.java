package main;
import javax.swing.*;
import controller.*;
import javax.swing.filechooser.*;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

public class InvoiceValidator
{

/*	public String Fetcher(){
		return path+phoneNumber;
	}*/
	public static void main(String a[]) throws ParserConfigurationException, SAXException, IOException
	{
		JFrame frame = new JFrame();
		
		JLabel xmlopen, msisdn;

		final JTextField xmlfilename;

		final JTextField phone;
		String path="";
		String phoneNumber="";
		final summary s=new summary();

		JButton browse, submit, reset;

			Container contentPane = frame.getContentPane();
	        	SpringLayout layout = new SpringLayout();
			contentPane.setLayout(layout);
			
			xmlopen = new JLabel("XML File");
			contentPane.add(xmlopen);

			xmlfilename = new JTextField(20);
			contentPane.add(xmlfilename);			

			browse = new JButton("Browse");
			contentPane.add(browse);

			browse.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent ae)
				{
					JFileChooser fc = new JFileChooser();
					fc.setFileSelectionMode(fc.FILES_AND_DIRECTORIES);
					FileNameExtensionFilter xmlfilter = new FileNameExtensionFilter("xml files", "xml");
					fc.setFileFilter(xmlfilter);
					int returnVal = fc.showOpenDialog(null);
					if(returnVal == JFileChooser.APPROVE_OPTION)
					{
						fc.setMultiSelectionEnabled(false);
						xmlfilename.setText(fc.getSelectedFile().getAbsolutePath());	
					}	
				}
			});
			
			msisdn = new JLabel("MSISDN");
			contentPane.add(msisdn);

			phone = new JTextField(20);
			contentPane.add(phone);

			submit = new JButton("Submit");
			contentPane.add(submit);

			reset = new JButton("Reset");
			contentPane.add(reset);
			reset.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent ae)
				{
					xmlfilename.setText("");
					phone.setText("");
				}
			});
			
			submit.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent ae)
				{
				String path=xmlfilename.getText();
				String phoneNumber=phone.getText();
				System.out.println(path+phoneNumber);
				try {
					s.summary(path, phoneNumber);
					
				} catch (ParserConfigurationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SAXException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
				
			});

			frame.setSize(400,130);

			layout.putConstraint(SpringLayout.WEST, xmlopen, 5, SpringLayout.WEST, contentPane);
			layout.putConstraint(SpringLayout.NORTH, xmlopen, 7, SpringLayout.NORTH, contentPane);

			layout.putConstraint(SpringLayout.WEST, xmlfilename, 10, SpringLayout.EAST, xmlopen);
			layout.putConstraint(SpringLayout.NORTH, xmlfilename, 7, SpringLayout.NORTH, contentPane);

			layout.putConstraint(SpringLayout.WEST, browse, 10, SpringLayout.EAST, xmlfilename);
			layout.putConstraint(SpringLayout.NORTH, browse, 5, SpringLayout.NORTH, contentPane);

			layout.putConstraint(SpringLayout.WEST, msisdn, 5, SpringLayout.WEST, contentPane);
			layout.putConstraint(SpringLayout.NORTH, msisdn, 20, SpringLayout.SOUTH, xmlopen);

			layout.putConstraint(SpringLayout.WEST, phone, 13, SpringLayout.EAST, msisdn);
			layout.putConstraint(SpringLayout.NORTH, phone, 15, SpringLayout.SOUTH, xmlfilename);
			
			layout.putConstraint(SpringLayout.WEST, submit, 100, SpringLayout.WEST, contentPane);
			layout.putConstraint(SpringLayout.NORTH, submit, 15, SpringLayout.SOUTH, phone);

			layout.putConstraint(SpringLayout.WEST, reset, 13, SpringLayout.EAST, submit);
			layout.putConstraint(SpringLayout.NORTH, reset, 15, SpringLayout.SOUTH, phone);

			frame.setVisible(true);
			frame.setTitle("Invoice Validator");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			//System.out.println(path+phoneNumber);
	}
}
