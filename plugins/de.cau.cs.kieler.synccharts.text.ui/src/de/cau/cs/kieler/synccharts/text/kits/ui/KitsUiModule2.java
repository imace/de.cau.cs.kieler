/*
 * generated by Xtext
 */
package de.cau.cs.kieler.synccharts.text.kits.ui;

import org.eclipse.ui.plugin.AbstractUIPlugin;

import org.eclipse.xtext.ui.editor.syntaxcoloring.antlr.DefaultAntlrTokenToAttributeIdMapper;


/**
 * Use this class to register components to be used within the IDE.
 */
public class KitsUiModule2 extends de.cau.cs.kieler.synccharts.text.kits.ui.AbstractKitsUiModule {
	public KitsUiModule2(AbstractUIPlugin plugin) {
		super(plugin);
	}
	
	// disabling the damn nature adder
	public Class<? extends org.eclipse.xtext.ui.editor.IXtextEditorCallback> bindIXtextEditorCallback() {
		return org.eclipse.xtext.ui.editor.IXtextEditorCallback.NullImpl.class;
	}
    public Class<? extends DefaultAntlrTokenToAttributeIdMapper> bindAbstractAntlrTokenToAttributeIdMapper() {
    	return CustomAntlrTokenToAttributeIdMapper.class;
    }
	
//    public Class<? extends DefaultHighlightingConfiguration> bindILexicalHighlightingConfiguration() {
//        return CustomLexicalHighlightingConfiguration.class;
//    }
    

}
