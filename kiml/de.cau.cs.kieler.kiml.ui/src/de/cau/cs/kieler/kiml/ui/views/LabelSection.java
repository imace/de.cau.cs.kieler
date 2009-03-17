/******************************************************************************
 * KIELER - Kiel Integrated Environment for Layout for the Eclipse RCP
 *
 * http://www.informatik.uni-kiel.de/rtsys/kieler/
 * 
 * Copyright 2008 by
 * + Christian-Albrechts-University of Kiel
 *   + Department of Computer Science
 *     + Real-Time and Embedded Systems Group
 * 
 * This code is provided under the terms of the Eclipse Public License (EPL).
 * See the file epl-v10.html for the license text.
 */
package de.cau.cs.kieler.kiml.ui.views;


import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.tabbed.AbstractPropertySection;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

/**
 * The Label section on the Button tab.
 * 
 * @author Anthony Hunter
 */
public class LabelSection
    extends AbstractPropertySection {

    private Text labelText;

   

    private ModifyListener listener = new ModifyListener() {

        public void modifyText(ModifyEvent arg0) {
           
        }
    };

 public void createControls(Composite parent,
            TabbedPropertySheetPage aTabbedPropertySheetPage) {
        super.createControls(parent, aTabbedPropertySheetPage);
     Composite composite = getWidgetFactory()
            .createFlatFormComposite(parent);
        FormData data;

        labelText = getWidgetFactory().createText(composite, ""); //$NON-NLS-1$
        data = new FormData();
     data.left = new FormAttachment(0, STANDARD_LABEL_WIDTH);
        data.right = new FormAttachment(100, 0);
     data.top = new FormAttachment(0, ITabbedPropertyConstants.VSPACE);
        labelText.setLayoutData(data);
        labelText.addModifyListener(listener);

        CLabel labelLabel = getWidgetFactory()
            .createCLabel(composite, "Label:"); //$NON-NLS-1$
        data = new FormData();
        data.left = new FormAttachment(0, 0);
        data.right = new FormAttachment(labelText,
            -ITabbedPropertyConstants.HSPACE);
        data.top = new FormAttachment(labelText, 0, SWT.CENTER);
        labelLabel.setLayoutData(data);
    }

 public void setInput(IWorkbenchPart part, ISelection selection) {
        super.setInput(part, selection);
        assert selection instanceof IStructuredSelection;
        Object input = ((IStructuredSelection) selection).getFirstElement();

    }

 public void refresh() {
        labelText.removeModifyListener(listener);
   
        labelText.addModifyListener(listener);
    }
}