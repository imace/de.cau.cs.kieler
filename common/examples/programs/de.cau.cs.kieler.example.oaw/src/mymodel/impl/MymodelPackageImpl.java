/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package mymodel.impl;

import mymodel.MyConst;
import mymodel.MyData;
import mymodel.MyDataModel;
import mymodel.MyInt;
import mymodel.MyList;
import mymodel.MyString;
import mymodel.MymodelFactory;
import mymodel.MymodelPackage;
import mymodel.myConstValue;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MymodelPackageImpl extends EPackageImpl implements MymodelPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass myStringEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass myIntEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass myDataEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass myConstEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass myListEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass myDataModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum myConstValueEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see mymodel.MymodelPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private MymodelPackageImpl() {
		super(eNS_URI, MymodelFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this
	 * model, and for any others upon which it depends.  Simple
	 * dependencies are satisfied by calling this method on all
	 * dependent packages before doing anything else.  This method drives
	 * initialization for interdependent packages directly, in parallel
	 * with this package, itself.
	 * <p>Of this package and its interdependencies, all packages which
	 * have not yet been registered by their URI values are first created
	 * and registered.  The packages are then initialized in two steps:
	 * meta-model objects for all of the packages are created before any
	 * are initialized, since one package's meta-model objects may refer to
	 * those of another.
	 * <p>Invocation of this method will not affect any packages that have
	 * already been initialized.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static MymodelPackage init() {
		if (isInited) return (MymodelPackage)EPackage.Registry.INSTANCE.getEPackage(MymodelPackage.eNS_URI);

		// Obtain or create and register package
		MymodelPackageImpl theMymodelPackage = (MymodelPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof MymodelPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new MymodelPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theMymodelPackage.createPackageContents();

		// Initialize created meta-data
		theMymodelPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theMymodelPackage.freeze();

		return theMymodelPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMyString() {
		return myStringEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMyString_Text() {
		return (EAttribute)myStringEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMyInt() {
		return myIntEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMyInt_Value() {
		return (EAttribute)myIntEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMyData() {
		return myDataEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMyConst() {
		return myConstEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMyConst_Value() {
		return (EAttribute)myConstEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMyList() {
		return myListEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMyList_Items() {
		return (EReference)myListEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMyDataModel() {
		return myDataModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMyDataModel_Items() {
		return (EReference)myDataModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMyDataModel_Name() {
		return (EAttribute)myDataModelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getmyConstValue() {
		return myConstValueEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MymodelFactory getMymodelFactory() {
		return (MymodelFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		myStringEClass = createEClass(MY_STRING);
		createEAttribute(myStringEClass, MY_STRING__TEXT);

		myIntEClass = createEClass(MY_INT);
		createEAttribute(myIntEClass, MY_INT__VALUE);

		myDataEClass = createEClass(MY_DATA);

		myConstEClass = createEClass(MY_CONST);
		createEAttribute(myConstEClass, MY_CONST__VALUE);

		myListEClass = createEClass(MY_LIST);
		createEReference(myListEClass, MY_LIST__ITEMS);

		myDataModelEClass = createEClass(MY_DATA_MODEL);
		createEReference(myDataModelEClass, MY_DATA_MODEL__ITEMS);
		createEAttribute(myDataModelEClass, MY_DATA_MODEL__NAME);

		// Create enums
		myConstValueEEnum = createEEnum(MY_CONST_VALUE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		myStringEClass.getESuperTypes().add(this.getMyData());
		myIntEClass.getESuperTypes().add(this.getMyData());
		myConstEClass.getESuperTypes().add(this.getMyData());
		myListEClass.getESuperTypes().add(this.getMyData());

		// Initialize classes and features; add operations and parameters
		initEClass(myStringEClass, MyString.class, "MyString", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMyString_Text(), ecorePackage.getEString(), "text", null, 0, 1, MyString.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(myIntEClass, MyInt.class, "MyInt", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMyInt_Value(), ecorePackage.getEInt(), "value", null, 0, 1, MyInt.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(myDataEClass, MyData.class, "MyData", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(myConstEClass, MyConst.class, "MyConst", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMyConst_Value(), this.getmyConstValue(), "value", null, 0, 1, MyConst.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(myListEClass, MyList.class, "MyList", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMyList_Items(), this.getMyData(), null, "items", null, 0, -1, MyList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(myDataModelEClass, MyDataModel.class, "MyDataModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMyDataModel_Items(), this.getMyData(), null, "items", null, 0, -1, MyDataModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMyDataModel_Name(), ecorePackage.getEString(), "name", null, 0, 1, MyDataModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(myConstValueEEnum, myConstValue.class, "myConstValue");
		addEEnumLiteral(myConstValueEEnum, myConstValue.PI);
		addEEnumLiteral(myConstValueEEnum, myConstValue.E);
		addEEnumLiteral(myConstValueEEnum, myConstValue.NULL);

		// Create resource
		createResource(eNS_URI);
	}

} //MymodelPackageImpl
