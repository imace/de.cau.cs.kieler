package edu.unikiel.rtsys.kieler.kiml.ui.helpers;

import java.util.ArrayList;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.CompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.StringValueStyle;

import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.LAYOUT_TYPE;

/**
 * Holds various static functions useful when working with layout hints. A
 * <b>layout hint</b> for an element comprises the <b>layout type</b> (e.g.
 * horizontal) and the <b>layout group</b> (a String).
 * 
 * @author <a href="mailto:ars@informatik.uni-kiel.de">Arne Schipper</a>
 * 
 */
public class KimlGMFLayoutHintHelper {

	/**
	 * Constant for layout group, used to indicate that a ShapeNodeEdit part
	 * does not belong to any group
	 */
	public static final String NOT_GROUPED = "Not grouped";
	public static final String LAYOUT_TYPE_STYLE = "layoutType";
	public static final String LAYOUT_GROUP_STYLE = "layoutGroup";
	public static final String LAYOUTER_NAME_STYLE = "layouterName";

	/**
	 * Returns the layouter name for this ShapeNodeEditPart, is a plain String.
	 * 
	 * @param shapeNodeEditPart
	 *            the ShapeNodeEditPart to retrieve the layout type for
	 * @return the layouter name
	 */
	public static String getLayouterName(GraphicalEditPart shapeNodeEditPart) {

		StringValueStyle layouterNameStyle = (StringValueStyle) (shapeNodeEditPart
				.getNotationView().getNamedStyle(NotationPackage.eINSTANCE
				.getStringValueStyle(), LAYOUTER_NAME_STYLE));

		// if property not available, return empty string
		if (layouterNameStyle == null) {
			return "";
			// return stored model/notation value
		} else {
			return layouterNameStyle.getStringValue();
		}
	}

	/**
	 * Convenient function to set the layouter name for group of
	 * ShapeNodeEditParts
	 * 
	 * @param shapeNodeEditParts
	 *            the ShapeNodeEditsParts as a typed ArrayList
	 * @param layouterName
	 *            the name of a layouter which should render these EditParts
	 * @see KimlGMFLayoutHintHelper#setLayoutHint(ShapeNodeEditPart, String)
	 */
	public static void setLayouterName(
			ArrayList<? extends GraphicalEditPart> GraphicalEditParts,
			String layouterName) {
		for (GraphicalEditPart snep : GraphicalEditParts) {
			setLayouterName(snep, layouterName);
		}
	}

	/**
	 * Convenient function to set the layouter name for a group of
	 * GraphicalEditParts.
	 * 
	 * @param GraphicalEditParts
	 *            the ShapeNodeEditsParts as a simple array
	 * @param layouterName
	 *            the name of a layouter which should render these EditParts
	 * @see KimlGMFLayoutHintHelper#setlayoutType(GraphicalEditPart, String)
	 */
	public static void setLayouterName(GraphicalEditPart[] GraphicalEditParts,
			String layouterName) {
		for (GraphicalEditPart snep : GraphicalEditParts) {
			setLayouterName(snep, layouterName);
		}
	}

