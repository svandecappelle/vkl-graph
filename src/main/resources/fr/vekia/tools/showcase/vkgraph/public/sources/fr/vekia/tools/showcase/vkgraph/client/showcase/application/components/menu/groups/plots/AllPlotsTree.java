package fr.vekia.tools.showcase.vkgraph.client.showcase.application.components.menu.groups.plots;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.client.ui.IsWidget;

import fr.vekia.tools.showcase.vkgraph.client.showcase.application.components.menu.AbstractShowcaseTreeMenuItem;
import fr.vekia.tools.showcase.vkgraph.client.showcase.demonstration.items.simple.BarChartExempleItem;
import fr.vekia.tools.showcase.vkgraph.client.showcase.demonstration.items.simple.BezierCurveExempleItem;
import fr.vekia.tools.showcase.vkgraph.client.showcase.demonstration.items.simple.BlockPlotExempleItem;
import fr.vekia.tools.showcase.vkgraph.client.showcase.demonstration.items.simple.BubblePlotExempleItem;
import fr.vekia.tools.showcase.vkgraph.client.showcase.demonstration.items.simple.DualValuesPlotExempleItem;
import fr.vekia.tools.showcase.vkgraph.client.showcase.demonstration.items.simple.GaugeExempleItem;
import fr.vekia.tools.showcase.vkgraph.client.showcase.demonstration.items.simple.LineChartExempleItem;
import fr.vekia.tools.showcase.vkgraph.client.showcase.demonstration.items.simple.PyramidPlotExempleItem;
import fr.vekia.tools.showcase.vkgraph.client.showcase.demonstration.items.simple.VerticalBarChartExempleItem;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 27 avr. 2012. GWTQuery Vekia Showcase
 * @version 1.0
 */
public class AllPlotsTree extends AbstractShowcaseTreeMenuItem {

    /**
     * Default constructor
     * 
     */
    public AllPlotsTree() {
        super("Available plots");
    }

    @Override
    public boolean hasChildren() {
        return true;
    }

    @Override
    public List<AbstractShowcaseTreeMenuItem> getChildrenItems() {
        List<AbstractShowcaseTreeMenuItem> childrens = new ArrayList<AbstractShowcaseTreeMenuItem>();
        childrens.add(new LineChartExempleItem("LineChart plots"));
        childrens.add(new DualValuesPlotExempleItem("Dual values plot"));
        childrens.add(new VerticalBarChartExempleItem("Vertical and Horizontal Bar Charts"));
        childrens.add(new BarChartExempleItem("Bar Charts"));
        childrens.add(new BezierCurveExempleItem("Bezier Curve Plots"));
        childrens.add(new BlockPlotExempleItem("Block Plots"));
        childrens.add(new BubblePlotExempleItem("Bubble Plots"));
        childrens.add(new PyramidPlotExempleItem("Pyramid plot"));
        childrens.add(new GaugeExempleItem("Gauge plot"));
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
