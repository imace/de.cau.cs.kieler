package de.cau.cs.kieler.ssm.diagram.layouter.provider;

import org.eclipse.emf.common.notify.AdapterFactory;

import de.cau.cs.kieler.kiml.ui.provider.IKimlLabelProvider;
import de.cau.cs.kieler.ssm.SimpleState;
import de.cau.cs.kieler.ssm.provider.SimpleStateItemProvider;

public class KimlSimpleStateItemProvider extends SimpleStateItemProvider implements IKimlLabelProvider {

	public KimlSimpleStateItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	@Override
	public String getKimlLongLabel(Object object) {
		String label = ((SimpleState)object).getName();
		return label;
	}

	@Override
	public String getKimlShortLabel(Object object) {
		String label = ((SimpleState)object).getName();
		return label;
	}

	@Override
	public String getKimlCenterLabel(Object object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getKimlHeadLabel(Object object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getKimlTailLabel(Object object) {
		// TODO Auto-generated method stub
		return null;
	}

}