	/**
	 * Wrapper function to set the layouter name of a graphicalEditPart. This
	 * function should always be called together with
	 * <code>setLayoutGroup</code> and <code>setLayoutType</code> to keep the
	 * information consistent.
	 * 
	 * @param GraphicalEditPart
	 *            the GraphicalEditPart to set the layout type for
	 * @param layouterName
	 *            he name of a layouter which should render these EditParts
	 * @see KimlGMFLayoutHintHelper#setLayoutGroup(GraphicalEditPart, String)
	 */
	public static void setLayouterName(
			final GraphicalEditPart graphicalEditPart, final String layouterName) {

		// see if there is already an layouterNameStyle
		final StringValueStyle layoutTypeStyle = (StringValueStyle) (graphicalEditPart
				.getNotationView().getNamedStyle(NotationPackage.eINSTANCE
				.getStringValueStyle(), LAYOUTER_NAME_STYLE));

		// no: -> create a new one and save it
		if (layoutTypeStyle == null) {
			final StringValueStyle newlayouterNameStyle = NotationFactory.eINSTANCE
					.createStringValueStyle();
			newlayouterNameStyle.setName(LAYOUTER_NAME_STYLE);
			newlayouterNameStyle.setStringValue(layouterName);
			graphicalEditPart.getEditingDomain().getCommandStack().execute(
					new RecordingCommand(graphicalEditPart.getEditingDomain()) {
						protected void doExecute() {
							graphicalEditPart.getNotationView().getStyles()
									.add(newlayouterNameStyle);
						}
					});

			// yes: -> save the new value
		} else {
			graphicalEditPart.getEditingDomain().getCommandStack().execute(
					new RecordingCommand(graphicalEditPart.getEditingDomain()) {
						protected void doExecute() {
							((StringValueStyle) (graphicalEditPart
									.getNotationView().getNamedStyle(
									NotationPackage.eINSTANCE
											.getStringValueStyle(),
									LAYOUTER_NAME_STYLE)))
									.setStringValue(layouterName);
						}
					});
		}
	}

	/**
	 * Returns the name of the layout hint for this GraphicalEditPart, is a
	 * constant declared in KimlLayoutHintConstants, and will be
	 * <code>KimlLayoutHintConstants.NONE</code>, if this GraphicalEditPart does
	 * not have a hint yet or if the hint was invalid
	 * 
	 * @param GraphicalEditPart
	 *            the GraphicalEditPart to retrieve the layout type for
	 * @return the layoutType if available, or
	 *         <code>KimlLayoutHintConstants.NONE</code> if not
	 */
	public static LAYOUT_TYPE getLayoutType(GraphicalEditPart graphicalEditPart) {

		StringValueStyle layoutTypeStyle = (StringValueStyle) (graphicalEditPart
				.getNotationView().getNamedStyle(NotationPackage.eINSTANCE
				.getStringValueStyle(), LAYOUT_TYPE_STYLE));

		// if property not available, return default value
		if (layoutTypeStyle == null) {
			return LAYOUT_TYPE.DEFAULT;
			// return stored model/notation value
		} else {
			if (LAYOUT_TYPE.getByName(layoutTypeStyle.getStringValue()) != null)
				return LAYOUT_TYPE.getByName(layoutTypeStyle.getStringValue());
			else
				return LAYOUT_TYPE.DEFAULT;
		}
	}

	/**
	 * Convenient function to set the layout hint of a group of
	 * GraphicalEditParts
	 * 
	 * @param GraphicalEditParts
	 *            the ShapeNodeEditsParts as a typed ArrayList
	 * @param hintID
	 *            the string value of the hint, must be a constant declared in
	 *            KimlLayoutHintConstants.layoutTypes
	 * @see KimlGMFLayoutHintHelper#setLayoutHint(GraphicalEditPart, String)
	 * @see KimlLayoutHintConstants#layoutTypes
	 */
	public static void setLayoutType(
			ArrayList<? extends GraphicalEditPart> GraphicalEditParts,
			LAYOUT_TYPE layoutType) {
		for (GraphicalEditPart snep : GraphicalEditParts) {
			setLayoutType(snep, layoutType);
		}
	}

	/**
	 * Convenient function to set the layout type of a group of
	 * GraphicalEditParts.
	 * 
	 * @param GraphicalEditParts
	 *            the ShapeNodeEditsParts as a simple array
	 * @param layoutType
	 *            the string value of the type, must be a constant declared in
	 *            KimlLayoutHintConstants.layoutTypes
	 * @see KimlGMFLayoutHintHelper#setlayoutType(GraphicalEditPart, String)
	 * @see KimlLayoutHintConstants#layoutTypes
	 */
	public static void setLayoutType(GraphicalEditPart[] GraphicalEditParts,
			LAYOUT_TYPE layoutType) {
		for (GraphicalEditPart snep : GraphicalEditParts) {
			setLayoutType(snep, layoutType);
		}
	}

