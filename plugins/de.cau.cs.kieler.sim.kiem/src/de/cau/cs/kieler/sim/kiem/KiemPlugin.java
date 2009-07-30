/******************************************************************************
 * KIELER - Kiel Integrated Environment for Layout for the Eclipse RCP
 *
 * http://www.informatik.uni-kiel.de/rtsys/kieler/
 * 
 * Copyright 2009 by
 * + Christian-Albrechts-University of Kiel
 *   + Department of Computer Science
 *     + Real-Time and Embedded Systems Group
 * 
 * This code is provided under the terms of the Eclipse Public License (EPL).
 * See the file epl-v10.html for the license text.
 ******************************************************************************/

package de.cau.cs.kieler.sim.kiem;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.ui.statushandlers.IStatusAdapterConstants;
import org.eclipse.ui.statushandlers.StatusAdapter;
import org.eclipse.ui.statushandlers.StatusManager;
import org.osgi.framework.BundleContext;
//import org.eclipse.core.resources.IResource;
//import org.eclipse.core.runtime.IAdaptable;
//import org.eclipse.jface.viewers.ISelection;
//import org.eclipse.jface.viewers.IStructuredSelection;

import de.cau.cs.kieler.sim.kiem.data.DataComponentEx;
import de.cau.cs.kieler.sim.kiem.data.KiemProperty;
import de.cau.cs.kieler.sim.kiem.data.KiemPropertyException;
import de.cau.cs.kieler.sim.kiem.execution.Execution;
import de.cau.cs.kieler.sim.kiem.extension.JSONObjectDataComponent;
import de.cau.cs.kieler.sim.kiem.extension.JSONStringDataComponent;
import de.cau.cs.kieler.sim.kiem.extension.DataComponent;
import de.cau.cs.kieler.sim.kiem.extension.KiemExecutionException;
import de.cau.cs.kieler.sim.kiem.extension.KiemInitializationException;
import de.cau.cs.kieler.sim.kiem.views.KiemView;

/**
 * This activator class controls the life cycle of the KiemPlugin.
 * It also provides the access to the one and only instance of this
 * class and hence a way to access the execution thread.
 *
 * @author Christian Motika - cmot AT informatik.uni-kiel.de
 * 
 */
public class KiemPlugin extends AbstractUIPlugin {

	/** The Constant AIMED_STEP_DURATION_DEFAULT. 
	 * Default value of the AimedStepDuration text field in ms */
	public static final int AIMED_STEP_DURATION_DEFAULT = 500;
	
	/** The Constant AIMED_STEP_DURATION_MIN. 
	 * Minimum value of the AimedStepDuration text field in ms */
	public static final int AIMED_STEP_DURATION_MIN = 1;
	
	/** The Constant AIMED_STEP_DURATION_MAX. 
	 * Maximum value of the AimedStepDuration text field in ms */
	public static final int AIMED_STEP_DURATION_MAX = 3600000;
	
	/** The Constant PLUGIN_ID. */
	public static final String PLUGIN_ID = "de.cau.cs.kieler.sim.kiem";

	/** The shared instance */
	private static KiemPlugin plugin;
	
	/** List of available dataProducers and dataObservers */
	private List<DataComponent> dataComponentList;
	
	/** List of selected dataComponentEx's (modified by KiemView) */
	private List<DataComponentEx> dataComponentExList;
	
	/** Execution object */
	public Execution execution;
	
	/** Execution thread */
	public Thread executionThread;
	
	/** Current value of the aimed step duration in ms */
	private int aimedStepDuration;
	
	/** The KIEM view instance. */
	private KiemView KIEMViewInstance;
	
	//-------------------------------------------------------------------------
	
