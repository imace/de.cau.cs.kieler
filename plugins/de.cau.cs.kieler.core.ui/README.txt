| de.cau.cs.kieler.core.ui
\______________________________________

Core user interface contributions for the KIELER project. Aside from utility
classes for use in the Eclipse UI, the plugin.xml contains definitions of
UI elements that can be reused throughout KIELER. This includes categories
for the most important UI contributions, e.g. commands or views.

Other plug-ins should import this only if they contain UI code and are not
meant to be exported for a stand-alone application or library. This plug-in
should be kept free from any extended Eclipse features, such as GEF, GMF,
Xtext, or other modeling frameworks.

Special files:

help/
  contents for eclipse internal help and the welcome page
