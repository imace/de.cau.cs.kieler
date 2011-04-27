package de.cau.cs.kieler.klots;

import js.common.CLIToolProgressMonitor;
import js.tinyvm.TinyVM;
import js.tinyvm.TinyVMException;
import lejos.nxt.remote.NXTCommand;
import lejos.pc.comm.NXTComm;
import lejos.pc.tools.NXJUpload;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.progress.IProgressConstants;
import org.osgi.framework.Bundle;

import de.cau.cs.kieler.klots.editor.SJEditor;

public class KlotsJob extends Job {
	
	public static final String LINK_JOB = "Linking program";
	public static final String DOWNLOAD_JOB = "Download program";
	public static final String RUN_JOB = "Run program";
	public static final String NO_JOB = "No job";

	// the OS specific file separator char, e.g. '/' or '\'
	private final String OS_FILE_SEPARATOR = System.getProperty("file.separator");
	// the OS specific path separator char, e.g. ':' or ';'
	private final String OS_PATH_SEPARATOR = System.getProperty("path.separator");
	
	private String job = "No job";
	private String projectName = "No project name";
	private String projectPath = "No project path";
	private String fileName = "No file nale";
	private String lejosPath = "No leJOS path";
	private MultiStatus info;
	
	
	
	public KlotsJob(String job, IEditorPart editorPart) {
		super(job);
		
		if(editorPart != null) {
			SJEditor e = (SJEditor) editorPart;
			IFileEditorInput input = (IFileEditorInput)e.getEditorInput();
		    IFile file = input.getFile();
		    fileName = file.getName();
		    fileName = fileName.substring(0, fileName.lastIndexOf("." + KlotsConstants.SJ_FILE_NAME_EXTENSION));
		    IProject activeProject = file.getProject();
		    projectName = activeProject.getName();
		    projectPath = activeProject.getLocation().toOSString();
		    projectPath = projectPath.substring(0, projectPath.lastIndexOf(projectName));
		    
		    Bundle lejosBundle = Platform.getBundle("org.lejos.nxt");
			lejosPath = lejosBundle.getLocation();
			lejosPath = lejosPath.replaceFirst(".*file:", "");
		    System.out.println("%%%%%%%%%%%%%%%%%%>>> org.lejos.nxt LOCATION = >" + lejosPath + "<");
		}
		
		if( !job.equals(KlotsJob.LINK_JOB) && !job.equals(KlotsJob.DOWNLOAD_JOB) && !job.equals(KlotsJob.RUN_JOB) ) {
			this.job = KlotsJob.NO_JOB;
			return;
		}
		this.job = job;
	}
	
	
	private void doJob() {
		if( job.equals(KlotsJob.LINK_JOB) ) {
			performLinkingAction();
		} else if( job.equals(KlotsJob.DOWNLOAD_JOB) ) {
			performDownloadAction();
		} else if( job.equals(KlotsJob.RUN_JOB) ) {
			performRunProgramAction();
		} else if( job.equals(KlotsJob.NO_JOB) ) {
			System.out.println("%%%%%%%%%%%%%%% KLOTS JOB ERROR: No job declared!");
		} else {
			System.err.println("%%%%%%%%%%%%%%% KLOTS JOB FATAL ERROR: No valid job declared!");
		}
	}
	
	
	protected IStatus run(IProgressMonitor monitor) {
		doJob();
		if (isModal(this)) {
			// The progress dialog is still open so just open the message
			showResults();
		} else {
			setProperty(IProgressConstants.KEEP_PROPERTY, Boolean.TRUE);
			setProperty(IProgressConstants.ACTION_PROPERTY, getCompletedAction());
		}
		return Status.OK_STATUS;
	}
	
	
	private void performLinkingAction() {
		setProperty(IProgressConstants.ICON_PROPERTY, KlotsPlugin.imageDescriptorFromPlugin(KlotsPlugin.PLUGIN_ID, "icons/linkIcon.png") );
		try {
			final String[] args = {"--bootclasspath", lejosPath,
					"--writeorder", "LE",
					"--classpath", "\".\"",
					"-v",
					"-cp", projectPath + projectName + OS_FILE_SEPARATOR + "embeddedSJ.jar" + OS_PATH_SEPARATOR +
					projectPath + projectName + OS_FILE_SEPARATOR + "bin",
					"." + OS_FILE_SEPARATOR + "examples" + OS_FILE_SEPARATOR + fileName,
					"-o", projectPath + projectName + OS_FILE_SEPARATOR + "bin" + OS_FILE_SEPARATOR + fileName + ".nxj"};
			final TinyVM link = new TinyVM();
			link.addProgressMonitor(new CLIToolProgressMonitor());
			link.start( args );
			info = new MultiStatus(KlotsPlugin.PLUGIN_ID, 0, "Embedded SJ program " + fileName + " built successfully!", null);
			info.add(new Status(IStatus.INFO, KlotsPlugin.PLUGIN_ID, 0, ">OK<", null));
		} catch (TinyVMException e) {
			e.printStackTrace();
			e.printStackTrace();
			info = new MultiStatus(KlotsPlugin.PLUGIN_ID, 1, "Error while trying to build Embedded SJ program " + fileName + "!", null);
			info.add(new Status(IStatus.ERROR, KlotsPlugin.PLUGIN_ID, 1, e.getMessage(), null));
		}
	}
	
	
	private void performDownloadAction() {
		setProperty(IProgressConstants.ICON_PROPERTY, KlotsPlugin.imageDescriptorFromPlugin(KlotsPlugin.PLUGIN_ID, "icons/downloadIcon.png") );
		String[] args = {"-b", projectPath + projectName + OS_FILE_SEPARATOR + "bin" + OS_FILE_SEPARATOR + fileName + ".nxj"};
		NXJUpload up = new NXJUpload();
		try {
			up.run(args);
			info = new MultiStatus(KlotsPlugin.PLUGIN_ID, 0, "Embedded SJ program " + fileName + " downloaded successfully!", null);
			info.add(new Status(IStatus.INFO, KlotsPlugin.PLUGIN_ID, 0, ">OK<", null));
		} catch (Exception le) {
			le.printStackTrace();
			info = new MultiStatus(KlotsPlugin.PLUGIN_ID, 1, "Error while trying to download Embedded SJ program " + fileName + "!", null);
			info.add(new Status(IStatus.ERROR, KlotsPlugin.PLUGIN_ID, 1, le.getMessage(), null));
		}
	}
	
	
	private void performRunProgramAction() {
		setProperty(IProgressConstants.ICON_PROPERTY, KlotsPlugin.imageDescriptorFromPlugin(KlotsPlugin.PLUGIN_ID, "icons/runProgramIcon.png") );
		NXTCommand nxtCommand = NXTCommand.getSingleton();
		try {
			NXTComm nxtComm = NXTCommunicator.getInstance().getNXTComm();
			nxtCommand.setNXTComm(nxtComm);
			nxtCommand.startProgram(fileName + ".nxj");
			// must close low level transmission in order to be able to start a high level transmission
			NXTCommunicator.getInstance().closeTransmission(false);
			String msg = NXTCommunicator.getInstance().receiveMessage().toString();
			if( msg.startsWith("[{" + KlotsConstants.STANDALONE_PROGRAM_MODE_COMMAND_KEY) ) {
				NXTCommunicator.getInstance().sendMessage(KlotsConstants.STANDALONE_PROGRAM_MODE_COMMAND_KEY);
				RemotePrintReceiver printer = new RemotePrintReceiver(NXTCommunicator.getInstance());
				printer.start();
			}
			info = new MultiStatus(KlotsPlugin.PLUGIN_ID, 0, fileName + " finished successfully!", null);
			info.add(new Status(IStatus.INFO, KlotsPlugin.PLUGIN_ID, 0, ">OK<", null));
		} catch (Exception le) {
			le.printStackTrace();
			info = new MultiStatus(KlotsPlugin.PLUGIN_ID, 1, "Error while trying to start Embedded SJ program " + fileName + "!", null);
			info.add(new Status(IStatus.ERROR, KlotsPlugin.PLUGIN_ID, 1, le.getMessage(), null));
			//ErrorDialog.openError(null, "KLOTS", null, info);
		}
	}
	
	
	private boolean isModal(Job job) {
		Boolean isModal = (Boolean)job.getProperty(IProgressConstants.PROPERTY_IN_DIALOG);
		if( isModal == null ) {
			return false;
		}
		return isModal.booleanValue();
	}
	
	
	protected void showResults() {
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				getCompletedAction().run();
			}
		});
	}
	
	
	private Action getCompletedAction() {
		return new Action() {
			public void run() {
				ErrorDialog.openError(null, "KLOTS", null, info);
			}
		};
	}

	
}
