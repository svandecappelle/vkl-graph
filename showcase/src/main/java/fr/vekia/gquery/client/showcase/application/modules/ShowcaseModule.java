/*
 * File: $URL: svn+ssh://chimay/home/svn/VkGraph-showcase/VkGraph-showcase/src/main/java/fr/vekia/gquery/client/showcase/application/modules/ShowcaseModule.java $
 * $Id: ShowcaseModule.java 22 2012-06-27 16:38:32Z svandecappelle $
 * Licence MIT
 * 
 * Last change:
 * $Date: 2012-06-27 18:38:32 +0200 (mer., 27 juin 2012) $
 * $Author: svandecappelle $
 */
package fr.vekia.gquery.client.showcase.application.modules;

import net.customware.gwt.presenter.client.DefaultEventBus;
import net.customware.gwt.presenter.client.EventBus;

import com.google.gwt.inject.client.AbstractGinModule;

import fr.vekia.gquery.client.showcase.application.ShowcaseConsoleCodePresenter;
import fr.vekia.gquery.client.showcase.application.ShowcaseGlobalPanelPresenter;
import fr.vekia.gquery.client.showcase.application.ShowcaseMenuPresenter;
import fr.vekia.gquery.client.showcase.application.ShowcasePresenter;
import fr.vekia.gquery.client.showcase.application.components.GlobalPanel;
import fr.vekia.gquery.client.showcase.application.components.Menu;
import fr.vekia.gquery.client.showcase.application.components.code.ConsoleCode;
import fr.vekia.gquery.client.showcase.application.displays.ShowcaseDisplay;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 23 avr. 2012. GWTQuery Vekia Showcase
 * @version 1.0
 * 
 *          {@inheritDoc}
 */
public class ShowcaseModule extends AbstractGinModule {

    /*
     * (non-Javadoc)
     * 
     * @see com.google.gwt.inject.client.AbstractGinModule#configure()
     */
    @Override
    protected void configure() {
	bind(ShowcasePresenter.Display.class).to(ShowcaseDisplay.class);
	bind(ShowcaseMenuPresenter.Display.class).to(Menu.class);
	bind(ShowcaseGlobalPanelPresenter.Display.class).to(GlobalPanel.class);
	bind(ShowcaseConsoleCodePresenter.Display.class).to(ConsoleCode.class);
	bind(EventBus.class).to(DefaultEventBus.class);
    }

}
