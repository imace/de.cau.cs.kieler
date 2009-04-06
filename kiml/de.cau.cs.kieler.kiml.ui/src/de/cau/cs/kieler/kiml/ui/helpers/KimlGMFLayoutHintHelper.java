/******************************************************************************
 * KIELER - Kiel Integrated Environment for Layout for the Eclipse RCP
 *
 * http://www.informatik.uni-kiel.de/rtsys/kieler/
 * 
 * Copyright 2008 by
 * + Christian-Albrechts-University of Kiel
 *   + Department of Computer Science
 *     + Real-Time and Embedded Systems Group
 * 
 * This code is provided under the terms of the Eclipse Public License (EPL).
 * See the file epl-v10.html for the license text.
 */
package de.cau.cs.kieler.kiml.ui.helpers;

import java.util.ArrayList;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gmf.runtime.diagram.ui.editparts.CompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.StringValueStyle;

import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutType;
import de.cau.cs.kieler.kiml.layout.options.LayoutType;


/**
 * Holds various static functions useful when working with layout hints.
 * <p/>
 * There are two types of layout hints, one when all elements of a compartment
 * should be laid out as one group. This is the common case. Another possibility
 * is to lay out elements arbitrarily. Then each element must know to which
 * group it belongs. This is reflected in the two types of hints.
 * <p/>
 * All elements in a compartment are in the same group. The information on how
 * to lay out this group, that is actually how to lay out the children, is saved
 * as a StringValueStyle in the Notation Model of the compartment element:
 * <ul>
 * <li>the <b>layout type</b> (e.g. hierarchical)</li>
 * <li>the <b>layouter name</b> (e.g. GraphViz Dot)</li>
 * </ul>
 * <p/>
 * When also single element grouping should be enabled then the information must
 * be saved in each element itself. However, this is also done through a
 * StringValueStyle in the NotationModel:
 * <ul>
 * <li>the <b>layout type</b> (e.g. hierarchical)</li>
 * <li>the <b>layouter name</b> (e.g. GraphViz Dot)</li>
 * <li>the <b>layout group</b> (a String)</li>
 * </ul>
 * <p>
 * There are special functions addressing each of the cases.
 * 
 * @author <a href="mailto:ars@informatik.uni-kiel.de">Arne Schipper</a>
 */
public class KimlGMFLayoutHintHelper {

	/* Constants for the StringValueStyle treatment */
	public static final String NOT_GROUPED = "Not grouped";
	public static final String LAYOUT_TYPE_STYLE = "layoutType";
	public static final String LAYOUT_GROUP_STYLE = "layoutGroup";
	public static final String LAYOUTER_NAME_STYLE = "layouterName";
	public static final String CONTAINED_ELEMENTS_LAYOUT_TYPE_STYLE = "containedElementsLayoutType";
	public static final String CONTAINED_ELEMENTS_LAYOUTER_NAME_STYLE = "containedElementsLayouterName";

	// =======================================================================//
	// ================ GROUP EVERY SINGLE ELEMENT ===========================//
	// =======================================================================//

	/**
	 * Returns the layouter name for this GraphicalEditPart, is a plain String.
	 * 
	 * @param graphicalEditPart
	 *            the GraphicalEditPart to retrieve the layout type for
	 * @return the layouter name
	 */
	public static String getLayouterName(GraphicalEditPart graphicalEditPart) {

		StringValueStyle layouterNameStyle = (StringValueStyle) (graphicalEditPart
				.getNotationView().getNamedStyle(NotationPackage.eINSTANCE
				.getStringValueStyle(), LAYOUTER_NAME_STYLE));

		/* if property not available, return empty string */
		if (layouterNameStyle == null) {
			return "";
		}
		/* return stored model/notation value */
		else {
			return layouterNameStyle.getStringValue();
		}
	}

	/**
	 * Convenient function to set the layouter name for ArrayList of
	 * GraphicalEditParts
	 * 
	 * @param graphicalEditParts
	 *            the GraphicalEditParts as a typed ArrayList
	 * @param layouterName
	 *            the name of a layouter which should render these EditParts
	 */
	public static void setLayouterName(
			ArrayList<? extends GraphicalEditPart> GraphicalEditParts,
			String layouterName) {
		for (GraphicalEditPart snep : GraphicalEditParts) {
			setLayouterName(snep, layouterName);
		}
	}