	/**
	 * The constructor if the KIEM plug-in. A default DataComponentExList is
	 * created. It contains all DataComponents in the default order
	 * (@see #getDefaultComponentExList()). The execution is null by default.
	 * The KIEMViewInstance is set, in the constructor of the
	 * @see de.cau.cs.kieler.sim.kiem.views.KiemView
	 */
	public KiemPlugin() {
		dataComponentList = this.getDataComponentList();
		dataComponentExList = getDefaultComponentExList();
		execution = null;
		aimedStepDuration = AIMED_STEP_DURATION_DEFAULT;
		KIEMViewInstance = null;
	}

	//-------------------------------------------------------------------------

	/* (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	//-------------------------------------------------------------------------

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	//-------------------------------------------------------------------------

	/**
	 * Returns the shared instance of the KIEM plug-in. This is mainly used by
	 * the execution thread to access the view of the KIELER Execution Manager
	 * or the other way round.
	 *
	 * @return the one and only shared instance of this KIEM plug-in
	 */
	public static KiemPlugin getDefault() {
		return plugin;
	}

	//-------------------------------------------------------------------------

	/**
	 * Updates the view of the KiemView table asynchronously.
	 */
	public void updateViewAsync() {
		if (this.KIEMViewInstance != null) {
			this.KIEMViewInstance.updateViewAsync();

		}
	}
	
	/**
	 * Updates the steps in the Step text field asynchronously.
	 */
	public void updateStepsAsync() {
		if (this.KIEMViewInstance != null) {
			this.KIEMViewInstance.updateStepsAsync();

		}
	}

	//-------------------------------------------------------------------------

	/**
	 * Sets the view focus to the KiemView instance. This method is called by
	 * the AimedStepDuration text field if the used wants to leave its focus
	 * by pressing <ENTER>.
	 */
	public void setViewFocus() {
		if (this.KIEMViewInstance != null) {
			this.KIEMViewInstance.setFocus();
		}
	}
	
	//-------------------------------------------------------------------------

	/**
	 * Sets the KIEM view instance. This method is called by the constructor
	 * of the Class {@link de.cau.cs.kieler.sim.kiem.views.KiemView} so that
	 * this plug-in (or the execution thread) is able to trigger updates on 
	 * the view.
	 * 
	 * @param KIEMViewInstance the one and only KiemView instance
	 */
	public void setKIEMViewInstance(KiemView KIEMViewInstance) {
		this.KIEMViewInstance = KIEMViewInstance;
	}
	
	//-------------------------------------------------------------------------
	
	/**
	 * Gets the currently set aimed step duration.
	 * 
	 * @return the aimed step duration
	 */
	public int getAimedStepDuration() {
		return this.aimedStepDuration;
	}

	//-------------------------------------------------------------------------

	/**
	 * Sets the aimed step duration. This method sets the aimed step duration 
	 * and also passes-on the value to the execution thread if that exists.
	 * 
	 * @param aimedStepDuration the new aimed step duration
	 */
	public void setAimedStepDuration(int aimedStepDuration){
		this.aimedStepDuration = aimedStepDuration;
		//if executing, also update current delay
		if (execution != null)
			this.execution.setAimedStepDuration(aimedStepDuration);
	}
	
	//-------------------------------------------------------------------------

//	/**
//	 * Extracts the selection of the Project Explorer. This method is not
//	 * used in the current implementation but may be used in the future.
//	 * 
//	 */
//	public IResource extractSelection(ISelection sel) {
//	      if (!(sel instanceof IStructuredSelection))
//	         return null;
//	      IStructuredSelection ss = (IStructuredSelection) sel;
//	      Object element = ss.getFirstElement();
//	      if (element instanceof IResource)
//	         return (IResource) element;
//	      if (!(element instanceof IAdaptable))
//	         return null;
//	      IAdaptable adaptable = (IAdaptable)element;
//	      Object adapter = adaptable.getAdapter(IResource.class);
//	      return (IResource) adapter;
//	}
	
	//-------------------------------------------------------------------------
	
