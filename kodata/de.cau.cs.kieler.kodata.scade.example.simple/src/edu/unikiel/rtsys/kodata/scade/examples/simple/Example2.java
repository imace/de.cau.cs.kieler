package edu.unikiel.rtsys.kodata.scade.examples.simple;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import com.esterel.project.api.Configuration;
import com.esterel.project.api.FileRef;
import com.esterel.project.api.Folder;
import com.esterel.project.api.Project;
import com.esterel.project.api.Element;
import com.esterel.project.api.ProjectFactory;
import com.esterel.project.api.ProjectPackage;
import com.esterel.project.api.Prop;
import com.esterel.project.api.util.ProjectResourceFactoryImpl;
import com.esterel.scade.api.OperatorKind;
import com.esterel.scade.api.ScadeFactory;
import com.esterel.scade.api.ScadePackage;
import com.esterel.scade.api.pragmas.editor.EditorPragmasFactory;
import com.esterel.scade.api.pragmas.editor.EditorPragmasPackage;
import com.esterel.scade.api.pragmas.editor.TreeDiagram;
import com.esterel.scade.api.pragmas.editor.TreeDiagramKind;
import com.esterel.scade.api.pragmas.editor.util.EditorPragmasResourceFactoryImpl;
import com.esterel.scade.api.pragmas.editor.util.EditorPragmasUtil;
import com.esterel.scade.api.util.ScadeResourceFactoryImpl;

public class Example2 {

	/**
	 * This example shows how to create a new SCADE project containing some SCADE model files
	 * (both "root" model files and "separate" model files).
	 * The created SCADE model also contains one diagram, showing how diagrams can be created.
	 */
	public static void main(String[] args) {
		initPackagesAndFactories();
		ResourceSet resourceSet = new ResourceSetImpl();
		createEmptyScadeProject(resourceSet);
		createScadeModel(resourceSet);
		updateProjectWithModelFiles(resourceSet);
		saveAll(resourceSet);
	}

	static ProjectResourceFactoryImpl theProjectResourceFactory = new ProjectResourceFactoryImpl();
	static ScadeResourceFactoryImpl theScadeResourceFactory = new ScadeResourceFactoryImpl();
	static EditorPragmasResourceFactoryImpl theGraphicalResourceFactory = new EditorPragmasResourceFactoryImpl();
	
	/**
	 * Initialize the packages and factories needed to manipulate SCADE models.
	 * @return The initialization status (true upon success)
	 */
	static boolean initPackagesAndFactories() {
		boolean packagesInitialized =
			ProjectPackage.eINSTANCE       != null
		 && ScadePackage.eINSTANCE         != null
		 && EditorPragmasPackage.eINSTANCE != null;
	
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("etp", theProjectResourceFactory);
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("xscade", theScadeResourceFactory);
		Resource.Factory.Registry.INSTANCE.getProtocolToFactoryMap().put("scade.ed", theGraphicalResourceFactory);
		
		return packagesInitialized;
	}
	
	/**
	 * Creates an empty SCADE project ready to receive SCADE model files.
	 * @param resourceSet
	 */
	static void createEmptyScadeProject(ResourceSet resourceSet) {
		String path = "U:\\example1\\example1.etp";
		
		// Create the project model.
		ProjectFactory theProjectFactory = ProjectPackage.eINSTANCE.getProjectFactory();

		// Create a project resource.
		Resource projectResource = resourceSet.createResource(URI.createFileURI(path));
		
		// Create the project.
		Project project = theProjectFactory.createProject();
		project.setPathname(path);
		projectResource.getContents().add(project);

		// Create a default configuration.
		Configuration configuration = theProjectFactory.createConfiguration();
		configuration.setName("Default");
		project.getConfiguration().add(configuration);
		project.setDefaultConfiguration(configuration);
		
		Prop prop;
		// Create a SCADE project product property.
		prop = theProjectFactory.createProp();
		prop.setName("@STUDIO:PRODUCT");
		prop.getValue().add("SC");
		project.getProp().add(prop);
		
		// Create a SCADE project product property.
		prop = theProjectFactory.createProp();
		prop.setName("@SCADE:SEMFILE");
		prop.getValue().add("example1.err");
		project.getProp().add(prop);

		
		// Create the folder for SCADE model files.
		Folder modelFolder = theProjectFactory.createFolder();
		modelFolder.setName("Model Files");
		modelFolder.setExtensions("xscade");
		project.getRoot().add(modelFolder);

		// Create the folder for SCADE separate model files.
		Folder separateFolder = theProjectFactory.createFolder();
		separateFolder.setName("Separate Files");
		separateFolder.setExtensions("xscade");
		modelFolder.getElement().add(separateFolder);

		// Add predefined SCADE libraries to the project.
		setDefaultScadeLibraries(project);
	}
	
