
/*
 * generated by Xtext
 */
package de.cau.cs.kieler.synccharts.dsl;

import de.cau.cs.kieler.synccharts.dsl.KitsRuntimeModule;

/**
 * Manual modifications go to {de.cau.cs.kieler.synccharts.dsl.KitsUiModule}
 */
public abstract class AbstractKitsUiModule extends KitsRuntimeModule {
	
	
	// contributed by org.eclipse.xtext.ui.generator.ImplicitUiFragment
	public Class<? extends org.eclipse.xtext.ui.core.ILocationInFileProvider> bindILocationInFileProvider() {
		return org.eclipse.xtext.ui.core.DefaultLocationInFileProvider.class;
	}

	// contributed by org.eclipse.xtext.ui.generator.ImplicitUiFragment
	public Class<? extends org.eclipse.jface.text.hyperlink.IHyperlinkDetector> bindIHyperlinkDetector() {
		return org.eclipse.xtext.ui.common.editor.hyperlinking.DefaultHyperlinkDetector.class;
	}

	// contributed by org.eclipse.xtext.ui.generator.ImplicitUiFragment
	public Class<? extends org.eclipse.jface.text.reconciler.IReconciler> bindIReconciler() {
		return org.eclipse.xtext.ui.core.editor.reconciler.XtextReconciler.class;
	}

	// contributed by org.eclipse.xtext.ui.generator.ImplicitUiFragment
	public Class<? extends org.eclipse.xtext.ui.core.editor.toggleComments.ISingleLineCommentHelper> bindISingleLineCommentHelper() {
		return org.eclipse.xtext.ui.common.editor.toggleComments.DefaultSingleLineCommentHelper.class;
	}

	// contributed by org.eclipse.xtext.ui.generator.ImplicitUiFragment
	public Class<? extends org.eclipse.xtext.ui.common.editor.outline.ITreeProvider> bindITreeProvider() {
		return org.eclipse.xtext.ui.common.editor.outline.transformer.TransformingTreeProvider.class;
	}

	// contributed by org.eclipse.xtext.ui.generator.ImplicitUiFragment
	public Class<? extends org.eclipse.ui.views.contentoutline.IContentOutlinePage> bindIContentOutlinePage() {
		return org.eclipse.xtext.ui.common.editor.outline.XtextContentOutlinePage.class;
	}

	// contributed by org.eclipse.xtext.ui.generator.ImplicitUiFragment
	public Class<? extends org.eclipse.xtext.ui.common.editor.outline.actions.IActionBarContributor> bindIActionBarContributor() {
		return org.eclipse.xtext.ui.common.editor.outline.actions.IActionBarContributor.DefaultActionBarContributor.class;
	}

	// contributed by org.eclipse.xtext.ui.generator.ImplicitUiFragment
	public Class<? extends org.eclipse.xtext.ui.core.editor.syntaxcoloring.IHighlightingHelper> bindIHighlightingHelper() {
		return org.eclipse.xtext.ui.common.editor.syntaxcoloring.HighlightingHelper.class;
	}

	// contributed by org.eclipse.xtext.ui.generator.ImplicitUiFragment
	public Class<? extends org.eclipse.emf.common.notify.AdapterFactory> bindAdapterFactory() {
		return org.eclipse.xtext.ui.core.InjectableAdapterFactory.class;
	}

	// contributed by org.eclipse.xtext.ui.generator.ImplicitUiFragment
	public Class<? extends org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider> bindAdapterFactoryLabelProvider() {
		return org.eclipse.xtext.ui.core.InjectableAdapterFactoryLabelProvider.class;
	}

	// contributed by org.eclipse.xtext.ui.generator.ImplicitUiFragment
	public org.eclipse.emf.edit.provider.ComposedAdapterFactory.Descriptor.Registry bindComposedAdapterFactory$Descriptor$RegistryToInstance() {
		return org.eclipse.emf.edit.provider.ComposedAdapterFactory.Descriptor.Registry.INSTANCE;
	}

	// contributed by org.eclipse.xtext.ui.generator.ImplicitUiFragment
	public Class<? extends org.eclipse.xtext.ui.core.editor.contentassist.IContentAssistantFactory> bindIContentAssistantFactory() {
		return org.eclipse.xtext.ui.common.editor.contentassist.DefaultContentAssistantFactory.class;
	}

	// contributed by org.eclipse.xtext.ui.generator.ImplicitUiFragment
	public Class<? extends org.eclipse.jface.text.contentassist.IContentAssistProcessor> bindIContentAssistProcessor() {
		return org.eclipse.xtext.ui.core.editor.contentassist.XtextContentAssistProcessor.class;
	}

	// contributed by org.eclipse.xtext.ui.generator.ImplicitUiFragment
	public Class<? extends org.eclipse.xtext.ui.core.editor.contentassist.ICompletionProposalPostProcessor> bindICompletionProposalPostProcessor() {
		return org.eclipse.xtext.ui.common.editor.contentassist.DefaultCompletionProposalPostProcessor.class;
	}

	// contributed by org.eclipse.xtext.ui.generator.ImplicitUiFragment
	public Class<? extends org.eclipse.xtext.ui.core.editor.contentassist.IFollowElementCalculator> bindIFollowElementCalculator() {
		return org.eclipse.xtext.ui.common.editor.contentassist.DefaultFollowElementCalculator.class;
	}

