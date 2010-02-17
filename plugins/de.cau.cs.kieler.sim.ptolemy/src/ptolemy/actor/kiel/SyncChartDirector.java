/* 
 Copyright (c) 2006-2009 The Regents of the University of California.
 All rights reserved.
 Permission is hereby granted, without written agreement and without
 license or royalty fees, to use, copy, modify, and distribute this
 software and its documentation for any purpose, provided that the above
 copyright notice and the following two paragraphs appear in all copies
 of this software.

 IN NO EVENT SHALL THE UNIVERSITY OF CALIFORNIA BE LIABLE TO ANY PARTY
 FOR DIRECT, INDIRECT, SPECIAL, INCIDENTAL, OR CONSEQUENTIAL DAMAGES
 ARISING OUT OF THE USE OF THIS SOFTWARE AND ITS DOCUMENTATION, EVEN IF
 THE UNIVERSITY OF CALIFORNIA HAS BEEN ADVISED OF THE POSSIBILITY OF
 SUCH DAMAGE.

 THE UNIVERSITY OF CALIFORNIA SPECIFICALLY DISCLAIMS ANY WARRANTIES,
 INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF
 MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE. THE SOFTWARE
 PROVIDED HEREUNDER IS ON AN "AS IS" BASIS, AND THE UNIVERSITY OF
 CALIFORNIA HAS NO OBLIGATION TO PROVIDE MAINTENANCE, SUPPORT, UPDATES,
 ENHANCEMENTS, OR MODIFICATIONS.
 PT_COPYRIGHT_VERSION_2
 COPYRIGHTENDKEY

 */
package ptolemy.actor.kiel;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import ptolemy.actor.Actor;
import ptolemy.actor.CompositeActor;
import ptolemy.actor.Director;
import ptolemy.actor.IOPort;
import ptolemy.actor.Receiver;
import ptolemy.actor.SuperdenseTimeDirector;
import ptolemy.actor.lib.Expression;
import ptolemy.actor.sched.Firing;
import ptolemy.actor.sched.FixedPointDirector;
import ptolemy.actor.sched.FixedPointReceiver;
import ptolemy.actor.sched.FixedPointScheduler;
import ptolemy.actor.sched.Schedule;
import ptolemy.actor.sched.ScheduleElement;
import ptolemy.actor.sched.StaticSchedulingDirector;
import ptolemy.data.BooleanToken;
import ptolemy.data.IntToken;
import ptolemy.data.Token;
import ptolemy.data.expr.ASTPtRootNode;
import ptolemy.data.expr.Parameter;
import ptolemy.data.expr.ParseTreeEvaluator;
import ptolemy.data.expr.ParserScope;
import ptolemy.data.expr.PtParser;
import ptolemy.data.expr.UndefinedConstantOrIdentifierException;
import ptolemy.data.type.BaseType;
import ptolemy.domains.modal.kernel.FSMActor;
import ptolemy.domains.modal.kernel.OutputActionsAttribute;
import ptolemy.domains.modal.kernel.State;
import ptolemy.domains.modal.kernel.Transition;
import ptolemy.domains.modal.modal.ModalModel;
import ptolemy.kernel.CompositeEntity;
import ptolemy.kernel.Relation;
import ptolemy.kernel.util.Attribute;
import ptolemy.kernel.util.IllegalActionException;
import ptolemy.kernel.util.NameDuplicationException;
import ptolemy.kernel.util.Nameable;
import ptolemy.kernel.util.NamedObj;
import ptolemy.kernel.util.Settable;
import ptolemy.kernel.util.StringAttribute;
import ptolemy.kernel.util.Workspace;

//////////////////////////////////////////////////////////////////////////
//// SyncChartDirector 
//// (based on FixedPointDirector by Haiyang Zheng and Edward A. Lee)

/**
 This director implements a fixed point iteration for finding 
 synchronous signal assignments of SyncCharts. This director is based on
 the FixedPointDirector that was written for Ptolemy II 
 by Haiyang Zheng and Edward A. Lee.

 @author Christian Motika
 @Pt.ProposedRating Red (cmot)
 */
public class SyncChartDirector extends FixedPointDirector {

    /** Construct a director in the default workspace with an empty string
     *  as its name. The director is added to the list of objects in
     *  the workspace. Increment the version number of the workspace.
     *  @exception IllegalActionException If the name has a period in it, or
     *   the director is not compatible with the specified container.
     *  @exception NameDuplicationException If the container already contains
     *   an entity with the specified name.
     */
    public SyncChartDirector() throws IllegalActionException,
            NameDuplicationException {
        super();
        _init();
    }

    /** Construct a director in the given workspace with an empty name.
     *  The director is added to the list of objects in the workspace.
     *  Increment the version number of the workspace.
     *  @param workspace The workspace for this object.
     *  @exception IllegalActionException If the name has a period in it, or
     *   the director is not compatible with the specified container.
     *  @exception NameDuplicationException If the container already contains
     *   an entity with the specified name.
     */
    public SyncChartDirector(Workspace workspace)
            throws IllegalActionException, NameDuplicationException {
        super(workspace);
        _init();
    }

