package fr.vekia.vkgraph.client.charts.events;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 17 août 2012. VklGraph version 1.2
 * @version 2.1
 * 
 *          {@inheritDoc}
 */
public abstract class ChartSimpleEvent implements JqPlotEvent {

    /**
     * Return the event type to bind with.
     * 
     * @return the GWT event type.
     */
    @Override
    public abstract EventType getEventType();

    /**
     * Called method when the event is fired.
     * 
     * @param datasOnEvent
     */
    public abstract void onEvent(SimpleEventObject datasOnEvent);

    @Override
    public int getEventBindingParams() {
        return 1;
    }

    @Override
    public boolean isNative() {
        return false;
    }
}
