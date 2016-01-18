package fr.vekia.vkgraph.client.charts.events;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 17 août 2012. VklGraph version 1.2
 * @version 2.1
 */
public interface JqPlotEvent {

    /**
     * @return
     */
    int getEventBindingParams();

    /**
     * @return
     */
    String getEventType();

    /**
     * @return
     */
    boolean isNative();

    /**
     * @return
     */
    boolean isJqplotTarget();

}
