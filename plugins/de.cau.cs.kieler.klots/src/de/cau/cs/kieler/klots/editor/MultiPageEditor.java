package de.cau.cs.kieler.klots.editor;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
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

	InputDataPool buffer = InputDataPool.getInstance();
		
	// Java editor
	private CompilationUnitEditor editor;

	/** The font chosen in page 1. */
	private Font font;

	/** The text widget used in page 2. */
	private StyledText sjCoreViewer;
	
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
	
	/**
	 * Creates page 1 of the multi-page editor,
	 * which allows you to change the font used in page 2.
	 */
	void createPage1() {

		Composite composite = new Composite(getContainer(), SWT.NONE);
		GridLayout layout = new GridLayout();
		composite.setLayout(layout);
		layout.numColumns = 2;

		Button fontButton = new Button(composite, SWT.NONE);
		GridData gd = new GridData(GridData.BEGINNING);
		gd.horizontalSpan = 2;
		fontButton.setLayoutData(gd);
		fontButton.setText("Change Font...");
		
		fontButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				setFont();
			}
		});

		int index = addPage(composite);
		setPageText(index, "Properties");
	}
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
	/**
	 * Sets the font related data to be applied to the text in page 2.
	 */
	void setFont() {
		FontDialog fontDialog = new FontDialog(getSite().getShell());
		fontDialog.setFontList(sjCoreViewer.getFont().getFontData());
		FontData fontData = fontDialog.open();
		if (fontData != null) {
			if (font != null)
				font.dispose();
			font = new Font(sjCoreViewer.getDisplay(), fontData);
			sjCoreViewer.setFont(font);
		}
	}
	
	
	// ################################################################### //
	// ################################################################### //
	
	void getSJContent() {

		String editorText =
			editor.getDocumentProvider().getDocument(editor.getEditorInput()).get();
		
		int i = editorText.indexOf("public void tick()");
		int j = editorText.lastIndexOf('}');
		
		sjCoreViewer.setText( "    " + editorText.substring(i, j - 1) );   // FIXME: Exception is thrown if file with no tick() is opened.
		Device dev = Display.getCurrent();
		sjCoreViewer.setFont(new Font(dev, "FONT_10_BOLD", 10, SWT.BOLD) );
		sjCoreViewer.setForeground(new Color(dev, 85, 26, 139));
		
		highlightSJContent();
	}
	
	
	static void updateExecutionTraceViewer() {
//		System.out.println(">>> updateExecutionTraceViewer()");
		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				executionTraceViewer.setText(inputData.toString());
			}
		});
	}
	
	private void bindToDataPool() {
//		DataBindingContext bindingContext = new DataBindingContext();
//		IObservableValue editorValue = WidgetProperties.text(SWT.Modify)
//				.observe(buffer);
//		IObservableValue poolValue = BeanProperties.value(InputDataPool.class,
//				"buffer").observe(buffer);
//		bindingContext.bindValue(editorValue, poolValue);
		
		buffer.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent e) {
//				newData = (StringBuffer) e.getNewValue();
				inputData = inputData.append("\n").append( (StringBuffer) e.getNewValue() );
				MultiPageEditor.updateExecutionTraceViewer();
			}
		});
	}
	
	
	private void highlightSJContent() {
		
		Device dev = Display.getCurrent();
		String text = sjCoreViewer.getText();
		int size = text.length();
		
		for(int i = text.indexOf(" case "), j = text.indexOf("\n", i);
		(0 < i && i < size);
		i = text.indexOf("case", i+1), j = text.indexOf("\n", i)) {
			sjCoreViewer.setStyleRange(new StyleRange(i, j-i, new Color(dev, 139, 26, 26), null));
//			System.out.println("SETTING COLOR AT OFFSET: " + i);
		}
	}
	
}
