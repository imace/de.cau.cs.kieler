package edu.unikiel.rtsys.kieler.kiml.layout.services;

import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphFactory;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KLayoutGraph;

/**
 * Abstract class every concrete layout handler has to extend. The layout engine
 * itself, the editor and the rootEditPart where the layout should start from
 * have to be set before the actual layout can be performed. The concrete
 * instances are responsible for the translation of the editor input model to
 * the KLayoutGraph the actual layout engine is working with, and the appliance
 * of the changes made to the KLayoutGraph back to the model in the editor.
 * 
 * @author ars
 * 
 */
public abstract class KimlAbstractLayouter {

	protected Object root = null;
	protected KimlAbstractLayouterEngine layoutEngine = null;
	protected KLayoutGraph layoutGraph = KimlLayoutGraphFactory.eINSTANCE
			.createKLayoutGraph();

	/**
	 * Sets the root object the layout should start with, typically some
	 * graphical object. Is defined generically as object, to be able to work
	 * with any kind of diagram/graphical editors
	 * 
	 * @param theRoot
	 *            The Object which is the root for the layout
	 */
	public void setRoot(Object theRoot) {
		this.root = theRoot;
	}

	/**
	 * Sets the layout engine for this layout.
	 * 
	 * @param layouter
	 *            The IKimlLayouterEngine responsible for the actual layout
	 */
	public void setLayouter(KimlAbstractLayouterEngine theLayoutEngine) {
		this.layoutEngine = theLayoutEngine;
	}

	/**
	 * Method which should be called to do the actual layout. Layouters calling
	 * this methods must have build up the KLayoutGraph appropriately using the
	 * buildLayoutGraph method and must have an implementation of the
	 * applyLayout methods to actually apply the layout information back to the
	 * diagram.
	 */
	public void layout() {

		// Setup the options and perform the three stages of the
		// layout, two of them have to be implemented by the extending classes.
		if (!init()) {
			System.out.println(getClass().getSimpleName() + ": Error in init()");
			return;
		}
		// return silently if there is nothing to lay out.
		if (!buildLayoutGraph()){
			System.out.println(getClass().getSimpleName() + ": Error in buildLayoutGraph()");
			return;
		}
		// choose the default layout engine if none set
		if (layoutEngine == null)
			this.layoutEngine = new KimlRecursiveGroupLayouterEngine();
		// now do the layout
		layoutEngine.layout(layoutGraph);
		// and apply layout to model
		if (!applyLayout()){
			System.out.println(getClass().getSimpleName() + ": Error in applyLayout()");
			return;
		}
	}

	public abstract boolean init();

	public abstract boolean buildLayoutGraph();

	public abstract boolean applyLayout();

}
