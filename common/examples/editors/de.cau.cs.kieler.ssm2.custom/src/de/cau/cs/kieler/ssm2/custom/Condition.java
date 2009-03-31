package de.cau.cs.kieler.ssm2.custom;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

// A class to represent conditions; a condition contains a feature and a
// that the feature is supposed to have for the condition to be fulfilled
public class Condition {
	protected EStructuralFeature feature;
	protected Object value;
	
	public Condition (EStructuralFeature f, Object v) {
		feature = f;
		value = v;
	}
	
	public EStructuralFeature getFeature() {
		return feature;
	}
	
	public Object getValue() {
		return value;
	}
	
	// This method checks if the condition is fulfilled
	public boolean isValid(EObject modelElement) {
		if ((modelElement == null) || (modelElement.eGet(feature) == null)) {
			return false;
		}
		if (value == modelElement.eGet(feature)) {
			return true;
		}
		return false;
	}
}
