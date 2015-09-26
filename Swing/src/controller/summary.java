package controller;

import java.awt.List;
import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
public class summary {
	String billPeriod="";
	String planName="";
	String title="";
	String head="";
	public void summary(String path, String msisdn)
			throws ParserConfigurationException, SAXException, IOException {
		File xmlFile = new File(path); // getting the xml file
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(xmlFile); // parsinfg xml file
		int key=0;// value to store when at which iteration the msisdn has been
		String find="notFound";		// found
		head=msisdn;
	NodeList nList = doc.getElementsByTagName("INVOICE_SPECIFICATION"); // creating
																			// a
																			// list
																			// with
																			// the
																			// values
																			// under
																			// invoice_spec
																			// tags
 NodeList nBigList= doc.getElementsByTagName("INVOICE");//Parsing all tags 
		for (int temp = 0; temp < nList.getLength(); temp++) { // TO check all d
																// occurrence of
																// inv_spec tag

			Node nNode = nList.item(temp);// accessing the first(temp's) node
											// branch

			if (nNode.getNodeType() == Node.ELEMENT_NODE) {

				Element eElement = (Element) nNode;
				if ((msisdn).equals(eElement.getElementsByTagName("MSISDN")
						.item(0).getTextContent())) {
					key = temp;
					find="found";
					title=find;
				}
			}
		}
		if(find.equals("found")){
		Node nBilledPeriod= nBigList.item(0); //Fetch bill period from the big list.
		if(nBilledPeriod.getNodeType()==Node.ELEMENT_NODE){
			Element eElement = (Element) nBilledPeriod;
			System.out.println("Billing Period Of the selected MSISDN: "
					+ eElement.getElementsByTagName("BILL_CYCLE").item(0)
							.getTextContent());
			billPeriod= eElement.getElementsByTagName("BILL_CYCLE").item(0)
					.getTextContent();
		}
		Node nPlan = nList.item(key);//fetching plan name from small list
		if (nPlan.getNodeType() == Node.ELEMENT_NODE) {

			Element eElement = (Element) nPlan;
			System.out.println("PLAN Name Of the selected MSISDN: "
					+ eElement.getElementsByTagName("PLAN_NAME").item(0)
							.getTextContent());
			planName=eElement.getElementsByTagName("PLAN_NAME").item(0)
					.getTextContent();

		}
		}
		if(find.equals("notFound")){
			System.out.println("Msisdn is not present in this invoice. Please check the msisdn.");
			head="Msisdn is not present in this invoice. Please check the msisdn.";
		}
		
	}
	
}