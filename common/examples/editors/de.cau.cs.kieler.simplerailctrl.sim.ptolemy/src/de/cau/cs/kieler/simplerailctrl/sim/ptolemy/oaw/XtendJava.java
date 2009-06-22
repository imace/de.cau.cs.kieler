package de.cau.cs.kieler.simplerailctrl.sim.ptolemy.oaw;

import java.util.Collection;

import simplerailctrl.*;
import simplerailctrl.util.SimplerailctrlAdapterFactory;
import org.openarchitectureware.*;
import org.openarchitectureware.emf.*;

import org.eclipse.emf.ecore.*;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EcoreAdapterFactory;
import org.eclipse.emf.ecore.util.EcoreUtil;

import de.cau.cs.kieler.simplerailctrl.provider.*;
import simplerailctrl.*;

public class XtendJava {
	public final static void dump(String aString) {
		System.out.println(aString);
	}

	public final static String hash(Node myNode) {
		System.out.println(myNode.isInitial());
		
/*		
		//EPackage pack = MetaModelRegistration.getEPackage();

		int i = ((org.eclipse.emf.ecore.impl.DynamicEObjectImpl) myObject).hashCode();
		System.out.println("1) "+myObject.eClass().getName());
		

		if (myObject.eClass().getName().equals("SetSpeed")) {
			//Collection<EObject> myEObj = org.openarchitectureware.emf.EcoreUtil2.allContents(myObject);
			//Object[] objArray = myEObj.toArray().clone();
			//String name =(EObject)objArray[0]).eClass().getName();
			
			//EObject myObject2 = EcoreUtil.copy(myObject);
			//System.out.println("2) "+myObject2.eClass().getName());
			//(SetSpeed)myObject2.
			//if (myObject2 instanceof Node) {
			//	System.out.println(((SetSpeed)myObject2).getSpeed());
			//}
			
			//SimplerailctrlAdapterFactory af = new SimplerailctrlAdapterFactory();
			//EcoreAdapterFactory af2 = new EcoreAdapterFactory();
			//SetSpeed setSpeed = (SetSpeed) af2.adapt(myObject, SetSpeed.class);
			//SetSpeedItemProvider provider = new SetSpeedItemProvider(af);

			//SetSpeed setSpeed = (SetSpeed) myObject;
			//SetSpeed setSpeed = ((SetSpeed)((org.eclipse.emf.ecore.impl.DynamicEObjectImpl) myObject).dynamicGet(0));
			//System.out.println("SPEEED"+setSpeed.getSpeed());
		}
		if (myObject.eClass().getName().equals("SetPoint")) {
			
		}
		
		//System.out.println("---->"+ ((NodeImpl)eObject).isInitial());
/*		SetSignal setSignal;
		SetSpeed setSpeed;
		SetPoint setPoint;
		if (node.eClass().isInstance(SetSpeed.class)) {
			setSpeed = (SetSpeed) node;
			System.out.println(setSpeed.toString());
		}
		if (node.eClass().isInstance(SetPoint.class)) { 
			setPoint = (SetPoint) node;
			System.out.println(setPoint.toString());
		}
		if (node.eClass().isInstance(SetPoint.class)) { 
			setPoint = (SetPoint) node;
			System.out.println(setPoint.toString());
		}
		*/
		return "";
	}
}
