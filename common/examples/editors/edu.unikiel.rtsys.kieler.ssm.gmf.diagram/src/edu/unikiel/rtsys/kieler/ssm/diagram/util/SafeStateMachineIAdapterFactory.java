package edu.unikiel.rtsys.kieler.ssm.diagram.util;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;

import edu.unikiel.rtsys.kieler.ssm.CompositeState;
import edu.unikiel.rtsys.kieler.ssm.InitialState;
import edu.unikiel.rtsys.kieler.ssm.Region;
import edu.unikiel.rtsys.kieler.ssm.SimpleState;

public class SafeStateMachineIAdapterFactory implements IAdapterFactory {

	private static final Class[] types = { Map.class };

	public Object getAdapter(Object adaptableObject, Class adapterType) {

		if (adapterType == Map.class
				&& adaptableObject instanceof ShapeNodeEditPart) {
			Map<String, String> kimlLabel = new HashMap<String, String>();
			kimlLabel.put("SHORT_LABEL", "");
			kimlLabel.put("LONG_LABEL", "");

			/*
			 * First cast to ShapeNodeEditPart to be able to access the model
			 */
			EObject modelElement = ((ShapeNodeEditPart) adaptableObject)
					.getNotationView().getElement();

			/*
			 * CompositeState is easy, this is for the CompositeState
			 */
			if (modelElement instanceof CompositeState) {
				kimlLabel.put("SHORT_LABEL", ((CompositeState) modelElement)
						.getName());
				kimlLabel.put("LONG_LABEL", ((CompositeState) modelElement)
						.getName());
				return kimlLabel;
			}
			/*
			 * SimpleState is easy, too
			 */
			else if (modelElement instanceof SimpleState) {
				kimlLabel.put("SHORT_LABEL", ((SimpleState) modelElement)
						.getName());
				kimlLabel.put("LONG_LABEL", ((SimpleState) modelElement)
						.getName());
				return kimlLabel;
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
				kimlLabel.put("SHORT_LABEL", "");
				kimlLabel.put("LONG_LABEL", "Initial State of a Region in "
						+ compositeState.getName());
				return kimlLabel;
			}
			/*
			 * Similar for a region
			 */
			else if (modelElement instanceof Region) {
				Region region = (Region) modelElement;
				CompositeState compositeState = (CompositeState) region
						.eContainer();
				kimlLabel.put("SHORT_LABEL", "");
				kimlLabel.put("LONG_LABEL", "Region in "
						+ compositeState.getName());
				return kimlLabel;
			}
			return kimlLabel;
		}
		return null;
	}

	public Class[] getAdapterList() {
		return types;
	}

}