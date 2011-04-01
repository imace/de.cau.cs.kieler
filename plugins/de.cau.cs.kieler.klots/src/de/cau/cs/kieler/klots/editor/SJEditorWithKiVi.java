package de.cau.cs.kieler.klots.editor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.jdt.internal.ui.javaeditor.CompilationUnitEditor;
import org.eclipse.jdt.internal.ui.javaeditor.JavaEditor;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;

import org.eclipse.jface.action.IStatusLineManager;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.part.MultiPageEditorPart;
import org.eclipse.ui.texteditor.StatusLineContributionItem;
import org.eclipse.ui.ide.IDE;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


/**
 * An example showing how to create a multi-page editor.
 * This example has 3 pages:
 * <ul>
 * <li>page 0 contains a nested text editor.
 * <li>page 1 allows you to change the font used in page 2
 * <li>page 2 shows the words in page 0 in sorted order
 * </ul>
 */
@SuppressWarnings("restriction")
public class SJEditorWithKiVi extends MultiPageEditorPart implements IResourceChangeListener {
	
	
	// ======================================================================
	// >>>>>>>>>>              LABEL INFO INNER CLASS              <<<<<<<<<<
	// ======================================================================
	
	class LabelInfo {
		String labelName;
		int labelStartIndex;
		int labelEndIndex;
		int cursorIndex;
		
		LabelInfo(String name, int startIndex, int endIndex) {
			this.labelName = name;
			this.labelStartIndex = startIndex;
			this.labelEndIndex = endIndex;
			this.cursorIndex = startIndex;
		}
		
		int getCursorIndex() {
			return cursorIndex;
		}
		
		void setCursorIndex(int cursorIndex) {
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
	} //end inner class LabelInfo
	
	
	
	
	// ======================================================================
	// >>>>>>>>>>                FIELDS & VARIABLES                <<<<<<<<<<
	// ======================================================================
	
	// HIGHLIGHT COLORS
	// black
	private final static Color FOREGROUND_STANDARD_COLOR = new Color(Display.getDefault(), 0, 0, 0);
	// white
	private final static Color BACKGROUND_STANDARD_COLOR = new Color(Display.getDefault(), 255, 255, 255);
	// medium spring green
	private final static Color EXTRA_FOREGROUND_HIGHLIGHT_COLOR = new Color(Display.getDefault(), 0, 250, 154);
	// khaki
	private final static Color EXTRA_BACKGROUND_HIGHLIGHT_COLOR = new Color(Display.getDefault(), 240, 230, 140);
	
	// dark orange
	private final static Color ALREADY_DONE_MICROSTEP_FOREGROUND_COLOR = new Color(Display.getDefault(), 255, 140, 0);
	// alice blue
	private final static Color ALREADY_DONE_MICROSTEP_BACKGROUND_COLOR = new Color(Display.getDefault(), 240, 248, 255);
	// red
	private final static Color ACTIVE_MICROSTEP_FOREGROUND_COLOR = new Color(Display.getDefault(), 255, 0, 0);
	// alice blue
	private final static Color ACTIVE_MICROSTEP_BACKGROUND_COLOR = new Color(Display.getDefault(), 240, 248, 255);
	// medium spring green
	private final static Color YET_TO_BE_DONE_MICROSTEP_FOREGROUND_COLOR = new Color(Display.getDefault(), 0, 250, 154);
	// alice blue
	private final static Color YET_TO_BE_DONE_MICROSTEP_BACKGROUND_COLOR = new Color(Display.getDefault(), 240, 248, 255);
	
	// SJ instructions
	private final static String[][] sjInstructionsMap = {
		// normal instructions
		{"abort", "abort"},
		{"awaitDone", "awaitDoneCB"},
		{"fork", "fork"},
		{"forke", "forkEB"},
		{"goto", "gotoB"},
		{"halt", "haltCB"},
		{"joinDone", "joinDoneCB"},
		{"pause", "pauseB"},
		{"prio", "prioB"},
		{"suspend", "suspend"},
		{"term", "termB"},
		{"trans", "transB"},
		// signal instructions
		{"present", "isPresent"},
		{"emit", "emit"},
		{"sustain", "sustainCB"},
		{"pre", "pre"}};
	private final static int sjInstructionsMapSize = 16;

