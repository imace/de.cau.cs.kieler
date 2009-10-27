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
 * 
 *****************************************************************************/
package de.cau.cs.kieler.synccharts.labelparser.bridge;

import java.util.Iterator;
import java.util.List;

import de.cau.cs.kieler.synccharts.Action;
import de.cau.cs.kieler.synccharts.Assignment;
import de.cau.cs.kieler.synccharts.BooleanValue;
import de.cau.cs.kieler.synccharts.ComplexExpression;
import de.cau.cs.kieler.synccharts.Effect;
import de.cau.cs.kieler.synccharts.Emission;
import de.cau.cs.kieler.synccharts.Expression;
import de.cau.cs.kieler.synccharts.FloatValue;
import de.cau.cs.kieler.synccharts.HostCode;
import de.cau.cs.kieler.synccharts.IntValue;
import de.cau.cs.kieler.synccharts.OperatorType;
import de.cau.cs.kieler.synccharts.SignalReference;
import de.cau.cs.kieler.synccharts.VariableReference;

/**
 * Simple serializer for Action objects parsed by the Xtext parser. This class is a preliminary
 * workaround because the official Xtext serializer does not yet work for the given grammar.
 * 
 * @author haf
 * 
 */
public final class ActionLabelSerializer {

    /**
     * private constructor to avoid instantiation of utility class.
     */
    private ActionLabelSerializer() {
    }

    /**
     * Serialize an Action object.
     * 
     * @param action
     *            Action to be serialized
     * @return the serialized String
     */
    public static String toString(final Action action) {
        if (action == null) {
            return null;
        }
        StringBuffer sb = new StringBuffer();
        if (action.isIsImmediate()) {
            sb.append("# ");
        }
        if (action.getDelay() > 1) {
            sb.append(action.getDelay() + " ");
        }

        if (action.getTrigger() != null) {
            sb.append(toString(action.getTrigger(), false));
        }
        if (!action.getEffects().isEmpty()) {
            sb.append(" / ");
        }

        for (Iterator<Effect> iterator = action.getEffects().iterator(); iterator.hasNext();) {
            Effect effect = (Effect) iterator.next();
            sb.append(toString(effect));
            if (iterator.hasNext()) {
                sb.append(", ");
            }
        }
        return sb.toString().trim();
    }

    /**
     * Serialize an Effect object.
     * 
     * @param effect
     * @return
     */
    private static String toString(final Effect effect) {
        if (effect instanceof HostCode) {
            return toString((HostCode) effect);
        }
        if (effect instanceof Assignment) {
            return toString((Assignment) effect);
        }
        if (effect instanceof Emission) {
            return toString((Emission) effect);
        }
        return null;
    }

    private static String toString(final HostCode hostCode) {
        StringBuffer sb = new StringBuffer();
        sb.append("\"" + hostCode.getCode() + "\"");
        if (hostCode.getType() != null && hostCode.getType() != "") {
            sb.append("(" + hostCode.getType() + ")");
        }
        return sb.toString();
    }

    private static String toString(final Assignment assignment) {
        StringBuffer sb = new StringBuffer();
        sb.append(assignment.getVariable().getName());
        sb.append(":=");
        sb.append(toString(assignment.getExpression(), false));
        return sb.toString();
    }

    private static String toString(final Emission emission) {
        StringBuffer sb = new StringBuffer();
        sb.append(emission.getSignal().getName());
        if (emission.getNewValue() != null) {
            sb.append("(" + toString(emission.getNewValue(), false) + ")");
        }
        return sb.toString();
    }

    private static String toString(final Expression expression, final boolean isSubExpression) {
        StringBuffer sb = new StringBuffer();
        if (expression instanceof SignalReference) {
            return ((SignalReference) expression).getSignal().getName();
        }
        if (expression instanceof VariableReference) {
            return ((VariableReference) expression).getVariable().getName();
        }
        if (expression instanceof BooleanValue) {
            return ((BooleanValue) expression).getValue().toString();
        }
        if (expression instanceof IntValue) {
            return ((IntValue) expression).getValue().toString();
        }
        if (expression instanceof FloatValue) {
            return ((FloatValue) expression).getValue().toString();
        }
        if (expression instanceof HostCode) {
            return toString((HostCode) expression);
        }
        if (expression instanceof ComplexExpression) {
            List<Expression> subExpressions = ((ComplexExpression) expression).getSubExpressions();
            if (subExpressions.size() > 1) {
                if (isSubExpression) {
                    sb.append("(");
                }
                sb.append(toString((Expression) subExpressions.get(0), true));
                sb.append(" ");
            }
            sb.append(((ComplexExpression) expression).getOperator().getLiteral());
            sb.append(" ");
            if (subExpressions.size() > 1) {
                sb.append(toString((Expression) subExpressions.get(1), true));
                if (isSubExpression) {
                    sb.append(")");
                }
            } else {
                if ((isSubExpression && (subExpressions.get(0) instanceof ComplexExpression))
                        || ((ComplexExpression) expression).getOperator().equals(OperatorType.PRE)) {
                    sb.append("(");
                }
                sb.append(toString((Expression) subExpressions.get(0), true));
                if ((isSubExpression && (subExpressions.get(0) instanceof ComplexExpression))
                        || ((ComplexExpression) expression).getOperator().equals(OperatorType.PRE)) {
                    sb.append(")");
                }
            }
        }
        return sb.toString();
    }

}
