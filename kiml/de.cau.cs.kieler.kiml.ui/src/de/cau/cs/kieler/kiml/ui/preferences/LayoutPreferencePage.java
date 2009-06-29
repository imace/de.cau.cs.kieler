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
import java.util.StringTokenizer;

import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
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
import de.cau.cs.kieler.kiml.ui.layout.LayoutServiceBuilder;


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
    private int[][] data;
    /** the provider class that manages content of the priority table */
    private PriorityTableProvider tableProvider;
    
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
        
        Collection<LayoutProviderData> layoutProviderData = LayoutServices
                .INSTANCE.getLayoutProviderData();
        int layoutProviderCount = layoutProviderData.size();
        diagramTypes = LayoutServices.INSTANCE.getDiagramTypes().toArray(new String[0]);
        providerIds = new String[layoutProviderCount];
        data = new int[layoutProviderCount][diagramTypes.length];
        PriorityTableProvider.DataEntry[] tableEntries = new PriorityTableProvider
                .DataEntry[layoutProviderCount];
        String[] layouterNames = new String[layoutProviderCount];
        int i = 0;
        for (LayoutProviderData providerData : layoutProviderData) {
            providerIds[i] = providerData.id;
            tableEntries[i] = new PriorityTableProvider.DataEntry();
            tableEntries[i].layouterIndex = i;
            tableEntries[i].priorities = data[i];
            layouterNames[i] = providerData.name;
            for (int j = 0; j < diagramTypes.length; j++) {
                data[i][j] = providerData.getSupportedPriority(diagramTypes[j]);
            }
            i++;
        }
        
        // construct the priorities table
        Label tableHeaderLabel = new Label(prioritesGroup, SWT.WRAP);
        tableHeaderLabel.setText("Configure which diagram types are supported by each layouter. The Layouter with highest priority for a diagram type is highlighted with a blue circle. No priority value means the diagram type is not supported by that layouter.");
        Table prioritiesTable = new Table(prioritesGroup, SWT.BORDER);
        TableColumn[] columns = new TableColumn[diagramTypes.length + 1];
        columns[0] =  new TableColumn(prioritiesTable, SWT.NONE);
        columns[0].setText("Layouter");
        for (int j = 0; j < diagramTypes.length; j++) {
            columns[j+1] = new TableColumn(prioritiesTable, SWT.NONE);
            String diagramTypeName = LayoutServices.INSTANCE.getDiagramTypeName(diagramTypes[j]);
            columns[j+1].setText(getAbbrev(diagramTypeName));
            columns[j+1].setToolTipText(diagramTypeName);
        }
        prioritiesTable.setHeaderVisible(true);
        TableViewer priorityTableViewer = new TableViewer(prioritiesTable);
        String[] columnProperties = new String[diagramTypes.length + 1];
        CellEditor[] cellEditors = new CellEditor[diagramTypes.length + 1];
        columnProperties[0] = PriorityTableProvider.LAYOUTERS_PROPERTY;
        for (int j = 0; j < diagramTypes.length; j++) {
            columnProperties[j+1] = Integer.toString(j);
            cellEditors[j+1] = new TextCellEditor(prioritiesTable);
        }
        priorityTableViewer.setColumnProperties(columnProperties);
        tableProvider = new PriorityTableProvider(
                priorityTableViewer, data, layouterNames);
        priorityTableViewer.setContentProvider(tableProvider);
        priorityTableViewer.setLabelProvider(tableProvider);
        priorityTableViewer.setCellEditors(cellEditors);
        priorityTableViewer.setCellModifier(tableProvider);
        priorityTableViewer.setInput(tableEntries);
        for (TableColumn column : columns)
            column.pack();
        prioritiesTable.pack();
        
        prioritesGroup.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true,
                false, 1, 2));
        prioritesGroup.setLayout(new GridLayout(1, false));
        return prioritesGroup;
    }
    
    private String getAbbrev(String diagramType) {
        if (diagramType.length() <= 7)
            return diagramType;
        else {
            StringBuffer abbrev = new StringBuffer();
            StringTokenizer tokenizer = new StringTokenizer(diagramType);
            while (tokenizer.hasMoreTokens())
                abbrev.append(tokenizer.nextToken().charAt(0));
            return abbrev.toString();
        }
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
        super.performDefaults();
        LayoutServiceBuilder.readSupportPriorities(data, providerIds, diagramTypes);
        tableProvider.refresh();
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
                int newPriority = data[i][j];
                if (oldPriority != newPriority) {
                    providerData.setDiagramSupport(diagramTypes[j], newPriority);
                    String preference = getPreference(providerData.id, diagramTypes[j]);
                    getPreferenceStore().setValue(preference, newPriority);
                }
            }
        }
        return true;
    }

}