	// KiVi effects lists
	private static int microStepNumber = -1;
	private static List<HighlightSJInstructionEffect> kiviList = new ArrayList<HighlightSJInstructionEffect>();
	// label list
	private static List<LabelInfo> labelList = new ArrayList<LabelInfo>();

	// Java editor
	private static CompilationUnitEditor editor;
	// SJ instructions highlight update data
	protected static String sjInstructionsUpdateData = "";
	// execution trace viewer
	private static StyledText executionTraceViewer;
	// execution trace viewer data to be displayed
	private static StringBuffer executionTraceUpdateData = new StringBuffer();
	
	
	// status line SJ display
	private StatusLineContributionItem uiStatusLineItem;
	
	
	
	
	// ======================================================================
	// >>>>>>>>>>                   CONSTRUCTORS                   <<<<<<<<<<
	// ======================================================================
	
	/**
	 * Creates a multi-page editor example.
	 */
	public SJEditorWithKiVi() {
		super();
		ResourcesPlugin.getWorkspace().addResourceChangeListener(this);
	}
	
	
	
	
	// ######################################################################
	// ######################     METHODS SECTION     #######################
	// ######################################################################
	
	
	// ======================================================================
	// >>>>>>>>>>     STANDARD IMPLEMENTETION METHODS & SETUP      <<<<<<<<<<
	// ======================================================================
	
	/**
	 * Creates page 0 of the multi-page editor,
	 * which contains a java editor.
	 */
	void createJavaEditorPage() {
        try {
            IEditorInput input = getEditorInput();
            setPartName(input.getName());
            editor = new CompilationUnitEditor();
            int index = addPage(editor, input);
            setPageText(index, "Source");
        } catch (PartInitException e) {
            ErrorDialog.openError(getSite().getShell(),
                    "Error creating nested text editor", null, e.getStatus());
        }
    }
	
	public JavaEditor getJavaEditor() {
		return editor;
	}
	
	
	void createExecutionTraceViewerPage() {
		Composite composite = new Composite(getContainer(), SWT.NONE);
		FillLayout layout = new FillLayout();
		composite.setLayout(layout);
		executionTraceViewer = new StyledText(composite, SWT.H_SCROLL | SWT.V_SCROLL);
		executionTraceViewer.setEditable(false);

		int index = addPage(composite);
		setPageText(index, "Execution Trace");
	}
	
	
	/**
	 * Creates the pages of the multi-page editor.
	 */
	protected void createPages() {
		createJavaEditorPage();
		createExecutionTraceViewerPage();
		
		// -------------------- set up the status line ----------------------  
		IActionBars aBars = editor.getEditorSite().getActionBars();
		IStatusLineManager man = aBars.getStatusLineManager();
		uiStatusLineItem = new StatusLineContributionItem("uiStatusLineItem", true, 100);
		man.add(uiStatusLineItem);
		aBars.updateActionBars();
		uiStatusLineItem.setToolTipText("DO WE NEED A TOOL TIP TEXT?");
		uiStatusLineItem.setErrorText("INSTRUCTION INFO TO BE DISPAYED");
		// ------------------------------------------------------------------
		
		// --------------
		fillLabelList();
		// --------------
	
	}
	
	
	/**
	 * The <code>MultiPageEditorPart</code> implementation of this 
	 * <code>IWorkbenchPart</code> method disposes all nested editors.
	 * Subclasses may extend.
	 */
	public void dispose() {
		ResourcesPlugin.getWorkspace().removeResourceChangeListener(this);
		super.dispose();
	}
	
	/**
	 * Saves the multi-page editor's document.
	 */
	public void doSave(IProgressMonitor monitor) {
		getEditor(0).doSave(monitor);
	}
	
	/**
	 * Saves the multi-page editor's document as another file.
	 * Also updates the text for page 0's tab, and updates this multi-page editor's input
	 * to correspond to the nested editor's.
	 */
	public void doSaveAs() {
		IEditorPart editor = getEditor(0);
		editor.doSaveAs();
		setPageText(0, editor.getTitle());
		setInput(editor.getEditorInput());
	}
	
