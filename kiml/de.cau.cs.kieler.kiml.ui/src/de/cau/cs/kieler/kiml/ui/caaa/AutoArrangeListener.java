/******************************************************************************
 * KIELER - Kiel Integrated Environment for Layout for the Eclipse RCP
 *
 * http://www.informatik.uni-kiel.de/rtsys/kieler/
 * 
 * Copyright 2008 by
 * + Christian-Albrechts-University of Kiel
 *   + Department of Computer Science
 *     + Real-Time and Embedded Systems Group
 * 
 * This code is provided under the terms of the Eclipse Public License (EPL).
 * See the file epl-v10.html for the license text.
 */
package de.cau.cs.kieler.kiml.ui.caaa;

import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EReferenceImpl;
import org.eclipse.emf.transaction.NotificationFilter;
import org.eclipse.emf.transaction.ResourceSetChangeEvent;
import org.eclipse.emf.transaction.ResourceSetListenerImpl;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.eclipse.gmf.runtime.notation.impl.DiagramImpl;
import org.eclipse.swt.widgets.Display;

import de.cau.cs.kieler.kiml.ui.layout.DiagramLayouter;


/**
 * Listener for the <b>Continuous, Automated Arrange All</b> feature.
 * 
 * Listens to a
 * <code>DiagramEditor<code> for (transactions of) notifications which should trigger the arranging algorithm (filtered by a
 * <code>NotifcationFilter</code>). The observer is divided into two listeners:
 * <ul>
 * <li>The instance itself listens to ADD, REMOVE, ADD_MANY, REMOVE_MANY, which
 * always trigger the arrangement.</li>
 * <li>An anonymous inner class listens to SET notifications to trigger, if a
 * node is resized (width or height changed).</li>
 * </ul>
 * 
 * The class also provides the arranging functionality and therefore implements
 * the <code>Runnable</code> interface to be able to let it be executed
 * asynchronous by <code>Display.getDefault()</code>
 * 
 * @author <a href="mailto:cwu@informatik.uni-kiel.de">Christoph Wulf</a>
 * @author <a href="mailto:jhed@informatik.uni-kiel.de">Johannes Hedtrich</a> 
 * @author <a href="mailto:ars@informatik.uni-kiel.de">Arne Schipper</a>
 */
class AutoArrangeListener extends ResourceSetListenerImpl implements Runnable {

	/* the current editor to listen at */
	private DiagramEditor listenedEditor = null;

	/**
	 * <p>
	 * Switches the diagram editor to listen at. Unregisters from a possible
	 * previous editor. Registers to a possible (new editor could be
	 * <code>null</code>) new editor.
	 * </p>
	 * 
	 * @param editor
	 *            DiagramEditor to listen at
	 */
	void listenToEditor(DiagramEditor editor) {
		if (listenedEditor != null) {
			// unregister from previous editor
			listenedEditor.getEditingDomain().removeResourceSetListener(this);
			listenedEditor.getEditingDomain().removeResourceSetListener(
					setListener);
		}
		listenedEditor = editor;
		if (listenedEditor != null) {
			// register to new editor
			listenedEditor.getEditingDomain().addResourceSetListener(this);
			listenedEditor.getEditingDomain().addResourceSetListener(
					setListener);
		}
	}

	/* filter for notifications interested in */
	private static final NotificationFilter filter;

	static {
		/* Constructs the static filter (see getFilter()) */
		filter = NotificationFilter
				.createEventTypeFilter(Notification.ADD)
				.or(
						NotificationFilter
								.createEventTypeFilter(Notification.REMOVE))
				.or(
						NotificationFilter
								.createEventTypeFilter(Notification.REMOVE_MANY))
				.or(
						NotificationFilter
								.createEventTypeFilter(Notification.ADD_MANY))
				.and(
						NotificationFilter
								.createNotifierTypeFilter(DiagramImpl.class));
	}

