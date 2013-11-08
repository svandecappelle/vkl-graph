/*
 * File: $URL: svn+ssh://chimay/home/svn/VkGraph-showcase/VkGraph-showcase/src/main/java/fr.vekia.tools.showcase.vkgraph/client/showcase/application/events/SelectionOnMenuRequiredEvent.java $
 * $Id: SelectionOnMenuRequiredEvent.java 38 2012-08-23 16:36:45Z svandecappelle $
 * Licence MIT
 *
 * Last change:
 * $Date: 2012-08-23 18:36:45 +0200 (jeu., 23 août 2012) $
 * $Author: svandecappelle $
 */
package fr.vekia.tools.showcase.vkgraph.client.showcase.application.events;

import com.google.gwt.event.shared.GwtEvent;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 23 août 2012. VklGraph version 1.2
 * @version 2.1
 * 
 *          {@inheritDoc}
 */
public class SelectionOnMenuRequiredEvent extends GwtEvent<SelectionOnMenuRequiredHandler> {

    private String menuToShow;
    private String plotToShow;
    private int duration;

    /**
     * Default constructor
     * 
     * @param selectedItem
     */
    public SelectionOnMenuRequiredEvent(String menuToShow, String plotToShow) {
	this.menuToShow = menuToShow;
	this.plotToShow = plotToShow;
    }

    /**
     * Default constructor
     * 
     * @param selectedItem
     */
    public SelectionOnMenuRequiredEvent(String menuToShow) {
	this.menuToShow = menuToShow;
	this.plotToShow = null;
    }

    private static Type<SelectionOnMenuRequiredHandler> type;

    public static Type<SelectionOnMenuRequiredHandler> getType() {
	if (type == null) {
	    type = new Type<SelectionOnMenuRequiredHandler>();
	}
	return type;
    }

    @Override
    protected void dispatch(SelectionOnMenuRequiredHandler handler) {
	handler.onSelection(this);
    }

    @Override
    public GwtEvent.Type<SelectionOnMenuRequiredHandler> getAssociatedType() {
	return getType();
    }

    /**
     * @return the menuToShow
     */
    public String getMenuToShow() {
	return menuToShow;
    }

    /**
     * @return the plotToShow
     */
    public String getPlotToShow() {
	return plotToShow;
    }

    /**
     * @return the duration
     */
    public int getDuration() {
	return duration;
    }
}