    /** Construct a director in the given container with the given name.
     *  The container argument must not be null, or a
     *  NullPointerException will be thrown.
     *  If the name argument is null, then the name is set to the
     *  empty string. Increment the version number of the workspace.
     *  @param container Container of the director.
     *  @param name Name of this director.
     *  @exception IllegalActionException If the director is not compatible
     *   with the specified container.
     *  @exception NameDuplicationException If the name collides with an
     *   attribute in the container.
     */
    public SyncChartDirector(CompositeEntity container, String name)
            throws IllegalActionException, NameDuplicationException {
        super(container, name);
        _init();
    }
    

    /**
     * Checks whether a transition can possibly be taken. That is the case if
     * this transition is already enabled. It is also the case if it cannot be
     * evaluated because an important signal-status is missing (unknown). In
     * this case an UndefinedConstantOrIdentifierException is raised by Ptolemy
     * and this is also interpreted as a possibly enabled transition because
     * the trigger could not be evaluated to false unambiguously with this 
     * signal being still unknown.
     * 
     * @param transition
     *            the transition
     * 
     * @return true, if is possibly enabled
     * 
     * @throws IllegalActionException
     *             the illegal action exception
     */
    public boolean isPossiblyEnabled(Transition transition) throws IllegalActionException {
        try {
            //if we for sure know this transition is enabled we can return true
            if (transition.isEnabled()) {
                return true;
            }
        } catch(UndefinedConstantOrIdentifierException e) {
            //if we cannot evaluate the transition trigger because of a missing
            //signal status, we must return also true here
            return true;
        }
        //if we for sure know this transition is disabled we can return false
        return false;
    }
    
    /**
     * List all possibly enabled transitions here.
     * 
     * @param transitionList
     *            the transition list
     * @param modalModel
     *            the modal model
     * 
     * @return the list
     */
    private  List possiblyEnabledTransitions(List transitionList, 
                                             ModalModel modalModel) {
        LinkedList possiblyEnabledTransitions = new LinkedList();
        
        for (Object object: transitionList) {
            if (object instanceof Transition) {
                Transition transition = (Transition)object;

                try {
                    if (isPossiblyEnabled(transition)) {
                        possiblyEnabledTransitions.add(transition);
                }
                } catch(Exception e){
                    //hide this error => it means transition is not
                    //possibly enabled
                }
            }//end if a Transition
        }//end for each Transition
        
        return possiblyEnabledTransitions;
    }
    

    ///////////////////////////////////////////////////////////////////
    ////                         parameters                        ////
    
    public Attribute statesignals;

    /** The number of times that postfire may be called before it
     *  returns false. The type must be int, and the value
     *  defaults to zero. If the value is less than or equal to zero,
     *  then the execution will never return false in postfire, and
     *  thus the execution can continue forever.
     */
//    public Parameter iterations;

    /** Specify whether the execution should synchronize to the
     *  real time. This parameter has type boolean and defaults
     *  to false. If set to true, then this director stalls in the
     *  prefire() method until the elapsed real real time matches
     *  the current time. If the <i>period</i> parameter has value
     *  0.0 (the default), then changing this parameter to true
     *  has no effect. Note that in this base class, there is
     *  no <i>period</i> parameter and time is never advanced,
     *  so this will have no effect. It has effect in derived
     *  classes.
     */
//    public Parameter synchronizeToRealTime;

    ///////////////////////////////////////////////////////////////////
    ////                         public methods                    ////
    
    
    public String[] getMustCannotSignals() {
    	LinkedList<String> returnList = new LinkedList<String>();
    	
    	//search in current MODALMODEL actors
    	Iterator actors = this._actorsAllowedToFire.iterator();
        while (actors.hasNext()) {
        	Object actor = actors.next();
        	if (actor instanceof ModalModel) {
        		ModalModel modalModel = (ModalModel)actor;
        		State currentState = modalModel.getController().currentState();
        		List realtionList = currentState.linkedRelationList();
        		
        	System.out.println("ModalModel:"+modalModel.getName());
        	
                List transitionList = currentState.outgoingPort.linkedRelationList();
                //List<Transition> enabledTransitions;
                List<Transition> possiblyEnabledTransitions;

                possiblyEnabledTransitions =
				            this.possiblyEnabledTransitions(transitionList,
				                                            modalModel);
                //enabledTransitions = modalModel.getController().enabledTransitions(transitionList);

			
                //go thru all enabled transitions, these outputs are possibly emmitted (= NOT in mustnot)!
//              for (Transition transition: enabledTransitions) {
                for (Transition transition: possiblyEnabledTransitions) {
                        OutputActionsAttribute outputActions = transition.outputActions;
                                        if (outputActions != null) {
                                                OutputActionsAttribute outputActionsAttribute = (OutputActionsAttribute)outputActions;
                                                String output = outputActionsAttribute.getValueAsString();
                                                System.out.println("Output Actions of '"+transition.getFullName()+"': " + output);
                                                output = output.replaceAll("=1", "");
                                                output = output.replaceAll("=2", "");
                                                String[] signals = output.split(";");
                                                if (signals != null && signals.length > 0) {
                                                        for (String signal: signals) {
                                                                returnList.add(signal.trim());
                                                        }
                                                }
                                        }//end if output attribute
                }//next enabled transition
				
				//if active state has a refinement, do the same analysis for this refinement too
				try {
				if (currentState.getRefinement() != null) {
		                        String currentStateName = ((StringAttribute)currentState.getAttribute("originalName")).getValueAsString();
                                    System.out.println("MacroState:" + currentStateName);
					Director director = currentState.getRefinement()[0].getDirector();
					if (director instanceof SyncChartDirector) {
						SyncChartDirector syncChartDirector = (SyncChartDirector)director;
						String[] nestedSignals = syncChartDirector.getMustCannotSignals();
						for (String nestedSignal: nestedSignals) {
							returnList.add(nestedSignal);
						}
					}
				}//end if
				} catch (IllegalActionException e) {e.printStackTrace();}
				
           	}//next modalModel
        	
        }
        
        //construct a string array to return
        String[] returnArray = new String[returnList.size()];
        int i = 0;
        for (String signal: returnList) {
        	returnArray[i++] = signal;
        }
        
        return returnArray;
    }

