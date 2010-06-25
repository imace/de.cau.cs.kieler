/**
 * KIELER - Kiel Integrated Environment for Layout Eclipse RichClient
 * 
 * http://www.informatik.uni-kiel.de/rtsys/kieler/
 * 
 * Copyright 2010 by
 * + Christian-Albrechts-University of Kiel
 *   + Department of Computer Science
 *     + Real-Time and Embedded Systems Group
 * 
 * This code is provided under the terms of the Eclipse Public License (EPL).
 * See the file epl-v10.html for the license text.
 */
package de.cau.cs.kieler.core.expressions;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Value Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see de.cau.cs.kieler.core.expressions.ExpressionsPackage#getValueType()
 * @model
 * @generated
 */
public enum ValueType implements Enumerator {
    /**
     * The '<em><b>PURE</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #PURE_VALUE
     * @generated
     * @ordered
     */
    PURE(0, "PURE", "pure"),

    /**
     * The '<em><b>BOOL</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #BOOL_VALUE
     * @generated
     * @ordered
     */
    BOOL(1, "BOOL", "bool"),

    /**
     * The '<em><b>UNSIGNED</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #UNSIGNED_VALUE
     * @generated
     * @ordered
     */
    UNSIGNED(2, "UNSIGNED", "unsigned"),

    /**
     * The '<em><b>INT</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #INT_VALUE
     * @generated
     * @ordered
     */
    INT(3, "INT", "int"),

    /**
     * The '<em><b>FLOAT</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #FLOAT_VALUE
     * @generated
     * @ordered
     */
    FLOAT(4, "FLOAT", "float"),

    /**
     * The '<em><b>HOST</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #HOST_VALUE
     * @generated
     * @ordered
     */
    HOST(0, "HOST", "host");

    /**
     * The '<em><b>PURE</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>PURE</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #PURE
     * @model literal="pure"
     * @generated
     * @ordered
     */
    public static final int PURE_VALUE = 0;

    /**
     * The '<em><b>BOOL</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>BOOL</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #BOOL
     * @model literal="bool"
     * @generated
     * @ordered
     */
    public static final int BOOL_VALUE = 1;

    /**
     * The '<em><b>UNSIGNED</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>UNSIGNED</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #UNSIGNED
     * @model literal="unsigned"
     * @generated
     * @ordered
     */
    public static final int UNSIGNED_VALUE = 2;

    /**
     * The '<em><b>INT</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>INT</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #INT
     * @model literal="int"
     * @generated
     * @ordered
     */
    public static final int INT_VALUE = 3;

    /**
     * The '<em><b>FLOAT</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>FLOAT</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #FLOAT
     * @model literal="float"
     * @generated
     * @ordered
     */
    public static final int FLOAT_VALUE = 4;

    /**
     * The '<em><b>HOST</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>HOST</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #HOST
     * @model literal="host"
     * @generated
     * @ordered
     */
    public static final int HOST_VALUE = 0;

    /**
     * An array of all the '<em><b>Value Type</b></em>' enumerators.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private static final ValueType[] VALUES_ARRAY =
        new ValueType[] {
            PURE,
            BOOL,
            UNSIGNED,
            INT,
            FLOAT,
            HOST,
        };

    /**
     * A public read-only list of all the '<em><b>Value Type</b></em>' enumerators.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final List<ValueType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

    /**
     * Returns the '<em><b>Value Type</b></em>' literal with the specified literal value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static ValueType get(String literal) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            ValueType result = VALUES_ARRAY[i];
            if (result.toString().equals(literal)) {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>Value Type</b></em>' literal with the specified name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static ValueType getByName(String name) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            ValueType result = VALUES_ARRAY[i];
            if (result.getName().equals(name)) {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>Value Type</b></em>' literal with the specified integer value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static ValueType get(int value) {
        switch (value) {
            case PURE_VALUE: return PURE;
            case BOOL_VALUE: return BOOL;
            case UNSIGNED_VALUE: return UNSIGNED;
            case INT_VALUE: return INT;
            case FLOAT_VALUE: return FLOAT;
        }
        return null;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private final int value;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private final String name;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private final String literal;

    /**
     * Only this class can construct instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private ValueType(int value, String name, String literal) {
        this.value = value;
        this.name = name;
        this.literal = literal;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public int getValue() {
      return value;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getName() {
      return name;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getLiteral() {
      return literal;
    }

    /**
     * Returns the literal value of the enumerator, which is its string representation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String toString() {
        return literal;
    }
    
} //ValueType
