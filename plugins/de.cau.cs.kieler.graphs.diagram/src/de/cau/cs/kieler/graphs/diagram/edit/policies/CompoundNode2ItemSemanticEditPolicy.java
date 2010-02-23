package de.cau.cs.kieler.graphs.diagram.edit.policies;

import java.util.Iterator;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.command.ICompositeCommand;
import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;

import de.cau.cs.kieler.graphs.diagram.edit.commands.EdgeCreateCommand;
import de.cau.cs.kieler.graphs.diagram.edit.commands.EdgeReorientCommand;
import de.cau.cs.kieler.graphs.diagram.edit.parts.CompoundNode2EditPart;
import de.cau.cs.kieler.graphs.diagram.edit.parts.CompoundNodeNodeCompartment2EditPart;
import de.cau.cs.kieler.graphs.diagram.edit.parts.EdgeEditPart;
import de.cau.cs.kieler.graphs.diagram.edit.parts.Node2EditPart;
import de.cau.cs.kieler.graphs.diagram.part.GraphsVisualIDRegistry;
import de.cau.cs.kieler.graphs.diagram.providers.GraphsElementTypes;

/**
 * @generated
 */
public class CompoundNode2ItemSemanticEditPolicy extends GraphsBaseItemSemanticEditPolicy {

    /**
     * @generated
     */
    public CompoundNode2ItemSemanticEditPolicy() {
        super(GraphsElementTypes.CompoundNode_3002);
    }

    /**
     * @generated
     */
    protected Command getDestroyElementCommand(DestroyElementRequest req) {
        View view = (View) getHost().getModel();
        CompositeTransactionalCommand cmd = new CompositeTransactionalCommand(getEditingDomain(), null);
        cmd.setTransactionNestingEnabled(false);
        for (Iterator it = view.getTargetEdges().iterator(); it.hasNext();) {
            Edge incomingLink = (Edge) it.next();
            if (GraphsVisualIDRegistry.getVisualID(incomingLink) == EdgeEditPart.VISUAL_ID) {
                DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
                cmd.add(new DestroyElementCommand(r));
                cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
                continue;
            }
        }
        for (Iterator it = view.getSourceEdges().iterator(); it.hasNext();) {
            Edge outgoingLink = (Edge) it.next();
            if (GraphsVisualIDRegistry.getVisualID(outgoingLink) == EdgeEditPart.VISUAL_ID) {
                DestroyElementRequest r = new DestroyElementRequest(outgoingLink.getElement(), false);
                cmd.add(new DestroyElementCommand(r));
                cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
                continue;
            }
        }
        EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
        if (annotation == null) {
            // there are indirectly referenced children, need extra commands: false
            addDestroyChildNodesCommand(cmd);
            addDestroyShortcutsCommand(cmd, view);
            // delete host element
            cmd.add(new DestroyElementCommand(req));
        } else {
            cmd.add(new DeleteCommand(getEditingDomain(), view));
        }
        return getGEFWrapper(cmd.reduce());
    }

