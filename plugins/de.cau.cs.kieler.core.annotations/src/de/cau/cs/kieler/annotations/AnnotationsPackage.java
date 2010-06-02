/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.cau.cs.kieler.annotations;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

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
 * @see de.cau.cs.kieler.annotations.AnnotationsFactory
 * @model kind="package"
 * @generated
 */
public interface AnnotationsPackage extends EPackage {
    /**
     * The package name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNAME = "annotations";

    /**
     * The package namespace URI.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_URI = "http://kieler.cs.cau.de/annotations";

    /**
     * The package namespace name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_PREFIX = "ann";

    /**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    AnnotationsPackage eINSTANCE = de.cau.cs.kieler.annotations.impl.AnnotationsPackageImpl.init();

    /**
     * The meta object id for the '{@link de.cau.cs.kieler.annotations.impl.AnnotatableImpl <em>Annotatable</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.cau.cs.kieler.annotations.impl.AnnotatableImpl
     * @see de.cau.cs.kieler.annotations.impl.AnnotationsPackageImpl#getAnnotatable()
     * @generated
     */
    int ANNOTATABLE = 1;

    /**
     * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ANNOTATABLE__ANNOTATIONS = 0;

    /**
     * The number of structural features of the '<em>Annotatable</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ANNOTATABLE_FEATURE_COUNT = 1;

    /**
     * The meta object id for the '{@link de.cau.cs.kieler.annotations.impl.NamedObjectImpl <em>Named Object</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.cau.cs.kieler.annotations.impl.NamedObjectImpl
     * @see de.cau.cs.kieler.annotations.impl.AnnotationsPackageImpl#getNamedObject()
     * @generated
     */
    int NAMED_OBJECT = 0;

    /**
     * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NAMED_OBJECT__ANNOTATIONS = ANNOTATABLE__ANNOTATIONS;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NAMED_OBJECT__NAME = ANNOTATABLE_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Named Object</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NAMED_OBJECT_FEATURE_COUNT = ANNOTATABLE_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link de.cau.cs.kieler.annotations.impl.AnnotationImpl <em>Annotation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.cau.cs.kieler.annotations.impl.AnnotationImpl
     * @see de.cau.cs.kieler.annotations.impl.AnnotationsPackageImpl#getAnnotation()
     * @generated
     */
    int ANNOTATION = 2;

    /**
     * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ANNOTATION__ANNOTATIONS = NAMED_OBJECT__ANNOTATIONS;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ANNOTATION__NAME = NAMED_OBJECT__NAME;

    /**
     * The number of structural features of the '<em>Annotation</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ANNOTATION_FEATURE_COUNT = NAMED_OBJECT_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '{@link de.cau.cs.kieler.annotations.impl.StringAnnotationImpl <em>String Annotation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.cau.cs.kieler.annotations.impl.StringAnnotationImpl
     * @see de.cau.cs.kieler.annotations.impl.AnnotationsPackageImpl#getStringAnnotation()
     * @generated
     */
    int STRING_ANNOTATION = 3;

    /**
     * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int STRING_ANNOTATION__ANNOTATIONS = ANNOTATION__ANNOTATIONS;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int STRING_ANNOTATION__NAME = ANNOTATION__NAME;

    /**
     * The feature id for the '<em><b>Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int STRING_ANNOTATION__VALUE = ANNOTATION_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>String Annotation</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int STRING_ANNOTATION_FEATURE_COUNT = ANNOTATION_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link de.cau.cs.kieler.annotations.impl.ReferenceAnnotationImpl <em>Reference Annotation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.cau.cs.kieler.annotations.impl.ReferenceAnnotationImpl
     * @see de.cau.cs.kieler.annotations.impl.AnnotationsPackageImpl#getReferenceAnnotation()
     * @generated
     */
    int REFERENCE_ANNOTATION = 4;

