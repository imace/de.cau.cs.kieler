package edu.unikiel.rtsys.kieler.kivik.internal;

import java.lang.reflect.InvocationTargetException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.compare.CompareConfiguration;
import org.eclipse.compare.structuremergeviewer.ICompareInput;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.compare.EMFComparePlugin;
import org.eclipse.emf.compare.diff.metamodel.DiffFactory;
import org.eclipse.emf.compare.diff.metamodel.DiffModel;
import org.eclipse.emf.compare.diff.metamodel.ModelInputSnapshot;
import org.eclipse.emf.compare.diff.service.DiffService;
import org.eclipse.emf.compare.match.api.MatchOptions;
import org.eclipse.emf.compare.match.metamodel.MatchFactory;
import org.eclipse.emf.compare.match.metamodel.MatchModel;
import org.eclipse.emf.compare.match.service.MatchService;
import org.eclipse.emf.compare.match.statistic.MetamodelFilter;
import org.eclipse.emf.compare.ui.EMFCompareUIMessages;
import org.eclipse.emf.compare.ui.internal.ModelComparator;
import org.eclipse.emf.compare.ui.util.EMFCompareConstants;
import org.eclipse.emf.compare.util.EMFCompareMap;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.ui.PlatformUI;

/**
 * 
 * @author <a href="mailto:ars@informatik.uni-kiel.de">Arne Schipper</a>
 */
public final class KivikComparator {

	private static final Map<CompareConfiguration, KivikComparator> INSTANCES = new HashMap<CompareConfiguration, KivikComparator>();
	private CompareConfiguration fCompareConfiguration;
	private ModelInputSnapshot fKivikComparisonResult;

	/**
	 * Model comparators will only be instantiated via
	 * {@link #getComparator(CompareConfiguration)}.
	 */
	private KivikComparator(CompareConfiguration compareConfiguration) {
		fCompareConfiguration = compareConfiguration;
	}

	/**
	 * This will return the KivikComparator associated to the given
	 * CompareConfiguration.
	 * 
	 * @param configuration
	 *            CompareConfiguration of this comparator.
	 * @return The comparator for this configuration.
	 */
	public static KivikComparator getKivikComparator(
			CompareConfiguration configuration) {
		if (!INSTANCES.containsKey(configuration))
			INSTANCES.put(configuration, new KivikComparator(configuration));
		return INSTANCES.get(configuration);
	}

	/**
	 * Removes the comparator corresponding to a no longer used configuration.
	 * 
	 * @param configuration
	 *            CompareConfiguration which comparator should be removed.
	 */
	public static void removeKivikComparator(CompareConfiguration configuration) {
		ModelComparator.removeComparator(configuration);
		INSTANCES.remove(configuration);
	}

	public ModelComparator getComparator() {
		return ModelComparator.getComparator(fCompareConfiguration);
	}

	private EObject getAncestorDomainEObject(){
		if (getComparator().getAncestorResource() != null) {
			ResourceSet rset = getComparator().getAncestorResource().getResourceSet();
			return getDomainEObject(rset);
		} else
			return null;
	}
	
	private EObject getLeftDomainEObject() {
		ResourceSet rset = getComparator().getLeftResource().getResourceSet();
		return getDomainEObject(rset);
	}
	
	private EObject getRightDomainEObject() {
		ResourceSet rset = getComparator().getRightResource().getResourceSet();
		return getDomainEObject(rset);
	}
	
	private EObject getDomainEObject(ResourceSet rset) {
		EList<Resource> resources = rset.getResources();
		if (resources.size() == 2) {
			return resources.get(1).getContents().get(0);
		} else {
			Resource diagramAndModelResource = resources.get(0);
			return diagramAndModelResource.getContents().get(0);
		}
	}

	public ModelInputSnapshot getNotationComparisonResult() {
		return getComparator().getComparisonResult();
	}

	public ModelInputSnapshot getDomainComparisonResult() {
		if (fKivikComparisonResult == null
				|| fKivikComparisonResult.getDate() == null)
			return null;
		else
			return fKivikComparisonResult;
	}

	public ModelInputSnapshot compareNotationModel() {
		return getComparator().compare(fCompareConfiguration);
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
	public ModelInputSnapshot compareDomainModel() {
		if (fKivikComparisonResult == null
				|| fKivikComparisonResult.getDate() == null) {
			fKivikComparisonResult = DiffFactory.eINSTANCE
					.createModelInputSnapshot();
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
								if (getAncestorDomainEObject() == null)
									match = MatchService.doContentMatch(
											getLeftDomainEObject(),
											getRightDomainEObject(), options);
								else
									match = MatchService.doContentMatch(
											getLeftDomainEObject(),
											getRightDomainEObject(),
											getAncestorDomainEObject(),
											options);
								final DiffModel diff = DiffService.doDiff(
										match,
										getAncestorDomainEObject() != null);

								fKivikComparisonResult.setDate(Calendar
										.getInstance().getTime());
								fKivikComparisonResult.setDiff(diff);
								fKivikComparisonResult.setMatch(match);
							}
						});
			} catch (InterruptedException e) {
				fKivikComparisonResult
						.setDate(Calendar.getInstance().getTime());
				fKivikComparisonResult.setDiff(DiffFactory.eINSTANCE
						.createDiffModel());
				fKivikComparisonResult.setMatch(MatchFactory.eINSTANCE
						.createMatchModel());
			} catch (InvocationTargetException e) {
				EMFComparePlugin.log(e, true);
			}

			final Date end = Calendar.getInstance().getTime();
			fCompareConfiguration.setProperty(
					EMFCompareConstants.PROPERTY_COMPARISON_TIME, end.getTime()
							- start.getTime());
			fCompareConfiguration.setLeftEditable(!getComparator()
					.isLeftRemote());
			fCompareConfiguration.setRightEditable(!getComparator()
					.isRightRemote());
			if (getComparator().isLeftRemote()) {
				fCompareConfiguration.setLeftLabel(EMFCompareUIMessages
						.getString("comparison.label.remoteResource")); //$NON-NLS-1$
				fCompareConfiguration.setRightLabel(EMFCompareUIMessages
						.getString("comparison.label.localResource")); //$NON-NLS-1$
			}
		}
		return fKivikComparisonResult;
	}

	public void loadResources(ICompareInput input) {

		/* load the.ssm_diagram Resources */
		getComparator().loadResources(input);

		/*
		 * maybe use this later to pass a new input, now.ssm instead of
		 * .ssm_diagram to another EMF ModelComparator.
		 */
		// ResourceNode left = (ResourceNode) input.getLeft();
		// ResourceNode right = input.getRight();
		// ResourceNode ancestor = input.getAncestor();
		/*
		 * And here's the trick. Emma has just the.ssm_diagram resources, as she
		 * clicked on these files and these were loaded by the original EMF
		 * ModelComparator. Passing the contents of the resources to the
		 * MetamodelFilter results in loading also the two domain resources into
		 * the ResourceSet, and Emma can use them.
		 */
		MetamodelFilter metamodelFilter = new MetamodelFilter();
		for (EObject root : getComparator().getLeftResource().getContents())
			metamodelFilter.analyseModel(root);
		for (EObject root : getComparator().getRightResource().getContents())
			metamodelFilter.analyseModel(root);
	}

}
