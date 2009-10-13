///******************************************************************************
// * KIELER - Kiel Integrated Environment for Layout Eclipse RichClient
// *
// * http://www.informatik.uni-kiel.de/rtsys/kieler/
// * 
// * Copyright 2009 by
// * + Christian-Albrechts-University of Kiel
// *   + Department of Computer Science
// *     + Real-Time and Embedded Systems Group
// * 
// * This code is provided under the terms of the Eclipse Public License (EPL).
// * See the file epl-v10.html for the license text.
// ******************************************************************************/
package de.cau.cs.kieler.dataflow.codegen;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.LogFactory;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.WorkflowContextDefaultImpl;
import org.eclipse.emf.mwe.core.WorkflowRunner;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.issues.IssuesImpl;
import org.eclipse.emf.mwe.core.issues.MWEDiagnostic;
import org.eclipse.emf.mwe.core.monitor.NullProgressMonitor;
import org.eclipse.emf.mwe.internal.core.Workflow;
import org.eclipse.emf.mwe.utils.Reader;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.statushandlers.StatusManager;
import org.eclipse.xpand2.Generator;
import org.eclipse.xpand2.output.Outlet;
import org.eclipse.xtend.typesystem.emf.EmfMetaModel;

import de.cau.cs.kieler.dataflow.DataflowPackage;

public class LustreGenerator extends AbstractHandler implements IHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IEditorPart ed = HandlerUtil.getActiveEditor(event);

		FileEditorInput uri = (FileEditorInput) ed.getEditorInput();
		String model = "file:" + uri.getURI().getRawPath();
		if (model.endsWith("_diagram")) {
			model = model.substring(0, model.length() - 8);
		}
		Map<String, String> properties = new HashMap<String, String>();
		// Map<String, Object> slotContents = new HashMap<String, Object>();

		properties.put("model", model);
		properties.put("src-gen", ".");

		// WorkflowRunner runner = new WorkflowRunner();
		// Workflow
		Workflow workflow = new Workflow();

		// EMF reader
		Reader emfReader = new Reader();
		emfReader.setUri(model);
		emfReader.setModelSlot("model");

		// Meta model
		EmfMetaModel metaModel = new EmfMetaModel(
				de.cau.cs.kieler.dataflow.DataflowPackage.eINSTANCE);

		// Outlet
		Outlet outlet = new Outlet();
		outlet.setPath(".");

		// Generator
		Generator generator = new Generator();
		generator.addMetaModel(metaModel);
		generator.addOutlet(outlet);

		generator.setExpand("template::Lustre::main FOR model");

		WorkflowContext wfx = new WorkflowContextDefaultImpl();
		Issues issues = new org.eclipse.emf.mwe.core.issues.IssuesImpl();
		NullProgressMonitor monitor = new NullProgressMonitor();

		workflow.addComponent(emfReader);
		workflow.addComponent(generator);
		workflow.invoke(wfx, monitor, issues);

		String issue = generator.getLogMessage() + "\n" + issues.getInfos()
				+ issues.getIssues() + issues.getWarnings()
				+ issues.getErrors().toString();
		/*
		 * String generator = "src/lustre.mwe"; boolean success =
		 * runner.prepare(generator, new NullProgressMonitor(), properties);
		 * final Issues issues = new IssuesImpl(); if (success) { success =
		 * runner.executeWorkflow(slotContents, issues); }
		 * 
		 * ;
		 */

		StatusManager.getManager().handle(
				new Status(IStatus.WARNING, Activator.PLUGIN_ID, issue, null),
				StatusManager.LOG);

		return null;
	}
}
