/*
* KIELER - Kiel Integrated Environment for Layout Eclipse RichClient
* 
* http://www.informatik.uni-kiel.de/rtsys/kieler/
* 
* Copyright 2009 by
* + Christian-Albrechts-University of Kiel
*   + Department of Computer Science
*     + Real-Time and Embedded Systems Group
* 
* This code is provided under the terms of the Eclipse Public License (EPL).
* See the file epl-v10.html for the license text.
*/
package de.cau.cs.kieler.dataflow.diagram.edit.policies;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.commands.DuplicateEObjectsCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DuplicateElementsRequest;

import de.cau.cs.kieler.dataflow.diagram.edit.commands.BoxCreateCommand;
import de.cau.cs.kieler.dataflow.diagram.providers.DataflowElementTypes;

/**
 * @generated
 */
public class DataflowModelItemSemanticEditPolicy extends DataflowBaseItemSemanticEditPolicy {

    /**
     * @generated
     */
    public DataflowModelItemSemanticEditPolicy() {
        super(DataflowElementTypes.DataflowModel_1000);
    }

    /**
     * @generated
     */
    protected Command getCreateCommand(CreateElementRequest req) {
        if (DataflowElementTypes.Box_2001 == req.getElementType()) {
            return getGEFWrapper(new BoxCreateCommand(req));
        }
        return super.getCreateCommand(req);
    }

    /**
     * @generated
     */
    protected Command getDuplicateCommand(DuplicateElementsRequest req) {
        TransactionalEditingDomain editingDomain = ((IGraphicalEditPart) getHost())
                .getEditingDomain();
        return getGEFWrapper(new DuplicateAnythingCommand(editingDomain, req));
    }

    /**
     * @generated
     */
    private static class DuplicateAnythingCommand extends DuplicateEObjectsCommand {

        /**
         * @generated
         */
        public DuplicateAnythingCommand(TransactionalEditingDomain editingDomain,
                DuplicateElementsRequest req) {
            super(editingDomain, req.getLabel(), req.getElementsToBeDuplicated(), req
                    .getAllDuplicatedElementsMap());
        }

    }

}
