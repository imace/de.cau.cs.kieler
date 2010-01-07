/*
* generated by Xtext
*/
package de.cau.cs.kieler.editor.quartz.contentassist.antlr;

import java.util.Collection;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.RecognitionException;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ui.common.editor.contentassist.antlr.AbstractContentAssistParser;
import org.eclipse.xtext.ui.common.editor.contentassist.antlr.FollowElement;
import org.eclipse.xtext.ui.common.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;

import com.google.inject.Inject;

import de.cau.cs.kieler.editor.quartz.services.QuartzGrammarAccess;

public class QuartzParser extends AbstractContentAssistParser {
	
	@Inject
	private QuartzGrammarAccess grammarAccess;
	
	private Map<AbstractElement, String> nameMappings;
	
	@Override
	protected de.cau.cs.kieler.editor.quartz.contentassist.antlr.internal.InternalQuartzParser createParser() {
		de.cau.cs.kieler.editor.quartz.contentassist.antlr.internal.InternalQuartzParser result = new de.cau.cs.kieler.editor.quartz.contentassist.antlr.internal.InternalQuartzParser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}
	
	@Override
	protected String getRuleName(AbstractElement element) {
		if (nameMappings == null) {
			nameMappings = new HashMap<AbstractElement, String>() {
				private static final long serialVersionUID = 1L;
				{
					put(grammarAccess.getMacroDefAccess().getAlternatives(), "rule__MacroDef__Alternatives");
					put(grammarAccess.getStorageAccess().getAlternatives(), "rule__Storage__Alternatives");
					put(grammarAccess.getQTypeAccess().getAlternatives_0(), "rule__QType__Alternatives_0");
					put(grammarAccess.getInOutNameAccess().getAlternatives_0(), "rule__InOutName__Alternatives_0");
					put(grammarAccess.getInterfaceAccess().getAlternatives_0(), "rule__Interface__Alternatives_0");
					put(grammarAccess.getInterfaceCommaAccess().getAlternatives_0(), "rule__InterfaceComma__Alternatives_0");
					put(grammarAccess.getVerifTaskAccess().getAlternatives(), "rule__VerifTask__Alternatives");
					put(grammarAccess.getProofGoalListAccess().getAlternatives(), "rule__ProofGoalList__Alternatives");
					put(grammarAccess.getFixpointEqListAccess().getAlternatives_0(), "rule__FixpointEqList__Alternatives_0");
					put(grammarAccess.getOptUtyExprAccess().getAlternatives(), "rule__OptUtyExpr__Alternatives");
					put(grammarAccess.getUtyExprAccess().getAlternatives(), "rule__UtyExpr__Alternatives");
					put(grammarAccess.getUtyActionAccess().getAlternatives(), "rule__UtyAction__Alternatives");
					put(grammarAccess.getStmtAccess().getAlternatives_1_0(), "rule__Stmt__Alternatives_1_0");
					put(grammarAccess.getAtomicStmtAccess().getAlternatives(), "rule__AtomicStmt__Alternatives");
					put(grammarAccess.getAtomicStmtAccess().getAlternatives_9_1(), "rule__AtomicStmt__Alternatives_9_1");
					put(grammarAccess.getAtomicStmtAccess().getAlternatives_19_2_1(), "rule__AtomicStmt__Alternatives_19_2_1");
					put(grammarAccess.getNOTAccess().getAlternatives(), "rule__NOT__Alternatives");
					put(grammarAccess.getANDAccess().getAlternatives(), "rule__AND__Alternatives");
					put(grammarAccess.getXORAccess().getAlternatives(), "rule__XOR__Alternatives");
					put(grammarAccess.getORAccess().getAlternatives(), "rule__OR__Alternatives");
					put(grammarAccess.getIMPAccess().getAlternatives(), "rule__IMP__Alternatives");
					put(grammarAccess.getEQUAccess().getAlternatives(), "rule__EQU__Alternatives");
					put(grammarAccess.getQrzFileAccess().getGroup(), "rule__QrzFile__Group__0");
					put(grammarAccess.getPackagePathAccess().getGroup(), "rule__PackagePath__Group__0");
					put(grammarAccess.getImportListAccess().getGroup(), "rule__ImportList__Group__0");
					put(grammarAccess.getPointedNameAccess().getGroup(), "rule__PointedName__Group__0");
					put(grammarAccess.getPointedNameAccess().getGroup_1(), "rule__PointedName__Group_1__0");
					put(grammarAccess.getMacroDefAccess().getGroup_0(), "rule__MacroDef__Group_0__0");
					put(grammarAccess.getMacroDefAccess().getGroup_1(), "rule__MacroDef__Group_1__0");
					put(grammarAccess.getQModuleAccess().getGroup(), "rule__QModule__Group__0");
					put(grammarAccess.getQModuleAccess().getGroup_5(), "rule__QModule__Group_5__0");
					put(grammarAccess.getObservedSpecListAccess().getGroup(), "rule__ObservedSpecList__Group__0");
					put(grammarAccess.getQNameListAccess().getGroup(), "rule__QNameList__Group__0");
					put(grammarAccess.getQNameListAccess().getGroup_1(), "rule__QNameList__Group_1__0");
					put(grammarAccess.getQTypeAccess().getGroup(), "rule__QType__Group__0");
					put(grammarAccess.getQTypeAccess().getGroup_0_3(), "rule__QType__Group_0_3__0");
					put(grammarAccess.getQTypeAccess().getGroup_0_5(), "rule__QType__Group_0_5__0");
					put(grammarAccess.getQTypeAccess().getGroup_0_7(), "rule__QType__Group_0_7__0");
					put(grammarAccess.getQTypeListAccess().getGroup(), "rule__QTypeList__Group__0");
					put(grammarAccess.getQTypeListAccess().getGroup_1(), "rule__QTypeList__Group_1__0");
					put(grammarAccess.getDimListAccess().getGroup(), "rule__DimList__Group__0");
					put(grammarAccess.getInOutNameAccess().getGroup(), "rule__InOutName__Group__0");
					put(grammarAccess.getInOutNameListAccess().getGroup(), "rule__InOutNameList__Group__0");
					put(grammarAccess.getInOutNameListAccess().getGroup_1(), "rule__InOutNameList__Group_1__0");
					put(grammarAccess.getInOutNameListCommaAccess().getGroup(), "rule__InOutNameListComma__Group__0");
					put(grammarAccess.getInterfaceAccess().getGroup(), "rule__Interface__Group__0");
					put(grammarAccess.getInterfaceAccess().getGroup_0_0(), "rule__Interface__Group_0_0__0");
					put(grammarAccess.getInterfaceCommaAccess().getGroup(), "rule__InterfaceComma__Group__0");
					put(grammarAccess.getInterfaceCommaAccess().getGroup_0_0(), "rule__InterfaceComma__Group_0_0__0");
					put(grammarAccess.getInterfaceListAccess().getGroup(), "rule__InterfaceList__Group__0");
					put(grammarAccess.getInterfaceListAccess().getGroup_1(), "rule__InterfaceList__Group_1__0");
					put(grammarAccess.getVerifTaskAccess().getGroup_0(), "rule__VerifTask__Group_0__0");
					put(grammarAccess.getVerifTaskAccess().getGroup_1(), "rule__VerifTask__Group_1__0");
					put(grammarAccess.getVerifTaskAccess().getGroup_2(), "rule__VerifTask__Group_2__0");
					put(grammarAccess.getVerifTaskAccess().getGroup_3(), "rule__VerifTask__Group_3__0");
					put(grammarAccess.getControlListAccess().getGroup(), "rule__ControlList__Group__0");
					put(grammarAccess.getAssumeListAccess().getGroup(), "rule__AssumeList__Group__0");
					put(grammarAccess.getProofGoalListAccess().getGroup_0(), "rule__ProofGoalList__Group_0__0");
					put(grammarAccess.getProofGoalListAccess().getGroup_1(), "rule__ProofGoalList__Group_1__0");
					put(grammarAccess.getProofGoalListAccess().getGroup_2(), "rule__ProofGoalList__Group_2__0");
					put(grammarAccess.getProofGoalListAccess().getGroup_3(), "rule__ProofGoalList__Group_3__0");
					put(grammarAccess.getProofGoalListAccess().getGroup_4(), "rule__ProofGoalList__Group_4__0");
					put(grammarAccess.getFixpointEqListAccess().getGroup(), "rule__FixpointEqList__Group__0");
					put(grammarAccess.getOptUtyExprListAccess().getGroup(), "rule__OptUtyExprList__Group__0");
					put(grammarAccess.getOptUtyExprListAccess().getGroup_1(), "rule__OptUtyExprList__Group_1__0");
					put(grammarAccess.getUtyExprSelectListAccess().getGroup(), "rule__UtyExprSelectList__Group__0");
					put(grammarAccess.getUtyExprAccess().getGroup_11(), "rule__UtyExpr__Group_11__0");
					put(grammarAccess.getUtyExprAccess().getGroup_12(), "rule__UtyExpr__Group_12__0");
					put(grammarAccess.getUtyExprAccess().getGroup_13(), "rule__UtyExpr__Group_13__0");
					put(grammarAccess.getUtyExprAccess().getGroup_14(), "rule__UtyExpr__Group_14__0");
					put(grammarAccess.getUtyExprAccess().getGroup_15(), "rule__UtyExpr__Group_15__0");
					put(grammarAccess.getUtyExprAccess().getGroup_16(), "rule__UtyExpr__Group_16__0");
					put(grammarAccess.getUtyExprAccess().getGroup_17(), "rule__UtyExpr__Group_17__0");
					put(grammarAccess.getUtyExprAccess().getGroup_18(), "rule__UtyExpr__Group_18__0");
					put(grammarAccess.getUtyExprAccess().getGroup_19(), "rule__UtyExpr__Group_19__0");
					put(grammarAccess.getUtyExprAccess().getGroup_20(), "rule__UtyExpr__Group_20__0");
					put(grammarAccess.getUtyExprAccess().getGroup_21(), "rule__UtyExpr__Group_21__0");
					put(grammarAccess.getUtyExprAccess().getGroup_22(), "rule__UtyExpr__Group_22__0");
					put(grammarAccess.getUtyExprAccess().getGroup_23(), "rule__UtyExpr__Group_23__0");
					put(grammarAccess.getUtyExprAccess().getGroup_24(), "rule__UtyExpr__Group_24__0");
					put(grammarAccess.getUtyExprAccess().getGroup_25(), "rule__UtyExpr__Group_25__0");
					put(grammarAccess.getUtyExprAccess().getGroup_26(), "rule__UtyExpr__Group_26__0");
					put(grammarAccess.getUtyExprAccess().getGroup_27(), "rule__UtyExpr__Group_27__0");
					put(grammarAccess.getUtyExprAccess().getGroup_28(), "rule__UtyExpr__Group_28__0");
					put(grammarAccess.getUtyExprAccess().getGroup_29(), "rule__UtyExpr__Group_29__0");
					put(grammarAccess.getUtyExprAccess().getGroup_30(), "rule__UtyExpr__Group_30__0");
					put(grammarAccess.getUtyExprAccess().getGroup_31(), "rule__UtyExpr__Group_31__0");
					put(grammarAccess.getUtyExprAccess().getGroup_32(), "rule__UtyExpr__Group_32__0");
					put(grammarAccess.getUtyExprAccess().getGroup_33(), "rule__UtyExpr__Group_33__0");
					put(grammarAccess.getUtyExprAccess().getGroup_34(), "rule__UtyExpr__Group_34__0");
					put(grammarAccess.getUtyExprAccess().getGroup_35(), "rule__UtyExpr__Group_35__0");
					put(grammarAccess.getUtyExprAccess().getGroup_36(), "rule__UtyExpr__Group_36__0");
					put(grammarAccess.getUtyExprAccess().getGroup_37(), "rule__UtyExpr__Group_37__0");
					put(grammarAccess.getUtyExprAccess().getGroup_38(), "rule__UtyExpr__Group_38__0");
					put(grammarAccess.getUtyExprAccess().getGroup_39(), "rule__UtyExpr__Group_39__0");
					put(grammarAccess.getUtyExprAccess().getGroup_40(), "rule__UtyExpr__Group_40__0");
					put(grammarAccess.getUtyExprAccess().getGroup_41(), "rule__UtyExpr__Group_41__0");
					put(grammarAccess.getUtyExprAccess().getGroup_42(), "rule__UtyExpr__Group_42__0");
					put(grammarAccess.getUtyExprAccess().getGroup_43(), "rule__UtyExpr__Group_43__0");
					put(grammarAccess.getUtyExprAccess().getGroup_44(), "rule__UtyExpr__Group_44__0");
					put(grammarAccess.getUtyExprAccess().getGroup_45(), "rule__UtyExpr__Group_45__0");
					put(grammarAccess.getUtyExprAccess().getGroup_46(), "rule__UtyExpr__Group_46__0");
					put(grammarAccess.getUtyExprAccess().getGroup_47(), "rule__UtyExpr__Group_47__0");
					put(grammarAccess.getUtyExprAccess().getGroup_48(), "rule__UtyExpr__Group_48__0");
					put(grammarAccess.getUtyExprAccess().getGroup_49(), "rule__UtyExpr__Group_49__0");
					put(grammarAccess.getUtyExprAccess().getGroup_50(), "rule__UtyExpr__Group_50__0");
					put(grammarAccess.getUtyExprAccess().getGroup_51(), "rule__UtyExpr__Group_51__0");
					put(grammarAccess.getUtyExprAccess().getGroup_52(), "rule__UtyExpr__Group_52__0");
					put(grammarAccess.getUtyExprAccess().getGroup_53(), "rule__UtyExpr__Group_53__0");
					put(grammarAccess.getUtyExprAccess().getGroup_54(), "rule__UtyExpr__Group_54__0");
					put(grammarAccess.getUtyExprAccess().getGroup_55(), "rule__UtyExpr__Group_55__0");
					put(grammarAccess.getUtyExprAccess().getGroup_56(), "rule__UtyExpr__Group_56__0");
					put(grammarAccess.getUtyExprAccess().getGroup_57(), "rule__UtyExpr__Group_57__0");
					put(grammarAccess.getUtyExprAccess().getGroup_58(), "rule__UtyExpr__Group_58__0");
					put(grammarAccess.getUtyExprAccess().getGroup_59(), "rule__UtyExpr__Group_59__0");
					put(grammarAccess.getUtyExprAccess().getGroup_60(), "rule__UtyExpr__Group_60__0");
					put(grammarAccess.getUtyExprAccess().getGroup_61(), "rule__UtyExpr__Group_61__0");
					put(grammarAccess.getUtyExprAccess().getGroup_62(), "rule__UtyExpr__Group_62__0");
					put(grammarAccess.getUtyExprAccess().getGroup_63(), "rule__UtyExpr__Group_63__0");
					put(grammarAccess.getUtyExprAccess().getGroup_64(), "rule__UtyExpr__Group_64__0");
					put(grammarAccess.getUtyExprAccess().getGroup_65(), "rule__UtyExpr__Group_65__0");
					put(grammarAccess.getUtyExprAccess().getGroup_66(), "rule__UtyExpr__Group_66__0");
					put(grammarAccess.getUtyActionAccess().getGroup_0(), "rule__UtyAction__Group_0__0");
					put(grammarAccess.getUtyActionAccess().getGroup_1(), "rule__UtyAction__Group_1__0");
					put(grammarAccess.getUtyActionAccess().getGroup_2(), "rule__UtyAction__Group_2__0");
					put(grammarAccess.getUtyActionAccess().getGroup_3(), "rule__UtyAction__Group_3__0");
					put(grammarAccess.getUtyActionAccess().getGroup_4(), "rule__UtyAction__Group_4__0");
					put(grammarAccess.getUtyActionAccess().getGroup_5(), "rule__UtyAction__Group_5__0");
					put(grammarAccess.getUtyActionAccess().getGroup_6(), "rule__UtyAction__Group_6__0");
					put(grammarAccess.getUtyActionAccess().getGroup_7(), "rule__UtyAction__Group_7__0");
					put(grammarAccess.getUtyActionAccess().getGroup_8(), "rule__UtyAction__Group_8__0");
					put(grammarAccess.getUtyActionAccess().getGroup_9(), "rule__UtyAction__Group_9__0");
					put(grammarAccess.getUtyActionAccess().getGroup_10(), "rule__UtyAction__Group_10__0");
					put(grammarAccess.getUtyActionAccess().getGroup_11(), "rule__UtyAction__Group_11__0");
					put(grammarAccess.getUtyActionAccess().getGroup_12(), "rule__UtyAction__Group_12__0");
					put(grammarAccess.getUtyActionAccess().getGroup_13(), "rule__UtyAction__Group_13__0");
					put(grammarAccess.getUtyActionAccess().getGroup_14(), "rule__UtyAction__Group_14__0");
					put(grammarAccess.getUtyActionAccess().getGroup_15(), "rule__UtyAction__Group_15__0");
					put(grammarAccess.getCase_listAccess().getGroup(), "rule__Case_list__Group__0");
					put(grammarAccess.getDUtyExprAccess().getGroup(), "rule__DUtyExpr__Group__0");
					put(grammarAccess.getDUtyExprsAccess().getGroup(), "rule__DUtyExprs__Group__0");
					put(grammarAccess.getGenericAccess().getGroup(), "rule__Generic__Group__0");
					put(grammarAccess.getLocStmtAccess().getGroup(), "rule__LocStmt__Group__0");
					put(grammarAccess.getLocStmtAccess().getGroup_0(), "rule__LocStmt__Group_0__0");
					put(grammarAccess.getStmtAccess().getGroup(), "rule__Stmt__Group__0");
					put(grammarAccess.getStmtAccess().getGroup_1(), "rule__Stmt__Group_1__0");
					put(grammarAccess.getAtomicStmtAccess().getGroup_0(), "rule__AtomicStmt__Group_0__0");
					put(grammarAccess.getAtomicStmtAccess().getGroup_1(), "rule__AtomicStmt__Group_1__0");
					put(grammarAccess.getAtomicStmtAccess().getGroup_2(), "rule__AtomicStmt__Group_2__0");
					put(grammarAccess.getAtomicStmtAccess().getGroup_2_0(), "rule__AtomicStmt__Group_2_0__0");
					put(grammarAccess.getAtomicStmtAccess().getGroup_3(), "rule__AtomicStmt__Group_3__0");
					put(grammarAccess.getAtomicStmtAccess().getGroup_3_0(), "rule__AtomicStmt__Group_3_0__0");
					put(grammarAccess.getAtomicStmtAccess().getGroup_4(), "rule__AtomicStmt__Group_4__0");
					put(grammarAccess.getAtomicStmtAccess().getGroup_5(), "rule__AtomicStmt__Group_5__0");
					put(grammarAccess.getAtomicStmtAccess().getGroup_6(), "rule__AtomicStmt__Group_6__0");
					put(grammarAccess.getAtomicStmtAccess().getGroup_6_0(), "rule__AtomicStmt__Group_6_0__0");
					put(grammarAccess.getAtomicStmtAccess().getGroup_7(), "rule__AtomicStmt__Group_7__0");
					put(grammarAccess.getAtomicStmtAccess().getGroup_7_0(), "rule__AtomicStmt__Group_7_0__0");
					put(grammarAccess.getAtomicStmtAccess().getGroup_8(), "rule__AtomicStmt__Group_8__0");
					put(grammarAccess.getAtomicStmtAccess().getGroup_9(), "rule__AtomicStmt__Group_9__0");
					put(grammarAccess.getAtomicStmtAccess().getGroup_10(), "rule__AtomicStmt__Group_10__0");
					put(grammarAccess.getAtomicStmtAccess().getGroup_11(), "rule__AtomicStmt__Group_11__0");
					put(grammarAccess.getAtomicStmtAccess().getGroup_12(), "rule__AtomicStmt__Group_12__0");
					put(grammarAccess.getAtomicStmtAccess().getGroup_13(), "rule__AtomicStmt__Group_13__0");
					put(grammarAccess.getAtomicStmtAccess().getGroup_13_0(), "rule__AtomicStmt__Group_13_0__0");
					put(grammarAccess.getAtomicStmtAccess().getGroup_14(), "rule__AtomicStmt__Group_14__0");
					put(grammarAccess.getAtomicStmtAccess().getGroup_14_0(), "rule__AtomicStmt__Group_14_0__0");
					put(grammarAccess.getAtomicStmtAccess().getGroup_15(), "rule__AtomicStmt__Group_15__0");
					put(grammarAccess.getAtomicStmtAccess().getGroup_15_0(), "rule__AtomicStmt__Group_15_0__0");
					put(grammarAccess.getAtomicStmtAccess().getGroup_16(), "rule__AtomicStmt__Group_16__0");
					put(grammarAccess.getAtomicStmtAccess().getGroup_16_3(), "rule__AtomicStmt__Group_16_3__0");
					put(grammarAccess.getAtomicStmtAccess().getGroup_17(), "rule__AtomicStmt__Group_17__0");
					put(grammarAccess.getAtomicStmtAccess().getGroup_18(), "rule__AtomicStmt__Group_18__0");
					put(grammarAccess.getAtomicStmtAccess().getGroup_19(), "rule__AtomicStmt__Group_19__0");
					put(grammarAccess.getAtomicStmtAccess().getGroup_19_2(), "rule__AtomicStmt__Group_19_2__0");
					put(grammarAccess.getAtomicStmtAccess().getGroup_20(), "rule__AtomicStmt__Group_20__0");
					put(grammarAccess.getAtomicStmtAccess().getGroup_21(), "rule__AtomicStmt__Group_21__0");
					put(grammarAccess.getAtomicStmtAccess().getGroup_22(), "rule__AtomicStmt__Group_22__0");
					put(grammarAccess.getAtomicStmtAccess().getGroup_23(), "rule__AtomicStmt__Group_23__0");
					put(grammarAccess.getQrzFileAccess().getImportsAssignment_1(), "rule__QrzFile__ImportsAssignment_1");
					put(grammarAccess.getQrzFileAccess().getMacrosAssignment_2(), "rule__QrzFile__MacrosAssignment_2");
					put(grammarAccess.getQrzFileAccess().getModuleAssignment_3(), "rule__QrzFile__ModuleAssignment_3");
					put(grammarAccess.getImportListAccess().getImpAssignment_1(), "rule__ImportList__ImpAssignment_1");
					put(grammarAccess.getPointedNameAccess().getIdAssignment_0(), "rule__PointedName__IdAssignment_0");
					put(grammarAccess.getPointedNameAccess().getNameAssignment_1_1(), "rule__PointedName__NameAssignment_1_1");
					put(grammarAccess.getPointedNameAccess().getAllAssignment_2(), "rule__PointedName__AllAssignment_2");
					put(grammarAccess.getMacroDefAccess().getNameAssignment_0_1(), "rule__MacroDef__NameAssignment_0_1");
					put(grammarAccess.getMacroDefAccess().getArgsAssignment_0_3(), "rule__MacroDef__ArgsAssignment_0_3");
					put(grammarAccess.getMacroDefAccess().getExprAssignment_0_6(), "rule__MacroDef__ExprAssignment_0_6");
					put(grammarAccess.getMacroDefAccess().getNameAssignment_1_1(), "rule__MacroDef__NameAssignment_1_1");
					put(grammarAccess.getMacroDefAccess().getExprAssignment_1_5(), "rule__MacroDef__ExprAssignment_1_5");
					put(grammarAccess.getQModuleAccess().getNameAssignment_1(), "rule__QModule__NameAssignment_1");
					put(grammarAccess.getQModuleAccess().getIntfAssignment_3(), "rule__QModule__IntfAssignment_3");
					put(grammarAccess.getQModuleAccess().getStmtAssignment_5_1(), "rule__QModule__StmtAssignment_5_1");
					put(grammarAccess.getQModuleAccess().getObsAssignment_6(), "rule__QModule__ObsAssignment_6");
					put(grammarAccess.getNameAccess().getIdAssignment(), "rule__Name__IdAssignment");
					put(grammarAccess.getQNameListAccess().getNameAssignment_0(), "rule__QNameList__NameAssignment_0");
					put(grammarAccess.getQNameListAccess().getNamesAssignment_1_1(), "rule__QNameList__NamesAssignment_1_1");
					put(grammarAccess.getQTypeAccess().getTaAssignment_0_3_2(), "rule__QType__TaAssignment_0_3_2");
					put(grammarAccess.getQTypeAccess().getTbAssignment_0_5_2(), "rule__QType__TbAssignment_0_5_2");
					put(grammarAccess.getQTypeAccess().getTcAssignment_0_7_2(), "rule__QType__TcAssignment_0_7_2");
					put(grammarAccess.getQTypeAccess().getDimsAssignment_1(), "rule__QType__DimsAssignment_1");
					put(grammarAccess.getQTypeListAccess().getTypeAssignment_0(), "rule__QTypeList__TypeAssignment_0");
					put(grammarAccess.getQTypeListAccess().getTAssignment_1_1(), "rule__QTypeList__TAssignment_1_1");
					put(grammarAccess.getDimListAccess().getExprAssignment_1(), "rule__DimList__ExprAssignment_1");
					put(grammarAccess.getInOutNameListAccess().getNamesAssignment_1_1(), "rule__InOutNameList__NamesAssignment_1_1");
					put(grammarAccess.getInOutNameListCommaAccess().getNamesAssignment_0(), "rule__InOutNameListComma__NamesAssignment_0");
					put(grammarAccess.getInterfaceAccess().getTypeAssignment_0_0_1(), "rule__Interface__TypeAssignment_0_0_1");
					put(grammarAccess.getInterfaceAccess().getNamesAssignment_1(), "rule__Interface__NamesAssignment_1");
					put(grammarAccess.getInterfaceCommaAccess().getTypeAssignment_0_0_1(), "rule__InterfaceComma__TypeAssignment_0_0_1");
					put(grammarAccess.getInterfaceCommaAccess().getNamesAssignment_1(), "rule__InterfaceComma__NamesAssignment_1");
					put(grammarAccess.getInterfaceListAccess().getIntfAssignment_0(), "rule__InterfaceList__IntfAssignment_0");
					put(grammarAccess.getInterfaceListAccess().getInterfacesAssignment_1_1(), "rule__InterfaceList__InterfacesAssignment_1_1");
					put(grammarAccess.getProofGoalListAccess().getNameAssignment_0_0(), "rule__ProofGoalList__NameAssignment_0_0");
					put(grammarAccess.getProofGoalListAccess().getExprAssignment_0_3(), "rule__ProofGoalList__ExprAssignment_0_3");
					put(grammarAccess.getProofGoalListAccess().getNameAssignment_1_0(), "rule__ProofGoalList__NameAssignment_1_0");
					put(grammarAccess.getProofGoalListAccess().getExprAssignment_1_3(), "rule__ProofGoalList__ExprAssignment_1_3");
					put(grammarAccess.getProofGoalListAccess().getGoalsAssignment_1_5(), "rule__ProofGoalList__GoalsAssignment_1_5");
					put(grammarAccess.getProofGoalListAccess().getNameAssignment_2_0(), "rule__ProofGoalList__NameAssignment_2_0");
					put(grammarAccess.getProofGoalListAccess().getVerAssignment_2_1(), "rule__ProofGoalList__VerAssignment_2_1");
					put(grammarAccess.getProofGoalListAccess().getCtrlAssignment_2_2(), "rule__ProofGoalList__CtrlAssignment_2_2");
					put(grammarAccess.getProofGoalListAccess().getExprAssignment_2_5(), "rule__ProofGoalList__ExprAssignment_2_5");
					put(grammarAccess.getProofGoalListAccess().getAssAssignment_2_6(), "rule__ProofGoalList__AssAssignment_2_6");
					put(grammarAccess.getProofGoalListAccess().getNameAssignment_3_0(), "rule__ProofGoalList__NameAssignment_3_0");
					put(grammarAccess.getProofGoalListAccess().getCtrAssignment_3_1(), "rule__ProofGoalList__CtrAssignment_3_1");
					put(grammarAccess.getProofGoalListAccess().getExprAssignment_3_4(), "rule__ProofGoalList__ExprAssignment_3_4");
					put(grammarAccess.getProofGoalListAccess().getAssAssignment_3_5(), "rule__ProofGoalList__AssAssignment_3_5");
					put(grammarAccess.getProofGoalListAccess().getNameAssignment_4_0(), "rule__ProofGoalList__NameAssignment_4_0");
					put(grammarAccess.getProofGoalListAccess().getExprAssignment_4_3(), "rule__ProofGoalList__ExprAssignment_4_3");
					put(grammarAccess.getProofGoalListAccess().getAssAssignment_4_4(), "rule__ProofGoalList__AssAssignment_4_4");
					put(grammarAccess.getFixpointEqListAccess().getNameAssignment_1(), "rule__FixpointEqList__NameAssignment_1");
					put(grammarAccess.getFixpointEqListAccess().getExprAssignment_3(), "rule__FixpointEqList__ExprAssignment_3");
					put(grammarAccess.getOptUtyExprAccess().getTkAssignment_1(), "rule__OptUtyExpr__TkAssignment_1");
					put(grammarAccess.getOptUtyExprListAccess().getExprsAssignment_1_1(), "rule__OptUtyExprList__ExprsAssignment_1_1");
					put(grammarAccess.getUtyExprSelectListAccess().getTkAssignment_1(), "rule__UtyExprSelectList__TkAssignment_1");
					put(grammarAccess.getUtyExprAccess().getOpAssignment_11_0(), "rule__UtyExpr__OpAssignment_11_0");
					put(grammarAccess.getUtyExprAccess().getExprAssignment_11_1(), "rule__UtyExpr__ExprAssignment_11_1");
					put(grammarAccess.getUtyExprAccess().getT7Assignment_15_5(), "rule__UtyExpr__T7Assignment_15_5");
					put(grammarAccess.getUtyExprAccess().getExprAssignment_18_3(), "rule__UtyExpr__ExprAssignment_18_3");
					put(grammarAccess.getUtyExprAccess().getExprAssignment_30_4(), "rule__UtyExpr__ExprAssignment_30_4");
					put(grammarAccess.getUtyExprAccess().getExprAssignment_31_4(), "rule__UtyExpr__ExprAssignment_31_4");
					put(grammarAccess.getUtyExprAccess().getExprAssignment_33_2(), "rule__UtyExpr__ExprAssignment_33_2");
					put(grammarAccess.getUtyExprAccess().getExprAssignment_34_2(), "rule__UtyExpr__ExprAssignment_34_2");
					put(grammarAccess.getUtyExprAccess().getExprAssignment_35_2(), "rule__UtyExpr__ExprAssignment_35_2");
					put(grammarAccess.getUtyExprAccess().getExprAssignment_36_3(), "rule__UtyExpr__ExprAssignment_36_3");
					put(grammarAccess.getUtyExprAccess().getExprAssignment_37_3(), "rule__UtyExpr__ExprAssignment_37_3");
					put(grammarAccess.getUtyExprAccess().getExprAssignment_38_3(), "rule__UtyExpr__ExprAssignment_38_3");
					put(grammarAccess.getUtyExprAccess().getExprAssignment_39_3(), "rule__UtyExpr__ExprAssignment_39_3");
					put(grammarAccess.getUtyExprAccess().getExprAssignment_40_3(), "rule__UtyExpr__ExprAssignment_40_3");
					put(grammarAccess.getUtyExprAccess().getExprAssignment_41_3(), "rule__UtyExpr__ExprAssignment_41_3");
					put(grammarAccess.getUtyExprAccess().getExprAssignment_42_3(), "rule__UtyExpr__ExprAssignment_42_3");
					put(grammarAccess.getUtyExprAccess().getExprAssignment_43_3(), "rule__UtyExpr__ExprAssignment_43_3");
					put(grammarAccess.getUtyExprAccess().getExprAssignment_44_3(), "rule__UtyExpr__ExprAssignment_44_3");
					put(grammarAccess.getUtyExprAccess().getExprAssignment_45_3(), "rule__UtyExpr__ExprAssignment_45_3");
					put(grammarAccess.getUtyExprAccess().getExprAssignment_46_3(), "rule__UtyExpr__ExprAssignment_46_3");
					put(grammarAccess.getUtyExprAccess().getExprAssignment_47_3(), "rule__UtyExpr__ExprAssignment_47_3");
					put(grammarAccess.getUtyExprAccess().getNameAssignment_61_1(), "rule__UtyExpr__NameAssignment_61_1");
					put(grammarAccess.getUtyExprAccess().getExprAssignment_61_3(), "rule__UtyExpr__ExprAssignment_61_3");
					put(grammarAccess.getUtyExprAccess().getNameAssignment_62_1(), "rule__UtyExpr__NameAssignment_62_1");
					put(grammarAccess.getUtyExprAccess().getExprAssignment_62_3(), "rule__UtyExpr__ExprAssignment_62_3");
					put(grammarAccess.getUtyExprAccess().getExpr2Assignment_63_3(), "rule__UtyExpr__Expr2Assignment_63_3");
					put(grammarAccess.getUtyExprAccess().getNameAssignment_64_1(), "rule__UtyExpr__NameAssignment_64_1");
					put(grammarAccess.getUtyExprAccess().getTypeAssignment_64_3(), "rule__UtyExpr__TypeAssignment_64_3");
					put(grammarAccess.getUtyExprAccess().getExprAssignment_64_5(), "rule__UtyExpr__ExprAssignment_64_5");
					put(grammarAccess.getUtyExprAccess().getNameAssignment_65_1(), "rule__UtyExpr__NameAssignment_65_1");
					put(grammarAccess.getUtyExprAccess().getTypeAssignment_65_3(), "rule__UtyExpr__TypeAssignment_65_3");
					put(grammarAccess.getUtyExprAccess().getExprAssignment_65_5(), "rule__UtyExpr__ExprAssignment_65_5");
					put(grammarAccess.getUtyActionAccess().getT2Assignment_2_5(), "rule__UtyAction__T2Assignment_2_5");
					put(grammarAccess.getUtyActionAccess().getT4Assignment_3_5(), "rule__UtyAction__T4Assignment_3_5");
					put(grammarAccess.getUtyActionAccess().getExprAssignment_14_4(), "rule__UtyAction__ExprAssignment_14_4");
					put(grammarAccess.getUtyActionAccess().getExprAssignment_15_4(), "rule__UtyAction__ExprAssignment_15_4");
					put(grammarAccess.getCase_listAccess().getExpAssignment_0(), "rule__Case_list__ExpAssignment_0");
					put(grammarAccess.getCase_listAccess().getStmtAssignment_2(), "rule__Case_list__StmtAssignment_2");
					put(grammarAccess.getGenericAccess().getT6Assignment_3(), "rule__Generic__T6Assignment_3");
					put(grammarAccess.getGenericAccess().getT5Assignment_5(), "rule__Generic__T5Assignment_5");
					put(grammarAccess.getLocStmtAccess().getLocalsAssignment_0_0(), "rule__LocStmt__LocalsAssignment_0_0");
					put(grammarAccess.getLocStmtAccess().getStmtAssignment_1(), "rule__LocStmt__StmtAssignment_1");
					put(grammarAccess.getSeqStmtAccess().getSAssignment(), "rule__SeqStmt__SAssignment");
					put(grammarAccess.getStmtAccess().getLeftAssignment_0(), "rule__Stmt__LeftAssignment_0");
					put(grammarAccess.getStmtAccess().getRightAssignment_1_1(), "rule__Stmt__RightAssignment_1_1");
					put(grammarAccess.getAtomicStmtAccess().getNameAssignment_4_2(), "rule__AtomicStmt__NameAssignment_4_2");
					put(grammarAccess.getAtomicStmtAccess().getExprsAssignment_4_4(), "rule__AtomicStmt__ExprsAssignment_4_4");
					put(grammarAccess.getAtomicStmtAccess().getExprsAssignment_5_2(), "rule__AtomicStmt__ExprsAssignment_5_2");
					put(grammarAccess.getAtomicStmtAccess().getExprAssignment_6_3(), "rule__AtomicStmt__ExprAssignment_6_3");
					put(grammarAccess.getAtomicStmtAccess().getStmtAssignment_7_4(), "rule__AtomicStmt__StmtAssignment_7_4");
					put(grammarAccess.getAtomicStmtAccess().getTsAssignment_7_6(), "rule__AtomicStmt__TsAssignment_7_6");
					put(grammarAccess.getAtomicStmtAccess().getExprAssignment_8_5(), "rule__AtomicStmt__ExprAssignment_8_5");
					put(grammarAccess.getAtomicStmtAccess().getT03Assignment_9_4(), "rule__AtomicStmt__T03Assignment_9_4");
					put(grammarAccess.getAtomicStmtAccess().getT06Assignment_10_3(), "rule__AtomicStmt__T06Assignment_10_3");
					put(grammarAccess.getAtomicStmtAccess().getT07Assignment_11_2(), "rule__AtomicStmt__T07Assignment_11_2");
					put(grammarAccess.getAtomicStmtAccess().getExprAssignment_13_2(), "rule__AtomicStmt__ExprAssignment_13_2");
					put(grammarAccess.getAtomicStmtAccess().getT08Assignment_13_3(), "rule__AtomicStmt__T08Assignment_13_3");
					put(grammarAccess.getAtomicStmtAccess().getStmtAssignment_14_3(), "rule__AtomicStmt__StmtAssignment_14_3");
					put(grammarAccess.getAtomicStmtAccess().getNameAssignment_15_0_2(), "rule__AtomicStmt__NameAssignment_15_0_2");
					put(grammarAccess.getAtomicStmtAccess().getExprAssignment_15_2(), "rule__AtomicStmt__ExprAssignment_15_2");
					put(grammarAccess.getAtomicStmtAccess().getT10Assignment_15_3(), "rule__AtomicStmt__T10Assignment_15_3");
					put(grammarAccess.getAtomicStmtAccess().getT13Assignment_16_2(), "rule__AtomicStmt__T13Assignment_16_2");
					put(grammarAccess.getAtomicStmtAccess().getT14Assignment_16_3_1(), "rule__AtomicStmt__T14Assignment_16_3_1");
					put(grammarAccess.getAtomicStmtAccess().getT15Assignment_17_3(), "rule__AtomicStmt__T15Assignment_17_3");
					put(grammarAccess.getAtomicStmtAccess().getT16Assignment_18_3(), "rule__AtomicStmt__T16Assignment_18_3");
					put(grammarAccess.getAtomicStmtAccess().getTAssignment_19_3(), "rule__AtomicStmt__TAssignment_19_3");
					put(grammarAccess.getAtomicStmtAccess().getT23Assignment_20_2(), "rule__AtomicStmt__T23Assignment_20_2");
					put(grammarAccess.getAtomicStmtAccess().getExprAssignment_22_4(), "rule__AtomicStmt__ExprAssignment_22_4");
					put(grammarAccess.getAtomicStmtAccess().getT24Assignment_22_6(), "rule__AtomicStmt__T24Assignment_22_6");
				}
			};
		}
		return nameMappings.get(element);
	}
	
	@Override
	protected Collection<FollowElement> getFollowElements(AbstractInternalContentAssistParser parser) {
		try {
			de.cau.cs.kieler.editor.quartz.contentassist.antlr.internal.InternalQuartzParser typedParser = (de.cau.cs.kieler.editor.quartz.contentassist.antlr.internal.InternalQuartzParser) parser;
			typedParser.entryRuleQrzFile();
			return typedParser.getFollowElements();
		} catch(RecognitionException ex) {
			throw new RuntimeException(ex);
		}		
	}
	
	@Override
	protected String[] getInitialHiddenTokens() {
		return new String[] { "RULE_WS", "RULE_SL_COMMENT", "RULE_ML_COMMENT" };
	}
	
	public QuartzGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}
	
	public void setGrammarAccess(QuartzGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}
