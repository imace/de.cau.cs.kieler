/*
 * KIELER - Kiel Integrated Environment for Layout Eclipse RichClient
 *
 * http://www.informatik.uni-kiel.de/rtsys/kieler/
 * 
 * Copyright 2011 by
 * + Christian-Albrechts-University of Kiel
 *   + Department of Computer Science
 *     + Real-Time and Embedded Systems Group
 * 
 * This code is provided under the terms of the Eclipse Public License (EPL).
 * See the file epl-v10.html for the license text.
 */
package de.cau.cs.kieler.synccharts.codegen.s.xtend

import com.google.inject.Guice
import de.cau.cs.kieler.s.s.Join
import de.cau.cs.kieler.s.s.SFactory
import de.cau.cs.kieler.synccharts.Region
import de.cau.cs.kieler.synccharts.State
import de.cau.cs.kieler.synccharts.Transition
import de.cau.cs.kieler.synccharts.TransitionType
import de.cau.cs.kieler.synccharts.codegen.dependencies.dependency.DependencyFactory
import de.cau.cs.kieler.synccharts.codegen.dependencies.dependency.DependencyType
import de.cau.cs.kieler.synccharts.codegen.dependencies.xtend.Synccharts2Dependenies
import java.util.ArrayList
import java.util.List
import org.eclipse.xtend.util.stdlib.TraceComponent

/**
 * Converts a SyncChart into an S program.
 * 
 * @author cmot
 */
class Synccharts2S {

	extension de.cau.cs.kieler.synccharts.codegen.dependencies.xtend.Synccharts2Dependenies Synccharts2Dependenies = Guice::createInjector().getInstance(typeof(Synccharts2Dependenies));
	extension de.cau.cs.kieler.synccharts.codegen.s.xtend.Helper Helper = Guice::createInjector().getInstance(typeof(Helper));

	// ======================================================================================================
	// ==                                        M A I N   T R A N S F O R M A T I O N                     ==
	// ======================================================================================================

	def create target : SFactory::eINSTANCE.createProgram() transform (Region rootRegion) {
		val rootState = rootRegion.states.head();

		// clear traces
		TraceComponent::clearTrace();
		
		// dependency analysis
		val dependencies = DependencyFactory::eINSTANCE.createDependencies();
		Synccharts2Dependenies.transform(dependencies, rootRegion);
		
		// set highest priority
		target.setPriority(dependencies.nodes.size);
		
		// create mapping from SyncChart states to dependency nodes
		for (node : dependencies.nodes) {
			if (node.type == DependencyType::WEAK) {
				TraceComponent::createTrace(node.state, node, "DependencyWeak");
			}
			else {
				TraceComponent::createTrace(node.state, node, "DependencyStrong");
			}
		}
		
		// set s program name (as the root state's name)
		target.setName(rootState.id)

		// add interface signals to s program (as the root state's signals)
		for (signal : rootState.getStateSignals) {
			target.signals.add(signal);
		}
		
		// order SyncChart states according to their dependency priority  (strong nodes)
		val dependencyPrioritySortedStates = rootRegion.getAllStates.sort(e1, e2 | compareTraceDependencyPriority(e1, e2));
		
		// create all states and their mapping
		for (state : dependencyPrioritySortedStates) {
			val sStateSurface = state.createSStateSurface(state.isRootState);
			val sStateDepth   = state.createSStateDepth(state.isRootState);
			val sStateJoin = state.createSStateJoin(state.isRootState);
			val sStateExtraSurface = state.createSStateExtraSurface(state.isRootState);

			// possibly normal termination (for parallel regions)
			if (state.needsJoinSState) {
				// create traces for all created join states
				TraceComponent::createTrace(state, sStateJoin, "Join" );
				TraceComponent::createTrace(sStateJoin, state, "JoinBack" );
			}
			// possibly weak immediate transition (for hierarchical states with inner actions)
			if (state.needsExtraSurfaceSState) {
					// create traces for all created extra surface states (weak immediate transitions out of a macro state)
					TraceComponent::createTrace(state, sStateExtraSurface, "ExtraSurface" );
					TraceComponent::createTrace(sStateExtraSurface, state, "ExtraSurfaceBack" );
			}
			// create traces for all created surface and depth s states
			TraceComponent::createTrace(state, sStateSurface, "Surface" );
			TraceComponent::createTrace(sStateSurface, state, "SurfaceBack" );
			TraceComponent::createTrace(state, sStateDepth, "Depth" );
			TraceComponent::createTrace(sStateDepth, state, "DepthBack" );
			// add new s states to program in the order surface -> [surface2] -> [join] -> depth
			target.states.add(sStateSurface);
			if (state.needsExtraSurfaceSState) {
				target.states.add(sStateExtraSurface);
			}
			if (state.needsJoinSState) {
				target.states.add(sStateJoin);
			}
			target.states.add(sStateDepth);
		}
		
		// handle transitions (as states are created now and gotos can be mapped)
		for (state : rootRegion.getAllStates) {
			val sStateSurface = state.surfaceSState
			val sStateDepth = state.depthSState
			state.fillSStateSurface(sStateSurface); 
			if (state.needsExtraSurfaceSState) {
				val sStateExtraSurface = state.extraSurfaceSState;
				state.fillSStateExtraSurface(sStateExtraSurface);
			} 
			if (state.needsJoinSState) {
				val sStateJoin = state.joinSState
				state.fillSStateJoin(sStateJoin);
			} 
			state.fillSStateDepth(sStateDepth);
		}
		 
		
	}		


