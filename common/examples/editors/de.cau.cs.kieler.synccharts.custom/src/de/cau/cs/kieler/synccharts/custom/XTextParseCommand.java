package de.cau.cs.kieler.synccharts.custom;

import java.io.ByteArrayInputStream;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.openarchitectureware.xtext.parser.parsetree.Node;

import de.cau.cs.kieler.synccharts.Action;
import de.cau.cs.kieler.synccharts.Assignment;
import de.cau.cs.kieler.synccharts.ComplexExpression;
import de.cau.cs.kieler.synccharts.Emission;
import de.cau.cs.kieler.synccharts.Expression;
import de.cau.cs.kieler.synccharts.Region;
import de.cau.cs.kieler.synccharts.Signal;
import de.cau.cs.kieler.synccharts.SignalReference;
import de.cau.cs.kieler.synccharts.State;
import de.cau.cs.kieler.synccharts.SuspensionTrigger;
import de.cau.cs.kieler.synccharts.Transition;
import de.cau.cs.kieler.synccharts.Variable;
import de.cau.cs.kieler.synccharts.VariableReference;
import de.cau.cs.kieler.synccharts.dsl.parser.XtextParser;

// This command parses the text of a label and integrates the results into the
// given SSM model
public class XTextParseCommand extends AbstractTransactionalCommand {

	IAdaptable element;
	XtextParser parser;
	String string;
	
	public XTextParseCommand(IAdaptable element, String newString, int flags) {
		super(TransactionUtil.getEditingDomain(((Action) (((EObjectAdapter) element).getRealObject()))), newString, null);
		this.element = element;
		this.string = newString;
	}

	public XTextParseCommand(TransactionalEditingDomain editingDomain,
			String newString, Object object) {
		super(editingDomain, newString, null);
	}

