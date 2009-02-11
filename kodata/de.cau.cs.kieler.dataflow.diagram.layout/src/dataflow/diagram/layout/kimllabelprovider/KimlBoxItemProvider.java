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

import dataflow.Box;
import dataflow.provider.BoxItemProvider;
import de.cau.cs.kieler.kiml.ui.provider.IKimlLabelProvider;

public class KimlBoxItemProvider extends BoxItemProvider  implements IKimlLabelProvider{

	public KimlBoxItemProvider(AdapterFactory adapterFactory) {
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
		String label = ((Box)object).getName();
		return label == null || label.length() == 0 ? "" : label; //$NON-NLS-1$
	}

	@Override
	public String getKimlShortLabel(Object object) {
		String label = ((Box)object).getName();
		return label == null || label.length() == 0 ? "" : label; //$NON-NLS-1$
	}

	@Override
	public String getKimlTailLabel(Object object) {
		return null;
	}

}
