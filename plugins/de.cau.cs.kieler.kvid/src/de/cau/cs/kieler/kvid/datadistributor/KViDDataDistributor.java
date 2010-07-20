package de.cau.cs.kieler.kvid.datadistributor;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

import org.eclipse.draw2d.BorderLayout;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramRootEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.json.JSONException;
import org.json.JSONObject;

import de.cau.cs.kieler.kvid.data.KViDDataObject;
import de.cau.cs.kieler.kvid.visual.GMFDrawer;
import de.cau.cs.kieler.kvid.visual.IDrawer;

public class KViDDataDistributor {
    
    private static final KViDDataDistributor instance = new KViDDataDistributor();
    
    private HashMap<String, EditPart> editPartsByURI = new HashMap<String, EditPart>();
    
    private HashMap<String, KViDDataObject> dataByURI = new HashMap<String, KViDDataObject>();
    
    private IDrawer drawer = new GMFDrawer();
    
    public static KViDDataDistributor getInstance() {
        return instance;
    }
    
    public void initialize() {
        IEditorPart activeEditor = getActiveEditor();
        if (activeEditor instanceof DiagramEditor) {
            DiagramEditPart dep = ((DiagramEditor)activeEditor).getDiagramEditPart();
            Collection<?> editParts = dep.getViewer().getEditPartRegistry()
                    .values();
            for (Object object : editParts) {
                EditPart part = (EditPart)object;
                if (part.getModel() instanceof EObject) {
                    EObject eObject = (EObject)part.getModel();
                    Resource resource = eObject.eResource();
                    System.out.println(eObject.toString());
                    String URI = EcoreUtil.getURI(eObject).toString();
                    editPartsByURI.put(URI, part);
                    System.out.println(URI);
                }
            }
        }
    }
    
    public void update(final JSONObject data) {
        Iterator allKeys = data.keys();
        while (allKeys.hasNext()) {
            Object o = allKeys.next();
            try {
                String key = o.toString();
                dataByURI.put(o.toString(), new KViDDataObject(key, data.getString(key)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        drawer.draw(dataByURI);
    }
    
    public void cleanup() {
        drawer.clearDrawing();
    }
    
    public void markPartByURI(String fragmentURI) {
        EditPart marked = getEditPartByURI(fragmentURI);
        if (marked instanceof GraphicalEditPart) {
            IFigure markable = ((GraphicalEditPart) marked).getFigure();
            markable.setBackgroundColor(ColorConstants.blue);
        }
    }
    
    public EditPart getEditPartByURI(String fragmentURI) {
        return editPartsByURI.get(fragmentURI);
    }
    
    public IEditorPart getActiveEditor() {
        IEditorPart editor = null;
        IWorkbenchWindow[] activeWindows = PlatformUI.getWorkbench().getWorkbenchWindows();
        for (int i = 0; i < activeWindows.length; i++) {
            IWorkbenchPage page = activeWindows[i].getActivePage();
            if (page.getActiveEditor() != null) {
                editor = page.getActiveEditor();
            }
        }
        return editor;        
    }

}