    /** Prefire and fire actors in the order given by the scheduler
     *  until the iteration converges.
     *  An iteration converges when a pass through the schedule does
     *  not change the status of any receiver.
     *  @exception IllegalActionException If an actor violates the
     *   monotonicity constraints, or the prefire() or fire() method
     *   of the actor throws it.
     */
    public void fire() throws IllegalActionException {
        if (_debugging) {
            _debug("FixedPointDirector: invoking fire().");
        }
        Schedule schedule = getScheduler().getSchedule();
        int iterationCount = 0;

        //------------------------------------------------------------
        //order the schedule to habe KIELER_IO inputs scheduled first!
        Schedule orderedSchedule = new Schedule();
        Iterator firingIterator = schedule.firingIterator();
        for (int c = 0; c < schedule.size(); c++) {
        	ScheduleElement element = (ScheduleElement)schedule.get(c);
            Actor actor = ((Firing) element).getActor();
            int index = c;
            if (actor instanceof KielerIO) 
            	index = 0;
            orderedSchedule.add(index, element);
        }
        //------------------------------------------------------------
        
        do {
            do {
            	firingIterator = orderedSchedule.firingIterator();
                while (firingIterator.hasNext() && !_stopRequested) {
                    Actor actor = ((Firing) firingIterator.next()).getActor();
                    System.out.println("FIRING: "+actor.getFullName());
                    // If the actor has previously returned false in postfire(),
                    // do not fire it.
                    if (!_actorsFinishedExecution.contains(actor)) {
                        // check if the actor is ready to fire.
                        if (_isReadyToFire(actor)) {
                            _fireActor(actor);
                            _actorsFired.add(actor);
                        }
                    } else {
                        // The postfire() method of this actor returned false in
                        // some previous iteration, so here, for the benefit of
                        // connected actors, we need to explicitly call the
                        // sendClear() method of all of its output ports,
                        // which indicates that a signal is known to be absent.
                        if (_debugging) {
                            _debug("FixedPointDirector: no longer enabled (return false in postfire): "
                                    + actor.getFullName());
                        }
//                        _sendClearToAllUnknownOutputsOf(actor);
                    }
                }
                iterationCount++;
            } while (!_hasIterationConverged() && !_stopRequested);
                       
        //converged BUT no test if any local signals (defined on this level)
        //can be set to absent (=cannot be emmitted by any statemachine)
        //this also propagates the unlock!
        System.out.println("CHECKING MUSTCANNOT FOR STATE '"+this.getFullName()+"'");
        String[] possibleSignals = getMustCannotSignals();
        
        //debug printout
    	for (String possibleSignal: possibleSignals) {
    		System.out.println("possible signal: "+possibleSignal); 
    	}
    	if (possibleSignals.length == 0)
    		System.out.println("no possible signals"); 
        
        //construct a list of state signals, not in possible signals (= cannot be emitted)
        LinkedList<String> cannotSignals = new LinkedList<String>();
    	
        String stateSignals = "";
        Attribute attribute = this.getAttribute("statesignals");
        if (attribute instanceof StringAttribute) {
        	StringAttribute stringAttribute = (StringAttribute)attribute;
        	stateSignals = stringAttribute.getValueAsString();
        }
    	
    	stateSignals = stateSignals.replaceAll("'", "");
       	stateSignals = stateSignals.replaceAll(" ", "");
        stateSignals = stateSignals.replace("[", "");
    	stateSignals = stateSignals.replace("]", "");
    	String[] stateSignalArray = stateSignals.split(",");
    	for (int c = 0; c < stateSignalArray.length; c++) {
        	String stateSignal = stateSignalArray[c];
        	if (stateSignal.equals("null")) continue;
        	boolean found = false;
        	for (String possibleSignal: possibleSignals) {
        		if (possibleSignal.equals(stateSignal)) {
        			found = true;
        			break;
        		}
                        if (possibleSignal.equals(stateSignal+"i")) {
                                found = true;
                                break;
                        }
                        if (possibleSignal.equals(stateSignal+"o")) {
                                found = true;
                                break;
                        }
        	}//next stateSignal
        	if (!found) {
        		//the following signal CANNOT be emitted!
        		//it is CLEARED then
        		cannotSignals.add(stateSignal);
            	System.out.println("CANNOT EMMIT: "+stateSignal);
        	}
        }//next stateSignal
    	

   		//check for unknown signals and set them to absent (clear())
            List receivers = this._receivers; //_actorsFired.iterator();

        	System.out.println("CHECK "+receivers.size());
            
            for (int c = 0; c < receivers.size(); c++) {
                Object entity = receivers.get(c);
                if (entity instanceof Receiver) {
                    Receiver receiver = (Receiver) entity;

                    //System.out.println("TEST FOR "+this._elementName + " " + receiverSignalName);
                   
                    //if they are still unknown then assume signal absence
                    if (!receiver.isKnown()) {
                    	try {
                            String receiverSignalName = receiver.getContainer().getName();
                            boolean doubleContainter = false;
                            if (receiverSignalName.equals("input")) {
                                //this is true for the combine function
                                receiverSignalName = receiver.getContainer().getContainer().getName();
                                doubleContainter = true;
                            }
                            boolean cannotEmmit = false;
                            for (String cannotSignal: cannotSignals) {
                            	cannotSignal = cannotSignal.replaceAll("\"", "");
                            	
                                System.out.println("TEST FOR "+receiverSignalName+" == "+ cannotSignal );
                            	if ((receiverSignalName.equals(cannotSignal))
                                        	|| receiverSignalName.equals(cannotSignal+"i")
                                        	|| receiverSignalName.equals(cannotSignal+"o_COMBINE")) {
                                   	//clear the port
                            	    
                            	        if (this._isTopLevel()) {
                                            //if (receiver.getContainer().attributeList().contains("definition_level")) {
                                            System.out.println("Sending CLEAR on receiver port "+receiver.getContainer().getName() +
                                                            " of actor " + receiver.getContainer().getContainer().getName());
                                            receiver.clear();
                            	        } else {
                                            System.out.println("NOT Sending CLEAR on receiver port (not top level) "+receiver.getContainer().getName() +
                                                    " of actor " + receiver.getContainer().getContainer().getName());
                            	        }
                                    	
                                    	//signal status has changed, so we need a new fixed point!
                                    	//=> _hasIterationConverged will result false now again!
                                    	//(this is because the call of clear() actually is registered within this
                                    	//director)
                                	//}
                                }
                            }
                    	}catch(Exception e){}
                    }//end if signal presence unknwon
                }//end if Receiver
            }//next receiver object

//                    	//clear the port
//                    	if (receiver.getContainer().attributeList().contains("definition_level")) {
//                        	System.out.println("Sending CLEAR on receiver port "+receiver.getContainer().getName() +
//                        			" of actor " + receiver.getContainer().getContainer().getName());
//                        	receiver.clear();
//                    	}
//                    	else {
//                        	System.out.println("Port "+receiver.getContainer().getName() +
//                       			" of actor " + receiver.getContainer().getContainer().getName()+" not defined on this level!");
//                    		if (this._isTopLevel()) {
//                            	System.out.println("Sending CLEAR on receiver port "+receiver.getContainer().getName() +
//                            			" of actor " + receiver.getContainer().getContainer().getName());
//                    			receiver.clear();
//                    		}
//                    		else {
//                            	System.out.println("Port "+receiver.getContainer().getName() +
//                   			" of actor " + receiver.getContainer().getContainer().getName()+" is unknown (diff level)!");
//                    		}
//                    	}
//                    }
//                    else {
//                    	System.out.println("Port "+receiver.getContainer().getName() +
//                    			" of actor " + receiver.getContainer().getContainer().getName()+" is known!");
//                    }
//                }//end if receiver
//            }//next receiver
            
            
        } while (!_hasIterationConverged() && !_stopRequested);
//        } while (hasChanged);
        
        if (_debugging) {
            _debug(this.getFullName() + ": Fixed point found after "
                    + iterationCount + " iterations.");
        }
    }

