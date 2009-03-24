package de.cau.cs.kieler.ssm2.custom;

import java.io.ByteArrayInputStream;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserEditStatus;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserEditStatus;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.openarchitectureware.xtext.parser.parsetree.Node;

import de.cau.cs.kieler.ssm2.Action;
import de.cau.cs.kieler.ssm2.Assignment;
import de.cau.cs.kieler.ssm2.ComplexExpression;
import de.cau.cs.kieler.ssm2.Emission;
import de.cau.cs.kieler.ssm2.Expression;
import de.cau.cs.kieler.ssm2.Signal;
import de.cau.cs.kieler.ssm2.Ssm2Package;
import de.cau.cs.kieler.ssm2.Variable;
import de.cau.cs.kieler.ssm2.dsl.parser.XtextParser;

public class XTextParserWrapper implements IParser {

	private XtextParser parser;
	
	public XTextParserWrapper(Action action) {
	}

	@Override
	public IContentAssistProcessor getCompletionProcessor(IAdaptable element) {
		return null;
	}

	@Override
	public String getEditString(IAdaptable element, int flags) {
		if (element instanceof EObjectAdapter) {
			if (((EObjectAdapter) element).getRealObject() instanceof Action) {
				Action action = (Action) (((EObjectAdapter) element).getRealObject());
				if (action.getTriggersAndEffects() != null) {
					return action.getTriggersAndEffects();
				}
			}
		}
		return "";
	}

	@Override
	public ICommand getParseCommand(IAdaptable element, String newString, int flags) {
		return new XTextParseCommand(element, newString, flags);
	}

	@Override
	public String getPrintString(IAdaptable element, int flags) {
		if (element instanceof EObjectAdapter) {
			if (((EObjectAdapter) element).getRealObject() instanceof Action) {
				Action action = (Action) (((EObjectAdapter) element).getRealObject());
				if (action.getTriggersAndEffects() != null) {
					return action.getTriggersAndEffects();
				}
			}
		}
		return "";
	}

	@Override
	public boolean isAffectingEvent(Object event, int flags) {
		if (event instanceof Notification) {
			Object feature = ((Notification) event).getFeature();
			if (feature.equals(Ssm2Package.eINSTANCE.getAction_TriggersAndEffects())) {
				return true;
			}
		}
		return false;
	}

	@Override
	public IParserEditStatus isValidEditString(IAdaptable element, String editString) {
		try {
			if (element instanceof Action) {
				ByteArrayInputStream stream = new ByteArrayInputStream(editString.getBytes());
				parser = new XtextParser(stream);
				Node node = parser.getParser().parse();
				Action newAction = (Action) node.getModelElement();
				Action action = (Action)element;
				if (checkSignals(action, newAction)) {
					return ParserEditStatus.EDITABLE_STATUS;
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return ParserEditStatus.UNEDITABLE_STATUS;
	}
			
	private boolean checkSignals(Action action, Action newAction) {
		boolean allValid = true;
		boolean oneEqual = false;
		for (Signal s1 : getSignals(newAction)) {
			oneEqual = false;
			for (Signal s2 : action.getParentStateEntryAction().getSignals()) {
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
		EList<Signal> tempSignals;
		for (Emission e : action.getEmissions()) {
			tempSignals = getSignals(e);
			for (Signal s : tempSignals) {
				if (!signals.contains(s)) {
					signals.add(s);
				}
			}
		}
		for (Assignment a : action.getAssignments()) {
			tempSignals = getSignals(a);
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
