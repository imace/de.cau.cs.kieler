package edu.unikiel.rtsys.kieler.kev.views;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Panel;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Locale;

import javax.swing.JLabel;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import org.apache.batik.bridge.ExternalResourceSecurity;
import org.apache.batik.bridge.NoLoadExternalResourceSecurity;
import org.apache.batik.bridge.NoLoadScriptSecurity;
import org.apache.batik.bridge.ScriptSecurity;
import org.apache.batik.swing.JSVGCanvas;
import org.apache.batik.swing.gvt.GVTTreeRendererAdapter;
import org.apache.batik.swing.gvt.GVTTreeRendererEvent;
import org.apache.batik.swing.svg.GVTTreeBuilderAdapter;
import org.apache.batik.swing.svg.GVTTreeBuilderEvent;
import org.apache.batik.swing.svg.JSVGComponent;
import org.apache.batik.swing.svg.SVGDocumentLoaderAdapter;
import org.apache.batik.swing.svg.SVGDocumentLoaderEvent;
import org.apache.batik.swing.svg.SVGUserAgent;
import org.apache.batik.util.ParsedURL;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.awt.SWT_AWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPart;
import org.w3c.dom.Element;


import edu.unikiel.rtsys.kieler.kev.KevPlugin;
import edu.unikiel.rtsys.kieler.kev.helpers.Tools;

public class EnvironmentComposite extends Composite implements ISelectionListener {

	private JSVGCanvas svgCanvas = null;
	
	private boolean debug = true;
	private Shell shell;
	private IFile svgFile;
	private IProject svgProject;
	private URI svgURI; // required if RCP does not support IFiles
	
	private SVGResourceChangeListener updater;
	private JLabel statusLabel = new JLabel("Status");
	private Frame frame;
	
	private MyUserAgent userAgent;
	
	public MyUserAgent getUserAgent() {
		return userAgent;
	}
	
	public EnvironmentComposite(Composite parent, int style,boolean showScrollbars) {
		super(parent,SWT.EMBEDDED);
		
		shell = parent.getShell();
		
		parent.setLayout(new FillLayout());
		statusLabel.setHorizontalAlignment(SwingConstants.CENTER);
		statusLabel.setBackground(java.awt.Color.BLACK);
		statusLabel.setForeground(java.awt.Color.WHITE);
		statusLabel.setFont(new Font("helvetica",Font.BOLD,12));
		statusLabel.setOpaque(true);
		statusLabel.setVisible(false);
				
		/*
		 * Set a Windows specific AWT property that prevents heavyweight
		 * components from erasing their background. Note that this
		 * is a global property and cannot be scoped. It might not be
		 * suitable for your application.
		 */
		try {
			System.setProperty("sun.awt.noerasebackground","true");
		} catch (NoSuchMethodError error) {
		    error.printStackTrace();
		}
		
		
		try {
			userAgent = new MyUserAgent();
			svgCanvas = new EclipseJSVGCanvas(userAgent, true, true);
			svgCanvas.setLayout(new BorderLayout());
			
			// taken from original modelgui
			svgCanvas.setDocumentState(JSVGComponent.ALWAYS_DYNAMIC);
			svgCanvas.setDoubleBufferedRendering(false);
			svgCanvas.setDisableInteractions(true);
			// svgCanvas.enableInputMethods(false);
			//this.canvas.setAnimationLimitingCPU(0.5f);
			// svgCanvas.setDoubleBuffered(true);

			
			  
			// Set the JSVGCanvas listeners.
			svgCanvas.addSVGDocumentLoaderListener(new SVGDocumentLoaderAdapter() {
				public void documentLoadingStarted(SVGDocumentLoaderEvent e) {
				}
				public void documentLoadingCompleted(SVGDocumentLoaderEvent e) {
				}
			});
			
			svgCanvas.addGVTTreeBuilderListener(new GVTTreeBuilderAdapter() {
				public void gvtBuildStarted(GVTTreeBuilderEvent e) {
				}
				public void gvtBuildCompleted(GVTTreeBuilderEvent e) {
				}
			});
			
			svgCanvas.addGVTTreeRendererListener(new GVTTreeRendererAdapter() {
				public void gvtRenderingPrepare(GVTTreeRendererEvent e) {
				}
				public void gvtRenderingCompleted(GVTTreeRendererEvent e) {
				}
			});
			
			frame = SWT_AWT.new_Frame(this);
			
			Panel panel = new Panel(new BorderLayout()) {	
				public void update(java.awt.Graphics g) {
					/* Do not erase the background */ 
					paint(g);
				}
			};
			
			JRootPane root = new JRootPane();
			panel.add(root);
			java.awt.Container contentPane = root.getContentPane();
			contentPane.setLayout(new BorderLayout());
			
			if (showScrollbars) {
				contentPane.add(BorderLayout.CENTER, new JScrollPane(svgCanvas));
			} else {
				contentPane.add(BorderLayout.CENTER, svgCanvas);				
			}
			frame.setLayout(new BorderLayout());
			frame.add(BorderLayout.CENTER, panel);
			frame.setEnabled(true);
			
			IWorkspace workspace = ResourcesPlugin.getWorkspace();
			updater = new SVGResourceChangeListener();
			workspace.addResourceChangeListener(updater);
		} catch (Throwable t) {
			//Status s = new Status(0,"",0,t.getMessage(),t);
			//ErrorDialog d = new ErrorDialog(this.getShell(),"Error",t.getMessage(),s,IStatus.ERROR);
		}
	}
	
