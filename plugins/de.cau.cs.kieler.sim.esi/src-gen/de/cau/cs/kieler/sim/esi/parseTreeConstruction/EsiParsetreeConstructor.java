/*
* generated by Xtext
*/
package de.cau.cs.kieler.sim.esi.parseTreeConstruction;

import org.eclipse.emf.ecore.*;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parsetree.reconstr.IInstanceDescription;
import org.eclipse.xtext.parsetree.reconstr.impl.AbstractParseTreeConstructor;

import de.cau.cs.kieler.sim.esi.services.EsiGrammarAccess;

import com.google.inject.Inject;

public class EsiParsetreeConstructor extends AbstractParseTreeConstructor {
		
	@Inject
	private EsiGrammarAccess grammarAccess;
	
	@Override	
	public EsiGrammarAccess getGrammarAccess() {
		return grammarAccess;
	}

	@Override
	protected AbstractToken getRootToken(IInstanceDescription inst) {
		return new ThisRootNode(inst);	
	}
	
protected class ThisRootNode extends RootToken {
	public ThisRootNode(IInstanceDescription inst) {
		super(inst);
	}
	
	@Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new Tracelist_Group(this, this, 0, inst);
			case 1: return new Trace_Group(this, this, 1, inst);
			case 2: return new Tick_Group(this, this, 2, inst);
			case 3: return new Signal_Group(this, this, 3, inst);
			default: return null;
		}	
	}	
}
	

/************ begin Rule tracelist ****************
 *
 * tracelist:
 *   traces+=trace? ("!" "reset" ";" traces+=trace)+;
 *
 **/

// traces+=trace? ("!" "reset" ";" traces+=trace)+
protected class Tracelist_Group extends GroupToken {
	
