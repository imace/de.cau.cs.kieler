/*
 * KIELER - Kiel Integrated Environment for Layout Eclipse RichClient
 *
 * http://www.informatik.uni-kiel.de/rtsys/kieler/
 * 
 * Copyright 2010 by
 * + Christian-Albrechts-University of Kiel
 *   + Department of Computer Science
 *     + Real-Time and Embedded Systems Group
 * 
 * This code is provided under the terms of the Eclipse Public License (EPL).
 * See the file epl-v10.html for the license text.
 */
package de.cau.cs.kieler.kies.transformation.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramGraphicalViewer;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramWorkbenchPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.statushandlers.StatusManager;
import org.eclipse.xtend.expression.Variable;
import org.eclipse.xtext.parsetree.reconstr.Serializer;
import org.eclipse.xtext.resource.SaveOptions;

import com.google.common.collect.Lists;
import com.google.inject.Injector;

import de.cau.cs.kieler.core.kexpressions.BooleanValue;
import de.cau.cs.kieler.core.kexpressions.Expression;
import de.cau.cs.kieler.core.kexpressions.FloatValue;
import de.cau.cs.kieler.core.kexpressions.IntValue;
import de.cau.cs.kieler.core.kexpressions.KExpressionsFactory;
import de.cau.cs.kieler.core.kexpressions.TextExpression;
import de.cau.cs.kieler.core.kexpressions.TextualCode;
import de.cau.cs.kieler.core.ui.util.MonitoredOperation;
import de.cau.cs.kieler.core.util.Maybe;
import de.cau.cs.kieler.kies.EsterelStandaloneSetup;
import de.cau.cs.kieler.kies.esterel.ConstantExpression;
import de.cau.cs.kieler.kies.esterel.EsterelPackage;
import de.cau.cs.kieler.kies.transformation.Activator;
import de.cau.cs.kieler.synccharts.Action;
import de.cau.cs.kieler.synccharts.Region;
import de.cau.cs.kieler.synccharts.State;
import de.cau.cs.kieler.synccharts.StateType;
import de.cau.cs.kieler.synccharts.SyncchartsFactory;
import de.cau.cs.kieler.synccharts.diagram.part.SyncchartsDiagramEditor;
import de.cau.cs.kieler.synccharts.diagram.part.SyncchartsDiagramEditorUtil;
import de.cau.cs.kieler.synccharts.text.actions.bridge.ActionLabelSerializer;

/**
 * Utility class providing convenient methods for the esterel to synccharts transformation and the
 * pure synccharts optimization.
 * 
 * @author uru
 * 
 */
public final class TransformationUtil {

    /** KIES's own logger. */
    public static Logger logger = Logger.getLogger("kies");

    /** injector used for serialization. */
    private static Injector injector = new EsterelStandaloneSetup()
            .createInjectorAndDoEMFRegistration();;

    /** utility class. */
    private TransformationUtil() {
        // logger.setLevel(Level.OFF);
        // logger.getHandlers()[0] = new Handler() {
        //
        // @Override
        // public void publish(LogRecord record) {
        // System.out.println(record.getMessage());
        // }
        //
        // @Override
        // public void flush() {
        //
        // }
        //
        // @Override
        // public void close() throws SecurityException {
        // }
        // };
    }

    /**
     * Returns the textual representation of the passed esterel object.
     * 
     * @param e
     *            esterel object
     * @return serialized string
     */
    public static String getSerializedString(final EObject e) {
        if (!isEsterelElement(e)) {
            IStatus status = new Status(Status.WARNING, Activator.PLUGIN_ID,
                    "In this context only serialization of Esterel objects is possible.");
            StatusManager.getManager().handle(status);
            return "";
        }

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        OutputStreamWriter osw = new OutputStreamWriter(baos);
        try {
            // serialize the element
            Serializer serializerUtil = injector.getInstance(Serializer.class);
            serializerUtil.serialize(e, osw, SaveOptions.defaultOptions());
        } catch (IOException ex) {
            IStatus status = new Status(Status.WARNING, Activator.PLUGIN_ID,
                    "A problem occured while trying to serialize " + e + ".", ex);
            StatusManager.getManager().handle(status);
        }
        // return string representation
        return baos.toString();
    }

