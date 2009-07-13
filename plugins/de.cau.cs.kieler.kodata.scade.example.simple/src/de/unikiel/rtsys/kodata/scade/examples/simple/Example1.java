package edu.unikiel.rtsys.kodata.scade.examples.simple;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.esterel.common.util.EsterelUtil;
import com.esterel.project.api.FileRef;
import com.esterel.project.api.ProjectPackage;
import com.esterel.project.api.util.ProjectResourceFactoryImpl;
import com.esterel.scade.api.Operator;
import com.esterel.scade.api.ScadePackage;
import com.esterel.scade.api.pragmas.editor.EditorPragmasPackage;
import com.esterel.scade.api.pragmas.editor.util.EditorPragmasResourceFactoryImpl;
import com.esterel.scade.api.util.ScadeResourceFactoryImpl;

public class Example1 {

	/**
	 * This example shows how to load and traverse a SCADE model using only plain EMF code,
	 * without knowing anything about the underlying storage-related concepts of the SCADE API.
	 */
	public static void main(String[] args) {
		// Register packages and factories.
		initPackagesAndFactories();
		
		// Prepare the resource set that will contain all our artefacts.
		ResourceSet resourceSet = new ResourceSetImpl();

		// Load the main model file.
		String scadeSuiteBinDir = EsterelUtil.getScadeSuiteBinDir();
		loadModel(scadeSuiteBinDir + "\\..\\examples\\CruiseControl\\CruiseControl\\CruiseControl.etp", resourceSet);
		
		// Traverse the model, looking for specific SCADE entities like operators.
		TreeIterator<java.lang.Object> modelIterator = EcoreUtil.getAllProperContents(resourceSet, true);
		while (modelIterator.hasNext()) {
			java.lang.Object object = modelIterator.next();
			if (object instanceof Operator) {
				// Print information about SCADE operators.
				Operator operator = (Operator)object;
				System.out.println(operator.getName());
			}
		}
		
	}
	
	/**
	 * Initialize the packages and factories needed to manipulate SCADE models.
	 * @return The initialization status (true upon success)
	 */
	static boolean initPackagesAndFactories() {
		boolean packagesInitialized =
			ProjectPackage.eINSTANCE   != null
		 && ScadePackage.eINSTANCE     != null
		 && EditorPragmasPackage.eINSTANCE != null;
	
		ProjectResourceFactoryImpl theProjectResourceFactory = new ProjectResourceFactoryImpl();
		ScadeResourceFactoryImpl theScadeResourceFactory = new ScadeResourceFactoryImpl();
		EditorPragmasResourceFactoryImpl theGraphicalResourceFactory = new EditorPragmasResourceFactoryImpl();

		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("etp", theProjectResourceFactory);
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("xscade", theScadeResourceFactory);
		Resource.Factory.Registry.INSTANCE.getProtocolToFactoryMap().put("scade", theScadeResourceFactory);
		Resource.Factory.Registry.INSTANCE.getProtocolToFactoryMap().put("scade.ed", theGraphicalResourceFactory);
		
		return packagesInitialized;
	}
	
	/**
	 * Load a model into the resource set.
	 * @param path
	 * @param resourceSet
	 */
	static void loadModel(String path, ResourceSet resourceSet) {
		Set<String> loadedLibraries = new HashSet<String>();
		loadModel(path, resourceSet, loadedLibraries);
	}
	
	/**
	 * Load a model (the main model or a library model) into the resource set.
	 * @param path The path of the model to be loaded
	 * @param resourceSet The target resource set
	 */
	static void loadModel(String path, ResourceSet resourceSet, Set<String> loadedLibraries) {
		// Load only if not already loaded (beware of recursive loading of libraries).
		if (!loadedLibraries.add(path)) return;
	
		// Load the project file.
		URI projectUri = URI.createFileURI(path);
		Resource projectResource = resourceSet.getResource(projectUri, true);
		
		// Traverse the project, looking for SCADE files or libraries to be loaded.
		TreeIterator<EObject> projectIterator = projectResource.getAllContents();
		while (projectIterator.hasNext()) {
			EObject object = projectIterator.next();
			if (object instanceof FileRef) {
				FileRef fileRef = (FileRef)object;
				IPath pathname = fileRef.getPathName();
				String extension = pathname.getFileExtension();
				if (extension.equals("xscade")) {
					// A SCADE XML File.
					String nonRootProp = fileRef.getToolProp("SCADE", "NONROOT", null);
					if (nonRootProp != null && Boolean.parseBoolean(nonRootProp)) {
						// A non root file (i.e. a file containing a separate SCADE object). Skip it.
						// It cannot be loaded stand-alone, and will be loaded automatically as part of loading its parent package.
					} else {
						URI scadeUri = URI.createFileURI(pathname.toString());
						resourceSet.getResource(scadeUri, true);
					}
				} else if (extension.equals("etp")) {
					// A SCADE library file.
					loadModel(pathname.toString(), resourceSet, loadedLibraries);
				}
			}
		}
	}

}
