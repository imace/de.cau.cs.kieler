package de.cau.cs.kieler.core.ui.examplewizard.manager;

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

import de.cau.cs.kieler.core.ui.examplewizard.datacollector.ExampleOnlineDataRetriever;
import de.cau.cs.kieler.core.ui.examplewizard.util.Example;

public class ExampleManagementPage extends WizardPage {

	private CheckboxTableViewer checkBoxTableViewer;
	
	public ExampleManagementPage() {
		super("Management Page");
		setTitle("Example Management");
		setDescription("A Description.");
	}
	
	@Override
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);
		container.setLayout(new FormLayout());
		setControl(container);
		
		checkBoxTableViewer = CheckboxTableViewer.newCheckList(container, SWT.BORDER);
		checkBoxTableViewer.setContentProvider(new ArrayContentProvider());
		checkBoxTableViewer.setLabelProvider(null); // TODO LabelProvider!!
		Table table = checkBoxTableViewer.getTable();
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
		column3.setWidth(100);
		column3.setText("PlugIn");
		
		TableColumn column4 = new TableColumn(table, SWT.NONE);
		column4.setWidth(250);
		column4.setText("Description");
		
	}
	
	public void setVisible(boolean visible) {
		if(visible) {
			List<Example> examples = new ArrayList<Example>();
			examples.addAll(ExampleOnlineDataRetriever.INSTANCE.getExamples());
			checkBoxTableViewer.setInput(examples);
		}
		super.setVisible(visible);
	}


}
