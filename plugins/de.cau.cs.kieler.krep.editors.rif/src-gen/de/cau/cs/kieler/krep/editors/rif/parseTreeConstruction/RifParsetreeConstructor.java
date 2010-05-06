/*
* generated by Xtext
*/
package de.cau.cs.kieler.krep.editors.rif.parseTreeConstruction;

import org.eclipse.emf.ecore.*;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parsetree.reconstr.IEObjectConsumer;
import org.eclipse.xtext.parsetree.reconstr.impl.AbstractParseTreeConstructor;

import de.cau.cs.kieler.krep.editors.rif.services.RifGrammarAccess;

import com.google.inject.Inject;

public class RifParsetreeConstructor extends AbstractParseTreeConstructor {
		
	@Inject
	private RifGrammarAccess grammarAccess;
	
	@Override
	protected AbstractToken getRootToken(IEObjectConsumer inst) {
		return new ThisRootNode(inst);	
	}
	
protected class ThisRootNode extends RootToken {
	public ThisRootNode(IEObjectConsumer inst) {
		super(inst);
	}
	
	@Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Trace_Group(this, this, 0, inst);
			case 1: return new Decl_Group(this, this, 1, inst);
			case 2: return new Tick_Group(this, this, 2, inst);
			case 3: return new Data_Alternatives(this, this, 3, inst);
			default: return null;
		}	
	}	
}
	

/************ begin Rule Trace ****************
 *
 * Trace:
 *   INPUTS inputs+=decl* "@#" OUTPUTS outputs+=decl* "@#" LOCALS local+=decl*
 *   "@#" tick+=Tick+ Status?;
 *
 **/

// INPUTS inputs+=decl* "@#" OUTPUTS outputs+=decl* "@#" LOCALS local+=decl* "@#"
// tick+=Tick+ Status?
protected class Trace_Group extends GroupToken {
	
	public Trace_Group(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getTraceAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Trace_TickAssignment_9(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getTraceRule().getType().getClassifier())
			return null;
		return eObjectConsumer;
	}

}

// INPUTS
protected class Trace_INPUTSTerminalRuleCall_0 extends UnassignedTextToken {

	public Trace_INPUTSTerminalRuleCall_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public RuleCall getGrammarElement() {
		return grammarAccess.getTraceAccess().getINPUTSTerminalRuleCall_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(this, index, index, inst);
		}	
	}

}

// inputs+=decl*
protected class Trace_InputsAssignment_1 extends AssignmentToken  {
	
	public Trace_InputsAssignment_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getTraceAccess().getInputsAssignment_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Decl_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("inputs",false)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("inputs");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getDeclRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getTraceAccess().getInputsDeclParserRuleCall_1_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new Trace_InputsAssignment_1(lastRuleCallOrigin, next, actIndex, consumed);
			case 1: return new Trace_INPUTSTerminalRuleCall_0(lastRuleCallOrigin, next, actIndex, consumed);
			default: return null;
		}	
	}	
}

// "@#"
protected class Trace_CommercialAtNumberSignKeyword_2 extends KeywordToken  {
	
	public Trace_CommercialAtNumberSignKeyword_2(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getTraceAccess().getCommercialAtNumberSignKeyword_2();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Trace_InputsAssignment_1(lastRuleCallOrigin, this, 0, inst);
			case 1: return new Trace_INPUTSTerminalRuleCall_0(lastRuleCallOrigin, this, 1, inst);
			default: return null;
		}	
	}

}

// OUTPUTS
protected class Trace_OUTPUTSTerminalRuleCall_3 extends UnassignedTextToken {

