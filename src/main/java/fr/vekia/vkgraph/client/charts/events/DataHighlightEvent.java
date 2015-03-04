package fr.vekia.vkgraph.client.charts.events;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 5 déc. 2011. GWTQuery Vekia Showcase
 * @version 1.0
 * 
 *          {@inheritDoc} Data Highlight (mouse hover) event.
 */
public abstract class DataHighlightEvent extends ChartEvent {

    /**
     * @author Steeve Vandecappelle (SVA)
     * @since 16 août 2012. VklGraph version 1.2
     * @version 2.1
     * 
     *          {@inheritDoc}
     */
    static final class DataHighlightEventType implements EventType {

        private static EventType singleton = new DataHighlightEventType();

        /**
         * Default constructor.
         * 
         */
        private DataHighlightEventType() {
        }

        @Override
        public String getName() {
            return "jqplotDataHighlight";
        }

        /**
         * Return the type of {@link DataHighlightEvent} GWT event.
         * 
         * @return the GWT event type
         */
        public static EventType getInstance() {
            return singleton;
        }

    }

    @Override
    public EventType getEventType() {
        return DataHighlightEventType.getInstance();
    }

}
