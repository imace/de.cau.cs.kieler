/*
 * KIELER - Kiel Integrated Environment for Layout Eclipse RichClient
 *
 * http://www.informatik.uni-kiel.de/rtsys/kieler/
 * 
 * Copyright 2011 by
 * + Christian-Albrechts-University of Kiel
 *   + Department of Computer Science
 *     + Real-Time and Embedded Systems Group
 * 
 * This code is provided under the terms of the Eclipse Public License (EPL).
 * See the file epl-v10.html for the license text.
 */
package de.cau.cs.kieler.kiml.ui;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;

import de.cau.cs.kieler.core.annotations.Annotatable;
import de.cau.cs.kieler.core.annotations.Annotation;
import de.cau.cs.kieler.core.annotations.AnnotationsFactory;
import de.cau.cs.kieler.core.annotations.BooleanAnnotation;
import de.cau.cs.kieler.core.annotations.FloatAnnotation;
import de.cau.cs.kieler.core.annotations.IntAnnotation;
import de.cau.cs.kieler.core.annotations.StringAnnotation;
import de.cau.cs.kieler.kiml.ILayoutData;
import de.cau.cs.kieler.kiml.LayoutAlgorithmData;
import de.cau.cs.kieler.kiml.LayoutOptionData;
import de.cau.cs.kieler.kiml.LayoutDataService;
import de.cau.cs.kieler.kiml.LayoutTypeData;
import de.cau.cs.kieler.kiml.SemanticLayoutConfig;
import de.cau.cs.kieler.kiml.options.LayoutOptions;

/**
 * A semantic layout configurations for annotations.
 *
 * @author msp
 */
public class AnnotationsLayoutConfig extends SemanticLayoutConfig {
    
    /** a caching map for layout option data. */
    private Map<String, LayoutOptionData<?>> optionDataMap;
    