	// contributed by org.eclipse.xtext.ui.generator.ImplicitUiFragment
	public Class<? extends org.eclipse.xtext.ui.core.editor.contentassist.ITemplateProposalProvider> bindITemplateProposalProvider() {
		return org.eclipse.xtext.ui.common.editor.templates.DefaultTemplateProposalProvider.class;
	}

	// contributed by org.eclipse.xtext.ui.generator.ImplicitUiFragment
	public Class<? extends org.eclipse.jface.text.templates.persistence.TemplateStore> bindTemplateStore() {
		return org.eclipse.xtext.ui.common.editor.templates.XtextTemplateStore.class;
	}

	// contributed by org.eclipse.xtext.ui.generator.ImplicitUiFragment
	public Class<? extends org.eclipse.jface.text.templates.ContextTypeRegistry> bindContextTypeRegistry() {
		return org.eclipse.xtext.ui.common.editor.templates.XtextTemplateContextTypeRegistry.class;
	}

	// contributed by org.eclipse.xtext.ui.generator.ImplicitUiFragment
	public Class<? extends org.eclipse.xtext.ui.core.editor.formatting.IContentFormatterFactory> bindIContentFormatterFactory() {
		return org.eclipse.xtext.ui.core.editor.formatting.ContentFormatterFactory.class;
	}

	// contributed by org.eclipse.xtext.ui.generator.ImplicitUiFragment
	public Class<? extends org.eclipse.xtext.ui.core.editor.validation.ValidationJob.Factory> bindValidationJob$Factory() {
		return org.eclipse.xtext.ui.core.editor.validation.DefaultValidationJobFactory.class;
	}

	// contributed by org.eclipse.xtext.ui.generator.ImplicitUiFragment
	public Class<? extends org.eclipse.xtext.ui.core.editor.validation.IXtextResourceChecker> bindIXtextResourceChecker() {
		return org.eclipse.xtext.ui.core.editor.validation.DefaultXtextResourceChecker.class;
	}

	// contributed by de.itemis.xtext.antlr.XtextAntlrGeneratorFragment
	public Class<? extends org.eclipse.jface.text.rules.ITokenScanner> bindITokenScanner() {
		return org.eclipse.xtext.ui.common.editor.syntaxcoloring.antlr.AntlrTokenScanner.class;
	}

	// contributed by de.itemis.xtext.antlr.XtextAntlrGeneratorFragment
	public Class<? extends org.eclipse.xtext.ui.common.editor.contentassist.IProposalConflictHelper> bindIProposalConflictHelper() {
		return org.eclipse.xtext.ui.common.editor.contentassist.antlr.AntlrProposalConflictHelper.class;
	}

	// contributed by de.itemis.xtext.antlr.XtextAntlrGeneratorFragment
	public Class<? extends org.eclipse.xtext.ui.core.editor.IDamagerRepairer> bindIDamagerRepairer() {
		return org.eclipse.xtext.ui.core.editor.XtextDamagerRepairer.class;
	}

	// contributed by org.eclipse.xtext.ui.generator.labeling.LabelProviderFragment
	public Class<? extends org.eclipse.jface.viewers.ILabelProvider> bindILabelProvider() {
		return de.cau.cs.kieler.synccharts.dsl.labeling.KitsLabelProvider.class;
	}

	// contributed by org.eclipse.xtext.ui.generator.outline.TransformerFragment
	public Class<? extends org.eclipse.xtext.ui.common.editor.outline.transformer.ISemanticModelTransformer> bindISemanticModelTransformer() {
		return de.cau.cs.kieler.synccharts.dsl.outline.KitsTransformer.class;
	}

	// contributed by org.eclipse.xtext.ui.generator.outline.OutlineNodeAdapterFactoryFragment
	public Class<? extends org.eclipse.xtext.ui.common.editor.outline.actions.IContentOutlineNodeAdapterFactory> bindIContentOutlineNodeAdapterFactory() {
		return de.cau.cs.kieler.synccharts.dsl.outline.KitsOutlineNodeAdapterFactory.class;
	}

	// contributed by org.eclipse.xtext.ui.generator.contentAssist.JavaBasedContentAssistFragment
	public Class<? extends org.eclipse.xtext.ui.core.editor.contentassist.IContentProposalProvider> bindIContentProposalProvider() {
		return de.cau.cs.kieler.synccharts.dsl.contentassist.KitsProposalProvider.class;
	}

	// contributed by de.itemis.xtext.antlr.XtextAntlrUiGeneratorFragment
	public Class<? extends org.eclipse.xtext.ui.core.editor.contentassist.ContentAssistContext.Factory> bindContentAssistContext$Factory() {
		return org.eclipse.xtext.ui.common.editor.contentassist.antlr.ParserBasedContentAssistContextFactory.class;
	}

	// contributed by de.itemis.xtext.antlr.XtextAntlrUiGeneratorFragment
	public Class<? extends org.eclipse.xtext.ui.common.editor.contentassist.antlr.IContentAssistParser> bindIContentAssistParser() {
		return de.cau.cs.kieler.synccharts.dsl.contentassist.antlr.KitsParser.class;
	}


}
