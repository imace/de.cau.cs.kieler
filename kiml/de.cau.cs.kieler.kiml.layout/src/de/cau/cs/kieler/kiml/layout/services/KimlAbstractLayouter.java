/*******************************************************************************
 * Copyright (c) 2008 Real-Time and Embedded Systems group
 *
 * INSERT LICENCE HERE
 *
 *
 * Author: Arne Schipper, ars@informatik.uni-kiel.de 
 *
 *******************************************************************************/
package de.cau.cs.kieler.kiml.layout.services;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.ui.statushandlers.StatusManager;

import de.cau.cs.kieler.kiml.layout.KimlLayoutPlugin;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutGraph;


/**
 * Abstract class every concrete diagram layouter has to extend. Performs the
 * mapping from the diagram/model to the KLayoutGraph, and further on all the
 * downstream steps to achieve a proper layout.
 * <p/>
 * The concrete instances are responsible for the translation of the editor
 * input model to the KLayoutGraph the actual layout engine is working with, and
 * for the appliance of the changes made to the KLayoutGraph back to the model
 * in the editor.
 * <p/>
 * Concrete DiagramLayouters for a model/editor must register themselves through
 * the <code>kimlDiagramLayouter</code> extension point. All DiagramLayouters
 * published to Eclipse this way are collected with the {@link DiagramLayouters}
 * singleton.
 * <p/>
 * Once you have obtained a concrete DiagramLayouter for your model/editor, you
 * just have to call <code>layout</code> with the object you want to be laid
 * out. That is all.
 * <p/>
 * There is still no proper error handling. This must be addressed on a KIELER
 * basis.
 * 
 * @author <a href="mailto:ars@informatik.uni-kiel.de">Arne Schipper</a>
 * @see KimlAbstractLayouter#layout(Object) layout(Object)
 * @see DiagramLayouters
 */
public abstract class KimlAbstractLayouter {

	/*
	 * some strings used when creating the concrete layouters via the extension
	 * point mechanism
	 */
	public static final String EXTENSION_POINT_ID = "de.cau.cs.kieler.kiml.layout.kimlDiagramLayouter";
	public static final String ATTRIBUTE_CLASS = "class";
	public static final String ATTRIBUTE_EDITOR_ID = "editor_id";
	public static final String ATTRIBUTE_ID = "id";
	public static final String ATTRIBUTE_NAME = "name";
	public static final String ATTRIBUTE_ICON = "icon";

	/**
	 * Method which should be called to do the actual layout. Several steps are
	 * performed in this method:
	 * <ol>
	 * <li>The concrete implementation of
	 * {@link KimlAbstractLayouter#init(Object target) init} is called. The
	 * implementing class should initialize itself to be able to perform the
	 * further steps. That is, for example, to extract the rootPart for the
	 * layout correctly from the provided object in the <code>layout</code>
	 * method, which will be used later be <code>buildLayoutGraph</code>, and
	 * for example to be aware of an eventual zoom of the editor.</li>
	 * <li>The KLayoutGraph is build up using the method
	 * {@link KimlAbstractLayouter#buildLayoutGraph() buildLayoutGraph}, which
	 * must also be implemented by the subclass.</li>
	 * <li>A layout engine is chosen. At the moment, there is just the
	 * {@link KimlRecursiveGroupLayouterEngine}, which spawns a new layout
	 * provider for each hierarchy level. This can be changed in later
	 * implementations.</li>
	 * <li>Finally, {@link KimlAbstractLayouter#applyLayout() applyLayout} of
	 * the implementing class is called to write the information which is now in
	 * the processed KLayoutGraph back to the diagram in the viewer or editor.</li>
	 * </ol>
	 * <p/>
	 * There is still no proper error handling. This must be addressed on a
	 * KIELER basis.
	 * 
	 * @param target
	 *            object specifying what is to be layouted
	 */
	public void layout(Object target) {
		try {
			// initialize the layouter depending on the layout target
			init(target);
			// build the layout graph
			KLayoutGraph layoutGraph = buildLayoutGraph();
			// notify layout listeners about the layout request
			LayoutListeners.getInstance().layoutRequested(layoutGraph);
			// choose the default layout engine
			KimlAbstractLayouterEngine layoutEngine = new KimlRecursiveGroupLayouterEngine();
			// now do the layout
			layoutEngine.layout(layoutGraph);
			// notify layout listeners about the performed layout
			LayoutListeners.getInstance().layoutPerformed(layoutGraph);
			// and apply layout to model
			applyLayout();
		}
		catch (Throwable exception) {
			Status status = new Status(IStatus.ERROR, KimlLayoutPlugin.PLUGIN_ID,
					"Failed to perform diagram layout.", exception);
			StatusManager.getManager().handle(status, StatusManager.SHOW);
		}
	}

	/**
	 * Returns the settings currently active in the diagram layouter. These are
	 * the settings the actual layouter owns, and which are adjustable through
	 * means of the layouter, e.g. a preference page.
	 * 
	 * @return a String-to-String map of the settings of the diagram layouter.
	 */
	public Map<String, String> getSettings() {
		return new HashMap<String, String>();
	}

	/**
	 * Returns a label provider that is capable of getting labels for concrete
	 * diagram edit parts such as nodes.
	 * 
	 * @return a label provider that is compatible with the related diagram
	 */
	public ILabelProvider getLabelProvider() {
		return new LabelProvider();
	}

	/**
	 * Is called first during the layout process. Implementations should
	 * initialize the layouter for a new given selection of a diagram, should
	 * choose the right diagram elements for laying out and prepare all needed
	 * structures.
	 * 
	 * @param target
	 *            Object specifying what is to be laid out. The translation in
	 *            {@link buildLayoutGraph} should be able to process this
	 *            object, or there should be a mechanism in this method to
	 *            extract a fitting rootPart for the layout.
	 * @throws IllegalArgumentException when the target object is not
	 *            supported
	 */
	protected abstract void init(Object target) throws IllegalArgumentException;

	/**
	 * Is called second during the layout process. Implementing methods should
	 * create the layout graph that corresponds to the diagram elements to be
	 * laid out.
	 * 
	 * @return A KLayoutGraph
	 */
	protected abstract KLayoutGraph buildLayoutGraph();

	/**
	 * Is called last during the layout process. Implementing methods should
	 * apply all layout information generated in the previous step to the
	 * diagram in the editor or viewer.
	 */
	protected abstract void applyLayout();

}
