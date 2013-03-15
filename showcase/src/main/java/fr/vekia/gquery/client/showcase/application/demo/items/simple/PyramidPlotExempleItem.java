/*
 * File: $URL: svn+ssh://chimay/home/svn/VkGraph-showcase/VkGraph-showcase/src/main/java/fr/vekia/gquery/client/showcase/application/components/menu/groups/plots/items/PyramidPlotExempleItem.java $
 * $Id: PyramidPlotExempleItem.java 37 2012-08-22 16:29:14Z svandecappelle $
 * Licence MIT
 *
 * Last change:
 * $Date: 2012-08-22 18:29:14 +0200 (mer., 22 août 2012) $
 * $Author: svandecappelle $
 */
package fr.vekia.gquery.client.showcase.application.demo.items.simple;

import java.util.List;

import com.google.gwt.user.client.ui.IsWidget;

import fr.vekia.gquery.client.showcase.application.components.menu.AbstractShowcaseTreeMenuItem;
import fr.vekia.gquery.client.showcase.application.demo.screens.simple.PyramidPlotScreen;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 21 août 2012. VklGraph version 1.2
 * @version 2.1
 * 
 *          {@inheritDoc}
 */
public class PyramidPlotExempleItem extends AbstractShowcaseTreeMenuItem {

    /**
     * Default constructor
     * 
     * @param text
     */
    public PyramidPlotExempleItem(String text) {
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
	return new PyramidPlotScreen();
    }

}