	/**
	 * This initializes the DataComponentList with all registered and loaded
	 * plug-ins that extend the following two extension points:
	 * @see de.cau.cs.kieler.sim.kiem.extension.JSONObjectDataComponent
	 * @see de.cau.cs.kieler.sim.kiem.extension.JSONStringDataComponent
	 * If a DataComponent is registered but cannot be instantiated because
	 * of an error this will result in a warning only so that all other
	 * fully functional DataComponents are still loaded. This method remembers
	 * its list thru the whole life-cycle of this plug-in and always returns
	 * the same list. All DataComponents that cannot be instantiated due to
	 * errors will not occur in the list.
	 * 
	 * @return the DataComponentList
	 */
	public List<DataComponent>getDataComponentList(){
		if(dataComponentList != null)
			return dataComponentList;
				
		// get the available interfaces and initialize them
		IConfigurationElement[] jsonComponents = 
				Platform.getExtensionRegistry()
				.getConfigurationElementsFor(
							Messages.extensionPointIDjsoncomponent);
		
		IConfigurationElement[] stringComponents = 
				Platform.getExtensionRegistry()
				.getConfigurationElementsFor(
							Messages.extensionPointIDstringcomponent);
		
		dataComponentList = new ArrayList<DataComponent>
											    (jsonComponents.length
											    +stringComponents.length);
		
//System.out.println("Found Controllers for "+Messages.extensionPointIDjsoncomponent+": "+jsonComponents.length);
		for (int i = 0; i < jsonComponents.length; i++) {
			try{
				JSONObjectDataComponent dataComponent = 
					(JSONObjectDataComponent) jsonComponents[i]
					                    .createExecutableExtension("class");
				dataComponent.setConfigurationElemenet(jsonComponents[i]);
				dataComponentList.add(dataComponent);
//System.out.println(jsonComponents[i]);
			}catch(Exception e){
				//throw new RuntimeException
				//	("Error at loading a KIEM data component plugin");
				this.showWarning("Error at loading KIEM data component" +
						" '"+jsonComponents[i].getContributor().getName()+"'",
						null, e);
			} 
		}
//System.out.println("Found Controllers for "+Messages.extensionPointIDstringcomponent+": "+stringComponents.length);
		for (int i = 0; i < stringComponents.length; i++) {
			try{
				JSONStringDataComponent dataComponent = 
					(JSONStringDataComponent)stringComponents[i]
                                        .createExecutableExtension("class");
				dataComponent.setConfigurationElemenet(stringComponents[i]);
				dataComponentList.add(dataComponent);
//System.out.println(dataComponent.getName());
			}catch(Exception e){
//				throw new RuntimeException
//					("Error at loading a KIEM data component plugin");
				this.showWarning("Error at loading KIEM data component" +
						" '"+jsonComponents[i].getContributor().getName()+"'",
						null, e);
			} 
		}
		return dataComponentList;
	}
	
	//-------------------------------------------------------------------------

