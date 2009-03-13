grammar KIT;
 options{backtrack=true; memoize=true;} 

@lexer::header {
package de.cau.cs.kieler.ssm2.kit.parser;

import org.openarchitectureware.xtext.parser.ErrorMsg;
import org.openarchitectureware.xtext.parser.impl.AntlrUtil;

}

@parser::header {
package de.cau.cs.kieler.ssm2.kit.parser;

import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EObject;

import org.openarchitectureware.xtext.parser.impl.AntlrUtil;
import org.openarchitectureware.xtext.XtextFile;
import org.openarchitectureware.xtext.parser.impl.EcoreModelFactory;
import org.openarchitectureware.xtext.parser.ErrorMsg;
import org.openarchitectureware.xtext.parser.model.ParseTreeManagerNeu;
import org.openarchitectureware.xtext.parser.parsetree.Node;

import de.cau.cs.kieler.ssm2.kit.MetaModelRegistration;

}
@lexer::members {
	 private List<ErrorMsg> errors = new ArrayList<ErrorMsg>();
	public List<ErrorMsg> getErrors() {
		return errors;
	}

	public String getErrorMessage(RecognitionException e, String[] tokenNames) {
		String msg = super.getErrorMessage(e,tokenNames);
		errors.add(AntlrUtil.create(msg,e,tokenNames));
		return msg;
	}
}

@parser::members {

	private Token getLastToken() {
		return input.LT(-1);
	}

	protected Object convert(Object arg) {
		if (arg instanceof org.antlr.runtime.Token) {
			Token t = (Token) arg;
			String s = t.getText();
			if (t.getType() == KITLexer.RULE_ID && s.startsWith("^")) {
				return s.substring(1);
			} else if (t.getType()==KITLexer.RULE_STRING) {
				return s.substring(1,s.length()-1);
			} else if (t.getType()==KITLexer.RULE_INT) {
				return Integer.valueOf(s);
			}
			return s;
		}
		return arg;
	}


	private EcoreModelFactory factory = new EcoreModelFactory(MetaModelRegistration.getEPackage());
    private ParseTreeManagerNeu ptm = new ParseTreeManagerNeu();
	private XtextFile xtextfile = MetaModelRegistration.getXtextFile();
	
	{
		
	}

	public ParseTreeManagerNeu getResult() {
		return ptm;
	}

	private List<ErrorMsg> errors = new ArrayList<ErrorMsg>();
	public List<ErrorMsg> getErrors() {
		return errors;
	}

	@Override
	public void reportError(RecognitionException e) {
		String msg = super.getErrorMessage(e,tokenNames);
		errors.add(AntlrUtil.create(msg,e,tokenNames));
		ptm.addError(msg, e);
		// This doesn't work. ANTLR may simply report an superfluous token. In that case,
		// two nodes will be finished instead of one.
		// ptm.ruleFinished(null, end());
	}

    private boolean skipCurrentToken;
    
	@Override
	protected boolean recoverFromMismatchedElement(IntStream arg0, RecognitionException arg1, BitSet arg2) {
		skipCurrentToken = true;
		return super.recoverFromMismatchedElement(arg0, arg1, arg2);
	}
}


parse returns [Node r]:
	 result=ruleStatechart
	 // Always return the root node! This prevents that this method is called multiple times
	 // with interesting side effects.
{
if (result != null)
  ptm.setModelElement(result);
$r = ptm.getCurrent();
ptm.ruleFinished(result);}	 EOF
;

ruleStatechart returns [EObject result]
@init {boolean hasContent = false;}
:
			{
				$result = factory.create("", "Statechart");
			 }
(({skipCurrentToken = false;}'statechart'{if (!skipCurrentToken) {
  hasContent = true;
  ptm.createNode(((EObject)((EObject)((EObject)xtextfile.eContents().get(0)).eContents().get(1)).eContents().get(0)));
  ptm.ruleFinished(getLastToken());
}})

({skipCurrentToken = false;}
RULE_ID{if (!skipCurrentToken) {
  hasContent = true;
  Token temp = getLastToken();
  ptm.createNode(((EObject)((EObject)((EObject)xtextfile.eContents().get(0)).eContents().get(1)).eContents().get(1)));
  factory.set($result,"name",convert(temp),false);
  ptm.ruleFinished(temp);
}}
)

(({skipCurrentToken = false;}'['{if (!skipCurrentToken) {
  hasContent = true;
  ptm.createNode(((EObject)((EObject)((EObject)((EObject)xtextfile.eContents().get(0)).eContents().get(1)).eContents().get(2)).eContents().get(0)));
  ptm.ruleFinished(getLastToken());
}})

({ptm.createNode(((EObject)((EObject)((EObject)((EObject)xtextfile.eContents().get(0)).eContents().get(1)).eContents().get(2)).eContents().get(1)));}temp_ChartArgument=
ruleChartArgument{if (temp_ChartArgument != null) {
  hasContent = true;
  ptm.setModelElement(temp_ChartArgument);
  factory.add($result,"arguments",convert(temp_ChartArgument),false);
  ptm.ruleFinished(temp_ChartArgument);
} else {
  ptm.destroyNode();
}
}
)*

({skipCurrentToken = false;}']'{if (!skipCurrentToken) {
  hasContent = true;
  ptm.createNode(((EObject)((EObject)((EObject)((EObject)xtextfile.eContents().get(0)).eContents().get(1)).eContents().get(2)).eContents().get(2)));
  ptm.ruleFinished(getLastToken());
}})
)?

({skipCurrentToken = false;}'{'{if (!skipCurrentToken) {
  hasContent = true;
  ptm.createNode(((EObject)((EObject)((EObject)xtextfile.eContents().get(0)).eContents().get(1)).eContents().get(3)));
  ptm.ruleFinished(getLastToken());
}})

({ptm.createNode(((EObject)((EObject)((EObject)xtextfile.eContents().get(0)).eContents().get(1)).eContents().get(4)));}temp_IoDeclaration=
ruleIoDeclaration{if (temp_IoDeclaration != null) {
  hasContent = true;
  ptm.setModelElement(temp_IoDeclaration);
  factory.add($result,"iodeclarations",convert(temp_IoDeclaration),false);
  ptm.ruleFinished(temp_IoDeclaration);
} else {
  ptm.destroyNode();
}
}
)*

({skipCurrentToken = false;}'{'{if (!skipCurrentToken) {
  hasContent = true;
  ptm.createNode(((EObject)((EObject)((EObject)xtextfile.eContents().get(0)).eContents().get(1)).eContents().get(5)));
  ptm.ruleFinished(getLastToken());
}})

({ptm.createNode(((EObject)((EObject)((EObject)xtextfile.eContents().get(0)).eContents().get(1)).eContents().get(6)));}temp_Element=
ruleElement{if (temp_Element != null) {
  hasContent = true;
  ptm.setModelElement(temp_Element);
  factory.add($result,"elements",convert(temp_Element),false);
  ptm.ruleFinished(temp_Element);
} else {
  ptm.destroyNode();
}
}
)*

({skipCurrentToken = false;}'}'{if (!skipCurrentToken) {
  hasContent = true;
  ptm.createNode(((EObject)((EObject)((EObject)xtextfile.eContents().get(0)).eContents().get(1)).eContents().get(7)));
  ptm.ruleFinished(getLastToken());
}})

({skipCurrentToken = false;}'}'{if (!skipCurrentToken) {
  hasContent = true;
  ptm.createNode(((EObject)((EObject)((EObject)xtextfile.eContents().get(0)).eContents().get(1)).eContents().get(8)));
  ptm.ruleFinished(getLastToken());
}})

({skipCurrentToken = false;}';'{if (!skipCurrentToken) {
  hasContent = true;
  ptm.createNode(((EObject)((EObject)((EObject)xtextfile.eContents().get(0)).eContents().get(1)).eContents().get(9)));
  ptm.ruleFinished(getLastToken());
}})
)
 {if (!hasContent)
  $result = null;};
