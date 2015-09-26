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
public void display(){
	Container contentPane = frame.getContentPane();
    SpringLayout layout = new SpringLayout();
	contentPane.setLayout(layout);
	head = new JLabel("XML File");
	contentPane.add(head);
	title = new JLabel("");
	contentPane.add(title);
	billPeriod = new JLabel("XML File");
	contentPane.add(billPeriod);
	planName = new JLabel("XML File");
	contentPane.add(planName);
}
}