    /**
     * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int REFERENCE_ANNOTATION__ANNOTATIONS = ANNOTATION__ANNOTATIONS;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int REFERENCE_ANNOTATION__NAME = ANNOTATION__NAME;

    /**
     * The feature id for the '<em><b>Object</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int REFERENCE_ANNOTATION__OBJECT = ANNOTATION_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Reference Annotation</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int REFERENCE_ANNOTATION_FEATURE_COUNT = ANNOTATION_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link de.cau.cs.kieler.annotations.impl.BooleanAnnotationImpl <em>Boolean Annotation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.cau.cs.kieler.annotations.impl.BooleanAnnotationImpl
     * @see de.cau.cs.kieler.annotations.impl.AnnotationsPackageImpl#getBooleanAnnotation()
     * @generated
     */
    int BOOLEAN_ANNOTATION = 5;

    /**
     * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BOOLEAN_ANNOTATION__ANNOTATIONS = ANNOTATION__ANNOTATIONS;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BOOLEAN_ANNOTATION__NAME = ANNOTATION__NAME;

    /**
     * The feature id for the '<em><b>Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BOOLEAN_ANNOTATION__VALUE = ANNOTATION_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Boolean Annotation</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BOOLEAN_ANNOTATION_FEATURE_COUNT = ANNOTATION_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link de.cau.cs.kieler.annotations.impl.IntAnnotationImpl <em>Int Annotation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.cau.cs.kieler.annotations.impl.IntAnnotationImpl
     * @see de.cau.cs.kieler.annotations.impl.AnnotationsPackageImpl#getIntAnnotation()
     * @generated
     */
    int INT_ANNOTATION = 6;

    /**
     * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INT_ANNOTATION__ANNOTATIONS = ANNOTATION__ANNOTATIONS;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INT_ANNOTATION__NAME = ANNOTATION__NAME;

    /**
     * The feature id for the '<em><b>Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INT_ANNOTATION__VALUE = ANNOTATION_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Int Annotation</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INT_ANNOTATION_FEATURE_COUNT = ANNOTATION_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link de.cau.cs.kieler.annotations.impl.FloatAnnotationImpl <em>Float Annotation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.cau.cs.kieler.annotations.impl.FloatAnnotationImpl
     * @see de.cau.cs.kieler.annotations.impl.AnnotationsPackageImpl#getFloatAnnotation()
     * @generated
     */
    int FLOAT_ANNOTATION = 7;

    /**
     * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FLOAT_ANNOTATION__ANNOTATIONS = ANNOTATION__ANNOTATIONS;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FLOAT_ANNOTATION__NAME = ANNOTATION__NAME;

    /**
     * The feature id for the '<em><b>Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FLOAT_ANNOTATION__VALUE = ANNOTATION_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Float Annotation</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FLOAT_ANNOTATION_FEATURE_COUNT = ANNOTATION_FEATURE_COUNT + 1;


    /**
     * Returns the meta object for class '{@link de.cau.cs.kieler.annotations.NamedObject <em>Named Object</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Named Object</em>'.
     * @see de.cau.cs.kieler.annotations.NamedObject
     * @generated
     */
    EClass getNamedObject();

    /**
     * Returns the meta object for the attribute '{@link de.cau.cs.kieler.annotations.NamedObject#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see de.cau.cs.kieler.annotations.NamedObject#getName()
     * @see #getNamedObject()
     * @generated
     */
    EAttribute getNamedObject_Name();

    /**
     * Returns the meta object for class '{@link de.cau.cs.kieler.annotations.Annotatable <em>Annotatable</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Annotatable</em>'.
     * @see de.cau.cs.kieler.annotations.Annotatable
     * @generated
     */
    EClass getAnnotatable();

    /**
     * Returns the meta object for the containment reference list '{@link de.cau.cs.kieler.annotations.Annotatable#getAnnotations <em>Annotations</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Annotations</em>'.
     * @see de.cau.cs.kieler.annotations.Annotatable#getAnnotations()
     * @see #getAnnotatable()
     * @generated
     */
    EReference getAnnotatable_Annotations();

    /**
     * Returns the meta object for class '{@link de.cau.cs.kieler.annotations.Annotation <em>Annotation</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Annotation</em>'.
     * @see de.cau.cs.kieler.annotations.Annotation
     * @generated
     */
    EClass getAnnotation();

