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

import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.Frame;
import com.google.gwt.user.client.ui.PopupPanel.PositionCallback;
import com.google.gwt.user.client.ui.UIObject;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 30 août 2012. VklGraph version 1.2
 * @version 2.1
 * 
 *          {@inheritDoc}
 */
public class Exporter {

    private Chart<?> chart;

    private DialogBox exportContainer;

    private UIObject relativeTo;

    // positionate the popup at 20 pixel from the chart position
    private static final int ABS_POSITION_POPUP_ALEA=20;

    /**
     * Default constructor
     * 
     * @param chart
     */
    public Exporter(Chart<?> chart) {
	this.chart = chart;
	this.exportContainer = new DialogBox();
	this.exportContainer.getElement().setId(chart.getId() + "-export");
    }

    public void setExportPopupPositionRelative(UIObject relativeTo) {
	this.relativeTo = relativeTo;
    }

    /**
     * Export the graph. Opening a DialogBox.
     * 
     */
    public void export() {
	Frame frame = new Frame(export(this.chart.getId()));
	frame.setStylePrimaryName("vkl-ExportPopup");
	exportContainer.setWidget(frame);
	exportContainer.setAnimationEnabled(true);
	exportContainer.setAutoHideEnabled(true);
	exportContainer.setAutoHideOnHistoryEventsEnabled(true);
	exportContainer.setPopupPositionAndShow(new PositionCallback() {

	    @Override
	    public void setPosition(int offsetWidth, int offsetHeight) {
		if (relativeTo != null) {
		    exportContainer.setPopupPosition(relativeTo.getAbsoluteLeft() + ABS_POSITION_POPUP_ALEA, relativeTo.getAbsoluteTop() + ABS_POSITION_POPUP_ALEA);
		} else {
		    exportContainer.setPopupPosition(chart.getAbsoluteLeft() + ABS_POSITION_POPUP_ALEA, chart.getAbsoluteTop() + ABS_POSITION_POPUP_ALEA);
		}
	    }
	});
	if (relativeTo != null) {
	    frame.setSize(relativeTo.getOffsetWidth() + "px", relativeTo.getOffsetHeight() + "px");
	} else {
	    frame.setSize(chart.getOffsetWidth() + "px", chart.getOffsetHeight() + "px");
	}
    }

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
