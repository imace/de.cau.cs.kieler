package de.cau.cs.kieler.core.ui.examplewizard.wizard;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.List;

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
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.osgi.framework.Bundle;
import org.osgi.framework.Version;

import de.cau.cs.kieler.core.ui.examplewizard.datacollector.ExampleExtensionPointDataRetriever;
import de.cau.cs.kieler.core.ui.examplewizard.datacollector.ExampleOnlineDataRetriever;
import de.cau.cs.kieler.core.ui.examplewizard.util.Example;

/**
 * The class generates the wizard page. The user needs to enter a new project
 * name and choose an example.
 * 
 * @author omi
 */
public class ExampleNewWizardPage extends WizardPage {
	/** Name of the new project */
	private Text projectName;

	/** List of examples added via extension point */
	private List<Example> installedExamples;

	/** List of online examples */
	private List<Example> onlineExamples;

	/** GUI List of examples */
	private org.eclipse.swt.widgets.List examplesList;

	/** List of bundles */
	private List<Bundle> bundles;

	/**
	 * Constructor for SampleNewWizardPage.
	 * 
	 * @param pageName
	 */
	public ExampleNewWizardPage() {
		super("wizardPage");
		setTitle("Example Wizard");
		setDescription("This wizard creates a new project with the choosen example.");
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
		Label label = new Label(container, SWT.NULL);
		label.setText("&Project:");

		projectName = new Text(container, SWT.BORDER | SWT.SINGLE);
		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		projectName.setLayoutData(gd);
		projectName.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				dialogChanged();
			}
		});

		label = new Label(container, SWT.TOP);
		label.setText("&Examples:");

		examplesList = new org.eclipse.swt.widgets.List(container, SWT.BORDER
				| SWT.CENTER);
		gd = new GridData(GridData.FILL_BOTH);
		examplesList.setLayoutData(gd);
		examplesList.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent e) {
				dialogChanged();
			}

			public void widgetDefaultSelected(SelectionEvent e) {
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
		installedExamples = ExampleExtensionPointDataRetriever.INSTANCE
				.getExamples();
		onlineExamples = ExampleOnlineDataRetriever.INSTANCE.getExamples();
		
		bundles = new ArrayList<Bundle>();

		// plugins with examples
		for (Example example : installedExamples) {
			String id = example.getPluginId();
			Version version = example.getPluginVersion();
			Bundle bundle = Platform.getBundle(id);
			if (bundle != null) {
				Version bundleVersion = bundle.getVersion();
				if (version != null && version.compareTo(bundleVersion) >= 0) {
					if (!bundles.contains(bundle)) {
						bundles.add(bundle);
					}
				}
			}

		}

		for (Example example : installedExamples) {
			examplesList.add(example.getName() + " - "
					+ example.getDescription());
		}
	}

	/**
	 * Ensures that text fields is set and one example is chosen.
	 */

	private void dialogChanged() {
		// IResource container = ResourcesPlugin.getWorkspace().getRoot()
		// .findMember(new Path(getProjectName()));

		if (getProjectName().length() == 0) {
			updateStatus("Project must be specified");
			return;
		}
		if (examplesList.getSelectionCount() == 0) {
			updateStatus("Select an example");
			return;
		}
		if (examplesList.getSelectionCount() > 1) {
			updateStatus("Select just one example");
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

	private void updateStatus(String message) {
		setErrorMessage(message);
		setPageComplete(message == null);
	}

	public String getProjectName() {
		return projectName.getText();
	}

	public String getSelectedExampleID() {
		String id = "";
		if (examplesList.getSelectionCount() == 1) {
			id = installedExamples.get(examplesList.getSelectionIndex())
					.getId();
		}
		return id;
	}
}