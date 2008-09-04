package edu.unikiel.rtsys.kieler.kivik.viewer;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.compare.CompareConfiguration;
import org.eclipse.compare.CompareUI;
import org.eclipse.core.resources.IFile;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.emf.compare.diff.metamodel.AbstractDiffExtension;
import org.eclipse.emf.compare.diff.metamodel.ModelInputSnapshot;
import org.eclipse.emf.compare.ui.util.EMFCompareConstants;
import org.eclipse.emf.compare.util.AdapterUtils;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.gef.DefaultEditDomain;
import org.eclipse.gmf.runtime.diagram.core.DiagramEditingDomainFactory;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramRootEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramGraphicalViewer;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.EditPartService;
import org.eclipse.gmf.runtime.diagram.ui.services.layout.LayoutService;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

import edu.unikiel.rtsys.kieler.kivik.Constants;
import edu.unikiel.rtsys.kieler.kivik.internal.KivikComparator;
import edu.unikiel.rtsys.layouter.LayoutType;

public class DiagramStructureMergeViewer extends StructuredViewer {

	Composite parent;
	CompareConfiguration compareConfiguration;
	DiagramGraphicalViewer viewer;
	private ISelectionChangedListener selectionChangedListener;

	public DiagramStructureMergeViewer(Composite parent, CompareConfiguration config) {
		super();
		compareConfiguration = config;
		this.parent = parent;
		viewer = new DiagramGraphicalViewer();
		viewer.createControl(parent);
		viewer.getControl().setBackground(ColorConstants.listBackground);
		viewer.setEditDomain(new DefaultEditDomain(null));
		viewer.setEditPartFactory(EditPartService.getInstance());
		selectionChangedListener= new ISelectionChangedListener(){

			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				System.out.println("DSMV: selectionChanged:  " + event);
				compareConfiguration.setProperty(EMFCompareConstants.PROPERTY_STRUCTURE_SELECTION, event);
			}
			
		};
		viewer.addSelectionChangedListener(selectionChangedListener); 
		setUseHashlookup(true);
		setContentProvider(new StructureMergeContentProvider(compareConfiguration));
		setLabelProvider(new DiagramLabelProvider());
	}
	
	/**
	 * Returns the viewer's title.
	 * 
	 * @return The viewer's title.
	 */
	public String getTitle() {
		System.out.println("DSMV: getTitle()");
		return Constants.PLUGIN_NAME + ": Domain model differences"; //$NON-NLS-1$
	}
	
	protected void inputChanged(Object input, Object oldInput) {
		System.out.println("DSMV: inputChanged():  " + input.getClass());
		super.inputChanged(input, oldInput);
		if (!(input instanceof ModelInputSnapshot) && input != oldInput) {
			System.out.println("DSMV: not instanceof ModelInputSnapshot");
			setInput(KivikComparator.getComparator(compareConfiguration).getComparisonResult());
		}else{
			Diagram diagram = KivikComparator.getComparator(compareConfiguration).getMergedViewModel();
			System.out.println("DSMV: diagram:  " + diagram);
			DiagramEditingDomainFactory.getInstance().createEditingDomain(
					diagram.eResource().getResourceSet());
			viewer.setRootEditPart(new DiagramRootEditPart(diagram
					.getMeasurementUnit()));
			LayoutService.getInstance().layout(diagram, LayoutType.GRAPHVIZ_DOT);
			viewer.setContents(diagram);
		}
		
	}
	
	@Override
	protected Widget doFindInputItem(Object element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Widget doFindItem(Object element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void doUpdateItem(Widget item, Object element, boolean fullMap) {
		// TODO Auto-generated method stub

	}

	@Override
	protected List getSelectionFromWidget() {
		// TODO Auto-generated method stub
		return new ArrayList();
	}

	@Override
	protected void internalRefresh(Object element) {
		// TODO Auto-generated method stub

	}

	@Override
	public void reveal(Object element) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void setSelectionToWidget(List l, boolean reveal) {
		// TODO Auto-generated method stub

	}

	@Override
	public Control getControl() {
		System.out.println("DSMV: 5");
		return viewer.getControl();
	}

	/**
	 * {@link LabelProvider} of this viewer.
	 * 
	 * @author <a href="mailto:ars@informatik.uni-kiel.de">Arne Schipper</a>
	 */
	private class DiagramLabelProvider extends LabelProvider {
		/**
		 * We use this generic label provider, but we want to customize some aspects that's why we choose to
		 * aggregate it.
		 */
		/* package */AdapterFactoryLabelProvider adapterProvider;

		/**
		 * Default constructor.
		 */
		public DiagramLabelProvider() {
			adapterProvider = new AdapterFactoryLabelProvider(AdapterUtils.getAdapterFactory());

		}

		/**
		 * Returns the platform icon for a given {@link IFile}. If not an {@link IFile}, delegates to the
		 * {@link AdapterFactoryLabelProvider} to get the {@link Image}.
		 * 
		 * @param object
		 *            Object to get the {@link Image} for.
		 * @return The platform icon for the given object.
		 * @see AdapterFactoryLabelProvider#getImage(Object)
		 */
		@Override
		public Image getImage(Object object) {
			Image image = null;
			if (object instanceof AbstractDiffExtension) {
				image = (Image)((AbstractDiffExtension)object).getImage();
			}
			if (object instanceof IFile) {
				image = PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJ_FILE);
			} else {
				if (image == null) {
					image = adapterProvider.getImage(object);
				}
			}
			return image;
		}

		/**
		 * Returns the name of the given {@link IFile}, delegates to
		 * {@link AdapterFactoryLabelProvider#getText(Object)} if not an {@link IFile}.
		 * 
		 * @param object
		 *            Object we seek the name for.
		 * @return The name of the given object.
		 * @see AdapterFactoryLabelProvider#getText(Object)
		 */
		@Override
		public String getText(Object object) {
			String text = null;
			if (object instanceof AbstractDiffExtension) {
				text = ((AbstractDiffExtension)object).getText();
			} else {
				if (object instanceof IFile) {
					text = ((IFile)object).getName();
				} else {
					text = adapterProvider.getText(object);
				}
			}
			return text;
		}
	}
}
