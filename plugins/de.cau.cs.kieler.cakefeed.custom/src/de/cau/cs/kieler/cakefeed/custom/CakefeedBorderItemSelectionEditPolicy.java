package de.cau.cs.kieler.cakefeed.custom;

import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.AlignmentRequest;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.BorderItemSelectionEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;

public class CakefeedBorderItemSelectionEditPolicy extends
		BorderItemSelectionEditPolicy {
	/*
	@Override
	public boolean understandsRequest(Request request) {
		if (REQ_CLONE.equals(request.getType())
			|| REQ_ADD.equals(request.getType())
			|| REQ_ORPHAN.equals(request.getType())
			|| REQ_ALIGN.equals(request.getType())) {
			return true;
		}
		return super.understandsRequest(request);
	}

	@Override
	public Command getCommand(Request request) {
		Object type = request.getType();
		
		if (REQ_ORPHAN.equals(type))
			return getOrphanCommand(request);
		if (REQ_ALIGN.equals(type))
			return getAlignCommand((AlignmentRequest)request);

		return null;
	}
	
	@Override
	public void showSourceFeedback(Request request) {
		if (*//*(REQ_MOVE.equals(request.getType()) && isDragAllowed())
				||*//* REQ_ADD.equals(request.getType())
				|| REQ_CLONE.equals(request.getType())
				|| RequestConstants.REQ_DROP.equals(request.getType()))
				showChangeBoundsFeedback((ChangeBoundsRequest) request);
	}
	
	@Override
	public void eraseSourceFeedback(Request request) {
		if (*//*(REQ_MOVE.equals(request.getType()) && isDragAllowed())
				||*//* REQ_CLONE.equals(request.getType())
				|| REQ_ADD.equals(request.getType())
				|| RequestConstants.REQ_DROP.equals(request.getType()))
				eraseChangeBoundsFeedback((ChangeBoundsRequest) request);

	}
	*/
}
