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
import de.cau.cs.kieler.ssm.InitialState;
import de.cau.cs.kieler.ssm.Region;
import de.cau.cs.kieler.ssm.provider.InitialStateItemProvider;

public class KimlInitialStateItemProvider extends InitialStateItemProvider implements IKimlLabelProvider {

	public KimlInitialStateItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
		// TODO Auto-generated constructor stub
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
		InitialState initialState = (InitialState) object;
		Region region = (Region) initialState.eContainer();
		CompositeState compositeState = (CompositeState) region
				.eContainer();
		return "Initial State of a Region in "
				+ compositeState.getName();
	}

	@Override
	public String getKimlShortLabel(Object object) {
		return "";
	}

	@Override
	public String getKimlTailLabel(Object object) {
		// TODO Auto-generated method stub
		return null;
	}

}
