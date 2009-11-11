/*
o * KIELER - Kiel Integrated Environment for Layout Eclipse RichClient
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
 */
package de.cau.cs.kieler.synccharts.dsl.kits.tests;

import java.io.File;
import java.io.IOException;
import java.util.Collections;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;

import com.google.inject.Injector;

import de.cau.cs.kieler.synccharts.Action;
import de.cau.cs.kieler.synccharts.Region;
import de.cau.cs.kieler.synccharts.State;
import de.cau.cs.kieler.synccharts.SyncchartsFactory;
import de.cau.cs.kieler.synccharts.Variable;
import de.cau.cs.kieler.synccharts.VariableReference;
import de.cau.cs.kieler.synccharts.dsl.KitsStandaloneSetup;

/**
 * @author oba
 * 
 */
public class KitsSerializerTest {
    public static void main(String[] args) {
        Injector injector = new KitsStandaloneSetup()
                .createInjectorAndDoEMFRegistration();
        System.out.println("> injector created...");
        XtextResourceSet resourceSet = injector
                .getInstance(XtextResourceSet.class);
        XtextResource resource = injector.getInstance(XtextResource.class);
        URI fileURI = URI.createFileURI(new File("test2.kits")
                .getAbsolutePath());
        resource = (XtextResource) resourceSet.createResource(fileURI);
        System.out.println("> resource created...");
        // try {
        // resource.load(new StringInputStream("init A"),
        // Collections.EMPTY_MAP);
        // } catch (IOException e1) {
        // /* error */
        // System.out.println("> i was loading while I was shot...");
        // e1.printStackTrace();
        // return;
        // }
        resource.getContents().add(createEMFModel());
        System.out.println("> EMF model added...");
        System.out.println("------------------------------------");
        try {
            resource.save(System.out, Collections.EMPTY_MAP);
            System.out.println();
            System.out.println("------------------------------------");
            System.out.println("> resource saved ...");
        } catch (IOException e) {
            /* do sth */
            e.printStackTrace();
        }
        System.out.println("> done");
        // ByteArrayOutputStream bos = new ByteArrayOutputStream();

    }

    static Region createEMFModel() {
        SyncchartsFactory syncFac = SyncchartsFactory.eINSTANCE;
        Region r = syncFac.createRegion();
        r.setParentState(null);// geht
        r.setId("syncchart");
        Variable v = syncFac.createVariable();
        v.setName("v1");
        v.setInitialValue("initialValue");
        r.getVariables().add(v);
        State s0 = syncFac.createState();
        s0.setId("S");
        s0.setLabel("S");
        s0.setBodyText("bodyText");
        s0.setIsFinal(true);
        s0.setIsInitial(true);
        Action a = syncFac.createAction();
        a.setDelay(0);
        a.setIsImmediate(true);
        VariableReference varRef = syncFac.createVariableReference();
        varRef.setVariable(v);
        a.setTrigger(varRef);
        a.setTriggersAndEffects("triggers / effects");
        s0.setSuspensionTrigger(a);
        s0.setType(de.cau.cs.kieler.synccharts.StateType.NORMAL);
        s0.setParentRegion(r);
        r.getInnerStates().add(s0);// isn't this done automatically? whatever,
        // take no risk
        return r;
    }
}
