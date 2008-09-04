package edu.unikiel.rtsys.kieler.kivik.viewer;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.compare.CompareConfiguration;
import org.eclipse.compare.CompareUI;
import org.eclipse.core.resources.IFile;
import org.eclipse.emf.compare.diff.metamodel.AbstractDiffExtension;
import org.eclipse.emf.compare.diff.metamodel.DiffElement;
import org.eclipse.emf.compare.diff.metamodel.ModelInputSnapshot;
import org.eclipse.emf.compare.ui.util.EMFCompareConstants;
import org.eclipse.emf.compare.util.AdapterUtils;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

import edu.unikiel.rtsys.kieler.kivik.Constants;
import edu.unikiel.rtsys.kieler.kivik.internal.KivikComparator;

/**
 * Compare and show diffs as a structured tree.
 * 
 * @author <a href="mailto:ars@informatik.uni-kiel.de">Arne Schipper</a>
 */
public class TreeStructureMergeViewer extends TreeViewer {
	/** Configuration element of the underlying comparison. */
	protected CompareConfiguration configuration;

	
	/**
	 * Creates a new model structure merge viewer and initializes it.
	 * 
	 * @param parent
	 *            Parent composite for this viewer.
	 * @param compareConfiguration
	 *            The configuration object.
	 */
	public TreeStructureMergeViewer(Composite parent, CompareConfiguration compareConfiguration) {
		super(parent);
		initialize(compareConfiguration);
	}

	/**
	 * Returns the compare configuration of this viewer, or <code>null</code> if this viewer does not yet
	 * have a configuration.
	 * 
	 * @return the compare configuration, or <code>null</code> if none
	 */
	public CompareConfiguration getCompareConfiguration() {
		return configuration;
	}

	/**
	 * Returns the viewer's title.
	 * 
	 * @return The viewer's title.
	 */
	public String getTitle() {
		return Constants.PLUGIN_NAME + ": Domain model differences"; //$NON-NLS-1$
	}

	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.viewers.ContentViewer#handleDispose(org.eclipse.swt.events.DisposeEvent)
	 */
	@Override
	protected void handleDispose(DisposeEvent event) {
		super.handleDispose(event);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.viewers.AbstractTreeViewer#inputChanged(java.lang.Object, java.lang.Object)
	 */
	@Override
	protected void inputChanged(Object input, Object oldInput) {
		final TreePath[] expandedPaths = getExpandedTreePaths();
		
		super.inputChanged(input, oldInput);
		if (!(input instanceof ModelInputSnapshot) && input != oldInput) {
			setInput(KivikComparator.getComparator(configuration).getComparisonResult());
		}
		
		setExpandedTreePaths(expandedPaths);
	}

	
	/**
	 * initializer of this structure merge viewer. It sets the {@link LabelProvider label} and content
	 * provider for the tree and creates the different needed listeners.
	 * 
	 * @param compareConfiguration
	 *            Configuration of the underlying comparison.
	 */
	private void initialize(CompareConfiguration compareConfiguration) {
		configuration = compareConfiguration;
		setLabelProvider(new TreeLabelProvider());
		setUseHashlookup(true);
		setContentProvider(new StructureMergeContentProvider(compareConfiguration));

		final Tree tree = getTree();
		tree.setData(CompareUI.COMPARE_VIEWER_TITLE, getTitle());
		tree.addSelectionListener(new SelectionListener() {
			public void widgetDefaultSelected(SelectionEvent e) {
				// Nothing to do here
			}

			public void widgetSelected(SelectionEvent e) {
				final List<DiffElement> selectedElements = new ArrayList<DiffElement>(getTree()
						.getSelection().length);
				for (TreeItem item : getTree().getSelection())
					if (item.getData() instanceof DiffElement)
						selectedElements.add((DiffElement)item.getData());
				configuration.setProperty(EMFCompareConstants.PROPERTY_STRUCTURE_SELECTION, selectedElements);
			}
		});

	}

	
	/**
	 * {@link LabelProvider} of this viewer.
	 * 
	 * @author <a href="mailto:ars@informatik.uni-kiel.de">Arne Schipper</a>
	 */
	private class TreeLabelProvider extends LabelProvider {
		/**
		 * We use this generic label provider, but we want to customize some aspects that's why we choose to
		 * aggregate it.
		 */
		/* package */AdapterFactoryLabelProvider adapterProvider;

		/**
		 * Default constructor.
		 */
		public TreeLabelProvider() {
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
