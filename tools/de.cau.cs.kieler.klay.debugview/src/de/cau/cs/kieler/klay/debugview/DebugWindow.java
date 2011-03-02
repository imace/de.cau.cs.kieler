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
package de.cau.cs.kieler.klay.debugview;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;

import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;

// CHECKSTYLEOFF MagicNumber

/**
 * The debug window houses controls that allow the user to inspect the debug output
 * produced by Klay Layered.
 * 
 * @author cds
 */
public class DebugWindow extends Window {
    
    /**
     * Content provider for the file table. Expects the table viewer to get a
     * {@code File} as input that denotes a directory.
     * 
     * @author cds
     */
    private static class FileTableContentProvider implements IStructuredContentProvider {
        /**
         * {@inheritDoc}
         */
        public void dispose() {
            // Nothing to do here.
        }

        /**
         * {@inheritDoc}
         */
        public void inputChanged(final Viewer viewer, final Object oldInput, final Object newInput) {
            // Nothing to do.
        }

        /**
         * {@inheritDoc}
         */
        public Object[] getElements(final Object inputElement) {
            if (inputElement instanceof File) {
                // Return a list of .dot files
                return ((File) inputElement).listFiles(new FileFilter() {
                    public boolean accept(final File file) {
                        return file.isFile() && file.getName().endsWith(".dot");
                    }
                });
                
            } else {
                return new Object[0];
            }
        }
    }
    
    /**
     * Label provider for the file table.
     * 
     * @author cds
     */
    private static class FileTableLabelProvider implements ILabelProvider {
        /**
         * Image for files whose PNG hasn't been created yet.
         */
        private Image unconverted = KlayDebugViewPlugin.loadImage("notconverted.gif");

        /**
         * Image for files whose PNG is available.
         */
        private Image converted = KlayDebugViewPlugin.loadImage("converted.gif");
        
        /**
         * {@inheritDoc}
         */
        public void addListener(final ILabelProviderListener listener) {
            // Do nothing.
        }

        /**
         * {@inheritDoc}
         */
        public void dispose() {
            if (converted != null) {
                converted.dispose();
            }
            
            if (unconverted != null) {
                unconverted.dispose();
            }
        }

        /**
         * {@inheritDoc}
         */
        public boolean isLabelProperty(final Object element, final String property) {
            // We don't have property changes
            return false;
        }

        /**
         * {@inheritDoc}
         */
        public void removeListener(final ILabelProviderListener listener) {
            // Do nothing.
        }

        /**
         * {@inheritDoc}
         */
        public Image getImage(final Object element) {
            String path = ((File) element).getPath();
            
            if (new File(path.substring(0, path.length() - 3) + "png").exists()) {
                return converted;
            } else {
                return unconverted;
            }
        }

        /**
         * {@inheritDoc}
         */
        public String getText(final Object element) {
            return ((File) element).getName();
        }
    }
    
    /**
     * Compares {@code File}s.
     * 
     * @author cds
     */
    private static class FileViewerComparator extends ViewerComparator {
        /**
         * {@inheritDoc}
         */
        @Override
        public int compare(final Viewer viewer, final Object e1, final Object e2) {
            File file1 = (File) e1;
            File file2 = (File) e2;
            
            return file1.getName().compareTo(file2.getName());
        }
    }
    
    // CONSTANTS
    /**
     * Setting for the currently displayed path.
     */
    private static final String SETT_PATH = "debugWindow.path";
    
    /**
     * Setting for the window bounds.
     */
    private static final String SETT_BOUNDS = "debugWindow.bounds";
    
    /**
     * How much the zoom factor is changed when zooming in or out.
     */
    private static final float ZOOM_DELTA = 0.1f;
    
