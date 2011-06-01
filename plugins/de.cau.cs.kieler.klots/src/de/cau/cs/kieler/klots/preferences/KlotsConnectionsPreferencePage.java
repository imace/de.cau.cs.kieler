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
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;

import de.cau.cs.kieler.klots.KlotsPlugin;
import de.cau.cs.kieler.klots.util.KlotsConstants;
import de.cau.cs.kieler.klots.util.NXTCommunicator;


/**
 * This class represents a preference page that is contributed to the
 * Preferences dialog.
 * 
 * @author ybe
 */

public class KlotsConnectionsPreferencePage extends PreferencePage
                                            implements IWorkbenchPreferencePage, ILabelProvider {
    
    private Button connectionTypeUSBRadioButton;
    private Button connectionTypeBluetoothRadioButton;
    
    private Button connectionSiteAddressRadioButton;
    private Button connectionSiteNameRadioButton;
    private Text connectionSiteAddressTextField;
    private Text connectionSiteNameTextField;
    private final int connectionSiteAddressLength = 12;
    
    /** The NXT search button. */
    private Button searchForNXTsButton;
    private final int searchForNXTsButtonWidth = 120;
    
    
    
    /**
     * 
     */
    public KlotsConnectionsPreferencePage() {
        super();
        setPreferenceStore(KlotsPlugin.getDefault().getPreferenceStore());
        setDescription("Connection preferences for the " + KlotsConstants.KLOTS_FULL_NAME);
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
        connectionTypeGroup.setText("&Connection type");
        connectionTypeGroup.setLayout(new GridLayout(1, true));
        connectionTypeGroup.setLayoutData(new GridData(SWT.FILL, SWT.NONE, true, false));
        connectionTypeUSBRadioButton = new Button(connectionTypeGroup, SWT.RADIO);
        connectionTypeUSBRadioButton.setText("&USB");
        connectionTypeBluetoothRadioButton = new Button(connectionTypeGroup, SWT.RADIO);
        connectionTypeBluetoothRadioButton.setText("&Bluetooth");
        connectionTypeGroup.layout();
        
        Group connectionSiteGroup = new Group(parent, SWT.SHADOW_ETCHED_IN);
        connectionSiteGroup.setText("&Connection site");
        connectionSiteGroup.setLayout(new GridLayout(2, true));
        connectionSiteGroup.setLayoutData(new GridData(SWT.FILL, SWT.NONE, true, false));
        connectionSiteAddressRadioButton = new Button(connectionSiteGroup, SWT.RADIO);
        connectionSiteAddressRadioButton.setText("&Connect to address");
        connectionSiteAddressRadioButton.addSelectionListener(listener);
        connectionSiteAddressTextField = new Text(connectionSiteGroup, SWT.LEFT);
        connectionSiteAddressTextField.setTextLimit(connectionSiteAddressLength);
        connectionSiteAddressTextField.setLayoutData(new GridData(SWT.FILL, SWT.NONE, true, false));
        connectionSiteNameRadioButton = new Button(connectionSiteGroup, SWT.RADIO);
        connectionSiteNameRadioButton.setText("Connect to &named brick");
        connectionSiteNameRadioButton.addSelectionListener(listener);
        connectionSiteNameTextField = new Text(connectionSiteGroup, SWT.LEFT);
        connectionSiteNameTextField.setLayoutData(new GridData(SWT.FILL, SWT.NONE, true, false));
        connectionSiteGroup.layout();
        
        // search NXTs button
        searchForNXTsButton = new Button(parent, SWT.NONE);
        searchForNXTsButton.setText("Search for NXTs");
        searchForNXTsButton.setToolTipText("Search for NXTs");
        searchForNXTsButton.addSelectionListener(listener);
        
        // invisible label to fill out unused space
        Label label = new Label(parent, SWT.NONE);
        label.setEnabled(false);
        label.setVisible(false);
        label.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        
        restoreSavedPreferences();
    }
    
    
    
    private void restoreSavedPreferences() {
        if (getPreferenceStore().getString(KlotsPreferenceConstants.P_CONNECTION_CONNECTION_TYPE)
                .equals(KlotsPreferenceConstants.P_CONNECTION_PROTOCOL_USB)) {
            connectionTypeUSBRadioButton.setSelection(true);
            connectionTypeBluetoothRadioButton.setSelection(false);
        } else if (getPreferenceStore().getString(KlotsPreferenceConstants.P_CONNECTION_CONNECTION_TYPE)
                .equals(KlotsPreferenceConstants.P_CONNECTION_PROTOCOL_BLUETOOTH)) {
            connectionTypeUSBRadioButton.setSelection(false);
            connectionTypeBluetoothRadioButton.setSelection(true);
        } else {
            System.err.println("XXXXXXXXXX>>>> CRITICAL ERROR WHILE READING PREFERENCES -> "
                    + " No saved connection type info found!");
        }
        
        if (getPreferenceStore().getBoolean(
                KlotsPreferenceConstants.P_CONNECTION_CONNECT_TO_BRICK_ADDRESS)) {
            connectionSiteAddressRadioButton.setSelection(true);
            connectionSiteNameRadioButton.setSelection(false);
            //connectionSiteAddressTextField.setEditable(true);
            connectionSiteAddressTextField.setEnabled(true);
            //connectionSiteNameTextField.setEditable(false);
            connectionSiteNameTextField.setEnabled(false);
        } else if (getPreferenceStore().getBoolean(
                KlotsPreferenceConstants.P_CONNECTION_CONNECT_TO_NAMED_BRICK)) {
            connectionSiteAddressRadioButton.setSelection(false);
            connectionSiteNameRadioButton.setSelection(true);
            //connectionSiteAddressTextField.setEditable(false);
            connectionSiteAddressTextField.setEnabled(false);
            //connectionSiteNameTextField.setEditable(true);
            connectionSiteNameTextField.setEnabled(true);
        } else {
            System.err.println("XXXXXXXXXX>>>> CRITICAL ERROR WHILE READING PREFERENCES -> "
                    + " No saved connection site info found!");
        }
        connectionSiteNameTextField.setText(getPreferenceStore().getString(
                KlotsPreferenceConstants.P_CONNECTION_CONNECTION_BRICK_NAME));
        connectionSiteAddressTextField.setText(getPreferenceStore().getString(
                KlotsPreferenceConstants.P_CONNECTION_CONNECTION_BRICK_ADDRESS));
        
    }

    
    
    private NXTInfo displayNXTSearchDialog(final String message) {
        ElementListSelectionDialog dialog = new ElementListSelectionDialog(this.getShell(), this);
        dialog.setMultipleSelection(false);
        dialog.setMessage(message);
        dialog.setHelpAvailable(false);
        
        NXTInfo[] nxts;
        nxts = NXTCommunicator.getInstance().searchForNXTs();
//        try {
//            NXTCommunicator.getInstance().getNXTConnector().close();
//        } catch (IOException ioe) {
//            ioe.printStackTrace();
//        }
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
        saveProperties();
        return true;
    }
    
    
    
    /**
     * 
     */
    private void saveProperties() {
        System.out.print("XXXXXXXXXX>>>> Saving NXT Info >");
        
        if (connectionTypeUSBRadioButton.getSelection()) {
            getPreferenceStore().setValue(KlotsPreferenceConstants.P_CONNECTION_CONNECTION_TYPE,
                    KlotsPreferenceConstants.P_CONNECTION_PROTOCOL_USB);
            System.out.print("Protocol: USB, ");
        } else if (connectionTypeBluetoothRadioButton.getSelection()) {
            getPreferenceStore().setValue(KlotsPreferenceConstants.P_CONNECTION_CONNECTION_TYPE,
                    KlotsPreferenceConstants.P_CONNECTION_PROTOCOL_BLUETOOTH);
            System.out.print("Protocol: BLUETOOTH, ");
        } else {
            System.err.println("XXXXXXXXXX>>>> CRITICAL ERROR WHILE SAVING PREFERENCES -> "
                    + " No connection type selected!");
        }
        
        if (connectionSiteAddressRadioButton.getSelection()) {
            getPreferenceStore().setValue(KlotsPreferenceConstants.P_CONNECTION_CONNECT_TO_NAMED_BRICK,
                    false);
            getPreferenceStore().setValue(KlotsPreferenceConstants.P_CONNECTION_CONNECT_TO_BRICK_ADDRESS,
                    true);
            System.out.println("Site address: " + connectionSiteAddressTextField.getText() + "<");
        } else if (connectionSiteNameRadioButton.getSelection()) {
            getPreferenceStore().setValue(KlotsPreferenceConstants.P_CONNECTION_CONNECT_TO_NAMED_BRICK,
                    true);
            getPreferenceStore().setValue(KlotsPreferenceConstants.P_CONNECTION_CONNECT_TO_BRICK_ADDRESS,
                    false);
            System.out.println("Site name: " + connectionSiteNameTextField.getText() + "<");
        } else {
            System.err.println("XXXXXXXXXX>>>> CRITICAL ERROR WHILE SAVING PREFERENCES -> "
                    + " No connection site selected!");
        }
        getPreferenceStore().setValue(KlotsPreferenceConstants.P_CONNECTION_CONNECTION_BRICK_NAME,
                connectionSiteNameTextField.getText());
        getPreferenceStore().setValue(KlotsPreferenceConstants.P_CONNECTION_CONNECTION_BRICK_ADDRESS,
                connectionSiteAddressTextField.getText());
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
            if (e.widget == connectionSiteAddressRadioButton) {
                //connectionSiteAddressTextField.setEditable(true);
                connectionSiteAddressTextField.setEnabled(true);
                //connectionSiteNameTextField.setEditable(false);
                connectionSiteNameTextField.setEnabled(false);
            }
            if (e.widget == connectionSiteNameRadioButton) {
                //connectionSiteAddressTextField.setEditable(false);
                connectionSiteAddressTextField.setEnabled(false);
                //connectionSiteNameTextField.setEditable(true);
                connectionSiteNameTextField.setEnabled(true);
            }
            if (e.widget == searchForNXTsButton) {
                searchForNXTsButton.setEnabled(false);
                searchForNXTsButton.setSize(searchForNXTsButtonWidth,
                        searchForNXTsButton.getSize().y);
                searchForNXTsButton.setText("Searching for NXTs...");
                NXTInfo selectedNXT = displayNXTSearchDialog(
                        KlotsPreferenceConstants.P_CONNECTION_SEARCH_FOR_BRICKS_TEXT);
                searchForNXTsButton.setEnabled(true);
                searchForNXTsButton.setText("Search for NXTs");
                if (selectedNXT == null) {
                    System.out.println("XXXXXXXXXX>>>> No NXT selected!");
                    return;
                }
                System.out.println("XXXXXXXXXX>>>> Selected NXT >"
                        + selectedNXT.name + ", "
                        + selectedNXT.deviceAddress + ", "
                        + (selectedNXT.protocol == NXTCommFactory.USB ? "USB" : "BLUETOOTH") + "<");
                getPreferenceStore().setValue(
                        KlotsPreferenceConstants.P_CONNECTION_CONNECT_TO_NAMED_BRICK, false);
                getPreferenceStore().setValue(
                        KlotsPreferenceConstants.P_CONNECTION_CONNECTION_BRICK_NAME, selectedNXT.name);
                getPreferenceStore().setValue(
                        KlotsPreferenceConstants.P_CONNECTION_CONNECT_TO_BRICK_ADDRESS, true);
                getPreferenceStore().setValue(
                        KlotsPreferenceConstants.P_CONNECTION_CONNECTION_BRICK_ADDRESS,
                        selectedNXT.deviceAddress);
                getPreferenceStore().setValue(KlotsPreferenceConstants.P_CONNECTION_CONNECTION_TYPE,
                        selectedNXT.protocol == NXTCommFactory.USB
                        ? KlotsPreferenceConstants.P_CONNECTION_PROTOCOL_USB
                                : KlotsPreferenceConstants.P_CONNECTION_PROTOCOL_BLUETOOTH);
                
                // update preference page
                KlotsConnectionsPreferencePage.this.restoreSavedPreferences();
                //KlotsPlugin.getDefault().getWorkbench().restart();
            }
        }
    }
    
}