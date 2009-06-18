/******************************************************************************
 * KIELER - Kiel Integrated Environment for Layout for the Eclipse RCP
 *
 * http://www.informatik.uni-kiel.de/rtsys/kieler/
 * 
 * Copyright 2008 by
 * + Christian-Albrechts-University of Kiel
 *   + Department of Computer Science
 *     + Real-Time and Embedded Systems Group
 * 
 * This code is provided under the terms of the Eclipse Public License (EPL).
 * See the file epl-v10.html for the license text.
 */
package de.cau.cs.kieler.kiml.ui.preferences;

import java.util.List;

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.FieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import de.cau.cs.kieler.kiml.layout.services.AbstractLayoutProvider;
import de.cau.cs.kieler.kiml.layout.services.KimlLayoutServices;


/**
 * Abstract field editor preference page for plugins that contain multiple
 * layout providers. Adds a checkbox for each layout provider of a
 * collection to enable and disable them. The respective status is
 * then passed to the layout services class.
 * 
 * @author <a href="mailto:ars@informatik.uni-kiel.de">Arne Schipper</a>
 */
public abstract class LayouterCollectionPreferencePage extends
		FieldEditorPreferencePage {

    /** layout provider collection for this preference page */
    private String collection = null;
    
    /**
     * Creates the preference page.
     */
    public LayouterCollectionPreferencePage() {
        super(GRID);
    }
    
    /**
     * Boolean field editor extension associated with a specific layout
     * provider. This is used to set the enable status of the layout provider.
     */
    private class LayouterEnabledFieldEditor extends BooleanFieldEditor {
        private AbstractLayoutProvider layoutProvider;
        
        /**
         * Creates a boolean field editor for the given layout provider.
         * @param parent the parent of the field editor's control
         * @param layoutProvider the layout provider associated with this
         *     field editor
         */
        LayouterEnabledFieldEditor(Composite parent,
                AbstractLayoutProvider layoutProvider) {
            super(layoutProvider.getName(), layoutProvider.getName()
                    + " (" + layoutProvider.getType() + ")", parent);
            this.layoutProvider = layoutProvider;
        }

        /**
         * Applies the enabled status to the contained layout provider.
         */
        protected void doStore() {
            super.doStore();
            layoutProvider.setEnabled(getBooleanValue());
        }
    }
    
	/**
	 * Creates add adds the status field editor for each layout provider
	 * provided by the contained collection. The concrete layout providers
	 * of this collection are read out from the layout services class.
	 * Subclasses should call this method first via
	 * {@code super.createFiedEditors()} when overriding this method.
	 */
	protected void createFieldEditors() {
		List<AbstractLayoutProvider> layoutProviders = KimlLayoutServices
		        .getInstance().getLayoutProviders(collection);
		
        if (!layoutProviders.isEmpty()) {
            Group enabledLayoutersGroup = new Group(getFieldEditorParent(), SWT.NONE);
            enabledLayoutersGroup.setText("Enabled Layouters");

            for (AbstractLayoutProvider layoutProvider : layoutProviders) {
                FieldEditor enableEditor = new LayouterEnabledFieldEditor(
                        enabledLayoutersGroup, layoutProvider);
                addField(enableEditor);
            }
            
            enabledLayoutersGroup.setLayoutData(new GridData(GridData.FILL,
                    GridData.FILL, true, false, 2, 1));
            GridLayout gl = new GridLayout();
            gl.marginWidth = 15;
            gl.marginHeight = 10;
            enabledLayoutersGroup.setLayout(gl);
        }
	}

	/**
	 * Initializes the preference page with the given collection.
	 * 
	 * @param collection layout provider collection
	 */
	protected final void init(String collection) {
	    this.collection = collection;
	}
	
}
