package edu.unikiel.rtsys.kieler.kiml.layouter.graphviz.preferences;

import kiel.layouter.graphviz.CircoLayoutProvider;
import kiel.layouter.graphviz.DotLayoutProvider;
import kiel.layouter.graphviz.NeatoLayoutProvider;
import kiel.layouter.graphviz.TwopiLayoutProvider;

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.DirectoryFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.IntegerFieldEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import edu.unikiel.rtsys.kieler.kiml.layouter.graphviz.Activator;

/**
 * This class represents a preference page that is contributed to the
 * Preferences dialog. By subclassing <samp>FieldEditorPreferencePage</samp>, we
 * can use the field support built into JFace that allows us to create a page
 * that is small and knows how to save, restore and apply itself.
 * <p>
 * This page is used to modify preferences only. They are stored in the
 * preference store that belongs to the main plug-in class. That way,
 * preferences can be accessed directly via the preference store.
 */

public class GraphvizPreferencePage extends FieldEditorPreferencePage implements
		IWorkbenchPreferencePage {

	public GraphvizPreferencePage() {
		super(GRID);
		setPreferenceStore(Activator.getDefault().getPreferenceStore());
		setDescription("Set the options for the GraphViz layout engine");
	}

	/**
	 * Creates the field editors. Field editors are abstractions of the common
	 * GUI blocks needed to manipulate various types of preferences. Each field
	 * editor knows how to save and restore itself.
	 */
	public void createFieldEditors() {
		// define gl as GridLayout globally
		GridLayout gl = null;

		// padding group
		Group padding = new Group(this.getFieldEditorParent(), SWT.NONE);
		padding.setText("Padding:");

		IntegerFieldEditor padx = new IntegerFieldEditor(
				PreferenceConstants.PREF_GRAPHVIZ_PADDING_X, "Padding X:",
				padding, 2);

		IntegerFieldEditor pady = new IntegerFieldEditor(
				PreferenceConstants.PREF_GRAPHVIZ_PADDING_Y, "Padding Y:",
				padding, 2);
		padding.setLayoutData(new GridData(GridData.FILL, GridData.FILL, true,
				false, 3, 1));
		gl = new GridLayout(3, true);
		gl.marginWidth = 15;
		gl.marginHeight = 10;
		padding.setLayout(gl);

		// layouters group
		Group availableLayouters = new Group(this.getFieldEditorParent(),
				SWT.NONE);
		availableLayouters.setText("Available Layouters");
		// KimlLayoutUtilPreferencePage.createLayouterTable(availableLayouters,
		// new GraphvizLayoutProvider());
		Table layouterTable = new Table(availableLayouters, SWT.BORDER);
		layouterTable.setLinesVisible(true);
		layouterTable.setHeaderVisible(true);
		// layouterTable.setEnabled(false);

		TableColumn layouterName = new TableColumn(layouterTable, SWT.NONE);
		layouterName.setText("Layouter name");
		TableColumn layoutType = new TableColumn(layouterTable, SWT.NONE);
		layoutType.setText("Layout type");
		TableColumn layoutOptions = new TableColumn(layouterTable, SWT.NONE);
		layoutOptions.setText("Layout options");

		/* CIRCO */
		TableItem circo = new TableItem(layouterTable, SWT.NONE);
		circo.setText(0, CircoLayoutProvider.LAYOUT_PROVIDER_NAME);
		circo.setText(1, CircoLayoutProvider.LAYOUT_PROVIDER_LAYOUT_TYPE.getLiteral());
		circo.setText(2, CircoLayoutProvider.LAYOUT_PROVIDER_LAYOUT_OPTION.getLiteral());
		
		/* DOT */
		TableItem dot = new TableItem(layouterTable, SWT.NONE);
		dot.setText(0, DotLayoutProvider.LAYOUT_PROVIDER_NAME);
		dot.setText(1, DotLayoutProvider.LAYOUT_PROVIDER_LAYOUT_TYPE.getLiteral());
		dot.setText(2, DotLayoutProvider.LAYOUT_PROVIDER_LAYOUT_OPTION.getLiteral());
		
		/* NEATO */
		TableItem neato = new TableItem(layouterTable, SWT.NONE);
		neato.setText(0, NeatoLayoutProvider.LAYOUT_PROVIDER_NAME);
		neato.setText(1, NeatoLayoutProvider.LAYOUT_PROVIDER_LAYOUT_TYPE.getLiteral());
		neato.setText(2, NeatoLayoutProvider.LAYOUT_PROVIDER_LAYOUT_OPTION.getLiteral());

		/* TWOPI */
		TableItem twopi = new TableItem(layouterTable, SWT.NONE);
		twopi.setText(0, TwopiLayoutProvider.LAYOUT_PROVIDER_NAME);
		twopi.setText(1, TwopiLayoutProvider.LAYOUT_PROVIDER_LAYOUT_TYPE.getLiteral());
		twopi.setText(2, TwopiLayoutProvider.LAYOUT_PROVIDER_LAYOUT_OPTION.getLiteral());

		layouterName.pack();
		layoutType.pack();
		availableLayouters.setLayoutData(new GridData(GridData.FILL,
				GridData.FILL, true, false, 3, 1));
		gl = new GridLayout();
		gl.marginWidth = 15;
		gl.marginHeight = 10;
		availableLayouters.setLayout(gl);

		// debug group
		Group debug = new Group(this.getFieldEditorParent(), SWT.NONE);
		debug.setText("Debug:");

		BooleanFieldEditor enableDebug = new BooleanFieldEditor(
				PreferenceConstants.PREF_GRAPHVIZ_ENABLE_DEBUG_OUTPUT,
				"Enable debug output (*.dot)", debug);
		DirectoryFieldEditor debugDir = new DirectoryFieldEditor(
				PreferenceConstants.PREF_GRAPHVIZ_DEBUG_DIR,
				"Debug directory:", debug);
		Label description = new Label(debug, SWT.WRAP);
		description
				.setText("If a directory is chosen, debug output of GraphViz (the *.dot files) go there. Otherwise the user home directory is chosen.");
		description.setLayoutData(new GridData(GridData.FILL, GridData.FILL,
				true, true, 2, 1));
		debug.setLayoutData(new GridData(GridData.FILL, GridData.FILL, true,
				false, 3, 2));
		gl = new GridLayout(3, false);
		gl.marginWidth = 15;
		gl.marginHeight = 10;
		debug.setLayout(gl);

		// now add all the stuff
		addField(padx);
		addField(pady);

		addField(enableDebug);
		addField(debugDir);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.IWorkbenchPreferencePage#init(org.eclipse.ui.IWorkbench)
	 */
	public void init(IWorkbench workbench) {

	}

}