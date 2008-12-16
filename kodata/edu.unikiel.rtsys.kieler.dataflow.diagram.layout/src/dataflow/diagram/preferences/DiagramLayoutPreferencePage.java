package dataflow.diagram.preferences;

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.FieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.RadioGroupFieldEditor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import dataflow.diagram.DataflowDiagramLayoutPlugin;
import dataflow.diagram.Messages;

/**
 * Preference page for the dataflow diagram editor that controls
 * diagram-specific layout options.
 * 
 * @author msp
 */
public class DiagramLayoutPreferencePage extends FieldEditorPreferencePage
		implements IWorkbenchPreferencePage {

	/** Preserve port positions for empty boxes */
	public static final String FIXED_INNER_PORTS = "Layout.fixedInnerPorts"; //$NON-NLS-1$
	/** Preserve port positions for non-empty boxes */
	public static final String FIXED_OUTER_PORTS = "Layout.fixedOuterPorts"; //$NON-NLS-1$
	/** Preserve box size for empty boxes */
	public static final String FIXED_NODE_SIZE = "Layout.fixedNodeSize"; //$NON-NLS-1$
	/** Strict port side: left for input ports, right for output ports */
	public static final String STRICT_PORT_SIDE = "Layout.strictPortSide"; //$NON-NLS-1$
	/** Layout direction: horizontal or vertical */
	public static final String LAYOUT_DIRECTION = "Layout.layoutDirection"; //$NON-NLS-1$
	
	/**
	 * Creates a diagram layout preference page.
	 */
	public DiagramLayoutPreferencePage() {
		super();
		setPreferenceStore(DataflowDiagramLayoutPlugin.getDefault().getPreferenceStore());
		setDescription(Messages.getString("dataflow.layout.5")); //$NON-NLS-1$
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.preference.FieldEditorPreferencePage#createFieldEditors()
	 */
	protected void createFieldEditors() {
		Composite composite = getFieldEditorParent();
		
		FieldEditor fixedInnerPortsEditor = new BooleanFieldEditor(FIXED_INNER_PORTS,
				Messages.getString("dataflow.layout.6"), composite); //$NON-NLS-1$
		FieldEditor fixedOuterPortsEditor = new BooleanFieldEditor(FIXED_OUTER_PORTS,
				Messages.getString("dataflow.layout.7"), composite); //$NON-NLS-1$
		FieldEditor fixedNodeSizeEditor = new BooleanFieldEditor(FIXED_NODE_SIZE,
				Messages.getString("dataflow.layout.8"), composite); //$NON-NLS-1$
		FieldEditor strictPortSideEditor = new BooleanFieldEditor(STRICT_PORT_SIDE,
				Messages.getString("dataflow.layout.9"), composite); //$NON-NLS-1$
		FieldEditor layoutDirectionEditor = new RadioGroupFieldEditor(LAYOUT_DIRECTION,
				Messages.getString("dataflow.layout.10"), 1, new String[][] { //$NON-NLS-1$
					{ Messages.getString("dataflow.layout.11"), "horizontal" }, //$NON-NLS-1$ //$NON-NLS-2$
					{ Messages.getString("dataflow.layout.13"), "vertical" } //$NON-NLS-1$ //$NON-NLS-2$
				}, composite, true);
		
		addField(fixedInnerPortsEditor);
		addField(fixedOuterPortsEditor);
		addField(fixedNodeSizeEditor);
		addField(strictPortSideEditor);
		addField(layoutDirectionEditor);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.IWorkbenchPreferencePage#init(org.eclipse.ui.IWorkbench)
	 */
	public void init(IWorkbench workbench) {
	}

}
