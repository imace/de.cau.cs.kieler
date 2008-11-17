package edu.unikiel.rtsys.kieler.core.util;

import org.eclipse.jface.preference.StringFieldEditor;
import org.eclipse.swt.widgets.Composite;

/**
 * Field editor for input of float values.
 * 
 * @author msp
 */
public class FloatFieldEditor extends StringFieldEditor {
	
	float lowerBound = -Float.MAX_VALUE;
	float upperBound = Float.MAX_VALUE;

	/**
	 * Creates a new float field editor.
	 * 
	 * @param name the name of the preference this field editor works on
	 * @param labelText the label text of the field editor
	 * @param parent the parent of the field editor's control
	 */
	public FloatFieldEditor(String name, String labelText, Composite parent)
	{
		super(name, labelText, parent);
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.eclipse.jface.preference.StringFieldEditor#checkState()
	 */
	protected boolean checkState()
	{
		try
		{
			float value = getFloatValue();
			return value >= lowerBound && value <= upperBound;
		}
		catch (NumberFormatException exception)
		{
			return false;
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.eclipse.jface.preference.StringFieldEditor#doLoad()
	 */
	protected void doLoad()
	{
		float value = getPreferenceStore().getFloat(getPreferenceName());
		setStringValue(Float.toString(value));
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.eclipse.jface.preference.StringFieldEditor#doLoadDefault()
	 */
	protected void doLoadDefault()
	{
		float value = getPreferenceStore().getDefaultFloat(getPreferenceName());
		setStringValue(Float.toString(value));
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.eclipse.jface.preference.StringFieldEditor#doStore()
	 */
	protected void doStore()
	{
		try
		{
			float value = getFloatValue();
			getPreferenceStore().setValue(getPreferenceName(), value);
		}
		catch (NumberFormatException exception)
		{
			// invalid textual input - ignore store command
		}
	}
	
	/**
	 * Sets the range of valid float values for this field editor. The
	 * default is to accept all float values except NaN and infinity.
	 * 
	 * @param min lower bound for float values
	 * @param max upper bound for float values
	 */
	public void setValidRange(float min, float max)
	{
		this.lowerBound = min;
		this.upperBound = max;
	}
	
	/**
	 * Parses the input string as a float value.
	 * 
	 * @return float value
	 * @throws NumberFormatException when the input string does not
	 *     represent a float value
	 */
	public float getFloatValue() throws NumberFormatException
	{
		return Float.parseFloat(getStringValue());
	}

}
