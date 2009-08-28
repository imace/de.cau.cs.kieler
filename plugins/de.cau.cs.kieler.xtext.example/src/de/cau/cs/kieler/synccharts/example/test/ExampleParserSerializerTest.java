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
package de.cau.cs.kieler.synccharts.example.test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parser.antlr.IAntlrParser;
import org.eclipse.xtext.parsetree.reconstr.SerializerUtil;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.junit.Before;
import org.junit.Test;

import com.google.inject.Injector;

import de.cau.cs.kieler.core.KielerException;
import de.cau.cs.kieler.xtext.ExampleStandaloneSetup;
import de.cau.cs.kieler.xtext.example.Model;

/**
 * JUnit Test Case for the SyncCharts Editor Transition label parser and its
 * serializer.
 * 
 * @author haf
 * 
 */
public class ExampleParserSerializerTest {

    Injector injector;
    SerializerUtil serializerUtil;
    IAntlrParser parser;
    
    EObject parsedObject;

    /**
     * Initialize the parser and serializer.
     * 
     * @throws Exception
     *             Something failed
     */
    @Before
    public void setUpParserAndSerializer() throws Exception {
        injector = new ExampleStandaloneSetup()
                .createInjectorAndDoEMFRegistration();
        serializerUtil = injector.getInstance(SerializerUtil.class);
    }

    @Test
    public void testParser1() throws KielerException, IOException {
        EObject parsedObject = parseAndSerialize("A B C D ; B A C D");
        Model model = (Model)parsedObject;
        String serializedString = serializerUtil.serialize(model.getAction());
        System.out.println(serializedString);
    }


    private EObject parseAndSerialize(String inputString) throws KielerException, IOException{
        EObject parsedObject = parse(inputString);
        String serializedString = serializerUtil.serialize(parsedObject);
        if(inputString.equals(serializedString)){
            System.out.println("Serialized String: "+serializedString);
            return parsedObject;
            
        }
        else
            throw new KielerException("Serialization failed. Input and output" +
            		"are not the same: Input: "+inputString+" Output: "+serializedString);
    }
    
    private EObject parse(String input) throws IOException, KielerException{
        ByteArrayInputStream stream = new ByteArrayInputStream(input.getBytes());

        XtextResourceSet resourceSet = injector
                .getInstance(XtextResourceSet.class);
        XtextResource resource = (XtextResource) resourceSet
                .createResource(URI
                        .createURI("platform:/resource/de.cau.cs.kieler.synccharts.labelparser.example/dummy.example"));
        // now do parsing
        Map<Object,Object> loadOptions = resourceSet.getLoadOptions();
        loadOptions
                .put(
                        org.eclipse.xtext.resource.XtextResource.OPTION_RESOLVE_ALL,
                        true);
        resource.load(stream, loadOptions);

        IParseResult parseResult = resource.getParseResult();
        if (parseResult == null)
            throw new KielerException(
                    "Could not parse action string. Parser did return null.");

        EList<Diagnostic> errors = resource.getErrors();
        EList<Diagnostic> warnings = resource.getWarnings();

        if (errors != null && errors.size() > 0) {
            String parseErrorString = "";
            for (Diagnostic syntaxError : errors) {
                parseErrorString += "\n" + syntaxError.getMessage();
            }
            throw new KielerException("Parse errors in action String: "
                    + parseErrorString);
        }
        EObject parsedObject = resource.getContents().get(0);
        return parsedObject;
    }
}
