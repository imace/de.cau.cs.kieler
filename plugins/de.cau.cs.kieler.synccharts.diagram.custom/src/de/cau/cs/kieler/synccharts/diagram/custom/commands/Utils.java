/**
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
package de.cau.cs.kieler.synccharts.diagram.custom.commands;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

import de.cau.cs.kieler.synccharts.Region;
import de.cau.cs.kieler.synccharts.State;
import de.cau.cs.kieler.synccharts.Transition;

/**
 * Utility class for synccharts ksbase.
 * 
 * @author soh
 * @kieler.rating 2010-03-12 proposed yellow
 */
public final class Utils {

    /**
     * 
     */
    private Utils() {
        // does nothing
    }

    /** Clipboard for copy and paste. */
    private static volatile EObject stateClipBoard = null;
    /** Clipboard for copy and paste. */
    private static volatile Collection<State> statesClipBoard = null;
    /** Clipboard for copy and paste. */
    private static volatile EObject regionClipBoard = null;
    /** Clipboard for copy and paste. */
    private static volatile Collection<Region> regionsClipBoard = null;
    /** Clipboard for copy and paste. */
    private static volatile EObject transitionClipBoard = null;
    /** Clipboard for copy and paste. */
    private static volatile Collection<Transition> transitionsClipBoard = null;

    /**
     * Remove a region from its parent state if its not the root region.
     * 
     * @param region
     *            the region to remove
     */
    private static void removeRegionFromParent(final Region region) {
        State parent = region.getParentState();
        if (parent != null) {
            parent.getRegions().remove(region);
        }
    }

    /**
     * Remove a state from the parent region.
     * 
     * @param state
     *            the state to remove
     */
    private static void removeStateFromParent(final State state) {
        state.getParentRegion().getInnerStates().remove(state);
    }

    /**
     * Copy an object to clipboard and remove it from the model.
     * 
     * @param object
     *            the object to cut
     */
    public static void cutObject(final Object object) {
        objectToClipboard(object);
        if (object instanceof EObject) {
            if (object instanceof State) {
                State s = (State) object;
                removeStateFromParent(s);
            } else if (object instanceof Region) {
                Region r = (Region) object;
                removeRegionFromParent(r);
            } else if (object instanceof Transition) {
                Transition t = (Transition) object;
                t.getSourceState().getOutgoingTransitions().remove(t);
            }
        } else if (object instanceof List<?>) {
            List<?> list = (List<?>) object;
            for (Object o : list) {
                if (o instanceof State) {
                    removeStateFromParent((State) o);
                } else if (o instanceof Region) {
                    removeRegionFromParent((Region) o);
                } else if (o instanceof Transition) {
                    Transition t = (Transition) o;
                    t.getSourceState().getOutgoingTransitions().remove(t);
                }
            }
        }
    }

    /**
     * Clone all transitions on a state.
     * 
     * @param source
     *            the source
     * @param target
     *            the clone
     */
    private static void cloneTransitions(final State source, final State target) {
        List<Transition> transSource = source.getOutgoingTransitions();
        List<Transition> transTarget = target.getOutgoingTransitions();
        transTarget.removeAll(transTarget);

        for (Transition t : transSource) {
            if (t.getTargetState() == source) {
                Transition clone = (Transition) EcoreUtil.copy(t);
                transTarget.add(clone);
                clone.setTargetState(target);
            }
        }
    }

    /**
     * Copy an object to clipboard.
     * 
     * @param object
     *            the object
     */
    public static void objectToClipboard(final Object object) {
        resetClipboard();
        if (object instanceof EObject) {
            EObject o = EcoreUtil.copy((EObject) object);
            if (o instanceof State) {
                cloneTransitions((State) object, (State) o);
                stateClipBoard = o;
            } else if (o instanceof Region) {
                regionClipBoard = o;
            } else if (o instanceof Transition) {
                transitionClipBoard = o;
            }
        } else if (object instanceof List<?>) {
            List<?> list = (List<?>) object;

            if (list.get(0) instanceof State) {
                Collection<State> coll = new LinkedList<State>();
                for (Object o : list) {
                    if (o instanceof State) {
                        State state = (State) o;
                        coll.add(state);
                    }
                }
                statesClipBoard = EcoreUtil.copyAll(coll);
            } else if (list.get(0) instanceof Region) {
                Collection<Region> coll = new LinkedList<Region>();
                for (Object o : list) {
                    if (o instanceof Region) {
                        coll.add((Region) o);
                    }
                }
                regionsClipBoard = EcoreUtil.copyAll(coll);
            } else if (list.get(0) instanceof Transition) {
                Collection<Transition> coll = new LinkedList<Transition>();
                for (Object o : list) {
                    if (o instanceof Transition) {
                        coll.add((Transition) o);
                    }
                }
                transitionsClipBoard = EcoreUtil.copyAll(coll);
            }
        }
    }

