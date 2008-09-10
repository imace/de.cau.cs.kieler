package edu.unikiel.rtsys.kieler.ssm.diagram.navigator;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.PlatformObject;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertySheetPageContributor;

/**
 * @generated
 */
public abstract class SafeStateMachineAbstractNavigatorItem extends
        PlatformObject {

    /**
     * @generated
     */
    static {
        final Class[] supportedTypes = new Class[] { ITabbedPropertySheetPageContributor.class };
        final ITabbedPropertySheetPageContributor propertySheetPageContributor = new ITabbedPropertySheetPageContributor() {
            public String getContributorId() {
                return "edu.unikiel.rtsys.kieler.ssm.gmf.diagram"; //$NON-NLS-1$
            }
        };
        Platform.getAdapterManager().registerAdapters(
                new IAdapterFactory() {

                    public Object getAdapter(Object adaptableObject,
                            Class adapterType) {
                        if (adaptableObject instanceof edu.unikiel.rtsys.kieler.ssm.diagram.navigator.SafeStateMachineAbstractNavigatorItem
                                && adapterType == ITabbedPropertySheetPageContributor.class) {
                            return propertySheetPageContributor;
                        }
                        return null;
                    }

                    public Class[] getAdapterList() {
                        return supportedTypes;
                    }
                },
                edu.unikiel.rtsys.kieler.ssm.diagram.navigator.SafeStateMachineAbstractNavigatorItem.class);
    }

    /**
     * @generated
     */
    private Object myParent;

    /**
     * @generated
     */
    protected SafeStateMachineAbstractNavigatorItem(Object parent) {
        myParent = parent;
    }

    /**
     * @generated
     */
    public Object getParent() {
        return myParent;
    }

}
