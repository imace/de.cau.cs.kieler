package de.cau.cs.kieler.ssm2.dsl;

import org.openarchitectureware.xtext.AbstractXtextEditorPlugin;
import org.openarchitectureware.xtext.LanguageUtilities;
import org.osgi.framework.BundleContext;

public class Ssm2dlEditorPlugin extends AbstractXtextEditorPlugin {
   private static Ssm2dlEditorPlugin plugin;
   public static Ssm2dlEditorPlugin getDefault() {
      return plugin;
   }

   private Ssm2dlUtilities utilities = new Ssm2dlUtilities();
   public LanguageUtilities getUtilities() {
      return utilities;
   }

   public Ssm2dlEditorPlugin() {
      plugin = this;
   }

   public void stop(BundleContext context) throws Exception {
      super.stop(context);
      plugin = null;
   }
}