catch [RecognitionException re] {if (!hasContent)
    $result = null;
reportError(re);
recover(input,re);}

ruleChartArgument returns [EObject result]
@init {boolean hasContent = false;}
:
			{
				$result = factory.create("", "ChartArgument");
			 }
((({skipCurrentToken = false;}'model'{if (!skipCurrentToken) {
  hasContent = true;
  ptm.createNode(((EObject)((EObject)((EObject)((EObject)xtextfile.eContents().get(1)).eContents().get(1)).eContents().get(0)).eContents().get(0)));
  ptm.ruleFinished(getLastToken());
}})

({skipCurrentToken = false;}'='{if (!skipCurrentToken) {
  hasContent = true;
  ptm.createNode(((EObject)((EObject)((EObject)((EObject)xtextfile.eContents().get(1)).eContents().get(1)).eContents().get(0)).eContents().get(1)));
  ptm.ruleFinished(getLastToken());
}})

({skipCurrentToken = false;}
RULE_ID{if (!skipCurrentToken) {
  hasContent = true;
  Token temp = getLastToken();
  ptm.createNode(((EObject)((EObject)((EObject)((EObject)xtextfile.eContents().get(1)).eContents().get(1)).eContents().get(0)).eContents().get(2)));
  factory.set($result,"model",convert(temp),false);
  ptm.ruleFinished(temp);
}}
)

({skipCurrentToken = false;}';'{if (!skipCurrentToken) {
  hasContent = true;
  ptm.createNode(((EObject)((EObject)((EObject)((EObject)xtextfile.eContents().get(1)).eContents().get(1)).eContents().get(0)).eContents().get(3)));
  ptm.ruleFinished(getLastToken());
}})
)
	|
(({skipCurrentToken = false;}'version'{if (!skipCurrentToken) {
  hasContent = true;
  ptm.createNode(((EObject)((EObject)((EObject)((EObject)xtextfile.eContents().get(1)).eContents().get(1)).eContents().get(1)).eContents().get(0)));
  ptm.ruleFinished(getLastToken());
}})

({skipCurrentToken = false;}'='{if (!skipCurrentToken) {
  hasContent = true;
  ptm.createNode(((EObject)((EObject)((EObject)((EObject)xtextfile.eContents().get(1)).eContents().get(1)).eContents().get(1)).eContents().get(1)));
  ptm.ruleFinished(getLastToken());
}})

({skipCurrentToken = false;}
RULE_ID{if (!skipCurrentToken) {
  hasContent = true;
  Token temp = getLastToken();
  ptm.createNode(((EObject)((EObject)((EObject)((EObject)xtextfile.eContents().get(1)).eContents().get(1)).eContents().get(1)).eContents().get(2)));
  factory.set($result,"version",convert(temp),false);
  ptm.ruleFinished(temp);
}}
)

({skipCurrentToken = false;}';'{if (!skipCurrentToken) {
  hasContent = true;
  ptm.createNode(((EObject)((EObject)((EObject)((EObject)xtextfile.eContents().get(1)).eContents().get(1)).eContents().get(1)).eContents().get(3)));
  ptm.ruleFinished(getLastToken());
}})
)
)
 {if (!hasContent)
  $result = null;};
catch [RecognitionException re] {if (!hasContent)
    $result = null;
reportError(re);
recover(input,re);}

ruleIoDeclaration returns [EObject result]
@init {boolean hasContent = false;}
:
			{
				$result = factory.create("", "IoDeclaration");
			 }
(({ptm.createNode(((EObject)((EObject)((EObject)xtextfile.eContents().get(2)).eContents().get(1)).eContents().get(0)));}temp_DeclType=
ruleDeclType{if (temp_DeclType != null) {
  hasContent = true;
  ptm.setModelElement(temp_DeclType);
  factory.set($result,"type",convert(temp_DeclType),false);
  ptm.ruleFinished(temp_DeclType);
} else {
  ptm.destroyNode();
}
}
)

({skipCurrentToken = false;}
RULE_ID{if (!skipCurrentToken) {
  hasContent = true;
  Token temp = getLastToken();
  ptm.createNode(((EObject)((EObject)((EObject)xtextfile.eContents().get(2)).eContents().get(1)).eContents().get(1)));
  factory.set($result,"name",convert(temp),false);
  ptm.ruleFinished(temp);
}}
)

(({skipCurrentToken = false;}':'{if (!skipCurrentToken) {
  hasContent = true;
  ptm.createNode(((EObject)((EObject)((EObject)((EObject)xtextfile.eContents().get(2)).eContents().get(1)).eContents().get(2)).eContents().get(0)));
  ptm.ruleFinished(getLastToken());
}})

({skipCurrentToken = false;}'='{if (!skipCurrentToken) {
  hasContent = true;
  ptm.createNode(((EObject)((EObject)((EObject)((EObject)xtextfile.eContents().get(2)).eContents().get(1)).eContents().get(2)).eContents().get(1)));
  ptm.ruleFinished(getLastToken());
}})

({skipCurrentToken = false;}
RULE_INT{if (!skipCurrentToken) {
  hasContent = true;
  Token temp = getLastToken();
  ptm.createNode(((EObject)((EObject)((EObject)((EObject)xtextfile.eContents().get(2)).eContents().get(1)).eContents().get(2)).eContents().get(2)));
  factory.set($result,"initialValue",convert(temp),false);
  ptm.ruleFinished(temp);
}}
)
)?

(({skipCurrentToken = false;}':'{if (!skipCurrentToken) {
  hasContent = true;
  ptm.createNode(((EObject)((EObject)((EObject)((EObject)xtextfile.eContents().get(2)).eContents().get(1)).eContents().get(3)).eContents().get(0)));
  ptm.ruleFinished(getLastToken());
}})

({ptm.createNode(((EObject)((EObject)((EObject)((EObject)xtextfile.eContents().get(2)).eContents().get(1)).eContents().get(3)).eContents().get(1)));}temp_VType=
ruleVType{if (temp_VType != null) {
  hasContent = true;
  ptm.setModelElement(temp_VType);
  factory.set($result,"valueType",convert(temp_VType),false);
  ptm.ruleFinished(temp_VType);
} else {
  ptm.destroyNode();
}
}
)
)?

({skipCurrentToken = false;}';'{if (!skipCurrentToken) {
  hasContent = true;
  ptm.createNode(((EObject)((EObject)((EObject)xtextfile.eContents().get(2)).eContents().get(1)).eContents().get(4)));
  ptm.ruleFinished(getLastToken());
}})
)
 {if (!hasContent)
  $result = null;};