    // UI CONTROLS
    private ToolBar toolBar = null;
    private Image folderBrowseImage = null;
    private ToolItem folderBrowseButton = null;
    private Image zoomInImage = null;
    private ToolItem zoomInButton = null;
    private Image zoomOutImage = null;
    private ToolItem zoomOutButton = null;
    private Table fileTable = null;
    private TableViewer fileTableViewer = null;
    private Canvas imageCanvas = null;
    private Label statusBar = null;
    
    // VARIABLES
    /**
     * The currently displayed path.
     */
    private String currentPath = null;
    
    /**
     * The currently displayed image file.
     */
    private File currentImageFile = null;
    
    /**
     * The currently displayed image.
     */
    private Image currentImage = null;
    
    /**
     * The image point that will land in the top left corner.
     */
    private Point origin = new Point(0, 0);
    
    /**
     * The current zoom factor.
     */
    private float zoom = 1.0f;
    

    /**
     * Constructs a new instance with the given parent shell.
     * 
     * @param parentShell the window's parent.
     */
    protected DebugWindow(final Shell parentShell) {
        super(parentShell);
    }
    

    ///////////////////////////////////////////////////////////////////////////////
    // Path Setting
    
    /**
     * Opens a directory dialog for the user to enter a new path. If the user clicks
     * OK, the new path is applied.
     */
    private void openPathDialog() {
        DirectoryDialog dialog = new DirectoryDialog(getShell());
        dialog.setMessage("Select the folder where Klay Layered has placed its debug output files.");
        dialog.setFilterPath(currentPath);
        
        String newPath = dialog.open();
        if (newPath != null) {
            setPath(newPath);
        }
    }
    
    /**
     * Tries to apply the new path.
     * 
     * @param newPath the new path. May be {@code null}.
     */
    private void setPath(final String newPath) {
        String thePath = newPath;
        if (thePath == null) {
            thePath = "";
        }
        
        // Find the path
        File pathFile = new File(thePath);
        if (!pathFile.isDirectory()) {
            // Error
            openErrorDialog("The directory could not be opened.");
        } else {
            fileTableViewer.setInput(pathFile);
        }
        
        // Show the new path to the user
        currentPath = thePath;
        statusBar.setText(currentPath);
    }
    

    ///////////////////////////////////////////////////////////////////////////////
    // Image Display
    
    /**
     * Loads the given image and shows it.
     */
    private void updateImage(final File modelFile) {
        String path = modelFile.getPath();
        File imageFile = new File(path.substring(0, path.length() - 3) + "png");
        
        // Check if the image file already exists
        if (!imageFile.exists()) {
            if (!createImage(modelFile, imageFile)) {
                // If this doesn't work, set image file to null
                imageFile = null;
            }
        }
        
        // Dispose the current image, if any
        if (currentImage != null) {
            currentImage.dispose();
        }
        
        if (imageFile == null) {
            // Reset
            currentImageFile = null;
            currentImage = null;
            statusBar.setText(currentPath);
        } else {
            // Load new image
            currentImage = new Image(getShell().getDisplay(), imageFile.getPath());
            currentImageFile = modelFile;
            statusBar.setText(currentImageFile.getPath());
        }

        origin.x = 0;
        origin.y = 0;
        zoom = 1.0f;
        
        updateCanvas();
    }
    
    /**
     * Zooms the image.
     * 
     * @param in {@code true} if we should zoom in, {@code false} if we should zoom
     *           out.
     */
    private void zoom(final boolean in) {
        if (in) {
            zoom += ZOOM_DELTA;
        } else {
            zoom = Math.max(0.0f, zoom - ZOOM_DELTA);
        }
        
        // TODO: Update bounds and stuff
        
        updateCanvas();
    }
    
    /**
     * Redraws the canvas and sets properties on its scroll bars.
     */
    private void updateCanvas() {
        
        
        imageCanvas.redraw();
        imageCanvas.update();
    }
    
