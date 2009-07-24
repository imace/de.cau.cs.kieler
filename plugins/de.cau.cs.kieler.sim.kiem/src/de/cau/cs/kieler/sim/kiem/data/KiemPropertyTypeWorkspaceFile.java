package de.cau.cs.kieler.sim.kiem.data;

import org.eclipse.core.internal.resources.File;

import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.DialogCellEditor;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;
import org.eclipse.ui.model.BaseWorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchLabelProvider;
import org.eclipse.ui.plugin.AbstractUIPlugin;

public class KiemPropertyTypeWorkspaceFile extends KiemPropertyType
									implements IKiemPropertyType {
	
	private static final long serialVersionUID = -2468753195329915004L;


	private static final Image PROPERTY_FILE = AbstractUIPlugin
			.imageDescriptorFromPlugin("de.cau.cs.kieler.sim.kiem",
					"icons/propertyFileIcon.png").createImage();

	
	private static final String[] DEFAULT_FILTER_NAMES = {"All Files (*.*)"};
	private static final String[] DEFAULT_FILTER_EXTS = {"*.*"};
	private String[] filterNames;
	private String[] filterExts;
	
	public KiemPropertyTypeWorkspaceFile() {
		super();
		this.filterNames = DEFAULT_FILTER_NAMES;
		this.filterExts = DEFAULT_FILTER_EXTS;
	}

	public Object getValue(KiemProperty property) {
		return property.value;
	}

	public void setValue(KiemProperty property, Object value) {
		if (value != null)
			property.setValue((String)value);
	}

	@Override
	public Image provideIcon() {
		return PROPERTY_FILE;
	}
	
	
	@Override 
	public CellEditor provideCellEditor(Composite parent) {
		return new CustomDialogCellEditor(parent);
	}
	

	public void setFilterNames(String[] filterNames) {
		this.filterNames = filterNames;
	}
	public String[] getFilterNames() {
		return this.filterNames;
	}
	
	public void setFilterExts(String[] filterExts) {
		this.filterExts = filterExts;
	}
	public String[] getFilterExts() {
		return this.filterExts;
	}
	
	//--------------------
	
	public class CustomDialogCellEditor extends DialogCellEditor {
		
	    public CustomDialogCellEditor(Composite parent) {
	        super(parent);
	    }

		@Override
		protected Object openDialogBox(Control cellEditorWindow) {
				
			ElementTreeSelectionDialog dlg = 
				new ElementTreeSelectionDialog(cellEditorWindow.getShell(), 
											   new WorkbenchLabelProvider(), 
											   new BaseWorkbenchContentProvider());
			dlg.setTitle("Open");
			dlg.setMessage("Select a file from your workspace to be opened:");
			dlg.setInput(ResourcesPlugin.getWorkspace().getRoot());
			dlg.setAllowMultiple(false);
			int val = dlg.open();
			if (val == 0) {
				return ((File)dlg.getFirstResult())
								.getFullPath().toOSString();
			}
			return null;
		}
	}
}
