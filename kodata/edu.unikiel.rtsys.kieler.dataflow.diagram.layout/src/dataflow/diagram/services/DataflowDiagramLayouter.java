package dataflow.diagram.services;

import java.util.Map;

import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IEditorPart;

import dataflow.diagram.edit.parts.DataflowModelEditPart;
import dataflow.diagram.part.DataflowDiagramEditor;

import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KLayoutGraph;
import edu.unikiel.rtsys.kieler.kiml.layout.services.KimlAbstractLayouter;

/**
 * This layouter for dataflow diagrams performs the needed transformation
 * from diagram elements to the KIML Layout Graph structure.
 * @author msp
 */
public class DataflowDiagramLayouter extends KimlAbstractLayouter {

	private DataflowModelEditPart modelPart = null;
	
	/*
	 * (non-Javadoc)
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.services.KimlAbstractLayouter#init(java.lang.Object)
	 */
	protected boolean init(Object target) {
		// find the dataflow model edit part depending on the type of input
		if (target instanceof IEditorPart)
		{
			DataflowDiagramEditor editor = (DataflowDiagramEditor)target;
			modelPart = (DataflowModelEditPart)editor.getDiagramEditPart();
		}
		else if (target instanceof IStructuredSelection)
		{
			IStructuredSelection selection = (IStructuredSelection)target;
			AbstractGraphicalEditPart content = (AbstractGraphicalEditPart)selection.getFirstElement();
			modelPart = (DataflowModelEditPart)content.getRoot().getChildren().get(0);
		}
		else return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.services.KimlAbstractLayouter#buildLayoutGraph()
	 */
	protected KLayoutGraph buildLayoutGraph() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.services.KimlAbstractLayouter#applyLayout()
	 */
	protected void applyLayout() {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.services.KimlAbstractLayouter#getSettings()
	 */
	public Map getSettings() {
		// TODO Auto-generated method stub
		return null;
	}

}
