/*
 * File: $URL: svn+ssh://chimay/home/svn/VkGraph-showcase/VkGraph-showcase/src/main/java/fr.vekia.tools.showcase.vkgraph/client/showcase/application/components/menu/groups/complex/items/AreaChartItem.java $
 * $Id: AreaChartItem.java 44 2012-09-05 09:32:12Z svandecappelle $
 * Licence MIT
 * 
 * Last change:
 * $Date: 2012-09-05 11:32:12 +0200 (mer., 05 sept. 2012) $
 * $Author: svandecappelle $
 */
package fr.vekia.tools.showcase.vkgraph.client.showcase.demonstration.items.complex;

import java.util.List;

import com.google.gwt.user.client.ui.IsWidget;

import fr.vekia.tools.showcase.vkgraph.client.showcase.application.components.menu.AbstractShowcaseTreeMenuItem;
import fr.vekia.tools.showcase.vkgraph.client.showcase.demonstration.screens.complex.MixedChartsScreen;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 11 mai 2012. GWTQuery Vekia Showcase
 * @version 1.0
 * 
 *          {@inheritDoc}
 */
public class AreaChartItem extends AbstractShowcaseTreeMenuItem {

	/**
	 * Default constructor
	 * 
	 * @param text
	 */
	public AreaChartItem(String text) {
		super(text);
	}

	@Override
	public boolean hasChildren() {
		return false;
	}

	@Override
	public List<AbstractShowcaseTreeMenuItem> getChildrenItems() {
		return null;
	}

	@Override
	public boolean hasScreen() {
		return true;
	}

	@Override
	public IsWidget getScreen() {
		return new MixedChartsScreen();
	}

}
