/*******************************************************************************
 * Copyright (c) 2008 Real-Time and Embedded Systems group
 *
 * INSERT LICENCE HERE
 *
 *
 * Author: Arne Schipper, ars@informatik.uni-kiel.de 
 *
 *******************************************************************************/
package ssm.diagram.custom.kiml.labelprovider;

import org.eclipse.emf.common.notify.AdapterFactory;

import de.cau.cs.kieler.kiml.ui.provider.IKimlLabelProvider;
import de.cau.cs.kieler.ssm.CompositeState;
import de.cau.cs.kieler.ssm.Region;
import de.cau.cs.kieler.ssm.provider.RegionItemProvider;

public class KimlRegionItemProvider extends RegionItemProvider implements
		IKimlLabelProvider {

	public KimlRegionItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	public String getKimlCenterLabel(Object object) {
		return null;
	}

	public String getKimlHeadLabel(Object object) {
		return null;
	}

	public String getKimlLongLabel(Object object) {
		Region region = (Region) object;
		CompositeState compositeState = (CompositeState) region.eContainer();
		
		return compositeState.getName() == null ? "Region " + region.hashCode()
				+ " in a Composite State" : "Region " + region.hashCode()
				+ " in " + compositeState.getName();
	}

	public String getKimlShortLabel(Object object) {
		Region region = (Region) object;
		return "Region " + region.hashCode();
	}

	public String getKimlTailLabel(Object object) {
		return null;
	}

}
