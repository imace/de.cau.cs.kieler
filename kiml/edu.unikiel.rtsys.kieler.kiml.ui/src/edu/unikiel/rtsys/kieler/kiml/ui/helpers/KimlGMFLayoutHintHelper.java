package edu.unikiel.rtsys.kieler.kiml.ui.helpers;

import java.util.ArrayList;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.CompartmentEditPart;
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
	public static String getLayouterName(ShapeNodeEditPart shapeNodeEditPart) {

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
			ArrayList<ShapeNodeEditPart> shapeNodeEditParts, String layouterName) {
		for (ShapeNodeEditPart snep : shapeNodeEditParts) {
			setLayouterName(snep, layouterName);
		}
	}

	/**
	 * Convenient function to set the layouter name for a group of
	 * ShapeNodeEditParts.
	 * 
	 * @param shapeNodeEditParts
	 *            the ShapeNodeEditsParts as a simple array
	 * @param layouterName
	 *            the name of a layouter which should render these EditParts
	 * @see KimlGMFLayoutHintHelper#setlayoutType(ShapeNodeEditPart, String)
	 */
	public static void setLayouterName(ShapeNodeEditPart[] shapeNodeEditParts,
			String layouterName) {
		for (ShapeNodeEditPart snep : shapeNodeEditParts) {
			setLayouterName(snep, layouterName);
		}
	}

	/**
	 * Wrapper function to set the layouter name of a ShapeNodeEditPart. This
	 * function should always be called together with
	 * <code>setLayoutGroup</code> and <code>setLayoutType</code> to keep the
	 * information consistent.
	 * 
	 * @param shapeNodeEditPart
	 *            the ShapeNodeEditPart to set the layout type for
	 * @param layouterName
	 *            he name of a layouter which should render these EditParts
	 * @see KimlGMFLayoutHintHelper#setLayoutGroup(ShapeNodeEditPart, String)
	 */
	public static void setLayouterName(
			final ShapeNodeEditPart shapeNodeEditPart, final String layouterName) {

		// see if there is already an layouterNameStyle
		final StringValueStyle layoutTypeStyle = (StringValueStyle) (shapeNodeEditPart
				.getNotationView().getNamedStyle(NotationPackage.eINSTANCE
				.getStringValueStyle(), LAYOUTER_NAME_STYLE));

		// no: -> create a new one and save it
		if (layoutTypeStyle == null) {
			final StringValueStyle newlayouterNameStyle = NotationFactory.eINSTANCE
					.createStringValueStyle();
			newlayouterNameStyle.setName(LAYOUTER_NAME_STYLE);
			newlayouterNameStyle.setStringValue(layouterName);
			shapeNodeEditPart.getEditingDomain().getCommandStack().execute(
					new RecordingCommand(shapeNodeEditPart.getEditingDomain()) {
						protected void doExecute() {
							shapeNodeEditPart.getNotationView().getStyles()
									.add(newlayouterNameStyle);
						}
					});

			// yes: -> save the new value
		} else {
			shapeNodeEditPart.getEditingDomain().getCommandStack().execute(
					new RecordingCommand(shapeNodeEditPart.getEditingDomain()) {
						protected void doExecute() {
							((StringValueStyle) (shapeNodeEditPart
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
	 * Returns the name of the layout hint for this ShapeNodeEditPart, is a
	 * constant declared in KimlLayoutHintConstants, and will be
	 * <code>KimlLayoutHintConstants.NONE</code>, if this ShapeNodeEditPart does
	 * not have a hint yet or if the hint was invalid
	 * 
	 * @param shapeNodeEditPart
	 *            the ShapeNodeEditPart to retrieve the layout type for
	 * @return the layoutType if available, or
	 *         <code>KimlLayoutHintConstants.NONE</code> if not
	 */
	public static LAYOUT_TYPE getLayoutType(ShapeNodeEditPart shapeNodeEditPart) {

		StringValueStyle layoutTypeStyle = (StringValueStyle) (shapeNodeEditPart
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
	 * ShapeNodeEditParts
	 * 
	 * @param shapeNodeEditParts
	 *            the ShapeNodeEditsParts as a typed ArrayList
	 * @param hintID
	 *            the string value of the hint, must be a constant declared in
	 *            KimlLayoutHintConstants.layoutTypes
	 * @see KimlGMFLayoutHintHelper#setLayoutHint(ShapeNodeEditPart, String)
	 * @see KimlLayoutHintConstants#layoutTypes
	 */
	public static void setLayoutType(
			ArrayList<ShapeNodeEditPart> shapeNodeEditParts,
			LAYOUT_TYPE layoutType) {
		for (ShapeNodeEditPart snep : shapeNodeEditParts) {
			setLayoutType(snep, layoutType);
		}
	}

	/**
	 * Convenient function to set the layout type of a group of
	 * ShapeNodeEditParts.
	 * 
	 * @param shapeNodeEditParts
	 *            the ShapeNodeEditsParts as a simple array
	 * @param layoutType
	 *            the string value of the type, must be a constant declared in
	 *            KimlLayoutHintConstants.layoutTypes
	 * @see KimlGMFLayoutHintHelper#setlayoutType(ShapeNodeEditPart, String)
	 * @see KimlLayoutHintConstants#layoutTypes
	 */
	public static void setLayoutType(ShapeNodeEditPart[] shapeNodeEditParts,
			LAYOUT_TYPE layoutType) {
		for (ShapeNodeEditPart snep : shapeNodeEditParts) {
			setLayoutType(snep, layoutType);
		}
	}

	/**
	 * Wrapper function to set the layout type of a ShapeNodeEditPart. This
	 * function should always be called together with
	 * <code>setLayoutGroup</code> to keep the information consistent.
	 * 
	 * @param shapeNodeEditPart
	 *            the ShapeNodeEditPart to set the layout type for
	 * @param layoutType
	 *            a string identifying the constant of the layout type for this
	 *            ShapeNodeEditPart
	 * @see KimlGMFLayoutHintHelper#setLayoutGroup(ShapeNodeEditPart, String)
	 * @see KimlLayoutHintConstants#layoutTypes
	 */
	public static void setLayoutType(final ShapeNodeEditPart shapeNodeEditPart,
			final LAYOUT_TYPE layoutType) {

		// see if there is already an layoutTypeStyle
		final StringValueStyle layoutTypeStyle = (StringValueStyle) (shapeNodeEditPart
				.getNotationView().getNamedStyle(NotationPackage.eINSTANCE
				.getStringValueStyle(), LAYOUT_TYPE_STYLE));

		// no: -> create a new one and save it
		if (layoutTypeStyle == null) {
			final StringValueStyle newlayoutTypeStyle = NotationFactory.eINSTANCE
					.createStringValueStyle();
			newlayoutTypeStyle.setName(LAYOUT_TYPE_STYLE);
			newlayoutTypeStyle.setStringValue(layoutType.getName());
			shapeNodeEditPart.getEditingDomain().getCommandStack().execute(
					new RecordingCommand(shapeNodeEditPart.getEditingDomain()) {
						protected void doExecute() {
							shapeNodeEditPart.getNotationView().getStyles()
									.add(newlayoutTypeStyle);
						}
					});

			// yes: -> save the new value
		} else {
			shapeNodeEditPart.getEditingDomain().getCommandStack().execute(
					new RecordingCommand(shapeNodeEditPart.getEditingDomain()) {
						protected void doExecute() {
							((StringValueStyle) (shapeNodeEditPart
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
	 * Returns the layout group for this ShapeNodeEditPart. If this
	 * ShapeNodeEditPart is not grouped, the Constant
	 * <code>KimlLayoutHintConstants.NOT_GROUPED</code> will be returned
	 * 
	 * @param shapeNodeEditPart
	 *            the ShapeNodeEditPart to retrieve the layout group for
	 * @return the name of the layout group, if the element is grouped, the
	 *         Constant KimlLayoutHintConstants.NOT_GROUPED else
	 * @see KimlLayoutHintConstants#NOT_GROUPED
	 */
	public static String getLayoutGroup(
			final ShapeNodeEditPart shapeNodeEditPart) {
		StringValueStyle layoutGroupStyle = (StringValueStyle) (shapeNodeEditPart
				.getNotationView().getNamedStyle(NotationPackage.eINSTANCE
				.getStringValueStyle(), LAYOUT_GROUP_STYLE));
		if (layoutGroupStyle == null)
			return NOT_GROUPED;
		else
			return layoutGroupStyle.getStringValue();
	}

	/**
	 * Convenient function to set the layout group of a group of
	 * ShapeNodeEditParts.
	 * 
	 * @param shapeNodeEditParts
	 *            the ShapeNodeEditParts to set the layout group for
	 * @param groupID
	 *            a unique groupID for the ShapeNodeEditParts
	 * @see KimlGMFLayoutHintHelper#setLayoutGroup(ShapeNodeEditPart, String)
	 */
	public static void setLayoutGroup(
			ArrayList<ShapeNodeEditPart> shapeNodeEditParts, String groupID) {
		for (ShapeNodeEditPart snep : shapeNodeEditParts) {
			setLayoutGroup(snep, groupID);
		}
	}

	/**
	 * Convenient function to set the layout group of a group of
	 * ShapeNodeEditParts.
	 * 
	 * @param shapeNodeEditParts
	 *            the ShapeNodeEditParts to set the layout group for
	 * @param groupID
	 *            a unique groupID for the ShapeNodeEditParts
	 * @see KimlGMFLayoutHintHelper#setLayoutGroup(ShapeNodeEditPart, String)
	 */
	public static void setLayoutGroup(ShapeNodeEditPart[] shapeNodeEditParts,
			String groupID) {
		for (ShapeNodeEditPart snep : shapeNodeEditParts) {
			setLayoutGroup(snep, groupID);
		}
	}

	/**
	 * Wrapper function to set the layout group of a ShapeNodeEditPart. This
	 * function should always be called together with <code>setlayoutType</code>
	 * to keep the information consistent.
	 * 
	 * @param shapeNodeEditPart
	 *            the ShapeNodeEditPart to set the layout group for
	 * @param groupID
	 *            a string identifying the name of the group this
	 *            ShapeNodeEditPart belongs to
	 * @see KimlGMFLayoutHintHelper#setlayoutType(ShapeNodeEditPart, String)
	 * @see KimlLayoutHintConstants#layoutTypes
	 */
	public static void setLayoutGroup(
			final ShapeNodeEditPart shapeNodeEditPart, final String groupID) {

		final StringValueStyle oldLayoutGroupStyle = (StringValueStyle) (shapeNodeEditPart
				.getNotationView().getNamedStyle(NotationPackage.eINSTANCE
				.getStringValueStyle(), LAYOUT_GROUP_STYLE));

		// no: -> create a new one and save it
		if (oldLayoutGroupStyle == null) {
			final StringValueStyle newLayoutGroupStyle = NotationFactory.eINSTANCE
					.createStringValueStyle();
			newLayoutGroupStyle.setName(LAYOUT_GROUP_STYLE);
			newLayoutGroupStyle.setStringValue(groupID);
			shapeNodeEditPart.getEditingDomain().getCommandStack().execute(
					new RecordingCommand(shapeNodeEditPart.getEditingDomain()) {
						protected void doExecute() {
							shapeNodeEditPart.getNotationView().getStyles()
									.add(newLayoutGroupStyle);
						}
					});

			// yes: -> save the new value
		} else {
			shapeNodeEditPart.getEditingDomain().getCommandStack().execute(
					new RecordingCommand(shapeNodeEditPart.getEditingDomain()) {
						protected void doExecute() {
							((StringValueStyle) (shapeNodeEditPart
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
			final ShapeNodeEditPart[] shapeNodeEditParts, final String groupID,
			final LAYOUT_TYPE layoutType, final String layouterName) {
		setLayoutGroup(shapeNodeEditParts, groupID);
		setLayoutType(shapeNodeEditParts, layoutType);
		setLayouterName(shapeNodeEditParts, layouterName);
	}

	public static void setLayoutHint(
			final ArrayList<ShapeNodeEditPart> shapeNodeEditParts,
			final String groupID, final LAYOUT_TYPE layoutType,
			final String layouterName) {
		setLayoutGroup(shapeNodeEditParts, groupID);
		setLayoutType(shapeNodeEditParts, layoutType);
		setLayouterName(shapeNodeEditParts, layouterName);
	}

	/**
	 * Wrapper function to set the layout <b>hint</b> of a an array of
	 * ShapeNodeEditParts. The layout hint is composed of the layout group and
	 * the layout type for this group
	 * 
	 * @param shapeNodeEditParts
	 *            the array of ShapeNodeEditParts to set the layout type for
	 * @param groupID
	 *            a string identifying the name of the group this
	 *            ShapeNodeEditPart belongs to
	 * @param layoutType
	 *            a string identifying the constant of the layout type for this
	 *            ShapeNodeEditPart
	 * @see KimlGMFLayoutHintHelper#setLayoutGroup(ShapeNodeEditPart, String)
	 * @see KimlGMFLayoutHintHelper#setLayoutType(ShapeNodeEditPart, String)
	 * @see KimlLayoutHintConstants#layoutTypes
	 */
	public static void setLayoutHint(
			final ShapeNodeEditPart[] shapeNodeEditParts, final String groupID,
			final LAYOUT_TYPE layoutType) {
		setLayoutGroup(shapeNodeEditParts, groupID);
		setLayoutType(shapeNodeEditParts, layoutType);
	}

	/**
	 * Wrapper function to set the layout <b>hint</b> of a an typed ArrayList of
	 * ShapeNodeEditParts. The layout hint is composed of the layout group and
	 * the layout type for this group
	 * 
	 * @param shapeNodeEditParts
	 *            the ArrayList of ShapeNodeEditParts to set the layout type for
	 * @param groupID
	 *            a string identifying the name of the group this
	 *            ShapeNodeEditPart belongs to
	 * @param layoutType
	 *            a string identifying the constant of the layout type for this
	 *            ShapeNodeEditPart
	 * @see KimlGMFLayoutHintHelper#setLayoutGroup(ShapeNodeEditPart, String)
	 * @see KimlGMFLayoutHintHelper#setLayoutType(ShapeNodeEditPart, String)
	 * @see KimlLayoutHintConstants#layoutTypes
	 */
	public static void setLayoutHint(
			final ArrayList<ShapeNodeEditPart> shapeNodeEditParts,
			final String groupID, final LAYOUT_TYPE layoutType) {
		setLayoutGroup(shapeNodeEditParts, groupID);
		setLayoutType(shapeNodeEditParts, layoutType);
	}

	/**
	 * Wrapper function to set the layout <b>hint</b> of a ShapeNodeEditPart.
	 * The layout hint is composed of the layout group and the layout type for
	 * this group
	 * 
	 * @param shapeNodeEditPart
	 *            the ShapeNodeEditPart to set the layout type for
	 * @param groupID
	 *            a string identifying the name of the group this
	 *            ShapeNodeEditPart belongs to
	 * @param layoutType
	 *            a string identifying the constant of the layout type for this
	 *            ShapeNodeEditPart
	 * @see KimlGMFLayoutHintHelper#setLayoutGroup(ShapeNodeEditPart, String)
	 * @see KimlGMFLayoutHintHelper#setLayoutType(ShapeNodeEditPart, String)
	 * @see KimlLayoutHintConstants#layoutTypes
	 */
	public static void setLayoutHint(final ShapeNodeEditPart shapeNodeEditPart,
			final String groupID, final LAYOUT_TYPE layoutType) {
		setLayoutGroup(shapeNodeEditPart, groupID);
		setLayoutType(shapeNodeEditPart, layoutType);
	}

	/**
	 * Wrapper function to unset the layout <b>hint</b> of a an array of
	 * ShapeNodeEditParts.
	 * 
	 * @param shapeNodeEditParts
	 *            the array of ShapeNodeEditParts to unset the layout type for
	 * @see KimlGMFLayoutHintHelper#unsetLayouthint(ShapeNodeEditPart)
	 */
	public static void unsetLayoutHint(
			final ShapeNodeEditPart[] shapeNodeEditParts) {
		for (ShapeNodeEditPart snep : shapeNodeEditParts) {
			unsetLayoutHint(snep);
		}
	}

	/**
	 * Wrapper function to unset the layout <b>hint</b> of a an typed ArrayList
	 * of ShapeNodeEditParts.
	 * 
	 * TODO: If, after removing the selected element from a group, there is just
	 * one element left, also remove the grouping information thereof.
	 * 
	 * @param shapeNodeEditParts
	 *            the ArrayList of ShapeNodeEditParts to unset the layout type
	 *            for
	 * 
	 * @see KimlGMFLayoutHintHelper#unsetLayouthint(ShapeNodeEditPart)
	 */
	public static void unsetLayoutHint(
			final ArrayList<ShapeNodeEditPart> shapeNodeEditParts) {
		for (ShapeNodeEditPart snep : shapeNodeEditParts) {
			unsetLayoutHint(snep);
		}
	}

	/**
	 * Wrapper function to unset the layout <b>hint</b> of a ShapeNodeEditPart.
	 * 
	 * @param shapeNodeEditPart
	 *            the ShapeNodeEditPart to unset the layout type for
	 */
	public static void unsetLayoutHint(final ShapeNodeEditPart shapeNodeEditPart) {

		final StringValueStyle layoutGroupStyle = (StringValueStyle) (shapeNodeEditPart
				.getNotationView().getNamedStyle(NotationPackage.eINSTANCE
				.getStringValueStyle(), LAYOUT_GROUP_STYLE));

		final StringValueStyle layouterNameStyle = (StringValueStyle) (shapeNodeEditPart
				.getNotationView().getNamedStyle(NotationPackage.eINSTANCE
				.getStringValueStyle(), LAYOUTER_NAME_STYLE));

		final StringValueStyle layoutTypeStyle = (StringValueStyle) (shapeNodeEditPart
				.getNotationView().getNamedStyle(NotationPackage.eINSTANCE
				.getStringValueStyle(), LAYOUT_TYPE_STYLE));

		if (layoutGroupStyle != null) {
			String groupID = layoutGroupStyle.getStringValue();

			/*
			 * assuming each ShapeNodeEditParts has at most one of each of those
			 * styles
			 */
			shapeNodeEditPart.getEditingDomain().getCommandStack().execute(
					new RecordingCommand(shapeNodeEditPart.getEditingDomain()) {
						protected void doExecute() {
							shapeNodeEditPart.getNotationView().getStyles()
									.remove(layoutGroupStyle);
							shapeNodeEditPart.getNotationView().getStyles()
									.remove(layouterNameStyle);
							shapeNodeEditPart.getNotationView().getStyles()
									.remove(layoutTypeStyle);
						}
					});

			/*
			 * Iterate through the list of saved groupID to perform the actual
			 * orphaned check. Emma need to get the container edit part to
			 * iterate through the children of this. Check also, if there is
			 * such a container element.
			 */
			EditPart parent = shapeNodeEditPart.getParent();
			if (parent != null && parent instanceof CompartmentEditPart) {
				CompartmentEditPart compartmentEditPart = (CompartmentEditPart) parent;
				// fetch all remaining elements of the group
				ArrayList<ShapeNodeEditPart> groupedParts = KimlGMFLayoutHintHelper
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
	 * Returns all the ShapeNodeEditParts which belong to the same group as the
	 * argument. If there are no other ShapeNodeEditParts, or the argument
	 * itself does not belong to any group, the ArrayList will be empty, but
	 * nevertheless initialized. The argument itself will <B>be</b> included in
	 * the returned list, <b>if</b> the element is grouped.
	 * 
	 * @param shapeNodeEditPart
	 *            the ShapeNodeEditPart of which the layout group members should
	 *            be returned
	 * @return an ArrayList of the ShapeNodeEditParts belonging to this group,
	 *         the argument itself will <b>be</b>in this group, empty list if
	 *         not grouped
	 */
	public static ArrayList<ShapeNodeEditPart> getGroupMembersByElement(
			ShapeNodeEditPart shapeNodeEditPart) {
		ArrayList<ShapeNodeEditPart> groupMembers = new ArrayList<ShapeNodeEditPart>();

		String layoutGroupToFind = KimlGMFLayoutHintHelper
				.getLayoutGroup(shapeNodeEditPart);

		if (layoutGroupToFind == NOT_GROUPED) {
			return groupMembers;
		} else {
			for (Object element : shapeNodeEditPart.getParent().getChildren()) {
				if (element != null
						&& element instanceof ShapeNodeEditPart
						&& KimlGMFLayoutHintHelper.getLayoutGroup(
								(ShapeNodeEditPart) element).equals(
								layoutGroupToFind)) {
					groupMembers.add((ShapeNodeEditPart) element);
				}
			}
			return groupMembers;
		}
	}

	/**
	 * Returns all the ShapeNodeEditParts which belong to the specified group
	 * 
	 * @param compartmentEditPart
	 *            the container CompartmentEditPart in which the
	 *            ShapeNodeEditParts belonging to a group should be retrieved
	 * @param groupID
	 *            ShapeNodeEditPart of which the layout group members should be
	 *            returned
	 * @return an ArrayList of the ShapeNodeEditParts belonging to this group
	 */
	public static ArrayList<ShapeNodeEditPart> getGroupMembersByGroupID(
			CompartmentEditPart compartmentEditPart, String groupID) {
		ArrayList<ShapeNodeEditPart> groupMembers = new ArrayList<ShapeNodeEditPart>();

		for (Object element : compartmentEditPart.getChildren()) {
			if (element != null
					&& element instanceof ShapeNodeEditPart
					&& KimlGMFLayoutHintHelper.getLayoutGroup(
							(ShapeNodeEditPart) element).equals(groupID)) {
				groupMembers.add((ShapeNodeEditPart) element);
			}
		}
		return groupMembers;

	}

	/**
	 * Generates and returns a unique ID which should be used as an identifier
	 * for a layout group
	 * 
	 * @param shapeNodeEditParts
	 *            an ArrayList of ShapeNodeEditParts
	 * @return a unique id serving as a group identifier for the selected
	 *         ShapeNodeEditParts
	 * @see KimlGMFLayoutHintHelper#generateLayoutGroupID(ArrayList, String)
	 */
	public static String generateLayoutGroupID(
			ArrayList<ShapeNodeEditPart> shapeNodeEditParts) {
		return generateLayoutGroupID(shapeNodeEditParts, "");
	}

	/**
	 * Generates and returns a unique ID which should be used as an identifier
	 * for a layout group
	 * 
	 * @param shapeNodeEditParts
	 *            an ArrayList of ShapeNodeEditParts
	 * @param suggestion
	 *            a String which can be used to generate a more readable groupID
	 * @return a unique id serving as a group identifier for the selected
	 *         ShapeNodeEditParts, will be <code>suggestion</code> if it was
	 *         unique, a generated ID else
	 */
	public static String generateLayoutGroupID(
			ArrayList<ShapeNodeEditPart> shapeNodeEditParts, String suggestion) {
		if (suggestion == null || suggestion == "") {
			return Integer.toString(shapeNodeEditParts.hashCode());
		}
		// TODO: check if suggestion is unique within notation model
		else
			return suggestion;
	}

	public static String buildGroupAsMessage(String layoutType,
			String layouterName, String groupID, int numbersGrouped) {
		return "Group as " + layouterName + " was executed:\n" + numbersGrouped
				+ " Nodes have been grouped with the layouter " + layouterName
				+ "(type: " + layoutType + ") and with the groupId " + groupID
				+ ".";
	}
}
