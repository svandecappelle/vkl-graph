/*
 * File: $URL: svn+ssh://chimay/home/svn/VkGraph-showcase/VkGraph-showcase/src/main/java/fr/vekia/gquery/client/showcase/application/ShowcasePresenter.java $
 * $Id: ShowcasePresenter.java 52 2012-09-26 15:26:35Z svandecappelle $
 * Licence MIT
 * 
 * Last change:
 * $Date: 2012-09-26 17:26:35 +0200 (mer., 26 sept. 2012) $
 * $Author: svandecappelle $
 */
package fr.vekia.gquery.client.showcase.application;

import net.customware.gwt.presenter.client.EventBus;
import net.customware.gwt.presenter.client.widget.WidgetDisplay;
import net.customware.gwt.presenter.client.widget.WidgetPresenter;

import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.inject.Inject;
import com.google.inject.Singleton;

import fr.vekia.gquery.client.showcase.activities.ActivityPresenter;
import fr.vekia.gquery.client.showcase.activities.places.MenuPlace;
import fr.vekia.gquery.client.showcase.application.events.StartAutomatedDemoEvent;
import fr.vekia.gquery.client.showcase.application.events.StartAutomatedDemoHandler;
import fr.vekia.gquery.client.showcase.application.injector.ShowcaseInjector;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 23 avr. 2012. GWTQuery Vekia Showcase
 * @version 1.0
 * 
 *          {@inheritDoc}
 */
@Singleton
public class ShowcasePresenter extends WidgetPresenter<ShowcasePresenter.Display> implements ActivityPresenter {
    public interface Display extends WidgetDisplay {

	/**
	 * @param widget
	 * @param size
	 */
	void addWest(IsWidget widget, int size);

	/**
	 * @param widget
	 * @param size
	 */
	void addNorth(IsWidget widget, int size);

	/**
	 * @param widget
	 */
	void addCenter(IsWidget widget);

    }

    private PlaceController controller;

    /**
     * Default constructor
     * 
     * @param display
     * @param eventBus
     */
    @Inject
    public ShowcasePresenter(Display display, EventBus eventBus) {
	super(display, eventBus);

	ShowcaseInjector injector = ShowcaseInjector.Util.getInstance();
	ShowcaseMenuPresenter menuPresenter = injector.getMenuPresenter();
	display.addWest(menuPresenter.getDisplay().asWidget(), 290);

	ShowcaseConsoleCodePresenter consoleCodePresenter = injector.getConsoleCodePresenter();
	consoleCodePresenter.getDisplay().insert();

	ShowcaseGlobalPanelPresenter globalPanelPresenter = injector.getGlobalPanelPresenter();
	display.addCenter(globalPanelPresenter.getDisplay().asWidget());
	
	menuPresenter.bind();
	globalPanelPresenter.bind();
	consoleCodePresenter.bind();
    }

    @Override
    protected void onBind() {
	eventBus.addHandler(StartAutomatedDemoEvent.getType(), new StartAutomatedDemoHandler() {

	    @Override
	    public void onStart(StartAutomatedDemoEvent event) {
		DemoStarter.start();
	    }
	});
    }

    @Override
    protected void onUnbind() {
    }

    @Override
    protected void onRevealDisplay() {
	RootLayoutPanel.get().insert(display.asWidget(),0);
    }

    /**
     * @return the controller
     */
    public PlaceController getPlaceController() {
	return controller;
    }

    /**
     * @param controller
     *            the controller to set
     */
    public void setController(PlaceController controller) {
	this.controller = controller;
    }

    @Override
    public void gotTo(MenuPlace menuPlace) {
	controller.goTo(menuPlace);
    }

    /**
     * 
     */
    public void detachDisplay() {
	RootLayoutPanel.get().remove(display.asWidget());
    }
}
