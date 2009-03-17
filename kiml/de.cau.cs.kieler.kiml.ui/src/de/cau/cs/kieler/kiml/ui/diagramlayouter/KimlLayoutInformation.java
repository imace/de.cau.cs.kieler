/******************************************************************************
 * KIELER - Kiel Integrated Environment for Layout for the Eclipse RCP
 *
 * http://www.informatik.uni-kiel.de/rtsys/kieler/
 * 
 * Copyright 2009 by
 * + Christian-Albrechts-University of Kiel
 *   + Department of Computer Science
 *     + Real-Time and Embedded Systems Group
 * 
 * This code is provided under the terms of the Eclipse Public License (EPL).
 * See the file epl-v10.html for the license text.
 */
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

/**
 * Structure used to pass all the needed layout information between the single
 * layout steps. Interacts mainly between the
 * {@link KimlAbstractLayoutGraphBuilder} and
 * {@link KimlAbstractLayoutGraphApplier}.
 * 
 * @author <a href="mailto:ars@informatik.uni-kiel.de">Arne Schipper</a>
 * 
 */
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
