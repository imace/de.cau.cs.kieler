package edu.unikiel.rtsys.kieler.ssm.diagram.util;

import org.eclipse.core.runtime.IAdapterFactory;

import edu.unikiel.rtsys.kieler.ssm.CompositeState;
import edu.unikiel.rtsys.kieler.ssm.InitialState;
import edu.unikiel.rtsys.kieler.ssm.Region;
import edu.unikiel.rtsys.kieler.ssm.SimpleState;
import edu.unikiel.rtsys.kieler.ssm.diagram.edit.parts.CompositeState2EditPart;
import edu.unikiel.rtsys.kieler.ssm.diagram.edit.parts.CompositeStateEditPart;
import edu.unikiel.rtsys.kieler.ssm.diagram.edit.parts.InitialStateEditPart;
import edu.unikiel.rtsys.kieler.ssm.diagram.edit.parts.RegionEditPart;
import edu.unikiel.rtsys.kieler.ssm.diagram.edit.parts.SimpleStateEditPart;

public class SafeStateMachineIAdapterFactory implements IAdapterFactory {

	private static final Class[] types = { String.class };

	@Override
	public Object getAdapter(Object adaptableObject, Class adapterType) {
		if (adapterType == String.class) {
			/*
			 * CompositeState is easy, this is for the _TOP_ CompositeState
			 */
			if (adaptableObject instanceof CompositeStateEditPart) {
				return ((CompositeState) ((CompositeStateEditPart) adaptableObject)
						.getNotationView().getElement()).getName();
			}
			/*
			 * CompositeState is easy, this is for the _NORMAL_ CompositeStates
			 */
			else if (adaptableObject instanceof CompositeState2EditPart) {
				return ((CompositeState) ((CompositeState2EditPart) adaptableObject)
						.getNotationView().getElement()).getName();
			}
			/*
			 * SimpleState is easy, too
			 */
			else if (adaptableObject instanceof SimpleStateEditPart) {
				return ((SimpleState) ((SimpleStateEditPart) adaptableObject)
						.getNotationView().getElement()).getName();
			}
			/*
			 * That's more complicated for a InitialState. An InitialState has
			 * no name, so Emma wants to build a String stating that the
			 * InitialState lies in a Region in a named CompositeState. Emma
			 * walks through the state hierachy in the EMF-Model. No pain with
			 * the 2 different Types of CompositeStates, as Emma walks through
			 * the EMF-Model
			 */
			else if (adaptableObject instanceof InitialStateEditPart) {
				InitialState initialState = (InitialState) ((InitialStateEditPart) adaptableObject)
						.getNotationView().getElement();
				Region region = (Region) initialState.eContainer();
				CompositeState compositeState = (CompositeState) region
						.eContainer();
				return "Initial State of a Region in "
						+ compositeState.getName();
			} else if (adaptableObject instanceof RegionEditPart) {
				Region region = (Region) ((RegionEditPart) adaptableObject)
						.getNotationView().getElement();
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
