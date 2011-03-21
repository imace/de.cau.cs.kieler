package de.cau.cs.kieler.klots.editor;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.jdt.internal.ui.javaeditor.CompilationUnitEditor;
import org.eclipse.jdt.internal.ui.javaeditor.JavaEditor;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IProgressMonitor;

import org.eclipse.jface.dialogs.ErrorDialog;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FontDialog;

import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.part.MultiPageEditorPart;
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
public class MultiPageEditor extends MultiPageEditorPart implements IResourceChangeListener {
	
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
	
	
	private static List<LabelInfo> labelList = new ArrayList<LabelInfo>();
	private static List<Integer> oldInstructionsStartOffsets = new ArrayList<Integer>();
	private static List<Integer> oldInstructionsEndOffsets = new ArrayList<Integer>();
	private static List<Integer> oldOldInstructionsStartOffsets = new ArrayList<Integer>();
	private static List<Integer> oldOldInstructionsEndOffsets = new ArrayList<Integer>();
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
	

	InputDataPool buffer = InputDataPool.getInstance();
		
	// Java editor
	private static CompilationUnitEditor editor;
	private static int tickMethodOffset = 0;

	/** The font chosen in page 1. */
	private Font font;

	/** The text widget used in page 2. */
	private static StyledText sjCoreViewer;
	protected static String sjCoreData = "";
	
	private static StyledText executionTraceViewer;
	private static StringBuffer inputData = new StringBuffer();
	
