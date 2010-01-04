package de.cau.cs.kieler.cakefeed.ksbase.handler;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.parts.BFBTypeEditPart;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts.CFBTypeEditPart;
import de.cau.cs.kieler.ksbase.ui.handler.TransformationCommand;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.IEditorPart;

public class CakefeedTransformationCommand extends TransformationCommand {

	public CakefeedTransformationCommand(TransactionalEditingDomain domain,
			String label, IAdaptable adapter) {
		super(domain, label, adapter);
	}
	
	public boolean initalize(
            final IEditorPart editPart, final ISelection selection, final String command,
            final String fileName, final String basePackage, final String[] parameter) {
		StructuredSelection s;

        if (selection instanceof StructuredSelection) {
            s = (StructuredSelection) selection;
        } else {
            return false;
        }

        int i = 0;
        EditPart fBType = null;
        while ((fBType == null) && (i < s.size())) {
        	Object obj = s.toList().get(i);
        	if (obj instanceof EditPart) {
        		fBType = findRoot((EditPart)obj);
        	}
		}
        
        Object[] parameters = new Object[1];
        parameters[1] = fBType;
        
        component.initializeTransformation(file, command, basePackage, parameters);
        
        return true;
	}

	private EditPart findRoot(EditPart eP) {
		if (eP == null) {
			return null;
		}
		else if ((eP instanceof BFBTypeEditPart)
				|| (eP instanceof CFBTypeEditPart)
				/*|| (eP instanceof ApplicationEditPart)*/) {
			return eP;
		}
		else {
			return findRoot(eP.getParent());
		}
	}

}
