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

import org.eclipse.compare.ITypedElement;
import org.eclipse.emf.compare.ui.util.EMFCompareEObjectUtils;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.swt.graphics.Image;

/**
 * Basic wrapper for an {@link ITypedElement}.
 * 
 */
public class KivikTypedElementWrapper implements ITypedElement {
	/** {@link EObject} this wrapper is build upon. */
	private final EObject wrappedObject;
	private EObject wrappedBusinessModel;
	private Diagram wrappedViewModel;
	

	/**
	 * Constructs an instance given the object to wrap.
	 * 
	 * @param eObject
	 *            Object to wrap as an {@link ITypedElement}.
	 */
	public KivikTypedElementWrapper(EObject eObject) {
		wrappedObject = eObject;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see ITypedElement#getImage()
	 */
	public Image getImage() {
		return EMFCompareEObjectUtils.computeObjectImage(wrappedObject);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see ITypedElement#getName()
	 */
	public String getName() {
		return EMFCompareEObjectUtils.computeObjectName(wrappedObject);
	}

	/**
	 * Returns the object wrapped within this {@link KivikTypedElementWrapper}.
	 * 
	 * @return The object wrapped within this {@link KivikTypedElementWrapper}.
	 */
	public EObject getObject() {
		return wrappedObject;
	}

	public EObject getBusinessModel() {
		return wrappedBusinessModel;
	}

	public void setBusinessModel(EObject wrappedBusinessModel) {
		this.wrappedBusinessModel = wrappedBusinessModel;
	}

	public Diagram getViewModel() {
		return wrappedViewModel;
	}

	public void setViewModel(Diagram wrappedViewModel) {
		this.wrappedViewModel = wrappedViewModel;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see ITypedElement#getType()
	 */
	public String getType() {
		return wrappedObject.getClass().getName();
	}
}
