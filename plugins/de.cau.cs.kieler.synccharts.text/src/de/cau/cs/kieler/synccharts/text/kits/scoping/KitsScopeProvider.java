/*
 * KIELER - Kiel Integrated Environment for Layout Eclipse RichClient
 *
 * http://www.informatik.uni-kiel.de/rtsys/kieler/
 * 
 * Copyright 2010 by
 * + Christian-Albrechts-University of Kiel
 *   + Department of Computer Science
 *     + Real-Time and Embedded Systems Group
 * 
 * This code is provided under the terms of the Eclipse Public License (EPL).
 * See the file epl-v10.html for the license text.
 */
package de.cau.cs.kieler.synccharts.text.kits.scoping;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider;
import org.eclipse.xtext.scoping.impl.SimpleScope;

import de.cau.cs.kieler.core.expressions.ExpressionsPackage;
import de.cau.cs.kieler.core.expressions.OperatorExpression;
import de.cau.cs.kieler.core.expressions.OperatorType;
import de.cau.cs.kieler.core.expressions.Signal;
import de.cau.cs.kieler.core.expressions.Variable;
import de.cau.cs.kieler.synccharts.Assignment;
import de.cau.cs.kieler.synccharts.Emission;
import de.cau.cs.kieler.synccharts.Region;
import de.cau.cs.kieler.synccharts.Scope;
import de.cau.cs.kieler.synccharts.State;
import de.cau.cs.kieler.synccharts.SyncchartsPackage;
import de.cau.cs.kieler.synccharts.Transition;

/**
 * This class contains custom scoping descriptions.
 * 
 * @author chsch
 */
public class KitsScopeProvider extends AbstractDeclarativeScopeProvider {

    /**
     * A implementation of scoping for transitions' targets.
     * Won't be called directly but via reflection by the Xtext runtime.
     * 
     * @param trans
     * @param reference
     * @return
     */
    @SuppressWarnings("unchecked")
    public IScope scope_Transition_targetState(Transition trans, EReference reference) {
        List<IEObjectDescription> l = new LinkedList<IEObjectDescription>();
        HashSet<String> m = new HashSet<String>();
        String key = null;
        for (State s : ((Region) trans.eContainer().eContainer()).getStates()) {
            key = s.getId();
            if (m.contains(key)) {
                key = s.getId();
            }
            l.add(new EObjectDescription(key, s, Collections.EMPTY_MAP));
            m.add(key);

        }
        return new SimpleScope(l);
    }
    

    /**
     * A implementation of scoping for scopes' body references.
     * Won't be called directly but via reflection by the Xtext runtime.
     * 
     * @param trans
     * @param reference
     * @return
     */
    @SuppressWarnings("unchecked")
    public IScope scope_Scope_bodyReference(State state, EReference reference) {
        Resource theResource = state.eResource();
        EList<Resource> set = state.eResource().getResourceSet().getResources();
        List<IEObjectDescription> l = new LinkedList<IEObjectDescription>();
        for (Resource r : set) {
            if (r != theResource) {
                EObject obj = null;
                for (Iterator<EObject> it = r.getAllContents(); it.hasNext();) {
                    obj = it.next();
                    if (!((InternalEObject) obj).eIsProxy() && SyncchartsPackage.eINSTANCE.getState().isInstance(obj)) {
                        l.add(new EObjectDescription(((State) obj).getId(), obj,
                                Collections.EMPTY_MAP));
                    }
                }
            }
        }

        return new SimpleScope(l);
    }

    
    /**
     * A implementation of scoping for signal and variable references.
     * Won't be called directly but via reflection by the Xtext runtime.
     * Delegates to {@link KitsScopeProvider#scope_ValuedObject(EObject, EReference, State)}. 
     * 
     * @param trans
     * @param reference
     * @return
     */
	public IScope scope_ValuedObjectReference_valuedObject(final EObject obj,
			final EReference reference) {
    	return new SimpleScope(this.scope_ValuedObject(obj, reference, null));
    }
    
