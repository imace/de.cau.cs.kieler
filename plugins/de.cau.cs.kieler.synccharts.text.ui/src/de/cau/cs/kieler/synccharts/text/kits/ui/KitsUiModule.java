package de.cau.cs.kieler.synccharts.text.kits.ui;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtext.ui.editor.syntaxcoloring.antlr.DefaultAntlrTokenToAttributeIdMapper;

/**
 * Use this class to register components to be used within the IDE.
 */
public class KitsUiModule extends de.cau.cs.kieler.synccharts.text.kits.ui.AbstractKitsUiModule {
	public KitsUiModule(AbstractUIPlugin plugin) {
		super(plugin);
	}
	
	public Class<? extends org.eclipse.xtext.ui.editor.IXtextEditorCallback> bindIXtextEditorCallback() {
		return org.eclipse.xtext.ui.editor.IXtextEditorCallback.NullImpl.class;
	}

	public Class<? extends DefaultAntlrTokenToAttributeIdMapper> bindAbstractAntlrTokenToAttributeIdMapper() {
    	return CustomAntlrTokenToAttributeIdMapper.class;
    }
}
