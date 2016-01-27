package fr.vekia.tools.showcase.vkgraph.client.showcase.application.components.menu.groups.plots;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.client.ui.IsWidget;

import fr.vekia.tools.showcase.vkgraph.client.showcase.application.components.menu.AbstractShowcaseTreeMenuItem;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 27 avr. 2012. GWTQuery Vekia Showcase
 * @version 1.0
 */
public class GeneralPlotTree extends AbstractShowcaseTreeMenuItem {

    /**
     * Default constructor
     * 
     */
    public GeneralPlotTree() {
        super("Plots");
    }

    @Override
    public boolean hasChildren() {
        return true;
    }

    @Override
    public List<AbstractShowcaseTreeMenuItem> getChildrenItems() {
        List<AbstractShowcaseTreeMenuItem> childrens = new ArrayList<AbstractShowcaseTreeMenuItem>();
        childrens.add(new AllPlotsTree());
        childrens.add(new AdvancedOptionsPlotTree());
        return childrens;
    }

    @Override
    public boolean hasScreen() {
        return false;
    }

    @Override
    public IsWidget getScreen() {
        return null;
    }

}