    /**
     * @param obj
     *            the {@link EObject} to test
     * @return true if {@code obj} is an esterel element, false otherwise.
     */
    public static boolean isEsterelElement(final EObject obj) {
        return EsterelPackage.eINSTANCE.eContents().contains(obj.eClass());
    }

    /**
     * Convenient method for setting the body reference for a state. A new {@link TextualCode}
     * element is created and added to the passed state. The state's type is set to
     * {@link StateType.TEXTUAL}
     * 
     * @param s
     *            the parent state
     * @param obj
     *            any {@link EObject}
     */
    public static void setBodyReference(final State s, final EObject obj) {
        if (obj != null && s != null) {
            s.setBodyReference(obj);
            TextualCode code = KExpressionsFactory.eINSTANCE.createTextualCode();
            s.setType(StateType.TEXTUAL);
            code.setCode(TransformationUtil.getSerializedString(obj));
            s.getBodyText().add(code);
        }
    }

    /**
     * Converts an Esterel {@link ConstantExpression} into an equivalent {@link Expression}. This is
     * in unambiguous order: {@link IntValue}, {@link FloatValue}, {@link BooleanValue} or an
     * {@link TextExpression} for a string constant or a referenced constant.
     * 
     * @param cexpr
     *            constant expression to convert
     * @return equivalent kexpression
     */
    public static Expression convertConstantExpression(final ConstantExpression cexpr) {
        if (cexpr == null) {
            return null;
        }

        KExpressionsFactory fac = KExpressionsFactory.eINSTANCE;
        if (cexpr.getValue() != null) {
            String val = cexpr.getValue();
            try {
                // first try integer
                IntValue intVal = fac.createIntValue();
                intVal.setValue(Integer.valueOf(val));
                return intVal;
            } catch (NumberFormatException nfeInt) {
                try { // second float
                    FloatValue floatVal = fac.createFloatValue();
                    floatVal.setValue(Float.valueOf(val));
                    return floatVal;
                } catch (NumberFormatException nfeFloat) {
                    if (val.equalsIgnoreCase("true") || val.equalsIgnoreCase("false")) {
                        BooleanValue boolVal = fac.createBooleanValue();
                        boolVal.setValue(Boolean.valueOf(val));
                        return boolVal;
                    } else {
                        TextExpression te = fac.createTextExpression();
                        te.setCode(val);
                        return te;
                    }
                }
            }
        } else if (cexpr.getConstant() != null) {
            TextExpression te = fac.createTextExpression();
            te.setCode(cexpr.getConstant().getName());
            return te;
        }
        TextExpression te = fac.createTextExpression();
        te.setCode("unsupported ConstantExpression: " + cexpr.getClass());
        return te;
    }

    /**
     * Compares the triggers of two transitions. Any delay is ignored as it does not matter here.
     * The same applies for any effects of the second transition.
     * 
     * Used in context of optimization rule3.
     * 
     * @param t1
     *            chronologically first transition
     * @param t2
     *            chronologically second transition
     * @return true if the triggers of both transitions match, false otherwise.
     */
    public static boolean compareTrigger(final Action t1, final Action t2) {
        Action tmp1 = EcoreUtil.copy(t1);
        tmp1.setDelay(1);
        Action tmp2 = EcoreUtil.copy(t2);
        tmp2.setDelay(1);
        tmp2.getEffects().clear();
        // use the ActionLabelSerializer in order to gain a string representation.
        return ActionLabelSerializer.toString(tmp1).equals(ActionLabelSerializer.toString(tmp2));
    }

    /**
     * Adds all elements of list2 to the front of list1.
     * 
     * @param list1
     *            - end of the new list
     * @param list2
     *            - front of the new list
     */
    public static void addToFrontOfList(final List<State> list1, final List<State> list2) {
        list1.addAll(0, list2);
    }

    /**
     * @return the currently active editor.
     */
    public static IEditorPart getActiveEditor() {
        final Maybe<IEditorPart> maybe = new Maybe<IEditorPart>();
        MonitoredOperation.runInUI(new Runnable() {
            public void run() {
                IEditorPart editor = PlatformUI.getWorkbench().getActiveWorkbenchWindow()
                        .getActivePage().getActiveEditor();
                if (editor != null) {
                    maybe.set(editor);
                }
            }
        }, true);
        return maybe.get();
    }