	public Trace_OUTPUTSTerminalRuleCall_3(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public RuleCall getGrammarElement() {
		return grammarAccess.getTraceAccess().getOUTPUTSTerminalRuleCall_3();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Trace_CommercialAtNumberSignKeyword_2(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}

// outputs+=decl*
protected class Trace_OutputsAssignment_4 extends AssignmentToken  {
	
	public Trace_OutputsAssignment_4(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getTraceAccess().getOutputsAssignment_4();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Decl_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("outputs",false)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("outputs");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getDeclRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getTraceAccess().getOutputsDeclParserRuleCall_4_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new Trace_OutputsAssignment_4(lastRuleCallOrigin, next, actIndex, consumed);
			case 1: return new Trace_OUTPUTSTerminalRuleCall_3(lastRuleCallOrigin, next, actIndex, consumed);
			default: return null;
		}	
	}	
}

// "@#"
protected class Trace_CommercialAtNumberSignKeyword_5 extends KeywordToken  {
	
	public Trace_CommercialAtNumberSignKeyword_5(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getTraceAccess().getCommercialAtNumberSignKeyword_5();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Trace_OutputsAssignment_4(lastRuleCallOrigin, this, 0, inst);
			case 1: return new Trace_OUTPUTSTerminalRuleCall_3(lastRuleCallOrigin, this, 1, inst);
			default: return null;
		}	
	}

}

// LOCALS
protected class Trace_LOCALSTerminalRuleCall_6 extends UnassignedTextToken {

	public Trace_LOCALSTerminalRuleCall_6(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public RuleCall getGrammarElement() {
		return grammarAccess.getTraceAccess().getLOCALSTerminalRuleCall_6();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Trace_CommercialAtNumberSignKeyword_5(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}

// local+=decl*
protected class Trace_LocalAssignment_7 extends AssignmentToken  {
	
	public Trace_LocalAssignment_7(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getTraceAccess().getLocalAssignment_7();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Decl_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("local",false)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("local");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getDeclRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getTraceAccess().getLocalDeclParserRuleCall_7_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new Trace_LocalAssignment_7(lastRuleCallOrigin, next, actIndex, consumed);
			case 1: return new Trace_LOCALSTerminalRuleCall_6(lastRuleCallOrigin, next, actIndex, consumed);
			default: return null;
		}	
	}	
}

// "@#"
protected class Trace_CommercialAtNumberSignKeyword_8 extends KeywordToken  {
	
	public Trace_CommercialAtNumberSignKeyword_8(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getTraceAccess().getCommercialAtNumberSignKeyword_8();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Trace_LocalAssignment_7(lastRuleCallOrigin, this, 0, inst);
			case 1: return new Trace_LOCALSTerminalRuleCall_6(lastRuleCallOrigin, this, 1, inst);
			default: return null;
		}	
	}

}

// tick+=Tick+
protected class Trace_TickAssignment_9 extends AssignmentToken  {
	
	public Trace_TickAssignment_9(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getTraceAccess().getTickAssignment_9();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Tick_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("tick",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("tick");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getTickRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getTraceAccess().getTickTickParserRuleCall_9_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new Trace_TickAssignment_9(lastRuleCallOrigin, next, actIndex, consumed);
			case 1: return new Trace_CommercialAtNumberSignKeyword_8(lastRuleCallOrigin, next, actIndex, consumed);
			default: return null;
		}	
	}	
}


/************ end Rule Trace ****************/


/************ begin Rule decl ****************
 *
 * decl:
 *   name=STRING ":" type=Type;
 *
 **/

// name=STRING ":" type=Type
protected class Decl_Group extends GroupToken {
	
	public Decl_Group(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getDeclAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Decl_TypeAssignment_2(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getDeclRule().getType().getClassifier())
			return null;
		return eObjectConsumer;
	}

}

// name=STRING
protected class Decl_NameAssignment_0 extends AssignmentToken  {
	
