/**
 * 
 */
package de.cau.cs.kieler.rail.editor;

import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.ICreateConnectionFeature;
import org.eclipse.graphiti.features.ICreateFeature;
import org.eclipse.graphiti.features.IDeleteFeature;
import org.eclipse.graphiti.features.IDirectEditingFeature;
import org.eclipse.graphiti.features.IFeature;
import org.eclipse.graphiti.features.ILayoutFeature;
import org.eclipse.graphiti.features.IMoveAnchorFeature;
import org.eclipse.graphiti.features.IResizeShapeFeature;
import org.eclipse.graphiti.features.IUpdateFeature;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.context.IDeleteContext;
import org.eclipse.graphiti.features.context.IDirectEditingContext;
import org.eclipse.graphiti.features.context.ILayoutContext;
import org.eclipse.graphiti.features.context.IMoveAnchorContext;
import org.eclipse.graphiti.features.context.IPictogramElementContext;
import org.eclipse.graphiti.features.context.IResizeShapeContext;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.features.custom.ICustomFeature;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.ui.features.DefaultFeatureProvider;

import de.cau.cs.kieler.core.model.graphiti.IStyleProvider;
import de.cau.cs.kieler.core.model.graphiti.features.DefaultKielerDeleteFeature;
import de.cau.cs.kieler.rail.editor.features.AddEdgeFeature;
import de.cau.cs.kieler.rail.editor.features.AddVertexFeature;
import de.cau.cs.kieler.rail.editor.features.CreateEdgeFeature;
import de.cau.cs.kieler.rail.editor.features.CreateVertexFeature;
import de.cau.cs.kieler.rail.editor.features.DirectEditBreachFeatures;
import de.cau.cs.kieler.rail.editor.features.LayoutFeature;
import de.cau.cs.kieler.rail.editor.features.MovePortFeature;
import de.cau.cs.kieler.rail.editor.features.ResizeFeature;
import de.cau.cs.kieler.rail.editor.features.RotateSwitchFeature;
import de.cau.cs.kieler.rail.editor.features.ToggleSwitchFeature;
import de.cau.cs.kieler.rail.editor.features.VertexType;
import de.cau.cs.kieler.rail.editor.features.UpdateBreachFeature;
import de.cau.cs.kieler.rail.editor.features.UpdateSwitchFeature;
import de.menges.topologie.Topologie.Basegraph.Edge;
import de.menges.topologie.Topologie.Basegraph.Port;
import de.menges.topologie.Topologie.Basegraph.Vertex;
import de.menges.topologie.Topologie.SpecializedVertices.*;
import de.menges.topologie.topoDSL.ELage;

/**
 * @author hdw
 * 
 */
public class FeatureProvider extends DefaultFeatureProvider {
    /**Height for the Breach*/
	private static final int BREANCH_HEIGHT = 50;
	/**Width for the breach*/
    private static final int BREANCH_WIDTH = 50;
    /**Height for the switch*/
	private static final int SWITCH_HEIGHT = 50;
	/**Width for the switch*/
	private static final int SWITCH_WIDTH = 50;
	/**Width for the deadend vertex*/
	private static final int DEADENDVERTEX_HEIGHT = 50;
	/**Height for the deadend vertex*/
	private static final int DEADENDVERTEX_WIDTH = 50;
    /** the style provider that is used by the features. */
    private IStyleProvider styleProvider;
    /** the semantic provider that is used by create-features. */
    private SemanticProvider semanticProvider;

    /**
     * Standard constructor.
     * @param dtp The Diagram Type Provider
     */
    public FeatureProvider(final IDiagramTypeProvider dtp) {
        super(dtp);
        styleProvider = new StyleProvider(dtp);
        semanticProvider = new SemanticProvider(dtp);
    }

    /**
     * {@inheritDoc}
     */
    @Override
	public final IAddFeature getAddFeature(final IAddContext context) {
        if (context.getNewObject() instanceof Einbruchsknoten) {
            return new AddVertexFeature(this, this.styleProvider,
                    VertexType.BREACH);
        } else if (context.getNewObject() instanceof Stumpfgleisknoten) {
            return new AddVertexFeature(this, this.styleProvider,
                    VertexType.DEADEND);
        } else if (context.getNewObject() instanceof Weichenknoten) {
            EOrientation orientation =
                 ((Weichenknoten) (context.getNewObject()))
                 .getAbzweigendeLage();
            switch (orientation) {
            case LINKS:
                return new AddVertexFeature(this, this.styleProvider,
                        VertexType.SWITCH_LEFT);
            case RECHTS:
                return new AddVertexFeature(this, this.styleProvider,
                        VertexType.SWITCH_RIGHT);
			default:
				break;
            }
        } else if (context.getNewObject() instanceof Edge) {
            return new AddEdgeFeature(this, styleProvider);
        }
        return super.getAddFeature(context);
    }

