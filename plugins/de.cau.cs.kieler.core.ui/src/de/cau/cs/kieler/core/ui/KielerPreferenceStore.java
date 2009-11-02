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
 */
package de.cau.cs.kieler.core.ui;

import org.eclipse.jface.preference.IPreferenceStore;

import de.cau.cs.kieler.core.IKielerPreferenceStore;

/**
 * Wrapper class for Eclipse preference stores.
 * 
 * @author <a href="mailto:msp@informatik.uni-kiel.de">Miro Sp&ouml;nemann</a>
 */
public class KielerPreferenceStore implements IKielerPreferenceStore {

    /** the contained Eclipse preference store. */
    private IPreferenceStore preferenceStore;

    /**
     * Creates a preference store wrapper from a given
     * <code>IPreferenceStore</code>.
     * 
     * @param thepreferenceStore the wrapped preference store
     */
    public KielerPreferenceStore(final IPreferenceStore thepreferenceStore) {
        this.preferenceStore = thepreferenceStore;
    }

    /**
     * {@inheritDoc}
     */
    public boolean contains(final String name) {
        return preferenceStore.contains(name);
    }

    /**
     * {@inheritDoc}
     */
    public boolean getBoolean(final String name) {
        return preferenceStore.getBoolean(name);
    }

    /**
     * {@inheritDoc}
     */
    public boolean getDefaultBoolean(final String name) {
        return preferenceStore.getDefaultBoolean(name);
    }

    /**
     * {@inheritDoc}
     */
    public double getDefaultDouble(final String name) {
        return preferenceStore.getDefaultDouble(name);
    }

    /**
     * {@inheritDoc}
     */
    public float getDefaultFloat(final String name) {
        return preferenceStore.getDefaultFloat(name);
    }

    /**
     * {@inheritDoc}
     */
    public int getDefaultInt(final String name) {
        return preferenceStore.getDefaultInt(name);
    }

    /**
     * {@inheritDoc}
     */
    public long getDefaultLong(final String name) {
        return preferenceStore.getDefaultLong(name);
    }

    /**
     * {@inheritDoc}
     */
    public String getDefaultString(final String name) {
        return preferenceStore.getDefaultString(name);
    }

    /**
     * {@inheritDoc}
     */
    public double getDouble(final String name) {
        return preferenceStore.getDouble(name);
    }

    /**
     * {@inheritDoc}
     */
    public float getFloat(final String name) {
        return preferenceStore.getFloat(name);
    }

    /**
     * {@inheritDoc}
     */
    public int getInt(final String name) {
        return preferenceStore.getInt(name);
    }

    /**
     * {@inheritDoc}
     */
    public long getLong(final String name) {
        return preferenceStore.getLong(name);
    }

    /**
     * {@inheritDoc}
     */
    public String getString(final String name) {
        return preferenceStore.getString(name);
    }

    /**
     * {@inheritDoc}
     */
    public boolean isDefault(final String name) {
        return preferenceStore.isDefault(name);
    }

    /**
     * {@inheritDoc}
     */
    public void setDefault(final String name, final double value) {
        preferenceStore.setDefault(name, value);
    }

    /**
     * {@inheritDoc}
     */
    public void setDefault(final String name, final float value) {
        preferenceStore.setDefault(name, value);
    }

    /**
     * {@inheritDoc}
     */
    public void setDefault(final String name, final int value) {
        preferenceStore.setDefault(name, value);
    }

    /**
     * {@inheritDoc}
     */
    public void setDefault(final String name, final long value) {
        preferenceStore.setDefault(name, value);
    }

    /**
     * {@inheritDoc}
     */
    public void setDefault(final String name, final String value) {
        preferenceStore.setDefault(name, value);
    }

    /**
     * {@inheritDoc}
     */
    public void setDefault(final String name, final boolean value) {
        preferenceStore.setDefault(name, value);
    }

    /**
     * {@inheritDoc}
     */
    public void setToDefault(final String name) {
        preferenceStore.setToDefault(name);
    }

    /**
     * {@inheritDoc}
     */
    public void setValue(final String name, final double value) {
        preferenceStore.setValue(name, value);
    }

    /**
     * {@inheritDoc}
     */
    public void setValue(final String name, final float value) {
        preferenceStore.setValue(name, value);
    }

    /**
     * {@inheritDoc}
     */
    public void setValue(final String name, final int value) {
        preferenceStore.setValue(name, value);
    }

    /**
     * {@inheritDoc}
     */
    public void setValue(final String name, final long value) {
        preferenceStore.setValue(name, value);
    }

    /**
     * {@inheritDoc}
     */
    public void setValue(final String name, final String value) {
        preferenceStore.setValue(name, value);
    }

    /**
     * {@inheritDoc}
     */
    public void setValue(final String name, final boolean value) {
        preferenceStore.setValue(name, value);
    }

}
