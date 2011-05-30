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

import java.io.IOException;
import lejos.pc.comm.NXTCommException;
import lejos.pc.comm.NXTCommFactory;
import lejos.pc.comm.NXTConnector;
import lejos.pc.comm.NXTInfo;
import lejos.pc.comm.NXTSamba;
import lejos.pc.tools.NXJFlashUI;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.ProgressBar;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.osgi.framework.Bundle;


/***
 * GUI application to write the leJOS Virtual Machine and Menu system to the NXT Flash. 
 * This Eclipse SWT adapted implementation is based on Roger Glassey original Swing code
 * and on Andy Shaw original command line code.
 * 
 * @author ybe
 */
public class NXTFirmwareFlasher extends ApplicationWindow {
    
    /** */
    public static final int DEFAULT_WIDTH = 400;
    /** */
    public static final int DEFAULT_HEIGHT = 550;
    
    private Button flashButton;
    private Text textArea;
    private Label progBarLabel;
    private ProgressBar progBar;
    private Shell parentShell;
    private Flasher flasher;
    
    
    
    /**
     * Constructor.
     * 
     * @param parent 
     */
    public NXTFirmwareFlasher(final Composite parent) {
        super(parent.getShell());
        parentShell = parent.getShell();
        flasher = new Flasher("Flashing NXT firmware");
    }

    
    
    /**
     * Runs the application.
     * @param button 
     */
    public void run(final Button button) {
        button.setEnabled(false);
        
        // Don't return from open() until window closes
        setBlockOnOpen(true);
        // Open the main window
        open();
        
        button.setEnabled(true);
    }

    
    
    /**
     * Configures the shell.
     * 
     * @param shell
     *            the shell
     */
    protected void configureShell(final Shell shell) {
        super.configureShell(shell);
        // Set the title bar text and the size
        shell.setText("Flash  leJOS NXJ  Firmware");
        shell.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }

    
    
    /**
     * Creates the main window's contents.
     * 
     * @param parent
     *            the main window
     * @return Control
     */
    protected Control createContents(final Composite parent) {
        Composite composite = new Composite(parent, SWT.NONE);
        composite.setLayout(new GridLayout(1, true));
        
        // Create the Start button
        flashButton = new Button(composite, SWT.PUSH);
        flashButton.setText(" Flash leJOS NXJ Firmware ");
        flashButton.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        // Display a Confirmation dialog
        flashButton.addSelectionListener(new SelectionListener() {
            public void widgetSelected(final SelectionEvent event) {
                if (flashButton.isEnabled()) {
                    flashButton.setEnabled(false);
                    flasher.setSystem(true);
                    flasher.schedule();
                }
            }
            public void widgetDefaultSelected(final SelectionEvent e) {
                // do nothing
            }
        });

        // Create the progress label on top of the text box
        Label progressLabel = new Label(composite, SWT.NONE);
        progressLabel.setText("Progress Log");
        progressLabel.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        
        // Create the big text box for the message text
        textArea = new Text(composite, SWT.MULTI | SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL);
        textArea.setLayoutData(new GridData(GridData.FILL_BOTH));

        // Create the progress label on top of the progress bar
        progBarLabel = new Label(composite, SWT.CENTER);
        progBarLabel.setText(" ");
        progBarLabel.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        
        // Create the progress bar
        progBar = new ProgressBar(composite, SWT.SMOOTH);
        progBar.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        
        return composite;
    }
    
 
    
    // ######################################################################
    // ######################################################################
    
    
    
    /**
     * Inner class to do the real work.
     */
    private class Flasher extends Job implements NXJFlashUI {
        
        private boolean flashExceptionOccured = false;
        private NXTFlashUpdate updater = new NXTFlashUpdate(this);
        
    
        
        public Flasher(final String name) {
            super(name);
        }

        
        
        public void message(final String str) {
            textArea.append(str + "\n");
        }

        
        
