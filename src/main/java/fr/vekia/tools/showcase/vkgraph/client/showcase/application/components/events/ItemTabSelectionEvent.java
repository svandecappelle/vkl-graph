/*
 * File: $URL: svn+ssh://chimay/home/svn/VkGraph-showcase/VkGraph-showcase/src/main/java/fr.vekia.tools.showcase.vkgraph/client/showcase/application/components/events/ItemTabSelectionEvent.java $
 * $Id: ItemTabSelectionEvent.java 22 2012-06-27 16:38:32Z svandecappelle $
 * Licence MIT
 * 
 * Last change:
 * $Date: 2012-06-27 18:38:32 +0200 (mer., 27 juin 2012) $
 * $Author: svandecappelle $
 */
package fr.vekia.tools.showcase.vkgraph.client.showcase.application.components.events;

import com.google.gwt.event.shared.GwtEvent;

import fr.vekia.tools.showcase.vkgraph.client.showcase.application.components.ItemActionSelection;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 27 avr. 2012. GWTQuery Vekia Showcase
 * @version 1.0
 * 
 *          {@inheritDoc}
 */
public class ItemTabSelectionEvent extends GwtEvent<ItemTabSelectionHandler> {

    private static Type<ItemTabSelectionHandler> type;

    public static Type<ItemTabSelectionHandler> getType() {
	if (type == null) {
	    type = new Type<ItemTabSelectionHandler>();
	}
	return type;
    }

    private ItemActionSelection action;

    public ItemTabSelectionEvent(ItemActionSelection action) {
	this.action = action;
    }

    /**
     * @return the action
     */
    public ItemActionSelection getAction() {
	return action;
    }

    @Override
    protected void dispatch(ItemTabSelectionHandler handler) {
	handler.onSelection(this);
    }

    @Override
    public GwtEvent.Type<ItemTabSelectionHandler> getAssociatedType() {
	return getType();
    }
}
