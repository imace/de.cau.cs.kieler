package de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;

import de.cau.cs.kieler.cakefeed.cfbtype.diagram.providers.CakefeedElementTypes;

/**
 * @generated
 */
public class FBFBDataConnectionItemSemanticEditPolicy extends
		CakefeedBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public FBFBDataConnectionItemSemanticEditPolicy() {
		super(CakefeedElementTypes.FBFBDataConnection_4014);
	}

	/**
	 * @generated
	 */
	protected Command getDestroyElementCommand(DestroyElementRequest req) {
		return getGEFWrapper(new DestroyElementCommand(req));
	}

}
