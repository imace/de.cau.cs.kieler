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
package de.cau.cs.kieler.core;

/**
 * An Exception that indicates problems with certain model elements. Main
 * difference to the normal KielerException is that it carries a reference
 * to an arbitrary object that is supposed to be the causing model
 * part.
 * @author haf
 *
 */
public class KielerModelException extends KielerException {

    Object causingModelObject;
    
    /**
     * @param message exception message
     * @param causingModelObject the model object that has caused the exception.
     *        Likely an EObject, if the metamodel is EMF.
     */
    public KielerModelException(String message, Object causingModelObject) {
        super(message);
        this.causingModelObject = causingModelObject;
    }

    /**
     * @param message exception message
     * @param causingModelObject the model object that has caused the exception.
     *        Likely an EObject, if the metamodel is EMF.
     * @param cause Causing Exception
     */
    public KielerModelException(String message, Object causingModelObject, Exception cause) {
        super(message, cause);
        this.causingModelObject = causingModelObject;
    }
    
    /**
     * @return the model object that has caused this Exception. Likely to be an
     *         EMF EObject if the used metamodeling framework is EMF.
     */
    public Object getModelObject(){
        return causingModelObject;
    }
    
}
