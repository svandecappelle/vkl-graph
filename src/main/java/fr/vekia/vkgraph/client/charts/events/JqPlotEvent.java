package fr.vekia.vkgraph.client.charts.events;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 17 août 2012. VklGraph version 1.2
 * @version 2.1
 * 
 *          {@inheritDoc}
 */
public interface JqPlotEvent {

    /**
     * @return
     */
    int getEventBindingParams();

    /**
     * @return
     */
    EventType getEventType();

    /**
     * @return
     */
    boolean isNative();

}
