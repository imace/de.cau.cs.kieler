/*
 * KIELER - Kiel Integrated Environment for Layout Eclipse Rich Client
 * 
 * http://www.informatik.uni-kiel.de/rtsys/kieler/
 * 
 * Copyright 2009 by + Christian-Albrechts-University of Kiel + Department of Computer Science +
 * Real-Time and Embedded Systems Group
 * 
 * This code is provided under the terms of the Eclipse Public License (EPL). See the file
 * epl-v10.html for the license text.
 */

package de.cau.cs.kieler.xkev.mapping.animations;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.w3c.dom.svg.SVGDocument;

import de.cau.cs.kieler.sim.kiem.json.JSONException;
import de.cau.cs.kieler.sim.kiem.json.JSONObject;
import de.cau.cs.kieler.xkev.Activator;
import de.cau.cs.kieler.xkev.mapping.Animation;
import de.cau.cs.kieler.xkev.mapping.Colorize;
import de.cau.cs.kieler.xkev.mapping.MappingPackage;
import de.cau.cs.kieler.xkev.mapping.Move;
import de.cau.cs.kieler.xkev.mapping.SVGElement;
import de.cau.cs.kieler.xkev.mapping.SVGFile;
import de.cau.cs.kieler.xkev.mapping.Textbox;
import de.cau.cs.kieler.xkev.views.EclipseJSVGCanvas;

/**
 * This class connects the mapping-file with the corresponding SVG-file.
 * 
 * @author Stephan Knauer (skn) - skn[at]informatik.uni-kiel.de
 * 
 */
public class MapAnimations {

    /**
     * SVGFile is an instance of the created model .mapping file.
     */
    private SVGFile mappingFile;
    
    private final EclipseJSVGCanvas svgCanvas = EclipseJSVGCanvas.getInstance();

    private Map<String, EList<Animation>> svgElementsHashMap = null;

    public MapAnimations() {
        // We must make sure that the svgCanvas has already been created (xKEV-View must have been
        // initialized first)
        if (svgCanvas == null) {
            Activator.reportInfoMessage("The xKEV-View must be initialized first!");
            return;
        }

    }
    
    /**
     * Creates the MapAnimation instance and loads an mapping file either from Resource (examples/*)
     * isResource=true or from anywhere on the harddisk (isResource=false).
     * 
     * @param filename
     * @param isResource
     */

    public MapAnimations(String filename, boolean isResource) {
        // We must make sure that the svgCanvas has already been created (xKEV-View must have been
        // initialized first)
        if (svgCanvas == null) {
            Activator.reportInfoMessage("The xKEV-View must be initialized first!");
            return;
        }
        if (isResource) {
            // mappingFile not needed anymore, because we now deal with a HashMap
            // mappingFile = loadFromResource(filename);
            mappingFile = loadFromResource(filename);
        } else {
            // mappingFile = loadFromFile(filename);
            mappingFile = loadFromFile(filename);
        }
    }

    /**
     * Returns the actual JSVGCanvas.
     * 
     * @return svgCanvas
     */
    public EclipseJSVGCanvas getJSVGCanvas() {
        return svgCanvas;
    }

    /**
     * Returns the actual SVGDocument.
     * 
     * @return svgDocument
     */
    public SVGDocument getSVGDocument() {
        return svgCanvas.getSVGDocument();
    }

    
    /**
     * Return the current mapping file of this mapanimation.
     * @return
     */
    public final SVGFile getMappingFile() {
        return mappingFile;
    }
    
    
    /**
     * Loads an .mapping file from the resource example folder.
     * 
     * @param filename
     * @return svgFile which is the mapping file
     */
    // return wird eigenetlich nicht mehr ben�tigt -> besser als void implementieren?
    public final SVGFile loadFromResource(String filename) {
        // Initialize the model
        MappingPackage.eINSTANCE.eClass();
        
        // Register the XMI resource factory for the .mapping extension
        Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
        Map<String, Object> m = reg.getExtensionToFactoryMap();
        m.put("mapping", new XMIResourceFactoryImpl());

        // Obtain a new resource set
        ResourceSet resSet = new ResourceSetImpl();

        // Get the resource from examples folder
        Resource resource;
        SVGFile svgFile = null;
        try {
            // Get the resource from examples folder
            resource = resSet.getResource(URI.createPlatformPluginURI(Activator.PLUGIN_ID+"/examples/"+filename, true), true);
            // Get the first model element and cast it to the right type, in my
            // example everything is hierarchical included in this first node
            svgFile = (SVGFile) resource.getContents().get(0);        
            createHashMap(svgFile);
            if (!svgFile.getFilename().isEmpty()) {
                loadSpecifiedSVGFile(svgFile.getFilename());
            } else {
                Activator.reportInfoMessage("The svg file was't specified in the current mapping file ("+filename+")!");
                EclipseJSVGCanvas.getInstance().setSVGDocument(null);//Because we only want a valid mapping file for animation
            }

        } catch (WrappedException e) {
            // TODO Auto-generated catch block
            System.out.println("File: "+filename+" does not exists in the example folder!");
        }
        return svgFile;
    }

