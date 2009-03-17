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
package de.cau.cs.kieler.kiml.ui;

import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

import de.cau.cs.kieler.kiml.ui.views.KimlLayoutHintView;


/**
 * Build up the special KIELER view in Eclipse.
 *  
 * @author <a href="mailto:haf@informatik.uni-kiel.de">Hauke Fuhrmann</a>
 */
public class KimlPerspectiveFactory implements IPerspectiveFactory {

	public void createInitialLayout(IPageLayout layout) {
		// Get editor area
		String editorArea = layout.getEditorArea();
		
		// Top left: Project Explorer
		IFolderLayout topLeft = layout.createFolder("topLeft", IPageLayout.LEFT, 0.25f, editorArea);
		topLeft.addView(IPageLayout.ID_RES_NAV);
		
		// Bottom left: Outline View
		IFolderLayout bottomLeft = layout.createFolder("bottomLeft", IPageLayout.BOTTOM, 0.5f, "topLeft");
		bottomLeft.addView(IPageLayout.ID_OUTLINE);
		
		// Bottom: Property and KIELER views
		IFolderLayout bottom = layout.createFolder("bottom", IPageLayout.BOTTOM, 0.75f, editorArea);
		bottom.addView(IPageLayout.ID_PROP_SHEET);
		bottom.addView(KimlLayoutHintView.ID);
		
		layout.addActionSet("de.cau.cs.kieler.kiml.ui.KimlActionSet");
	}

}