    /**
     * Returns the meta object for class '{@link de.cau.cs.kieler.annotations.StringAnnotation <em>String Annotation</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>String Annotation</em>'.
     * @see de.cau.cs.kieler.annotations.StringAnnotation
     * @generated
     */
    EClass getStringAnnotation();

    /**
     * Returns the meta object for the attribute '{@link de.cau.cs.kieler.annotations.StringAnnotation#getValue <em>Value</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Value</em>'.
     * @see de.cau.cs.kieler.annotations.StringAnnotation#getValue()
     * @see #getStringAnnotation()
     * @generated
     */
    EAttribute getStringAnnotation_Value();

    /**
     * Returns the meta object for class '{@link de.cau.cs.kieler.annotations.ReferenceAnnotation <em>Reference Annotation</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Reference Annotation</em>'.
     * @see de.cau.cs.kieler.annotations.ReferenceAnnotation
     * @generated
     */
    EClass getReferenceAnnotation();

    /**
     * Returns the meta object for the reference '{@link de.cau.cs.kieler.annotations.ReferenceAnnotation#getObject <em>Object</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Object</em>'.
     * @see de.cau.cs.kieler.annotations.ReferenceAnnotation#getObject()
     * @see #getReferenceAnnotation()
     * @generated
     */
    EReference getReferenceAnnotation_Object();

    /**
     * Returns the meta object for class '{@link de.cau.cs.kieler.annotations.BooleanAnnotation <em>Boolean Annotation</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Boolean Annotation</em>'.
     * @see de.cau.cs.kieler.annotations.BooleanAnnotation
     * @generated
     */
    EClass getBooleanAnnotation();

    /**
     * Returns the meta object for the attribute '{@link de.cau.cs.kieler.annotations.BooleanAnnotation#isValue <em>Value</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Value</em>'.
     * @see de.cau.cs.kieler.annotations.BooleanAnnotation#isValue()
     * @see #getBooleanAnnotation()
     * @generated
     */
    EAttribute getBooleanAnnotation_Value();

    /**
     * Returns the meta object for class '{@link de.cau.cs.kieler.annotations.IntAnnotation <em>Int Annotation</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Int Annotation</em>'.
     * @see de.cau.cs.kieler.annotations.IntAnnotation
     * @generated
     */
    EClass getIntAnnotation();

    /**
     * Returns the meta object for the attribute '{@link de.cau.cs.kieler.annotations.IntAnnotation#getValue <em>Value</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Value</em>'.
     * @see de.cau.cs.kieler.annotations.IntAnnotation#getValue()
     * @see #getIntAnnotation()
     * @generated
     */
    EAttribute getIntAnnotation_Value();

    /**
     * Returns the meta object for class '{@link de.cau.cs.kieler.annotations.FloatAnnotation <em>Float Annotation</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Float Annotation</em>'.
     * @see de.cau.cs.kieler.annotations.FloatAnnotation
     * @generated
     */
    EClass getFloatAnnotation();

    /**
     * Returns the meta object for the attribute '{@link de.cau.cs.kieler.annotations.FloatAnnotation#getValue <em>Value</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Value</em>'.
     * @see de.cau.cs.kieler.annotations.FloatAnnotation#getValue()
     * @see #getFloatAnnotation()
     * @generated
     */
    EAttribute getFloatAnnotation_Value();

    /**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
    AnnotationsFactory getAnnotationsFactory();

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
         * The meta object literal for the '{@link de.cau.cs.kieler.annotations.impl.NamedObjectImpl <em>Named Object</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see de.cau.cs.kieler.annotations.impl.NamedObjectImpl
         * @see de.cau.cs.kieler.annotations.impl.AnnotationsPackageImpl#getNamedObject()
         * @generated
         */
        EClass NAMED_OBJECT = eINSTANCE.getNamedObject();

        /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute NAMED_OBJECT__NAME = eINSTANCE.getNamedObject_Name();

