package edu.unikiel.informatik.aiw.gctl.edit.customs;

import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.transaction.ResourceSetChangeEvent;
import org.eclipse.emf.transaction.ResourceSetListenerImpl;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.ui.IPartListener2;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchPartReference;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

import edu.unikiel.informatik.aiw.generated.gctl.diagram.part.EpcDiagramEditor;


/**
 * 
 * @author Steffen Jacobs
 *
 */
public class ForeignModelLoader extends ResourceSetListenerImpl implements IPartListener2 {

	private Resource resource = null;
	private TransactionalEditingDomain domain = null;
	private String currentModelPath = null;
	
	public ForeignModelLoader(){
		try {
		IWorkbenchPage page = getActiveWorkbenchPage();
		//waiting for GCTL-Editor
		page.addPartListener(this);
		this.activate(page.getActivePartReference());
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public Resource getResource(){
		return resource;
	}
			
	public void loadResource(String path){
		if (domain != null){
			this.resource = domain.loadResource(path);
			if (resource != null)
				System.out.println("Resource loaded: " + resource.getURI());
		}
	}
	
	private void unloadResource(){
		if (resource != null)
			resource.unload();
	}
	
	public void deactivate(){
		if (domain != null){
			domain.removeResourceSetListener(this);
		}
		if (resource != null){
			unloadResource();
			resource = null;
		}
		System.out.println("ModelLoader deactivated");
	}
	
	/**
	 * Starts listening to ResourceSetChange events to get the 
	 * resource path string from domain model
	 */
	public void activate(IWorkbenchPartReference partRef){
		
		// start listening to specified editor only
		try { 
			if (partRef.getId().equals(EpcDiagramEditor.ID)){
				IWorkbenchPart part = partRef.getPart(true);			
				IEditingDomainProvider domainProvider = (IEditingDomainProvider) part.getAdapter(IEditingDomainProvider.class);
				if (domainProvider.getEditingDomain() instanceof TransactionalEditingDomain){
					domain = (TransactionalEditingDomain) domainProvider.getEditingDomain();
					//start listening to domain model changes
					domain.addResourceSetListener(this);
				} else {
					//TODO: add error logging and message dialog
					System.out.println("EditingDomain must be a TransactionalEditingDomain");
				}
				System.out.println("ModelLoader activated");
			}
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Override
	public void resourceSetChanged(ResourceSetChangeEvent event) {
		try {
			List<Notification> notifications = event.getNotifications();
			for (Notification notification : notifications) {
				if (notification != null){
					if (notification.getFeature() instanceof EAttribute){
						
						EAttribute attr = (EAttribute)(notification.getFeature());
						// if corresponding Feature 'foreignModelPath' has changed
						// load resource from value
						System.out.println(attr.getName());
						if (attr.getName().equals("foreignModelPath")){
							unloadResource();
							currentModelPath = notification.getNewStringValue();
							loadResource(currentModelPath);
							System.out.println(currentModelPath);
						}
					}
					//TODO: throws NullPointerException.
					//System.out.println(notification.getFeature());
				}
			}
		} catch(Exception e){
			e.printStackTrace();
		}
		//System.out.println("changed: " + event.getEditingDomain().getID());
	}
	
	/**
	 * 
	 * @return the currently active workbench page
	 */
	private IWorkbenchPage getActiveWorkbenchPage(){
		IWorkbenchPage page = null;
		IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		if (window != null){
			page = window.getActivePage();
		}
		if (page == null){
			 // Look for a window and get the page off it!
			IWorkbenchWindow[] windows = PlatformUI.getWorkbench().getWorkbenchWindows();
			for (int i = 0; i < windows.length; i++){
				 if (windows[i] != null)
				 {
					 window = windows[i];
					 page = windows[i].getActivePage();
					 if (page != null)
					 break;
				 }
			}
		}
		return page;
	}

	@Override
	public void partActivated(IWorkbenchPartReference partRef) {

		
	}

	@Override
	public void partBroughtToTop(IWorkbenchPartReference partRef) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void partClosed(IWorkbenchPartReference partRef) {
		this.deactivate();
		
	}

	@Override
	public void partDeactivated(IWorkbenchPartReference partRef) {

	}

	@Override
	public void partHidden(IWorkbenchPartReference partRef) {
	
	}

	@Override
	public void partInputChanged(IWorkbenchPartReference partRef) {
	
	}

	@Override
	public void partOpened(IWorkbenchPartReference partRef) {
		activate(partRef);		
	}

	@Override
	public void partVisible(IWorkbenchPartReference partRef) {
	
	}
}
