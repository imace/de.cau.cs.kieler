package de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.commands.FBCreateCommand;
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
		super(CakefeedElementTypes.CFBType_2002);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (CakefeedElementTypes.FB_3025 == req.getElementType()) {
			return getGEFWrapper(new FBCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
