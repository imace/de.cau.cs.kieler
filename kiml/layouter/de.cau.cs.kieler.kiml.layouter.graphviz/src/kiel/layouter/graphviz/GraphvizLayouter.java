package kiel.layouter.graphviz;

import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutNode;

public interface GraphvizLayouter {
	public void visit(KLayoutNode node);
}
