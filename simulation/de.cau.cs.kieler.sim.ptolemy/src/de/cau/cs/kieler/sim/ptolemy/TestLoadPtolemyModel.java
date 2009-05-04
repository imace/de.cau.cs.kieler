/******************************************************************************
 * KIELER - Kiel Integrated Environment for Layout for the Eclipse RCP
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
package de.cau.cs.kieler.sim.ptolemy;

import java.net.URL;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.URI;

import ptolemy.actor.Actor;
import ptolemy.actor.CompositeActor;
import ptolemy.actor.IOPort;
import ptolemy.actor.IOPortEvent;
import ptolemy.actor.IOPortEventListener;
import ptolemy.actor.Manager;
import ptolemy.kernel.util.NamedObj;
import ptolemy.moml.MoMLParser;

/**
 * Simple Test class that calls a Ptolemy MoML parser to create
 * a ptolemy model from an XML file that is created by one of the other
 * Tests. Will instantiate the model, add a manager to it and execute
 * a few iterations. See sourcecode comments for details.
 * 
 * @author haf
 * 
 */
public class TestLoadPtolemyModel {

    public static void main(String[] args) {

        // first create MoML file
        TestCreateMomlFile.main(null);
        // get URI of MoML file
        URI momlFile = TestCreateMomlFile.momlFileUri;

        // create new MoML parser. Make sure ptolemy is in your dependencies
        MoMLParser parser = new MoMLParser();

        NamedObj ptolemyModel = null;
        try {
            // parse
            // FIXME: here it would be nicer to parse something from memory
            //  maybe a String, hence the MoML code would be required in
            //  form of a String
            ptolemyModel = parser.parse(null, new URL(momlFile.toString()));
            System.out.println("MoML parsing finished...");

            // now execute the model

            // check if the parsed model is of correct type
            if (ptolemyModel != null && ptolemyModel instanceof CompositeActor) {
                CompositeActor actor = ((CompositeActor) ptolemyModel);

                // get the manager that manages execution
                Manager manager = actor.getManager();
                // there is likely no manager available, hence create a new one
                if (manager == null) {
                    manager = new Manager(actor.workspace(), "kieler manager");
                    actor.setManager(manager);
                }

                // inject listeners to the data to the model such that we get
                // our hands on the execution data
                Iterator<Object> childrenIterator = actor.containedObjectsIterator();
                while( childrenIterator.hasNext() ){
                    // search output ports of any child actors
                    Object child = childrenIterator.next();
                    if(child instanceof Actor){
                        List<Object> ports = ( (Actor)child ).outputPortList(); 
                        for (Object port : ports) {
                            if(port instanceof IOPort){
                                // found an output port, so add a listener to it
                                ( (IOPort)port ).addIOPortEventListener( new IOPortEventListener(){
                                    public void portEvent(IOPortEvent event) {
                                        System.out.print("IOPortEvent: ");
                                        System.out.print("Port: "+event.getPort().getFullName());
                                        System.out.print(" Token: "+event.getToken());
                                        System.out.println();
                                    }
                                });
                            }
                        }                        
                    }
                }
                
                // run the model
                if (manager != null) {
                    List<Actor> children = actor.getChildren();
                    // run forest, run!
                    manager.initialize();
                    for (int i = 0; i < 10; i++) {
                        manager.iterate();
                        
                    }
                    manager.wrapup();
                    // calling manager.execute() would run the model
                    // for the amount of iterations set in the director
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