    /**
     * @return the current selection within the currently active editor.
     */
    public static List<EObject> getCurrentEditorSelection() {
        LinkedList<EObject> selectedElements = null;
        // get the active editor
        IEditorPart editor = getActiveEditor();
        if (editor instanceof SyncchartsDiagramEditor) {
            EditPart rootEditPart = ((DiagramEditor) editor).getDiagramEditPart();
            EditPartViewer viewer = rootEditPart.getViewer();

            // get the selection
            ISelection selection = viewer.getSelection();
            if (!selection.isEmpty()) {
                selectedElements = Lists.newLinkedList();
                if (selection instanceof StructuredSelection) {
                    // append all elements to the list being returned
                    for (Object o : ((StructuredSelection) selection).toArray()) {
                        if (o instanceof EditPart) {
                            EObject selModel = ((View) ((EditPart) o).getModel()).getElement();
                            selectedElements.add(selModel);
                        }
                    }
                }
            }
        }
        return selectedElements;
    }

    /**
     * Fill the root esterel elements into a new syncchart.
     * 
     * @param strlFile
     *            esterel file to add to the synccharts
     * @param kixsFile
     *            synccharts model file
     */
    public static void doInitialEsterelTransformation(final IFile strlFile, final IFile kixsFile) {
        try {
            ResourceSet resourceSet = new ResourceSetImpl();
            final URI strlURI = URI.createPlatformResourceURI(strlFile.getFullPath().toString(),
                    true);
            final URI kixsURI = URI.createPlatformResourceURI(kixsFile.getFullPath().toString(),
                    false);

            // setup initial syncchart with one state in the global region
            Resource resource = resourceSet.getResource(kixsURI, true);
            SyncchartsFactory sf = SyncchartsFactory.eINSTANCE;
            Region rootRegion = (Region) resource.getContents().get(0);
            State rootState = sf.createState();
            rootState.setId("r0");
            rootRegion.getStates().add(rootState);
            rootState.setLabel("Esterel State");
            rootState.setType(StateType.TEXTUAL);

            // get the esterel code and add it as body reference
            Resource xtextResource = resourceSet.getResource(strlURI, true);
            EObject esterelModule = xtextResource.getContents().get(0);
            rootState.setBodyReference(esterelModule);

            // parse the esterel code and display as textual code
            TextualCode code = KExpressionsFactory.eINSTANCE.createTextualCode();
            rootState.getBodyText().add(code);
            code.setCode(TransformationUtil.getSerializedString(esterelModule));

            // save the resource
            resource.save(null);

            xtextResource.save(null);
            
            // t est
            resource.delete(null);
            xtextResource.delete(null);

        } catch (Exception e) {
            Status myStatus = new Status(IStatus.ERROR, Activator.PLUGIN_ID,
                    "Problem parsing the Esterel file.", e);
            StatusManager.getManager().handle(myStatus, StatusManager.SHOW);
        }
    }

