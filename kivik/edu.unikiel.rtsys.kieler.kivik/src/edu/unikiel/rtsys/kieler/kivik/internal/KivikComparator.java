package edu.unikiel.rtsys.kieler.kivik.internal;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.eclipse.compare.CompareConfiguration;
import org.eclipse.compare.IStreamContentAccessor;
import org.eclipse.compare.ITypedElement;
import org.eclipse.compare.ResourceNode;
import org.eclipse.compare.structuremergeviewer.ICompareInput;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.compare.EMFComparePlugin;
import org.eclipse.emf.compare.diff.metamodel.DiffFactory;
import org.eclipse.emf.compare.diff.metamodel.DiffModel;
import org.eclipse.emf.compare.diff.metamodel.ModelInputSnapshot;
import org.eclipse.emf.compare.diff.service.DiffService;
import org.eclipse.emf.compare.match.api.MatchOptions;
import org.eclipse.emf.compare.match.metamodel.MatchFactory;
import org.eclipse.emf.compare.match.metamodel.MatchModel;
import org.eclipse.emf.compare.match.service.MatchService;
import org.eclipse.emf.compare.ui.EMFCompareUIMessages;
import org.eclipse.emf.compare.ui.internal.AbstractTeamHandler;
import org.eclipse.emf.compare.ui.util.EMFCompareConstants;
import org.eclipse.emf.compare.util.EMFCompareMap;
import org.eclipse.emf.compare.util.EclipseModelUtils;
import org.eclipse.emf.compare.util.ModelUtils;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.EcoreFactoryImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;
import org.eclipse.gmf.runtime.diagram.ui.view.factories.DiagramViewFactory;
import org.eclipse.gmf.runtime.emf.core.resources.GMFResource;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.ui.PlatformUI;

import edu.unikiel.rtsys.kieler.kiml.ui.layouter.KimlGMFLayouter;
import edu.unikiel.rtsys.kieler.kivik.Constants;

/**
 * 
 * @author <a href="mailto:ars@informatik.uni-kiel.de">Arne Schipper</a>
 */
public final class KivikComparator {
	/** Keeps track of the team handlers declared for the extension point. */
	private static final Set<TeamHandlerDescriptor> CACHED_HANDLERS = new HashSet<TeamHandlerDescriptor>();

	/**
	 * This will contain instances of comparators associated to given
	 * CompareConfiguration.
	 */
	private static final Map<CompareConfiguration, KivikComparator> INSTANCES = new HashMap<CompareConfiguration, KivikComparator>();

	/** Name of the extension point to parse for team handlers. */
	private static final String TEAM_HANDLERS_EXTENSION_POINT = "org.eclipse.emf.compare.ui.internal.team.handler"; //$NON-NLS-1$

	/** This will hold the result of these resources' comparison. */
	protected ModelInputSnapshot comparisonResult;

	/** Resource of the ancestor model used in this comparison. */
	private Resource ancestorResource;

	/** This will keep track of the handler used by this comparison. */
	private AbstractTeamHandler comparisonHandler;

	/**
	 * Indicates that the left compared model is remote and shouldn't be
	 * modified.
	 */
	private boolean leftIsRemote;

	/** Resource of the left model used in this comparison. */
	private Resource leftResource;

	/**
	 * Indicates that the right compared model is remote and shouldn't be
	 * modified. This will only happen if we couldn't load a local resource when
	 * comparing with repository.
	 */
	private boolean rightIsRemote;

	private KimlGMFLayouter gmfLayouter = new KimlGMFLayouter();
	
	/** Resource of the right model used in this comparison. */
	private Resource rightResource;
	
	static {
		parseExtensionMetaData();
	}

	/**
	 * Model comparators will only be instantiated via
	 * {@link #getComparator(CompareConfiguration)}.
	 */
	private KivikComparator() {
		// prevents external instantiation
	}

	/**
	 * This will return the KivikComparator associated to the given
	 * CompareConfiguration.
	 * 
	 * @param configuration
	 *            CompareConfiguration of this comparator.
	 * @return The comparator for this configuration.
	 */
	public static KivikComparator getComparator(
			CompareConfiguration configuration) {
		if (!INSTANCES.containsKey(configuration))
			INSTANCES.put(configuration, new KivikComparator());
		return INSTANCES.get(configuration);
	}

