package fr.vekia.vkgraph.client.charts.events;

import com.google.gwt.event.shared.EventHandler;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 3 sept. 2012. VklGraph version 1.2
 * @version 2.1
 * 
 *          {@inheritDoc}
 */
public interface AttachedChartHandler extends EventHandler {

	/**
	 * @param itemTabSelectionEvent
	 */
	void onAttachedChart(AttachedChartEvent itemTabSelectionEvent);

}
