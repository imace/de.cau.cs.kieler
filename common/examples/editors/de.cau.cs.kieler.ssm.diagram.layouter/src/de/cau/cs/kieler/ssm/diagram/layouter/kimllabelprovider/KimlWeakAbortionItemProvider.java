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
import de.cau.cs.kieler.ssm.WeakAbortion;
import de.cau.cs.kieler.ssm.provider.WeakAbortionItemProvider;

public class KimlWeakAbortionItemProvider extends WeakAbortionItemProvider  implements IKimlLabelProvider{

	public KimlWeakAbortionItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	@Override
	public String getKimlCenterLabel(Object object) {
		WeakAbortion weakAbortion = (WeakAbortion) object;

		String immediate = weakAbortion.getIsImmediateString() == null ? ""
				: weakAbortion.getIsImmediateString();
		String trigger = weakAbortion.getTriggerString() == null ? ""
				: weakAbortion.getIsImmediateString()
						+ weakAbortion.getTriggerString();
		String effect = weakAbortion.getEffectString() == null ? ""
				: weakAbortion.getEffectString();
		return immediate + trigger + "/" + effect;
	}

	@Override
	public String getKimlHeadLabel(Object object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getKimlLongLabel(Object object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getKimlShortLabel(Object object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getKimlTailLabel(Object object) {
		WeakAbortion weakAbortion = (WeakAbortion) object;
		return String.valueOf(weakAbortion
				.getPriority());
	}

}
