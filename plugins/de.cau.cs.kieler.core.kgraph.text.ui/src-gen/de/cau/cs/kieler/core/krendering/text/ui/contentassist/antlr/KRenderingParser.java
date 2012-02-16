/*
* generated by Xtext
*/
package de.cau.cs.kieler.core.krendering.text.ui.contentassist.antlr;

import java.util.Collection;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.RecognitionException;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.AbstractContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.FollowElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;

import com.google.inject.Inject;

import de.cau.cs.kieler.core.krendering.text.services.KRenderingGrammarAccess;

public class KRenderingParser extends AbstractContentAssistParser {
	
	@Inject
	private KRenderingGrammarAccess grammarAccess;
	
	private Map<AbstractElement, String> nameMappings;
	
	@Override
	protected de.cau.cs.kieler.core.krendering.text.ui.contentassist.antlr.internal.InternalKRenderingParser createParser() {
		de.cau.cs.kieler.core.krendering.text.ui.contentassist.antlr.internal.InternalKRenderingParser result = new de.cau.cs.kieler.core.krendering.text.ui.contentassist.antlr.internal.InternalKRenderingParser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}
	
	@Override
	protected String getRuleName(AbstractElement element) {
		if (nameMappings == null) {
			nameMappings = new HashMap<AbstractElement, String>() {
				private static final long serialVersionUID = 1L;
				{
					put(grammarAccess.getKRenderingAccess().getAlternatives(), "rule__KRendering__Alternatives");
					put(grammarAccess.getKPlacementDataAccess().getAlternatives(), "rule__KPlacementData__Alternatives");
					put(grammarAccess.getKStyleAccess().getAlternatives(), "rule__KStyle__Alternatives");
					put(grammarAccess.getKPlacementAccess().getAlternatives(), "rule__KPlacement__Alternatives");
					put(grammarAccess.getKXPositionAccess().getAlternatives(), "rule__KXPosition__Alternatives");
					put(grammarAccess.getKYPositionAccess().getAlternatives(), "rule__KYPosition__Alternatives");
					put(grammarAccess.getKRoundedRectangleAccess().getAlternatives_2(), "rule__KRoundedRectangle__Alternatives_2");
					put(grammarAccess.getEFloatAccess().getAlternatives_4_0(), "rule__EFloat__Alternatives_4_0");
					put(grammarAccess.getEBooleanAccess().getAlternatives(), "rule__EBoolean__Alternatives");
					put(grammarAccess.getEStringAccess().getAlternatives(), "rule__EString__Alternatives");
					put(grammarAccess.getLineStyleAccess().getAlternatives(), "rule__LineStyle__Alternatives");
					put(grammarAccess.getVerticalAlignmentAccess().getAlternatives(), "rule__VerticalAlignment__Alternatives");
					put(grammarAccess.getHorizontalAlignmentAccess().getAlternatives(), "rule__HorizontalAlignment__Alternatives");
					put(grammarAccess.getKRenderingLibraryAccess().getGroup(), "rule__KRenderingLibrary__Group__0");
					put(grammarAccess.getKRenderingLibraryAccess().getGroup_3(), "rule__KRenderingLibrary__Group_3__0");
					put(grammarAccess.getKRenderingLibraryAccess().getGroup_3_1(), "rule__KRenderingLibrary__Group_3_1__0");
					put(grammarAccess.getKRenderingRefAccess().getGroup(), "rule__KRenderingRef__Group__0");
					put(grammarAccess.getKRenderingRefAccess().getGroup_2(), "rule__KRenderingRef__Group_2__0");
					put(grammarAccess.getKRenderingRefAccess().getGroup_2_3(), "rule__KRenderingRef__Group_2_3__0");
					put(grammarAccess.getKRenderingRefAccess().getGroup_5(), "rule__KRenderingRef__Group_5__0");
					put(grammarAccess.getKRenderingRefAccess().getGroup_6(), "rule__KRenderingRef__Group_6__0");
					put(grammarAccess.getKRenderingRefAccess().getGroup_6_3(), "rule__KRenderingRef__Group_6_3__0");
					put(grammarAccess.getKEllipseAccess().getGroup(), "rule__KEllipse__Group__0");
					put(grammarAccess.getKEllipseAccess().getGroup_3(), "rule__KEllipse__Group_3__0");
					put(grammarAccess.getKEllipseAccess().getGroup_3_3(), "rule__KEllipse__Group_3_3__0");
					put(grammarAccess.getKEllipseAccess().getGroup_4(), "rule__KEllipse__Group_4__0");
					put(grammarAccess.getKEllipseAccess().getGroup_5(), "rule__KEllipse__Group_5__0");
					put(grammarAccess.getKEllipseAccess().getGroup_6(), "rule__KEllipse__Group_6__0");
					put(grammarAccess.getKEllipseAccess().getGroup_6_3(), "rule__KEllipse__Group_6_3__0");
					put(grammarAccess.getKRectangleAccess().getGroup(), "rule__KRectangle__Group__0");
					put(grammarAccess.getKRectangleAccess().getGroup_3(), "rule__KRectangle__Group_3__0");
					put(grammarAccess.getKRectangleAccess().getGroup_3_3(), "rule__KRectangle__Group_3_3__0");
					put(grammarAccess.getKRectangleAccess().getGroup_4(), "rule__KRectangle__Group_4__0");
					put(grammarAccess.getKRectangleAccess().getGroup_5(), "rule__KRectangle__Group_5__0");
					put(grammarAccess.getKRectangleAccess().getGroup_6(), "rule__KRectangle__Group_6__0");
					put(grammarAccess.getKRectangleAccess().getGroup_6_3(), "rule__KRectangle__Group_6_3__0");
					put(grammarAccess.getKRoundedRectangleAccess().getGroup(), "rule__KRoundedRectangle__Group__0");
					put(grammarAccess.getKRoundedRectangleAccess().getGroup_2_0(), "rule__KRoundedRectangle__Group_2_0__0");
					put(grammarAccess.getKRoundedRectangleAccess().getGroup_2_1(), "rule__KRoundedRectangle__Group_2_1__0");
					put(grammarAccess.getKRoundedRectangleAccess().getGroup_3(), "rule__KRoundedRectangle__Group_3__0");
					put(grammarAccess.getKRoundedRectangleAccess().getGroup_3_3(), "rule__KRoundedRectangle__Group_3_3__0");
					put(grammarAccess.getKRoundedRectangleAccess().getGroup_4(), "rule__KRoundedRectangle__Group_4__0");
					put(grammarAccess.getKRoundedRectangleAccess().getGroup_5(), "rule__KRoundedRectangle__Group_5__0");
					put(grammarAccess.getKRoundedRectangleAccess().getGroup_6(), "rule__KRoundedRectangle__Group_6__0");
					put(grammarAccess.getKRoundedRectangleAccess().getGroup_6_3(), "rule__KRoundedRectangle__Group_6_3__0");
					put(grammarAccess.getKPolyline_ImplAccess().getGroup(), "rule__KPolyline_Impl__Group__0");
					put(grammarAccess.getKPolyline_ImplAccess().getGroup_3(), "rule__KPolyline_Impl__Group_3__0");
					put(grammarAccess.getKPolyline_ImplAccess().getGroup_3_3(), "rule__KPolyline_Impl__Group_3_3__0");
					put(grammarAccess.getKPolyline_ImplAccess().getGroup_4(), "rule__KPolyline_Impl__Group_4__0");
					put(grammarAccess.getKPolyline_ImplAccess().getGroup_5(), "rule__KPolyline_Impl__Group_5__0");
					put(grammarAccess.getKPolyline_ImplAccess().getGroup_6(), "rule__KPolyline_Impl__Group_6__0");
					put(grammarAccess.getKPolyline_ImplAccess().getGroup_6_3(), "rule__KPolyline_Impl__Group_6_3__0");
					put(grammarAccess.getKPolygonAccess().getGroup(), "rule__KPolygon__Group__0");
					put(grammarAccess.getKPolygonAccess().getGroup_3(), "rule__KPolygon__Group_3__0");
					put(grammarAccess.getKPolygonAccess().getGroup_3_3(), "rule__KPolygon__Group_3_3__0");
					put(grammarAccess.getKPolygonAccess().getGroup_4(), "rule__KPolygon__Group_4__0");
					put(grammarAccess.getKPolygonAccess().getGroup_5(), "rule__KPolygon__Group_5__0");
					put(grammarAccess.getKPolygonAccess().getGroup_6(), "rule__KPolygon__Group_6__0");
					put(grammarAccess.getKPolygonAccess().getGroup_6_3(), "rule__KPolygon__Group_6_3__0");
					put(grammarAccess.getKImageAccess().getGroup(), "rule__KImage__Group__0");
					put(grammarAccess.getKImageAccess().getGroup_6(), "rule__KImage__Group_6__0");
					put(grammarAccess.getKImageAccess().getGroup_6_3(), "rule__KImage__Group_6_3__0");
					put(grammarAccess.getKImageAccess().getGroup_7(), "rule__KImage__Group_7__0");
					put(grammarAccess.getKImageAccess().getGroup_8(), "rule__KImage__Group_8__0");
					put(grammarAccess.getKImageAccess().getGroup_8_3(), "rule__KImage__Group_8_3__0");
					put(grammarAccess.getKImageAccess().getGroup_9(), "rule__KImage__Group_9__0");
					put(grammarAccess.getKImageAccess().getGroup_9_3(), "rule__KImage__Group_9_3__0");
					put(grammarAccess.getKImageAccess().getGroup_10(), "rule__KImage__Group_10__0");
					put(grammarAccess.getKArcAccess().getGroup(), "rule__KArc__Group__0");
					put(grammarAccess.getKArcAccess().getGroup_3(), "rule__KArc__Group_3__0");
					put(grammarAccess.getKArcAccess().getGroup_4(), "rule__KArc__Group_4__0");
					put(grammarAccess.getKArcAccess().getGroup_5(), "rule__KArc__Group_5__0");
					put(grammarAccess.getKArcAccess().getGroup_5_3(), "rule__KArc__Group_5_3__0");
					put(grammarAccess.getKArcAccess().getGroup_6(), "rule__KArc__Group_6__0");
					put(grammarAccess.getKArcAccess().getGroup_7(), "rule__KArc__Group_7__0");
					put(grammarAccess.getKArcAccess().getGroup_7_3(), "rule__KArc__Group_7_3__0");
					put(grammarAccess.getKArcAccess().getGroup_8(), "rule__KArc__Group_8__0");
					put(grammarAccess.getKArcAccess().getGroup_8_3(), "rule__KArc__Group_8_3__0");
					put(grammarAccess.getKArcAccess().getGroup_9(), "rule__KArc__Group_9__0");
					put(grammarAccess.getKChildAreaAccess().getGroup(), "rule__KChildArea__Group__0");
					put(grammarAccess.getKChildAreaAccess().getGroup_3(), "rule__KChildArea__Group_3__0");
					put(grammarAccess.getKChildAreaAccess().getGroup_3_3(), "rule__KChildArea__Group_3_3__0");
					put(grammarAccess.getKChildAreaAccess().getGroup_4(), "rule__KChildArea__Group_4__0");
					put(grammarAccess.getKChildAreaAccess().getGroup_5(), "rule__KChildArea__Group_5__0");
					put(grammarAccess.getKChildAreaAccess().getGroup_5_3(), "rule__KChildArea__Group_5_3__0");
					put(grammarAccess.getKTextAccess().getGroup(), "rule__KText__Group__0");
					put(grammarAccess.getKTextAccess().getGroup_3(), "rule__KText__Group_3__0");
					put(grammarAccess.getKTextAccess().getGroup_4(), "rule__KText__Group_4__0");
					put(grammarAccess.getKTextAccess().getGroup_4_3(), "rule__KText__Group_4_3__0");
					put(grammarAccess.getKTextAccess().getGroup_5(), "rule__KText__Group_5__0");
					put(grammarAccess.getKTextAccess().getGroup_6(), "rule__KText__Group_6__0");
					put(grammarAccess.getKTextAccess().getGroup_6_3(), "rule__KText__Group_6_3__0");
					put(grammarAccess.getKTextAccess().getGroup_7(), "rule__KText__Group_7__0");
					put(grammarAccess.getKTextAccess().getGroup_7_3(), "rule__KText__Group_7_3__0");
					put(grammarAccess.getKTextAccess().getGroup_8(), "rule__KText__Group_8__0");
					put(grammarAccess.getKCustomRenderingAccess().getGroup(), "rule__KCustomRendering__Group__0");
					put(grammarAccess.getKCustomRenderingAccess().getGroup_6(), "rule__KCustomRendering__Group_6__0");
					put(grammarAccess.getKCustomRenderingAccess().getGroup_6_3(), "rule__KCustomRendering__Group_6_3__0");
					put(grammarAccess.getKCustomRenderingAccess().getGroup_7(), "rule__KCustomRendering__Group_7__0");
					put(grammarAccess.getKCustomRenderingAccess().getGroup_8(), "rule__KCustomRendering__Group_8__0");
					put(grammarAccess.getKCustomRenderingAccess().getGroup_8_3(), "rule__KCustomRendering__Group_8_3__0");
					put(grammarAccess.getKCustomRenderingAccess().getGroup_9(), "rule__KCustomRendering__Group_9__0");
					put(grammarAccess.getKCustomRenderingAccess().getGroup_9_3(), "rule__KCustomRendering__Group_9_3__0");
					put(grammarAccess.getKCustomRenderingAccess().getGroup_10(), "rule__KCustomRendering__Group_10__0");
					put(grammarAccess.getKSplineAccess().getGroup(), "rule__KSpline__Group__0");
					put(grammarAccess.getKSplineAccess().getGroup_3(), "rule__KSpline__Group_3__0");
					put(grammarAccess.getKSplineAccess().getGroup_3_3(), "rule__KSpline__Group_3_3__0");
					put(grammarAccess.getKSplineAccess().getGroup_4(), "rule__KSpline__Group_4__0");
					put(grammarAccess.getKSplineAccess().getGroup_5(), "rule__KSpline__Group_5__0");
					put(grammarAccess.getKSplineAccess().getGroup_5_3(), "rule__KSpline__Group_5_3__0");
					put(grammarAccess.getKSplineAccess().getGroup_6(), "rule__KSpline__Group_6__0");
					put(grammarAccess.getKSplineAccess().getGroup_6_3(), "rule__KSpline__Group_6_3__0");
					put(grammarAccess.getKSplineAccess().getGroup_7(), "rule__KSpline__Group_7__0");
					put(grammarAccess.getKDecoratorPlacementDataAccess().getGroup(), "rule__KDecoratorPlacementData__Group__0");
					put(grammarAccess.getKDecoratorPlacementDataAccess().getGroup_5(), "rule__KDecoratorPlacementData__Group_5__0");
					put(grammarAccess.getKDecoratorPlacementDataAccess().getGroup_6(), "rule__KDecoratorPlacementData__Group_6__0");
					put(grammarAccess.getKGridPlacementDataAccess().getGroup(), "rule__KGridPlacementData__Group__0");
					put(grammarAccess.getKStackPlacementDataAccess().getGroup(), "rule__KStackPlacementData__Group__0");
					put(grammarAccess.getKDirectPlacementDataAccess().getGroup(), "rule__KDirectPlacementData__Group__0");
					put(grammarAccess.getKPolylinePlacementDataAccess().getGroup(), "rule__KPolylinePlacementData__Group__0");
					put(grammarAccess.getKPolylinePlacementDataAccess().getGroup_3(), "rule__KPolylinePlacementData__Group_3__0");
					put(grammarAccess.getEFloatAccess().getGroup(), "rule__EFloat__Group__0");
					put(grammarAccess.getEFloatAccess().getGroup_4(), "rule__EFloat__Group_4__0");
					put(grammarAccess.getKPositionAccess().getGroup(), "rule__KPosition__Group__0");
					put(grammarAccess.getKLeftPositionAccess().getGroup(), "rule__KLeftPosition__Group__0");
					put(grammarAccess.getKLeftPositionAccess().getGroup_3(), "rule__KLeftPosition__Group_3__0");
					put(grammarAccess.getKLeftPositionAccess().getGroup_4(), "rule__KLeftPosition__Group_4__0");
					put(grammarAccess.getKRightPositionAccess().getGroup(), "rule__KRightPosition__Group__0");
					put(grammarAccess.getKRightPositionAccess().getGroup_3(), "rule__KRightPosition__Group_3__0");
					put(grammarAccess.getKRightPositionAccess().getGroup_4(), "rule__KRightPosition__Group_4__0");
					put(grammarAccess.getKTopPositionAccess().getGroup(), "rule__KTopPosition__Group__0");
					put(grammarAccess.getKTopPositionAccess().getGroup_3(), "rule__KTopPosition__Group_3__0");
					put(grammarAccess.getKTopPositionAccess().getGroup_4(), "rule__KTopPosition__Group_4__0");
					put(grammarAccess.getKBottomPositionAccess().getGroup(), "rule__KBottomPosition__Group__0");
					put(grammarAccess.getKBottomPositionAccess().getGroup_3(), "rule__KBottomPosition__Group_3__0");
					put(grammarAccess.getKBottomPositionAccess().getGroup_4(), "rule__KBottomPosition__Group_4__0");
					put(grammarAccess.getKForegroundColorAccess().getGroup(), "rule__KForegroundColor__Group__0");
					put(grammarAccess.getKForegroundColorAccess().getGroup_4(), "rule__KForegroundColor__Group_4__0");
					put(grammarAccess.getKForegroundColorAccess().getGroup_5(), "rule__KForegroundColor__Group_5__0");
					put(grammarAccess.getKForegroundColorAccess().getGroup_6(), "rule__KForegroundColor__Group_6__0");
					put(grammarAccess.getKBackgroundColorAccess().getGroup(), "rule__KBackgroundColor__Group__0");
					put(grammarAccess.getKBackgroundColorAccess().getGroup_4(), "rule__KBackgroundColor__Group_4__0");
					put(grammarAccess.getKBackgroundColorAccess().getGroup_5(), "rule__KBackgroundColor__Group_5__0");
					put(grammarAccess.getKBackgroundColorAccess().getGroup_6(), "rule__KBackgroundColor__Group_6__0");
					put(grammarAccess.getKLineWidthAccess().getGroup(), "rule__KLineWidth__Group__0");
					put(grammarAccess.getKVisibilityAccess().getGroup(), "rule__KVisibility__Group__0");
					put(grammarAccess.getKLineStyleAccess().getGroup(), "rule__KLineStyle__Group__0");
					put(grammarAccess.getKVerticalAlignmentAccess().getGroup(), "rule__KVerticalAlignment__Group__0");
					put(grammarAccess.getKHorizontalAlignmentAccess().getGroup(), "rule__KHorizontalAlignment__Group__0");
					put(grammarAccess.getKGridPlacementAccess().getGroup(), "rule__KGridPlacement__Group__0");
					put(grammarAccess.getKStackPlacementAccess().getGroup(), "rule__KStackPlacement__Group__0");
					put(grammarAccess.getEIntAccess().getGroup(), "rule__EInt__Group__0");
					put(grammarAccess.getKShapeLayoutAccess().getGroup(), "rule__KShapeLayout__Group__0");
					put(grammarAccess.getKShapeLayoutAccess().getGroup_3(), "rule__KShapeLayout__Group_3__0");
					put(grammarAccess.getKShapeLayoutAccess().getGroup_4(), "rule__KShapeLayout__Group_4__0");
					put(grammarAccess.getKShapeLayoutAccess().getGroup_5(), "rule__KShapeLayout__Group_5__0");
					put(grammarAccess.getKShapeLayoutAccess().getGroup_6(), "rule__KShapeLayout__Group_6__0");
					put(grammarAccess.getKShapeLayoutAccess().getGroup_7(), "rule__KShapeLayout__Group_7__0");
					put(grammarAccess.getKShapeLayoutAccess().getGroup_8(), "rule__KShapeLayout__Group_8__0");
					put(grammarAccess.getKShapeLayoutAccess().getGroup_8_3(), "rule__KShapeLayout__Group_8_3__0");
					put(grammarAccess.getKInsetsAccess().getGroup(), "rule__KInsets__Group__0");
					put(grammarAccess.getKInsetsAccess().getGroup_3(), "rule__KInsets__Group_3__0");
					put(grammarAccess.getKInsetsAccess().getGroup_4(), "rule__KInsets__Group_4__0");
					put(grammarAccess.getKInsetsAccess().getGroup_5(), "rule__KInsets__Group_5__0");
					put(grammarAccess.getKInsetsAccess().getGroup_6(), "rule__KInsets__Group_6__0");
					put(grammarAccess.getKEdgeLayoutAccess().getGroup(), "rule__KEdgeLayout__Group__0");
					put(grammarAccess.getKEdgeLayoutAccess().getGroup_6(), "rule__KEdgeLayout__Group_6__0");
					put(grammarAccess.getKEdgeLayoutAccess().getGroup_6_3(), "rule__KEdgeLayout__Group_6_3__0");
					put(grammarAccess.getKEdgeLayoutAccess().getGroup_7(), "rule__KEdgeLayout__Group_7__0");
					put(grammarAccess.getKEdgeLayoutAccess().getGroup_7_3(), "rule__KEdgeLayout__Group_7_3__0");
					put(grammarAccess.getKPointAccess().getGroup(), "rule__KPoint__Group__0");
					put(grammarAccess.getKPointAccess().getGroup_2(), "rule__KPoint__Group_2__0");
					put(grammarAccess.getKPointAccess().getGroup_3(), "rule__KPoint__Group_3__0");
					put(grammarAccess.getPersistentEntryAccess().getGroup(), "rule__PersistentEntry__Group__0");
					put(grammarAccess.getPersistentEntryAccess().getGroup_1(), "rule__PersistentEntry__Group_1__0");
					put(grammarAccess.getKRenderingLibraryAccess().getRenderingsAssignment_3_0(), "rule__KRenderingLibrary__RenderingsAssignment_3_0");
					put(grammarAccess.getKRenderingLibraryAccess().getRenderingsAssignment_3_1_1(), "rule__KRenderingLibrary__RenderingsAssignment_3_1_1");
					put(grammarAccess.getKRenderingRefAccess().getReferencesAssignment_2_2(), "rule__KRenderingRef__ReferencesAssignment_2_2");
					put(grammarAccess.getKRenderingRefAccess().getReferencesAssignment_2_3_1(), "rule__KRenderingRef__ReferencesAssignment_2_3_1");
					put(grammarAccess.getKRenderingRefAccess().getRenderingAssignment_4(), "rule__KRenderingRef__RenderingAssignment_4");
					put(grammarAccess.getKRenderingRefAccess().getPlacementDataAssignment_5_1(), "rule__KRenderingRef__PlacementDataAssignment_5_1");
					put(grammarAccess.getKRenderingRefAccess().getStylesAssignment_6_2(), "rule__KRenderingRef__StylesAssignment_6_2");
					put(grammarAccess.getKRenderingRefAccess().getStylesAssignment_6_3_1(), "rule__KRenderingRef__StylesAssignment_6_3_1");
					put(grammarAccess.getKEllipseAccess().getStylesAssignment_3_2(), "rule__KEllipse__StylesAssignment_3_2");
					put(grammarAccess.getKEllipseAccess().getStylesAssignment_3_3_1(), "rule__KEllipse__StylesAssignment_3_3_1");
					put(grammarAccess.getKEllipseAccess().getPlacementDataAssignment_4_2(), "rule__KEllipse__PlacementDataAssignment_4_2");
					put(grammarAccess.getKEllipseAccess().getChildPlacementAssignment_5_2(), "rule__KEllipse__ChildPlacementAssignment_5_2");
					put(grammarAccess.getKEllipseAccess().getChildrenAssignment_6_2(), "rule__KEllipse__ChildrenAssignment_6_2");
					put(grammarAccess.getKEllipseAccess().getChildrenAssignment_6_3_1(), "rule__KEllipse__ChildrenAssignment_6_3_1");
					put(grammarAccess.getKRectangleAccess().getStylesAssignment_3_2(), "rule__KRectangle__StylesAssignment_3_2");
					put(grammarAccess.getKRectangleAccess().getStylesAssignment_3_3_1(), "rule__KRectangle__StylesAssignment_3_3_1");
					put(grammarAccess.getKRectangleAccess().getPlacementDataAssignment_4_2(), "rule__KRectangle__PlacementDataAssignment_4_2");
					put(grammarAccess.getKRectangleAccess().getChildPlacementAssignment_5_2(), "rule__KRectangle__ChildPlacementAssignment_5_2");
					put(grammarAccess.getKRectangleAccess().getChildrenAssignment_6_2(), "rule__KRectangle__ChildrenAssignment_6_2");
					put(grammarAccess.getKRectangleAccess().getChildrenAssignment_6_3_1(), "rule__KRectangle__ChildrenAssignment_6_3_1");
					put(grammarAccess.getKRoundedRectangleAccess().getCornerWidthAssignment_2_0_1(), "rule__KRoundedRectangle__CornerWidthAssignment_2_0_1");
					put(grammarAccess.getKRoundedRectangleAccess().getCornerHeightAssignment_2_0_3(), "rule__KRoundedRectangle__CornerHeightAssignment_2_0_3");
					put(grammarAccess.getKRoundedRectangleAccess().getCornerHeightAssignment_2_1_1(), "rule__KRoundedRectangle__CornerHeightAssignment_2_1_1");
					put(grammarAccess.getKRoundedRectangleAccess().getCornerWidthAssignment_2_1_3(), "rule__KRoundedRectangle__CornerWidthAssignment_2_1_3");
					put(grammarAccess.getKRoundedRectangleAccess().getStylesAssignment_3_2(), "rule__KRoundedRectangle__StylesAssignment_3_2");
					put(grammarAccess.getKRoundedRectangleAccess().getStylesAssignment_3_3_1(), "rule__KRoundedRectangle__StylesAssignment_3_3_1");
					put(grammarAccess.getKRoundedRectangleAccess().getPlacementDataAssignment_4_2(), "rule__KRoundedRectangle__PlacementDataAssignment_4_2");
					put(grammarAccess.getKRoundedRectangleAccess().getChildPlacementAssignment_5_2(), "rule__KRoundedRectangle__ChildPlacementAssignment_5_2");
					put(grammarAccess.getKRoundedRectangleAccess().getChildrenAssignment_6_2(), "rule__KRoundedRectangle__ChildrenAssignment_6_2");
					put(grammarAccess.getKRoundedRectangleAccess().getChildrenAssignment_6_3_1(), "rule__KRoundedRectangle__ChildrenAssignment_6_3_1");
					put(grammarAccess.getKPolyline_ImplAccess().getStylesAssignment_3_2(), "rule__KPolyline_Impl__StylesAssignment_3_2");
					put(grammarAccess.getKPolyline_ImplAccess().getStylesAssignment_3_3_1(), "rule__KPolyline_Impl__StylesAssignment_3_3_1");
					put(grammarAccess.getKPolyline_ImplAccess().getPlacementDataAssignment_4_2(), "rule__KPolyline_Impl__PlacementDataAssignment_4_2");
					put(grammarAccess.getKPolyline_ImplAccess().getChildPlacementAssignment_5_2(), "rule__KPolyline_Impl__ChildPlacementAssignment_5_2");
					put(grammarAccess.getKPolyline_ImplAccess().getChildrenAssignment_6_2(), "rule__KPolyline_Impl__ChildrenAssignment_6_2");
					put(grammarAccess.getKPolyline_ImplAccess().getChildrenAssignment_6_3_1(), "rule__KPolyline_Impl__ChildrenAssignment_6_3_1");
					put(grammarAccess.getKPolygonAccess().getStylesAssignment_3_2(), "rule__KPolygon__StylesAssignment_3_2");
					put(grammarAccess.getKPolygonAccess().getStylesAssignment_3_3_1(), "rule__KPolygon__StylesAssignment_3_3_1");
					put(grammarAccess.getKPolygonAccess().getPlacementDataAssignment_4_2(), "rule__KPolygon__PlacementDataAssignment_4_2");
					put(grammarAccess.getKPolygonAccess().getChildPlacementAssignment_5_2(), "rule__KPolygon__ChildPlacementAssignment_5_2");
					put(grammarAccess.getKPolygonAccess().getChildrenAssignment_6_2(), "rule__KPolygon__ChildrenAssignment_6_2");
					put(grammarAccess.getKPolygonAccess().getChildrenAssignment_6_3_1(), "rule__KPolygon__ChildrenAssignment_6_3_1");
					put(grammarAccess.getKImageAccess().getBundleNameAssignment_3(), "rule__KImage__BundleNameAssignment_3");
					put(grammarAccess.getKImageAccess().getImagePathAssignment_5(), "rule__KImage__ImagePathAssignment_5");
					put(grammarAccess.getKImageAccess().getReferencesAssignment_6_2(), "rule__KImage__ReferencesAssignment_6_2");
					put(grammarAccess.getKImageAccess().getReferencesAssignment_6_3_1(), "rule__KImage__ReferencesAssignment_6_3_1");
					put(grammarAccess.getKImageAccess().getPlacementDataAssignment_7_1(), "rule__KImage__PlacementDataAssignment_7_1");
					put(grammarAccess.getKImageAccess().getStylesAssignment_8_2(), "rule__KImage__StylesAssignment_8_2");
					put(grammarAccess.getKImageAccess().getStylesAssignment_8_3_1(), "rule__KImage__StylesAssignment_8_3_1");
					put(grammarAccess.getKImageAccess().getChildrenAssignment_9_2(), "rule__KImage__ChildrenAssignment_9_2");
					put(grammarAccess.getKImageAccess().getChildrenAssignment_9_3_1(), "rule__KImage__ChildrenAssignment_9_3_1");
					put(grammarAccess.getKImageAccess().getChildPlacementAssignment_10_1(), "rule__KImage__ChildPlacementAssignment_10_1");
					put(grammarAccess.getKArcAccess().getStartAngleAssignment_3_1(), "rule__KArc__StartAngleAssignment_3_1");
					put(grammarAccess.getKArcAccess().getArcAngleAssignment_4_1(), "rule__KArc__ArcAngleAssignment_4_1");
					put(grammarAccess.getKArcAccess().getReferencesAssignment_5_2(), "rule__KArc__ReferencesAssignment_5_2");
					put(grammarAccess.getKArcAccess().getReferencesAssignment_5_3_1(), "rule__KArc__ReferencesAssignment_5_3_1");
					put(grammarAccess.getKArcAccess().getPlacementDataAssignment_6_1(), "rule__KArc__PlacementDataAssignment_6_1");
					put(grammarAccess.getKArcAccess().getStylesAssignment_7_2(), "rule__KArc__StylesAssignment_7_2");
					put(grammarAccess.getKArcAccess().getStylesAssignment_7_3_1(), "rule__KArc__StylesAssignment_7_3_1");
					put(grammarAccess.getKArcAccess().getChildrenAssignment_8_2(), "rule__KArc__ChildrenAssignment_8_2");
					put(grammarAccess.getKArcAccess().getChildrenAssignment_8_3_1(), "rule__KArc__ChildrenAssignment_8_3_1");
					put(grammarAccess.getKArcAccess().getChildPlacementAssignment_9_1(), "rule__KArc__ChildPlacementAssignment_9_1");
					put(grammarAccess.getKChildAreaAccess().getReferencesAssignment_3_2(), "rule__KChildArea__ReferencesAssignment_3_2");
					put(grammarAccess.getKChildAreaAccess().getReferencesAssignment_3_3_1(), "rule__KChildArea__ReferencesAssignment_3_3_1");
					put(grammarAccess.getKChildAreaAccess().getPlacementDataAssignment_4_1(), "rule__KChildArea__PlacementDataAssignment_4_1");
					put(grammarAccess.getKChildAreaAccess().getStylesAssignment_5_2(), "rule__KChildArea__StylesAssignment_5_2");
					put(grammarAccess.getKChildAreaAccess().getStylesAssignment_5_3_1(), "rule__KChildArea__StylesAssignment_5_3_1");
					put(grammarAccess.getKTextAccess().getClipAssignment_0(), "rule__KText__ClipAssignment_0");
					put(grammarAccess.getKTextAccess().getTextAssignment_3_1(), "rule__KText__TextAssignment_3_1");
					put(grammarAccess.getKTextAccess().getReferencesAssignment_4_2(), "rule__KText__ReferencesAssignment_4_2");
					put(grammarAccess.getKTextAccess().getReferencesAssignment_4_3_1(), "rule__KText__ReferencesAssignment_4_3_1");
					put(grammarAccess.getKTextAccess().getPlacementDataAssignment_5_1(), "rule__KText__PlacementDataAssignment_5_1");
					put(grammarAccess.getKTextAccess().getStylesAssignment_6_2(), "rule__KText__StylesAssignment_6_2");
					put(grammarAccess.getKTextAccess().getStylesAssignment_6_3_1(), "rule__KText__StylesAssignment_6_3_1");
					put(grammarAccess.getKTextAccess().getChildrenAssignment_7_2(), "rule__KText__ChildrenAssignment_7_2");
					put(grammarAccess.getKTextAccess().getChildrenAssignment_7_3_1(), "rule__KText__ChildrenAssignment_7_3_1");
					put(grammarAccess.getKTextAccess().getChildPlacementAssignment_8_1(), "rule__KText__ChildPlacementAssignment_8_1");
					put(grammarAccess.getKCustomRenderingAccess().getClassNameAssignment_3(), "rule__KCustomRendering__ClassNameAssignment_3");
					put(grammarAccess.getKCustomRenderingAccess().getBundleNameAssignment_5(), "rule__KCustomRendering__BundleNameAssignment_5");
					put(grammarAccess.getKCustomRenderingAccess().getReferencesAssignment_6_2(), "rule__KCustomRendering__ReferencesAssignment_6_2");
					put(grammarAccess.getKCustomRenderingAccess().getReferencesAssignment_6_3_1(), "rule__KCustomRendering__ReferencesAssignment_6_3_1");
					put(grammarAccess.getKCustomRenderingAccess().getPlacementDataAssignment_7_1(), "rule__KCustomRendering__PlacementDataAssignment_7_1");
					put(grammarAccess.getKCustomRenderingAccess().getStylesAssignment_8_2(), "rule__KCustomRendering__StylesAssignment_8_2");
					put(grammarAccess.getKCustomRenderingAccess().getStylesAssignment_8_3_1(), "rule__KCustomRendering__StylesAssignment_8_3_1");
					put(grammarAccess.getKCustomRenderingAccess().getChildrenAssignment_9_2(), "rule__KCustomRendering__ChildrenAssignment_9_2");
					put(grammarAccess.getKCustomRenderingAccess().getChildrenAssignment_9_3_1(), "rule__KCustomRendering__ChildrenAssignment_9_3_1");
					put(grammarAccess.getKCustomRenderingAccess().getChildPlacementAssignment_10_1(), "rule__KCustomRendering__ChildPlacementAssignment_10_1");
					put(grammarAccess.getKSplineAccess().getReferencesAssignment_3_2(), "rule__KSpline__ReferencesAssignment_3_2");
					put(grammarAccess.getKSplineAccess().getReferencesAssignment_3_3_1(), "rule__KSpline__ReferencesAssignment_3_3_1");
					put(grammarAccess.getKSplineAccess().getPlacementDataAssignment_4_1(), "rule__KSpline__PlacementDataAssignment_4_1");
					put(grammarAccess.getKSplineAccess().getStylesAssignment_5_2(), "rule__KSpline__StylesAssignment_5_2");
					put(grammarAccess.getKSplineAccess().getStylesAssignment_5_3_1(), "rule__KSpline__StylesAssignment_5_3_1");
					put(grammarAccess.getKSplineAccess().getChildrenAssignment_6_2(), "rule__KSpline__ChildrenAssignment_6_2");
					put(grammarAccess.getKSplineAccess().getChildrenAssignment_6_3_1(), "rule__KSpline__ChildrenAssignment_6_3_1");
					put(grammarAccess.getKSplineAccess().getChildPlacementAssignment_7_1(), "rule__KSpline__ChildPlacementAssignment_7_1");
					put(grammarAccess.getKDecoratorPlacementDataAccess().getRelativeAssignment_0(), "rule__KDecoratorPlacementData__RelativeAssignment_0");
					put(grammarAccess.getKDecoratorPlacementDataAccess().getLocationAssignment_4(), "rule__KDecoratorPlacementData__LocationAssignment_4");
					put(grammarAccess.getKDecoratorPlacementDataAccess().getXOffsetAssignment_5_1(), "rule__KDecoratorPlacementData__XOffsetAssignment_5_1");
					put(grammarAccess.getKDecoratorPlacementDataAccess().getYOffsetAssignment_6_1(), "rule__KDecoratorPlacementData__YOffsetAssignment_6_1");
					put(grammarAccess.getKGridPlacementDataAccess().getWidthHintAssignment_3(), "rule__KGridPlacementData__WidthHintAssignment_3");
					put(grammarAccess.getKGridPlacementDataAccess().getHeightHintAssignment_5(), "rule__KGridPlacementData__HeightHintAssignment_5");
					put(grammarAccess.getKGridPlacementDataAccess().getHorizontalIndentAssignment_7(), "rule__KGridPlacementData__HorizontalIndentAssignment_7");
					put(grammarAccess.getKGridPlacementDataAccess().getVerticalIndentAssignment_9(), "rule__KGridPlacementData__VerticalIndentAssignment_9");
					put(grammarAccess.getKStackPlacementDataAccess().getInsetRightAssignment_3(), "rule__KStackPlacementData__InsetRightAssignment_3");
					put(grammarAccess.getKStackPlacementDataAccess().getInsetBottomAssignment_5(), "rule__KStackPlacementData__InsetBottomAssignment_5");
					put(grammarAccess.getKStackPlacementDataAccess().getInsetLeftAssignment_7(), "rule__KStackPlacementData__InsetLeftAssignment_7");
					put(grammarAccess.getKStackPlacementDataAccess().getInsetTopAssignment_9(), "rule__KStackPlacementData__InsetTopAssignment_9");
					put(grammarAccess.getKDirectPlacementDataAccess().getTopLeftAssignment_3(), "rule__KDirectPlacementData__TopLeftAssignment_3");
					put(grammarAccess.getKDirectPlacementDataAccess().getBottomRightAssignment_5(), "rule__KDirectPlacementData__BottomRightAssignment_5");
					put(grammarAccess.getKPolylinePlacementDataAccess().getPointsAssignment_2(), "rule__KPolylinePlacementData__PointsAssignment_2");
					put(grammarAccess.getKPolylinePlacementDataAccess().getPointsAssignment_3_1(), "rule__KPolylinePlacementData__PointsAssignment_3_1");
					put(grammarAccess.getKPositionAccess().getXAssignment_3(), "rule__KPosition__XAssignment_3");
					put(grammarAccess.getKPositionAccess().getYAssignment_5(), "rule__KPosition__YAssignment_5");
					put(grammarAccess.getKLeftPositionAccess().getAbsoluteAssignment_3_1(), "rule__KLeftPosition__AbsoluteAssignment_3_1");
					put(grammarAccess.getKLeftPositionAccess().getRelativeAssignment_4_1(), "rule__KLeftPosition__RelativeAssignment_4_1");
					put(grammarAccess.getKRightPositionAccess().getAbsoluteAssignment_3_1(), "rule__KRightPosition__AbsoluteAssignment_3_1");
					put(grammarAccess.getKRightPositionAccess().getRelativeAssignment_4_1(), "rule__KRightPosition__RelativeAssignment_4_1");
					put(grammarAccess.getKTopPositionAccess().getAbsoluteAssignment_3_1(), "rule__KTopPosition__AbsoluteAssignment_3_1");
					put(grammarAccess.getKTopPositionAccess().getRelativeAssignment_4_1(), "rule__KTopPosition__RelativeAssignment_4_1");
					put(grammarAccess.getKBottomPositionAccess().getAbsoluteAssignment_3_1(), "rule__KBottomPosition__AbsoluteAssignment_3_1");
					put(grammarAccess.getKBottomPositionAccess().getRelativeAssignment_4_1(), "rule__KBottomPosition__RelativeAssignment_4_1");
					put(grammarAccess.getKForegroundColorAccess().getPropagateToChildrenAssignment_3(), "rule__KForegroundColor__PropagateToChildrenAssignment_3");
					put(grammarAccess.getKForegroundColorAccess().getRedAssignment_4_1(), "rule__KForegroundColor__RedAssignment_4_1");
					put(grammarAccess.getKForegroundColorAccess().getGreenAssignment_5_1(), "rule__KForegroundColor__GreenAssignment_5_1");
					put(grammarAccess.getKForegroundColorAccess().getBlueAssignment_6_1(), "rule__KForegroundColor__BlueAssignment_6_1");
					put(grammarAccess.getKBackgroundColorAccess().getPropagateToChildrenAssignment_3(), "rule__KBackgroundColor__PropagateToChildrenAssignment_3");
					put(grammarAccess.getKBackgroundColorAccess().getRedAssignment_4_1(), "rule__KBackgroundColor__RedAssignment_4_1");
					put(grammarAccess.getKBackgroundColorAccess().getGreenAssignment_5_1(), "rule__KBackgroundColor__GreenAssignment_5_1");
					put(grammarAccess.getKBackgroundColorAccess().getBlueAssignment_6_1(), "rule__KBackgroundColor__BlueAssignment_6_1");
					put(grammarAccess.getKLineWidthAccess().getLineWidthAssignment_1(), "rule__KLineWidth__LineWidthAssignment_1");
					put(grammarAccess.getKLineWidthAccess().getPropagateToChildrenAssignment_2(), "rule__KLineWidth__PropagateToChildrenAssignment_2");
					put(grammarAccess.getKVisibilityAccess().getLineVisibleAssignment_2(), "rule__KVisibility__LineVisibleAssignment_2");
					put(grammarAccess.getKVisibilityAccess().getFilledAssignment_3(), "rule__KVisibility__FilledAssignment_3");
					put(grammarAccess.getKVisibilityAccess().getPropagateToChildrenAssignment_4(), "rule__KVisibility__PropagateToChildrenAssignment_4");
					put(grammarAccess.getKLineStyleAccess().getLineStyleAssignment_2(), "rule__KLineStyle__LineStyleAssignment_2");
					put(grammarAccess.getKLineStyleAccess().getPropagateToChildrenAssignment_3(), "rule__KLineStyle__PropagateToChildrenAssignment_3");
					put(grammarAccess.getKVerticalAlignmentAccess().getVerticalAlignmentAssignment_1(), "rule__KVerticalAlignment__VerticalAlignmentAssignment_1");
					put(grammarAccess.getKVerticalAlignmentAccess().getPropagateToChildrenAssignment_2(), "rule__KVerticalAlignment__PropagateToChildrenAssignment_2");
					put(grammarAccess.getKHorizontalAlignmentAccess().getHorizontalAlignmentAssignment_1(), "rule__KHorizontalAlignment__HorizontalAlignmentAssignment_1");
					put(grammarAccess.getKHorizontalAlignmentAccess().getPropagateToChildrenAssignment_2(), "rule__KHorizontalAlignment__PropagateToChildrenAssignment_2");
					put(grammarAccess.getKGridPlacementAccess().getNumColumnsAssignment_2(), "rule__KGridPlacement__NumColumnsAssignment_2");
					put(grammarAccess.getKShapeLayoutAccess().getXposAssignment_3_1(), "rule__KShapeLayout__XposAssignment_3_1");
					put(grammarAccess.getKShapeLayoutAccess().getYposAssignment_4_1(), "rule__KShapeLayout__YposAssignment_4_1");
					put(grammarAccess.getKShapeLayoutAccess().getWidthAssignment_5_1(), "rule__KShapeLayout__WidthAssignment_5_1");
					put(grammarAccess.getKShapeLayoutAccess().getHeightAssignment_6_1(), "rule__KShapeLayout__HeightAssignment_6_1");
					put(grammarAccess.getKShapeLayoutAccess().getInsetsAssignment_7_1(), "rule__KShapeLayout__InsetsAssignment_7_1");
					put(grammarAccess.getKShapeLayoutAccess().getPersistentEntriesAssignment_8_2(), "rule__KShapeLayout__PersistentEntriesAssignment_8_2");
					put(grammarAccess.getKShapeLayoutAccess().getPersistentEntriesAssignment_8_3_1(), "rule__KShapeLayout__PersistentEntriesAssignment_8_3_1");
					put(grammarAccess.getKInsetsAccess().getTopAssignment_3_1(), "rule__KInsets__TopAssignment_3_1");
					put(grammarAccess.getKInsetsAccess().getBottomAssignment_4_1(), "rule__KInsets__BottomAssignment_4_1");
					put(grammarAccess.getKInsetsAccess().getLeftAssignment_5_1(), "rule__KInsets__LeftAssignment_5_1");
					put(grammarAccess.getKInsetsAccess().getRightAssignment_6_1(), "rule__KInsets__RightAssignment_6_1");
					put(grammarAccess.getKEdgeLayoutAccess().getSourcePointAssignment_3(), "rule__KEdgeLayout__SourcePointAssignment_3");
					put(grammarAccess.getKEdgeLayoutAccess().getTargetPointAssignment_5(), "rule__KEdgeLayout__TargetPointAssignment_5");
					put(grammarAccess.getKEdgeLayoutAccess().getBendPointsAssignment_6_2(), "rule__KEdgeLayout__BendPointsAssignment_6_2");
					put(grammarAccess.getKEdgeLayoutAccess().getBendPointsAssignment_6_3_1(), "rule__KEdgeLayout__BendPointsAssignment_6_3_1");
					put(grammarAccess.getKEdgeLayoutAccess().getPersistentEntriesAssignment_7_2(), "rule__KEdgeLayout__PersistentEntriesAssignment_7_2");
					put(grammarAccess.getKEdgeLayoutAccess().getPersistentEntriesAssignment_7_3_1(), "rule__KEdgeLayout__PersistentEntriesAssignment_7_3_1");
					put(grammarAccess.getKPointAccess().getXAssignment_2_1(), "rule__KPoint__XAssignment_2_1");
					put(grammarAccess.getKPointAccess().getYAssignment_3_1(), "rule__KPoint__YAssignment_3_1");
					put(grammarAccess.getPersistentEntryAccess().getKeyAssignment_0(), "rule__PersistentEntry__KeyAssignment_0");
					put(grammarAccess.getPersistentEntryAccess().getValueAssignment_1_1(), "rule__PersistentEntry__ValueAssignment_1_1");
				}
			};
		}
		return nameMappings.get(element);
	}
	
	@Override
	protected Collection<FollowElement> getFollowElements(AbstractInternalContentAssistParser parser) {
		try {
			de.cau.cs.kieler.core.krendering.text.ui.contentassist.antlr.internal.InternalKRenderingParser typedParser = (de.cau.cs.kieler.core.krendering.text.ui.contentassist.antlr.internal.InternalKRenderingParser) parser;
			typedParser.entryRuleKRenderingLibrary();
			return typedParser.getFollowElements();
		} catch(RecognitionException ex) {
			throw new RuntimeException(ex);
		}		
	}
	
	@Override
	protected String[] getInitialHiddenTokens() {
		return new String[] { "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT" };
	}
	
	public KRenderingGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}
	
	public void setGrammarAccess(KRenderingGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}
