package de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.policies;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.commands.DuplicateEObjectsCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DuplicateElementsRequest;

import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.commands.BFBTypeCreateCommand;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.providers.CakefeedElementTypes;

/**
 * @generated
 */
public class BFBDiagramItemSemanticEditPolicy extends
		CakefeedBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public BFBDiagramItemSemanticEditPolicy() {
		super(CakefeedElementTypes.BFBDiagram_1000);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (CakefeedElementTypes.BFBType_2002 == req.getElementType()) {
			return getGEFWrapper(new BFBTypeCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

	/**
	 * @generated
	 */
	protected Command getDuplicateCommand(DuplicateElementsRequest req) {
		TransactionalEditingDomain editingDomain = ((IGraphicalEditPart) getHost())
				.getEditingDomain();
		return getGEFWrapper(new DuplicateAnythingCommand(editingDomain, req));
	}

	/**
	 * @generated
	 */
	private static class DuplicateAnythingCommand extends
			DuplicateEObjectsCommand {

		/**
		 * @generated
		 */
		public DuplicateAnythingCommand(
				TransactionalEditingDomain editingDomain,
				DuplicateElementsRequest req) {
			super(editingDomain, req.getLabel(), req
					.getElementsToBeDuplicated(), req
					.getAllDuplicatedElementsMap());
		}

	}

}
