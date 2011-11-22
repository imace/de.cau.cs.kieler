/*
 * KIELER - Kiel Integrated Environment for Layout Eclipse RichClient
 *
 * http://www.informatik.uni-kiel.de/rtsys/kieler/
 * 
 * Copyright 2010 by
 * + Christian-Albrechts-University of Kiel
 *   + Department of Computer Science
 *     + Real-Time and Embedded Systems Group
 * 
 * This code is provided under the terms of the Eclipse Public License (EPL).
 * See the file epl-v10.html for the license text.
 */
package de.cau.cs.kieler.esterel.cec.sim;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URL;
import java.util.LinkedList;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.model.XtextDocument;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.json.JSONException;
import org.json.JSONObject;
import org.osgi.framework.Bundle;

import de.cau.cs.kieler.core.kexpressions.Input;
import de.cau.cs.kieler.core.kexpressions.InterfaceSignalDecl;
import de.cau.cs.kieler.core.kexpressions.Output;
import de.cau.cs.kieler.core.kexpressions.Signal;
import de.cau.cs.kieler.core.ui.KielerProgressMonitor;
import de.cau.cs.kieler.esterel.cec.CEC;
import de.cau.cs.kieler.kies.esterel.Module;
import de.cau.cs.kieler.kies.esterel.Program;
import de.cau.cs.kieler.sim.kiem.JSONSignalValues;
import de.cau.cs.kieler.sim.kiem.KiemExecutionException;
import de.cau.cs.kieler.sim.kiem.KiemInitializationException;
import de.cau.cs.kieler.sim.kiem.properties.KiemProperty;
import de.cau.cs.kieler.sim.kiem.properties.KiemPropertyTypeFile;
import de.cau.cs.kieler.sim.kiem.ui.datacomponent.DataComponentPlugin;
import de.cau.cs.kieler.sim.kiem.ui.datacomponent.JSONObjectSimulationDataComponent;

/**
 * @author ctr, cmot
 * 
 */
public class DataComponent extends JSONObjectSimulationDataComponent {
	
    // -----------------------------------------------------------------------------
    // -----------------------------------------------------------------------------
	
    class EsterelSimulationProgressMonitor implements ProgressMonitor {

        private KielerProgressMonitor kielerProgressMonitor;
        private int numberOfComponents = 1;
        private int numberOfComponentsDone = 0;

        public EsterelSimulationProgressMonitor(
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
	

	private static final String ESTEREL_LANGUAGE = "de.cau.cs.kieler.kies.Esterel";

	private Program myModel = null;
	private Process process = null;
	private PrintWriter toEsterel = null;
	private BufferedReader fromEsterel = null;
	private BufferedReader error = null;

	private File strlFile = null;
	private File dataFile = null;
	private File simFile = null;

	private LinkedList<String> outputs = null;

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
		if (process == null) {
			throw new KiemExecutionException(
					"No esterel simulation is running", true, null);
		}
		JSONObject out = null;
		try {

			toEsterel.write(jSONObject.toString() + "\n");
			toEsterel.flush();
			while (error.ready()) {
				System.out.print(error.read());
			}

			String receivedMessage = fromEsterel.readLine();
			
			if (receivedMessage != null) {

				// print and delete debug information
				out = new JSONObject(receivedMessage);
				for (String o : outputs) {
					if (!out.has(o)) {
						out.accumulate(o, JSONSignalValues.newValue(false));
					}
				}
			}
			else {
				throw new KiemExecutionException(
						"No esterel simulation is running", true, null);
				
			}
			
			
		} catch (IOException e) {
			System.err.println(e.getMessage());
			process.destroy();
		} catch (JSONException e) {
			e.printStackTrace();
			process.destroy();
		}

		return out;
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
		final int nProperties = 1;
		KiemProperty[] properties = new KiemProperty[nProperties];
		KiemPropertyTypeFile compilerFile = new KiemPropertyTypeFile();
		properties[0] = new KiemProperty("C-Compiler", compilerFile, "gcc");

		return properties;
	}

	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	public void wrapup() throws KiemInitializationException {
		if (process != null) {
			process.destroy();
		}
		boolean ok = true;

		if (strlFile != null && strlFile.exists()) {
			ok &= strlFile.delete();
		}
		if (dataFile != null && dataFile.exists()) {
			ok &= dataFile.delete();
		}
		if (simFile != null && simFile.exists()) {
			ok &= simFile.delete();
		}
		strlFile = null;
		dataFile = null;
		simFile = null;

		if (!ok) {
			throw new KiemInitializationException(
					"Could not delete temp files", false, null);
		}
	}

