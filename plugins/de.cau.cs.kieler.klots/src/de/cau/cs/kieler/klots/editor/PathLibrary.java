package de.cau.cs.kieler.klots.editor;

import java.util.ArrayList;
import java.util.List;

public class PathLibrary {
	
	private static final PathLibrary INSTANCE = new PathLibrary();
//	private String path = "";
	
	class Container {
		String projectName;
		String projectPath;
		
		Container(String projectName, String projectPath) {
			this.projectName = projectName;
			this.projectPath = projectPath;
		}
		
		String getProjectName() {
			return projectName;
		}
		
		void setProjectName(String projectName) {
			this.projectName = projectName;
		}
		
		String getProjectPath() {
			return projectPath;
		}
		
		void setProjectPath(String projectPath) {
			this.projectPath = projectPath;
		}
	}
	
	
	private List<Container> paths = new ArrayList<Container>();
	
	public PathLibrary() {
	}
	
	public static PathLibrary getInstance() {
		return INSTANCE;
	}

//	public String getPath() {
//		return path;
//	}
//
//	public void setPath(String path) {
//		this.path = path;
//	}

	
	public String getProjectPath(String projectName) {
		for(int i = 0; i < paths.size(); i++) {
			if( (paths.get(i).getProjectName()).equals(projectName) ) {
				return paths.get(i).getProjectPath();
			}
		}
		return "";
	}

	public void addToLibrary(String projectName, String projectPath) {
		paths.add( new Container(projectName, projectPath) );
	}
	
}