        /**
         * The meta object literal for the '{@link de.cau.cs.kieler.annotations.impl.AnnotatableImpl <em>Annotatable</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see de.cau.cs.kieler.annotations.impl.AnnotatableImpl
         * @see de.cau.cs.kieler.annotations.impl.AnnotationsPackageImpl#getAnnotatable()
         * @generated
         */
        EClass ANNOTATABLE = eINSTANCE.getAnnotatable();

        /**
         * The meta object literal for the '<em><b>Annotations</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference ANNOTATABLE__ANNOTATIONS = eINSTANCE.getAnnotatable_Annotations();

        /**
         * The meta object literal for the '{@link de.cau.cs.kieler.annotations.impl.AnnotationImpl <em>Annotation</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see de.cau.cs.kieler.annotations.impl.AnnotationImpl
         * @see de.cau.cs.kieler.annotations.impl.AnnotationsPackageImpl#getAnnotation()
         * @generated
         */
        EClass ANNOTATION = eINSTANCE.getAnnotation();

        /**
         * The meta object literal for the '{@link de.cau.cs.kieler.annotations.impl.StringAnnotationImpl <em>String Annotation</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see de.cau.cs.kieler.annotations.impl.StringAnnotationImpl
         * @see de.cau.cs.kieler.annotations.impl.AnnotationsPackageImpl#getStringAnnotation()
         * @generated
         */
        EClass STRING_ANNOTATION = eINSTANCE.getStringAnnotation();

        /**
         * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute STRING_ANNOTATION__VALUE = eINSTANCE.getStringAnnotation_Value();

        /**
         * The meta object literal for the '{@link de.cau.cs.kieler.annotations.impl.ReferenceAnnotationImpl <em>Reference Annotation</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see de.cau.cs.kieler.annotations.impl.ReferenceAnnotationImpl
         * @see de.cau.cs.kieler.annotations.impl.AnnotationsPackageImpl#getReferenceAnnotation()
         * @generated
         */
        EClass REFERENCE_ANNOTATION = eINSTANCE.getReferenceAnnotation();

        /**
         * The meta object literal for the '<em><b>Object</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference REFERENCE_ANNOTATION__OBJECT = eINSTANCE.getReferenceAnnotation_Object();

        /**
         * The meta object literal for the '{@link de.cau.cs.kieler.annotations.impl.BooleanAnnotationImpl <em>Boolean Annotation</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see de.cau.cs.kieler.annotations.impl.BooleanAnnotationImpl
         * @see de.cau.cs.kieler.annotations.impl.AnnotationsPackageImpl#getBooleanAnnotation()
         * @generated
         */
        EClass BOOLEAN_ANNOTATION = eINSTANCE.getBooleanAnnotation();

        /**
         * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute BOOLEAN_ANNOTATION__VALUE = eINSTANCE.getBooleanAnnotation_Value();

        /**
         * The meta object literal for the '{@link de.cau.cs.kieler.annotations.impl.IntAnnotationImpl <em>Int Annotation</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see de.cau.cs.kieler.annotations.impl.IntAnnotationImpl
         * @see de.cau.cs.kieler.annotations.impl.AnnotationsPackageImpl#getIntAnnotation()
         * @generated
         */
        EClass INT_ANNOTATION = eINSTANCE.getIntAnnotation();

        /**
         * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute INT_ANNOTATION__VALUE = eINSTANCE.getIntAnnotation_Value();

        /**
         * The meta object literal for the '{@link de.cau.cs.kieler.annotations.impl.FloatAnnotationImpl <em>Float Annotation</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see de.cau.cs.kieler.annotations.impl.FloatAnnotationImpl
         * @see de.cau.cs.kieler.annotations.impl.AnnotationsPackageImpl#getFloatAnnotation()
         * @generated
         */
        EClass FLOAT_ANNOTATION = eINSTANCE.getFloatAnnotation();

        /**
         * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute FLOAT_ANNOTATION__VALUE = eINSTANCE.getFloatAnnotation_Value();

    }

} //AnnotationsPackage
