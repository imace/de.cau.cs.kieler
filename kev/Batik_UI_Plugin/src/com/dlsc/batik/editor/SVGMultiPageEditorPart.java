/*
 * Created on 09.03.2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.dlsc.batik.editor;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.MultiPageEditorPart;

import com.dlsc.batik.viewer.Messages;

/**
 * @author dlemmermann
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class SVGMultiPageEditorPart extends MultiPageEditorPart {
	private SVGEditor svgTextEditor;
	private SVGViewEditor svgViewEditor;
	private static SVGContentOutlinePage outlinePage;
	
	private static final int CODE_PAGE = 0;
	private static final int PREVIEW_PAGE = 1;
	
	//@@todo:this should be a preference setting
	private static int LAST_EDITOR_USED = CODE_PAGE;
	
	/* (non-Javadoc)
	 * @see org.eclipse.ui.part.MultiPageEditorPart#createPages()
	 */
	protected void createPages() {
		try {
			svgTextEditor = new SVGEditor();
			svgViewEditor = new SVGViewEditor();
			
			int codeIndex = addPage(svgTextEditor,getEditorInput());
			setPageText(codeIndex,Messages.getString("SVGMultiPageEditorPart.SOURCE")); //$NON-NLS-1$
			setPartName(getEditorInput().getName());
			int previewIndex = addPage(svgViewEditor,getEditorInput());
			setPageText(previewIndex,Messages.getString("SVGMultiPageEditorPart.PREVIEW")); //$NON-NLS-1$
			
			switch(LAST_EDITOR_USED) {
				case CODE_PAGE:
					setActivePage(codeIndex);
					break;
				case PREVIEW_PAGE:
					setActivePage(previewIndex);
					break;
				default:
					break;
			}
		} catch (PartInitException e) {
			e.printStackTrace();
		}	
		
	}
	
	public void pageChange(int index) {
		super.pageChange(index);
		LAST_EDITOR_USED = index;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.ISaveablePart#doSave(org.eclipse.core.runtime.IProgressMonitor)
	 */
	public void doSave(IProgressMonitor monitor) {
		svgTextEditor.doSave(monitor);

	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.ISaveablePart#doSaveAs()
	 */
	public void doSaveAs() {
		svgTextEditor.doSaveAs();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.ISaveablePart#isSaveAsAllowed()
	 */
	public boolean isSaveAsAllowed() {
		return true;
	}
	
	//@@todo:dl work in progress
//	public Object getAdapter(Class required) {
//		if (IContentOutlinePage.class.equals(required)) {
//			if (outlinePage == null) {
//				IDocumentProvider provider = svgTextEditor.getDocumentProvider();
//				outlinePage= new SVGContentOutlinePage(provider);
//				if (getEditorInput() != null) {
//					outlinePage.setInput(getEditorInput());
//				}
//			}
//			return outlinePage;
//		}
//		return super.getAdapter(required);
//	}
	
	public SVGEditor getSvgTextEditor() {
		return svgTextEditor;
	}
	
	public SVGViewEditor getSvgViewEditor() {
		return svgViewEditor;
	}
	
	public void dispose() {
		svgViewEditor.dispose();
		svgTextEditor.dispose();
		super.dispose();
	}
}
