package kiel.layouter.graphviz;

import java.util.List;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.editpolicies.GraphicalEditPolicy;
import org.eclipse.gef.requests.ChangeBoundsRequest;



public class RemoteLayoutEditPolicy extends GraphicalEditPolicy {
	
	public Command getCommand(Request request){
		if (request instanceof ChangeBoundsRequest){
			CompoundCommand cc = new CompoundCommand("");
			ChangeBoundsRequest cbr = (ChangeBoundsRequest)request;
			if(cbr.getType().equals("REQ_ABSOLUTEMOVE")){
				List<EditPart> children = cbr.getEditParts();
				
				return cc;
			}
		}
		
		return null;
	}

	
}