	/**
	 * Wrapper function to set the layout type of a graphicalEditPart. This
	 * function should always be called together with
	 * <code>setLayoutGroup</code> to keep the information consistent.
	 * 
	 * @param GraphicalEditPart
	 *            the GraphicalEditPart to set the layout type for
	 * @param layoutType
	 *            a string identifying the constant of the layout type for this
	 *            GraphicalEditPart
	 * @see KimlGMFLayoutHintHelper#setLayoutGroup(GraphicalEditPart, String)
	 * @see KimlLayoutHintConstants#layoutTypes
	 */
	public static void setLayoutType(final GraphicalEditPart graphicalEditPart,
			final LAYOUT_TYPE layoutType) {

		// see if there is already an layoutTypeStyle
		final StringValueStyle layoutTypeStyle = (StringValueStyle) (graphicalEditPart
				.getNotationView().getNamedStyle(NotationPackage.eINSTANCE
				.getStringValueStyle(), LAYOUT_TYPE_STYLE));

		// no: -> create a new one and save it
		if (layoutTypeStyle == null) {
			final StringValueStyle newlayoutTypeStyle = NotationFactory.eINSTANCE
					.createStringValueStyle();
			newlayoutTypeStyle.setName(LAYOUT_TYPE_STYLE);
			newlayoutTypeStyle.setStringValue(layoutType.getName());
			graphicalEditPart.getEditingDomain().getCommandStack().execute(
					new RecordingCommand(graphicalEditPart.getEditingDomain()) {
						protected void doExecute() {
							graphicalEditPart.getNotationView().getStyles()
									.add(newlayoutTypeStyle);
						}
					});

			// yes: -> save the new value
		} else {
			graphicalEditPart.getEditingDomain().getCommandStack().execute(
					new RecordingCommand(graphicalEditPart.getEditingDomain()) {
						protected void doExecute() {
							((StringValueStyle) (graphicalEditPart
									.getNotationView().getNamedStyle(
									NotationPackage.eINSTANCE
											.getStringValueStyle(),
									LAYOUT_TYPE_STYLE)))
									.setStringValue(layoutType.getName());
						}
					});
		}
	}

	/**
	 * Returns the layout group for this graphicalEditPart. If this
	 * GraphicalEditPart is not grouped, the Constant
	 * <code>KimlLayoutHintConstants.NOT_GROUPED</code> will be returned
	 * 
	 * @param GraphicalEditPart
	 *            the GraphicalEditPart to retrieve the layout group for
	 * @return the name of the layout group, if the element is grouped, the
	 *         Constant KimlLayoutHintConstants.NOT_GROUPED else
	 * @see KimlLayoutHintConstants#NOT_GROUPED
	 */
	public static String getLayoutGroup(
			final GraphicalEditPart graphicalEditPart) {
		StringValueStyle layoutGroupStyle = (StringValueStyle) (graphicalEditPart
				.getNotationView().getNamedStyle(NotationPackage.eINSTANCE
				.getStringValueStyle(), LAYOUT_GROUP_STYLE));
		if (layoutGroupStyle == null)
			return NOT_GROUPED;
		else
			return layoutGroupStyle.getStringValue();
	}

	/**
	 * Convenient function to set the layout group of a group of
	 * GraphicalEditParts.
	 * 
	 * @param GraphicalEditParts
	 *            the GraphicalEditParts to set the layout group for
	 * @param groupID
	 *            a unique groupID for the GraphicalEditParts
	 * @see KimlGMFLayoutHintHelper#setLayoutGroup(GraphicalEditPart, String)
	 */
	public static void setLayoutGroup(
			ArrayList<? extends GraphicalEditPart> GraphicalEditParts,
			String groupID) {
		for (GraphicalEditPart snep : GraphicalEditParts) {
			setLayoutGroup(snep, groupID);
		}
	}

