/*
 * Created on 09.03.2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.dlsc.batik.editor;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.editors.text.ILocationProvider;
import org.eclipse.ui.part.EditorPart;
import com.dlsc.batik.viewer.SVGComposite;

/**
 * @author dlemmermann
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class SVGViewEditor extends EditorPart {
	private SVGComposite svgComp;
	private IPath svgPath;
	
	public SVGComposite getSVGComposite() {
		return svgComp;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.ui.ISaveablePart#doSave(org.eclipse.core.runtime.IProgressMonitor)
	 */
	public void doSave(IProgressMonitor monitor) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.ISaveablePart#doSaveAs()
	 */
	public void doSaveAs() {
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.IEditorPart#init(org.eclipse.ui.IEditorSite, org.eclipse.ui.IEditorInput)
	 */
	public void init(IEditorSite site, IEditorInput input)
			throws PartInitException {
		if (input instanceof IFileEditorInput) {
			IFileEditorInput fileIn = (IFileEditorInput) input;
			svgPath = fileIn.getFile().getRawLocation();
		} else if (input instanceof ILocationProvider) {
		    // work around for eclipse bug #58179
		    // opening an external resource always returns an instance of
		    // JavaFileEditorInput :-(
		    ILocationProvider provider = (ILocationProvider) input;
		    svgPath = provider.getPath(input);
		}
		setSite(site);
		setInput(input);
		setPartName(input.getName());
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.ISaveablePart#isDirty()
	 */
	public boolean isDirty() {
		return false;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.ISaveablePart#isSaveAsAllowed()
	 */
	public boolean isSaveAsAllowed() {
		return true;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.IWorkbenchPart#createPartControl(org.eclipse.swt.widgets.Composite)
	 */
	public void createPartControl(Composite parent) {
		svgComp = new SVGComposite(parent,SWT.NONE,true);
		svgComp.setSVGPath(svgPath);		
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.IWorkbenchPart#setFocus()
	 */
	public void setFocus() {
		svgComp.setFocus();
	}
	
	public void dispose() {
		svgComp.dispose();
		super.dispose();
	}
}
