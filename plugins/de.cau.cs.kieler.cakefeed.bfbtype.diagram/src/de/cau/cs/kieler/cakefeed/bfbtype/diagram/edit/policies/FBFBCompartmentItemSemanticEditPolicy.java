package de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.commands.FBInputEventCreateCommand;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.commands.FBInputVarCreateCommand;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.commands.FBOutputEventCreateCommand;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.commands.FBOutputVarCreateCommand;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.providers.CakefeedElementTypes;

/**
 * @generated
 */
public class FBFBCompartmentItemSemanticEditPolicy extends
		CakefeedBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public FBFBCompartmentItemSemanticEditPolicy() {
		super(CakefeedElementTypes.FB_3019);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (CakefeedElementTypes.FBInputEvent_3020 == req.getElementType()) {
			return getGEFWrapper(new FBInputEventCreateCommand(req));
		}
		if (CakefeedElementTypes.FBOutputEvent_3021 == req.getElementType()) {
			return getGEFWrapper(new FBOutputEventCreateCommand(req));
		}
		if (CakefeedElementTypes.FBInputVar_3022 == req.getElementType()) {
			return getGEFWrapper(new FBInputVarCreateCommand(req));
		}
		if (CakefeedElementTypes.FBOutputVar_3023 == req.getElementType()) {
			return getGEFWrapper(new FBOutputVarCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
