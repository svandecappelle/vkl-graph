/*
 * File: $URL: https://vklgraph.googlecode.com/svn/trunk/src/main/java/fr/vekia/VkGraph/client/charts/events/ChartEvent.java $
 * $Id: ChartEvent.java 26 2012-08-20 10:05:52Z steeve.vandecappelle@gmail.com $
 * Licence MIT
 *
 * Last change:
 * $Date: 2012-08-20 12:05:52 +0200 (lun., 20 août 2012) $
 * $Author: steeve.vandecappelle@gmail.com $
 */
package fr.vekia.VkGraph.client.charts.events;

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
	public abstract EventType getEventType();

	/**
	 * Called method when the event is fired.
	 * 
	 * @param datasOnEvent
	 */
	public abstract void onEvent(EventObject datasOnEvent);

	/**
	 * @return the eventBindingParams
	 */
	public int getEventBindingParams() {
		return eventBindingParams;
	}

}