    /** Return the current index of the director.
     *  The current index is a portion of the superdense time.
     *  Superdense time means that time is a real value and an index,
     *  allowing multiple sequential steps to occur at a fixed (real) time.
     *  @return the superdense time index
     *  @see #setIndex(int)
     *  @see ptolemy.actor.SuperdenseTimeDirector
     */
    public int getIndex() {
        return _index;
    }

    /** Return true, indicating that this director assumes and exports
     *  the strict actor semantics, as described in this paper:
     *  <p>
     *  A. Goderis, C. Brooks, I. Altintas, E. A. Lee, and C. Goble,
     *  "Heterogeneous Composition of Models of Computation,"
     *  EECS Department, University of California, Berkeley,
     *  Tech. Rep. UCB/EECS-2007-139, Nov. 2007.
     *  http://www.eecs.berkeley.edu/Pubs/TechRpts/2007/EECS-2007-139.html
     *  <p>
     *  In particular, a director that implements this interface guarantees
     *  that it will not invoke the postfire() method of an actor until all
     *  its inputs are known at the current tag.  Moreover, it it will only
     *  do so in its own postfire() method, and in its prefire() and fire()
     *  methods, it does not change its own state.  Thus, such a director
     *  can be used within a model of computation that has a fixed-point
     *  semantics, such as SRDirector and ContinuousDirector.
     *  @return True.
     */
    public boolean implementsStrictActorSemantics() {
        return true;
    }

