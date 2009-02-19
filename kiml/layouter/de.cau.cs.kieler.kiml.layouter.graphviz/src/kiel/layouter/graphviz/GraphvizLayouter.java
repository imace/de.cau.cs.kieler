package kiel.layouter.graphviz;

import de.cau.cs.kieler.core.KielerException;
import de.cau.cs.kieler.core.alg.IKielerProgressMonitor;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutNode;

/**
 * Interface for GraphViz layout access classes.
 * 
 * @author ?
 */
public interface GraphvizLayouter {
	
	/**
	 * Performs layout on the given parent node.
	 * 
	 * @param node parent node
	 * @param progressMonitor progress monitor
	 * @throws KielerException if the layout process fails
	 */
	public void visit(KLayoutNode node, IKielerProgressMonitor progressMonitor)
			throws KielerException;
	
}
