/*
 * KIELER - Kiel Integrated Environment for Layout Eclipse RichClient
 *
 * http://www.informatik.uni-kiel.de/rtsys/kieler/
 * 
 * Copyright 2010 by
 * + Christian-Albrechts-University of Kiel
 *   + Department of Computer Science
 *     + Real-Time and Embedded Systems Group
 * 
 * This code is provided under the terms of the Eclipse Public License (EPL).
 * See the file epl-v10.html for the license text.
 */
package de.cau.cs.kieler.sim.kiem.automated;

import java.util.List;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;

import de.cau.cs.kieler.sim.kiem.KiemInitializationException;
import de.cau.cs.kieler.sim.kiem.properties.KiemProperty;
import de.cau.cs.kieler.sim.kiem.ui.datacomponent.JSONObjectSimulationDataComponent;

/**
 * Default implementation of an automated component.
 * 
 * @author soh
 * @kieler.rating 2010-03-16 yellow ctr, tam
 */
public abstract class AbstractAutomatedComponent extends
        JSONObjectSimulationDataComponent implements IAutomatedComponent {

    /**
     * The model file.
     */
    private IPath modelFile;

    /**
     * The index of the current iteration.
     */
    private int iteration = -1;

    /**
     * This component doesn't support any files.
     * 
     * Subclasses should override this to indicate which type of file they
     * support.
     * 
     * Example: types = {"kixs", "strl}; types = IAutomatedComponent.ANY_TYPE;
     * 
     * @return null
     */
    public String[] getSupportedExtensions() {
        return null;
    }

    /**
     * The default implementation only retrieves the model file and the current
     * iteration index.
     * 
     * Subclasses should extend this method.
     * 
     * @param properties
     *            the properties passed before each execution
     * @throws KiemInitializationException
     *             if something went wrong
     */
    public void setParameters(final List<KiemProperty> properties)
            throws KiemInitializationException {
        modelFile = null;
        iteration = -1;
        for (KiemProperty prop : properties) {
            if (modelFile == null
                    && prop.getKey().equals(IAutomatedComponent.MODEL_FILE)) {
                String path = prop.getValue();
                modelFile = Path.fromOSString(path);
            } else if (iteration == -1
                    && prop.getKey().equals(IAutomatedComponent.ITERATION)) {
                iteration = Integer.parseInt(prop.getValue());
            }
            if (iteration != -1 && modelFile != null) {
                break;
            }
        }
    }

    /**
     * The default implementation doesn't need any runs.
     * 
     * Subclasses should override this method.
     * 
     * @return 0
     * @deprecated use getNumberOfAdditionalIterations()
     */
    @Deprecated
    public int wantsMoreRuns() {
        return 0;
    }

    /**
     * The default implementation doesn't need any runs.
     * 
     * Subclasses should override this method.
     * 
     * @return 0
     */
    public int getNumberOfAdditionalIterations() {
        return wantsMoreRuns();
    }

    /**
     * The default implementation doesn't need any steps.
     * 
     * Subclasses should override this method.
     * 
     * @return 0
     * @deprecated use getNumberOfAdditionalSteps()
     */
    @Deprecated
    public int wantsMoreSteps() {
        return 0;
    }

    /**
     * The default implementation doesn't need any steps.
     * 
     * Subclasses should override this method.
     * 
     * @return 0
     */
    public int getNumberOfAdditionalSteps() {
        return wantsMoreSteps();
    }

    /**
     * Getter for the model file retrieved from the parameter list. May be null
     * if setParameters was not called.
     * 
     * @return the model file
     */
    protected IPath getModelFile() {
        return modelFile;
    }

    /**
     * Getter for the iteration index retrieved from the parameter list. May be
     * -1 if setParameters was not called.
     * 
     * @return the iteration index
     */
    protected int getIteration() {
        return iteration;
    }

}
