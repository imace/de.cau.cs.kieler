package dataflow.diagram.layout.preferences;

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.FieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.RadioGroupFieldEditor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import dataflow.diagram.layout.DataflowDiagramLayoutPlugin;
import dataflow.diagram.layout.Messages;

/**
 * Preference page for the dataflow diagram editor that controls
 * diagram-specific layout options.
 * 
 * @author msp
 */
public class DiagramLayoutPreferencePage extends FieldEditorPreferencePage
		implements IWorkbenchPreferencePage {

	/** Preserve box size for empty boxes */
	public static final String FIXED_NODE_SIZE = "Layout.fixedNodeSize"; //$NON-NLS-1$
	/** Port constraints options for empty boxes */
	public static final String EMPTY_PORT_CONSTRAINTS = "Layout.emptyPortConstraints"; //$NON-NLS-1$
	/** Preserve port positions for non-empty boxes */
    public static final String NONEMPTY_PORT_CONSTRAINTS = "Layout.nonemptyPortConstraints"; //$NON-NLS-1$
    /** Layout direction: horizontal or vertical */
	public static final String LAYOUT_DIRECTION = "Layout.layoutDirection"; //$NON-NLS-1$
	
	/** value for fixed ports position option */
	public static final String VAL_PORT_FIXED_POS = "fixedPos";
	/** value for fixed ports order option */
    public static final String VAL_PORT_FIXED_ORDER = "fixedOrder";
    /** value for fixed ports side option */
	public static final String VAL_PORT_FIXED_SIDE = "fixedSide";
	/** value for free ports option */
	public static final String VAL_FREE_PORTS = "free";
	/** value for horizontal layout option */
	public static final String VAL_HORIZONTAL = "horizontal";
	/** value for vertical layout option */
	public static final String VAL_VERTICAL = "vertical";
	/** value for alternating horizontal / vertical layout option */
	public static final String VAL_ALTERNATING = "hv";
	
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
		
		FieldEditor fixedNodeSizeEditor = new BooleanFieldEditor(
				FIXED_NODE_SIZE,
				Messages.getString("dataflow.layout.8"), composite); //$NON-NLS-1$
		FieldEditor emptyPortConstraintsEditor = new RadioGroupFieldEditor(
				EMPTY_PORT_CONSTRAINTS,
				Messages.getString("dataflow.layout.15"), 1, new String[][] { //$NON-NLS-1$
					{ Messages.getString("dataflow.layout.16"), VAL_PORT_FIXED_POS }, //$NON-NLS-1$
					{ Messages.getString("dataflow.layout.19"), VAL_PORT_FIXED_ORDER }, //$NON-NLS-1$
                    { Messages.getString("dataflow.layout.17"), VAL_PORT_FIXED_SIDE }, //$NON-NLS-1$
					{ Messages.getString("dataflow.layout.18"), VAL_FREE_PORTS } //$NON-NLS-1$
				}, composite, true);
		FieldEditor nonemptyPortConstraintsEditor = new RadioGroupFieldEditor(
                NONEMPTY_PORT_CONSTRAINTS,
                Messages.getString("dataflow.layout.20"), 1, new String[][] { //$NON-NLS-1$
                    { Messages.getString("dataflow.layout.16"), VAL_PORT_FIXED_POS }, //$NON-NLS-1$
                    { Messages.getString("dataflow.layout.19"), VAL_PORT_FIXED_ORDER }, //$NON-NLS-1$
                    { Messages.getString("dataflow.layout.17"), VAL_PORT_FIXED_SIDE }, //$NON-NLS-1$
                    { Messages.getString("dataflow.layout.18"), VAL_FREE_PORTS } //$NON-NLS-1$
                }, composite, true);
        FieldEditor layoutDirectionEditor = new RadioGroupFieldEditor(
				LAYOUT_DIRECTION,
				Messages.getString("dataflow.layout.10"), 1, new String[][] { //$NON-NLS-1$
					{ Messages.getString("dataflow.layout.11"), VAL_HORIZONTAL }, //$NON-NLS-1$
					{ Messages.getString("dataflow.layout.13"), VAL_VERTICAL }, //$NON-NLS-1$
					{ Messages.getString("dataflow.layout.14"), VAL_ALTERNATING } //$NON-NLS-1$
				}, composite, true);
		
		addField(fixedNodeSizeEditor);
		addField(emptyPortConstraintsEditor);
		addField(nonemptyPortConstraintsEditor);
        addField(layoutDirectionEditor);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.IWorkbenchPreferencePage#init(org.eclipse.ui.IWorkbench)
	 */
	public void init(IWorkbench workbench) {
	}

}
