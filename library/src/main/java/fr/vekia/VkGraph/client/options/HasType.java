/*
 * File: $URL$
 * $Id$
 * Copyright: Vekia
 *
 * Last change:
 * $Date$
 * $Author$
 */
package fr.vekia.VkGraph.client.options;

/**
 * @author svandecappelle
 * @since Nov 26, 2012. VklGraph version 1.2
 * @version 2.1
 * 
 *	{@inheritDoc}				
 */
public interface HasType {
    OptionType getType();

    /**
     * @return
     */
    boolean hasChildren();
}
