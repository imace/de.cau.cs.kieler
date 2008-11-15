package edu.unikiel.rtsys.kieler.ssm.gmf.diagram.layouter.properties.sections;

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;

import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphPackage;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.LAYOUT_TYPE;
import edu.unikiel.rtsys.kieler.kiml.layout.services.DiagramLayouters;
import edu.unikiel.rtsys.kieler.kiml.ui.helpers.KimlGMFLayoutHintHelper;
import edu.unikiel.rtsys.kieler.kiml.ui.properties.tabbed.sections.AbstractKimlEnumerationPropertySection;
import edu.unikiel.rtsys.kieler.ssm.diagram.part.SafeStateMachineDiagramEditor;

public class KimlLayoutTypePropertySection extends
		AbstractKimlEnumerationPropertySection {

	/**
	 * Handle the combo modified event.
	 */
	protected void handleComboModified() {

		int index = combo.getSelectionIndex();
		boolean equals = isEqual(index);
		if (!equals) {
			EditingDomain editingDomain = getEditingDomain();
			Object value = getFeatureValue(index);
			if (eObjectList.size() == 1) {
				/* apply the property change to single selected object */
				KimlGMFLayoutHintHelper.setContainedElementsLayoutType(e2Gep.get(eObject), (LAYOUT_TYPE)value);
			} else {
				CompoundCommand compoundCommand = new CompoundCommand();
				/* apply the property change to all selected elements */
				for (Iterator<EObject> i = eObjectList.iterator(); i.hasNext();) {
					EObject nextObject = i.next();
					compoundCommand.append(SetCommand.create(editingDomain,
						nextObject, getFeature(), value));
				}
				editingDomain.getCommandStack().execute(compoundCommand);
			}
			DiagramLayouters.getInstance().getDiagramLayouter(SafeStateMachineDiagramEditor.ID).layout(e2Gep.get(eObject).getRoot().getViewer().getContents());
		}
	}
	
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
		return KimlGMFLayoutHintHelper.getContainedElementsLayoutType(e2Gep.get(eObject)).getLiteral();
	}

	/**
	 * @see org.eclipse.ui.examples.views.properties.tabbed.hockeyleague.ui.properties.sections.AbstractEnumerationPropertySection#getFeatureValue(int)
	 */
	protected Object getFeatureValue(int index) {
		return LAYOUT_TYPE.VALUES.get(index);
	}

	/**
	 * @see org.eclipse.ui.examples.views.properties.tabbed.hockeyleague.ui.properties.sections.AbstractEnumerationPropertySection#getLabelText()
	 */
	protected String getLabelText() {
		return "Layout Type:";//$NON-NLS-1$
	}

	/**
	 * @see org.eclipse.ui.examples.views.properties.tabbed.hockeyleague.ui.properties.sections.AbstractEnumerationPropertySection#isEqual(int)
	 */
	protected boolean isEqual(int index) {
		return LAYOUT_TYPE.VALUES.get(index).getLiteral().equals(getFeatureAsText());
	}

	/**
	 * @see org.eclipse.ui.examples.views.properties.tabbed.hockeyleague.ui.properties.sections.AbstractEnumerationPropertySection#getEnumerationFeatureValues()
	 */
	protected String[] getEnumerationFeatureValues() {
		List<LAYOUT_TYPE> values = LAYOUT_TYPE.VALUES;
		String[] ret = new String[values.size()];
		for (int i = 0; i < values.size(); i++) {
			ret[i] = values.get(i).getLiteral();
		}
		return ret;
	}
}