    /**
     * Clears the clipboard.
     */
    private static void resetClipboard() {
        stateClipBoard = null;
        statesClipBoard = null;
        regionClipBoard = null;
        regionsClipBoard = null;
        transitionClipBoard = null;
        transitionsClipBoard = null;
    }

    /**
     * Get a state from the clipboard.
     * 
     * @return the state
     */
    public static State getStateFromClipboard() {
        if (stateClipBoard != null) {
            State newState = (State) EcoreUtil.copy(stateClipBoard);
            cloneTransitions((State) stateClipBoard, newState);
            return newState;
        }
        return null;
    }

    /**
     * Get a list of states from the clipboard.
     * 
     * @return the states
     */
    public static List<State> getStatesFromClipboard() {
        if (statesClipBoard != null && !statesClipBoard.isEmpty()) {
            Collection<State> states = EcoreUtil.copyAll(statesClipBoard);
            List<State> dummy = new LinkedList<State>();
            for (State state : states) {
                dummy.add(state);

                // remove transitions that leave the current selection
                Iterator<Transition> iter = state.getOutgoingTransitions()
                        .iterator();
                while (iter.hasNext()) {
                    Transition trans = iter.next();
                    if (!states.contains(trans.getTargetState())) {
                        iter.remove();
                    }
                }
            }
            return dummy;
        }
        return null;
    }

    /**
     * Get a region from the clipboard.
     * 
     * @return the region
     */
    public static Region getRegionFromClipboard() {
        if (regionClipBoard != null) {
            Region newRegion = (Region) EcoreUtil.copy(regionClipBoard);
            return newRegion;
        }
        return null;
    }

    /**
     * Get a list of regions from the clipboard.
     * 
     * @return the regions
     */
    public static List<Region> getRegionsFromClipboard() {
        if (regionsClipBoard != null && !regionsClipBoard.isEmpty()) {
            Collection<Region> regions = EcoreUtil.copyAll(regionsClipBoard);
            List<Region> dummy = new LinkedList<Region>();
            for (Region region : regions) {
                dummy.add(region);
            }
            return dummy;
        }
        return null;
    }

    /**
     * Get a transition from the clipboard.
     * 
     * @return the transition
     */
    public static Transition getTransitionFromClipboard() {
        if (transitionClipBoard != null) {
            Transition newTrans = (Transition) EcoreUtil
                    .copy(transitionClipBoard);
            return newTrans;
        }
        return null;
    }

    /**
     * Get a transition from the clipboard.
     * 
     * @return the transition
     */
    public static List<Transition> getTransitionsFromClipboard() {
        if (transitionsClipBoard != null && !transitionsClipBoard.isEmpty()) {
            Collection<Transition> transitions = EcoreUtil
                    .copyAll(transitionsClipBoard);

            List<Transition> dummy = new LinkedList<Transition>();
            for (Transition transition : transitions) {
                dummy.add(transition);
            }
            return dummy;
        }
        return null;
    }

    /**
     * Copy the object.
     * 
     * @param object
     *            the object
     * @return the copy
     */
    public final static EObject copy(final Object object) {
        return EcoreUtil.copy((EObject) object);
    }

    /**
     * Debug output for xtend code.
     * 
     * @param object
     *            the message
     */
    public final static void debug(final Object object) {
        System.out.println("COPY AND PASTE DEBUG: " + object.toString());
    }
    
    
    public final static void dump(String aString) {
        System.out.println(aString);
    }

    public final static EObject analyze(Object object){
        return (EObject) object;
    }
}