    /** Initialize the director and all deeply contained actors by calling
     *  the super.initialize() method. Reset all private variables.
     *  @exception IllegalActionException If the superclass throws it.
     */
    public void initialize() throws IllegalActionException {
        _currentIteration = 0;
        // This variable has to be reset at the very beginning, because
        // some actors may call fireAt method to register breakpoints in DE
        // and Continuous domains, which depend on the value of _index.
        _index = 0;
        // This could be getting re-initialized during execution
        // (e.g., if we are inside a modal model), in which case,
        // if the enclosing director is a superdense time director,
        // we should initialize to its microstep, not to our own.
        // NOTE: Some (weird) directors pretend they are not embedded even
        // if they are (e.g. in Ptides), so we call _isEmbedded() to give
        // the subclass the option of pretending it is not embedded.
        if (_isEmbedded()) {
            Nameable container = getContainer();
            if (container instanceof CompositeActor) {
                Director executiveDirector = ((CompositeActor) container)
                        .getExecutiveDirector();
                if (executiveDirector instanceof SuperdenseTimeDirector) {
                    _index = ((SuperdenseTimeDirector) executiveDirector)
                            .getIndex();
                }
            }
        }

        _actorsAllowedToFire = new HashSet();
        _actorsFinishedFiring = new HashSet();
        _cachedAllInputsKnown = new HashSet();

        _cachedFunctionalProperty = true;
        _functionalPropertyVersion = -1;
        
        super.initialize();

        _realStartTime = System.currentTimeMillis();

        // NOTE: The following used to be done in prefire(), which is wrong,
        // because prefire() can be invoked multiple times in an iteration
        // (particularly if this is inside another FixedPointDirector).
        _resetAllReceivers();
    }

    /** Return true if all the controlled actors' isFireFunctional()
     *  methods return true. Otherwise, return false.
     *
     *  @return True if all controlled actors are functional.  Return
     *  false if there is no container or no actors in the container.
     */
    public boolean isFireFunctional() {
        if (workspace().getVersion() == _functionalPropertyVersion) {
            return _cachedFunctionalProperty;
        }

        boolean result = true;
        boolean containsActors = false;

        CompositeActor container = (CompositeActor) getContainer();
        if (container == null) {
            return false;
        }
        Iterator actors = container.deepEntityList().iterator();

        while (result && actors.hasNext() && !_stopRequested) {
            Actor actor = (Actor) actors.next();
            result = actor.isFireFunctional() && result;
            containsActors = true;
        }

        if (!containsActors) {
            result = false;
        }
        _cachedFunctionalProperty = result;
        _functionalPropertyVersion = workspace().getVersion();

        return result;
    }

    /** Return false. The transferInputs() method checks whether
     *  the inputs are known before calling hasToken().
     *  Thus this director tolerates unknown inputs.
     *  @return False.
     */
    public boolean isStrict() {
        return false;
    }

    /** Return a new FixedPointReceiver. If a subclass overrides this
     *  method, the receiver it creates must be a subclass of FixedPointReceiver,
     *  and it must add the receiver to the _receivers list (a protected
     *  member of this class).
     *  @return A new FixedPointReceiver.
     */
    public Receiver newReceiver() {
        Receiver receiver = new FixedPointReceiver((FixedPointDirector)this);
        _receivers.add(receiver);
        return receiver;
    }

    /** Call postfire() on all contained actors that were fired in the current
     *  iteration.  Return false if the model
     *  has finished executing, either by reaching the iteration limit, or if
     *  no actors in the model return true in postfire(), or if stop has
     *  been requested, or if no actors fired at all in the last iteration.
     *  This method is called only once for each iteration.
     *  Note that actors are postfired in arbitrary order.
     *  @return True if the execution is not finished.
     *  @exception IllegalActionException If the iterations parameter does
     *   not have a valid token, or if there still some unknown inputs (which
     *   indicates a causality loop).
     */
    public boolean postfire() throws IllegalActionException {
        if (_debugging) {
            _debug("FixedPointDirector: Called postfire().");
        }
        boolean needMoreIterations = true;
        // If no actors were fired, this director used to return
        // false in postfire. However, this is not correct because there
        // may be actors that are using time to decide whether to fire
        // and, in addition, this may be embedded, in which case future
        // events will trigger firings.
        /*
        int numberOfActors = getScheduler().getSchedule().size();
        if ((numberOfActors > 0) && (_actorsFired.size() == 0)) {
            needMoreIterations = false;
        }
        */

        Iterator actors = _actorsFired.iterator();
        while (actors.hasNext() && !_stopRequested) {
            Actor actor = (Actor) actors.next();
            if (!_areAllInputsKnown(actor)) {
                // Construct a list of the unknown inputs.
                StringBuffer unknownInputs = new StringBuffer();
                Iterator inputPorts = actor.inputPortList().iterator();
                IOPort firstPort = null;
                while (inputPorts.hasNext()) {
                    IOPort inputPort = (IOPort) inputPorts.next();
                    if (!inputPort.isKnown()) {
                        unknownInputs.append(inputPort.getName());
                        unknownInputs.append("\n");
                        if (firstPort == null) {
                            firstPort = inputPort;
                        }
                    }
                }
                throw new IllegalActionException(actor, firstPort,
                        "Unknown inputs remain. Possible causality loop:\n"
                                + unknownInputs);
            }
            if (!_actorsFinishedExecution.contains(actor)) {
                if (!_postfireActor(actor)) {
                    // postfire() returned false, so prevent the actor
                    // from iterating again.
                    _actorsFinishedExecution.add(actor);
                }
            }
        }
        if (_debugging) {
            _debug(this.getFullName() + ": Iteration " + _currentIteration
                    + " is complete.");
        }

        // NOTE: The following used to be done in prefire(), which is wrong,
        // because prefire() can be invoked multiple times in an iteration
        // (particularly if this is inside another FixedPointDirector).
        _resetAllReceivers();

        // In this base class, the superdense time index is the only advancement
        // of time, and it advances on every iteration. Derived classes must set
        // it to zero in their postfire method if they advance time.
        _index++;

        // Check whether the current execution has reached its iteration limit.
        _currentIteration++;
        int numberOfIterations = ((IntToken) iterations.getToken()).intValue();
        if ((numberOfIterations > 0)
                && (_currentIteration >= numberOfIterations)) {
            super.postfire();
            return false;
        }

        return super.postfire() && needMoreIterations;
    }