	/**
	 * Convenient function to set the layout group of a group of
	 * GraphicalEditParts.
	 * 
	 * @param GraphicalEditParts
	 *            the GraphicalEditParts to set the layout group for
	 * @param groupID
	 *            a unique groupID for the GraphicalEditParts
	 * @see KimlGMFLayoutHintHelper#setLayoutGroup(GraphicalEditPart, String)
	 */
	public static void setLayoutGroup(GraphicalEditPart[] GraphicalEditParts,
			String groupID) {
		for (GraphicalEditPart snep : GraphicalEditParts) {
			setLayoutGroup(snep, groupID);
		}
	}

	/**
	 * Wrapper function to set the layout group of a graphicalEditPart. This
	 * function should always be called together with <code>setlayoutType</code>
	 * to keep the information consistent.
	 * 
	 * @param GraphicalEditPart
	 *            the GraphicalEditPart to set the layout group for
	 * @param groupID
	 *            a string identifying the name of the group this
	 *            GraphicalEditPart belongs to
	 * @see KimlGMFLayoutHintHelper#setlayoutType(GraphicalEditPart, String)
	 * @see KimlLayoutHintConstants#layoutTypes
	 */
	public static void setLayoutGroup(
			final GraphicalEditPart graphicalEditPart, final String groupID) {

		final StringValueStyle oldLayoutGroupStyle = (StringValueStyle) (graphicalEditPart
				.getNotationView().getNamedStyle(NotationPackage.eINSTANCE
				.getStringValueStyle(), LAYOUT_GROUP_STYLE));

		// no: -> create a new one and save it
		if (oldLayoutGroupStyle == null) {
			final StringValueStyle newLayoutGroupStyle = NotationFactory.eINSTANCE
					.createStringValueStyle();
			newLayoutGroupStyle.setName(LAYOUT_GROUP_STYLE);
			newLayoutGroupStyle.setStringValue(groupID);
			graphicalEditPart.getEditingDomain().getCommandStack().execute(
					new RecordingCommand(graphicalEditPart.getEditingDomain()) {
						protected void doExecute() {
							graphicalEditPart.getNotationView().getStyles()
									.add(newLayoutGroupStyle);
						}
					});

			// yes: -> save the new value
		} else {
			graphicalEditPart.getEditingDomain().getCommandStack().execute(
					new RecordingCommand(graphicalEditPart.getEditingDomain()) {
						protected void doExecute() {
							((StringValueStyle) (graphicalEditPart
									.getNotationView().getNamedStyle(
									NotationPackage.eINSTANCE
											.getStringValueStyle(),
									LAYOUT_GROUP_STYLE)))
									.setStringValue(groupID);
						}
					});
		}
	}

	public static void setLayoutHint(
			final GraphicalEditPart[] GraphicalEditParts, final String groupID,
			final LAYOUT_TYPE layoutType, final String layouterName) {
		setLayoutGroup(GraphicalEditParts, groupID);
		setLayoutType(GraphicalEditParts, layoutType);
		setLayouterName(GraphicalEditParts, layouterName);
	}

	public static void setLayoutHint(
			final ArrayList<? extends GraphicalEditPart> GraphicalEditParts,
			final String groupID, final LAYOUT_TYPE layoutType,
			final String layouterName) {
		setLayoutGroup(GraphicalEditParts, groupID);
		setLayoutType(GraphicalEditParts, layoutType);
		setLayouterName(GraphicalEditParts, layouterName);
	}