	public Decl_NameAssignment_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getDeclAccess().getNameAssignment_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(this, index, index, inst);
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("name",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("name");
		if(valueSerializer.isValid(obj.getEObject(), grammarAccess.getDeclAccess().getNameSTRINGTerminalRuleCall_0_0(), value, null)) {
			type = AssignmentType.TERMINAL_RULE_CALL;
			element = grammarAccess.getDeclAccess().getNameSTRINGTerminalRuleCall_0_0();
			return obj;
		}
		return null;
	}

}

// ":"
protected class Decl_ColonKeyword_1 extends KeywordToken  {
	
	public Decl_ColonKeyword_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getDeclAccess().getColonKeyword_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Decl_NameAssignment_0(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}

// type=Type
protected class Decl_TypeAssignment_2 extends AssignmentToken  {
	
	public Decl_TypeAssignment_2(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getDeclAccess().getTypeAssignment_2();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Decl_ColonKeyword_1(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("type",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("type");
		if(valueSerializer.isValid(obj.getEObject(), grammarAccess.getDeclAccess().getTypeTypeParserRuleCall_2_0(), value, null)) {
			type = AssignmentType.DATATYPE_RULE_CALL;
			element = grammarAccess.getDeclAccess().getTypeTypeParserRuleCall_2_0();
			return obj;
		}
		return null;
	}

}


/************ end Rule decl ****************/



/************ begin Rule Tick ****************
 *
 * Tick:
 *   {Tick} "#step" nr=INT input+=Data* "#outs" output+=Data* "#locs" local+=Data*
 * ;
 *
 **/

// {Tick} "#step" nr=INT input+=Data* "#outs" output+=Data* "#locs" local+=Data*
protected class Tick_Group extends GroupToken {
	
	public Tick_Group(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getTickAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Tick_LocalAssignment_7(lastRuleCallOrigin, this, 0, inst);
			case 1: return new Tick_LocsKeyword_6(lastRuleCallOrigin, this, 1, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getTickAccess().getTickAction_0().getType().getClassifier())
			return null;
		return eObjectConsumer;
	}

}

// {Tick}
protected class Tick_TickAction_0 extends ActionToken  {

	public Tick_TickAction_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Action getGrammarElement() {
		return grammarAccess.getTickAccess().getTickAction_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(this, index, index, inst);
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(!eObjectConsumer.isConsumed()) return null;
		return eObjectConsumer;
	}
}

// "#step"
protected class Tick_StepKeyword_1 extends KeywordToken  {
	
	public Tick_StepKeyword_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getTickAccess().getStepKeyword_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Tick_TickAction_0(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}

// nr=INT
protected class Tick_NrAssignment_2 extends AssignmentToken  {
	
	public Tick_NrAssignment_2(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getTickAccess().getNrAssignment_2();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Tick_StepKeyword_1(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("nr",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("nr");
		if(valueSerializer.isValid(obj.getEObject(), grammarAccess.getTickAccess().getNrINTTerminalRuleCall_2_0(), value, null)) {
			type = AssignmentType.TERMINAL_RULE_CALL;
			element = grammarAccess.getTickAccess().getNrINTTerminalRuleCall_2_0();
			return obj;
		}
		return null;
	}

}

// input+=Data*
protected class Tick_InputAssignment_3 extends AssignmentToken  {
	
	public Tick_InputAssignment_3(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getTickAccess().getInputAssignment_3();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Data_Alternatives(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("input",false)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("input");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getDataRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getTickAccess().getInputDataParserRuleCall_3_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new Tick_InputAssignment_3(lastRuleCallOrigin, next, actIndex, consumed);
			case 1: return new Tick_NrAssignment_2(lastRuleCallOrigin, next, actIndex, consumed);
			default: return null;
		}	
	}	
}

// "#outs"
protected class Tick_OutsKeyword_4 extends KeywordToken  {
	
	public Tick_OutsKeyword_4(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getTickAccess().getOutsKeyword_4();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Tick_InputAssignment_3(lastRuleCallOrigin, this, 0, inst);
			case 1: return new Tick_NrAssignment_2(lastRuleCallOrigin, this, 1, inst);
			default: return null;
		}	
	}

}

// output+=Data*
protected class Tick_OutputAssignment_5 extends AssignmentToken  {
	
	public Tick_OutputAssignment_5(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getTickAccess().getOutputAssignment_5();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Data_Alternatives(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("output",false)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("output");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getDataRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getTickAccess().getOutputDataParserRuleCall_5_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new Tick_OutputAssignment_5(lastRuleCallOrigin, next, actIndex, consumed);
			case 1: return new Tick_OutsKeyword_4(lastRuleCallOrigin, next, actIndex, consumed);
			default: return null;
		}	
	}	
}

// "#locs"
protected class Tick_LocsKeyword_6 extends KeywordToken  {
	
	public Tick_LocsKeyword_6(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getTickAccess().getLocsKeyword_6();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Tick_OutputAssignment_5(lastRuleCallOrigin, this, 0, inst);
			case 1: return new Tick_OutsKeyword_4(lastRuleCallOrigin, this, 1, inst);
			default: return null;
		}	
	}

}

// local+=Data*
protected class Tick_LocalAssignment_7 extends AssignmentToken  {
	
	public Tick_LocalAssignment_7(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getTickAccess().getLocalAssignment_7();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Data_Alternatives(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("local",false)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("local");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getDataRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getTickAccess().getLocalDataParserRuleCall_7_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new Tick_LocalAssignment_7(lastRuleCallOrigin, next, actIndex, consumed);
			case 1: return new Tick_LocsKeyword_6(lastRuleCallOrigin, next, actIndex, consumed);
			default: return null;
		}	
	}	
}


/************ end Rule Tick ****************/


/************ begin Rule Data ****************
 *
 * Data:
 *   val=INT|true="T"|false="F";
 *
 **/

// val=INT|true="T"|false="F"
protected class Data_Alternatives extends AlternativesToken {

	public Data_Alternatives(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Alternatives getGrammarElement() {
		return grammarAccess.getDataAccess().getAlternatives();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Data_ValAssignment_0(lastRuleCallOrigin, this, 0, inst);
			case 1: return new Data_TrueAssignment_1(lastRuleCallOrigin, this, 1, inst);
			case 2: return new Data_FalseAssignment_2(lastRuleCallOrigin, this, 2, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getDataRule().getType().getClassifier())
			return null;
		return eObjectConsumer;
	}

}

// val=INT
protected class Data_ValAssignment_0 extends AssignmentToken  {
	
	public Data_ValAssignment_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getDataAccess().getValAssignment_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(this, index, index, inst);
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("val",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("val");
		if(valueSerializer.isValid(obj.getEObject(), grammarAccess.getDataAccess().getValINTTerminalRuleCall_0_0(), value, null)) {
			type = AssignmentType.TERMINAL_RULE_CALL;
			element = grammarAccess.getDataAccess().getValINTTerminalRuleCall_0_0();
			return obj;
		}
		return null;
	}

}

// true="T"
protected class Data_TrueAssignment_1 extends AssignmentToken  {
	
	public Data_TrueAssignment_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getDataAccess().getTrueAssignment_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(this, index, index, inst);
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("true",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("true");
		if("T".equals(value)) { // org::eclipse::xtext::impl::KeywordImpl
			type = AssignmentType.KEYWORD;
			element = grammarAccess.getDataAccess().getTrueTKeyword_1_0();
			return obj;
		}
		return null;
	}

}

// false="F"
protected class Data_FalseAssignment_2 extends AssignmentToken  {
	
	public Data_FalseAssignment_2(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getDataAccess().getFalseAssignment_2();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(this, index, index, inst);
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("false",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("false");
		if("F".equals(value)) { // org::eclipse::xtext::impl::KeywordImpl
			type = AssignmentType.KEYWORD;
			element = grammarAccess.getDataAccess().getFalseFKeyword_2_0();
			return obj;
		}
		return null;
	}

}


/************ end Rule Data ****************/


}
