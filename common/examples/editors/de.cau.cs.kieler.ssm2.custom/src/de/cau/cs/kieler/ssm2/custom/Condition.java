package de.cau.cs.kieler.ssm2.custom;

import org.eclipse.emf.ecore.EStructuralFeature;

public class Condition {
	private EStructuralFeature feature;
	private Object value;
	
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
}
