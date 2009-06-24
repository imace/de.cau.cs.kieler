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

import java.util.Collection;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import de.cau.cs.kieler.kiml.layout.services.LayoutProviderData;
import de.cau.cs.kieler.kiml.layout.services.LayoutServices;
import de.cau.cs.kieler.kiml.ui.KimlUiPlugin;


/**
 * Preference page for general KIML preferences.
 * 
 * @author msp
 */
public class LayoutPreferencePage extends PreferencePage
		implements IWorkbenchPreferencePage {

    /** column identifiers for the priorities table */
    private final static String[] COLUMNS_PRIO = { "diagram", "supported", "priority" };
    
	/**
	 * Creates the layout preference page.
	 */
	public LayoutPreferencePage() {
		super();
		setDescription("Preferences for the KIELER Infrastructure for Meta Layout.");
	}

    /* (non-Javadoc)
     * @see org.eclipse.jface.preference.PreferencePage#createContents(org.eclipse.swt.widgets.Composite)
     */
    protected Control createContents(Composite parent) {
        Group prioritesGroup = new Group(parent, SWT.NONE);
        prioritesGroup.setText("Priorities of Layouters");
        
        // construct the combo box to select a layouter
        Combo layoutersCombo = new Combo(prioritesGroup, SWT.DROP_DOWN | SWT.READ_ONLY);
        Collection<LayoutProviderData> layoutProviderData = LayoutServices
                .INSTANCE.getLayoutProviderData();
        String[] comboEntries = new String[layoutProviderData.size()];
        int i = 0;
        for (LayoutProviderData data : layoutProviderData) {
            String collectionName = LayoutServices.INSTANCE.getCollectionName(data.collection);
            if (collectionName != null)
                comboEntries[i++] = data.name + " (" + collectionName + ")";
            else
                comboEntries[i++] = data.name;
        }
        layoutersCombo.setItems(comboEntries);
        layoutersCombo.select(0);
        
        // construct the priorities table
        Label tableHeaderLabel = new Label(prioritesGroup, SWT.NONE);
        tableHeaderLabel.setText("Priorities of the selected layouter:");
        Table prioritiesTable = new Table(parent, SWT.HIDE_SELECTION);
        TableColumn column0 =  new TableColumn(prioritiesTable, SWT.NONE);
        column0.setText("Diagram Type");
        TableColumn column1 =  new TableColumn(prioritiesTable, SWT.NONE);
        column1.setText("Supported");
        TableColumn column2 =  new TableColumn(prioritiesTable, SWT.NONE, 2);
        column2.setText("Priority");
        prioritiesTable.setLinesVisible(true);
        prioritiesTable.setHeaderVisible(true);
        TableViewer viewer = new TableViewer(prioritiesTable);
        viewer.setColumnProperties(COLUMNS_PRIO);
        //viewer.setContentProvider(new IStructuredContentProvider());
        //viewer.setLabelProvider(new ITableLabelProvider());
        
        prioritesGroup.setLayout(new FillLayout(SWT.VERTICAL));
        return prioritesGroup;
    }

    /* (non-Javadoc)
     * @see org.eclipse.ui.IWorkbenchPreferencePage#init(org.eclipse.ui.IWorkbench)
     */
    public void init(IWorkbench workbench) {
        setPreferenceStore(KimlUiPlugin.getDefault().getPreferenceStore());
    }

    /*
     * (non-Javadoc)
     * @see org.eclipse.jface.preference.PreferencePage#performDefaults()
     */
    protected void performDefaults() {
        // TODO read default values
        super.performDefaults();
    }
    
    /*
     * (non-Javadoc)
     * @see org.eclipse.jface.preference.PreferencePage#performOk()
     */
    public boolean performOk() {
        // TODO apply preferences
        return true;
    }

}