	/* (non-Javadoc)
	 * Method declared on IEditorPart
	 */
	public void gotoMarker(IMarker marker) {
		setActivePage(0);
		IDE.gotoMarker(getEditor(0), marker);
	}
	
	/**
	 * The <code>MultiPageEditorExample</code> implementation of this method
	 * checks that the input is an instance of <code>IFileEditorInput</code>.
	 */
	public void init(IEditorSite site, IEditorInput editorInput)
		throws PartInitException {
		if (!(editorInput instanceof IFileEditorInput))
			throw new PartInitException("Invalid Input: Must be IFileEditorInput");
		super.init(site, editorInput);
	}
	
	/* (non-Javadoc)
	 * Method declared on IEditorPart.
	 */
	public boolean isSaveAsAllowed() {
		return true;
	}
	
	/**
	 * Calculates the contents of page 2 when the it is activated.
	 */
	protected void pageChange(int newPageIndex) {
		super.pageChange(newPageIndex);
	}
	
	/**
	 * Closes all project files on project close.
	 */
	public void resourceChanged(final IResourceChangeEvent event){
		if(event.getType() == IResourceChangeEvent.PRE_CLOSE){
			Display.getDefault().asyncExec(new Runnable(){
				public void run(){
					IWorkbenchPage[] pages = getSite().getWorkbenchWindow().getPages();
					for (int i = 0; i<pages.length; i++){
						if(((FileEditorInput)editor.getEditorInput()).getFile().getProject().equals(event.getResource())){
							IEditorPart editorPart = pages[i].findEditor(editor.getEditorInput());
							pages[i].closeEditor(editorPart,true);
						}
					}
				}            
			});
		}
	}
	
		
	
	
	// ======================================================================
	// >>>>>>>>>>            MACRO STEP UPDATE METHODS             <<<<<<<<<<
	// ======================================================================
	
