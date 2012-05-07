package de.cau.cs.kieler.synccharts.codegen.dependencies.xtend

import de.cau.cs.kieler.synccharts.*
import de.cau.cs.kieler.synccharts.codegen.dependencies.*
import de.cau.cs.kieler.synccharts.codegen.dependencies.dependency.*
import de.cau.cs.kieler.synccharts.codegen.dependencies.dependency.DependencyFactory
import de.cau.cs.kieler.core.kexpressions.*
import java.util.*
import com.google.inject.Inject
import org.eclipse.emf.ecore.EClass
//import org.eclipse.xtend.util.stdlib.TraceComponent


class Synccharts2Dependenies {


	def create dependencies : DependencyFactory::eINSTANCE.createDependencies() transform (Region root) {
		var rootState = root.states.head();

		// create nodes for all states 
		for (state : root.getAllStates(dependencies)) {
			for (transition : state.outgoingTransitions) {
				// create simple or (strong and weak) nodes
				if (state.hierarchical) {
					dependencies.getNode(state, transition, DEPENDENCYTYPE::STRONG);
					dependencies.getNode(state, transition, DEPENDENCYTYPE::WEAK);
				}
				else {
					dependencies.getNode(state, transition, DEPENDENCYTYPE::STRONG);
				}
			}
		}


		// create dependencies between nodes
		for (state : root.getAllStates(dependencies)) {
			dependencies.handleTransitionDependency(state);
			
			for (transition : state.outgoingTransitions) {
				
				var firstNode  = dependencies.getNode(transition.sourceState, transition, DEPENDENCYTYPE::STRONG);
				var secondNode = dependencies.getNode(transition.targetState, transition, DEPENDENCYTYPE::STRONG);
				dependencies.getControlFlowDependency(firstNode, secondNode)
				
				if (state.hierarchical) {
					var firstNodeW  = dependencies.getNode(transition.sourceState, transition, DEPENDENCYTYPE::WEAK);
					var secondNodeW = dependencies.getNode(transition.targetState, transition, DEPENDENCYTYPE::WEAK);
					dependencies.getControlFlowDependency(firstNodeW, secondNodeW)
					dependencies.getControlFlowDependency(firstNodeW, secondNode)  //TODO: necessary or correct???
					dependencies.getControlFlowDependency(firstNode, secondNodeW)  //TODO: necessary or correct???
				}
				
				dependencies.handleSignalDependency(transition, rootState);
			}
		}
		
	}		
	
	// -----------------------------------------------------------------------------------------------------