	// This method is executed when the text of the label has been changed
	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor,
			IAdaptable info) throws ExecutionException {
		try {
			// Parse the text and get the newly created action
			if ((element != null) && (element instanceof EObjectAdapter) && (((EObjectAdapter)element).getRealObject() instanceof Action)) {
				ByteArrayInputStream stream = new ByteArrayInputStream(string.getBytes());
				parser = new XtextParser(stream);
				Node node = parser.getParser().parse();
				Action newAction = (Action) node.getModelElement();
				Action action = (Action) (((EObjectAdapter)element).getRealObject());
				
				// Only proceed if an action has been created and its signals have
				// already been defined within the parent state
				if (newAction == null) {
					action.setTrigger(null);
					action.getEmissions().clear();
					action.getAssignments().clear();
					action.setTriggersAndEffects("");
					return CommandResult.newOKCommandResult();
				}
				
				if (!checkSignals(action, newAction)) {
					action.setTrigger(null);
					action.getEmissions().clear();
					action.getAssignments().clear();
					action.setTriggersAndEffects("INVALID: " + string);
					return CommandResult.newErrorCommandResult("The action contains invalid signals!");					
				}
				
				// Integrate the action's trigger, its emissions and assignments
				// into the SSM model
				action.setTrigger(newAction.getTrigger());
				action.setTriggersAndEffects(string);
				action.getEmissions().clear();
				action.getAssignments().clear();
				int numEmissions = newAction.getEmissions().size();
				int numAssignments = newAction.getAssignments().size();
				for (int i = 0; i < numEmissions; i++) {
					action.getEmissions().add(newAction.getEmissions().get(i));
				}
				for (int i = 0; i < numAssignments; i++) {
					action.getAssignments().add(newAction.getAssignments().get(i));
				}
			}
			else if ((element != null) && (element instanceof EObjectAdapter) && (((EObjectAdapter)element).getRealObject() instanceof SuspensionTrigger)) {
				ByteArrayInputStream stream = new ByteArrayInputStream(string.getBytes());
				parser = new XtextParser(stream);
				Node node = parser.getParser().parse();
				SuspensionTrigger suspensionTrigger = (SuspensionTrigger) (((EObjectAdapter)element).getRealObject());
				Action newAction = (Action) node.getModelElement();
				Expression newExpression = (Expression) newAction.getTrigger();
				Expression expression =  (Expression) suspensionTrigger.getExpression();
				
				
				// Only proceed if an expression has been created and its signals have
				// already been defined within the parent state
				if (newExpression == null) {
					suspensionTrigger.setExpression(null);
					suspensionTrigger.setTrigger("");
					return CommandResult.newOKCommandResult();
				}
				
				if (!checkSignals(suspensionTrigger, expression, newExpression)
					|| (newAction.getEmissions().size() > 0)
					|| (newAction.getAssignments().size() > 0)) {
					suspensionTrigger.setExpression(null);
					suspensionTrigger.setTrigger("INVALID: " + string);
					return CommandResult.newErrorCommandResult("The Expression contains invalid signals or other invalid characters!");					
				}
				
				// Integrate the new Expression into the SSM model
				suspensionTrigger.setExpression(newExpression);
				suspensionTrigger.setTrigger(string);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return CommandResult.newOKCommandResult();
	}

	// Method to check whether the signals have already been defined in the parent state
	private boolean checkSignals(Action action, Action newAction) {
		boolean allValid = true;
		boolean oneEqual = false;
		for (Signal s1 : getSignals(newAction)) {
			oneEqual = false;
			EList<Signal> validSignals = new BasicEList();
			if (action instanceof Transition) {
				try {
					validSignals = collectValidSignals((State) ((Region) ((State) ((Transition) action).getSourceState()).getParentRegion()).getParentState());
				} catch (Exception e) {
					return false;
				}
			}
			else {
				try {
					validSignals = collectValidSignals(action.getParentStateEntryAction());
				} catch (Exception e) {
					try {
						validSignals = collectValidSignals(action.getParentStateInnerAction());
					} catch (Exception f) {
						try {
							validSignals = collectValidSignals(action.getParentStateExitAction());
						} catch (Exception g) {
							return false;
						}
					}
				}
			}
			for (Signal s2 : validSignals) {
				if (s1.getName().equals(s2.getName())) {
					forwardSignals(newAction, s2);
					oneEqual = true;
					break;
				}
			}
			if (!oneEqual) {
				allValid = false;
				break;
			}
		}
		return allValid;
	}
	
	// A similar method for suspension triggers
	private boolean checkSignals(SuspensionTrigger suspensionTrigger, Expression expression, Expression newExpression) {
		boolean allValid = true;
		boolean oneEqual = false;
		for (Signal s1 : getSignals(newExpression)) {
			oneEqual = false;
			EList<Signal> validSignals = new BasicEList();
			
			validSignals = collectValidSignals(suspensionTrigger.getParentState());
			for (Signal s2 : validSignals) {
				if (s1.getName().equals(s2.getName())) {
					forwardSignals(newExpression, s2);
					oneEqual = true;
					break;
				}
			}
			if (!oneEqual) {
				allValid = false;
				break;
			}
		}
		return allValid;
	}
	
	// Methods to forward signal pointers
	private void forwardSignals(Action action, Signal signal) {
		Expression trigger = action.getTrigger();
		EList<Emission> emissions = action.getEmissions();
		EList<Assignment> assignments = action.getAssignments();
		
		if ((trigger instanceof SignalReference) && (((Signal) ((SignalReference) trigger).getSignal()).getName().equals(signal.getName()))) {
			SignalReference sigRef = (SignalReference) trigger;
			sigRef.setSignal(signal);
		}
		else if (trigger instanceof ComplexExpression) {
			setSignal((ComplexExpression) trigger, signal);
		}
		
		for (Emission emission : emissions) {
			if (emission.getSignal().getName().equals(signal.getName())) {
				emission.setSignal(signal);
			}
		}
		
		for (Assignment assignment : assignments) {
			Expression expression = assignment.getExpression();
			if ((expression instanceof SignalReference) && ((Signal) ((SignalReference) expression).getSignal()).getName().equals(signal.getName())) {
				SignalReference sigRef = (SignalReference) assignment.getExpression();
				sigRef.setSignal(signal);
			}
			else if (expression instanceof ComplexExpression) {
				setSignal((ComplexExpression) expression, signal);
			}
		}
	}
	
	// Methods to forward signal pointers
	private void forwardSignals(Expression expression, Signal signal) {
		
		if ((expression instanceof SignalReference) && (((Signal) ((SignalReference) expression).getSignal()).getName().equals(signal.getName()))) {
			SignalReference sigRef = (SignalReference) expression;
			sigRef.setSignal(signal);
		}
		else if (expression instanceof ComplexExpression) {
			setSignal((ComplexExpression) expression, signal);
		}
	}
	
	private void setSignal(ComplexExpression trigger, Signal signal) {
		EList<Expression> subExpressions = trigger.getSubExpressions();
		Expression expression;
		if (subExpressions != null) {
			for (int i = 0; i < subExpressions.size(); i++) {
				expression = subExpressions.get(i);
				if ((expression instanceof SignalReference) && ((Signal) ((SignalReference) expression).getSignal()).getName().equals(signal.getName())) {
					SignalReference sigRef = (SignalReference) expression;
					sigRef.setSignal(signal);
				}
				else if (expression instanceof ComplexExpression) {
					setSignal((ComplexExpression) expression, signal);
				}
			}
		}
	}
	
	// Method to collect all signals declared in state or its parent (+ grandparent etc.) states
	private EList<Signal> collectValidSignals(State state) {
		EList<Signal> newSignals = new BasicEList<Signal>();
		if ((state.getSignals() != null) && (state.getSignals().size() > 0)) {
			newSignals.addAll(state.getSignals());
		}
		if ((state.getParentRegion() != null) && (state.getParentRegion().getParentState() != null)) {
			newSignals.addAll(collectValidSignals(state.getParentRegion().getParentState()));
		}
		return newSignals;
	}
	
	// Several methods to get the signals from the different types of model elements
	private EList<Signal> getSignals(Action action) {
		EList<Signal> signals = getSignals(action.getTrigger());
		if (signals == null) {
			signals = new BasicEList<Signal>();
		}
		EList<Signal> tempSignals;
		for (Emission e : action.getEmissions()) {
			tempSignals = getSignals(e);
			if (tempSignals == null) {
				tempSignals = new BasicEList<Signal>();
			}
			for (Signal s : tempSignals) {
				if (!signals.contains(s)) {
					signals.add(s);
				}
			}
		}
		for (Assignment a : action.getAssignments()) {
			tempSignals = getSignals(a);
			if (tempSignals == null) {
				tempSignals = new BasicEList<Signal>();
			}
			for (Signal s : tempSignals) {
				if (!signals.contains(s)) {
					signals.add(s);
				}
			}
		}
		return signals;
	}
	
	private EList<Signal> getSignals(Expression expression) {
		if (expression instanceof SignalReference)
			return getSignals((SignalReference)expression);
		if (expression instanceof VariableReference)
			return getSignals((VariableReference)expression);
		if (expression instanceof ComplexExpression)
			return getSignals((ComplexExpression)expression);
		return null;
	}
	
	private EList<Signal> getSignals(ComplexExpression complexExpression) {
		EList<Signal> signals = new BasicEList<Signal>();
		EList<Signal> tempSignals;
		for (Expression exp : complexExpression.getSubExpressions()) {
			tempSignals = getSignals(exp);
			for (Signal s : tempSignals) {
				if (!signals.contains(s)) {
					signals.add(s);
				}
			}
		}
		return signals;
	}
	
	private EList<Signal> getSignals(Assignment assignment) {
		return getSignals(assignment.getExpression());
	}
	
	private EList<Signal> getSignals(Emission emission) {
		return getSignals(emission.getSignal());
	}

	private EList<Signal> getSignals(Variable variable) {
		return new BasicEList<Signal>();
	}

	private EList<Signal> getSignals(SignalReference signalRef) {
		return getSignals(signalRef.getSignal());
	}
	
	private EList<Signal> getSignals(VariableReference variableRef) {
		return getSignals(variableRef.getVariable());
	}

	private EList<Signal> getSignals(Signal signal) {
		EList<Signal> signals = new BasicEList<Signal>();
		signals.add(signal);
		return signals;
	}
	
}
