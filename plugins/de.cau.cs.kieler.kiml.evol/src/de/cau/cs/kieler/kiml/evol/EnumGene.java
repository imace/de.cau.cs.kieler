/*
 * KIELER - Kiel Integrated Environment for Layout Eclipse RichClient
 *
 * http://www.informatik.uni-kiel.de/rtsys/kieler/
 * 
 * Copyright 2010 by
 * + Christian-Albrechts-University of Kiel
 *   + Department of Computer Science
 *     + Real-Time and Embedded Systems Group
 * 
 * This code is provided under the terms of the Eclipse Public License (EPL).
 * See the file epl-v10.html for the license text.
 */
package de.cau.cs.kieler.kiml.evol;

import org.eclipse.core.runtime.Assert;

import de.cau.cs.kieler.kiml.evol.MutationInfo.Distribution;

/**
 * 
 * @author bdu
 */
public final class EnumGene extends IntegerGene {
    @Override
    public IGene<Integer> newInstance(final AbstractGene<Integer> template) {
        if (template instanceof EnumGene) {
            return new EnumGene(template.getId(), template.getValue(), this.enumClass,
                    getMutationInfo().getProbability());
        }
        // incompatible template
        return null;
    }
    
    @Override
    public IGene<Integer> newMutation() {
        IGene<Integer> template = super.newMutation();
        IGene<Integer> result = new EnumGene(template.getId(), template.getValue(), this.enumClass,
                getMutationInfo().getProbability());
        return result;
    }

    /**
     * 
     * @param theId
     *            the id
     * @param theValue
     *            the value
     * @param theEnumClass
     *            the enumeration class. Must not be null.
     * @param theMutationProbability
     *            mutation probability
     */
    public EnumGene(
            final Object theId,
            final int theValue,
            final Class<? extends Enum<?>> theEnumClass,
            final double theMutationProbability) {
        super(theId, theValue, new TypeInfo<Integer>(0, 0, choicesCount(theEnumClass) - 1,
                Integer.class),
        // TODO: use enum class?
                new MutationInfo(theMutationProbability, Distribution.UNIFORM));
        Assert.isLegal(theEnumClass != null);
        setEnumClass(theEnumClass);
    }
    
    /**
     * 
     * @return A string representation if this instance.
     */
    @Override
    public String toString() {
        Assert.isNotNull(this.enumClass);
        Enum<?>[] constants = this.enumClass.getEnumConstants();
        if (constants == null) {
            return "";
        }
        final int value = getValue();
        Assert.isTrue(value >= 0 && value < constants.length);
        final String result = constants[value].toString();
        return result;
    }

    /**
     * Determines the number of possible choices in the given enumeration.
     * 
     * @param theEnumClass
     *            an enumeration class
     * @return number of choices in the given enumeration.
     */
    private static int choicesCount(final Class<? extends Enum<?>> theEnumClass) {
        Assert.isLegal(theEnumClass != null);
        return theEnumClass.getEnumConstants().length;
    }
    
    private void setEnumClass(final Class<? extends Enum<?>> theEnumClass) {
        this.enumClass = theEnumClass;
    }
    
    // private fields
    private Class<? extends Enum<?>> enumClass;
}