catch [RecognitionException re] {if (!hasContent)
    $result = null;
reportError(re);
recover(input,re);}

ruleDeclType returns [EObject result]
@init {boolean hasContent = false;}
:
			{
				$result = factory.create("", "DeclType");
			 }
(({skipCurrentToken = false;}'input'{if (!skipCurrentToken) {
  hasContent = true;
  ptm.createNode(((EObject)((EObject)((EObject)xtextfile.eContents().get(3)).eContents().get(1)).eContents().get(0)));
  ptm.ruleFinished(getLastToken());
}})
	|
({skipCurrentToken = false;}'output'{if (!skipCurrentToken) {
  hasContent = true;
  ptm.createNode(((EObject)((EObject)((EObject)xtextfile.eContents().get(3)).eContents().get(1)).eContents().get(1)));
  ptm.ruleFinished(getLastToken());
}})
)
 {if (!hasContent)
  $result = null;};
catch [RecognitionException re] {if (!hasContent)
    $result = null;
reportError(re);
recover(input,re);}

ruleVType returns [EObject result]
@init {boolean hasContent = false;}
:
			{
				$result = factory.create("", "VType");
			 }
(({skipCurrentToken = false;}'boolean'{if (!skipCurrentToken) {
  hasContent = true;
  ptm.createNode(((EObject)((EObject)((EObject)xtextfile.eContents().get(4)).eContents().get(1)).eContents().get(0)));
  ptm.ruleFinished(getLastToken());
}})
	|
({skipCurrentToken = false;}'double'{if (!skipCurrentToken) {
  hasContent = true;
  ptm.createNode(((EObject)((EObject)((EObject)xtextfile.eContents().get(4)).eContents().get(1)).eContents().get(1)));
  ptm.ruleFinished(getLastToken());
}})
	|
({skipCurrentToken = false;}'float'{if (!skipCurrentToken) {
  hasContent = true;
  ptm.createNode(((EObject)((EObject)((EObject)xtextfile.eContents().get(4)).eContents().get(1)).eContents().get(2)));
  ptm.ruleFinished(getLastToken());
}})
	|
({skipCurrentToken = false;}'integer'{if (!skipCurrentToken) {
  hasContent = true;
  ptm.createNode(((EObject)((EObject)((EObject)xtextfile.eContents().get(4)).eContents().get(1)).eContents().get(3)));
  ptm.ruleFinished(getLastToken());
}})
)
 {if (!hasContent)
  $result = null;};
catch [RecognitionException re] {if (!hasContent)
    $result = null;
reportError(re);
recover(input,re);}

ruleState returns [EObject result]
@init {boolean hasContent = false;}
:
			{
				$result = factory.create("", "State");
			 }
(({skipCurrentToken = false;}
RULE_ID{if (!skipCurrentToken) {
  hasContent = true;
  Token temp = getLastToken();
  ptm.createNode(((EObject)((EObject)((EObject)xtextfile.eContents().get(5)).eContents().get(1)).eContents().get(0)));
  factory.set($result,"name",convert(temp),false);
  ptm.ruleFinished(temp);
}}
)

(({skipCurrentToken = false;}'['{if (!skipCurrentToken) {
  hasContent = true;
  ptm.createNode(((EObject)((EObject)((EObject)((EObject)xtextfile.eContents().get(5)).eContents().get(1)).eContents().get(1)).eContents().get(0)));
  ptm.ruleFinished(getLastToken());
}})

({ptm.createNode(((EObject)((EObject)((EObject)((EObject)xtextfile.eContents().get(5)).eContents().get(1)).eContents().get(1)).eContents().get(1)));}temp_StateArgument=
ruleStateArgument{if (temp_StateArgument != null) {
  hasContent = true;
  ptm.setModelElement(temp_StateArgument);
  factory.add($result,"arguments",convert(temp_StateArgument),false);
  ptm.ruleFinished(temp_StateArgument);
} else {
  ptm.destroyNode();
}
}
)*

({skipCurrentToken = false;}']'{if (!skipCurrentToken) {
  hasContent = true;
  ptm.createNode(((EObject)((EObject)((EObject)((EObject)xtextfile.eContents().get(5)).eContents().get(1)).eContents().get(1)).eContents().get(2)));
  ptm.ruleFinished(getLastToken());
}})
)?

(({skipCurrentToken = false;}'{'{if (!skipCurrentToken) {
  hasContent = true;
  ptm.createNode(((EObject)((EObject)((EObject)((EObject)xtextfile.eContents().get(5)).eContents().get(1)).eContents().get(2)).eContents().get(0)));
  ptm.ruleFinished(getLastToken());
}})

({ptm.createNode(((EObject)((EObject)((EObject)((EObject)xtextfile.eContents().get(5)).eContents().get(1)).eContents().get(2)).eContents().get(1)));}temp_Element=
ruleElement{if (temp_Element != null) {
  hasContent = true;
  ptm.setModelElement(temp_Element);
  factory.add($result,"elements",convert(temp_Element),false);
  ptm.ruleFinished(temp_Element);
} else {
  ptm.destroyNode();
}
}
)*

({skipCurrentToken = false;}'}'{if (!skipCurrentToken) {
  hasContent = true;
  ptm.createNode(((EObject)((EObject)((EObject)((EObject)xtextfile.eContents().get(5)).eContents().get(1)).eContents().get(2)).eContents().get(2)));
  ptm.ruleFinished(getLastToken());
}})
)?

({skipCurrentToken = false;}';'{if (!skipCurrentToken) {
  hasContent = true;
  ptm.createNode(((EObject)((EObject)((EObject)xtextfile.eContents().get(5)).eContents().get(1)).eContents().get(3)));
  ptm.ruleFinished(getLastToken());
}})
)
 {if (!hasContent)
  $result = null;};
