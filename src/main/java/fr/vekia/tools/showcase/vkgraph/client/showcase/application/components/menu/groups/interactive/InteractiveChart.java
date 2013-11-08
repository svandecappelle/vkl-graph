/*
 * File: $URL: svn+ssh://chimay/home/svn/VkGraph-showcase/VkGraph-showcase/src/main/java/fr.vekia.tools.showcase.vkgraph/client/showcase/application/components/menu/groups/interactive/InteractiveChart.java $
 * $Id: InteractiveChart.java 44 2012-09-05 09:32:12Z svandecappelle $
 * Licence MIT
 *
 * Last change:
 * $Date: 2012-09-05 11:32:12 +0200 (mer., 05 sept. 2012) $
 * $Author: svandecappelle $
 */
package fr.vekia.tools.showcase.vkgraph.client.showcase.application.components.menu.groups.interactive;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.client.ui.IsWidget;

import fr.vekia.tools.showcase.vkgraph.client.showcase.application.components.menu.AbstractShowcaseTreeMenuItem;
import fr.vekia.tools.showcase.vkgraph.client.showcase.application.demo.items.interactives.AreaChartInteractiveItem;
import fr.vekia.tools.showcase.vkgraph.client.showcase.application.demo.items.interactives.BarChartInteractiveItem;
import fr.vekia.tools.showcase.vkgraph.client.showcase.application.demo.items.interactives.BubbleChartInteractiveItem;
import fr.vekia.tools.showcase.vkgraph.client.showcase.application.demo.items.interactives.DonutChartInteractiveItem;
import fr.vekia.tools.showcase.vkgraph.client.showcase.application.demo.items.interactives.LineChartInteractiveItem;
import fr.vekia.tools.showcase.vkgraph.client.showcase.application.demo.items.interactives.PieChartInteractiveItem;
import fr.vekia.tools.showcase.vkgraph.client.showcase.application.demo.items.interactives.PyramidChartInteractiveItem;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 17 août 2012. VklGraph version 1.2
 * @version 2.1
 * 
 *          {@inheritDoc}
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
