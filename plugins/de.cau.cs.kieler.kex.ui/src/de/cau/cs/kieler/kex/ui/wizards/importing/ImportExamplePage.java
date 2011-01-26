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
package de.cau.cs.kieler.kex.ui.wizards.importing;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseTrackAdapter;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.WizardResourceImportPage;
import org.osgi.framework.Bundle;

import de.cau.cs.kieler.core.KielerException;
import de.cau.cs.kieler.core.util.Pair;
import de.cau.cs.kieler.kex.controller.ExampleManager;
import de.cau.cs.kieler.kex.model.Category;
import de.cau.cs.kieler.kex.model.Example;

/**
 * This class represents the import page of importwizard. It contains a tree which shows the
 * importable examples. Secondly there is a description and a preview picture field. The
 * {@link WizardResourceImportPage} is extended because of getting a Workspace Directory Chooser.
 * 
 * @author pkl
 * 
 */
public class ImportExamplePage extends WizardPage {

    private static final int IMAGE_MAX_WIDTH = 800;
    private static final int IMAGE_MAX_HEIGHT = 600;

    private static final int IMAGE_PRE_WIDTH = 240;
    private static final int IMAGE_PRE_HEIGHT = 135;

    private static final int DESC_HEIGHT_HINT = 160;
    private static final int DESC_MIN_HEIGHT = 120;

    private static final int IMG_PADDINGS_WIDTH = 40;
    private static final int IMG_PADDINGS_HEIGHT = 120;

    private Text exampleDescField;

    private Label imageLabel;

    private Example selectedExample;

    private Composite previewComp;

    private Label previewDesc;

    private CheckboxTreeViewer treeViewer;

    /**
     * The constructor will be called with following parameters.
     * 
     * @param name
     *            , the name of page, works as page title, too.
     * @param selection
     *            , the selected resource will be set as default as import location.
     */

    public ImportExamplePage(final String name, final IStructuredSelection selection) {
        super(name);
        setDescription(Messages.MainPage_pageDescription);
    }

    public void createControl(Composite parent) {
        Composite composite = new Composite(parent, SWT.NONE);
        GridLayout gridLayout = new GridLayout();
        gridLayout.numColumns = 2;
        composite.setLayout(gridLayout);
        composite.setLayoutData(new GridData(GridData.FILL_BOTH));
        setControl(composite);
        createLeft(composite);
        createRight(composite);
        getShell().setMinimumSize(540, 600);
    }