	public static void setChildrenLayoutHint(
			final GraphicalEditPart graphicalEditPart, final String groupID,
			final LAYOUT_TYPE layoutType, final String layouterName) {

		for (Object level1 : graphicalEditPart.getChildren()) {
			if (level1 instanceof CompartmentEditPart) {
				for (Object level2 : ((CompartmentEditPart) level1)
						.getChildren()) {
					if (level2 instanceof GraphicalEditPart) {
						GraphicalEditPart childEditPart = (GraphicalEditPart) level2;
						setLayoutGroup(childEditPart, groupID);
						setLayoutType(childEditPart, layoutType);
						setLayouterName(childEditPart, layouterName);
					}
				}
			}
		}
	}

	/**
	 * Wrapper function to set the layout <b>hint</b> of a an array of
	 * GraphicalEditParts. The layout hint is composed of the layout group and
	 * the layout type for this group
	 * 
	 * @param GraphicalEditParts
	 *            the array of GraphicalEditParts to set the layout type for
	 * @param groupID
	 *            a string identifying the name of the group this
	 *            GraphicalEditPart belongs to
	 * @param layoutType
	 *            a string identifying the constant of the layout type for this
	 *            GraphicalEditPart
	 * @see KimlGMFLayoutHintHelper#setLayoutGroup(GraphicalEditPart, String)
	 * @see KimlGMFLayoutHintHelper#setLayoutType(GraphicalEditPart, String)
	 * @see KimlLayoutHintConstants#layoutTypes
	 */
	public static void setLayoutHint(
			final GraphicalEditPart[] GraphicalEditParts, final String groupID,
			final LAYOUT_TYPE layoutType) {
		setLayoutGroup(GraphicalEditParts, groupID);
		setLayoutType(GraphicalEditParts, layoutType);
	}

	/**
	 * Wrapper function to set the layout <b>hint</b> of a an typed ArrayList of
	 * GraphicalEditParts. The layout hint is composed of the layout group and
	 * the layout type for this group
	 * 
	 * @param GraphicalEditParts
	 *            the ArrayList of GraphicalEditParts to set the layout type for
	 * @param groupID
	 *            a string identifying the name of the group this
	 *            GraphicalEditPart belongs to
	 * @param layoutType
	 *            a string identifying the constant of the layout type for this
	 *            GraphicalEditPart
	 * @see KimlGMFLayoutHintHelper#setLayoutGroup(GraphicalEditPart, String)
	 * @see KimlGMFLayoutHintHelper#setLayoutType(GraphicalEditPart, String)
	 * @see KimlLayoutHintConstants#layoutTypes
	 */
	public static void setLayoutHint(
			final ArrayList<? extends GraphicalEditPart> GraphicalEditParts,
			final String groupID, final LAYOUT_TYPE layoutType) {
		setLayoutGroup(GraphicalEditParts, groupID);
		setLayoutType(GraphicalEditParts, layoutType);
	}

	/**
	 * Wrapper function to set the layout <b>hint</b> of a graphicalEditPart.
	 * The layout hint is composed of the layout group and the layout type for
	 * this group
	 * 
	 * @param GraphicalEditPart
	 *            the GraphicalEditPart to set the layout type for
	 * @param groupID
	 *            a string identifying the name of the group this
	 *            GraphicalEditPart belongs to
	 * @param layoutType
	 *            a string identifying the constant of the layout type for this
	 *            GraphicalEditPart
	 * @see KimlGMFLayoutHintHelper#setLayoutGroup(GraphicalEditPart, String)
	 * @see KimlGMFLayoutHintHelper#setLayoutType(GraphicalEditPart, String)
	 * @see KimlLayoutHintConstants#layoutTypes
	 */
	public static void setLayoutHint(final GraphicalEditPart graphicalEditPart,
			final String groupID, final LAYOUT_TYPE layoutType) {
		setLayoutGroup(graphicalEditPart, groupID);
		setLayoutType(graphicalEditPart, layoutType);
	}

