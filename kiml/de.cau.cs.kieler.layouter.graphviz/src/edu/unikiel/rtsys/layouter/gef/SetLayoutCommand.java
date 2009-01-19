package edu.unikiel.rtsys.layouter.gef;


import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.RelativeBendpoints;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.runtime.notation.datatype.RelativeBendpoint;
import org.eclipse.jface.util.Assert;

/**
 * @see SetConnectionBendpointCommand
 * @author haf
 *
 */
public class SetLayoutCommand extends AbstractTransactionalCommand {


	private PointList newPointList;
	private Point sourceRefPoint;
	private Point targetRefPoint;
	
	private IGraphicalEditPart ep;
	private IAdaptable adapter;
	
	public SetLayoutCommand(IGraphicalEditPart ep, String label) {
		super(ep.getEditingDomain(), label, null);
		this.ep = ep;
		this.adapter = new EObjectAdapter((EObject)ep.getModel());
	}

	public List getAffectedFiles() {
		
		View view = (View) adapter.getAdapter(View.class);
		if (view != null)
			return getWorkspaceFiles(view);
		return super.getAffectedFiles();
	}

	protected CommandResult doExecuteWithResult(
            IProgressMonitor progressMonitor, IAdaptable info)
        throws ExecutionException {
        
		Edge edge =
			(Edge) adapter.getAdapter(Edge.class);
		Assert.isNotNull(edge);
		
		ArrayList<RelativeBendpoint> newBendpoints = new ArrayList<RelativeBendpoint>();
		
		
		RelativeBendpoint wbp = new org.eclipse.gmf.runtime.notation.datatype.RelativeBendpoint(10,20,30,40);
		org.eclipse.draw2d.RelativeBendpoint rbp = new org.eclipse.draw2d.RelativeBendpoint((Connection)this.ep.getFigure());
		
		rbp.setRelativeDimensions(new Dimension(wbp.getSourceX(),wbp.getSourceY()), 
				                  new Dimension(wbp.getTargetX(),wbp.getTargetY()));
		
		rbp.setWeight(0.6f); 

		Point p = rbp.getLocation();
		
		ConnectionNodeEditPart cep = (ConnectionNodeEditPart) this.ep.getFigure();

		
		newBendpoints.add(new RelativeBendpoint(0,0,0,0));
		newBendpoints.add(new RelativeBendpoint(0,100,0,0));
		newBendpoints.add(new RelativeBendpoint(10,20,30,40));
		newBendpoints.add(new RelativeBendpoint(0,0,0,0));
		/*newBendpoints.add(new RelativeBendpoint(30,30,300,300));
		newBendpoints.add(new RelativeBendpoint(20,20,20,20));
		newBendpoints.add(new RelativeBendpoint(40,40,40,40));
		*/
		RelativeBendpoints points = (RelativeBendpoints) edge.getBendpoints();
		points.setPoints(newBendpoints);
		
		//((Bounds)((Node)edge.getSource()).getLayoutConstraint()).setX(100);
		//((Bounds)((Node)edge.getSource()).getLayoutConstraint()).setY(100);
		
		return CommandResult.newOKCommandResult();
	}
	
	
	
}
