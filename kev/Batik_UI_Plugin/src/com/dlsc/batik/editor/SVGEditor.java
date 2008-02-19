package com.dlsc.batik.editor;

import org.eclipse.ui.editors.text.TextEditor;

public class SVGEditor extends TextEditor {

	private ColorManager colorManager;

	public SVGEditor() {
		super();
		colorManager = new ColorManager();
		setSourceViewerConfiguration(new XMLConfiguration(colorManager));
		setDocumentProvider(new XMLDocumentProvider());
	}
	public void dispose() {
		colorManager.dispose();
		super.dispose();
	}

}
