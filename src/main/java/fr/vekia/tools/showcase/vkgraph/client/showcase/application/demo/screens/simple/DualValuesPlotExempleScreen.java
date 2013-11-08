/*
 * File: $URL: svn+ssh://chimay/home/svn/VkGraph-showcase/VkGraph-showcase/src/main/java/fr.vekia.tools.showcase.vkgraph/client/showcase/application/components/menu/groups/plots/screens/DualValuesPlotExempleScreen.java $
 * $Id: DualValuesPlotExempleScreen.java 36 2012-08-20 09:04:30Z svandecappelle $
 * Licence MIT
 * 
 * Last change:
 * $Date: 2012-08-20 11:04:30 +0200 (lun., 20 août 2012) $
 * $Author: svandecappelle $
 */
package fr.vekia.tools.showcase.vkgraph.client.showcase.application.demo.screens.simple;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.VerticalPanel;

import fr.vekia.VkGraph.client.charts.AbstractChart;
import fr.vekia.VkGraph.client.charts.LineChart;
import fr.vekia.VkGraph.client.charts.RenderersEnum;
import fr.vekia.VkGraph.client.datas.DualValue;
import fr.vekia.VkGraph.client.options.ChartOption;
import fr.vekia.VkGraph.client.options.SubOption;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 4 mai 2012. GWTQuery Vekia Showcase
 * @version 1.0
 * 
 *          {@inheritDoc}
 */
public class DualValuesPlotExempleScreen extends SimplePanel {
    private AbstractChart<List<DualValue>> first;
    private DualValuesPlotWithOptionsExempleScreen other;

    /**
     * Default constructor
     * 
     */
    public DualValuesPlotExempleScreen() {
    	Window.alert("haha");
	first = new LineChart<List<DualValue>>();

	ArrayList<DualValue> valuesLineOne = new ArrayList<DualValue>();
	valuesLineOne.add(new DualValue(1, 2));
	valuesLineOne.add(new DualValue(3, 5.12));
	valuesLineOne.add(new DualValue(5, 13.1));
	valuesLineOne.add(new DualValue(7, 33.6));
	valuesLineOne.add(new DualValue(9, 85.9));
	List<List<DualValue>> values = new ArrayList<List<DualValue>>();
	values.add(valuesLineOne);

	 // Ticks x axis
    final List<String> ticks = new ArrayList<String>();
    ticks.add("XS");
    ticks.add("S");
    ticks.add("M");
    ticks.add("L");
    ticks.add("XL");
    

    first.setOption(ChartOption.axes, SubOption.xaxis, SubOption.renderer, RenderersEnum.CategoryAxis.getValueRenderer());

    first.setNumberOption(ChartOption.axes, SubOption.yaxis, SubOption.tickInterval, 1);
    first.setNumberOption(ChartOption.axes, SubOption.yaxis, SubOption.min, 0f);
    first.setNumberOption(ChartOption.axes, SubOption.yaxis, SubOption.max, 5);
    first.setOption(ChartOption.axes, SubOption.yaxis, SubOption.tickOptions, "{formatString:'%i piece'}");

    first.setOption(ChartOption.axes, SubOption.xaxis, SubOption.tickRenderer, RenderersEnum.CanvasAxisTick.getValueRenderer());
    first.setOption(ChartOption.axes, SubOption.xaxis, SubOption.tickOptions, "fontSize: '11pt',showMark: false,showGridline: false}");
    first.setOption(ChartOption.axes, SubOption.xaxis, SubOption.labelRenderer, RenderersEnum.CanvasAxisLabel.getValueRenderer());
    first.setOption(ChartOption.axes, SubOption.xaxis, SubOption.labelsOptions, "{fontSize: '11pt'}");
    first.setTextOption(ChartOption.axes, SubOption.xaxis, SubOption.label, "Tailles");
    first.setOption(ChartOption.axes, SubOption.xaxis, SubOption.ticks, ticks);
	
	
	first.setDatas(values);

	other = new DualValuesPlotWithOptionsExempleScreen();
	other.asWidget();

	VerticalPanel container = new VerticalPanel();
	container.add(first);
	container.add(other);

	setWidget(container);
    }

}