	/**
	 * Removes the comparator corresponding to a no longer used configuration.
	 * 
	 * @param configuration
	 *            CompareConfiguration which comparator should be removed.
	 */
	public static void removeComparator(CompareConfiguration configuration) {
		INSTANCES.remove(configuration);
	}

	/**
	 * This will parse {@link #TEAM_HANDLERS_EXTENSION_POINT} for team handlers.
	 */
	private static void parseExtensionMetaData() {
		final IExtension[] extensions = Platform.getExtensionRegistry()
				.getExtensionPoint(TEAM_HANDLERS_EXTENSION_POINT)
				.getExtensions();
		for (IExtension extension : extensions) {
			for (IConfigurationElement configElement : extension
					.getConfigurationElements()) {
				final TeamHandlerDescriptor descriptor = new TeamHandlerDescriptor(
						configElement);
				CACHED_HANDLERS.add(descriptor);
			}
		}
	}

	public ModelInputSnapshot compare(CompareConfiguration configuration) {
		return compare(configuration, Constants.RESOURCE);
	}

	public ModelInputSnapshot compareBusinessModel(
			CompareConfiguration configuration) {
		return compare(configuration, Constants.BUSINESS_MODEL);
	}

	public ModelInputSnapshot compareViewModel(
			CompareConfiguration configuration) {
		return compare(configuration, Constants.VIEW_MODEL);
	}

	/**
	 * This will run the comparison process and return the resulting
	 * {@link ModelInputSnapshot snapshot}.
	 * 
	 * @param configuration
	 *            Compared configuration of this comparison. Properties will be
	 *            set on this to hold comparison data.
	 * @return Result of the comparison of the loaded resources.
	 */
	public ModelInputSnapshot compare(CompareConfiguration configuration,
			final int typeOfComparison) {
		if (comparisonResult == null) {
			comparisonResult = DiffFactory.eINSTANCE.createModelInputSnapshot();
			final Date start = Calendar.getInstance().getTime();

			try {
				PlatformUI.getWorkbench().getProgressService().busyCursorWhile(
						new IRunnableWithProgress() {
							public void run(IProgressMonitor monitor)
									throws InterruptedException {
								final Map<String, Object> options = new EMFCompareMap<String, Object>();
								options.put(
										MatchOptions.OPTION_PROGRESS_MONITOR,
										monitor);
								final MatchModel match;

								if (typeOfComparison == Constants.VIEW_MODEL) {
									if (getAncestorResource() == null)
										match = MatchService.doMatch(
												getLeftViewModel(),
												getRightViewModel(), options);
									else
										match = MatchService
												.doMatch(getLeftViewModel(),
														getRightViewModel(),
														getAncestorViewModel(),
														options);
								} else if (typeOfComparison == Constants.BUSINESS_MODEL) {
									if (getAncestorResource() == null)
										match = MatchService.doMatch(
												getLeftBusinessModel(),
												getRightBusinessModel(),
												options);
									else
										match = MatchService.doMatch(
												getLeftBusinessModel(),
												getRightBusinessModel(),
												getAncestorBusinessModel(),
												options);
								} else {
									if (getAncestorResource() == null)
										match = MatchService.doResourceMatch(
												getLeftResource(),
												getRightResource(), options);
									else
										match = MatchService.doResourceMatch(
												getLeftResource(),
												getRightResource(),
												getAncestorResource(), options);
								}
								final DiffModel diff = DiffService.doDiff(
										match, getAncestorResource() != null);
								
								comparisonResult.setDate(Calendar.getInstance()
										.getTime());
								comparisonResult.setDiff(diff);
								comparisonResult.setMatch(match);
							}
						});
			} catch (InterruptedException e) {
				comparisonResult.setDate(Calendar.getInstance().getTime());
				comparisonResult.setDiff(DiffFactory.eINSTANCE
						.createDiffModel());
				comparisonResult.setMatch(MatchFactory.eINSTANCE
						.createMatchModel());
			} catch (InvocationTargetException e) {
				EMFComparePlugin.log(e, true);
			}

			final Date end = Calendar.getInstance().getTime();
			configuration.setProperty(
					EMFCompareConstants.PROPERTY_COMPARISON_TIME, end.getTime()
							- start.getTime());
			configuration.setLeftEditable(!isLeftRemote());
			configuration.setRightEditable(!isRightRemote());
			if (isLeftRemote()) {
				configuration.setLeftLabel(EMFCompareUIMessages
						.getString("comparison.label.remoteResource")); //$NON-NLS-1$
				configuration.setRightLabel(EMFCompareUIMessages
						.getString("comparison.label.localResource")); //$NON-NLS-1$
			}
		}
		return comparisonResult;
	}

