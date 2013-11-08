/*
 * File: $URL$
 * $Id$
 * Copyright: Vekia
 *
 * Last change:
 * $Date$
 * $Author$
 */
package fr.vekia.tools.showcase.vkgraph.client.showcase.activities;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

import fr.vekia.tools.showcase.vkgraph.client.showcase.application.components.PresentationDemoPanel;

/**
 * @author svandecappelle
 * @since Dec 12, 2012. VklGraph version 1.2
 * @version 2.1
 * 
 *          {@inheritDoc}
 */
public class PresentationActivity extends AbstractActivity {

    private Place place;

    /**
     * Default constructor
     * 
     * @param place
     */
    public PresentationActivity(Place place) {
	this.place = place;
    }

    @Override
    public void start(AcceptsOneWidget panel, EventBus eventBus) {
	PresentationDemoPanel widget = new PresentationDemoPanel();
	panel.setWidget(widget);
    }

}
