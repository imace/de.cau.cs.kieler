/*
 * KIELER - Kiel Integrated Environment for Layout Eclipse Rich Client
 *
 * http://www.informatik.uni-kiel.de/rtsys/kieler/
 * 
 * Copyright 2011 by
 * + Christian-Albrechts-University of Kiel
 *   + Department of Computer Science
 *     + Real-Time and Embedded Systems Group
 * 
 * This code is provided under the terms of the Eclipse Public License (EPL).
 * See the file epl-v10.html for the license text.
 */
package de.cau.cs.kieler.klots.util;

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
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.progress.IProgressConstants;
import org.osgi.framework.Bundle;

import de.cau.cs.kieler.klots.KlotsPlugin;
import de.cau.cs.kieler.klots.editor.KlotsEditor;
import de.cau.cs.kieler.klots.preferences.KlotsPreferenceConstants;


/**
 * @author root
 *
 */
public class KlotsJob extends Job {

    /**
     * 
     */
    public static final String LINK_JOB = "Linking program";
    /**
     * 
     */
    public static final String DOWNLOAD_JOB = "Downloading program";
    /**
     * 
     */
    public static final String RUN_JOB = "Running program";
    /**
     * 
     */
    public static final String NO_JOB = "No job";

    // the OS specific file separator char, e.g. '/' or '\'
    private static final String OS_FILE_SEPARATOR = System.getProperty("file.separator");
    // the OS specific path separator char, e.g. ':' or ';'
    private static final String OS_PATH_SEPARATOR = System.getProperty("path.separator");

    private String jobType = "No job";
    private String projectName = "No project name";
    private String projectPath = "No project path";
    private String fileRelativePath = "No file relative path";
    private String fileName = "No file name";
    private String lejosPath = "No leJOS path";
    private KlotsEditor editor;
    private MultiStatus info;
    private boolean isSJProject = false;