    /**
     * Paints the canvas.
     * 
     * @param gc graphics context.
     */
    private void handlePaintCanvas(final GC gc) {
        Rectangle imageRect = new Rectangle(0, 0, 0, 0);
        
        if (currentImage != null) {
            // Draw image
            gc.drawImage(currentImage, 0, 0);
            imageRect = currentImage.getBounds();
        }
        
        // Draw background
        Rectangle client = imageCanvas.getClientArea();
        
        int marginWidth = client.width - imageRect.width;
        if (marginWidth > 0) {
                gc.fillRectangle(imageRect.width, 0, marginWidth, client.height);
        }
        
        int marginHeight = client.height - imageRect.height;
        if (marginHeight > 0) {
                gc.fillRectangle(0, imageRect.height, client.width, marginHeight);
        }
    }
    

    ///////////////////////////////////////////////////////////////////////////////
    // Miscellaneous
    
    /**
     * Tries to turn the given model file into the given image file.
     * 
     * @param modelFile the model file.
     * @param imageFile the image file.
     * @return {@code true} if the image file was successfully created.
     */
    private boolean createImage(final File modelFile, final File imageFile) {
        try {
            Process p = Runtime.getRuntime().exec("dot -Tpng \""
                    + modelFile.getCanonicalPath() + "\" -o \""
                    + imageFile.getCanonicalPath() + "\"");
            p.waitFor();
            
            fileTableViewer.update(modelFile, null);
        } catch (IOException e) {
            return false;
        } catch (InterruptedException e) {
            return false;
        }
        
        return imageFile.exists();
    }
    
    /**
     * Shows an error dialog with the given message.
     * 
     * @param message the message.
     */
    private void openErrorDialog(final String message) {
        ErrorDialog dialog = new ErrorDialog(
                getShell()
                , "Error",
                message,
                null,
                0);
        dialog.open();
    }
    

    ///////////////////////////////////////////////////////////////////////////////
    // Dialog Settings
    
    /**
     * Saves the current settings.
     */
    private void saveDialogSettings() {
        IDialogSettings dialogSettings = KlayDebugViewPlugin.getDefault().getDialogSettings();
        
        Point size = getShell().getSize();
        dialogSettings.put(SETT_BOUNDS + ".x", size.x);
        dialogSettings.put(SETT_BOUNDS + ".y", size.y);
        
        dialogSettings.put(SETT_PATH, currentPath);
    }
    
    /**
     * Loads the most recently saved dialog settings.
     */
    private void loadDialogSettings() {
        IDialogSettings dialogSettings = KlayDebugViewPlugin.getDefault().getDialogSettings();
        
        setPath(dialogSettings.get(SETT_PATH));
    }
    
    

