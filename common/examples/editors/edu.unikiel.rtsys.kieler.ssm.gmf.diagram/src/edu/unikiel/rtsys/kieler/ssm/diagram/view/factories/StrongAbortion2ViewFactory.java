package edu.unikiel.rtsys.kieler.ssm.diagram.view.factories;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.view.factories.ConnectionViewFactory;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.View;

import edu.unikiel.rtsys.kieler.ssm.diagram.edit.parts.StrongAbortion2EditPart;
import edu.unikiel.rtsys.kieler.ssm.diagram.edit.parts.StrongAbortionIsImmediateStringTrigge2EditPart;
import edu.unikiel.rtsys.kieler.ssm.diagram.edit.parts.StrongAbortionPriority2EditPart;
import edu.unikiel.rtsys.kieler.ssm.diagram.part.SafeStateMachineVisualIDRegistry;

/**
 * @generated
 */
public class StrongAbortion2ViewFactory extends ConnectionViewFactory {

    /**
     * @generated
     */
    protected List createStyles(View view) {
        List styles = new ArrayList();
        styles.add(NotationFactory.eINSTANCE.createConnectorStyle());
        styles.add(NotationFactory.eINSTANCE.createFontStyle());
        return styles;
    }

    /**
     * @generated
     */
    protected void decorateView(View containerView, View view,
            IAdaptable semanticAdapter, String semanticHint, int index,
            boolean persisted) {
        if (semanticHint == null) {
            semanticHint = SafeStateMachineVisualIDRegistry
                    .getType(StrongAbortion2EditPart.VISUAL_ID);
            view.setType(semanticHint);
        }
        super.decorateView(containerView, view, semanticAdapter, semanticHint,
                index, persisted);
        IAdaptable eObjectAdapter = null;
        EObject eObject = (EObject) semanticAdapter.getAdapter(EObject.class);
        if (eObject != null) {
            eObjectAdapter = new EObjectAdapter(eObject);
        }
        getViewService().createNode(
                eObjectAdapter,
                view,
                SafeStateMachineVisualIDRegistry
                        .getType(StrongAbortionPriority2EditPart.VISUAL_ID),
                ViewUtil.APPEND, true, getPreferencesHint());
        getViewService()
                .createNode(
                        eObjectAdapter,
                        view,
                        SafeStateMachineVisualIDRegistry
                                .getType(StrongAbortionIsImmediateStringTrigge2EditPart.VISUAL_ID),
                        ViewUtil.APPEND, true, getPreferencesHint());
    }
}
