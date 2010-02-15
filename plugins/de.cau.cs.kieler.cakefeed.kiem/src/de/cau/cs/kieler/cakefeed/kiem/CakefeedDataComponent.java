package de.cau.cs.kieler.cakefeed.kiem;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.IFigure;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.editparts.AbstractConnectionEditPart;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramWorkbenchPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.graphics.Color;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import de.cau.cs.kieler.cakefeed.DataConnection;
import de.cau.cs.kieler.cakefeed.EventConnection;
import de.cau.cs.kieler.cakefeed.FB;
import de.cau.cs.kieler.cakefeed.FBType;
import de.cau.cs.kieler.cakefeed.NamedAndCommented;
import de.cau.cs.kieler.cakefeed.fbnetwork.diagram.edit.parts.FBNetworkEditPart;
import de.cau.cs.kieler.sim.kiem.IJSONObjectDataComponent;
import de.cau.cs.kieler.sim.kiem.JSONObjectDataComponent;
import de.cau.cs.kieler.sim.kiem.KiemExecutionException;
import de.cau.cs.kieler.sim.kiem.KiemInitializationException;
import de.cau.cs.kieler.sim.kiem.properties.KiemProperty;
import de.cau.cs.kieler.sim.kiem.properties.KiemPropertyTypeFile;
import de.cau.cs.kieler.sim.kiem.properties.KiemPropertyTypeWorkspaceFile;
import de.cau.cs.kieler.synccharts.Transition;
import de.cau.cs.kieler.synccharts.diagram.edit.parts.RegionEditPart;
import de.cau.cs.kieler.synccharts.diagram.edit.parts.State2EditPart;
import de.cau.cs.kieler.synccharts.diagram.edit.parts.StateEditPart;
import de.cau.cs.kieler.synccharts.diagram.edit.parts.TransitionEditPart;

public class CakefeedDataComponent extends JSONObjectDataComponent implements IJSONObjectDataComponent {

	protected Document trace = null;
	protected int currentTick = -1;
	protected List<EditPart> lastChanged = new ArrayList<EditPart>();
	
	@Override
	public void initialize() throws KiemInitializationException {
		//String path = "";
		//try {
		//	path = (org.eclipse.core.runtime.FileLocator
		//			.toFileURL(Activator.getDefault().getBundle().getResource(
		//			getProperties()[0].getValue()))).toString();
		//} catch (IOException e) {
		//	System.out.println("File could not be read!");
		//	e.printStackTrace();
		//}
		//trace = null;
		//currentTick = -1;
		//lastChanged = new ArrayList<EditPart>();
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
		clearHighlights();
		lastChanged.clear();
		if (!isHistoryStep()) {
			currentTick++;
		} else if (currentTick > 0) {
			currentTick--;
		}
		Element tick = getTick(currentTick, trace.getDocumentElement());
		if (tick != null) {
			NodeList children = tick.getChildNodes();
			for (int i = 0; i < children.getLength(); i++) {
				Node child = children.item(i);
				if (child instanceof Element) {
					Element e = (Element)child;
					if (e.getNodeName().equals("Component") && e.hasAttribute("Name")) {
						String fBName = e.getAttribute("Name");
						List<String> signalNames = getChildrenNames(e, "Signal");
						List<String> sourceStateNames = getChildrenNames(e, "SourceState");
						List<String> destinationStateNames = getChildrenNames(e, "DestinationState");
						highlightConnections(fBName, signalNames);
						highlightTransitions(fBName, sourceStateNames, destinationStateNames);
					}
				}
			}
		}
		return new JSONObject();
	}
	
	private void clearHighlights() {
		for (EditPart editPart : lastChanged) {
			if (editPart instanceof GraphicalEditPart) {
				EObject object = ((View)(editPart.getModel())).getElement();
				IFigure figure = ((GraphicalEditPart)editPart).getFigure();
				Color fGC = null;
				Color bGC = null;
				if (object instanceof Transition) {
					fGC = ColorConstants.black;
					bGC = ColorConstants.black;
				} else if (object instanceof EventConnection) {
					fGC = ColorConstants.red;
					bGC = ColorConstants.red;
				} else if (object instanceof DataConnection) {
					fGC = ColorConstants.blue;
					bGC = ColorConstants.blue;
				}
				figure.setForegroundColor(fGC);
				figure.setBackgroundColor(bGC);
				figure.repaint();
			}
		}
	}

