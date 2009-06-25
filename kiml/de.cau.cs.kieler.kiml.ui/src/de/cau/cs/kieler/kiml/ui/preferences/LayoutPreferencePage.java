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

import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.CheckboxCellEditor;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
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

    /** array of layout provider identifiers */
    private String[] providerIds;
    /** array of diagram type identifiers */
    private String[] diagramTypes;
    /** data matrix: rows represent layout providers, columns represent diagram types */
    private PriorityTableProvider.DataEntry[][] data;
    /** the combo box used to select layout providers */
    private Combo layoutersCombo;
    /** the table viewer used to display priorities */
    private TableViewer priorityTableViewer;
    
	/**
	 * Creates the layout preference page.
	 */
	public LayoutPreferencePage() {
		super();
		setDescription("Preferences for the KIELER Infrastructure for Meta Layout.");
	}
	
	/**
	 * Builds the preference name associated with the supported priority value
	 * of the given layout provider for the given diagram type.
	 * 
	 * @param layoutProvider identifier of layout provider
	 * @param diagramType identifier of diagram type
	 * @return a preference name for the supported priority value
	 */
	public static String getPreference(String layoutProvider, String diagramType) {
	    return layoutProvider + "-" + diagramType;
	}

    /* (non-Javadoc)
     * @see org.eclipse.jface.preference.PreferencePage#createContents(org.eclipse.swt.widgets.Composite)
     */
    protected Control createContents(Composite parent) {
        Group prioritesGroup = new Group(parent, SWT.NONE);
        prioritesGroup.setText("Priorities of Layouters");
        
        // construct the combo box to select a layouter
        layoutersCombo = new Combo(prioritesGroup, SWT.DROP_DOWN | SWT.READ_ONLY);
        Collection<LayoutProviderData> layoutProviderData = LayoutServices
                .INSTANCE.getLayoutProviderData();
        int layoutProviderCount = layoutProviderData.size();
        diagramTypes = LayoutServices.INSTANCE.getDiagramTypes().toArray(new String[0]);
        String[] comboEntries = new String[layoutProviderCount];
        providerIds = new String[layoutProviderCount];
        data = new PriorityTableProvider.DataEntry
                [layoutProviderCount][diagramTypes.length];
        int i = 0;
        for (LayoutProviderData providerData : layoutProviderData) {
            String collectionName = LayoutServices.INSTANCE.getCollectionName(providerData.collection);
            if (collectionName != null)
                comboEntries[i] = providerData.name + " (" + collectionName + ")";
            else
                comboEntries[i] = providerData.name;
            providerIds[i] = providerData.id;
            for (int j = 0; j < diagramTypes.length; j++) {
                data[i][j] = new PriorityTableProvider.DataEntry();
                data[i][j].diagramTypeName = LayoutServices.INSTANCE
                        .getDiagramTypeName(diagramTypes[j]);
            }
            i++;
        }
        layoutersCombo.setItems(comboEntries);
        layoutersCombo.select(0);
        
        // construct the priorities table
        Label tableHeaderLabel = new Label(prioritesGroup, SWT.NONE);
        tableHeaderLabel.setText("Priorities of the selected layouter:");
        ScrolledComposite scrolledComposite = new ScrolledComposite(prioritesGroup, SWT.BORDER);
        Table prioritiesTable = new Table(scrolledComposite, SWT.HIDE_SELECTION);
        scrolledComposite.setContent(prioritiesTable);
        TableColumn column0 =  new TableColumn(prioritiesTable, SWT.NONE);
        column0.setText("Diagram Type");
        column0.setResizable(true);;
        TableColumn column1 =  new TableColumn(prioritiesTable, SWT.NONE);
        column1.setText("Supported");
        column1.setResizable(true);
        TableColumn column2 =  new TableColumn(prioritiesTable, SWT.NONE, 2);
        column2.setText("Priority");
        column2.setResizable(true);
        prioritiesTable.setHeaderVisible(true);
        prioritiesTable.setSize(300, 200);
        priorityTableViewer = new TableViewer(prioritiesTable);
        priorityTableViewer.setColumnProperties(new String[] {
            PriorityTableProvider.DIAGRAM_PROPERTY,
            PriorityTableProvider.SUPPORTED_PROPERTY,
            PriorityTableProvider.PRIORITY_PROPERTY
        });
        PriorityTableProvider tableProvider = new PriorityTableProvider(priorityTableViewer);
        priorityTableViewer.setContentProvider(tableProvider);
        priorityTableViewer.setLabelProvider(tableProvider);
        CellEditor[] editors = new CellEditor[3];
        editors[1] = new CheckboxCellEditor(prioritiesTable);
        editors[2] = new TextCellEditor(prioritiesTable);
        priorityTableViewer.setCellEditors(editors);
        priorityTableViewer.setCellModifier(tableProvider);
        layoutersCombo.addModifyListener(new ModifyListener() {
            public void modifyText(ModifyEvent e) {
                priorityTableViewer.setInput(data[layoutersCombo.getSelectionIndex()]);
            }
        });
        priorityTableViewer.setInput(data[0]);
        
        prioritesGroup.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false,
                false, 1, 1));
        GridLayout gridLayout = new GridLayout(1, false);
        gridLayout.marginWidth = 15;
        gridLayout.marginHeight = 10;
        prioritesGroup.setLayout(gridLayout);
        
        loadData();
        column0.pack();
        column1.pack();
        column2.pack();
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
        // FIXME currently the default values given by the extension points are not available after user changes have been stored
        super.performDefaults();
        loadData();
    }
    
    /*
     * (non-Javadoc)
     * @see org.eclipse.jface.preference.PreferencePage#performOk()
     */
    public boolean performOk() {
        for (int i = 0; i < providerIds.length; i++) {
            LayoutProviderData providerData = LayoutServices.INSTANCE
                    .getLayoutProviderData(providerIds[i]);
            for (int j = 0; j < diagramTypes.length; j++) {
                int oldPriority = providerData.getSupportedPriority(
                        diagramTypes[j]);
                boolean updateNeeded = false;
                int newPriority = 0;
                if (oldPriority == LayoutProviderData.MIN_PRIORITY
                        && data[i][j].supported) {
                    newPriority = data[i][j].priority;
                    updateNeeded = true;
                }
                else if (oldPriority > LayoutProviderData.MIN_PRIORITY
                        && !data[i][j].supported) {
                    newPriority = LayoutProviderData.MIN_PRIORITY;
                    updateNeeded = true;
                }
                else if (oldPriority > LayoutProviderData.MIN_PRIORITY
                        && data[i][j].supported && oldPriority != data[i][j].priority) {
                    newPriority = data[i][j].priority;
                    updateNeeded = true;
                }
                if (updateNeeded) {
                    providerData.setDiagramSupport(diagramTypes[j], newPriority);
                    String preference = getPreference(providerData.id, diagramTypes[j]);
                    getPreferenceStore().setValue(preference, newPriority);
                }
            }
        }
        return true;
    }
    
    /**
     * Loads the internal data form the layout services.
     */
    private void loadData() {
        for (int i = 0; i < providerIds.length; i++) {
            LayoutProviderData providerData = LayoutServices.INSTANCE
                    .getLayoutProviderData(providerIds[i]);
            for (int j = 0; j < diagramTypes.length; j++) {
                int supportedPriority = providerData.getSupportedPriority(
                        diagramTypes[j]);
                data[i][j].supported = supportedPriority
                        > LayoutProviderData.MIN_PRIORITY;
                data[i][j].priority = data[i][j].supported
                        ? supportedPriority : 0;
            }
        }
        priorityTableViewer.refresh();
    }

}
