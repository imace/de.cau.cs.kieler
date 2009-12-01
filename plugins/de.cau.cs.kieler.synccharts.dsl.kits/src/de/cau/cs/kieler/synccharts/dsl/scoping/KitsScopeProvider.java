/*
 * generated by Xtext
 */
package de.cau.cs.kieler.synccharts.dsl.scoping;

import java.util.ArrayList;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.Scopes;
import org.eclipse.xtext.scoping.IScopedElement;
import org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider;
import org.eclipse.xtext.scoping.impl.ScopedElement;
import org.eclipse.xtext.scoping.impl.SimpleScope;

import de.cau.cs.kieler.synccharts.Action;
import de.cau.cs.kieler.synccharts.Emission;
import de.cau.cs.kieler.synccharts.Region;
import de.cau.cs.kieler.synccharts.Signal;
import de.cau.cs.kieler.synccharts.SignalReference;
import de.cau.cs.kieler.synccharts.State;
import de.cau.cs.kieler.synccharts.Transition;

/**
 * This class contains custom scoping description.
 * 
 * see : http://www.eclipse.org/Xtext/documentation/latest/xtext.html#scoping on
 * how and when to use it
 * 
 */
public class KitsScopeProvider extends AbstractDeclarativeScopeProvider {
	/**
	 * This declarative function calcualtes the scope of target states
	 * 
	 * @param context
	 *            the context
	 * @param reference
	 *            the reference
	 * @return new scope for target states
	 */
	// @Override
	// protected IScope createScope(Resource resource, EClass type) {
	// System.out.println("cross ref's are now made by id per default");
	// return new DefaultScope(resource, type, getImportUriResolver(),
	// SimpleAttributeResolver.newResolver(String.class, "id"));
	//
	// }

	IScope scope_Transition_targetState(Transition context, EReference reference) {
		State sourceState = (State) context.eContainer();
		Region parentRegion = sourceState.getParentRegion();

		ArrayList<IScopedElement> scopeElems = new ArrayList<IScopedElement>();

		for (State innerState : parentRegion.getInnerStates()) {
			// if the inner state has a label then show its label in the content
			// assist
			if (innerState.getLabel() != null) {
				IScopedElement elem = ScopedElement.create(innerState
						.getLabel(), innerState);
				scopeElems.add(elem);
			}
			// else if the inner state has an id then add it using its id
			if (innerState.getId() != null) {
				IScopedElement elem = ScopedElement.create(innerState.getId(),
						innerState);
				scopeElems.add(elem);
			}
		}
		return new SimpleScope(scopeElems);
	}

	/**
	 * This declarative function calcualtes the scope of signals in emissions
	 * 
	 * @param context
	 *            the context
	 * @param reference
	 *            the reference
	 * @return new scope for signals in emissions
	 */


	IScope scope_Emission_signal(Emission context, EReference reference) {
		ArrayList<IScopedElement> scopeElems = new ArrayList<IScopedElement>();
		// this is my transition
		Action a = context.getParentEAction();
		if (a instanceof Transition) {
			Transition t = (Transition) a;
			System.out.println(context.toString() + " has the source state: "
					+ t.getSourceState().getId());
			// has the parent state declared any signals?
			if (t.getSourceState().getSignals() != null) {
				for (Signal sig : t.getSourceState().getSignals()) {
					IScopedElement elem = ScopedElement.create(sig.getName(),
							sig);
					System.out.println("=================================");
					System.out.println("ADDED: " + sig.getName());
					System.out.println("=================================");
					scopeElems.add(elem);
				}
			}

			// ============ start region ============//
			Region r = t.getSourceState().getParentRegion();
			if (!r.getSignals().isEmpty()) {// != null) {
				System.out.println("=================================");
				System.out.println("FOUND SIGNALS");
				System.out.println("=================================");
				for (Signal sig : r.getSignals()) {
					IScopedElement elem = ScopedElement.create(sig.getName(),
							sig);
					System.out.println("Signal " + sig.getName());
					System.out.println("=================================");
					System.out.println("ADDED: " + sig.getName());
					System.out.println("=================================");
					scopeElems.add(elem);

				}
			}

			// this parent region is not the root region yet?
			if (r.getParentState() != null) {
				System.out.println("Region above "
						+ r.getInnerStates().get(0).getId()
						+ " has a parent state so ...");
				scopeElems = gatherSignals(r, scopeElems);
			}
		}
		// ============ end of region ============//
		// System.out
		// .println("--------------END OF SCOPE CALC (Emission_signal)--------------");
		else if (context instanceof Emission)
			a = context.getParentEAction();
		if (a instanceof Action) {
			System.out.println("im in");
			Action act = (Action) a;
			State parentState = null;
			if (a.getParentStateEntryAction() != null) {
				parentState = act.getParentStateEntryAction();
			}
			if (a.getParentStateExitAction() != null) {
				parentState = act.getParentStateExitAction();
			}
			if (a.getParentStateInnerAction() != null) {
				parentState = act.getParentStateInnerAction();
			}
			if (a.getParentStateSuspension() != null) {
				parentState = act.getParentStateSuspension();
			}
			if (parentState != null) {
				if (parentState.getSignals() != null) {
					for (Signal sig : parentState.getSignals()) {
						IScopedElement elem = ScopedElement.create(sig
								.getName(), sig);
						System.out.println("=================================");
						System.out.println("ADDED: " + sig.getName());
						System.out.println("=================================");
						scopeElems.add(elem);
					}
				}

			}
			Region r = parentState.getParentRegion();
			if (!r.getSignals().isEmpty()) {// != null) {
				System.out.println("=================================");
				System.out.println("FOUND SIGNALS");
				System.out.println("=================================");
				for (Signal sig : r.getSignals()) {
					IScopedElement elem = ScopedElement.create(sig.getName(),
							sig);
					System.out.println("Signal " + sig.getName());
					System.out.println("=================================");
					System.out.println("ADDED: " + sig.getName());
					System.out.println("=================================");
					scopeElems.add(elem);

				}
			}

			// this parent region is not the root region yet?
			if (r.getParentState() != null) {
				System.out.println("Region above "
						+ r.getInnerStates().get(0).getId()
						+ " has a parent state so ...");
				scopeElems = gatherSignals(r, scopeElems);
			}
		}

		return new SimpleScope(scopeElems);
	}

