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
 * 
 *****************************************************************************/
package de.cau.cs.kieler.synccharts.text.kitsState.ui;

import java.util.List;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.validation.DiagnosticConverterImpl;
import org.eclipse.xtext.validation.IDiagnosticConverter;

import de.cau.cs.kieler.synccharts.SyncchartsPackage;

/**
 * 
 * @author chsch
 */
public class KitsStateDiagnosticConverterImpl extends DiagnosticConverterImpl {

    public void convertValidatorDiagnostic(org.eclipse.emf.common.util.Diagnostic diagnostic,
            IDiagnosticConverter.Acceptor acceptor) {
        if (SyncchartsPackage.eINSTANCE.getState().isInstance(getCauser(diagnostic))) {
            EStructuralFeature feature = getFeature(diagnostic);
            if (SyncchartsPackage.eINSTANCE.getState_ParentRegion().equals(feature)) {
                return;
            }
        }
        super.convertValidatorDiagnostic(diagnostic, acceptor);
    }
    
    protected EStructuralFeature getFeature(Diagnostic diagnostic) {
        List<?> data = diagnostic.getData();
        Object feature = data.size() > 1 ? data.get(1) : null;
        return resolveStructuralFeature(getCauser(diagnostic), feature);
    }
}