	def List<State> getAllStates(Region region, Dependencies dependencies) {
		var List<State> stateList = new ArrayList()
		for (state : region.states) {
			stateList.add(state)
			for (regionsOfState : state.regions) {
				var childStates = regionsOfState.getAllStates(dependencies);
				for (childState : childStates) {
					dependencies.handleHierarchyDependency(childState, state);
				}
				stateList.addAll(childStates)
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
	// ======================================================================================================
	
	// Weak dependencies from parentWeak to (childWeak and childStrong)
	// Strong dependencies from (childWeak and childStrong) to parentStrong
	def handleHierarchyDependency(Dependencies dependencies, State childState, State state) {
		for (stateTransition : state.outgoingTransitions) {
			var PS = dependencies.getNode(state, stateTransition, DEPENDENCYTYPE::STRONG);
			var PW = dependencies.getNode(state, stateTransition, DEPENDENCYTYPE::WEAK);
			for (childStateTransition : childState.outgoingTransitions) {
				var CS = dependencies.getNode(childState, childStateTransition, DEPENDENCYTYPE::STRONG);
				dependencies.getHierarchyDependency(PW, CS);
				dependencies.getHierarchyDependency(CS, PS);
				if (childState.hierarchical) {
					var CW = dependencies.getNode(childState, childStateTransition, DEPENDENCYTYPE::WEAK);
					dependencies.getHierarchyDependency(PW, CW);
					dependencies.getHierarchyDependency(CW, PS);
				}
			}
		}
		
	}
	
	
	def handleTransitionDependency(Dependencies dependencies, State state) {
		var orderedTransitions = state.outgoingTransitions.filter(e|e.isImmediate).sort(e1, e2 | if (e1.priority < e2.priority) {-1} else {1});
		var i = 1;
		for (transition : orderedTransitions) {
			var nextTransition = orderedTransitions.get(i);
			if (nextTransition != null) {
				var sourceNode = dependencies.getNode(state, transition, DEPENDENCYTYPE::STRONG);
				var targetNode = dependencies.getNode(state, nextTransition, DEPENDENCYTYPE::STRONG);
				dependencies.getTransitionDependency(sourceNode, targetNode);
				if (state.hierarchical) {
					var sourceNodeW = dependencies.getNode(state, transition, DEPENDENCYTYPE::WEAK);
					var targetNodeW = dependencies.getNode(state, nextTransition, DEPENDENCYTYPE::WEAK);
					dependencies.getTransitionDependency(sourceNodeW, targetNodeW);
					dependencies.getTransitionDependency(sourceNodeW, targetNode)  //TODO: necessary or correct???
					dependencies.getTransitionDependency(sourceNode, targetNodeW)  //TODO: necessary or correct???
				}
			}
			i=i+1;
		}
	}
		
	
	def handleSignalDependency(Dependencies dependencies, Transition transition, State rootState) {
				for (effect : transition.effects.filter(typeof(Emission))) {
					
					// get other states that test for this signal in out going transition triggers
					// (the scope of the signal should be respected because we a
					// not searching for the NAME but for the object to appear in transition
					// triggers
					//
					// (effect as Emission).signal; == emitted signal
					//
					var triggeredTransitions = rootState.eAllContents().toIterable().filter(typeof(Transition)).filter(e | 
						   e.trigger.eAllContents().toIterable().filter(e2 |
						   	        e2.equals( (effect as Emission).signal )
						   ).size > 0); 
						
					for (triggeredTransition : triggeredTransitions) {
						var emitterState = transition.sourceState;
						var triggerState = triggeredTransition.sourceState;
						
						var emitterNode = dependencies.getNode(emitterState, transition, DEPENDENCYTYPE::STRONG);
						var triggerNode = dependencies.getNode(triggerState, transition, DEPENDENCYTYPE::STRONG);
						dependencies.getSignalDependency(emitterNode, triggerNode);
						//TODO: all the following necessary/correct???
						if (emitterState.hierarchical) {
							var emitterNodeW = dependencies.getNode(emitterState, transition, DEPENDENCYTYPE::WEAK);
							dependencies.getSignalDependency(emitterNodeW, triggerNode);
						}
						if (triggerState.hierarchical) {
							var triggerNodeW = dependencies.getNode(triggerState, transition, DEPENDENCYTYPE::WEAK);
							dependencies.getSignalDependency(emitterNode, triggerNodeW);
						}
						if (emitterState.hierarchical && triggerState.hierarchical) {
							var emitterNodeW = dependencies.getNode(emitterState, transition, DEPENDENCYTYPE::WEAK);
							var triggerNodeW = dependencies.getNode(triggerState, transition, DEPENDENCYTYPE::WEAK);
							dependencies.getSignalDependency(emitterNodeW, triggerNodeW);
						}
					}										
				}
	}

	// ======================================================================================================
	// ======================================================================================================

	def Dependency getSignalDependency(Dependencies dependencies, Node emitterNode, Node triggerNode) {
		var newDependency = DependencyFactory::eINSTANCE.createSignalDependency();
		dependencies.getDependency(triggerNode, emitterNode, newDependency);
	}

	def Dependency getControlFlowDependency(Dependencies dependencies, Node firstNode, Node secondNode) {
		var newDependency = DependencyFactory::eINSTANCE.createControlflowDependency();
		dependencies.getDependency(secondNode, firstNode, newDependency);
	}

	def Dependency getHierarchyDependency(Dependencies dependencies, Node sourceNode, Node targetNode) {
		var newDependency = DependencyFactory::eINSTANCE.createHierarchyDependency();
		dependencies.getDependency(sourceNode, targetNode, newDependency);
	}

	def Dependency getTransitionDependency(Dependencies dependencies, Node sourceNode, Node targetNode) {
		var newDependency = DependencyFactory::eINSTANCE.createTransitionDependency();
		dependencies.getDependency(targetNode, sourceNode, newDependency);
	}
	
	// ======================================================================================================

	def Dependency getDependency(Dependencies dependencies, Node sourceNode, Node targetNode, Dependency newDependency) {
		var dependency = dependencies.dependencies.filter(e|
			   e.eClass.toString.equalsIgnoreCase(newDependency.eClass.toString())
			&& e.sourceNode == sourceNode
			&& e.targetNode == targetNode);
		
		if (dependency != null) {
			return dependency.head;
		}
		// not yet found newDependency => add it
		newDependency.setSourceNode(sourceNode);
		newDependency.setTargetNode(targetNode);
		dependencies.dependencies.add(newDependency);
		return newDependency;
	}
	
	// ======================================================================================================

	def Node getNode(Dependencies dependencies, State state, Transition transition, DEPENDENCYTYPE type) {
		var node = dependencies.nodes.filter(e|(e.type == type) && (e.state == state) && (e.transition == transition));
		if (node != null) {
			return node.head;
		}
		// not yet found newNode => add it
		var newNode = DependencyFactory::eINSTANCE.createNode();
		newNode.setState(state);
		newNode.setTransition(transition);
		newNode.setType(type);
		dependencies.nodes.add(newNode);
		return newNode;
	}

	// ======================================================================================================
	
	def boolean isHierarchical(State state) {
		state.regions.size > 0;
	}
	
}