	/**
	 * Wrapper function to unset the layout <b>hint</b> of a an array of
	 * GraphicalEditParts.
	 * 
	 * @param GraphicalEditParts
	 *            the array of GraphicalEditParts to unset the layout type for
	 * @see KimlGMFLayoutHintHelper#unsetLayouthint(GraphicalEditPart)
	 */
	public static void unsetLayoutHint(
			final GraphicalEditPart[] GraphicalEditParts) {
		for (GraphicalEditPart snep : GraphicalEditParts) {
			unsetLayoutHint(snep);
		}
	}

	/**
	 * Wrapper function to unset the layout <b>hint</b> of a an typed ArrayList
	 * of GraphicalEditParts.
	 * 
	 * TODO: If, after removing the selected element from a group, there is just
	 * one element left, also remove the grouping information thereof.
	 * 
	 * @param GraphicalEditParts
	 *            the ArrayList of GraphicalEditParts to unset the layout type
	 *            for
	 * 
	 * @see KimlGMFLayoutHintHelper#unsetLayouthint(GraphicalEditPart)
	 */
	public static void unsetLayoutHint(
			final ArrayList<? extends GraphicalEditPart> GraphicalEditParts) {
		for (GraphicalEditPart snep : GraphicalEditParts) {
			unsetLayoutHint(snep);
		}
	}

	/**
	 * Wrapper function to unset the layout <b>hint</b> of a graphicalEditPart.
	 * 
	 * @param GraphicalEditPart
	 *            the GraphicalEditPart to unset the layout type for
	 */
	public static void unsetLayoutHint(final GraphicalEditPart graphicalEditPart) {

		final StringValueStyle layoutGroupStyle = (StringValueStyle) (graphicalEditPart
				.getNotationView().getNamedStyle(NotationPackage.eINSTANCE
				.getStringValueStyle(), LAYOUT_GROUP_STYLE));

		final StringValueStyle layouterNameStyle = (StringValueStyle) (graphicalEditPart
				.getNotationView().getNamedStyle(NotationPackage.eINSTANCE
				.getStringValueStyle(), LAYOUTER_NAME_STYLE));

		final StringValueStyle layoutTypeStyle = (StringValueStyle) (graphicalEditPart
				.getNotationView().getNamedStyle(NotationPackage.eINSTANCE
				.getStringValueStyle(), LAYOUT_TYPE_STYLE));

		if (layoutGroupStyle != null) {
			String groupID = layoutGroupStyle.getStringValue();

			/*
			 * assuming each GraphicalEditParts has at most one of each of those
			 * styles
			 */
			graphicalEditPart.getEditingDomain().getCommandStack().execute(
					new RecordingCommand(graphicalEditPart.getEditingDomain()) {
						protected void doExecute() {
							graphicalEditPart.getNotationView().getStyles()
									.remove(layoutGroupStyle);
							graphicalEditPart.getNotationView().getStyles()
									.remove(layouterNameStyle);
							graphicalEditPart.getNotationView().getStyles()
									.remove(layoutTypeStyle);
						}
					});

			/*
			 * Iterate through the list of saved groupID to perform the actual
			 * orphaned check. Emma need to get the container edit part to
			 * iterate through the children of this. Check also, if there is
			 * such a container element.
			 */
			Object parent = graphicalEditPart.getParent();
			if (parent != null && parent instanceof CompartmentEditPart) {
				CompartmentEditPart compartmentEditPart = (CompartmentEditPart) parent;
				// fetch all remaining elements of the group
				ArrayList<? extends GraphicalEditPart> groupedParts = KimlGMFLayoutHintHelper
						.getGroupMembersByGroupID(compartmentEditPart, groupID);
				// if just 1 element left, remove all grouping information
				if (groupedParts.size() == 1) {
					// call this function recursively, but this will just happen
					// to
					// a depth of 1
					unsetLayoutHint(groupedParts.get(0));
				}
			}
		}
	}

