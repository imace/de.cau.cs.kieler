package edu.unikiel.rtsys.kieler.core.preferences;

import org.eclipse.jface.preference.StringFieldEditor;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

public class DoubleFieldEditor extends StringFieldEditor {

	double min=Double.MIN_NORMAL, max=Double.MAX_VALUE;
	
	/** 
	 * Creates a new Double Field Editor
	 */
	public DoubleFieldEditor() {
		super();
	}
	
	/**
	 * Creates a new Double Field Editor
	 * @param name the name of the preference this field editor works on
	 * @param labelText the label text of the field editor
	 * @param parent the parent of the field editor's control
	 */
	public DoubleFieldEditor(String name, String labelText, Composite parent){
		super(name,labelText,parent);
	}
	/**
	 * Creates a new Double Field Editor
	 * @param name the name of the preference this field editor works on
	 * @param labelText the label text of the field editor
	 * @param width the width of the text input field in characters, or UNLIMITED for no limit
	 * @param parent the parent of the field editor's control
	 */
	public DoubleFieldEditor(String name, String labelText, int width,
			Composite parent) {
		super(name, labelText, width, parent);
		// TODO Auto-generated constructor stub
	}
	/**
	 * Creates a new Double Field Editor
	 * @param name the name of the preference this field editor works on
	 * @param labelText the label text of the field editor
	 * @param width the width of the text input field in characters, or UNLIMITED for no limit
	 * @param strategy either VALIDATE_ON_KEY_STROKE to perform on the fly checking (the default), or VALIDATE_ON_FOCUS_LOST to perform validation only after the text has been typed in
	 * @param parent the parent of the field editor's control
	 */
	public DoubleFieldEditor(String name, String labelText, int width,
			int strategy, Composite parent) {
		super(name, labelText, width, strategy, parent);
		// TODO Auto-generated constructor stub
	}

	/**
     * Sets the range of valid values for this field.
     * 
     * @param min the minimum allowed value (inclusive)
     * @param max the maximum allowed value (inclusive)
     */
    public void setValidRange(double min, double max) {
        this.min = min;
        this.max = max;
//        setErrorMessage(JFaceResources.format(
//        		"DoubleFieldEditor.errorMessageRange", //$NON-NLS-1$
//        		new Object[] { new Integer((int)min), new Integer((int)max) }));
        setErrorMessage("Double Field requires double in the bounds ["+min+","+max+"]");
    }
	
    /* (non-Javadoc)
     * Method declared on StringFieldEditor.
     * Checks whether the entered String is a valid double or not.
     */
    protected boolean checkState() {

        Text text = getTextControl();

        if (text == null) {
			return false;
		}

        String numberString = text.getText();
        try {
            double number = Double.valueOf(numberString).doubleValue();
            if (number >= min && number <= max) {
				clearErrorMessage();
				return true;
			}
            
			showErrorMessage();
			return false;
			
        } catch (NumberFormatException e1) {
            showErrorMessage();
        }
        return false;
    }
    
    /* (non-Javadoc)
     * Method declared on FieldEditor.
     */
    protected void doLoad() {
        Text text = getTextControl();
        if (text != null) {
            double value = getPreferenceStore().getDouble(getPreferenceName());
            text.setText("" + value);//$NON-NLS-1$
            oldValue = "" + value; //$NON-NLS-1$
        }
    }
    
    /* (non-Javadoc)
     * Method declared on FieldEditor.
     */
    protected void doLoadDefault() {
        Text text = getTextControl();
        if (text != null) {
            double value = getPreferenceStore().getDefaultDouble(getPreferenceName());
            text.setText("" + value);//$NON-NLS-1$
        }
        valueChanged();
    }
    
    /* (non-Javadoc)
     * Method declared on FieldEditor.
     */
    protected void doStore() {
        Text text = getTextControl();
        if (text != null) {
            Double d = new Double(text.getText());
            getPreferenceStore().setValue(getPreferenceName(), d.doubleValue());
        }
    }
    
    /**
     * Returns this field editor's current value as an integer.
     *
     * @return the value
     * @exception NumberFormatException if the <code>String</code> does not
     *   contain a parsable integer
     */
    public double getDoubleValue() throws NumberFormatException {
        return new Double(getStringValue()).doubleValue();
    }
    

}
