/*******************************************************************************
 * Copyright (c) 2008 Real-Time and Embedded Systems group
 *
 * INSERT LICENCE HERE
 *
 *
 * Author: Arne Schipper, ars@informatik.uni-kiel.de 
 *
 *******************************************************************************/
package edu.unikiel.rtsys.kieler.kiml.ui.properties.tabbed.sections;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.Animation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphPackage;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.LAYOUTER_INFO;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.LAYOUT_TYPE;
import edu.unikiel.rtsys.kieler.kiml.layout.services.DiagramLayouters;
import edu.unikiel.rtsys.kieler.kiml.layout.services.LayoutProviders;
import edu.unikiel.rtsys.kieler.kiml.ui.helpers.KimlGMFLayoutHintHelper;

public class KimlLayoutTypePropertySection extends
		AbstractKimlEnumerationPropertySection {

	Button apply;
	Button removeAllHints;
	Button applyToAll;

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

	private void handleRemoveAllHints() {
		if (eObjectList.size() == 1) {
			KimlGMFLayoutHintHelper.unsetAllContainedElementsLayoutHints(e2Gep
					.get(eObject));

			performLayout();
		}
	}

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
			/* here Emma has a concrete layout provider */
			if (stringValue.substring(0, 2).equals("  ")) {
				LAYOUTER_INFO layouterInfo = LayoutProviders.getInstance()
						.getLayouterInfoForLayouterName(stringValue.trim());
				KimlGMFLayoutHintHelper.setAllContainedElementsLayoutHints(
						e2Gep.get(eObject), layouterInfo.getLayoutType(),
						layouterInfo.getLayouterName());
			}
			/* she has just a layout type */
			else {
				KimlGMFLayoutHintHelper.setAllContainedElementsLayoutHints(
						e2Gep.get(eObject), (LAYOUT_TYPE.get(stringValue)), "");
			}

			performLayout();
		}
	}

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
			/* here Emma has a concrete layout provider */
			if (stringValue.substring(0, 2).equals("  ")) {
				LAYOUTER_INFO layouterInfo = LayoutProviders.getInstance()
						.getLayouterInfoForLayouterName(stringValue.trim());
				KimlGMFLayoutHintHelper.setContainedElementsLayoutHint(e2Gep
						.get(eObject), layouterInfo.getLayoutType(),
						layouterInfo.getLayouterName());
			}
			/* she has just a layout type */
			else {
				KimlGMFLayoutHintHelper.unsetContainedElementsLayoutHint(e2Gep
						.get(eObject));
				KimlGMFLayoutHintHelper.setContainedElementsLayoutType(e2Gep
						.get(eObject), (LAYOUT_TYPE.get(stringValue)));
			}
			performLayout();
		}
	}

	private void performLayout() {
		String editorID = PlatformUI.getWorkbench().getActiveWorkbenchWindow()
				.getActivePage().getActiveEditor().getEditorSite().getId();
		Animation.markBegin();
		DiagramLayouters.getInstance().getDiagramLayouter(editorID).layout(
				e2Gep.get(eObject).getRoot().getViewer().getContents());
		Animation.run(1000);
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
		return KimlLayoutGraphPackage.eINSTANCE.getLAYOUTER_INFO_LayoutType();
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
	 * @see org.eclipse.ui.examples.views.properties.tabbed.hockeyleague.ui.properties.sections.AbstractEnumerationPropertySection#getEnumerationFeatureValues()
	 */
	protected String[] getEnumerationFeatureValues() {
		List<LAYOUT_TYPE> values = LAYOUT_TYPE.VALUES;
		ArrayList<String> valueList = new ArrayList<String>();

		/* make sure default is always on the list */
		valueList.add(LAYOUT_TYPE.DEFAULT.getLiteral());

		/*
		 * iterate through layout types and add the type as some kind of parent
		 * section, and then add all the layout providers for this type
		 */
		for (LAYOUT_TYPE value : values) {

			/* add parent section delimiter */
			valueList.add(value.getLiteral());
			boolean somethingAdded = false;
			for (LAYOUTER_INFO layouterInfo : LayoutProviders.getInstance()
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
