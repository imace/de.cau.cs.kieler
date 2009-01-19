package edu.unikiel.rtsys.kieler.kiml.ui.policies;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PrecisionRectangle;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.GraphicalEditPolicy;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.SetBoundsCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramUIMessages;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.View;

/**
 * An edit policy used for the automatic layout of diagram parts.
 * 
 * @author msp
 */
public class LayoutEditPolicy extends GraphicalEditPolicy {

	/** key used for the automatic layout option of the extended data map */
	public static final String AUTO_LAYOUT_KEY = "auto_layout";
	
	/**
	 * Checks whether the given request is supported by this policy.
	 */
	public boolean understandsRequest(Request req) {
		return req.getExtendedData().containsKey(AUTO_LAYOUT_KEY)
				&& RequestConstants.REQ_MOVE.equals(req.getType());
	}
	
	/**
	 * Creates a command for a given request, or null if the request
	 * is not supported. Only requests with the automatic layout option
	 * set in the extended data map are supported.
	 */
	public Command getCommand(Request request) {
		if (request.getExtendedData().containsKey(AUTO_LAYOUT_KEY)) {
			if (RequestConstants.REQ_MOVE.equals(request.getType()))
				return getMoveCommand((ChangeBoundsRequest)request);
			else
				return null;
		}
		else return null;
	}

	/**
	 * Returns the command contribution to a change bounds request.
	 * 
	 * @param request the change bounds request
	 * @return the command contribution to the request
	 */
	private Command getMoveCommand(ChangeBoundsRequest request) {
		GraphicalEditPart editPart = (GraphicalEditPart)getHost();
		Rectangle rect = getTransformedBounds(request);
		
		ICommand moveCommand = new SetBoundsCommand(editPart.getEditingDomain(),
				DiagramUIMessages.Commands_MoveElement, new EObjectAdapter(
					(View)getHost().getModel()), rect.getLocation());
		return new ICommandProxy(moveCommand);
	}
	
	/**
	 * Calculates the new bounds proposed by a given change bounds request.
	 * The new bounds are transformed to their relative location.
	 * 
	 * @param request the change bounds request
	 * @return the new proposed bounds
	 */
	private Rectangle getTransformedBounds(ChangeBoundsRequest request) {
		IFigure hostFigure = getHostFigure();
		PrecisionRectangle rect = new PrecisionRectangle(hostFigure.getBounds());
		rect.translate(request.getMoveDelta());
		rect.resize(request.getSizeDelta());
		
		Point parentLocation = hostFigure.getParent().getBounds().getLocation();
		rect.translate(-parentLocation.x, -parentLocation.y);
		
		return rect;
	}
	
}
