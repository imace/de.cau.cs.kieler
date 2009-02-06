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
import de.cau.cs.kieler.ssm.NormalTermination;
import de.cau.cs.kieler.ssm.provider.NormalTerminationItemProvider;

public class KimlNormalTerminationItemProvider extends
		NormalTerminationItemProvider  implements IKimlLabelProvider{

	public KimlNormalTerminationItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	@Override
	public String getKimlCenterLabel(Object object) {
		NormalTermination normalTermination = (NormalTermination) object;
		String effect = normalTermination.getEffectString() == null ? ""
				: normalTermination.getEffectString();
		return "/" + effect;
	}

	@Override
	public String getKimlHeadLabel(Object object) {
		return null;
	}

	@Override
	public String getKimlLongLabel(Object object) {
		return null;
	}

	@Override
	public String getKimlShortLabel(Object object) {
		return null;
	}

	@Override
	public String getKimlTailLabel(Object object) {
		NormalTermination normalTermination = (NormalTermination) object;
		return String.valueOf(normalTermination
				.getPriority());
	}

}
