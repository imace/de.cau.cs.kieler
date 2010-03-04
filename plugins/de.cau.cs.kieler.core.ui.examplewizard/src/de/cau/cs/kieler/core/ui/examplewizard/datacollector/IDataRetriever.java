/**
 * 
 */
package de.cau.cs.kieler.core.ui.examplewizard.datacollector;

import java.util.List;

import de.cau.cs.kieler.core.ui.examplewizard.util.Example;

/**
 * The {@code IDataRetriever} interface must be implemented by classes reading Examples. 
 * @author omi
 *
 */
public interface IDataRetriever {

	/**
	 * Returns a complete list of examples.
	 * @return
	 */
	public List<Example> getExamples();
	
	/**
	 * Returns a list of pluginIds needed for the examples.
	 * @return
	 */
	public List<String> getPluginIds();
	
	/**
	 * Returns all examples for this pluginId.
	 * @return
	 */
	public List<Example> getExamplesByPluginId(String pluginId);
	
	/**
	 * Returns all example ids.
	 * @return
	 */
	public List<String> getExampleIds();
	
	/**
	 * Returns the example for this id or {@code null} if not found. 
	 * @return
	 */
	// TODO think about versions
	public Example getExampleById(String id);
}
