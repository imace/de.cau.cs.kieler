package de.cau.cs.kieler.ssm.diagram.layouter.provider;

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
		NormalTermination normalTermination = (NormalTermination) object;
		return String.valueOf(normalTermination
				.getPriority());
	}

}
