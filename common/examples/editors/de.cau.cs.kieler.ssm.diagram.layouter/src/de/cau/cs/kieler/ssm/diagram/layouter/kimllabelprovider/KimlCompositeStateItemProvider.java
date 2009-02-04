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
		return label;
	}

	@Override
	public String getKimlShortLabel(Object object) {
		String label = ((CompositeState)object).getName();
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

