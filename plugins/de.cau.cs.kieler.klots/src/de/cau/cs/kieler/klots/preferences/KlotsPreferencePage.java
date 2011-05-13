/*
 * KIELER - Kiel Integrated Environment for Layout Eclipse Rich Client
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
package de.cau.cs.kieler.klots.preferences;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import lejos.pc.comm.NXTCommFactory;
import lejos.pc.comm.NXTInfo;

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.RadioGroupFieldEditor;
import org.eclipse.jface.preference.StringFieldEditor;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import de.cau.cs.kieler.klots.KlotsPlugin;
import de.cau.cs.kieler.klots.util.KlotsConstants;
import de.cau.cs.kieler.klots.util.NXTCommunicator;


/**
 * This class represents a preference page that is contributed to the
 * Preferences dialog.
 * 
 * @author ybe
 */

public class KlotsPreferencePage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

    /** The Constant COLUMN_0_WIDTH. */
    private static final int COLUMN_0_WIDTH = 0;
    private static final String COLUMN_0_TEXT = "";
    private static final String COLUMN_0_TOOLTIP = "";

    /** The Constant COLUMN_1_WIDTH. */
    private static final int COLUMN_1_WIDTH = 100;
    private static final String COLUMN_1_TEXT = "Name";
    private static final String COLUMN_1_TOOLTIP = "NXT name";

    /** The Constant COLUMN_2_WIDTH. */
    private static final int COLUMN_2_WIDTH = 90;
    private static final String COLUMN_2_TEXT = "Address";
    private static final String COLUMN_2_TOOLTIP = "Address";

    /** The Constant COLUMN_3_WIDTH. */
    private static final int COLUMN_3_WIDTH = 90;
    private static final String COLUMN_3_TEXT = "Protocol";
    private static final String COLUMN_3_TOOLTIP = "NXT connection protocol";
    
    /** The NXT search button. */
    private Button searchForNXTsButton;
    /** The table where found NXTs are displayed. */
    private Table nxtsTable;
    /** The table viewer. */
    private TableViewer nxtsTableViewer;
    /** The data entries for this table. */
    private List<NXTInfo> nxtsTableEntries = new LinkedList<NXTInfo>();
    
    private RadioGroupFieldEditor connectionType;
    private BooleanFieldEditor connectToBrickAddress;
    private StringFieldEditor connectionBrickAddress;
    private BooleanFieldEditor connectToNamedBrick;
    private StringFieldEditor connectionBrickName;
    private Label currentNXTLabel1;
    private Label currentNXTLabel2;
    
    
    
    /**
     * 
     */
    public KlotsPreferencePage() {
        super(GRID);
        setPreferenceStore(KlotsPlugin.getDefault().getPreferenceStore());
        setDescription("Preferences for the " + KlotsConstants.KLOTS_FULL_NAME);
    }

    
    
    /**
     * Creates the field editors. Field editors are abstractions of the common
     * GUI blocks needed to manipulate various types of preferences. Each field
     * editor knows how to save and restore itself.
     */
    public void createFieldEditors() {
        connectionType = new RadioGroupFieldEditor(
                KlotsPreferenceConstants.P_CONNECTION_TYPE, "&Connection type", 1,
                new String[][] {
                        { "&USB", KlotsPreferenceConstants.P_PROTOCOL_USB },
                        { "&Bluetooth", KlotsPreferenceConstants.P_PROTOCOL_BLUETOOTH } },
                getFieldEditorParent(), true);
        addField(connectionType);
        
        Group manualConnectionGroup = new Group(this.getFieldEditorParent(), SWT.SHADOW_ETCHED_IN);
        // connect to NXT by address?
        connectToBrickAddress = new BooleanFieldEditor(
                KlotsPreferenceConstants.P_CONNECT_TO_BRICK_ADDRESS,
                "&Connect to address", manualConnectionGroup);
        connectionBrickAddress = new StringFieldEditor(
                KlotsPreferenceConstants.P_CONNECTION_BRICK_ADDRESS, "&Address", manualConnectionGroup);
        addField(connectToBrickAddress);
        addField(connectionBrickAddress);
        
        // connect to named NXT?
        connectToNamedBrick = new BooleanFieldEditor(
                KlotsPreferenceConstants.P_CONNECT_TO_NAMED_BRICK,
                "Connect to &named brick", manualConnectionGroup);
        connectionBrickName = new StringFieldEditor(
                KlotsPreferenceConstants.P_CONNECTION_BRICK_NAME, "&Name", manualConnectionGroup);
        addField(connectToNamedBrick);
        addField(connectionBrickName);
        Label label = new Label(this.getFieldEditorParent(), SWT.RIGHT);
        label.setText("");
        
        // search NXTs button
        searchForNXTsButton = new Button(this.getFieldEditorParent(), SWT.NONE);
        searchForNXTsButton.setText("Search for NXTs");
        searchForNXTsButton.setToolTipText("Search for NXTs");
        searchForNXTsButton.addSelectionListener(new SelectionListener() {
            public void widgetSelected(final SelectionEvent e) {
                searchForNXTsButton.setEnabled(false);
                searchForNXTsButton.setText("Searching...");
                searchForNXTsButton.setToolTipText("Searching for NXTs...");
                NXTInfo[] nxts = NXTCommunicator.getInstance().searchForNXTs();
                try {
                    NXTCommunicator.getInstance().getNXTConnector().close();
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
                nxtsTableEntries = new LinkedList<NXTInfo>();
                for (NXTInfo info : nxts) {
                    nxtsTableEntries.add(info);
                }
                nxtsTableViewer.setInput(nxtsTableEntries);
                nxtsTableViewer.refresh();
                searchForNXTsButton.setEnabled(true);
                searchForNXTsButton.setText("Search for NXTs");
                searchForNXTsButton.setToolTipText("Search for NXTs");
                
                System.out.print("XXXXXXXXX CURRENT NXT >");
                System.out.print(getPreferenceStore().getString(
                        KlotsPreferenceConstants.P_CONNECTION_BRICK_NAME) + ", ");
                System.out.print(getPreferenceStore().getString(
                        KlotsPreferenceConstants.P_CONNECTION_BRICK_ADDRESS) + ", ");
                System.out.println(getPreferenceStore().getString(
                        KlotsPreferenceConstants.P_CONNECTION_TYPE) + "<");
                
            }
            public void widgetDefaultSelected(final SelectionEvent e) {
            } 
        });
        
        // NXTs device table
        nxtsTable = new Table(this.getFieldEditorParent(), SWT.BORDER | SWT.FULL_SELECTION);
        nxtsTableViewer = new TableViewer(nxtsTable);
        createColumns(nxtsTableViewer);
        nxtsTableViewer.setContentProvider(new KlotsPreferenceNXTSearchTableContentProvider());
        nxtsTableViewer.setLabelProvider(new KlotsPreferenceNXTSearchTableLabelProvider());
        nxtsTableViewer.setInput(nxtsTableEntries);
        nxtsTable.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false));
        nxtsTable.pack();
        nxtsTableViewer.addSelectionChangedListener(new ISelectionChangedListener() {
            public void selectionChanged(final SelectionChangedEvent event) {
                // if the selection is empty do nothing
                if (event.getSelection().isEmpty()) {
                    System.out.println("XXXXXXXXXX>>> EMPTY SELECTION");
                    return;
                }
                if (event.getSelection() instanceof IStructuredSelection) {
                    IStructuredSelection selection = (IStructuredSelection) event.getSelection();
                    NXTInfo nxt = (NXTInfo) selection.getFirstElement();
                    getPreferenceStore().setValue(KlotsPreferenceConstants.P_CONNECT_TO_NAMED_BRICK,
                            true);
                    getPreferenceStore().setValue(KlotsPreferenceConstants.P_CONNECTION_BRICK_NAME,
                            nxt.name);
                    getPreferenceStore().setValue(KlotsPreferenceConstants.P_CONNECT_TO_BRICK_ADDRESS,
                            true);
                    getPreferenceStore().setValue(KlotsPreferenceConstants.P_CONNECTION_BRICK_ADDRESS,
                            nxt.deviceAddress);
                    getPreferenceStore().setValue(KlotsPreferenceConstants.P_CONNECTION_TYPE,
                            nxt.protocol == NXTCommFactory.USB
                            ? KlotsPreferenceConstants.P_PROTOCOL_USB
                                    : KlotsPreferenceConstants.P_PROTOCOL_BLUETOOTH);
                    System.out.println("XXXXXXXXXX>>>> Selected NXT >" + nxt.toString() + "<");
                    
                    // update preference page
                    connectionType.load();
                    connectToBrickAddress.load();
                    connectionBrickAddress.load();
                    connectToNamedBrick.load();
                    connectionBrickName.load();
                    currentNXTLabel2.setText(getPreferenceStore().getString(
                                    KlotsPreferenceConstants.P_CONNECTION_BRICK_NAME) + ", "
                            + getPreferenceStore().getString(
                                    KlotsPreferenceConstants.P_CONNECTION_BRICK_ADDRESS) + ", "
                            + (getPreferenceStore().getString(
                                    KlotsPreferenceConstants.P_CONNECTION_TYPE)
                                    .equals(KlotsPreferenceConstants.P_PROTOCOL_USB)
                                    ? "USB" : "BLUETOOTH"));
                    
                }
                nxtsTableViewer.refresh(false);
            }
        });
        
        // current NXT labels
        currentNXTLabel1 = new Label(this.getFieldEditorParent(), SWT.LEAD | SWT.BOLD);
        currentNXTLabel1.setText("Currently used NXT:");
        currentNXTLabel2 = new Label(this.getFieldEditorParent(),
                SWT.LEAD | SWT.BOLD | SWT.BORDER_SOLID);
        currentNXTLabel2.setText(
                getPreferenceStore().getString(KlotsPreferenceConstants.P_CONNECTION_BRICK_NAME) + ", "
                + getPreferenceStore().getString(KlotsPreferenceConstants.P_CONNECTION_BRICK_ADDRESS)
                + ", " + (getPreferenceStore().getString(KlotsPreferenceConstants.P_CONNECTION_TYPE)
                        .equals(KlotsPreferenceConstants.P_PROTOCOL_USB) ? "USB" : "BLUETOOTH"));
        
    }

    
    
    /**
     * {@inheritDoc}
     */
    public void init(final IWorkbench workbench) {
    }

    
    
    /**
     * This will create the columns for the table.
     * 
     * @param viewerParam
     *            the DataTableViewer
     */
    private void createColumns(final TableViewer viewerParam) {
        int[] bounds = { COLUMN_0_WIDTH, COLUMN_1_WIDTH, COLUMN_2_WIDTH, COLUMN_3_WIDTH };
        String[] titles = { COLUMN_0_TEXT, COLUMN_1_TEXT, COLUMN_2_TEXT, COLUMN_3_TEXT };
        String[] toolTip = { COLUMN_0_TOOLTIP, COLUMN_1_TOOLTIP, COLUMN_2_TOOLTIP, COLUMN_3_TOOLTIP };

        for (int i = 0; i < titles.length; i++) {
            TableViewerColumn column = new TableViewerColumn(viewerParam, SWT.NONE);
            column.getColumn().setWidth(bounds[i]);
            column.getColumn().setText(titles[i]);
            column.getColumn().setToolTipText(toolTip[i]);
            column.getColumn().setResizable(true);
            column.getColumn().setMoveable(true);
            if (i == 0) {
                column.getColumn().setResizable(false);
            }
        }

        Table tree = viewerParam.getTable();
        tree.setHeaderVisible(true);
        tree.setLinesVisible(true);
    }
}