	public Tracelist_Group(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getTracelistAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new Tracelist_Group_1(parent, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override
	public IInstanceDescription tryConsume() {
		if(!current.isInstanceOf(grammarAccess.getTracelistRule().getType().getClassifier())) return null;
		return tryConsumeVal();
	}
}

// traces+=trace?
protected class Tracelist_TracesAssignment_0 extends AssignmentToken  {
	
	public Tracelist_TracesAssignment_0(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getTracelistAccess().getTracesAssignment_0();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new Trace_Group(this, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override	
	protected IInstanceDescription tryConsumeVal() {
		if((value = current.getConsumable("traces",false)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("traces");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf(grammarAccess.getTraceRule().getType().getClassifier())) {
				type = AssignmentType.PRC;
				element = grammarAccess.getTracelistAccess().getTracesTraceParserRuleCall_0_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		if(value == inst.getDelegate() && !inst.isConsumed()) return null;
		switch(index) {
			default: return parent.createParentFollower(next, actIndex , index, consumed);
		}	
	}	
}

// ("!" "reset" ";" traces+=trace)+
protected class Tracelist_Group_1 extends GroupToken {
	
	public Tracelist_Group_1(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getTracelistAccess().getGroup_1();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new Tracelist_TracesAssignment_1_3(parent, this, 0, inst);
			default: return null;
		}	
	}	
		
}

// "!"
protected class Tracelist_ExclamationMarkKeyword_1_0 extends KeywordToken  {
	
	public Tracelist_ExclamationMarkKeyword_1_0(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getTracelistAccess().getExclamationMarkKeyword_1_0();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new Tracelist_Group_1(parent, this, 0, inst);
			case 1: return new Tracelist_TracesAssignment_0(parent, this, 1, inst);
			default: return parent.createParentFollower(this, index, index - 2, inst);
		}	
	}	
		
}

// "reset"
protected class Tracelist_ResetKeyword_1_1 extends KeywordToken  {
	
	public Tracelist_ResetKeyword_1_1(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getTracelistAccess().getResetKeyword_1_1();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new Tracelist_ExclamationMarkKeyword_1_0(parent, this, 0, inst);
			default: return null;
		}	
	}	
		
}

// ";"
protected class Tracelist_SemicolonKeyword_1_2 extends KeywordToken  {
	
	public Tracelist_SemicolonKeyword_1_2(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getTracelistAccess().getSemicolonKeyword_1_2();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new Tracelist_ResetKeyword_1_1(parent, this, 0, inst);
			default: return null;
		}	
	}	
		
}

// traces+=trace
protected class Tracelist_TracesAssignment_1_3 extends AssignmentToken  {
	
	public Tracelist_TracesAssignment_1_3(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getTracelistAccess().getTracesAssignment_1_3();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new Trace_Group(this, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override	
	protected IInstanceDescription tryConsumeVal() {
		if((value = current.getConsumable("traces",true)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("traces");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf(grammarAccess.getTraceRule().getType().getClassifier())) {
				type = AssignmentType.PRC;
				element = grammarAccess.getTracelistAccess().getTracesTraceParserRuleCall_1_3_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		if(value == inst.getDelegate() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new Tracelist_SemicolonKeyword_1_2(parent, next, actIndex, consumed);
			default: return null;
		}	
	}	
}



/************ end Rule tracelist ****************/


/************ begin Rule trace ****************
 *
 * trace:
 *   {trace} ticks+=tick*;
 *
 **/

// {trace} ticks+=tick*
protected class Trace_Group extends GroupToken {
	
	public Trace_Group(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getTraceAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new Trace_TicksAssignment_1(parent, this, 0, inst);
			case 1: return new Trace_TraceAction_0(parent, this, 1, inst);
			default: return null;
		}	
	}	
		
    @Override
	public IInstanceDescription tryConsume() {
		if(!current.isInstanceOf(grammarAccess.getTraceRule().getType().getClassifier())) return null;
		return tryConsumeVal();
	}
}

// {trace}
protected class Trace_TraceAction_0 extends ActionToken  {

	public Trace_TraceAction_0(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Action getGrammarElement() {
		return grammarAccess.getTraceAccess().getTraceAction_0();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			default: return parent.createParentFollower(this, index, index, inst);
		}	
	}	
		
	
    @Override
	protected IInstanceDescription tryConsumeVal() {
		if(!current.isInstanceOf(grammarAccess.getTraceAccess().getTraceAction_0().getType().getClassifier())) return null;
		if(!current.isConsumed()) return null;
		return current;
	}
}

// ticks+=tick*
protected class Trace_TicksAssignment_1 extends AssignmentToken  {
	
	public Trace_TicksAssignment_1(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getTraceAccess().getTicksAssignment_1();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new Tick_Group(this, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override	
	protected IInstanceDescription tryConsumeVal() {
		if((value = current.getConsumable("ticks",false)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("ticks");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf(grammarAccess.getTickRule().getType().getClassifier())) {
				type = AssignmentType.PRC;
				element = grammarAccess.getTraceAccess().getTicksTickParserRuleCall_1_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		if(value == inst.getDelegate() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new Trace_TicksAssignment_1(parent, next, actIndex, consumed);
			case 1: return new Trace_TraceAction_0(parent, next, actIndex, consumed);
			default: return null;
		}	
	}	
}


/************ end Rule trace ****************/


/************ begin Rule tick ****************
 *
 * tick:
 *   input+=signal* ("%" "Output" ":" output+=signal*)? n=";";
 *
 **/

// input+=signal* ("%" "Output" ":" output+=signal*)? n=";"
protected class Tick_Group extends GroupToken {
	
	public Tick_Group(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getTickAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new Tick_NAssignment_2(parent, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override
	public IInstanceDescription tryConsume() {
		if(!current.isInstanceOf(grammarAccess.getTickRule().getType().getClassifier())) return null;
		return tryConsumeVal();
	}
}

// input+=signal*
protected class Tick_InputAssignment_0 extends AssignmentToken  {
	
	public Tick_InputAssignment_0(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getTickAccess().getInputAssignment_0();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new Signal_Group(this, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override	
	protected IInstanceDescription tryConsumeVal() {
		if((value = current.getConsumable("input",false)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("input");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf(grammarAccess.getSignalRule().getType().getClassifier())) {
				type = AssignmentType.PRC;
				element = grammarAccess.getTickAccess().getInputSignalParserRuleCall_0_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		if(value == inst.getDelegate() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new Tick_InputAssignment_0(parent, next, actIndex, consumed);
			default: return parent.createParentFollower(next, actIndex , index - 1, consumed);
		}	
	}	
}

// ("%" "Output" ":" output+=signal*)?
protected class Tick_Group_1 extends GroupToken {
	
	public Tick_Group_1(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getTickAccess().getGroup_1();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new Tick_OutputAssignment_1_3(parent, this, 0, inst);
			case 1: return new Tick_ColonKeyword_1_2(parent, this, 1, inst);
			default: return null;
		}	
	}	
		
}

// "%"
protected class Tick_PercentSignKeyword_1_0 extends KeywordToken  {
	
	public Tick_PercentSignKeyword_1_0(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getTickAccess().getPercentSignKeyword_1_0();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new Tick_InputAssignment_0(parent, this, 0, inst);
			default: return parent.createParentFollower(this, index, index - 1, inst);
		}	
	}	
		
}

// "Output"
protected class Tick_OutputKeyword_1_1 extends KeywordToken  {
	
	public Tick_OutputKeyword_1_1(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getTickAccess().getOutputKeyword_1_1();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new Tick_PercentSignKeyword_1_0(parent, this, 0, inst);
			default: return null;
		}	
	}	
		
}

// ":"
protected class Tick_ColonKeyword_1_2 extends KeywordToken  {
	
	public Tick_ColonKeyword_1_2(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getTickAccess().getColonKeyword_1_2();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new Tick_OutputKeyword_1_1(parent, this, 0, inst);
			default: return null;
		}	
	}	
		
}

// output+=signal*
protected class Tick_OutputAssignment_1_3 extends AssignmentToken  {
	
	public Tick_OutputAssignment_1_3(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getTickAccess().getOutputAssignment_1_3();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new Signal_Group(this, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override	
	protected IInstanceDescription tryConsumeVal() {
		if((value = current.getConsumable("output",false)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("output");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf(grammarAccess.getSignalRule().getType().getClassifier())) {
				type = AssignmentType.PRC;
				element = grammarAccess.getTickAccess().getOutputSignalParserRuleCall_1_3_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		if(value == inst.getDelegate() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new Tick_OutputAssignment_1_3(parent, next, actIndex, consumed);
			case 1: return new Tick_ColonKeyword_1_2(parent, next, actIndex, consumed);
			default: return null;
		}	
	}	
}


// n=";"
protected class Tick_NAssignment_2 extends AssignmentToken  {
	
	public Tick_NAssignment_2(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getTickAccess().getNAssignment_2();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new Tick_Group_1(parent, this, 0, inst);
			case 1: return new Tick_InputAssignment_0(parent, this, 1, inst);
			default: return parent.createParentFollower(this, index, index - 2, inst);
		}	
	}	
		
    @Override	
	protected IInstanceDescription tryConsumeVal() {
		if((value = current.getConsumable("n",true)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("n");
		if(";".equals(value)) { // org::eclipse::xtext::impl::KeywordImpl
			type = AssignmentType.KW;
			element = grammarAccess.getTickAccess().getNSemicolonKeyword_2_0();
			return obj;
		}
		return null;
	}

}


/************ end Rule tick ****************/


/************ begin Rule signal ****************
 *
 * signal:
 *   name=ID (valued?="(" val=NUM ")")?;  
 * 
 *      
 *              
 *    
 *                
 * / *------------------------------------------------------------------
 * * LEXER RULES
 * *------------------------------------------------------------------* /
 *
 **/

// name=ID (valued?="(" val=NUM ")")?
protected class Signal_Group extends GroupToken {
	
	public Signal_Group(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getSignalAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new Signal_Group_1(parent, this, 0, inst);
			case 1: return new Signal_NameAssignment_0(parent, this, 1, inst);
			default: return null;
		}	
	}	
		
    @Override
	public IInstanceDescription tryConsume() {
		if(!current.isInstanceOf(grammarAccess.getSignalRule().getType().getClassifier())) return null;
		return tryConsumeVal();
	}
}

// name=ID
protected class Signal_NameAssignment_0 extends AssignmentToken  {
	
	public Signal_NameAssignment_0(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getSignalAccess().getNameAssignment_0();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			default: return parent.createParentFollower(this, index, index, inst);
		}	
	}	
		
    @Override	
	protected IInstanceDescription tryConsumeVal() {
		if((value = current.getConsumable("name",true)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("name");
		if(Boolean.TRUE.booleanValue()) { // org::eclipse::xtext::impl::RuleCallImpl FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = grammarAccess.getSignalAccess().getNameIDTerminalRuleCall_0_0();
			return obj;
		}
		return null;
	}

}

// (valued?="(" val=NUM ")")?
protected class Signal_Group_1 extends GroupToken {
	
	public Signal_Group_1(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getSignalAccess().getGroup_1();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new Signal_RightParenthesisKeyword_1_2(parent, this, 0, inst);
			default: return null;
		}	
	}	
		
}

// valued?="("
protected class Signal_ValuedAssignment_1_0 extends AssignmentToken  {
	
	public Signal_ValuedAssignment_1_0(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getSignalAccess().getValuedAssignment_1_0();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new Signal_NameAssignment_0(parent, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override	
	protected IInstanceDescription tryConsumeVal() {
		if((value = current.getConsumable("valued",true)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("valued");
		if(Boolean.TRUE.equals(value)) { // org::eclipse::xtext::impl::KeywordImpl
			type = AssignmentType.KW;
			element = grammarAccess.getSignalAccess().getValuedLeftParenthesisKeyword_1_0_0();
			return obj;
		}
		return null;
	}

}

// val=NUM
protected class Signal_ValAssignment_1_1 extends AssignmentToken  {
	
	public Signal_ValAssignment_1_1(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getSignalAccess().getValAssignment_1_1();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new Signal_ValuedAssignment_1_0(parent, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override	
	protected IInstanceDescription tryConsumeVal() {
		if((value = current.getConsumable("val",true)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("val");
		if(Boolean.TRUE.booleanValue()) { // org::eclipse::xtext::impl::RuleCallImpl FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = grammarAccess.getSignalAccess().getValNUMTerminalRuleCall_1_1_0();
			return obj;
		}
		return null;
	}

}

// ")"
protected class Signal_RightParenthesisKeyword_1_2 extends KeywordToken  {
	
	public Signal_RightParenthesisKeyword_1_2(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getSignalAccess().getRightParenthesisKeyword_1_2();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new Signal_ValAssignment_1_1(parent, this, 0, inst);
			default: return null;
		}	
	}	
		
}



/************ end Rule signal ****************/

}
