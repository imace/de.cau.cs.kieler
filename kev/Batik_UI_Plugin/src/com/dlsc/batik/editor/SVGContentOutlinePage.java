/*
 * Created on 16.03.2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.dlsc.batik.editor;

import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentPartitioner;
import org.eclipse.jface.text.ITypedRegion;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.texteditor.IDocumentProvider;
import org.eclipse.ui.views.contentoutline.ContentOutlinePage;

/**
 * @author dlemmermann
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class SVGContentOutlinePage extends ContentOutlinePage {
	private IEditorInput editorInput;
	private IDocumentProvider documentProvider;
	
	/**
	 * @param provider
	 */
	public SVGContentOutlinePage(IDocumentProvider provider) {
		this.documentProvider = provider;
	}

	/**
	 * @param editorInput
	 */
	public void setInput(IEditorInput newEditorInput) {
		this.editorInput = newEditorInput;
	}
	
	public void createControl(Composite parent) {
		super.createControl(parent);

		TreeViewer viewer= getTreeViewer();
		viewer.setContentProvider(new ContentProvider());
		viewer.setLabelProvider(new LabelProvider());
		viewer.addSelectionChangedListener(this);

		if (editorInput != null) {
			viewer.setInput(editorInput);
		}
	}
	
	class ContentProvider implements ITreeContentProvider {
		private IDocumentPartitioner partitioner;
		
		/* (non-Javadoc)
		 * @see org.eclipse.jface.viewers.IContentProvider#dispose()
		 */
		public void dispose() {
			// TODO Auto-generated method stub
			
		}

		/* (non-Javadoc)
		 * @see org.eclipse.jface.viewers.IContentProvider#inputChanged(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
		 */
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			if (newInput != null) {
				IDocument document= documentProvider.getDocument(newInput);
				if (document != null) {
					partitioner = document.getDocumentPartitioner();
					ITypedRegion region = partitioner.getPartition(0);
					viewer.setInput(region);
				}
			}
		}

		/* (non-Javadoc)
		 * @see org.eclipse.jface.viewers.ITreeContentProvider#getChildren(java.lang.Object)
		 */
		public Object[] getChildren(Object parentElement) {
			if (parentElement instanceof ITypedRegion) {
				ITypedRegion region = (ITypedRegion) parentElement;
			}
			Object[] children = {"a","b","c"}; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
			return children;
		}

		/* (non-Javadoc)
		 * @see org.eclipse.jface.viewers.ITreeContentProvider#getParent(java.lang.Object)
		 */
		public Object getParent(Object element) {
			// TODO Auto-generated method stub
			return null;
		}

		/* (non-Javadoc)
		 * @see org.eclipse.jface.viewers.ITreeContentProvider#hasChildren(java.lang.Object)
		 */
		public boolean hasChildren(Object element) {
			// TODO Auto-generated method stub
			return true;
		}

		/* (non-Javadoc)
		 * @see org.eclipse.jface.viewers.IStructuredContentProvider#getElements(java.lang.Object)
		 */
		public Object[] getElements(Object inputElement) {
			Object[] children = {"a","b","c"}; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
			return children;
		}
	}
}
