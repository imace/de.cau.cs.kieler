/**
 * <copyright> </copyright>
 * 
 * $Id$
 */
package de.cau.cs.kieler.kev.mapping.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Pattern;

import org.json.JSONObject;

import de.cau.cs.kieler.kev.Activator;
import de.cau.cs.kieler.kev.mapping.MappingPackage;
import de.cau.cs.kieler.kev.mapping.Rotate;
import de.cau.cs.kieler.kev.mapping.animations.MapAnimations;
import de.cau.cs.kieler.kev.views.EclipseJSVGCanvas;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.w3c.dom.DOMException;
import org.w3c.dom.Element;
import org.w3c.dom.svg.SVGDocument;
import org.w3c.dom.svg.SVGLocatable;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Rotate</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.kev.mapping.impl.RotateImpl#getAngleRange <em>Angle Range</em>}</li>
 *   <li>{@link de.cau.cs.kieler.kev.mapping.impl.RotateImpl#getAnchorPoint <em>Anchor Point</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RotateImpl extends AnimationImpl implements Rotate {
    /**
     * The default value of the '{@link #getAngle_range() <em>Angle range</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getAngle_range()
     * @generated
     * @ordered
     */
    protected static final String ANGLE_RANGE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getAngleRange() <em>Angle Range</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getAngleRange()
     * @generated
     * @ordered
     */
    protected String angleRange = ANGLE_RANGE_EDEFAULT;

    /**
     * The default value of the '{@link #getAnchor_point() <em>Anchor point</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getAnchor_point()
     * @generated
     * @ordered
     */
    protected static final String ANCHOR_POINT_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getAnchorPoint() <em>Anchor Point</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getAnchorPoint()
     * @generated
     * @ordered
     */
    protected String anchorPoint = ANCHOR_POINT_EDEFAULT;

    /**
     * A hashmap used for the animation, need to be created only once.
     */
    private HashMap<String, String> hashMap = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    protected RotateImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return MappingPackage.Literals.ROTATE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getAngleRange() {
        return angleRange;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setAngleRange(String newAngleRange) {
        String oldAngleRange = angleRange;
        angleRange = newAngleRange;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MappingPackage.ROTATE__ANGLE_RANGE, oldAngleRange, angleRange));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getAnchorPoint() {
        return anchorPoint;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setAnchorPoint(String newAnchorPoint) {
        String oldAnchorPoint = anchorPoint;
        anchorPoint = newAnchorPoint;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MappingPackage.ROTATE__ANCHOR_POINT, oldAnchorPoint, anchorPoint));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case MappingPackage.ROTATE__ANGLE_RANGE:
                return getAngleRange();
            case MappingPackage.ROTATE__ANCHOR_POINT:
                return getAnchorPoint();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case MappingPackage.ROTATE__ANGLE_RANGE:
                setAngleRange((String)newValue);
                return;
            case MappingPackage.ROTATE__ANCHOR_POINT:
                setAnchorPoint((String)newValue);
                return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eUnset(int featureID) {
        switch (featureID) {
            case MappingPackage.ROTATE__ANGLE_RANGE:
                setAngleRange(ANGLE_RANGE_EDEFAULT);
                return;
            case MappingPackage.ROTATE__ANCHOR_POINT:
                setAnchorPoint(ANCHOR_POINT_EDEFAULT);
                return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean eIsSet(int featureID) {
        switch (featureID) {
            case MappingPackage.ROTATE__ANGLE_RANGE:
                return ANGLE_RANGE_EDEFAULT == null ? angleRange != null : !ANGLE_RANGE_EDEFAULT.equals(angleRange);
            case MappingPackage.ROTATE__ANCHOR_POINT:
                return ANCHOR_POINT_EDEFAULT == null ? anchorPoint != null : !ANCHOR_POINT_EDEFAULT.equals(anchorPoint);
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String toString() {
        if (eIsProxy()) return super.toString();

        StringBuffer result = new StringBuffer(super.toString());
        result.append(" (angleRange: ");
        result.append(angleRange);
        result.append(", anchorPoint: ");
        result.append(anchorPoint);
        result.append(')');
        return result.toString();
    }

    // Computes the range values
    private final ArrayList<String> computeRange(String value, int numberOfInputValues) {
        ArrayList<String> range = new ArrayList<String>();
        if (Pattern.matches("[-]?[\\d]+[.]{2,3}[-]?[\\d]+", value)) {
            Scanner sc = new Scanner(value).useDelimiter("[.]+");
            // We have exactly two values
            float first, last, numberOfRangeValues;
            first = sc.nextFloat();
            last = sc.nextFloat();

            numberOfRangeValues = Math.abs(first - last);
            float x = numberOfRangeValues / numberOfInputValues;
            if (first <= last) {
                for (int i = 0; i < numberOfInputValues; i++) {
                    range.add(Float.toString((x * i) + first));
                }
            } else {
                for (int i = 0; i < numberOfInputValues; i++) {
                    range.add(Float.toString(first - (x * i)));
                }
            }
        } else if (Pattern.matches("([-]?\\d+([.]\\d+)?[,])+[-]?\\d+([.]\\d+)?", value)) {
            // Get a list of comma separted values
            range = MapAnimations.getInstance().attributeParser(value, false);
        } else if (Pattern.matches("[-]?\\d+([.]\\d+)?", value)) {
            for (int i = 0; i < numberOfInputValues; i++) {
                range.add(value);
            }
        } // else we have invalid values for move x_range and y_range
        return range;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * de.cau.cs.kieler.kev.mapping.Animation#applyAnimation(de.cau.cs.kieler.sim.kiem.json.JSONObject
     * , java.lang.String)
     */
    public void apply(Object jsonObject, String svgElementID) {
        // Get the current SVGDocument for manipulation.
        SVGDocument svgDoc = EclipseJSVGCanvas.getInstance().getSVGDocument();
        Element elem = svgDoc.getElementById(svgElementID);
        //String jsonValue = getActualJSONValue(jsonObject, svgElementID);
        
        // Check whether JSON object is an JSONAArray
        String jsonValue;
        if (getAccessID() != null && !getAccessID().equals("")) {
            jsonValue = ((JSONObject) jsonObject).optJSONArray(getKey()).optString(Integer.parseInt(getAccessID()));
            if (jsonValue.equals("")) {
                return;
            }
        } else {
            jsonValue = ((JSONObject) jsonObject).optString(getKey());    
        }        
        
        if (jsonValue != null) {
            if (jsonValue.indexOf("$") == 0) {
                jsonValue = ((JSONObject) jsonObject).optString(jsonValue.substring(1));
            }
            float pivotX = 0, pivotY = 0;
            if (getAnchorPoint() != null && !getAnchorPoint().equals("")) {
                Scanner sc = new Scanner(getAnchorPoint()).useDelimiter("[,]");
                try {
                    if (sc.hasNext()) {
                        pivotX = Float.parseFloat(sc.next());
                    }
                    if (sc.hasNext()) {
                        pivotY = Float.parseFloat(sc.next());
                    }
                } catch (NumberFormatException e) {
                    Activator
                            .reportInfoMessage("The rotate animation has wrong values for the pivot element. [SVGElementID: "
                                    + svgElementID + "]");
                }
            } else {
                // If no anchor_point is specified set the point to origin of the current element
                setAnchorPoint("0,0");
            }
            String angle = hashMap.get(jsonValue);
            if (angle != null) {
                if (angle.indexOf("$") == 0) {
                    angle = ((JSONObject) jsonObject).optString(angle.substring(1));
                    if (angle == null) {
                        // Rotation without an valid angle value makes no sense
                        return;
                    }
                }
                if (elem != null) {
                    // Now apply the animation
                    try {
                        // Get the BoundingBox of the element "elem"
                        SVGLocatable locatable = (SVGLocatable) elem;
                        elem.setAttribute("transform", "rotate(" + angle + ","
                                + (locatable.getBBox().getX() + pivotX) + ","
                                + (locatable.getBBox().getY() + pivotY) + ")");
                    } catch (DOMException e) {
                        Activator.reportErrorMessage(
                                "Something went wrong, setting an DOM element.", e);
                    } catch (NumberFormatException e1) {
                        Activator.reportErrorMessage(
                                "Wrong format for pivot element in rotate animation", e1);
                    }
                }
            }
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see de.cau.cs.kieler.kev.mapping.Animation#initialize()
     */
    public void initialize(String svgElementID) {
        // General initializing for each animation. 
        MapAnimations currentMapAnimation = MapAnimations.getInstance();
        if (currentMapAnimation != null) {
            // Check current key and set it to the element id if it doesn't exists.
            if (getKey() == null || getKey().equals("")) {
                setKey(svgElementID);
            } else {
                String jsonKey = getKey();
                // Otherwise we have a link to another JSON value.
                if (jsonKey.indexOf("$") == 0) {
                    setKey(jsonKey.substring(1));
                }
//                } else if (jsonKey.matches(".+\\[\\d+\\]")) { // This means the json key points to an json array
//                    try {
//                        this.arrayIndex = Integer.parseInt(jsonKey.substring(jsonKey.indexOf("["), jsonKey.indexOf("]")));
//                        setKey(jsonKey.substring(0,jsonKey.indexOf("[")));
//                    } catch (NumberFormatException e) {
//                        Activator.reportErrorMessage("Error during parsing. Arrayindex of JSON Key is not a number! [" + jsonKey + "]");
//                    }
//                }
            }


            // Initialize values if necessary
            if (getAnchorPoint() == null) {
                setAnchorPoint("");
            }
            if (getAngleRange() == null) {
                setAngleRange("");
            }
            if (getInput() == null) {
                setInput("");
            }
    
            ArrayList<String> inputArray, angleRange;
            inputArray = currentMapAnimation.attributeParser(getInput(), true);
            angleRange = computeRange(getAngleRange(), inputArray.size());
    
            // mapping of input to angle_range
            this.hashMap = currentMapAnimation.mapInputToOutput(inputArray, angleRange);
        }
    }

} // RotateImpl
