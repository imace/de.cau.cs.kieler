package de.cau.cs.kieler.simplerailctrl.sim.ptolemy.oaw;

import java.util.Collection;
import java.util.Hashtable;

import simplerailctrl.*;
import simplerailctrl.util.SimplerailctrlAdapterFactory;
import org.openarchitectureware.*;
import org.openarchitectureware.emf.*;
import org.eclipse.emf.common.util.EList;
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

	//-------------------------------------------------------------------------

	public final static String hash(Node myNode) {
		return ""+myNode.hashCode();
	}
	
	public final static String hash(Transition myTransition) {
		return ""+myTransition.hashCode();
	}

	//-------------------------------------------------------------------------
	
	//-------------------------------------------------------------------------

	public final static String buildTrigger(Transition myTransition) {
		String myTrigger = "";
		if (myTransition.eClass().getName().equals("EventWait")) {
			EventWait event = (EventWait)myTransition;
			myTrigger = "count > "+event.getSeconds();
		}
		if (myTransition.eClass().getName().equals("EventContact")) {
			EventContact event = (EventContact)myTransition;
			int track = event.getTrack().getValue();
			int pos   = event.getPosition().getValue();
			myTrigger = "contact(" + track + ") == " + pos;
		}
		if (myTransition.eClass().getName().equals("EventOccupied")) {
			EventOccupied event = (EventOccupied)myTransition;
			EList trackList = event.getTrack();
			String condition   = event.getCondition().getLiteral();
			String conjunction = event.getConjunction().getLiteral();
			if(condition.equals("IF_NOT")) condition = "!("; 
									  else condition = "(";
			if(conjunction.equals("AND")) conjunction = " && "; 
									 else conjunction = " || ";
			myTrigger = condition;
			for (int c = 0; c < trackList.size(); c++) {
				if (c > 0) myTrigger += conjunction;
				int track = ((TRACK)trackList.get(c)).getValue();
				myTrigger += "occupied("+track+") == 1";
			}
			myTrigger += ")";
		}
		return myTrigger;
	}

	//-------------------------------------------------------------------------

	public final static String buildEmission(Transition myTransition) {
		String myEmission = "";
		if (myTransition.getDestination().eClass().getName().equals("SetSpeed")) {
			SetSpeed setSpeed = (SetSpeed)myTransition.getDestination();
			int speed = setSpeed.getSpeed();
			int motormode = setSpeed.getDirection().getValue();
			EList trackList = setSpeed.getTrack();
			myEmission += "tracks={";
			for (int c = 0; c < trackList.size(); c++) {
				if (c > 0) myEmission += ",";
				int track = ((TRACK)trackList.get(c)).getValue();
				myEmission += "track"+track+"={speed="+speed+", motormode="+motormode+"}";
			}
			myEmission += "};";
		}

		if (myTransition.getDestination().eClass().getName().equals("SetPoint")) {
			SetPoint setPoint = (SetPoint)myTransition.getDestination();
			int turn = setPoint.getDirection().getValue();
			EList pointList = setPoint.getPoint();
			myEmission += "points={";
			for (int c = 0; c < pointList.size(); c++) {
				if (c > 0) myEmission += ",";
				int point = ((POINT)pointList.get(c)).getValue();
				myEmission += "point"+point+"={turn="+turn+"}";
			}
			myEmission += "};";
		}

		if (myTransition.getDestination().eClass().getName().equals("SetSignal")) {
			SetSignal setSignal = (SetSignal)myTransition.getDestination();
			int color = setSignal.getColor().getValue();
			boolean position0 = false;
			boolean position1 = false;
			EList positionList = setSignal.getPosition();
			for (int c = 0; c < positionList.size(); c++){
				int posval = ((POSITION)positionList.get(c)).getValue();
				if (posval == 0) position0 = true;
				if (posval == 1) position1 = true;
			}
			EList trackList = setSignal.getTrack();
			myEmission += "signals={";
			for (int c = 0; c < trackList.size(); c++) {
				if (c > 0) myEmission += ",";
				int track = ((TRACK)trackList.get(c)).getValue();
				if (position0) {
					myEmission += "signal"+track+"a={lights="+color+"}";
				}
				if (position0 && position1) {
					myEmission += ",";
				}
				if (position1) {
					myEmission += "signal"+track+"b={lights="+color+"}";
				}
			}
			myEmission += "};";
		}
		
		return myEmission;
	}

	//-------------------------------------------------------------------------

	static Hashtable ht = new Hashtable();
	public final static void markState(Node myNode) {
		ht.put(myNode.hashCode(), myNode);
	}
	
	public final static boolean isMarked(Node myNode) {
		return ht.contains(myNode);
	}
}
