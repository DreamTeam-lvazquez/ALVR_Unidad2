package dom;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import model.Clother;





public class ClotherDOM {
	
	private String pathFile ="F:\\workspace\\ALVR_Unidad2\\src\\data\\clothers.xml";
	public void add(Clother data) {
		try {
		Document document = DOMHelper.getDocument(pathFile);
		Element clothers = document.getDocumentElement();
		//Creando stufent tag
		
		Element clother =document.createElement("clother");
		//crando id tag 
		Element id =document.createElement("id");
		id.appendChild(document.createTextNode(data.getId()));
		clother.appendChild(id);
		
		//crando id tag 
		Element jeans =document.createElement("jeans");
		jeans.appendChild(document.createTextNode(data.getJeans()));
		clother.appendChild(jeans);
		
		//crando id tag 
		Element shirt =document.createElement("shirt");
		shirt.appendChild(document.createTextNode(data.getShirt()));
		clother.appendChild(shirt);
		
		//crando id tag 
		Element coat =document.createElement("coat");
		coat.appendChild(document.createTextNode(data.getCoat()));
		clother.appendChild(jeans);
		clothers.appendChild(clother);
		
		DOMHelper.saveXMLContent(document, pathFile);
		
		
}catch(Exception e){
			
			System.out.println(e.getMessage());
		
	}
}

public void delete (String id ) {
	
	try {
		Document document = DOMHelper.getDocument(pathFile);
		NodeList nodelist = document.getElementsByTagName("clother");
		for (int i =0; i< nodelist.getLength(); i++) {
			
			Element clother= (Element)nodelist.item(i);
			if (clother.getElementsByTagName("id").item(0).getTextContent().equals(id)) {
				clother.getParentNode().removeChild(clother);
			}
		}
		DOMHelper.saveXMLContent(document, pathFile);
		
	}catch (Exception e) {
		e.printStackTrace();
	}
}

public void update (Clother data) {
	try {
		Document document = DOMHelper.getDocument(pathFile);
		NodeList nodelist = document.getElementsByTagName("clother");
		for (int i =0; i< nodelist.getLength(); i++) {
			Element clother = (Element)nodelist.item(i);
			if (clother.getElementsByTagName("id").item(0).getTextContent().equals(data.getId())) {
				clother.getElementsByTagName("jeans").item(0).setTextContent(data.getJeans());
				clother.getElementsByTagName("shirt").item(0).setTextContent(data.getShirt());
				clother.getElementsByTagName("coat").item(0).setTextContent(data.getCoat());
				
				}
		}
		DOMHelper.saveXMLContent(document, pathFile);
		
	}catch(Exception e) {
		e.printStackTrace();
	}
	
}

public Clother findById(String id) {
	Clother clother = null;
	try {
		Document document = DOMHelper.getDocument(pathFile);
		NodeList nodelist = document.getElementsByTagName("clother");
		for(int i=0; i<nodelist.getLength(); i++) {
			Element s = (Element)nodelist.item(i);
			if(s.getElementsByTagName("id").item(0).getTextContent().equals(id)) {
				clother = new Clother();
				clother.setId(id);
				clother.setJeans(s.getElementsByTagName("jeans").item(0).getTextContent());
				clother.setShirt(s.getElementsByTagName("shirt").item(0).getTextContent());
				clother.setCoat(s.getElementsByTagName("coat").item(0).getTextContent());
				
				
			}
			
			
		}
		
		
	}catch (Exception e) {
		e.printStackTrace();
	}
	return clother;
}
public  List<Clother> getClother(){
	
	List<Clother> clothers = new ArrayList<Clother>();
	Document document = DOMHelper.getDocument(pathFile);
	NodeList nodelist = document.getElementsByTagName("clother");
	for (int i =0; i<nodelist.getLength(); i++) {
		
		Element s = (Element)nodelist.item(i);
		Clother clother = new Clother();
		clother.setId(s.getElementsByTagName("id").item(0).getTextContent());
		clother.setJeans(s.getElementsByTagName("jeans").item(0).getTextContent());
		clother.setShirt(s.getElementsByTagName("shirt").item(0).getTextContent());
		clother.setCoat(s.getElementsByTagName("coat").item(0).getTextContent());
		
		
		clothers.add(clother);
		
	}
	return clothers;
}
}	
	
