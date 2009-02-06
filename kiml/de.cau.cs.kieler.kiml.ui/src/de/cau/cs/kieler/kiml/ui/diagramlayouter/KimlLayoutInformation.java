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

public final class KimlLayoutInformation {

	public KLayoutGraph layoutGraph;

	public Map<KLayoutNode, GraphicalEditPart> layoutNode2EditPart;
	public Map<KLayoutEdge, ConnectionEditPart> layoutEdge2EditPart;
	public Map<KLayoutPort, GraphicalEditPart> layoutPort2EditPart;

	public Map<KNodeLabel, LabelEditPart> nodeLabel2EditPart;
	public Map<KEdgeLabel, LabelEditPart> edgeLabel2EditPart;
	public Map<KPortLabel, LabelEditPart> portLabel2EditPart;

	public GraphicalEditPart layoutRootPart;

}
