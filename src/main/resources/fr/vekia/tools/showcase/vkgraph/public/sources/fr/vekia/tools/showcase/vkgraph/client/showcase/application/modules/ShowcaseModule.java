package fr.vekia.tools.showcase.vkgraph.client.showcase.application.modules;

import com.google.gwt.inject.client.AbstractGinModule;

import fr.vekia.tools.showcase.vkgraph.client.showcase.application.layout.code.display.ConsoleCode;
import fr.vekia.tools.showcase.vkgraph.client.showcase.application.layout.code.interfaces.ShowcaseConsoleCodeDisplay;
import fr.vekia.tools.showcase.vkgraph.client.showcase.application.layout.global.display.GlobalPanel;
import fr.vekia.tools.showcase.vkgraph.client.showcase.application.layout.global.interfaces.GlobalDisplay;
import fr.vekia.tools.showcase.vkgraph.client.showcase.application.layout.main.display.ShowcaseDisplay;
import fr.vekia.tools.showcase.vkgraph.client.showcase.application.layout.main.interfaces.ShowcaseMainLayoutDisplay;
import fr.vekia.tools.showcase.vkgraph.client.showcase.application.layout.menu.display.Menu;
import fr.vekia.tools.showcase.vkgraph.client.showcase.application.layout.menu.interfaces.ShowcaseMenuDisplay;
import net.customware.gwt.presenter.client.DefaultEventBus;
import net.customware.gwt.presenter.client.EventBus;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 23 avr. 2012. GWTQuery Vekia Showcase
 * @version 1.0
 */
public class ShowcaseModule extends AbstractGinModule {

    @Override
    protected void configure() {
        bind(ShowcaseMainLayoutDisplay.class).to(ShowcaseDisplay.class);
        bind(ShowcaseMenuDisplay.class).to(Menu.class);
        bind(GlobalDisplay.class).to(GlobalPanel.class);
        bind(ShowcaseConsoleCodeDisplay.class).to(ConsoleCode.class);
        bind(EventBus.class).to(DefaultEventBus.class);
    }

}
