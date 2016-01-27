package fr.vekia.tools.showcase.vkgraph.client.showcase.application.components.events;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.user.client.ui.IsWidget;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 3 mai 2012. GWTQuery Vekia Showcase
 * @version 1.0
 */
public class SelectionCodeEvent extends GwtEvent<SelectionCodeHandler> {

    private IsWidget selectedItem;

    /**
     * Default constructor
     * 
     * @param selectedItem
     */
    public SelectionCodeEvent(IsWidget selectedItem) {
        this.selectedItem = selectedItem;
    }

    /**
     * @return the selectedItem
     */
    public IsWidget getSelectedItem() {
        return selectedItem;
    }

    private static Type<SelectionCodeHandler> type;

    public static Type<SelectionCodeHandler> getType() {
        if (type == null) {
            type = new Type<SelectionCodeHandler>();
        }
        return type;
    }

    @Override
    protected void dispatch(SelectionCodeHandler handler) {
        handler.onSelection(this);
    }

    @Override
    public GwtEvent.Type<SelectionCodeHandler> getAssociatedType() {
        return getType();
    }
}
