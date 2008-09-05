package edu.unikiel.rtsys.kieler.kiml.layout;

/**
 * @author ars@informatik.uni-kiel.de
 * 
 */
public class LayoutConstants {

	/**
	 * Constant for layout hint, used for example to create a named style for a
	 * view
	 */
	public static final String LAYOUT_TYPE = "layoutType";

	/**
	 * Constant for layout group, used for example to create a named style for a
	 * view
	 */
	public static final String LAYOUT_GROUP = "layoutGroup";

	/**
	 * Constant for layout group, used to indicate that a ShapeNodeEdit part
	 * does not belong to any group
	 */
	public static final String NOT_GROUPED = "Not grouped";

	/**
	 * No special layout hint should be applied to elements marked NONE
	 */
	public static final String NONE = "NONE";

	/**
	 * A custom, maybe yet to be implemented layout should be applied to
	 * elements marked CUSTOM
	 */
	public static final String CUSTOM = "CUSTOM";

	/**
	 * Elements marked like this should be given a HORIZONTAL layout
	 */
	public static final String HORIZONTAL = "HORIZONTAL";

	/**
	 * Elements marked like this should be given a VERTICAL layout
	 */
	public static final String VERTICAL = "VERTICAL";

	/**
	 * Elements marked like this should be given a CIRCLE layout
	 */
	public static final String CIRCLE = "CIRCLE";

	/**
	 * Elements marked like this should be given a DOT like layout
	 */
	public static final String DOT = "DOT";

	/**
	 * The array of all possible layout hints:
	 * 
	 * NONE, CUSTOM, HORIZONTAL, VERTICAL, CIRCLE, DOT
	 * 
	 */
	public static String[] layoutTypes = { NONE, CUSTOM, HORIZONTAL, VERTICAL,
			CIRCLE, DOT };

}
