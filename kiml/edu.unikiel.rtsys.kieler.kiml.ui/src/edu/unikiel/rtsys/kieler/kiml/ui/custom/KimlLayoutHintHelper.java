package edu.unikiel.rtsys.kieler.kiml.ui.custom;

import java.util.ArrayList;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.CompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.StringValueStyle;

import edu.unikiel.rtsys.kieler.kiml.ui.KimlLayoutHintConstants;

/**
 * Holds various static function useful when working with layout hints. A
 * <b>layout hint</b> for an element comprises the <b>layout type</b> (e.g.
 * horizontal) and the <b>layout group</b> (a String).
 * 
 * @author Arne Schipper <a href="mailto:ars@informatik.uni-kiel.de">
 * 
 */
public class KimlLayoutHintHelper {

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
	public static String getLayoutType(ShapeNodeEditPart shapeNodeEditPart) {
		StringValueStyle layoutTypeStyle = (StringValueStyle) (shapeNodeEditPart
				.getNotationView().getNamedStyle(NotationPackage.eINSTANCE
				.getStringValueStyle(), KimlLayoutHintConstants.LAYOUT_TYPE));

		// if property not available, return default value (NOT_GROUPED)
		if (layoutTypeStyle == null)
			return KimlLayoutHintConstants.NONE;
		// return stored model/notation value
		else {
			// see if the value is equal to one of the constants
			int i = KimlLayoutHintConstants.layoutTypes.length - 1;
			while (!layoutTypeStyle.getStringValue().equals(
					KimlLayoutHintConstants.layoutTypes[i])
					&& i > 0)
				--i;
			// not equal: -> return default
			if (i == 0)
				return KimlLayoutHintConstants.NONE;
			// equal to one entry: -> return this
			else
				return KimlLayoutHintConstants.layoutTypes[i];
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
	 * @see KimlLayoutHintHelper#setLayoutHint(ShapeNodeEditPart, String)
	 * @see KimlLayoutHintConstants#layoutTypes
	 */
	public static void setLayoutType(
			ArrayList<ShapeNodeEditPart> shapeNodeEditParts, String layoutType) {
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
	 * @see KimlLayoutHintHelper#setlayoutType(ShapeNodeEditPart, String)
	 * @see KimlLayoutHintConstants#layoutTypes
	 */
	public static void setLayoutType(ShapeNodeEditPart[] shapeNodeEditParts,
			String layoutType) {
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
	 * @see KimlLayoutHintHelper#setLayoutGroup(ShapeNodeEditPart, String)
	 * @see KimlLayoutHintConstants#layoutTypes
	 */
	public static void setLayoutType(final ShapeNodeEditPart shapeNodeEditPart,
			final String layoutType) {

		// see if the value is equal to one of the constants
		int i = KimlLayoutHintConstants.layoutTypes.length - 1;
		while (!layoutType.equals(KimlLayoutHintConstants.layoutTypes[i])
				&& i > 0)
			--i;
		// input not equal to one of the constants: -> do nothing
		if (i == 0)
			return;

		// see if there is already an layoutTypeStyle
		final StringValueStyle layoutTypeStyle = (StringValueStyle) (shapeNodeEditPart
				.getNotationView().getNamedStyle(NotationPackage.eINSTANCE
				.getStringValueStyle(), KimlLayoutHintConstants.LAYOUT_TYPE));

		// no: -> create a new one and save it
		if (layoutTypeStyle == null) {
			final StringValueStyle newlayoutTypeStyle = NotationFactory.eINSTANCE
					.createStringValueStyle();
			newlayoutTypeStyle.setName(KimlLayoutHintConstants.LAYOUT_TYPE);
			newlayoutTypeStyle.setStringValue(layoutType);
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
									KimlLayoutHintConstants.LAYOUT_TYPE)))
									.setStringValue(layoutType);
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
				.getStringValueStyle(), KimlLayoutHintConstants.LAYOUT_GROUP));
		if (layoutGroupStyle == null)
			return KimlLayoutHintConstants.NOT_GROUPED;
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
	 * @see KimlLayoutHintHelper#setLayoutGroup(ShapeNodeEditPart, String)
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
	 * @see KimlLayoutHintHelper#setLayoutGroup(ShapeNodeEditPart, String)
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
	 * @see KimlLayoutHintHelper#setlayoutType(ShapeNodeEditPart, String)
	 * @see KimlLayoutHintConstants#layoutTypes
	 */
	public static void setLayoutGroup(
			final ShapeNodeEditPart shapeNodeEditPart, final String groupID) {

		final StringValueStyle oldLayoutGroupStyle = (StringValueStyle) (shapeNodeEditPart
				.getNotationView().getNamedStyle(NotationPackage.eINSTANCE
				.getStringValueStyle(), KimlLayoutHintConstants.LAYOUT_GROUP));

		// no: -> create a new one and save it
		if (oldLayoutGroupStyle == null) {
			final StringValueStyle newLayoutGroupStyle = NotationFactory.eINSTANCE
					.createStringValueStyle();
			newLayoutGroupStyle.setName(KimlLayoutHintConstants.LAYOUT_GROUP);
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
									KimlLayoutHintConstants.LAYOUT_GROUP)))
									.setStringValue(groupID);
						}
					});
		}
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
	 * @see KimlLayoutHintHelper#setLayoutGroup(ShapeNodeEditPart, String)
	 * @see KimlLayoutHintHelper#setLayoutType(ShapeNodeEditPart, String)
	 * @see KimlLayoutHintConstants#layoutTypes
	 */
	public static void setLayoutHint(
			final ShapeNodeEditPart[] shapeNodeEditParts, final String groupID,
			final String layoutType) {
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
	 * @see KimlLayoutHintHelper#setLayoutGroup(ShapeNodeEditPart, String)
	 * @see KimlLayoutHintHelper#setLayoutType(ShapeNodeEditPart, String)
	 * @see KimlLayoutHintConstants#layoutTypes
	 */
	public static void setLayoutHint(
			final ArrayList<ShapeNodeEditPart> shapeNodeEditParts,
			final String groupID, final String layoutType) {
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
	 * @see KimlLayoutHintHelper#setLayoutGroup(ShapeNodeEditPart, String)
	 * @see KimlLayoutHintHelper#setLayoutType(ShapeNodeEditPart, String)
	 * @see KimlLayoutHintConstants#layoutTypes
	 */
	public static void setLayoutHint(final ShapeNodeEditPart shapeNodeEditPart,
			final String groupID, final String layoutType) {
		setLayoutGroup(shapeNodeEditPart, groupID);
		setLayoutType(shapeNodeEditPart, layoutType);
	}

	/**
	 * Wrapper function to unset the layout <b>hint</b> of a an array of
	 * ShapeNodeEditParts.
	 * 
	 * @param shapeNodeEditParts
	 *            the array of ShapeNodeEditParts to unset the layout type for
	 * @see KimlLayoutHintHelper#unsetLayouthint(ShapeNodeEditPart)
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
	 * @see KimlLayoutHintHelper#unsetLayouthint(ShapeNodeEditPart)
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
				.getStringValueStyle(), KimlLayoutHintConstants.LAYOUT_GROUP));

		final StringValueStyle layoutTypeStyle = (StringValueStyle) (shapeNodeEditPart
				.getNotationView().getNamedStyle(NotationPackage.eINSTANCE
				.getStringValueStyle(), KimlLayoutHintConstants.LAYOUT_TYPE));

		String groupID = layoutGroupStyle.getStringValue();

		/*
		 * assuming each ShapeNodeEditParts has at most one of each of those
		 * styles
		 */
		shapeNodeEditPart.getEditingDomain().getCommandStack().execute(
				new RecordingCommand(shapeNodeEditPart.getEditingDomain()) {
					protected void doExecute() {
						shapeNodeEditPart.getNotationView().getStyles().remove(
								layoutGroupStyle);
						shapeNodeEditPart.getNotationView().getStyles().remove(
								layoutTypeStyle);
					}
				});

		/*
		 * Iterate through the list of saved groupID to perform the actual
		 * orphaned check. Emma need to get the container edit part to iterate
		 * through the children of this. Check also, if there is such a
		 * container element.
		 */
		EditPart parent = shapeNodeEditPart.getParent();
		if (parent != null && parent instanceof CompartmentEditPart) {
			CompartmentEditPart compartmentEditPart = (CompartmentEditPart) parent;
			// fetch all remaining elements of the group
			ArrayList<ShapeNodeEditPart> groupedParts = KimlLayoutHintHelper
					.getGroupMembersByGroupID(compartmentEditPart, groupID);
			// if just 1 element left, remove all grouping information
			if (groupedParts.size() == 1) {
				// call this function recursively, but this will just happen to
				// a depth of 1
				unsetLayoutHint(groupedParts.get(0));
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

		String layoutGroupToFind = KimlLayoutHintHelper
				.getLayoutGroup(shapeNodeEditPart);

		if (layoutGroupToFind == KimlLayoutHintConstants.NOT_GROUPED) {
			return groupMembers;
		} else {
			for (Object element : shapeNodeEditPart.getParent().getChildren()) {
				if (element != null
						&& element instanceof ShapeNodeEditPart
						&& KimlLayoutHintHelper.getLayoutGroup(
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
					&& KimlLayoutHintHelper.getLayoutGroup(
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
	 * @see KimlLayoutHintHelper#generateLayoutGroupID(ArrayList, String)
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

	public static String buildGroupAsMessage(String layoutType, String groupID,
			int numbersGrouped) {
		return "Group as " + layoutType + " was executed:\n" + numbersGrouped
				+ " Nodes have been grouped with the type " + layoutType
				+ " and with the groupId " + groupID + ".";
	}
}