	/**
	 * Returns the compared resources ancestor.
	 * 
	 * @return The compared resources ancestor.
	 */
	public Resource getAncestorResource() {
		if (comparisonHandler != null) {
			System.out
					.println("KivikComparator: Ancestor used comparisonHandler");
			return comparisonHandler.getAncestorResource();
		}
		return ancestorResource;
	}

	/**
	 * This will return the comparison result.
	 * 
	 * @return The comparison result. <code>null</code> if no comparison has
	 *         been done since last loading resources.
	 */
	public ModelInputSnapshot getComparisonResult() {
		return comparisonResult;
	}

	/**
	 * Returns the left compared resource.
	 * 
	 * @return The left compared resource.
	 */
	public Resource getLeftResource() {
		if (comparisonHandler != null) {
			System.out.println("KivikComparator: Left used comparisonHandler");
			return comparisonHandler.getLeftResource();
		}
		System.out.println(leftResource.getURI());
		return leftResource;
	}

	/**
	 * Returns the right compared resource.
	 * 
	 * @return The right compared resource.
	 */
	public Resource getRightResource() {
		if (comparisonHandler != null) {
			System.out.println("KivikComparator: Right used comparisonHandler");
			return comparisonHandler.getRightResource();
		}
		return rightResource;
	}

	/**
	 * Returns the Ancestor business model.
	 * 
	 * @return The Ancestor business model.
	 */
	public EObject getAncestorBusinessModel() {
		if (getAncestorResource() != null) {
			if (getAncestorResource().getContents().get(0) instanceof Diagram) {
				return ((Diagram) getAncestorResource().getContents().get(0))
						.getElement();
			} else {
				return getAncestorResource().getContents().get(0);
			}
		} else
			return EcoreFactoryImpl.eINSTANCE.createEObject();
	}

	/**
	 * Returns the left business model.
	 * 
	 * @return The left business model.
	 */
	public EObject getLeftBusinessModel() {
		if (getLeftResource().getContents().get(0) instanceof Diagram) {
			System.out
					.println("KivikComparator: LeftBusinessModel from diagram model");
			if (((Diagram) getLeftResource().getContents().get(0)).getElement() != null) {
				System.out
						.println("KivikComparator: LeftBusinessModel NOT NULL: "
								+ ((Diagram) getLeftResource().getContents()
										.get(0)).getElement());
				return ((Diagram) getLeftResource().getContents().get(0))
						.getElement();
			} else {
				//((Diagram) getLeftResource().getContents().get(0)).
				return EcoreFactoryImpl.eINSTANCE.createEObject();
			}

		} else {
			System.out.println("KivikComparator: LeftBusinessModel DIRECT");
			return getLeftResource().getContents().get(0);
		}
	}

	/**
	 * Returns the right business model.
	 * 
	 * @return The right business model.
	 */
	public EObject getRightBusinessModel() {
		if (getRightResource().getContents().get(0) instanceof Diagram) {
			System.out
					.println("KivikComparator: RightBusinessModel from diagram model");
			if (((Diagram) getRightResource().getContents().get(0))
					.getElement() != null) {
				System.out
						.println("KivikComparator: RightBusinessModel NOT NULL: "
								+ ((Diagram) getRightResource().getContents()
										.get(0)).getElement());
				return ((Diagram) getRightResource().getContents().get(0))
						.getElement();
			} else {
				return EcoreFactoryImpl.eINSTANCE.createEObject();
			}

		} else {
			System.out.println("KivikComparator: RightBusinessModel DIRECT");
			return getRightResource().getContents().get(0);
		}
	}

