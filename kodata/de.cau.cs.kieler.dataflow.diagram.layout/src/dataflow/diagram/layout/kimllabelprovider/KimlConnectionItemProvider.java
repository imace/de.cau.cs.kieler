/*******************************************************************************
 * Copyright (c) 2008 Real-Time and Embedded Systems group
 *
 * INSERT LICENCE HERE
 *
 *
 * Author: Arne Schipper, ars@informatik.uni-kiel.de 
 *
 *******************************************************************************/
package dataflow.diagram.layout.kimllabelprovider;

import org.eclipse.emf.common.notify.AdapterFactory;

import dataflow.provider.ConnectionItemProvider;
import de.cau.cs.kieler.kiml.ui.provider.IKimlLabelProvider;

public class KimlConnectionItemProvider extends ConnectionItemProvider
		implements IKimlLabelProvider {

	public KimlConnectionItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	@Override
	public String getKimlCenterLabel(Object object) {
		return null;
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
		return null;
	}

}