    /**
     * Creates a new synccharts diagram at the passed location. If the file already exists, a dialog
     * is opened asking the user if he wants to overwrite the file or specify a new name.
     * Furthermore, if the corresponding .kids file is already opened, it is closed and deleted
     * first in order to avoid any graphical relicts.
     * 
     * @param kixsFile
     *            file location
     * @return true if the synccharts was created, false otherwhise.
     */
    public static IFile createSyncchartDiagram(final IFile kixsFile) {
        try {
            IFile newKixsFile = kixsFile;
            IWorkspace workspace = ResourcesPlugin.getWorkspace();
            if (kixsFile.exists()) {
                Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
                String currentName = kixsFile.getName();
                currentName = currentName.substring(0, currentName.lastIndexOf(".") + 1) + "kixs";
                InputDialog inputdiag = new InputDialog(shell, "Existing File.",
                        "File already exists. Overwrite or choose a new name.", currentName,
                        new KixsInputValidator());
                boolean accepted = false;
                if (inputdiag.open() == InputDialog.OK) {
                    accepted = true;
                    String newName = inputdiag.getValue();
                    IPath newPath = new Path(kixsFile.getFullPath().removeLastSegments(1)
                            .append(newName).toString());
                    newKixsFile = workspace.getRoot().getFile(newPath);
                }
                if (!accepted) {
                    return null;
                }
            }

            // remove a possible old .kids file to avoid any graphic relicts.
            final IFile possibleKidsFile = workspace.getRoot().getFile(
                    newKixsFile.getFullPath().removeFileExtension().addFileExtension("kids"));
            if (possibleKidsFile.exists()) {
                // in case the .kids is currently opened, close it first
                MonitoredOperation.runInUI(new Runnable() {
                    public void run() {
                        IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow()
                                .getActivePage();
                        IEditorReference[] editors = page.getEditorReferences();
                        for (IEditorReference editorRef : editors) {
                            if (editorRef.getId().equals(SyncchartsDiagramEditor.ID)) {
                                if (editorRef.getPartName().equals(possibleKidsFile.getName())) {
                                    page.closeEditor(editorRef.getEditor(false), false);
                                }
                            }
                        }
                    }
                }, true);
                possibleKidsFile.delete(true, null);
            }

            // create corresponding syncchart
            final URI kidsURI = URI.createPlatformResourceURI(newKixsFile.getFullPath()
                    .removeFileExtension().addFileExtension("kids").toString(), false);
            final URI kixsURI = URI.createPlatformResourceURI(newKixsFile.getFullPath().toString(),
                    false);

            logger.info("Creating new SyncCharts Diagram.");

            // create a new SyncCharts Diagram.
            final IRunnableWithProgress op = new WorkspaceModifyOperation(null) {
                protected void execute(final IProgressMonitor monitor) throws CoreException,
                        InterruptedException {
                    Resource diagram = SyncchartsDiagramEditorUtil.createDiagram(kidsURI, kixsURI,
                            monitor);
                    try {
                        diagram.save(null);
                    } catch (Exception e) {
                        logger.severe(e.fillInStackTrace().getLocalizedMessage());
                        Status myStatus = new Status(IStatus.ERROR, Activator.PLUGIN_ID,
                                "Problem creating a new SyncChartsDiagram.", e);
                        StatusManager.getManager().handle(myStatus, StatusManager.SHOW);
                    }
                }
            };
            // run
            op.run(null);
            return newKixsFile;
        } catch (Exception e) {
            e.printStackTrace();
            Status myStatus = new Status(IStatus.ERROR, Activator.PLUGIN_ID,
                    "Problem creating a new SyncChartsDiagram.", e);
            StatusManager.getManager().handle(myStatus, StatusManager.SHOW);
        }
        return null;
    }

