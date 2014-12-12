/*
 * File: $URL: https://vklgraph.googlecode.com/svn/trunk/src/main/java/fr/vekia/VkGraph/client/charts/ZoomProxy.java $
 * $Id: ZoomProxy.java 35 2012-09-03 16:11:14Z steeve.vandecappelle@gmail.com $
 * Licence MIT
 *
 * Last change:
 * $Date: 2012-09-03 18:11:14 +0200 (lun., 03 sept. 2012) $
 * $Author: steeve.vandecappelle@gmail.com $
 */
package fr.vekia.VkGraph.client.charts;

import com.google.gwt.core.client.JavaScriptObject;

import fr.vekia.VkGraph.client.charts.events.AttachedChartEvent;
import fr.vekia.VkGraph.client.charts.events.AttachedChartHandler;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 3 sept. 2012. VklGraph version 1.2
 * @version 2.1
 * 
 *          {@inheritDoc}
 */
public class ZoomProxy {

	public void setProxy(final Chart<?> chartTarget, final Chart<?> chartProxy) {
		if (chartProxy != null) {
			chartProxy.addAttachedChartHandler(new AttachedChartHandler() {

				@Override
				public void onAttachedChart(AttachedChartEvent itemTabSelectionEvent) {
					if (chartProxy.getChartJavascriptObject() != null && chartTarget.getChartJavascriptObject() != chartProxy.getChartJavascriptObject()) {
						setZoomProxy(chartTarget.getChartJavascriptObject(), chartProxy.getChartJavascriptObject());
					}
				}
			});
			chartTarget.addAttachedChartHandler(new AttachedChartHandler() {

				@Override
				public void onAttachedChart(AttachedChartEvent itemTabSelectionEvent) {
					if (chartProxy.getChartJavascriptObject() != null && chartTarget.getChartJavascriptObject() != chartProxy.getChartJavascriptObject()) {
						setZoomProxy(chartTarget.getChartJavascriptObject(), chartProxy.getChartJavascriptObject());
					}
				}
			});

		}
	}

	private native void setZoomProxy(JavaScriptObject controllerPlot, JavaScriptObject objectProxy) /*-{
																									$wnd.jQuery.jqplot.Cursor.zoomProxy(controllerPlot, objectProxy);
																									}-*/;
}
