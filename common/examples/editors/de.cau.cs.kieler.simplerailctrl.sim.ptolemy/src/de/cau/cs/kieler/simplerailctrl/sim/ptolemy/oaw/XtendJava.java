package de.cau.cs.kieler.simplerailctrl.sim.ptolemy.oaw;

import java.util.Collection;
import java.util.Hashtable;

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
		return ""+myNode.hashCode();
	}
	public final static String hash(Transition myTransition) {
		return ""+myTransition.hashCode();
	}

	public final static String buildTrigger(Transition myTransition) {
		return "";
	}
	public final static String buildEmission(Transition myTransition) {
		return "";
	}

	static Hashtable ht = new Hashtable();
	public final static void markState(Node myNode) {
		ht.put(myNode.hashCode(), myNode);
	}
	
	public final static boolean isMarked(Node myNode) {
		return ht.contains(myNode);
	}
}