        public void progress(final String str, final int percent) {
            if (str.length() <= 0) {
                progBarLabel.setText(" ");
            } else {
                progBarLabel.setText(str);
            }
            progBar.setSelection(percent);
        }

        
        
        /**
         * {@inheritDoc}
         */
        public IStatus run(final IProgressMonitor monitor) {
            System.out.println("ÖÖÖÖÖÖÖÖÖÖÖÖÖ FIRMWARE FLASH PROCESS STARTED ÖÖÖÖÖÖÖÖÖÖÖÖÖ");
            Display.getDefault().syncExec(new Runnable() {
                public void run() {

                    //                wait for NXT to be connected
                    // ----------------------------------------------------------
                    MessageDialog.openInformation(parentShell, "",
                    "Click OK when your NXT is turned on and connected ");
                    // ----------------------------------------------------------
                    
                    //           get NXT firmware images (VM and menu)
                    // ----------------------------------------------------------
                    try {
                        String vmPath = KlotsConstants.KLOTS_TEMPLATES_FOLDER_NAME + Path.SEPARATOR
                                + KlotsConstants.KLOTS_TEMPLATES_LEJOS_FOLDER_NAME + Path.SEPARATOR
                                + KlotsConstants.KLOTS_TEMPLATES_LEJOS_FIRMWARE_FILE_NAME;
                        String menuPath = KlotsConstants.KLOTS_TEMPLATES_FOLDER_NAME + Path.SEPARATOR
                                + KlotsConstants.KLOTS_TEMPLATES_LEJOS_FOLDER_NAME + Path.SEPARATOR
                                + KlotsConstants.KLOTS_TEMPLATES_LEJOS_FIRMWARE_MENU_FILE_NAME;
                        
                        Bundle klotsBundle = Platform.getBundle("de.cau.cs.kieler.klots");
                        String klotsPath = klotsBundle.getLocation().replaceFirst(".*file:", "");
                        System.out.println("%%%%%%%%>>> de.cau.cs.kieler.klots relative LOCATION = >"
                                + klotsPath + "<");
                        String eclipseInstallLocation =
                            Platform.getInstallLocation().getURL().getPath();
                        // test if eclipse is a working instance or installed one
                        if (klotsPath.endsWith(".jar")) {
                            System.out.println("%%%%%%%%>>> eclipse install LOCATION = >"
                                    + eclipseInstallLocation + "<");
                            klotsPath = eclipseInstallLocation + klotsPath;
                        }
                        System.out.println("%%%%%%%%>>> final LOCATION = >" + klotsPath + "<");
                        
                        byte[] memoryImage = updater.createFirmwareImage(
                                vmPath, menuPath, klotsPath);
                        // ------------------------------------------------------

                        //   wait for user to confirm format NXT memory process
                        // ------------------------------------------------------
                        boolean formatNXTMemory = MessageDialog.openConfirm(parentShell,
                                "Clear memory first", "Do you want to erase all NXT files now?");
                        // ------------------------------------------------------
                        
                        //                    flash NXT firmware
                        // ------------------------------------------------------
                        byte[] fs = null;
                        if (formatNXTMemory) {
                            fs = updater.createFilesystemImage();
                        }
                        NXTSamba nxt = openDevice();
                        if (nxt != null) {
                            updater.updateDevice(nxt, memoryImage, fs, true, true, true);
                        }
                        // ------------------------------------------------------
                        
                    //                handle exception occurred
                    // ----------------------------------------------------------
                    } catch (final Exception e) {
                        MessageDialog.openError(parentShell, "Fatal Error",
                                "Bad news: An error has occurred " + e);
                        e.printStackTrace();
                        flashExceptionOccured = true;
                        flashButton.setEnabled(true);
                        return;
                    }
                    // ----------------------------------------------------------
                 
                    flashButton.setEnabled(true);
                } // end run()
            }); // end synchExec()
            if (flashExceptionOccured) {
                return Status.CANCEL_STATUS;
            }
            return Status.OK_STATUS;
        }

        
        
