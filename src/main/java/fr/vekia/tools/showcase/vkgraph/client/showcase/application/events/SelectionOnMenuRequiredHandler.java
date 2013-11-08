/*
 * File: $URL: svn+ssh://chimay/home/svn/VkGraph-showcase/VkGraph-showcase/src/main/java/fr.vekia.tools.showcase.vkgraph/client/showcase/application/events/SelectionOnMenuRequiredHandler.java $
 * $Id: SelectionOnMenuRequiredHandler.java 38 2012-08-23 16:36:45Z svandecappelle $
 * Licence MIT
 *
 * Last change:
 * $Date: 2012-08-23 18:36:45 +0200 (jeu., 23 août 2012) $
 * $Author: svandecappelle $
 */
package fr.vekia.tools.showcase.vkgraph.client.showcase.application.events;

import com.google.gwt.event.shared.EventHandler;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 23 août 2012. VklGraph version 1.2
 * @version 2.1
 * 
 *          {@inheritDoc}
 */
public interface SelectionOnMenuRequiredHandler extends EventHandler {
    /**
     * @param itemTabSelectionEvent
     */
    void onSelection(SelectionOnMenuRequiredEvent event);

}
