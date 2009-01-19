package de.cau.cs.kieler.dataflow.ui.wizards;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.ContainerSelectionDialog;

/**
 * The "New" wizard page allows setting the container for the new file as well
 * as the file name. The page will only accept file name without the extension
 * OR with the extension that matches the expected one (dataflow).
 */

public class CreateRandomModelWizardPage extends WizardPage {
	private Text containerText;

	private Text fileText;
	
	private Text nodeText;
	private Text connectionText;
	private Text hierarchyText;

	private int nodeDefault = 10;
	private int connectionDefault = 2;
	private float hierarchyDefault = 0.1f;
	
	private int nodes = nodeDefault;
	private int connections = connectionDefault;
	private float hierarchyProb = hierarchyDefault;
	
	private ISelection selection;

	

	/**
	 * Constructor for SampleNewWizardPage.
	 * 
	 * @param pageName
	 */
	public CreateRandomModelWizardPage(ISelection selection) {
		super("createRandomModelWizard");
		setTitle("Create Random Model");
		setDescription("This wizard creates a new EMF model of given size with some initial content. It might be used for benchmarking or other things.");
		this.selection = selection;
	}

	/**
	 * @see IDialogPage#createControl(Composite)
	 */
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);
		GridLayout layout = new GridLayout();
		container.setLayout(layout);
		layout.numColumns = 3;
		layout.verticalSpacing = 9;
		Label label = new Label(container, SWT.NULL);
		label.setText("&Container:");

		containerText = new Text(container, SWT.BORDER | SWT.SINGLE);
		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		containerText.setLayoutData(gd);
		containerText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				dialogChanged();
			}
		});

		Button button = new Button(container, SWT.PUSH);
		button.setText("Browse...");
		button.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				handleBrowse();
			}
		});
		label = new Label(container, SWT.NULL);
		label.setText("&File name:");

		fileText = new Text(container, SWT.BORDER | SWT.SINGLE);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		fileText.setLayoutData(gd);
		fileText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				dialogChanged();
			}
		});
		
		// Specify amount of Nodes
		label = new Label(container, SWT.NULL); // empty label to fill grid
		label = new Label(container, SWT.NULL);
		label.setText("&Amount of Nodes:");
		
		nodeText = new Text(container, SWT.BORDER | SWT.SINGLE);
		nodeText.setText(""+nodeDefault);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		nodeText.setLayoutData(gd);
		nodeText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				dialogChanged();
			}
		});
		
		// Specify amount of Connections
		label = new Label(container, SWT.NULL); // empty label to fill grid
		label = new Label(container, SWT.NULL);
		label.setText("&Amount of outgoing Connections per node:");
		
		connectionText = new Text(container, SWT.BORDER | SWT.SINGLE);
		connectionText.setText(""+connectionDefault);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		connectionText.setLayoutData(gd);
		connectionText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				dialogChanged();
			}
		});
		
		// Specify probability of hierarchy level introduction
		label = new Label(container, SWT.NULL); // empty label to fill grid
		label = new Label(container, SWT.NULL);
		label.setText("&Probability of introducing new hierarchy levels:");

		hierarchyText = new Text(container, SWT.BORDER | SWT.SINGLE);
		hierarchyText.setText(""+hierarchyDefault);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		hierarchyText.setLayoutData(gd);
		hierarchyText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				dialogChanged();
			}
		});
		
		initialize();
		dialogChanged();
		setControl(container);
	}

	/**
	 * Tests if the current workbench selection is a suitable container to use.
	 */

	private void initialize() {
		if (selection != null && selection.isEmpty() == false
				&& selection instanceof IStructuredSelection) {
			IStructuredSelection ssel = (IStructuredSelection) selection;
			if (ssel.size() > 1)
				return;
			Object obj = ssel.getFirstElement();
			if (obj instanceof IResource) {
				IContainer container;
				if (obj instanceof IContainer)
					container = (IContainer) obj;
				else
					container = ((IResource) obj).getParent();
				containerText.setText(container.getFullPath().toString());
			}
		}
		fileText.setText("random.dataflow");
	}

	/**
	 * Uses the standard container selection dialog to choose the new value for
	 * the container field.
	 */

	private void handleBrowse() {
		ContainerSelectionDialog dialog = new ContainerSelectionDialog(
				getShell(), ResourcesPlugin.getWorkspace().getRoot(), false,
				"Select new file container");
		if (dialog.open() == ContainerSelectionDialog.OK) {
			Object[] result = dialog.getResult();
			if (result.length == 1) {
				containerText.setText(((Path) result[0]).toString());
			}
		}
	}

	/**
	 * Ensures that both text fields are set.
	 */

	private void dialogChanged() {
		IResource container = ResourcesPlugin.getWorkspace().getRoot()
				.findMember(new Path(getContainerName()));
		String fileName = getFileName();

		if (getContainerName().length() == 0) {
			updateStatus("File container must be specified");
			return;
		}
		if (container == null
				|| (container.getType() & (IResource.PROJECT | IResource.FOLDER)) == 0) {
			updateStatus("File container must exist");
			return;
		}
		if (!container.isAccessible()) {
			updateStatus("Project must be writable");
			return;
		}
		if (fileName.length() == 0) {
			updateStatus("File name must be specified");
			return;
		}
		if (fileName.replace('\\', '/').indexOf('/', 1) > 0) {
			updateStatus("File name must be valid");
			return;
		}
		int dotLoc = fileName.lastIndexOf('.');
		if (dotLoc != -1) {
			String ext = fileName.substring(dotLoc + 1);
			if (ext.equalsIgnoreCase("dataflow") == false) {
				updateStatus("File extension must be \"dataflow\"");
				return;
			}
		}
		try{
			nodes = Integer.parseInt(nodeText.getText());
		}
		catch( NumberFormatException exc ){
			updateStatus("Amount of Nodes must be an integer number!");
			return;
		}
		try{
		    connections = Integer.parseInt(connectionText.getText());
		}
		catch( NumberFormatException exc ){
			updateStatus("Amount of Connections must be an integer number!");
			return;
		}
		try{
		    float temp = Float.parseFloat(hierarchyText.getText());
			if(temp >= 0 && temp <= 1)
				hierarchyProb = temp;
			else throw new NumberFormatException("must be within 0 and 1");
		}
		catch( NumberFormatException exc ){
			updateStatus("Hierarchy Probability must be a float number in the range from 0.0 to 1.0");
			return;
		}
		
		updateStatus(null);
	}

	private void updateStatus(String message) {
		setErrorMessage(message);
		setPageComplete(message == null);
	}

	public String getContainerName() {
		return containerText.getText();
	}

	public String getFileName() {
		return fileText.getText();
	}
	
	public int getNodes(){
		return nodes;
	}
	public int getConnections(){
		return connections;
	}

	public float getHierarchyProb() {
		return hierarchyProb;
	}
}