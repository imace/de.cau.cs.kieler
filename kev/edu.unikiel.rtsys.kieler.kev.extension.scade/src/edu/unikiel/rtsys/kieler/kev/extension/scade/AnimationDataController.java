package edu.unikiel.rtsys.kieler.kev.extension.scade;

import edu.unikiel.rtsys.kieler.kev.extension.ControlFlowChangeEvent;
import edu.unikiel.rtsys.kieler.kev.extension.DataChangeEvent;
import edu.unikiel.rtsys.kieler.kev.helpers.Tools;

public class AnimationDataController extends
		edu.unikiel.rtsys.kieler.kev.extension.AnimationDataController {

	ScadeStepControlJob controlJob;
	
	public AnimationDataController() {
		
	}

	@Override
	public void controlFlowChanged(ControlFlowChangeEvent e) {
		if(controlJob == null)
			controlJob = new ScadeStepControlJob(this);
		switch (e.getType()) {
		case START:
			if(controlJob.isConnected()){
				controlJob.setPaused(false);
				controlJob.schedule();
			}
			else{
				controlJob.init();
			}
			break;
		case STEP:
			controlJob.setPaused(true);
			controlJob.schedule();
			break;
		case DELAY:
			try {
				controlJob.setDelay((Integer)e.getData());
			} catch (Exception e2) {
				Tools.showDialog("Could not set the specified delay.", e2);
			}
			break;
		default:
			controlJob.cancel();
			controlJob.stop();
			break;
		}

	}

	@Override
	public void dataChanged(DataChangeEvent e) {
		
	}

	@Override
	public void setDataSize(int size) {
		
	}

}
