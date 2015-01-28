/*
 * File: $URL: https://vklgraph.googlecode.com/svn/trunk/src/main/java/fr/vekia/VkGraph/client/charts/events/JqPlotEvent.java $
 * $Id: JqPlotEvent.java 26 2012-08-20 10:05:52Z steeve.vandecappelle@gmail.com $
 * Licence MIT
 *
 * Last change:
 * $Date: 2012-08-20 12:05:52 +0200 (lun., 20 août 2012) $
 * $Author: steeve.vandecappelle@gmail.com $
 */
package fr.vekia.vkgraph.client.charts.events;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 17 août 2012. VklGraph version 1.2
 * @version 2.1
 * 
 *          {@inheritDoc}
 */
public interface JqPlotEvent {

	/**
	 * @return
	 */
	int getEventBindingParams();

	/**
	 * @return
	 */
	EventType getEventType();

	/**
	 * @return
	 */
	boolean isNative();

}
