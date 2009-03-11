package de.cau.cs.kieler.ssm2.custom;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

public class SizeCondition extends Condition {

	public SizeCondition(EStructuralFeature f, Integer v) {
		super(f, v);
	}
	
	@Override
	public boolean isValid(EObject modelElement) {
		if ((modelElement == null) || (modelElement.eGet(feature) == null) || !(modelElement.eGet(feature) instanceof EList)) {
			return false;
		}
		if (((Integer) value).intValue() == ((EList) modelElement.eGet(feature)).size()) {
			return true;
		}
		return false;
	}

}
