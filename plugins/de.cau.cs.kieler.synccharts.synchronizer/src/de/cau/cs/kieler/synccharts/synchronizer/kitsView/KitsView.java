/*
 * KIELER - Kiel Integrated Environment for Layout Eclipse RichClient
 *
 * http://www.informatik.uni-kiel.de/rtsys/kieler/
 * 
 * Copyright 2010 by
 * + Christian-Albrechts-University of Kiel
 *   + Department of Computer Science
 *     + Real-Time and Embedded Systems Group
 * 
 * This code is provided under the terms of the Eclipse Public License (EPL).
 * See the file epl-v10.html for the license text.
 */
package de.cau.cs.kieler.synccharts.synchronizer.kitsView;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.IJobChangeEvent;
import org.eclipse.core.runtime.jobs.JobChangeAdapter;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parsetree.reconstr.XtextSerializationException;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.IXtextModelListener;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import com.google.inject.Injector;

import de.cau.cs.kieler.synccharts.Region;
import de.cau.cs.kieler.synccharts.State;
import de.cau.cs.kieler.synccharts.SyncchartsPackage;
import de.cau.cs.kieler.synccharts.diagram.part.SyncchartsDiagramEditor;
import de.cau.cs.kieler.synccharts.synchronizer.Activator;
import de.cau.cs.kieler.synccharts.synchronizer.KitsSynchronizeLinker;
import de.cau.cs.kieler.synccharts.text.kits.KitsResource;
import de.cau.cs.kieler.synccharts.text.kits.scoping.KitsEmbeddedScopeProvider;
import de.cau.cs.kieler.synccharts.text.ui.KitsUIPlugin;

/**
 * View providing textual view on parts of SyncCharts models.
 * The view serves as a SelectionListener to retrieve the
 * graphical editors' models.
 * 
 * @author chsch
 */
public class KitsView extends ViewPart implements ISelectionListener {

	private EmbeddedXtextEditor editor;
	
	private SyncchartsDiagramEditor passiveEditor;
	
	private Region rootRegionCopy;
	
	private State container;
	
	private int index;
	
	private JobChangeAdapter doneListener;
	
	private SyncChartSynchronizerJob synchronizer;
	
	@Override
	public void createPartControl(Composite parent) {
		parent.setLayout(new GridLayout());
		parent.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		
		Injector injector = KitsUIPlugin.getInstance().getInjector(KitsUIPlugin.KITS_LANGUAGE_EMBEDDED);

		editor = new EmbeddedXtextEditor(parent, injector);

		editor.getDocument().addModelListener(new IXtextModelListener() {
			public void modelChanged(XtextResource resource) {
				if (!documentHasErrors(editor.getDocument())) {
					reconcileChangedModel();
				} else {
					System.out.println("Errors");
				}
			}
		});

		((ISelectionService) getSite().getService(ISelectionService.class))
				.addSelectionListener(this);
				
		doneListener = new JobChangeAdapter() {
			
			@Override
			public void done(IJobChangeEvent event) {
				container.getRegions().remove(index);
			}			
		};
		
		synchronizer = new SyncChartSynchronizerJob("SyncChartsSynchronizer");
		synchronizer.addJobChangeListener(doneListener);
		
	}
	
	
	public void selectionChanged(IWorkbenchPart part, ISelection selection) {

		EObject model = null;
		
		StructuredSelection sSelection = null;
		if (part instanceof SyncchartsDiagramEditor
				&& selection instanceof StructuredSelection) {
			passiveEditor = (SyncchartsDiagramEditor) part;
			sSelection = (StructuredSelection) selection;
			
			if (sSelection.size() != 0
					&& sSelection.getFirstElement() instanceof EditPart) {
				EditPart ePart = (EditPart) sSelection.getFirstElement();
				
				if (ePart.getModel() instanceof View) {
					model = ((View) ePart.getModel()).getElement();
				}
			}
		}
		
		if (model == null) {
			return;
		}
		
		while (!SyncchartsPackage.eINSTANCE.getRegion().isInstance(model)) {
			model = model.eContainer();
		}
		
		final Region region = (Region) model;
		final Region rootRegion = (Region) EcoreUtil.getRootContainer(region);
		
		try {
			editor.getDocumentEditor().process(
					new IUnitOfWork.Void<XtextResource>() {

						@Override
						public void process(XtextResource state)
								throws Exception {
							rootRegionCopy = EcoreUtil.copy(rootRegion);
							Region copy = null;

							KitsResource resource = (KitsResource) editor.createResource();
							resource.getContents().clear();
							resource.getContents().add(rootRegionCopy);

							try {
								copy = new KitsSynchronizeLinker()
										.consultSrcAndCopy(rootRegion, rootRegionCopy)
										.linkElement(rootRegionCopy)
										.getMatched(region);
							} catch (ClassCastException e) {
								System.out.println("Problem");
								return;
							}
							
							container = (State) copy.eContainer();
							KitsEmbeddedScopeProvider.logicalContainer = container;
							index = 0;
							if (container != null) {
								index = container.getRegions().indexOf(copy);
							}
							
							state.getContents().clear();
							state.getContents().add(copy);
						}

					}, editor.getDocument());
			
			synchronizer.cancel();
			
			
		} catch (XtextSerializationException e) {
			Activator
					.getDefault()
					.getLog()
					.log(new Status(IStatus.ERROR, Activator.PLUGIN_ID,
							1, "Serialization of textual view failed", e));
		}
	}
	
		
	private void reconcileChangedModel() {		
		editor.getDocument().readOnly(new IUnitOfWork.Void<XtextResource>() {
			@Override
			public void process(XtextResource state) throws Exception {
				synchronizer.cancel();
				
				Region copy = EcoreUtil.copy((Region) state.getContents().get(0));
				container.getRegions().add(index, copy);
				synchronizer.setLeftRegion(rootRegionCopy);
				synchronizer.setPassiveEditor(passiveEditor);
				synchronizer.schedule(1000L);
				
			}
		});
	}
	
	
	/**
	 * Copied from @{link org.eclipselabs.xtfo.demo.rcp.editor.detailspage.Domain DomainModelDetailsPage}.
	 * (and simplified)
	 * 
	 * @param xtextDocument
	 * @return true if the document could not be parsed and linked correctly, false otherwise
	 */
	private boolean documentHasErrors(final IXtextDocument xtextDocument) {
		return (xtextDocument.readOnly(new IUnitOfWork<Boolean, XtextResource>() {
			public Boolean exec(XtextResource state) throws Exception {
				IParseResult parseResult = state.getParseResult();
						return !state.getErrors().isEmpty()
								|| parseResult == null
								|| !parseResult.getParseErrors().isEmpty();
			}
		}));
	}


	public void dispose() {		
		((ISelectionService) getSite().getService(ISelectionService.class))
				.removeSelectionListener(this);
		editor.dispose();
		super.dispose();
	}

	
	@Override
	public void setFocus() {
		
	}

}
