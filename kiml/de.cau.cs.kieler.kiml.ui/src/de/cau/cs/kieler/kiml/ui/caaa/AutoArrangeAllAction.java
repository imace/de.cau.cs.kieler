/******************************************************************************
 * KIELER - Kiel Integrated Environment for Layout for the Eclipse RCP
 *
 * http://www.informatik.uni-kiel.de/rtsys/kieler/
 * 
 * Copyright 2008 by
 * + Christian-Albrechts-University of Kiel
 *   + Department of Computer Science
 *     + Real-Time and Embedded Systems Group
 * 
 * This code is provided under the terms of the Eclipse Public License (EPL).
 * See the file epl-v10.html for the license text.
 */
package de.cau.cs.kieler.kiml.ui.caaa;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gef.Request;
import org.eclipse.gmf.runtime.diagram.ui.actions.DiagramAction;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramGraphicalViewer;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramGraphicalViewer;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;

import de.cau.cs.kieler.kiml.ui.caaa.l10n.CaaaMessages;
import de.cau.cs.kieler.kiml.ui.caaa.l10n.CaaaPluginImages;


/**
 * Checked action for the Auto Arrange All workspace property
 * 
 * <p>
 * Delegates the current editor (or
 * <code>null</<code> if disabled) to an <code>AutoArrangeListener</code>, which performs the proper auto arranging.</p>
 * 
 * @author <a href="mailto:cwu@informatik.uni-kiel.de">Christoph Wulf</a>
 * @author <a href="mailto:jhed@informatik.uni-kiel.de">Johannes Hedtrich</a> 
 */
public class AutoArrangeAllAction extends DiagramAction {

	/* Action ID */
	static final String ACTION_ID = "caaa";

	/* Preference store key for the feature */
	private static final String PROPERTIES_KEY = "de.cau.cs.kieler.kiml.ui.caaa.AutoArrangeAll";

	/* ResourceSetListener for the active editor, performs the arranging */
	private final AutoArrangeListener listener;

	/**
	 * Create a Auto Arrange All Action.
	 * 
	 * @param workbenchPage
	 */
	public AutoArrangeAllAction(IWorkbenchPage workbenchPage) {
		super(workbenchPage);
		setId(ACTION_ID);
		setText(CaaaMessages.AutoArrangeAll_textLabel);
		setToolTipText(CaaaMessages.AutoArrangeAll_toolTip);
		setImageDescriptor(CaaaPluginImages.DESC_AUTO_ARRANGE_ALL);

		listener = new AutoArrangeListener();
	}

	/**
	 * Returns null, this action modifies the workspace preference only.
	 * 
	 * @returns null
	 * @see org.eclipse.gmf.runtime.diagram.ui.actions.DiagramAction#createTargetRequest()
	 */
	protected Request createTargetRequest() {
		return null;
	}

	/**
	 * Sets the action style to AS_CHECK_BOX (Toggle Button)
	 */
	public int getStyle() {
		return AS_CHECK_BOX;
	}

	/**
	 * Calculates the enablement state of the action. This action is enabled if
	 * the diagram is selected.
	 * 
	 * @return <code>true</code> if the diagram is selected
	 */
	protected boolean calculateEnabled() {
		return getDiagramGraphicalViewer() != null;
	}

	/**
	 * Updates the workspace preference store's PROPERTIES_KEY value. <br>
	 * <br>
	 * The active <code>DiagramEditor</code> (or <code>null</code> if not
	 * selected) is delegated to the listener.<br>
	 * If the button is selected, Arrange All is executed.
	 */
	protected void doRun(IProgressMonitor progressMonitor) {
		((DiagramGraphicalViewer) getDiagramGraphicalViewer())
				.getWorkspaceViewerPreferenceStore().setValue(PROPERTIES_KEY,
						isChecked());

		listener
				.listenToEditor(isChecked() ? (DiagramEditor) getDiagramWorkbenchPart()
						: null);
		if (isChecked()) {
			// initial arrange on activation
			listener.run();
		}
	}

	/**
	 * This action is interested in selection.
	 * 
	 * @return true
	 * @see org.eclipse.gmf.runtime.common.ui.action.AbstractActionHandler#isSelectionListener()
	 */
	public boolean isSelectionListener() {
		return true;
	}

	/**
	 * Overrides setWorkbenchPart to reset checked value based on preference
	 * store of currently selected <code>DiagramEditor</code>.
	 * <p>
	 * In case of a <code>DiagramEditor</code> and the selection of the
	 * feature, the listener is asked to listen to the new editor.
	 * </p>
	 * 
	 * @param workbenchPart
	 */
	@Override
	protected void setWorkbenchPart(IWorkbenchPart workbenchPart) {
		super.setWorkbenchPart(workbenchPart);

		if ((workbenchPart != null) && (isSelectionListener())) {
			// set checked to 'false' if the IWorkbenchPart is not a
			// DiagramEditor or it's viewer has no preference store.
			boolean shouldBeChecked = false;

			if (workbenchPart instanceof DiagramEditor) {

				DiagramEditor editor = (DiagramEditor) workbenchPart;

				// retrieve state from the preference store if available
				IDiagramGraphicalViewer viewer = editor
						.getDiagramGraphicalViewer();
				if (viewer != null) {
					IPreferenceStore preferenceStore = ((DiagramGraphicalViewer) viewer)
							.getWorkspaceViewerPreferenceStore();
					if (preferenceStore != null) {
						shouldBeChecked = preferenceStore
								.getBoolean(PROPERTIES_KEY);
					}
				}
				this.setChecked(shouldBeChecked);

				// Tell the listener to register at new editor if selected or
				// unregister from current if not checked.
				listener.listenToEditor(shouldBeChecked ? editor : null);
				if (shouldBeChecked) {
					// intial arrange
					listener.run();
				}
			} else {
				// unregister from current editor
				listener.listenToEditor(null);
			}
		}
	}
}
