package fr.vekia.vkgraph.client.charts.events;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 5 déc. 2011. GWTQuery Vekia Showcase
 * @version 1.0
 * 
 *          {@inheritDoc} Data Highlight (mouse hover) event.
 */
public abstract class DataUnHighlightEvent extends ChartSimpleEvent {

    @Override
    public String getEventType() {
        return "jqplotDataUnhighlight";
    }

}