	// ======================================================================================================
	// ==                   T R A V E R S E   A L L   S T A T E S   A N D   R E G I O N S                  ==
	// ======================================================================================================

	def List<State> getAllStates(Region region) {
		var List<State> stateList = new ArrayList()
		for (state : region.states) {
			stateList.add(state)
			for (regionsOfState : state.regions) {
				stateList.addAll(regionsOfState.getAllStates)
			}  
		}
		stateList
	}

	def List<State> getAllStatesOfRegion (Region region) {
		region.states
	}

	def List<Region> getAllRegionsOfState (State state) {
		state.regions
	}
	
	// ======================================================================================================
	// ==                             H A N D L E   S   S T A T E   S U R F A C E                          ==
	// ======================================================================================================
	
	def fillSStateSurface (State state, de.cau.cs.kieler.s.s.State sState) {
		val regardedTransitionListStrong = state.strongTransitionsOrdered.filter(e|e.isImmediate);
		val regardedTransitionListWeak = state.weakTransitionsOrdered.filter(e|e.isImmediate);

		// first handle all strong preemptions
		for (transition : regardedTransitionListStrong) {
			sState.addStrongPrio(state, transition);
			transition.handleTransition(sState);
		}
		
		// parallel regions
		if (state.hierarchical) {
			// fork inner regions
			for (region : state.regions) {
				val initialState = region.initialState;
				val sfork = SFactory::eINSTANCE.createFork();
				sfork.setThread(initialState.surfaceSState)
				sfork.setPriority(initialState.highestDependencyStrongNode.priority);
				sState.instructions.add(sfork);
			}
			// if there is no immediate weak transition, we do not need an extra surface!
			if (!state.needsExtraSurfaceSState) {
				// fork join thread with same priority as current thread or proceed with depth
				val sfork = SFactory::eINSTANCE.createFork();
				if (state.needsJoinSState) {
					sfork.setThread(state.joinSState)
				}
				else {
					sfork.setThread(state.depthSState)
				}
				sfork.setPriority(state.highestDependencyStrongNode.priority);
				sState.instructions.add(sfork);
			}
		}

		if (!state.hierarchical) {
			// lower priority (to allow a possible body to be executed)
			sState.addHighestWeakPrio(state);
		
			// 	then handle all immediate weak preemptions
			for (transition : regardedTransitionListWeak) {
				sState.addWeakPrio(state, transition);
				transition.handleTransition(sState);
			}

			// continue with depth (only if not a hierarchical state!)
			val scontinuation = state.depthSState
			val strans = SFactory::eINSTANCE.createTrans();
			strans.setContinuation(scontinuation);
			sState.instructions.add(strans);
		}
		
	}	
	
	
	// ======================================================================================================
	// ==                      H A N D L E   S   S T A T E   E X T R A    S U R F A C E                    ==
	// ======================================================================================================
	
