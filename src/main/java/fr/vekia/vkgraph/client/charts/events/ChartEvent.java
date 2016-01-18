package fr.vekia.vkgraph.client.charts.events;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 5 déc. 2011. GWTQuery Vekia Showcase
 * @version 1.0
 * 
 *          {@inheritDoc}
 */
public abstract class ChartEvent implements JqPlotEvent {

    private static final Integer DEFAULT_BINDING_PARAMS_VALUE = 5;
    private int eventBindingParams;

    private boolean nativeE;

    /**
     * Default constructor
     * 
     */
    public ChartEvent(Integer eventBindingParams) {
        this.eventBindingParams = eventBindingParams;
    }

    /**
     * Default constructor
     * 
     */
    public ChartEvent(Integer eventBindingParams, boolean isNative) {
        this.eventBindingParams = eventBindingParams;
        this.nativeE = isNative;
    }

    /**
     * Default constructor
     * 
     */
    public ChartEvent(boolean isNative) {
        this.nativeE = isNative;
    }

    @Override
    public boolean isNative() {
        return nativeE;
    }

    /**
     * Default constructor
     * 
     */
    public ChartEvent() {
        this(DEFAULT_BINDING_PARAMS_VALUE);
    }

    /**
     * Return the event type to bind with.
     * 
     * @return the GWT event type.
     */
    @Override
    public abstract String getEventType();

    /**
     * Called method when the event is fired.
     * 
     * @param datasOnEvent
     */
    public abstract void onEvent(EventObject datasOnEvent);

    /**
     * @return the eventBindingParams
     */
    @Override
    public int getEventBindingParams() {
        return eventBindingParams;
    }

    @Override
    public boolean isJqplotTarget() {
        return false;
    }
}
