/*******************************************************************************
 * Copyright (c) 2008 Real-Time and Embedded Systems group
 *
 * INSERT LICENCE HERE
 *
 *
 * Author: Arne Schipper, ars@informatik.uni-kiel.de 
 *
 *******************************************************************************/
package edu.unikiel.rtsys.kieler.kivik.internal;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.compare.ITypedElement;
import org.eclipse.compare.structuremergeviewer.ICompareInput;
import org.eclipse.compare.structuremergeviewer.ICompareInputChangeListener;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.compare.diff.merge.service.MergeService;
import org.eclipse.emf.compare.diff.metamodel.AttributeChange;
import org.eclipse.emf.compare.diff.metamodel.DiffElement;
import org.eclipse.emf.compare.diff.metamodel.DiffGroup;
import org.eclipse.emf.compare.diff.metamodel.DiffModel;
import org.eclipse.emf.compare.diff.metamodel.ModelElementChange;
import org.eclipse.emf.compare.diff.metamodel.ReferenceChange;
import org.eclipse.emf.compare.match.metamodel.Match2Elements;
import org.eclipse.emf.compare.match.metamodel.Match3Element;
import org.eclipse.emf.compare.match.metamodel.MatchModel;
import org.eclipse.emf.compare.ui.util.EMFCompareConstants;
import org.eclipse.emf.compare.ui.util.EMFCompareEObjectUtils;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.swt.graphics.Image;

public class KivikCompareInput implements ICompareInput {
	/** Resource containing the ancestor object of this comparison. */
	private Resource ancestorResource;

	/** {@link DiffModel} result of the underlying comparison. */
	private final DiffModel diff;

	/** Keeps a list of all the differences (without DiffGroup) detected. */
	private List<DiffElement> diffList;

	/**
	 * Memorizes all listeners registered for this {@link ICompareInput compare
	 * input}.
	 */
	private final List<ICompareInputChangeListener> inputChangeListeners = new ArrayList<ICompareInputChangeListener>();

	/** Resource containing the left compared object. */
	private Resource leftResource;

	/** Diagram containing the right compared object. */
	private Diagram ancestorViewModel;

	/** Diagram containing the left compared object. */
	private Diagram leftViewModel;

	/** Diagram containing the right compared object. */
	private Diagram rightViewModel;

	/** EObject containing the left compared object. */
	private EObject ancestorBusinessModel;

	/** EObject containing the left compared object. */
	private EObject leftBusinessModel;

	/** EObject containing the right compared object. */
	private EObject rightBusinessModel;

	/** {@link MatchModel} result of the underlying comparison. */
	private final MatchModel match;

	/** Resource containing the right compared object. */
	private Resource rightResource;

	/**
	 * Creates a CompareInput given the resulting
	 * {@link org.eclipse.emf.compare.match.diff.match.MatchModel match} and
	 * {@link org.eclipse.emf.compare.match.diff.diff.DiffModel diff} of the
	 * comparison.
	 * 
	 * @param matchModel
	 *            {@link org.eclipse.emf.compare.match.diff.match.MatchModel
	 *            match} of the comparison.
	 * @param diffModel
	 *            {@link org.eclipse.emf.compare.match.diff.diff.DiffModel diff}
	 *            of the comparison.
	 */
	public KivikCompareInput(MatchModel matchModel, DiffModel diffModel) {
		match = matchModel;
		diff = diffModel;
	}

