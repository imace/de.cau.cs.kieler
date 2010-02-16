package de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.commands.FBCreateCommand;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.providers.CakefeedElementTypes;

/**
 * @generated
 */
public class FBDFBDCompartmentItemSemanticEditPolicy extends
		CakefeedBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public FBDFBDCompartmentItemSemanticEditPolicy() {
		super(CakefeedElementTypes.FBD_3029);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (CakefeedElementTypes.FB_3030 == req.getElementType()) {
			return getGEFWrapper(new FBCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
