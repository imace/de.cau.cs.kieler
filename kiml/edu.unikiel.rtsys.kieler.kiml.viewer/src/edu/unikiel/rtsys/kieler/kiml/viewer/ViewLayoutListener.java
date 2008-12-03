package edu.unikiel.rtsys.kieler.kiml.viewer;

import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KLayoutGraph;
import edu.unikiel.rtsys.kieler.kiml.layout.services.IKimlLayoutListener;

/**
 * Layout listener implementation that displays the layout graphs in
 * a view.
 * 
 * @author msp
 */
public class ViewLayoutListener implements IKimlLayoutListener {

	/* (non-Javadoc)
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.services.IKimlLayoutListener#layoutRequested(edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KLayoutGraph)
	 */
	public void layoutRequested(KLayoutGraph layoutGraph) {
		System.out.println("hau");
	}
	
	/* (non-Javadoc)
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.services.IKimlLayoutListener#layoutPerformed(edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KLayoutGraph)
	 */
	public void layoutPerformed(KLayoutGraph layoutGraph) {
		System.out.println("ruck");
	}

}
