package edu.unikiel.rtsys.kieler.kivik.viewer;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.compare.CompareConfiguration;
import org.eclipse.compare.structuremergeviewer.ICompareInput;
import org.eclipse.emf.compare.EMFCompareException;
import org.eclipse.emf.compare.diff.metamodel.DiffModel;
import org.eclipse.emf.compare.diff.metamodel.ModelInputSnapshot;
import org.eclipse.emf.compare.diff.metamodel.util.DiffAdapterFactory;
import org.eclipse.emf.compare.ui.EMFCompareUIMessages;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

import edu.unikiel.rtsys.kieler.kivik.internal.KivikComparator;

/**
 * Structure viewer used by the
 * Assumes that its input is a {@link DiffModel}.
 * 
 * @author <a href="mailto:ars@informatik.uni-kiel.de">Arne Schipper</a>
 */
public class StructureMergeContentProvider implements ITreeContentProvider {
	/** Keeps track of the comparison result. */
	/* package */ModelInputSnapshot snapshot;

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
	public StructureMergeContentProvider(CompareConfiguration compareConfiguration) {
		configuration = compareConfiguration;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.viewers.IContentProvider#dispose()
	 */
	public void dispose() {
		KivikComparator.removeComparator(configuration);
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
		final KivikComparator comparator = KivikComparator.getComparator(configuration);
		if (newInput instanceof ModelInputSnapshot) {
			snapshot = (ModelInputSnapshot)newInput;
		} else if (comparator.getComparisonResult() != null) {
			snapshot = comparator.getComparisonResult();
		} else if (oldInput != newInput && newInput instanceof ICompareInput) {
			comparator.loadResources((ICompareInput)newInput);
			snapshot = comparator.compareViewModel(configuration);
		}
		diffInput = snapshot.getDiff();
	}
}