	/**
	 * Convenient function to set the layouter name for an Array of
	 * GraphicalEditParts.
	 * 
	 * @param graphicalEditParts
	 *            the GraphicalEditParts as a simple array
	 * @param layouterName
	 *            the name of a layouter which should render these EditParts
	 */
	public static void setLayouterName(GraphicalEditPart[] GraphicalEditParts,
			String layouterName) {
		for (GraphicalEditPart snep : GraphicalEditParts) {
			setLayouterName(snep, layouterName);
		}
	}

	/**
	 * Wrapper function to set the layouter name for a graphicalEditPart. This
	 * function should always be called together with
	 * <code>setLayoutGroup</code> and <code>setLayoutType</code> to keep the
	 * information consistent.
	 * 
	 * @param GraphicalEditPart
	 *            the GraphicalEditPart to set the layout type for
	 * @param layouterName
	 *            he name of a layouter which should render these EditParts
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
	 * Returns the name of the layout hint for this GraphicalEditPart.
	 * 
	 * @param GraphicalEditPart
	 *            the GraphicalEditPart to retrieve the layout type for
	 * @return the layoutType
	 */
	public static KLayoutType getLayoutType(GraphicalEditPart graphicalEditPart) {

		StringValueStyle layoutTypeStyle = (StringValueStyle) (graphicalEditPart
				.getNotationView().getNamedStyle(NotationPackage.eINSTANCE
				.getStringValueStyle(), LAYOUT_TYPE_STYLE));

		// if property not available, return default value
		if (layoutTypeStyle == null) {
			return KLayoutType.DEFAULT;
			// return stored model/notation value
		} else {
			if (KLayoutType.getByName(layoutTypeStyle.getStringValue()) != null)
				return KLayoutType.getByName(layoutTypeStyle.getStringValue());
			else
				return KLayoutType.DEFAULT;
		}
	}

	/**
	 * Convenient function to set the layout type of a ArrayList of
	 * GraphicalEditParts
	 * 
	 * @param graphicalEditParts
	 *            the GraphicalEditParts as a typed ArrayList
	 * @param layoutType
	 *            The layoutType
	 */
	public static void setLayoutType(
			ArrayList<? extends GraphicalEditPart> GraphicalEditParts,
			KLayoutType layoutType) {
		for (GraphicalEditPart snep : GraphicalEditParts) {
			setLayoutType(snep, layoutType);
		}
	}

	/**
	 * Convenient function to set the layout type of a array of
	 * GraphicalEditParts.
	 * 
	 * @param graphicalEditParts
	 *            the GraphicalEditParts as a simple array
	 * @param layoutType
	 *            The layoutType
	 */
	public static void setLayoutType(GraphicalEditPart[] GraphicalEditParts,
			KLayoutType layoutType) {
		for (GraphicalEditPart snep : GraphicalEditParts) {
			setLayoutType(snep, layoutType);
		}
	}

