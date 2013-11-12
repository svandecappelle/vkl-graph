/*
 * File: $URL: svn+ssh://chimay/home/svn/VkGraph-showcase/VkGraph-showcase/src/main/java/fr.vekia.tools.showcase.vkgraph/client/showcase/application/injector/ShowcaseInjector.java $
 * $Id: ShowcaseInjector.java 22 2012-06-27 16:38:32Z svandecappelle $
 * Licence MIT
 * 
 * Last change:
 * $Date: 2012-06-27 18:38:32 +0200 (mer., 27 juin 2012) $
 * $Author: svandecappelle $
 */
package fr.vekia.tools.showcase.vkgraph.client.showcase.application.injector;

import net.customware.gwt.presenter.client.EventBus;

import com.google.gwt.core.client.GWT;
import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;

import fr.vekia.tools.showcase.vkgraph.client.showcase.application.ShowcaseConsoleCodePresenter;
import fr.vekia.tools.showcase.vkgraph.client.showcase.application.ShowcaseGlobalPanelPresenter;
import fr.vekia.tools.showcase.vkgraph.client.showcase.application.ShowcaseMenuPresenter;
import fr.vekia.tools.showcase.vkgraph.client.showcase.application.ShowcasePresenter;
import fr.vekia.tools.showcase.vkgraph.client.showcase.application.modules.ShowcaseModule;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 23 avr. 2012. GWTQuery Vekia Showcase
 * @version 1.0
 * 
 *          {@inheritDoc}
 */
@GinModules(ShowcaseModule.class)
public interface ShowcaseInjector extends Ginjector {

	final class Util {

		private static ShowcaseInjector injector = null;

		private Util() {
		}

		/**
		 * @return the injector
		 */
		public static ShowcaseInjector getInstance() {
			if (injector == null) {
				injector = GWT.create(ShowcaseInjector.class);
			}

			return injector;
		}
	}

	EventBus getEventBus();

	ShowcasePresenter getPresenter();

	ShowcaseMenuPresenter getMenuPresenter();

	ShowcaseGlobalPanelPresenter getGlobalPanelPresenter();

	ShowcaseConsoleCodePresenter getConsoleCodePresenter();

}
