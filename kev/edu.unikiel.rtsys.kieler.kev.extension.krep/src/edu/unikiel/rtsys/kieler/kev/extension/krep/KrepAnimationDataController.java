package edu.unikiel.rtsys.kieler.kev.extension.krep;

import java.util.LinkedList;

import krep.evalbench.comm.ISignalListener;
import krep.evalbench.comm.Signal;
import edu.unikiel.rtsys.kieler.kev.extension.AnimationData;
import edu.unikiel.rtsys.kieler.kev.extension.AnimationDataController;
import edu.unikiel.rtsys.kieler.kev.extension.AnimationDataControllerAggregated;
import edu.unikiel.rtsys.kieler.kev.extension.ControlFlowChangeEvent;
import edu.unikiel.rtsys.kieler.kev.extension.DataChangeEvent;
import edu.unikiel.rtsys.kieler.kev.helpers.Tools;

public class KrepAnimationDataController extends AnimationDataControllerAggregated{

	/** implementing singleton pattern to be able to interface between KEV and KREP extension points */
	public static KrepAnimationDataController INSTANCE;
	
	/** Data object to be displayed in the graphics */
    AnimationData kevAnimationData = new AnimationData();
	
	public KrepAnimationDataController() {
		INSTANCE = this;
	}

	/** implementing singleton pattern to be able to interface between KEV and KREP extension points */
	public static KrepAnimationDataController getInstace(){
		return INSTANCE;
	}
	
	/**
	 * Listener Method called from KEV to indicate some control flow
	 * has been changed by the KEV buttons (start, stop, step, delay time).
	 * This is not used at the KReP. Here the KReP UI takes control of that.
	 * 
	 * @see edu.unikiel.rtsys.kieler.kev.extension.ControlFlowChangeListener#controlFlowChanged(edu.unikiel.rtsys.kieler.kev.extension.ControlFlowChangeEvent)
	 */
	@Override
	public void controlFlowChanged(ControlFlowChangeEvent e) {
		/*nothing*/
	}

	/**
	 * Will be called by KEV at image loading to tell the controller how many inputs
	 * there are available.
	 */
	@Override
	public void setDataSize(int size) {
		// TODO Auto-generated method stub
	}


}
