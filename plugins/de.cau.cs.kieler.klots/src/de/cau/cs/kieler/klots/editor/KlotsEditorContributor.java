/*
 * KIELER - Kiel Integrated Environment for Layout Eclipse Rich Client
 *
 * http://www.informatik.uni-kiel.de/rtsys/kieler/
 * 
 * Copyright 2011 by
 * + Christian-Albrechts-University of Kiel
 *   + Department of Computer Science
 *     + Real-Time and Embedded Systems Group
 * 
 * This code is provided under the terms of the Eclipse Public License (EPL).
 * See the file epl-v10.html for the license text.
 */
package de.cau.cs.kieler.klots.editor;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.ide.IDEActionFactory;
import org.eclipse.ui.part.EditorActionBarContributor;
import org.eclipse.ui.texteditor.ITextEditor;
import org.eclipse.ui.texteditor.ITextEditorActionConstants;

import de.cau.cs.kieler.klots.KlotsPlugin;
import de.cau.cs.kieler.klots.util.KlotsConstants;
import de.cau.cs.kieler.klots.util.KlotsJob;
import de.cau.cs.kieler.klots.util.RemotePrintReceiver;


/**
 * Manages the installation/deinstallation of global actions for multi-page editors.
 * Responsible for the redirection of global actions to the active editor.
 * Multi-page contributor replaces the contributors for the individual editors in the multi-page editor.
 * 
 * @author root
 *
 */
public class KlotsEditorContributor extends EditorActionBarContributor {

    private static final int KLOTS_CONSOLE_WARM_UP_TIME = 10; 
    
    private IEditorPart activeEditorPart;
    private Action compileAndLink;
    private Action downloadToNXT;
    private Action runProgram;
    private Action klotsConsoleToggleButton;



    /**
     * Creates a multi-page contributor.
     */
    public KlotsEditorContributor() {
        super();
        createActions();
    }



    /**
     * Returns the action registed with the given text editor.
     * 
     * @param editor 
     * @param actionID 
     * @return IAction or null if editor is null.
     */
    protected IAction getAction(final ITextEditor editor, final String actionID) {
        return (editor == null ? null : editor.getAction(actionID));
    }



    /**
     * {@inheritDoc}
     */
    public void setActivePage(final IEditorPart part) {
        if (activeEditorPart == part) {
            return;
        }

        activeEditorPart = part;

        IActionBars actionBars = getActionBars();
        if (actionBars != null) {

            ITextEditor editor = (part instanceof ITextEditor) ? (ITextEditor) part : null;

            actionBars.setGlobalActionHandler(ActionFactory.DELETE.getId(),
                    getAction(editor, ITextEditorActionConstants.DELETE));
            actionBars.setGlobalActionHandler(ActionFactory.UNDO.getId(),
                    getAction(editor, ITextEditorActionConstants.UNDO));
            actionBars.setGlobalActionHandler(ActionFactory.REDO.getId(),
                    getAction(editor, ITextEditorActionConstants.REDO));
            actionBars.setGlobalActionHandler(ActionFactory.CUT.getId(),
                    getAction(editor, ITextEditorActionConstants.CUT));
            actionBars.setGlobalActionHandler(ActionFactory.COPY.getId(),
                    getAction(editor, ITextEditorActionConstants.COPY));
            actionBars.setGlobalActionHandler(ActionFactory.PASTE.getId(),
                    getAction(editor, ITextEditorActionConstants.PASTE));
            actionBars.setGlobalActionHandler(ActionFactory.SELECT_ALL.getId(),
                    getAction(editor, ITextEditorActionConstants.SELECT_ALL));
            actionBars.setGlobalActionHandler(ActionFactory.FIND.getId(),
                    getAction(editor, ITextEditorActionConstants.FIND));
            actionBars.setGlobalActionHandler(IDEActionFactory.BOOKMARK.getId(),
                    getAction(editor, IDEActionFactory.BOOKMARK.getId()));
            actionBars.updateActionBars();
        }
    }



