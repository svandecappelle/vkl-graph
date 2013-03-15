/*
 * File: $URL: svn+ssh://chimay/home/svn/VkGraph-showcase/VkGraph-showcase/src/main/java/fr/vekia/gquery/client/showcase/application/components/menu/groups/interactive/items/LineChartInteractiveItem.java $
 * $Id: LineChartInteractiveItem.java 36 2012-08-20 09:04:30Z svandecappelle $
 * Licence MIT
 *
 * Last change:
 * $Date: 2012-08-20 11:04:30 +0200 (lun., 20 août 2012) $
 * $Author: svandecappelle $
 */
package fr.vekia.gquery.client.showcase.application.demo.items.interactives;

import java.util.List;

import com.google.gwt.user.client.ui.IsWidget;

import fr.vekia.gquery.client.showcase.application.components.menu.AbstractShowcaseTreeMenuItem;
import fr.vekia.gquery.client.showcase.application.demo.screens.interactives.LineInteractiveWidgetScreen;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 17 août 2012. VklGraph version 1.2
 * @version 2.1
 * 
 *          {@inheritDoc}
 */
public class LineChartInteractiveItem extends AbstractShowcaseTreeMenuItem {

    /**
     * Default constructor
     * 
     * @param string
     */
    public LineChartInteractiveItem(String text) {
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
	return new LineInteractiveWidgetScreen();
    }

}
