package de.cau.cs.kieler.ssm2.custom;

import java.io.ByteArrayInputStream;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.openarchitectureware.xtext.parser.parsetree.Node;

import de.cau.cs.kieler.ssm2.Action;
import de.cau.cs.kieler.ssm2.Assignment;
import de.cau.cs.kieler.ssm2.ComplexExpression;
import de.cau.cs.kieler.ssm2.Emission;
import de.cau.cs.kieler.ssm2.Expression;
import de.cau.cs.kieler.ssm2.Region;
import de.cau.cs.kieler.ssm2.Signal;
import de.cau.cs.kieler.ssm2.State;
import de.cau.cs.kieler.ssm2.Transition;
import de.cau.cs.kieler.ssm2.Variable;
import de.cau.cs.kieler.ssm2.dsl.parser.XtextParser;

public class XTextParseCommand extends AbstractTransactionalCommand {

	IAdaptable element;
	XtextParser parser;
	String string;
	
	public XTextParseCommand(IAdaptable element, String newString, int flags) {
		super(TransactionUtil.getEditingDomain(((Action) (((EObjectAdapter) element).getRealObject()))), newString, null);
		this.element = element;
		this.string = newString;
	}

	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor,
			IAdaptable info) throws ExecutionException {
		try {
			if ((element != null) && (element instanceof EObjectAdapter) && (((EObjectAdapter)element).getRealObject() instanceof Action)) {
				ByteArrayInputStream stream = new ByteArrayInputStream(string.getBytes());
				parser = new XtextParser(stream);
				Node node = parser.getParser().parse();
				Action newAction = (Action) node.getModelElement();
				Action action = (Action) (((EObjectAdapter)element).getRealObject());
				
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
					action.setTriggersAndEffects("");
					return CommandResult.newErrorCommandResult("The action contains invalid signals!");					
				}
				
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
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return CommandResult.newOKCommandResult();
	}

	private boolean checkSignals(Action action, Action newAction) {
		boolean allValid = true;
		boolean oneEqual = false;
		for (Signal s1 : getSignals(newAction)) {
			oneEqual = false;
			EList<Signal> validSignals = new BasicEList();
			if (action instanceof Transition) {
				try {
					validSignals = ((State) ((Region) ((State) ((Transition) action).getSourceState()).getParentRegion()).getParentState()).getSignals();
				} catch (Exception e) {
					return false;
				}
			}
			else {
				try {
					validSignals = action.getParentStateEntryAction().getSignals();
				} catch (Exception e) {
					try {
						validSignals = action.getParentStateInnerAction().getSignals();
					} catch (Exception f) {
						try {
							validSignals = action.getParentStateExitAction().getSignals();
						} catch (Exception g) {
							return false;
						}
					}
				}
			}
			for (Signal s2 : validSignals) {
				if (s1.getName().equals(s2.getName())) {
					s1 = s2;
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
		if (expression instanceof Signal)
			return getSignals((Signal)expression);
		if (expression instanceof Variable)
			return getSignals((Variable)expression);
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

	private EList<Signal> getSignals(Signal signal) {
		EList<Signal> signals = new BasicEList<Signal>();
		signals.add(signal);
		return signals;
	}
}
