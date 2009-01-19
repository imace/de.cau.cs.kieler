/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hierarchymealy;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Hierarchy Mealy Machine</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hierarchymealy.HierarchyMealyMachine#getMachineName <em>Machine Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see hierarchymealy.MealyPackage#getHierarchyMealyMachine()
 * @model
 * @generated
 */
public interface HierarchyMealyMachine extends CompositeState {
	/**
	 * Returns the value of the '<em><b>Machine Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Machine Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Machine Name</em>' attribute.
	 * @see #setMachineName(String)
	 * @see hierarchymealy.MealyPackage#getHierarchyMealyMachine_MachineName()
	 * @model
	 * @generated
	 */
	String getMachineName();

	/**
	 * Sets the value of the '{@link hierarchymealy.HierarchyMealyMachine#getMachineName <em>Machine Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Machine Name</em>' attribute.
	 * @see #getMachineName()
	 * @generated
	 */
	void setMachineName(String value);

} // HierarchyMealyMachine