	private void highlightTransitions(String fBName,
			List<String> sourceStateNames, List<String> destinationStateNames) {
		IWorkbenchWindow[] windows = PlatformUI.getWorkbench().getWorkbenchWindows();
		for (int i = 0; i < windows.length; i++) {
			IEditorPart activeEditor = windows[i].getActivePage().getActiveEditor();
			if (activeEditor instanceof IDiagramWorkbenchPart) {
				EditPart editPart = ((IDiagramWorkbenchPart) activeEditor).getDiagramEditPart();
				if (editPart instanceof RegionEditPart) {
					List<EditPart> transitionEditParts = getTransitionEditParts(editPart);
					for (EditPart tEP : transitionEditParts) {
						EObject object = ((View)(tEP.getModel())).getElement();
						if (object instanceof Transition) {
							Transition transition = (Transition)object;
							if (!sourceStateNames.isEmpty() && !destinationStateNames.isEmpty()
								&& (transition.getSourceState() != null)
								&& (transition.getTargetState() != null)
								&& (transition.getSourceState().getId() != null)
								&& (transition.getTargetState().getId() != null)
								&& transition.getSourceState().getId().equals(sourceStateNames.get(0))
								&& transition.getTargetState().getId().equals(destinationStateNames.get(0))) {
								if (tEP instanceof TransitionEditPart) {
									IFigure tF = ((TransitionEditPart)tEP).getFigure();
									tF.setForegroundColor(ColorConstants.lightGreen);
									tF.setBackgroundColor(ColorConstants.lightGreen);
									tF.repaint();
									this.lastChanged.add(tEP);
								}
							}
						}
					}
				}
			}
		}
	}

	@SuppressWarnings("unchecked")
	private List<EditPart> getTransitionEditParts(EditPart editPart) {
		List<EditPart> transitionEditParts = new ArrayList<EditPart>();
		List<Object> children = editPart.getChildren();
		for (Object c : children) {
			if (c instanceof EditPart) {
				if (c instanceof StateEditPart) {
					StateEditPart sEP = (StateEditPart)c;
					transitionEditParts.addAll(sEP.getSourceConnections());
				} else if (c instanceof State2EditPart) {
					State2EditPart sEP = (State2EditPart)c;
					transitionEditParts.addAll(sEP.getSourceConnections());
				}
				else if (c instanceof TransitionEditPart) {
					transitionEditParts.add((EditPart)c);
				}
				transitionEditParts.addAll(getTransitionEditParts((EditPart)c));
			}
		}
		return transitionEditParts;
	}

	private void highlightConnections(String fBName, List<String> signalNames) {
		IWorkbenchWindow[] windows = PlatformUI.getWorkbench().getWorkbenchWindows();
		for (int i = 0; i < windows.length; i++) {
			IEditorPart activeEditor = windows[i].getActivePage().getActiveEditor();
			if (activeEditor instanceof IDiagramWorkbenchPart) {
				EditPart editPart = ((IDiagramWorkbenchPart) activeEditor).getDiagramEditPart();
				if ((editPart instanceof FBNetworkEditPart)) {
					List<EditPart> signalEditParts = getSignalEditParts(editPart, fBName);
					List<EditPart> connectionEditParts = getConnectionEditParts(editPart);
					List<EditPart> connectionsToHighlight = new ArrayList<EditPart>();
					for (EditPart cEP : connectionEditParts) {
						if (cEP instanceof AbstractConnectionEditPart) {
							AbstractConnectionEditPart aCEP = (AbstractConnectionEditPart)cEP;
							if ((signalEditParts.contains(aCEP.getSource())) && (signalEditParts.contains(aCEP.getTarget()))) {
								connectionsToHighlight.add(cEP);
							}
						}
					}
					for (EditPart cEP2 : connectionsToHighlight) {
						if (cEP2 instanceof GraphicalEditPart) {
							IFigure cF = ((GraphicalEditPart)cEP2).getFigure();
							cF.setForegroundColor(ColorConstants.lightGreen);
							cF.setBackgroundColor(ColorConstants.lightGreen);
							cF.repaint();
							this.lastChanged.add(cEP2);
						}
					}
				}
			}
		}
	}

