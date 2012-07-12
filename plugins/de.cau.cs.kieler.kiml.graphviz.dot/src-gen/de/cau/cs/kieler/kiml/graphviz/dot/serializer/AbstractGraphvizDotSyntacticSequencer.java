package de.cau.cs.kieler.kiml.graphviz.dot.serializer;

import com.google.inject.Inject;
import de.cau.cs.kieler.kiml.graphviz.dot.services.GraphvizDotGrammarAccess;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AbstractElementAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.GroupAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.TokenAlias;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynNavigable;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynTransition;
import org.eclipse.xtext.serializer.sequencer.AbstractSyntacticSequencer;

@SuppressWarnings("all")
public abstract class AbstractGraphvizDotSyntacticSequencer extends AbstractSyntacticSequencer {

	protected GraphvizDotGrammarAccess grammarAccess;
	protected AbstractElementAlias match_AttributeStatement_CommaKeyword_2_1_0_q;
	protected AbstractElementAlias match_EdgeStatement_CommaKeyword_2_1_1_0_q;
	protected AbstractElementAlias match_EdgeStatement___LeftSquareBracketKeyword_2_0_RightSquareBracketKeyword_2_2__q;
	protected AbstractElementAlias match_NodeStatement_CommaKeyword_1_1_1_0_q;
	protected AbstractElementAlias match_NodeStatement___LeftSquareBracketKeyword_1_0_RightSquareBracketKeyword_1_2__q;
	protected AbstractElementAlias match_Statement_SemicolonKeyword_1_q;
	protected AbstractElementAlias match_Subgraph_SubgraphKeyword_1_0_q;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (GraphvizDotGrammarAccess) access;
		match_AttributeStatement_CommaKeyword_2_1_0_q = new TokenAlias(false, true, grammarAccess.getAttributeStatementAccess().getCommaKeyword_2_1_0());
		match_EdgeStatement_CommaKeyword_2_1_1_0_q = new TokenAlias(false, true, grammarAccess.getEdgeStatementAccess().getCommaKeyword_2_1_1_0());
		match_EdgeStatement___LeftSquareBracketKeyword_2_0_RightSquareBracketKeyword_2_2__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getEdgeStatementAccess().getLeftSquareBracketKeyword_2_0()), new TokenAlias(false, false, grammarAccess.getEdgeStatementAccess().getRightSquareBracketKeyword_2_2()));
		match_NodeStatement_CommaKeyword_1_1_1_0_q = new TokenAlias(false, true, grammarAccess.getNodeStatementAccess().getCommaKeyword_1_1_1_0());
		match_NodeStatement___LeftSquareBracketKeyword_1_0_RightSquareBracketKeyword_1_2__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getNodeStatementAccess().getLeftSquareBracketKeyword_1_0()), new TokenAlias(false, false, grammarAccess.getNodeStatementAccess().getRightSquareBracketKeyword_1_2()));
		match_Statement_SemicolonKeyword_1_q = new TokenAlias(false, true, grammarAccess.getStatementAccess().getSemicolonKeyword_1());
		match_Subgraph_SubgraphKeyword_1_0_q = new TokenAlias(false, true, grammarAccess.getSubgraphAccess().getSubgraphKeyword_1_0());
	}
	
	@Override
	protected String getUnassignedRuleCallToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		return "";
	}
	
	
	@Override
	protected void emitUnassignedTokens(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		if (transition.getAmbiguousSyntaxes().isEmpty()) return;
		List<INode> transitionNodes = collectNodes(fromNode, toNode);
		for (AbstractElementAlias syntax : transition.getAmbiguousSyntaxes()) {
			List<INode> syntaxNodes = getNodesFor(transitionNodes, syntax);
			if(match_AttributeStatement_CommaKeyword_2_1_0_q.equals(syntax))
				emit_AttributeStatement_CommaKeyword_2_1_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_EdgeStatement_CommaKeyword_2_1_1_0_q.equals(syntax))
				emit_EdgeStatement_CommaKeyword_2_1_1_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_EdgeStatement___LeftSquareBracketKeyword_2_0_RightSquareBracketKeyword_2_2__q.equals(syntax))
				emit_EdgeStatement___LeftSquareBracketKeyword_2_0_RightSquareBracketKeyword_2_2__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_NodeStatement_CommaKeyword_1_1_1_0_q.equals(syntax))
				emit_NodeStatement_CommaKeyword_1_1_1_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_NodeStatement___LeftSquareBracketKeyword_1_0_RightSquareBracketKeyword_1_2__q.equals(syntax))
				emit_NodeStatement___LeftSquareBracketKeyword_1_0_RightSquareBracketKeyword_1_2__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Statement_SemicolonKeyword_1_q.equals(syntax))
				emit_Statement_SemicolonKeyword_1_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Subgraph_SubgraphKeyword_1_0_q.equals(syntax))
				emit_Subgraph_SubgraphKeyword_1_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * Syntax:
	 *     ','?
	 */
	protected void emit_AttributeStatement_CommaKeyword_2_1_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ','?
	 */
	protected void emit_EdgeStatement_CommaKeyword_2_1_1_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ('[' ']')?
	 */
	protected void emit_EdgeStatement___LeftSquareBracketKeyword_2_0_RightSquareBracketKeyword_2_2__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ','?
	 */
	protected void emit_NodeStatement_CommaKeyword_1_1_1_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ('[' ']')?
	 */
	protected void emit_NodeStatement___LeftSquareBracketKeyword_1_0_RightSquareBracketKeyword_1_2__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ';'?
	 */
	protected void emit_Statement_SemicolonKeyword_1_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'subgraph'?
	 */
	protected void emit_Subgraph_SubgraphKeyword_1_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}