	/**
	 * Creates a multi-page editor example.
	 */
	public MultiPageEditor() {
		super();
		ResourcesPlugin.getWorkspace().addResourceChangeListener(this);
		bindToDataPool();
	}
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
	
	
//	/**
//	 * Creates page 1 of the multi-page editor,
//	 * which allows you to change the font used in page 2.
//	 */
//	void createPage1() {
//
//		Composite composite = new Composite(getContainer(), SWT.NONE);
//		GridLayout layout = new GridLayout();
//		composite.setLayout(layout);
//		layout.numColumns = 2;
//
//		Button fontButton = new Button(composite, SWT.NONE);
//		GridData gd = new GridData(GridData.BEGINNING);
//		gd.horizontalSpan = 2;
//		fontButton.setLayoutData(gd);
//		fontButton.setText("Change Font...");
//		
//		fontButton.addSelectionListener(new SelectionAdapter() {
//			public void widgetSelected(SelectionEvent event) {
//				setFont();
//			}
//		});
//
//		int index = addPage(composite);
//		setPageText(index, "Properties");
//	}
	
	
	/**
	 * Creates page 2 of the multi-page editor,
	 * which shows the sorted text.
	 */
	void createSJViewerPage() {
		Composite composite = new Composite(getContainer(), SWT.NONE);
		FillLayout layout = new FillLayout();
		composite.setLayout(layout);
		sjCoreViewer = new StyledText(composite, SWT.H_SCROLL | SWT.V_SCROLL);
		sjCoreViewer.setEditable(false);

		int index = addPage(composite);
		setPageText(index, "SJ Core");
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
//		createPage1();
		createSJViewerPage();
		createExecutionTraceViewerPage();
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
		if (newPageIndex == 1) {
			getSJContent();
		}
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
//	/**
//	 * Sets the font related data to be applied to the text in page 2.
//	 */
//	void setFont() {
//		FontDialog fontDialog = new FontDialog(getSite().getShell());
//		fontDialog.setFontList(sjCoreViewer.getFont().getFontData());
//		FontData fontData = fontDialog.open();
//		if (fontData != null) {
//			if (font != null)
//				font.dispose();
//			font = new Font(sjCoreViewer.getDisplay(), fontData);
//			sjCoreViewer.setFont(font);
//		}
//	}
	
	
	// ################################################################### //
	// ################################################################### //
	
	void getSJContent() {
		String editorText = editor.getDocumentProvider().getDocument(editor.getEditorInput()).get();
		int i = editorText.indexOf("public void tick()");
		int j = editorText.lastIndexOf('}');
		tickMethodOffset = i;
		sjCoreViewer.setText( "    " + editorText.substring(i, j - 1) );   // FIXME: Exception is thrown if file with no tick() is opened.
		Device dev = Display.getCurrent();
		sjCoreViewer.setFont(new Font(dev, "FONT_10_BOLD", 10, SWT.BOLD) );
		sjCoreViewer.setForeground(new Color(dev, 85, 26, 139));
		highlightSJContent();
	}
	
	
	
	
	
	// XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
	// XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
	// XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
	
	static void updateSJCoreViewer() {
		Display.getDefault().syncExec(new Runnable() {
			public void run() {
//				executionTraceViewer.setText(inputData.toString());
				
				// ------------- UNDO-highlight old old labels --------------
				Device dev = sjCoreViewer.getDisplay();
				int oldStart = 0;
				int oldEnd = 0;
				for(int i = 0; i < oldOldInstructionsStartOffsets.size(); i++) {
					oldStart = (int) oldOldInstructionsStartOffsets.get(i);
					oldEnd = (int) oldOldInstructionsEndOffsets.get(i);
					sjCoreViewer.setStyleRange(new StyleRange(oldStart, oldEnd-oldStart+1, new Color(dev, 0, 0, 0), null));
					editor.getViewer().setTextColor(new Color(dev, 0, 0, 0), oldStart+tickMethodOffset-4, oldEnd-oldStart, true);
				}
				// XXX: There is no method clone() for ArrayList<Integer> ???
				//oldOldInstructionsStartOffsets = (ArrayList<Integer>) oldInstructionsStartOffsets.clone();
				//oldOldInstructionsEndOffsets = (ArrayList<Integer>) oldInstructionsEndOffsets.clone();
				oldOldInstructionsStartOffsets.clear();
				oldOldInstructionsEndOffsets.clear();
				for(int i = 0; i < oldInstructionsStartOffsets.size(); i++) {
					oldOldInstructionsStartOffsets.add(oldInstructionsStartOffsets.get(i));
					oldOldInstructionsEndOffsets.add(oldInstructionsEndOffsets.get(i));
				}
				// ----------------------------------------------------------
				
				// ----------------- highlight old labels -------------------
//				Device dev = sjCoreViewer.getDisplay();
//				int oldStart = 0;
//				int oldEnd = 0;
				oldStart = 0;
				oldEnd = 0;
				for(int i = 0; i < oldInstructionsStartOffsets.size(); i++) {
					oldStart = (int) oldInstructionsStartOffsets.get(i);
					oldEnd = (int) oldInstructionsEndOffsets.get(i);
					sjCoreViewer.setStyleRange(new StyleRange(oldStart, oldEnd-oldStart+1, new Color(dev, 255, 140, 0), null));
					editor.getViewer().setTextColor(new Color(dev, 255, 140, 0), oldStart+tickMethodOffset-4, oldEnd-oldStart, true);
				}
				oldInstructionsStartOffsets.clear();
				oldInstructionsEndOffsets.clear();
				// ----------------------------------------------------------
				
				try {
					JSONArray array = new JSONArray(sjCoreData);
					JSONObject instruction = new JSONObject();
					JSONObject instructionData = new JSONObject();
					String key = "";
					for(int i = 2, j = 1; i < array.length()-2; i++, j++) {
						instruction = array.getJSONObject(i);
						Iterator<?> iter = instruction.keys();
						key = (String) iter.next();
						instructionData = instruction.getJSONObject(key);
						key = getProperSJInstruktionName(key); 
						highlightInstruction(key, instructionData, j);
					}
					
				} catch(JSONException e) {
					e.printStackTrace();
				}
				
				
			}
		});
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
		Device dev = sjCoreViewer.getDisplay();
		String text = sjCoreViewer.getText();
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
			sjCoreViewer.setStyleRange(new StyleRange(instrStartOffset, instrEndOffset-instrStartOffset, new Color(dev, 0, 0, 255), null));
			// FIXME: Why the hell do i need the "4" in "instrStartOffset+tickMethodOffset-4" ???
			editor.getViewer().setTextColor(new Color(dev, 255, 0, 0), instrStartOffset+tickMethodOffset-4, instrEndOffset-instrStartOffset, true);
			
			// -------------- fill the old instructions lists ---------------
			oldInstructionsStartOffsets.add( new Integer(instrStartOffset) );
			oldInstructionsEndOffsets.add( new Integer(instrEndOffset) );
			// --------------------------------------------------------------
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	// XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
	// XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
	// XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
	
	
	
	
	
	static void updateExecutionTraceViewer() {
		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				executionTraceViewer.setText(inputData.toString());
			}
		});
	}
	
	
	private void bindToDataPool() {
		buffer.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent e) {
				
				// ---------------------------------------------------------
				sjCoreData = ((StringBuffer) e.getNewValue()).toString(); //
				// ---------------------------------------------------------
				
				inputData = inputData.append("\n").append( (StringBuffer) e.getNewValue() );
				MultiPageEditor.updateExecutionTraceViewer();
				
				// -------------------------------------
				MultiPageEditor.updateSJCoreViewer(); //
				// -------------------------------------
			}
		});
	}
	
	
	private void highlightSJContent() {
		
		// reset labelList
		labelList.clear();
		
		Device dev = sjCoreViewer.getDisplay();
		String text = sjCoreViewer.getText();
		int size = text.length();
		
		for(int i = text.indexOf(" case "), j = text.indexOf(":", i);
		(0 < i && i < size);
		i = text.indexOf(" case ", i+1), j = text.indexOf(":", i)) {
			System.out.println("################>>>>>>>>>>>> i = " + i + ", j = " + j);
			sjCoreViewer.setStyleRange(new StyleRange(i, j-i+1, new Color(dev, 139, 26, 26), null));
			
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
	
}
