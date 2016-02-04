package fr.vekia.tools.showcase.vkgraph.client.showcase.application.layout.menu.groups.pie;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.client.ui.IsWidget;

import fr.vekia.tools.showcase.vkgraph.client.showcase.application.layout.menu.AbstractShowcaseTreeMenuItem;
import fr.vekia.tools.showcase.vkgraph.client.showcase.demonstration.items.pies.DonutExempleItem;
import fr.vekia.tools.showcase.vkgraph.client.showcase.demonstration.items.pies.GeneralPieExempleItem;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 4 mai 2012. GWTQuery Vekia Showcase
 * @version 1.0
 */
public class PieTree extends AbstractShowcaseTreeMenuItem {
    /**
     * Default constructor
     * 
     */
    public PieTree() {
        super("PieChart");
    }

    @Override
    public boolean hasChildren() {
        return true;
    }

    @Override
    public List<AbstractShowcaseTreeMenuItem> getChildrenItems() {
        List<AbstractShowcaseTreeMenuItem> childrens = new ArrayList<AbstractShowcaseTreeMenuItem>();
        childrens.add(new GeneralPieExempleItem("Simple pie"));
        childrens.add(new DonutExempleItem("Donut"));
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