	/**
	 * Returns the Ancestor View model.
	 * 
	 * @return The Ancestor View model.
	 */
	public Diagram getAncestorViewModel() {
		if (getAncestorResource() != null) {
			if (getAncestorResource().getContents().get(0) instanceof Diagram) {
				return (Diagram) getAncestorResource().getContents().get(0);
			} else {
				System.out.println("KivikComparator: AncViewModel is null");
				return null;
			}
		} else
			return null;
	}

	/**
	 * Returns the left View model.
	 * 
	 * @return The left View model.
	 */
	public Diagram getLeftViewModel() {
		if (getLeftResource().getContents().get(0) instanceof Diagram) {
			System.out.println("KivikComparator: LeftViewModel NOT null");
			Diagram left_diag = (Diagram) getLeftResource().getContents().get(0);
			System.out.println("ääääääääääääääää" + left_diag.getChildren().get(0));
			gmfLayouter.setRoot(getLeftBusinessModel());
			gmfLayouter.layout();
			return (Diagram) getLeftResource().getContents().get(0);
		} else {
			System.out.println("KivikComparator: LeftViewModel is null");
			DiagramViewFactory dvf = new DiagramViewFactory();
			return null;
		}
	}

	/**
	 * Returns the right View model.
	 * 
	 * @return The right View model.
	 */
	public Diagram getRightViewModel() {
		if (getRightResource().getContents().get(0) instanceof Diagram) {
			System.out.println("KivikComparator: RightViewModel NOT null");
			return (Diagram) getRightResource().getContents().get(0);
		} else {
			System.out.println("KivikComparator: RightViewModel is null");
			return null;
		}
	}

	/**
	 * Returns the merged View model.
	 * 
	 * @return The right merged model.
	 */
	public Diagram getMergedViewModel() {
		if (getRightResource().getContents().get(0) instanceof Diagram) {
			System.out.println("KivikComparator: MergedViewModel NOT null");
			
			// make copies of left semantic an notation model
//			Copier semanticCopier = new Copier();
//			Copier notationCopier = new Copier();
//			EObject rightSemanticStaticModel = semanticCopier.copy(getRightBusinessModel());
//			semanticCopier.copyReferences();
//			Diagram rightNotationStaticModel = (Diagram)notationCopier.copy(getRightViewModel());
//			notationCopier.copyReferences();
//			// add copies to the resourceset
//			GMFResource res = new GMFResource(URI.createGenericURI("null", "null", ""));
//			res.getContents().add(rightNotationStaticModel);
//			res.getContents().add(rightSemanticStaticModel);
//			getRightViewModel().eResource().getResourceSet().getResources().add(res);
//			rightNotationStaticModel.setElement(rightSemanticStaticModel);
			//return rightNotationStaticModel;
			return (Diagram)getLeftResource().getContents().get(0);
		} else {
			System.out.println("KivikComparator: MergedViewModel is null");
			return null;
		}
	}
	
	/**
	 * Indicates that the left resource is remote and shouldn't be modified.
	 * 
	 * @return <code>true</code> if the left compared resource is remote,
	 *         <code>false</code> otherwise.
	 */
	public boolean isLeftRemote() {
		// if (comparisonHandler != null)
		// return comparisonHandler.isLeftRemote();
		return leftIsRemote;
	}

	/**
	 * Indicates that the right resource is remote and shouldn't be modified.
	 * Note that this will never return <code>true</code> unless we failed to
	 * load a local resource for comparison.
	 * 
	 * @return <code>true</code> if the right compared resource is remote,
	 *         <code>false</code> otherwise.
	 */
	public boolean isRightRemote() {
		// if (comparisonHandler != null)
		// return comparisonHandler.isRightRemote();
		return rightIsRemote;
	}

