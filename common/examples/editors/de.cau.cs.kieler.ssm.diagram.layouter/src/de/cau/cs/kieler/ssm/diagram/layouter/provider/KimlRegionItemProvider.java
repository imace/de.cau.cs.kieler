package de.cau.cs.kieler.ssm.diagram.layouter.provider;

import org.eclipse.emf.common.notify.AdapterFactory;

import de.cau.cs.kieler.kiml.ui.provider.IKimlLabelProvider;
import de.cau.cs.kieler.ssm.CompositeState;
import de.cau.cs.kieler.ssm.Region;
import de.cau.cs.kieler.ssm.provider.RegionItemProvider;

public class KimlRegionItemProvider extends RegionItemProvider implements IKimlLabelProvider {

	public KimlRegionItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
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
	public String getKimlLongLabel(Object object) {
		Region region = (Region) object;
		CompositeState compositeState = (CompositeState) region
				.eContainer();
		return "Region " + region.hashCode()
				+ " in " + compositeState.getName();
	}

	@Override
	public String getKimlShortLabel(Object object) {
		Region region = (Region) object;
		return "Region " + region.hashCode();
	}

	@Override
	public String getKimlTailLabel(Object object) {
		// TODO Auto-generated method stub
		return null;
	}

}