    /** Return true if the director is ready to fire.
     *  If <i>synchronizeToRealTime</i> is true, then
     *  wait for real time elapse to match or exceed model time.
     *  The return whatever the base class returns.
     *  @return True.
     *  @exception IllegalActionException Not thrown in this base class.
     */
    public boolean prefire() throws IllegalActionException {
        _synchronizeToRealTime();
        return super.prefire();
    }

    /** Set the superdense time index. This should only be
     *  called by an enclosing director.
     *  @exception IllegalActionException Not thrown in this base class.
     *  @see #getIndex()
     *  @see ptolemy.actor.SuperdenseTimeDirector
     */
    public void setIndex(int index) throws IllegalActionException {
        if (_debugging) {
            _debug("Setting superdense time index to " + index);
        }
        _index = index;
    }

    /** Return an array of suggested directors to be used with
     *  ModalModel. Each director is specified by its full class
     *  name.  The first director in the array will be the default
     *  director used by a modal model.
     *  @return An array of suggested directors to be used with ModalModel.
     *  @see ptolemy.actor.Director#suggestedModalModelDirectors()
     */
    public String[] suggestedModalModelDirectors() {
        String[] defaultSuggestions = new String[2];
        defaultSuggestions[1] = "ptolemy.domains.fsm.kernel.NonStrictFSMDirector";
        defaultSuggestions[0] = "ptolemy.domains.fsm.kernel.FSMDirector";
        return defaultSuggestions;
    }

    /** Transfer data from the specified input port of the
     *  container to the ports it is connected to on the inside.
     *  If there is no data on the specified input port, then
     *  set the ports on the inside to absent by calling sendClearInside().
     *  This method delegates the data transfer
     *  operation to the transferInputs method of the super class.
     *
     *  @exception IllegalActionException If the port is not an opaque
     *   input port.
     *  @param port The port to transfer tokens from.
     *  @return True if at least one token is transferred.
     */
    public boolean transferInputs(IOPort port) throws IllegalActionException {
        boolean result = false;
        int insideWidth = port.getWidthInside();
        for (int i = 0; i < port.getWidth(); i++) {
            if (port.isKnown(i)) {
                if (port.hasToken(i)) {
                    result = super.transferInputs(port) || result;
                } else {
                    if (i < insideWidth) {
                        port.sendClearInside(i);
                    }
                }
            }
            // we do not explicit reset the receivers receiving inputs
            // from this port because the fixedpoint director resets the
            // receivers in its prefire() method.
        }
        // If the inside is wider than the outside, send clear on the inside.
        for (int i = port.getWidth(); i < insideWidth; i++) {
            port.sendClearInside(i);
        }
        return result;
    }

    /** Transfer data from the specified output port of the
     *  container to the ports it is connected to on the outside.
     *  If there is no data on the specified output port, then
     *  set the ports on the outside to absent by calling sendClear().
     *  This method delegates the data transfer
     *  operation to the transferOutputs method of the super class.
     *
     *  @exception IllegalActionException If the port is not an opaque
     *   output port.
     *  @param port The port to transfer tokens from.
     *  @return True if at least one token is transferred.
     */
    public boolean transferOutputs(IOPort port) throws IllegalActionException {
        boolean result = false;
        Director executiveDirector = ((CompositeActor) getContainer())
                .getExecutiveDirector();
        int outsideWidth = port.getWidth();
        for (int i = 0; i < port.getWidthInside(); i++) {
            if (port.isKnownInside(i)) {
                if (port.hasTokenInside(i)) {
                    result = super.transferOutputs(port) || result;
                } else if (executiveDirector instanceof SyncChartDirector) {
                    // Mark the destination receivers absent.
                    // Note that the clear() method of the FixedPointReceiver is
                    // the right behavior, but this will do the wrong thing for
                    // say a DE director, where it will clear out previously
                    // produced data.
                    if (i < outsideWidth) {
                        port.sendClear(i);
                    }
                }
            }
        }
        // If the outside is wider than the inside, send clear on the outside.
        /* NOTE: This isn't right!  Need to leave the output unknown in case
         * we are in a modal model. A transition may be wanting to set it.
         * it has to become known only if the environment sets it known
         * by presuming that any unproduced outputs are absent.
         *
        for (int i = port.getWidthInside(); i < outsideWidth; i++) {
            port.sendClear(i);
        }
        */
        return result;
    }

    ///////////////////////////////////////////////////////////////////
    ////                         protected methods                 ////

    /** React to the change in receiver status by incrementing the count of
     *  known receivers.
     */
    protected void _receiverChanged() {
        _currentNumberOfKnownReceivers++;
    }