    /**
     * {@inheritDoc}
     */
    @Override
	public final ICreateFeature[] getCreateFeatures() {
        // , new CreateDeadEndVertexFeature(this)

        return new ICreateFeature[] {
                new CreateVertexFeature(this, VertexType.BREACH, semanticProvider),
                new CreateVertexFeature(this, VertexType.DEADEND, semanticProvider),
                new CreateVertexFeature(this, VertexType.SWITCH_LEFT, semanticProvider),
                new CreateVertexFeature(this, VertexType.SWITCH_RIGHT, semanticProvider)};
                //new CreatePortFeature(this)};
    }

    /**
     * {@inheritDoc}
     */
    @Override
	public final ICreateConnectionFeature[] getCreateConnectionFeatures() {
        return new ICreateConnectionFeature[] {new CreateEdgeFeature(this, semanticProvider)};
    }

    /**
     * {@inheritDoc}
     */
    @Override
	public final IUpdateFeature getUpdateFeature(
			final IUpdateContext context) {
        PictogramElement pictogramElement = context.getPictogramElement();
        if (pictogramElement instanceof ContainerShape) {
            Object bo = getBusinessObjectForPictogramElement(pictogramElement);
            if (bo instanceof Einbruchsknoten) {
                return new UpdateBreachFeature(this);
            } else if (bo instanceof Weichenknoten) {
                return new UpdateSwitchFeature(this);
            }
        }
        return super.getUpdateFeature(context);
    }

    /**
     * {@inheritDoc}
     */
    @Override
	public final IDirectEditingFeature getDirectEditingFeature(
            final IDirectEditingContext context) {
        PictogramElement pe = context.getPictogramElement();
        Object bo = getBusinessObjectForPictogramElement(pe);
        if (bo instanceof Vertex) {
            return new DirectEditBreachFeatures(this);
        }
        return super.getDirectEditingFeature(context);
    }

    /**
     * {@inheritDoc}
     */
    @Override
	public final IResizeShapeFeature getResizeShapeFeature(
            final IResizeShapeContext context) {
        Shape shape = context.getShape();
        Object bo = getBusinessObjectForPictogramElement(shape);
        if (bo instanceof Einbruchsknoten) {
            return new ResizeFeature(this, VertexType.BREACH);
        } else if (bo instanceof Stumpfgleisknoten) {
            return new ResizeFeature(this, VertexType.DEADEND);
        } else if (bo instanceof Weichenknoten) {
            EOrientation orientation = ((Weichenknoten)
            		(bo)).getAbzweigendeLage();
            switch (orientation) {
            case LINKS:
                return new ResizeFeature(this, VertexType.SWITCH_LEFT);
            case RECHTS:
                return new ResizeFeature(this, VertexType.SWITCH_RIGHT);
			default:
				break;
            }
        }
        return super.getResizeShapeFeature(context);
    }

    /**
     * {@inheritDoc}
     */
    @Override
	public final ILayoutFeature getLayoutFeature(
			final ILayoutContext context) {
        PictogramElement pictogramElement = context.getPictogramElement();
        Object bo = getBusinessObjectForPictogramElement(pictogramElement);
        if (bo instanceof Einbruchsknoten) {
            return new LayoutFeature(this, VertexType.BREACH,
                    BREANCH_HEIGHT, BREANCH_WIDTH);
        } else if (bo instanceof Stumpfgleisknoten) {
            return new LayoutFeature(this, VertexType.DEADEND,
            		DEADENDVERTEX_HEIGHT, DEADENDVERTEX_WIDTH);
        } else if (bo instanceof Weichenknoten) {
            EOrientation orientation =
            	((Weichenknoten) (bo)).getAbzweigendeLage();
            switch (orientation) {
            case LINKS:
                return new LayoutFeature(this, VertexType.SWITCH_LEFT,
                        SWITCH_HEIGHT, SWITCH_WIDTH);
            case RECHTS:
                return new LayoutFeature(this, VertexType.SWITCH_RIGHT,
                		SWITCH_HEIGHT, SWITCH_WIDTH);
			default:
				break;
            }
        }
        return super.getLayoutFeature(context);
    }

    /**
     * {@inheritDoc}
     */
    @Override
	public final IMoveAnchorFeature getMoveAnchorFeature(
            final IMoveAnchorContext context) {
        System.out.println(getBusinessObjectForPictogramElement(context
                .getAnchor()));
        if (getBusinessObjectForPictogramElement(context.getAnchor())
        instanceof Port) {
            return new MovePortFeature(this);
        }
        return super.getMoveAnchorFeature(context);
    }

    @Override
	public final IFeature[] getDragAndDropFeatures(
            final IPictogramElementContext context) {
        // simply return all create connection features
        return getCreateConnectionFeatures();
    }

    @Override
	public final ICustomFeature[] getCustomFeatures(final ICustomContext context) {
        return new ICustomFeature[] {new RotateSwitchFeature(this),
                new ToggleSwitchFeature(this) };
    }

    /**
     * {@inheritDoc}
     */
    @Override
	public final IDeleteFeature getDeleteFeature(final IDeleteContext context) {
        return new DefaultKielerDeleteFeature(this);
    }

}