package edu.unikiel.rtsys.kieler.kiml.layout.services;

import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphFactory;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KLayoutGraph;

/**
 * Abstract class every concrete layout handler has to extend. The layouter
 * itself, the editor and the rootEditPart where the layout should start from
 * have to be set before the actual layout can be performed. The concrete
 * instances are responsible for the translation of the editor input model to
 * the KLayoutGraph the actual layouter is working with, and the appliance of
 * the changes made to the KLayoutGraph back to the model in the editor.
 * 
 * @author ars
 * 
 */
public abstract class KimlAbstractLayouter {

	protected Object root = null;
	protected IKimlLayouterEngine layouter = null;
	protected KLayoutGraph layoutGraph = KimlLayoutGraphFactory.eINSTANCE
			.createKLayoutGraph();
	
	
	public void setRoot(Object root){
		this.root = root;
	}
	
	/**
	 * Sets the layouter for this layout handler.
	 * 
	 * @param layouter
	 *            The IKimlLayouterEngine responsible for the actual layout
	 */
	public void setLayouter(IKimlLayouterEngine layouter) {
		this.layouter = layouter;
	}


	/**
	 * Concrete layouters should override this method to perform the actual
	 * layouting. The model of the editor should be translated into the layout
	 * graph, the layout method of the KimlLayouter should be called and then
	 * the resulting layout should be applied to the editor model. Before
	 * calling this method the layouter, the editor and the rootEditPart have to
	 * be set with the corresponding methods.
	 */
	public void layout(){
		setupOptions();
		buildLayoutGraph();
		layouter.layout(layoutGraph);
		applyLayout();
	}

	public abstract void buildLayoutGraph();
	
	public abstract void applyLayout();

	public abstract void setupOptions();


	/**
	 * Method to choose a layouter according to a model, or to a hint.
	 * 
	 * @param layouterHint
	 *            A String serving as a hint to choose an appropriate layouter
	 */
	public abstract void chooseLayouter(String layouterHint);

}
