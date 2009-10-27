/*
 * KIELER - Kiel Integrated Environment for Layout Eclipse RichClient
 *
 * http://www.informatik.uni-kiel.de/rtsys/kieler/
 * 
 * Copyright 2009 by
 * + Christian-Albrechts-University of Kiel
 *   + Department of Computer Science
 *     + Real-Time and Embedded Systems Group
 * 
 * This code is provided under the terms of the Eclipse Public License (EPL).
 * See the file epl-v10.html for the license text.
 */

package de.cau.cs.kieler.sim.kiem.data;

import java.io.Serializable;

/**
 * The Class KiemProperty. This is the basic serializable KiemProperty 
 * implementation which can hold a key value pair of types String and
 * also a KiemPropertyType.  
 * The contents of the KiemProperty can be saved and loaded but the
 * KiemPropertyType is recovered by its identifier.
 *
 * @author Christian Motika - cmot AT informatik.uni-kiel.de
 * 
 */
public class KiemProperty implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -6897758298476417410L;
	
	/** The String key of the KiemProperty. */
	protected String key;
	
	/** The String value of the KiemProperty. */
	protected String value;
	
	/** The KiemPropertyType of the KiemProperty. */
	protected transient KiemPropertyType type;
	
	/** The propertyType id of the component for deserialization */
	@SuppressWarnings("unused")
	private String propertyTypeId;

	//-------------------------------------------------------------------------

	/**
	 * Instantiates a new String KiemProperty, with given default value.
	 * 
	 * @param key the key of this property
	 * @param type the type of this property
	 * @param value the value of this property
	 */
	public KiemProperty(String key, KiemPropertyType type, String value) {
		this.key = key;
		this.value = value;
		this.type = type; 
		this.propertyTypeId = type.getId();
	}

	//-------------------------------------------------------------------------

	/**
	 * Instantiates a new KiemProperty of given type with given default value.
	 * 
	 * @param key the key of this property
	 * @param type the type of this property
	 * @param value the value of this property
	 */
	public KiemProperty(String key, KiemPropertyType type, int value) {
		this.key = key;
		this.value = ""+value;
		this.type = type; 
	}

	//-------------------------------------------------------------------------
	
	/**
	 * Instantiates a new KiemProperty of given type with empty default value.
	 * 
	 * @param key the key of this property
	 * @param type the type of this property
	 */
	public KiemProperty(String key, KiemPropertyType type) {
		this.key = key;
		this.value = "";
		this.type = type; 
	}

	//-------------------------------------------------------------------------

	/**
	 * Instantiates a new String KiemProperty with empty default value. 
	 * 
	 * @param key the key of this property
	 */
	public KiemProperty(String key) {
		this.key = key;
		this.value = "";
		this.type = new KiemPropertyTypeString();  
	}
	
	//-------------------------------------------------------------------------

	/**
	 * Instantiates a new String KiemProperty with given default value.
	 * 
	 * @param key the key of this property
	 * @param value the value of this property
	 */
	public KiemProperty(String key, String value) {
		this.key = key;
		this.value = value;
		this.type = new KiemPropertyTypeString();  
	}
	
	//-------------------------------------------------------------------------

	/**
	 * Instantiates a new int KiemProperty with given default value.
	 * 
	 * @param key the key of this property
	 * @param value the value of this property
	 */
	public KiemProperty(String key, int value) {
		this.key = key;
		this.value = value+"";
		this.type = new KiemPropertyTypeInt(); 
	}

	//-------------------------------------------------------------------------

	/**
	 * Instantiates a new boolean KiemProperty with given default value.
	 * 
	 * @param key the key of this property
	 * @param value the value of this property
	 */
	public KiemProperty(String key, boolean value) {
		this.key = key;
		this.value = (value == true) ? "true" : "false";
		this.type = new KiemPropertyTypeBool(); 
	}
	
	//-------------------------------------------------------------------------

	/**
	 * Gets the key of the KiemProperty.
	 * 
	 * @return the String property key
	 */
	public String getKey() {
		return this.key;
	}
	
	//-------------------------------------------------------------------------

	/**
	 * Gets the value of the KiempProperty.
	 * 
	 * @return the String property value
	 */
	public String getValue() {
		return this.value;
	}
	
	//-------------------------------------------------------------------------

	/**
	 * Gets the type of the KiemProperty.
	 * 
	 * @return the KiemPropertyType
	 */
	public KiemPropertyType getType() {
		return this.type;
	}
	
	//-------------------------------------------------------------------------

	/**
	 * Sets the KIEM property type.
	 * 
	 * @param type the new property type
	 */
	public void setType(KiemPropertyType type) {
		this.type = type;
	}
	
	//-------------------------------------------------------------------------
	
	/**
	 * Sets the value of the KiemPorperty.
	 * 
	 * @param value the new String property value
	 */
	public void setValue(String value) {
		this.value = value;
	}

	//-------------------------------------------------------------------------
	
	/**
	 * Gets the file path as a String. This interprets the property value as
	 * a file path.
	 * 
	 * @return the String file path
	 */
	public String getFilePath() {
		return this.value.replace("\\", "/");
	}
	
	//-------------------------------------------------------------------------

	/**
	 * Gets the directory as a String. This interprets the property value as
	 * a file and extracts the directory out of it.
	 * 
	 * @return the String directory
	 */
	public String getDirectory() {
		String backDir = this.value;
		backDir = backDir.replace("\\", "/");
		int i = backDir.lastIndexOf("/");
		if (i > -1)
			backDir = backDir.substring(0,i+1);
		return backDir;
	}

}
