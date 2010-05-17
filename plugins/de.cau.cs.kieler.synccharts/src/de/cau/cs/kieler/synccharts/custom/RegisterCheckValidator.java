package de.cau.cs.kieler.synccharts.custom;

import java.util.ArrayList;

import org.eclipse.ui.IStartup;

import de.cau.cs.kieler.core.model.util.MarkerHandler;
import de.cau.cs.kieler.synccharts.SyncchartsPackage;

/**
 * Registers/deregisters the checkfiles.
 * 
 * @author haf
 */
public class RegisterCheckValidator implements IStartup {

    /**
     * 
     * {@inheritDoc}
     */
    public void earlyStartup() {
        registerChecks();
    }

    /**
     * Registers the checkfiles to the synccharts editor.
     * 
     */
    public static void registerChecks() {
        // normal SyncChart checks
        MarkerHandler.registerCheckFile(SyncchartsPackage.eINSTANCE,
                "model/SyncchartsChecks.chk", false, new ArrayList());

        // additional checks for KLEPTO simulation restrictions
        MarkerHandler.registerCheckFile(SyncchartsPackage.eINSTANCE,
                "model/SyncchartsKleptoChecks.chk", true, new ArrayList());
    }
}
