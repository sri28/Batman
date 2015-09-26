package main;
import javax.swing.*;

import controller.*;

import javax.swing.border.Border;
import javax.swing.filechooser.*;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
public class resultDisplay {
	JFrame frame = new JFrame();
	
	JLabel head,title,billPeriod,planName;
public void display(String headd,String titlee,String billPeriodd,String planNamee){
	Container contentPane = frame.getContentPane();
    SpringLayout layout = new SpringLayout();
	contentPane.setLayout(layout);
	head = new JLabel("headd");
	contentPane.add(head);
	title = new JLabel("titlee");
	contentPane.add(title);
	billPeriod = new JLabel("billPeriodd");
	contentPane.add(billPeriod);
	planName = new JLabel("planNamee");
	contentPane.add(planName);
	System.out.println("i passed you sucker!");
	frame.setVisible(true);
	frame.setTitle("Validate");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
}
