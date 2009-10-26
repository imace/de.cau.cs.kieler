/******************************************************************************
 * KIELER - Kiel Integrated Environment for Layout for the Eclipse RCP
 *
 * http://www.informatik.uni-kiel.de/rtsys/kieler/
 * 
 * Copyright 2009 by
 * + Christian-Albrechts-University of Kiel
 *   + Department of Computer Science
 *     + Real-Time and Embedded Systems Group
 * 
 * This code is provided under the terms of the Eclipse Public License (EPL).
 * See the file epl-v10.html for the license text.
 * 
 *****************************************************************************/
package de.cau.cs.kieler.ksbase.ui.preferences;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.parts.DiagramDocumentEditor;
import org.eclipse.jface.preference.FileFieldEditor;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ControlEditor;
import org.eclipse.swt.custom.TableCursor;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IPropertyListener;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPartConstants;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.contexts.IContextService;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;
import org.eclipse.ui.internal.contexts.ContextService;
import org.eclipse.ui.part.FileEditorInput;

import de.cau.cs.kieler.ksbase.core.EditorTransformationSettings;
import de.cau.cs.kieler.ksbase.core.Transformation;
import de.cau.cs.kieler.ksbase.core.TransformationManager;

/**
 * The KSBasE transformation preference page.
 * 
 * The preference page is used to modify existing extensions only! Due to
 * technical restrictions, it is not possible to add new settings here. If you'd
 * like to create features for a new editor please use the
 * 'ksbase.configuration' extension point provided by this project
 * 
 * @author Michael Matzen
 */
