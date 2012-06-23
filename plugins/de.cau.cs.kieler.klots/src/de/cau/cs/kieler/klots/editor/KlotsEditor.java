/*
 * KIELER - Kiel Integrated Environment for Layout Eclipse RichClient
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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.jdt.internal.ui.javaeditor.CompilationUnitEditor;
import org.eclipse.jdt.internal.ui.javaeditor.JavaEditor;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.ide.IGotoMarker;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import de.cau.cs.kieler.klots.KlotsPlugin;
import de.cau.cs.kieler.klots.preferences.KlotsPreferenceConstants;
import de.cau.cs.kieler.klots.util.ColorProvider;
import de.cau.cs.kieler.klots.util.KlotsConstants;

/**
 * @author root
 * 
 */
@SuppressWarnings("restriction")
public class KlotsEditor extends CompilationUnitEditor implements IResourceChangeListener,
        IPropertyChangeListener, IGotoMarker {

    /**
     * 
     */
    public static final String ID = "de.cau.cs.kieler.klots.editor.KlotsEditor";

    // ======================================================================
    // >>>>>>>>>> LABEL INFO INNER CLASS <<<<<<<<<<
    // ======================================================================

    /**
     * @author root
     * 
     */
    class LabelInfo {
        private String labelName;
        private int labelStartIndex;
        private int labelEndIndex;
        private int cursorIndex;
        private List<IMarker> sjInstructions;
        private int sjInstructionCursor;

        LabelInfo(final String name, final int startIndex, final int endIndex) {
            this.labelName = name;
            this.labelStartIndex = startIndex;
            this.labelEndIndex = endIndex;
            this.cursorIndex = startIndex;
            this.sjInstructions = new ArrayList<IMarker>();
            this.sjInstructionCursor = -1;
        }

        LabelInfo(final String name, final int startIndex) {
            this.labelName = name;
            this.labelStartIndex = startIndex;
            this.labelEndIndex = -1;
            this.cursorIndex = startIndex;
            this.sjInstructions = new ArrayList<IMarker>();
            this.sjInstructionCursor = -1;
        }

        int getCursorIndex() {
            return cursorIndex;
        }

        void setCursorIndex(final int cursorIndex) {
            this.cursorIndex = cursorIndex;
        }

        String getLabelName() {
            return labelName;
        }

        int getLabelStartIndex() {
            return labelStartIndex;
        }

        int getLabelEndIndex() {
            return labelEndIndex;
        }

        void setLabelEndIndex(final int labelEndIndex) {
            this.labelEndIndex = labelEndIndex;
        }

        void addSJInstruction(final IMarker sjInstructionMarker) {
            int instrStart = sjInstructionMarker.getAttribute(
                    KlotsConstants.SJ_INSTRUCTION_MARKER_ATTRIBUTE_INSTRUCTION_START, 0);
            for (int i = 0; i < this.sjInstructions.size(); i++) {
                if (instrStart < this.sjInstructions.get(i).getAttribute(
                        KlotsConstants.SJ_INSTRUCTION_MARKER_ATTRIBUTE_INSTRUCTION_START, 0)) {
                    this.sjInstructions.add(i, sjInstructionMarker);
                    return;
                }
            }
            this.sjInstructions.add(sjInstructionMarker);
        }

        List<IMarker> getSJInstructions() {
            return this.sjInstructions;
        }

        IMarker getCurrentSJInstruction() {
            return this.sjInstructions.get(sjInstructionCursor);
        }

        int getSJInstructionCursor() {
            return this.sjInstructionCursor;
        }

        void setSJInstructionCursor(final int index) {
            this.sjInstructionCursor = index;
        }

    } // end inner class LabelInfo

    // ======================================================================
    // >>>>>>>>>> FIELDS & VARIABLES <<<<<<<<<<
    // ======================================================================

    // colors
    private static ColorProvider colorProvider;
    private static Color colorForegroundStandard;
    private static Color colorBackgroundStandard;
    private static Color colorForegroundAlreadyDoneMicrostep;
    private static Color colorBackgroundAlreadyDoneMicrostep;
    private static Color colorForegroundActiveMicrostep;
    private static Color colorBackgroundActiveMicrostep;
    private static Color colorForegroundYetToBeDoneMicrostep;
    private static Color colorBackgroundYetToBeDoneMicrostep;

    // KiVi effects lists
    private static int microStepNumber = -1;
    private static List<HighlightSJMarkerEffect> kiviList = new ArrayList<HighlightSJMarkerEffect>();
    // label list
    private static List<LabelInfo> labelList = new ArrayList<LabelInfo>();
    private String[] labels;
    // signals
    private String[] signals;
    // SJ content flag
    private boolean hasSJContent;
    // editor initialized flag
    private boolean initialized = false;

    // SJ instructions highlight update data
    private static String sjInstructionsUpdateData = "";

    // status line SJ display
    // private StatusLineContributionItem uiStatusLineItem;

    // ======================================================================
    // >>>>>>>>>> CONSTRUCTORS <<<<<<<<<<
    // ======================================================================

    /**
     * Creates a multi-page editor example.
     */
    public KlotsEditor() {
        super();
        ResourcesPlugin.getWorkspace().addResourceChangeListener(this);
        this.setPreferenceStore(KlotsPlugin.getDefault().getPreferenceStore());
        this.getPreferenceStore().addPropertyChangeListener(this);
        colorProvider = KlotsPlugin.getColorProvider();
        initColors();

        // -------------------- set up the status line ----------------------
        // IActionBars aBars = editor.getEditorSite().getActionBars();
        // IStatusLineManager man = aBars.getStatusLineManager();
        // uiStatusLineItem = new StatusLineContributionItem("uiStatusLineItem",
        // true, 100);
        // man.add(uiStatusLineItem);
        // aBars.updateActionBars();
        // uiStatusLineItem.setToolTipText("DO WE NEED A TOOL TIP TEXT?");
        // uiStatusLineItem.setErrorText("INSTRUCTION INFO TO BE DISPAYED");
        // ------------------------------------------------------------------

    }

    // ######################################################################
    // ###################### METHODS SECTION #######################
    // ######################################################################

    // ======================================================================
    // >>>>>>>>>> STANDARD IMPLEMENTETION METHODS & SETUP <<<<<<<<<<
    // ======================================================================

    /**
     * 
     */
    private void initColors() {
        System.out.println("***********>>>> EDITOR > initColors()");
        if (colorProvider == null) {
            colorProvider = KlotsPlugin.getColorProvider();
        }
        colorForegroundStandard = colorProvider
                .getColor(KlotsPreferenceConstants.P_COLOR_FOREGROUND_STANDARD);
        colorBackgroundStandard = colorProvider
                .getColor(KlotsPreferenceConstants.P_COLOR_BACKGROUND_STANDARD);
        colorForegroundAlreadyDoneMicrostep = colorProvider
                .getColor(KlotsPreferenceConstants.P_COLOR_FOREGROUND_ALREADY_DONE_MICROSTEP);
        colorBackgroundAlreadyDoneMicrostep = colorProvider
                .getColor(KlotsPreferenceConstants.P_COLOR_BACKGROUND_ALREADY_DONE_MICROSTEP);
        colorForegroundActiveMicrostep = colorProvider
                .getColor(KlotsPreferenceConstants.P_COLOR_FOREGROUND_ACTIVE_MICROSTEP);
        colorBackgroundActiveMicrostep = colorProvider
                .getColor(KlotsPreferenceConstants.P_COLOR_BACKGROUND_ACTIVE_MICROSTEP);
        colorForegroundYetToBeDoneMicrostep = colorProvider
                .getColor(KlotsPreferenceConstants.P_COLOR_FOREGROUND_YET_TO_BE_DENE_MICROSTEP);
        colorBackgroundYetToBeDoneMicrostep = colorProvider
                .getColor(KlotsPreferenceConstants.P_COLOR_BACKGROUND_YET_TO_BE_DENE_MICROSTEP);
    }

    /**
     * @return JavaEditor
     */
    public static JavaEditor getEditor() {
        IEditorPart editorPart = KlotsPlugin.getDefault().getWorkbench().getActiveWorkbenchWindow()
                .getActivePage().getActiveEditor();
        if (editorPart != null) {
            KlotsEditor e = (KlotsEditor) editorPart;
            return e;
        }
        return null;
    }

    /**
     * The <code>MultiPageEditorPart</code> implementation of this <code>IWorkbenchPart</code>
     * method disposes all nested editors. Subclasses may extend.
     */
    public void dispose() {
        ResourcesPlugin.getWorkspace().removeResourceChangeListener(this);
        this.getPreferenceStore().removePropertyChangeListener(this);
        super.dispose();
    }

    /**
     * Saves the multi-page editor's document.
     *
     * @param monitor the monitor
     */
    public void doSave(final IProgressMonitor monitor) {
        super.doSave(monitor);
    }

    /**
     * Saves the multi-page editor's document as another file. Also updates the text for page 0's
     * tab, and updates this multi-page editor's input to correspond to the nested editor's.
     */
    public void doSaveAs() {
        super.doSaveAs();
        setInput(getEditorInput());
    }

    /**
     * {@inheritDoc}
     */
    public void init(final IEditorSite site, final IEditorInput editorInput)
            throws PartInitException {
        if (!(editorInput instanceof IFileEditorInput)) {
            throw new PartInitException("Invalid Input: Must be IFileEditorInput");
        }
        super.init(site, editorInput);
    }

    /**
     * {@inheritDoc}
     */
    public boolean isSaveAsAllowed() {
        return true;
    }

    /**
     * {@inheritDoc}
     */
    public void resourceChanged(final IResourceChangeEvent event) {
        if (event.getType() == IResourceChangeEvent.PRE_CLOSE) {
            Display.getDefault().asyncExec(new Runnable() {
                public void run() {
                    IWorkbenchPage[] pages = getSite().getWorkbenchWindow().getPages();
                    for (int i = 0; i < pages.length; i++) {
                        if (((FileEditorInput) getEditorInput()).getFile().getProject()
                                .equals(event.getResource())) {
                            IEditorPart editorPart = pages[i].findEditor(getEditorInput());
                            pages[i].closeEditor(editorPart, true);
                        }
                    }
                }
            });
        }
    }

    /**
     * {@inheritDoc}
     */
    public void propertyChange(final PropertyChangeEvent event) {
        String property = event.getProperty();
        System.out.println("***********>>>> EDITOR > propertyChange() with property >" + property
                + "<");
        if (property.startsWith(KlotsPreferenceConstants.P_COLOR_PREFERENCE_PREFIX)) {
            colorProvider.handlePreferenceStoreChanged(event);
        } else {
            return;
        }
        if (property.equals(KlotsPreferenceConstants.P_COLOR_FOREGROUND_STANDARD)) {
            colorForegroundStandard = colorProvider.getColor(property);
        } else if (property.equals(KlotsPreferenceConstants.P_COLOR_BACKGROUND_STANDARD)) {
            colorBackgroundStandard = colorProvider.getColor(property);
        } else if (property
                .equals(KlotsPreferenceConstants.P_COLOR_FOREGROUND_ALREADY_DONE_MICROSTEP)) {
            colorForegroundAlreadyDoneMicrostep = colorProvider.getColor(property);
        } else if (property
                .equals(KlotsPreferenceConstants.P_COLOR_BACKGROUND_ALREADY_DONE_MICROSTEP)) {
            colorBackgroundAlreadyDoneMicrostep = colorProvider.getColor(property);
        } else if (property.equals(KlotsPreferenceConstants.P_COLOR_FOREGROUND_ACTIVE_MICROSTEP)) {
            colorForegroundActiveMicrostep = colorProvider.getColor(property);
        } else if (property.equals(KlotsPreferenceConstants.P_COLOR_BACKGROUND_ACTIVE_MICROSTEP)) {
            colorBackgroundActiveMicrostep = colorProvider.getColor(property);
        } else if (property
                .equals(KlotsPreferenceConstants.P_COLOR_FOREGROUND_YET_TO_BE_DENE_MICROSTEP)) {
            colorForegroundYetToBeDoneMicrostep = colorProvider.getColor(property);
        } else if (property
                .equals(KlotsPreferenceConstants.P_COLOR_BACKGROUND_YET_TO_BE_DENE_MICROSTEP)) {
            colorBackgroundYetToBeDoneMicrostep = colorProvider.getColor(property);
        } else {
            return;
        }
        repaintAllMicroSteps();
    }

    /**
     * @return boolean
     */
    public boolean hasSJContent() {
        return hasSJContent;
    }

    /**
     * @return boolean
     */
    public boolean isInitialized() {
        return initialized;
    }

    // ======================================================================
    // >>>>>>>>>> SJ INITIALIZATION UTILITY METHODS <<<<<<<<<<
    // ======================================================================

    /**
     * 
     */
    public void rollbackSJContent() {
        kiviList.clear();
        labelList.clear();
        labels = null;
        signals = null;
        hasSJContent = false;
        initialized = false;
        microStepNumber = -1;
        sjInstructionsUpdateData = "";
        // execute asynchronously just in case method is called from the UI thread
        Display.getDefault().asyncExec(new Runnable() {
            public void run() {
                setInput(getEditorInput());
            }
        });
        // uiStatusLineItem.setToolTipText("");
        // uiStatusLineItem.setErrorText("");
    }

    /**
     * 
     */
    public void initSJContent() {

        initColors();

        hasSJContent = true;

        // -------------------
        computeLabels();
        parseLabels();
        parseSJInstructions();
        // -------------------

        initialized = true;
    }

    private void computeLabels() {
        System.out.println("HHHHHHHHHHHHHHHHHHHHH>>> COMPUTE LABELS <<<HHHHHHHHHHHHHHHHHHHHH");
        String text = this.getDocumentProvider().getDocument(this.getEditorInput()).get();

        // find label declaration part
        int offset = text.indexOf(KlotsConstants.LABEL_ENUM_NAME);
        if (offset < 0 || offset > text.length()) {
            System.err.println("EDITOR INITIALIZATION ERROR: No label declaration part found!");
            hasSJContent = false;
            return;
        }
        System.out.println("HHHHHHHHHHHHHH>>>>>>>>>>>> offset = " + offset + ", length = "
                + KlotsConstants.LABEL_ENUM_NAME.length() + ", text = >"
                + text.substring(offset, offset + KlotsConstants.LABEL_ENUM_NAME.length()) + "<");
        while (isComment(offset, offset + KlotsConstants.LABEL_ENUM_NAME.length(), text)
                || isString(offset, offset + KlotsConstants.LABEL_ENUM_NAME.length(), text)) {
            offset = text.indexOf(KlotsConstants.LABEL_ENUM_NAME, offset + 1);
            if (offset < 0 || offset > text.length()) {
                System.err.println("EDITOR INITIALIZATION ERROR: No label declaration part found!");
                return;
            }
            System.out.println("HHHHHHHHHHHHHH>>>>>>>>>>>> offset = " + offset + ", length = "
                    + KlotsConstants.LABEL_ENUM_NAME.length() + ", text = >"
                    + text.substring(offset, offset + KlotsConstants.LABEL_ENUM_NAME.length())
                    + "<");
        }

        // parse label declarations
        offset = text.indexOf('{', offset) + 1;
        String labelsText = text.substring(offset, text.indexOf('}', offset));
        System.out.println("HHHHHHHHHHHHHH>>>>>>>>>>>> labels text = >" + labelsText + "<");
        String[] rawLabels = labelsText.split(KlotsConstants.COMMA_STRING);
        for (int i = 0; i < rawLabels.length; i++) {
            System.out.println("HHHHHHHHHHHHHH>>>>>>>>>>>> process label = >" + rawLabels[i] + "<");
            rawLabels[i] = rawLabels[i].trim();
            // remove multi line comments
            rawLabels[i] = rawLabels[i].replaceAll("(/\\x2A{1}).*(\\x2A/{1})", " ");
            // remove single line comments
            rawLabels[i] = rawLabels[i].replaceAll("//.*", " ");
            rawLabels[i] = rawLabels[i].trim();
            System.out.println("HHHHHHHHHHHHHH>>>>>>>>>>>> label after processing = >"
                    + rawLabels[i] + "<");
        }
        for (String l : rawLabels) {
            System.out.println("HHHHHHHHHHHHHH>>>>>>>>>>>> 'raw' label after processing = >" + l
                    + "<");
        }
        this.labels = rawLabels;
    }

    private void parseSignals(final boolean first, final int tickMethodOffset, final int startOffset) {
        System.out.println("HHHHHHHHHHHHHHHHHHHHH>>> PARSE SIGNALS <<<HHHHHHHHHHHHHHHHHHHHH");
        String text = getDocumentProvider().getDocument(this.getEditorInput()).get();
        int tickOffset = tickMethodOffset;
        int offset = startOffset;
        if (first) {
            tickOffset = computeTickMethodStartOffset();
            offset = 0;
        }

        // find signal declaration part
        offset = text.indexOf(KlotsConstants.SIGNAL_DECLARATION_NAME, offset);
        System.out.println("HHHHHHHHHHHHHH>>>>>>>>>>>> offset = " + offset + ", tickOffset = "
                + tickOffset);
        if (offset < 0 || offset > tickOffset) {
            if (first) {
                System.err
                        .println("EDITOR INITIALIZATION ERROR: No signal declaration part found!");
                hasSJContent = false;
            } else {
                System.out
                        .println("HHHHHHHHHHHHHH>>>>>>>>>>>> ALL SIGNAL DECLARATION PARTS PROCESSED!");
            }
            return;
        }
        System.out.println("HHHHHHHHHHHHHH>>>>>>>>>>>> offset = " + offset + ", length = "
                + KlotsConstants.SIGNAL_DECLARATION_NAME.length() + ", text = >"
                + text.substring(offset, offset + KlotsConstants.SIGNAL_DECLARATION_NAME.length())
                + "<");
        while (isComment(offset, offset + KlotsConstants.SIGNAL_DECLARATION_NAME.length(), text)
                || isString(offset, offset + KlotsConstants.SIGNAL_DECLARATION_NAME.length(), text)) {
            offset = text.indexOf(KlotsConstants.SIGNAL_DECLARATION_NAME, offset + 1);
            if (offset < 0 || offset > tickOffset) {
                if (first) {
                    System.err
                            .println("EDITOR INITIALIZATION ERROR: No signal declaration part found!");
                    hasSJContent = false;
                } else {
                    System.out.println("HHHHHHHHHHHHHH>>>>>>>>>>>> "
                            + "ALL SIGNAL DECLARATION PARTS PROCESSED!");
                }
                return;
            }
            System.out.println("HHHHHHHHHHHHHH>>>>>>>>>>>> offset = "
                    + offset
                    + ", length = "
                    + KlotsConstants.SIGNAL_DECLARATION_NAME.length()
                    + ", text = >"
                    + text.substring(offset,
                            offset + KlotsConstants.SIGNAL_DECLARATION_NAME.length()) + "<");
        }

        // parse label declarations
        offset = text.indexOf(KlotsConstants.SJ_INSTRUCTION_START_BRACKET_CHAR, offset) + 1;
        String signalsText = text.substring(offset,
                text.indexOf(KlotsConstants.SJ_INSTRUCTION_END_BRACKET_CHAR, offset));
        System.out.println("HHHHHHHHHHHHHH>>>>>>>>>>>> signals text = >" + signalsText + "<");
        String[] rawSignals = signalsText.split(KlotsConstants.COMMA_STRING);
        for (int i = 0; i < rawSignals.length; i++) {
            System.out.println("HHHHHHHHHHHHHH>>>>>>>>>>>> process signal = >" + rawSignals[i]
                    + "<");
            rawSignals[i] = rawSignals[i].trim();
            // remove multi line comments
            rawSignals[i] = rawSignals[i].replaceAll("(/\\x2A{1}).*(\\x2A/{1})", " ");
            // remove single line comments
            rawSignals[i] = rawSignals[i].replaceAll("//.*", " ");
            rawSignals[i] = rawSignals[i].trim();
            System.out.println("HHHHHHHHHHHHHH>>>>>>>>>>>> signal after processing = >"
                    + rawSignals[i] + "<");
        }
        for (String s : rawSignals) {
            System.out.println("HHHHHHHHHHHHHH>>>>>>>>>>>> 'raw' signal after processing = >" + s
                    + "<");
        }
        if (first) {
            this.signals = rawSignals;
        } else {
            String[] combinedSignals = new String[signals.length + rawSignals.length];
            for (int i = 0; i < signals.length; i++) {
                combinedSignals[i] = signals[i];
            }
            for (int i = 0; i < rawSignals.length; i++) {
                combinedSignals[i + signals.length] = rawSignals[i];
            }
            this.signals = combinedSignals;
        }

        // call same method recursively till all signal declaration parts
        // (if more than one at all) are processed
        parseSignals(false, tickOffset, offset);
    }

    private int computeTickMethodStartOffset() {
        System.out
                .println("HHHHHHHHHHHHHHHHHHHHH>>> COMPUTE TICK METHOD OFFSET <<<HHHHHHHHHHHHHHHHHHHHH");
        String text = this.getDocumentProvider().getDocument(this.getEditorInput()).get();

        // find tick method start offset
        int offset = text.indexOf(KlotsConstants.TICK_METHOD_NAME);
        if (offset < 0 || offset > text.length()) {
            System.err.println("EDITOR INITIALIZATION ERROR: No tick() method found!");
            hasSJContent = false;
            return -1;
        }
        System.out.println("HHHHHHHHHHHHHH>>>>>>>>>>>> offset = " + offset + ", length = "
                + KlotsConstants.TICK_METHOD_NAME.length() + ", text = >"
                + text.substring(offset, offset + KlotsConstants.TICK_METHOD_NAME.length()) + "<");
        while (isComment(offset, offset + KlotsConstants.TICK_METHOD_NAME.length(), text)
                || isString(offset, offset + KlotsConstants.TICK_METHOD_NAME.length(), text)) {
            offset = text.indexOf(KlotsConstants.TICK_METHOD_NAME, offset + 1);
            if (offset < 0 || offset > text.length()) {
                System.err.println("EDITOR INITIALIZATION ERROR: No tick() method found!");
                hasSJContent = false;
                return -1;
            }
            System.out.println("HHHHHHHHHHHHHH>>>>>>>>>>>> offset = " + offset + ", length = "
                    + KlotsConstants.TICK_METHOD_NAME.length() + ", text = >"
                    + text.substring(offset, offset + KlotsConstants.TICK_METHOD_NAME.length())
                    + "<");
        }

        System.out.println("HHHHHHHHHHHHHH>>>>>>>>>>>> found tick() method at offset = " + offset);
        return offset;
    }

    private void parseLabels() {
        System.out.println("HHHHHHHHHHHHHHHHHHHHH>>> PARSE LABELS <<<HHHHHHHHHHHHHHHHHHHHH");
        labelList.clear();
        String text = this.getDocumentProvider().getDocument(this.getEditorInput()).get();
        int size = text.length();
        String label = "";
        int labelColon = 0;

        for (int labelStart = text.indexOf(KlotsConstants.LABEL_CASE_NAME); 
                (0 < labelStart && labelStart < size); labelStart = text
                .indexOf(KlotsConstants.LABEL_CASE_NAME, labelStart + 1)) {
            if ((text.charAt(labelStart - 1) != KlotsConstants.SPACE_CHAR)
                    && (text.charAt(labelStart - 1) != KlotsConstants.SEMICOLON_CHAR)
                    && (text.charAt(labelStart - 1) != '{') && (text.charAt(labelStart - 1) != '/')) {
                System.out
                        .println("################>>>>>>>>>>>> case is part of a word! -> continue!"
                                + " [char before case = " + text.charAt(labelStart - 1) + "]");
                continue;
            }
            if (isComment(labelStart, labelStart + KlotsConstants.LABEL_CASE_NAME.length() - 1,
                    text)
                    || isString(labelStart, labelStart + KlotsConstants.LABEL_CASE_NAME.length()
                            - 1, text)) {
                System.out.println("################>>>>>>>>>>>> case is inside of a comment! "
                        + "-> continue!");
                continue;
            }
            labelColon = text.indexOf(KlotsConstants.COLON_STRING, labelStart);
            System.out.println("################>>>>>>>>>>>> labelStart = " + labelStart
                    + ", labelColon = " + labelColon + ", labelText = "
                    + text.substring(labelStart, labelColon) + "<<<");
            if (labelColon == -1) {
                System.out.println("################>>>>>>>>>>>> labelColon = -1, -> END!");
                break;
            }

            label = checkForLabelAt(labelStart, labelColon, text);
            if (!label.equals(KlotsConstants.EMPTY_STRING)) {
                if (labelList.isEmpty()) {
                    labelList.add(new LabelInfo(label, labelStart
                            + KlotsConstants.LABEL_CASE_NAME.length()));
                } else {
                    labelList.get(labelList.size() - 1).setLabelEndIndex(labelStart);
                    labelList.add(new LabelInfo(label, labelStart
                            + KlotsConstants.LABEL_CASE_NAME.length()));
                }
            } else {
                System.out.println("################>>>>>>>>>>>> BAD LABEL at: >"
                        + text.substring(labelStart, labelColon) + "<, -> continue!");
                continue;
            }
        }
        if (labelList.isEmpty()) {
            System.err.println("EDITOR INITIALIZATION ERROR: No labels found!");
            hasSJContent = false;
            return;
        }
        labelList.get(labelList.size() - 1).setLabelEndIndex(
                text.lastIndexOf(KlotsConstants.SEMICOLON_STRING));

        for (LabelInfo l : labelList) {
            System.out.println("\n++++++++++++++++++++++++++++++++++++++++");
            System.out.println("ADDING LABEL: >" + l.getLabelName() + "<");
            System.out.println("start index = " + l.getLabelStartIndex());
            System.out.println("end index = " + l.getLabelEndIndex());
            System.out.println("label text = \n"
                    + text.substring(l.getLabelStartIndex(), l.getLabelEndIndex()));
            System.out.println("++++++++++++++++++++++++++++++++++++++++\n");
        }

    }

    private void parseSJInstructions() {
        System.out
                .println("HHHHHHHHHHHHHHHHHHHHH>>> PARSE SJ INSTRUCTIONS <<<HHHHHHHHHHHHHHHHHHHHH");
        String text = this.getDocumentProvider().getDocument(this.getEditorInput()).get();
        String instrName = "";
        for (LabelInfo label : labelList) {
            for (int i = 0; i < KlotsConstants.SJ_INSTRUCTIONS_MAP_SIZE; i++) {
                instrName = KlotsConstants.SJ_INSTSTRUCTIONS_MAP[i][1];
                label.setCursorIndex(label.getLabelStartIndex());

                // ----------------------------------------------------------------------
                while (findSJInstructionAndAddMarkerToLabel(text, label, instrName)) {
                    ; // SUPPRESS CHECKSTYLE EmptyStatement All the work is done in the while
                      // condition
                }
                // ----------------------------------------------------------------------

            }
            label.setCursorIndex(label.getLabelStartIndex());
            label.setSJInstructionCursor(0);

            System.out.println("OOOOOOOOOOOOOOOOOOOO INSTRUCTIONS AT LABEL >"
                    + label.getLabelName() + "< OOOOOOOOOOOOOOOOOOOO");
            for (IMarker m : label.getSJInstructions()) {
                System.out.print("instruction: >"
                        + m.getAttribute(
                                KlotsConstants.SJ_INSTRUCTION_MARKER_ATTRIBUTE_INSTRUCTION_NAME,
                                "NO NAME") + "<");
                System.out
                        .println(", text: >"
                                + text.substring(
                                        m.getAttribute(
                                                KlotsConstants
                                                .SJ_INSTRUCTION_MARKER_ATTRIBUTE_INSTRUCTION_START,
                                                0),
                                        m.getAttribute(
                                                KlotsConstants
                                                .SJ_INSTRUCTION_MARKER_ATTRIBUTE_INSTRUCTION_END,
                                                1)) + "<");
            }
            System.out.println();
        }
    }

    private String checkForLabelAt(final int labelStart, final int labelColon, final String text) {
        String label = text.substring(labelStart + KlotsConstants.LABEL_CASE_NAME.length() - 1,
                labelColon);
        label = label.trim();
        System.out.println("################>>>>>>>>>>>> label = " + label + "<<<");
        boolean labelFound = false;
        for (String s : this.labels) {
            if (s.equals(label)) {
                labelFound = true;
                break;
            }
        }
        if (!labelFound) {
            System.err.println("SJ EDITOR INITIALIZATION ERROR: At label >" + label
                    + "<: No such label found!");
            return KlotsConstants.EMPTY_STRING;
        }
        return label;
    }

    private boolean isComment(final int startIndex, final int endIndex, final String text) {
        int commentStart = -1;
        int commentEnd = -1;
        System.out.println("####>>>>>>>>>>>> CHECK IF COMMENT! <<<<<<<<<<<<<<####");

        // rule out multi line comments
        System.out.println(">>> RULE OUT MULTI LINE COMMENTS");
        commentStart = text.lastIndexOf(KlotsConstants.MULTI_LINE_COMMENT_START, startIndex);
        System.out.println(">>> CommentStart = " + commentStart);
        if (commentStart > -1) {
            commentEnd = text.indexOf(KlotsConstants.MULTI_LINE_COMMENT_END, commentStart);
            System.out.println(">>> CommentEnd = " + commentEnd);
            if (commentEnd > -1 && commentEnd > endIndex) {
                System.out.println(">>> In Comment!!!");
                return true;
            }
        }

        // rule out single line comments
        System.out.println(">>> RULE OUT SINGLE LINE COMMENTS");
        commentStart = text.lastIndexOf(KlotsConstants.SINGLE_LINE_COMMENT_START, startIndex);
        System.out.println(">>> CommentStart = " + commentStart);
        if (commentStart > -1) {
            commentEnd = text.indexOf(KlotsConstants.SINGLE_LINE_COMMENT_END, commentStart);
            System.out.println(">>> CommentEnd = " + commentEnd);
            if (commentEnd > endIndex) {
                System.out.println(">>> In Comment!!!");
                return true;
            }
        }

        return false;
    }

    private boolean isString(final int startIndex, final int endIndex, final String text) {
        System.out.println("####>>>>>>>>>>>> CHECK IF STRING! <<<<<<<<<<<<<<####");
        System.out.println(">>> RULE OUT STRINGS");
        int stringEnd = text.lastIndexOf(KlotsConstants.SEMICOLON_STRING, startIndex);
        int stringStart = text.lastIndexOf(KlotsConstants.STRING_START_CHAR, startIndex);
        System.out.println(">>> StringStart = " + stringStart);
        if (stringStart > -1 && stringStart > stringEnd) {

            // if supposed start of the string is inside of a comment, return 'it's not a string'
            if (isComment(stringStart, stringStart + 1, text)) {
                System.out.println(">>> Supposed string is inside of a comment!");
                return false;
            }

            stringEnd = text.indexOf(KlotsConstants.STRING_END_CHAR, stringStart + 1);
            System.out.println(">>> StringEnd = " + stringEnd);
            if (stringEnd > -1 && stringEnd > endIndex) {
                System.out.println(">>> In String!!!");
                return true;
            }
        }
        return false;
    }

    private boolean findSJInstructionAndAddMarkerToLabel(final String text, final LabelInfo label,
            final String instrName) {
        System.out.println("XXXXXXXXXX label = >" + label.getLabelName()
                + "<, instruction name = >" + instrName + "<");
        int offset = text.indexOf(instrName + KlotsConstants.SJ_INSTRUCTION_START_BRACKET_STRING,
                label.getCursorIndex());
        if (offset < 0 || offset > label.getLabelEndIndex()) {
            return false;
        }
        int end = text.indexOf(KlotsConstants.SJ_INSTRUCTION_END_BRACKET_CHAR, offset) + 1;
        if (end < 0 || end > label.getLabelEndIndex()) {
            return false;
        }
        label.setCursorIndex(offset + 1);
        System.out.println("XXXXXXXXXXXX instruction offset = " + offset + ", instruction text = "
                + text.substring(offset, end));

        if (!isComment(offset, end, text) && !isString(offset, end, text)) {
            int line = 0;
            try {
                line = this.getDocumentProvider().getDocument(this.getEditorInput())
                        .getLineOfOffset(offset);
            } catch (BadLocationException e) {
                e.printStackTrace();
            }
            IMarker instrMarker = createSJInstructionMarker(">" + instrName + "<", instrName,
                    label.getLabelName(), line, offset, end);
            label.addSJInstruction(instrMarker);
        }

        return true;
    }

    private IMarker createSJInstructionMarker(final String msg, final String instrName,
            final String instrLabel, final int line, final int instrStart, final int instrEnd) {
        try {
            IMarker marker = (((IFileEditorInput) this.getEditorInput()).getFile())
                    .createMarker(KlotsConstants.SJ_INSTRUCTION_MARKER_ID);
            marker.setAttribute(KlotsConstants.SJ_INSTRUCTION_MARKER_ATTRIBUTE_INSTRUCTION_NAME,
                    instrName);
            marker.setAttribute(KlotsConstants.SJ_INSTRUCTION_MARKER_ATTRIBUTE_INSTRUCTION_LABEL,
                    instrLabel);
            marker.setAttribute(KlotsConstants.SJ_INSTRUCTION_MARKER_ATTRIBUTE_INSTRUCTION_START,
                    instrStart);
            marker.setAttribute(KlotsConstants.SJ_INSTRUCTION_MARKER_ATTRIBUTE_INSTRUCTION_END,
                    instrEnd);
            marker.setAttribute(IMarker.LINE_NUMBER, line);
            marker.setAttribute(IMarker.CHAR_START, instrStart);
            marker.setAttribute(IMarker.CHAR_END, instrEnd);
            marker.setAttribute(IMarker.MESSAGE, msg);
            // marker.setAttribute(IMarker.PRIORITY, IMarker.PRIORITY_HIGH);
            // marker.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_INFO);
            return marker;
        } catch (CoreException e) {
            // You need to handle the cases where attribute value is rejected
            e.printStackTrace();
            return null;
        }
    }

    // ======================================================================
    // >>>>>>>>>> MACRO STEP UPDATE METHODS <<<<<<<<<<
    // ======================================================================

    static void updateJavaEditor() {
        Display.getDefault().asyncExec(new Runnable() {
            public void run() {

                // ------------ undo highlight old instructions -------------
                for (HighlightSJMarkerEffect e : kiviList) {
                    e.undo();
                }
                kiviList.clear();
                // ----------------------------------------------------------

                // ----------------- highlight new labels -------------------
                try {
                    JSONArray array = new JSONArray(sjInstructionsUpdateData);
                    JSONObject instruction = new JSONObject();
                    JSONObject instructionData = new JSONObject();
                    String key = "";
                    for (int i = 2, j = 1; i < array.length() - 2; i++, j++) {
                        instruction = array.getJSONObject(i);
                        Iterator<?> iter = instruction.keys();
                        key = (String) iter.next();
                        instructionData = instruction.getJSONObject(key);
                        key = getProperSJInstruktionName(key);

                        // ---------------------------------------------------
                        createHighlightEffect(key, instructionData, j);
                        // ---------------------------------------------------

                    }

                    // set all instructions 'already done'
                    for (int i = 0; i < kiviList.size() - 1; i++) {
                        kiviList.get(i).setColor(colorForegroundAlreadyDoneMicrostep);
                        kiviList.get(i).setBackgroundColor(colorBackgroundAlreadyDoneMicrostep);
                        kiviList.get(i).execute();
                    }
                    // set last instruction 'active'
                    kiviList.get(kiviList.size() - 1).setColor(colorForegroundActiveMicrostep);
                    kiviList.get(kiviList.size() - 1).setBackgroundColor(
                            colorBackgroundActiveMicrostep);
                    kiviList.get(kiviList.size() - 1).execute();
                    // adjust microstep counter
                    microStepNumber = kiviList.size() - 1;

                } catch (JSONException e) {
                    e.printStackTrace();
                }
                // ----------------------------------------------------------

            } // end run()
        }); // end asyncExec()
    }

    private static String getProperSJInstruktionName(final String instr) {
        for (int i = 0; i < KlotsConstants.SJ_INSTRUCTIONS_MAP_SIZE; i++) {
            if (instr.equals(KlotsConstants.SJ_INSTSTRUCTIONS_MAP[i][0])) {
                return KlotsConstants.SJ_INSTSTRUCTIONS_MAP[i][1];
            }
        }
        return "INSTRUCTION MAPPING ERROR";
    }

    /**
     * Creates the highlight effect.
     * 
     * @param instrName
     *            the instr name
     * @param instrData
     *            the instr data
     * @param chronology
     *            the chronology
     * @throws JSONException
     *             the jSON exception
     */
    protected static void createHighlightEffect(final String instrName, final JSONObject instrData,
            final int chronology) throws JSONException {
        LabelInfo label = null;
        System.out.print("$$$$$$>>> LABELS IN LIST: [");
        for (LabelInfo info : labelList) {
            System.out.print(info.getLabelName() + ", ");
            if (info.getLabelName().equals(instrData.getString(KlotsConstants.JSON_LABEL_TAG))) {
                label = info;
                break;
            }
        }
        System.out.println("]");

        if (label == null) {
            System.err.println("=> Instruction >" + instrName + "< not found at label >"
                    + instrData.getString(KlotsConstants.JSON_LABEL_TAG) + "<! No such label!");
        }
        IMarker marker = null;
        List<IMarker> list = label.getSJInstructions();

        // search for the instruction from current position to the end of the
        // label range
        for (int i = label.getSJInstructionCursor(); i < list.size(); i++) {
            if ((list.get(i).getAttribute(
                    KlotsConstants.SJ_INSTRUCTION_MARKER_ATTRIBUTE_INSTRUCTION_NAME, "NO NAME"))
                    .equals(instrName)) {
                marker = list.get(i);
                label.setSJInstructionCursor(i + 1);
                break;
            }
        }

        // if instruction not found till end of label range goto label start and
        // search from there
        if (marker == null) {
            for (int i = 0; i < label.getSJInstructionCursor(); i++) {
                if ((list.get(i).getAttribute(
                        KlotsConstants.SJ_INSTRUCTION_MARKER_ATTRIBUTE_INSTRUCTION_NAME, "NO NAME"))
                        .equals(instrName)) {
                    marker = list.get(i);
                    label.setSJInstructionCursor(i + 1);
                    break;
                }
            }
        }

        // if instruction not found at all -> ERROR!
        if (marker == null) {
            if (instrName.equals("isPresent")) {
                System.out.println("=> skipping instruction >present<");
                System.out.println("======================================================\n");
            } else {
                System.err.println("=> Instruction >" + instrName + "< not found at label >"
                        + label.getLabelName() + "<! No such instruction!");
            }
            return;
        }

        // create highlight effect
        HighlightSJMarkerEffect e = new HighlightSJMarkerEffect(marker,
                colorForegroundYetToBeDoneMicrostep, colorBackgroundYetToBeDoneMicrostep,
                colorForegroundStandard, colorBackgroundStandard, getEditor());
        kiviList.add(e);
    }

    // ======================================================================
    // >>>>>>>>>> INTERACTIONS WITH THE KIEM DATA OBSERVER <<<<<<<<<<
    // ======================================================================

    /**
     * Update.
     * 
     * @param data
     *            the data
     * @param historyData
     *            the history data
     */
    public void update(final StringBuffer data, final boolean historyData) {
        update(data.toString(), historyData);
    }

    /**
     * Update.
     * 
     * @param data
     *            the data
     * @param historyData
     *            the history data
     */
    public void update(final String data, final boolean historyData) {
        sjInstructionsUpdateData = data;
        // -----------------------------------------------
        // if( !historyData ) {
        // SJEditor.updateExecutionTraceViewer();
        // }
        updateJavaEditor();
        // -----------------------------------------------
    }

    /**
     * Use as execution viewer.
     * 
     * @param b
     *            the b
     */
    public void useAsExecutionViewer(final boolean b) {
        Display.getDefault().asyncExec(new Runnable() {
            public void run() {
                getViewer().getTextWidget().setEditable(!b);
            }
        });
    }

    /**
     * @return String[]
     */
    public String[] getSignals() {
        if (signals == null) {
            parseSignals(true, 0, 0);
        }
        return signals;
    }

    // ======================================================================
    // >>>>>>>>>> INTERACTIONS WITH THE SJ INSTRUCTIONS VIEW <<<<<<<<<<
    // ======================================================================

    /**
     * 
     */
    public void doMicroStepForwards() {
        System.out.println(">>> this.doMicroStepForwards() >>> microStepNumber = "
                + microStepNumber);
        if (microStepNumber >= kiviList.size() - 1) {
            return;
        }
        if (microStepNumber == -1) {
            // set all instructions 'yet to be done'
            for (int i = 1; i < kiviList.size(); i++) {
                kiviList.get(i).setColor(colorForegroundYetToBeDoneMicrostep);
                kiviList.get(i).setBackgroundColor(colorBackgroundYetToBeDoneMicrostep);
                kiviList.get(i).execute();
            }
        } else {
            // set old current instruction 'already done'
            kiviList.get(microStepNumber).setColor(colorForegroundAlreadyDoneMicrostep);
            kiviList.get(microStepNumber).setBackgroundColor(colorBackgroundAlreadyDoneMicrostep);
            kiviList.get(microStepNumber).execute();
        }
        // set new current instruction 'active'
        microStepNumber++;
        kiviList.get(microStepNumber).setColor(colorForegroundActiveMicrostep);
        kiviList.get(microStepNumber).setBackgroundColor(colorBackgroundActiveMicrostep);
        kiviList.get(microStepNumber).execute();
    }

    /**
     * 
     */
    public void doMicroStepBackwards() {
        if (microStepNumber > 0) {
            // set old current instruction 'yet to be done'
            kiviList.get(microStepNumber).setColor(colorForegroundYetToBeDoneMicrostep);
            kiviList.get(microStepNumber).setBackgroundColor(colorBackgroundYetToBeDoneMicrostep);
            kiviList.get(microStepNumber).execute();
            // set new current instruction 'active'
            microStepNumber--;
            kiviList.get(microStepNumber).setColor(colorForegroundActiveMicrostep);
            kiviList.get(microStepNumber).setBackgroundColor(colorBackgroundActiveMicrostep);
            kiviList.get(microStepNumber).execute();
        }
    }

    /**
     * 
     */
    public void doAllForwardMicroSteps() {
        // set all instructions 'already done'
        for (int i = 0; i < kiviList.size() - 1; i++) {
            kiviList.get(i).setColor(colorForegroundAlreadyDoneMicrostep);
            kiviList.get(i).setBackgroundColor(colorBackgroundAlreadyDoneMicrostep);
            kiviList.get(i).execute();
        }
        // set last instruction 'active'
        kiviList.get(kiviList.size() - 1).setColor(colorForegroundActiveMicrostep);
        kiviList.get(kiviList.size() - 1).setBackgroundColor(colorBackgroundActiveMicrostep);
        kiviList.get(kiviList.size() - 1).execute();
        // adjust microstep counter
        microStepNumber = kiviList.size() - 1;
    }

    /**
     * 
     */
    public void doAllBackwardMicroSteps() {
        microStepNumber = -1;
        doMicroStepForwards();
    }

    /**
     * 
     */
    public void doClearAllMicroSteps() {
        for (HighlightSJMarkerEffect e : kiviList) {
            e.undo();
        }
    }

    /**
     * 
     */
    public void doResetMicroSteps() {
        microStepNumber = -1;
    }

    /**
     * Do specific single micro step.
     * 
     * @param indexArray
     *            the index array
     */
    public void doSpecificSingleMicroStep(final int[] indexArray) {
        // highlight 'already done' instructions
        for (int i = 0; i < indexArray[0]; i++) {
            kiviList.get(i).setColor(colorForegroundAlreadyDoneMicrostep);
            kiviList.get(i).setBackgroundColor(colorBackgroundAlreadyDoneMicrostep);
            kiviList.get(i).execute();
        }
        // highlight 'yet to be done' instructions
        for (int i = indexArray[0] + 1; i < kiviList.size(); i++) {
            kiviList.get(i).setColor(colorForegroundYetToBeDoneMicrostep);
            kiviList.get(i).setBackgroundColor(colorBackgroundYetToBeDoneMicrostep);
            kiviList.get(i).execute();
        }
        // highlight 'active' instructions
        for (int i = 0; i < indexArray.length; i++) {
            kiviList.get(indexArray[i]).setColor(colorForegroundActiveMicrostep);
            kiviList.get(indexArray[i]).setBackgroundColor(colorBackgroundActiveMicrostep);
            kiviList.get(indexArray[i]).execute();
        }
        // adjust microStepNumber
        microStepNumber = indexArray[0];
    }

    /**
     * 
     */
    public void repaintAllMicroSteps() {
        if (microStepNumber < 0 || microStepNumber > kiviList.size()) {
            return;
        }
        // repaint 'already done' instructions
        for (int i = 0; i < microStepNumber; i++) {
            kiviList.get(i).setColor(colorForegroundAlreadyDoneMicrostep);
            kiviList.get(i).setBackgroundColor(colorBackgroundAlreadyDoneMicrostep);
            kiviList.get(i).execute();
        }
        // repaint 'yet to be done' instructions
        for (int i = microStepNumber + 1; i < kiviList.size(); i++) {
            kiviList.get(i).setColor(colorForegroundYetToBeDoneMicrostep);
            kiviList.get(i).setBackgroundColor(colorBackgroundYetToBeDoneMicrostep);
            kiviList.get(i).execute();
        }
        // repaint 'active' instruction
        kiviList.get(microStepNumber).setColor(colorForegroundActiveMicrostep);
        kiviList.get(microStepNumber).setBackgroundColor(colorBackgroundActiveMicrostep);
        kiviList.get(microStepNumber).execute();
    }

    // XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
    // XXXXXXXXXX HISTORICAL METHODS XXXXXXXXXX
    // XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX

    // private void bindToDataPool() {
    // buffer.addPropertyChangeListener(buffer.DATA_BUFFER, new
    // PropertyChangeListener() {
    // public void propertyChange(PropertyChangeEvent e) {
    // sjCoreData = ((StringBuffer) e.getNewValue()).toString();
    // inputData = inputData.append("\n").append( (StringBuffer) e.getNewValue()
    // );
    // // -----------------------------------------------
    // SJEditorWithKiVi.updateExecutionTraceViewer();
    // SJEditorWithKiVi.updateJavaEditor();
    // // -----------------------------------------------
    // }
    // });
    // buffer.addPropertyChangeListener(buffer.ACTION_FLAG, new
    // PropertyChangeListener() {
    // public void propertyChange(PropertyChangeEvent e) {
    // if( (Integer) e.getNewValue() == buffer.START_ACTION ) {
    // Display.getDefault().syncExec(new Runnable() {
    // public void run() {
    // // set the java editor read only
    // editor.getViewer().getTextWidget().setEditable(false);
    //
    // // ------------ set tool tip TESTER -------------
    // final StyledText t = editor.getViewer().getTextWidget();
    // String s = t.getText();
    // int i = s.indexOf("public void tick()");
    // Point p = t.getLocationAtOffset(i) ;
    // final Rectangle r = new Rectangle( p.x, p.y, 200, t.getLineHeight() );
    // Listener mouseListener = new Listener () {
    // public void handleEvent (Event event) {
    // switch (event.type) {
    // case SWT.MouseEnter:
    // case SWT.MouseMove:
    // if (r.contains (event.x, event.y)) {
    // String text = "ToolTip >tick()<";
    // if (!(text.equals (t.getToolTipText ()))) {
    // t.setToolTipText ("ToolTip >tick()<");
    // }
    // return;
    // }
    // t.setToolTipText(null);
    // break;
    // }
    // }
    // };
    // t.addListener (SWT.MouseMove, mouseListener);
    // t.addListener (SWT.MouseEnter, mouseListener);
    // // ----------------------------------------------
    //
    // // ------------- set marker TESTER --------------
    // IFile file = ((IFileEditorInput) editor.getEditorInput()).getFile();
    // IMarker marker = createInstructionMarker(file,
    // "INSTRUCTION INFO\nTO BE DISPLAYED", 66);
    // //MarkerViewUtil.showMarker(page, marker, showView);
    // // ----------------------------------------------
    // }
    // });
    // } else if( (Integer) e.getNewValue() == buffer.STOP_ACTION ) {
    // Display.getDefault().syncExec(new Runnable() {
    // public void run() {
    // editor.getViewer().getTextWidget().setEditable(true);
    // // set tool tip
    // editor.getViewer().getTextWidget().setToolTipText("");
    // }
    // });
    // }
    // }
    // });
    // }

    // private IMarker createInstructionMarker(IResource res, String msg, String
    // instrName, String instrLabel, int line, int charStart, int charEnd) {
    // try {
    // IMarker marker =
    // res.createMarker("de.cau.cs.kieler.klots.editor.instructionMarker");
    // marker.setAttribute("instructionName", instrName);
    // marker.setAttribute("instructionLabel", instrLabel);
    // marker.setAttribute(IMarker.LINE_NUMBER, line);
    // marker.setAttribute(IMarker.CHAR_START, charStart);
    // marker.setAttribute(IMarker.CHAR_END, charEnd);
    // marker.setAttribute(IMarker.MESSAGE, msg);
    // //marker.setAttribute(IMarker.PRIORITY, IMarker.PRIORITY_HIGH);
    // //marker.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_ERROR);
    // return marker;
    // } catch (CoreException e) {
    // // You need to handle the cases where attribute value is rejected
    // e.printStackTrace();
    // return null;
    // }
    // }

    // private void fillLabelList() {
    // // fixme: Find a way to deal with 'case' inside of a comment!
    // // fixme: Initialization method is needed in case the editor's content is
    // edited and execution is started again
    // labelList.clear();
    //
    // //
    // -----------------------------------------------------------------------------------
    // // editor.getViewer().getTextWidget().getText() DOES NOT FACTOR IN THE
    // HIDDEN TEXT!!!!
    // //String text = editor.getViewer().getTextWidget().getText();
    // String text =
    // editor.getDocumentProvider().getDocument(editor.getEditorInput()).get();
    // //
    // -----------------------------------------------------------------------------------
    // int size = text.length();
    //
    // for(int i = text.indexOf(" case "), j = text.indexOf(":", i);
    // (0 < i && i < size);
    // i = text.indexOf(" case ", i+1), j = text.indexOf(":", i)) {
    // System.out.println("################>>>>>>>>>>>> i = " + i + ", j = " +
    // j);
    //
    // // ----------------------- fill labelList -----------------------
    // int end = text.indexOf(" case ", i+1);
    // System.out.println("===> i = " + i + ", end = " + end);
    // if( end < 0 ) {
    // end = text.lastIndexOf(';') + 1;
    // }
    // String labelText = text.substring(i, end);
    // String labelName = text.substring( i+6, text.indexOf(':', i+6) );
    // int labelEndIndex = labelText.lastIndexOf(';') + i;
    // System.out.println("\n++++++++++++++++++++++++++++++++++++++++");
    // System.out.println("ADDING LABEL: >" + labelName + "<");
    // System.out.println("start index = " + (i+6));
    // System.out.println("end index = " + labelEndIndex);
    // System.out.println("label text = \n" + labelText);
    // System.out.println("++++++++++++++++++++++++++++++++++++++++\n");
    // labelList.add( new LabelInfo(labelName, i+6, labelEndIndex) );
    // // --------------------------------------------------------------
    //
    // }
    // }

    // protected static void highlightInstruction(String instrName, JSONObject
    // instrData, int chronology)
    // throws JSONException {
    //
    // //
    // -----------------------------------------------------------------------------------
    // // editor.getViewer().getTextWidget().getText() DOES NOT FACTOR IN THE
    // HIDDEN TEXT!!!!
    // //String text = editor.getViewer().getTextWidget().getText();
    // String text =
    // editor.getDocumentProvider().getDocument(editor.getEditorInput()).get();
    // //
    // -----------------------------------------------------------------------------------
    //
    // LabelInfo label = null;
    // System.out.print("$$$$$$>>> LABELS IN LIST: [");
    // for(LabelInfo info : labelList) {
    // System.out.print(info.getLabelName() + ", ");
    // if( info.getLabelName().equals(instrData.getString("label")) ) {
    // label = info;
    // break;
    // }
    // }
    // System.out.println("]");
    //
    // if( label == null ) {
    // System.err.println("=> Instruction >" + instrName +
    // "< not found at label >" + instrData.getString("label") +
    // "<! No such label!");
    // }
    // int instrStartOffset = text.indexOf( instrName + "(",
    // label.getCursorIndex()-1 );
    // int instrEndOffset = -1;
    // System.out.println("======================================================\n");
    // System.out.println("instrName = " + instrName);
    // System.out.println("label.getLabelName() = " + label.getLabelName());
    // System.out.println("label.getLabelStartIndex() = " +
    // label.getLabelStartIndex());
    // System.out.println("label.getLabelEndIndex() = " +
    // label.getLabelEndIndex());
    // System.out.println("label.getCursorIndex() = " + label.getCursorIndex());
    //
    // // if instruction not found till end of label range goto label start and
    // search from there
    // if( instrStartOffset < 0 || instrStartOffset > label.getLabelEndIndex() )
    // {
    // label.setCursorIndex( label.getLabelStartIndex() );
    // instrStartOffset = text.indexOf( instrName + "(",
    // label.getCursorIndex()-1 );
    // // if instruction not found at all -> ERROR!
    // if( instrStartOffset < 0 ) {
    // if( instrName.equals("isPresent") ) {
    // System.out.println("=> skipping instruction >present<");
    // System.out.println("======================================================\n");
    // return;
    // } else {
    // System.err.println("=> Instruction >" + instrName +
    // "< not found at label >" + label.getLabelName() +
    // "<! No such instruction!");
    // }
    // }
    // }
    // instrEndOffset = text.indexOf(')', instrStartOffset) + 1;
    // label.setCursorIndex(instrEndOffset + 1);
    // System.out.println("instrStartOffset = " + instrStartOffset);
    // System.out.println("instrEndOffset = " + instrEndOffset);
    // System.out.println("Paint text: " + text.substring(instrStartOffset,
    // instrEndOffset));
    // System.out.println("=====================================\n");
    // try {
    //
    // // ---------- highlight instruction using KiVi effect -----------
    // //HighlightSJInstructionEffect e = new
    // HighlightSJInstructionEffect(instrStartOffset,
    // instrEndOffset-instrStartOffset, FOREGROUND_HIGHLIGHT_COLOR,
    // BACKGROUND_HIGHLIGHT_COLOR, FOREGROUND_STANDARD_COLOR,
    // BACKGROUND_STANDARD_COLOR, editor);
    // //HighlightSJInstructionEffect e = new
    // HighlightSJInstructionEffect(instrStartOffset,
    // instrEndOffset-instrStartOffset, FOREGROUND_HIGHLIGHT_COLOR, null,
    // FOREGROUND_STANDARD_COLOR, null, editor);
    // HighlightSJInstructionEffect e = new
    // HighlightSJInstructionEffect(instrStartOffset,
    // instrEndOffset-instrStartOffset,
    // YET_TO_BE_DONE_MICROSTEP_FOREGROUND_COLOR, null,
    // FOREGROUND_STANDARD_COLOR, null, editor);
    // kiviList.add(e);
    // //e.execute();
    // // --------------------------------------------------------------
    //
    // } catch(Exception e) {
    // e.printStackTrace();
    // }
    //
    // }

    // public void setLabelNames(String[] labels) {
    // System.out.print("======>>>>>>>> RECEIVED LABELS: [");
    // for( String l : labels ) {
    // System.out.print(l + ", ");
    // }
    // System.out.println("]");
    // this.labels = labels;
    //
    // // -----------
    // parseLabels();
    // // -----------
    //
    // // -------------------
    // parseSJInstructions();
    // // -------------------
    //
    // }

}