	public void dispose() {
				
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		workspace.removeResourceChangeListener(updater);
		
		svgCanvas.dispose();
		frame.dispose();
		super.dispose();
	}
	
	public void setSVGPath(IPath path) {
	    try {
	        URL url = path.toFile().toURL();
	        setSVGFile(url);
	        this.svgURI = path.toFile().toURI();
	    } catch (MalformedURLException e) {
	        e.printStackTrace();
	    }
	}
	
	public void setSVGFile(IFile f) {
		svgFile = f;
		svgProject = f.getProject();
		this.svgURI = f.getLocationURI();
		paintSVGFile();
	}
	
	public void setSVGFile(URL url) {
		try {
			this.svgURI = url.toURI();
		} catch (URISyntaxException e) {
			Tools.showDialog("Error converting URL "+url+" to URI when trying to load svg file.", e);
		}
		try{
			svgCanvas.loadSVGDocument(url.toExternalForm());
		}catch(Exception e){
			Tools.showDialog("Failed to load svg image: "+url, e);
		}
	}
	
	public void paintSVGFile() {
		try {
			if (svgFile != null) {
				URL url = svgFile.getLocation().toFile().toURL();
				svgCanvas.loadSVGDocument(url.toExternalForm());
			}else if(svgURI != null){
				svgCanvas.loadSVGDocument(svgURI.toURL().toExternalForm());
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Callback of ISelectionListener that listens on selection of svg-files
	 * in the file navigator/project explorer. Will load the svg file from the
	 * selected IFile. 
	 */
	public void selectionChanged(IWorkbenchPart part, ISelection s) {
		if (s instanceof IStructuredSelection) {
			IStructuredSelection ss = (IStructuredSelection) s;
			Object obj = ss.getFirstElement();
			if (obj instanceof IFile) {
				IFile f = (IFile) obj;
				IPath path = (IPath) f.getLocation();
				if (path != null) {
					if (path.toFile().exists()) {
						if (path.getFileExtension().equals("svg") //$NON-NLS-1$
								|| path.getFileExtension().equals("svgz")) { //$NON-NLS-1$
							if (svgFile == null || !(svgFile.equals(f))) {
								setSVGFile(f);
							}
						}
					}
				}
			}
		}
	}
	
	public class SVGResourceChangeListener implements IResourceChangeListener {
		public void resourceChanged(IResourceChangeEvent event) {
			if (svgFile != null) {
				final IPath svgPath = svgFile.getLocation();
				
				final IPath PATH =
					new Path(
							svgProject.getName()
							+ "/" //$NON-NLS-1$
							+ svgFile.getProjectRelativePath());
				
				//we are only interested in POST_CHANGE events
				if (event.getType() != IResourceChangeEvent.POST_CHANGE)
					return;
				IResourceDelta rootDelta = event.getDelta();
				//get the delta, if any, for the documentation directory
				IResourceDelta docDelta = rootDelta.findMember(PATH);
				if (docDelta == null)
					return;
				final ArrayList changed = new ArrayList();
				IResourceDeltaVisitor visitor = new IResourceDeltaVisitor() {
					public boolean visit(IResourceDelta delta) {
						//only interested in changed resources (not added or
						// removed)
						if (delta.getKind() != IResourceDelta.CHANGED)
							return true;
						//only interested in content changes
						if ((delta.getFlags() & IResourceDelta.CONTENT) == 0)
							return true;
						IResource resource = delta.getResource();
						
						IPath path = resource.getLocation();
						
						if (path.equals(svgPath)) {
							paintSVGFile();
						}
						
						return true;
					}
				};
				try {
					docDelta.accept(visitor);
				} catch (CoreException e) {
					//BatikUIPlugin.getDefault().getLog().log(e.getStatus());
					Tools.showDialog(e);
					
					//open error dialog with syncExec or print to plugin log file
				}
				//nothing more to do if there were no changed text files
				if (changed.size() == 0)
					return;
			}
		}
	}

	public JSVGCanvas getSvgCanvas() {
		return svgCanvas;
	}

	public URI getSvgFile() throws URISyntaxException {
		if(svgURI == null)
			throw new URISyntaxException("null","No URI available: "+svgURI);
		return svgURI;
	}
	
	//
	// UserAgent
	//
	
	/**
	 * This class implements a SVG user agent.
	 */
	protected class MyUserAgent implements SVGUserAgent {
		
		/**
		 * Creates a new SVGUserAgent.
		 */
		protected MyUserAgent() {
		}
		
		public String getDefaultFontFamily() {
			return "arial"; //$NON-NLS-1$
		}
		
		/**
		 * Displays an error message.
		 */
		public void displayError(String message) {
			if (debug) {
				System.err.println(message);
			}
			
			final String fMessage = message;
			shell.getDisplay().syncExec(new Runnable() {
				public void run() {
					Exception ex = new Exception(fMessage);
					ex.printStackTrace();
					Status status = new Status(Status.ERROR,KevPlugin.getDefault().getBundle().getSymbolicName(),Status.OK,fMessage, ex);;
					ErrorDialog.openError(shell,"Error",fMessage,status);
				}
			});
		}
		
		/**
		 * Displays an error resulting from the specified Exception.
		 */
		public void displayError(Exception ex) {
			if (debug) {
				ex.printStackTrace();
			}
			final Exception fex = ex;
			shell.getDisplay().syncExec(new Runnable() {
				public void run() {
				    String msg = fex.getMessage();
				    if (msg == null) {
				        msg = "NO MESSAGE";
				    }
					Status status = new Status(Status.ERROR,KevPlugin.getDefault().getBundle().getSymbolicName(),Status.OK,msg, fex);;
					ErrorDialog.openError(shell,"Error",fex.getMessage(),status);
				}
			});
		}
		
		/**
		 * Displays a message in the User Agent interface. The given message is
		 * typically displayed in a status bar.
		 */
		public void displayMessage(String message) {
			final String fMessage = message;
			shell.getDisplay().syncExec(new Runnable() {
				public void run() {
					MessageDialog.openInformation(shell,"Message",fMessage);
				}
			});
		}
		
		/**
		 * Shows an alert dialog box.
		 */
		public void showAlert(String message) {
			final String fMessage = message;
			shell.getDisplay().syncExec(new Runnable() {
				public void run() {
					Tools.showDialog(fMessage);
					//MessageDialog.openWarning(shell, Messages.getString("SVGView.40"), fMessage); //$NON-NLS-1$
				}
			});
		}
		
		/**
		 * Shows a prompt dialog box.
		 */
		public String showPrompt(String message) {
			return svgCanvas.showPrompt(message);
		}
		
		/**
		 * Shows a prompt dialog box.
		 */
		public String showPrompt(String message, String defaultValue) {
			return svgCanvas.showPrompt(message, defaultValue);
		}
		
		/**
		 * Shows a confirm dialog box.
		 */
		public boolean showConfirm(String message) {
			return true;
		}
		
		/**
		 * Returns the size of a px CSS unit in millimeters.
		 */
		public float getPixelUnitToMillimeter() {
			return 0.26458333333333333333333333333333f; // 96dpi
		}
		
		/**
		 * Returns the size of a px CSS unit in millimeters. This will be
		 * removed after next release.
		 * 
		 * @see #getPixelUnitToMillimeter();
		 */
		public float getPixelToMM() {
			return getPixelUnitToMillimeter();
			
		}
		
		/**
		 * Returns the medium font size.
		 */
		public float getMediumFontSize() {
			// 9pt (72pt == 1in)
			return 9f * 25.4f / (72f * getPixelUnitToMillimeter());
		}
		
		/**
		 * Returns a lighter font-weight.
		 */
		public float getLighterFontWeight(float f) {
			// Round f to nearest 100...
			int weight = ((int) ((f + 50) / 100)) * 100;
			switch (weight) {
			case 100 :
				return 100;
			case 200 :
				return 100;
			case 300 :
				return 200;
			case 400 :
				return 300;
			case 500 :
				return 400;
			case 600 :
				return 400;
			case 700 :
				return 400;
			case 800 :
				return 400;
			case 900 :
				return 400;
			default :
				throw new IllegalArgumentException("Bad Font Weight " + f); //$NON-NLS-1$
			}
		}
		
		/**
		 * Returns a bolder font-weight.
		 */
		public float getBolderFontWeight(float f) {
			// Round f to nearest 100...
			int weight = ((int) ((f + 50) / 100)) * 100;
			switch (weight) {
			case 100 :
				return 600;
			case 200 :
				return 600;
			case 300 :
				return 600;
			case 400 :
				return 600;
			case 500 :
				return 600;
			case 600 :
				return 700;
			case 700 :
				return 800;
			case 800 :
				return 900;
			case 900 :
				return 900;
			default :
				throw new IllegalArgumentException("Bad Font Weight " + f); //$NON-NLS-1$
			}
		}
		
		/**
		 * Returns the language settings.
		 */
		public String getLanguages() {
			return Locale.getDefault().getLanguage();
		}
		
		/**
		 * Returns the user stylesheet uri.
		 * 
		 * @return null if no user style sheet was specified.
		 */
		public String getUserStyleSheetURI() {
			return null;
		}
		
		/**
		 * Returns the class name of the XML parser.
		 */
		public String getXMLParserClassName() {
		    return "org.apache.crimson.parser.XMLReaderImpl"; //$NON-NLS-1$
		}

	     
		/**
		 * Returns true if the XML parser must be in validation mode, false
		 * otherwise.
		 */
		public boolean isXMLParserValidating() {
			return false;
		}
		
		/**
		 * Returns this user agent's CSS media.
		 */
		public String getMedia() {
			return "screen"; //$NON-NLS-1$
		}
		
		/**
		 * Returns this user agent's alternate style-sheet title.
		 */
		public String getAlternateStyleSheet() {
			return null;
		}
		
		/**
		 * Opens a link.
		 * 
		 * @param uri
		 *            The document URI.
		 * @param newc
		 *            Whether the link should be activated in a new component.
		 */
		public void openLink(String uri, boolean newc) {
		}
		
		/**
		 * Tells whether the given extension is supported by this user agent.
		 */
		public boolean supportExtension(String s) {
			return false;
		}
		
		public void handleElement(Element elt, Object data) {
		}
		
		/**
		 * Returns the security settings for the given script type, script url
		 * and document url
		 * 
		 * @param scriptType
		 *            type of script, as found in the type attribute of the
		 *            &lt;script&gt; element.
		 * @param scriptURL
		 *            url for the script, as defined in the script's xlink:href
		 *            attribute. If that attribute was empty, then this
		 *            parameter should be null
		 * @param docURL
		 *            url for the document into which the script was found.
		 */
		public ScriptSecurity getScriptSecurity(
				String scriptType,
				ParsedURL scriptURL,
				ParsedURL docURL) {
			return new NoLoadScriptSecurity(scriptType);
		}
		
		/**
		 * This method throws a SecurityException if the script of given type,
		 * found at url and referenced from docURL should not be loaded.
		 * 
		 * This is a convenience method to call checkLoadScript on the
		 * ScriptSecurity strategy returned by getScriptSecurity.
		 * 
		 * @param scriptType
		 *            type of script, as found in the type attribute of the
		 *            &lt;script&gt; element.
		 * @param scriptURL
		 *            url for the script, as defined in the script's xlink:href
		 *            attribute. If that attribute was empty, then this
		 *            parameter should be null
		 * @param docURL
		 *            url for the document into which the script was found.
		 */
		public void checkLoadScript(
				String scriptType,
				ParsedURL scriptURL,
				ParsedURL docURL)
		throws SecurityException {
		}
		
		/**
		 * Returns the security settings for the given resource url and
		 * document url
		 * 
		 * @param resourceURL
		 *            url for the resource, as defined in the resource's
		 *            xlink:href attribute. If that attribute was empty, then
		 *            this parameter should be null
		 * @param docURL
		 *            url for the document into which the resource was found.
		 */
		public ExternalResourceSecurity getExternalResourceSecurity(
				ParsedURL resourceURL,
				ParsedURL docURL) {
			return new NoLoadExternalResourceSecurity();
		}
		
		/**
		 * This method throws a SecurityException if the resource found at url
		 * and referenced from docURL should not be loaded.
		 * 
		 * This is a convenience method to call checkLoadExternalResource on
		 * the ExternalResourceSecurity strategy returned by
		 * getExternalResourceSecurity.
		 * 
		 * @param scriptURL
		 *            url for the script, as defined in the script's xlink:href
		 *            attribute. If that attribute was empty, then this
		 *            parameter should be null
		 * @param docURL
		 *            url for the document into which the script was found.
		 */
		public void checkLoadExternalResource(
				ParsedURL resourceURL,
				ParsedURL docURL)
		throws SecurityException {
		}
	}
	
	

}
