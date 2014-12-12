/*
 * File: $URL: https://vklgraph.googlecode.com/svn/trunk/src/main/java/fr/vekia/VkGraph/client/charts/events/AttachedChartEvent.java $
 * $Id: AttachedChartEvent.java 35 2012-09-03 16:11:14Z steeve.vandecappelle@gmail.com $
 * Licence MIT
 *
 * Last change:
 * $Date: 2012-09-03 18:11:14 +0200 (lun., 03 sept. 2012) $
 * $Author: steeve.vandecappelle@gmail.com $
 */
package fr.vekia.VkGraph.client.charts.events;

import com.google.gwt.event.shared.GwtEvent;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 3 sept. 2012. VklGraph version 1.2
 * @version 2.1
 * 
 *          {@inheritDoc}
 */
public class AttachedChartEvent extends GwtEvent<AttachedChartHandler> {

	private static Type<AttachedChartHandler> type;

	public static Type<AttachedChartHandler> getType() {
		if (type == null) {
			type = new Type<AttachedChartHandler>();
		}
		return type;
	}

	public AttachedChartEvent() {
	}

	@Override
	protected void dispatch(AttachedChartHandler handler) {
		handler.onAttachedChart(this);
	}

	@Override
	public GwtEvent.Type<AttachedChartHandler> getAssociatedType() {
		return getType();
	}
}