@SuppressWarnings("restriction")
public class TransformationPreferencePage extends PreferencePage implements
        IWorkbenchPreferencePage {

    /** The list of classes that provide ecore packages. **/
    protected static final String[] DIAGRAM_PACKAGES = new String[] {"org.eclipse.emf.ecore.EPackage" }; //$NON-NLS-1$
    /** The diagram document editor defining the diagram to use. **/
    protected DiagramDocumentEditor diagram;
    /** Text boxes. **/
    protected Text sfMetaModel, sfContext;
    /** Combo boxes. **/
    protected Combo cbEditors;
    /** Buttons. **/
    protected Button btContext, btBrowseXtend, btModelPackage, btTableEdit;
    /** The file editor used to select an icon from the project folder. **/
    FileFieldEditor dfDefaultIcon;
    /** The currently selected editor. **/
    protected EditorTransformationSettings activeEditor;
    /** The table used to display the existing transformation. **/
    protected Table table;
    /** Composites used to layout the preference page. **/
    Composite tableComp, browserContainer, btComp;
    /**
     * The transformation manager instance used in this class so we don't have
     * to get the instance every time.
     **/
    private TransformationManager manager;

    /**
     * Default constructor. Sets the preference page title.
     */
    public TransformationPreferencePage() {
        super(Messages.KSBasEPreferencePage_Title);
        manager = TransformationManager.INSTANCE;
    }

    /**
     * Creates the contents of the preference page.
     * 
     * @param parent
     *            The parent of this preference page.
     * @return The created controls.
     */
    @Override
    protected Control createContents(final Composite parent) {
        Composite container = new Composite(parent, SWT.NONE);
        GridLayout layout = new GridLayout(2, false);

        Label editorLabel = new Label(container, SWT.NONE);
        editorLabel
                .setText(Messages.KSBasEPreferencePage_EditorSelection_Title);
        cbEditors = new Combo(container, SWT.DROP_DOWN | SWT.READ_ONLY);
        cbEditors.addSelectionListener(new SelectionListener() {

            public void widgetDefaultSelected(final SelectionEvent e) {
            }

            /**
             * Handles the selection of an editor from the combo box.
             */
            public void widgetSelected(final SelectionEvent e) {
                EditorTransformationSettings editor = manager
                        .getEditorByName(((Combo) e.getSource()).getText());
                activeEditor = editor;
                if (activeEditor != null) { // Load editor settings
                    sfMetaModel.setText(editor.getModelPackageClass());
                    sfContext.setText(editor.getContext());
                    dfDefaultIcon.setStringValue(editor.getDefaultIcon());
                    // Fill table with transformations
                    table.removeAll();
                    for (Transformation t : editor.getTransformations()) {
                        TableItem tItem = new TableItem(table, SWT.NONE);

                        tItem.setText(new String[] {t.getTransformationId(),
                                t.getName(), t.getTransformationName(),
                                t.getIcon(), t.getKeyboardShortcut() });

                    }
                    // enable controls
                    sfMetaModel.setEnabled(true);
                    browserContainer.setEnabled(true);
                    tableComp.setEnabled(true);
                    btBrowseXtend.setEnabled(true);
                    btTableEdit.setEnabled(true);
                    btContext.setEnabled(true);
                    table.setEnabled(true);
                    cbEditors.setEnabled(true);
                }
            }

        });

        new Label(container, SWT.NONE);

        GridData gData = new GridData(SWT.FILL, SWT.BEGINNING, true, false);
        cbEditors.setLayoutData(gData);

        browserContainer = new Composite(parent, SWT.NONE);
        browserContainer.setLayout(new GridLayout(3, true));

        new Label(browserContainer, SWT.NONE)
                .setText(Messages.KSBasEPreferencePage_ModelPackage);
        sfMetaModel = new Text(browserContainer, SWT.SINGLE | SWT.BORDER
                | SWT.READ_ONLY);
        sfMetaModel.setEnabled(false);
        btModelPackage = new Button(browserContainer, SWT.NONE);
        btModelPackage.setText(Messages.KSBasEPreferencePage_Button_Browse);
        btModelPackage.addSelectionListener(new SelectionListener() {

            public void widgetDefaultSelected(final SelectionEvent e) {
            }

            /**
             * Handles the 'browse model package' event. Shows a simple
             * FileDialog in which a file can be selected
             */
            public void widgetSelected(final SelectionEvent e) {
                assert (activeEditor != null);
                IConfigurationElement[] elements = Platform
                        .getExtensionRegistry().getConfigurationElementsFor(
                                "org.eclipse.emf.ecore.generated_package");
                ArrayList<String> editors = new ArrayList<String>();

                for (int i = 0; i < elements.length; ++i) {

                    if (elements[i] != null
                            && elements[i].getAttribute("class") != null) {
                        editors.add(elements[i].getAttribute("class"));
                    }
                }

                ElementListSelectionDialog dlg = new ElementListSelectionDialog(
                        getShell(), new LabelProvider());
                dlg.setTitle("Select Package");
                dlg.setMessage("Select a Package");
                dlg.setElements(editors.toArray());
                dlg.setAllowDuplicates(false);
                dlg.setMatchEmptyString(true);
                dlg.setMultipleSelection(false);
                dlg
                        .setEmptyListMessage("No Package found, please check your workspace settings.");

                if (dlg.open() == ElementListSelectionDialog.OK) {

                    String modelPackage = ((String) dlg.getFirstResult())
                            .split("@")[0];
                    // only add a diagram once !
                    if (manager.getEditorByName(modelPackage) == null) {
                        activeEditor.setModelPackageClass(modelPackage);
                        cbEditors.notifyListeners(SWT.Selection, null);
                    }
                }
            }

        });
        sfMetaModel.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true,
                false));

        new Label(browserContainer, SWT.NONE).setText("Diagram Context:");
        sfContext = new Text(browserContainer, SWT.SINGLE | SWT.BORDER
                | SWT.READ_ONLY);
        btContext = new Button(browserContainer, SWT.NONE);
        btContext.setText(Messages.KSBasEPreferencePage_Button_Browse);
        btContext.addSelectionListener(new SelectionListener() {

            public void widgetSelected(final SelectionEvent e) {
                assert (activeEditor != null);
                Collection<?> definedContexts = ((ContextService) PlatformUI
                        .getWorkbench().getService(IContextService.class))
                        .getDefinedContextIds();
                ElementListSelectionDialog dlg = new ElementListSelectionDialog(
                        getShell(), new LabelProvider());
                dlg.setTitle("Select diagram context");
                dlg.setMessage("Select a context");
                dlg.setElements(definedContexts.toArray());
                dlg.setAllowDuplicates(false);
                dlg.setMatchEmptyString(true);
                dlg.setMultipleSelection(false);
                dlg
                        .setEmptyListMessage("No context found, please check your workspace settings");

                if (dlg.open() == ElementListSelectionDialog.OK) {
                    activeEditor.setContext((String) dlg.getFirstResult());
                    cbEditors.notifyListeners(SWT.Selection, null);
                }
            }

            public void widgetDefaultSelected(final SelectionEvent e) {
            }

        });
        sfContext.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true,
                false));

        dfDefaultIcon = new FileFieldEditor(
                Messages.KSBasEPreferencePage_DefaultIconName,
                Messages.KSBasEPreferencePage_DefaultIcon, browserContainer);
        dfDefaultIcon.setFileExtensions(new String[] {
                Messages.KSBasEPreferencePage_IconExtension_PNG,
                Messages.KSBasEPreferencePage_IconExtension_ICO });

        browserContainer.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING,
                true, false));
        browserContainer.setEnabled(false);

        container.setLayout(layout);
        container.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, false,
                false));

        tableComp = new Composite(parent, SWT.NONE);
        tableComp.setLayout(new GridLayout(1, false));
        Label tableLabel = new Label(tableComp, SWT.NONE);
        tableLabel.setText(Messages.KSBasEPreferencePage_TableTitle);

        table = new Table(tableComp, SWT.BORDER | SWT.SINGLE);

        table.setHeaderVisible(true);
        table.setLinesVisible(true);

        TableColumn[] titleCols = new TableColumn[5];

        titleCols[0] = new TableColumn(table, SWT.NONE);
        titleCols[0].setText(Messages.KSBasEPreferencePage_Table_Col_Id);
        titleCols[0]
                .setToolTipText(Messages.KSBasEPreferencePage_Table_Col_Id_ToolTip);
        titleCols[0].setWidth(150);

        titleCols[1] = new TableColumn(table, SWT.NONE);
        titleCols[1].setText(Messages.KSBasEPreferencePage_Table_Col_Name);
        titleCols[1]
                .setToolTipText(Messages.KSBasEPreferencePage_Table_Col_Name_ToolTip);
        titleCols[1].setWidth(150);

        titleCols[2] = new TableColumn(table, SWT.NONE);
        titleCols[2]
                .setText(Messages.KSBasEPreferencePage_Table_Col_Transformation);
        titleCols[2]
                .setToolTipText(Messages.KSBasEPreferencePage_Table_Col_Transformation_ToolTip);
        titleCols[2].setWidth(150);

        titleCols[3] = new TableColumn(table, SWT.NONE);
        titleCols[3].setText(Messages.KSBasEPreferencePage_Table_Col_Icon);
        titleCols[3].setWidth(50);

        titleCols[4] = new TableColumn(table, SWT.NONE);
        titleCols[4].setText(Messages.KSBasEPreferencePage_Table_Col_Shortcut);
        titleCols[4].setWidth(75);
        titleCols[4]
                .setToolTipText(Messages.KSBasEPreferencePage_Table_Col_Shortcut_ToolTip);

        // Cursor to edit Table cells
        final TableCursor cursor = new TableCursor(table, SWT.NONE);
        final ControlEditor editor = new ControlEditor(cursor);
        editor.grabHorizontal = true;
        editor.grabVertical = true;

        cursor.addSelectionListener(new SelectionListener() {
            public void widgetDefaultSelected(final SelectionEvent e) {
                table.setSelection(new TableItem[] {cursor.getRow() });
            }

            /**
             * Handles the event of selecting a table entry
             */
            public void widgetSelected(final SelectionEvent e) {
                assert (activeEditor != null);
                TableItem row = cursor.getRow();
                int col = cursor.getColumn();
                final Transformation transformation = activeEditor
                        .getTransformations().get(table.indexOf(row));
                if (col == 0 || col == 1) {
                    // Name and Id can be edited directly
                    final Text text = new Text(cursor, SWT.NONE);
                    text.addKeyListener(new KeyAdapter() {

                        public void keyPressed(final KeyEvent e) {
                            if (e.character == SWT.CR) {
                                int col = cursor.getColumn();
                                if (col == 0) {
                                    // TODO: Check for duplicate Id's
                                    transformation.setTransformationId(text
                                            .getText());
                                } else if (col == 1) {
                                    transformation.setName(text.getText());
                                }
                                text.dispose();
                                cbEditors.notifyListeners(SWT.Selection, null);
                            }

                        }
                    });
                    text.addFocusListener(new FocusAdapter() {
                        public void focusLost(final FocusEvent e) {
                            int col = cursor.getColumn();
                            if (col == 0) {
                                transformation.setTransformationId(text
                                        .getText());
                            } else if (col == 1) {
                                transformation.setName(text.getText());
                            }
                            text.dispose();
                        }
                    });
                    text.setText(row.getText(col));
                    editor.setEditor(text);
                    text.setFocus();
                } else if (col == 3) { // Icon
                    FileDialog dlg = new FileDialog(getShell(), SWT.OPEN);
                    dlg.setFilterExtensions(new String[] {
                            Messages.KSBasEPreferencePage_IconExtension_PNG,
                            Messages.KSBasEPreferencePage_IconExtension_ICO });
                    String fileName = dlg.open();
                    if (fileName != null) {
                        transformation.setIcon(fileName);
                        cbEditors.notifyListeners(SWT.Selection, null);
                    }
                } else if (col == 4) { // Keyboard shortcut
                    // We are using two text fields here
                    // one for storing the actual shortcut text including
                    // modifiers ('text') and one
                    // for storing the raw pressed keys ('keys') without
                    // modifiers
                    final Text text = new Text(cursor, SWT.NONE);
                    // We can't use a string here 'cause we need a final
                    // variable which is defined
                    // in the enclosing type and we really don't need another
                    // class variable

                    // FIXME: Adapt behavior of key binding pref page
                    final Text keys = new Text(cursor, SWT.NONE);
                    text.addKeyListener(new KeyAdapter() {

                        public void keyPressed(final KeyEvent e) {
                            if (e.keyCode == SWT.DEL || e.keyCode == SWT.BS) {
                                text.setText(""); //$NON-NLS-1$
                                keys.setText(""); //$NON-NLS-1$
                            } else {
                                if (e.keyCode >= 97 && e.keyCode <= 122) { // only
                                    // allow
                                    // characters
                                    String ex = ""; //$NON-NLS-1$
                                    if (ex.length() > 0) {
                                        ex += "\u002B"; //$NON-NLS-1$
                                    }
                                    if ((e.stateMask & SWT.CTRL) != 0) {
                                        ex += Messages.KSBasEPreferencePage_Shortcut_CTRL;
                                    }
                                    if ((e.stateMask & SWT.ALT) != 0) {
                                        ex += Messages.KSBasEPreferencePage_Shortcut_ALT;
                                    }
                                    if ((e.stateMask & SWT.SHIFT) != 0) {
                                        ex += Messages.KSBasEPreferencePage_Shortcut_SHIFT;
                                    }
                                    if (keys.getText().length() > 0) {
                                        ex += keys.getText();
                                    }

                                    keys.append(String
                                            .valueOf((char) e.keyCode)
                                            + " "); //$NON-NLS-1$

                                    ex += (char) e.keyCode;
                                    text.setText(ex.toUpperCase(Locale
                                            .getDefault()));
                                }
                            }
                        }
                    });
                    text.addFocusListener(new FocusAdapter() {
                        public void focusLost(final FocusEvent e) {

                            if (text.getText().length() > 0) {
                                transformation.setKeyboardShortcut(text
                                        .getText());
                                cbEditors.notifyListeners(SWT.Selection, null);
                            }
                            text.dispose();
                            keys.dispose();
                        }
                    });
                    text.setText(row.getText(col));
                    editor.setEditor(text);
                    text.setFocus();
                }
            }
        });

        table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        tableComp.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        tableComp.setEnabled(false);

        btComp = new Composite(parent, SWT.NONE);
        btComp.setLayout(new GridLayout(4, false));

        btTableEdit = new Button(btComp, SWT.NONE);
        btTableEdit
                .setText(Messages.KSBasEPreferencePage_Button_Edit_Transformations);
        btTableEdit.addSelectionListener(new SelectionListener() {

            public void widgetDefaultSelected(final SelectionEvent e) {
            }

            /**
             * Handles the 'Edit transformations' event. Closes the preferences
             * page and opens the Xtend file in a new workbench editor
             */
            public void widgetSelected(final SelectionEvent e) {
                assert (activeEditor != null);
                MessageBox box = new MessageBox(getShell(), SWT.OK | SWT.CANCEL);
                box
                        .setMessage(Messages.KSBasEPreferencePage_EditTransformations_Message);
                box
                        .setText(Messages.KSBasEPreferencePage_EditTransformations_Title);
                if (box.open() == SWT.OK) {
                    try {

                        DirectoryDialog dlg = new DirectoryDialog(getShell());
                        dlg.setFilterPath(ResourcesPlugin.getWorkspace()
                                .getRoot().getLocation().toOSString());
                        dlg
                                .setMessage("Select a source folder to store and open the transformation file");

                        String result = dlg.open();
                        if (result != null && result.length() > 0) {
                            final File tmpFile = File.createTempFile(
                                    "extension", ".ext", new File(result));

                            IEditorDescriptor desc = PlatformUI.getWorkbench()
                                    .getEditorRegistry().getDefaultEditor(
                                            "feature.ext");
                            IWorkspace workspace = ResourcesPlugin
                                    .getWorkspace();
                            IPath location = Path.fromOSString(tmpFile
                                    .getAbsolutePath());
                            IFile file = workspace.getRoot()
                                    .getFileForLocation(location);
                            if (file == null) {
                                MessageBox errorBox = new MessageBox(
                                        getShell(), SWT.OK);
                                errorBox
                                        .setMessage("Invalid folder. Please use a folder in your current worksapce");
                                errorBox.setText("Error");
                                errorBox.open();
                                return;
                            }
                            ByteArrayInputStream extStream = new ByteArrayInputStream(
                                    activeEditor.getExtFile().getBytes());
                            if (file.exists()) {
                                file.setContents(extStream, IFile.FORCE, null);
                            } else {
                                file.create(extStream, IFile.FORCE, null);
                            }
                            IWorkbenchPage page = PlatformUI.getWorkbench()
                                    .getActiveWorkbenchWindow().getActivePage();
                            FileEditorInput input = new FileEditorInput(file);
                            IEditorPart editor = page.openEditor(input, desc
                                    .getId());
                            IPropertyListener list = new IPropertyListener() {

                                private boolean dirty = false;

                                public void propertyChanged(final Object source,
                                        final int propId) {
                                    if (propId == IWorkbenchPartConstants.PROP_DIRTY) {
                                        if (dirty) {
                                            /*
                                             * activeEditor
                                             * .parseTransformationsFromFile
                                             * (tmpFile .getAbsolutePath());
                                             */
                                            // TODO:
                                            // manager.storeTransformations();
                                            dirty = false;
                                            return;
                                        } else {
                                            dirty = true;
                                        }
                                    }
                                }
                            };

                            editor.addPropertyListener(list);
                            performOk();
                        }
                    } catch (PartInitException excep) {
                        excep.printStackTrace();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        btTableEdit.setEnabled(false);
        btBrowseXtend = new Button(btComp, SWT.NONE);
        btBrowseXtend.setText("Load Xtend File");
        btBrowseXtend.setEnabled(false);
        btBrowseXtend.addSelectionListener(new SelectionListener() {

            public void widgetDefaultSelected(final SelectionEvent e) {
            }

            /**
             * Handles the 'browse xtend file' event Shows a simple FileDialog
             * in which a file can be selected
             */
            public void widgetSelected(final SelectionEvent e) {
                assert (activeEditor != null);
                MessageBox box = new MessageBox(getShell(), SWT.YES | SWT.NO);
                box.setMessage("Loading an xtend file may reset the "
                                + "existing transformations.\r\n Do you want continue?");
                box
                        .setText(Messages.KSBasEPreferencePage_EditTransformations_Title);
                if (box.open() == SWT.YES) {
                    FileDialog dlg = new FileDialog(getShell());
                    dlg.setFilterPath(ResourcesPlugin.getWorkspace().getRoot()
                            .getLocation().toOSString());
                    dlg
                            .setFileName(Messages.KSBasEPreferencePage_XtendFile_DefaultName);
                    dlg
                            .setFilterExtensions(new String[] {Messages.KSBasEPreferencePage_XtendFile_Extension });
                    dlg
                            .setText(Messages.KSBasEPreferencePage_XtendFile_DialogTitle);
                    String result = dlg.open();
                    if (result != null) {
                        IPath path = new Path(result);

                        IFile file = ResourcesPlugin.getWorkspace().getRoot()
                                .getFileForLocation(path);

                        if (file == null) {
                            box = new MessageBox(getShell(), SWT.OK);
                            box
                                    .setMessage(Messages.KSBasEPreferencePage_XtendFile_InvalidFile);
                            box.open();
                            return;
                        } else {
                            activeEditor.setEditor(result);
                            cbEditors.notifyListeners(SWT.Selection, null);
                        }
                    }
                }
            }

        });

        btComp.setLayoutData(new GridData(SWT.FILL, SWT.BOTTOM, true, false));
        readEditors();
        return null;
    }

    /**
     * Reads the existing editors from the manager and inserts them to the
     * editor list.
     */
    private void readEditors() {
        if (manager.getEditors() != null) {
            for (EditorTransformationSettings s : manager.getEditors()) {
                cbEditors.add(s.getEditor());
            }
            if (cbEditors.getItemCount() > 0) {
                cbEditors.select(0);
                cbEditors.notifyListeners(SWT.Selection, null);
            }
        }
    }

    /**
     * Initializes the preference page.
     * @param workbench The workbench for this preference page
     */
    public final void init(final IWorkbench workbench) {
        manager.initializeTransformations();
    }

    /**
     * Performs an 'OK' command. i.e. stores the settings for the currently
     * selected editor.
     * @return False if an error occurred while storing the settings.
     */
    @Override
    public boolean performOk() {
        // TODO: The tricky part: Store transformations in existing extension
        // point scheme
        // Alot of tricky parts here: Find extension point, serialize settings
        // to XML scheme, overwrite existing
        if (activeEditor != null) {
            activeEditor.setModelPackageClass(sfMetaModel.getText());
            activeEditor.setContext(sfContext.getText());
            activeEditor.setDefaultIcon(dfDefaultIcon.getStringValue());
            // manager.storeTransformations();
        }
        return super.performOk();
    }
}
