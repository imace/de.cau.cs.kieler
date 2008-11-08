package edu.unikiel.rtsys.kieler.kivik.util;

import java.util.ListIterator;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.compare.diff.metamodel.DiffElement;
import org.eclipse.emf.compare.diff.metamodel.DiffGroup;
import org.eclipse.emf.compare.match.metamodel.Match2Elements;
import org.eclipse.emf.compare.match.metamodel.Match3Element;
import org.eclipse.emf.compare.match.metamodel.MatchModel;
import org.eclipse.emf.compare.match.metamodel.UnMatchElement;
import org.eclipse.emf.compare.ui.util.EMFCompareConstants;
import org.eclipse.emf.compare.ui.util.EMFCompareEObjectUtils;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.notation.View;

public class KivikUtil {
	
	

	public static EObject getTargetForDiffElement(DiffElement diffElement, MatchModel match, int side) {
		if (side == EMFCompareConstants.LEFT) {
			return EMFCompareEObjectUtils.getLeftElement(diffElement);
		} else if (side == EMFCompareConstants.RIGHT) {
			if (diffElement instanceof DiffGroup
					&& EMFCompareEObjectUtils.getLeftElement(diffElement) != null)
				return EMFCompareEObjectUtils
						.getRightElement(findMatchFromElement(EMFCompareEObjectUtils
								.getLeftElement(diffElement), match));
			else if (!(diffElement instanceof DiffGroup))
				return EMFCompareEObjectUtils.getRightElement(diffElement);
			else
				return null;
		} else
			return null;
	}

	public static AbstractGraphicalEditPart findAbstractGraphicalEditPart(
			GraphicalEditPart gepBegin, EObject target) {

		if (target == null || gepBegin == null)
			return null;

		AbstractGraphicalEditPart foundEditPart = (GraphicalEditPart) gepBegin
				.findEditPart(null, target);

		if (foundEditPart == null) {
			GraphicalEditPart gepParent = (GraphicalEditPart) gepBegin
					.findEditPart(null, target.eContainer());
			foundEditPart = (AbstractGraphicalEditPart) findConnectionEditPart(
					gepParent, target);
		}
		return foundEditPart;
	}

	/** Finds an editpart given a starting editpart and an EObject */
	public static AbstractGraphicalEditPart findConnectionEditPart(
			AbstractGraphicalEditPart epBegin, EObject theElement) {
		if (theElement == null || epBegin == null) {
			return null;
		}

		// check if gmf graphical edit part to be able to get connections
		if (epBegin instanceof GraphicalEditPart) {
			GraphicalEditPart epStart = (GraphicalEditPart) epBegin;

			// source connections
			for (Object obj : epStart.getSourceConnections()) {
				if (obj instanceof ConnectionEditPart) {
					ConnectionEditPart connectionEditPart = (ConnectionEditPart) obj;

					final View view = (View) ((IAdaptable) connectionEditPart)
							.getAdapter(View.class);

					if (view != null) {

						EObject el = ViewUtil.resolveSemanticElement(view);

						if ((el != null) && el.equals(theElement)) {
							return (AbstractGraphicalEditPart) connectionEditPart;
						}
					}
				}
			}

			// same for target connections
			for (Object obj : epStart.getTargetConnections()) {
				if (obj instanceof ConnectionEditPart) {
					ConnectionEditPart connectionEditPart = (ConnectionEditPart) obj;

					final View view = (View) ((IAdaptable) connectionEditPart)
							.getAdapter(View.class);

					if (view != null) {

						EObject el = ViewUtil.resolveSemanticElement(view);

						if ((el != null) && el.equals(theElement)) {
							return (AbstractGraphicalEditPart) connectionEditPart;
						}
					}
				}
			}

			ListIterator<?> childLI = epStart.getChildren().listIterator();
			while (childLI.hasNext()) {
				AbstractGraphicalEditPart epChild = (AbstractGraphicalEditPart) childLI
						.next();

				AbstractGraphicalEditPart elementEP = findConnectionEditPart(
						epChild, theElement);
				if (elementEP != null) {
					return elementEP;
				}
			}
		}
		return null;
	}
	
	protected static EObject findMatchFromElement(EObject element,MatchModel match) {
		EObject theElement = null;

		final TreeIterator<EObject> iterator = match.eAllContents();
		while (iterator.hasNext()) {
			final Object object = iterator.next();

			if (object instanceof Match3Element) {
				final Match3Element matchElement = (Match3Element) object;
				if (element.equals(matchElement.getLeftElement())
						|| element.equals(matchElement.getRightElement())
						|| element.equals(matchElement.getOriginElement())) {
					theElement = matchElement;
				}
			} else if (object instanceof Match2Elements) {
				final Match2Elements matchElement = (Match2Elements) object;
				if (matchElement.getLeftElement().equals(element)
						|| matchElement.getRightElement().equals(element)) {
					theElement = matchElement;
				}
			} else if (object instanceof UnMatchElement) {
				final UnMatchElement unMatchElement = (UnMatchElement) object;
				if (unMatchElement.getElement().equals(element)) {
					theElement = unMatchElement;
				}
			}
		}

		return theElement;
	}
}