catch [RecognitionException re] {if (!hasContent)
    $result = null;
reportError(re);
recover(input,re);}

ruleStateArgument returns [EObject result]
@init {boolean hasContent = false;}
:
			{
				$result = factory.create("", "StateArgument");
			 }
((({skipCurrentToken = false;}'label'{if (!skipCurrentToken) {
  hasContent = true;
  ptm.createNode(((EObject)((EObject)((EObject)((EObject)xtextfile.eContents().get(6)).eContents().get(1)).eContents().get(0)).eContents().get(0)));
  ptm.ruleFinished(getLastToken());
}})

({skipCurrentToken = false;}'='{if (!skipCurrentToken) {
  hasContent = true;
  ptm.createNode(((EObject)((EObject)((EObject)((EObject)xtextfile.eContents().get(6)).eContents().get(1)).eContents().get(0)).eContents().get(1)));
  ptm.ruleFinished(getLastToken());
}})

({skipCurrentToken = false;}
RULE_STRING{if (!skipCurrentToken) {
  hasContent = true;
  Token temp = getLastToken();
  ptm.createNode(((EObject)((EObject)((EObject)((EObject)xtextfile.eContents().get(6)).eContents().get(1)).eContents().get(0)).eContents().get(2)));
  factory.set($result,"label",convert(temp),false);
  ptm.ruleFinished(temp);
}}
)

({skipCurrentToken = false;}';'{if (!skipCurrentToken) {
  hasContent = true;
  ptm.createNode(((EObject)((EObject)((EObject)((EObject)xtextfile.eContents().get(6)).eContents().get(1)).eContents().get(0)).eContents().get(3)));
  ptm.ruleFinished(getLastToken());
}})?
)
	|
(({skipCurrentToken = false;}'type'{if (!skipCurrentToken) {
  hasContent = true;
  ptm.createNode(((EObject)((EObject)((EObject)((EObject)xtextfile.eContents().get(6)).eContents().get(1)).eContents().get(1)).eContents().get(0)));
  ptm.ruleFinished(getLastToken());
}})

({skipCurrentToken = false;}'='{if (!skipCurrentToken) {
  hasContent = true;
  ptm.createNode(((EObject)((EObject)((EObject)((EObject)xtextfile.eContents().get(6)).eContents().get(1)).eContents().get(1)).eContents().get(1)));
  ptm.ruleFinished(getLastToken());
}})

({ptm.createNode(((EObject)((EObject)((EObject)((EObject)xtextfile.eContents().get(6)).eContents().get(1)).eContents().get(1)).eContents().get(2)));}temp_Pseudo=
rulePseudo{if (temp_Pseudo != null) {
  hasContent = true;
  ptm.setModelElement(temp_Pseudo);
  factory.set($result,"type",convert(temp_Pseudo),false);
  ptm.ruleFinished(temp_Pseudo);
} else {
  ptm.destroyNode();
}
}
)

({skipCurrentToken = false;}';'{if (!skipCurrentToken) {
  hasContent = true;
  ptm.createNode(((EObject)((EObject)((EObject)((EObject)xtextfile.eContents().get(6)).eContents().get(1)).eContents().get(1)).eContents().get(3)));
  ptm.ruleFinished(getLastToken());
}})?
)
)
 {if (!hasContent)
  $result = null;};
catch [RecognitionException re] {if (!hasContent)
    $result = null;
reportError(re);
recover(input,re);}

rulePseudo returns [EObject result]
@init {boolean hasContent = false;}
:
			{
				$result = factory.create("", "Pseudo");
			 }
(({skipCurrentToken = false;}'final'{if (!skipCurrentToken) {
  hasContent = true;
  ptm.createNode(((EObject)((EObject)((EObject)xtextfile.eContents().get(7)).eContents().get(1)).eContents().get(0)));
  ptm.ruleFinished(getLastToken());
}})
	|
({skipCurrentToken = false;}'initial'{if (!skipCurrentToken) {
  hasContent = true;
  ptm.createNode(((EObject)((EObject)((EObject)xtextfile.eContents().get(7)).eContents().get(1)).eContents().get(1)));
  ptm.ruleFinished(getLastToken());
}})
	|
({skipCurrentToken = false;}'pseudo'{if (!skipCurrentToken) {
  hasContent = true;
  ptm.createNode(((EObject)((EObject)((EObject)xtextfile.eContents().get(7)).eContents().get(1)).eContents().get(2)));
  ptm.ruleFinished(getLastToken());
}})
)
 {if (!hasContent)
  $result = null;};
catch [RecognitionException re] {if (!hasContent)
    $result = null;
reportError(re);
recover(input,re);}

ruleElement returns [EObject result]
@init {boolean hasContent = false;}
:
			{
				$result = factory.create("", "Element");
			 }
(({ptm.createNode(((EObject)((EObject)((EObject)xtextfile.eContents().get(8)).eContents().get(1)).eContents().get(0)));}
temp_State=ruleState
{if (temp_State != null) {
  hasContent = true;
  ptm.setModelElement(temp_State);
  ptm.ruleFinished(temp_State);
  $result=temp_State;
} else {
  ptm.destroyNode();
}
}
)
	|
({ptm.createNode(((EObject)((EObject)((EObject)xtextfile.eContents().get(8)).eContents().get(1)).eContents().get(1)));}
temp_Transition=ruleTransition
{if (temp_Transition != null) {
  hasContent = true;
  ptm.setModelElement(temp_Transition);
  ptm.ruleFinished(temp_Transition);
  $result=temp_Transition;
} else {
  ptm.destroyNode();
}
}
)
	|
({skipCurrentToken = false;}'||'{if (!skipCurrentToken) {
  hasContent = true;
  ptm.createNode(((EObject)((EObject)((EObject)xtextfile.eContents().get(8)).eContents().get(1)).eContents().get(2)));
  ptm.ruleFinished(getLastToken());
}})
)
 {if (!hasContent)
  $result = null;};
catch [RecognitionException re] {if (!hasContent)
    $result = null;
reportError(re);
recover(input,re);}

ruleTransition returns [EObject result]
@init {boolean hasContent = false;}
:
			{
				$result = factory.create("", "Transition");
			 }
