ThinKCharts - Thin Kieler SyncCharts Editor

@author Matthias Schmeling <schm@informatik.uni-kiel.de>, 
        Hauke Fuhrmann <haf@informatik.uni-kiel.de>

================

How to generate:

1. open model/synccharts.genmodel
2. right-click the root node of the model in the editor
3. select "Generate Model Code"
4. select "Generate Edit Code"
5. select "Generate Editor Code"
6.a optionally re-generate the gmfgen file from the mapping file (see below)
6. right-click the file model/synccharts.gmfgen
7. select "Generate diagram code"
8. Check if all freshly generated projects compile without errors

=================

Troubleshooting:

Compile errors in freshly generated projects:
- delete all generated projects before regeneration (make sure to really 
  remove all contents and not only the project file)
- Make sure all dependencies to the editors are fulfilled. Check if there
  are any errors in any of the projects in their META-INF/MANIFEST.MF files.
  If there are missing dependencies, you need to install the corresponding
  plug-ins.

Updating the gmfgen model:
- There are many customizations done to the gmfgen model. Hence, a pure
  regeneration from the mapping file is not sufficient.
- All customizations are specified in the QVTO transformation in
  model/synccharts_gmfgen_customization.qvto
1. right-click model/synccharts.gmfmap file
2. select "Create generator model..."
3. "Next" to "Specify transformation options"
4. in that wizard page add a "Extra in-place transformation *after* reconcile step"
5. set platform:/resource/de.cau.cs.kieler.synccharts/model/synccharts_gmfgen_customization.qvto
   as file name
6. Finish
7. Check generated gmfgen file if the customizations have been applied
  - e.g. open Gen Plugin, see if new Wizard category is set to "de.cau.cs.kieler"

================

Changing the generated code for .editor, .edit, .model, .test plugins:

- Look at .genmodel and make sure that under templates & merge the following
is selected:
    - Dynamic Templates : true
    - Template Directory : de.cau.cs.kieler.synccharts/templates
- Find the file you want to change:
    - all files that can go into the templates folder are taken from
    org.eclipse.emf.codegen.ecore
    - for changing the plugin.xml you have to either look at
    plugin.xmljet or manifest.mfjet
- Edit the corresponding file
    - for example to change the version id look at manifest.mfjet
    and change "Bundle-Version: 0.1.0.qualifier" to 
    "Bundle-Version: 0.2.0.qualifier"
- Generate the corresponding plugin

author: Soeren Hansen <soh@informatik...>

================

Files:

 model/synccharts.ecorediag
    EMF Metamodel diagram file for the EMFtools diagram editor
 model/synccharts.ecore
    EMF Metamodel of SyncCharts
 model/synccharts.genmodel
    The codegenerator model for the SyncCharts metamodel code
 model/synccharts.png
    Image of the SyncCharts Metamodel. It is linked from the trac wiki on
    the project homepage. Hence it should be kept up to date.
 
model/synccharts_0_1.*
    Older versions of the synccharts metamodel. Not used anymore but still there
    for an easy reference. These files are incompatible to the current version,
    so do not use them anymore. Contact the KIELER team for the migration
    strategy to the new version if you have such issues. 
 
 model/synccharts.gmfgraph
     Graphical definitions model for GMF
 model/synccharts.gmftool
     Tooling model for GMF
 model/synccharts.gmfmap
     Mapping model for GMF. It is used to generate the gmfgen model.
 model/synccharts.gmfgen
     The GMF generator model. It is used to generate the diagram plugin and
     code
 model/synccharts.trace
     Trace file generated during the gmfmap->gmfgen transformation. It is used
     to keep the visual IDs of the elements the same when the gmfgen is
     regenerated. This is required if custom code references visual IDs as 
     our does.
 model/synccharts_gmfgen_customization.qvto
     QVT-Operational Model-to-Model transformation that transforms a
     gmfgen model by an in-place transformation. This transformation
     holds all customizations done to the gmfgen model after its creation
     from the mapping model. Hence all customizations can be applied
     automatically by this transformation from a fresh generated gmfgen model.
 
 model/SyncchartsChecks.chk
     Syntactic checks in the check language of oAW for Synccharts. May be
     applied also to the graphical diagram.
     
 model/synccharts2.png, manual.png
     Images, Classdiagrams for documentation, also linked from the wiki.
     So please don't remove or rename unless you also update the wiki page.
     
 customIcons/*
     Custom Icons for the graphical editor. Make sure also to export this
     folder to any application if you want to see these custom icons in
     e.g. an RCP
     
 gmf-templates/*
     Custom code generation templates for the diagram code generation from
     the gmfgen model. They are necessary to generate custom code required
     for some special features of the editor, e.g. Attribute Awareness and
     other stuff.
     
 templates/*
    Custom code generation templates for the .editor, .model, .edit, .test
    plugins. They are used to generate the proper version ids and
    add custom editors and wizards to the generated plugins.