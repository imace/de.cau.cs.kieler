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

import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import de.cau.cs.kieler.klots.KlotsPlugin;
import de.cau.cs.kieler.klots.util.KlotsConstants;
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
    private Composite parentComposite;
    
    
    
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
        parentComposite = parent;
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
        
        Label description = new Label(parent, SWT.BOLD);
        description.setText(
                "As leJOS NXJ is a firmware replacement, you will need to flash the firmware\n"
                + "to your NXT. Note that this will overwrite any existing firmware. If you have\n"
                + "the standard LEGO firmware or other third-party firmware on your NXT,\n"
                + "existing files will be lost. Make sure your NXT is attached to the PC by its USB\n"
                + "cable, and switch it on by pressing the orange button.");
        description.setSize(parent.getSize().x, parent.getSize().y);
        description.setVisible(true);
        
        // flash NXT firmware button
        flashNXTFirmwareButton = new Button(parent, SWT.NONE);
        flashNXTFirmwareButton.setText(" Flash leJOS NXJ Firmware ");
        flashNXTFirmwareButton.setToolTipText("Flash leJOS NXJ Firmware");
        flashNXTFirmwareButton.addSelectionListener(listener);
        
        // invisible label to fill out unused space
        Label label = new Label(parent, SWT.NONE);
        label.setEnabled(false);
        label.setVisible(false);
        label.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
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
                NXTFirmwareFlasher flasher = new NXTFirmwareFlasher(parentComposite);
                flasher.run(flashNXTFirmwareButton);
            }
        }
    }
    
}