(({skipCurrentToken = false;}
RULE_ID{if (!skipCurrentToken) {
  hasContent = true;
  Token temp = getLastToken();
  ptm.createNode(((EObject)((EObject)((EObject)xtextfile.eContents().get(9)).eContents().get(1)).eContents().get(0)));
  factory.set($result,"source",convert(temp),false);
  ptm.ruleFinished(temp);
}}
)?

({skipCurrentToken = false;}'->'{if (!skipCurrentToken) {
  hasContent = true;
  ptm.createNode(((EObject)((EObject)((EObject)xtextfile.eContents().get(9)).eContents().get(1)).eContents().get(1)));
  ptm.ruleFinished(getLastToken());
}})

({skipCurrentToken = false;}
RULE_ID{if (!skipCurrentToken) {
  hasContent = true;
  Token temp = getLastToken();
  ptm.createNode(((EObject)((EObject)((EObject)xtextfile.eContents().get(9)).eContents().get(1)).eContents().get(2)));
  factory.set($result,"target",convert(temp),false);
  ptm.ruleFinished(temp);
}}
)

(({skipCurrentToken = false;}'['{if (!skipCurrentToken) {
  hasContent = true;
  ptm.createNode(((EObject)((EObject)((EObject)((EObject)xtextfile.eContents().get(9)).eContents().get(1)).eContents().get(3)).eContents().get(0)));
  ptm.ruleFinished(getLastToken());
}})

({ptm.createNode(((EObject)((EObject)((EObject)((EObject)xtextfile.eContents().get(9)).eContents().get(1)).eContents().get(3)).eContents().get(1)));}temp_TransArgument=
ruleTransArgument{if (temp_TransArgument != null) {
  hasContent = true;
  ptm.setModelElement(temp_TransArgument);
  factory.add($result,"arguments",convert(temp_TransArgument),false);
  ptm.ruleFinished(temp_TransArgument);
} else {
  ptm.destroyNode();
}
}
)*

({skipCurrentToken = false;}']'{if (!skipCurrentToken) {
  hasContent = true;
  ptm.createNode(((EObject)((EObject)((EObject)((EObject)xtextfile.eContents().get(9)).eContents().get(1)).eContents().get(3)).eContents().get(2)));
  ptm.ruleFinished(getLastToken());
}})
)?

({skipCurrentToken = false;}';'{if (!skipCurrentToken) {
  hasContent = true;
  ptm.createNode(((EObject)((EObject)((EObject)xtextfile.eContents().get(9)).eContents().get(1)).eContents().get(4)));
  ptm.ruleFinished(getLastToken());
}})
)
 {if (!hasContent)
  $result = null;};
catch [RecognitionException re] {if (!hasContent)
    $result = null;
reportError(re);
recover(input,re);}

ruleTransArgument returns [EObject result]
@init {boolean hasContent = false;}
:
			{
				$result = factory.create("", "TransArgument");
			 }
((({skipCurrentToken = false;}'label'{if (!skipCurrentToken) {
  hasContent = true;
  ptm.createNode(((EObject)((EObject)((EObject)((EObject)xtextfile.eContents().get(10)).eContents().get(1)).eContents().get(0)).eContents().get(0)));
  ptm.ruleFinished(getLastToken());
}})

({skipCurrentToken = false;}'='{if (!skipCurrentToken) {
  hasContent = true;
  ptm.createNode(((EObject)((EObject)((EObject)((EObject)xtextfile.eContents().get(10)).eContents().get(1)).eContents().get(0)).eContents().get(1)));
  ptm.ruleFinished(getLastToken());
}})

({ptm.createNode(((EObject)((EObject)((EObject)((EObject)xtextfile.eContents().get(10)).eContents().get(1)).eContents().get(0)).eContents().get(2)));}temp_Action=
ruleAction{if (temp_Action != null) {
  hasContent = true;
  ptm.setModelElement(temp_Action);
  factory.set($result,"label",convert(temp_Action),false);
  ptm.ruleFinished(temp_Action);
} else {
  ptm.destroyNode();
}
}
)

({skipCurrentToken = false;}';'{if (!skipCurrentToken) {
  hasContent = true;
  ptm.createNode(((EObject)((EObject)((EObject)((EObject)xtextfile.eContents().get(10)).eContents().get(1)).eContents().get(0)).eContents().get(3)));
  ptm.ruleFinished(getLastToken());
}})?
)
	|
(({skipCurrentToken = false;}'type'{if (!skipCurrentToken) {
  hasContent = true;
  ptm.createNode(((EObject)((EObject)((EObject)((EObject)xtextfile.eContents().get(10)).eContents().get(1)).eContents().get(1)).eContents().get(0)));
  ptm.ruleFinished(getLastToken());
}})

({skipCurrentToken = false;}'='{if (!skipCurrentToken) {
  hasContent = true;
  ptm.createNode(((EObject)((EObject)((EObject)((EObject)xtextfile.eContents().get(10)).eContents().get(1)).eContents().get(1)).eContents().get(1)));
  ptm.ruleFinished(getLastToken());
}})

({ptm.createNode(((EObject)((EObject)((EObject)((EObject)xtextfile.eContents().get(10)).eContents().get(1)).eContents().get(1)).eContents().get(2)));}temp_TransType=
ruleTransType{if (temp_TransType != null) {
  hasContent = true;
  ptm.setModelElement(temp_TransType);
  factory.set($result,"type",convert(temp_TransType),false);
  ptm.ruleFinished(temp_TransType);
} else {
  ptm.destroyNode();
}
}
)

({skipCurrentToken = false;}';'{if (!skipCurrentToken) {
  hasContent = true;
  ptm.createNode(((EObject)((EObject)((EObject)((EObject)xtextfile.eContents().get(10)).eContents().get(1)).eContents().get(1)).eContents().get(3)));
  ptm.ruleFinished(getLastToken());
}})?
)
	|
(({skipCurrentToken = false;}'priority'{if (!skipCurrentToken) {
  hasContent = true;
  ptm.createNode(((EObject)((EObject)((EObject)((EObject)xtextfile.eContents().get(10)).eContents().get(1)).eContents().get(2)).eContents().get(0)));
  ptm.ruleFinished(getLastToken());
}})

({skipCurrentToken = false;}'='{if (!skipCurrentToken) {
  hasContent = true;
  ptm.createNode(((EObject)((EObject)((EObject)((EObject)xtextfile.eContents().get(10)).eContents().get(1)).eContents().get(2)).eContents().get(1)));
  ptm.ruleFinished(getLastToken());
}})

({skipCurrentToken = false;}
RULE_INT{if (!skipCurrentToken) {
  hasContent = true;
  Token temp = getLastToken();
  ptm.createNode(((EObject)((EObject)((EObject)((EObject)xtextfile.eContents().get(10)).eContents().get(1)).eContents().get(2)).eContents().get(2)));
  factory.set($result,"prio",convert(temp),false);
  ptm.ruleFinished(temp);
}}
)

({skipCurrentToken = false;}';'{if (!skipCurrentToken) {
  hasContent = true;
  ptm.createNode(((EObject)((EObject)((EObject)((EObject)xtextfile.eContents().get(10)).eContents().get(1)).eContents().get(2)).eContents().get(3)));
  ptm.ruleFinished(getLastToken());
}})?
)
)
 {if (!hasContent)
  $result = null;};
