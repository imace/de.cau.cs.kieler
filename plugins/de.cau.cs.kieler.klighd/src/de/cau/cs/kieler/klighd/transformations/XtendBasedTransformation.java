/*
 * KIELER - Kiel Integrated Environment for Layout Eclipse RichClient
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
package de.cau.cs.kieler.klighd.transformations;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.internal.xtend.xtend.XtendFile;
import org.eclipse.internal.xtend.xtend.ast.Extension;
import org.eclipse.ui.statushandlers.StatusManager;
import org.eclipse.xtend.XtendFacade;
import org.eclipse.xtend.XtendResourceParser;
import org.eclipse.xtend.typesystem.emf.EmfMetaModel;

import de.cau.cs.kieler.klighd.IModelTransformation;
import de.cau.cs.kieler.klighd.KLighDPlugin;

/**
 * An implementation of {@link IModelTransformation} enabling Xtend-based model transformations. 
 * 
 * @author chsch
 */
public class XtendBasedTransformation implements IModelTransformation<Object, Object> {

    private static final String TRANSFORMATION_EXTENSION_NAME = "transform";

    private URL extfile;
    private String extension;
    private Map<String, EPackage> metamodels;
    private int countParams = 1;

    /**
     * The constructor.
     * 
     * @param extFileURL the extend file
     * @param theExtension the root extend function
     * @param theMetamodels the involved meta models
     */
    public XtendBasedTransformation(final URL extFileURL, final String theExtension,
            final List<EPackage> theMetamodels) {
        this.extfile = extFileURL;
        this.metamodels = new HashMap<String, EPackage>();

        for (EPackage mm : theMetamodels) {
            this.metamodels.put(mm.getNsPrefix(), mm);
        }

        if (theExtension != null && !theExtension.equals("")) {
            this.extension = theExtension;
        } else {
            this.extension = TRANSFORMATION_EXTENSION_NAME;
        }
    }

    /**
     * Checks whether the the supplied Xtend-based transformation supports the current model object.
     * 
     * @param model the model to be tested
     * @return <code>true</code> if the given model is supported by this model transformation
     */
    public boolean isModelSupported(final Object model) {
        try {

            /* load the Xtend file */
            XtendFile ext = (XtendFile) new XtendResourceParser().parse(new InputStreamReader(
                    extfile.openStream()), extfile.getFile());

            /* search the fitting extension */
            for (Extension e : ext.getExtensions()) {
                // by name...
                if (e.getName().equals(this.extension)) {

                    // reveal the type of the first parameter
                    String firstParamType = e.getFormalParameters().get(0).getType().getValue();

                    // construe its name
                    int pos = firstParamType.lastIndexOf("::");
                    String className = (pos == -1 ? firstParamType : firstParamType
                            .substring(pos + 2));
                    String packageName = (pos == -1 ? "" : firstParamType.substring(0, pos));
                    EClassifier clazz = null;
                    EPackage ePackage = null;

                    // search a class with the revealed type name in the registered meta models
                    for (EPackage mm : this.metamodels.values()) {
                        clazz = mm.getEClassifier(className);

                        if (clazz != null && clazz.isInstance(model)) {
                            ePackage = clazz.getEPackage();
                            boolean isDeclared = false;

                            // check whether the xtend file imports the package containing this
                            // class
                            // this check test only the last subpackage name (is sufficient right
                            // now)
                            for (String name : ext.getImportedNamespaces()) {
                                isDeclared |= name.endsWith(ePackage.getNsPrefix());
                            }

                            // in case the type was specified by a FQCN, check the identity of the
                            // package names; check the presence of the class' package import
                            // otherwise
                            if (!packageName.equals("") && packageName.equals(ePackage.getName())
                                    || packageName.equals("") && isDeclared) {

                                // remember the actual number of parameters for convenience,
                                // needed during the execution below
                                countParams = e.getFormalParameters().size();
                                return true;
                            }
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("");

        return false;
    }

    /** the length of the string ".ext". */
    private static final int ENDING_OFFSET = 4;
    
    /**
     * Fires an instance of {@link XtendFacade} to execute the transformation.
     * 
     * @param model the model to be transformed.
     * @return the transformation result.
     */
    public EObject transform(final Object model) {        
        String url = this.extfile.getFile();
        if (url.endsWith(".ext")) {
            url = url.substring(0, url.length() - ENDING_OFFSET);
        }

        XtendFacade facade = XtendFacade.create(url);
        facade.registerMetaModel(new EmfMetaModel(EcorePackage.eINSTANCE));
        for (EPackage mm : this.metamodels.values()) {
            facade.registerMetaModel(new EmfMetaModel(mm));
        }

        Object[] params = new Object[this.countParams];
        params[0] = model;

        EObject result = null;
        try {
            result = (EObject) facade.call(this.extension, params);
        } catch (Exception e) {
            StatusManager.getManager().handle(
                    new Status(IStatus.ERROR, KLighDPlugin.PLUGIN_ID,
                            "Xtend-based transformation execution failed", e));
        }

        return result;
    }

}