	/**
	 * The action is interested in notifications on <code>DiagramImpl</code> of
	 * type:
	 * <ul>
	 * <li><code>ADD</<code></li>
	 * <li><code>ADD_MANY</<code></li>
	 * <li><code>REMOVE</<code></li>
	 * <li><code>REMOVE_MANY</<code></li>
	 * </ul>
	 * 
	 * These 4 notification types can be directly handled by arranging the
	 * diagram. SET notifications caused by a resize are triggered by the
	 * anonymous inner class.
	 * 
	 * @see #setListener
	 * @see org.eclipse.emf.transaction.ResourceSetListenerImpl
	 * 
	 * @return Returns the filter for notifications it is interested in.
	 */
	public NotificationFilter getFilter() {
		return AutoArrangeListener.filter;
	}

	/**
	 * Only already committed diagram changes are required.
	 * 
	 * @see org.eclipse.emf.transaction.ResourceSetListenerImpl
	 */
	@Override
	public boolean isPostcommitOnly() {
		return true;
	}

	/**
	 * Anonymous inner class which triggers SET notifications caused by resizing
	 * a part.
	 * 
	 * @see org.eclipse.emf.transaction.ResourceSetListenerImpl
	 */
	private final ResourceSetListenerImpl setListener = new ResourceSetListenerImpl() {

		private final NotificationFilter filter = NotificationFilter
				.createEventTypeFilter(Notification.SET);

		@Override
		public NotificationFilter getFilter() {
			return filter;
		}

		/**
		 * Checks if a transaction has been worth to require a processing. That
		 * could be
		 * <ul>
		 * <li>a resizing</li>
		 * <li>an addition or</li>
		 * <li>a deletion of an element</li>
		 * </ul>
		 * and delegates to the <code>resourceSetChanged</code> of the outer
		 * class if necessary.
		 */
		@Override
		public void resourceSetChanged(ResourceSetChangeEvent event) {
			if (!aboutToArrange) {
				if (isAutoLayoutTransaction(event.getNotifications())) {
					AutoArrangeListener.this.resourceSetChanged(event);
				}
			}
		}

		/**
		 * @param notifications
		 *            Notification list
		 * 
		 * @return Returns true, if list contains a notification worth for an
		 *         automatic layout.
		 */
		private boolean isAutoLayoutTransaction(List<?> notifications) {
			for (Object notifyObj : notifications) {
				Notification notification = (Notification) notifyObj;

				/* called when resizing */
				if (notification.getFeature() instanceof EAttribute) {
					EAttribute attr = (EAttribute) notification.getFeature();
					// if width or height has changed
					if (("width".equals(attr.getName()) || "height".equals(attr
							.getName()))
							&& notification.getOldIntValue() != notification
									.getNewIntValue()) {
						return true;
					}
				}

				/* called when addition/deletion of element */
				if (notification.getFeature() instanceof EReferenceImpl) {
					EReference ref = (EReference) notification.getFeature();
					// if width or height has changed
					if (("element".equals(ref.getName()))) {
						return true;
					}
				}

			}
			return false;
		}
	};

	/*
	 * determines, whether the Display has been requested to execute this object
	 * as Runnable in the event loop
	 */
	private boolean aboutToArrange = false;

	/**
	 * <p>
	 * If there is not already a request for the Display to arrange the diagram,
	 * the flag is set and the Display asked to execute this runnable at the end
	 * of the event loop.
	 * </p>
	 * <p>
	 * <code>synchronized</code> for the case, if the resource set is changed by
	 * another thread (not GUI thread) while the GUI thread arranges the
	 * diagram.
	 * </p>
	 * 
	 * @see #run()
	 * @see org.eclipse.emf.transaction.ResourceSetListenerImpl
	 */
	@Override
	public synchronized void resourceSetChanged(ResourceSetChangeEvent event) {
		if (!aboutToArrange) {
			aboutToArrange = true;
			Display.getDefault().asyncExec(this);
		}
	}

	/**
	 * Executed by the Display at the end of the event loop. Starts an animated
	 * arrange all request and resets the flag.
	 * 
	 * @see java.lang.Runnable
	 */
	public synchronized void run() {
		// layout the diagram
		DiagramLayouter.layout(listenedEditor, true, true);
		// arranging completed, allow next one
		aboutToArrange = false;
	}
}
