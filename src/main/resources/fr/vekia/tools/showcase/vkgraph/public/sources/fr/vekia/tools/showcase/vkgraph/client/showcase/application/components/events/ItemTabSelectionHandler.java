package fr.vekia.tools.showcase.vkgraph.client.showcase.application.components.events;

import com.google.gwt.event.shared.EventHandler;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 27 avr. 2012. GWTQuery Vekia Showcase
 * @version 1.0
 */
public interface ItemTabSelectionHandler extends EventHandler {

    /**
     * @param itemTabSelectionEvent
     */
    void onSelection(ItemTabSelectionEvent itemTabSelectionEvent);

}