    /**
     * Loads an .mapping file from disk
     * 
     * @param filename
     * @return
     */

    public final SVGFile loadFromFile(String filename) {
        // Initialize the model
        MappingPackage.eINSTANCE.eClass();

        // Register the XMI resource factory for the .mapping extension
        Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
        Map<String, Object> m = reg.getExtensionToFactoryMap();
        m.put("mapping", new XMIResourceFactoryImpl());

        // Obtain a new resource set
        ResourceSet resSet = new ResourceSetImpl();

        // EXAMPLE: Resource resource =
        // resSet.getResource(URI.createURI("examples/Trafficlight.mapping"), true);
        Resource resource;
        SVGFile svgFile = null;

        try {
            System.out.println(URI.createURI(filename));
            // Get the resource from anywhere on the harddisk
            resource = resSet.getResource(URI.createURI(filename), true);
            // Get the first model element and cast it to the right type
            svgFile = (SVGFile) resource.getContents().get(0);
            createHashMap(svgFile);            
            
            if (!svgFile.getFilename().isEmpty()) {
                //Filename is absolute
                if (svgFile.getFilename().contains("file:/")) {
                    System.out.println(svgFile.getFilename());
                    loadSpecifiedSVGFile(svgFile.getFilename());
                } else {//Filename is relative
                    String tempPath;
                    tempPath = filename.substring(0,filename.lastIndexOf("/")+1) + svgFile.getFilename();
                    System.out.println(tempPath);
                    loadSpecifiedSVGFile(tempPath);
                }
            } else {
                Activator.reportInfoMessage("The svg file was't specified in the current mapping file ("+filename+")!");
            }
        } catch (WrappedException e) {
            // TODO Auto-generated catch block
            System.out.println("File: " + filename + " does not exists!");
        }
        return svgFile;
    }

