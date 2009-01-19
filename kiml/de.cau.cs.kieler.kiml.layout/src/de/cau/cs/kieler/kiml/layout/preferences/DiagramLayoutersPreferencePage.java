/*******************************************************************************
 * Copyright (c) 2008 Real-Time and Embedded Systems group
 *
 * INSERT LICENCE HERE
 *
 *
 * Author: Arne Schipper, ars@informatik.uni-kiel.de 
 *
 *******************************************************************************/
package de.cau.cs.kieler.kiml.layout.preferences;

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import de.cau.cs.kieler.kiml.layout.KimlLayoutPlugin;
import de.cau.cs.kieler.kiml.layout.util.KimlLayoutPreferenceConstants;


/**
 * The Diagram Layouters preference page. This places a page into the
 * preferences with options for all DiagramLayouters. Specific DiagramLayouters
 * should place their own preference page below this one. Settings for this can
 * be made in the respective plugin.xml file.
 * 
 * @author <a href="mailto:ars@informatik.uni-kiel.de">Arne Schipper</a>
 * @see de.cau.cs.kieler.kiml.layout.services.DiagramLayouters
 *      DiagramLayouters
 * @see de.cau.cs.kieler.kiml.layout.services.KimlAbstractLayouter
 *      KimlAbstractLayouter
 */
public class DiagramLayoutersPreferencePage extends FieldEditorPreferencePage
		implements IWorkbenchPreferencePage {

	/**
	 * Creates a new preference page for the diagram layouters.
	 */
	public DiagramLayoutersPreferencePage() {
		super(GRID);
		setPreferenceStore(KimlLayoutPlugin.getDefault().getPreferenceStore());
		setDescription("Set the options for the KIML Diagram Layouters");
	}

	/**
	 * Creates the field editors for the various options.
	 */
	public void createFieldEditors() {

		/* use GMF for Connection lables */
		addField(new BooleanFieldEditor(
				KimlLayoutPreferenceConstants.PREF_DIAGRAMLAYOUTERS_USE_GMF_TO_LAYOUT_CONNECTION_LABELS,
				"Use GMF to layout connection lables", getFieldEditorParent()));
		Label descriptionGMF = new Label(getFieldEditorParent(), SWT.WRAP);
		descriptionGMF
				.setText("If checked do not use the layout information provided by the layout engine to layout the labels. Use the internal functions of the graphical editor, if it has any. Might lead to a better placement.");

		/* smoothen edges (simulates bezier curves) */
		addField(new BooleanFieldEditor(
				KimlLayoutPreferenceConstants.PREF_DIAGRAMLAYOUTERS_SMOOTHEN_EDGES,
				"Smoothen edges", getFieldEditorParent()));
		Label descriptionSmooth = new Label(getFieldEditorParent(), SWT.WRAP);
		descriptionSmooth.setText("If checked, smoothen the edges.");

		/* multiple layout runs */
		addField(new BooleanFieldEditor(
				KimlLayoutPreferenceConstants.PREF_DIAGRAMLAYOUTERS_MULTIPLE_LAYOUT_RUNS,
				"Mutliple layout runs", getFieldEditorParent()));
		Label descriptionMultipleRuns = new Label(getFieldEditorParent(),
				SWT.WRAP);
		descriptionMultipleRuns
				.setText("If checked, two or three runs of the layout process are performed to get a sound layout directly. A workaround for the problem with the edges and labels due to their relative positions. Note that this affects the animation.");

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
