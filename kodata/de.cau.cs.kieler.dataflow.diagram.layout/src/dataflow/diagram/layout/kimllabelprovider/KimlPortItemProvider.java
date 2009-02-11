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

import dataflow.provider.PortItemProvider;
import de.cau.cs.kieler.kiml.ui.provider.IKimlLabelProvider;

public class KimlPortItemProvider extends PortItemProvider implements
		IKimlLabelProvider {

	public KimlPortItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	public String getKimlCenterLabel(Object object) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getKimlHeadLabel(Object object) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getKimlLongLabel(Object object) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getKimlShortLabel(Object object) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getKimlTailLabel(Object object) {
		// TODO Auto-generated method stub
		return null;
	}

}
