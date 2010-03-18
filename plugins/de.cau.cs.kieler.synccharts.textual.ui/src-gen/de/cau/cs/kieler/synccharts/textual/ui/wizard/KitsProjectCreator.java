package de.cau.cs.kieler.synccharts.textual.ui.wizard;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.xtend.type.impl.java.JavaBeansMetaModel;
import org.eclipse.xpand2.XpandExecutionContextImpl;
import org.eclipse.xpand2.XpandFacade;
import org.eclipse.xpand2.output.Outlet;
import org.eclipse.xpand2.output.OutputImpl;
import org.eclipse.xtext.ui.core.util.EclipseResourceUtil;
import org.eclipse.xtext.ui.core.wizard.DefaultProjectCreator;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

public class KitsProjectCreator extends DefaultProjectCreator {

	private static final String DSL_GENERATOR_PROJECT_NAME = "de.cau.cs.kieler.synccharts.textual.kits.generator";

	private static final String SRC_ROOT = "src";
	private static final String SRC_GEN_ROOT = "src-gen";
	private final List<String> SRC_FOLDER_LIST = Collections
			.unmodifiableList(Arrays.asList(SRC_ROOT, SRC_GEN_ROOT));

	@Override
	protected KitsProjectInfo getProjectInfo() {
		return (KitsProjectInfo) super.getProjectInfo();
	}

	@Override
	protected void execute(final IProgressMonitor monitor)
			throws CoreException, InvocationTargetException, InterruptedException {
		SubMonitor subMonitor = SubMonitor.convert(monitor, 
				"Creating model project " + getProjectInfo().getProjectName(), 
				2);
		try {
			final IProject project = createProject(subMonitor.newChild(1));
			if (project == null)
				return;
			initializeProject(project, subMonitor.newChild(1));
			IFile modelFile = getModelFile(project);
			setResult(modelFile);
		} finally {
			subMonitor.done();
		}
	}

	protected IProject createProject(IProgressMonitor monitor) {
		final IProject project = EclipseResourceUtil.createProject(
				getProjectInfo().getProjectName(),
				getSourceFolders(), 
				getReferencedProjects(),
				Sets.newLinkedHashSet(getRequiredBundles()), 
				getExportedPackages(),
				getImportedPackages(), 
				getActivatorClassName(),
				monitor,
				null,
				getProjectNatures()
		);
		return project;
	}
	
	protected List<String> getSourceFolders() {
        return SRC_FOLDER_LIST;
    }

	protected List<IProject> getReferencedProjects() {
        return Collections.<IProject> emptyList();
    }

    protected List<String> getExportedPackages() {
        return null;
    }

    protected List<String> getImportedPackages() {
        return Lists.newArrayList("org.apache.log4j");
    }

    protected String getActivatorClassName() {
        return null;
    }
    
    protected String[] getProjectNatures() {
        return new String[] {
        	"org.eclipse.jdt.core.javanature",
			"org.eclipse.pde.PluginNature",
			"org.eclipse.xtext.builder.xtextNature"
		};
    }
    
	protected List<String> getRequiredBundles() {
		return Lists.newArrayList(
			"com.ibm.icu",
			"org.eclipse.xtext", 
			"org.eclipse.xtext.generator",
			"org.eclipse.xtend",
			"org.eclipse.xtend.typesystem.emf",
			"org.eclipse.xpand", 
			"de.itemis.xtext.antlr;resolution:=optional",
			"org.eclipse.xtend.util.stdlib",
			DSL_GENERATOR_PROJECT_NAME);
	}

	protected void initializeProject(final IProject project, final IProgressMonitor monitor) throws CoreException {
		OutputImpl output = new OutputImpl();
		output.addOutlet(new Outlet(false, getEncoding(), null, true, project.getLocation().makeAbsolute().toOSString()));

		XpandExecutionContextImpl execCtx = new XpandExecutionContextImpl(output, null);
		execCtx.setFileEncoding("UTF-8");
		execCtx.registerMetaModel(new JavaBeansMetaModel());

		XpandFacade facade = XpandFacade.create(execCtx);
		facade.evaluate("de::cau::cs::kieler::synccharts::dsl::ui::wizard::KitsNewProject::main", getProjectInfo());

		project.refreshLocal(IResource.DEPTH_INFINITE, monitor);
	}

	protected IFile getModelFile(IProject project) throws CoreException {
		IFolder srcFolder = project.getFolder(SRC_ROOT);
		for (IResource resource : srcFolder.members()) {
			if (IResource.FILE == resource.getType() && "kits".equals(resource.getFileExtension())) {
				return (IFile) resource;
			}
		}
		return null;
	}

}