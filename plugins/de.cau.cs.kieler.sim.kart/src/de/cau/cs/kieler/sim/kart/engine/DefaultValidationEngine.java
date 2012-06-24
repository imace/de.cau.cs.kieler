/*
 * KIELER - Kiel Integrated Environment for Layout Eclipse RichClient
 *
 * http://www.informatik.uni-kiel.de/rtsys/kieler/
 * 
 * Copyright 2012 by
 * + Christian-Albrechts-University of Kiel
 *   + Department of Computer Science
 *     + Real-Time and Embedded Systems Group
 * 
 * This code is provided under the terms of the Eclipse Public License (EPL).
 * See the file epl-v10.html for the license text.
 */
package de.cau.cs.kieler.sim.kart.engine;

import java.util.Iterator;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

import de.cau.cs.kieler.core.util.Pair;
import de.cau.cs.kieler.sim.kart.KartConstants;
import de.cau.cs.kieler.sim.kart.Utilities;
import de.cau.cs.kieler.sim.kiem.KiemPlugin;

/**
 * The default validation engine to validate simulation runs with. This engine has the capability to
 * perform validity checks of state information, i. e. it can visualize state information.
 * Furthermore, it also checks other variables for valid values. It also checks signals including
 * their values for validity and can (but not must) raise a validation error if additional signals
 * are being generated by the simulation.
 * 
 * @author ssc, cmot
 * @kieler.rating 2012-01-24 red
 */
public class DefaultValidationEngine implements IValidationEngine {

    /**
     * Flag to indicate whether to ignore additionally generated signals or not.
     */
    private boolean ignoreAdditionalSignals;

    // -------------------------------------------------------------------------

    /**
     * Create a new DefaultValidationEngine.
     * 
     * @param ignoreAdditionalSignals
     *            true iff additional signals should be ignored
     */
    public DefaultValidationEngine(final boolean ignoreAdditionalSignals) {
        this.ignoreAdditionalSignals = ignoreAdditionalSignals;
    }

    // -------------------------------------------------------------------------

    /**
     * 
     * {@inheritDoc}
     */
    public void validateVariable(final Pair<String, String> variable, final Object recValue,
            final String simValue, final boolean isHistoryStep, final JSONObject retval) {
        if (simValue == null) {
            KiemPlugin.getDefault().showWarning(
                    "The simulation step did not generate a variable \"" + variable.getFirst()
                            + "\". "
                            + "No validation for this variable will take place in this step!",
                    KartConstants.PLUGINID, null, KartConstants.ERR_SILENT);
        } else if (recValue == null) {
            KiemPlugin.getDefault().showWarning(
                    "The trace file did not contain a variable \"" + variable.getFirst() + "\"."
                            + "No validation for this variable will take place in this step!",
                    KartConstants.PLUGINID, null, KartConstants.ERR_SILENT);
        } else if (!Utilities.compareValues(recValue, simValue)) {
            try {
                if (!isHistoryStep) {
                    // Display an error message
                    String errorMessage = "Validation error: The simulation should have generated the "
                            + "variable \""
                            + variable.getFirst()
                            + "\", representing the following "
                            + "diagram objects:\n"
                            + recValue
                            + "\nbut the variable actually represents:\n" + simValue;

                    try {
                        retval.accumulate(variable.getSecond().toString(), recValue);
                    } catch (JSONException e) {
                        // do nothing
                    }

                    KiemPlugin.getDefault().showError(errorMessage, KartConstants.PLUGINID, null,
                            KartConstants.ERR_SILENT);
                    // throw new KiemExecutionException(Constants.VAL_TITLE, false,
                    // new ValidationException(errorMessage));
                }
            } catch (Exception e) {
                // something went terribly wrong when trying to get real names, just print that
                // string
                try {
                    retval.accumulate(variable.getSecond().toString(), recValue);
                } catch (JSONException j) {
                    // do nothing
                }
                KiemPlugin.getDefault().showError(
                        "Validation error: The simulation should provide a variable \""
                                + variable.getFirst() + "\" with a value of \"" + recValue
                                + "\", but it actually generated the value \"" + simValue + "\".",
                        KartConstants.PLUGINID, null, KartConstants.ERR_SILENT);
            }
        } else {
            try {
                retval.accumulate(variable.getSecond().toString(), "");
            } catch (JSONException e) {
                // do nothing
            }
        }
    }

    // -------------------------------------------------------------------------

    /**
     * 
     * {@inheritDoc}
     */
    public void validateSignals(final Map<String, Object> recSignals,
            final Map<String, String> simSignals, final boolean isHistoryStep,
            final String errSignalVar, final JSONObject retval) {

        Iterator<String> signals = recSignals.keySet().iterator();
        String errSignals = "";

        while (signals.hasNext()) {
            String signal = signals.next();

            if (!(simSignals.containsKey(signal) && ((recSignals.get(signal) == null) || Utilities
                    .compareValues(recSignals.get(signal), simSignals.get(signal))))) {
                if (!errSignals.isEmpty()) {
                    errSignals += ", ";
                }
                errSignals += signal;
            }
            simSignals.remove(signal);
        }

        if (!errSignals.isEmpty()) {
            if (!isHistoryStep) {
                KiemPlugin.getDefault().showError(
                        "Validation error: The signals " + errSignals
                                + " were produced erroneously, they were either not "
                                + "present when they should "
                                + "have been or in the case of valued signals were"
                                + " present with a wrong value", KartConstants.PLUGINID, null,
                        KartConstants.ERR_SILENT);
            }
        }

        String excessSignals = "";
        if (!(ignoreAdditionalSignals || simSignals.isEmpty())) {
            Iterator<String> it2 = simSignals.keySet().iterator();
            while (it2.hasNext()) {
                String signal = it2.next();
                excessSignals += signal;

                if (it2.hasNext()) {
                    excessSignals += ", ";
                }
            }
            if (!isHistoryStep) {
                KiemPlugin.getDefault().showError(
                        "Validation error: The signal(s) " + excessSignals
                                + " were not recorded, but generated in the simulation",
                        KartConstants.PLUGINID, null, KartConstants.ERR_SILENT);
            }
        }

        if (!errSignals.isEmpty()) {
            errSignals += ", ";
        }

        try {
            retval.accumulate(errSignalVar, errSignals + excessSignals);
        } catch (JSONException e) {
            // do nothing
        }
    }

    // -------------------------------------------------------------------------

}
