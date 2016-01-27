package fr.vekia.tools.showcase.vkgraph.client.showcase.application.components.events;

import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 27 avr. 2012. GWTQuery Vekia Showcase
 * @version 1.0
 */
public interface HasItemTabSelectionHandlers extends HasHandlers {

    /**
     * Adds a {@link ItemTabSelectionEvent} handler.
     * 
     * @param handler
     *            ItemTabSelection handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    HandlerRegistration addSelectionHandler(ItemTabSelectionHandler handler);
}
