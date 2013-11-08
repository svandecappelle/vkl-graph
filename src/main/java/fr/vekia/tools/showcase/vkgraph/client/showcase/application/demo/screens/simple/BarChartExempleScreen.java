/*
 * File: $URL: svn+ssh://chimay/home/svn/VkGraph-showcase/VkGraph-showcase/src/main/java/fr.vekia.tools.showcase.vkgraph/client/showcase/application/components/menu/groups/plots/screens/BarChartExempleScreen.java $
 * $Id: BarChartExempleScreen.java 52 2012-09-26 15:26:35Z svandecappelle $
 * Licence MIT
 * 
 * Last change:
 * $Date: 2012-09-26 17:26:35 +0200 (mer., 26 sept. 2012) $
 * $Author: svandecappelle $
 */
package fr.vekia.tools.showcase.vkgraph.client.showcase.application.demo.screens.simple;

import java.util.ArrayList;
import java.util.List;

import fr.vekia.VkGraph.client.charts.BarChart;
import fr.vekia.VkGraph.client.charts.RenderersEnum;
import fr.vekia.VkGraph.client.options.ChartOption;
import fr.vekia.VkGraph.client.options.SubOption;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 28 mai 2012. GWTQuery Vekia Showcase
 * @version 1.0
 * 
 *          {@inheritDoc}
 */
public class BarChartExempleScreen extends BarChart<Number> {

    /**
     * Default constructor
     * 
     */
    public BarChartExempleScreen() {
	super.setOption(ChartOption.seriesDefaults, SubOption.renderer, RenderersEnum.Bar.getValueRenderer());

	ArrayList<Number> data = new ArrayList<Number>();
	data.add(1);
	data.add(3);
	data.add(5);
	data.add(7);
	data.add(5);

	List<String> ticks = new ArrayList<String>();
	ticks.add("A");
	ticks.add("B");
	ticks.add("C");
	ticks.add("D");
	ticks.add("E");
	super.setOption(ChartOption.axes, SubOption.xaxis, SubOption.renderer, RenderersEnum.CategoryAxis.getValueRenderer());
	super.setOption(ChartOption.axes, SubOption.xaxis, SubOption.ticks, ticks);
	super.setNumberOption(ChartOption.axes, SubOption.yaxis, SubOption.min, 0);
	super.setNumberOption(ChartOption.axes, SubOption.yaxis, SubOption.max, 10);
	super.setNumberOption(ChartOption.axes, SubOption.yaxis, SubOption.tickInterval, 1);
	super.setBooleanOption(ChartOption.seriesDefaults, SubOption.pointLabels, SubOption.show, false);
	setListView(true);
	setDatas(data);
    }
}