	/**
	 * Initializes the Execution. This is one of the heart-methods of this 
	 * plug-in. It does the following tasks:
	 * (1) Check if there are any (enabled) DataProducers or DataConsumers.
	 * (2) Check if all DataComponent's properties are set correctly
	 * (3) Grab all interface variables provided by the DataComponents.
	 * (4) Distribute the union of all the variables to all DataComponents.
	 * (5) Initialize the DataComponents
	 * (6) Create an run the Execution thread
	 * 
	 * This method returns true if the execution is successfully initialized
	 * or if the execution thread already exists, hence the {@link #execution}
	 * is not null.
	 * 
	 * @return true, if successful
	 */
	public boolean initExecution() {
		if (this.execution != null) return true;

		//count all (enabled) data producer and Observer
		int countEnabledProducer = 0;
		int countEnabledObserver = 0;
		for (int c = 0; c < dataComponentExList.size(); c++) {
			DataComponentEx dataComponentEx = dataComponentExList.get(c);
			if (dataComponentEx.isEnabled()) {
				if (dataComponentEx.isProducer()) {
					countEnabledProducer++;
				}
				if (dataComponentEx.isObserver()) {
					countEnabledObserver++;
				}
			}//end if enabled
		}//next c
		if (countEnabledProducer < 1) {
			this.showError("Please enable at least one Data Producer!",
					KiemPlugin.PLUGIN_ID,null);
			return false;
		}
		else if (countEnabledObserver < 1) {
			showError("Please enable at least one Data Observer!",
					KiemPlugin.PLUGIN_ID,null);
			return false;
		}
		
		//now check if properties are OK hence no KiemPropertyError is thrown
		for (int c = 0; c < dataComponentExList.size(); c++) {
			DataComponentEx dataComponentEx = dataComponentExList.get(c);
			KiemProperty[] properties = dataComponentEx.getProperties();
			try {
				dataComponentEx.checkProperties(properties);
			} catch (KiemPropertyException e) {
				this.showError(e.getMessage(), dataComponentEx
						.getDataComponent().getConfigurationElement()
						.getContributor().getName(),
						e);
				return false;
			}
		}
		
		//get all InterfaceVariables from (enabled) data producer 
		//and combine them into globalInterfaceVariables
		List<String> globalInterfaceVariables = new LinkedList<String>();
		for (int c = 0; c < dataComponentExList.size(); c++) {
			DataComponentEx dataComponentEx = dataComponentExList.get(c);
			if (dataComponentEx.isEnabled()) {
			  String[] localInterfaceVariables = 
			  dataComponentEx.provideInterfaceVariables();
			  if (localInterfaceVariables != null) {
				for (int cc = 0; cc < localInterfaceVariables.length; cc++) {
				  String localInterfaceVariable = localInterfaceVariables[cc];
				  globalInterfaceVariables.add(localInterfaceVariable);
				}//next cc
			  }//end if not null
			}//if enabled
		}//next c
		
		//distribute union of InterfaceVariables to all enabled components
		for (int c = 0; c < dataComponentExList.size(); c++) {
			DataComponentEx dataComponentEx = dataComponentExList.get(c);
			if (dataComponentEx.isEnabled()) {
				dataComponentEx.setInterfaceVariables
				  ((String[])globalInterfaceVariables.toArray(new String [0]));
			}//end if enabled
		}//next c
		
		//initialize all (enabled) data producer and Observer
		for (int c = 0; c < dataComponentExList.size(); c++) {
			DataComponentEx dataComponentEx = dataComponentExList.get(c);
			if (dataComponentEx.isEnabled()) {
				try {
					dataComponentEx.getDataComponent().initialize();
				}catch(KiemInitializationException e) {
					KiemPlugin.getDefault().handleComponentError(
							dataComponentEx.getDataComponent(), e);
					return false;
				}
			}//end if enabled
		}//next c
		
		//now create and run the execution thread
		this.execution = new Execution(dataComponentExList);
		//take the last set delay
		this.execution.setAimedStepDuration(this.getAimedStepDuration());
		this.executionThread = new Thread(this.execution);
		this.executionThread.start();

		return true;
	}

	//-------------------------------------------------------------------------
	
	/**
	 * Add a DataComponent instance to the DataComponentExList 
	 * (@see #dataComponentExList).
	 * This will clone the DataComponent and add an executable extension. It
	 * then creates a new DataComponentEx instance that encapsulates the just
	 * created DataComponent (and offers additional information and methods). 
	 * The latter will be added then to the DataComponentList.
	 * 
	 * @param component the component
	 */
	public void addTodataComponentExList(DataComponent component) {
		IConfigurationElement componentConfigEle = 
								component.getConfigurationElement();
		DataComponent componentClone;
		try {
			componentClone = (DataComponent)
						componentConfigEle.createExecutableExtension("class");
			componentClone.setConfigurationElemenet(componentConfigEle);
			
			DataComponentEx dataComponentEx = 
						new DataComponentEx(componentClone);
			this.dataComponentExList.add(dataComponentEx);
		} catch (CoreException e) {
			e.printStackTrace();
		}
	}

