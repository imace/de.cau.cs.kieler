package edu.unikiel.rtsys.kieler.kivik.preferences;

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.IntegerFieldEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.eclipse.ui.dialogs.PreferenceLinkArea;
import org.eclipse.ui.preferences.IWorkbenchPreferenceContainer;

import edu.unikiel.rtsys.kieler.kivik.KivikPlugin;

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

public class KivikPreferencePage extends FieldEditorPreferencePage implements
		IWorkbenchPreferencePage {

	public KivikPreferencePage() {
		super(GRID);
		setPreferenceStore(KivikPlugin.getDefault().getPreferenceStore());
		setDescription("Set options for the KiViK Plugin:"); //$NON-NLS-1$
	}

	/**
	 * Creates the field editors. Field editors are abstractions of the common
	 * GUI blocks needed to manipulate various types of preferences. Each field
	 * editor knows how to save and restore itself.
	 */
	public void createFieldEditors() {

		// define gl as GridLayout globally
		GridLayout gl = null;

		/* ========= Link to the content types page ======= */
		Group contentTypes = new Group(this.getFieldEditorParent(), SWT.NONE);
		contentTypes.setText("Content types");
		new PreferenceLinkArea(contentTypes,
				SWT.NONE,
				"org.eclipse.ui.preferencePages.ContentTypes", //$NON-NLS-1$
				"See <a>{0}</a> to define model types",
				(IWorkbenchPreferenceContainer) getContainer(), null);
		Label contentTypesDescription = new Label(contentTypes, SWT.WRAP);
		contentTypesDescription
				.setText("You have to register the content types of the models you want to compare graphically. This is done globally.");
		contentTypes.setLayoutData(new GridData(GridData.FILL, GridData.FILL,
				true, false, 2, 1));
		gl = new GridLayout(1, true);
		gl.marginWidth = 15;
		gl.marginHeight = 10;
		contentTypes.setLayout(gl);

		/* ========= link to EMF Compare page ======= */
		Group emfCompare = new Group(this.getFieldEditorParent(), SWT.NONE);
		emfCompare.setText("EMF Compare");
		new PreferenceLinkArea(emfCompare,
				SWT.NONE,
				"org.eclipse.emf.compare.ui.preferences.EMFComparePreferencesPage", //$NON-NLS-1$
				"See <a>{0}</a> to set EMF Compare options",
				(IWorkbenchPreferenceContainer) getContainer(), null);
		Label emfCompareDescription = new Label(emfCompare, SWT.WRAP);
		emfCompareDescription
				.setText("Some common options for model comparison are taken from the EMF Compare settings. You have to adjust them there.");
		emfCompare.setLayoutData(new GridData(GridData.FILL, GridData.FILL,
				true, false, 2, 1));
		gl = new GridLayout(1, true);
		gl.marginWidth = 15;
		gl.marginHeight = 10;
		emfCompare.setLayout(gl);

		/* ========= options group ======= */
		Group options = new Group(this.getFieldEditorParent(), SWT.NONE);
		options.setText("Options");

		/* selection */
		BooleanFieldEditor selectable = new BooleanFieldEditor(
				PreferenceConstants.PREF_KIVIK_ENABLE_SELECTING_IN_DIAGRAM,
				"Enable selection in diagram", options);
		Label selectableDescription = new Label(options, SWT.WRAP);
		selectableDescription
				.setText("If enabled, it is possible to click on elements in one of the diagrams and to get the corresponding highlighted in the other diagram.");

		/* scrolling animation */
		BooleanFieldEditor scollingAnimation = new BooleanFieldEditor(
				PreferenceConstants.PREF_KIVIK_ENABLE_SCROLLING_ANIMATION,
				"Animate scrolling", options);
		Label scollingAnimationDescription = new Label(options, SWT.WRAP);
		scollingAnimationDescription
				.setText("If enabled, the scrolling to the corresponding changed elements is animated, mainting the mental map of the user.");

		/* zooming */
		BooleanFieldEditor zooming = new BooleanFieldEditor(
				PreferenceConstants.PREF_KIVIK_ENABLE_ZOOMING_TO_CHANGED_ELEMENTS,
				"Zoom to differences", options);
		Label zoomingDescription = new Label(options, SWT.WRAP);
		zoomingDescription
				.setText("If enabled, the viewer will zoom to the selected changed elements.");

		/* layout */
		BooleanFieldEditor layout = new BooleanFieldEditor(
				PreferenceConstants.PREF_KIVIK_ENABLE_AUTO_LAYOUT,
				"Layout diagrams", options);
		Label layoutDescription = new Label(options, SWT.WRAP);
		layoutDescription
				.setText("If enabled, it the two diagrams to compare are laid out newly from scratch.");

		/* collapsing */
		BooleanFieldEditor collapsing = new BooleanFieldEditor(
				PreferenceConstants.PREF_KIVIK_ENABLE_COLLAPSING_OF_UNCHANGED_ELEMENTS,
				"Collapse unchanged elements", options);
		Label collapsingDescription = new Label(options, SWT.WRAP);
		collapsingDescription
				.setText("If enabled, contained elements that are not changed are collapsed and hidden to the user. This forces relayout.");

		/* zoom factor */
		IntegerFieldEditor initialZoom = new IntegerFieldEditor(
				PreferenceConstants.PREF_KIVIK_INITIAL_ZOOM_FACTOR,
				"Initial zoom factor in %", options, 3);
		initialZoom.setValidRange(10, 400);

		Label initialZoomDescription = new Label(options, SWT.WRAP);
		initialZoomDescription
				.setText("Set here the zoom factor in % to which the diagrams should be scaled initially.");

		options.setLayoutData(new GridData(GridData.FILL, GridData.FILL, true,
				false, 2, 1));
		gl = new GridLayout(3, false);
		gl.marginWidth = 15;
		gl.marginHeight = 10;
		options.setLayout(gl);

		// now add all the stuff
		addField(selectable);
		addField(scollingAnimation);
		addField(zooming);
		addField(layout);
		addField(collapsing);
		addField(initialZoom);

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