	/**
	 * This will load the resources held by <code>input</code>.
	 * 
	 * @param input
	 *            CompareInput which holds the resources to be loaded.
	 * @return <code>true</code> if the given models have been successfully
	 *         loaded, <code>false</code> otherwise.
	 */
	public boolean loadResources(ICompareInput input) {
		clear();
		final ITypedElement left = input.getLeft();
		final ITypedElement right = input.getRight();
		final ITypedElement ancestor = input.getAncestor();

		try {
			// This will be sufficient when comparing local resources
			boolean result = handleLocalResources(left, right, ancestor);
			// If resources weren't local, iterates through the registry to find
			// a proper team handler
			if (!result) {
				final Iterator<TeamHandlerDescriptor> handlerDescriptorIterator = CACHED_HANDLERS
						.iterator();
				while (handlerDescriptorIterator.hasNext()) {
					final AbstractTeamHandler handler = handlerDescriptorIterator
							.next().getHandlerInstance();
					result |= handler.loadResources(input);
					if (result) {
						comparisonHandler = handler;
						break;
					}
				}
			}
			// We didn't found a proper handler, use a generic one
			if (!result)
				result |= handleGenericResources(left, right, ancestor);
			return result;
		} catch (IOException e) {
			EMFComparePlugin.log(e, true);
		} catch (CoreException e) {
			EMFComparePlugin.log(e.getStatus());
		}
		return false;
	}

	/**
	 * Clears all loaded resources from the resource set.
	 */
	private void clear() {
		clearResourceSet(leftResource, rightResource, ancestorResource);
		leftResource = null;
		rightResource = null;
		ancestorResource = null;
		comparisonResult = null;
		comparisonHandler = null;
	}

	/**
	 * This will empty the resourceSet of the given <tt>resource</tt>.
	 * 
	 * @param resource
	 *            Resource that is to be cleared.
	 */
	private void clearResourceSet(Resource... resource) {
		for (int i = 0; i < resource.length; i++) {
			if (resource[i] == null)
				continue;
			final ResourceSet resourceSet = resource[i].getResourceSet();
			final Iterator<Resource> resourcesIterator = resourceSet
					.getResources().iterator();
			while (resourcesIterator.hasNext()) {
				resourcesIterator.next().unload();
			}
			resourceSet.getResources().clear();
		}
	}

	/**
	 * This generic handler should be able to load resources passed by any team
	 * plug-in. Using this handler instead of
	 * {@link #handleSubversiveResources(ITypedElement, ITypedElement, ITypedElement)}
	 * for comparison via subversive will result in unsaveable merge operations.
	 * 
	 * @param left
	 *            Handler of the left compared model.
	 * @param right
	 *            Handler of the right compared model.
	 * @param ancestor
	 *            Handler of these two models' common ancestor.
	 * @return <code>true</code> If all resources have been loaded by this
	 *         handler, <code>false</code> otherwise.
	 * @throws IOException
	 *             Thrown if the right resource cannot be loaded.
	 * @throws CoreException
	 *             Thrown if exceptions occur when loading the remote resources
	 *             (left and ancestor).
	 */
	private boolean handleGenericResources(ITypedElement left,
			ITypedElement right, ITypedElement ancestor) throws IOException,
			CoreException {
		if (left instanceof ResourceNode
				&& right instanceof IStreamContentAccessor) {
			if (((ResourceNode) left).getResource().isAccessible()) {
				rightResource = EclipseModelUtils.load(
						((ResourceNode) left).getResource().getFullPath(),
						new ResourceSetImpl()).eResource();
				
			} else {
				rightResource = ModelUtils
						.createResource(URI.createPlatformResourceURI(
								((ResourceNode) left).getResource()
										.getFullPath().toOSString(), true));
				// resource has been deleted. We set it as "remote" to disable
				// merge facilities
				rightIsRemote = true;
			}
			try {
				leftResource = ModelUtils.load(
						((IStreamContentAccessor) right).getContents(),
						right.getName(), new ResourceSetImpl()).eResource();
			} catch (IOException e) {
				// We couldn't load the remote resource. Considers it has been
				// added to the repository
				leftResource = ModelUtils.createResource(URI.createURI(right
						.getName()));
				// Set the right as remote to disable merge facilities
				rightIsRemote = true;
			}
			leftIsRemote = true;
			if (ancestor != null) {
				try {
					ancestorResource = ModelUtils.load(
							((IStreamContentAccessor) ancestor).getContents(),
							ancestor.getName(), new ResourceSetImpl())
							.eResource();
				} catch (IOException e) {
					// Couldn't load ancestor resource, create an empty one
					ancestorResource = ModelUtils.createResource(URI
							.createURI(ancestor.getName()));
				}
			}
			return true;
		}
		/*
		 * Weshould never be here. There always is a local resource when
		 * comparing with CVS. this code will be executed if we couldn't manage
		 * to handle thislocal resource as such. Though the resourcewill be
		 * loaded thanks to this generic handler, note that it will not be
		 * saveable.
		 */
		boolean result = false;
		if (left instanceof IStreamContentAccessor
				&& right instanceof IStreamContentAccessor) {
			rightResource = ModelUtils.load(
					((IStreamContentAccessor) left).getContents(),
					left.getName(), new ResourceSetImpl()).eResource();
			leftResource = ModelUtils.load(
					((IStreamContentAccessor) right).getContents(),
					right.getName(), new ResourceSetImpl()).eResource();
			rightIsRemote = true;
			leftIsRemote = true;
			if (ancestor != null)
				ancestorResource = ModelUtils.load(
						((IStreamContentAccessor) ancestor).getContents(),
						ancestor.getName(), new ResourceSetImpl()).eResource();
			result = true;
		}
		return result;
	}

