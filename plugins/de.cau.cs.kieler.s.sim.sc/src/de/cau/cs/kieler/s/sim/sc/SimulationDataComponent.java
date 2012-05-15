package de.cau.cs.kieler.s.sim.sc;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Reader;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Map;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;

import com.google.inject.Guice;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFileState;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IPathVariableManager;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResourceProxy;
import org.eclipse.core.resources.IResourceProxyVisitor;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourceAttributes;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.QualifiedName;
import org.eclipse.core.runtime.content.IContentDescription;
import org.eclipse.core.runtime.jobs.ISchedulingRule;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.xtend.util.stdlib.CloningExtensions;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.osgi.framework.Bundle;

import de.cau.cs.kieler.core.kexpressions.Input;
import de.cau.cs.kieler.core.kexpressions.InterfaceSignalDecl;
import de.cau.cs.kieler.core.kexpressions.Output;
import de.cau.cs.kieler.core.kexpressions.Signal;
import de.cau.cs.kieler.core.ui.KielerProgressMonitor;
import de.cau.cs.kieler.s.s.Program; 
import de.cau.cs.kieler.s.sc.S2SCPlugin;
import de.cau.cs.kieler.s.sc.xtend.S2SC;
import de.cau.cs.kieler.s.sc.xtend.S2SC;
import de.cau.cs.kieler.s.sim.sc.xtend.S2Simulation;
import de.cau.cs.kieler.sc.SCExecution;
import de.cau.cs.kieler.sim.kiem.IJSONObjectDataComponent;
import de.cau.cs.kieler.sim.kiem.JSONObjectDataComponent;
import de.cau.cs.kieler.sim.kiem.KiemExecutionException;
import de.cau.cs.kieler.sim.kiem.KiemInitializationException;
import de.cau.cs.kieler.sim.kiem.properties.KiemProperty;
import de.cau.cs.kieler.sim.kiem.properties.KiemPropertyTypeFile;
import de.cau.cs.kieler.sim.kiem.ui.datacomponent.JSONObjectSimulationDataComponent;
import de.cau.cs.kieler.sim.signals.JSONSignalValues;