	def fillSStateExtraSurface (State state, de.cau.cs.kieler.s.s.State sState) {
			// we have a hierarchical state with an outgoing immediate transition
			// which means that it must be allowed to execute all internal immediate
			// behavior. Because of this we need a second surface state_surface2.
			
			val regardedTransitionListWeak = state.weakTransitionsOrdered.filter(e|e.isImmediate);
			
			// Put code for weak immediate transitions inside this second extra surface
			val extraSurfaceSState = state.extraSurfaceSState
			
			// lower priority (to allow a possible body to be executed)
			extraSurfaceSState.addHighestWeakPrio(state);
			
			// then handle all immediate weak preemptions 
			// (strong transitions were handled before any FORK in the surface already)
			for (transition : regardedTransitionListWeak) {
					extraSurfaceSState.addWeakPrio(state, transition);
					transition.handleTransition(extraSurfaceSState);
			}
			
			// Transition from extra surface to normal join or depth node
			val sTrans = SFactory::eINSTANCE.createTrans
			if (state.needsJoinSState) {
				sTrans.setContinuation(state.joinSState);
			}
			else {
				sTrans.setContinuation(state.depthSState);
			}
			extraSurfaceSState.instructions.add(sTrans);

			// fork extra surface thread (instead of join thread!) with same priority as current thread
			val sfork = SFactory::eINSTANCE.createFork();
			sfork.setThread(extraSurfaceSState)
			sfork.setPriority(state.highestDependencyStrongNode.priority);
			sState.instructions.add(sfork);
			
	}
	
	
	// ======================================================================================================
	// ==                               H A N D L E   S   S T A T E   J O I N                              ==
	// ======================================================================================================
	
	def fillSStateJoin (State state, de.cau.cs.kieler.s.s.State sState) {
		val regardedTransitionNormalTermination = state.normalTerminationTransition

		// lower priority (to allow a possible body to be executed)
		sState.addLowestWeakPrio(state);
		
		// then handle possible normal termination
		if (regardedTransitionNormalTermination != null) {
			regardedTransitionNormalTermination.handleTransition(sState);
		}
		else {
 		   // continue with depth (only if not a hierarchical state!)
		   val scontinuation = state.depthSState
		   val strans = SFactory::eINSTANCE.createTrans();
		   strans.setContinuation(scontinuation);
		   sState.instructions.add(strans);
		}
			
		
	}	
	
	// ======================================================================================================
	// ==                              H A N D L E   S   S T A T E   D E P T H                             ==
	// ======================================================================================================
	
	def fillSStateDepth (State state, de.cau.cs.kieler.s.s.State sState) {
		val regardedTransitionListStrong = state.strongTransitionsOrdered
		val regardedTransitionListWeak = state.weakTransitionsOrdered

		// is a join instruction present? if this is the case do not generate a pause here!
		val joinInstruction = (state.getJoinSState != null && state.joinSState.instructions.filter(typeof(Join)).toList.size > 0)
				
		// if not a final state then process normally otherwise add halt or term 
		if (!state.finalState) {
			
	 	   	// before the pause statement possibly raise priority
	 	   	if (state.highestDependencyWeakNode != null) {
			    // optimization: do this only if the priority might be lowered (weak prio exist)
			    sState.addHighestStrongPrio(state);
	  		} 
	    
	  		// create a pause instruction only iff no HALT or TERM instruction
	  		// halt == no outgoing transition
	  	  	// term == final state
			if (!state.finalState && !joinInstruction) {
				sState.instructions.add(SFactory::eINSTANCE.createPause());
			}

			// first handle all strong preemptions
			for (transition : regardedTransitionListStrong) {
				sState.addStrongPrio(state, transition);
				transition.handleTransition(sState);
			}
		
			// lower priority (to allow a possible body to be executed)
			sState.addHighestWeakPrio(state);
		
			// then handle all weak preemptions
			for (transition : regardedTransitionListWeak) {
				sState.addWeakPrio(state, transition);
				transition.handleTransition(sState);
			}
		
			// if this a final state wait for join otherwise continue 
			// in the next tick to possibly handle strong and weak transitions
			// again in the depth of this sState

			var strans = SFactory::eINSTANCE.createTrans();
			// if state is hierarchical instead of the depth continue with join (if join state is needed
			// that is the state has an outgoing normal termination)
			// for handling possible normal terminations
			if (state.needsJoinSState) {
				val sStateJoin = state.joinSState;
				strans.setContinuation(sStateJoin);
			}
			else {
				strans.setContinuation(sState);
			}
			sState.instructions.add(strans);

		} else {
			// add halt or term because this is a final state
			if (state.isFinal) {
				sState.instructions.add(SFactory::eINSTANCE.createTerm)
			} 
			else if (!state.isFinal) {
				sState.instructions.add(SFactory::eINSTANCE.createHalt)
			}
		}
		
	}	
	
