package de.cau.cs.kieler.core.ui.examplewizard.manager;

import java.util.ArrayList;
import java.util.Arrays;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;

import de.cau.cs.kieler.core.ui.examplewizard.datacollector.ExampleOnlineDataRetriever;
import de.cau.cs.kieler.core.ui.examplewizard.util.Example;
import de.cau.cs.kieler.core.ui.examplewizard.util.ExampleFile;

public class ExampleManagerDialog extends Window implements SelectionListener {

	/** Table to choose examples to remove them */
	private CheckboxTableViewer removeTableViewer;
	
	private CheckboxTableViewer updateTableViewer;

	/** Button to trigger remove action */
	private Button removeButton;

	/** Button to close the manager */
	private Button closeButton;

	private Text id, name, version, description, bundleId, bundleVersion, file,
			folder;

	private Button showInEditor;

	private List files;

	private ArrayList<ExampleFile> fileList;

	private Button addExample;

	private Button addFile;

	private Button removeFile;

	private Button browse;
	
	/**
	 * Constructor.
	 * 
	 * @param parentShell
	 */
	public ExampleManagerDialog(Shell parentShell) {
		super(parentShell);
		this.fileList = new ArrayList<ExampleFile>();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jface.window.Window#createContents(org.eclipse.swt.widgets
	 * .Composite)
	 */
	public Control createContents(Composite parent) {
		FormData formData;
		GridData gridData;
		Label label;

		Composite container = new Composite(parent, SWT.NULL);
		container.setLayout(new FillLayout());

		TabFolder tabFolder = new TabFolder(container, SWT.BORDER);

		// Remove
		TabItem removeTab = new TabItem(tabFolder, SWT.NULL);
		removeTab.setText("Remove");
		Composite removeContainer = new Composite(tabFolder, SWT.NULL);
		removeTab.setControl(removeContainer);

		removeContainer.setLayout(new FormLayout());

		this.removeButton = new Button(removeContainer, SWT.PUSH);
		this.removeButton.setText("Remove Selected");
		this.removeButton.addSelectionListener(this);
		formData = new FormData();
		formData.right = new FormAttachment(100, -5);
		formData.bottom = new FormAttachment(100, -5);
		this.removeButton.setLayoutData(formData);

		this.removeTableViewer = CheckboxTableViewer.newCheckList(
				removeContainer, SWT.BORDER);
		this.removeTableViewer.setContentProvider(new ArrayContentProvider());
		this.removeTableViewer.setLabelProvider(new ExampleLabelProvider());

		Table table = this.removeTableViewer.getTable();

		formData = new FormData();
		formData.bottom = new FormAttachment(this.removeButton, -5);
		formData.right = new FormAttachment(100, -5);
		formData.top = new FormAttachment(0, 5);
		formData.left = new FormAttachment(0, 5);
		table.setLayoutData(formData);

		table.setHeaderVisible(true);

		TableColumn column1 = new TableColumn(table, SWT.NONE);
		column1.setWidth(150);
		column1.setText("Example");

		TableColumn column2 = new TableColumn(table, SWT.NONE);
		column2.setWidth(100);
		column2.setText("Version");

		TableColumn column3 = new TableColumn(table, SWT.NONE);
		column3.setWidth(100);
		column3.setText("Plug-In");

		TableColumn column4 = new TableColumn(table, SWT.NONE);
		column4.setWidth(250);
		column4.setText("Description");

		initTableData();

		// Update
		TabItem updateTab = new TabItem(tabFolder, SWT.NULL);
		updateTab.setText("Update");
		Composite updateContainer = new Composite(tabFolder, SWT.NULL);
		updateTab.setControl(updateContainer);
		updateContainer.setLayout(new FillLayout());
		
		this.updateTableViewer = CheckboxTableViewer.newCheckList(updateContainer, SWT.BORDER);
		this.updateTableViewer.setContentProvider(new ArrayContentProvider());
		this.updateTableViewer.setLabelProvider(new ExampleLabelProvider());
		
		Table updateTable = this.updateTableViewer.getTable();

		formData = new FormData();
		formData.bottom = new FormAttachment(this.removeButton, -5);
		formData.right = new FormAttachment(100, -5);
		formData.top = new FormAttachment(0, 5);
		formData.left = new FormAttachment(0, 5);
		table.setLayoutData(formData);

		table.setHeaderVisible(true);

		TableColumn updateColumn1 = new TableColumn(table, SWT.NONE);
		updateColumn1.setWidth(150);
		updateColumn1.setText("Example");

		TableColumn updateColumn2 = new TableColumn(table, SWT.NONE);
		updateColumn2.setWidth(100);
		updateColumn2.setText("Version");

		TableColumn updateColumn3 = new TableColumn(table, SWT.NONE);
		updateColumn3.setWidth(100);
		updateColumn3.setText("Plug-In");

		TableColumn column4 = new TableColumn(table, SWT.NONE);
		column4.setWidth(250);
		column4.setText("Description");

		initTableData();

		// Add
		TabItem addTab = new TabItem(tabFolder, SWT.NULL);
		addTab.setText("Add");
		Composite addContainer = new Composite(tabFolder, SWT.NULL);
		addTab.setControl(addContainer);
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 6;
		addContainer.setLayout(gridLayout);

		// row1
		label = new Label(addContainer, SWT.LEFT);
		label.setText("Example ID:");
		this.id = new Text(addContainer, SWT.SINGLE | SWT.BORDER);
		label = new Label(addContainer, SWT.LEFT);
		label.setText("");
		label = new Label(addContainer, SWT.LEFT);
		label.setText("Files");
		label = new Label(addContainer, SWT.LEFT);
		label.setText("");
		label = new Label(addContainer, SWT.LEFT);
		label.setText("");
		gridData = new GridData();
		gridData.horizontalAlignment = GridData.FILL;
		gridData.grabExcessHorizontalSpace = true;
		id.setLayoutData(gridData);

		// row2
		label = new Label(addContainer, SWT.LEFT);
		label.setText("Example Name:");
		this.name = new Text(addContainer, SWT.SINGLE | SWT.BORDER);
		label = new Label(addContainer, SWT.LEFT);
		label.setText("");
		label = new Label(addContainer, SWT.LEFT);
		label.setText("File");
		this.file = new Text(addContainer, SWT.SINGLE | SWT.BORDER);
		this.browse = new Button(addContainer, SWT.PUSH);
		this.browse.addSelectionListener(this);
		this.browse.setText("Browse");
		this.browse.setSize(53, 23);
		this.browse.setAlignment(SWT.CENTER);
		gridData = new GridData();
		gridData.horizontalAlignment = GridData.FILL;
		gridData.grabExcessHorizontalSpace = true;
		this.name.setLayoutData(gridData);
		this.file.setLayoutData(gridData);

		// row3
		label = new Label(addContainer, SWT.LEFT);
		label.setText("Example Version:");
		this.version = new Text(addContainer, SWT.SINGLE | SWT.BORDER);
		label = new Label(addContainer, SWT.LEFT);
		label.setText("");
		label = new Label(addContainer, SWT.LEFT);
		label.setText("Folder");
		this.folder = new Text(addContainer, SWT.SINGLE | SWT.BORDER);
		label = new Label(addContainer, SWT.LEFT);
		label.setText("");
		gridData = new GridData();
		gridData.horizontalAlignment = GridData.FILL;
		gridData.grabExcessHorizontalSpace = true;
		this.version.setLayoutData(gridData);
		this.folder.setLayoutData(gridData);

		// row4
		label = new Label(addContainer, SWT.LEFT);
		label.setText("Description:");
		this.description = new Text(addContainer, SWT.SINGLE | SWT.BORDER);
		label = new Label(addContainer, SWT.LEFT);
		label.setText("");
		label = new Label(addContainer, SWT.LEFT);
		label.setText("Show Editor:");
		this.showInEditor = new Button(addContainer, SWT.CHECK | SWT.LEFT);
		label = new Label(addContainer, SWT.LEFT);
		label.setText("");
		gridData = new GridData();
		gridData.horizontalAlignment = GridData.FILL;
		gridData.grabExcessHorizontalSpace = true;
		this.description.setLayoutData(gridData);

		// row5
		label = new Label(addContainer, SWT.LEFT);
		label.setText("Plugin ID:");
		this.bundleId = new Text(addContainer, SWT.SINGLE | SWT.BORDER);
		label = new Label(addContainer, SWT.LEFT);
		label.setText("");
		label = new Label(addContainer, SWT.LEFT);
		label.setText("");
		label = new Label(addContainer, SWT.LEFT);
		label.setText("");
		this.addFile = new Button(addContainer, SWT.LEFT | SWT.PUSH | SWT.FILL);
		this.addFile.setText("Add");
		this.addFile.setSize(53, 23);
		this.addFile.setAlignment(SWT.CENTER);
		this.addFile.addSelectionListener(this);
		gridData = new GridData();
		gridData.horizontalAlignment = GridData.FILL;
		gridData.grabExcessHorizontalSpace = true;
		this.bundleId.setLayoutData(gridData);

		// row6
		label = new Label(addContainer, SWT.LEFT);
		label.setText("Plugin Version:");
		this.bundleVersion = new Text(addContainer, SWT.SINGLE | SWT.BORDER
				| SWT.TOP);
		label = new Label(addContainer, SWT.LEFT);
		label.setText("");
		label = new Label(addContainer, SWT.LEFT);
		label.setText("");
		this.files = new List(addContainer, SWT.SINGLE | SWT.BORDER);
		this.removeFile = new Button(addContainer, SWT.LEFT | SWT.TOP
				| SWT.PUSH);
		this.removeFile.setText("Remove");
		this.bundleVersion.setLayoutData(gridData);
		this.removeFile.setSize(53, 23);
		this.removeFile.setAlignment(SWT.CENTER);
		this.removeFile.addSelectionListener(this);
		gridData = new GridData();
		gridData.horizontalAlignment = GridData.FILL;
		gridData.grabExcessHorizontalSpace = true;
		gridData.heightHint = 100;
		this.files.setLayoutData(gridData);

		// row7
		label = new Label(addContainer, SWT.LEFT);
		label.setText("");
		label = new Label(addContainer, SWT.LEFT);
		label.setText("");
		label = new Label(addContainer, SWT.LEFT);
		label.setText("");
		label = new Label(addContainer, SWT.LEFT);
		label.setText("");
		label = new Label(addContainer, SWT.LEFT);
		label.setText("");
		this.addExample = new Button(addContainer, SWT.PUSH | SWT.RIGHT);
		this.addExample.setText("Add Example");
		this.addExample.setAlignment(SWT.CENTER);
		return container;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.swt.events.SelectionListener#widgetDefaultSelected(org.eclipse
	 * .swt.events.SelectionEvent)
	 */
	public void widgetDefaultSelected(SelectionEvent e) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.swt.events.SelectionListener#widgetSelected(org.eclipse.swt
	 * .events.SelectionEvent)
	 */
	public void widgetSelected(SelectionEvent e) {
		Object source = e.getSource();
		if (source.equals(this.removeButton)) {
			Object[] examples = this.removeTableViewer.getCheckedElements();
			if (examples.length > 0) {
				ExampleOnlineDataRetriever.INSTANCE.remove(examples);
				this.removeTableViewer.remove(examples);
			}
		}
		if (source.equals(this.addFile)) {
			if (!file.getText().equals("")) {
				ExampleFile file = new ExampleFile(this.file.getText(),
						this.showInEditor.getSelection(), this.folder.getText());
				this.fileList.add(file);
				this.files.add(file.getFile());
				this.file.setText("");
				this.folder.setText("");
				this.showInEditor.setSelection(false);
			}
		}
		if (source.equals(this.removeFile)) {
			if (this.files.getSelectionCount() > 0) {
				int[] selection = this.files.getSelectionIndices();
				Arrays.sort(selection);
				for (int i = selection.length - 1; i >= 0; i--) {
					this.files.remove(i);
					this.fileList.remove(i);
				}
			}
		}
		if (source.equals(this.addExample)) {
			String id = this.id.getText();
			String name = this.name.getText();
			String version = this.version.getText();
			String bundleId = this.bundleId.getText();
			String bundleVersion = this.bundleVersion.getText();
			if (!id.equals("") && !name.equals("") && !version.equals("")
					&& !bundleId.equals("") && !bundleVersion.equals("")) {
				Example example = new Example(id, name, version, id + "_"
						+ version, bundleId, bundleVersion, this.description
						.getText(), "", this.fileList, null);
				ExampleOnlineDataRetriever.INSTANCE.add(example);
				// Reseting the input mask
				this.id.setText("");
				this.name.setText("");
				this.version.setText("");
				this.description.setText("");
				this.bundleId.setText("");
				this.bundleVersion.setText("");
				this.file.setText("");
				this.folder.setText("");
				this.showInEditor.setSelection(false);
				this.fileList.clear();
				this.files.removeAll();
			}
		}
		if (source.equals(this.browse)) {
			FileDialog dialog = new FileDialog(getShell(), SWT.OPEN);
			dialog.setText("Choose File");
			dialog.open();
			this.file.setText(dialog.getFileName());
		}
	}

	/**
	 * Initiate the table data
	 */
	private void initTableData() {
		ArrayList<Example> examples = new ArrayList<Example>();
		examples.addAll(ExampleOnlineDataRetriever.INSTANCE.getExamples());
		this.removeTableViewer.setInput(examples.toArray());
	}

}
