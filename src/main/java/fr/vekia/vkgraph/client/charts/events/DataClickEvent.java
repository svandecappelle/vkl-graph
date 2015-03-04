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

    /**
     * @author Steeve Vandecappelle (SVA)
     * @since 16 août 2012. VklGraph version 1.2
     * @version 2.1
     * 
     *          {@inheritDoc}
     */
    static final class DataClickEventType implements EventType {

        private static EventType singleton = new DataClickEventType();

        /**
         * Default constructor.
         * 
         */
        private DataClickEventType() {
        }

        @Override
        public String getName() {
            return "jqplotDataClick";
        }

        /**
         * Return the type of {@link DataClickEvent} GWT event.
         * 
         * @return the GWT event type
         */
        public static EventType getInstance() {
            return singleton;
        }

    }

    @Override
    public EventType getEventType() {
        return DataClickEventType.getInstance();
    }

}
