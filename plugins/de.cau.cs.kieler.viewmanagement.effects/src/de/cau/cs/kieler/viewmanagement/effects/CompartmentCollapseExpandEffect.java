package de.cau.cs.kieler.viewmanagement.effects;

import org.eclipse.gmf.runtime.diagram.ui.internal.properties.Properties;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramUIMessages;
import org.eclipse.gmf.runtime.diagram.ui.requests.ChangePropertyValueRequest;

import de.cau.cs.kieler.viewmanagement.AEffect;

/**
 * This Effect collapses or expands compartments. The execute() method expands
 * while the undo method collapses.
 * 
 * @author haf
 */
public class CompartmentCollapseExpandEffect extends AEffect {

	@Override
	public void execute() {
		try {
			ChangePropertyValueRequest request = new ChangePropertyValueRequest(
					DiagramUIMessages.PropertyDescriptorFactory_CollapseCompartment,
					Properties.ID_COLLAPSED, Boolean.TRUE);
			this.getAffectedObject().performRequest(request);
		} catch (Exception e) {
			// could not be expanded, maybe the affected object is not a
			// compartment edit part
			// nothing
		}
	}

	public void undo() {
		try {
			ChangePropertyValueRequest request = new ChangePropertyValueRequest(
					DiagramUIMessages.PropertyDescriptorFactory_CollapseCompartment,
					Properties.ID_COLLAPSED, Boolean.FALSE);
			this.getAffectedObject().performRequest(request);
		} catch (Exception e) {
			// could not be expanded, maybe the affected object is not a
			// compartment edit part
			// nothing
		}

	}

}
