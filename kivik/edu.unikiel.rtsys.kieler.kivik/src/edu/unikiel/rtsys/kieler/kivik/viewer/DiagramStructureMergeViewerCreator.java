package edu.unikiel.rtsys.kieler.kivik.viewer;

import org.eclipse.compare.CompareConfiguration;
import org.eclipse.compare.IViewerCreator;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.widgets.Composite;

/**
 * @author <a href="mailto:ars@informatik.uni-kiel.de">Arne Schipper</a>
 */
public class DiagramStructureMergeViewerCreator implements IViewerCreator {
	/**
	 * {@inheritDoc}
	 */
	public Viewer createViewer(Composite parent, CompareConfiguration config) {
		System.out.println("New DiagramStructuredMergeViewer created!");
		return new DiagramStructureMergeViewer(parent, config);
	}
}