	@SuppressWarnings("unchecked")
	private List<EditPart> getConnectionEditParts(EditPart editPart) {
		List<EditPart> connectionEditParts = new ArrayList<EditPart>();
		List<Object> children = editPart.getChildren();
		for (Object c : children) {
			if (c instanceof AbstractGraphicalEditPart) {
				connectionEditParts.addAll(((AbstractGraphicalEditPart)c).getSourceConnections());
			}
			connectionEditParts.addAll(getConnectionEditParts((EditPart)c));
		}
		return connectionEditParts;
	}

	@SuppressWarnings("unchecked")
	private List<EditPart> getSignalEditParts(EditPart editPart, String fBName) {
		List<EditPart> signalEditParts = new ArrayList<EditPart>();
		List<Object> children = editPart.getChildren();
		for (Object c : children) {
			if (c instanceof EditPart) {
				if ((c instanceof de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.parts.IFInputEventEditPart)
						|| (c instanceof de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.parts.IFOutputEventEditPart)
						|| (c instanceof de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.parts.IFInputVarEditPart)
						|| (c instanceof de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.parts.IFOutputVarEditPart)
						|| (c instanceof de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.parts.FBInputEventEditPart)
						|| (c instanceof de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.parts.FBOutputEventEditPart)
						|| (c instanceof de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.parts.FBInputVarEditPart)
						|| (c instanceof de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.parts.FBOutputVarEditPart)
						|| (c instanceof de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts.IFInputEventEditPart)
						|| (c instanceof de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts.IFOutputEventEditPart)
						|| (c instanceof de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts.IFInputVarEditPart)
						|| (c instanceof de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts.IFOutputVarEditPart)
						|| (c instanceof de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts.FBInputEventEditPart)
						|| (c instanceof de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts.FBOutputEventEditPart)
						|| (c instanceof de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts.FBInputVarEditPart)
						|| (c instanceof de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts.FBOutputVarEditPart)
						|| (c instanceof de.cau.cs.kieler.cakefeed.fbnetwork.diagram.edit.parts.FBInputEventEditPart)
						|| (c instanceof de.cau.cs.kieler.cakefeed.fbnetwork.diagram.edit.parts.FBOutputEventEditPart)
						|| (c instanceof de.cau.cs.kieler.cakefeed.fbnetwork.diagram.edit.parts.FBInputVarEditPart)
						|| (c instanceof de.cau.cs.kieler.cakefeed.fbnetwork.diagram.edit.parts.FBOutputVarEditPart)) {
					EObject element = ((View)((EditPart)c).getModel()).getElement();
					EObject container = element.eContainer();
					if (((container instanceof FBType) || (container instanceof FB)) && (((NamedAndCommented)container).getName().equals(fBName))) {
						signalEditParts.add((EditPart)c);
					}
				}
				signalEditParts.addAll(getSignalEditParts((EditPart)c, fBName));
			}
		}
		return signalEditParts;
	}

	private List<String> getChildrenNames(Element elem, String type) {
		List<String> names = new ArrayList<String>();
		NodeList children = elem.getChildNodes();
		for (int i = 0; i < children.getLength(); i++) {
			Node child = children.item(i);
			if (child instanceof Element) {
				Element e = (Element)child;
				if (e.getNodeName().equals(type)) {
					names.add(e.getTextContent());
				} 
				else {
					names.addAll(getChildrenNames(e, type));
				}
			}
		}
		return names;
	}

	private Element getTick(int tick, Element elem) {
		Element result = null;
		String name = elem.getNodeName();
		if (name.equals("Tick") && elem.hasAttribute("Id") && (elem.getAttribute("Id").equals(""+ tick +""))) {
			result = elem;
		} else {
			NodeList children = elem.getChildNodes();
			for (int i = 0; i < children.getLength(); i++) {
				Node child = children.item(i);
				if (child instanceof Element) {
					Element newResult = getTick(tick, (Element)child);
					if (newResult != null) {
						result = newResult;
					}
				}
			}
		}
		return result;
	}

	protected void read(String fileName) {
		try {
			  // TODO xml von andre korrigieren lassen
			  File file = new File(fileName/*"C:\\Documents and Settings\\msch165\\Desktop\\CAKeFEED\\demo\\environmentcruise.rmc"*/);
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
        properties[0] = new KiemProperty("Counter Example", new KiemPropertyTypeFile(),
                "C:\\CounterExample.txt");
        // CHECKSTYLEON MagicNumber
        return properties;
    }

}
