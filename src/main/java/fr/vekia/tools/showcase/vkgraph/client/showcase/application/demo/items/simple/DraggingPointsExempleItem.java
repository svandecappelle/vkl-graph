/*
 * File: $URL: svn+ssh://chimay/home/svn/VkGraph-showcase/VkGraph-showcase/src/main/java/fr.vekia.tools.showcase.vkgraph/client/showcase/application/components/menu/groups/plots/items/DraggingPointsExempleItem.java $
 * $Id: DraggingPointsExempleItem.java 22 2012-06-27 16:38:32Z svandecappelle $
 * Licence MIT
 * 
 * Last change:
 * $Date: 2012-06-27 18:38:32 +0200 (mer., 27 juin 2012) $
 * $Author: svandecappelle $
 */
package fr.vekia.tools.showcase.vkgraph.client.showcase.application.demo.items.simple;

import java.util.List;

import com.google.gwt.user.client.ui.IsWidget;

import fr.vekia.tools.showcase.vkgraph.client.showcase.application.components.menu.AbstractShowcaseTreeMenuItem;
import fr.vekia.tools.showcase.vkgraph.client.showcase.application.demo.screens.simple.DraggingPointExempleScreen;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 28 mai 2012. GWTQuery Vekia Showcase
 * @version 1.0
 * 
 *          {@inheritDoc}
 */
public class DraggingPointsExempleItem extends AbstractShowcaseTreeMenuItem {

	/**
	 * Default constructor
	 * 
	 * @param text
	 */
	public DraggingPointsExempleItem(String text) {
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
		return new DraggingPointExempleScreen();
	}

}
