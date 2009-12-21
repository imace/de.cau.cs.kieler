package de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.commands.FBCreateCommand;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.commands.IFInputEventCreateCommand;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.commands.IFInputVarCreateCommand;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.commands.IFOutputEventCreateCommand;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.commands.IFOutputVarCreateCommand;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.providers.CakefeedElementTypes;

/**
 * @generated
 */
public class CFBTypeCFBTypeCompartmentItemSemanticEditPolicy extends
		CakefeedBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public CFBTypeCFBTypeCompartmentItemSemanticEditPolicy() {
		super(CakefeedElementTypes.CFBType_2001);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (CakefeedElementTypes.IFInputEvent_3012 == req.getElementType()) {
			return getGEFWrapper(new IFInputEventCreateCommand(req));
		}
		if (CakefeedElementTypes.IFOutputEvent_3013 == req.getElementType()) {
			return getGEFWrapper(new IFOutputEventCreateCommand(req));
		}
		if (CakefeedElementTypes.IFInputVar_3014 == req.getElementType()) {
			return getGEFWrapper(new IFInputVarCreateCommand(req));
		}
		if (CakefeedElementTypes.IFOutputVar_3015 == req.getElementType()) {
			return getGEFWrapper(new IFOutputVarCreateCommand(req));
		}
		if (CakefeedElementTypes.FB_3016 == req.getElementType()) {
			return getGEFWrapper(new FBCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