	/**
	 * Add the set of all predefined SCADE libraries to the project.
	 * @param project
	 */
	static void setDefaultScadeLibraries(Project project) {
		ProjectFactory   theProjectFactory   = ProjectPackage.eINSTANCE.getProjectFactory();
		// Create the library folder
		Folder folder = theProjectFactory.createFolder();
		folder.setName("SCADE Libraries");
		folder.setExtensions("vsp;etp");
		project.getRoot().add(folder);
		
		String libraries[] = {
				"libdigital",
				"liblinear",
				"libmath",
				"libmathext",
				"libpwlinear"
		};
		for (int l = 0; l < libraries.length; l++) {
			String library = libraries[l];
			addDefaultLibrary(folder, library);
		}
	}
	
	/**
	 * Add one of the default library to the SCADE project.
	 * @param folder
	 * @param baseName
	 * @return
	 */
	static FileRef addDefaultLibrary(Folder folder, String baseName)
	{
		ProjectFactory   theProjectFactory   = ProjectPackage.eINSTANCE.getProjectFactory();

		IPath path = new Path("$(SCADE)");
	    path = path.append("libraries");
	    path = path.append(baseName);
	    path = path.append(baseName);
	    path = path.addFileExtension("etp");

	    FileRef fileRef = theProjectFactory.createFileRef();
	    fileRef.setPersistAs(path.toOSString());
	    folder.getElement().add(fileRef);

	    return fileRef;
	}
	
	/**
	 * Update the SCADE project in the resource set
	 * according to all SCADE model files also present in the resource set. 
	 * @param resourceSet
	 */
	static void updateProjectWithModelFiles(ResourceSet resourceSet) {
		// Find the project.
		Resource projectResource = null;
		for (Resource resource : resourceSet.getResources()) {
			if (resource.getURI().toFileString().endsWith(".etp")) {
				projectResource = resource;
				break;
			}
		}
		if (projectResource == null) return;
		Project project = (Project)projectResource.getContents().get(0);
		
		// Find the folder for model files.
		Folder modelFolder = null;
		for (Element element : project.getRoot()) {
			if (element instanceof Folder) {
				Folder folder = (Folder)element;
				if (folder.getName().equals("Model Files")) {
					modelFolder = folder;
					break;
				}
			}
		}
		if (modelFolder == null) return;
		
		// Find the folder for separate model files.
		Folder separateFolder = null;
		for (Element element : modelFolder.getElement()) {
			if (element instanceof Folder) {
				Folder folder = (Folder)element;
				if (folder.getName().equals("Separate Files")) {
					separateFolder = folder;
					break;
				}
			}
		}
		if (separateFolder == null) return;
		
		ProjectFactory theProjectFactory = ProjectPackage.eINSTANCE.getProjectFactory();

		// Add all SCADE files to the appropriate project folder.
		for (Resource resource : resourceSet.getResources()) {
			String resourceURI = resource.getURI().toFileString();
			if (resourceURI != null && resourceURI.endsWith(".xscade")) {
				// We assume the files are all located in the same directory as the project file.
				IPath path = new Path(resourceURI);
				String persistAs = path.lastSegment();
				FileRef fileRef = theProjectFactory.createFileRef();
				fileRef.setPersistAs(persistAs);
				// Check whether the content of the SCADE model files is separated or not.
				EObject root = resource.getContents().get(0);
				EObject owner = root.eContainer();
				Resource ownerResource = owner != null ? owner.eResource() : null;
				if (ownerResource == null || !ownerResource.getURI().toFileString().endsWith(".xscade")) {
					// This object is at the root of the model, not in a separate file.
					modelFolder.getElement().add(fileRef);
				} else {
					// This object is separate from its owner.
					fileRef.setToolProp("SCADE", "NONROOT", "true", null);
					separateFolder.getElement().add(fileRef);
				}
			}
		}
		
	}
	
