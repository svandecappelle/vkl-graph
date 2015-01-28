/*
 * File: $URL: https://vklgraph.googlecode.com/svn/trunk/src/main/java/fr/vekia/VkGraph/client/charts/ThemeActivator.java $
 * $Id: ThemeActivator.java 25 2012-08-16 14:04:01Z steeve.vandecappelle@gmail.com $
 * Licence MIT
 *
 * Last change:
 * $Date: 2012-08-16 16:04:01 +0200 (jeu., 16 août 2012) $
 * $Author: steeve.vandecappelle@gmail.com $
 */
package fr.vekia.vkgraph.client.charts;

import fr.vekia.vkgraph.client.charts.menus.RightClickMenuWidget;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 14 août 2012. VklGraph version 1.2
 * @version 2.1
 * 
 *          {@inheritDoc}
 */
class ThemeActivator {

	private Chart<?> chart;
	private RightClickMenuWidget menu;

	/**
	 * Default constructor.
	 * 
	 */
	public ThemeActivator(Chart<?> chart, RightClickMenuWidget menu) {
		this.chart = chart;
		this.menu = menu;
	}

	/**
	 * Activate a theme to chart. Replot and hide theme selector menu.
	 * 
	 * @param theme
	 */
	public void activate(Theming theme) {
		chart.activateTheme(theme.getTheme());
		chart.replot();
		menu.hideMenu();
	}

}
