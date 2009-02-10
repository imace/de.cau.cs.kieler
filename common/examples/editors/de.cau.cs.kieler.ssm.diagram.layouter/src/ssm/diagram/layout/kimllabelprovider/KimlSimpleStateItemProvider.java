/*******************************************************************************
 * Copyright (c) 2008 Real-Time and Embedded Systems group
 *
 * INSERT LICENCE HERE
 *
 *
 * Author: Arne Schipper, ars@informatik.uni-kiel.de 
 *
 *******************************************************************************/
package ssm.diagram.layout.kimllabelprovider;

import org.eclipse.emf.common.notify.AdapterFactory;

import de.cau.cs.kieler.kiml.ui.provider.IKimlLabelProvider;
import de.cau.cs.kieler.ssm.SimpleState;
import de.cau.cs.kieler.ssm.provider.SimpleStateItemProvider;

public class KimlSimpleStateItemProvider extends SimpleStateItemProvider
		implements IKimlLabelProvider {

	public KimlSimpleStateItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	public String getKimlLongLabel(Object object) {
		String label = ((SimpleState) object).getName();
		return label == null || label.length() == 0 ? "" : label;
	}

	public String getKimlShortLabel(Object object) {
		String label = ((SimpleState) object).getName();
		return label == null || label.length() == 0 ? "" : label;
	}

	public String getKimlCenterLabel(Object object) {
		return null;
	}

	public String getKimlHeadLabel(Object object) {
		return null;
	}

	public String getKimlTailLabel(Object object) {
		return null;
	}

}