	//-------------------------------------------------------------------------
	
	/**
	 * Returns the default ComponentExList. This will contain all registered
	 * DataComponents that extend one the following extension points:
	 * @see de.cau.cs.kieler.sim.kiem.extension.JSONObjectDataComponent
	 * @see de.cau.cs.kieler.sim.kiem.extension.JSONStringDataComponent
	 * They will be ordered in the "natural" way, meaning that the (pure)
	 * DataProducers are scheduled before the DataObserver&Producers which
	 * are themselves scheduled before the (pure) DataObservers.
	 * Although DataComponents may be multiple instantiable, by default, there
	 * will be exactly one instance per DataComponent in the list.
	 * 
	 * @return the default DataComponentExList
	 */
	public List<DataComponentEx> getDefaultComponentExList() {
		List<DataComponent> list = this.getDataComponentList();
		List<DataComponentEx> returnList = 
							new LinkedList<DataComponentEx>();
		//first add pure producer
		for (int c = 0; c < list.size(); c ++) {
			DataComponent dataComponent = (DataComponent)list.get(c);
			DataComponentEx dataComponentEx = 
				new DataComponentEx(dataComponent);
			if (dataComponentEx.isProducerOnly()) {
				returnList.add(dataComponentEx);
			}
		}
		//then add Observer & producer
		for (int c = 0; c < list.size(); c ++) {
			DataComponent dataComponent = (DataComponent)list.get(c);
			DataComponentEx dataComponentEx = 
				new DataComponentEx(dataComponent);
			if (dataComponentEx.isProducerObserver()) {
				returnList.add(dataComponentEx);
			}
		}
		//then add pure Observer
		for (int c = 0; c < list.size(); c ++) {
			DataComponent dataComponent = (DataComponent)list.get(c);
			DataComponentEx dataComponentEx = 
				new DataComponentEx(dataComponent);
			if (dataComponentEx.isObserverOnly()) {
				returnList.add(dataComponentEx);
			}
		}
		return returnList;
	}

	//-------------------------------------------------------------------------

	/**
	 * Returns the current DataComponentEx-List that is held by the KIEM
	 * plug-in directly. Any modification on this list is persistent in this
	 * one and only plug-in instance. The DataComponentExList holds a list 
	 * of DataComponents, selected from all registered (and loaded) plug-ins
	 * that extend the following extension points:
	 * @see de.cau.cs.kieler.sim.kiem.extension.JSONObjectDataComponent
	 * @see de.cau.cs.kieler.sim.kiem.extension.JSONStringDataComponent
	 * 
	 * @return the DataComponentExList
	 */
	public List<DataComponentEx> getDataComponentExList() {
		return this.dataComponentExList;
	}

	//-------------------------------------------------------------------------
	
	/**
	 * This method handles errors or warnings within the execution of
	 * DataComponents. It specifically handles the following two types
	 * or errors:
	 * - @see de.cau.cs.kieler.sim.kiem.execution.KiemExecutionException
	 * - @see de.cau.cs.kieler.sim.kiem.execution.KiemInitializationException
	 * If the mustStop flag is set, then the execution is immediately stoped.
	 * Note that all threads will be advised to stop in the
	 * {@link de.cau.cs.kieler.sim.kiem.execution.Execution#errorTerminate()}
	 * method. But there is no guarantee that they really stop. The links to
	 * these threads will be cut down, so that there is the possibility of
	 * zombie threads.
	 * 
	 * @param dataComponent the DataComponent that caused the error or warning
	 * @param e the Exception if any, or null
	 */
	public void handleComponentError(DataComponent dataComponent,
									 Exception e) {
		
		boolean mustStop = false; 
		
		//check if mustStop flag is set
		if (e instanceof KiemExecutionException) {
			mustStop = ((KiemExecutionException)e).isMustStop();
		}
		else if (e instanceof KiemInitializationException) {
			mustStop = ((KiemInitializationException)e).isMustStop();
		}
		
		//show error or warning message dialog
		if (mustStop) {
			//first terminate the execution
			KiemPlugin.getDefault().execution.errorTerminate();
			//then show modal error dialog
			KiemPlugin.getDefault().showError(
					null, dataComponent.getPluginId(), e);
		}
		else {
			//show non modal warning dialog
			KiemPlugin.getDefault().showWarning(
					null, dataComponent.getPluginId(), e);
		}
		
	}
	
