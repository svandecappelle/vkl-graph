package fr.vekia.vkgraph.client.charts.events;

/**
 * @author svandecappelle
 * @since Jan 18, 2013. VklGraph version : 2.1
 * @version 2.1
 * 
 *          {@inheritDoc}
 */
public abstract class DragStopEvent extends ChartEvent {
    private static final Integer DEFAULT_BINDING_PARAMS_VALUE = 4;

    /**
     * Default constructor
     *
     */
    public DragStopEvent() {
        super(true);
    }

    @Override
    public String getEventType() {
        return "jqplotDragStop";
    }

    @Override
    public int getEventBindingParams() {
        return DEFAULT_BINDING_PARAMS_VALUE;
    }
}
