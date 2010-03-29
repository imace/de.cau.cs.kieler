
/*
 * generated by Xtext
 */
package de.cau.cs.kieler.krep.editors.klp;

import org.eclipse.xtext.Constants;
import org.eclipse.xtext.service.DefaultRuntimeModule;

import com.google.inject.Binder;
import com.google.inject.name.Names;

/**
 * Manual modifications go to {de.cau.cs.kieler.krep.editors.klp.KlpRuntimeModule}
 */
public abstract class AbstractKlpRuntimeModule extends DefaultRuntimeModule {
	
	@Override
	public void configure(Binder binder) {
		super.configure(binder);
		binder.bind(String.class).annotatedWith(Names.named(Constants.LANGUAGE_NAME)).toInstance(
			"de.cau.cs.kieler.krep.editors.klp.Klp");
		bindProperties(binder);
	}
	
	protected void bindProperties(Binder binder) {
		bindProperties(binder, "de/cau/cs/kieler/krep/editors/klp/Klp.properties");
	}
	
	
	// contributed by org.eclipse.xtext.generator.grammarAccess.GrammarAccessFragment
	public Class<? extends org.eclipse.xtext.IGrammarAccess> bindIGrammarAccess() {
		return de.cau.cs.kieler.krep.editors.klp.services.KlpGrammarAccess.class;
	}

	// contributed by org.eclipse.xtext.generator.parseTreeConstructor.ParseTreeConstructorFragment
	public Class<? extends org.eclipse.xtext.parsetree.reconstr.IParseTreeConstructor> bindIParseTreeConstructor() {
		return de.cau.cs.kieler.krep.editors.klp.parseTreeConstruction.KlpParsetreeConstructor.class;
	}

	// contributed by de.itemis.xtext.antlr.XtextAntlrGeneratorFragment
	public Class<? extends org.eclipse.xtext.parser.antlr.IAntlrParser> bindIAntlrParser() {
		return de.cau.cs.kieler.krep.editors.klp.parser.antlr.KlpParser.class;
	}

	// contributed by de.itemis.xtext.antlr.XtextAntlrGeneratorFragment
	public Class<? extends org.eclipse.xtext.parser.ITokenToStringConverter> bindITokenToStringConverter() {
		return org.eclipse.xtext.parser.antlr.AntlrTokenToStringConverter.class;
	}

	// contributed by de.itemis.xtext.antlr.XtextAntlrGeneratorFragment
	public Class<? extends org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider> bindIAntlrTokenFileProvider() {
		return de.cau.cs.kieler.krep.editors.klp.parser.antlr.KlpAntlrTokenFileProvider.class;
	}

	// contributed by de.itemis.xtext.antlr.XtextAntlrGeneratorFragment
	public Class<? extends org.eclipse.xtext.parser.antlr.Lexer> bindLexer() {
		return de.cau.cs.kieler.krep.editors.klp.parser.antlr.internal.InternalKlpLexer.class;
	}

	// contributed by de.itemis.xtext.antlr.XtextAntlrGeneratorFragment
	public com.google.inject.Provider<de.cau.cs.kieler.krep.editors.klp.parser.antlr.internal.InternalKlpLexer> provideInternalKlpLexer() {
		return org.eclipse.xtext.parser.antlr.LexerProvider.create(de.cau.cs.kieler.krep.editors.klp.parser.antlr.internal.InternalKlpLexer.class);
	}

	// contributed by de.itemis.xtext.antlr.XtextAntlrGeneratorFragment
	public void configureRuntimeLexer(com.google.inject.Binder binder) {
		binder.bind(org.eclipse.xtext.parser.antlr.Lexer.class).annotatedWith(com.google.inject.name.Names.named(org.eclipse.xtext.parser.antlr.LexerBindings.RUNTIME)).to(de.cau.cs.kieler.krep.editors.klp.parser.antlr.internal.InternalKlpLexer.class);
	}

	// contributed by de.itemis.xtext.antlr.XtextAntlrGeneratorFragment
	public Class<? extends org.eclipse.xtext.parser.antlr.ITokenDefProvider> bindITokenDefProvider() {
		return org.eclipse.xtext.parser.antlr.AntlrTokenDefProvider.class;
	}

	// contributed by org.eclipse.xtext.generator.validation.JavaValidatorFragment
	@org.eclipse.xtext.service.SingletonBinding(eager=true)	public Class<? extends de.cau.cs.kieler.krep.editors.klp.validation.KlpJavaValidator> bindKlpJavaValidator() {
		return de.cau.cs.kieler.krep.editors.klp.validation.KlpJavaValidator.class;
	}

	// contributed by org.eclipse.xtext.generator.scoping.ImportURIScopingFragment
	public Class<? extends org.eclipse.xtext.scoping.IScopeProvider> bindIScopeProvider() {
		return de.cau.cs.kieler.krep.editors.klp.scoping.KlpScopeProvider.class;
	}

	// contributed by org.eclipse.xtext.generator.scoping.ImportURIScopingFragment
	public void configureIScopeProviderDelegate(com.google.inject.Binder binder) {
		binder.bind(org.eclipse.xtext.scoping.IScopeProvider.class).annotatedWith(com.google.inject.name.Names.named("org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider.delegate")).to(org.eclipse.xtext.scoping.impl.SimpleLocalScopeProvider.class);
	}

	// contributed by org.eclipse.xtext.generator.scoping.ImportURIScopingFragment
	public Class<? extends org.eclipse.xtext.scoping.IGlobalScopeProvider> bindIGlobalScopeProvider() {
		return org.eclipse.xtext.scoping.impl.ImportUriGlobalScopeProvider.class;
	}

	// contributed by org.eclipse.xtext.generator.exporting.SimpleNamesFragment
	public Class<? extends org.eclipse.xtext.naming.IQualifiedNameProvider> bindIQualifiedNameProvider() {
		return org.eclipse.xtext.naming.SimpleNameProvider.class;
	}

	// contributed by org.eclipse.xtext.generator.formatting.FormatterFragment
	public Class<? extends org.eclipse.xtext.formatting.IFormatter> bindIFormatter() {
		return de.cau.cs.kieler.krep.editors.klp.formatting.KlpFormatter.class;
	}

}
