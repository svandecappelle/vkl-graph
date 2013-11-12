/*
 * File: $URL: svn+ssh://chimay/home/svn/VkGraph-showcase/VkGraph-showcase/src/main/java/fr.vekia.tools.showcase.vkgraph/client/GQuery.java $
 * $Id: GQuery.java 22 2012-06-27 16:38:32Z svandecappelle $
 * Licence MIT
 * 
 * Last change:
 * $Date: 2012-06-27 18:38:32 +0200 (mer., 27 juin 2012) $
 * $Author: svandecappelle $
 */
package fr.vekia.tools.showcase.vkgraph.client;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;

import fr.vekia.tools.showcase.vkgraph.client.showcase.activities.MyActivityMapper;
import fr.vekia.tools.showcase.vkgraph.client.showcase.activities.hitory.MyPlaceHistoryMapper;
import fr.vekia.tools.showcase.vkgraph.client.showcase.activities.places.PresentationPlace;
import fr.vekia.tools.showcase.vkgraph.client.showcase.application.ShowcasePresenter;
import fr.vekia.tools.showcase.vkgraph.client.showcase.application.ThemeFactory;
import fr.vekia.tools.showcase.vkgraph.client.showcase.application.ThemeFactory.Theme;
import fr.vekia.tools.showcase.vkgraph.client.showcase.application.injector.ShowcaseInjector;
import fr.vekia.tools.showcase.vkgraph.client.theming.ThemeInjector;
import fr.vekia.tools.showcase.vkgraph.client.theming.view.ThemeViewImpl;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Showcase implements EntryPoint {

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		ShowcaseInjector injector = ShowcaseInjector.Util.getInstance();
		ShowcasePresenter presenter = injector.getPresenter();
		presenter.bind();
		presenter.revealDisplay();

		SimpleEventBus eventBusMap = new SimpleEventBus();
		PlaceController controller = new PlaceController(eventBusMap);
		presenter.setController(controller);

		// Start ActivityManager for the main widget with our ActivityMapper

		ActivityMapper activityMapper = new MyActivityMapper();
		ActivityManager activityManager = new ActivityManager(activityMapper,
				eventBusMap);
		activityManager.setDisplay(injector.getGlobalPanelPresenter()
				.getDisplay());

		// Start PlaceHistoryHandler with our PlaceHistoryMapper
		MyPlaceHistoryMapper historyMapper = GWT
				.create(MyPlaceHistoryMapper.class);
		PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(
				historyMapper);
		Place defaultPlace = new PresentationPlace("Presentation");
		historyHandler.register(presenter.getPlaceController(), eventBusMap,
				defaultPlace);

		//controller.goTo(defaultPlace);

		// Goes to place represented on URL or default place
		historyHandler.handleCurrentHistory();

		ThemeFactory.setTheme(Theme.PRO);
		ThemeInjector injectorTheme = ThemeInjector.Util.getInstance();
		injectorTheme.getPresenter().bind();
		injectorTheme.getPresenter().revealDisplay();
		
		// RootLayoutPanel.get().add(ohlc);

		// PilotGraph ohlc = new PilotGraph();
		//
		// RootLayoutPanel.get().add(ohlc);

	}
}
