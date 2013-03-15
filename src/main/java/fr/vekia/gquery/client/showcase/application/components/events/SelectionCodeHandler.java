/*
 * File: $URL: svn+ssh://chimay/home/svn/VkGraph-showcase/VkGraph-showcase/src/main/java/fr/vekia/gquery/client/showcase/application/components/events/SelectionCodeHandler.java $
 * $Id: SelectionCodeHandler.java 22 2012-06-27 16:38:32Z svandecappelle $
 * Licence MIT
 * 
 * Last change:
 * $Date: 2012-06-27 18:38:32 +0200 (mer., 27 juin 2012) $
 * $Author: svandecappelle $
 */
package fr.vekia.gquery.client.showcase.application.components.events;

import com.google.gwt.event.shared.EventHandler;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 3 mai 2012. GWTQuery Vekia Showcase
 * @version 1.0
 * 
 *          {@inheritDoc}
 */
public interface SelectionCodeHandler extends EventHandler {
    /**
     * @param itemTabSelectionEvent
     */
    void onSelection(SelectionCodeEvent event);

}