	/**
	 * This declarative function calcualtes the scope of signals in signal
	 * references
	 * 
	 * @param context
	 *            the context
	 * @param reference
	 *            the reference
	 * @return new scope for signals in signal references
	 */
	IScope scope_SignalReference_signal(SignalReference context,
			EReference reference) {

		ArrayList<IScopedElement> scopeElems = new ArrayList<IScopedElement>();
		// this is my transition
		Action a = context.getParentExpression().getParentAction();
		// Action a = context.getParentAction();
		if (a instanceof Transition) {
			Transition t = (Transition) a;
			System.out.println(context.toString() + " has the source state: "
					+ t.getSourceState().getId());
			// has the parent state declared any signals?
			if (t.getSourceState().getSignals() != null) {
				for (Signal sig : t.getSourceState().getSignals()) {
					IScopedElement elem = ScopedElement.create(sig.getName(),
							sig);
					System.out.println("=================================");
					System.out.println("ADDED: " + sig.getName());
					System.out.println("=================================");
					scopeElems.add(elem);
				}
			}

			// ============ start region ============//
			Region r = t.getSourceState().getParentRegion();
			if (!r.getSignals().isEmpty()) {// != null) {
				System.out.println("=================================");
				System.out.println("FOUND SIGNALS");
				System.out.println("=================================");
				for (Signal sig : r.getSignals()) {
					IScopedElement elem = ScopedElement.create(sig.getName(),
							sig);
					System.out.println("Signal " + sig.getName());
					System.out.println("=================================");
					System.out.println("ADDED: " + sig.getName());
					System.out.println("=================================");
					scopeElems.add(elem);

				}
			}

			// this parent region is not the root region yet?
			if (r.getParentState() != null) {
				System.out.println("Region above "
						+ r.getInnerStates().get(0).getId()
						+ " has a parent state so ...");
				scopeElems = gatherSignals(r, scopeElems);
			}
		}
		// ============ end of region ============//
		System.out
				.println("--------------END OF SCOPE CALC (SigRef)--------------");
		return new SimpleScope(scopeElems);

	}

	// help function to gather all signals in a region
	private ArrayList<IScopedElement> gatherSignals(Region r,
			ArrayList<IScopedElement> scopedElems) {
		// if you are here, there exists a parent state to your region so
		// extract it:
		State parentState = r.getParentState();
		// has the parent state declared any signals?
		if (parentState.getSignals() != null) {
			for (Signal sig : parentState.getSignals()) {
				IScopedElement elem = ScopedElement.create(sig.getName(), sig);
				System.out.println("=================================");
				System.out.println("ADDED: " + sig.getName());
				System.out.println("=================================");
				scopedElems.add(elem);
			}
		}
		System.out.println("...jump to its parent state: "
				+ parentState.getId());
		if (parentState.getRegions() != null) {
			for (Region outerRegions : parentState.getRegions()) {
				if (!outerRegions.getSignals().isEmpty()) {
					System.out.println("=================================");
					System.out.println("FOUND SIGNALS");
					System.out.println("=================================");
					for (Signal sig : outerRegions.getSignals()) {
						IScopedElement elem = ScopedElement.create(sig
								.getName(), sig);
						scopedElems.add(elem);
						System.out.println("Signal " + sig.getName());
						System.out.println("=================================");
						System.out.println("ADDED: " + sig.getName());
						System.out.println("=================================");
					}
				}
			}
		}
		if (!parentState.getParentRegion().getSignals().isEmpty()) {
			for (Signal sig : parentState.getParentRegion().getSignals()) {
				IScopedElement elem = ScopedElement.create(sig.getName(), sig);
				scopedElems.add(elem);
				System.out.println("=================================");
				System.out.println("ADDED: " + sig.getName());
				System.out.println("=================================");
			}
		}
		// be sure you have a parent state to your region before calling
		// gatherSignals again otherwise you are done gathering anyway
		if (parentState.getParentRegion().getParentState() != null) {
			gatherSignals(parentState.getParentRegion(), scopedElems);
		}
		System.out.println("Region above " + parentState.getId()
				+ " has no parent state so we are at the top");

		return scopedElems;
	}

