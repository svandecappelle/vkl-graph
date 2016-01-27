package fr.vekia.tools.showcase.vkgraph.client.showcase.application.components.events;

import com.google.gwt.event.shared.EventHandler;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 3 mai 2012. GWTQuery Vekia Showcase
 * @version 1.0
 */
public interface SelectionCodeHandler extends EventHandler {
    /**
     * @param itemTabSelectionEvent
     */
    void onSelection(SelectionCodeEvent event);

}
