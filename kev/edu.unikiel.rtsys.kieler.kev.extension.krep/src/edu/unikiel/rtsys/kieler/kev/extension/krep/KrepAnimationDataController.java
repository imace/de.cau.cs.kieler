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

public class KrepAnimationDataController extends AnimationDataControllerAggregated implements ISignalListener {

	/** Data object to be displayed in the graphics */
    AnimationData kevAnimationData = new AnimationData();
	
	public KrepAnimationDataController() {
		// TODO Auto-generated constructor stub
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

	/**
	 * KReP callback to tell the animation to perform one tick. Inputs
	 * and outputs are mapped from the KEV interface.
	 */
	@Override
	public void tickPerformed(LinkedList<Signal> inputs,
			LinkedList<Signal> outputs) {
		// receive a clone of the current control data
		AnimationData kevControlData = this.getControlData();
		// reset the current control data in order to start aggregating new events
		this.resetControlData();
		try{
			// send data to KEV
			for (Signal signal : outputs) {
				if(signal.isValued())
					kevAnimationData.setData(signal.getIndex(), signal.getValue());
				else
					kevAnimationData.setData(signal.getIndex(), new Boolean(signal.getPresent()));
			}
			this.fireDataChangeEvent(kevAnimationData);
			
			// send data to KReP
			for (Signal signal : inputs) {
				Object item = kevControlData.getData().get(signal.getIndex());
				if(item instanceof Boolean)
					signal.setPresent(((Boolean)item).booleanValue());
				else
					signal.setValue(item);
			}
			
		}catch(Exception e){
			Tools.showDialog("Problems at passing data between KEV and KReP Eval Bench. Maybe the two data signatures do not match.", e);
		}
	}

}
