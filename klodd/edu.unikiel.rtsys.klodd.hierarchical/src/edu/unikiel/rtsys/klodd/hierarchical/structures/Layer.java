package edu.unikiel.rtsys.klodd.hierarchical.structures;

/**
 * A single Layer used in a layered graph.
 * 
 * @author msp
 */
public class Layer {
	
	/** value to use if the rank is undefined */
	public static final int UNDEF_RANK = -1;
	/** value to use if the height is undefined */
	public static final int UNDEF_HEIGHT = -1;

	/** the rank of this layer */
	public int rank;
	/** the height of this layer */
	public int height;
	
	/**
	 * Creates a new layer with given rank and height.
	 * 
	 * @param rank the rank, may be UNDEF_RANK
	 * @param height the height, may be UNDEF_HEIGHT
	 */
	public Layer(int rank, int height)
	{
		this.rank = rank;
		this.height = height;
	}
	
	public void put(Object obj)
	{
		
	}
	
}
