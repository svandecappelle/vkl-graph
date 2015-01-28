package fr.vekia.vkgraph.client.options;

import java.io.Serializable;

/**
 * @author svandecappelle
 * 
 */
public interface HasType extends Serializable {
	/**
	 * Return the object jqplot option type.
	 * 
	 * @return the type of object
	 */
	OptionType getType();

	/**
	 * @return <code>true</code> if object has children
	 */
	boolean hasChildren();
}
