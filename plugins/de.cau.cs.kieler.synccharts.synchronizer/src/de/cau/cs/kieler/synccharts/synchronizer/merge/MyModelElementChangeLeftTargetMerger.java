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
package de.cau.cs.kieler.synccharts.synchronizer.merge;

import java.util.Iterator;

import org.eclipse.emf.compare.EMFComparePlugin;
import org.eclipse.emf.compare.FactoryException;
import org.eclipse.emf.compare.diff.merge.DefaultMerger;
import org.eclipse.emf.compare.diff.merge.EMFCompareEObjectCopier;
import org.eclipse.emf.compare.diff.merge.service.MergeService;
import org.eclipse.emf.compare.diff.metamodel.ConflictingDiffElement;
import org.eclipse.emf.compare.diff.metamodel.DiffElement;
import org.eclipse.emf.compare.diff.metamodel.DiffGroup;
import org.eclipse.emf.compare.diff.metamodel.ModelElementChangeLeftTarget;
import org.eclipse.emf.compare.diff.metamodel.ReferenceChangeLeftTarget;
import org.eclipse.emf.compare.diff.metamodel.ReferenceOrderChange;
import org.eclipse.emf.compare.util.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.util.Strings;

import de.cau.cs.kieler.core.kexpressions.KExpressionsPackage;
import de.cau.cs.kieler.core.kexpressions.ValuedObject;

/**
 * Customized merger for an {@link ModelElementChangeLeftTarget} operation.
 * 
 * @author chsch
 * @kieler.ignore (excluded from review process)
 */
public class MyModelElementChangeLeftTargetMerger extends DefaultMerger {
    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.emf.compare.diff.merge.api.AbstractMerger#applyInOrigin()
     */
    @Override
    public void applyInOrigin() {
        final ModelElementChangeLeftTarget theDiff = (ModelElementChangeLeftTarget) this.diff;
        final EObject element = theDiff.getLeftElement();
        final EObject parent = theDiff.getLeftElement().eContainer();
        EcoreUtil.remove(element);
        // now removes all the dangling references
        removeDanglingReferences(parent);
        super.applyInOrigin();
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.emf.compare.diff.merge.api.AbstractMerger#undoInTarget()
     */
    @Override
    public void undoInTarget() {
        final ModelElementChangeLeftTarget theDiff = (ModelElementChangeLeftTarget) this.diff;
        // we should copy the element to the Origin one.
        final EObject origin = theDiff.getRightParent();
        final EObject element = theDiff.getLeftElement();
        
//        if (origin instanceof Transition) {
//            System.out.println("Hier " + origin.eResource());
//        }
        
        if (KExpressionsPackage.eINSTANCE.getValuedObject().isInstance(element)
                && Strings.isEmpty(((ValuedObject) element).getName())) {
            super.undoInTarget();
            return;
        }
        
        final EObject newOne = copy(element);
        
//        LinkingAdapter.installLinkingAdapter(element, newOne);
        
        final EReference ref = element.eContainmentFeature();
        if (ref != null) {
            try {
                EFactory.eAdd(origin, ref.getName(), newOne);
                setXMIID(newOne, getXMIID(element));
            } catch (final FactoryException e) {
                EMFComparePlugin.log(e, true);
            }
        } else if (origin == null && getDiffModel().getRightRoots().size() > 0) {
            getDiffModel().getRightRoots().get(0).eResource().getContents().add(newOne);
        } else if (origin != null) {
            origin.eResource().getContents().add(newOne);
        } else { // SUPPRESS CHECKSTYLE EmptyBlock
            // FIXME throw exception : couldn't merge this
        }
        // we should now have a look for RemovedReferencesLinks needing elements to apply
        final Iterator<EObject> siblings = getDiffModel().eAllContents();
        while (siblings.hasNext()) {
            final Object op = siblings.next();
            if (op instanceof ReferenceChangeLeftTarget) { // SUPPRESS CHECKSTYLE EmptyBlock
//                final ReferenceChangeLeftTarget link = (ReferenceChangeLeftTarget) op;
                // now if I'm in the target References I should put my copy in the origin
                // if (link.getRightTarget().equals(element)) {
                // link.setLeftTarget(newOne);
                // }
            } else if (op instanceof ReferenceOrderChange) {
                final ReferenceOrderChange link = (ReferenceOrderChange) op;
                if (link.getReference().equals(ref)) {
                    // FIXME respect ordering!
                    link.getRightTarget().add(newOne);
                }
            }
        }
        super.undoInTarget();
    }

    @Override
    protected void removeFromContainer(final DiffElement diffElement) {
        final EObject parent = diffElement.eContainer();
        EcoreUtil.remove(diffElement);
        // removeDanglingReferences(parent);

        // If diff was contained by a ConflictingDiffElement, we call back this on it
        if (parent instanceof ConflictingDiffElement) {
            removeFromContainer((DiffElement) parent);
        }

        // if diff was in a diffGroup and it was the last one, we also remove the diffgroup
        if (parent instanceof DiffGroup) {
            cleanDiffGroup((DiffGroup) parent);
        }
    }

    /**
     * Creates a copy of the given EObject as a {@link EcoreUtil#copy(EObject)} would, except we use
     * specific handling for unmatched references.
     * 
     * @param eObject
     *            The object to copy.
     * @return the copied object.
     */
    public EObject copy(final EObject eObject) {
        final EMFCompareEObjectCopier copier = MergeService.getCopier(diff);
        final EObject result = copier.copy(eObject);
//        if (result.eAdapters().contains(ModelSynchronizer.getModelChangeListener())) {
//            System.out.println("�tsch");
//        }
        // copier.copyReferences();
        // copier.copyXMIIDs();
        return result;
    }
    
}
