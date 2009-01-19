package de.cau.cs.kieler.standalone;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import edu.unikiel.rtsys.kieler.ssm.AbstractState;
import edu.unikiel.rtsys.kieler.ssm.CompositeState;
import edu.unikiel.rtsys.kieler.ssm.Region;
import edu.unikiel.rtsys.kieler.ssm.SafeStateMachine;
import edu.unikiel.rtsys.kieler.ssm.SimpleState;
import edu.unikiel.rtsys.kieler.ssm.ssmPackage;

public class StandaloneLauncher {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		System.out.println("Standalone started.");
		if (args.length == 1 && new File(args[0]).canRead()) {
			System.out.println("Argument: " + args[0] + "\n");
			URI fileURI = URI
					.createFileURI(new File(args[0]).getAbsolutePath());
			final ResourceSet resourceSet = new ResourceSetImpl();
			
			resourceSet.getPackageRegistry().put(ssmPackage.eNS_URI,
					ssmPackage.eINSTANCE);

			// Register the default resource factory -- only needed for stand-alone!
			  resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(
			    Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());
			  
			Resource ssmResource = resourceSet.createResource(fileURI);
			ssmResource.load(Collections.EMPTY_MAP);
			final SafeStateMachine ssm = (SafeStateMachine) ssmResource
					.getContents().get(0);
			try {
				System.out.println("Safe State Machine: " + ssm.getName());
				Iterator iter1;
				Iterator iter2;
				Region myRegion;
				AbstractState abstractState;
				CompositeState compositeState;
				SimpleState simpleState;
				for (iter1 = ssm.getTop().getRegions().iterator(); iter1.hasNext();) {
					myRegion = (Region) iter1.next();
					System.out.println("  Region: " + myRegion.toString());
					for (iter2 = myRegion.getStates().iterator(); iter2
							.hasNext();) {
						abstractState = (AbstractState) iter2.next();
						if (abstractState instanceof SimpleState) {
							simpleState = (SimpleState) abstractState;
							System.out.println("    SimpleState: "
									+ simpleState.getName());
						}
						if (abstractState instanceof CompositeState) {
							compositeState = (CompositeState) abstractState;
							System.out.println("    CompositeState: "
									+ compositeState.getName());
						}
					}
				}
			} catch (Exception e) {
				System.out.println(e.toString());
			}
		} else {
			System.out.println("Please provide a file name.\n");
		}

	}
}
