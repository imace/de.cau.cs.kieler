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
package de.cau.cs.kieler.kiml.ui.layout;

import java.util.Map;

import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.LabelEditPart;

import de.cau.cs.kieler.core.kgraph.KEdge;
import de.cau.cs.kieler.core.kgraph.KLabel;
import de.cau.cs.kieler.core.kgraph.KNode;
import de.cau.cs.kieler.core.kgraph.KPort;


/**
 * Structure used to pass all the needed layout information between the single
 * layout steps. Interacts mainly between the
 * {@link AbstractLayoutGraphBuilder} and
 * {@link AbstractLayoutGraphApplier}.
 * 
 * @author <a href="mailto:ars@informatik.uni-kiel.de">Arne Schipper</a>
 */
public final class KimlLayoutInformation {

	public KNode layoutGraph;

	public Map<KNode, GraphicalEditPart> layoutNode2EditPart;
	public Map<KEdge, ConnectionEditPart> layoutEdge2EditPart;
	public Map<KPort, GraphicalEditPart> layoutPort2EditPart;

	public Map<KLabel, LabelEditPart> nodeLabel2EditPart;
	public Map<KLabel, LabelEditPart> edgeLabel2EditPart;
	public Map<KLabel, LabelEditPart> portLabel2EditPart;

	public GraphicalEditPart layoutRootPart;

}