	// ======================================================================================================
	// ==                                   H A N D L E   T R A N S I T I O N                              ==
	// ======================================================================================================
	
	def void handleTransition(Transition transition, de.cau.cs.kieler.s.s.State sState) {
			val sif = SFactory::eINSTANCE.createIf();
			val strans = SFactory::eINSTANCE.createTrans();
			val sabort = SFactory::eINSTANCE.createAbort();
			
			// handle transition trigger - convert to s-expression
			if (transition.type == TransitionType::NORMALTERMINATION) {
				val sjoin = SFactory::eINSTANCE.createJoin();
				// if not joined yet - continue at state depth
				sjoin.setContinuation(transition.sourceState.depthSState);
				sState.instructions.add(sjoin);
			}
			
			if (transition.trigger != null) {
				sif.setExpression(transition.trigger.convertToSExpression);
			}
			else {
				sif.setExpression(getTrueBooleanValue());
			}
			
			// handle transition effect - convert to s-effect
			if (!transition.effects.nullOrEmpty) {
				for (effect : transition.effects) {
					effect.convertToSEffect(sif.instructions);
				}
			}
			
			// if leaving a macro state, first abort it
			// for weak abortions we know because of the lowered priority that
			// all internal behavior (of this tick!) has already executed and
			// we can safely abort the state.
			if (transition.sourceState.hierarchical) {
				sif.instructions.add(sabort);
			}	

			// add transition to if-branch and add if-branch to sState
			strans.setContinuation(transition.targetState.surfaceSState);
			sif.instructions.add(strans);
			sState.instructions.add(sif);
	}	

	// ======================================================================================================
	// ==                          H A N D L E   S   S  T A T E   C R E A T I O N                          ==
	// ======================================================================================================

	def de.cau.cs.kieler.s.s.State createSStateJoin (State state, Boolean root) {
		val target = SFactory::eINSTANCE.createState(); 
		target.name = state.getStatePathAsName;
		if (root) {
			target.name = "L_root";
		}
		target.name = target.name + "_join";
		if (!root) {
			// add root state signals to program only (not to the state itself)
			target.signals.addAll(state.getStateSignals)
		}
		target;
	}	
	
	def de.cau.cs.kieler.s.s.State createSStateSurface (State state, Boolean root) {
		val target = SFactory::eINSTANCE.createState(); 
		target.name = state.getStatePathAsName;
		if (root) {
			target.name = "L_root";
		}
		target.name = target.name + "_surface";

		if (!root) {
			// add root state signals to program only (not to the state itself)
			target.signals.addAll(state.getStateSignals)
		}
		target;
	}	
	
	def de.cau.cs.kieler.s.s.State createSStateExtraSurface (State state, Boolean root) {
		val target = SFactory::eINSTANCE.createState(); 
		target.name = state.getStatePathAsName;
		if (root) {
			target.name = "L_root";
		}
		target.name = target.name + "_surface2";

		if (!root) {
			// add root state signals to program only (not to the state itself)
			target.signals.addAll(state.getStateSignals)
		}
		target;
	}	

	def de.cau.cs.kieler.s.s.State createSStateDepth (State state, Boolean root) {
		val target = SFactory::eINSTANCE.createState(); 
		target.name = state.getStatePathAsName;
		if (root) {
			target.name = "L_root";
		}
		target.name = target.name + "_depth";
		
		if (!root) {
			// add root state signals to program only (not to the state itself)
			target.signals.addAll(state.getStateSignals)
		}

		target;
	}

	// ======================================================================================================
	
}