	/**
	 * Creates a CompareInput given the resulting
	 * {@link org.eclipse.emf.compare.match.diff.match.MatchModel match} and
	 * {@link org.eclipse.emf.compare.match.diff.diff.DiffModel diff} of the
	 * comparison.
	 * 
	 * @param matchModel
	 *            {@link org.eclipse.emf.compare.match.diff.match.MatchModel
	 *            match} of the comparison.
	 * @param diffModel
	 *            {@link org.eclipse.emf.compare.match.diff.diff.DiffModel diff}
	 *            of the comparison.
	 * @param comparator
	 *            The comparator which has been used for this comparison.
	 */
	public KivikCompareInput(MatchModel matchModel, DiffModel diffModel,
			KivikComparator comparator) {
		this(matchModel, diffModel);
//		leftResource = comparator.getLeftNotationModel().eResource();
//		rightResource = comparator.getRightNotationModel().eResource();
//		ancestorResource = (comparator.getAncestorNotationModel() == null) ? null
//				: comparator.getAncestorNotationModel().eResource();
//		leftViewModel = comparator.getLeftNotationModel();
//		rightViewModel = comparator.getRightNotationModel();
//		ancestorViewModel = comparator.getAncestorNotationModel();
//		leftBusinessModel = comparator.getLeftDomainModel();
//		rightBusinessModel = comparator.getRightDomainModel();
//		ancestorBusinessModel = comparator.getAncestorDomainModel();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see ICompareInput#addCompareInputChangeListener(ICompareInputChangeListener)
	 */
	public void addCompareInputChangeListener(
			ICompareInputChangeListener listener) {
		inputChangeListeners.add(listener);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see ICompareInput#copy(boolean)
	 */
	public void copy(boolean leftToRight) {
		final List<DiffElement> differences = new ArrayList<DiffElement>(diff
				.getOwnedElements());
		doCopy(differences, leftToRight);
		fireCompareInputChanged();
	}

	/**
	 * Copies a single {@link DiffElement} or a {@link DiffGroup} in the given
	 * direction.
	 * 
	 * @param element
	 *            {@link DiffElement Element} to copy.
	 * @param leftToRight
	 *            Direction of the copy.
	 */
	public void copy(DiffElement element, boolean leftToRight) {
		doCopy(element, leftToRight);
		fireCompareInputChanged();
	}

	/**
	 * Copies a list of {@link DiffElement}s or {@link DiffGroup}s in the given
	 * direction.
	 * 
	 * @param elements
	 *            {@link DiffElement Element}s to copy.
	 * @param leftToRight
	 *            Direction of the copy.
	 */
	public void copy(List<DiffElement> elements, boolean leftToRight) {
		doCopy(elements, leftToRight);
		fireCompareInputChanged();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see ICompareInput#getAncestor()
	 */
	public ITypedElement getAncestor() {
		KivikTypedElementWrapper ancestor = null;
		if (ancestorResource != null) {
			if (ancestorResource.getContents().size() > 0)
				ancestor = new KivikTypedElementWrapper(ancestorResource
						.getContents().get(0));
			ancestor.setBusinessModel(ancestorBusinessModel);
			ancestor.setViewModel(ancestorViewModel);
		} else {
			// Seeks a resource from the MatchModel
			// Assumes that some elements have been matched
			final TreeIterator<EObject> matchIterator = match.eAllContents();
			EObject root = null;
			while (matchIterator.hasNext()) {
				final EObject matchElement = matchIterator.next();
				if (matchElement instanceof Match3Element) {
					root = ((Match3Element) matchElement).getOriginElement()
							.eResource().getContents().get(0);
					break;
				}
			}
			ancestor = new KivikTypedElementWrapper(root);
		}
		return ancestor;
	}

	/**
	 * Returns this ModelCompareInput's DiffModel.
	 * 
	 * @return This ModelCompareInput's DiffModel.
	 */
	public DiffModel getDiff() {
		return diff;
	}

	/**
	 * Returns the {@link DiffElement} of the input {@link DiffModel} as a list.
	 * Doesn't take {@link DiffGroup}s into account.
	 * 
	 * @return The {@link DiffElement} of the input {@link DiffModel} as a list.
	 */
	public List<DiffElement> getDiffAsList() {
		if (diffList == null) {
			diffList = new ArrayList<DiffElement>();
			// ordering is needed in order to merge modelElement diffs before
			// references change
			// We'll order the diffs by class (modelElementChange,
			// attributechange then referenceChange)
			final List<ModelElementChange> modelElementDiffs = new ArrayList<ModelElementChange>();
			final List<AttributeChange> attributeChangeDiffs = new ArrayList<AttributeChange>();
			final List<ReferenceChange> referenceChangeDiffs = new ArrayList<ReferenceChange>();
			final TreeIterator<EObject> iterator = getDiff().eAllContents();
			while (iterator.hasNext()) {
				final DiffElement aDiff = (DiffElement) iterator.next();
				if (aDiff instanceof ModelElementChange)
					modelElementDiffs.add((ModelElementChange) aDiff);
				else if (aDiff instanceof AttributeChange)
					attributeChangeDiffs.add((AttributeChange) aDiff);
				else if (aDiff instanceof ReferenceChange)
					referenceChangeDiffs.add((ReferenceChange) aDiff);
				// fallthrough
				else if (!(aDiff instanceof DiffGroup))
					diffList.add(aDiff);
			}
			diffList.addAll(modelElementDiffs);
			diffList.addAll(attributeChangeDiffs);
			diffList.addAll(referenceChangeDiffs);
			modelElementDiffs.clear();
			attributeChangeDiffs.clear();
			referenceChangeDiffs.clear();
		}

		return diffList;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see ICompareInput#getImage()
	 */
	public Image getImage() {
		Image image = null;

		if (getMatch() != null)
			image = EMFCompareEObjectUtils.computeObjectImage(getMatch());
		else if (getDiff() != null)
			image = EMFCompareEObjectUtils.computeObjectImage(getDiff());

		return image;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see ICompareInput#getKind()
	 */
	public int getKind() {
		if (getAncestor() != null)
			return EMFCompareConstants.ENABLE_ANCESTOR;
		return EMFCompareConstants.NO_CHANGE;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see ICompareInput#getLeft()
	 */
	public ITypedElement getLeft() {
		KivikTypedElementWrapper left = null;
		if (leftResource != null) {
			if (leftResource.getContents().size() > 0)
				left = new KivikTypedElementWrapper(leftResource.getContents()
						.get(0));
			left.setBusinessModel(leftBusinessModel);
			left.setViewModel(leftViewModel);
		} else {
			// Seeks a resource from the MatchModel
			// Assumes that some elements have been matched
			final TreeIterator<EObject> matchIterator = match.eAllContents();
			EObject root = null;
			while (matchIterator.hasNext()) {
				final EObject matchElement = matchIterator.next();
				if (matchElement instanceof Match2Elements) {
					root = ((Match2Elements) matchElement).getLeftElement()
							.eResource().getContents().get(0);
					break;
				}
			}
			left = new KivikTypedElementWrapper(root);
		}
		return left;
	}

	/**
	 * Returns this ModelCompareInput's MatchModel.
	 * 
	 * @return This ModelCompareInput's MatchModel.
	 */
	public MatchModel getMatch() {
		return match;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see ICompareInput#getName()
	 */
	public String getName() {
		String name = null;

		if (getMatch() != null)
			name = EMFCompareEObjectUtils.computeObjectName(getMatch());
		else if (getDiff() != null)
			name = EMFCompareEObjectUtils.computeObjectName(getDiff());

		return name;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see ICompareInput#getRight()
	 */
	public ITypedElement getRight() {
		KivikTypedElementWrapper right = null;
		if (rightResource != null) {
			if (rightResource.getContents().size() > 0)
				right = new KivikTypedElementWrapper(rightResource
						.getContents().get(0));
			right.setBusinessModel(rightBusinessModel);
			right.setViewModel(rightViewModel);
		} else {
			// Seeks a resource from the MatchModel
			// Assumes that some elements have been matched
			final TreeIterator<EObject> matchIterator = match.eAllContents();
			EObject root = null;
			while (matchIterator.hasNext()) {
				final EObject matchElement = matchIterator.next();
				if (matchElement instanceof Match2Elements) {
					root = ((Match2Elements) matchElement).getRightElement()
							.eResource().getContents().get(0);
					break;
				}
			}
			right = new KivikTypedElementWrapper(root);
		}
		return right;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see ICompareInput#removeCompareInputChangeListener(ICompareInputChangeListener)
	 */
	public void removeCompareInputChangeListener(
			ICompareInputChangeListener listener) {
		inputChangeListeners.remove(listener);
	}

	/**
	 * Applies the changes implied by a given {@link DiffElement} in the
	 * direction specified by <code>leftToRight</code>.
	 * 
	 * @param element
	 *            {@link DiffElement} containing the copy information.
	 * @param leftToRight
	 *            <code>True</code> if the changes must be applied from the left
	 *            to the right model, <code>False</code> otherwise.
	 */
	protected void doCopy(DiffElement element, boolean leftToRight) {
		MergeService.merge(element, leftToRight);
	}

	/**
	 * Applies the changes implied by a list of {@link DiffElement} in the
	 * direction specified by <code>leftToRight</code>.
	 * 
	 * @param elements
	 *            {@link DiffElement}s containing the copy information.
	 * @param leftToRight
	 *            <code>True</code> if the changes must be applied from the left
	 *            to the right model, <code>False</code> otherwise.
	 */
	protected void doCopy(List<DiffElement> elements, boolean leftToRight) {
		MergeService.merge(elements, leftToRight);
	}

	/**
	 * Notifies all {@link ICompareInputChangeListener listeners} registered for
	 * this {@link KivikCompareInput input} that a change occured.
	 */
	protected void fireCompareInputChanged() {
		diffList.clear();
		diffList = null;
		for (ICompareInputChangeListener listener : inputChangeListeners) {
			listener.compareInputChanged(this);
		}
	}
}
