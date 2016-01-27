package fr.vekia.tools.showcase.vkgraph.client.showcase.application.components.events;

import com.google.gwt.event.shared.GwtEvent;

import fr.vekia.tools.showcase.vkgraph.client.showcase.application.components.ItemActionSelection;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 27 avr. 2012. GWTQuery Vekia Showcase
 * @version 1.0
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
