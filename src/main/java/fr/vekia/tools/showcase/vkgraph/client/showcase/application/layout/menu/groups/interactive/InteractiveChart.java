package fr.vekia.tools.showcase.vkgraph.client.showcase.application.layout.menu.groups.interactive;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.client.ui.IsWidget;

import fr.vekia.tools.showcase.vkgraph.client.showcase.application.layout.menu.AbstractShowcaseTreeMenuItem;
import fr.vekia.tools.showcase.vkgraph.client.showcase.demonstration.items.interactives.AreaChartInteractiveItem;
import fr.vekia.tools.showcase.vkgraph.client.showcase.demonstration.items.interactives.BarChartInteractiveItem;
import fr.vekia.tools.showcase.vkgraph.client.showcase.demonstration.items.interactives.BubbleChartInteractiveItem;
import fr.vekia.tools.showcase.vkgraph.client.showcase.demonstration.items.interactives.DonutChartInteractiveItem;
import fr.vekia.tools.showcase.vkgraph.client.showcase.demonstration.items.interactives.LineChartInteractiveItem;
import fr.vekia.tools.showcase.vkgraph.client.showcase.demonstration.items.interactives.PieChartInteractiveItem;
import fr.vekia.tools.showcase.vkgraph.client.showcase.demonstration.items.interactives.PyramidChartInteractiveItem;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 17 août 2012. VklGraph version 1.2
 * @version 2.1
 */
public class InteractiveChart extends AbstractShowcaseTreeMenuItem {

    /**
     * Default constructor
     * 
     * @param text
     */
    public InteractiveChart() {
        super("Interactive Charts");
    }

    @Override
    public boolean hasChildren() {
        return true;
    }

    @Override
    public List<AbstractShowcaseTreeMenuItem> getChildrenItems() {
        List<AbstractShowcaseTreeMenuItem> childrens = new ArrayList<AbstractShowcaseTreeMenuItem>();
        childrens.add(new LineChartInteractiveItem("Line Charts and drag Options"));
        childrens.add(new BarChartInteractiveItem("Bar chart and drag Options"));
        childrens.add(new PieChartInteractiveItem("Pie  chart with events"));
        childrens.add(new DonutChartInteractiveItem("Donut chart with events"));
        childrens.add(new AreaChartInteractiveItem("Filled (Area) Charts with drag"));
        childrens.add(new BubbleChartInteractiveItem("Bubble chart with events and drag Options"));
        childrens.add(new PyramidChartInteractiveItem("Pyramid chart with events"));
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
