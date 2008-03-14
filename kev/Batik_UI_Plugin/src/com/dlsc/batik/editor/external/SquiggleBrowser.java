package com.dlsc.batik.editor.external;

//import org.apache.batik.apps.svgbrowser.Main;
import org.eclipse.core.runtime.IPath;
import org.eclipse.ui.IEditorLauncher;

/**
 * @see IEditorLauncher
 */
public class SquiggleBrowser implements IEditorLauncher {
	/**
	 *  
	 */
	public SquiggleBrowser() {
	}

	/**
	 * @see IEditorLauncher#open
	 */
	public void open(IPath file) {			
		try {
			String[] args = {};
//			Main browser = new Main(args);
//			browser.run();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
