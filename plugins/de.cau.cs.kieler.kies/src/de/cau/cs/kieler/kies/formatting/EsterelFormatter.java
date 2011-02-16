/*
 * generated by Xtext
 */
package de.cau.cs.kieler.kies.formatting;

import org.eclipse.xtext.formatting.impl.AbstractDeclarativeFormatter;
import org.eclipse.xtext.formatting.impl.FormattingConfig;

import de.cau.cs.kieler.kies.services.EsterelGrammarAccess;

/**
 * This class contains custom formatting description.
 * 
 * see : http://www.eclipse.org/Xtext/documentation/latest/xtext.html#formatting on how and when to
 * use it
 * 
 * Also see {@link org.eclipse.xtext.xtext.XtextFormattingTokenSerializer} as an example
 */
public class EsterelFormatter extends AbstractDeclarativeFormatter {

    @Override
    protected void configureFormatting(FormattingConfig c) {
        EsterelGrammarAccess g = (EsterelGrammarAccess) getGrammarAccess();

        // mandatory! otherwise if (1=1) serializes to if1=1
        c.setSpace(" ").after(g.getIfTestAccess().getIfKeyword_0());

        // testing
       c.setSpace(" ").after(g.getPauseAccess().getPauseKeyword_0());

        c.setLinewrap().after(g.getSequenceAccess().getSemicolonKeyword_1_1());
        c.setLinewrap().after(g.getSequenceAccess().getSemicolonKeyword_2());
        c.setLinewrap().after(g.getSequenceRule());

        c.setLinewrap(1).after(g.getModuleAccess().getColonKeyword_2());

        c.setSpace(" ").after(g.getModuleAccess().getModuleKeyword_0());
        c.setSpace(" ").before(g.getModuleRule());

        // de.cau.cs.kieler.esterel.services.EsterelGrammarAccess f =
        // (de.cau.cs.kieler.esterel.services.EsterelGrammarAccess) getGrammarAccess();
        // Iterable<Keyword> keywords = GrammarUtil.containedKeywords(f
        // .getGrammar());
        // // remove space before ";" and "," . Add linewrap after ","
        // for (Keyword keyword : keywords) {
        // if ((";".equals(keyword.getValue()))
        // | (",".equals(keyword.getValue()))) {
        // //c.setNoSpace().before(keyword);
        // }
        // if (",".equals(keyword.getValue())) {
        // c.setLinewrap().after(keyword);
        // }
        // }
        // /* ********************************************************************
        // * Formatting for comments
        // * ********************************************************************
        // */
        //
        // c.setLinewrap(2).before(f.getEsterel_ML_CommentRule());
        // c.setNoLinewrap().before(f.getEsterel_SL_CommentRule());
        // c.setLinewrap().after(f.getEsterel_SL_CommentRule());
        //
        // /* ********************************************************************
        // * Formatting for Module/MainModule
        // * ********************************************************************
        // */
        // c.setLinewrap(2).before(f.getModuleAccess().getModuleKeyword_0());
        // c.setLinewrap().after(f.getModuleAccess().getColonKeyword_2());
        // c.setNoSpace().before(f.getModuleAccess().getColonKeyword_2());
        // // c.setLinewrap().before(f.getEndModuleAccess().getEndKeyword_0_0());
        // // c.setLinewrap().before(f.getEndModuleAccess().getFullStopKeyword_1());
        //
        // /* ********************************************************************
        // * Formatting for ModuleInterface
        // * ********************************************************************
        // */
        //
        // // ==> Input <==
        // // c.setLinewrap()
        // // .after(f.getSignalDeclAccess().getSemicolonKeyword_0_4());
        // // c.setLinewrap().after(f.getSignalDeclAccess().getCommaKeyword_0_3_0());
        // // // c.setIndentationSpace(getMaxIndentation(f.getSignalDeclAccess()
        // // // .getInputKeyword_0_1().getValue()));
        // // c.setIndentation(f.getSignalDeclAccess().getInputKeyword_0_1(), f
        // // .getSignalDeclAccess().getSemicolonKeyword_0_4());
        // // // ==> Output <==
        // // c.setLinewrap()
        // // .after(f.getSignalDeclAccess().getSemicolonKeyword_1_4());
        // // c.setLinewrap().after(f.getSignalDeclAccess().getCommaKeyword_1_3_0());
        // // c.setIndentation(f.getSignalDeclAccess().getOutputKeyword_1_1(), f
        // // .getSignalDeclAccess().getSemicolonKeyword_1_4());
        // // // ==> InputOutput <==
        // // c.setLinewrap()
        // // .after(f.getSignalDeclAccess().getSemicolonKeyword_2_4());
        // // c.setLinewrap().after(f.getSignalDeclAccess().getCommaKeyword_2_3_0());
        // // c.setIndentation(f.getSignalDeclAccess().getInputoutputKeyword_2_1(), f
        // // .getSignalDeclAccess().getSemicolonKeyword_2_4());
        // // // ==> Return <==
        // // c.setLinewrap()
        // // .after(f.getSignalDeclAccess().getSemicolonKeyword_3_4());
        // // c.setLinewrap().after(f.getSignalDeclAccess().getCommaKeyword_3_3_0());
        // // c.setIndentation(f.getSignalDeclAccess().getReturnKeyword_3_1(), f
        // // .getSignalDeclAccess().getSemicolonKeyword_3_4());
        // // // ==> Type <==
        // // c.setLinewrap().after(f.getTypeDeclAccess().getSemicolonKeyword_3());
        // // c.setLinewrap().after(f.getTypeDeclAccess().getCommaKeyword_2_0());
        // // c.setIndentation(f.getTypeDeclAccess().getTypeKeyword_0(), f
        // // .getTypeDeclAccess().getSemicolonKeyword_3());
        // // // ==> Sensor <==
        // // c.setLinewrap().after(f.getSensorDeclAccess().getSemicolonKeyword_3());
        // // c.setLinewrap().after(f.getSensorDeclAccess().getCommaKeyword_2_0());
        // // c.setIndentation(f.getSensorDeclAccess().getSensorKeyword_0(), f
        // // .getSensorDeclAccess().getSemicolonKeyword_3());
        // // // ==> Constant <==
        // // c.setLinewrap()
        // // .after(f.getConstantDeclAccess().getSemicolonKeyword_3());
        // // c.setLinewrap().after(f.getConstantDeclAccess().getCommaKeyword_2_0());
        // // c.setIndentation(f.getConstantDeclAccess().getConstantKeyword_0(), f
        // // .getConstantDeclAccess().getSemicolonKeyword_3());
        // // // ==> Relation <==
        // // c.setLinewrap()
        // // .after(f.getRelationDeclAccess().getSemicolonKeyword_4());
        // // c.setLinewrap().after(f.getRelationDeclAccess().getCommaKeyword_3_0());
        // // c.setIndentation(f.getRelationDeclAccess().getRelationKeyword_1(), f
        // // .getRelationDeclAccess().getSemicolonKeyword_4());
        // // // ==> Function <==
        // // c.setLinewrap()
        // // .after(f.getFunctionDeclAccess().getSemicolonKeyword_3());
        // // c.setLinewrap().after(f.getFunctionDeclAccess().getCommaKeyword_2_0());
        // // c.setIndentation(f.getFunctionDeclAccess().getFunctionKeyword_0(), f
        // // .getFunctionDeclAccess().getSemicolonKeyword_3());
        // // // ==> Procedure <==
        // // c.setLinewrap().after(
        // // f.getProcedureDeclAccess().getSemicolonKeyword_3());
        // // c.setLinewrap().after(f.getProcedureDeclAccess().getCommaKeyword_2_0());
        // // c.setIndentation(f.getProcedureDeclAccess().getProcedureKeyword_0(), f
        // // .getProcedureDeclAccess().getSemicolonKeyword_3());
        //
        // /* ********************************************************************
        // * Formatting for ModuleBody
        // * ********************************************************************
        // */
        // // c.setIndentationSpace("  "); // reset indentation for the module body
        // // c.setLinewrap().after(f.getSequenceAccess().getSemicolonKeyword_1_1());
        // // c.setLinewrap().after(f.getSequenceAccess().getSemicolonKeyword_2());
        //
        // // ==> Parallel <==
        // c.setLinewrap()
        // .before(
        // f.getStatementAccess()
        // .getVerticalLineVerticalLineKeyword_1_1());
        // // ==> Block <==
        // c.setLinewrap().before(
        // f.getBlockAccess().getLeftSquareBracketKeyword_0());
        // c.setLinewrap().before(
        // f.getBlockAccess().getRightSquareBracketKeyword_2());
        // c.setIndentation(f.getBlockAccess().getLeftSquareBracketKeyword_0(), f
        // .getBlockAccess().getRightSquareBracketKeyword_2());
        // // ==> Assignment <==
        // // c.setLinewrap().before(
        // // f.getAssignmentAccess().getVariableAssignment_0());
        // // ==> Abort <==
        // c.setLinewrap().before(f.getAbortAccess().getAbortKeyword_0());
        // c.setLinewrap().before(f.getAbortAccess().getWhenKeyword_2());
        // c.setIndentation(f.getAbortAccess().getAbortKeyword_0(), f
        // .getAbortAccess().getWhenKeyword_2());
        // // c.setLinewrap().before(f.getAbortEndAccess().getEndKeyword_0());
        // c.setLinewrap().before(f.getAbortCaseSingleAccess().getCaseKeyword_0());
        // c.setIndentation(f.getAbortCaseSingleAccess().getDoKeyword_2_0(), f
        // .getAbortCaseSingleAccess().getGroup_2());
        // c.setLinewrap().before(f.getAbortInstanceAccess().getDoKeyword_1_0());
        // // c.setIndentation(f.getAbortInstanceAccess().getDoKeyword_1_0(), f
        // // .getAbortInstanceAccess().getEndAssignment_1_2());
        // // TODO AbortBody
        // // ==> Await <==
        // c.setLinewrap().before(f.getAwaitAccess().getAwaitKeyword_0());
        // // TODO AwaitBody
        // // ==> Do <==
        // c.setLinewrap().before(f.getDoAccess().getDoKeyword_0());
        // c.setLinewrap().before(f.getDoUptoAccess().getUptoKeyword_0());
        // c.setIndentation(f.getDoAccess().getDoKeyword_0(), f.getDoUptoAccess()
        // .getUptoKeyword_0());
        // c.setLinewrap().before(f.getDoWatchingAccess().getWatchingKeyword_0());
        // c.setIndentation(f.getDoAccess().getDoKeyword_0(), f
        // .getDoWatchingAccess().getWatchingKeyword_0());
        // c.setLinewrap()
        // .before(f.getDoWatchingEndAccess().getTimeoutKeyword_0());
        // // c.setLinewrap().before(f.getDoWatchingEndAccess().getEndKeyword_2());
        // // c.setIndentation(f.getDoWatchingEndAccess().getTimeoutKeyword_0(), f
        // // .getDoWatchingEndAccess().getEndKeyword_2());
        // // ==> Emit <==
        // c.setLinewrap().before(f.getEmitAccess().getEmitKeyword_0());
        // // ==> EveryDo <==
        // c.setLinewrap().before(f.getEveryDoAccess().getEveryKeyword_0());
        // // c.setIndentation(f.getEveryDoAccess().getDoKeyword_2(), f
        // // .getEveryDoAccess().getEndKeyword_4());
        // // ==> Exit <==
        // c.setLinewrap().before(f.getExitAccess().getExitKeyword_0());
        // // ==> Halt <==
        // c.setLinewrap().before(f.getHaltAccess().getHaltKeyword_0());
        // // ==> If <==
        // c.setLinewrap().before(f.getIfTestAccess().getIfKeyword_0());
        // // c.setLinewrap().before(f.getIfTestAccess().getEndKeyword_5());
        // c.setLinewrap().before(f.getElsIfAccess().getElsifKeyword_0());
        // c.setLinewrap().before(f.getElsePartAccess().getElseKeyword_0());
        // c.setLinewrap().before(f.getThenPartAccess().getThenKeyword_0());
        // // TODO If indentation
        // // ==> Loop <==
        // // TODO Indentation for Loop
        // c.setLinewrap().before(f.getLoopAccess().getLoopKeyword_0());
        // c.setLinewrap().before(f.getEndLoopAccess().getEndKeyword_0());
        // // c.setIndentation(f.getLoopAccess().getLoopKeyword_0(), f
        // // .getEndLoopAccess().getEndKeyword_0());
        // c.setLinewrap().before(f.getLoopEachAccess().getEachKeyword_0());
        // // c.setIndentation(f.getLoopAccess().getLoopKeyword_0(), f
        // // .getLoopEachAccess().getEachKeyword_0());
        // // ==> Nothing <==
        // c.setLinewrap().before(f.getNothingAccess().getNothingKeyword_0());
        // // ==> Pause <==
        // c.setLinewrap().before(f.getPauseAccess().getPauseKeyword_0());
        // // ==> Present <==
        // c.setLinewrap().before(f.getPresentAccess().getPresentKeyword_0());
        // // c.setLinewrap().before(f.getPresentAccess().getEndKeyword_3());
        // // TODO Present indents
        // // ==> Repeat <==
        // c.setLinewrap().before(f.getRepeatAccess().getGroup());
        // c.setLinewrap().before(f.getRepeatAccess().getTimesKeyword_3());
        // c.setLinewrap().before(f.getRepeatAccess().getEndKeyword_5());
        // // TODO test repeat
        // // ==> Run <==
        // c.setLinewrap().before(f.getRunAccess().getRunKeyword_0_0());
        // c.setLinewrap().before(f.getRunAccess().getCopymoduleKeyword_1_0());
        // // TODO formatting for renaming
        // // ==> Local Signal <==
        // c.setLinewrap().before(
        // f.getLocalSignalDeclAccess().getSignalKeyword_0());
        // c.setLinewrap().before(f.getLocalSignalDeclAccess().getInKeyword_2());
        // // c.setLinewrap().before(f.getLocalSignalDeclAccess().getEndKeyword_4());
        // // c.setIndentation(f.getLocalSignalDeclAccess().getSignalKeyword_0(), f
        // // .getLocalSignalDeclAccess().getEndKeyword_4());
        // // c.setIndentation(f.getLocalSignalDeclAccess().getInKeyword_2(), f
        // // .getLocalSignalDeclAccess().getEndKeyword_4());
        // // ==> Suspend <==
        // c.setLinewrap().before(f.getSuspendAccess().getSuspendKeyword_0());
        // c.setLinewrap().before(f.getSuspendAccess().getWhenKeyword_2());
        // c.setIndentation(f.getSuspendAccess().getSuspendKeyword_0(), f
        // .getSuspendAccess().getWhenKeyword_2());
        // // ==> Sustain <==
        // c.setLinewrap().before(f.getSustainAccess().getSustainKeyword_0());
        // // ==> Trap <==
        // c.setLinewrap().before(f.getTrapAccess().getTrapKeyword_0());
        // c.setLinewrap().before(f.getTrapAccess().getInKeyword_2());
        // c.setLinewrap().before(f.getTrapAccess().getEndKeyword_5());
        // // ==> Var <==
        // // c.setLinewrap().before(f.getVariableAccess().getVarKeyword_0());
        // // c.setLinewrap().before(f.getVariableAccess().getInKeyword_2());
        // // c.setLinewrap().before(f.getVariableAccess().getEndKeyword_4());
        // // ==> Weak Abort <==
        // c.setLinewrap().before(f.getWeakAbortAccess().getWeakKeyword_0());
        // c.setLinewrap().before(f.getWeakAbortAccess().getWhenKeyword_3());
        // c.setIndentation(f.getWeakAbortAccess().getWeakKeyword_0(), f
        // .getWeakAbortAccess().getWhenKeyword_3());
        // c.setLinewrap().before(f.getWeakAbortEndAccess().getEndKeyword_0());
        // // ...
    }

    private String getMaxIndentation(final String keyword) {
        // Max Indentation may be changed here
        int maxIndent = keyword.length() + 1;
        String indent = "";
        for (int i = 0; i < maxIndent; i++) {
            indent += " ";
        }
        return indent;
    }
}
