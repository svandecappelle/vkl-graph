package fr.vekia.tools.showcase.vkgraph.client.showcase.demonstration.items.simple;

import java.util.List;

import com.google.gwt.user.client.ui.IsWidget;

import fr.vekia.tools.showcase.vkgraph.client.showcase.application.layout.menu.AbstractShowcaseTreeMenuItem;
import fr.vekia.tools.showcase.vkgraph.client.showcase.demonstration.screens.simple.ThemingChartScreen;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 14 août 2012. VklGraph version 1.2
 * @version 2.1
 */
public class ThemingPlotExempleItem extends AbstractShowcaseTreeMenuItem {

    /**
     * Default constructor
     * 
     * @param text
     */
    public ThemingPlotExempleItem(String text) {
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
        return new ThemingChartScreen();
    }

}
