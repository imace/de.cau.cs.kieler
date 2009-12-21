package de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.commands.FBDCreateCommand;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.commands.IFInputEventCreateCommand;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.commands.IFInputVarCreateCommand;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.commands.IFOutputEventCreateCommand;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.commands.IFOutputVarCreateCommand;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.commands.InternalVarCreateCommand;
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
		super(CakefeedElementTypes.BFBType_2001);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (CakefeedElementTypes.IFInputEvent_3015 == req.getElementType()) {
			return getGEFWrapper(new IFInputEventCreateCommand(req));
		}
		if (CakefeedElementTypes.IFOutputEvent_3016 == req.getElementType()) {
			return getGEFWrapper(new IFOutputEventCreateCommand(req));
		}
		if (CakefeedElementTypes.IFInputVar_3017 == req.getElementType()) {
			return getGEFWrapper(new IFInputVarCreateCommand(req));
		}
		if (CakefeedElementTypes.IFOutputVar_3018 == req.getElementType()) {
			return getGEFWrapper(new IFOutputVarCreateCommand(req));
		}
		if (CakefeedElementTypes.InternalVar_3005 == req.getElementType()) {
			return getGEFWrapper(new InternalVarCreateCommand(req));
		}
		if (CakefeedElementTypes.FBD_3006 == req.getElementType()) {
			return getGEFWrapper(new FBDCreateCommand(req));
		}
		if (CakefeedElementTypes.ST_3008 == req.getElementType()) {
			return getGEFWrapper(new STCreateCommand(req));
		}
		if (CakefeedElementTypes.LD_3009 == req.getElementType()) {
			return getGEFWrapper(new LDCreateCommand(req));
		}
		if (CakefeedElementTypes.Other_3010 == req.getElementType()) {
			return getGEFWrapper(new OtherCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