    ///////////////////////////////////////////////////////////////////////////////
    // GUI Creation / Disposal
    
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean close() {
        saveDialogSettings();
        
        boolean closed = super.close();
        
        if (closed) {
            if (folderBrowseImage != null) {
                folderBrowseImage.dispose();
            }
            
            if (zoomInImage != null) {
                zoomInImage.dispose();
            }
            
            if (zoomOutImage != null) {
                zoomOutImage.dispose();
            }
        }
        
        return closed;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Control createContents(final Composite parent) {
        Composite shellComposite = new Composite(parent, SWT.NULL);
        shellComposite.setLayout(new GridLayout(1, false));
        shellComposite.setLayoutData(new GridData(GridData.FILL_BOTH));
        
        setupToolBar(shellComposite);
        createMainContent(shellComposite);
        createStatusBar(shellComposite);
        
        loadDialogSettings();
        
        return shellComposite;
    }

    /**
     * Creates the main controls to be displayed in the window.
     * 
     * @param parent the parent composite.
     */
    private void createMainContent(final Composite parent) {
        // GUI code needs magic numbers
        // CHECKSTYLEOFF MagicNumber
        
        // Sash Form
        SashForm sashForm = new SashForm(parent, SWT.HORIZONTAL | SWT.SMOOTH);
        sashForm.setLayout(new FillLayout());
        sashForm.setLayoutData(new GridData(GridData.FILL_BOTH));
        
        // Table
        fileTable = new Table(sashForm, SWT.BORDER | SWT.SINGLE | SWT.FULL_SELECTION);
        
        // Table Viewer
        fileTableViewer = new TableViewer(fileTable);
        fileTableViewer.setContentProvider(new FileTableContentProvider());
        fileTableViewer.setLabelProvider(new FileTableLabelProvider());
        fileTableViewer.setComparator(new FileViewerComparator());
        
        // Image Canvas
        imageCanvas = new Canvas(sashForm,
                SWT.NO_BACKGROUND | SWT.NO_REDRAW_RESIZE | SWT.V_SCROLL | SWT.H_SCROLL);
        
        // Set sash form weights
        sashForm.setWeights(new int[] {30, 70});
        
        // Event listeners
        fileTableViewer.addSelectionChangedListener(new ISelectionChangedListener() {
            public void selectionChanged(final SelectionChangedEvent event) {
                IStructuredSelection selection = (IStructuredSelection) event.getSelection();
                updateImage((File) selection.getFirstElement());
            }
        });
        
        imageCanvas.addListener(SWT.Paint, new Listener() {
            public void handleEvent(final Event event) {
                handlePaintCanvas(event.gc);
            }
        });
        
        // CHECKSTYLEON MagicNumber
    }
    
    /**
     * Creates the tool bar.
     * 
     * @param parent the parent composite.
     */
    private void setupToolBar(final Composite parent) {
        toolBar = new ToolBar(parent, SWT.FLAT | SWT.HORIZONTAL);
        toolBar.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        
        // Folder Browse Button
        folderBrowseButton = new ToolItem(toolBar, SWT.NULL);
        folderBrowseButton.setToolTipText("Open...");
        folderBrowseButton.setImage(KlayDebugViewPlugin.loadImage("open.png"));
        
        // Separator
        new ToolItem(toolBar, SWT.SEPARATOR);
        
        // Zoom Buttons
        zoomInButton = new ToolItem(toolBar, SWT.NULL);
        zoomInButton.setToolTipText("Zoom in");
        zoomInButton.setImage(KlayDebugViewPlugin.loadImage("zoomin.gif"));

        zoomOutButton = new ToolItem(toolBar, SWT.NULL);
        zoomOutButton.setToolTipText("Zoom out");
        zoomOutButton.setImage(KlayDebugViewPlugin.loadImage("zoomout.gif"));
        
        // Event listeners
        folderBrowseButton.addSelectionListener(new SelectionAdapter() {
            /**
             * {@inheritDoc}
             */
            @Override
            public void widgetSelected(final SelectionEvent e) {
                openPathDialog();
            }
        });

        zoomInButton.addSelectionListener(new SelectionAdapter() {
            /**
             * {@inheritDoc}
             */
            @Override
            public void widgetSelected(final SelectionEvent e) {
                zoom(true);
            }
        });

        zoomOutButton.addSelectionListener(new SelectionAdapter() {
            /**
             * {@inheritDoc}
             */
            @Override
            public void widgetSelected(final SelectionEvent e) {
                zoom(false);
            }
        });
    }
    
    /**
     * Creates the status bar.
     * 
     * @param parent the parent composite.
     */
    private void createStatusBar(final Composite parent) {
        statusBar = new Label(parent, SWT.NULL);
        statusBar.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void configureShell(final Shell newShell) {
        super.configureShell(newShell);
        
        newShell.setText("Klay Layered Debug Viewer");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Point getInitialSize() {
        IDialogSettings dialogSettings = KlayDebugViewPlugin.getDefault().getDialogSettings();
        
        try {
            return new Point(
                    dialogSettings.getInt(SETT_BOUNDS + ".x"),
                    dialogSettings.getInt(SETT_BOUNDS + ".y"));
        } catch (NumberFormatException e) {
            return super.getInitialSize();
        }
    }
}
