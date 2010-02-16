package de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.commands.FBDCreateCommand;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.commands.LDCreateCommand;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.commands.OtherCreateCommand;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.commands.STCreateCommand;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.providers.CakefeedElementTypes;

/**
 * @generated
 */
public class BFBTypeBFBTypeCompartmentItemSemanticEditPolicy extends
		CakefeedBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public BFBTypeBFBTypeCompartmentItemSemanticEditPolicy() {
		super(CakefeedElementTypes.BFBType_2002);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (CakefeedElementTypes.FBD_3029 == req.getElementType()) {
			return getGEFWrapper(new FBDCreateCommand(req));
		}
		if (CakefeedElementTypes.ST_3035 == req.getElementType()) {
			return getGEFWrapper(new STCreateCommand(req));
		}
		if (CakefeedElementTypes.LD_3036 == req.getElementType()) {
			return getGEFWrapper(new LDCreateCommand(req));
		}
		if (CakefeedElementTypes.Other_3037 == req.getElementType()) {
			return getGEFWrapper(new OtherCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
