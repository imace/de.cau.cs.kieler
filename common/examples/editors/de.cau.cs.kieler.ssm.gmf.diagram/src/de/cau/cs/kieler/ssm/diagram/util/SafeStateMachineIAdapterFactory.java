package de.cau.cs.kieler.ssm.diagram.util;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;

import edu.unikiel.rtsys.kieler.ssm.CompositeState;
import edu.unikiel.rtsys.kieler.ssm.InitialState;
import edu.unikiel.rtsys.kieler.ssm.NormalTermination;
import edu.unikiel.rtsys.kieler.ssm.Region;
import edu.unikiel.rtsys.kieler.ssm.SimpleState;
import edu.unikiel.rtsys.kieler.ssm.StrongAbortion;
import edu.unikiel.rtsys.kieler.ssm.WeakAbortion;

public class SafeStateMachineIAdapterFactory implements IAdapterFactory {

	private static final Class[] types = { Map.class };

	public Object getAdapter(Object adaptableObject, Class adapterType) {

		if (adapterType == Map.class
				&& adaptableObject instanceof ShapeNodeEditPart) {
			Map<String, String> hashMap = new HashMap<String, String>();
			hashMap.put("SHORT_LABEL", "");
			hashMap.put("LONG_LABEL", "");

			/*
			 * First cast to ShapeNodeEditPart to be able to access the model
			 */
			EObject modelElement = ((ShapeNodeEditPart) adaptableObject)
					.getNotationView().getElement();

			/*
			 * CompositeState is easy, this is for the CompositeState
			 */
			if (modelElement instanceof CompositeState) {
				hashMap.put("SHORT_LABEL", ((CompositeState) modelElement)
						.getName());
				hashMap.put("LONG_LABEL", ((CompositeState) modelElement)
						.getName());
				return hashMap;
			}
			/*
			 * SimpleState is easy, too
			 */
			else if (modelElement instanceof SimpleState) {
				hashMap.put("SHORT_LABEL", ((SimpleState) modelElement)
						.getName());
				hashMap.put("LONG_LABEL", ((SimpleState) modelElement)
						.getName());
				return hashMap;
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
				hashMap.put("SHORT_LABEL", "");
				hashMap.put("LONG_LABEL", "Initial State of a Region in "
						+ compositeState.getName());
				return hashMap;
			}
			/*
			 * Similar for a region
			 */
			else if (modelElement instanceof Region) {
				Region region = (Region) modelElement;
				CompositeState compositeState = (CompositeState) region
						.eContainer();
				hashMap.put("SHORT_LABEL", "");
				hashMap.put("LONG_LABEL", "Region " + region.hashCode()
						+ " in " + compositeState.getName());
				return hashMap;
			}
			return hashMap;
		}

		if (adapterType == Map.class
				&& adaptableObject instanceof ConnectionEditPart) {
			Map<String, String> hashMap = new HashMap<String, String>();
			hashMap.put("HEAD_LABEL", "");
			hashMap.put("MID_LABEL", "");
			hashMap.put("TAIL_LABEL", "");

			/*
			 * First cast to ShapeNodeEditPart to be able to access the model
			 */
			EObject modelElement = ((ConnectionEditPart) adaptableObject)
					.getNotationView().getElement();
			/*
			 * Now for Strong Abortion
			 */
			if (modelElement instanceof StrongAbortion) {
				StrongAbortion strongAbortion = (StrongAbortion) modelElement;

				String immediate = strongAbortion.getIsImmediateString() == null ? ""
						: strongAbortion.getIsImmediateString();
				String trigger = strongAbortion.getTriggerString() == null ? ""
						: strongAbortion.getIsImmediateString()
								+ strongAbortion.getTriggerString();
				String effect = strongAbortion.getEffectString() == null ? ""
						: strongAbortion.getEffectString();
				hashMap.put("MID_LABEL", immediate + trigger + "/" + effect);
				hashMap.put("TAIL_LABEL", String.valueOf(strongAbortion
						.getPriority()));
				hashMap.put("HEAD_LABEL", "");
				return hashMap;
			}
			/*
			 * Now for Normal Termination
			 */
			else if (modelElement instanceof NormalTermination) {
				NormalTermination normalTermination = (NormalTermination) modelElement;
				String effect = normalTermination.getEffectString() == null ? ""
						: normalTermination.getEffectString();
				hashMap.put("MID_LABEL", "/" + effect);
				hashMap.put("TAIL_LABEL", String.valueOf(normalTermination
						.getPriority()));
				hashMap.put("HEAD_LABEL", "");
				return hashMap;
			}
			/*
			 * Now for Weak Abortion
			 */
			else if (modelElement instanceof WeakAbortion) {
				WeakAbortion weakAbortion = (WeakAbortion) modelElement;

				String immediate = weakAbortion.getIsImmediateString() == null ? ""
						: weakAbortion.getIsImmediateString();
				String trigger = weakAbortion.getTriggerString() == null ? ""
						: weakAbortion.getIsImmediateString()
								+ weakAbortion.getTriggerString();
				String effect = weakAbortion.getEffectString() == null ? ""
						: weakAbortion.getEffectString();
				hashMap.put("MID_LABEL", immediate + trigger + "/" + effect);
				hashMap.put("TAIL_LABEL", String.valueOf(weakAbortion
						.getPriority()));
				hashMap.put("HEAD_LABEL", "");
				return hashMap;
			}

			return hashMap;
		}

		return null;
	}

	public Class[] getAdapterList() {
		return types;
	}

}