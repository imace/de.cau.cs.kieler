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

import org.eclipse.jface.preference.ColorFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import de.cau.cs.kieler.klots.KlotsPlugin;
import de.cau.cs.kieler.klots.util.KlotsConstants;

/**
 * This class represents a preference page that is contributed to the
 * Preferences dialog.
 * 
 * @author Matthias Paul Scholz
 */

public class KlotsColorsPreferencePage extends FieldEditorPreferencePage
                                       implements IWorkbenchPreferencePage {
    
    // CHECKSTYLEOFF LineLength
    
    private static final String COLOR_TEXT_FOREGROUND_STANDARD = "Standard foreground color";
    private static final String COLOR_TEXT_TOOLTIP_FOREGROUND_STANDARD = "";
    private static final String COLOR_TEXT_BACKGROUND_STANDARD = "Standard background color";
    private static final String COLOR_TEXT_TOOLTIP_BACKGROUND_STANDARD = "";
    private static final String COLOR_TEXT_FOREGROUND_ALREADY_DONE_MICROSTEP = "Foreground color for already done microsteps";
    private static final String COLOR_TEXT_TOOLTIP_FOREGROUND_ALREADY_DONE_MICROSTEP = "";
    private static final String COLOR_TEXT_BACKGROUND_ALREADY_DONE_MICROSTEP = "Background color for already done microsteps";
    private static final String COLOR_TEXT_TOOLTIP_BACKGROUND_ALREADY_DONE_MICROSTEP = "";
    private static final String COLOR_TEXT_FOREGROUND_ACTIVE_MICROSTEP = "Foreground color for the active microstep";
    private static final String COLOR_TEXT_TOOLTIP_FOREGROUND_ACTIVE_MICROSTEP = "";
    private static final String COLOR_TEXT_BACKGROUND_ACTIVE_MICROSTEP = "Background color for the active microstep";
    private static final String COLOR_TEXT_TOOLTIP_BACKGROUND_ACTIVE_MICROSTEP = "";
    private static final String COLOR_TEXT_FOREGROUND_YET_TO_BE_DONE_MICROSTEP = "Foreground color for microsteps yet to be done";
    private static final String COLOR_TEXT_TOOLTIP_FOREGROUND_YET_TO_BE_DONE_MICROSTEP = "";
    private static final String COLOR_TEXT_BACKGROUND_YET_TO_BE_DONE_MICROSTEP = "Background color for microsteps yet to be done";
    private static final String COLOR_TEXT_TOOLTIP_BACKGROUND_YET_TO_BE_DONE_MICROSTEP = "";
    
    // CHECKSTYLEON LineLength
    
    private ColorFieldEditor foregroundStandardColor;
    private ColorFieldEditor backgroundStandardColor;
    private ColorFieldEditor foregroundAlreadyDoneMicrostepColor;
    private ColorFieldEditor backgroundAlreadyDoneMicrostepColor;
    private ColorFieldEditor foregroundActiveMicrostepColor;
    private ColorFieldEditor backgroundActiveMicrostepColor;
    private ColorFieldEditor foregroundYetToBeDoneMicrostepColor;
    private ColorFieldEditor backgroundYetToBeDoneMicrostepColor;
    
    

    /**
     * 
     */
    public KlotsColorsPreferencePage() {
        super(GRID);
        setPreferenceStore(KlotsPlugin.getDefault().getPreferenceStore());
        setDescription("Color preferences for the " + KlotsConstants.KLOTS_FULL_NAME);
    }

    
    
    /**
     * Creates the field editors. Field editors are abstractions of the common
     * GUI blocks needed to manipulate various types of preferences. Each field
     * editor knows how to save and restore itself.
     */
    public void createFieldEditors() {
        Composite parent = getFieldEditorParent();
        // standard color
        foregroundStandardColor = new ColorFieldEditor(
                KlotsPreferenceConstants.P_COLOR_FOREGROUND_STANDARD,
                KlotsColorsPreferencePage.COLOR_TEXT_FOREGROUND_STANDARD,
                parent);
        backgroundStandardColor = new ColorFieldEditor(
                KlotsPreferenceConstants.P_COLOR_BACKGROUND_STANDARD,
                KlotsColorsPreferencePage.COLOR_TEXT_BACKGROUND_STANDARD,
                parent);
        // already done microstep color
        foregroundAlreadyDoneMicrostepColor = new ColorFieldEditor(
                KlotsPreferenceConstants.P_COLOR_FOREGROUND_ALREADY_DONE_MICROSTEP,
                KlotsColorsPreferencePage.COLOR_TEXT_FOREGROUND_ALREADY_DONE_MICROSTEP,
                parent);
        backgroundAlreadyDoneMicrostepColor = new ColorFieldEditor(
                KlotsPreferenceConstants.P_COLOR_BACKGROUND_ALREADY_DONE_MICROSTEP,
                KlotsColorsPreferencePage.COLOR_TEXT_BACKGROUND_ALREADY_DONE_MICROSTEP,
                parent);
        // active microstep color
        foregroundActiveMicrostepColor = new ColorFieldEditor(
                KlotsPreferenceConstants.P_COLOR_FOREGROUND_ACTIVE_MICROSTEP,
                KlotsColorsPreferencePage.COLOR_TEXT_FOREGROUND_ACTIVE_MICROSTEP,
                parent);
        backgroundActiveMicrostepColor = new ColorFieldEditor(
                KlotsPreferenceConstants.P_COLOR_BACKGROUND_ACTIVE_MICROSTEP,
                KlotsColorsPreferencePage.COLOR_TEXT_BACKGROUND_ACTIVE_MICROSTEP,
                parent);
        // yet to be done microstep color
        foregroundYetToBeDoneMicrostepColor = new ColorFieldEditor(
                KlotsPreferenceConstants.P_COLOR_FOREGROUND_YET_TO_BE_DENE_MICROSTEP,
                KlotsColorsPreferencePage.COLOR_TEXT_FOREGROUND_YET_TO_BE_DONE_MICROSTEP,
                parent);
        backgroundYetToBeDoneMicrostepColor = new ColorFieldEditor(
                KlotsPreferenceConstants.P_COLOR_BACKGROUND_YET_TO_BE_DENE_MICROSTEP,
                KlotsColorsPreferencePage.COLOR_TEXT_BACKGROUND_YET_TO_BE_DONE_MICROSTEP,
                parent);
        
        // add fields
        addField(foregroundStandardColor);
        addField(backgroundStandardColor);
        addField(foregroundAlreadyDoneMicrostepColor);
        addField(backgroundAlreadyDoneMicrostepColor);
        addField(foregroundActiveMicrostepColor);
        addField(backgroundActiveMicrostepColor);
        addField(foregroundYetToBeDoneMicrostepColor);
        addField(backgroundYetToBeDoneMicrostepColor);
    }

    
    
    /**
     * {@inheritDoc}
     */
    public void init(final IWorkbench workbench) {
    }
    
}