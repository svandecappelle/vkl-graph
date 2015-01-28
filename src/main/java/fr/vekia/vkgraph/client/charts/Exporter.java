/*
 * File: $URL: https://vklgraph.googlecode.com/svn/trunk/src/main/java/fr/vekia/VkGraph/client/charts/Exporter.java $
 * $Id: Exporter.java 33 2012-08-30 15:42:04Z steeve.vandecappelle@gmail.com $
 * Licence MIT
 *
 * Last change:
 * $Date: 2012-08-30 17:42:04 +0200 (jeu., 30 août 2012) $
 * $Author: steeve.vandecappelle@gmail.com $
 */
package fr.vekia.vkgraph.client.charts;


/**
 * @author Steeve Vandecappelle (SVA)
 * @since 30 août 2012. VklGraph version 1.2
 * @version 1.3.0
 * 
 *          {@inheritDoc}
 */
public class Exporter {

	private Chart<?> chart;

	/**
	 * Default constructor
	 * 
	 * @param chart
	 */
	public Exporter(Chart<?> chart) {
		this.chart = chart;
	}

	/**
	 * Export the graph. Opening a DialogBox.
	 * 
	 */
	public void export() {
		this.download(this.chart.getId());
	}

	private final native void download(String id) /*-{
		$wnd.jQuery("#".concat(id)).jqplotSaveImage();	
	}-*/;
}
