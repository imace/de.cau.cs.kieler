/*
 * generated by Xtext
 */
package de.cau.cs.kieler.synccharts.textual.labeling;

import org.eclipse.xtext.ui.core.DefaultLabelProvider;

import com.sun.org.apache.xpath.internal.operations.Variable;

import de.cau.cs.kieler.synccharts.Action;
import de.cau.cs.kieler.synccharts.Region;
import de.cau.cs.kieler.synccharts.Signal;
import de.cau.cs.kieler.synccharts.State;

//import de.cau.cs.kieler.synccharts.StateType;

/**
 * see
 * http://www.eclipse.org/Xtext/documentation/latest/xtext.html#labelProvider
 */
public class KitsLabelProvider extends DefaultLabelProvider {
	//
	String image(State s) {
		String myStateLabelImage = "State.gif";
		if (s.isIsInitial()) {
			myStateLabelImage = "InitialState.gif";
		}
		if (s.isIsFinal()) {
			myStateLabelImage = "FinalState.gif";
		}
		// if (s.getType().equals(StateType.PSEUDO)) {
		// myStateLabelImage = "...";
		// }
		return myStateLabelImage;
	}

	// String image(Transition t) {
	// String transitionLabelImage = "Transition.gif";
	// return transitionLabelImage;
	// }
	String image(Action a) {
		String image = "action.gif";
		if (a.eContainingFeature().getName() == "suspensionTrigger") {
			image = "SuspensionSD.gif";
		}
		if (a.eContainingFeature().getName() == "entryActions") {
			image = "action.gif";
		}
		// if (a.eContainingFeature().getName() == "innerActions") {
		// image = "...";
		// }
		// if (a.eContainingFeature().getName() == "exitActions") {
		// image = "...";
		// }
		return image;
	}

	String image(Region r) {
		String image = "Region25.gif";
		return image;
	}

	String image(Signal r) {
		String image = "Signal.gif";
		return image;
	}

	String image(Variable v) {
		String image = "Variable.gif";
		return image;
	}
}
