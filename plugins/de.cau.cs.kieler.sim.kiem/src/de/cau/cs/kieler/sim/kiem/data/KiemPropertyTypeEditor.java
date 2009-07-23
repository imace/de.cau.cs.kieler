package de.cau.cs.kieler.sim.kiem.data;

import org.eclipse.jface.viewers.ComboBoxCellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.plugin.AbstractUIPlugin;

public class KiemPropertyTypeEditor extends KiemPropertyType
									implements IKiemPropertyType {
	
	private static final long serialVersionUID = 3163900421868918205L;

	private static final Image PROPERTY_CHOICE = AbstractUIPlugin
			.imageDescriptorFromPlugin("de.cau.cs.kieler.sim.kiem",
					"icons/propertyEditorIcon.png").createImage();
	
	private String[] items;

	public KiemPropertyTypeEditor() {
		super();
	}
	
	@Override 
	public void setCellEditor(Composite parent) {
		refreshItems();
		cellEditor = new ComboBoxCellEditor(parent, 
									items, 
									SWT.Deactivate);
	}

	public void refreshItems() {
	    IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
	    IEditorReference[] editors = page.getEditorReferences();
	    if ((editors == null)||(editors.length == 0)) {
	    	this.items = new String[0];
	    	return;
	    }
		String[] items = new String[editors.length];
		for (int c = 0; c < editors.length; c++) {
			 items[c] = editors[c].getTitle() + " (" + editors[c].getId() + ")";
		}
		this.items = items;
	}
	
	@Override
	public Object getValue(KiemProperty property) {
		if ((items == null)||(items.length == 0)) return 0;
		for (int c = 0; c < items.length; c ++) {
			if (property.getValue().equals(items[c])) return c;
		}
		return 0; //default is the first item
	}

	@Override
	public void setValue(KiemProperty property, Object value) {
		if ((items == null)||(items.length == 0)) return;
		property.setValue(items[Integer.parseInt((String)value)]);
	}
	
	public void setItems(String[] items) {
		this.items = items;
	}

	@Override
	public Image getIcon() {
		return PROPERTY_CHOICE;
	}

}
