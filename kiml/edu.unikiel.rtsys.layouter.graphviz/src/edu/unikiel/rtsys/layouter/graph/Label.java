/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.unikiel.rtsys.layouter.graph;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Label</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.unikiel.rtsys.layouter.graph.Label#getPosition <em>Position</em>}</li>
 *   <li>{@link edu.unikiel.rtsys.layouter.graph.Label#getData <em>Data</em>}</li>
 *   <li>{@link edu.unikiel.rtsys.layouter.graph.Label#getText <em>Text</em>}</li>
 *   <li>{@link edu.unikiel.rtsys.layouter.graph.Label#getSize <em>Size</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.unikiel.rtsys.layouter.graph.GraphPackage#getLabel()
 * @model
 * @generated
 */
public interface Label extends EObject {
	/**
	 * Returns the value of the '<em><b>Position</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Position</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Position</em>' containment reference.
	 * @see #setPosition(Coordinates)
	 * @see edu.unikiel.rtsys.layouter.graph.GraphPackage#getLabel_Position()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Coordinates getPosition();

	/**
	 * Sets the value of the '{@link edu.unikiel.rtsys.layouter.graph.Label#getPosition <em>Position</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Position</em>' containment reference.
	 * @see #getPosition()
	 * @generated
	 */
	void setPosition(Coordinates value);

	/**
	 * Returns the value of the '<em><b>Data</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Data</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data</em>' attribute.
	 * @see #setData(Object)
	 * @see edu.unikiel.rtsys.layouter.graph.GraphPackage#getLabel_Data()
	 * @model
	 * @generated
	 */
	Object getData();

	/**
	 * Sets the value of the '{@link edu.unikiel.rtsys.layouter.graph.Label#getData <em>Data</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data</em>' attribute.
	 * @see #getData()
	 * @generated
	 */
	void setData(Object value);

	/**
	 * Returns the value of the '<em><b>Text</b></em>' attribute.
	 * The default value is <code>"\"\""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Text</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Text</em>' attribute.
	 * @see #setText(String)
	 * @see edu.unikiel.rtsys.layouter.graph.GraphPackage#getLabel_Text()
	 * @model default="\"\"" required="true"
	 * @generated
	 */
	String getText();

	/**
	 * Sets the value of the '{@link edu.unikiel.rtsys.layouter.graph.Label#getText <em>Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Text</em>' attribute.
	 * @see #getText()
	 * @generated
	 */
	void setText(String value);

	/**
	 * Returns the value of the '<em><b>Size</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Size</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Size</em>' containment reference.
	 * @see #setSize(Size)
	 * @see edu.unikiel.rtsys.layouter.graph.GraphPackage#getLabel_Size()
	 * @model containment="true"
	 * @generated
	 */
	Size getSize();

	/**
	 * Sets the value of the '{@link edu.unikiel.rtsys.layouter.graph.Label#getSize <em>Size</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Size</em>' containment reference.
	 * @see #getSize()
	 * @generated
	 */
	void setSize(Size value);

} // Label
