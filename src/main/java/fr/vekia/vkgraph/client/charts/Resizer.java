/*
 * File: $URL: https://vklgraph.googlecode.com/svn/trunk/src/main/java/fr/vekia/VkGraph/client/charts/Resizer.java $
 * $Id: Resizer.java 32 2012-08-30 13:58:24Z steeve.vandecappelle@gmail.com $
 * Licence MIT
 *
 * Last change:
 * $Date: 2012-08-30 15:58:24 +0200 (jeu., 30 août 2012) $
 * $Author: steeve.vandecappelle@gmail.com $
 */
package fr.vekia.vkgraph.client.charts;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 30 août 2012. VklGraph version 1.2
 * @version 2.1
 * 
 *          {@inheritDoc}
 */
public class Resizer {
	private Chart<?> chart;

	/**
	 * Default constructor
	 * 
	 */
	public Resizer(Chart<?> chart) {
		this.chart = chart;
	}

	/**
	 * @param chartJavascriptObject
	 * @param string
	 * @param string2
	 */
	public void bind() {
		setResizable(chart.getChartJavascriptObject(), "#" + chart.getId() + "resizable");
	}

	/**
	 * JavaScript native method used to bind the resize / reploting chart using
	 * JQuery.
	 * 
	 * @param chart
	 * @param resizableElementId
	 */
	private native void setResizable(final JavaScriptObject chart, final String resizableElementId)/*-{
																									$wnd.jQuery(resizableElementId).bind('resize', function(event, ui) {
																									chart.replot({
																									resetAxes : true
																									});
																									});

																									$wnd.jQuery(resizableElementId).resizable({});
																									}-*/;

}
