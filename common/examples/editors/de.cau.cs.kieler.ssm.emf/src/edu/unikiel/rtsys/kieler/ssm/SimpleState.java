/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.unikiel.rtsys.kieler.ssm;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Simple State</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.unikiel.rtsys.kieler.ssm.SimpleState#getStateFlag <em>State Flag</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.unikiel.rtsys.kieler.ssm.ssmPackage#getSimpleState()
 * @model
 * @generated
 */
public interface SimpleState extends AbstractState, Named {
    /**
	 * Returns the value of the '<em><b>State Flag</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * The literals are from the enumeration {@link edu.unikiel.rtsys.kieler.ssm.StateFlag}.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>State Flag</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>State Flag</em>' attribute.
	 * @see edu.unikiel.rtsys.kieler.ssm.StateFlag
	 * @see #setStateFlag(StateFlag)
	 * @see edu.unikiel.rtsys.kieler.ssm.ssmPackage#getSimpleState_StateFlag()
	 * @model default="" unique="false" required="true"
	 * @generated
	 */
    StateFlag getStateFlag();

    /**
	 * Sets the value of the '{@link edu.unikiel.rtsys.kieler.ssm.SimpleState#getStateFlag <em>State Flag</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>State Flag</em>' attribute.
	 * @see edu.unikiel.rtsys.kieler.ssm.StateFlag
	 * @see #getStateFlag()
	 * @generated
	 */
    void setStateFlag(StateFlag value);

} // SimpleState
