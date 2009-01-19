package de.cau.cs.kieler.ssm.diagram.edit.commands;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.type.core.commands.CreateElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.notation.View;

import de.cau.cs.kieler.ssm.SafeStateMachine;

/**
 * @generated
 */
public class CompositeStateCreateCommand extends CreateElementCommand {

	/**
	 * @generated
	 */
	public CompositeStateCreateCommand(CreateElementRequest req) {
		super(req);
	}

	/**
	 * @generated
	 */
	protected EObject getElementToEdit() {
		EObject container = ((CreateElementRequest) getRequest())
				.getContainer();
		if (container instanceof View) {
			container = ((View) container).getElement();
		}
		return container;
	}

	/**
	 * @generated
	 */
	public boolean canExecute() {
		de.cau.cs.kieler.ssm.SafeStateMachine container = (de.cau.cs.kieler.ssm.SafeStateMachine) getElementToEdit();
		if (container.getTop() != null) {
			return false;
		}
		return true;
	}

	/**
	 * @generated
	 */
	protected EClass getEClassToEdit() {
		return de.cau.cs.kieler.ssm.ssmPackage.eINSTANCE.getSafeStateMachine();
	}

}
