package de.cau.cs.kieler.core.ui.examplewizard.wizard;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

import de.cau.cs.kieler.core.ui.examplewizard.datacollector.ExampleExtensionPointDataRetriever;
import de.cau.cs.kieler.core.ui.examplewizard.datacollector.ExampleOnlineDataRetriever;
import de.cau.cs.kieler.core.ui.examplewizard.util.Example;

/**
 * This wizard page shows the examples associated with the chosen bundles in a table.
 * @author omi
 *
 */
public class ExampleChooserPage extends WizardPage {

	/** The table */
	private CheckboxTableViewer checkboxTableViewer;
	
	/**
	 * Constructor.
	 */
	public ExampleChooserPage() {
		super("wizardPage");
		setTitle("Example Wizard");
		setDescription("A description.");
	}
	
	/**
	 * @see org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets.Composite)
	 */
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);
		container.setLayout(new FormLayout());
		setControl(container);
		
		checkboxTableViewer = CheckboxTableViewer.newCheckList(container, SWT.BORDER);
		checkboxTableViewer.setContentProvider(new ArrayContentProvider());
		checkboxTableViewer.setLabelProvider(new ExtractedExampleLabelProvider());
		Table table = checkboxTableViewer.getTable();
		FormData formData = new FormData();
		formData.bottom = new FormAttachment(100, 0);
		formData.right = new FormAttachment(100, 0);
		formData.top = new FormAttachment(0, 0);
		formData.left = new FormAttachment(0, 0);
		table.setLayoutData(formData);
		table.setHeaderVisible(true);

		TableColumn column1 = new TableColumn(table, SWT.NONE);
		column1.setWidth(150);
		column1.setText("Example");

		TableColumn column2 = new TableColumn(table, SWT.NONE);
		column2.setWidth(100);
		column2.setText("Version");

		TableColumn column3 = new TableColumn(table, SWT.NONE);
		column3.setWidth(250);
		column3.setText("Description");
	}
	
	/**
	 * @see org.eclipse.jface.dialogs.DialogPage#setVisible(boolean)
	 */
	public void setVisible(boolean visible) {
		if(visible) {
			BundleChooserPage bundleChooser = (BundleChooserPage)getPreviousPage();
			String[] bundleIds = bundleChooser.getSelectedBundles();
			List<Example> examples = new ArrayList<Example>();
			for(String id : bundleIds) {
				if(bundleChooser.showOnlineExamples()) {
					examples.addAll(ExampleOnlineDataRetriever.INSTANCE.getExamplesByPluginId(id));
				}
				if(bundleChooser.showOfflineExamples()) {
					examples.addAll(ExampleExtensionPointDataRetriever.INSTANCE.getExamplesByPluginId(id));
				}
			}
			checkboxTableViewer.setInput(examples);
		}
		super.setVisible(visible);
	}
	
	/**
	 * Returns a list of selected examples.
	 * @return
	 */
	public List<Example> getSelectedExamples() {
		List<Example> examples = new ArrayList<Example>();
		Object[] objects = this.checkboxTableViewer.getCheckedElements();
		for(Object object : objects) {
			examples.add((Example)object);
		}
		return examples;
	}

}
