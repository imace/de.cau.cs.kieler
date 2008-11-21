package dataflow.diagram.preferences;

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.FieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import dataflow.diagram.DataflowDiagramLayoutPlugin;

/**
 * Preference page for the dataflow diagram editor that controls
 * diagram-specific layout options.
 * 
 * @author msp
 */
public class DiagramLayoutPreferencePage extends FieldEditorPreferencePage
		implements IWorkbenchPreferencePage {

	/** Preserve port positions for empty boxes */
	public static final String FIXED_INNER_PORTS = "Layout.fixedInnerPorts";
	/** Preserve port positions for non-empty boxes */
	public static final String FIXED_OUTER_PORTS = "Layout.fixedOuterPorts";
	/** Preserve box size for empty boxes */
	public static final String FIXED_NODE_SIZE = "Layout.fixedNodeSize";
	/** Strict port side: left for input ports, right for output ports */
	public static final String STRICT_PORT_SIDE = "Layout.strictPortSide";
	
	/**
	 * Creates a diagram layout preference page.
	 */
	public DiagramLayoutPreferencePage() {
		super();
		setPreferenceStore(DataflowDiagramLayoutPlugin.getDefault().getPreferenceStore());
		setDescription("Diagram specific layout options:");
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.preference.FieldEditorPreferencePage#createFieldEditors()
	 */
	protected void createFieldEditors() {
		Composite composite = getFieldEditorParent();
		
		FieldEditor fixedInnerPortsEditor = new BooleanFieldEditor(FIXED_INNER_PORTS,
				"Preserve port positions for empty boxes", composite);
		FieldEditor fixedOuterPortsEditor = new BooleanFieldEditor(FIXED_OUTER_PORTS,
				"Preserve port positions for non-empty boxes", composite);
		FieldEditor fixedNodeSizeEditor = new BooleanFieldEditor(FIXED_NODE_SIZE,
				"Preserve box size for empty boxes", composite);
		FieldEditor strictPortSideEditor = new BooleanFieldEditor(STRICT_PORT_SIDE,
				"Strict port side: left for input ports, right for output ports", composite);
		
		addField(fixedInnerPortsEditor);
		addField(fixedOuterPortsEditor);
		addField(fixedNodeSizeEditor);
		addField(strictPortSideEditor);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.IWorkbenchPreferencePage#init(org.eclipse.ui.IWorkbench)
	 */
	public void init(IWorkbench workbench) {
	}

}