	/**
	 * This will try and load the given element as being local resources.
	 * 
	 * @param left
	 *            Handler of the left compared model.
	 * @param right
	 *            Handler of the right compared model.
	 * @param ancestor
	 *            Handler of these two models' common ancestor.
	 * @return <code>true</code> If all resources have been loaded by this
	 *         handler, <code>false</code> otherwise.
	 * @throws IOException
	 *             Thrown if resources cannot be loaded.
	 */
	private boolean handleLocalResources(ITypedElement left,
			ITypedElement right, ITypedElement ancestor) throws IOException {
		if (left instanceof ResourceNode && right instanceof ResourceNode) {
			leftResource = EclipseModelUtils.load(
					((ResourceNode) left).getResource().getFullPath(),
					new ResourceSetImpl()).eResource();
			rightResource = EclipseModelUtils.load(
					((ResourceNode) right).getResource().getFullPath(),
					new ResourceSetImpl()).eResource();
			if (ancestor != null)
				ancestorResource = EclipseModelUtils.load(
						((ResourceNode) ancestor).getResource().getFullPath(),
						new ResourceSetImpl()).eResource();
			return true;
		}
		return false;
	}

	/**
	 * Describes a team handler registered from a plug-in's extension point.
	 * 
	 * @author <a href="mailto:laurent.goubet@obeo.fr">Laurent Goubet</a>
	 */
	private static final class TeamHandlerDescriptor {
		/**
		 * Name of the extension point attribute corresponding to the handler's
		 * class.
		 */
		private static final String ATTRIBUTE_HANDLER_CLASS = "class"; //$NON-NLS-1$

		/**
		 * Keeps a reference to the configuration element that describes this
		 * handler.
		 */
		private final IConfigurationElement element;

		/** This descriptor's wrapped {@link AbstractTeamHandler handler}. */
		private AbstractTeamHandler handler;

		/**
		 * Constructs a new descriptor from an IConfigurationElement.
		 * 
		 * @param configuration
		 *            Configuration of the team handler.
		 */
		public TeamHandlerDescriptor(IConfigurationElement configuration) {
			element = configuration;
		}

		/**
		 * Returns an instance of the described handler.
		 * 
		 * @return Instance of the handler.
		 */
		public AbstractTeamHandler getHandlerInstance() {
			if (handler == null) {
				try {
					handler = (AbstractTeamHandler) element
							.createExecutableExtension(ATTRIBUTE_HANDLER_CLASS);
				} catch (CoreException e) {
					EMFComparePlugin.log(e, true);
				}
			}
			return handler;
		}
	}
}
