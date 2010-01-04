package de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;

import de.cau.cs.kieler.cakefeed.bfbtype.diagram.providers.CakefeedElementTypes;

/**
 * @generated
 */
public class OutputWithItemSemanticEditPolicy extends
		CakefeedBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public OutputWithItemSemanticEditPolicy() {
		super(CakefeedElementTypes.OutputWith_4002);
	}

	/**
	 * @generated
	 */
	protected Command getDestroyElementCommand(DestroyElementRequest req) {
		return getGEFWrapper(new DestroyElementCommand(req));
	}

}