	/**
	 * Save all SCADE-related resources in the resource set.
	 * @param resourceSet
	 */
	static void saveAll(ResourceSet resourceSet) {
		for (Resource resource : resourceSet.getResources()) {
			String resourceURI = resource.getURI().toFileString();
			if (resourceURI != null && (resourceURI.endsWith(".etp") || resourceURI.endsWith(".xscade"))) {
				try {
					resource.save(null);
				} catch (Exception e) {
					System.out.println("Exception during resource saving: " + resource.getURI().toFileString());
				}
			}
		}
	}
	
	/**
	 * Create an example SCADE model, split over two files.
	 * @param resourceSet
	 */
	static void createScadeModel(ResourceSet resourceSet) {
		ScadeFactory         theScadeFactory         = ScadePackage.eINSTANCE.getScadeFactory();
		EditorPragmasFactory theEditorPragmasFactory = EditorPragmasPackage.eINSTANCE.getEditorPragmasFactory();
				

		// Create model.
		
		// Create a resource for the main package.
		Resource resourcePackage1 = resourceSet.createResource(URI.createFileURI("U:\\example1\\Package1.xscade"));
	
		// Create a resource for a separated operator.
		Resource resourceOperator2 = resourceSet.createResource(URI.createFileURI("U:\\example1\\Operator2.xscade"));
		
		// Create a Package "Package1"
		com.esterel.scade.api.Package Package1 = theScadeFactory.createPackage();
		Package1.setName("Package1");
		resourcePackage1.getContents().add(Package1);

		com.esterel.scade.api.pragmas.editor.Package Package1_Pragma = theEditorPragmasFactory.createPackage();
		Package1.getPragma().add(Package1_Pragma);

		// Create pseudo predefined types.
		com.esterel.scade.api.Type TypeBool = theScadeFactory.createType();
		TypeBool.setName("bool");
		
		com.esterel.scade.api.Operator Operator1 = theScadeFactory.createOperator();
		Operator1.setName("Operator1");
		Operator1.setKind(OperatorKind.NODE_LITERAL);
		Package1.getDeclaration().add(Operator1);

		com.esterel.scade.api.Operator Operator2 = theScadeFactory.createOperator();
		Operator2.setName("Operator2");
		Operator2.setKind(OperatorKind.NODE_LITERAL);
		Package1.getDeclaration().add(Operator2);
		
		com.esterel.scade.api.Operator Operator3 = theScadeFactory.createOperator();
		Operator3.setName("Operator3");
		Operator3.setKind(OperatorKind.NODE_LITERAL);
		Package1.getDeclaration().add(Operator3);

		com.esterel.scade.api.Variable Operator1_Input1 = theScadeFactory.createVariable();
		Operator1_Input1.setName("Input1");
		com.esterel.scade.api.NamedType Operator1_Input1_Type = theScadeFactory.createNamedType();
		Operator1_Input1_Type.setType(TypeBool);
		Operator1_Input1.setType(Operator1_Input1_Type);
		Operator1.getInput().add(Operator1_Input1);
		com.esterel.scade.api.Variable Operator1_Output1 = theScadeFactory.createVariable();
		Operator1_Output1.setName("Output1");
		com.esterel.scade.api.NamedType Operator1_Output1_Type = theScadeFactory.createNamedType();
		Operator1_Output1_Type.setType(TypeBool);
		Operator1_Output1.setType(Operator1_Output1_Type);
		Operator1.getOutput().add(Operator1_Output1);

		com.esterel.scade.api.Variable Operator2_Input1 = theScadeFactory.createVariable();
		Operator2_Input1.setName("Input1");
		Operator2.getInput().add(Operator2_Input1);
		com.esterel.scade.api.Variable Operator2_Output1 = theScadeFactory.createVariable();
		Operator2_Output1.setName("Output1");
		Operator2.getOutput().add(Operator2_Output1);

		com.esterel.scade.api.Variable Operator3_Input1 = theScadeFactory.createVariable();
		Operator3_Input1.setName("Input1");
		Operator3.getInput().add(Operator3_Input1);
		com.esterel.scade.api.Variable Operator3_Output1 = theScadeFactory.createVariable();
		Operator3_Output1.setName("Output1");
		Operator3.getOutput().add(Operator3_Output1);

		// Add an equation in Operator1 to represent its input Input1
		com.esterel.scade.api.Variable Operator1__L1 = theScadeFactory.createVariable();
		Operator1__L1.setName("_L1");
		com.esterel.scade.api.NamedType Operator1__L1_Type = theScadeFactory.createNamedType();
		Operator1__L1_Type.setType(TypeBool);
		Operator1__L1.setType(Operator1__L1_Type);
		Operator1.getLocal().add(Operator1__L1);
		com.esterel.scade.api.Equation Operator1_Equation1 = theScadeFactory.createEquation();
		Operator1_Equation1.getLeft().add(Operator1__L1);
		com.esterel.scade.api.IdExpression Operator1_Equation1_rightExpr1 = theScadeFactory.createIdExpression();
		Operator1_Equation1_rightExpr1.setPath(Operator1_Input1);
		Operator1_Equation1.setRight(Operator1_Equation1_rightExpr1);
		Operator1.getData().add(Operator1_Equation1);
		EditorPragmasUtil.setOid(Operator1_Equation1, "Op1Eq1Oid");
		
		// Add an equation in Operator1 to represent a call to Operator2
		com.esterel.scade.api.Variable Operator1__L2 = theScadeFactory.createVariable();
		Operator1__L2.setName("_L2");
		com.esterel.scade.api.NamedType Operator1__L2_Type = theScadeFactory.createNamedType();
		Operator1__L2_Type.setType(TypeBool);
		Operator1__L2.setType(Operator1__L2_Type);
		Operator1.getLocal().add(Operator1__L2);
		com.esterel.scade.api.Equation Operator1_Equation2 = theScadeFactory.createEquation();
		Operator1_Equation2.getLeft().add(Operator1__L2);
		com.esterel.scade.api.CallExpression Operator1_Equation2_rightExpr = theScadeFactory.createCallExpression();
		com.esterel.scade.api.OpCall Operator1_Equation2_OpCall = theScadeFactory.createOpCall();
		Operator1_Equation2_OpCall.setOperator(Operator2);
		Operator1_Equation2_OpCall.setName("1"); // occNum
		Operator1_Equation2_rightExpr.setOperator(Operator1_Equation2_OpCall);
		com.esterel.scade.api.IdExpression Operator1_Equation2_rightExpr1 = theScadeFactory.createIdExpression();
		Operator1_Equation2_rightExpr1.setPath(Operator1__L1);
		Operator1_Equation2_rightExpr.getCallParameter().add(Operator1_Equation2_rightExpr1);
		Operator1_Equation2.setRight(Operator1_Equation2_rightExpr);
		Operator1.getData().add(Operator1_Equation2);
		EditorPragmasUtil.setOid(Operator1_Equation2, "Op1Eq2Oid");

		// Add an equation in Operator1 to represent its output Output1
		com.esterel.scade.api.Equation Operator1_Equation3 = theScadeFactory.createEquation();
		Operator1_Equation3.getLeft().add(Operator1_Output1);
		com.esterel.scade.api.IdExpression Operator1_Equation3_rightExpr1 = theScadeFactory.createIdExpression();
		Operator1_Equation3_rightExpr1.setPath(Operator1__L2);
		Operator1_Equation3.setRight(Operator1_Equation3_rightExpr1);
		Operator1.getData().add(Operator1_Equation3);
		EditorPragmasUtil.setOid(Operator1_Equation3, "Op1Eq3Oid");

		// Add graphical net-diagram in Operator1.
		com.esterel.scade.api.pragmas.editor.Operator Operator1_Pragma = theEditorPragmasFactory.createOperator();
		Operator1.getPragma().add(Operator1_Pragma);
		Operator1_Pragma.setNodeKind("graphical");
		com.esterel.scade.api.pragmas.editor.NetDiagram Operator1_Diagram = theEditorPragmasFactory.createNetDiagram();
		Operator1_Diagram.setName("Operator1_diagram");
		Operator1_Diagram.setFormat("A4 (210 297)");
		Operator1_Diagram.setLandscape(true);
		Operator1_Pragma.getDiagram().add(Operator1_Diagram);

		// Add symbol representing the input Input1 (Equation1)
		com.esterel.scade.api.pragmas.editor.EquationGE Operator1_EquationGE1 = theEditorPragmasFactory.createEquationGE();
		Operator1_EquationGE1.setEquation(Operator1_Equation1);
		com.esterel.scade.api.pragmas.editor.Point Operator1_EquationGE1_Position = theEditorPragmasFactory.createPoint();
		Operator1_EquationGE1_Position.setX(1000);
		Operator1_EquationGE1_Position.setY(1000);
		Operator1_EquationGE1.setPosition(Operator1_EquationGE1_Position);
		com.esterel.scade.api.pragmas.editor.Size Operator1_EquationGE1_Size = theEditorPragmasFactory.createSize();
		Operator1_EquationGE1_Size.setWidth(2000);
		Operator1_EquationGE1_Size.setHeight(1000);
		Operator1_EquationGE1.setSize(Operator1_EquationGE1_Size);
		Operator1_Diagram.getPresentationElement().add(Operator1_EquationGE1);

		// Add symbol representing the call to Operator2 (Equation2)
		com.esterel.scade.api.pragmas.editor.EquationGE Operator1_EquationGE2 = theEditorPragmasFactory.createEquationGE();
		Operator1_EquationGE2.setEquation(Operator1_Equation2);
		com.esterel.scade.api.pragmas.editor.Point Operator1_EquationGE2_Position = theEditorPragmasFactory.createPoint();
		Operator1_EquationGE2_Position.setX(5000);
		Operator1_EquationGE2_Position.setY(1000);
		Operator1_EquationGE2.setPosition(Operator1_EquationGE2_Position);
		com.esterel.scade.api.pragmas.editor.Size Operator1_EquationGE2_Size = theEditorPragmasFactory.createSize();
		Operator1_EquationGE2_Size.setWidth(4000);
		Operator1_EquationGE2_Size.setHeight(3000);
		Operator1_EquationGE2.setSize(Operator1_EquationGE2_Size);
		Operator1_Diagram.getPresentationElement().add(Operator1_EquationGE2);

		// Add symbol representing the output Output1 (Equation3)
		com.esterel.scade.api.pragmas.editor.EquationGE Operator1_EquationGE3 = theEditorPragmasFactory.createEquationGE();
		Operator1_EquationGE3.setEquation(Operator1_Equation3);
		com.esterel.scade.api.pragmas.editor.Point Operator1_EquationGE3_Position = theEditorPragmasFactory.createPoint();
		Operator1_EquationGE3_Position.setX(20000);
		Operator1_EquationGE3_Position.setY(10000);
		Operator1_EquationGE3.setPosition(Operator1_EquationGE3_Position);
		com.esterel.scade.api.pragmas.editor.Size Operator1_EquationGE3_Size = theEditorPragmasFactory.createSize();
		Operator1_EquationGE3_Size.setWidth(2000);
		Operator1_EquationGE3_Size.setHeight(1000);
		Operator1_EquationGE3.setSize(Operator1_EquationGE3_Size);
		Operator1_Diagram.getPresentationElement().add(Operator1_EquationGE3);
		
		// Add an edge representing the "_L1" flow from Input1 to the parameter of the call.
		com.esterel.scade.api.pragmas.editor.Edge Operator1_Edge1 = theEditorPragmasFactory.createEdge();
		Operator1_Edge1.setSrcEquation(Operator1_EquationGE1);
		Operator1_Edge1.setDstEquation(Operator1_EquationGE2);
		Operator1_Edge1.setLeftVarIndex(1);   // First (and unique) pin going out of the input symbol for Input1.
		Operator1_Edge1.setRightExprIndex(1); // First (and unique) pin coming in the box symbol for the call. 
		com.esterel.scade.api.pragmas.editor.Point Operator1_Edge1_Point1 = theEditorPragmasFactory.createPoint();
		com.esterel.scade.api.pragmas.editor.Point Operator1_Edge1_Point2 = theEditorPragmasFactory.createPoint();
		com.esterel.scade.api.pragmas.editor.Point Operator1_Edge1_Point3 = theEditorPragmasFactory.createPoint();
		com.esterel.scade.api.pragmas.editor.Point Operator1_Edge1_Point4 = theEditorPragmasFactory.createPoint();
		Operator1_Edge1_Point1.setX(3000);
		Operator1_Edge1_Point1.setY(1200);
		Operator1_Edge1_Point4.setX(5000);
		Operator1_Edge1_Point4.setY(2000);
		Operator1_Edge1.getPosition().add(Operator1_Edge1_Point1);
		Operator1_Edge1.getPosition().add(Operator1_Edge1_Point4);
		Operator1_Diagram.getPresentationElement().add(Operator1_Edge1);
		
		// Add an edge representing the "_L2" flow from the output pin of the call to output Output1.
		com.esterel.scade.api.pragmas.editor.Edge Operator1_Edge2 = theEditorPragmasFactory.createEdge();
		Operator1_Edge2.setSrcEquation(Operator1_EquationGE2);
		Operator1_Edge2.setDstEquation(Operator1_EquationGE3);
		Operator1_Edge2.setLeftVarIndex(1);   // First (and unique) pin going out of the box symbol for the call.
		Operator1_Edge2.setRightExprIndex(1); // First (and unique) pin coming in the output symbol. 
		com.esterel.scade.api.pragmas.editor.Point Operator1_Edge2_Point1 = theEditorPragmasFactory.createPoint();
		com.esterel.scade.api.pragmas.editor.Point Operator1_Edge2_Point2 = theEditorPragmasFactory.createPoint();
		com.esterel.scade.api.pragmas.editor.Point Operator1_Edge2_Point3 = theEditorPragmasFactory.createPoint();
		com.esterel.scade.api.pragmas.editor.Point Operator1_Edge2_Point4 = theEditorPragmasFactory.createPoint();
		Operator1_Edge2_Point1.setX(9000);
		Operator1_Edge2_Point1.setY(3000);
		Operator1_Edge2_Point4.setX(20000);
		Operator1_Edge2_Point4.setY(10500);
		Operator1_Edge2.getPosition().add(Operator1_Edge2_Point1);
		Operator1_Edge2.getPosition().add(Operator1_Edge2_Point4);
		Operator1_Diagram.getPresentationElement().add(Operator1_Edge2);

		// Add block diagrams to the package.
		
		TreeDiagram diagramConstants = theEditorPragmasFactory.createTreeDiagram();
		diagramConstants.setBlockKind(TreeDiagramKind.CONSTANTS_LITERAL);
		Package1_Pragma.getDiagram().add(diagramConstants);
		
		TreeDiagram diagramTypes     = theEditorPragmasFactory.createTreeDiagram();
		diagramTypes.setBlockKind(TreeDiagramKind.TYPES_LITERAL);
		Package1_Pragma.getDiagram().add(diagramTypes);

		TreeDiagram diagramSensors   = theEditorPragmasFactory.createTreeDiagram();
		diagramSensors.setBlockKind(TreeDiagramKind.SENSORS_LITERAL);
		Package1_Pragma.getDiagram().add(diagramSensors);

		// Make Operator2 separate.
		resourceOperator2.getContents().add(Operator2);
	}
}