catch [RecognitionException re] {if (!hasContent)
    $result = null;
reportError(re);
recover(input,re);}

ruleTransType returns [EObject result]
:
        temp_weakabortion=ruleweakabortion {$result=temp_weakabortion;}	|        temp_strongabortion=rulestrongabortion {$result=temp_strongabortion;}	|        temp_normaltermination=rulenormaltermination {$result=temp_normaltermination;}	;

ruleweakabortion returns [EObject result]
@init {boolean hasContent = false;}
:
			{
				$result = factory.create("", "weakabortion");
			 }
(({skipCurrentToken = false;}'weakAbortion'{if (!skipCurrentToken) {
  hasContent = true;
  ptm.createNode(((EObject)((EObject)((EObject)xtextfile.eContents().get(12)).eContents().get(1)).eContents().get(0)));
  ptm.ruleFinished(getLastToken());
}})
	|
({skipCurrentToken = false;}'wa'{if (!skipCurrentToken) {
  hasContent = true;
  ptm.createNode(((EObject)((EObject)((EObject)xtextfile.eContents().get(12)).eContents().get(1)).eContents().get(1)));
  ptm.ruleFinished(getLastToken());
}})
)
 {if (!hasContent)
  $result = null;};
catch [RecognitionException re] {if (!hasContent)
    $result = null;
reportError(re);
recover(input,re);}

rulestrongabortion returns [EObject result]
@init {boolean hasContent = false;}
:
			{
				$result = factory.create("", "strongabortion");
			 }
(({skipCurrentToken = false;}'strongAbortion'{if (!skipCurrentToken) {
  hasContent = true;
  ptm.createNode(((EObject)((EObject)((EObject)xtextfile.eContents().get(13)).eContents().get(1)).eContents().get(0)));
  ptm.ruleFinished(getLastToken());
}})
	|
({skipCurrentToken = false;}'sa'{if (!skipCurrentToken) {
  hasContent = true;
  ptm.createNode(((EObject)((EObject)((EObject)xtextfile.eContents().get(13)).eContents().get(1)).eContents().get(1)));
  ptm.ruleFinished(getLastToken());
}})
)
 {if (!hasContent)
  $result = null;};
catch [RecognitionException re] {if (!hasContent)
    $result = null;
reportError(re);
recover(input,re);}

rulenormaltermination returns [EObject result]
@init {boolean hasContent = false;}
:
			{
				$result = factory.create("", "normaltermination");
			 }
(({skipCurrentToken = false;}'normalTermination'{if (!skipCurrentToken) {
  hasContent = true;
  ptm.createNode(((EObject)((EObject)((EObject)xtextfile.eContents().get(14)).eContents().get(1)).eContents().get(0)));
  ptm.ruleFinished(getLastToken());
}})
	|
({skipCurrentToken = false;}'nt'{if (!skipCurrentToken) {
  hasContent = true;
  ptm.createNode(((EObject)((EObject)((EObject)xtextfile.eContents().get(14)).eContents().get(1)).eContents().get(1)));
  ptm.ruleFinished(getLastToken());
}})
)
 {if (!hasContent)
  $result = null;};
catch [RecognitionException re] {if (!hasContent)
    $result = null;
reportError(re);
recover(input,re);}

ruleAction returns [EObject result]
@init {boolean hasContent = false;}
:
			{
				$result = factory.create("", "Action");
			 }
(({ptm.createNode(((EObject)((EObject)((EObject)xtextfile.eContents().get(15)).eContents().get(1)).eContents().get(0)));}temp_Trigger=
ruleTrigger{if (temp_Trigger != null) {
  hasContent = true;
  ptm.setModelElement(temp_Trigger);
  factory.set($result,"trigger",convert(temp_Trigger),false);
  ptm.ruleFinished(temp_Trigger);
} else {
  ptm.destroyNode();
}
}
)

({skipCurrentToken = false;}'/'{if (!skipCurrentToken) {
  hasContent = true;
  ptm.createNode(((EObject)((EObject)((EObject)xtextfile.eContents().get(15)).eContents().get(1)).eContents().get(1)));
  ptm.ruleFinished(getLastToken());
}})

({ptm.createNode(((EObject)((EObject)((EObject)xtextfile.eContents().get(15)).eContents().get(1)).eContents().get(2)));}temp_Emission=
ruleEmission{if (temp_Emission != null) {
  hasContent = true;
  ptm.setModelElement(temp_Emission);
  factory.add($result,"effects",convert(temp_Emission),false);
  ptm.ruleFinished(temp_Emission);
} else {
  ptm.destroyNode();
}
}
)*
)
 {if (!hasContent)
  $result = null;};
catch [RecognitionException re] {if (!hasContent)
    $result = null;
reportError(re);
recover(input,re);}

ruleEmission returns [EObject result]
@init {boolean hasContent = false;}
:
			{
				$result = factory.create("", "Emission");
			 }
(({ptm.createNode(((EObject)((EObject)((EObject)xtextfile.eContents().get(16)).eContents().get(1)).eContents().get(0)));}temp_Signal=
ruleSignal{if (temp_Signal != null) {
  hasContent = true;
  ptm.setModelElement(temp_Signal);
  factory.set($result,"signal",convert(temp_Signal),false);
  ptm.ruleFinished(temp_Signal);
} else {
  ptm.destroyNode();
}
}
)

(({skipCurrentToken = false;}'('{if (!skipCurrentToken) {
  hasContent = true;
  ptm.createNode(((EObject)((EObject)((EObject)((EObject)xtextfile.eContents().get(16)).eContents().get(1)).eContents().get(1)).eContents().get(0)));
  ptm.ruleFinished(getLastToken());
}})

({ptm.createNode(((EObject)((EObject)((EObject)((EObject)xtextfile.eContents().get(16)).eContents().get(1)).eContents().get(1)).eContents().get(1)));}temp_Value=
ruleValue{if (temp_Value != null) {
  hasContent = true;
  ptm.setModelElement(temp_Value);
  factory.set($result,"newValue",convert(temp_Value),false);
  ptm.ruleFinished(temp_Value);
} else {
  ptm.destroyNode();
}
}
)

({skipCurrentToken = false;}')'{if (!skipCurrentToken) {
  hasContent = true;
  ptm.createNode(((EObject)((EObject)((EObject)((EObject)xtextfile.eContents().get(16)).eContents().get(1)).eContents().get(1)).eContents().get(2)));
  ptm.ruleFinished(getLastToken());
}})
)?
)
 {if (!hasContent)
  $result = null;};
