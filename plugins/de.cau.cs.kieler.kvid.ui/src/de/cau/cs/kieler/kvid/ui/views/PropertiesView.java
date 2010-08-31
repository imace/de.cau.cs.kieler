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
package de.cau.cs.kieler.kvid.ui.views;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.eclipse.gmf.runtime.notation.Connector;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.CellLabelProvider;
import org.eclipse.jface.viewers.ComboBoxCellEditor;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;

import de.cau.cs.kieler.core.model.util.ModelingUtil;
import de.cau.cs.kieler.kvid.datadistributor.IPropertyListener;
import de.cau.cs.kieler.kvid.datadistributor.Property;
import de.cau.cs.kieler.kvid.datadistributor.RuntimeConfiguration;

/**
 * 
 * Eclipse view for editing KViD properties by hand.
 * 
 * @author jjc
 *
 */
public class PropertiesView extends ViewPart implements IPropertyListener, ISelectionChangedListener {
    
    private TableViewer tableViewer;
    
    private List<String> currentlySelectedParts = null;
    
    private IEditorPart currentPart = null;
    
    private static final int COLUMN_WIDTH = 250;

    @Override
    /**
     * {@inheritDoc}
     */
    public void createPartControl(final Composite parent) {       
        RuntimeConfiguration.getInstance().addPropertyListener(this);
        IPartListener partListener = new IPartListener() {
            public void partActivated(final IWorkbenchPart part) {
                if (part instanceof IEditorPart) {
                    currentPart = (IEditorPart) part;
                    currentPart.getSite().getSelectionProvider()
                        .addSelectionChangedListener(PropertiesView.this);
                }
            }
            public void partDeactivated(final IWorkbenchPart part) {
            }
            public void partBroughtToTop(final IWorkbenchPart part) {
            }
            public void partClosed(final IWorkbenchPart part) {
                if (part == currentPart) {
                    currentPart
                            .getSite()
                            .getSelectionProvider()
                            .removeSelectionChangedListener(PropertiesView.this);
                    currentPart = null;
                }
            }
            public void partOpened(final IWorkbenchPart part) {
            }
        };
        PlatformUI.getWorkbench().getActiveWorkbenchWindow().getPartService()
                .addPartListener(partListener);
        
        tableViewer = new TableViewer(parent, SWT.NONE);
        Table propertyTable = tableViewer.getTable();
        propertyTable.setHeaderVisible(true);
        propertyTable.setLinesVisible(true);
        
        TableViewerColumn viewerPropertyColumn = new TableViewerColumn(tableViewer, SWT.NONE);
        viewerPropertyColumn.getColumn().setText("Property");
        viewerPropertyColumn.getColumn().setWidth(COLUMN_WIDTH);
        
        TableViewerColumn viewerValueColumn = new TableViewerColumn(tableViewer, SWT.NONE);
        viewerValueColumn.getColumn().setText("Value");
        viewerValueColumn.getColumn().setWidth(COLUMN_WIDTH);
        
        tableViewer.setContentProvider(ArrayContentProvider.getInstance());
                
        viewerPropertyColumn.setLabelProvider(new CellLabelProvider() {
            
            @Override
            public void update(final ViewerCell cell) {
                cell.setText(((Property) (cell.getElement())).getName());
            }
        });
        
        viewerValueColumn.setLabelProvider(new CellLabelProvider() {
            
            @Override
            public void update(final ViewerCell cell) {
                cell.setText(((Property) (cell.getElement())).getCurrentValue());
            }
        });
        
        viewerValueColumn.setEditingSupport(new EditingSupport(tableViewer) {
            
            @Override
            protected void setValue(final Object element, final Object value) {
                if (((Property) element).isFreeText()) {
                    ((Property) element).setCurrentValue(String.valueOf(value));
                } else {
                    ((Property) element).setCurrentValue((Integer) value);
                }
                tableViewer.refresh(element);
            }
            
            @Override
            protected Object getValue(final Object element) {
                if (((Property) element).isFreeText()) {
                    return ((Property) element).getCurrentValue();
                } else {
                    return ((Property) element).getCurrentValueNumber();
                }
            }
            
            @Override
            protected CellEditor getCellEditor(final Object element) {
                CellEditor cell;
                if (((Property) element).isFreeText()) {
                    cell = new TextCellEditor(tableViewer.getTable());
                } else {
                    cell = new ComboBoxCellEditor(tableViewer.getTable(),
                            ((Property) element).getValueNames(), SWT.READ_ONLY);
                }
                return cell;
            }
            
            @Override
            protected boolean canEdit(final Object element) {
                return true;
            }
        });
        
        
        tableViewer.setInput(RuntimeConfiguration.getInstance()
                .getReferedProperties(currentlySelectedParts));
    }

    @Override
    /**
     * {@inheritDoc}
     */
    public void setFocus() {
        tableViewer.getControl().setFocus();
    }

    /**
     * {@inheritDoc}
     */
    public void triggerPropertyChanged(final Property changedProperty) {
        PlatformUI.getWorkbench().getDisplay().syncExec(new Runnable() {
            public void run() {
                tableViewer.setInput(RuntimeConfiguration.getInstance()
                        .getReferedProperties(currentlySelectedParts));            }
        });
    }

    /**
     * {@inheritDoc}
     */
    public void triggerPropertyListChanged() {
        PlatformUI.getWorkbench().getDisplay().syncExec(new Runnable() {
            public void run() {
                tableViewer.setInput(RuntimeConfiguration.getInstance()
                        .getReferedProperties(currentlySelectedParts));
                }
        });
    }

    /**
     * {@inheritDoc}
     */
    public void selectionChanged(final SelectionChangedEvent event) {
        currentlySelectedParts = new LinkedList<String>();
        ISelection selection = event.getSelection();
        if (selection instanceof IStructuredSelection) {
            for (Object item : ((IStructuredSelection) selection).toList()) {
                if (item instanceof EditPart) {
                    Object model = ((EditPart) item).getModel();
                    if (currentPart instanceof DiagramEditor) {
                        String fragmentUri = null;
                        if (model instanceof Node) {
                            fragmentUri = ModelingUtil.getFragmentUri(((Node) model).getElement());
                        } else if (model instanceof Connector) {
                            fragmentUri = ModelingUtil.getFragmentUri(((Connector) model).getElement());
                        }
                        currentlySelectedParts.add(fragmentUri);
                    }
                }
            }
        }
        if (currentlySelectedParts.isEmpty()) {
            currentlySelectedParts = null;
        }
        PlatformUI.getWorkbench().getDisplay().syncExec(new Runnable() {
            public void run() {
                tableViewer.setInput(RuntimeConfiguration.getInstance()
                        .getReferedProperties(currentlySelectedParts));            }
        });
    }


}
