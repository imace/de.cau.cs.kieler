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
import de.cau.cs.kieler.ssm.StrongAbortion;
import de.cau.cs.kieler.ssm.provider.StrongAbortionItemProvider;

public class KimlStrongAbortionItemProvider extends StrongAbortionItemProvider  implements IKimlLabelProvider{

	public KimlStrongAbortionItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	public String getKimlCenterLabel(Object object) {
		StrongAbortion strongAbortion = (StrongAbortion) object;

		String immediate = strongAbortion.getIsImmediateString() == null ? ""
				: strongAbortion.getIsImmediateString();
		String trigger = strongAbortion.getTriggerString() == null ? ""
				:  strongAbortion.getTriggerString();
		String effect = strongAbortion.getEffectString() == null ? ""
				: strongAbortion.getEffectString();
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
		StrongAbortion strongAbortion = (StrongAbortion) object;
		return String.valueOf(strongAbortion
				.getPriority());
	}

}
