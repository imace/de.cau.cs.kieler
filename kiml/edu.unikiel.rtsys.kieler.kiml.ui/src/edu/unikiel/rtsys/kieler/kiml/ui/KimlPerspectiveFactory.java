package edu.unikiel.rtsys.kieler.kiml.ui;

import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

import edu.unikiel.rtsys.kieler.kiml.ui.views.KimlLayoutGraphView;

public class KimlPerspectiveFactory implements IPerspectiveFactory {

	@Override
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
		bottom.addView(KimlLayoutGraphView.ID);
		
		layout.addActionSet("edu.unikiel.rtsys.kieler.kiml.ui.KimlActionSet");
	}

}
