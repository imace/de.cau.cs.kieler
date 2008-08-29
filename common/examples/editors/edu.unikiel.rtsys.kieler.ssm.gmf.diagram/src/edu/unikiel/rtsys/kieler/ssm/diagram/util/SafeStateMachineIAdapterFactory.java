package edu.unikiel.rtsys.kieler.ssm.diagram.util;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;

import edu.unikiel.rtsys.kieler.ssm.CompositeState;
import edu.unikiel.rtsys.kieler.ssm.InitialState;
import edu.unikiel.rtsys.kieler.ssm.Region;
import edu.unikiel.rtsys.kieler.ssm.SimpleState;

public class SafeStateMachineIAdapterFactory implements IAdapterFactory {

	private static final Class[] types = { String.class };

	@Override
	public Object getAdapter(Object adaptableObject, Class adapterType) {
		if (adapterType == String.class
				&& adaptableObject instanceof ShapeNodeEditPart) {
			/*
			 * First cast to ShapeNodeEditPart to be able to access the model
			 */
			EObject modelElement = ((ShapeNodeEditPart) adaptableObject)
					.getNotationView().getElement();

			/*
			 * CompositeState is easy, this is for the CompositeState
			 */
			if (modelElement instanceof CompositeState) {
				return ((CompositeState) modelElement).getName();
			}
			/*
			 * SimpleState is easy, too
			 */
			else if (modelElement instanceof SimpleState) {
				return ((SimpleState) modelElement).getName();
			}
			/*
			 * That's more complicated for an InitialState. An InitialState has
			 * no name, so Emma wants to build a String stating that the
			 * InitialState lies in a Region in a named CompositeState. Emma
			 * walks through the state hierarchy in the EMF-Model. No pain with
			 * the 2 different Types of CompositeStates, as Emma walks through
			 * the EMF-Model
			 */
			else if (modelElement instanceof InitialState) {
				InitialState initialState = (InitialState) modelElement;
				Region region = (Region) initialState.eContainer();
				CompositeState compositeState = (CompositeState) region
						.eContainer();
				return "Initial State of a Region in "
						+ compositeState.getName();
			}
			/*
			 * Similar for a region
			 */
			else if (modelElement instanceof Region) {
				Region region = (Region) modelElement;
				CompositeState compositeState = (CompositeState) region
						.eContainer();
				return "Region in " + compositeState.getName();
			}
		}
		// return null if falling through
		return null;
	}

	@Override
	public Class[] getAdapterList() {
		return types;
	}

}
