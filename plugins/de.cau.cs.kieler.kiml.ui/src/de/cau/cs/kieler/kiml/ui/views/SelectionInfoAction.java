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
package de.cau.cs.kieler.kiml.ui.views;

import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.SWTError;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.statushandlers.StatusManager;
import org.eclipse.ui.views.properties.IPropertySheetEntry;

import de.cau.cs.kieler.kiml.LayoutOptionData;
import de.cau.cs.kieler.kiml.LayoutProviderData;
import de.cau.cs.kieler.kiml.LayoutServices;
import de.cau.cs.kieler.kiml.ui.KimlUiPlugin;
import de.cau.cs.kieler.kiml.ui.Messages;
import de.cau.cs.kieler.kiml.ui.layout.DiagramLayoutManager;
import de.cau.cs.kieler.kiml.ui.util.KimlUiUtil;

/**
 * An action that displays useful information about the current selection.
 *
 * @author msp
 */
public class SelectionInfoAction extends Action {

    /** the icon used for this action. */
    private static ImageDescriptor icon = KimlUiPlugin.getImageDescriptor("icons/menu16/info.gif");
    /** the dialog's default width. */
    private static final int DEFAULT_WIDTH = 580;
    /** the dialog's default height. */
    private static final int DEFAULT_HEIGHT = 600;
    
    /** the layout view that created this action. */
    private LayoutViewPart layoutView;

    /**
     * A dialog class that displays HTML content.
     */
    private class SelectionInfoDialog extends Dialog {
        
        /** the HTML text to display in the dialog. */
        private String htmlText;
        
        /**
         * Create a selection info dialog.
         * @param parentShell the parent shell
         */
        protected SelectionInfoDialog(final Shell parentShell, final String text) {
            super(parentShell);
            this.htmlText = text;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        protected void configureShell(final Shell shell) {
            super.configureShell(shell);
            shell.setText(Messages.getString("kiml.ui.38"));
        }

        /**
         * {@inheritDoc}
         */
        @Override
        protected Point getInitialSize() {
            return new Point(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        protected boolean isResizable() {
            return true;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        protected Control createDialogArea(final Composite parent) {
            Composite composite = (Composite) super.createDialogArea(parent);
            try {
                Browser browser = new Browser(composite, SWT.NONE);
                GridData gridData = new GridData(GridData.FILL_BOTH);
                browser.setLayoutData(gridData);
                browser.setText(htmlText);
            } catch (SWTError exception) {
                IStatus status = new Status(IStatus.ERROR, KimlUiPlugin.PLUGIN_ID,
                        "Could not instantiate Browser.", exception);
                StatusManager.getManager().handle(status);
            }
            return composite;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        protected void createButtonsForButtonBar(final Composite parent) {
            createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
        }
        
    };
    
    /**
     * Creates a selection info action.
     * 
     * @param thelayoutView the layout view that created this action
     * @param text user friendly text
     */
    public SelectionInfoAction(final LayoutViewPart thelayoutView, final String text) {
        super(text, icon);
        this.layoutView = thelayoutView;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void run() {
        Dialog dialog = new SelectionInfoDialog(layoutView.getViewSite().getShell(), createInfo()); 
        dialog.open();
    }
    
    /**
     * Create an information string to display to the user.
     * 
     * @return an info string
     */
    private String createInfo() {
        LayoutServices layoutServices = LayoutServices.getInstance();
        DiagramLayoutManager manager = layoutView.getCurrentManager();
        StringBuilder builder = new StringBuilder();
        EditPart editPart = layoutView.getCurrentEditPart();
        if (editPart != null) {
            builder.append("<b>Edit part class</b><ul><li>"
                    + editPart.getClass().getName() + "</li></ul>");
            EObject model = manager.getBridge().getElement(editPart);
            if (model != null) {
                builder.append("<b>Domain model class</b><ul><li>"
                        + model.eClass().getInstanceTypeName() + "</li></ul>");
            }
        }
        
        LayoutProviderData[] providerData = layoutView.getCurrentProviderData();
        if (providerData != null && providerData.length > 0) {
            builder.append("<b>Involved layout providers</b><ul>");
            for (LayoutProviderData data : providerData) {
                if (data != null) {
                    builder.append("<li>" + data.getName());
                    String category = layoutServices.getCategoryName(data.getCategory());
                    if (category != null) {
                        builder.append(" (" + category + ")");
                    }
                    builder.append(" - " + data.getId() + "</li>");
                }
            }
            builder.append("</ul>");
        }
        
        List<IPropertySheetEntry> selectedOptions = layoutView.getSelection();
        if (!selectedOptions.isEmpty()) {
            builder.append("<b>Selected options</b><ul>");
            for (IPropertySheetEntry entry : selectedOptions) {
                final LayoutOptionData<?> optionData = KimlUiUtil.getOptionData(providerData,
                        entry.getDisplayName());
                if (optionData != null) {
                    builder.append("<li>" + optionData.getName() + " (" + optionData.getType().literal()
                            + ") - " + optionData.getId() + "</li>");
                }
            }
            builder.append("</ul>");
        }
        
        if (builder.length() == 0) {
            builder.append("No information available.");
        }
        return builder.toString();
    }

}
