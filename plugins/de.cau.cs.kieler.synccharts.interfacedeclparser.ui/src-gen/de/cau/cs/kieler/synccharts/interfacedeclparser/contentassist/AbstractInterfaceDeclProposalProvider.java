/*
* generated by Xtext
*/
package de.cau.cs.kieler.synccharts.interfacedeclparser.contentassist;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.*;
import org.eclipse.xtext.common.contentassist.TerminalsProposalProvider;
import org.eclipse.xtext.ui.core.editor.contentassist.ICompletionProposalAcceptor;
import org.eclipse.xtext.ui.core.editor.contentassist.ContentAssistContext;

/**
 * Represents a generated, default implementation of interface {@link IProposalProvider}.
 * Methods are dynamically dispatched on the first parameter, i.e., you can override them 
 * with a more concrete subtype. 
 */
public class AbstractInterfaceDeclProposalProvider extends TerminalsProposalProvider {
		
	private final static Logger logger = Logger.getLogger(AbstractInterfaceDeclProposalProvider.class);
	
	public void completeStateExtend_Regions(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		if (logger.isDebugEnabled()) {
			logger.debug("completeStateExtend_Regions feature '" + assignment.getFeature() + "' terminal '"
					+ assignment.getTerminal() + "' cardinality '" + assignment.getCardinality() + "' and prefix '"
					+ context.getPrefix() + "'");
		}
		completeRuleCall(((RuleCall)assignment.getTerminal()), context, acceptor);
	}
	public void completeStateExtend_InOutputSignals(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		if (logger.isDebugEnabled()) {
			logger.debug("completeStateExtend_InOutputSignals feature '" + assignment.getFeature() + "' terminal '"
					+ assignment.getTerminal() + "' cardinality '" + assignment.getCardinality() + "' and prefix '"
					+ context.getPrefix() + "'");
		}
		completeRuleCall(((RuleCall)assignment.getTerminal()), context, acceptor);
	}
	public void completeStateExtend_OutputSignals(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		if (logger.isDebugEnabled()) {
			logger.debug("completeStateExtend_OutputSignals feature '" + assignment.getFeature() + "' terminal '"
					+ assignment.getTerminal() + "' cardinality '" + assignment.getCardinality() + "' and prefix '"
					+ context.getPrefix() + "'");
		}
		completeRuleCall(((RuleCall)assignment.getTerminal()), context, acceptor);
	}
	public void completeStateExtend_InputSignals(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		if (logger.isDebugEnabled()) {
			logger.debug("completeStateExtend_InputSignals feature '" + assignment.getFeature() + "' terminal '"
					+ assignment.getTerminal() + "' cardinality '" + assignment.getCardinality() + "' and prefix '"
					+ context.getPrefix() + "'");
		}
		completeRuleCall(((RuleCall)assignment.getTerminal()), context, acceptor);
	}
	public void completeStateExtend_Signals(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		if (logger.isDebugEnabled()) {
			logger.debug("completeStateExtend_Signals feature '" + assignment.getFeature() + "' terminal '"
					+ assignment.getTerminal() + "' cardinality '" + assignment.getCardinality() + "' and prefix '"
					+ context.getPrefix() + "'");
		}
		completeRuleCall(((RuleCall)assignment.getTerminal()), context, acceptor);
	}
	public void completeRegionSignalDec_Region(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		if (logger.isDebugEnabled()) {
			logger.debug("completeRegionSignalDec_Region feature '" + assignment.getFeature() + "' terminal '"
					+ assignment.getTerminal() + "' cardinality '" + assignment.getCardinality() + "' and prefix '"
					+ context.getPrefix() + "'");
		}
		lookupCrossReference(((CrossReference)assignment.getTerminal()), context, acceptor);
	}
	public void completeRegionSignalDec_Vars(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		if (logger.isDebugEnabled()) {
			logger.debug("completeRegionSignalDec_Vars feature '" + assignment.getFeature() + "' terminal '"
					+ assignment.getTerminal() + "' cardinality '" + assignment.getCardinality() + "' and prefix '"
					+ context.getPrefix() + "'");
		}
		completeRuleCall(((RuleCall)assignment.getTerminal()), context, acceptor);
	}
	public void completeRegionSignalDec_Signals(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		if (logger.isDebugEnabled()) {
			logger.debug("completeRegionSignalDec_Signals feature '" + assignment.getFeature() + "' terminal '"
					+ assignment.getTerminal() + "' cardinality '" + assignment.getCardinality() + "' and prefix '"
					+ context.getPrefix() + "'");
		}
		completeRuleCall(((RuleCall)assignment.getTerminal()), context, acceptor);
	}
	public void completeSignals_Signals(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		if (logger.isDebugEnabled()) {
			logger.debug("completeSignals_Signals feature '" + assignment.getFeature() + "' terminal '"
					+ assignment.getTerminal() + "' cardinality '" + assignment.getCardinality() + "' and prefix '"
					+ context.getPrefix() + "'");
		}
		completeRuleCall(((RuleCall)assignment.getTerminal()), context, acceptor);
	}
	public void completeInputSignals_Signals(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		if (logger.isDebugEnabled()) {
			logger.debug("completeInputSignals_Signals feature '" + assignment.getFeature() + "' terminal '"
					+ assignment.getTerminal() + "' cardinality '" + assignment.getCardinality() + "' and prefix '"
					+ context.getPrefix() + "'");
		}
		completeRuleCall(((RuleCall)assignment.getTerminal()), context, acceptor);
	}
	public void completeOutputSignals_Signals(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		if (logger.isDebugEnabled()) {
			logger.debug("completeOutputSignals_Signals feature '" + assignment.getFeature() + "' terminal '"
					+ assignment.getTerminal() + "' cardinality '" + assignment.getCardinality() + "' and prefix '"
					+ context.getPrefix() + "'");
		}
		completeRuleCall(((RuleCall)assignment.getTerminal()), context, acceptor);
	}
	public void completeInOutputSignals_Signals(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		if (logger.isDebugEnabled()) {
			logger.debug("completeInOutputSignals_Signals feature '" + assignment.getFeature() + "' terminal '"
					+ assignment.getTerminal() + "' cardinality '" + assignment.getCardinality() + "' and prefix '"
					+ context.getPrefix() + "'");
		}
		completeRuleCall(((RuleCall)assignment.getTerminal()), context, acceptor);
	}
	public void completeSignal_Name(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		if (logger.isDebugEnabled()) {
			logger.debug("completeSignal_Name feature '" + assignment.getFeature() + "' terminal '"
					+ assignment.getTerminal() + "' cardinality '" + assignment.getCardinality() + "' and prefix '"
					+ context.getPrefix() + "'");
		}
		completeRuleCall(((RuleCall)assignment.getTerminal()), context, acceptor);
	}
	public void completeSignal_InitialValue(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		if (logger.isDebugEnabled()) {
			logger.debug("completeSignal_InitialValue feature '" + assignment.getFeature() + "' terminal '"
					+ assignment.getTerminal() + "' cardinality '" + assignment.getCardinality() + "' and prefix '"
					+ context.getPrefix() + "'");
		}
		completeRuleCall(((RuleCall)assignment.getTerminal()), context, acceptor);
	}
	public void completeSignal_Type(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		if (logger.isDebugEnabled()) {
			logger.debug("completeSignal_Type feature '" + assignment.getFeature() + "' terminal '"
					+ assignment.getTerminal() + "' cardinality '" + assignment.getCardinality() + "' and prefix '"
					+ context.getPrefix() + "'");
		}
		completeRuleCall(((RuleCall)assignment.getTerminal()), context, acceptor);
	}
	public void completeSignal_CombineOperator(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		if (logger.isDebugEnabled()) {
			logger.debug("completeSignal_CombineOperator feature '" + assignment.getFeature() + "' terminal '"
					+ assignment.getTerminal() + "' cardinality '" + assignment.getCardinality() + "' and prefix '"
					+ context.getPrefix() + "'");
		}
		completeRuleCall(((RuleCall)assignment.getTerminal()), context, acceptor);
	}
	public void completeSignal_HostType(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		if (logger.isDebugEnabled()) {
			logger.debug("completeSignal_HostType feature '" + assignment.getFeature() + "' terminal '"
					+ assignment.getTerminal() + "' cardinality '" + assignment.getCardinality() + "' and prefix '"
					+ context.getPrefix() + "'");
		}
		completeRuleCall(((RuleCall)assignment.getTerminal()), context, acceptor);
	}
	public void completeSignal_HostCombineOperator(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		if (logger.isDebugEnabled()) {
			logger.debug("completeSignal_HostCombineOperator feature '" + assignment.getFeature() + "' terminal '"
					+ assignment.getTerminal() + "' cardinality '" + assignment.getCardinality() + "' and prefix '"
					+ context.getPrefix() + "'");
		}
		completeRuleCall(((RuleCall)assignment.getTerminal()), context, acceptor);
	}
	public void completeVariable_Name(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		if (logger.isDebugEnabled()) {
			logger.debug("completeVariable_Name feature '" + assignment.getFeature() + "' terminal '"
					+ assignment.getTerminal() + "' cardinality '" + assignment.getCardinality() + "' and prefix '"
					+ context.getPrefix() + "'");
		}
		completeRuleCall(((RuleCall)assignment.getTerminal()), context, acceptor);
	}
	public void completeVariable_InitialValue(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		if (logger.isDebugEnabled()) {
			logger.debug("completeVariable_InitialValue feature '" + assignment.getFeature() + "' terminal '"
					+ assignment.getTerminal() + "' cardinality '" + assignment.getCardinality() + "' and prefix '"
					+ context.getPrefix() + "'");
		}
		completeRuleCall(((RuleCall)assignment.getTerminal()), context, acceptor);
	}
	public void completeVariable_Type(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		if (logger.isDebugEnabled()) {
			logger.debug("completeVariable_Type feature '" + assignment.getFeature() + "' terminal '"
					+ assignment.getTerminal() + "' cardinality '" + assignment.getCardinality() + "' and prefix '"
					+ context.getPrefix() + "'");
		}
		completeRuleCall(((RuleCall)assignment.getTerminal()), context, acceptor);
	}
	public void completeVariable_HostType(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		if (logger.isDebugEnabled()) {
			logger.debug("completeVariable_HostType feature '" + assignment.getFeature() + "' terminal '"
					+ assignment.getTerminal() + "' cardinality '" + assignment.getCardinality() + "' and prefix '"
					+ context.getPrefix() + "'");
		}
		completeRuleCall(((RuleCall)assignment.getTerminal()), context, acceptor);
	}
    