        /**
         * Locate and open an NXT device ready for the firmware to be updated.
         * First we look for devices that are already in SAM-BA mode. If we do
         * not find any we look for devices in normal mode and attempt to
         * re-boot them into SAM-BA mode.
         * 
         * @return
         */
        NXTSamba openDevice() throws NXTCommException, IOException {
            // First look to see if there are any devices already in SAM-BA mode
            NXTSamba samba = updater.openSambaDevice(0);
            if (samba == null) {
                NXTInfo[] nxts;
                textArea.append("\nNo devices in firmware update mode were found.\n"
                        + "Searching for other NXT devices.\n");
                NXTConnector conn = new NXTConnector();
                nxts = conn.search(null, null, NXTCommFactory.USB);
                if (nxts.length <= 0) {
                    MessageDialog.openWarning(parentShell, "Warning",
                            "No NXT found. \nPlease check that it's turned on and connected.");
                    return null;
                }
                textArea.append("Found " + nxts[0].name + " Bluetooth address  "
                        + nxts[0].deviceAddress + "\n\n");
                // Force into firmware update mode.
                updater.resetDevice(nxts[0]);
                final int timeout = 30000;
                samba = updater.openSambaDevice(timeout);
            }
            if (samba == null) {
                System.err.println("Unable to locate the device in firmware update mode.\n"
                        + "Please place the device in reset mode and try again.");
            }
            return samba;
        }
        
        
        
//        /**
//         * @param relativeFilePath 
//         * @return String 
//         * @throws Exception 
//         */
//        private String ensureFile(final String fileName, final String relativeFilePath) {
//            Bundle klotsBundle = Platform.getBundle("de.cau.cs.kieler.klots");
//            String klotsPath = klotsBundle.getLocation().replaceFirst(".*file:", "");
//            System.out.println("%%%%%%%%%%%%%%%>>> de.cau.cs.kieler.klots relative LOCATION = >"
//                    + klotsPath + "<");
//            String eclipseInstallLocation = Platform.getInstallLocation().getURL().getPath();
//            // test if eclipse is a working instance or installed one
//            if (klotsPath.endsWith(".jar")) {
//                System.out.println("%%%%%%%%%%%%%%%>>> eclipse install LOCATION = >"
//                        + eclipseInstallLocation + "<");
//                klotsPath = eclipseInstallLocation + klotsPath;
//            } else {
//                return klotsPath + relativeFilePath;
//            }
//            System.out.println("%%%%%%%%%%%%%%%>>> final LOCATION = >" + klotsPath + "<");
//            
//            String fullPath = eclipseInstallLocation + fileName;
//            FileInputStream fin = null;
//            JarInputStream jin = null;
//            FileOutputStream os = null;
//            try {
//                fin = new FileInputStream(klotsPath);
//                jin = new JarInputStream(fin);
//                ZipEntry entry;
//                while ((entry = jin.getNextEntry()) != null) {
//                    if (entry.getName().equals(relativeFilePath)) {
//                        break;
//                    }
//                }
//                File f = new File(fullPath);
//                os = new FileOutputStream(f);
//                final int byteArrayLen = 512;
//                byte[] b = new byte[byteArrayLen];
//                int len;
//                while ((len = jin.read(b, 0, b.length)) != -1) {
//                    os.write(b, 0, len);
//                }
//            } catch (Exception e) {
//                MessageDialog.openError(parentShell, "Fatal Error",
//                        "Bad news: An error has occurred " + e);
//                e.printStackTrace();
//            } finally {
//                try {
//                    if (os != null) {
//                        os.close();
//                    }
//                    if (jin != null) {
//                        jin.closeEntry();
//                        jin.close();
//                    }
//                    if (fin != null) {
//                        fin.close();
//                    }
//                } catch (Exception finallyExc) {
//                    finallyExc.printStackTrace();
//                }
//            }
//            return fullPath;
//        } // end method ensureFile()

    } // end inner class Flasher
    
}
