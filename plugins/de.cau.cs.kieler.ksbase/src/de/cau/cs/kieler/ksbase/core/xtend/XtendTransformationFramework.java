/*
 * KIELER - Kiel Integrated Environment for Layout Eclipse RichClient
 *
 * http://www.informatik.uni-kiel.de/rtsys/kieler/
 * 
 * Copyright 2009 by
 * + Christian-Albrechts-University of Kiel
 *   + Department of Computer Science
 *     + Real-Time and Embedded Systems Group
 * 
 * This code is provided under the terms of the Eclipse Public License (EPL).
 * See the file epl-v10.html for the license text.
 * 
 *****************************************************************************/
package de.cau.cs.kieler.ksbase.core.xtend;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.mwe.core.ConfigurationException;
import org.eclipse.xtend.XtendFacade;
import org.eclipse.xtend.typesystem.emf.EcoreUtil2;
import org.eclipse.xtend.typesystem.emf.EmfMetaModel;

import de.cau.cs.kieler.ksbase.KSBasEPlugin;
import de.cau.cs.kieler.ksbase.core.ITransformationFramework;

/**
 * A wrapper class for an {@link XtendComponent}. Used to initialize the component, set the
 * invocation target and its meta-model
 * 
 * @author Michael Matzen - mim AT informatik.uni-kiel.de
 * 
 * @kieler.rating 2009-11-20 proposed yellow -review by msp,skn: move to ui
 * @kieler.rating 2009-12-15 proposed yellow - new review required
 */
public class XtendTransformationFramework implements ITransformationFramework {

    /** The Xtend facade, used to execute a transformation. **/
    private XtendFacade xtendFacade;
    /** The extension parameters. **/
    private Object[] parameters;
    /** The name of the extension. **/
    private String extension;
    /** The component status. **/
    private boolean initalized;

    /**
     * Creates a new Xtend component.
     * 
     */
    public XtendTransformationFramework() {
        initalized = false;
    }

    /**
     * Executes a transformation using the XtendFacade.
     * 
     * @param fileName
     *            The extension file name
     * @param operation
     *            The extension to execute
     * @param basePackage
     *            The package of the editors metamodel
     * @param parameter
     *            The parameters
     * @return False if an error occoured.
     */
    @Override
    public boolean initializeTransformation(final String fileName, final String operation,
            final String basePackage, final Object... parameter) {
        try {
            // The EMFMetaMetaModel,
            EmfMetaModel metaModel;

            // Load the EPackage class by using EcoreUtils
            EPackage pack = EcoreUtil2.getEPackageByClassName(basePackage);
            // create EMFMetaModel with the given EPackage
            metaModel = new EmfMetaModel(pack);
            xtendFacade = XtendFacade.create(fileName);
            xtendFacade.registerMetaModel(metaModel);
            
            if (!xtendFacade.hasExtension(operation, parameter)) {
                KSBasEPlugin.getDefault().logError(
                        "Could not find transformation " + operation + " with the parameters"
                                + parameter.toString());
            } else {
                this.parameters = parameter;
                this.extension = operation;
                initalized = true;
            }
        } catch (ConfigurationException ex) {
            KSBasEPlugin.getDefault().logError(
                    "Could not find EPackage for package name " + basePackage);
            return false;
        }
        return true;
    }

    @Override
    public void executeTransformation() {
        if (initalized) {
            xtendFacade.call(extension, parameters);
        } else {
            KSBasEPlugin.getDefault().logError(
                    "Could not execute transformation: Transformation not initalized poroperly");
        }
    }
}