catch [RecognitionException re] {if (!hasContent)
    $result = null;
reportError(re);
recover(input,re);}

ruleValue returns [EObject result]
@init {boolean hasContent = false;}
:
			{
				$result = factory.create("", "Value");
			 }
({skipCurrentToken = false;}
RULE_INT{if (!skipCurrentToken) {
  hasContent = true;
  Token temp = getLastToken();
  ptm.createNode(((EObject)((EObject)xtextfile.eContents().get(17)).eContents().get(1)));
  factory.set($result,"value",convert(temp),false);
  ptm.ruleFinished(temp);
}}
)
 {if (!hasContent)
  $result = null;};
catch [RecognitionException re] {if (!hasContent)
    $result = null;
reportError(re);
recover(input,re);}

ruleSignal returns [EObject result]
@init {boolean hasContent = false;}
:
			{
				$result = factory.create("", "Signal");
			 }
(({skipCurrentToken = false;}
'I'{if (!skipCurrentToken) {
  hasContent = true;
  Token temp = getLastToken();
  ptm.createNode(((EObject)((EObject)((EObject)xtextfile.eContents().get(18)).eContents().get(1)).eContents().get(0)));
  factory.set($result,"isInput",convert(temp),false);
  ptm.ruleFinished(temp);
}}
)?

({skipCurrentToken = false;}
'O'{if (!skipCurrentToken) {
  hasContent = true;
  Token temp = getLastToken();
  ptm.createNode(((EObject)((EObject)((EObject)xtextfile.eContents().get(18)).eContents().get(1)).eContents().get(1)));
  factory.set($result,"isOutput",convert(temp),false);
  ptm.ruleFinished(temp);
}}
)?

({skipCurrentToken = false;}
'L'{if (!skipCurrentToken) {
  hasContent = true;
  Token temp = getLastToken();
  ptm.createNode(((EObject)((EObject)((EObject)xtextfile.eContents().get(18)).eContents().get(1)).eContents().get(2)));
  factory.set($result,"isLocal",convert(temp),false);
  ptm.ruleFinished(temp);
}}
)?

({skipCurrentToken = false;}
RULE_ID{if (!skipCurrentToken) {
  hasContent = true;
  Token temp = getLastToken();
  ptm.createNode(((EObject)((EObject)((EObject)xtextfile.eContents().get(18)).eContents().get(1)).eContents().get(3)));
  factory.set($result,"name",convert(temp),false);
  ptm.ruleFinished(temp);
}}
)

(({skipCurrentToken = false;}'('{if (!skipCurrentToken) {
  hasContent = true;
  ptm.createNode(((EObject)((EObject)((EObject)((EObject)xtextfile.eContents().get(18)).eContents().get(1)).eContents().get(4)).eContents().get(0)));
  ptm.ruleFinished(getLastToken());
}})

({ptm.createNode(((EObject)((EObject)((EObject)((EObject)xtextfile.eContents().get(18)).eContents().get(1)).eContents().get(4)).eContents().get(1)));}temp_Value=
ruleValue{if (temp_Value != null) {
  hasContent = true;
  ptm.setModelElement(temp_Value);
  factory.set($result,"value",convert(temp_Value),false);
  ptm.ruleFinished(temp_Value);
} else {
  ptm.destroyNode();
}
}
)

({skipCurrentToken = false;}')'{if (!skipCurrentToken) {
  hasContent = true;
  ptm.createNode(((EObject)((EObject)((EObject)((EObject)xtextfile.eContents().get(18)).eContents().get(1)).eContents().get(4)).eContents().get(2)));
  ptm.ruleFinished(getLastToken());
}})
)?
)
 {if (!hasContent)
  $result = null;};
catch [RecognitionException re] {if (!hasContent)
    $result = null;
reportError(re);
recover(input,re);}

ruleTrigger returns [EObject result]
@init {boolean hasContent = false;}
:
			{
				$result = factory.create("", "Trigger");
			 }
