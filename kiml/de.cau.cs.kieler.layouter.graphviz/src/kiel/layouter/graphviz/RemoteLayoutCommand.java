package kiel.layouter.graphviz;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.common.command.AbstractCommand;
import org.eclipse.gmf.runtime.notation.Node;

public class RemoteLayoutCommand extends AbstractCommand {

	private final Node myNode;
	private final RemoteLayoutRequest myRequest;

	private Point myNewPosition;
	
	public RemoteLayoutCommand(Node node, RemoteLayoutRequest request) {
		super("Change node position/size by remote");
		myNode = node;
		myRequest = request;
	}
	
	public void execute() {
		// TODO Auto-generated method stub
		
	}

	public void redo() {
		// TODO Auto-generated method stub
		
	}

	

}
