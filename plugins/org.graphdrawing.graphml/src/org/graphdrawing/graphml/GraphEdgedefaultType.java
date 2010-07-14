/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.graphdrawing.graphml;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Graph Edgedefault Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * 
 *       Simple type for the edgedefault attribute of &lt;graph&gt;.
 *       graph.edgedefault.type is a restriction of xs:NMTOKEN
 *       Allowed values: directed, undirected.
 *     
 * <!-- end-model-doc -->
 * @see org.graphdrawing.graphml.GraphMLPackage#getGraphEdgedefaultType()
 * @model extendedMetaData="name='graph.edgedefault.type'"
 * @generated
 */
public enum GraphEdgedefaultType implements Enumerator {
    /**
     * The '<em><b>Directed</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #DIRECTED_VALUE
     * @generated
     * @ordered
     */
    DIRECTED(0, "directed", "directed"),

    /**
     * The '<em><b>Undirected</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #UNDIRECTED_VALUE
     * @generated
     * @ordered
     */
    UNDIRECTED(1, "undirected", "undirected");

    /**
     * The '<em><b>Directed</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>Directed</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #DIRECTED
     * @model name="directed"
     * @generated
     * @ordered
     */
    public static final int DIRECTED_VALUE = 0;

    /**
     * The '<em><b>Undirected</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>Undirected</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #UNDIRECTED
     * @model name="undirected"
     * @generated
     * @ordered
     */
    public static final int UNDIRECTED_VALUE = 1;

    /**
     * An array of all the '<em><b>Graph Edgedefault Type</b></em>' enumerators.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private static final GraphEdgedefaultType[] VALUES_ARRAY =
        new GraphEdgedefaultType[] {
            DIRECTED,
            UNDIRECTED,
        };

    /**
     * A public read-only list of all the '<em><b>Graph Edgedefault Type</b></em>' enumerators.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final List<GraphEdgedefaultType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

    /**
     * Returns the '<em><b>Graph Edgedefault Type</b></em>' literal with the specified literal value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static GraphEdgedefaultType get(String literal) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            GraphEdgedefaultType result = VALUES_ARRAY[i];
            if (result.toString().equals(literal)) {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>Graph Edgedefault Type</b></em>' literal with the specified name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static GraphEdgedefaultType getByName(String name) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            GraphEdgedefaultType result = VALUES_ARRAY[i];
            if (result.getName().equals(name)) {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>Graph Edgedefault Type</b></em>' literal with the specified integer value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static GraphEdgedefaultType get(int value) {
        switch (value) {
            case DIRECTED_VALUE: return DIRECTED;
            case UNDIRECTED_VALUE: return UNDIRECTED;
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
    private GraphEdgedefaultType(int value, String name, String literal) {
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
    
} //GraphEdgedefaultType
