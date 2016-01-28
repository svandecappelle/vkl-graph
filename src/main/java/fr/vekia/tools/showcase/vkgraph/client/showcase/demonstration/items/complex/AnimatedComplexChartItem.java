package fr.vekia.tools.showcase.vkgraph.client.showcase.demonstration.items.complex;

import java.util.List;

import com.google.gwt.user.client.ui.IsWidget;

import fr.vekia.tools.showcase.vkgraph.client.showcase.application.layout.menu.AbstractShowcaseTreeMenuItem;
import fr.vekia.tools.showcase.vkgraph.client.showcase.demonstration.screens.complex.ZoomProxyChartScreen;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 11 mai 2012. GWTQuery Vekia Showcase
 * @version 1.0
 */
public class AnimatedComplexChartItem extends AbstractShowcaseTreeMenuItem {

    /**
     * Default constructor
     * 
     * @param string
     */
    public AnimatedComplexChartItem(String string) {
        super(string);
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
        return new ZoomProxyChartScreen();
    }

}
