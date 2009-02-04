/*******************************************************************************
 * Copyright (c) 2008 Real-Time and Embedded Systems group
 *
 * INSERT LICENCE HERE
 *
 *
 * Author: Arne Schipper, ars@informatik.uni-kiel.de 
 *
 *******************************************************************************/
package de.cau.cs.kieler.ssm.diagram.layouter.kimllabelprovider;

import org.eclipse.emf.common.notify.AdapterFactory;

import de.cau.cs.kieler.kiml.ui.provider.IKimlLabelProvider;
import de.cau.cs.kieler.ssm.CompositeState;
import de.cau.cs.kieler.ssm.provider.CompositeStateItemProvider;

public class KimlCompositeStateItemProvider extends CompositeStateItemProvider implements IKimlLabelProvider {

	public KimlCompositeStateItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	@Override
	public String getKimlLongLabel(Object object) {
		String label = ((CompositeState)object).getName();
		return label == null || label.length() == 0 ? "" : label;
	}

	@Override
	public String getKimlShortLabel(Object object) {
		String label = ((CompositeState)object).getName();
		return label == null || label.length() == 0 ? "" : label;
	}

	@Override
	public String getKimlCenterLabel(Object object) {
		return null;
	}

	@Override
	public String getKimlHeadLabel(Object object) {
		return null;
	}

	@Override
	public String getKimlTailLabel(Object object) {
		return null;
	}

}

