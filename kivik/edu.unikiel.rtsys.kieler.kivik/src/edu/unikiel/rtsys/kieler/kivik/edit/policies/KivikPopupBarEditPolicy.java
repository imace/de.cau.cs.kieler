package edu.unikiel.rtsys.kieler.kivik.edit.policies;

import java.util.Iterator;
import java.util.List;

import org.eclipse.gmf.runtime.common.ui.services.icon.IconService;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.PopupBarEditPolicy;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.ui.services.modelingassistant.ModelingAssistantService;

public class KivikPopupBarEditPolicy extends PopupBarEditPolicy {

	@Override
	protected void fillPopupBarDescriptors() {
		List types = ModelingAssistantService.getInstance()
				.getTypesForPopupBar(getHost());
		for (Iterator iter = types.iterator(); iter.hasNext();) {
			Object type = iter.next();
			if (type instanceof IElementType) {
				addPopupBarDescriptor((IElementType) type, IconService
						.getInstance().getIcon((IElementType) type));
			}
		}
	}
}