	/**
	 * More generic scoping implementation that can be re-used.
	 *  
	 * @param obj
	 * @param reference
	 * @param logicalContainer
	 * @return
	 */
	protected List<IEObjectDescription> scope_ValuedObject(
			final EObject obj, final EReference reference,
			final Scope logicalContainer) {
		
		// include all available signals
        List<IEObjectDescription> l = this.scope_Signal(obj, reference, logicalContainer);

        // this branch will be entered during linking if the valuedObjectReference
        // is contained by a '?' OperatorExpression
        if (ExpressionsPackage.eINSTANCE.getOperatorExpression().isInstance(obj.eContainer())
                && (((OperatorExpression) obj.eContainer()).getOperator() == OperatorType.VAL || ((OperatorExpression) obj
                        .eContainer()).getOperator() == OperatorType.PRE)) {
            return l;
        }

        // this branch will be entered computing the content assist proposals
        // if the text input leads to a valid model!
        // otherwise used context is nearly unpredictable
        if (ExpressionsPackage.eINSTANCE.getOperatorExpression().isInstance(obj)
                && (((OperatorExpression) obj).getOperator() == OperatorType.VAL || ((OperatorExpression) obj)
                        .getOperator() == OperatorType.PRE)) {
            return l;
        }
        
		// add all available variables
        l.addAll(this.scope_Variable(obj, reference, logicalContainer));
        return l;
    }

    
    /**
     * A implementation of scoping for signal emissions.
     * Won't be called directly but via reflection by the Xtext runtime.
     * Delegates to {@link KitsScopeProvider#scope_Signal(EObject, EReference, State)}.
     * 
     * @param obj
     * @param reference
     * @return
     */
	public IScope scope_Emission_signal(final Emission obj,
			final EReference reference) {
		return new SimpleScope(this.scope_Signal(obj, reference, null));
    }
    
	/**
	 * More generic scoping implementation that can be re-used.
	 *  
	 * @param obj
	 * @param reference
	 * @param logicalContainer
	 * @return
	 */
    @SuppressWarnings("unchecked")
	protected List<IEObjectDescription> scope_Signal(final EObject obj,
			final EReference reference, final Scope logicalContainer) {
    	
        List<IEObjectDescription> l = new LinkedList<IEObjectDescription>();
        EObject container = obj;
        while (true) {
            if (SyncchartsPackage.eINSTANCE.getScope().isInstance(container)) {
                break;
            }
            container = container.eContainer();
        }

        boolean inLogicalContainer = false;
        Scope scope = (Scope) container;
        do {
            for (Signal s : scope.getSignals()) {
                l.add(new EObjectDescription(s.getName(), s,
                        (Map<String, String>) Collections.EMPTY_MAP));
            }
            
            scope = (Scope) scope.eContainer();
            if (scope == null && !inLogicalContainer && container != null) {
            	scope = logicalContainer;
            	inLogicalContainer = true;
            }
        } while (scope != null);
        return l;
    }
    

    /**
     * A implementation of scoping for variable assignments.
     * Won't be called directly but via reflection by the Xtext runtime.
     * Delegates to {@link KitsScopeProvider#scope_Variable(EObject, EReference, State)}.
     * 
     * @param obj
     * @param reference
     * @return
     */
	public IScope scope_Assignment_variable(final Assignment obj,
			final EReference reference) {
    	return new SimpleScope(this.scope_Variable(obj, reference, null));
    }
    
	/**
	 * More generic scoping implementation that can be re-used.
	 *  
	 * @param obj
	 * @param reference
	 * @param logicalContainer
	 * @return
	 */
    @SuppressWarnings("unchecked")
	protected List<IEObjectDescription> scope_Variable(final EObject obj,
			final EReference reference, final Scope logicalContainer) {
    	
        List<IEObjectDescription> l = new LinkedList<IEObjectDescription>();
        EObject container = obj;
        while (true) {
            if (SyncchartsPackage.eINSTANCE.getScope().isInstance(container)) {
                break;
            }
            container = container.eContainer();
        }

        boolean inLogicalContainer = false;
        Scope scope = (Scope) container;
        do {
            for (Variable v : scope.getVariables()) {
                l.add(new EObjectDescription(v.getName(), v,
                        (Map<String, String>) Collections.EMPTY_MAP));
            }
            
            scope = (Scope) scope.eContainer();
            if (scope == null && !inLogicalContainer && container != null) {
            	scope = logicalContainer;
            	inLogicalContainer = true;
            }
        } while (scope != null);
        return l;
    }
}
