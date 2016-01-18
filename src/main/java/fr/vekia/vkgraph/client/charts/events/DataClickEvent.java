package fr.vekia.vkgraph.client.charts.events;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 5 déc. 2011. GWTQuery Vekia Showcase
 * @version 1.0
 * 
 *          {@inheritDoc} Data Highlight (mouse hover) event.
 */
public abstract class DataClickEvent extends ChartEvent {
    private static final Integer DATA_CLICK_EVENT_BINDING_PARAMS = 4;

    /**
     * Default constructor
     * 
     */
    public DataClickEvent() {
        super(DATA_CLICK_EVENT_BINDING_PARAMS);
    }

    @Override
    public String getEventType() {
        return "jqplotDataClick";
    }
    
}