public class SimulationDataComponent extends JSONObjectSimulationDataComponent implements
		IJSONObjectDataComponent {
	
	// -----------------------------------------------------------------------------
	// -----------------------------------------------------------------------------

	class SSimulationProgressMonitor implements ProgressMonitor {

		private KielerProgressMonitor kielerProgressMonitor;
		private int numberOfComponents = 1;
		private int numberOfComponentsDone = 0;

		public SSimulationProgressMonitor(
				final KielerProgressMonitor kielerProgressMonitorParam,
				final int numberOfComponentsParam) {
			kielerProgressMonitor = kielerProgressMonitorParam;
			numberOfComponents = numberOfComponentsParam;
			numberOfComponentsDone = 0;
		}

		public void beginTask(final String name, final int totalWork) {
			kielerProgressMonitor.begin(name, numberOfComponents);
		}

		public void done() {
			// is called by the workflow wrapper
		}

		public void finished(final Object element, final Object context) {
		}

		public void internalWorked(final double work) {
		}

		public boolean isCanceled() {
			return (kielerProgressMonitor.isCanceled());
		}

		public void postTask(final Object element, final Object context) {
			kielerProgressMonitor.worked(numberOfComponentsDone);
			numberOfComponentsDone++;
		}

		public void preTask(final Object element, final Object context) {
			// kielerProgressMonitor.begin(element.toString(), 1);
			kielerProgressMonitor.worked(numberOfComponentsDone);
		}

		public void setCanceled(final boolean value) {
		}

		public void setTaskName(final String name) {
		}

		public void started(final Object element, final Object context) {
		}

		public void subTask(final String name) {
			kielerProgressMonitor.subTask(UNKNOWN);
		}

		public void worked(final int work) {
			kielerProgressMonitor.worked(work);
		}

	}

	// -----------------------------------------------------------------------------
	// -----------------------------------------------------------------------------
	

	private Program myModel = null;

	private SCExecution scExecution = null;

	private LinkedList<String> outputSignalList = null;


    // -------------------------------------------------------------------------

    /*
     * (non-Javadoc)
     * 
     * @see de.cau.cs.kieler.sim.kiem.ui.datacomponent.JSONObjectSimulationDataComponent
     * #checkModelValidation (org.eclipse.emf.ecore.EObject)
     */
    @Override
    public boolean checkModelValidation(final EObject rootEObject) throws KiemInitializationException {
        if (!(rootEObject instanceof Program)) {
    		throw new KiemInitializationException(
                    "S Simulator can only be used with an S editor.\n\n"
                            ,
                    true, null);
        }
        
        return true;
    }    

    // -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	public void initialize() throws KiemInitializationException {
	}

	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	public JSONObject doStep(final JSONObject jSONObject)
			throws KiemExecutionException {
		// The return object to construct
		JSONObject returnObj = new JSONObject();

		// Collect active statements
		String activeStatements = "";

		if (!scExecution.isStarted()) {
			throw new KiemExecutionException(
					"No s simulation is running", true, null);
		}
		try {

			scExecution.getExecutionInterfaceToSC().write(jSONObject.toString() + "\n");
			scExecution.getExecutionInterfaceToSC().flush();
			while (scExecution.getExecutionInterfaceError().ready()) {
				System.out.print(scExecution.getExecutionInterfaceError().read());
			}

			String receivedMessage = scExecution.getExecutionInterfaceFromSC().readLine();

			if (receivedMessage != null) {
				JSONObject esterelOutput = new JSONObject(receivedMessage);
				JSONArray esterelOutputArray = esterelOutput.names();

				if (esterelOutputArray != null) {
					// First add auxiliary signals
					for (int i = 0; i < esterelOutputArray.length(); i++) {
						String esterelOutputName = esterelOutputArray
								.getString(i);

						// Test if the output variable is an auxiliary signal
						// that is only there to mark the current S
						// statement
						// in full_simulation mode of the simulator.
						// These auxiliary signals must be encapsulated in a
						// state
						// variable.
						if (esterelOutputName
								.startsWith(SSimSCPlugin.AUXILIARY_VARIABLE_TAG)) {
							try {
								String statementWithoutAuxiliaryVariableTag = esterelOutputName
										.substring(SSimSCPlugin.AUXILIARY_VARIABLE_TAG
												.length());

								// Insert a "," if not the first statement
								if (activeStatements.length() != 0) {
									activeStatements += ",";
								}

								// Add active statement to string.
								activeStatements += statementWithoutAuxiliaryVariableTag;

							} catch (Exception e) {
							}

						}

					}
				}

				// Then add normal output signals
				for (String outputSignal : outputSignalList) {
					if (esterelOutput.has(outputSignal)) {
						
						// retrieve jsonSignal
						JSONObject jsonSignal = esterelOutput.getJSONObject(outputSignal);
						
						if (jsonSignal.has("value")) {
							Object value = jsonSignal.get("value");
							// valued signals
							returnObj.accumulate(outputSignal,
									JSONSignalValues.newValue(value, true));
						}
						else {
							// pure signals
							returnObj.accumulate(outputSignal,
									JSONSignalValues.newValue(true));
						}
					} else {
						returnObj.accumulate(outputSignal,
								JSONSignalValues.newValue(false));
					}
				}
			} else {
				throw new KiemExecutionException(
						"No S simulation is running", true, null);

			}

			// Finally accumulate all active Statements (activeStatements)
			// under the statementName
			String statementName = this.getProperties()[1].getValue();
			returnObj.accumulate(statementName, activeStatements);

		} catch (IOException e) {
			System.err.println(e.getMessage());
			scExecution.stopExecution();
		} catch (JSONException e) {
			e.printStackTrace();
			scExecution.stopExecution();
		}

		return returnObj;
	}

	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	public boolean isObserver() {
		return true;
	}

	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	public boolean isProducer() {
		return true;
	}

	// -------------------------------------------------------------------------

	@Override
	public KiemProperty[] doProvideProperties() {
		final int nProperties = 3;
		KiemProperty[] properties = new KiemProperty[nProperties];
		KiemPropertyTypeFile compilerFile = new KiemPropertyTypeFile();
		properties[0] = new KiemProperty("Statement Name", "statement");

		properties[1] = new KiemProperty("C-Compiler", compilerFile, "gcc");
		properties[2] = new KiemProperty("Full Debug Mode", true);

		return properties;
	}

	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	public void wrapup() throws KiemInitializationException {
		scExecution.stopExecution();
	}

	// -------------------------------------------------------------------------

	/**
	 * Convert an EMF URI to a Java.net.URI.
	 * 
	 * @param uri
	 *            the uri
	 * @return the java.net. uri
	 * @throws URISyntaxException
	 *             the uRI syntax exception
	 */
	private java.net.URI convertURI(URI uri) throws URISyntaxException {
		IWorkspaceRoot myWorkspaceRoot = ResourcesPlugin.getWorkspace()
				.getRoot();

		IPath path = new Path(uri.toPlatformString(false));
		IFile file = myWorkspaceRoot.getFile(path);
		IPath fullPath = file.getLocation();

		return new java.net.URI(fullPath.toString());
	}

	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	public void doModel2ModelTransform(final KielerProgressMonitor monitor)
			throws KiemInitializationException {
		monitor.begin("S Simulation", 10);

		SSimulationProgressMonitor esterelSimulationProgressMonitor = new SSimulationProgressMonitor(
				monitor, 10);

		File executable = null;
		String compile = "";
		
		try {
			// get active editor
			IEditorPart editorPart = this.getInputEditor();
			if (editorPart == null) {
				throw new KiemInitializationException(
						"No active editor selected!", true, null);
			}

			myModel = (Program) this.getInputModelEObject(editorPart);

			if (myModel == null) {
				throw new KiemInitializationException(
						"Cannot simulate active editor using the S Simulator", true,
						null);
			}

			// Make a copy of the S program in case it was from
			// an active Editor

			URI sOutput = URI.createURI("");
			URI scOutput = URI.createURI("");
			// By default there is no additional transformation necessary
			Program transformedProgram = myModel;
			
			// If 'Full Debug Mode' is turned on then the user wants to have
			// also states visualized.
			// Hence some pre-processing is needed and done by the
			// Esterl2Simulation Xtend2 model transformation
			if (this.getProperties()[3].getValueAsBoolean()) {
				// Try to load synccharts model
				// 'Full Debug Mode' is turned ON
				S2Simulation transform = Guice.createInjector()
						.getInstance(S2Simulation.class);
				transformedProgram = transform.transform2Simulation(myModel);
			}

			// Calculate output path
			FileEditorInput editorInput = (FileEditorInput) editorPart
					.getEditorInput();
			URI input = URI.createPlatformResourceURI(editorInput.getFile()
					.getFullPath().toString(), true);

			sOutput = URI.createURI(input.toString());
			sOutput = sOutput.trimFragment();
			sOutput = sOutput.trimFileExtension()
					.appendFileExtension("simulation.s");
			
			scOutput = URI.createURI(input.toString());
			scOutput = sOutput.trimFragment();
			scOutput = sOutput.trimFileExtension()
					.appendFileExtension("c");

			try {
				// Write out copy/transformation of Esterel program
				Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
				Map<String, Object> m = reg.getExtensionToFactoryMap();
				m.put("daform", new XMIResourceFactoryImpl());
				ResourceSet resSet = new ResourceSetImpl();
				Resource resource = resSet.createResource(sOutput);
				resource.getContents().add(transformedProgram);
				resource.save(Collections.EMPTY_MAP);
			} catch (IOException e) {
				throw new KiemInitializationException(
						"Cannot write output S file.", true, null);
			}

			// Set a random output folder for the compiled files
			String outputFolder = SCExecution.generateRandomTempOutputFolder();
			
			// Genereate SC code
			String scOutputString =	getFileStringFromUri(scOutput);
			S2SCPlugin.generateSCCode(transformedProgram, scOutputString, outputFolder);
			
			// Compile
			scExecution = new SCExecution(outputFolder);
			LinkedList<String> generatedSCFiles = new LinkedList<String>();
			generatedSCFiles.add(scOutputString);
			scExecution.compile(generatedSCFiles);	
		} catch (Exception e) {
			throw new KiemInitializationException(
					"Error compiling S program:\n\n " + e.getMessage() + "\n\n" + compile,
					true, e);
		}
	}
	
	
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public JSONObject doProvideInitialVariables()
			throws KiemInitializationException {
		
		// start execution of compiled program
		if (scExecution.isCompiled()) {
			try {
				scExecution.startExecution();
			} catch (IOException e) {
	    		throw new KiemInitializationException(
	                    "S program could not be started sucessfully.\n\n",
	                    true, e);
			}
		}
		else {
    		throw new KiemInitializationException(
                    "S program was not compiled sucessfully.\n\n",
                    true, null);
		}
		

		if (!scExecution.isStarted()) {
			throw new KiemInitializationException(
					"Error running S program. Compiled simulation does not exist.\n",
					true, null);
		}


		// Build the list of interface output signals
		outputSignalList = new LinkedList<String>();
		JSONObject res = new JSONObject();
		try {
			if (myModel != null && myModel.getSignals() != null) {
				for (Signal signal : myModel.getSignals()) {
					if (signal.isIsInput()) {
						res.accumulate(signal.getName(),
								JSONSignalValues.newValue(false));
					}
					if (signal.isIsOutput()) {
						String signalName = signal.getName();
						if (!signalName
								.startsWith(SSimSCPlugin.AUXILIARY_VARIABLE_TAG)) {
							res.accumulate(signalName,
									JSONSignalValues
											.newValue(false));
							outputSignalList.add(signalName);
						}
					}
				}
			}
		} catch (JSONException e) {
			// ignore
		}
		return res;
	}

	// -------------------------------------------------------------------------

	/**
	 * Checks whether the system is based on windows.
	 * 
	 * @return true, if is windows
	 */
	public static boolean isWindows() {
		String os = System.getProperty("os.name").toLowerCase();
		return (os.indexOf("win") >= 0);
	}

	// -------------------------------------------------------------------------
	// -------------------------------------------------------------------------

	/**
	 * Transform a URI into a file string.
	 *
	 * @param uri the uri
	 * @return the file string from uri
	 */
	protected String getFileStringFromUri(URI uri) {

		IWorkspaceRoot myWorkspaceRoot = ResourcesPlugin.getWorkspace()
				.getRoot();

		IPath path = new Path(uri.toPlatformString(false));
		IFile file = myWorkspaceRoot.getFile(path);

		IPath fullPath = file.getLocation();

		// If we have spaces, try it like this...
		if (fullPath == null
				&& file instanceof org.eclipse.core.internal.resources.Resource) {
			org.eclipse.core.internal.resources.Resource resource = (org.eclipse.core.internal.resources.Resource) file;
			fullPath = resource.getLocalManager().locationFor(resource);
		}

		// Ensure it is absolute
		fullPath.makeAbsolute();

		java.io.File javaFile = new java.io.File(fullPath.toString().replaceAll("%20",
				" "));

		if (javaFile != null) {
			String fileString = javaFile.getAbsolutePath();
			return fileString;
		}

		// Something went wrong, we could not resolve the file location
		return null;
	}		
	
	// -------------------------------------------------------------------------

}