    private void createActions() {
        // ---------------------- compile and link --------------------------
        compileAndLink = new Action() {
            public void run() {
                KlotsJob job = new KlotsJob(KlotsJob.LINK_JOB,
                        KlotsPlugin.getDefault().getWorkbench().getActiveWorkbenchWindow()
                        .getActivePage().getActiveEditor());
                job.setUser(true);
                job.schedule();
            }
        };
        compileAndLink.setText("Build program");
        compileAndLink.setToolTipText("Build Embedded SJ program");
        compileAndLink.setImageDescriptor(
                KlotsPlugin.imageDescriptorFromPlugin(KlotsPlugin.PLUGIN_ID, "icons/linkIcon.png"));
//        compileAndLink.setDisabledImageDescriptor(
//                KlotsPlugin.imageDescriptorFromPlugin(
//                        KlotsPlugin.PLUGIN_ID, "icons/KIEMstepIconDisabled.png"));


        // ------------------------ download to NXT -------------------------
        downloadToNXT = new Action() {
            public void run() {
                KlotsJob job = new KlotsJob(KlotsJob.DOWNLOAD_JOB,
                        KlotsPlugin.getDefault().getWorkbench().getActiveWorkbenchWindow()
                        .getActivePage().getActiveEditor());
                job.setUser(true);
                job.schedule();
            }
        };
        downloadToNXT.setText("Download to NXT");
        downloadToNXT.setToolTipText("Download Embedded SJ program to NXT");
        downloadToNXT.setImageDescriptor(
                KlotsPlugin.imageDescriptorFromPlugin(KlotsPlugin.PLUGIN_ID, "icons/downloadIcon.png"));
//        downloadToNXT.setDisabledImageDescriptor(
//                KlotsPlugin.imageDescriptorFromPlugin(KlotsPlugin.PLUGIN_ID,
//                        "icons/KIEMstepIconDisabled.png"));


        // -------------------------- run program ---------------------------
        runProgram = new Action() {
            public void run() {
//                klotsConsoleToggleButton.setEnabled(true);
//                klotsConsoleToggleButton.setChecked(true);
//                KlotsConsole.getInstance().setEnabled(true);
                klotsConsoleToggleButton.setChecked(true);
                // wait for remaining 'print data' from previous execution, if any, to drain
                try {
                    Thread.sleep(KLOTS_CONSOLE_WARM_UP_TIME);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                KlotsJob job = new KlotsJob(KlotsJob.RUN_JOB,
                        KlotsPlugin.getDefault().getWorkbench().getActiveWorkbenchWindow()
                        .getActivePage().getActiveEditor());
                job.setUser(true);
                job.schedule();
            }
        };
        runProgram.setText("Run program on NXT");
        runProgram.setToolTipText("Run program on NXT");
        runProgram.setImageDescriptor(
                KlotsPlugin.imageDescriptorFromPlugin(KlotsPlugin.PLUGIN_ID,
                        "icons/runProgramIcon.png"));
//        runProgram.setDisabledImageDescriptor(
//                KlotsPlugin.imageDescriptorFromPlugin(KlotsPlugin.PLUGIN_ID,
//                        "icons/runProgramIconDisabled.png"));
        
        
        // ------------------ KLOTS console toggle button -------------------
        klotsConsoleToggleButton = new Action(
                KlotsConstants.KLOTS_SHORT_NAME + " console", IAction.AS_CHECK_BOX) {
            public void run() {
                if (klotsConsoleToggleButton.isChecked()) {
                    klotsConsoleToggleButton.setText("Disable console");
                    klotsConsoleToggleButton.setToolTipText("Disable console");
                } else {
                    klotsConsoleToggleButton.setText("Enable console");
                    klotsConsoleToggleButton.setToolTipText("Enable console");
                }
            }
        };
        klotsConsoleToggleButton.addPropertyChangeListener(new IPropertyChangeListener() {
            public void propertyChange(final PropertyChangeEvent event) {
                if (event.getProperty().equals("checked")) {
                    if (event.getNewValue().toString().equals("true")) {
                        //KlotsConsole.getInstance().setEnabled(true);
                        if (RemotePrintReceiver.exists()
                                && RemotePrintReceiver.getInstance().isPaused()) {
                            System.out.println("++++++++ CONSOLE BUTTON -> printer.proceed()!");
                            RemotePrintReceiver.getInstance().proceed();
                        }
                    } else {
                        //KlotsConsole.getInstance().setEnabled(false);
                        if (RemotePrintReceiver.exists()
                                && !RemotePrintReceiver.getInstance().isPaused()) {
                            System.out.println("++++++++ CONSOLE BUTTON -> printer.pause()!");
                            RemotePrintReceiver.getInstance().pause();
                        }
                    }
                }
            }
            
        });
//        KlotsConsole.getInstance().setEnabled(true);
//        klotsConsoleToggleButton.setText("Disable console");
//        klotsConsoleToggleButton.setToolTipText("Disable console");
//        klotsConsoleToggleButton.setEnabled(true);
        
//        klotsConsoleToggleButton.setEnabled(false);
        
        klotsConsoleToggleButton.setImageDescriptor(KlotsPlugin.imageDescriptorFromPlugin(
                        KlotsPlugin.PLUGIN_ID, "icons/KLOTSConsoleIcon.png"));
//        klotsConsoleToggleButton.setDisabledImageDescriptor(
//                KlotsPlugin.imageDescriptorFromPlugin(KlotsPlugin.PLUGIN_ID,
//                        "icons/KLOTSConsoleIconDisabled.png"));
        // ------------------------------------------------------------------

    }



    // ----------------------------------------------------------------------
    // XXX: No menu contribution, for now buttons on the toolbar suffice
    //public void contributeToMenu(IMenuManager manager) {
    //IMenuManager menu = new MenuManager("Embedded &SJ &Menu");
    //manager.prependToGroup(IWorkbenchActionConstants.MB_ADDITIONS, menu);
    //menu.add(compileAndLink);
    //menu.add(downloadToNXT);
    //}
    // ----------------------------------------------------------------------


    
    /**
     * {@inheritDoc}
     */
    public void contributeToToolBar(final IToolBarManager manager) {
        manager.add(new Separator());
        manager.add(compileAndLink);
        manager.add(downloadToNXT);
        manager.add(runProgram);
        manager.add(klotsConsoleToggleButton);
        manager.add(new Separator());
    }

}