	/**
	 * Returns all the GraphicalEditParts which belong to the same group as the
	 * argument. If there are no other GraphicalEditParts, or the argument
	 * itself does not belong to any group, the ArrayList will be empty, but
	 * nevertheless initialized. The argument itself will <B>be</b> included in
	 * the returned list, <b>if</b> the element is grouped.
	 * 
	 * @param GraphicalEditPart
	 *            the GraphicalEditPart of which the layout group members should
	 *            be returned
	 * @return an ArrayList of the GraphicalEditParts belonging to this group,
	 *         the argument itself will <b>be</b>in this group, empty list if
	 *         not grouped
	 */
	public static ArrayList<GraphicalEditPart> getGroupMembersByElement(
			GraphicalEditPart graphicalEditPart) {

		ArrayList<GraphicalEditPart> groupMembers = new ArrayList<GraphicalEditPart>();

		String layoutGroupToFind = KimlGMFLayoutHintHelper
				.getLayoutGroup(graphicalEditPart);

		if (layoutGroupToFind == NOT_GROUPED) {
			return groupMembers;
		} else {
			for (Object element : graphicalEditPart.getParent().getChildren()) {
				if (element != null
						&& element instanceof GraphicalEditPart
						&& KimlGMFLayoutHintHelper.getLayoutGroup(
								(GraphicalEditPart) element).equals(
								layoutGroupToFind)) {
					groupMembers.add((GraphicalEditPart) element);
				}
			}
			return groupMembers;
		}
	}

	/**
	 * Returns all the GraphicalEditParts which belong to the specified group
	 * 
	 * @param compartmentEditPart
	 *            the container CompartmentEditPart in which the
	 *            GraphicalEditParts belonging to a group should be retrieved
	 * @param groupID
	 *            GraphicalEditPart of which the layout group members should be
	 *            returned
	 * @return an ArrayList of the GraphicalEditParts belonging to this group
	 */
	public static ArrayList<GraphicalEditPart> getGroupMembersByGroupID(
			CompartmentEditPart compartmentEditPart, String groupID) {

		ArrayList<GraphicalEditPart> groupMembers = new ArrayList<GraphicalEditPart>();

		for (Object element : compartmentEditPart.getChildren()) {
			if (element != null
					&& element instanceof GraphicalEditPart
					&& KimlGMFLayoutHintHelper.getLayoutGroup(
							(GraphicalEditPart) element).equals(groupID)) {
				groupMembers.add((GraphicalEditPart) element);
			}
		}
		return groupMembers;

	}

	/**
	 * Generates and returns a unique ID which should be used as an identifier
	 * for a layout group
	 * 
	 * @param GraphicalEditParts
	 *            an ArrayList of GraphicalEditParts
	 * @return a unique id serving as a group identifier for the selected
	 *         GraphicalEditParts
	 * @see KimlGMFLayoutHintHelper#generateLayoutGroupID(ArrayList, String)
	 */
	public static String generateLayoutGroupID(
			ArrayList<? extends GraphicalEditPart> graphicalEditParts) {
		return generateLayoutGroupID(graphicalEditParts, "");
	}

	/**
	 * Generates and returns a unique ID which should be used as an identifier
	 * for a layout group
	 * 
	 * @param GraphicalEditParts
	 *            an ArrayList of GraphicalEditParts
	 * @param suggestion
	 *            a String which can be used to generate a more readable groupID
	 * @return a unique id serving as a group identifier for the selected
	 *         GraphicalEditParts, will be <code>suggestion</code> if it was
	 *         unique, a generated ID else
	 */
	public static String generateLayoutGroupID(
			ArrayList<? extends GraphicalEditPart> graphicalEditParts,
			String suggestion) {
		if (suggestion == null || suggestion == "") {
			return Integer.toString(graphicalEditParts.hashCode());
		}
		// TODO: check if suggestion is unique within notation model
		else
			return suggestion;
	}

}
