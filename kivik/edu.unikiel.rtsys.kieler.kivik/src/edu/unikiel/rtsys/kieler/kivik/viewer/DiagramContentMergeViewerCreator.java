package edu.unikiel.rtsys.kieler.kivik.viewer;

import org.eclipse.compare.CompareConfiguration;
import org.eclipse.compare.IViewerCreator;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.widgets.Composite;

public class DiagramContentMergeViewerCreator implements IViewerCreator {

	public Viewer createViewer(Composite parent, CompareConfiguration config) {
		System.out.println("New DiagramContentMergeViewer created.\n");
		return new DiagramContentMergeViewer(parent, config);
	}

}
