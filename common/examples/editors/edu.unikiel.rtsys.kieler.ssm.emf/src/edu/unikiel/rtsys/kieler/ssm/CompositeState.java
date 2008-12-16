/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.unikiel.rtsys.kieler.ssm;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Composite State</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.unikiel.rtsys.kieler.ssm.CompositeState#getRegions <em>Regions</em>}</li>
 *   <li>{@link edu.unikiel.rtsys.kieler.ssm.CompositeState#getLocalSignals <em>Local Signals</em>}</li>
 *   <li>{@link edu.unikiel.rtsys.kieler.ssm.CompositeState#getInputSignals <em>Input Signals</em>}</li>
 *   <li>{@link edu.unikiel.rtsys.kieler.ssm.CompositeState#getOutputSignals <em>Output Signals</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.unikiel.rtsys.kieler.ssm.ssmPackage#getCompositeState()
 * @model annotation="http://rtsys.informatik.uni-kiel.de/trac/kieler documentation='This one is called \"MacroState\" in the SSM definition'"
 * @generated
 */
public interface CompositeState extends SimpleState {
    /**
	 * Returns the value of the '<em><b>Regions</b></em>' containment reference list.
	 * The list contents are of type {@link edu.unikiel.rtsys.kieler.ssm.Region}.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Regions</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Regions</em>' containment reference list.
	 * @see edu.unikiel.rtsys.kieler.ssm.ssmPackage#getCompositeState_Regions()
	 * @model containment="true" required="true"
	 * @generated
	 */
    EList<Region> getRegions();

    /**
	 * Returns the value of the '<em><b>Local Signals</b></em>' containment reference list.
	 * The list contents are of type {@link edu.unikiel.rtsys.kieler.ssm.Signal}.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Local Signals</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Local Signals</em>' containment reference list.
	 * @see edu.unikiel.rtsys.kieler.ssm.ssmPackage#getCompositeState_LocalSignals()
	 * @model containment="true" transient="true"
	 * @generated
	 */
    EList<Signal> getLocalSignals();

    /**
	 * Returns the value of the '<em><b>Input Signals</b></em>' containment reference list.
	 * The list contents are of type {@link edu.unikiel.rtsys.kieler.ssm.Signal}.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Input Signals</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Input Signals</em>' containment reference list.
	 * @see edu.unikiel.rtsys.kieler.ssm.ssmPackage#getCompositeState_InputSignals()
	 * @model containment="true" transient="true"
	 * @generated
	 */
    EList<Signal> getInputSignals();

    /**
	 * Returns the value of the '<em><b>Output Signals</b></em>' containment reference list.
	 * The list contents are of type {@link edu.unikiel.rtsys.kieler.ssm.Signal}.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Output Signals</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Output Signals</em>' containment reference list.
	 * @see edu.unikiel.rtsys.kieler.ssm.ssmPackage#getCompositeState_OutputSignals()
	 * @model containment="true" transient="true"
	 * @generated
	 */
    EList<Signal> getOutputSignals();

} // CompositeState