    private void loadSpecifiedSVGFile(String filename) {
        SVGLoadingStatusListener loadingStatusListener = svgCanvas.getSVGLoadingStatusListener();

        if (filename.indexOf("resource:") == 0) {
            String path = filename.substring("resource:".length());
            // Get the resource from examples folder
            URL url = FileLocator.find(Activator.getDefault().getBundle(), new Path(path), null);

            System.out.println("Bundleentry: " + url.toExternalForm());
            // setSVGFile(url);
            // KevComposite.getInstance().setSVGFile(url);
            svgCanvas.loadSVGDocument(url.toExternalForm());
            // Sometimes on first load, the fileloading get's cancelled, don't know why and from
            // whom, so try again
            if (loadingStatusListener.getLoadingStatus() == SVGLoadingStatusListener.LOADING_CANCELLED) {
                // KevComposite.getInstance().paintSVGFile();
                svgCanvas.loadSVGDocument(url.toExternalForm());
            }
            // svgCanvas.loadSVGDocument(url.toExternalForm());
        } else {
            try {
                //URL url = new URL("file:/" + filename);
                URL url = new URL(filename);
                // KevComposite.getInstance().setSVGFile(url);
                svgCanvas.loadSVGDocument(url.toExternalForm());
                // Sometimes on first load, the fileloading get's cancelled, don't know why and from
                // whom so try again
                if (loadingStatusListener.getLoadingStatus() == SVGLoadingStatusListener.LOADING_CANCELLED) {
                    // KevComposite.getInstance().paintSVGFile();
                    svgCanvas.loadSVGDocument(url.toExternalForm());
                }
            } catch (MalformedURLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        // Wait until loading was successful or an Errorstatus occurs (status < 2)
        while (loadingStatusListener.getLoadingStatus() < SVGLoadingStatusListener.LOADING_COMPLETED) {
        }
    }

    /**
     * This Method creates a HashMap of SVGElements of the actual Mapping file.
     * 
     */
    private synchronized void createHashMap(SVGFile mappingFile) {
        this.svgElementsHashMap = new HashMap<String, EList<Animation>>();
        Iterator<SVGElement> elementIterator = mappingFile.getSvgElement().iterator();
        SVGElement svgElement;
        while (elementIterator.hasNext()) {
            svgElement = elementIterator.next();
            this.svgElementsHashMap.put(svgElement.getId(), svgElement.getAnimation());
        }
    }

    /**
     * Applies the Animations for all JSON-Keys which exists in the mapping file.
     * 
     * @param jsonObject
     */
    public void doAnimations(JSONObject jsonObject) {
        // Check whether the HashMap has been created
        if (this.svgElementsHashMap == null) {
            System.out.println("HashMap is not initialized!");
            return;
        }
        
        try {
//            System.out.println(jsonObject.toString());
            //Now we have to make the JSONobject flat, so that we can address all key by "." notation.
            JSONObject flatJSONObject = makeItFlat(jsonObject);
//            System.out.println(flatJSONObject.toString());
            //For each svg element id we need to check if all any animation can be applied. 
            Iterator<String> svgElementIDIterator = svgElementsHashMap.keySet().iterator();
            while (svgElementIDIterator.hasNext()) {
                String svgElementID = svgElementIDIterator.next();
                // Get all animations for each SVG element
                Iterator<Animation> animationIterator = svgElementsHashMap.get(svgElementID).iterator();

                Animation animation;
                while (animationIterator.hasNext()) {
                    animation = animationIterator.next();

                    // We need to apply all animations for each SVG element
                    if (animation instanceof Colorize) {
                        Colorize colorizeAnimation = (Colorize) animation;
                        colorizeAnimation.applyAnimation(flatJSONObject, svgElementID);
                    } else if (animation instanceof Move) {
                        Move moveAnimation = (Move) animation;
                        moveAnimation.applyAnimation(flatJSONObject, svgElementID);
                    } else if (animation instanceof Textbox) {
                        Textbox textboxAnimation = (Textbox) animation;
                        textboxAnimation.applyAnimation(flatJSONObject, svgElementID);
                    } else {
                        System.out.println("Animation " + animation.getClass().getSimpleName()
                                + " does not exists!");
                    }

                }
            }
            // Now we still need to apply all animations to the SVG document
            updateSVGGraphik();
        } catch (JSONException e) {
            //Something went wrong with the JSONObject.
        }
    }
    
    //OLD VERSION DOES ONLY ANIMATIONS IF THE JSON KEY EQUALS THE SVG ELEMENT ID
    //------------------------------------------------------------------------------------------
//    /**
//     * Applies the Animations for all JSON-Keys which exists in the mapping file.
//     * 
//     * @param jsonObject
//     */
//    public void doAnimations(JSONObject jsonObject) {
//        // Check whether the HashMap has been created
//        if (this.svgElementsHashMap == null) {
//            System.out.println("HashMap is not initialized!");
//            return;
//        }
//        
//        try {
//            System.out.println(jsonObject.toString());
//            //Now we have to make the JSONobject flat, so that we can address all key by "." notation.
//            JSONObject flatJSONObject = makeItFlat(jsonObject);
//            System.out.println(flatJSONObject.toString());
//            // Get all JSON-Key-Names from the flatJSONobject
//            String[] keys = JSONObject.getNames(flatJSONObject);
//            for (String key : keys) {
//                // Now we need to check for each JSON-Key if there exists a SVGElement-Tag in the
//                // Mapping-HashMap
//                if (this.svgElementsHashMap.containsKey(key)) {
//                    // Get all animations for each SVG element
//                    Iterator<Animation> animationIterator = svgElementsHashMap.get(key).iterator();
//    
//                    Animation animation;
//                    while (animationIterator.hasNext()) {
//                        animation = animationIterator.next();
//    
//                        // We need to apply all animations for each SVG element
//                        if (animation instanceof Colorize) {
//                            Colorize colorizeAnimation = (Colorize) animation;
//                            colorizeAnimation.applyAnimation(flatJSONObject, key);
//                        } else if (animation instanceof Move) {
//                            Move moveAnimation = (Move) animation;
//                            moveAnimation.applyAnimation(flatJSONObject, key);
//                        } else if (animation instanceof Textbox) {
//                            Textbox textboxAnimation = (Textbox) animation;
//                            textboxAnimation.applyAnimation(flatJSONObject, key);
//                        } else {
//                            System.out.println("Animation " + animation.getClass().getSimpleName()
//                                    + " does not exists!");
//                        }
//    
//                    }
//                }
//            }
//            // Now we still need to apply all animations to the SVG document
//            updateSVGGraphik();
//        } catch (JSONException e) {
//            //Something went wrong with the JSONObject.
//        }
//    }
// --------------------------------------------------------------------------------------------------
    /**
     * This function is intensively used by the mapInputToOutput() method. It simply creates an
     * ArrayList with no duplicates of the inputstring.
     * 
     */
    private ArrayList<String> generateArrayListFromInput(String input, boolean integerOnly) {
        ArrayList<String> inputArray = new ArrayList<String>();
        HashSet<String> inputSet = new HashSet<String>();
        // Now we begin with the input tokens
        String pattern;
        if (integerOnly) {
            // Allow only valid integer values.
            pattern = "[-]?[\\d]+";
        } else {
            // Allow all chars, except these ",;[]"
            pattern = "[^,;\\[\\]]+";
        }

        if (Pattern.matches("\\[([^,\\[\\]]+[,])*[^,\\[\\]]+\\]", input)) {
            // Correct brackets for a valid list
            // System.out.println("Korrekte Liste: "+input);
            Scanner inputScanner = new Scanner(input).useDelimiter("[\\[,\\]]");
            while (inputScanner.hasNext()) {
                // This means a range plus a distance between [number1]:[number2]
                if (inputScanner.hasNext("[-]?[\\d]+:[-]?[\\d]+[.]{2,3}[-]?[\\d]+")) {
                    Scanner sc = new Scanner(inputScanner.next()).useDelimiter("[.:]+");
                    // We have exactly three integer values if this pattern matches
                    int first, second, last;
                    first = sc.nextInt();
                    second = sc.nextInt();
                    last = sc.nextInt();
                    if (first < second && last >= second) {
                        // Example: [200:210..220] = three steps (200, 210, 220)
                        for (int i = first; i < last; i += (second - first)) {
                            if (inputSet.add(Integer.toString(i))) {
                                inputArray.add(Integer.toString(i));
                            }// Else, the input is already in the Array
                        }
                    } else if (first > second && last <= second) {
                        // Example: [220:210..210] = two steps (220, 210)
                        for (int i = first; i > last; i -= (first - second)) {
                            if (inputSet.add(Integer.toString(i))) {
                                inputArray.add(Integer.toString(i));
                            }// Else, the input is already in the Array
                        }
                    } // Others makes no sense
                } else if (inputScanner.hasNext("[-]?[\\d]+[.]{2,3}[-]?[\\d]+")) {// Test if the
                                                                                  // next input
                                                                                  // matches
                                                                                  // "[-]NUMBER..[.][-]NUMBER"
                    // Now we know, that the inputScanner.next() contains exactly 2 integer values
                    Scanner sc = new Scanner(inputScanner.next()).useDelimiter("[.]+");
                    int leftint = sc.nextInt();
                    int rightint = sc.nextInt();
                    // int min, max;
                    // min = Math.min(leftint, rightint);
                    // max = Math.max(leftint, rightint);
                    if (leftint <= rightint) {
                        for (int j = leftint; j <= rightint; j++) {
                            if (inputSet.add(Integer.toString(j))) {
                                inputArray.add(Integer.toString(j));
                            }// Else, the input is already in the Array
                        }
                    } else {// leftint is greater then rightint
                        for (int j = leftint; j >= rightint; j--) {
                            if (inputSet.add(Integer.toString(j))) {
                                inputArray.add(Integer.toString(j));
                            }// Else, the input is already in the Array
                        }
                    }
                } else {
                    String token = inputScanner.next();
                    if (Pattern.matches(pattern, token)) {
                        // The input can be everything now
                        if (inputSet.add(token)) {
                            inputArray.add(token);
//                            System.out.println("Genau ein Wert: "+token);
                        }
                    } else {
                        // Error - wrong Syntax, was not accepted!
//                        System.out.println("Falsche Syntax: "+token);
                    }
                }
            }
        } else if (Pattern.matches(pattern, input)) {
            // Valid value (exactly one)
//            System.out.println("Genau ein Wert: "+input);
            if (inputSet.add(input)) {
                inputArray.add(input);
            }// Else, the input is already in the Array
        } else {
            // Error - wrong Syntax, was not accepted!
//            System.out.println("Falsche Syntax: "+input);
        }
        // for (int i=0; i<inputArray.size(); i++) System.out.print(inputArray.get(i)+",");
        // System.out.println();
        return inputArray;
    }

    /**
     * The short version for the normal case that all values are excepted.
     */
    public ArrayList<HashMap<String, String>> mapInputToOutput(String input, String output) {
        return mapInputToOutput(input, output, false);
    }

    /**
     * THIS Method is really important and should be used for all animations! This method maps the
     * input values to the corespondig output values. input is always the input from mapping file
     * whereby output can be any value of the special animation to which the input values should be
     * mapped.
     * 
     * Example: input="[1..10,20..30];[40,45,50];900"
     * output=x_range="[200..215,220,225,230,235,240];[1..3];200" PROBLEME MIT DEM PARSEN DES
     * OUTPUTS HIER NOCHMAL SCHAUEN!
     */
    public ArrayList<HashMap<String, String>> mapInputToOutput(String input, String output,
            boolean outputIntegerOnly) {
        // First of all, we delete any space in the input an output strings
        String in, out;
        in = input.replace(" ", "");
        out = output.replace(" ", "");
        // At the beginning we want to separate all inputs and outputs specified by ";"
        StringTokenizer inTokenizer = new StringTokenizer(in, ";");
        StringTokenizer outTokenizer = new StringTokenizer(out, ";");
        // System.out.println("in:"+in+" out:"+out);
        // System.out.println("#in:"+inTokenizer.countTokens()+" #out:"+outTokenizer.countTokens());
        // System.out.println("inTokenizer:");
        // while (inTokenizer.hasMoreTokens()) {
        // System.out.println(inTokenizer.nextToken());
        // }
        // System.out.println("outTokenizer:");
        // while (outTokenizer.hasMoreTokens()) {
        // System.out.println(outTokenizer.nextToken());
        // }
        // Now we need to check whether the number of input tokens is the same as the number of
        // output tokens.
        // If not, we need to compare only to the minimum of both
        int minTokens = Math.min(inTokenizer.countTokens(), outTokenizer.countTokens());
        ArrayList<HashMap<String, String>> hashMapArray = new ArrayList<HashMap<String, String>>();
        for (int i = 0; i < minTokens; i++) {
            // Now for each token, we create an ArrayList first an parallel to it a HashSet to
            // guarantee that each value
            // exists only once in the ArrayList.
            ArrayList<String> inputArray = new ArrayList<String>();
            ArrayList<String> outputArray = new ArrayList<String>();

            // For each token we generate an input and output Array
            // and create a HashMap of it
            HashMap<String, String> hashMap = new HashMap<String, String>();
            inputArray = generateArrayListFromInput(inTokenizer.nextToken(), false); // The input
                                                                                     // should
                                                                                     // always allow
                                                                                     // all values
            outputArray = generateArrayListFromInput(outTokenizer.nextToken(), outputIntegerOnly);

            Iterator<String> inputIterator = inputArray.iterator();
            Iterator<String> outputIterator = outputArray.iterator();

            // Do some size calculation
            // Only go on, if we have two arrays which are greater then zero
            if (Math.min(inputArray.size(), outputArray.size()) > 0) {
                if (inputArray.size() > outputArray.size()) {
                    // This is the cyclic version
                    while (inputIterator.hasNext()) {
                        // This while loop is necessary for the cyclic mapping
                        for (int j = 0; j < outputArray.size(); j++) {
                            if (inputIterator.hasNext()) {
                                hashMap.put(inputIterator.next(), outputArray.get(j));
                            }
                        }
                    }
                } else if (inputArray.size() == outputArray.size()) {
                    while (inputIterator.hasNext()) {
                        hashMap.put(inputIterator.next(), outputIterator.next());
                    }
                } else {// inputArray.size() < outputArray.size()
                    for (int j = 0; j < inputArray.size(); j++) {
                        hashMap.put(inputArray.get(j), outputArray.get(j));
                    }
                }
            }

            // DEBUG-BEGIN
            // System.out.println("hashMapSize: "+hashMap.size());
            // Iterator<String> it = hashMap.keySet().iterator();
            // String key;
            // while (it.hasNext()) {
            // key = it.next();
            // System.out.println("Input: "+i+" Key: "+key+" Value: "+hashMap.get(key));
            // }
            // DEBUG-END

            // Now the actual token is successfully saved in the hashMap.
            // So we just need to put it to the HashMap-ArrayList
            hashMapArray.add(hashMap);
        }
        return hashMapArray;
    }

    /**
     * The values of the special animation is a single value for each input value separated by ";".
     * 
     * @param inputValue
     * @return
     */
    public String[] parseValueString(String inputValue) {
        // First we need to seperate each value pairs (symbolized by ";")
        // First of all delete all whitespace of inputValue
        ArrayList<String> arrayList = new ArrayList<String>();
        StringTokenizer tokenizer = new StringTokenizer(inputValue.replaceAll(" ", ""), ";");
        while (tokenizer.hasMoreTokens()) {
            arrayList.add(tokenizer.nextToken());
        }
        // Now the arrayList contains all validValues for each input, separated by ";"
        return arrayList.toArray(new String[arrayList.size()]);
    }

    /**
     * Just updates the actual SVGDocument.
     */
    private void updateSVGGraphik() {
        svgCanvas.setSVGDocument(svgCanvas.getSVGDocument());
    }

    
    // ----------------------------------------------------------------------------------------------
    //Should be put later on to the JSON package

    /**
     * Make the input jsonobject flat if there exists a hirachie. This one should be called instead
     * of the other version of makeItFlat, which has some initial value parameters for recursive
     * computation.
     * 
     * @param inputObject
     * @return
     * @throws JSONException
     */
    public final JSONObject makeItFlat(JSONObject inputObject) throws JSONException {
        return makeItFlat(new JSONObject(), "", inputObject);
    }

    /**
     * Computes the flat JSONObject. Is just a helper function.
     * 
     * @param flatOne
     * @param adressKey
     * @param inputObject
     * @return
     * @throws JSONException
     */

    private static JSONObject makeItFlat(JSONObject flatOne, String adressKey,
            JSONObject inputObject) throws JSONException {
        String[] keys = JSONObject.getNames(inputObject);
        if (keys == null) {
            //If there exists no key try it must be an empty json object
            if (!adressKey.isEmpty()) {
                flatOne.put(adressKey, new JSONObject());
            }
        } else {
            for (String key : keys) {
                if (inputObject.optJSONObject(key) == null) {
                    if (adressKey.isEmpty()) {
                        flatOne.put(key, inputObject.optString(key));
                    } else {
                        flatOne.put(adressKey + "." + key, inputObject.optString(key));
                    }
                } else {
                    if (adressKey.isEmpty()) {
                        makeItFlat(flatOne, key, inputObject.optJSONObject(key));
                        //Add the toplevel objects to the result object (that are the svgelement id's)
                        //flatOne.put(key, JSONObject.NULL);
                    } else {
                        makeItFlat(flatOne, adressKey + "." + key, inputObject.optJSONObject(key));
                    }
                }
            }
        }
        return flatOne;
    }
}