	// public static EObject parent;
	//
	//	
	// /*
	// * (non-Javadoc)
	// *
	// * @see
	// *
	// org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider#getScope
	// * (org.eclipse.emf.ecore.EObject, org.eclipse.emf.ecore.EReference)
	// */
	// @Override
	// public IScope getScope(EObject context, EReference reference) {
	// if (parent != null)
	// return new ExternalScope(parent);
	// return super.getScope(context, reference);
	// }
	//
	// class ExternalScope implements IScope {
	//
	// EObject parent;
	// List<IScopedElement> scopedElements;
	//
	// public ExternalScope(EObject parent) {
	// this.parent = parent;
	// this.scopedElements = new ArrayList<IScopedElement>();
	// // State scopedState = parentState;
	// // while(scopedState != null){
	// if (this.parent != null && this.parent instanceof Region) {
	// List<Signal> signals = ((Region) parent).getSignals();
	// for (Signal signal : signals) {
	// scopedElements.add(new ExternalScopedElement(signal, signal
	// .getName()));
	// }
	// List<Variable> variables = ((Region) parent).getVariables();
	// for (Variable variable : variables) {
	// scopedElements.add(new ExternalScopedElement(variable,
	// variable.getName()));
	// }
	// } else if (this.parent != null && this.parent instanceof State) {
	// List<Signal> signals = ((State) parent).getSignals();
	// for (Signal signal : signals) {
	// scopedElements.add(new ExternalScopedElement(signal, signal
	// .getName()));
	// }
	// }
	// // if(scopedState.getParentRegion() != null)
	// // scopedState = scopedState.getParentRegion().getParentState();
	// // }
	// }
	//
	// /*
	// * (non-Javadoc)
	// *
	// * @see org.eclipse.xtext.scoping.IScope#getAllContents()
	// */
	// public Iterable<IScopedElement> getAllContents() {
	// List<IScopedElement> elements = new ArrayList<IScopedElement>();
	// elements.addAll(scopedElements);
	// IScope outerScope = this.getOuterScope();
	// while (!outerScope.equals(IScope.NULLSCOPE)) {
	// elements
	// .addAll((Collection<? extends IScopedElement>) outerScope
	// .getContents());
	// outerScope = outerScope.getOuterScope();
	// }
	// return elements;
	// }
	//
	// /*
	// * (non-Javadoc)
	// *
	// * @see org.eclipse.xtext.scoping.IScope#getContents()
	// */
	// public Iterable<IScopedElement> getContents() {
	// return scopedElements;
	// }
	//
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.xtext.scoping.IScope#getOuterScope()
	 */
	// public IScope getOuterScope() {
	// if (parent instanceof Region) {
	// if (((Region) parent).getParentState() != null)
	// return new ExternalScope(((Region) parent).getParentState());
	// } else if (parent instanceof State) {
	// if (((State) parent).getParentRegion() != null)
	// return new ExternalScope(((State) parent).getParentRegion());
	// }
	// return IScope.NULLSCOPE;
	// }
	//
	// class ExternalScopedElement implements IScopedElement {
	//
	// EObject object;
	// String name;
	//
	// public ExternalScopedElement(EObject o, String n) {
	// object = o;
	// name = n;
	// }
	// }
}
//
// /*
// * (non-Javadoc)
// *
// * @see
// * org.eclipse.xtext.scoping.IScopedElement#additionalInformation()
// */
// public Object additionalInformation() {
// return null;
// }
//
// /*
// * (non-Javadoc)
// *
// * @see org.eclipse.xtext.scoping.IScopedElement#element()
// */
// public EObject element() {
// return object;
// }
//
// /*
// * (non-Javadoc)
// *
// * @see org.eclipse.xtext.scoping.IScopedElement#name()
// */
// public String name() {
// return name;
// }
//
// }
// }
