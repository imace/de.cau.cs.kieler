package dataflow.diagram.services;

import org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderedShapeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.jface.viewers.LabelProvider;

/**
 * @author msp
 *
 */
public class DataflowLabelProvider extends LabelProvider {

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.jface.viewers.LabelProvider#getText(java.lang.Object)
	 */
	public String getText(Object element) {
		if (element instanceof AbstractBorderedShapeEditPart) {
			AbstractBorderedShapeEditPart boxEditPart = (AbstractBorderedShapeEditPart)element;
			for (Object child : boxEditPart.getChildren()) {
				if (child instanceof ITextAwareEditPart) {
					ITextAwareEditPart nameEditPart = (ITextAwareEditPart)child;
					return nameEditPart.getEditText();
				}
			}
		}
		
		// fetching of element name failed, get class name
		return element.getClass().getSimpleName();
	}

}
