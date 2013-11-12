/*
 * File: $URL: svn+ssh://chimay/home/svn/VkGraph-showcase/VkGraph.showcase/src/main/java/fr.vekia.tools.showcase.vkgraph/client/showcase/application/displays/ShowcaseDisplay.java$
 * $Id: ShowcaseDisplay.java 40 2012-08-30 10:12:40Z svandecappelle $
 * Licence MIT
 * 
 * Last change:
 * $Date: 2012-08-30 12:12:40 +0200 (jeu., 30 août 2012) $
 * $Author: svandecappelle $
 */
package fr.vekia.tools.showcase.vkgraph.client.showcase.application.displays;

import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.SplitLayoutPanel;
import com.google.gwt.user.client.ui.Widget;

import fr.vekia.tools.showcase.vkgraph.client.showcase.application.ShowcasePresenter.Display;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 23 avr. 2012. GWTQuery Vekia Showcase
 * @version 1.0
 * 
 *          {@inheritDoc}
 */
public class ShowcaseDisplay implements Display {
	private SplitLayoutPanel layout;

	/**
	 * Default constructor
	 * 
	 */
	public ShowcaseDisplay() {
		layout = new SplitLayoutPanel();
	}

	@Override
	public void addWest(IsWidget widget, int size) {
		layout.addWest(widget, size);
	}

	@Override
	public void addNorth(IsWidget widget, int size) {
		layout.addNorth(widget, size);
	}

	@Override
	public void addCenter(IsWidget widget) {
		layout.add(widget);
	}

	@Override
	public Widget asWidget() {
		return layout;
	}
}
