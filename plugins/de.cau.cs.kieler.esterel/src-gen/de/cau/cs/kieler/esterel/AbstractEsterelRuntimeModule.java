
/*
 * generated by Xtext
 */
package de.cau.cs.kieler.esterel;

import org.eclipse.xtext.Constants;
import org.eclipse.xtext.service.DefaultRuntimeModule;

import com.google.inject.Binder;
import com.google.inject.name.Names;

/**
 * Manual modifications go to {de.cau.cs.kieler.esterel.EsterelRuntimeModule}
 */
public abstract class AbstractEsterelRuntimeModule extends DefaultRuntimeModule {
	
	@Override
	public void configure(Binder binder) {
		super.configure(binder);
		binder.bind(String.class).annotatedWith(Names.named(Constants.LANGUAGE_NAME)).toInstance(
			"de.cau.cs.kieler.esterel.Esterel");
		bindProperties(binder);
	}
	
	protected void bindProperties(Binder binder) {
		bindProperties(binder, "/de/cau/cs/kieler/esterel/Esterel.properties");
	}
	
	
	// contributed by org.eclipse.xtext.generator.grammarAccess.GrammarAccessFragment
	public Class<? extends org.eclipse.xtext.IGrammarAccess> bindIGrammarAccess() {
		return de.cau.cs.kieler.esterel.services.EsterelGrammarAccess.class;
	}

	// contributed by org.eclipse.xtext.generator.parseTreeConstructor.ParseTreeConstructorFragment
	public Class<? extends org.eclipse.xtext.parsetree.reconstr.IParseTreeConstructor> bindIParseTreeConstructor() {
		return de.cau.cs.kieler.esterel.parseTreeConstruction.EsterelParsetreeConstructor.class;
	}

	// contributed by de.itemis.xtext.antlr.XtextAntlrGeneratorFragment
	public Class<? extends org.eclipse.xtext.parser.antlr.IAntlrParser> bindIAntlrParser() {
		return de.cau.cs.kieler.esterel.parser.antlr.EsterelParser.class;
	}

	// contributed by de.itemis.xtext.antlr.XtextAntlrGeneratorFragment
	public Class<? extends org.eclipse.xtext.parser.ITokenToStringConverter> bindITokenToStringConverter() {
		return org.eclipse.xtext.parser.antlr.AntlrTokenToStringConverter.class;
	}

	// contributed by de.itemis.xtext.antlr.XtextAntlrGeneratorFragment
	public Class<? extends org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider> bindIAntlrTokenFileProvider() {
		return de.cau.cs.kieler.esterel.parser.antlr.EsterelAntlrTokenFileProvider.class;
	}

	// contributed by de.itemis.xtext.antlr.XtextAntlrGeneratorFragment
	public Class<? extends org.eclipse.xtext.parser.antlr.Lexer> bindLexer() {
		return de.cau.cs.kieler.esterel.parser.antlr.internal.InternalEsterelLexer.class;
	}

	// contributed by de.itemis.xtext.antlr.XtextAntlrGeneratorFragment
	public com.google.inject.Provider<de.cau.cs.kieler.esterel.parser.antlr.internal.InternalEsterelLexer> provideInternalEsterelLexer() {
		return org.eclipse.xtext.parser.antlr.LexerProvider.create(de.cau.cs.kieler.esterel.parser.antlr.internal.InternalEsterelLexer.class);
	}

	// contributed by de.itemis.xtext.antlr.XtextAntlrGeneratorFragment
	public void configureRuntimeLexer(com.google.inject.Binder binder) {
		binder.bind(org.eclipse.xtext.parser.antlr.Lexer.class).annotatedWith(com.google.inject.name.Names.named(org.eclipse.xtext.parser.antlr.LexerBindings.RUNTIME)).to(de.cau.cs.kieler.esterel.parser.antlr.internal.InternalEsterelLexer.class);
	}

	// contributed by de.itemis.xtext.antlr.XtextAntlrGeneratorFragment
	public Class<? extends org.eclipse.xtext.parser.antlr.ITokenDefProvider> bindITokenDefProvider() {
		return org.eclipse.xtext.parser.antlr.AntlrTokenDefProvider.class;
	}

	// contributed by org.eclipse.xtext.generator.validation.JavaValidatorFragment
	@org.eclipse.xtext.service.SingletonBinding(eager=true)	public Class<? extends de.cau.cs.kieler.esterel.validation.EsterelJavaValidator> bindEsterelJavaValidator() {
		return de.cau.cs.kieler.esterel.validation.EsterelJavaValidator.class;
	}

	// contributed by org.eclipse.xtext.generator.scoping.JavaScopingFragment
	public Class<? extends org.eclipse.xtext.scoping.IScopeProvider> bindIScopeProvider() {
		return de.cau.cs.kieler.esterel.scoping.EsterelScopeProvider.class;
	}

	// contributed by org.eclipse.xtext.generator.scoping.JavaScopingFragment
	public void configureIScopeProviderDelegate(com.google.inject.Binder binder) {
		binder.bind(org.eclipse.xtext.scoping.IScopeProvider.class).annotatedWith(com.google.inject.name.Names.named("org.eclipse.xtext.scoping.IScopeProvider.delegate")).to(org.eclipse.xtext.scoping.impl.SimpleNameScopeProvider.class);
	}

	// contributed by org.eclipse.xtext.generator.formatting.FormatterFragment
	public Class<? extends org.eclipse.xtext.formatting.IFormatter> bindIFormatter() {
		return de.cau.cs.kieler.esterel.formatting.EsterelFormatter.class;
	}

}
