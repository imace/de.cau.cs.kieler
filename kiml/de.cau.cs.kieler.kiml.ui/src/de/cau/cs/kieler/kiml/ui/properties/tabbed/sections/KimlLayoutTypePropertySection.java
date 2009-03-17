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
package de.cau.cs.kieler.kiml.ui.properties.tabbed.sections;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.CompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutType;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayouterInfo;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphPackage;
import de.cau.cs.kieler.kiml.layout.services.KimlLayoutServices;
import de.cau.cs.kieler.kiml.ui.diagramlayouter.KimlDiagramLayouter;
import de.cau.cs.kieler.kiml.ui.helpers.KimlGMFLayoutHintHelper;

/**
 * The section displaying the Kiml Layout Hints in a tab in the properties view.
 * Information about the currently selected object is available and layout
 * functions can be triggered on this object.
 * 
 * @author <a href="mailto:ars@informatik.uni-kiel.de">Arne Schipper</a>
 */
public class KimlLayoutTypePropertySection extends
		AbstractKimlEnumerationPropertySection {

	/* the three buttons */
	Button apply;
	Button removeAllHints;
	Button applyToAll;

	/**
	 * Creates the actual property section.
	 * 
	 * @see de.cau.cs.kieler.kiml.ui.properties.tabbed.sections.AbstractKimlEnumerationPropertySection#createControls(org.eclipse.swt.widgets.Composite,
	 *      org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage)
	 */
	public void createControls(Composite parent,
			TabbedPropertySheetPage aTabbedPropertySheetPage) {

		parent.setLayoutData(new GridData(GridData.FILL, GridData.FILL, true,
				false, 1, 1));
		GridLayout gl = new GridLayout(1, true);
		gl.marginWidth = 15;
		gl.marginHeight = 10;
		parent.setLayout(gl);

		super.createControls(parent, aTabbedPropertySheetPage);

		Composite composite = getWidgetFactory()
				.createFlatFormComposite(parent);
		FormData data;

		removeAllHints = getWidgetFactory().createButton(composite,
				"Remove all Hints", SWT.PUSH);
		data = new FormData();
		data.left = new FormAttachment(ITabbedPropertyConstants.HMARGIN,
				ITabbedPropertyConstants.HSPACE);
		data.top = new FormAttachment(0, ITabbedPropertyConstants.VSPACE);
		removeAllHints.setLayoutData(data);

		applyToAll = getWidgetFactory().createButton(composite,
				"Apply to whole Diagram", SWT.PUSH);
		data = new FormData();
		data.left = new FormAttachment(removeAllHints,
				ITabbedPropertyConstants.HSPACE);
		data.top = new FormAttachment(0, ITabbedPropertyConstants.VSPACE);
		applyToAll.setLayoutData(data);

		apply = getWidgetFactory().createButton(composite, "Apply", SWT.PUSH);
		data = new FormData();
		data.left = new FormAttachment(applyToAll, 0);
		data.top = new FormAttachment(0, ITabbedPropertyConstants.VSPACE);
		apply.setLayoutData(data);

		SelectionListener buttonListener = new SelectionListener() {

			public void widgetSelected(SelectionEvent e) {
				if (e.getSource().equals(apply))
					handleApply();
				else if (e.getSource().equals(applyToAll))
					handleApplyToAll();
				else if (e.getSource().equals(removeAllHints))
					handleRemoveAllHints();
			}

			public void widgetDefaultSelected(SelectionEvent e) {
				widgetSelected(e);
			}

		};
		apply.addSelectionListener(buttonListener);
		applyToAll.addSelectionListener(buttonListener);
		removeAllHints.addSelectionListener(buttonListener);

	}

	/**
	 * Handles the removal of layout hints.
	 */
	private void handleRemoveAllHints() {
		if (eObjectList.size() == 1) {
			KimlGMFLayoutHintHelper.unsetAllContainedElementsLayoutHints(e2Gep
					.get(eObject));

			performLayout();
		}
	}

	/**
	 * Handles the application of the selected layout hint to all elements in
	 * the diagram.
	 */
	private void handleApplyToAll() {
		int index = combo.getSelectionIndex();

		Object value = getFeatureValue(index);
		if (eObjectList.size() == 1) {
			/*
			 * check if just a general layout type, or a concrete layouter was
			 * selected. A layouter starts with 2 SPACES, a layout type starts
			 * directly with the type literal
			 */
			String stringValue = (String) value;
			GraphicalEditPart editPart = getSemanticEditPart();
			/* here Emma has a concrete layout provider */
			if (stringValue.substring(0, 2).equals("  ")) {
				KLayouterInfo layouterInfo = KimlLayoutServices.getInstance()
						.getLayouterInfoForLayouterName(stringValue.trim());
				KimlGMFLayoutHintHelper.setAllContainedElementsLayoutHints(
						editPart, layouterInfo.getLayoutType(), layouterInfo
								.getLayouterName());
			}
			/* she has just a layout type */
			else {
				KimlGMFLayoutHintHelper.setAllContainedElementsLayoutHints(
						editPart, (KLayoutType.get(stringValue)), "");
			}

			performLayout();
		}
	}

	/**
	 * Handles the application of the layout hint to the selected element.
	 */
	private void handleApply() {
		int index = combo.getSelectionIndex();

		Object value = getFeatureValue(index);
		if (eObjectList.size() == 1) {
			/*
			 * check if just a general layout type, or a concrete layouter was
			 * selected. A layouter starts with 2 SPACES, a layout type starts
			 * directly with the type literal
			 */
			String stringValue = (String) value;
			GraphicalEditPart editPart = getSemanticEditPart();
			/* here Emma has a concrete layout provider */
			if (stringValue.substring(0, 2).equals("  ")) {
				KLayouterInfo layouterInfo = KimlLayoutServices.getInstance()
						.getLayouterInfoForLayouterName(stringValue.trim());
				KimlGMFLayoutHintHelper.setContainedElementsLayoutHint(
						editPart, layouterInfo.getLayoutType(), layouterInfo
								.getLayouterName());
			}
			/* she has just a layout type */
			else {
				KimlGMFLayoutHintHelper
						.unsetContainedElementsLayoutHint(editPart);
				KimlGMFLayoutHintHelper.setContainedElementsLayoutType(
						editPart, (KLayoutType.get(stringValue)));
			}
			performLayout();
		}
	}

	/**
	 * Is called when the layout hint was changed and performs a new layout.
	 */
	private void performLayout() {
		KimlDiagramLayouter.layout(getSemanticEditPart().getRoot().getViewer()
				.getContents(), true, true);
	}

	/**
	 * Helper function to get the <i>real</i> EditPart if just a compartment of
	 * a composite EditPart was selected
	 * 
	 * @return The <i>real</i> parent EditPart if a compartment is selected, the
	 *         selected EditPart else.
	 */
	private GraphicalEditPart getSemanticEditPart() {
		EditPart parent;
		if (e2Gep.get(eObject) instanceof CompartmentEditPart
				&& (parent = ((CompartmentEditPart) e2Gep.get(eObject))
						.getParent()) instanceof GraphicalEditPart)
			return (GraphicalEditPart) parent;
		else
			return e2Gep.get(eObject);
	}

	/**
	 * nothing here, processing is done when clicking the buttons. method must
	 * be here nevertheless, to overwrite method in superclass.
	 */
	protected void handleComboModified() {
		;
	}

	// ================================================================================================/
	// METHODS FOR THE COMBOBOX FOLLOWING /
	// ================================================================================================/

	/**
	 * @see org.eclipse.ui.examples.views.properties.tabbed.hockeyleague.ui.properties.sections.AbstractEnumerationPropertySection#getFeature()
	 */
	protected EAttribute getFeature() {
		return KimlLayoutGraphPackage.eINSTANCE.getKLayouterInfo_LayoutType();
	}

	/**
	 * @see org.eclipse.ui.examples.views.properties.tabbed.hockeyleague.ui.properties.sections.AbstractEnumerationPropertySection#getFeatureAsText()
	 */
	protected String getFeatureAsText() {
		String layouterName = KimlGMFLayoutHintHelper
				.getContainedElementsLayouterName(e2Gep.get(eObject));
		if (layouterName != null && !layouterName.equals("")) {
			return "  " + layouterName;
		} else {
			return KimlGMFLayoutHintHelper.getContainedElementsLayoutType(
					e2Gep.get(eObject)).getLiteral();
		}
	}

	/**
	 * @see org.eclipse.ui.examples.views.properties.tabbed.hockeyleague.ui.properties.sections.AbstractEnumerationPropertySection#getFeatureValue(int)
	 */
	protected Object getFeatureValue(int index) {
		return getEnumerationFeatureValues()[index];
	}

	/**
	 * @see org.eclipse.ui.examples.views.properties.tabbed.hockeyleague.ui.properties.sections.AbstractEnumerationPropertySection#getLabelText()
	 */
	protected String getLabelText() {
		return "Layouter and type:";//$NON-NLS-1$
	}

	/**
	 * @see org.eclipse.ui.examples.views.properties.tabbed.hockeyleague.ui.properties.sections.AbstractEnumerationPropertySection#isEqual(int)
	 */
	protected boolean isEqual(int index) {
		return getEnumerationFeatureValues()[index].equals(getFeatureAsText());
	}

	/**
	 * Fetches the values (Strings) to display in the Combobox.
	 * 
	 * @see org.eclipse.ui.examples.views.properties.tabbed.hockeyleague.ui.properties.sections.AbstractEnumerationPropertySection#getEnumerationFeatureValues()
	 */
	protected String[] getEnumerationFeatureValues() {
		List<KLayoutType> values = KLayoutType.VALUES;
		ArrayList<String> valueList = new ArrayList<String>();

		/* make sure default is always on the list */
		valueList.add(KLayoutType.DEFAULT.getLiteral());

		/*
		 * iterate through layout types and add the type as some kind of parent
		 * section, and then add all the layout providers for this type
		 */
		for (KLayoutType value : values) {

			/* add parent section delimiter */
			valueList.add(value.getLiteral());
			boolean somethingAdded = false;
			for (KLayouterInfo layouterInfo : KimlLayoutServices.getInstance()
					.getEnabledLayouterInfos()) {
				/* add the layout provider with some identation */
				if (layouterInfo.getLayoutType().equals(value)) {
					valueList.add("  " + layouterInfo.getLayouterName());
					somethingAdded = true;
				}
			}

			/*
			 * if no layout provider for the current layout type was added,
			 * removed this parent section
			 */
			if (!somethingAdded) {
				valueList.remove(valueList.size() - 1);
			}
		}

		return valueList.toArray(new String[] {});
	}
}
