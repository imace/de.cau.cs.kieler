/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>KPort Layout</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KPortLayout#getPlacement <em>Placement</em>}</li>
 *   <li>{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KPortLayout#getRank <em>Rank</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphPackage#getKPortLayout()
 * @model
 * @generated
 */
public interface KPortLayout extends KShapeLayout {
	/**
	 * Returns the value of the '<em><b>Placement</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * The literals are from the enumeration {@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.PORT_PLACEMENT}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Placement</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Placement</em>' attribute.
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.PORT_PLACEMENT
	 * @see #setPlacement(PORT_PLACEMENT)
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphPackage#getKPortLayout_Placement()
	 * @model default="0"
	 * @generated
	 */
	PORT_PLACEMENT getPlacement();

	/**
	 * Sets the value of the '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KPortLayout#getPlacement <em>Placement</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Placement</em>' attribute.
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.PORT_PLACEMENT
	 * @see #getPlacement()
	 * @generated
	 */
	void setPlacement(PORT_PLACEMENT value);

	/**
	 * Returns the value of the '<em><b>Rank</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rank</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rank</em>' attribute.
	 * @see #setRank(int)
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphPackage#getKPortLayout_Rank()
	 * @model default="0"
	 * @generated
	 */
	int getRank();

	/**
	 * Sets the value of the '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KPortLayout#getRank <em>Rank</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rank</em>' attribute.
	 * @see #getRank()
	 * @generated
	 */
	void setRank(int value);

} // KPortLayout
