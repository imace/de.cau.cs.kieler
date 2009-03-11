package de.cau.cs.kieler.ssm2.custom;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

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
