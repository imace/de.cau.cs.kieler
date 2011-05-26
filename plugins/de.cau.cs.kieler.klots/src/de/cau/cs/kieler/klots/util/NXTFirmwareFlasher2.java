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

import lejos.pc.comm.NXTCommException;
import lejos.pc.comm.NXTCommFactory;
import lejos.pc.comm.NXTConnector;
import lejos.pc.comm.NXTInfo;
import lejos.pc.comm.NXTSamba;
import lejos.pc.tools.NXJFlashUI;
import lejos.pc.tools.NXJFlashUpdate;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import org.eclipse.core.runtime.Platform;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.FormDialog;
import org.eclipse.ui.forms.IFormPart;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.SectionPart;
import org.eclipse.ui.forms.widgets.Section;
import org.osgi.framework.Bundle;

/***
 * GUI application to write the leJOS Virtual Machine and Menu system to the NXT
 * Flash. Based on Roger Glassey original GUI code and Andy Shaw original
 * command line code.
 * 
 * @author ybe
 */
public class NXTFirmwareFlasher2 extends FormDialog {
    
    private static final long serialVersionUID = -6787741534291728860L;
    private static final String OS_FILE_SEPARATOR = System.getProperty("file.separator");
    
    private Composite parent;

    

    /**
     * Creates new form NXJFlashG.
     * @param parent 
     */
    public NXTFirmwareFlasher2(final Composite parentComposite) {
        super(parentComposite.getShell());
        parent = parentComposite;
//        getShell().setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        flasher = new Flasher();
        open();
    }

    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     * @param manform 
     */
    protected void createFormContent(final IManagedForm manform) {
//        setTitle("Install  NXJ  Firmware in  NXT");
//        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        //JPanel p1 = new JPanel();
        Section section = new Section(parent, SWT.CENTER);
        IFormPart p1 = new SectionPart(section);
        goB = new Button(section, SWT.CENTER);
        goB.setText(" Start Program ");
//        add(p1, BorderLayout.NORTH);
        msgPanel = new javax.swing.JPanel();
        msgPanel.setPreferredSize(new Dimension(400, 160));
//        add(msgPanel, BorderLayout.SOUTH);

        progressTxt = new javax.swing.JTextArea();
        progressLabel = new javax.swing.JLabel("Progress Log", SwingConstants.CENTER);
        progressTxt.setColumns(30);
        progressTxt.setRows(70);

        JPanel progress = new JPanel(new BorderLayout());
        progress.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
        progress.setMinimumSize(new Dimension(350, 550));
        progress.add(progressLabel, BorderLayout.NORTH);
        progress.add(progressTxt, BorderLayout.CENTER);

        JPanel progBarPanel = new JPanel(new BorderLayout());
        progBarPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 10));
        progBarPanel.setMinimumSize(new Dimension(300, 50));
        progBarLabel = new javax.swing.JLabel(" ", SwingConstants.CENTER);
        progBar = new javax.swing.JProgressBar(0, 100);
        progBar.setStringPainted(true);
        progBarPanel.add(progBar, BorderLayout.NORTH);
        progBarPanel.add(progBarLabel, BorderLayout.SOUTH);
        progress.add(progBarPanel, BorderLayout.SOUTH);
//        add(progress, BorderLayout.CENTER);

        goB.setText("Start program");
//        goB.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(final java.awt.event.ActionEvent evt) {
//                goBActionPerformed();
//            }
//        });
    }

    
    
    /**
     * 
     */
    private void goBActionPerformed() {
        flasher.start();
    }

    
    
