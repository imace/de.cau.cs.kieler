/*******************************************************************************
 * Copyright (c) 2006, 2007, 2008 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package de.cau.cs.kieler.kivik.viewer.structure;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.compare.CompareConfiguration;
import org.eclipse.compare.structuremergeviewer.ICompareInput;
import org.eclipse.emf.compare.EMFCompareException;
import org.eclipse.emf.compare.diff.metamodel.ComparisonSnapshot;
import org.eclipse.emf.compare.diff.metamodel.DiffModel;
import org.eclipse.emf.compare.diff.metamodel.ComparisonResourceSnapshot;
import org.eclipse.emf.compare.diff.metamodel.util.DiffAdapterFactory;
import org.eclipse.emf.compare.ui.EMFCompareUIMessages;
import org.eclipse.emf.compare.ui.ModelCompareInput;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;

import de.cau.cs.kieler.kivik.internal.KivikComparator;


/**
 */
public class ModelStructureContentProvider implements ITreeContentProvider {
	/** Keeps track of the comparison result. */
	/* package */ComparisonResourceSnapshot snapshot;

	/**
	 * {@link CompareConfiguration} controls various aspect of the GUI elements. This will keep track of the
	 * one used to created this compare editor.
	 */
	private final CompareConfiguration configuration;

	/**
	 * {@link DiffModel} result of the underlying comparison. This contains the data for this content
	 * provider.
	 */
	private DiffModel diffInput;

	/**
	 * Instantiates a content provider given the {@link CompareConfiguration} to use.
	 * 
	 * @param compareConfiguration
	 *            {@link CompareConfiguration} used for this comparison.
	 */
	public ModelStructureContentProvider(CompareConfiguration compareConfiguration) {
		configuration = compareConfiguration;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.viewers.IContentProvider#dispose()
	 */
	public void dispose() {
		KivikComparator.removeKivikComparator(configuration);
		diffInput = null;
		snapshot = null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see ITreeContentProvider#getChildren(Object)
	 */
	public Object[] getChildren(Object parentElement) {
		Object[] children = null;
		if (parentElement instanceof EObject) {
			final Collection<EObject> childrenList = new ArrayList<EObject>();
			for (EObject child : ((EObject)parentElement).eContents()) {
				if (!DiffAdapterFactory.shouldBeHidden(child))
					childrenList.add(child);
			}
			children = childrenList.toArray();
		}
		return children;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.viewers.IStructuredContentProvider#getElements(Object)
	 */
	public Object[] getElements(Object inputElement) {
		Object[] elements = null;
		if (inputElement instanceof DiffModel) {
			elements = ((DiffModel)inputElement).getOwnedElements().toArray();
		} else {
			try {
				elements = diffInput.getOwnedElements().toArray();
			} catch (NullPointerException e) {
				throw new EMFCompareException(EMFCompareUIMessages
						.getString("ModelStructureContentProvider.inputException")); //$NON-NLS-1$
			}
		}
		return elements;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see ITreeContentProvider#getParent(Object)
	 */
	public Object getParent(Object element) {
		Object parent = null;
		if (element instanceof EObject) {
			parent = ((EObject)element).eContainer();
		}
		return parent;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see ITreeContentProvider#hasChildren(Object)
	 */
	public boolean hasChildren(Object element) {
		boolean hasChildren = false;
		if (element instanceof EObject) {
			hasChildren = !((EObject)element).eContents().isEmpty();
		}
		return hasChildren;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.viewers.IContentProvider#inputChanged(Viewer, Object, Object)
	 */
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		((TreeViewer)viewer).getTree().clearAll(true);
		final KivikComparator kivikComparator = KivikComparator
		.getKivikComparator(configuration);
		if (newInput instanceof ComparisonResourceSnapshot) {
			snapshot = (ComparisonResourceSnapshot)newInput;
		} else if (kivikComparator.getDomainComparisonResult() != null) {
			snapshot = kivikComparator.getDomainComparisonResult();
		} else if (oldInput != newInput && newInput instanceof ICompareInput) {
			kivikComparator.loadResources((ICompareInput)newInput);			
			snapshot = kivikComparator.compareDomainModel();
		}
		diffInput = snapshot.getDiff();
	}
}
