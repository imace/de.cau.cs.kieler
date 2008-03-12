package edu.unikiel.rtsys.kieler.kev.extension.elevator;

import edu.unikiel.rtsys.kieler.kev.extension.AnimationData;
import edu.unikiel.rtsys.kieler.kev.extension.AnimationDataController;
import edu.unikiel.rtsys.kieler.kev.extension.ControlFlowChangeEvent;
import edu.unikiel.rtsys.kieler.kev.extension.DataChangeEvent;
import edu.unikiel.rtsys.kieler.kev.extension.ControlFlowChangeEvent.Type;

/**
 * <p> A simple Java internal test-controller for the KIEL Environment Visualization (KEV).
 * This controller implements the AnimationDataController case class to extend the
 * corresponding extension point of KEV. </p>
 * 
 * <p>This controller is implemented directly in Java and implements only one specific
 * application. I.e. it is not a generic controlling interface. The application is
 * a simple 2-floor elevator. The interface comprises three displays 
 * (int:direction, boolean:alarm lamp and int:position) and three controls 
 * (boolean:up, boolean: down and boolean:alarm).<p>
 * 
 * <p>The controller also reads the controlFlowChanged events to keep track of the control
 * flow. The ElevatorJob takes care of the passing of time.</p>
 * 
 * @see ElevatorJob
 * @author Hauke Fuhrmann, haf
 */

public class TestController extends AnimationDataController{
	
	ElevatorJob elevatorJob = new ElevatorJob(this);
	
	/*
	 * (non-Javadoc)
	 * @see edu.unikiel.rtsys.kieler.kev.extension.ControlFlowChangeListener#controlFlowChanged(edu.unikiel.rtsys.kieler.kev.extension.ControlFlowChangeEvent)
	 */
	@Override
	public void controlFlowChanged(ControlFlowChangeEvent e) {
		System.out.println("Control Flow Changed: "+e.getType()+" "+e.getData());
		switch (e.getType()) {
		case START:
			elevatorJob.start();
			break;
		case STOP:
			elevatorJob.cancel();
			elevatorJob = new ElevatorJob(this);
			break;
		case STEP:
			elevatorJob.step();
			break;
		case DELAY:
			elevatorJob.setDelay((Integer)e.getData());
			break;
		default:
			break;
		}
	}

	/*
	 * (non-Javadoc)
	 * @see edu.unikiel.rtsys.kieler.kev.extension.DataChangeListener#dataChanged(edu.unikiel.rtsys.kieler.kev.extension.DataChangeEvent)
	 */
	@Override
	public void dataChanged(DataChangeEvent e) {
		System.out.println("Control data Changed: "+e.getData());
		elevatorJob.buttonPressed(e.getData());
	}

	/*
	 * (non-Javadoc)
	 * @see edu.unikiel.rtsys.kieler.kev.extension.DataChangeListener#setDataSize(int)
	 */
	@Override
	public void setDataSize(int size) {
		System.out.println("Display data size from mapping: "+size);
	}

}