//    /**
//     * @param args the command line arguments
//     */
//    public static void main(final String[] args) {
//        new NXTFirmwareFlasher2().setVisible(true);
//
//    }

    
    
    // ######################################################################
    // ######################################################################
    
    /**
     * Inner class to do the real work.
     */
    private class Flasher extends Thread implements NXJFlashUI {
        
        private NXJFlashUpdate updater = new NXJFlashUpdate(this);

        
        
        public void message(final String str) {
            progressTxt.append(str + "\n");
        }

        
        
        public void progress(final String str, final int percent) {
            if (str.length() <= 0) {
                progBarLabel.setText(" ");
            } else {
                progBarLabel.setText(str);
            }
            progBar.setValue(percent);
        }

        
        
        @Override
        public void run() {
            boolean more = true;
            while (more) {
                JOptionPane.showMessageDialog(msgPanel,
                        "Click OK when your NXT is turned on and connected ");
                try {
                    Bundle klotsBundle = Platform.getBundle("de.cau.cs.kieler.klots");
                    String klotsPath = klotsBundle.getLocation().replaceFirst(".*file:", "");
                    System.out.println("%%%%%%%%%%%%%%%>>> org.lejos.nxt relative LOCATION = >"
                            + klotsPath + "<");
                    // test if eclipse is a working instance or installed one
                    if (klotsPath.endsWith(".jar")) {
                        String eclipseInstallLocation = Platform.getInstallLocation().getURL().getPath();
                        System.out.println("%%%%%%%%%%%%%%%>>> eclipse install LOCATION = >"
                                + eclipseInstallLocation + "<");
                        klotsPath = eclipseInstallLocation + klotsPath;
                    } else {
                        // klotsPath += "bin" + OS_FILE_SEPARATOR;
                    }

                    String vmName = klotsPath + KlotsConstants.KLOTS_TEMPLATES_FOLDER_NAME
                            + OS_FILE_SEPARATOR + KlotsConstants.KLOTS_TEMPLATES_LEJOS_FOLDER_NAME
                            + OS_FILE_SEPARATOR
                            + KlotsConstants.KLOTS_TEMPLATES_LEJOS_FIRMWARE_FILE_NAME;
                    String menuName = klotsPath + KlotsConstants.KLOTS_TEMPLATES_FOLDER_NAME
                            + OS_FILE_SEPARATOR + KlotsConstants.KLOTS_TEMPLATES_LEJOS_FOLDER_NAME
                            + OS_FILE_SEPARATOR
                            + KlotsConstants.KLOTS_TEMPLATES_LEJOS_FIRMWARE_MENU_FILE_NAME;
                    byte[] memoryImage = updater.createFirmwareImage(vmName, menuName, null);

                    boolean format = 0 == JOptionPane.showConfirmDialog(msgPanel,
                            "Do you want to erase all NXT files now?", "Clear memory first",
                            JOptionPane.YES_NO_OPTION);
                    byte[] fs = null;
                    if (format) {
                        fs = updater.createFilesystemImage();
                    }
                    NXTSamba nxt = openDevice();
                    if (nxt != null) {
                        updater.updateDevice(nxt, memoryImage, fs, true, true, true);
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(msgPanel, "Bad news: An error has occurred " + e,
                            "Fatal error ", JOptionPane.ERROR_MESSAGE);
                    // System.exit(1);

                }
                more = 0 == JOptionPane.showConfirmDialog(msgPanel,
                        "Do you want to flash firmware again?", "Question", JOptionPane.YES_NO_OPTION);
            }
            // System.exit(1);
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
                progressTxt.append("\nNo devices in firmware update mode were found.\n"
                        + "Searching for other NXT devices.\n");
                NXTConnector conn = new NXTConnector();
                nxts = conn.search(null, null, NXTCommFactory.USB);
                if (nxts.length <= 0) {
                    JOptionPane.showMessageDialog(msgPanel,
                            "No NXT found. \nPlease check that it's turned on and connected.",
                            "Warning", JOptionPane.WARNING_MESSAGE);
                    return null;
                }
                progressTxt.append("Found " + nxts[0].name + " Bluetooth address  "
                        + nxts[0].deviceAddress + "\n\n");
                // Force into firmware update mode.
                updater.resetDevice(nxts[0]);
                samba = updater.openSambaDevice(30000);
            }
            if (samba == null) {
                System.err.println("Unable to locate the device in firmware update mode.\n"
                        + "Please place the device in reset mode and try again.");
            }
            return samba;
        }

    }

    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Button goB;
    private javax.swing.JPanel msgPanel;
    private javax.swing.JLabel progressLabel;
    private javax.swing.JTextArea progressTxt;
    // End of variables declaration//GEN-END:variables
    private javax.swing.JLabel progBarLabel;
    private javax.swing.JProgressBar progBar;
    private Flasher flasher;
    /** */
    public static final int DEFAULT_WIDTH = 400;
    /** */
    public static final int DEFAULT_HEIGHT = 700;
}
