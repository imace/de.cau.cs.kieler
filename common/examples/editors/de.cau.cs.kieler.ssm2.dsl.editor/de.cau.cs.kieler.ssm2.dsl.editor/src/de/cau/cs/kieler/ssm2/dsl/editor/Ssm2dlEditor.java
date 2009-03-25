package de.cau.cs.kieler.ssm2.dsl.editor;

import org.openarchitectureware.xtext.AbstractXtextEditorPlugin;
import org.openarchitectureware.xtext.editor.AbstractXtextEditor;

import de.cau.cs.kieler.ssm2.dsl.Ssm2dlEditorPlugin;

public class Ssm2dlEditor extends AbstractXtextEditor {

   public AbstractXtextEditorPlugin getPlugin() {
      return Ssm2dlEditorPlugin.getDefault();
   }
}