    private void createLeft(Composite parent) {
        Composite composite = new Composite(parent, SWT.NONE);
        composite.setLayout(new GridLayout());
        composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        // create filter text
        final Text filterText = new Text(composite, SWT.BORDER);
        filterText.setText("type filter text");
        filterText.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));
        filterText.setForeground(parent.getDisplay().getSystemColor(SWT.COLOR_GRAY));

        // create tree viewer
        treeViewer = new CheckboxTreeViewer(composite, SWT.SINGLE | SWT.V_SCROLL | SWT.BORDER
                | SWT.H_SCROLL);
        treeViewer.setContentProvider(new ExampleContentProvider());
        treeViewer.setLabelProvider(new ExampleLabelProvider());
        treeViewer.setSorter(new ViewerSorter());
        treeViewer.getControl().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        fillTreeViewer();
        treeViewer.addSelectionChangedListener(new ISelectionChangedListener() {

            public void selectionChanged(SelectionChangedEvent event) {

            }
        });
        treeViewer.addCheckStateListener(new ICheckStateListener() {

            public void checkStateChanged(CheckStateChangedEvent event) {

            }
        });
        treeViewer.expandAll();
    }

    private void fillTreeViewer() {
        List<Pair<Category, List<Object>>> viewElement = new ArrayList<Pair<Category, List<Object>>>();
        List<Category> categories = ExampleManager.get().getCategories();
        Collection<Example> values = ExampleManager.get().getExamples().values();

        // TODO build subCategories
        for (Category category : categories) {
            Pair<Category, List<Object>> categoryPair = new Pair<Category, List<Object>>();
            List<Object> categoryList = new ArrayList<Object>();
            for (Example example : values) {
                if (example.getCategoryId().equals(category.getId())) {
                    categoryList.add(example);
                }
            }
            if (category.getParentId() == null) {
                categoryPair.setFirst(category);
                categoryPair.setSecond(categoryList);
                viewElement.add(categoryPair);
            }
        }
        treeViewer.setInput(viewElement);

    }

    private class ExampleContentProvider implements ITreeContentProvider {

        // Maybe use treeElements which are implemented in an revision before.
        List<Pair<Category, List<Object>>> input;

        public void dispose() {
        }

        public void inputChanged(final Viewer viewer, final Object oldInput, final Object newInput) {
        }

        @SuppressWarnings("unchecked")
        public Object[] getElements(final Object inputElement) {
            input = (ArrayList<Pair<Category, List<Object>>>) inputElement;
            return input.toArray();
        }

        @SuppressWarnings("unchecked")
        public Object[] getChildren(final Object parentElement) {
            if (parentElement instanceof Pair) {
                Pair<Category, List<Object>> elements = (Pair<Category, List<Object>>) parentElement;
                return elements.getSecond().toArray();
            } else {
                return Collections.EMPTY_LIST.toArray();
            }
        }

        public Object getParent(final Object element) {
            if (element instanceof Example) {
                for (Pair pair : input) {
                    if (((Category) pair.getFirst()).getId().equals(
                            ((Example) element).getCategoryId()))
                        return pair.getFirst();
                }
            }
            return null;
        }

        public boolean hasChildren(Object element) {
            return getChildren(element).length > 0;
        }

    }

    private class ExampleLabelProvider extends LabelProvider implements ILabelProvider {

        @SuppressWarnings("unchecked")
        @Override
        public String getText(final Object element) {
            if (element instanceof Pair) {
                Pair<Category, List<Object>> pair = (Pair<Category, List<Object>>) element;
                return (pair.getFirst()).getTitle();
            }
            if (element instanceof Example) {
                return ((Example) element).getTitle();
            }
            return null;
        }

        @Override
        public Image getImage(final Object element) {
            if (element instanceof Category) {
                return computeIconImage(((Category) element).getIconPath(),
                        ((Category) element).getNamespaceId());
            }
            // TODO extend with example image
            // if (data instanceof Example) {
            // return computeIconImage(((Example) data).getOverviewPic(),
            // ((Example) data).getNamespaceId());
            // }
            return null;
        }

        private Image computeIconImage(final String imagePath, final String nameSpaceId) {
            if (imagePath != null && imagePath.length() > 0) {
                Bundle bundle = Platform.getBundle(nameSpaceId);
                URL resource = bundle.getEntry(imagePath);
                if (resource != null) {
                    ImageDescriptor descriptor = ImageDescriptor.createFromURL(resource);
                    Image image = descriptor.createImage();
                    if (image != null) {
                        return image;
                    }
                }
            }
            return null;
        }

    }

    private void createRight(Composite parent) {
        Composite composite = new Composite(parent, SWT.NONE);
        composite.setLayout(new GridLayout());
        composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        createPreviewComp(composite);
        createDescriptionComp(composite);
    }

    /**
     * Creates the preview picture component.
     * 
     * @param composite
     * @param controlComp
     */
    private void createPreviewComp(final Composite composite) {
        // TODO check where previewComp is used!?
        previewComp = composite;
        previewDesc = new Label(composite, SWT.NONE);
        previewDesc.setText("Example Preview");
        GridData previewDescData = new GridData(GridData.FILL_HORIZONTAL);
        previewDesc.setLayoutData(previewDescData);
        imageLabel = new Label(composite, SWT.BORDER);
        imageLabel.setImage(initPreviewImage());
        GridData imgLabelData = new GridData(GridData.FILL_HORIZONTAL, GridData.FILL_VERTICAL,
                true, true);
        // 16 : 9
        imgLabelData.heightHint = IMAGE_PRE_HEIGHT;
        imgLabelData.minimumHeight = DESC_MIN_HEIGHT;
        imageLabel.setLayoutData(imgLabelData);
        imageLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseDown(final MouseEvent e) {
                super.mouseDown(e);
                if (selectedExample == null) {
                    return;
                }
                Dialog dialog = new Dialog(imageLabel.getShell()) {

                    private Rectangle bounds;

                    @Override
                    protected void createButtonsForButtonBar(final Composite parent) {
                        super.createButton(parent, IDialogConstants.OK_ID,
                                IDialogConstants.OK_LABEL, true);
                    }

                    @Override
                    protected Control createDialogArea(final Composite parent) {
                        Composite composite = (Composite) super.createDialogArea(parent);
                        Composite innerComp = new Composite(composite, SWT.CENTER | SWT.BORDER);
                        innerComp.setLayout(new GridLayout());
                        Label imgLabel = new Label(innerComp, SWT.BORDER | SWT.V_SCROLL
                                | SWT.H_SCROLL);
                        imgLabel.setLayoutData(new GridData(GridData.CENTER));
                        Image image = loadImage(IMAGE_MAX_WIDTH, IMAGE_MAX_HEIGHT);
                        bounds = image.getBounds();
                        imgLabel.setImage(image);
                        return composite;
                    }

                    @Override
                    protected Point getInitialSize() {
                        // imagesize + paddings
                        return new Point(bounds.width + IMG_PADDINGS_WIDTH, bounds.height
                                + IMG_PADDINGS_HEIGHT);
                    }

                    @Override
                    protected void configureShell(final Shell newShell) {
                        super.configureShell(newShell);
                        newShell.setText("Preview Picture");
                    }

                };
                dialog.open();
            }
        });
        imageLabel.addMouseTrackListener(new MouseTrackAdapter() {
            @Override
            public void mouseHover(final MouseEvent e) {
                imageLabel.setCursor(new Cursor(imageLabel.getDisplay(), SWT.CURSOR_HAND));
            }
        });
    }

    private void createDescriptionComp(final Composite composite) {
        Label descriptionLabel = new Label(composite, SWT.NONE);
        descriptionLabel.setText("Example Description");
        this.exampleDescField = new Text(composite, SWT.NONE | SWT.MULTI | SWT.V_SCROLL
                | SWT.BORDER);
        GridData descData = new GridData(GridData.FILL_HORIZONTAL);
        descData.heightHint = DESC_HEIGHT_HINT;
        descData.minimumHeight = DESC_MIN_HEIGHT;
        this.exampleDescField.setLayoutData(descData);
    }

    private void updateCategory(final SelectionChangedEvent e) {
        // if (e.detail != SWT.CHECK) {
        return;
        // }
        // TreeItem parentItem = ((TreeItem) e.item).getParentItem();
        // TreeItem[] items = parentItem.getItems();
        // boolean selectedAll = true;
        // for (TreeItem treeItem : items) {
        // if (!treeItem.getChecked()) {
        // selectedAll = false;
        // break;
        // }
        // }
        // parentItem.setChecked(selectedAll);
    }

    /**
     * Updates the label of preview picture.
     * 
     * @param image
     *            , {@link Image}
     */
    private void updateImageLabel(final Image image) {
        // FormData formData = new FormData(image.getImageData().width,
        // image.getImageData().height);
        // formData.top = new FormAttachment(previewDesc, OFFSET);
        // imageLabel.setLayoutData(formData);
        // imageLabel.setImage(image);
        // imageLabel.pack();
    }

    /**
     * loads preview image. The parameters define the max width and heigt of an image. The loaded
     * image will scaled to the parameter values, while keeping the imageformat.
     * 
     * @param image_width
     * @param image_height
     * @return
     */
    private Image loadImage(final double imageWidth, final double imageHeight) {
        final String previewPicPath = selectedExample.getOverviewPic();
        if (previewPicPath != null && previewPicPath.length() > 1) {
            try {
                ImageData imgData = new ImageData(ExampleManager.get().loadOverviewPic(
                        selectedExample));

                double tempSize = Math
                        .max(imgData.width / imageWidth, imgData.height / imageHeight);
                imgData = imgData.scaledTo((int) (imgData.width / tempSize),
                        (int) (imgData.height / tempSize));
                return new Image(previewComp.getDisplay(), imgData);

            } catch (final KielerException e) {
                e.printStackTrace();
                return noPreviewPic(previewComp.getDisplay());
            }
        }
        return noPreviewPic(previewComp.getDisplay());

    }

    private void updateDescriptionLabel(final Example example) {
        StringBuilder sb = new StringBuilder();
        sb.append("Title: ").append(example.getTitle()).append("\n").append("Author: ")
                .append(example.getAuthor()).append("\n").append("Contact: ")
                .append(example.getContact()).append("\n").append("\n")
                .append(example.getDescription());
        getExampleDescField().setText(sb.toString());
    }

    // TODO falls ein image nicht richtig geladen wird wegen format fehler oder
    // so muss auf jeden fall eine meldung kommen... am besten schon beim export
    // darauf reagieren.

    /**
     * loads "no preview" picture.
     * 
     * @return "no preview" picture
     */
    private Image noPreviewPic(final Display display) {
        return new Image(display, ExampleManager.get().loadStandardPic());
    }

    /**
     * initializes the preview image.
     * 
     * @return
     */
    private Image initPreviewImage() {
        Image preview = new Image(previewComp.getDisplay(), IMAGE_PRE_WIDTH, IMAGE_PRE_HEIGHT);
        GC gc = new GC(preview);
        gc.setBackground(previewComp.getBackground());
        gc.fillRectangle(preview.getBounds());
        return preview;
    }

    /**
     * filters checked examples from example tree.
     * 
     * @return list of examples.
     */
    public List<Example> getCheckedExamples() {
        List<Example> result = new ArrayList<Example>();
        Object[] checkedElements = this.treeViewer.getCheckedElements();
        for (Object ob : checkedElements)
            if (ob instanceof Example) {
                result.add((Example) ob);
            }
        return result;
    }

    /**
     * getter for example description field. It is a browser.
     * 
     * @return Text
     */
    public Text getExampleDescField() {
        return exampleDescField;
    }

}
