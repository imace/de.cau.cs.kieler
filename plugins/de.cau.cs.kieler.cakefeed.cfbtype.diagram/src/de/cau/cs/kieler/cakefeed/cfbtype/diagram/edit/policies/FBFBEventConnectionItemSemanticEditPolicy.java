package de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;

import de.cau.cs.kieler.cakefeed.cfbtype.diagram.providers.CakefeedElementTypes;

/**
 * @generated
 */
public class FBFBEventConnectionItemSemanticEditPolicy extends
		CakefeedBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public FBFBEventConnectionItemSemanticEditPolicy() {
		super(CakefeedElementTypes.FBFBEventConnection_4010);
	}

	/**
	 * @generated
	 */
	protected Command getDestroyElementCommand(DestroyElementRequest req) {
		return getGEFWrapper(new DestroyElementCommand(req));
	}

}
