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
package de.cau.cs.kieler.klots.preferences;

import java.io.IOException;
import lejos.pc.comm.NXTCommFactory;
import lejos.pc.comm.NXTInfo;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;

import de.cau.cs.kieler.klots.KlotsPlugin;
import de.cau.cs.kieler.klots.util.KlotsConstants;
import de.cau.cs.kieler.klots.util.NXTCommunicator;
import de.cau.cs.kieler.klots.util.NXTFirmwareFlasher;


/**
 * This class represents a preference page that is contributed to the
 * Preferences dialog.
 *
 * @author ybe
 */

public class KlotsNXTFlasherPreferencePage extends PreferencePage
                                        implements IWorkbenchPreferencePage, ILabelProvider {
    
    /** The NXT firmware flash button. */
    private Button flashNXTFirmwareButton;
    private final int flashNXTFirmwareButtonWidth = 120;
    
    
    
    /**
     * 
     */
    public KlotsNXTFlasherPreferencePage() {
        super();
        setPreferenceStore(KlotsPlugin.getDefault().getPreferenceStore());
        setDescription("Firmware preferences for the " + KlotsConstants.KLOTS_FULL_NAME);
    }


    
    /**
     * {@inheritDoc}
     */
    @Override
    protected Control createContents(final Composite parent) {
        buildPage(parent);
        return null;
    }
    
    
    /**
     * Creates the field editors. Field editors are abstractions of the common
     * GUI blocks needed to manipulate various types of preferences. Each field
     * editor knows how to save and restore itself.
     * 
     * @param parent 
     */
    public void buildPage(final Composite parent) {
        SelectListener listener = new SelectListener();
        
        Group connectionTypeGroup = new Group(parent, SWT.SHADOW_ETCHED_IN);
        connectionTypeGroup.setText("&Flash NXT firmware");
        connectionTypeGroup.setLayout(new GridLayout(1, true));
        connectionTypeGroup.setLayoutData(new GridData(SWT.FILL, SWT.NONE, true, false));
        // search NXTs button
        flashNXTFirmwareButton = new Button(parent, SWT.NONE);
        flashNXTFirmwareButton.setText("Search for NXTs");
        flashNXTFirmwareButton.setToolTipText("Search for NXTs");
        flashNXTFirmwareButton.addSelectionListener(listener);
        connectionTypeGroup.layout();
        
        // invisible label to fill out unused space
        Label label = new Label(parent, SWT.NONE);
        label.setEnabled(false);
        label.setVisible(false);
        label.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
    }

    
    
    private NXTInfo displayNXTSearchDialog(final String message) {
        ElementListSelectionDialog dialog = new ElementListSelectionDialog(this.getShell(), this);
        dialog.setMultipleSelection(false);
        dialog.setMessage(message);
        dialog.setHelpAvailable(false);
        
        NXTInfo[] nxts = NXTCommunicator.getInstance().searchForNXTs();
        try {
            NXTCommunicator.getInstance().getNXTConnector().close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        String[] elements = new String[nxts.length];
        for (int i = 0; i < nxts.length; i++) {
            elements[i] = nxts[i].name + ", " + nxts[i].deviceAddress + ", "
            + (nxts[i].protocol == NXTCommFactory.USB ? "USB" : "BLUETOOTH");
            System.out.println("XXXXXXXXXX>>>> " + (i + 1) + ". found NXT >" + elements[i] + "<");
        }
        dialog.setElements(elements);
        
        if (dialog.open() == Dialog.OK) {
            Object[] result = dialog.getResult();
            for (int i = 0; i < elements.length; i++) {
                if (result[0].equals(elements[i])) {
                    return nxts[i];
                }
            }
        }
        return null;
    }
    
    
    
    /**
     * {@inheritDoc}
     */
    public void init(final IWorkbench workbench) {
    }
    
    
    
    /**
     * {@inheritDoc}
     */
    @Override
    protected void performDefaults() {
    }
    
    
    
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean performOk() {
        return true;
    }
    
    
    
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void performApply() {
        performOk();
    }
    
    
    // --------------------------------------------------------------------------
    /**
     * {@inheritDoc}
     */
    public Image getImage(final Object element) {
        return null;
    }
    /**
     * {@inheritDoc}
     */
    public String getText(final Object element) {
        return element.toString();
    }
    /**
     * {@inheritDoc}
     */
    public void addListener(final ILabelProviderListener listener) {
    }
    /**
     * {@inheritDoc}
     */
    public boolean isLabelProperty(final Object element, final String property) {
        return false;
    }
    /**
     * {@inheritDoc}
     */
    public void removeListener(final ILabelProviderListener listener) {
    }
    // --------------------------------------------------------------------------

    
    
    /**
     * Listener for listening to any select events on this preference page.
     * Especially button clicks.
     * 
     * @author ybe
     */
    private class SelectListener implements SelectionListener {

        /**
         * {@inheritDoc}
         */
        public void widgetDefaultSelected(final SelectionEvent e) {
            // do nothing
        }

        /**
         * {@inheritDoc}
         */
        public void widgetSelected(final SelectionEvent e) {
            if (e.widget == flashNXTFirmwareButton) {
                flashNXTFirmwareButton.setEnabled(false);
                flashNXTFirmwareButton.setSize(flashNXTFirmwareButtonWidth,
                        flashNXTFirmwareButton.getSize().y);
                flashNXTFirmwareButton.setText("Flashinf NXT firmware...");
//                NXTInfo selectedNXT = displayNXTSearchDialog(
//                        KlotsPreferenceConstants.P_CONNECTION_SEARCH_FOR_BRICKS_TEXT);
                flashNXTFirmwareButton.setEnabled(true);
                flashNXTFirmwareButton.setText("Flash NXT firmware");
//                if (selectedNXT == null) {
//                    System.out.println("XXXXXXXXXX>>>> No NXT selected!");
//                    return;
//                }
                NXTFirmwareFlasher flasher = new NXTFirmwareFlasher();
//                System.out.println("XXXXXXXXXX>>>> Selected NXT >"
//                        + selectedNXT.name + ", "
//                        + selectedNXT.deviceAddress + ", "
//                        + (selectedNXT.protocol == NXTCommFactory.USB ? "USB" : "BLUETOOTH") + "<");
//                getPreferenceStore().setValue(KlotsPreferenceConstants.P_CONNECTION_CONNECT_TO_NAMED_BRICK,
//                        false);
//                getPreferenceStore().setValue(KlotsPreferenceConstants.P_CONNECTION_CONNECTION_BRICK_NAME,
//                        selectedNXT.name);
//                getPreferenceStore().setValue(KlotsPreferenceConstants.P_CONNECTION_CONNECT_TO_BRICK_ADDRESS,
//                        true);
//                getPreferenceStore().setValue(KlotsPreferenceConstants.P_CONNECTION_CONNECTION_BRICK_ADDRESS,
//                        selectedNXT.deviceAddress);
//                getPreferenceStore().setValue(KlotsPreferenceConstants.P_CONNECTION_CONNECTION_TYPE,
//                        selectedNXT.protocol == NXTCommFactory.USB
//                        ? KlotsPreferenceConstants.P_CONNECTION_PROTOCOL_USB
//                                : KlotsPreferenceConstants.P_CONNECTION_PROTOCOL_BLUETOOTH);
            }
        }
    }
    
}