    // -------------------------------------------------------------------------
	
	private URI compileEsterelToC(final URI strlFile, final File outFile, EsterelSimulationProgressMonitor monitor) throws IOException {
		monitor.subTask("Reading Esterel file");
        InputStream strl = CEC.runSTRL(strlFile);
        monitor.worked(1);
        if (monitor.isCanceled()) { 
        	return null;
        }
		monitor.subTask("Parsing Esterel file");
        InputStream strlxml = CEC.runSTRLXML(strl);
        monitor.worked(1);
        if (monitor.isCanceled()) { 
        	return null;
        }
		monitor.subTask("Expanding Esterel file");
        InputStream expandmodule = CEC.runEXPANDMODULE(strlxml);
        monitor.worked(1);
        if (monitor.isCanceled()) { 
        	return null;
        }
		monitor.subTask("Dismantle Esterel file");
        InputStream dismantle = CEC.runDISMANTLE(expandmodule);
        monitor.worked(1);
        if (monitor.isCanceled()) { 
        	return null;
        }
		monitor.subTask("ASTGRC");
        InputStream astgrc = CEC.runASTGRC(dismantle);
        monitor.worked(1);
        if (monitor.isCanceled()) { 
        	return null;
        }
		monitor.subTask("GRCOPT");
        InputStream grcopt = CEC.runGRCOPT(astgrc);
        monitor.worked(1);
        if (monitor.isCanceled()) { 
        	return null;
        }
		monitor.subTask("GRCPDG");
        InputStream grcpdg = CEC.runGRCPDG(grcopt);
        monitor.worked(1);
        if (monitor.isCanceled()) { 
        	return null;
        }
		monitor.subTask("PDGCCFG");
        InputStream pdgccfg = CEC.runPDGCCFG(grcpdg);
        monitor.worked(1);
        if (monitor.isCanceled()) { 
        	return null;
        }
		monitor.subTask("EEC");
        InputStream eec = CEC.runEEC(pdgccfg);
        monitor.worked(1);
        if (monitor.isCanceled()) { 
        	return null;
        }
		monitor.subTask("SCFGC");
        InputStream scfgc = CEC.runSCFGC(eec);
        monitor.worked(1);
        if (monitor.isCanceled()) { 
        	return null;
        }
		monitor.subTask("Generating C code");
        URI uri = CEC.runCODEGEN(scfgc, outFile);
        monitor.worked(1);
		return uri;
	}
	
    // -------------------------------------------------------------------------
//    private IStatus model2ModelTransform(KielerProgressMonitor monitor)
//            throws KiemInitializationException {
//        try {
//            doModel2ModelTransform(monitor);
//        } catch (Exception e) {
//            monitor.done();
//            e.printStackTrace();
//            transformationCompleted = true;
//            transformationError = true;
//            return new Status(IStatus.ERROR, DataComponentPlugin.PLUGIN_ID,
//                    "Model transformation failed.", e);
//        }
//        monitor.done();
//        transformationCompleted = true;
//        transformationError = false;
//        return new Status(IStatus.OK, DataComponentPlugin.PLUGIN_ID, IStatus.OK, null, null);
//    }
    
    
    public void doModel2ModelTransform(final KielerProgressMonitor monitor)
            throws KiemInitializationException {
        monitor.begin("Esterel Simulation", 10);
    	
    	EsterelSimulationProgressMonitor esterelSimulationProgressMonitor = new EsterelSimulationProgressMonitor(monitor, 10);
    	
		File executable = null;
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
						"Cannot simulate active editor using the CEC", true,
						null);
			}

			FileEditorInput input = (FileEditorInput) editorPart.getEditorInput();

