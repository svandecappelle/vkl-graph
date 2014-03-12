/*
 * File: $URL: https://vklgraph.googlecode.com/svn/trunk/src/main/java/fr/vekia/VkGraph/client/charts/Exporter.java $
 * $Id: Exporter.java 33 2012-08-30 15:42:04Z steeve.vandecappelle@gmail.com $
 * Licence MIT
 *
 * Last change:
 * $Date: 2012-08-30 17:42:04 +0200 (jeu., 30 août 2012) $
 * $Author: steeve.vandecappelle@gmail.com $
 */
package fr.vekia.VkGraph.client.charts;

import com.google.gwt.user.client.Window;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 30 août 2012. VklGraph version 1.2
 * @version 2.1
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
	String img = export(this.chart.getId());
	String url = img.replaceAll("^data:image\\/[^;]", "data:application/octet-stream");
	Window.open(url, "_self", "");
    }

    private static native void download(JavaScriptObject chart) /*-{
	chart.jqplotSaveImage();	
    }-*/;

    /**
     * Export a graph with his identifier.
     * 
     * @param id
     *            graph HTML id
     */
    private static native String export(String id) /*-{
	return parent.jqplotToImg(id);
    }-*/;
}
