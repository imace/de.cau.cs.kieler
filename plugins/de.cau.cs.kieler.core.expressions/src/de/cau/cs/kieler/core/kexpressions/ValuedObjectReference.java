/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.cau.cs.kieler.core.kexpressions;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Valued Object Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A ValuedObjectReference has a reference to a ValuedObject and is a ComplexExpression.
 * Therefore such reference may have subExpressions. Those can be used to 
 * address a specific value. E.g. the ValuedObject could carry an array
 * value and a subExpression could be an IntValue that points to a special entry in 
 * that array. 
 * <p>
 * The distinction between a Variable and a VariableReference is mainly due to containment
 * relations. A Variable is usually defined exactly once and therefore contained by some 
 * scope element. A reference to that Variable may be required multiple times where
 * such reference need to be contained at the places where the reference is used.
 * Hence we need this distinction.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.core.kexpressions.ValuedObjectReference#getValuedObject <em>Valued Object</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.cau.cs.kieler.core.kexpressions.KExpressionsPackage#getValuedObjectReference()
 * @model
 * @generated
 */
public interface ValuedObjectReference extends ComplexExpression {
    /**
     * Returns the value of the '<em><b>Valued Object</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Valued Object</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Valued Object</em>' reference.
     * @see #setValuedObject(ValuedObject)
     * @see de.cau.cs.kieler.core.kexpressions.KExpressionsPackage#getValuedObjectReference_ValuedObject()
     * @model required="true"
     * @generated
     */
    ValuedObject getValuedObject();

    /**
     * Sets the value of the '{@link de.cau.cs.kieler.core.kexpressions.ValuedObjectReference#getValuedObject <em>Valued Object</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Valued Object</em>' reference.
     * @see #getValuedObject()
     * @generated
     */
    void setValuedObject(ValuedObject value);

} // ValuedObjectReference
