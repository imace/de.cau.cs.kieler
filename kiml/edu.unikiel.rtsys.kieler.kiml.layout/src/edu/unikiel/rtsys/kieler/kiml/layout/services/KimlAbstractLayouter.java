package edu.unikiel.rtsys.kieler.kiml.layout.services;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.LabelProvider;

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

	public static final String EXTENSION_POINT_ID = "edu.unikiel.rtsys.kieler.kiml.layout.kimlDiagramLayouter";
	public static final String ATTRIBUTE_CLASS = "class";
	public static final String ATTRIBUTE_EDITOR_ID = "editor_id";
	public static final String ATTRIBUTE_ID = "id";
	public static final String ATTRIBUTE_NAME = "name";
	public static final String ATTRIBUTE_ICON = "icon";

	/**
	 * Method which should be called to do the actual layout. Layouters calling
	 * this methods must have build up the KLayoutGraph appropriately using the
	 * buildLayoutGraph method and must have an implementation of the
	 * applyLayout methods to actually apply the layout information back to the
	 * diagram.
	 * 
	 * @param target
	 *            object specifying what is to be layouted
	 */
	public void layout(Object target) {
		// Setup the options and perform the three stages of the
		// layout, two of them have to be implemented by the extending classes.
		if (!init(target)) {
			// TODO error handling
			System.out
					.println(getClass().getSimpleName() + ": Error in init()");
			return;
		}
		// return silently if there is nothing to lay out.
		KLayoutGraph layoutGraph = buildLayoutGraph();
		if (layoutGraph == null) {
			// TODO error handling
			System.out.println(getClass().getSimpleName()
					+ ": Error in buildLayoutGraph()");
			return;
		}
		// choose the default layout engine
		KimlAbstractLayouterEngine layoutEngine = new KimlRecursiveGroupLayouterEngine();
		// now do the layout
		layoutEngine.layout(layoutGraph);
		// and apply layout to model
		applyLayout();
	}

	/**
	 * Returns the settings currently active in the diagram layouter. These are
	 * the settings the actual layouter owns, and which are adjustable through
	 * means of the layouter, e.g. a preference page.
	 * 
	 * @return a String-to-String map of the settings of the diagram layouter.
	 */
	public Map<String, String> getSettings()
	{
		return new HashMap<String, String>();
	}
	
	/**
	 * Returns a label provider that is capable of getting labels for
	 * concrete diagram edit parts such as nodes.
	 * 
	 * @return a label provider that is compatible with the related diagram
	 */
	public ILabelProvider getLabelProvider()
	{
		return new LabelProvider();
	}

	/**
	 * Initializes the layouter for a new given selection of a diagram. Chooses
	 * the right diagram elements for laying out and prepares all needed
	 * structures.
	 * 
	 * @param target
	 *            object specifying what is to be laid out
	 * @return true if successful
	 */
	protected abstract boolean init(Object target);

	/**
	 * Creates the layout graph that corresponds to the diagram elements to be
	 * laid out.
	 * 
	 * @return a layout graph
	 */
	protected abstract KLayoutGraph buildLayoutGraph();

	/**
	 * Applies all layout properties after the layout algorithm has executed on
	 * the layout graph.
	 */
	protected abstract void applyLayout();

}
