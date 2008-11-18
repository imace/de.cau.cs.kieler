package edu.unikiel.rtsys.klodd.core.util;

import java.util.AbstractList;

/**
 * Array list implementation with fixed size. Elements are put
 * to the start or to the end of the array, depending on which
 * add method is used first. 
 * 
 * @author msp
 */
public class FixedArrayList<E> extends AbstractList<E> {

	/**
	 * Types of a fixed array list.
	 */
	public enum Type
	{
		/** the first element is always at position 0 */
		ALIGN_FRONT,
		/** the last element is always at the greatest position */
		ALIGN_BACK
	}
	
	// the type of array list
	private Type type;
	// the array containing element data
	private Object[] array;
	// the number of elements in the array
	private int size = 0;
	// the starting index of the element data
	private int start = -1;
	
	/**
	 * Creates a fixed array list with given capacity.
	 * 
	 * @param capacity maximal number of objects that can be put into the list
	 * @param type type of fixed array list
	 */
	public FixedArrayList(int capacity, Type type)
	{
		super();
        if (capacity < 0)
            throw new IllegalArgumentException("Illegal Capacity: " + capacity);
        
        this.type = type;
		this.array = new Object[capacity];
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.util.AbstractList#get(int)
	 */
	@SuppressWarnings("unchecked")
	public E get(int index) {
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException("Index out of bounds: " + index);
		
		return (E)array[start + index];
	}

	/*
	 * (non-Javadoc)
	 * @see java.util.AbstractCollection#size()
	 */
	public int size() {
		return size;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.util.AbstractList#add(java.lang.Object)
	 */
	public boolean add(E element)
	{
		if (size == array.length)
			throw new UnsupportedOperationException("Capacity exhausted: " + array.length);
		
		if (type == Type.ALIGN_FRONT)
		{
			array[size] = element;
		}
		else
		{
			for (int i = start; i < array.length; i++)
			{
				array[i - 1] = array[i];
			}
			start--;
			array[array.length - 1] = element;
		}
		size++;
		return true;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.util.AbstractList#add(int, java.lang.Object)
	 */
	public void add(int index, E element)
	{
		if (index < 0)
			throw new IndexOutOfBoundsException("Index out of bounds: " + index);
		if (index >= array.length)
			throw new UnsupportedOperationException("Capacity exhausted: " + array.length);
		
		if (type == Type.ALIGN_FRONT)
		{
			for (int i = size - 1; i >= index; i--)
			{
				array[i + 1] = array[i];
			}
		}
		else
		{
			for (int i = start; i < index; i++)
			{
				array[i - 1] = array[i];
			}
			start--;
		}
		array[start + index] = element;
		size++;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.util.AbstractList#remove(int)
	 */
	public E remove(int index)
	{
		E previous = get(index);
		if (type == Type.ALIGN_FRONT)
		{
			for (int i = index; i < size - 1; i++)
			{
				array[i] = array[i + 1];
			}
		}
		else
		{
			for (int i = start + index; i > start; i--)
			{
				array[i] = array[i - 1];
			}
			start++;
		}
		size--;
		return previous;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.util.AbstractList#set(int, java.lang.Object)
	 */
	public E set(int index, E element)
	{
		E previous = get(index);
		array[start + index] = element;
		return previous;
	}

}
