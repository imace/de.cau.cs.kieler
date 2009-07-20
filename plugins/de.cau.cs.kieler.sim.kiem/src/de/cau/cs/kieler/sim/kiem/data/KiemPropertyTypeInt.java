package de.cau.cs.kieler.sim.kiem.data;

import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.plugin.AbstractUIPlugin;

public class KiemPropertyTypeInt extends KiemPropertyType
									implements IKiemPropertyType {
	
	private static final long serialVersionUID = 8908596145125394334L;
	private static final Image PROPERTY_INT = AbstractUIPlugin
	.imageDescriptorFromPlugin("de.cau.cs.kieler.sim.kiem",
			"icons/propertyIntIcon.png").createImage();

	public KiemPropertyTypeInt() {
		super();
	}

	@Override
	public Object getValue(Object element) {
		KiemProperty property = (KiemProperty)element;
		return property.value;
	}

	@Override
	public void setValue(Object element, Object value) {
		KiemProperty property = (KiemProperty)element;
		try {
			property.setValue(""+Integer.valueOf((String)value));
		}catch(Exception e) {
		}
	}

	@Override
	public Image getIcon() {
		return PROPERTY_INT;
	}

}