	public void complete_StateExtend(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		if (logger.isDebugEnabled()) {
			logger.debug("complete_StateExtend '" + ruleCall.getRule().getName() + "' cardinality '" + ruleCall.getCardinality()
					+ "' for model '" + context.getCurrentModel() + "' and prefix '" + context.getPrefix() + "'");
		}
		// subclasses may override
	}
	public void complete_RegionSignalDec(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		if (logger.isDebugEnabled()) {
			logger.debug("complete_RegionSignalDec '" + ruleCall.getRule().getName() + "' cardinality '" + ruleCall.getCardinality()
					+ "' for model '" + context.getCurrentModel() + "' and prefix '" + context.getPrefix() + "'");
		}
		// subclasses may override
	}
	public void complete_Signals(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		if (logger.isDebugEnabled()) {
			logger.debug("complete_Signals '" + ruleCall.getRule().getName() + "' cardinality '" + ruleCall.getCardinality()
					+ "' for model '" + context.getCurrentModel() + "' and prefix '" + context.getPrefix() + "'");
		}
		// subclasses may override
	}
	public void complete_InputSignals(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		if (logger.isDebugEnabled()) {
			logger.debug("complete_InputSignals '" + ruleCall.getRule().getName() + "' cardinality '" + ruleCall.getCardinality()
					+ "' for model '" + context.getCurrentModel() + "' and prefix '" + context.getPrefix() + "'");
		}
		// subclasses may override
	}
	public void complete_OutputSignals(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		if (logger.isDebugEnabled()) {
			logger.debug("complete_OutputSignals '" + ruleCall.getRule().getName() + "' cardinality '" + ruleCall.getCardinality()
					+ "' for model '" + context.getCurrentModel() + "' and prefix '" + context.getPrefix() + "'");
		}
		// subclasses may override
	}
	public void complete_InOutputSignals(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		if (logger.isDebugEnabled()) {
			logger.debug("complete_InOutputSignals '" + ruleCall.getRule().getName() + "' cardinality '" + ruleCall.getCardinality()
					+ "' for model '" + context.getCurrentModel() + "' and prefix '" + context.getPrefix() + "'");
		}
		// subclasses may override
	}
	public void complete_Signal(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		if (logger.isDebugEnabled()) {
			logger.debug("complete_Signal '" + ruleCall.getRule().getName() + "' cardinality '" + ruleCall.getCardinality()
					+ "' for model '" + context.getCurrentModel() + "' and prefix '" + context.getPrefix() + "'");
		}
		// subclasses may override
	}
	public void complete_Variable(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		if (logger.isDebugEnabled()) {
			logger.debug("complete_Variable '" + ruleCall.getRule().getName() + "' cardinality '" + ruleCall.getCardinality()
					+ "' for model '" + context.getCurrentModel() + "' and prefix '" + context.getPrefix() + "'");
		}
		// subclasses may override
	}
	public void complete_ValueType(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		if (logger.isDebugEnabled()) {
			logger.debug("complete_ValueType '" + ruleCall.getRule().getName() + "' cardinality '" + ruleCall.getCardinality()
					+ "' for model '" + context.getCurrentModel() + "' and prefix '" + context.getPrefix() + "'");
		}
		// subclasses may override
	}
	public void complete_CombineOperator(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		if (logger.isDebugEnabled()) {
			logger.debug("complete_CombineOperator '" + ruleCall.getRule().getName() + "' cardinality '" + ruleCall.getCardinality()
					+ "' for model '" + context.getCurrentModel() + "' and prefix '" + context.getPrefix() + "'");
		}
		// subclasses may override
	}
}
