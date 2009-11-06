/**
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
package de.cau.cs.kieler.ksbase.core;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.Locale;

import org.eclipse.core.runtime.IContributor;

/**
 * Stores the KSBasE settings for one specific editor.
 * 
 * @author Michael Matzen - mim AT informatik.uni-kiel.de
 * 
 */
public class EditorTransformationSettings implements Serializable {

    /** Serialization Id. **/
    private static final long serialVersionUID = 836873211581178353L;
    /** The model package class. **/
    private String modelPackageClass;
    /** Default icon for menu entries. **/
    private String defaultIcon;
    /** Editor to which this setting is assigned. **/
    private String editor;
    /** Xtend file in which the transformations are defined. **/
    private String extFile;
    /** The context for the diagram editor, required for key bindings. **/
    private String context;
    /** The current List of Transformations. **/
    private LinkedList<Transformation> transformations;
    /** List of menu contributions. **/
    private LinkedList<KSBasEMenuContribution> menuContributions;
    /**
     * The contributor which contains the extension points. When the settings
     * have been defined using the preference pages this will be null.
     **/
    private transient IContributor contributor;

    /**
     * Creates a new transformation setting with the given fully qualified
     * editor name.
     * 
     * @param editorClass
     *            The fqn of the diagram editor
     */
    public EditorTransformationSettings(final String editorClass) {
        this.editor = editorClass;
        this.modelPackageClass = ""; //$NON-NLS-1$
        this.defaultIcon = "";
        this.extFile = ""; //$NON-NLS-1$
        this.context = "";
        this.transformations = new LinkedList<Transformation>();
        this.menuContributions = new LinkedList<KSBasEMenuContribution>();
        this.contributor = null;
    }

    /**
     * Sets the editor class.
     * 
     * @param editorClass
     *            The fqn of the diagram editor
     */
    public final void setEditor(final String editorClass) {
        if (editorClass != null && editorClass.length() > 0) {
            this.editor = editorClass;
        }
    }

    /**
     * Gets the assigned editor.
     * 
     * @return The fully qualified editor name
     */
    public final String getEditor() {
        return editor;
    }

    /**
     * Gets the model package class name.
     * 
     * @return The fqn of the model package class
     */
    public final String getModelPackageClass() {

        if (modelPackageClass == null) {
            return ""; //$NON-NLS-1$
        } else {
            return modelPackageClass;
        }
    }

    /**
     * Sets a model package class.
     * 
     * @param modelPackage
     *            The package class
     */
    public final void setModelPackageClass(final String modelPackage) {
        this.modelPackageClass = modelPackage;
    }

    /**
     * Gets the list of existing menu contributions.
     * 
     * @return The list of menu contributions for this editor
     */
    public final LinkedList<KSBasEMenuContribution> getMenuContributions() {
        return menuContributions;
    }

    /**
     * Sets the menu contributions for this editor and removes any existing
     * contributions.
     * 
     * @param contributionList
     *            The list of menu contributions to use
     */
    public final void setMenuContributions(final LinkedList<KSBasEMenuContribution> contributionList) {
        if (contributionList != null && contributionList.size() > 0) {
            this.menuContributions.clear();
            this.menuContributions.addAll(contributionList);
        }
    }

    /**
     * Adds a menu contribution to this editor.
     * 
     * @param contribution
     *            The contribution to append to the list of menu contributions.
     */
    public final void addMenuContribution(final KSBasEMenuContribution contribution) {
        if (contribution != null) {
            this.menuContributions.add(contribution);
        }
    }

    /**
     * Returns the path to the default icon.
     * 
     * @return Path to the default icon
     */
    public final String getDefaultIcon() {
        return defaultIcon;
    }

    /**
     * Sets the path to the default icon.
     * 
     * @param icon
     *            Icon path
     */
    public final void setDefaultIcon(final String icon) {
        this.defaultIcon = icon;
    }

    /**
     * Gets the list of defined transformations.
     * 
     * @return A LinkedList containing all transformations
     */
    public final LinkedList<Transformation> getTransformations() {
        return transformations;
    }

    /**
     * Tries to find a transformation with a given name.
     * 
     * @param transformation
     *            The name to find
     * @return The first transformation found or null
     */
    public final Transformation getTransformationByName(final String transformation) {
        if (transformation != null) {
            for (Transformation t : transformations) {
                if (t.getTransformationName().toLowerCase(Locale.getDefault()).equals(
                        transformation.toLowerCase(Locale.getDefault()))) {
                    return t;
                }
            }
        }
        return null;
    }

    /**
     * Tries to find a transformation by its identity string.
     * 
     * @param tid
     *            The id to find
     * @return The first transformation with the given id or null if no
     *         transformation has been found
     */
    public final Transformation getTransformationById(final String tid) {
        if (tid != null) {
            for (Transformation t : transformations) {
                if (t.getTransformationId().equals(tid)) {
                    return t;
                }
            }
        }
        return null;
    }

    /**
     * Sets the transformation list.
     * 
     * @param transformationList
     *            A LinkedList containing the transformations
     */
    public final void setTransformations(final LinkedList<Transformation> transformationList) {
        if (transformationList != null) {
            this.transformations.clear();
            this.transformations.addAll(transformationList);
        }
    }

    /**
     * Adds a single transformation to the transformations list.
     * 
     * @param t
     *            a transformation definition
     */
    public final void addTransformation(final Transformation t) {
        if (t != null) {
            this.transformations.add(t);
        }
    }

