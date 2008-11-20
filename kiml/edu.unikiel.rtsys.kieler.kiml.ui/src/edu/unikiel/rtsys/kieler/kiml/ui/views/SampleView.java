/*******************************************************************************
 * Copyright (c) 2008 Real-Time and Embedded Systems group
 *
 * INSERT LICENCE HERE
 *
 *
 * Author: Arne Schipper, ars@informatik.uni-kiel.de 
 *
 *******************************************************************************/
package edu.unikiel.rtsys.kieler.kiml.ui.views;

/*******************************************************************************
 * Copyright (c) 2006 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

import javax.lang.model.element.Element;

import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreeNode;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.ui.views.properties.IPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertySheetPageContributor;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

public class SampleView extends ViewPart implements
		ITabbedPropertySheetPageContributor {

	private TreeViewer viewer;

	private TabbedPropertySheetPage tabbedPropertySheetPage;

	public static final String TESTS_VIEW_ID = "edu.unikiel.rtsys.kieler.kiml.ui.views.SampleView"; //$NON-NLS-1$

	class ViewLabelProvider extends LabelProvider {

		public String getText(Object obj) {
			// Element element = (Element) ((TreeNode) obj).getValue();
			// return element.getName();
			return "";
		}

		public Image getImage(Object obj) {
			// Element element = (Element) ((TreeNode) obj).getValue();
			// return element.getImage();
			return null;
		}
	}

	/**
	 * The constructor.
	 */
	public SampleView() {
		//
	}

	/**
	 * This is a callback that will allow us to create the viewer and initialize
	 * it.
	 */
	public void createPartControl(Composite parent) {
		viewer = new TreeViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
		viewer.setContentProvider(new SampleViewContentProvider(this));
		viewer.setLabelProvider(new ViewLabelProvider());
		viewer.setInput(getViewSite());
		getSite().setSelectionProvider(viewer);
	}

	/**
	 * Passing the focus request to the viewer's control.
	 */
	public void setFocus() {
		viewer.getControl().setFocus();
	}

	public Object getAdapter(Class adapter) {
		if (adapter == IPropertySheetPage.class) {
			if (tabbedPropertySheetPage == null) {
				tabbedPropertySheetPage = new TabbedPropertySheetPage(this);
			}
			return tabbedPropertySheetPage;
		}
		return super.getAdapter(adapter);
	}

	public String getContributorId() {
		return TESTS_VIEW_ID;
	}

	public TreeViewer getViewer() {
		return viewer;
	}

	public TabbedPropertySheetPage getTabbedPropertySheetPage() {
		return tabbedPropertySheetPage;
	}
}
