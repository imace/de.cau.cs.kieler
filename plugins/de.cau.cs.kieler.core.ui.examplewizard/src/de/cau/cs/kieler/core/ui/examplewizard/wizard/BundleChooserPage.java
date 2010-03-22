package de.cau.cs.kieler.core.ui.examplewizard.wizard;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.dialogs.IDialogPage;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.osgi.framework.Bundle;

import de.cau.cs.kieler.core.ui.examplewizard.datacollector.ExampleExtensionPointDataRetriever;
import de.cau.cs.kieler.core.ui.examplewizard.datacollector.ExampleOnlineDataRetriever;

/**
 * The class generates the wizard page. The user needs to enter a new project
 * name and choose an example.
 * 
 * @author omi
 */
public class BundleChooserPage extends WizardPage implements SelectionListener, ModifyListener {
	/** Name of the new project */
	private Text projectField;

	/** CheckBox to switch on/off online examples */
	private Button showOnlineExamples;
	
	/** CheckBox to switch on/off offline examples */
	private Button showOfflineExamples;
	
	/** GUI List of examples */
	private org.eclipse.swt.widgets.List bundleList;

	/** Map<Bundle-Name, Bundle-id> for the examplesList */
	private Map<String, String> bundleMap;

	/**
	 * Constructor for SampleNewWizardPage.
	 * 
	 * @param pageName
	 */
	public BundleChooserPage() {
		super("wizardPage");
		setTitle("Example Wizard");
		setDescription("This wizard creates a new project with the choosen example.");
		this.bundleMap = new HashMap<String, String>();
	}

	/**
	 * @see IDialogPage#createControl(Composite)
	 */
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);
		GridLayout layout = new GridLayout();
		container.setLayout(layout);

		layout.numColumns = 2;
		layout.verticalSpacing = 9;

		Label projectLabel = new Label(container, SWT.NULL);
		projectLabel.setText("&Project:");
		
		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		this.projectField = new Text(container, SWT.BORDER | SWT.SINGLE);
		this.projectField.setLayoutData(gd);
		this.projectField.addModifyListener(this);

		gd = new GridData(GridData.VERTICAL_ALIGN_BEGINNING);
		Label exampleLabel = new Label(container, SWT.NULL);
		exampleLabel.setLayoutData(gd);
		exampleLabel.setText("&Bundles:");

		gd = new GridData(GridData.FILL_BOTH);
		this.bundleList = new org.eclipse.swt.widgets.List(container, SWT.BORDER	| SWT.CENTER);
		this.bundleList.setLayoutData(gd);
		this.bundleList.addSelectionListener(this);

		gd = new GridData(GridData.BEGINNING);
		this.showOfflineExamples = new Button(container, SWT.CHECK);
		this.showOfflineExamples.setText("Show offline examples");
		this.showOfflineExamples.setSelection(false);
		this.showOfflineExamples.setLayoutData(gd);
		this.showOfflineExamples.addSelectionListener(this);
		
		Label emptyLabel = new Label(container, SWT.NULL);
		emptyLabel.setText("");
		
		this.showOnlineExamples = new Button(container, SWT.CHECK);
		this.showOnlineExamples.setText("Show online examples");
		this.showOnlineExamples.setLayoutData(gd);
		this.showOnlineExamples.setSelection(true);
		this.showOnlineExamples.addSelectionListener(this);
		
		initialize();
		dialogChanged();
		setControl(container);
	}

	/**
	 * Initialize the components.
	 */
	private void initialize() {
		initializeList();
	} 

	/**
	 * Initializing the examples List, by adding the needed bundle names and IDs.
	 */
	@SuppressWarnings("unchecked")
	private void initializeList() {
		List<String> bundleIds = new ArrayList<String>();
		// get all bundle ids.
		if(this.showOnlineExamples.getSelection()) {
			bundleIds.addAll(ExampleOnlineDataRetriever.INSTANCE.getPluginIds());
		}
		if(this.showOfflineExamples.getSelection()) {
			List<String> offlineBundleIds = ExampleExtensionPointDataRetriever.INSTANCE.getPluginIds();
			for(String offlineBundleId : offlineBundleIds) {
				if(!bundleIds.contains(offlineBundleId)) {
					bundleIds.add(offlineBundleId);
				}
			}
		}
		this.bundleMap.clear();
		this.bundleList.removeAll();
		for(String bundleId : bundleIds) {
			Bundle bundle = Platform.getBundle(bundleId);
			Dictionary<String, String> headers = bundle.getHeaders();
			String name = headers.get("Bundle-Name");
			this.bundleList.add(name);
			this.bundleMap.put(name, bundleId);
		}
	}
	
	/**
	 * Ensures that text field is set and the bundle is chosen.
	 */
	private void dialogChanged() {
		// IResource container = ResourcesPlugin.getWorkspace().getRoot()
		// .findMember(new Path(getProjectName()));

		if (getProjectName().length() == 0) {
			updateStatus("Project must be specified");
			return;
		}
		if (bundleList.getSelectionCount() == 0) {
			updateStatus("Select a bundle");
			return;
		}
		if (bundleList.getSelectionCount() > 1) {
			updateStatus("Select just one bundle");
			return;
		}
		// if (container == null
		// || (container.getType() & (IResource.PROJECT | IResource.FOLDER)) ==
		// 0) {
		// updateStatus("File container must exist");
		// return;
		// }
		updateStatus(null);
	}

	/**
	 * Updating status message.
	 * @param message
	 */
	private void updateStatus(String message) {
		setErrorMessage(message);
		setPageComplete(message == null);
	}

	/**
	 * Returning the entered project name.
	 * @return
	 */
	public String getProjectName() {
		return projectField.getText();
	}

	/**
	 * This method returns the IDs of the selected bundles.
	 * @return
	 */
	public String[] getSelectedBundles() {
		int selectionSize = this.bundleList.getSelectionCount();
		String[] bundleIds = new String[selectionSize];
		String[] bundleNames = this.bundleList.getSelection();
		for(int i = 0; i < selectionSize; i++) {
			bundleIds[i] = this.bundleMap.get(bundleNames[i]);
		}
		return bundleIds;
	}

	/**
	 * Returns the value for the online example check box. 
	 * @return
	 */
	public boolean showOnlineExamples() {
		return this.showOnlineExamples.getSelection();
	}

	/**
	 * Returns the value for the example check box for the offline examples. 
	 * @return
	 */
	public boolean showOfflineExamples() {
		return this.showOfflineExamples.getSelection();
	}

	
	/**
	 * @see org.eclipse.swt.events.SelectionListener#widgetDefaultSelected(org.eclipse.swt.events.SelectionEvent)
	 */
	public void widgetDefaultSelected(SelectionEvent e) {
		// not needed.	
	}

	/**
	 * @see org.eclipse.swt.events.SelectionListener#widgetSelected(org.eclipse.swt.events.SelectionEvent)
	 */
	public void widgetSelected(SelectionEvent e) {
		if(e.widget.equals(this.showOfflineExamples)) {
			// TODO
		}
		if(e.widget.equals(this.showOnlineExamples)) {
			initializeList();
		}
		if(e.widget.equals(this.bundleList)) {
			dialogChanged();
		}
	}

	/**
	 * @see org.eclipse.swt.events.ModifyListener#modifyText(org.eclipse.swt.events.ModifyEvent)
	 */
	public void modifyText(ModifyEvent e) {
		if(e.widget.equals(this.projectField)) {
			dialogChanged();
		}
	}
}