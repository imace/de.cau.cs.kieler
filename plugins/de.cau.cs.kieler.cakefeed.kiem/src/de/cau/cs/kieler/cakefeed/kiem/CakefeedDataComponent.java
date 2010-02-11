package de.cau.cs.kieler.cakefeed.kiem;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import de.cau.cs.kieler.sim.kiem.IJSONObjectDataComponent;
import de.cau.cs.kieler.sim.kiem.JSONObjectDataComponent;
import de.cau.cs.kieler.sim.kiem.KiemExecutionException;
import de.cau.cs.kieler.sim.kiem.KiemInitializationException;
import de.cau.cs.kieler.sim.kiem.properties.KiemProperty;
import de.cau.cs.kieler.sim.kiem.properties.KiemPropertyTypeWorkspaceFile;

public class CakefeedDataComponent extends JSONObjectDataComponent implements IJSONObjectDataComponent {

	Document trace;
	int currentTick;
	
	@Override
	public void initialize() throws KiemInitializationException {
		trace = null;
		currentTick = -1;
		read(getProperties()[0].getValue());
	}

	@Override
	public boolean isObserver() {
		return true;
	}

	@Override
	public boolean isProducer() {
		return true;
	}

	public boolean isHistoryObserver() {
        return true;
    }
	
	public boolean isDeltaObserver() {
        return false;
    }
	
	@Override
	public void wrapup() throws KiemInitializationException {
		trace = null;
		currentTick = 0;

	}

	@Override
	public JSONObject step(JSONObject jSONObject) throws KiemExecutionException {
		// TODO Auto-generated method stub
		// gucken, welcher tick ausgewaehlt ist
		// entsprechenden tick aus trace variable raussuchen
		// events/vars/connections aus tick highlighten
		System.out.println("STEP START");
		if (!isHistoryStep()) {
			currentTick++;
		} else if (currentTick > 0) {
			currentTick--;
		}
		Element tick = getTick(currentTick, trace.getDocumentElement());
		if (tick != null) {
			
		}
		System.out.println("STEP FINISH");
		return null;
	}
	
	private Element getTick(int tick, Element elem) {
		String name = elem.getNodeName();
		if (name.equals("Tick") && elem.hasAttribute("Id") && (elem.getAttribute("Id").equals(""+ tick +""))) {
			return elem;
		} else {
			NodeList children = elem.getChildNodes();
			for (int i = 0; i < children.getLength(); i++) {
				Node child = children.item(i);
				if (child instanceof Element) {
					return getTick(tick, (Element)child);
				}
			}
			return null;
		}
	}

	protected void read(String fileName) {
		try {
			//IWorkspace workspace = ResourcesPlugin.getWorkspace();
			//IWorkspaceRoot root = workspace.getRoot();
			//IPath location = root.getLocation();
			
			  File file = new File(/*fileName*/"C:\\Documents and Settings\\msch165\\Desktop\\CAKeFEED\\demo\\environmentcruise.rmc");
			  DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			  DocumentBuilder db = dbf.newDocumentBuilder();
			  Document doc = db.parse(file);
			  doc.getDocumentElement().normalize();
			  trace = doc;
			  /*NodeList nodeLst = doc.getElementsByTagName("employee");
			  

			  for (int s = 0; s < nodeLst.getLength(); s++) {

			    Node fstNode = nodeLst.item(s);
			    
			    if (fstNode.getNodeType() == Node.ELEMENT_NODE) {
			  
			      Element fstElmnt = (Element) fstNode;
			      NodeList fstNmElmntLst = fstElmnt.getElementsByTagName("firstname");
			      Element fstNmElmnt = (Element) fstNmElmntLst.item(0);
			      NodeList fstNm = fstNmElmnt.getChildNodes();
			      System.out.println("First Name : "  + ((Node) fstNm.item(0)).getNodeValue());
			      NodeList lstNmElmntLst = fstElmnt.getElementsByTagName("lastname");
			      Element lstNmElmnt = (Element) lstNmElmntLst.item(0);
			      NodeList lstNm = lstNmElmnt.getChildNodes();
			      System.out.println("Last Name : " + ((Node) lstNm.item(0)).getNodeValue());
			    }

			  }*/
			  } catch (Exception e) {
			    e.printStackTrace();
			  }
	}
	
	@Override
    public KiemProperty[] provideProperties() {
        // CHECKSTYLEOFF MagicNumber
        KiemProperty[] properties = new KiemProperty[1];
        properties[0] = new KiemProperty("Counter Example", new KiemPropertyTypeWorkspaceFile(),
                "/nothing.txt");
        // CHECKSTYLEON MagicNumber
        return properties;
    }

}
