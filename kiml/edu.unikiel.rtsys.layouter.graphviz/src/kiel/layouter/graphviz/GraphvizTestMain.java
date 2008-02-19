package kiel.layouter.graphviz;

public class GraphvizTestMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
    	    
		final String name = "TestGraph";
		GraphvizAPI.initialize();
		int g = GraphvizAPI.createGraph(name);
			
		
	}

}