    /**
     * @param job 
     * @param editorPart 
     */
    public KlotsJob(final String job, final IEditorPart editorPart) {
        super(job);

        if (editorPart != null) {
            editor = (KlotsEditor) editorPart;
            IFileEditorInput input = (IFileEditorInput) editor.getEditorInput();
            IFile file = input.getFile();
            fileName = file.getName();
            fileName = fileName.substring(
                    0, fileName.lastIndexOf("." + KlotsConstants.SJ_FILE_NAME_EXTENSION));
            IProject activeProject = file.getProject();
            projectName = activeProject.getName();
            System.out.println("HHHHHHHH>>> project name is: >" + projectName + "<");
            projectPath = activeProject.getLocation().toOSString();
            projectPath = projectPath.substring(0, projectPath.lastIndexOf(projectName));
            System.out.println("HHHHHHHH>>> project path is: >" + projectPath + "<");
            fileRelativePath = file.getProjectRelativePath().toOSString().replaceFirst("src", "");
            int fileNameIndex = fileRelativePath.lastIndexOf(file.getName());
            fileRelativePath = fileRelativePath.substring(0, fileNameIndex);
            System.out.println("HHHHHHHH>>> file final relative path is: >" + fileRelativePath + "<");
            
            isSJProject = activeProject.exists(
                    new Path(KlotsConstants.KLOTS_TEMPLATES_EMBEDDED_SJ_JAR_NAME));
            System.out.println("(:)(:)(:)(:)(:)(:)(:)(:)(:) CHECKING IF THE PROJECT IS A SJ PROJECT? -> "
                    + (isSJProject ? "YES!" : "NO!") + " (:)(:)(:)(:)(:)(:)(:)(:)(:)");

            // print some eclipse file system information for easier debugging
            System.out.println("%%%%%%%%%%%%%%%>>> eclipse instance LOCATION = >"
                    + Platform.getInstanceLocation().getURL().getPath() + "<");
            System.out.println("%%%%%%%%%%%%%%%>>>  eclipse install LOCATION = >"
                    + Platform.getInstallLocation().getURL().getPath() + "<");
            
            // get 'org.lejos.classes' bundle from the 'org.lejos.classes' plugin activator
            //Bundle lejosBundle = LejosClassesBundlePluginActivator.getDefault().getBundle();
            Bundle lejosBundle = Platform.getBundle("org.lejos.classes");
            lejosPath = lejosBundle.getLocation().replaceFirst(".*file:", "");
            System.out.println("%%%%%%%%%%%%%%%>>> org.lejos.nxt relative LOCATION = >"
                    + lejosPath + "<");
            // test if eclipse is a working instance or installed one
            if (lejosPath.endsWith(".jar")) {
                String eclipseInstallLocation = Platform.getInstallLocation().getURL().getPath();
                System.out.println("%%%%%%%%%%%%%%%>>> eclipse install LOCATION = >"
                        + eclipseInstallLocation + "<");
                lejosPath = eclipseInstallLocation + lejosPath;
            } else {
                lejosPath += "bin" + OS_FILE_SEPARATOR;
            }
            System.out.println("%%%%%%%%%%%%%%%>>> org.lejos.nxt final LOCATION = >" + lejosPath + "<");
            
        }

        if (
             !job.equals(KlotsJob.LINK_JOB)
             && !job.equals(KlotsJob.DOWNLOAD_JOB)
             && !job.equals(KlotsJob.RUN_JOB)
            ) {
            this.jobType = KlotsJob.NO_JOB;
            return;
        }
        this.jobType = job;
    }


    
    private void doJob() {
        if (jobType.equals(KlotsJob.LINK_JOB)) {
            performLinkingAction();
        } else if (jobType.equals(KlotsJob.DOWNLOAD_JOB)) {
            performDownloadAction();
        } else if (jobType.equals(KlotsJob.RUN_JOB)) {
            performRunProgramAction();
        } else if (jobType.equals(KlotsJob.NO_JOB)) {
            System.out.println("%%%%%%%%%%%%%%% KLOTS JOB ERROR: No job declared!");
        } else {
            System.err.println("%%%%%%%%%%%%%%% KLOTS JOB FATAL ERROR: No valid job declared!");
        }
    }


    
    /**
     * {@inheritDoc}
     */
    protected IStatus run(final IProgressMonitor monitor) {
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
        setProperty(IProgressConstants.ICON_PROPERTY,
                KlotsPlugin.imageDescriptorFromPlugin(KlotsPlugin.PLUGIN_ID, "icons/linkIcon.png"));
        
        // TODO: see if possible to remove 'embeddedSJ.jar' from project's directory
        // and give a path to the 'embeddedSJ.jar' file in 'sj_templates' or even better
        // give a path to the 'de.cau.cs.kieler.sj' bundle
        // and to the 'de.cau.cs.kieler.klots.sj.embedded' package in the KLOTS plugin
        // (this package is perhaps to be placed in a separate plugin)
        // CHECKSTYLEOFF LineLength
        final String[] args = {"--bootclasspath", lejosPath,
                "--writeorder", "LE",
                "--classpath", "\".\"",
                "-v",
                "-cp", projectPath + projectName + OS_FILE_SEPARATOR + KlotsConstants.KLOTS_TEMPLATES_EMBEDDED_JAVA_JAR_NAME + OS_PATH_SEPARATOR
                + (isSJProject ? projectPath + projectName + OS_FILE_SEPARATOR + KlotsConstants.KLOTS_TEMPLATES_EMBEDDED_SJ_JAR_NAME + OS_PATH_SEPARATOR : "")
                + projectPath + projectName + OS_FILE_SEPARATOR + "bin",
                //"." + OS_FILE_SEPARATOR + "examples" + OS_FILE_SEPARATOR + fileName,
                "." + fileRelativePath + fileName,
                "-o", projectPath + projectName + OS_FILE_SEPARATOR + "bin" + OS_FILE_SEPARATOR + fileName + ".nxj"};
        // CHECKSTYLEON LineLength
        
        final TinyVM link = new TinyVM();
        StringBuffer buf = new StringBuffer();
        link.addProgressMonitor(new LinkProgramProgressMonitor(buf));
        try {
            link.start(args);
            info = new MultiStatus(KlotsPlugin.PLUGIN_ID, 0,
                    "Embedded SJ program " + fileName + " built successfully!", null);
            String[] output = buf.toString().split(KlotsConstants.SEARATOR_STRING);
            buf = null;
            for (String s : output) {
                info.add(new Status(IStatus.INFO, KlotsPlugin.PLUGIN_ID, 0, s, null));
            }
        } catch (TinyVMException e) {
            e.printStackTrace();
            e.printStackTrace();
            info = new MultiStatus(KlotsPlugin.PLUGIN_ID, 1,
                    "Error while trying to build Embedded SJ program " + fileName + "!", null);
            info.add(new Status(IStatus.ERROR, KlotsPlugin.PLUGIN_ID, 1, e.getMessage(), null));
            String[] output = buf.toString().split(KlotsConstants.SEARATOR_STRING);
            buf = null;
            for (String s : output) {
                info.add(new Status(IStatus.INFO, KlotsPlugin.PLUGIN_ID, 0, s, null));
            }
        }
    }


    
    private void performDownloadAction() {
        setProperty(IProgressConstants.ICON_PROPERTY,
                KlotsPlugin.imageDescriptorFromPlugin(KlotsPlugin.PLUGIN_ID, "icons/downloadIcon.png"));
        // *************************************************************************************** //
//        String connType;
//        if (KlotsPlugin.getDefault().getPreferenceStore()
//                .getString(KlotsPreferenceConstants.P_CONNECTION_CONNECTION_TYPE)
//                .equals(KlotsPreferenceConstants.P_CONNECTION_PROTOCOL_USB)) {
//            connType = "-u";
//        } else {
//            connType = "-b";
//        }
        
//        String[] args = {connType, projectPath + projectName + OS_FILE_SEPARATOR + "bin"
//                + OS_FILE_SEPARATOR + fileName + ".nxj"};
        // *************************************************************************************** //
        String argsStr = "";
        if (KlotsPlugin.getDefault().getPreferenceStore()
                .getString(KlotsPreferenceConstants.P_CONNECTION_CONNECTION_TYPE)
                .equals(KlotsPreferenceConstants.P_CONNECTION_PROTOCOL_USB)) {
            argsStr = "-u;";
        } else {
            argsStr = "-b;";
            if (KlotsPlugin.getDefault().getPreferenceStore().getBoolean(
                    KlotsPreferenceConstants.P_CONNECTION_CONNECT_TO_BRICK_ADDRESS)) {
                argsStr += "-d;" + KlotsPlugin.getDefault().getPreferenceStore()
                .getString(KlotsPreferenceConstants.P_CONNECTION_CONNECTION_BRICK_ADDRESS) + ";";
            }
            if (KlotsPlugin.getDefault().getPreferenceStore().getBoolean(
                    KlotsPreferenceConstants.P_CONNECTION_CONNECT_TO_NAMED_BRICK)) {
                argsStr += "-n;" + KlotsPlugin.getDefault().getPreferenceStore()
                .getString(KlotsPreferenceConstants.P_CONNECTION_CONNECTION_BRICK_NAME) + ";";
            }
        }
        argsStr += projectPath + projectName + OS_FILE_SEPARATOR + "bin" + OS_FILE_SEPARATOR
                + fileName + ".nxj";
        
        String[] args = argsStr.split(";");
        // *************************************************************************************** //
        
        NXJUpload up = new NXJUpload();
        StringBuffer buf = new StringBuffer();
        up.addLogListener(new CommandLogListener(buf));
        try {
            up.run(args);
            info = new MultiStatus(KlotsPlugin.PLUGIN_ID, 0,
                    "Embedded SJ program " + fileName + " downloaded successfully!", null);
            String[] output = buf.toString().split(KlotsConstants.SEARATOR_STRING);
            buf = null;
            for (String s : output) {
                info.add(new Status(IStatus.INFO, KlotsPlugin.PLUGIN_ID, 0, s, null));
            }
        } catch (Exception le) {
            le.printStackTrace();
            String msg = le.getMessage();
            info = new MultiStatus(KlotsPlugin.PLUGIN_ID, 1,
                    "Error while trying to download Embedded SJ program " + fileName + "!", null);
            String[] output = buf.toString().split(KlotsConstants.SEARATOR_STRING);
            buf = null;
            for (String s : output) {
                info.add(new Status(IStatus.INFO, KlotsPlugin.PLUGIN_ID, 1, s, null));
            }
            info.add(new Status(IStatus.ERROR, KlotsPlugin.PLUGIN_ID, 1, msg, null));
            if (msg.contains("No NXT found")) { 
                msg = "Are the connection preferences set up properly?";
                info.add(new Status(IStatus.ERROR, KlotsPlugin.PLUGIN_ID, 1, msg, null));
            }
        }
    }


    
    private void performRunProgramAction() {
        setProperty(IProgressConstants.ICON_PROPERTY,
                KlotsPlugin.imageDescriptorFromPlugin(KlotsPlugin.PLUGIN_ID,
                        "icons/runProgramIcon.png"));
        NXTCommand nxtCommand = NXTCommand.getSingleton();
        try {
            NXTComm nxtComm = NXTCommunicator.getInstance().getNXTComm();
            nxtCommand.setNXTComm(nxtComm);
            nxtCommand.startProgram(fileName + ".nxj");
            // must close low level transmission in order to be able to start a high level transmission
            // FIXME: use nxtCommand.close() instead???
            NXTCommunicator.getInstance().closeTransmission(false);
            if (editor instanceof KlotsEditor) {
                editor.initSJContent();
                if (!editor.hasSJContent()) {
                    showConnectDialog();
                }
            }
            info = new MultiStatus(KlotsPlugin.PLUGIN_ID, 0, fileName + " is running!", null);
            info.add(new Status(IStatus.INFO, KlotsPlugin.PLUGIN_ID, 0, ">OK<", null));
            
        } catch (Exception le) {
            le.printStackTrace();
            info = new MultiStatus(KlotsPlugin.PLUGIN_ID, 1,
                    "Error while trying to start Embedded SJ program " + fileName + "!", null);
            info.add(new Status(IStatus.ERROR, KlotsPlugin.PLUGIN_ID, 1, le.getMessage(), null));
        }
    }


    
    private boolean isModal(final Job job) {
        Boolean isModal = (Boolean) job.getProperty(IProgressConstants.PROPERTY_IN_DIALOG);
        if (isModal == null) {
            return false;
        }
        return isModal.booleanValue();
    }


    
    private void showResults() {
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
    
    
    
    private void showConnectDialog() {
        Display.getDefault().asyncExec(new Runnable() {
            public void run() {
                getConnectAction().run();
            }
        });
    }
    
    
    
    private Action getConnectAction() {
        return new Action() {
            public void run() {
                boolean connect = MessageDialog.openQuestion(editor.getEditorSite().getShell(),
                        "KLOTS", "Connect to NXT?\n(Please make this choice on the NXT first.)");
                if (connect) {
                    NXTCommunicator.getInstance()
                    .sendMessage(KlotsConstants.EMBEDDED_JAVA_PROGRAM_MODE_COMMAND_KEY);
//                    RemotePrintReceiver.init();
                    RemotePrintReceiver.getInstance().start();
                }
            }
        };
    }

}