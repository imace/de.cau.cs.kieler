/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package mymodel;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
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
 * @see mymodel.MymodelFactory
 * @model kind="package"
 * @generated
 */
public interface MymodelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "mymodel";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://mymodel/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "mymodel";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	MymodelPackage eINSTANCE = mymodel.impl.MymodelPackageImpl.init();

	/**
	 * The meta object id for the '{@link mymodel.impl.MyDataImpl <em>My Data</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mymodel.impl.MyDataImpl
	 * @see mymodel.impl.MymodelPackageImpl#getMyData()
	 * @generated
	 */
	int MY_DATA = 2;

	/**
	 * The number of structural features of the '<em>My Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MY_DATA_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link mymodel.impl.MyStringImpl <em>My String</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mymodel.impl.MyStringImpl
	 * @see mymodel.impl.MymodelPackageImpl#getMyString()
	 * @generated
	 */
	int MY_STRING = 0;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MY_STRING__TEXT = MY_DATA_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>My String</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MY_STRING_FEATURE_COUNT = MY_DATA_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link mymodel.impl.MyIntImpl <em>My Int</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mymodel.impl.MyIntImpl
	 * @see mymodel.impl.MymodelPackageImpl#getMyInt()
	 * @generated
	 */
	int MY_INT = 1;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MY_INT__VALUE = MY_DATA_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>My Int</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MY_INT_FEATURE_COUNT = MY_DATA_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link mymodel.impl.MyConstImpl <em>My Const</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mymodel.impl.MyConstImpl
	 * @see mymodel.impl.MymodelPackageImpl#getMyConst()
	 * @generated
	 */
	int MY_CONST = 3;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MY_CONST__VALUE = MY_DATA_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>My Const</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MY_CONST_FEATURE_COUNT = MY_DATA_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link mymodel.impl.MyListImpl <em>My List</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mymodel.impl.MyListImpl
	 * @see mymodel.impl.MymodelPackageImpl#getMyList()
	 * @generated
	 */
	int MY_LIST = 4;

	/**
	 * The feature id for the '<em><b>Items</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MY_LIST__ITEMS = MY_DATA_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>My List</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MY_LIST_FEATURE_COUNT = MY_DATA_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link mymodel.impl.MyDataModelImpl <em>My Data Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mymodel.impl.MyDataModelImpl
	 * @see mymodel.impl.MymodelPackageImpl#getMyDataModel()
	 * @generated
	 */
	int MY_DATA_MODEL = 5;

	/**
	 * The feature id for the '<em><b>Items</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MY_DATA_MODEL__ITEMS = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MY_DATA_MODEL__NAME = 1;

	/**
	 * The number of structural features of the '<em>My Data Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MY_DATA_MODEL_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link mymodel.myConstValue <em>my Const Value</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mymodel.myConstValue
	 * @see mymodel.impl.MymodelPackageImpl#getmyConstValue()
	 * @generated
	 */
	int MY_CONST_VALUE = 6;


	/**
	 * Returns the meta object for class '{@link mymodel.MyString <em>My String</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>My String</em>'.
	 * @see mymodel.MyString
	 * @generated
	 */
	EClass getMyString();

	/**
	 * Returns the meta object for the attribute '{@link mymodel.MyString#getText <em>Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Text</em>'.
	 * @see mymodel.MyString#getText()
	 * @see #getMyString()
	 * @generated
	 */
	EAttribute getMyString_Text();

	/**
	 * Returns the meta object for class '{@link mymodel.MyInt <em>My Int</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>My Int</em>'.
	 * @see mymodel.MyInt
	 * @generated
	 */
	EClass getMyInt();

	/**
	 * Returns the meta object for the attribute '{@link mymodel.MyInt#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see mymodel.MyInt#getValue()
	 * @see #getMyInt()
	 * @generated
	 */
	EAttribute getMyInt_Value();

	/**
	 * Returns the meta object for class '{@link mymodel.MyData <em>My Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>My Data</em>'.
	 * @see mymodel.MyData
	 * @generated
	 */
	EClass getMyData();

	/**
	 * Returns the meta object for class '{@link mymodel.MyConst <em>My Const</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>My Const</em>'.
	 * @see mymodel.MyConst
	 * @generated
	 */
	EClass getMyConst();

	/**
	 * Returns the meta object for the attribute '{@link mymodel.MyConst#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see mymodel.MyConst#getValue()
	 * @see #getMyConst()
	 * @generated
	 */
	EAttribute getMyConst_Value();

	/**
	 * Returns the meta object for class '{@link mymodel.MyList <em>My List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>My List</em>'.
	 * @see mymodel.MyList
	 * @generated
	 */
	EClass getMyList();

	/**
	 * Returns the meta object for the containment reference list '{@link mymodel.MyList#getItems <em>Items</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Items</em>'.
	 * @see mymodel.MyList#getItems()
	 * @see #getMyList()
	 * @generated
	 */
	EReference getMyList_Items();

	/**
	 * Returns the meta object for class '{@link mymodel.MyDataModel <em>My Data Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>My Data Model</em>'.
	 * @see mymodel.MyDataModel
	 * @generated
	 */
	EClass getMyDataModel();

	/**
	 * Returns the meta object for the containment reference list '{@link mymodel.MyDataModel#getItems <em>Items</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Items</em>'.
	 * @see mymodel.MyDataModel#getItems()
	 * @see #getMyDataModel()
	 * @generated
	 */
	EReference getMyDataModel_Items();

	/**
	 * Returns the meta object for the attribute '{@link mymodel.MyDataModel#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see mymodel.MyDataModel#getName()
	 * @see #getMyDataModel()
	 * @generated
	 */
	EAttribute getMyDataModel_Name();

	/**
	 * Returns the meta object for enum '{@link mymodel.myConstValue <em>my Const Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>my Const Value</em>'.
	 * @see mymodel.myConstValue
	 * @generated
	 */
	EEnum getmyConstValue();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	MymodelFactory getMymodelFactory();

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
		 * The meta object literal for the '{@link mymodel.impl.MyStringImpl <em>My String</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mymodel.impl.MyStringImpl
		 * @see mymodel.impl.MymodelPackageImpl#getMyString()
		 * @generated
		 */
		EClass MY_STRING = eINSTANCE.getMyString();

		/**
		 * The meta object literal for the '<em><b>Text</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MY_STRING__TEXT = eINSTANCE.getMyString_Text();

		/**
		 * The meta object literal for the '{@link mymodel.impl.MyIntImpl <em>My Int</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mymodel.impl.MyIntImpl
		 * @see mymodel.impl.MymodelPackageImpl#getMyInt()
		 * @generated
		 */
		EClass MY_INT = eINSTANCE.getMyInt();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MY_INT__VALUE = eINSTANCE.getMyInt_Value();

		/**
		 * The meta object literal for the '{@link mymodel.impl.MyDataImpl <em>My Data</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mymodel.impl.MyDataImpl
		 * @see mymodel.impl.MymodelPackageImpl#getMyData()
		 * @generated
		 */
		EClass MY_DATA = eINSTANCE.getMyData();

		/**
		 * The meta object literal for the '{@link mymodel.impl.MyConstImpl <em>My Const</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mymodel.impl.MyConstImpl
		 * @see mymodel.impl.MymodelPackageImpl#getMyConst()
		 * @generated
		 */
		EClass MY_CONST = eINSTANCE.getMyConst();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MY_CONST__VALUE = eINSTANCE.getMyConst_Value();

		/**
		 * The meta object literal for the '{@link mymodel.impl.MyListImpl <em>My List</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mymodel.impl.MyListImpl
		 * @see mymodel.impl.MymodelPackageImpl#getMyList()
		 * @generated
		 */
		EClass MY_LIST = eINSTANCE.getMyList();

		/**
		 * The meta object literal for the '<em><b>Items</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MY_LIST__ITEMS = eINSTANCE.getMyList_Items();

		/**
		 * The meta object literal for the '{@link mymodel.impl.MyDataModelImpl <em>My Data Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mymodel.impl.MyDataModelImpl
		 * @see mymodel.impl.MymodelPackageImpl#getMyDataModel()
		 * @generated
		 */
		EClass MY_DATA_MODEL = eINSTANCE.getMyDataModel();

		/**
		 * The meta object literal for the '<em><b>Items</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MY_DATA_MODEL__ITEMS = eINSTANCE.getMyDataModel_Items();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MY_DATA_MODEL__NAME = eINSTANCE.getMyDataModel_Name();

		/**
		 * The meta object literal for the '{@link mymodel.myConstValue <em>my Const Value</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mymodel.myConstValue
		 * @see mymodel.impl.MymodelPackageImpl#getmyConstValue()
		 * @generated
		 */
		EEnum MY_CONST_VALUE = eINSTANCE.getmyConstValue();

	}

} //MymodelPackage