	//-------------------------------------------------------------------------

	/**
	 * Shows a warning dialog using the StatusAdapter. This dialog will *NOT*
	 * be modal, so that the user is notified but the current work is 
	 * not interrupted. 
	 * Additionally the information will be logged in the error log so that
	 * the user has the opportunity to e.g., access the error stack trace. 
	 * The plug-in id is required, textMessage and exception are optional.
	 * 
	 * @param textMessage the text message
	 * @param PluginID the plug-in id
	 * @param exception the exception
	 */
	public void showWarning(String textMessage, 
							String PluginID, 
							Exception exception) {
		try{
			String message = "";
			
			if (textMessage != null) {
				message = textMessage + message;
				//exception = null;
			}
			else if (exception != null) {
				message = exception.getMessage() + message;
				//exception = null;
			}

			//do not post the same message twice
			if (exception.getMessage().startsWith(textMessage))
				message = "" + PluginID + "";
			else
				message += " (" + PluginID + ")";
			
			if (PluginID == null) PluginID = KiemPlugin.PLUGIN_ID;

			IStatus status = new Status(IStatus.WARNING,
					PluginID,
					42,
					message,
					exception);
			
			StatusAdapter statusAdapter = new StatusAdapter(status);
			statusAdapter.setProperty(
					IStatusAdapterConstants.TIMESTAMP_PROPERTY, 
					System.currentTimeMillis());
			 

			//use status manager (log and show)
			StatusManager.getManager().handle(statusAdapter,
					StatusManager.LOG | 
					StatusManager.SHOW);
			
		}catch(Exception e){
			e.printStackTrace();
		}		
	}

	//-------------------------------------------------------------------------
	
	/**
	 * Shows an error dialog using the StatusAdapter. This dialog will be
	 * modal, so that the user has to click OK to end it. Additionally the
	 * information will be logged in the error log so that the user has
	 * the opportunity to e.g., access the error stack trace. The plug-in
	 * id is required, textMessage and exception are optional.
	 * 
	 * @param textMessage the optional text message
	 * @param PluginID the plug-in id
	 * @param exception the exception if any, null otherwise
	 */
	public void showError(String textMessage, 
						  String PluginID,
						  Exception exception) {
		try{
			String message = "";
			
			if (textMessage != null) {
				message = textMessage + message;
				//exception = null;
			}
			else if (exception != null) {
				message = exception.getMessage() + message;
				//exception = null;
			}
			
			//do not post the same message twice
			if (exception.getMessage().startsWith(textMessage))
				message = "" + PluginID + "";
			else
				message += " (" + PluginID + ")";

			if (PluginID == null) PluginID = KiemPlugin.PLUGIN_ID;

			IStatus status = new Status(IStatus.ERROR,
					PluginID,
					42,
					message,
					exception);

			StatusAdapter statusAdapter = new StatusAdapter(status);
			statusAdapter.setProperty(
					IStatusAdapterConstants.TIMESTAMP_PROPERTY, 
					System.currentTimeMillis());
			
			//use status manager (log and show)
			//BLOCK = modal window, force the user to act!
			StatusManager.getManager().handle(statusAdapter,
					StatusManager.BLOCK | 
					StatusManager.LOG | 
					StatusManager.SHOW);
			
		}catch(Exception e){
			e.printStackTrace();
		}		
	}
	
}
