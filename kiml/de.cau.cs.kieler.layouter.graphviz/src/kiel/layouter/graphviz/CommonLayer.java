package kiel.layouter.graphviz;

import de.cau.cs.kieler.layouter.graph.Graph;
/**
 * Common data supplied by this Plugin 
 * that is shared between different plugins. Other plugins need static
 * references to these objects, because otherwise the data might not
 * be available from within the Eclipse core.
 * @author haf
 *
 */
public class CommonLayer {

	Graph layoutGraph;

	public Graph getLayoutGraph() {
		return layoutGraph;
	}

	public void setLayoutGraph(Graph layoutGraph) {
		this.layoutGraph = layoutGraph;
	}

	
	
}