    /** Reset all receivers to unknown status and clear out variables used
     *  to track which actors fired in the last iteration.
     */
    protected void _resetAllReceivers() {
        _actorsAllowedToFire.clear();
        _actorsFinishedFiring.clear();
        _actorsFired.clear();
        _cachedAllInputsKnown.clear();
        _lastNumberOfKnownReceivers = -1;

        if (_debugging) {
            _debug("    FixedPointDirector is resetting all receivers");
        }
        _currentNumberOfKnownReceivers = 0;

        Iterator receiverIterator = _receivers.iterator();
        while (receiverIterator.hasNext()) {
            FixedPointReceiver receiver = (FixedPointReceiver) receiverIterator
                    .next();
            receiver.reset();
        }
    }

    /** Synchronize to real time, if appropriate.
     *  @exception IllegalActionException If the <i>synchronizeToRealTime</i>
     *   parameter is ill formed.
     */
    protected void _synchronizeToRealTime() throws IllegalActionException {
        boolean synchronizeValue = ((BooleanToken) synchronizeToRealTime
                .getToken()).booleanValue();

        if (synchronizeValue) {
            int depth = 0;
            try {
                synchronized (this) {
                    while (true) {
                        long elapsedTime = System.currentTimeMillis()
                                - _realStartTime;

                        // NOTE: We assume that the elapsed time can be
                        // safely cast to a double.  This means that
                        // the SR domain has an upper limit on running
                        // time of Double.MAX_VALUE milliseconds.
                        double elapsedTimeInSeconds = elapsedTime / 1000.0;
                        double currentTime = getModelTime().getDoubleValue();

                        if (currentTime <= elapsedTimeInSeconds) {
                            break;
                        }

                        long timeToWait = (long) ((currentTime - elapsedTimeInSeconds) * 1000.0);

                        if (_debugging) {
                            _debug("Waiting for real time to pass: "
                                    + timeToWait);
                        }

                        try {
                            // NOTE: The built-in Java wait() method
                            // does not release the
                            // locks on the workspace, which would block
                            // UI interactions and may cause deadlocks.
                            // SOLUTION: explicitly release read permissions.
                            if (timeToWait > 0) {
                                // Bug fix from J. S. Senecal:
                                //
                                //  The problem was that sometimes, the
                                //  method Object.wait(timeout) was called
                                //  with timeout = 0. According to java
                                //  documentation:
                                //
                                // " If timeout is zero, however, then
                                // real time is not taken into
                                // consideration and the thread simply
                                // waits until notified."
                                depth = _workspace.releaseReadPermission();
                                wait(timeToWait);
                            }
                        } catch (InterruptedException ex) {
                            // Continue executing.
                        }
                    }
                }
            } finally {
                if (depth > 0) {
                    _workspace.reacquireReadPermission(depth);
                }
            }
        }
    }

    ///////////////////////////////////////////////////////////////////
    ////                         protected variables               ////

    /** The current index of the model. */
    protected int _index;

    /** List of all receivers this director has created. */
    protected List _receivers = new LinkedList();

    ///////////////////////////////////////////////////////////////////
    ////                         private methods                   ////

    /** Return true if all the inputs of the specified actor are known.
     */
    private boolean _areAllInputsKnown(Actor actor)
            throws IllegalActionException {

        if (_cachedAllInputsKnown.contains(actor)) {
            return true;
        }

        Iterator inputPorts = actor.inputPortList().iterator();

        while (inputPorts.hasNext()) {
            IOPort inputPort = (IOPort) inputPorts.next();

            if (!inputPort.isKnown()) {
                return false;
            }
        }

        _cachedAllInputsKnown.add(actor);
        return true;
    }

    /** Fire an actor. Call its prefire() method, and
     *  if that returns true, call its fire() method.
     *  @exception IllegalActionException If the prefire() method
     *   returns false having previously returned true in the same
     *   iteration, or if the prefire() or fire() method of the actor
     *   throws it.
     */
    private void _fireActor(Actor actor) throws IllegalActionException {
        // Prefire the actor.
        boolean prefireReturns = actor.prefire();
        if (_debugging) {
            _debug("FixedPointDirector: Prefiring: "
                    + ((Nameable) actor).getFullName() + ", which returns "
                    + prefireReturns);
        }
        // Check monotonicity constraint.
        if (!prefireReturns && _actorsAllowedToFire.contains(actor)) {
            throw new IllegalActionException(
                    actor,
                    "prefire() method returns false, but it"
                            + " has previously returned true in this iteration.");
        }
        if (prefireReturns) {
            _actorsAllowedToFire.add(actor);

            // Whether all inputs are known must be checked before
            // firing to handle cases with self-loops, because the
            // current firing may change the status of some input
            // receivers from unknown to known.
            boolean allInputsKnownBeforeFiring = _areAllInputsKnown(actor);

            if (_debugging) {
                if (allInputsKnownBeforeFiring) {
                    _debug("Firing: " + ((Nameable) actor).getName()
                            + ", which has all inputs known.");
                } else {
                    _debug("Firing: " + ((Nameable) actor).getName()
                            + ", which has some inputs unknown.");
                }
            }

            actor.fire();
            // If all of the inputs of this actor were known before firing, firing
            // the actor again in the current iteration is not necessary.
            if (allInputsKnownBeforeFiring) {
                _actorsFinishedFiring.add(actor);
                _sendClearToAllUnknownOutputsOf(actor);
            }
        } else {
            // prefire() returned false. The actor declines
            // to fire. This could be because some inputs are
            // not known.  If all inputs are known, then we
            // interpret this to mean that all outputs should be absent.
            // Note that prefire() is executed only after all the inputs are
            // known if the actor is strict.
            if (actor.isStrict() || _areAllInputsKnown(actor)) {
                _actorsFinishedFiring.add(actor);
                _sendClearToAllUnknownOutputsOf(actor);
            }
        }
    }