    /**
     * Return a layout option data for the given identifier.
     * 
     * @param id an identifier
     * @return the corresponding option data
     */
    private LayoutOptionData<?> getOptionData(final String id) {
        if (optionDataMap == null) {
            optionDataMap = new HashMap<String, LayoutOptionData<?>>();
            LayoutDataService layoutServices = LayoutDataService.getInstance();
            for (LayoutOptionData<?> optionData : layoutServices.getOptionData()) {
                String optionId = optionData.getId();
                int dotIndex = optionId.lastIndexOf('.');
                if (dotIndex >= 0) {
                    optionDataMap.put(optionId.substring(dotIndex + 1), optionData);
                }
                optionDataMap.put(optionId, optionData);
            }
        }
        return optionDataMap.get(id);
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    protected List<LayoutOptionData<?>> getOptionData(final EObject semanticElem) {
        List<LayoutOptionData<?>> data = new LinkedList<LayoutOptionData<?>>();
        if (semanticElem instanceof Annotatable) {
            for (Annotation annotation : ((Annotatable) semanticElem).getAnnotations()) {
                LayoutOptionData<?> option = getOptionData(annotation.getName());
                if (option != null) {
                    data.add(option);
                }
            }
        }
        return data;
    }

    /**
     * Return an annotation that matches the given identifier, if present.
     * 
     * @param annotatable an annotatable object
     * @param optionId a layout option identifier
     * @return an annotation, or {@code null}
     */
    private Annotation getAnnotation(final Annotatable annotatable, final String optionId) {
        Annotation result = annotatable.getAnnotation(optionId);
        if (result != null) {
            return result;
        }
        int dotIndex = optionId.lastIndexOf('.');
        if (dotIndex >= 0) {
            return annotatable.getAnnotation(optionId.substring(dotIndex + 1));
        }
        return null;
    }
    
    /**
     * Return the value of the given annotation.
     * 
     * @param annotation an annotation
     * @param optionData the layout option data
     * @return the annotation value, or {@code null}
     */
    private Object getValue(final Annotation annotation, final LayoutOptionData<?> optionData) {
        if (annotation instanceof StringAnnotation) {
            String value = ((StringAnnotation) annotation).getValue();
            if (optionData.getId().equals(LayoutOptions.ALGORITHM_ID)) {
                ILayoutData layoutData = getAlgorithmData(value);
                if (layoutData != null) {
                    return layoutData.getId();
                }
            } else {
                return optionData.parseValue(value);
            }
        } else if (annotation instanceof IntAnnotation) {
            if (optionData.getType() == LayoutOptionData.Type.INT) {
                return ((IntAnnotation) annotation).getValue();
            }
        } else if (annotation instanceof FloatAnnotation) {
            if (optionData.getType() == LayoutOptionData.Type.FLOAT) {
                return ((FloatAnnotation) annotation).getValue();
            }
        } else if (annotation instanceof BooleanAnnotation) {
            if (optionData.getType() == LayoutOptionData.Type.BOOLEAN) {
                return ((BooleanAnnotation) annotation).isValue();
            }
        }
        return null;
    }
    
    /** a caching map for layout algorithm data. */
    private Map<String, ILayoutData> algorithmDataMap;
    
    /**
     * Return a layout algorithm data for the given identifier.
     * 
     * @param id an identifier
     * @return the corresponding algorithm data
     */
    private ILayoutData getAlgorithmData(final String id) {
        if (algorithmDataMap == null) {
            algorithmDataMap = new HashMap<String, ILayoutData>();
            LayoutDataService layoutServices = LayoutDataService.getInstance();
            // add layout type data to the cache
            for (LayoutTypeData typeData : layoutServices.getTypeData()) {
                String typeId = typeData.getId();
                int dotIndex = typeId.lastIndexOf('.');
                if (dotIndex >= 0) {
                    algorithmDataMap.put(typeId.substring(dotIndex + 1), typeData);
                }
                algorithmDataMap.put(typeId, typeData);
            }
            // add layout algorithm data to the cache
            for (LayoutAlgorithmData algorithmData : layoutServices.getAlgorithmData()) {
                String algoId = algorithmData.getId();
                int dotIndex = algoId.lastIndexOf('.');
                if (dotIndex >= 0) {
                    algorithmDataMap.put(algoId.substring(dotIndex + 1), algorithmData);
                }
                algorithmDataMap.put(algoId, algorithmData);
            }
        }
        return algorithmDataMap.get(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Object getSemanticProperty(final EObject semanticElem,
            final LayoutOptionData<?> layoutOption) {
        if (semanticElem instanceof Annotatable) {
            Annotation annotation = getAnnotation((Annotatable) semanticElem, layoutOption.getId());
            if (annotation != null) {
                return getValue(annotation, layoutOption);
            }
        }
        return null;
    }
    
    /**
     * Set the value of the given annotation.
     * 
     * @param annotation an annotation
     * @param optionData the layout option data
     * @param value the new annotation value
     */
    private void setValue(final Annotation annotation, final LayoutOptionData<?> optionData,
            final Object value) {
        if (annotation instanceof StringAnnotation) {
            ((StringAnnotation) annotation).setValue(value.toString());
        } else if (annotation instanceof IntAnnotation) {
            if (optionData.getType() == LayoutOptionData.Type.INT && value instanceof Integer) {
                ((IntAnnotation) annotation).setValue((Integer) value);
            }
        } else if (annotation instanceof FloatAnnotation) {
            if (optionData.getType() == LayoutOptionData.Type.FLOAT && value instanceof Float) {
                ((FloatAnnotation) annotation).setValue((Float) value);
            }
        } else if (annotation instanceof BooleanAnnotation) {
            if (optionData.getType() == LayoutOptionData.Type.BOOLEAN && value instanceof Boolean) {
                ((BooleanAnnotation) annotation).setValue((Boolean) value);
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void setSemanticProperty(final EObject semanticElem,
            final LayoutOptionData<?> layoutOption, final Object value) {
        if (semanticElem instanceof Annotatable) {
            Annotatable annotatable = (Annotatable) semanticElem;
            if (value == null) {
                annotatable.removeAllAnnotations(layoutOption.getId());
            } else {
                Annotation annotation = getAnnotation(annotatable, layoutOption.getId());
                if (annotation != null) {
                    setValue(annotation, layoutOption, value);
                } else {
                    StringAnnotation newAnnot = AnnotationsFactory.eINSTANCE.createStringAnnotation();
                    newAnnot.setName(layoutOption.getId());
                    newAnnot.setValue(value.toString());
                    annotatable.getAnnotations().add(newAnnot);
                }
            }
        }
    }

}
