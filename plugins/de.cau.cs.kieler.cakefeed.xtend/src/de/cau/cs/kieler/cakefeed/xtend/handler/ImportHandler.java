package de.cau.cs.kieler.cakefeed.xtend.handler;

import java.io.File;
import java.io.IOException;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramWorkbenchPart;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;

import de.cau.cs.kieler.functionblocks.AdapterConnections;
import de.cau.cs.kieler.functionblocks.DocumentRoot;
import de.cau.cs.kieler.functionblocks.FBType;
import de.cau.cs.kieler.functionblocks.FunctionblocksFactory;
import de.cau.cs.kieler.functionblocks.FunctionblocksPackage;
import de.cau.cs.kieler.functionblocks.util.FunctionblocksResourceFactoryImpl;

public class ImportHandler extends AbstractHandler implements IHandler{

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		
		IEditorPart activeEditor = PlatformUI.getWorkbench().getActiveWorkbenchWindow()
									.getActivePage().getActiveEditor();
		if (activeEditor instanceof IDiagramWorkbenchPart) {
			//EObject obj = ((View) ((IDiagramWorkbenchPart) activeEditor)
			//				.getDiagramEditPart().getModel()).getElement();
			
			//IFile file = ((FileEditorInput) activeEditor.getEditorInput()).getFile();
			//final URI uri = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
			
			
			// open file wizard
			FileDialog dialog = new FileDialog(activeEditor.getSite().getShell(), SWT.SINGLE);
			String fileName = dialog.open();
			
			//test
			String[] fileNameArray = {fileName};
			main(fileNameArray);
			//end test
			
			final URI uri = URI.createFileURI(fileName);
			// activate package
			FunctionblocksPackage p = FunctionblocksPackage.eINSTANCE;

			
			// read file
			ResourceSet resourceSet = new ResourceSetImpl();
			//resourceSet.getPackageRegistry().put(FunctionblocksPackage.eNS_URI, FunctionblocksPackage.eINSTANCE);
			
			//test
			FBType fbtype = FunctionblocksFactory.eINSTANCE.createFBType();
			//end test
			Resource resource = resourceSet.getResource(/*URI.createFileURI(fileName)*/uri, true);
			
			// activate package
			FunctionblocksPackage q = FunctionblocksPackage.eINSTANCE;
			
			EList<EObject> contents = resource.getContents();
			System.out.println("");
			// transform model
			
			// put transformed model into open editor
			
		}	
		return null;
	}
	
	public static void main(String[] args) {
		// Create a resource set to hold the resources.
		//
		ResourceSet resourceSet = new ResourceSetImpl();
		
		// Register the appropriate resource factory to handle all file extensions.
		//
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put
			(Resource.Factory.Registry.DEFAULT_EXTENSION, 
			 new FunctionblocksResourceFactoryImpl());

		// Register the package to ensure it is available during loading.
		//
		resourceSet.getPackageRegistry().put
			(FunctionblocksPackage.eNS_URI, 
			 FunctionblocksPackage.eINSTANCE);
        
		// If there are no arguments, emit an appropriate usage message.
		//
		if (args.length == 0) {
			System.out.println("Enter a list of file paths or URIs that have content like this:");
			try {
				Resource resource = resourceSet.createResource(URI.createURI("http:///My.functionblocks"));
				DocumentRoot documentRoot = FunctionblocksFactory.eINSTANCE.createDocumentRoot();
				AdapterConnections root = FunctionblocksFactory.eINSTANCE.createAdapterConnections();
				documentRoot.setAdapterConnections(root);
				resource.getContents().add(documentRoot);
				resource.save(System.out, null);
			}
			catch (IOException exception) {
				exception.printStackTrace();
			}
		}
		else {
			// Iterate over all the arguments.
			//
			for (int i = 0; i < args.length; ++i) {
				// Construct the URI for the instance file.
				// The argument is treated as a file path only if it denotes an existing file.
				// Otherwise, it's directly treated as a URL.
				//
				File file = new File(args[i]);
				URI uri = file.isFile() ? URI.createFileURI(file.getAbsolutePath()): URI.createURI(args[0]);

				try {
					// Demand load resource for this file.
					//
					Resource resource = resourceSet.getResource(uri, true);
					System.out.println("Loaded " + uri);

					// Validate the contents of the loaded resource.
					//
					for (EObject eObject : resource.getContents()) {
						Diagnostic diagnostic = Diagnostician.INSTANCE.validate(eObject);
						if (diagnostic.getSeverity() != Diagnostic.OK) {
							printDiagnostic(diagnostic, "");
						}
					}
				}
				catch (RuntimeException exception) {
					System.out.println("Problem loading " + uri);
					exception.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * Prints diagnostics with indentation.
	 * <!-- end-user-doc -->
	 * @param diagnostic the diagnostic to print.
	 * @param indent the indentation for printing.
	 * @generated
	 */
	protected static void printDiagnostic(Diagnostic diagnostic, String indent) {
		System.out.print(indent);
		System.out.println(diagnostic.getMessage());
		for (Diagnostic child : diagnostic.getChildren()) {
			printDiagnostic(child, indent + "  ");
		}
	}

}
