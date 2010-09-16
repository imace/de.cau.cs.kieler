package de.cau.cs.kieler.synccharts.diagram.part;

import java.util.Iterator;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gmf.runtime.common.ui.services.marker.MarkerNavigationService;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.ui.actions.ActionIds;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.IDiagramDocument;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.IDocument;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.IDocumentProvider;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.parts.DiagramDocumentEditor;
import org.eclipse.gmf.runtime.notation.Connector;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorMatchingStrategy;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.SaveAsDialog;
import org.eclipse.ui.ide.IGotoMarker;
import org.eclipse.ui.navigator.resources.ProjectExplorer;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.part.IShowInTargetList;
import org.eclipse.ui.part.ShowInContext;

import de.cau.cs.kieler.core.KielerRuntimeException;
import de.cau.cs.kieler.synccharts.Region;
import de.cau.cs.kieler.synccharts.diagram.navigator.SyncchartsNavigatorItem;
import de.cau.cs.kieler.synccharts.text.actions.bridge.ActionLabelProcessorWrapper;

/**
 * @generated
 */
public class SyncchartsDiagramEditor extends DiagramDocumentEditor implements IGotoMarker {

	/**
 	 * Manually added method.
 	 * Deletes orphaned notation elements to avoid broken transition connects etc.
 	 * Serializes labels as they are not stored in textual kits files.
 	 * Triggers the canonical edit policies to encompass newly introduced model elements.
 	 * Finally, cleans up the command stack (removes history) and resets the dirty state. 
	 * 
	 * @author chsch
	 */
    protected void initializeGraphicalViewerContents() {
        Diagram d = getDiagram();
        CompoundCommand CC = new CompoundCommand();
        Object o = null;
        for (Iterator<?> it = d.eAllContents(); it.hasNext();) {
            o = it.next();
            if (NotationPackage.eINSTANCE.getView().isInstance(o)
                    && ((InternalEObject) ((View) o).getElement()).eIsProxy()) {
                if (NotationPackage.eINSTANCE.getConnector().isInstance(o)) {
                    CC.append(new RemoveCommand(getEditingDomain(), ((Connector) o).getSource()
                            .getSourceEdges(), o));
                    CC.append(new RemoveCommand(getEditingDomain(), ((Connector) o).getTarget()
                            .getTargetEdges(), o));
                    CC.append(new RemoveCommand(getEditingDomain(), getDiagram()
                            .getPersistedEdges(), o));
                } else {
                    CC.append(new RemoveCommand(getEditingDomain(),
                            ((View) ((View) o).eContainer()).getPersistedChildren(), o));
                }
            }
        }
        getEditingDomain().getCommandStack().execute(CC);

        // new de.cau.cs.kieler.synccharts.text.actions.bridge.ActionLabelSerializeCommand
        if (d.getElement() instanceof Region) {
            try {
                ActionLabelProcessorWrapper.processActionLabels(d.getElement(),
                        ActionLabelProcessorWrapper.SERIALIZE);
            } catch (Exception e) {
                throw new KielerRuntimeException("Transition labels could not be serialized properly.");
            }
        }
        
        super.initializeGraphicalViewerContents();

        for (CanonicalEditPolicy c : CanonicalEditPolicy.getRegisteredEditPolicies(d.getElement())) {
            c.refresh();
        }

        getGraphicalViewer().flush();

        // remove the dirty state of the editor
        this.getCommandStack().dispose();
        ((SyncchartsDocumentProvider) this.getDocumentProvider()).setCanBeSaved(false);        
    }

    /**
     * @generated
     */
    public static final String ID = "de.cau.cs.kieler.synccharts.diagram.part.SyncchartsDiagramEditorID"; //$NON-NLS-1$

    /**
     * @generated
     */
    public static final String CONTEXT_ID = "de.cau.cs.kieler.synccharts.diagram.ui.diagramContext"; //$NON-NLS-1$

    /**
     * @generated
     */
    public SyncchartsDiagramEditor() {
        super(true);
    }

    /**
     * @generated
     */
    protected String getContextID() {
        return CONTEXT_ID;
    }

    /**
     * @generated
     */
    protected PaletteRoot createPaletteRoot(PaletteRoot existingPaletteRoot) {
        PaletteRoot root = super.createPaletteRoot(existingPaletteRoot);
        new SyncchartsPaletteFactory().fillPalette(root);
        return root;
    }

    /**
     * @generated
     */
    protected PreferencesHint getPreferencesHint() {
        return SyncchartsDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT;
    }

    /**
     * @generated
     */
    public String getContributorId() {
        return SyncchartsDiagramEditorPlugin.ID;
    }

    /**
     * @generated
     */
    @SuppressWarnings("rawtypes")
    public Object getAdapter(Class type) {
        if (type == IShowInTargetList.class) {
            return new IShowInTargetList() {
                public String[] getShowInTargetIds() {
                    return new String[] { ProjectExplorer.VIEW_ID };
                }
            };
        }
        return super.getAdapter(type);
    }

    /**
     * @generated
     */
    protected IDocumentProvider getDocumentProvider(IEditorInput input) {
        if (input instanceof IFileEditorInput || input instanceof URIEditorInput) {
            return SyncchartsDiagramEditorPlugin.getInstance().getDocumentProvider();
        }
        return super.getDocumentProvider(input);
    }