	static void updateJavaEditor() {
		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				
				// ------------ undo highlight old instructions -------------
				for(HighlightSJInstructionEffect e : kiviList) {
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
					for(int i = 2, j = 1; i < array.length()-2; i++, j++) {
						instruction = array.getJSONObject(i);
						Iterator<?> iter = instruction.keys();
						key = (String) iter.next();
						instructionData = instruction.getJSONObject(key);
						key = getProperSJInstruktionName(key);
						
						// -------------------------------------------
						highlightInstruction(key, instructionData, j);
						// -------------------------------------------
						
					}
					
					// set all instructions 'already done'
					for(int i = 0; i < kiviList.size()-1; i++) {
						kiviList.get(i).setColor(ALREADY_DONE_MICROSTEP_FOREGROUND_COLOR);
//						kiviList.get(i).setBackgroundColor(ALREADY_DONE_MICROSTEP_BACKGROUND_COLOR);
						kiviList.get(i).execute();
					}
					// set last instruction 'active'
					kiviList.get(kiviList.size()-1).setColor(ACTIVE_MICROSTEP_FOREGROUND_COLOR);
//					kiviList.get(kiviList.size()-1).setBackgroundColor(ACTIVE_MICROSTEP_BACKGROUND_COLOR);
					kiviList.get(kiviList.size()-1).execute();
					// adjust microstep counter 
					microStepNumber = kiviList.size()-1;
					
				} catch(JSONException e) {
					e.printStackTrace();
				}
				// ----------------------------------------------------------
				
			} //end run()
		}); // end syncExec()
	}
	
	
	
	private static String getProperSJInstruktionName(String instr) {
		for(int i = 0; i < sjInstructionsMapSize; i++) {
			if( instr.equals(sjInstructionsMap[i][0]) ) {
				return sjInstructionsMap[i][1];
			}
		}
		return "INSTRUCTION MAPPING ERROR";
	}
	
	
	
	protected static void highlightInstruction(String instrName, JSONObject instrData, int chronology) 
	throws JSONException {
		//Device dev = editor.getViewer().getTextWidget().getDisplay();
		
		// -----------------------------------------------------------------------------------
		// editor.getViewer().getTextWidget().getText() DOES NOT FACTOR IN THE HIDDEN TEXT!!!!
		//String text = editor.getViewer().getTextWidget().getText();
		String text = editor.getDocumentProvider().getDocument(editor.getEditorInput()).get();
		// -----------------------------------------------------------------------------------
		
		LabelInfo label = null;
		System.out.print("$$$$$$>>> LABELS IN LIST: [");
		for(LabelInfo info : labelList) {
			System.out.print(info.getLabelName() + ", ");
			if( info.getLabelName().equals(instrData.getString("label")) ) {
				label = info;
				break;
			}
		}
		System.out.println("]");
		
		if( label == null ) {
			System.err.println("=> Instruction >" + instrName + "< not found at label >" + instrData.getString("label") + "<! No such label!");
		}
		int instrStartOffset = text.indexOf( instrName + "(", label.getCursorIndex()-1 );
		int instrEndOffset = -1;
		System.out.println("\n§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§");
		System.out.println("instrName = " + instrName);
		System.out.println("label.getLabelName() = " + label.getLabelName());
		System.out.println("label.getLabelStartIndex() = " + label.getLabelStartIndex());
		System.out.println("label.getLabelEndIndex() = " + label.getLabelEndIndex());
		System.out.println("label.getCursorIndex() = " + label.getCursorIndex());
		
		// if instruction not found till end of label range goto label start and search from there
		if( instrStartOffset < 0 || instrStartOffset > label.getLabelEndIndex() ) {
			label.setCursorIndex( label.getLabelStartIndex() );
			instrStartOffset = text.indexOf( instrName + "(", label.getCursorIndex()-1 );
			// if instruction not found at all -> ERROR!
			if( instrStartOffset < 0 ) {
				if( instrName.equals("isPresent") ) {
					System.out.println("=> skipping instruction >present<"); 
					System.out.println("§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§\n");
					return;
				} else {
					System.err.println("=> Instruction >" + instrName + "< not found at label >" + label.getLabelName() + "<! No such instruction!");
				}
			}
		}
		instrEndOffset = text.indexOf(')', instrStartOffset) + 1;
		label.setCursorIndex(instrEndOffset + 1);
		System.out.println("instrStartOffset = " + instrStartOffset);
		System.out.println("instrEndOffset = " + instrEndOffset);
		System.out.println("Paint text: " + text.substring(instrStartOffset, instrEndOffset));
		System.out.println("§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§\n");
		try {
			
			// ---------- highlight instruction using KiVi effect ----------- 
			//HighlightSJInstructionEffect e = new HighlightSJInstructionEffect(instrStartOffset, instrEndOffset-instrStartOffset, FOREGROUND_HIGHLIGHT_COLOR, BACKGROUND_HIGHLIGHT_COLOR, FOREGROUND_STANDARD_COLOR, BACKGROUND_STANDARD_COLOR, editor);
			//HighlightSJInstructionEffect e = new HighlightSJInstructionEffect(instrStartOffset, instrEndOffset-instrStartOffset, FOREGROUND_HIGHLIGHT_COLOR, null, FOREGROUND_STANDARD_COLOR, null, editor);
			HighlightSJInstructionEffect e = new HighlightSJInstructionEffect(instrStartOffset, instrEndOffset-instrStartOffset, YET_TO_BE_DONE_MICROSTEP_FOREGROUND_COLOR, null, FOREGROUND_STANDARD_COLOR, null, editor);
			kiviList.add(e);
			//e.execute();
			// --------------------------------------------------------------
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	static void updateExecutionTraceViewer() {
		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				executionTraceViewer.setText(executionTraceUpdateData.toString());
			}
		});
	}
	
	
	
	
	
	// ======================================================================
	// >>>>>>>>>>          INITIALIZATION UTILITY METHODS          <<<<<<<<<<
	// ======================================================================
	
	private void fillLabelList() {
		// FIXME: Initialization method is needed in case the editor's content is edited and execution is started again	
		// TODO: CHECK IF LABEL LIST HAS ELEMENTS AT ALL AT THIS TIME
		// reset labelList
		labelList.clear();
		
		// -----------------------------------------------------------------------------------
		// editor.getViewer().getTextWidget().getText() DOES NOT FACTOR IN THE HIDDEN TEXT!!!!
		//String text = editor.getViewer().getTextWidget().getText();
		String text = editor.getDocumentProvider().getDocument(editor.getEditorInput()).get();
		// -----------------------------------------------------------------------------------
		int size = text.length();
		
		for(int i = text.indexOf(" case "), j = text.indexOf(":", i);
		(0 < i && i < size);
		i = text.indexOf(" case ", i+1), j = text.indexOf(":", i)) {
			System.out.println("################>>>>>>>>>>>> i = " + i + ", j = " + j);
			
			// ----------------------- fill labelList -----------------------
			int end = text.indexOf(" case ", i+1);
			System.out.println("===> i = " + i + ", end = " + end);
			if( end < 0 ) {
				end = text.lastIndexOf(';') + 1;
			}
			String labelText = text.substring(i, end);
			String labelName = text.substring( i+6, text.indexOf(':', i+6) );
			int labelEndIndex = labelText.lastIndexOf(';') + i;
			System.out.println("\n++++++++++++++++++++++++++++++++++++++++");
			System.out.println("ADDING LABEL: >" + labelName + "<");
			System.out.println("start index = " + (i+6));
			System.out.println("end index = " + labelEndIndex);
			System.out.println("label text = \n" + labelText);
			System.out.println("++++++++++++++++++++++++++++++++++++++++\n");
			labelList.add( new LabelInfo(labelName, i+6, labelEndIndex) );
			// --------------------------------------------------------------
			
		}
	}
	
	
	
	
	
	// ======================================================================
	// >>>>>>>>>>     INTERACTIONS WITH THE KIEM DATA OBSERVER     <<<<<<<<<<
	// ======================================================================
	
	public void update(StringBuffer data, boolean historyData) {
		update(data.toString(), historyData);
	}
	
	
	public void update(String data, boolean historyData) {
		sjInstructionsUpdateData = data;
		executionTraceUpdateData = executionTraceUpdateData.append("\n\n").append(data);
		// -----------------------------------------------
		if( !historyData ) {
			SJEditorWithKiVi.updateExecutionTraceViewer();
		}
		SJEditorWithKiVi.updateJavaEditor();
		// -----------------------------------------------
	}
	
	
	public void useAsExecutionViewer(final boolean b) {
		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				editor.getViewer().getTextWidget().setEditable(!b);
			}
		});
	}
	
	
	
	
	
	// ======================================================================
	// >>>>>>>>>>    INTERACTIONS WITH THE EDITOR'S CONTRIBUTOR    <<<<<<<<<<
	// ======================================================================
	
	public void doMicroStepForwards() {
		if( microStepNumber >= kiviList.size()-1 ) {
			return;
		}
		if( microStepNumber == -1 ) {
			// set all instructions 'yet to be done'
			for(int i = 1; i < kiviList.size(); i++) {
				kiviList.get(i).setColor(YET_TO_BE_DONE_MICROSTEP_FOREGROUND_COLOR);
//				kiviList.get(i).setBackgroundColor(YET_TO_BE_DONE_MICROSTEP_BACKGROUND_COLOR);
				kiviList.get(i).execute();
			}
		} else {
			// set old current instruction 'already done'
			kiviList.get(microStepNumber).setColor(ALREADY_DONE_MICROSTEP_FOREGROUND_COLOR);
//			kiviList.get(microStepNumber).setBackgroundColor(ALREADY_DONE_MICROSTEP_BACKGROUND_COLOR);
			kiviList.get(microStepNumber).execute();
		}
		// set new current instruction 'active'
		microStepNumber++;
		kiviList.get(microStepNumber).setColor(ACTIVE_MICROSTEP_FOREGROUND_COLOR);
//		kiviList.get(microStepNumber).setBackgroundColor(ACTIVE_MICROSTEP_BACKGROUND_COLOR);
		kiviList.get(microStepNumber).execute();
	}
	
	
	public void doMicroStepBackwards() {
		if( microStepNumber > 0 ) {
			// set old current instruction 'yet to be done'
			kiviList.get(microStepNumber).setColor(YET_TO_BE_DONE_MICROSTEP_FOREGROUND_COLOR);
//			kiviList.get(microStepNumber).setBackgroundColor(YET_TO_BE_DONE_MICROSTEP_BACKGROUND_COLOR);
			kiviList.get(microStepNumber).execute();
			// set new current instruction 'active'
			microStepNumber--;
			kiviList.get(microStepNumber).setColor(ACTIVE_MICROSTEP_FOREGROUND_COLOR);
//			kiviList.get(microStepNumber).setBackgroundColor(ACTIVE_MICROSTEP_BACKGROUND_COLOR);
			kiviList.get(microStepNumber).execute();
		}
	}
	
	
	public void doAllForwardMicroSteps() {
		// set all instructions 'already done'
		for(int i = 0; i < kiviList.size()-1; i++) {
			kiviList.get(i).setColor(ALREADY_DONE_MICROSTEP_FOREGROUND_COLOR);
//			kiviList.get(i).setBackgroundColor(ALREADY_DONE_MICROSTEP_BACKGROUND_COLOR);
			kiviList.get(i).execute();
		}
		// set last instruction 'active'
		kiviList.get(kiviList.size()-1).setColor(ACTIVE_MICROSTEP_FOREGROUND_COLOR);
//		kiviList.get(kiviList.size()-1).setBackgroundColor(ACTIVE_MICROSTEP_BACKGROUND_COLOR);
		kiviList.get(kiviList.size()-1).execute();
		// adjust microstep counter 
		microStepNumber = kiviList.size()-1;
	}
	
	
	public void doAllBackwardMicroSteps() {
		//doClearAllMicroSteps();
		microStepNumber = -1;
		doMicroStepForwards();
	}
	
	
	public void doClearAllMicroSteps() {
		for(HighlightSJInstructionEffect e : kiviList) {
			e.undo();
		}
	}
	
	
	public void doResetMicroSteps() {
		microStepNumber = -1;
	}
	
	
	
	
	
	// ======================================================================
	// >>>>>>>>>>    INTERACTIONS WITH THE SJ INSTRUCTIONS VIEW    <<<<<<<<<<
	// ======================================================================
	
	public void doSpecificSingleMicroStep(int[] indexArray) {
		// highlight 'already done' instructions
		for(int i = 0; i < indexArray[0]; i++) {
			kiviList.get(i).setColor(ALREADY_DONE_MICROSTEP_FOREGROUND_COLOR);
//			kiviList.get(i).setBackgroundColor(ALREADY_DONE_MICROSTEP_BACKGROUND_COLOR);
			kiviList.get(i).execute();
		}
		// highlight 'yet to be done' instructions
		for(int i = indexArray[0]+1; i < kiviList.size(); i++) {
			kiviList.get(i).setColor(YET_TO_BE_DONE_MICROSTEP_FOREGROUND_COLOR);
//			kiviList.get(i).setBackgroundColor(YET_TO_BE_DONE_MICROSTEP_BACKGROUND_COLOR);
			kiviList.get(i).execute();
		}
		// highlight 'active' instructions
		for(int i = 0; i < indexArray.length; i++) {
			kiviList.get(indexArray[i]).setColor(ACTIVE_MICROSTEP_FOREGROUND_COLOR);
//			kiviList.get(indexArray[i]).setBackgroundColor(ACTIVE_MICROSTEP_BACKGROUND_COLOR);
			kiviList.get(indexArray[i]).execute();
		}
	}
	
	
	
	