	/**
	 * Wrapper function to set the layout type of a GraphicalEditPart. This
	 * function should always be called together with
	 * <code>setLayoutGroup</code> to keep the information consistent.
	 * 
	 * @param graphicalEditPart
	 *            the GraphicalEditPart to set the layout type for
	 * @param layoutType
	 *            The layoutType
	 */
	public static void setLayoutType(final GraphicalEditPart graphicalEditPart,
			final KLayoutType layoutType) {

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
	 * Returns the layout group for this GraphicalEditPart. If this
	 * GraphicalEditPart is not grouped, the Constant
	 * <code>KimlLayoutHintConstants.NOT_GROUPED</code> will be returned
	 * 
	 * @param graphicalEditPart
	 *            the GraphicalEditPart to retrieve the layout group for
	 * @return the name of the layout group, if the element is grouped, the
	 *         constant KimlLayoutHintConstants.NOT_GROUPED else
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
	 * Convenient function to set the layout group of an ArrayList of
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
	 * Convenient function to set the layout group of an array of
	 * GraphicalEditParts.
	 * 
	 * @param graphicalEditParts
	 *            the GraphicalEditParts to set the layout group for
	 * @param groupID
	 *            a unique groupID for the GraphicalEditParts
	 */
	public static void setLayoutGroup(GraphicalEditPart[] GraphicalEditParts,
			String groupID) {
		for (GraphicalEditPart snep : GraphicalEditParts) {
			setLayoutGroup(snep, groupID);
		}
	}

	/**
	 * Wrapper function to set the layout group of a GraphicalEditPart. This
	 * function should always be called together with <code>setlayoutType</code>
	 * to keep the information consistent.
	 * 
	 * @param graphicalEditPart
	 *            the GraphicalEditPart to set the layout group for
	 * @param groupID
	 *            a string identifying the name of the group this
	 *            GraphicalEditPart belongs to
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

	/**
	 * Wrapper function to set the layout hint for an array of
	 * GraphicalEditParts.
	 * 
	 * @param graphicalEditParts
	 *            Array of GraphicalEditParts to set layout hints for
	 * @param groupID
	 *            The unique groupID for the array of GraphicalEditParts
	 * @param layoutType
	 *            The layout type for the array of GraphicalEditParts
	 * @param layouterName
	 *            The layouter name for the array of GraphicalEditParts
	 */
	public static void setLayoutHint(
			final GraphicalEditPart[] GraphicalEditParts, final String groupID,
			final KLayoutType layoutType, final String layouterName) {
		setLayoutGroup(GraphicalEditParts, groupID);
		setLayoutType(GraphicalEditParts, layoutType);
		setLayouterName(GraphicalEditParts, layouterName);
	}

	/**
	 * Wrapper function to set the layout hint for an ArrayList of
	 * GraphicalEditParts.
	 * 
	 * @param graphicalEditParts
	 *            ArrayList of GraphicalEditParts to set layout hints for
	 * @param groupID
	 *            The unique groupID for the array of GraphicalEditParts
	 * @param layoutType
	 *            The layout type for the array of GraphicalEditParts
	 * @param layouterName
	 *            The layouter name for the array of GraphicalEditParts
	 */
	public static void setLayoutHint(
			final ArrayList<? extends GraphicalEditPart> GraphicalEditParts,
			final String groupID, final KLayoutType layoutType,
			final String layouterName) {
		setLayoutGroup(GraphicalEditParts, groupID);
		setLayoutType(GraphicalEditParts, layoutType);
		setLayouterName(GraphicalEditParts, layouterName);
	}

	/**
	 * Wrapper function to set the layout hint for all the children of a
	 * GraphicalEditPart.
	 * 
	 * @param graphicalEditPart
	 *            The GraphicalEditParts whose children should all be grouped
	 *            together in the single grouping semantics
	 * @param groupID
	 *            The unique groupID for the children
	 * @param layoutType
	 *            The layout type for the children
	 * @param layouterName
	 *            The layouter name for the children
	 */
	public static void setChildrenLayoutHint(
			final GraphicalEditPart graphicalEditPart, final String groupID,
			final KLayoutType layoutType, final String layouterName) {

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
	 * the layout type for this group.
	 * 
	 * @param graphicalEditParts
	 *            the array of GraphicalEditParts to set the layout type for
	 * @param groupID
	 *            a string identifying the name of the group this
	 *            GraphicalEditPart belongs to
	 * @param layoutType
	 *            a string identifying the constant of the layout type for this
	 *            GraphicalEditPart
	 */
	public static void setLayoutHint(
			final GraphicalEditPart[] GraphicalEditParts, final String groupID,
			final KLayoutType layoutType) {
		setLayoutGroup(GraphicalEditParts, groupID);
		setLayoutType(GraphicalEditParts, layoutType);
	}

	/**
	 * Wrapper function to set the layout <b>hint</b> of a an typed ArrayList of
	 * GraphicalEditParts. The layout hint is composed of the layout group and
	 * the layout type for this group
	 * 
	 * @param graphicalEditParts
	 *            the ArrayList of GraphicalEditParts to set the layout type for
	 * @param groupID
	 *            a string identifying the name of the group this
	 *            GraphicalEditPart belongs to
	 * @param layoutType
	 *            a string identifying the constant of the layout type for this
	 *            GraphicalEditPart
	 */
	public static void setLayoutHint(
			final ArrayList<? extends GraphicalEditPart> GraphicalEditParts,
			final String groupID, final KLayoutType layoutType) {
		setLayoutGroup(GraphicalEditParts, groupID);
		setLayoutType(GraphicalEditParts, layoutType);
	}

	/**
	 * Wrapper function to set the layout <b>hint</b> of a graphicalEditPart.
	 * The layout hint is composed of the layout group and the layout type for
	 * this group
	 * 
	 * @param graphicalEditPart
	 *            the GraphicalEditPart to set the layout type for
	 * @param groupID
	 *            a string identifying the name of the group this
	 *            GraphicalEditPart belongs to
	 * @param layoutType
	 *            a string identifying the constant of the layout type for this
	 *            GraphicalEditPart
	 */
	public static void setLayoutHint(final GraphicalEditPart graphicalEditPart,
			final String groupID, final KLayoutType layoutType) {
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
		for (GraphicalEditPart editPart : GraphicalEditParts) {
			unsetLayoutHint(editPart);
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
	 */
	public static void unsetLayoutHint(
			final ArrayList<? extends GraphicalEditPart> GraphicalEditParts) {
		for (GraphicalEditPart editPart : GraphicalEditParts) {
			unsetLayoutHint(editPart);
		}
	}

	/**
	 * Wrapper function to unset the layout <b>hint</b> of a GraphicalEditPart.
	 * 
	 * @param graphicalEditPart
	 *            the GraphicalEditPart to unset the layout hint for
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
	 * @param graphicalEditPart
	 *            the GraphicalEditPart of which the layout group members should
	 *            be returned
	 * @return an ArrayList of the GraphicalEditParts belonging to this group,
	 *         the argument itself will <b>be</b> in this group, empty list if
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
	 * @return A possibly empty ArrayList of the GraphicalEditParts belonging to
	 *         this group
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
	 */
	public static String generateLayoutGroupID(
			ArrayList<? extends GraphicalEditPart> graphicalEditParts) {
		return generateLayoutGroupID(graphicalEditParts, "");
	}

	/**
	 * Generates and returns a unique ID which should be used as an identifier
	 * for a layout group
	 * 
	 * @param graphicalEditParts
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

	// ===================================================================== //
	// ================ GROUP CONTAINED ELEMENTS =========================== //
	// ===================================================================== //

	/**
	 * Returns the layouter name for this GraphicalEditPart, is a plain String.
	 * 
	 * @param graphicalEditPart
	 *            the GraphicalEditPart to retrieve the layout type for
	 * @return the layouter name
	 */
	public static String getContainedElementsLayouterName(
			GraphicalEditPart graphicalEditPart) {

		StringValueStyle subElementsLayouterNameStyle = (StringValueStyle) (graphicalEditPart
				.getNotationView().getNamedStyle(NotationPackage.eINSTANCE
				.getStringValueStyle(), CONTAINED_ELEMENTS_LAYOUTER_NAME_STYLE));

		/* if property not available, return empty string */
		if (subElementsLayouterNameStyle == null) {
			return "";
		}
		/* return stored model/notation value */
		else {
			return subElementsLayouterNameStyle.getStringValue();
		}
	}

	/**
	 * Wrapper function to set the layouter name of a GraphicalEditPart.
	 * 
	 * @param GraphicalEditPart
	 *            The GraphicalEditPart to set the layout type for
	 * @param layouterName
	 *            The name of a layouter which should render the sub elements of
	 *            this EditPart
	 */
	public static void setContainedElementsLayouterName(
			final GraphicalEditPart graphicalEditPart, final String layouterName) {

		// see if there is already an layouterNameStyle
		final StringValueStyle layoutTypeStyle = (StringValueStyle) (graphicalEditPart
				.getNotationView().getNamedStyle(NotationPackage.eINSTANCE
				.getStringValueStyle(), CONTAINED_ELEMENTS_LAYOUTER_NAME_STYLE));

		// no: -> create a new one and save it
		if (layoutTypeStyle == null) {
			final StringValueStyle newlayouterNameStyle = NotationFactory.eINSTANCE
					.createStringValueStyle();
			newlayouterNameStyle
					.setName(CONTAINED_ELEMENTS_LAYOUTER_NAME_STYLE);
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
									CONTAINED_ELEMENTS_LAYOUTER_NAME_STYLE)))
									.setStringValue(layouterName);
						}
					});
		}
	}

	/**
	 * Returns the layout type for this GraphicalEditPart.
	 * 
	 * @param graphicalEditPart
	 *            The GraphicalEditPart to retrieve the layout type for
	 * @return The layoutType
	 */
	public static LayoutType getContainedElementsLayoutType(
			GraphicalEditPart graphicalEditPart) {

		StringValueStyle layoutTypeStyle = (StringValueStyle) (graphicalEditPart
				.getNotationView().getNamedStyle(NotationPackage.eINSTANCE
				.getStringValueStyle(), CONTAINED_ELEMENTS_LAYOUT_TYPE_STYLE));

		// if property not available, return default value
		if (layoutTypeStyle == null) {
			return LayoutType.OTHER;
			// return stored model/notation value
		} else {
			if (KLayoutType.getByName(layoutTypeStyle.getStringValue()) != null)
				return LayoutType.fromString(layoutTypeStyle.getStringValue());
			else
				return LayoutType.OTHER;
		}
	}

	/**
	 * Wrapper function to set the layout type of a GraphicalEditPart.
	 * 
	 * @param graphicalEditPart
	 *            the GraphicalEditPart to set the layout type for
	 * @param layoutType
	 *            The layoutType
	 */
	public static void setContainedElementsLayoutType(
			final GraphicalEditPart graphicalEditPart,
			final LayoutType layoutType) {

		// see if there is already an layoutTypeStyle
		final StringValueStyle layoutTypeStyle = (StringValueStyle) (graphicalEditPart
				.getNotationView().getNamedStyle(NotationPackage.eINSTANCE
				.getStringValueStyle(), CONTAINED_ELEMENTS_LAYOUT_TYPE_STYLE));

		// no: -> create a new one and save it
		if (layoutTypeStyle == null) {
			final StringValueStyle newlayoutTypeStyle = NotationFactory.eINSTANCE
					.createStringValueStyle();
			newlayoutTypeStyle.setName(CONTAINED_ELEMENTS_LAYOUT_TYPE_STYLE);
			newlayoutTypeStyle.setStringValue(layoutType.toString());
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
									CONTAINED_ELEMENTS_LAYOUT_TYPE_STYLE)))
									.setStringValue(layoutType.toString());
						}
					});
		}
	}

	/**
	 * Wrapper function to set the layout <b>hint</b> of a GraphicalEditPart,
	 * respective its subelements.
	 * 
	 * @param graphicalEditPart
	 *            The GraphicalEditPart to set the layout hint for
	 * @param layoutType
	 *            The layoutType
	 * @param layouterName
	 *            The layouter name
	 */
	public static void setContainedElementsLayoutHint(
			final GraphicalEditPart graphicalEditPart,
			final LayoutType layoutType, final String layouterName) {
		setContainedElementsLayoutType(graphicalEditPart, layoutType);
		setContainedElementsLayouterName(graphicalEditPart, layouterName);
	}

	/**
	 * Wrapper function to unset the layout <b>hint</b> of a GraphicalEditPart.
	 * 
	 * @param GraphicalEditPart
	 *            The GraphicalEditPart to unset the layout type for
	 */
	public static void unsetContainedElementsLayoutHint(
			final GraphicalEditPart graphicalEditPart) {

		final StringValueStyle layouterNameStyle = (StringValueStyle) (graphicalEditPart
				.getNotationView().getNamedStyle(NotationPackage.eINSTANCE
				.getStringValueStyle(), CONTAINED_ELEMENTS_LAYOUTER_NAME_STYLE));

		final StringValueStyle layoutTypeStyle = (StringValueStyle) (graphicalEditPart
				.getNotationView().getNamedStyle(NotationPackage.eINSTANCE
				.getStringValueStyle(), CONTAINED_ELEMENTS_LAYOUT_TYPE_STYLE));

		if (layoutTypeStyle != null) {
			graphicalEditPart.getEditingDomain().getCommandStack().execute(
					new RecordingCommand(graphicalEditPart.getEditingDomain()) {
						protected void doExecute() {
							graphicalEditPart.getNotationView().getStyles()
									.remove(layouterNameStyle);
							graphicalEditPart.getNotationView().getStyles()
									.remove(layoutTypeStyle);
						}
					});
		}
	}

	/**
	 * Convenience function to remove all layout hints from a model.
	 * 
	 * @param graphicalEditPart
	 *            Any GraphicalEditPart of the diagram to clean
	 */
	public static void unsetAllContainedElementsLayoutHints(
			final GraphicalEditPart graphicalEditPart) {
		GraphicalViewer viewer = (GraphicalViewer) graphicalEditPart
				.getViewer();

		for (Object shapeNodeEditPart : viewer.getEditPartRegistry().values()) {
			if (shapeNodeEditPart instanceof ShapeNodeEditPart) {
				unsetContainedElementsLayoutHint((ShapeNodeEditPart) shapeNodeEditPart);
			}
		}
	}

	/**
	 * Convenience function to set layout hints to all elements of a
	 * model/diagram.
	 * 
	 * @param graphicalEditPart
	 *            Any GraphicalEditPart of the diagram to process
	 * @param layoutType
	 *            The layoutType
	 * @param layouterName
	 *            The layouter to use
	 */
	public static void setAllContainedElementsLayoutHints(
			final GraphicalEditPart graphicalEditPart,
			final LayoutType layoutType, final String layouterName) {

		GraphicalViewer viewer = (GraphicalViewer) graphicalEditPart
				.getViewer();

		setContainedElementsLayoutHint(graphicalEditPart, layoutType,
				layouterName);
		for (Object shapeNodeEditPart : viewer.getEditPartRegistry().values()) {
			if (shapeNodeEditPart instanceof ShapeNodeEditPart) {
				setContainedElementsLayoutHint(
						(ShapeNodeEditPart) shapeNodeEditPart, layoutType,
						layouterName);
			}
		}
	}

}