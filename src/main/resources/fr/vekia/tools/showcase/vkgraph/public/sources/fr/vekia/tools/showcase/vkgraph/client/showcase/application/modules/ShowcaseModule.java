package fr.vekia.tools.showcase.vkgraph.client.showcase.application.modules;

import net.customware.gwt.presenter.client.DefaultEventBus;
import net.customware.gwt.presenter.client.EventBus;

import com.google.gwt.inject.client.AbstractGinModule;

import fr.vekia.tools.showcase.vkgraph.client.showcase.application.ShowcaseConsoleCodePresenter;
import fr.vekia.tools.showcase.vkgraph.client.showcase.application.ShowcaseGlobalPanelPresenter;
import fr.vekia.tools.showcase.vkgraph.client.showcase.application.ShowcaseMenuPresenter;
import fr.vekia.tools.showcase.vkgraph.client.showcase.application.ShowcasePresenter;
import fr.vekia.tools.showcase.vkgraph.client.showcase.application.components.GlobalPanel;
import fr.vekia.tools.showcase.vkgraph.client.showcase.application.components.Menu;
import fr.vekia.tools.showcase.vkgraph.client.showcase.application.components.code.ConsoleCode;
import fr.vekia.tools.showcase.vkgraph.client.showcase.application.displays.ShowcaseDisplay;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 23 avr. 2012. GWTQuery Vekia Showcase
 * @version 1.0
 */
public class ShowcaseModule extends AbstractGinModule {

    @Override
    protected void configure() {
        bind(ShowcasePresenter.Display.class).to(ShowcaseDisplay.class);
        bind(ShowcaseMenuPresenter.Display.class).to(Menu.class);
        bind(ShowcaseGlobalPanelPresenter.Display.class).to(GlobalPanel.class);
        bind(ShowcaseConsoleCodePresenter.Display.class).to(ConsoleCode.class);
        bind(EventBus.class).to(DefaultEventBus.class);
    }

}
