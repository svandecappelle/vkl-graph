/*
 * File: $URL: https://vklgraph.googlecode.com/svn/trunk/src/main/java/fr/vekia/VkGraph/client/charts/events/DataClickEvent.java $
 * $Id: DataClickEvent.java 34 2012-08-31 13:03:35Z steeve.vandecappelle@gmail.com $
 * Licence MIT
 *
 * Last change:
 * $Date: 2012-08-31 15:03:35 +0200 (ven., 31 août 2012) $
 * $Author: steeve.vandecappelle@gmail.com $
 */
package fr.vekia.VkGraph.client.charts.events;

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