    /**
     * @generated
     */
    public TransactionalEditingDomain getEditingDomain() {
        IDocument document = getEditorInput() != null ? getDocumentProvider().getDocument(
                getEditorInput()) : null;
        if (document instanceof IDiagramDocument) {
            return ((IDiagramDocument) document).getEditingDomain();
        }
        return super.getEditingDomain();
    }

    /**
     * @generated
     */
    protected void setDocumentProvider(IEditorInput input) {
        if (input instanceof IFileEditorInput || input instanceof URIEditorInput) {
            setDocumentProvider(SyncchartsDiagramEditorPlugin.getInstance().getDocumentProvider());
        } else {
            super.setDocumentProvider(input);
        }
    }

    /**
     * @generated
     */
    public void gotoMarker(IMarker marker) {
        MarkerNavigationService.getInstance().gotoMarker(this, marker);
    }

    /**
     * @generated
     */
    public boolean isSaveAsAllowed() {
        return true;
    }

    /**
     * @generated
     */
    public void doSaveAs() {
        performSaveAs(new NullProgressMonitor());
    }

    /**
     * @generated
     */
    protected void performSaveAs(IProgressMonitor progressMonitor) {
        Shell shell = getSite().getShell();
        IEditorInput input = getEditorInput();
        SaveAsDialog dialog = new SaveAsDialog(shell);
        IFile original = input instanceof IFileEditorInput ? ((IFileEditorInput) input).getFile()
                : null;
        if (original != null) {
            dialog.setOriginalFile(original);
        }
        dialog.create();
        IDocumentProvider provider = getDocumentProvider();
        if (provider == null) {
            // editor has been programmatically closed while the dialog was open
            return;
        }
        if (provider.isDeleted(input) && original != null) {
            String message = NLS.bind(Messages.SyncchartsDiagramEditor_SavingDeletedFile,
                    original.getName());
            dialog.setErrorMessage(null);
            dialog.setMessage(message, IMessageProvider.WARNING);
        }
        if (dialog.open() == Window.CANCEL) {
            if (progressMonitor != null) {
                progressMonitor.setCanceled(true);
            }
            return;
        }
        IPath filePath = dialog.getResult();
        if (filePath == null) {
            if (progressMonitor != null) {
                progressMonitor.setCanceled(true);
            }
            return;
        }
        IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
        IFile file = workspaceRoot.getFile(filePath);
        final IEditorInput newInput = new FileEditorInput(file);
        // Check if the editor is already open
        IEditorMatchingStrategy matchingStrategy = getEditorDescriptor()
                .getEditorMatchingStrategy();
        IEditorReference[] editorRefs = PlatformUI.getWorkbench().getActiveWorkbenchWindow()
                .getActivePage().getEditorReferences();
        for (int i = 0; i < editorRefs.length; i++) {
            if (matchingStrategy.matches(editorRefs[i], newInput)) {
                MessageDialog.openWarning(shell, Messages.SyncchartsDiagramEditor_SaveAsErrorTitle,
                        Messages.SyncchartsDiagramEditor_SaveAsErrorMessage);
                return;
            }
        }
        boolean success = false;
        try {
            provider.aboutToChange(newInput);
            getDocumentProvider(newInput).saveDocument(progressMonitor, newInput,
                    getDocumentProvider().getDocument(getEditorInput()), true);
            success = true;
        } catch (CoreException x) {
            IStatus status = x.getStatus();
            if (status == null || status.getSeverity() != IStatus.CANCEL) {
                ErrorDialog.openError(shell, Messages.SyncchartsDiagramEditor_SaveErrorTitle,
                        Messages.SyncchartsDiagramEditor_SaveErrorMessage, x.getStatus());
            }
        } finally {
            provider.changed(newInput);
            if (success) {
                setInput(newInput);
            }
        }
        if (progressMonitor != null) {
            progressMonitor.setCanceled(!success);
        }
    }

    /**
     * @generated
     */
    public ShowInContext getShowInContext() {
        return new ShowInContext(getEditorInput(), getNavigatorSelection());
    }

    /**
     * @generated
     */
    private ISelection getNavigatorSelection() {
        IDiagramDocument document = getDiagramDocument();
        if (document == null) {
            return StructuredSelection.EMPTY;
        }
        Diagram diagram = document.getDiagram();
        IFile file = WorkspaceSynchronizer.getFile(diagram.eResource());
        if (file != null) {
            SyncchartsNavigatorItem item = new SyncchartsNavigatorItem(diagram, file, false);
            return new StructuredSelection(item);
        }
        return StructuredSelection.EMPTY;
    }

    /**
     * @generated
     */
    protected void configureGraphicalViewer() {
        super.configureGraphicalViewer();
        DiagramEditorContextMenuProvider provider = new DiagramEditorContextMenuProvider(this,
                getDiagramGraphicalViewer());
        getDiagramGraphicalViewer().setContextMenu(provider);
        getSite().registerContextMenu(ActionIds.DIAGRAM_EDITOR_CONTEXT_MENU, provider,
                getDiagramGraphicalViewer());
    }

}
