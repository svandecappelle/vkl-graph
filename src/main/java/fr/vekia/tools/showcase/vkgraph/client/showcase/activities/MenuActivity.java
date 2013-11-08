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
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

import fr.vekia.tools.showcase.vkgraph.client.showcase.activities.places.MenuPlace;
import fr.vekia.tools.showcase.vkgraph.client.showcase.application.ShowcaseMenuPresenter;
import fr.vekia.tools.showcase.vkgraph.client.showcase.application.components.menu.AbstractShowcaseTreeMenuItem;
import fr.vekia.tools.showcase.vkgraph.client.showcase.application.injector.ShowcaseInjector;

/**
 * @author svandecappelle
 * @since Dec 11, 2012. VklGraph version 1.2
 * @version 2.1
 * 
 *          {@inheritDoc}
 */
public class MenuActivity extends AbstractActivity implements ActivityPresenter {

    private MenuPlace place;

    /**
     * Default constructor
     * 
     * @param place
     * 
     */
    public MenuActivity(MenuPlace place) {
	this.place = place;
    }

    @Override
    public void start(AcceptsOneWidget panel, EventBus eventBus) {
	try {
	    // add a widget to panel
	    ShowcaseMenuPresenter menuPresenter = ShowcaseInjector.Util.getInstance().getMenuPresenter();

	    menuPresenter.getCategories().get(place.getMenu());
	    AbstractShowcaseTreeMenuItem item = menuPresenter.getPlotsScreens().get(place.getItem());
	    panel.setWidget(item.getScreen());
	} catch (Exception e) {
	    GWT.log(e.getMessage(), e);
	}
    }

    @Override
    public void gotTo(MenuPlace menuPlace) {
	ShowcaseInjector.Util.getInstance().getPresenter().gotTo(menuPlace);
    }

}
