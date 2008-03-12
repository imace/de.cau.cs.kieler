package edu.unikiel.rtsys.kieler.kev.application;

import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

public class Perspective implements IPerspectiveFactory {

	private final String ID_ENVIRONMENT_VIEW =  "edu.unikiel.rtsys.kieler.kev.views.EnvironmentView";
	
	public void createInitialLayout(IPageLayout layout) {
        layout.addStandaloneView(ID_ENVIRONMENT_VIEW, true, IPageLayout.TOP, 1.0f, layout.getEditorArea());
        layout.setEditorAreaVisible(false); // we only have a view, no editor...
	}
}
