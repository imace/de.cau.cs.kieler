/*
 * generated by Xtext
 */
package de.cau.cs.kieler.synccharts.dsl.contentassist;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.ui.core.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.core.editor.contentassist.ICompletionProposalAcceptor;

import de.cau.cs.kieler.synccharts.Transition;
import de.cau.cs.kieler.synccharts.dsl.contentassist.AbstractKitsProposalProvider;

/**
 * see.
 * http://www.eclipse.org/Xtext/documentation/latest/xtext.html#contentAssist on
 * how to customize content assistant
 */
public class KitsProposalProvider extends AbstractKitsProposalProvider {
//    @Override
//    public void completeTransition_TargetState(EObject model,
//            Assignment assignment, ContentAssistContext context,
//            ICompletionProposalAcceptor acceptor) {
//        // implementation in super class
//        super.completeTransition_TargetState(model, assignment, context,
//                acceptor);
//
//        // compute the plain proposal
//        String proposal = "CHANGED";
//
//        // convert the proposal (String) to a valid ID terminal
//        proposal = getValueConverter().toString(proposal, "ID");
//
//        // create the completion proposal
//        ICompletionProposal completionProposal = createCompletionProposal(
//                proposal, context);
//
//        // register the proposal
//        acceptor.accept(completionProposal);
//
//    }
//
//    @Override
//    public void completeTransition_Type(EObject model, Assignment assignment,
//            ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
//        // implementation in super class
//        super.completeTransition_Type(model, assignment, context, acceptor);
//
//        String proposal = null;
//        Transition transition = null;
//        // get Transition types
//        if (model instanceof Transition) {
//
//            transition = (Transition) model;
//        }
//        // compute the plain proposal
//        proposal = "Changed" + transition.getType().getLiteral();
//
//        // convert the proposal (String) to a valid ID terminal
//        proposal = getValueConverter().toString(proposal, "ID");
//
//        // create the completion proposal
//        ICompletionProposal completionProposal = createCompletionProposal(
//                proposal, context);
//
//        // register the proposal
//        acceptor.accept(completionProposal);
//
//    }
}
