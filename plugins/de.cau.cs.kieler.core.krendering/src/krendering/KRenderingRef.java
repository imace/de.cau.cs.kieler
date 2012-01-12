/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package krendering;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ref</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link krendering.KRenderingRef#getRendering <em>Rendering</em>}</li>
 * </ul>
 * </p>
 *
 * @see krendering.KRenderingPackage#getKRenderingRef()
 * @model
 * @generated
 */
public interface KRenderingRef extends KRendering {
    /**
     * Returns the value of the '<em><b>Rendering</b></em>' reference.
     * It is bidirectional and its opposite is '{@link krendering.KRendering#getReferences <em>References</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Rendering</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Rendering</em>' reference.
     * @see #setRendering(KRendering)
     * @see krendering.KRenderingPackage#getKRenderingRef_Rendering()
     * @see krendering.KRendering#getReferences
     * @model opposite="references" required="true"
     * @generated
     */
    KRendering getRendering();

    /**
     * Sets the value of the '{@link krendering.KRenderingRef#getRendering <em>Rendering</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Rendering</em>' reference.
     * @see #getRendering()
     * @generated
     */
    void setRendering(KRendering value);

} // KRenderingRef
