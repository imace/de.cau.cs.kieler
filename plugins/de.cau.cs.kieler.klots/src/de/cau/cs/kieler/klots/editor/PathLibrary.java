package de.cau.cs.kieler.klots.editor;

//import java.util.ArrayList;
//import java.util.List;

public class PathLibrary {
	
	private static final PathLibrary INSTANCE = new PathLibrary();
	private String path = "";
	
//	private List<String> paths = new ArrayList<String>();
	
	public PathLibrary() {	
	}
	
	public static PathLibrary getInstance() {
		return INSTANCE;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
}
