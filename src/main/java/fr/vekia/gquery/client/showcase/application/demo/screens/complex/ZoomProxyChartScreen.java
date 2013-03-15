/*
 * File: $URL: svn+ssh://chimay/home/svn/VkGraph-showcase/VkGraph-showcase/src/main/java/fr/vekia/gquery/client/showcase/application/components/menu/groups/complex/screens/ZoomProxyChartScreen.java $
 * $Id: ZoomProxyChartScreen.java 53 2012-09-26 15:38:21Z svandecappelle $
 * Licence MIT
 * 
 * Last change:
 * $Date: 2012-09-26 17:38:21 +0200 (mer., 26 sept. 2012) $
 * $Author: svandecappelle $
 */
package fr.vekia.gquery.client.showcase.application.demo.screens.complex;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.VerticalPanel;

import fr.vekia.VkGraph.client.charts.AbstractChart;
import fr.vekia.VkGraph.client.datas.DualValue;
import fr.vekia.VkGraph.client.datas.OptionSerie;
import fr.vekia.VkGraph.client.datas.SeriesData;
import fr.vekia.VkGraph.client.options.ChartOption;
import fr.vekia.VkGraph.client.options.SubOption;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 11 mai 2012. GWTQuery Vekia Showcase
 * @version 1.0
 * 
 *          {@inheritDoc}
 */
public class ZoomProxyChartScreen extends SimplePanel {

    /**
     * Default constructor
     * 
     */
    public ZoomProxyChartScreen() {

	super();

	VerticalPanel content = new VerticalPanel();

	AbstractChart<List<DualValue>> chart1 = new AbstractChart<List<DualValue>>();
	chart1.setBooleanOption(ChartOption.animate, true);
	chart1.setBooleanOption(ChartOption.animateReplot, true);

	chart1.setBooleanOption(ChartOption.cursor, SubOption.show, true);
	chart1.setBooleanOption(ChartOption.cursor, SubOption.zoom, true);
	chart1.setBooleanOption(ChartOption.cursor, SubOption.looseZoom, true);
	chart1.setBooleanOption(ChartOption.cursor, SubOption.showTooltip, false);

	OptionSerie firstDataRendererOptions = new OptionSerie();
	firstDataRendererOptions.setBooleanOption(SubOption.pointLabels, SubOption.show, true);

	OptionSerie barDataRendererOptions = new OptionSerie();
	barDataRendererOptions.setOption(SubOption.renderer, "$.jqplot.BarRenderer");
	barDataRendererOptions.setTextOption(SubOption.yaxis, "y2axis");
	barDataRendererOptions.setNumberOption(SubOption.rendererOptions, SubOption.barWidth, 15);
	barDataRendererOptions.setNumberOption(SubOption.rendererOptions, SubOption.barPadding, -15);
	barDataRendererOptions.setNumberOption(SubOption.rendererOptions, SubOption.barMargin, 0);
	barDataRendererOptions.setNumberOption(SubOption.rendererOptions, SubOption.barWidth, 15);
	barDataRendererOptions.setBooleanOption(SubOption.rendererOptions, SubOption.highlightMouseOver, false);

	chart1.setOption(ChartOption.seriesDefaults, SubOption.rendererOptions, SubOption.animation, "{speed:2000}");
	chart1.setNumberOption(ChartOption.seriesDefaults, SubOption.rendererOptions, SubOption.barMargin, 15);
	chart1.setBooleanOption(ChartOption.seriesDefaults, SubOption.rendererOptions, SubOption.highlightMouseOver, true);

	SeriesData seriesData = new SeriesData();
	seriesData.set(0, firstDataRendererOptions);
	seriesData.set(1, barDataRendererOptions);

	List<List<DualValue>> datas = new ArrayList<List<DualValue>>();
	List<DualValue> lineDataOne = new ArrayList<DualValue>();
	lineDataOne.add(new DualValue(2002, 112000));
	lineDataOne.add(new DualValue(2003, 122000));
	lineDataOne.add(new DualValue(2004, 104000));
	lineDataOne.add(new DualValue(2005, 99000));
	lineDataOne.add(new DualValue(2006, 121000));
	lineDataOne.add(new DualValue(2007, 148000));
	lineDataOne.add(new DualValue(2008, 114000));
	lineDataOne.add(new DualValue(2009, 133000));
	lineDataOne.add(new DualValue(2010, 161000));
	lineDataOne.add(new DualValue(2011, 173000));

	datas.add(lineDataOne);

	List<DualValue> lineDataTwo = new ArrayList<DualValue>();
	lineDataTwo.add(new DualValue(2002, 10200));
	lineDataTwo.add(new DualValue(2003, 10800));
	lineDataTwo.add(new DualValue(2004, 11200));
	lineDataTwo.add(new DualValue(2005, 11800));
	lineDataTwo.add(new DualValue(2006, 12400));
	lineDataTwo.add(new DualValue(2007, 12800));
	lineDataTwo.add(new DualValue(2008, 13200));
	lineDataTwo.add(new DualValue(2009, 12600));
	lineDataTwo.add(new DualValue(2010, 13100));
	lineDataTwo.add(new DualValue(2011, 13100));
	datas.add(lineDataTwo);

	chart1.setDatas(datas);

	chart1.setSeriesOptions(seriesData);

	content.add(chart1);

	AbstractChart<List<DualValue>> chartProxy = new AbstractChart<List<DualValue>>();
	chartProxy.setDatas(datas);
	chartProxy.setOption(ChartOption.cursor, SubOption.constrainZoomTo, "x");
	chartProxy.setSeriesOptions(seriesData);
	chartProxy.setHeight("100px");

	content.add(chartProxy);
	chartProxy.setBooleanOption(ChartOption.cursor, SubOption.show, true);
	chartProxy.setBooleanOption(ChartOption.cursor, SubOption.zoom, true);
	chart1.setZoomProxy(chartProxy);

	setWidget(content);

    }

}
