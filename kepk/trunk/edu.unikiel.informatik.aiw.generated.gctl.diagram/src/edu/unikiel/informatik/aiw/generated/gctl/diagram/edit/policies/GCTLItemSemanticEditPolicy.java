package edu.unikiel.informatik.aiw.generated.gctl.diagram.edit.policies;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.commands.DuplicateEObjectsCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DuplicateElementsRequest;

import edu.unikiel.informatik.aiw.generated.epc.EpcPackage;
import edu.unikiel.informatik.aiw.generated.gctl.diagram.edit.commands.EPCCreateCommand;
import edu.unikiel.informatik.aiw.generated.gctl.diagram.edit.commands.EventCreateCommand;
import edu.unikiel.informatik.aiw.generated.gctl.diagram.edit.commands.FunctionCreateCommand;
import edu.unikiel.informatik.aiw.generated.gctl.diagram.edit.commands.ImplicationCreateCommand;
import edu.unikiel.informatik.aiw.generated.gctl.diagram.edit.commands.InformationCreateCommand;
import edu.unikiel.informatik.aiw.generated.gctl.diagram.providers.EpcElementTypes;

/**
 * @generated
 */
public class GCTLItemSemanticEditPolicy extends EpcBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (EpcElementTypes.Function_1001 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req
						.setContainmentFeature(EpcPackage.eINSTANCE
								.getEPC_Objects());
			}
			return getGEFWrapper(new FunctionCreateCommand(req));
		}
		if (EpcElementTypes.Event_1002 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req
						.setContainmentFeature(EpcPackage.eINSTANCE
								.getEPC_Objects());
			}
			return getGEFWrapper(new EventCreateCommand(req));
		}
		if (EpcElementTypes.Information_1003 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req
						.setContainmentFeature(EpcPackage.eINSTANCE
								.getEPC_Objects());
			}
			return getGEFWrapper(new InformationCreateCommand(req));
		}
		if (EpcElementTypes.EPC_1004 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req
						.setContainmentFeature(EpcPackage.eINSTANCE
								.getEPC_Objects());
			}
			return getGEFWrapper(new EPCCreateCommand(req));
		}
		if (EpcElementTypes.Implication_1005 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req
						.setContainmentFeature(EpcPackage.eINSTANCE
								.getEPC_Objects());
			}
			return getGEFWrapper(new ImplicationCreateCommand(req));
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