    /**
     * Performs initial transformation of the passed Esterel file into a SyncCharts. Opens the new
     * .kids file afterwards.
     * 
     * @param strlFile
     *            esterel file to transform
     * @return true if an kixs file was created, false otherwise.
     */
    public static boolean strlToKixsAndOpen(final IFile strlFile) {

        final Maybe<Boolean> createdKixs = new Maybe<Boolean>();
        // start with a progress dialog as parsing and opening might take some time
        MonitoredOperation.runInUI(new Runnable() {

            public void run() {
                try {
                    PlatformUI.getWorkbench().getProgressService()
                            .run(false, true, new IRunnableWithProgress() {
                                public void run(final IProgressMonitor uiMonitor) {

                                    // measure the overall time
                                    long start = System.currentTimeMillis();
                                    IFile kixsFile, kidsFile;
                                    IWorkspaceRoot workspaceRoot;

                                    // CHECKSTYLEOFF MagicNumber
                                    // used some numbers to estimate work done
                                    uiMonitor.beginTask("Initial Transformation", 100);
                                    // access workspace
                                    IWorkspace workspace = ResourcesPlugin.getWorkspace();
                                    workspaceRoot = workspace.getRoot();

                                    // get files relative to Workspace
                                    IPath kidsPath = strlFile.getFullPath().removeFileExtension()
                                            .addFileExtension("kids");
                                    IPath kixsPath = strlFile.getFullPath().removeFileExtension()
                                            .addFileExtension("kixs");
                                    kidsFile = workspaceRoot.getFile(kidsPath);
                                    kixsFile = workspaceRoot.getFile(kixsPath);

                                    logger.info(strlFile.toString());
                                    // create all the elements
                                    IFile created = TransformationUtil
                                            .createSyncchartDiagram(kixsFile);
                                    if (created == null) {
                                        createdKixs.set(false);
                                        return;
                                    } else {
                                        createdKixs.set(true);
                                        kixsFile = created;
                                        kidsFile = workspaceRoot.getFile(kixsFile.getFullPath()
                                                .removeFileExtension().addFileExtension("kids"));
                                    }
                                    uiMonitor.worked(40);
                                    TransformationUtil.doInitialEsterelTransformation(strlFile,
                                            kixsFile);
                                    uiMonitor.worked(60);
                                    TransformationUtil.refreshEditPolicies();
                                    uiMonitor.worked(90);

                                    // open the editor with the kids file
                                    IWorkbenchPage page = PlatformUI.getWorkbench()
                                            .getActiveWorkbenchWindow().getActivePage();
                                    try {
                                        page.openEditor(new FileEditorInput(kidsFile),
                                                SyncchartsDiagramEditor.ID);
                                    } catch (PartInitException e) {
                                        Status myStatus = new Status(IStatus.ERROR,
                                                Activator.PLUGIN_ID,
                                                "Problem opening the SyncCharts Diagram.", e);
                                        StatusManager.getManager().handle(myStatus,
                                                StatusManager.SHOW);
                                    }
                                    long total = System.currentTimeMillis() - start;
                                    logger.info("Initial Transformation took: " + total + " Sek: "
                                            + (total / 1000f) + "s");
                                    // CHECKSTYLEON MagicNumber
                                }
                            });
                } catch (Exception e) {
                    Status myStatus = new Status(IStatus.ERROR, Activator.PLUGIN_ID,
                            "Problem occured during initial Transformation.", e);
                    StatusManager.getManager().handle(myStatus, StatusManager.SHOW);
                }
            }
        }, true);
        return createdKixs.get();
    }

    /**
     * In case the active editor is a {@link IDiagramWorkbenchPart} all of its EditPolicies will be
     * refreshed.
     */
    public static void refreshEditPolicies() {
        // update edit policies, so GMF will generate diagram elements
        // for model elements which have been generated during the
        // transformation.
        IEditorPart activeEditor = PlatformUI.getWorkbench().getActiveWorkbenchWindow()
                .getActivePage().getActiveEditor();
        if (activeEditor instanceof IDiagramWorkbenchPart) {
            EObject obj = ((View) ((IDiagramWorkbenchPart) activeEditor).getDiagramEditPart()
                    .getModel()).getElement();
            List<CanonicalEditPolicy> editPolicies = CanonicalEditPolicy
                    .getRegisteredEditPolicies(obj);
            for (CanonicalEditPolicy editPolicy : editPolicies) {
                editPolicy.refresh();
            }
            IDiagramGraphicalViewer graphViewer = ((IDiagramWorkbenchPart) activeEditor)
                    .getDiagramGraphicalViewer();
            graphViewer.flush();
        }
    }

    /**
     * @param bool
     *            desired value
     * @return a new boolean xtend {@link Variable}.
     */
    public static Variable getXtendVarBoolean(final boolean bool) {
        return new Variable("boolean", bool);
    }

    /**
     * assures that string inputs have the file extention ".kixs".
     * 
     * @author uru
     * 
     */
    private static class KixsInputValidator implements IInputValidator {
        /**
         * {@inheritDoc}
         */
        public String isValid(final String newText) {
            int i = newText.lastIndexOf(".");
            String fileExt = newText.substring(i + 1, newText.length());
            if (fileExt.equals("kixs")) {
                return null;
            } else {
                return "File extention has to be .kixs";
            }
        }
    }

    /**
     * may be used to print some debug information.
     * 
     * @param obj
     *            any obj
     */
    public static void debug(final Object obj) {
        System.out.println("Debug: " + obj);
        if (obj instanceof Region) {
            System.out.println(((Region) obj).getParentState());
            System.out.println(((Region) obj).getStates());
        }
    }
}
