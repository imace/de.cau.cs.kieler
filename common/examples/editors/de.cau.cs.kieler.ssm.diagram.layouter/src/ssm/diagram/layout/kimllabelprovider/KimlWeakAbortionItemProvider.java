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
import de.cau.cs.kieler.ssm.WeakAbortion;
import de.cau.cs.kieler.ssm.provider.WeakAbortionItemProvider;

public class KimlWeakAbortionItemProvider extends WeakAbortionItemProvider  implements IKimlLabelProvider{

	public KimlWeakAbortionItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	public String getKimlCenterLabel(Object object) {
		WeakAbortion weakAbortion = (WeakAbortion) object;

		String immediate = weakAbortion.getIsImmediateString() == null ? ""
				: weakAbortion.getIsImmediateString();
		String trigger = weakAbortion.getTriggerString() == null ? ""
				: weakAbortion.getTriggerString();
		String effect = weakAbortion.getEffectString() == null ? ""
				: weakAbortion.getEffectString();
		return immediate + trigger + "/" + effect;
	}

	public String getKimlHeadLabel(Object object) {
		return null;
	}

	public String getKimlLongLabel(Object object) {
		return null;
	}

	public String getKimlShortLabel(Object object) {
		return null;
	}

	public String getKimlTailLabel(Object object) {
		WeakAbortion weakAbortion = (WeakAbortion) object;
		return String.valueOf(weakAbortion
				.getPriority());
	}

}
