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

/**
 * Constant definitions for plug-in preferences.
 * 
 * @author ybe
 * 
 */
public final class KlotsPreferenceConstants {
    
    // CHECKSTYLEOFF LineLength

    // ################### CONNECTION PREFERENCE CONSTANTS ###################
    /**
     * 
     */
    public static final String P_CONNECTION_PREFERENCE_PREFIX = "prefConnection";
    /**
     * 
     */
    public static final String P_CONNECTION_PROTOCOL_USB = "u";
    /**
     * 
     */
    public static final String P_CONNECTION_PROTOCOL_BLUETOOTH = "b";
    /**
     * 
     */
    public static final String P_CONNECTION_CONNECTION_TYPE = "connectionType";
    /**
     * 
     */
    public static final String P_CONNECTION_CONNECT_TO_BRICK_ADDRESS = "ConnectToAddress";
    /**
     * 
     */
    public static final String P_CONNECTION_CONNECTION_BRICK_ADDRESS = "ConnectionAddress";
    /**
     * 
     */
    public static final String P_CONNECTION_CONNECT_TO_NAMED_BRICK = "ConnectToName";
    /**
     * 
     */
    public static final String P_CONNECTION_CONNECTION_BRICK_NAME = "ConnectionName";
    /**
     * 
     */
    public static final String P_CONNECTION_SEARCH_FOR_BRICKS = "SearchForNXTs";
    /**
     * 
     */
    public static final String P_CONNECTION_SEARCH_FOR_BRICKS_TEXT = "Select a NXT to be connected to.";
    
    
    
    // ##################### COLOR PREFERENCE CONSTANTS ######################
    /**
     * 
     */
    public static final String P_COLOR_PREFERENCE_PREFIX = "prefColor";
    /**
     * 
     */
    public static final String P_COLOR_FOREGROUND_STANDARD = "prefColorForegroundStandard";
    /**
     * 
     */
    public static final String P_COLOR_BACKGROUND_STANDARD = "prefColorBackgroundStandard";
    /**
     * 
     */
    public static final String P_COLOR_FOREGROUND_ALREADY_DONE_MICROSTEP = "prefColorForegroundAlreadyDoneMicrostep";
    /**
     * 
     */
    public static final String P_COLOR_BACKGROUND_ALREADY_DONE_MICROSTEP = "prefColorBackgroundAlreadyDoneMicrostep";
    /**
     * 
     */
    public static final String P_COLOR_FOREGROUND_ACTIVE_MICROSTEP = "prefColorForegroundActiveMicrostep";
    /**
     * 
     */
    public static final String P_COLOR_BACKGROUND_ACTIVE_MICROSTEP = "prefColorBackgroundActiveMicrostep";
    /**
     * 
     */
    public static final String P_COLOR_FOREGROUND_YET_TO_BE_DENE_MICROSTEP = "prefColorForegroundYetToBeDoneMicrostep";
    /**
     * 
     */
    public static final String P_COLOR_BACKGROUND_YET_TO_BE_DENE_MICROSTEP = "prefColorBackgroundYetToBeDoneMicrostep";
    
    // CHECKSTYLEON LineLength
    
    private KlotsPreferenceConstants() {
        
    }
}