			// compile Esterel to C
			URL output = this.compileEsterelToC(input.getURI(), CEC.getDefaultOutFile(), esterelSimulationProgressMonitor).toURL();
			strlFile = new File(output.getPath());
			// generate data.c
			URL data = generateData();
			dataFile = new File(data.getPath());

			// compile C code
			Bundle bundle = Platform
					.getBundle("de.cau.cs.kieler.esterel.cec.sim");

			URL bundleLocation = FileLocator.toFileURL(FileLocator.find(bundle,
					new Path("simulation"), null));

			executable = File.createTempFile("sim", "");
			String compiler = (getProperties()[1]).getValue();
			String compile = compiler + " " + output.getPath() + " "
					+ data.getPath() + " " + bundleLocation.getPath()
					+ "cJSON.c " + "-I " + bundleLocation.getPath() + " "
					+ "-lm -o " + executable;

			if (isWindows()) {
				executable = File.createTempFile("sim", ".exe");
				compile = compiler + " " + output.getPath().substring(1) + " "
						+ data.getPath().substring(1) + " "
						+ bundleLocation.getPath().substring(1) + "cJSON.c "
						+ "-I " + bundleLocation.getPath().substring(1) + " "
						+ "-lm -o " + executable;
			}

			simFile = executable;

			process = Runtime.getRuntime().exec(compile);
			InputStream stderr = process.getErrorStream();
			InputStreamReader isr = new InputStreamReader(stderr);
			BufferedReader br = new BufferedReader(isr);
			String line = null;
			StringBuilder errorString = new StringBuilder();
			while ((line = br.readLine()) != null) {
				errorString.append("\n" + line);

			}

			int exitValue = process.waitFor();

			if (exitValue != 0) {
				throw new KiemInitializationException("could not compile",
						true, new Exception(errorString.toString()));
			}

		} catch (IOException e) {
			throw new KiemInitializationException(
					"Error compiling Esterel file:\n\n" + e.getMessage(), true, e);
		} catch (InterruptedException e) {
			throw new KiemInitializationException(
					"Error compiling Esterel file:\n\n " + e.getMessage(),
					true, e);
		}
    }
	
    // -------------------------------------------------------------------------
	
	
	@Override
	public JSONObject doProvideInitialVariables()
			throws KiemInitializationException {
		
		
		try {
			// run
			String executablePath = simFile.getPath();
			process = Runtime.getRuntime().exec(executablePath);

			toEsterel = new PrintWriter(new OutputStreamWriter(
					process.getOutputStream()));
			fromEsterel = new BufferedReader(new InputStreamReader(
					process.getInputStream()));
			error = new BufferedReader(new InputStreamReader(
					process.getErrorStream()));

		} catch (IOException e) {
			throw new KiemInitializationException(
					"Error running Esterel file:\n\n" + e.getMessage(), true, e);
		}

		outputs = new LinkedList<String>();
		JSONObject res = new JSONObject();
		try {
			if (myModel != null) {
				for (Module mod : myModel.getModules()) {
					for (InterfaceSignalDecl sig : mod.getInterface()
							.getIntSignalDecls()) {
						if (sig instanceof Input) {
							for (Signal s : sig.getSignals()) {
								res.accumulate(s.getName(),
										JSONSignalValues.newValue(false));
							}
						}
						if (sig instanceof Output) {
							for (Signal s : sig.getSignals()) {
								res.accumulate(s.getName(),
										JSONSignalValues.newValue(false));
								outputs.add(s.getName());
							}
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

	/**
	 * @return
	 * @throws KiemInitializationException
	 */
	private URL generateData() throws KiemInitializationException {
		File data;
		try {
			data = File.createTempFile("data", ".c");
			CSimulationInterfaceGenerator cSimulationInterfaceGenerator = new CSimulationInterfaceGenerator(
					this.getInputEditor());
			cSimulationInterfaceGenerator.execute(data.getPath());
			return data.toURI().toURL();
		} catch (IOException e) {
			throw new KiemInitializationException("Error creating data file",
					true, e);
		} catch (ExecutionException e) {
			throw new KiemInitializationException("Error creating data file",
					true, e);
		}
	}
	
    // -------------------------------------------------------------------------
	
}
