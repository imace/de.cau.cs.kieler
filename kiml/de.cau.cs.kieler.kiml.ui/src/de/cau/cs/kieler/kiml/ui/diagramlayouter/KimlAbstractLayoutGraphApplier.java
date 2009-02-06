package de.cau.cs.kieler.kiml.ui.diagramlayouter;

import java.util.Map;

import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.LabelEditPart;

import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KEdgeLabel;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutEdge;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutGraph;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutNode;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutPort;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KNodeLabel;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KPortLabel;

public abstract class KimlAbstractLayoutGraphApplier {

	/*
	 * some strings used when creating the concrete layout graph appliers via
	 * the extension point mechanism
	 */
	public static final String EXTENSION_POINT_ID = "de.cau.cs.kieler.kiml.ui.kimlLayoutGraphApplier";
	public static final String ATTRIBUTE_CLASS = "class";
	public static final String ATTRIBUTE_EDITOR_ID = "editor_id";
	public static final String ATTRIBUTE_ID = "id";
	public static final String ATTRIBUTE_NAME = "name";
	public static final String ATTRIBUTE_ICON = "icon";

	protected Map<KLayoutNode, GraphicalEditPart> layoutNode2EditPart;
	protected Map<KLayoutEdge, ConnectionEditPart> layoutEdge2EditPart;
	protected Map<KLayoutPort, GraphicalEditPart> layoutPort2EditPart;

	protected Map<KNodeLabel, LabelEditPart> nodeLabel2EditPart;
	protected Map<KEdgeLabel, LabelEditPart> edgeLabel2EditPart;
	protected Map<KPortLabel, LabelEditPart> portLabel2EditPart;

	protected GraphicalEditPart layoutRootPart;
	protected KLayoutGraph layoutGraph;
	
	
	protected final void applyLayoutGraph(
			KimlLayoutInformation layoutInformation) {

		updatePreferences();

		layoutNode2EditPart = layoutInformation.layoutNode2EditPart;
		layoutEdge2EditPart = layoutInformation.layoutEdge2EditPart;
		layoutPort2EditPart = layoutInformation.layoutPort2EditPart;
		nodeLabel2EditPart = layoutInformation.nodeLabel2EditPart;
		edgeLabel2EditPart = layoutInformation.edgeLabel2EditPart;
		portLabel2EditPart = layoutInformation.portLabel2EditPart;
		layoutRootPart = layoutInformation.layoutRootPart;
		layoutGraph = layoutInformation.layoutGraph;
		
		doApplyLayoutGraph();
	}

	protected abstract void doApplyLayoutGraph();

	protected abstract void updatePreferences();
}
