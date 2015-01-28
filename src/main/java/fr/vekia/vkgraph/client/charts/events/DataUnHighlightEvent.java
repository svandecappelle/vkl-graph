/*
 * File: $URL: https://vklgraph.googlecode.com/svn/trunk/src/main/java/fr/vekia/VkGraph/client/charts/events/DataUnHighlightEvent.java $
 * $Id: DataUnHighlightEvent.java 26 2012-08-20 10:05:52Z steeve.vandecappelle@gmail.com $
 * Licence MIT
 *
 * Last change:
 * $Date: 2012-08-20 12:05:52 +0200 (lun., 20 août 2012) $
 * $Author: steeve.vandecappelle@gmail.com $
 */
package fr.vekia.vkgraph.client.charts.events;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 5 déc. 2011. GWTQuery Vekia Showcase
 * @version 1.0
 * 
 *          {@inheritDoc} Data Highlight (mouse hover) event.
 */
public abstract class DataUnHighlightEvent extends ChartSimpleEvent {

	/**
	 * @author Steeve Vandecappelle (SVA)
	 * @since 16 août 2012. VklGraph version 1.2
	 * @version 2.1
	 * 
	 *          {@inheritDoc}
	 */
	static final class DataUnHighlightEventType implements EventType {

		private static EventType singleton = new DataUnHighlightEventType();

		/**
		 * Default constructor.
		 * 
		 */
		private DataUnHighlightEventType() {
		}

		@Override
		public String getName() {
			return "jqplotDataUnhighlight";
		}

		/**
		 * Return the type of {@link DataUnHighlightEvent} GWT event.
		 * 
		 * @return the GWT event type
		 */
		public static EventType getInstance() {
			return singleton;
		}

	}

	@Override
	public EventType getEventType() {
		return DataUnHighlightEventType.getInstance();
	}

}