(({ptm.createNode(((EObject)((EObject)((EObject)xtextfile.eContents().get(19)).eContents().get(1)).eContents().get(0)));}temp_Signal=
ruleSignal{if (temp_Signal != null) {
  hasContent = true;
  ptm.setModelElement(temp_Signal);
  factory.add($result,"literals",convert(temp_Signal),false);
  ptm.ruleFinished(temp_Signal);
} else {
  ptm.destroyNode();
}
}
)
	|
(({ptm.createNode(((EObject)((EObject)((EObject)((EObject)xtextfile.eContents().get(19)).eContents().get(1)).eContents().get(1)).eContents().get(0)));}temp_Signal=
ruleSignal{if (temp_Signal != null) {
  hasContent = true;
  ptm.setModelElement(temp_Signal);
  factory.add($result,"literals",convert(temp_Signal),false);
  ptm.ruleFinished(temp_Signal);
} else {
  ptm.destroyNode();
}
}
)

({ptm.createNode(((EObject)((EObject)((EObject)((EObject)xtextfile.eContents().get(19)).eContents().get(1)).eContents().get(1)).eContents().get(1)));}temp_BinaryOp=
ruleBinaryOp{if (temp_BinaryOp != null) {
  hasContent = true;
  ptm.setModelElement(temp_BinaryOp);
  factory.add($result,"operator",convert(temp_BinaryOp),false);
  ptm.ruleFinished(temp_BinaryOp);
} else {
  ptm.destroyNode();
}
}
)

({ptm.createNode(((EObject)((EObject)((EObject)((EObject)xtextfile.eContents().get(19)).eContents().get(1)).eContents().get(1)).eContents().get(2)));}temp_Signal=
ruleSignal{if (temp_Signal != null) {
  hasContent = true;
  ptm.setModelElement(temp_Signal);
  factory.add($result,"literals",convert(temp_Signal),false);
  ptm.ruleFinished(temp_Signal);
} else {
  ptm.destroyNode();
}
}
)
)
	|
(({skipCurrentToken = false;}'('{if (!skipCurrentToken) {
  hasContent = true;
  ptm.createNode(((EObject)((EObject)((EObject)((EObject)xtextfile.eContents().get(19)).eContents().get(1)).eContents().get(2)).eContents().get(0)));
  ptm.ruleFinished(getLastToken());
}})

({ptm.createNode(((EObject)((EObject)((EObject)((EObject)xtextfile.eContents().get(19)).eContents().get(1)).eContents().get(2)).eContents().get(1)));}temp_Trigger=
ruleTrigger{if (temp_Trigger != null) {
  hasContent = true;
  ptm.setModelElement(temp_Trigger);
  factory.add($result,"subTrigger",convert(temp_Trigger),false);
  ptm.ruleFinished(temp_Trigger);
} else {
  ptm.destroyNode();
}
}
)

({skipCurrentToken = false;}')'{if (!skipCurrentToken) {
  hasContent = true;
  ptm.createNode(((EObject)((EObject)((EObject)((EObject)xtextfile.eContents().get(19)).eContents().get(1)).eContents().get(2)).eContents().get(2)));
  ptm.ruleFinished(getLastToken());
}})

({ptm.createNode(((EObject)((EObject)((EObject)((EObject)xtextfile.eContents().get(19)).eContents().get(1)).eContents().get(2)).eContents().get(3)));}temp_BinaryOp=
ruleBinaryOp{if (temp_BinaryOp != null) {
  hasContent = true;
  ptm.setModelElement(temp_BinaryOp);
  factory.add($result,"operator",convert(temp_BinaryOp),false);
  ptm.ruleFinished(temp_BinaryOp);
} else {
  ptm.destroyNode();
}
}
)

({skipCurrentToken = false;}'('{if (!skipCurrentToken) {
  hasContent = true;
  ptm.createNode(((EObject)((EObject)((EObject)((EObject)xtextfile.eContents().get(19)).eContents().get(1)).eContents().get(2)).eContents().get(4)));
  ptm.ruleFinished(getLastToken());
}})

({ptm.createNode(((EObject)((EObject)((EObject)((EObject)xtextfile.eContents().get(19)).eContents().get(1)).eContents().get(2)).eContents().get(5)));}temp_Trigger=
ruleTrigger{if (temp_Trigger != null) {
  hasContent = true;
  ptm.setModelElement(temp_Trigger);
  factory.add($result,"subTrigger",convert(temp_Trigger),false);
  ptm.ruleFinished(temp_Trigger);
} else {
  ptm.destroyNode();
}
}
)

({skipCurrentToken = false;}')'{if (!skipCurrentToken) {
  hasContent = true;
  ptm.createNode(((EObject)((EObject)((EObject)((EObject)xtextfile.eContents().get(19)).eContents().get(1)).eContents().get(2)).eContents().get(6)));
  ptm.ruleFinished(getLastToken());
}})
)
)
 {if (!hasContent)
  $result = null;};
catch [RecognitionException re] {if (!hasContent)
    $result = null;
reportError(re);
recover(input,re);}

ruleBinaryOp returns [EObject result]
@init {boolean hasContent = false;}
:
			{
				$result = factory.create("", "BinaryOp");
			 }
(({skipCurrentToken = false;}'EQ'{if (!skipCurrentToken) {
  hasContent = true;
  ptm.createNode(((EObject)((EObject)((EObject)xtextfile.eContents().get(21)).eContents().get(1)).eContents().get(0)));
  ptm.ruleFinished(getLastToken());
}})
	|
({skipCurrentToken = false;}'LT'{if (!skipCurrentToken) {
  hasContent = true;
  ptm.createNode(((EObject)((EObject)((EObject)xtextfile.eContents().get(21)).eContents().get(1)).eContents().get(1)));
  ptm.ruleFinished(getLastToken());
}})
	|
({skipCurrentToken = false;}'LEQ'{if (!skipCurrentToken) {
  hasContent = true;
  ptm.createNode(((EObject)((EObject)((EObject)xtextfile.eContents().get(21)).eContents().get(1)).eContents().get(2)));
  ptm.ruleFinished(getLastToken());
}})
	|
({skipCurrentToken = false;}'AND'{if (!skipCurrentToken) {
  hasContent = true;
  ptm.createNode(((EObject)((EObject)((EObject)xtextfile.eContents().get(21)).eContents().get(1)).eContents().get(3)));
  ptm.ruleFinished(getLastToken());
}})
	|
({skipCurrentToken = false;}'OR'{if (!skipCurrentToken) {
  hasContent = true;
  ptm.createNode(((EObject)((EObject)((EObject)xtextfile.eContents().get(21)).eContents().get(1)).eContents().get(4)));
  ptm.ruleFinished(getLastToken());
}})
	|
({skipCurrentToken = false;}'ADD'{if (!skipCurrentToken) {
  hasContent = true;
  ptm.createNode(((EObject)((EObject)((EObject)xtextfile.eContents().get(21)).eContents().get(1)).eContents().get(5)));
  ptm.ruleFinished(getLastToken());
}})
	|
({skipCurrentToken = false;}'SUB'{if (!skipCurrentToken) {
  hasContent = true;
  ptm.createNode(((EObject)((EObject)((EObject)xtextfile.eContents().get(21)).eContents().get(1)).eContents().get(6)));
  ptm.ruleFinished(getLastToken());
}})
	|
({skipCurrentToken = false;}'MULT'{if (!skipCurrentToken) {
  hasContent = true;
  ptm.createNode(((EObject)((EObject)((EObject)xtextfile.eContents().get(21)).eContents().get(1)).eContents().get(7)));
  ptm.ruleFinished(getLastToken());
}})
	|
({skipCurrentToken = false;}'DIV'{if (!skipCurrentToken) {
  hasContent = true;
  ptm.createNode(((EObject)((EObject)((EObject)xtextfile.eContents().get(21)).eContents().get(1)).eContents().get(8)));
  ptm.ruleFinished(getLastToken());
}})
)
 {if (!hasContent)
  $result = null;};
catch [RecognitionException re] {if (!hasContent)
    $result = null;
reportError(re);
recover(input,re);}

RULE_ID :

	 ('^')?('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*
	 
;

RULE_STRING :

	 '\"' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'\"') )* '\"' |
	 '\'' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'\'') )* '\''
	 
;

RULE_INT :

	 ('-')?('0'..'9')+
	 
;

RULE_WS :

	 (' '|'\t'|'\r'|'\n')+ {$channel=HIDDEN;}
	 
;

RULE_ML_COMMENT :

	 '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;}
	 
;

RULE_SL_COMMENT :

	 '//' ~('\n'|'\r')* '\r'? '\n' {$channel=HIDDEN;}
	 
;