    /**
     * Removes a transformation.
     * 
     * @param index
     *            the index of the element to remove
     */
    public final void removeTransformation(final int index) {
        if (index > -1 && index < transformations.size()) {
            this.transformations.remove(index);
        }
    }

    /**
     * Replaces a transformation with a new one.
     * 
     * @param oldVal
     *            The transformation to replace
     * @param newVal
     *            The transformation to insert
     */
    public final void modifyTransformation(final Transformation oldVal, final Transformation newVal) {
        if (this.transformations.contains(oldVal)) {
            transformations.remove(oldVal);
        }
        if (newVal != null) {
            transformations.add(newVal);
        }
    }

    /**
     * Returns the text representation of the Xtend file.
     * 
     * @return A .ext file in plain text
     */
    public final String getExtFile() {
        return extFile;
    }

    /**
     * Sets the content of the Xtend file.
     * 
     * @param file
     *            a .ext file in plain text
     * @param createTransformations
     *            indicates if the editor transformations should be created
     *            while parsing the file.
     */
    public final void setExtFile(final String file, final boolean createTransformations) {
        this.extFile = file;
        parseTransformations(createTransformations);
    }

    /**
     * Gets the contributor. May return null if the editor has been added via
     * the preference pages.
     * 
     * @return The editors contributor project.
     */
    public final IContributor getContributor() {
        return contributor;
    }

    /**
     * Sets the editors contributor project.
     * 
     * @param contrib
     *            The contribution that is assigned with this editor. May be
     *            null if the editor has been defined by the user.
     */
    public final void setContributor(final IContributor contrib) {
        this.contributor = contrib;
    }

    /**
     * Returns the defined diagram context.
     * 
     * @return A contextID used to bind keyboard shortcuts to commands
     */
    public final String getContext() {
        return context;
    }

    /**
     * Sets the diagram context.
     * 
     * @param contxt
     *            the contextID to bind keyboard shortcuts
     */
    public final void setContext(final String contxt) {
        this.context = contxt;
    }

    /**
     * Parses the Xtend file to read transformations and parameters.
     * 
     * @param createTransformations
     *            If this flag is set the transformations are created while
     *            parsing. If not, the parameters of the existing
     *            transformations are matched with the file.
     */
    public final void parseTransformations(final boolean createTransformations) {
        if (extFile != null && extFile.length() > 0) {
            // To check if we have any invalid transformations, i.e.
            // if it has no transformation match in the xtend file,
            // we want to remove it now.
            LinkedList<Transformation> cachedTransformations = new LinkedList<Transformation>();

            // Let's find all in-place m2m transformations, defined in this file
            // They are defined by :
            // Starting with 'void '
            // End with ':'
            String[] methods = extFile.split(";");
            for (String m : methods) {
                try {
                    m = m.trim().replaceAll("//.*\n", "");
                    String method = m.toLowerCase(Locale.getDefault()); // just
                    // to be
                    // sure
                    if (!method.contains("void")) { // we only want void methods
                        continue;
                    }
                    // We have to eliminate random occurrences of the 'void'
                    // keyword, e.g. in comments
                    String[] voidMethod = method.split(" ");
                    if (voidMethod.length == 0 || !voidMethod[0].trim().equals("void")) {
                        continue;
                    }

                    // method = method.replaceAll("/\\*.*\\", "");
                    String[] tokens = method.split("void ");
                    String[] head = tokens[1].split(":");
                    String[] parts = head[0].split("\\(");
                    String name = parts[0];
                    String param = parts[1].replace(")", "");
                    String[] parameterAndNames = param.split(",");
                    String[] parameters = new String[parameterAndNames.length];
                    for (int i = 0; i < parameterAndNames.length; ++i) {
                        parameters[i] = parameterAndNames[i].trim().split(" ")[0];
                    }
                    Transformation t = getTransformationByName(name);
                    if (t != null) {
                        t.setParameter(parameters);
                        cachedTransformations.add(t.clone());
                    } else if (createTransformations) {
                        t = new Transformation(name, name);
                        t.setParameter(parameters);
                        t.setTransformationId(editor + "." + name);
                        cachedTransformations.add(t);
                    }
                } catch (NullPointerException exp) {
                    System.err.println("invalid xtend file");
                }
            }

            transformations.clear();
            transformations.addAll(cachedTransformations);
        }
    }

    /**
     * Two editor settings are the same if they have the same target editor and
     * the same source contributor. So we will have an implicit distinction
     * between extension point and user defined settings, because user defined
     * settings will have 'null' as contributor.
     * 
     * @param obj
     *            The Object to compare
     * @return True if the given Object is an EditorTransformationSetting and
     *         has the same contributor
     */
    @Override
    public boolean equals(final Object obj) {
        if (obj instanceof EditorTransformationSettings) {
            EditorTransformationSettings o = (EditorTransformationSettings) obj;
            // we are using the '==' operator for the contributor
            // because it may be possible that the contributor is 'null'
            // and the equals method will throw an exception
            return (o.getEditor().equals(editor) && o.getContributor() == contributor);
        }
        return false;
    }

    /**
     * The hashcode is calculated from the editors hash and the hashCode of the
     * contributor, if existing.
     * 
     * @return The hashCode
     */
    @Override
    public int hashCode() {
        int hash = editor.hashCode();
        if (contributor != null) {
            hash += contributor.hashCode();
        }
        return hash;
    }
}
