package kiel.layouter.graphviz;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;
import org.eclipse.gmf.runtime.notation.Location;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.impl.NodeImpl;

/**
 * AbsoluteMoveCommand that takes an EP and an absolute location where to move the
 * EditPart. This is required, because the usual ChangeBoundsRequest REQ_MOVE only
 * moves relatively to some delta. As a request and its execution might differ in time
 * this delta might need to be calculated at execution of the command instead of its creation. 
 * @author haf
 *
 */
public class AbsoluteMoveCommand extends Command {

	GraphicalEditPart ep;
	Point newLocation;
	
	public AbsoluteMoveCommand(GraphicalEditPart ep, Point newLocation) {
		super("AbsoluteMoveCommand");
		this.ep = ep;
		this.newLocation = newLocation;
	}
	
	@Override
	public void execute(){
		System.out.println("Execute LabelMoveCommand");
		
		ChangeBoundsRequest request = new ChangeBoundsRequest(RequestConstants.REQ_MOVE);
		request.setEditParts(ep);
		// calculate the Move Delta (required by movement request)
		Point oldLocation = ep.getFigure().getBounds().getLocation();
/* results some strange initial position but not the correct intermediate one
 * 		Object model = ep.getModel();
		if(model instanceof Node){
			Object layoutConstraint = ((NodeImpl) model).getLayoutConstraint();
			if(layoutConstraint instanceof Location){
				oldLocation = new Point(((Location)layoutConstraint).getX(),((Location)layoutConstraint).getY());
			}
		}
*/		Point delta = new Point(newLocation.x-oldLocation.x, newLocation.y-oldLocation.y);
		request.setMoveDelta(delta);
		request.setLocation(newLocation);
		// get the actual command for the request from EP itself
		Command cmd = ep.getCommand(request);
		if(cmd != null && cmd.canExecute())
			cmd.execute();
	}
	
}
