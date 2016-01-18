package fr.vekia.vkgraph.client.charts.events;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 5 déc. 2011. GWTQuery Vekia Showcase
 * @version 1.0
 * 
 *          {@inheritDoc} Fired event when the data is modified by user.
 */
public abstract class EditedDataEvent extends ChartEvent {
    /**
     * @author Steeve Vandecappelle (SVA)
     * @since 16 août 2012. VklGraph version 1.2
     * @version 2.1
     * 
     *          {@inheritDoc}
     */

    @Override
    public String getEventType() {
        return "jqplotSeriesPointChange";
    }

}