    /**
     * @generated
     */
    private void addDestroyChildNodesCommand(ICompositeCommand cmd) {
        View view = (View) getHost().getModel();
        for (Iterator nit = view.getChildren().iterator(); nit.hasNext();) {
            Node node = (Node) nit.next();
            switch (GraphsVisualIDRegistry.getVisualID(node)) {
            case CompoundNodeNodeCompartment2EditPart.VISUAL_ID:
                for (Iterator cit = node.getChildren().iterator(); cit.hasNext();) {
                    Node cnode = (Node) cit.next();
                    switch (GraphsVisualIDRegistry.getVisualID(cnode)) {
                    case Node2EditPart.VISUAL_ID:
                        for (Iterator it = cnode.getTargetEdges().iterator(); it.hasNext();) {
                            Edge incomingLink = (Edge) it.next();
                            if (GraphsVisualIDRegistry.getVisualID(incomingLink) == EdgeEditPart.VISUAL_ID) {
                                DestroyElementRequest r = new DestroyElementRequest(incomingLink
                                        .getElement(), false);
                                cmd.add(new DestroyElementCommand(r));
                                cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
                                continue;
                            }
                        }
                        for (Iterator it = cnode.getSourceEdges().iterator(); it.hasNext();) {
                            Edge outgoingLink = (Edge) it.next();
                            if (GraphsVisualIDRegistry.getVisualID(outgoingLink) == EdgeEditPart.VISUAL_ID) {
                                DestroyElementRequest r = new DestroyElementRequest(outgoingLink
                                        .getElement(), false);
                                cmd.add(new DestroyElementCommand(r));
                                cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
                                continue;
                            }
                        }
                        cmd.add(new DestroyElementCommand(new DestroyElementRequest(getEditingDomain(),
                                cnode.getElement(), false))); // directlyOwned: true
                        // don't need explicit deletion of cnode as parent's view deletion would clean child views as well 
                        // cmd.add(new org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand(getEditingDomain(), cnode));
                        break;
                    case CompoundNode2EditPart.VISUAL_ID:
                        for (Iterator it = cnode.getTargetEdges().iterator(); it.hasNext();) {
                            Edge incomingLink = (Edge) it.next();
                            if (GraphsVisualIDRegistry.getVisualID(incomingLink) == EdgeEditPart.VISUAL_ID) {
                                DestroyElementRequest r = new DestroyElementRequest(incomingLink
                                        .getElement(), false);
                                cmd.add(new DestroyElementCommand(r));
                                cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
                                continue;
                            }
                        }
                        for (Iterator it = cnode.getSourceEdges().iterator(); it.hasNext();) {
                            Edge outgoingLink = (Edge) it.next();
                            if (GraphsVisualIDRegistry.getVisualID(outgoingLink) == EdgeEditPart.VISUAL_ID) {
                                DestroyElementRequest r = new DestroyElementRequest(outgoingLink
                                        .getElement(), false);
                                cmd.add(new DestroyElementCommand(r));
                                cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
                                continue;
                            }
                        }
                        cmd.add(new DestroyElementCommand(new DestroyElementRequest(getEditingDomain(),
                                cnode.getElement(), false))); // directlyOwned: true
                        // don't need explicit deletion of cnode as parent's view deletion would clean child views as well 
                        // cmd.add(new org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand(getEditingDomain(), cnode));
                        break;
                    }
                }
                break;
            }
        }
    }

    /**
     * @generated
     */
    protected Command getCreateRelationshipCommand(CreateRelationshipRequest req) {
        Command command = req.getTarget() == null ? getStartCreateRelationshipCommand(req)
                : getCompleteCreateRelationshipCommand(req);
        return command != null ? command : super.getCreateRelationshipCommand(req);
    }

    /**
     * @generated
     */
    protected Command getStartCreateRelationshipCommand(CreateRelationshipRequest req) {
        if (GraphsElementTypes.Edge_4001 == req.getElementType()) {
            return getGEFWrapper(new EdgeCreateCommand(req, req.getSource(), req.getTarget()));
        }
        return null;
    }

    /**
     * @generated
     */
    protected Command getCompleteCreateRelationshipCommand(CreateRelationshipRequest req) {
        if (GraphsElementTypes.Edge_4001 == req.getElementType()) {
            return getGEFWrapper(new EdgeCreateCommand(req, req.getSource(), req.getTarget()));
        }
        return null;
    }

    /**
     * Returns command to reorient EClass based link. New link target or source
     * should be the domain model element associated with this node.
     * 
     * @generated
     */
    protected Command getReorientRelationshipCommand(ReorientRelationshipRequest req) {
        switch (getVisualID(req)) {
        case EdgeEditPart.VISUAL_ID:
            return getGEFWrapper(new EdgeReorientCommand(req));
        }
        return super.getReorientRelationshipCommand(req);
    }

}
