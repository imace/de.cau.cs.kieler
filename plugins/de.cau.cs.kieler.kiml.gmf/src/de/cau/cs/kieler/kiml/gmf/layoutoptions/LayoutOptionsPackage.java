/**
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
 *
 * $Id$
 */
package de.cau.cs.kieler.kiml.gmf.layoutoptions;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.gmf.runtime.notation.NotationPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see de.cau.cs.kieler.kiml.gmf.layoutoptions.LayoutOptionsFactory
 * @model kind="package"
 * @generated
 * @deprecated use {@link org.eclipse.gmf.runtime.notation.StringValueStyle} instead
 */
public interface LayoutOptionsPackage extends EPackage {
    /**
     * The package name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNAME = "layoutoptions";

    /**
     * The package namespace URI.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_URI = "http://kieler.cs.cau.de/LayoutOptions";

    /**
     * The package namespace name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_PREFIX = "layoutoptions";

    /**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    LayoutOptionsPackage eINSTANCE = de.cau.cs.kieler.kiml.gmf.layoutoptions.LayoutOptionsPackageImpl.init();

    /**
     * The meta object id for the '{@link de.cau.cs.kieler.kiml.gmf.layoutoptions.LayoutOptionStyleImpl <em>Layout Option Style</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.cau.cs.kieler.kiml.gmf.layoutoptions.LayoutOptionStyleImpl
     * @see de.cau.cs.kieler.kiml.gmf.layoutoptions.LayoutOptionsPackageImpl#getLayoutOptionStyle()
     * @generated
     */
    int LAYOUT_OPTION_STYLE = 0;

    /**
     * The feature id for the '<em><b>Options</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LAYOUT_OPTION_STYLE__OPTIONS = NotationPackage.STYLE_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Layout Option Style</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LAYOUT_OPTION_STYLE_FEATURE_COUNT = NotationPackage.STYLE_FEATURE_COUNT + 1;


    /**
     * The meta object id for the '{@link de.cau.cs.kieler.kiml.gmf.layoutoptions.KOptionImpl <em>KOption</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.cau.cs.kieler.kiml.gmf.layoutoptions.KOptionImpl
     * @see de.cau.cs.kieler.kiml.gmf.layoutoptions.LayoutOptionsPackageImpl#getKOption()
     * @generated
     */
    int KOPTION = 1;

    /**
     * The feature id for the '<em><b>Key</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int KOPTION__KEY = 0;

    /**
     * The feature id for the '<em><b>Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int KOPTION__VALUE = 1;

    /**
     * The feature id for the '<em><b>Default</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int KOPTION__DEFAULT = 2;

    /**
     * The number of structural features of the '<em>KOption</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int KOPTION_FEATURE_COUNT = 3;


    /**
     * Returns the meta object for class '{@link de.cau.cs.kieler.kiml.gmf.layoutoptions.LayoutOptionStyle <em>Layout Option Style</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Layout Option Style</em>'.
     * @see de.cau.cs.kieler.kiml.gmf.layoutoptions.LayoutOptionStyle
     * @generated
     */
    EClass getLayoutOptionStyle();

    /**
     * Returns the meta object for the containment reference list '{@link de.cau.cs.kieler.kiml.gmf.layoutoptions.LayoutOptionStyle#getOptions <em>Options</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Options</em>'.
     * @see de.cau.cs.kieler.kiml.gmf.layoutoptions.LayoutOptionStyle#getOptions()
     * @see #getLayoutOptionStyle()
     * @generated
     */
    EReference getLayoutOptionStyle_Options();

    /**
     * Returns the meta object for class '{@link de.cau.cs.kieler.kiml.gmf.layoutoptions.KOption <em>KOption</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>KOption</em>'.
     * @see de.cau.cs.kieler.kiml.gmf.layoutoptions.KOption
     * @generated
     */
    EClass getKOption();

    /**
     * Returns the meta object for the attribute '{@link de.cau.cs.kieler.kiml.gmf.layoutoptions.KOption#getKey <em>Key</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Key</em>'.
     * @see de.cau.cs.kieler.kiml.gmf.layoutoptions.KOption#getKey()
     * @see #getKOption()
     * @generated
     */
    EAttribute getKOption_Key();

    /**
     * Returns the meta object for the attribute '{@link de.cau.cs.kieler.kiml.gmf.layoutoptions.KOption#getValue <em>Value</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Value</em>'.
     * @see de.cau.cs.kieler.kiml.gmf.layoutoptions.KOption#getValue()
     * @see #getKOption()
     * @generated
     */
    EAttribute getKOption_Value();

    /**
     * Returns the meta object for the attribute '{@link de.cau.cs.kieler.kiml.gmf.layoutoptions.KOption#isDefault <em>Default</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Default</em>'.
     * @see de.cau.cs.kieler.kiml.gmf.layoutoptions.KOption#isDefault()
     * @see #getKOption()
     * @generated
     */
    EAttribute getKOption_Default();

    /**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
    LayoutOptionsFactory getLayoutOptionsFactory();

    /**
     * <!-- begin-user-doc -->
     * Defines literals for the meta objects that represent
     * <ul>
     *   <li>each class,</li>
     *   <li>each feature of each class,</li>
     *   <li>each enum,</li>
     *   <li>and each data type</li>
     * </ul>
     * <!-- end-user-doc -->
     * @generated
     */
    interface Literals {
        /**
         * The meta object literal for the '{@link de.cau.cs.kieler.kiml.gmf.layoutoptions.LayoutOptionStyleImpl <em>Layout Option Style</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see de.cau.cs.kieler.kiml.gmf.layoutoptions.LayoutOptionStyleImpl
         * @see de.cau.cs.kieler.kiml.gmf.layoutoptions.LayoutOptionsPackageImpl#getLayoutOptionStyle()
         * @generated
         */
        EClass LAYOUT_OPTION_STYLE = eINSTANCE.getLayoutOptionStyle();

        /**
         * The meta object literal for the '<em><b>Options</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference LAYOUT_OPTION_STYLE__OPTIONS = eINSTANCE.getLayoutOptionStyle_Options();

        /**
         * The meta object literal for the '{@link de.cau.cs.kieler.kiml.gmf.layoutoptions.KOptionImpl <em>KOption</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see de.cau.cs.kieler.kiml.gmf.layoutoptions.KOptionImpl
         * @see de.cau.cs.kieler.kiml.gmf.layoutoptions.LayoutOptionsPackageImpl#getKOption()
         * @generated
         */
        EClass KOPTION = eINSTANCE.getKOption();

        /**
         * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute KOPTION__KEY = eINSTANCE.getKOption_Key();

        /**
         * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute KOPTION__VALUE = eINSTANCE.getKOption_Value();

        /**
         * The meta object literal for the '<em><b>Default</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute KOPTION__DEFAULT = eINSTANCE.getKOption_Default();

    }

} //LayoutOptionsPackage
