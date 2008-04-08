package edu.unikiel.rtsys.kieler.kev.extension.scade;

import org.eclipse.jface.preference.IPreferenceStore;

import edu.unikiel.rtsys.kieler.kev.extension.AnimationData;
import edu.unikiel.rtsys.kieler.kev.extension.DataChangeEvent;
import edu.unikiel.rtsys.kieler.kev.extension.StepControlJob;
import edu.unikiel.rtsys.kieler.kev.helpers.Tools;

/** A Job that takes care of the timing behaviour, i.e. controls that
 * the steps are executed in the time set by the delay variable. It has
 * a ScadeSlaveGateway and will bridge between the AnimationDataController
 * and SCADE.
 * @author haf
 *
 */
public class ScadeStepControlJob extends StepControlJob {

	ScadeSlaveGateway scadeGateway;
	AnimationData animationData;
	IPreferenceStore preferenceStore;
	
	public ScadeStepControlJob(AnimationDataController controller) {
		super("SCADE Step Control Job",controller);
		// TODO: fix hardcoded stuff
		preferenceStore = KevScadePlugin.getDefault().getPreferenceStore();
		String outputpath = preferenceStore.getString(WorkbenchPreferencePage.OUTPUTPATH_EDITOR);
		scadeGateway = new ScadeSlaveGateway(outputpath,"");
	}
	
	/**
	 * This is one step of the execution loop.
	 */
	@Override
	public void myRun() {
		if(scadeGateway.isConnected())
			try {
				// perform a step in SCADE
				scadeGateway.step(1, true);
				// read the outputs of SCADE
				String scadeResponse = scadeGateway.receiveMessage();
				//System.out.println("Data: "+scadeResponse);
				animationData = new StringAnimationData(scadeResponse);
				// notify KEV of data change
				this.getDataController().fireDataChangeEvent(DataChangeEvent.ALL, animationData);
			} catch (ClientException e) {
				Tools.showDialog(e);
			}
	}
	
	public boolean isConnected(){
		return scadeGateway.isConnected();
	}
	
	public void init(){
		try {
			String host = preferenceStore.getString(WorkbenchPreferencePage.HOST_EDITOR);
			int port = preferenceStore.getInt(WorkbenchPreferencePage.PORT_EDITOR);
			String profile = preferenceStore.getString(WorkbenchPreferencePage.PROFILE_EDITOR);
			String rootNode = preferenceStore.getString(WorkbenchPreferencePage.ROOT_EDITOR);
			
			scadeGateway.init(host,port);
			scadeGateway.startSimulation(profile,rootNode);
		} catch (ClientException e) {
			Tools.showDialog(e);
		}	
	}
	
	public void stop(){
		try {
			scadeGateway.stopSimulation();
		} catch (Exception e) {
			Tools.showDialog(e);
		} 
		scadeGateway.close();
	}

	@Override
	public void setControlData(AnimationData data) {
		// TODO Auto-generated method stub
	}

}
