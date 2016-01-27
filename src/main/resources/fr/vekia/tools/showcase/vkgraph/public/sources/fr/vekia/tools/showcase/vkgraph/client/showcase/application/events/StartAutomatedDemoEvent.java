package fr.vekia.tools.showcase.vkgraph.client.showcase.application.events;

import com.google.gwt.event.shared.GwtEvent;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 23 août 2012. VklGraph version 1.2
 * @version 2.1
 */
public class StartAutomatedDemoEvent extends GwtEvent<StartAutomatedDemoHandler> {

    /**
     * Default constructor
     * 
     * @param selectedItem
     */
    public StartAutomatedDemoEvent() {
    }

    private static Type<StartAutomatedDemoHandler> type;

    public static Type<StartAutomatedDemoHandler> getType() {
        if (type == null) {
            type = new Type<StartAutomatedDemoHandler>();
        }
        return type;
    }

    @Override
    protected void dispatch(StartAutomatedDemoHandler handler) {
        handler.onStart(this);
    }

    @Override
    public GwtEvent.Type<StartAutomatedDemoHandler> getAssociatedType() {
        return getType();
    }
}