    /** Return true if this iteration has converged.  The iteration has
     *  converged if both the number of known receivers
     *  has not changed since the previous invocation of this method.
     */
    private boolean _hasIterationConverged() {
        if (_debugging) {
            _debug(this.getFullName()
                    + ":\n Number of receivers known previously is "
                    + _lastNumberOfKnownReceivers
                    + ":\n Number of receivers known now is "
                    + _currentNumberOfKnownReceivers);
        }
        // Determine the number of known receivers has changed since the
        // last iteration. If not, the current iteration has converged.
        // Note that checking whether all receivers are known is not sufficient
        // to conclude the convergence of the iteration because if some
        // receivers just become known, their containers (actors) need to be
        // fired to react these new inputs.
        boolean converged = _lastNumberOfKnownReceivers == _currentNumberOfKnownReceivers;
        _lastNumberOfKnownReceivers = _currentNumberOfKnownReceivers;

        // One might try to optimize this method by also considering the
        // _actorsFinishedFiring set.
        // CompositeActor container = (CompositeActor) getContainer();
        // converged =
        // _actorsFinishedFiring.size() == container.deepEntityList().size());
        return converged;
    }

    /** Initialize the director by creating the parameters and setting their
     *  values and types.
     */
    private void _init() throws IllegalActionException,
            NameDuplicationException {
//        iterations = new Parameter(this, "iterations", new IntToken(0));
//        iterations.setTypeEquals(BaseType.INT);

//        synchronizeToRealTime = new Parameter(this, "synchronizeToRealTime");
//        synchronizeToRealTime.setExpression("false");
//        synchronizeToRealTime.setTypeEquals(BaseType.BOOLEAN);
          //statesignals = new Parameter(this, "statesignals");

        timeResolution.setVisibility(Settable.FULL);
        timeResolution.moveToLast();

        FixedPointScheduler scheduler = new FixedPointScheduler(this,
                uniqueName("Scheduler"));
        setScheduler(scheduler);
    }

    /** Return true if the specified actor is ready to fire.  An actor is
     *  ready to fire if it has not previously finished firing in this iteration
     *  and either it is strict and all inputs are known or it is nonstrict.
     *  Note that this ignores whether the actor has previously returned
     *  false in postfire().
     */
    private boolean _isReadyToFire(Actor actor) throws IllegalActionException {
        return !_actorsFinishedFiring.contains(actor)
                && (!actor.isStrict() || _areAllInputsKnown(actor));
    }

    /** Return the result of the postfire() method of the specified actor
     *  if it is allowed to be fired in the current iteration.  If this actor
     *  is not to be fired in the current iteration, return true without
     *  calling the postfire() method of the actor.
     */
    private boolean _postfireActor(Actor actor) throws IllegalActionException {
        if (_actorsAllowedToFire.contains(actor)) {
            _debug(getFullName() + " is postfiring "
                    + ((Nameable) actor).getFullName());
            return actor.postfire();
        }
        return true;
    }

    /** Call the sendClear() method of each output port with
     *  unknown status of the specified actor
     *  @param actor The actor.
     */
    private void _sendClearToAllUnknownOutputsOf(Actor actor)
            throws IllegalActionException {
        // An actor, if its firing has finished but some of its
        // outputs are still unknown, clear these outputs.
        // However, there is nothing need to do if this actor has
        // resolved all of its outputs.
        Iterator outputPorts = actor.outputPortList().iterator();
        while (outputPorts.hasNext()) {
            IOPort outputPort = (IOPort) outputPorts.next();
            for (int j = 0; j < outputPort.getWidth(); j++) {
                if (!outputPort.isKnown(j)) {
                    if (_debugging) {
                        _debug("  FixedPointDirector: Set output "
                                + outputPort.getFullName() + " to absent.");
                    }
                    outputPort.sendClear(j);
                }
            }
        }
    }

    ///////////////////////////////////////////////////////////////////
    ////                         private variables                 ////

    /** The set of actors that have returned true in their prefire() methods
     *  in the current iteration. This is used only to check monotonicity
     *  constraints.
     */
    private Set _actorsAllowedToFire;

    /** The set of actors that have been fired in this iteration with
     *  all inputs known.
     */
    private Set _actorsFinishedFiring;

    /** Actors that were fired in the most recent invocation of the fire() method. */
    private Set _actorsFired = new HashSet();

    /** The set of actors that have all inputs known in the given iteration. */
    private Set _cachedAllInputsKnown;

    /** The cache of the functional property of the container of this director. */
    private boolean _cachedFunctionalProperty;

    /** The current number of receivers with known state. */
    private int _currentNumberOfKnownReceivers;

    /** The count of iterations executed. */
    private int _currentIteration;

    /** Version number for the cached functional property. */
    private transient long _functionalPropertyVersion = -1L;

    /** The number of receivers with known state on the last phase of
     *  actor firings.
     */
    private int _lastNumberOfKnownReceivers;

    /** The real time at which the model begins executing. */
    private long _realStartTime = 0L;
}