//	public void doSpecificSingleMicroStep(int[] indexArray) {
//		undoHighlightsFromSJInstructionsView();
//		for( int i : indexArray ) {
//			HighlightSJInstructionEffect e = kiviList.get(i).clone();
//			e.setColor(EXTRA_FOREGROUND_HIGHLIGHT_COLOR);
//			kiviListFromSJInstructionsView.add(e);
//		}
//		executeHighlightsFromSJInstructionsView();
//	}
//	
//	
//	private static void undoHighlightsFromSJInstructionsView() {
//		for( HighlightSJInstructionEffect e : kiviListFromSJInstructionsView ) {
//			e.undo();
//		}
//		kiviListFromSJInstructionsView.clear();
//	}
//	
//	private void executeHighlightsFromSJInstructionsView() {
//		for( HighlightSJInstructionEffect e : kiviListFromSJInstructionsView ) {
//			e.execute();
//		}
//	}
	
	
	
	
	
	// XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
	// XXXXXXXXXX                HISTORICAL METHODS                XXXXXXXXXX
	// XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
	
//	private void bindToDataPool() {
//		buffer.addPropertyChangeListener(buffer.DATA_BUFFER, new PropertyChangeListener() {
//			public void propertyChange(PropertyChangeEvent e) {
//				sjCoreData = ((StringBuffer) e.getNewValue()).toString();
//				inputData = inputData.append("\n").append( (StringBuffer) e.getNewValue() );
//				// -----------------------------------------------
//				SJEditorWithKiVi.updateExecutionTraceViewer();
//				SJEditorWithKiVi.updateJavaEditor();
//				// -----------------------------------------------
//			}
//		});
//		buffer.addPropertyChangeListener(buffer.ACTION_FLAG, new PropertyChangeListener() {
//			public void propertyChange(PropertyChangeEvent e) {
//				if( (Integer) e.getNewValue() == buffer.START_ACTION ) {
//					Display.getDefault().syncExec(new Runnable() {
//						public void run() {
//							// set the java editor read only
//							editor.getViewer().getTextWidget().setEditable(false);
//							
//							// ------------ set tool tip TESTER -------------
//							final StyledText t = editor.getViewer().getTextWidget();
//							String s = t.getText();
//							int i = s.indexOf("public void tick()");
//							Point p = t.getLocationAtOffset(i) ;
//							final Rectangle r = new Rectangle( p.x, p.y, 200, t.getLineHeight() );
//							Listener mouseListener = new Listener () {
//								public void handleEvent (Event event) {
//									switch (event.type) {
//										case SWT.MouseEnter:
//										case SWT.MouseMove:
//											if (r.contains (event.x, event.y)) {
//												String text = "ToolTip >tick()<";
//												if (!(text.equals (t.getToolTipText ()))) {
//													t.setToolTipText ("ToolTip >tick()<");
//												}
//												return;
//											}
//										t.setToolTipText(null);
//										break;
//									}
//								}
//							};
//							t.addListener (SWT.MouseMove, mouseListener);
//							t.addListener (SWT.MouseEnter, mouseListener);
//							// ----------------------------------------------
//							
//							// ------------- set marker TESTER --------------
//							IFile file = ((IFileEditorInput) editor.getEditorInput()).getFile();
//							IMarker marker = createInstructionMarker(file, "INSTRUCTION INFO\nTO BE DISPLAYED", 66);
//							//MarkerViewUtil.showMarker(page, marker, showView);
//							// ----------------------------------------------
//						}
//					});
//				} else if( (Integer) e.getNewValue() == buffer.STOP_ACTION ) {
//					Display.getDefault().syncExec(new Runnable() {
//						public void run() {
//							editor.getViewer().getTextWidget().setEditable(true);
//							// set tool tip
//							editor.getViewer().getTextWidget().setToolTipText("");
//						}
//					});
//				}
//			}
//		});
//	}
//	
//	
//	
	private IMarker createInstructionMarker(IResource res, String msg, String instrName, String instrLabel, int line, int charStart, int charEnd) {
		try {
			IMarker marker = res.createMarker("de.cau.cs.kieler.klots.editor.instructionMarker");
			marker.setAttribute("instructionName", instrName);
			marker.setAttribute("instructionLabel", instrLabel);
			marker.setAttribute(IMarker.LINE_NUMBER, line);
			marker.setAttribute(IMarker.CHAR_START, charStart);
			marker.setAttribute(IMarker.CHAR_END, charEnd);
			marker.setAttribute(IMarker.MESSAGE, msg);
			//marker.setAttribute(IMarker.PRIORITY, IMarker.PRIORITY_HIGH);
			//marker.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_ERROR);
			return marker;
		} catch (CoreException e) {
			// You need to handle the cases where attribute value is rejected
			e.printStackTrace();
			return null;
		}
	}
	
	
	private void setupInstructionMarkers() {
		
	}
	
	
}
