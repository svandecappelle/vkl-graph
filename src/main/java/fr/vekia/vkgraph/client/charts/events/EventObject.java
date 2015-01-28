/*
 * File: $URL: https://vklgraph.googlecode.com/svn/trunk/src/main/java/fr/vekia/VkGraph/client/charts/events/EventObject.java $
 * $Id: EventObject.java 29 2012-08-22 16:29:33Z steeve.vandecappelle@gmail.com $
 * Licence MIT
 *
 * Last change:
 * $Date: 2012-08-22 18:29:33 +0200 (mer., 22 août 2012) $
 * $Author: steeve.vandecappelle@gmail.com $
 */
package fr.vekia.vkgraph.client.charts.events;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 15 juin 2012. GWTQuery Vekia Showcase
 * @version 1.0
 * 
 *          {@inheritDoc} generic event received object from javascript event.
 */
public class EventObject {
	private int seriesIndex;
	private int pointIndex;
	private Object value;

	private boolean nativeE;

	/**
	 * Default constructor.
	 * 
	 */
	public EventObject() {
	}

	/**
	 * Default constructor.
	 * 
	 */
	public EventObject(boolean isNative) {
		this.nativeE = isNative;
	}

	/**
	 * @param isNative
	 *            the isNative to set
	 */
	public void setNative(boolean isNative) {
		this.nativeE = isNative;
	}

	/**
	 * @return the isNative
	 */
	public boolean isNative() {
		return nativeE;
	}

	/**
	 * @return The modified Series data Index.
	 */
	public int getSeriesIndex() {
		return seriesIndex;
	}

	/**
	 * Set the modified Series data Index
	 * 
	 * @param seriesIndex
	 *            The modified Series data Index to set.
	 */
	public void setSeriesIndex(int seriesIndex) {
		this.seriesIndex = seriesIndex;
	}

	/**
	 * @return the point index whom fired the event.
	 */
	public int getPointIndex() {
		return pointIndex;
	}

	/**
	 * @param pointIndex
	 *            the point index whom fired the event.
	 */
	public void setPointIndex(int pointIndex) {
		this.pointIndex = pointIndex;
	}

	/**
	 * @return the object value data modified.
	 */
	public Object getValue() {
		return value;
	}

	/**
	 * @param value
	 *            the object value data modified to set.
	 */
	public void setValue(Object value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return EventObject.class.getName() + "\t - [" + getSeriesIndex() + "," + getPointIndex() + "]: " + getValue().toString();
	}

	/**
     * 
     */
	public NativeEventObject getNative() {
		if (isNative()) {
			return (NativeEventObject) this;
		} else {
			return null;
		}
	}

}
