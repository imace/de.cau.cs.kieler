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
import de.cau.cs.kieler.ssm.CompositeState;
import de.cau.cs.kieler.ssm.InitialState;
import de.cau.cs.kieler.ssm.Region;
import de.cau.cs.kieler.ssm.provider.InitialStateItemProvider;

public class KimlInitialStateItemProvider extends InitialStateItemProvider
		implements IKimlLabelProvider {

	public KimlInitialStateItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	public String getKimlCenterLabel(Object object) {
		return null;
	}

	public String getKimlHeadLabel(Object object) {
		return null;
	}

	public String getKimlLongLabel(Object object) {
		InitialState initialState = (InitialState) object;
		Region region = (Region) initialState.eContainer();
		CompositeState compositeState = (CompositeState) region.eContainer();

		return compositeState.getName() == null ? "Initial State of a Region in a Composite State"
				: "Initial State of a Region in " + compositeState.getName();
	}

	public String getKimlShortLabel(Object object) {
		/* Initial State has no label to display */
		return "";
	}

	public String getKimlTailLabel(Object object) {
		return null;
	}

}
