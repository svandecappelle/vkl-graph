/*
 * File: $URL: svn+ssh://chimay/home/svn/VkGraph-showcase/VkGraph-showcase/src/main/java/fr.vekia.tools.showcase.vkgraph/client/showcase/application/components/menu/groups/plots/screens/VerticalBarChartExempleScreen.java $
 * $Id: VerticalBarChartExempleScreen.java 32 2012-08-16 07:22:14Z svandecappelle $
 * Licence MIT
 * 
 * Last change:
 * $Date: 2012-08-16 09:22:14 +0200 (jeu., 16 août 2012) $
 * $Author: svandecappelle $
 */
package fr.vekia.tools.showcase.vkgraph.client.showcase.application.demo.screens.simple;

import java.util.ArrayList;
import java.util.List;

import fr.vekia.VkGraph.client.charts.AbstractChart;
import fr.vekia.VkGraph.client.datas.OptionSerie;
import fr.vekia.VkGraph.client.datas.SeriesData;
import fr.vekia.VkGraph.client.options.ChartOption;
import fr.vekia.VkGraph.client.options.SubOption;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 14 mai 2012. GWTQuery Vekia Showcase
 * @version 1.0
 * 
 *          {@inheritDoc}
 */
public class VerticalBarChartExempleScreen extends AbstractChart<List<Number>> {

	/**
	 * Default constructor
	 * 
	 */
	public VerticalBarChartExempleScreen() {

		// Can specify a custom tick Array.
		// Ticks should match up one for each y value (category) in the series.

		// The "seriesDefaults" option is an options object that will
		// be applied to all series in the chart.
		super.setOption(ChartOption.seriesDefaults, SubOption.renderer,
				"$.jqplot.BarRenderer");

		super.setBooleanOption(ChartOption.seriesDefaults,
				SubOption.rendererOptions, SubOption.fillToZero, true);

		// Custom labels for the series are specified with the "label"
		// option on the series option. Here a series option object
		// is specified for each series.
		SeriesData seriesData = new SeriesData();
		//
		OptionSerie firstLabel = new OptionSerie();
		firstLabel.setTextOption(SubOption.label, "Hotel");
		seriesData.set(0, firstLabel);
		//
		OptionSerie secondLabel = new OptionSerie();
		secondLabel.setTextOption(SubOption.label, "Event Regristration");
		seriesData.set(1, secondLabel);
		//
		OptionSerie lastLabel = new OptionSerie();
		lastLabel.setTextOption(SubOption.label, "Airfare");
		seriesData.set(2, lastLabel);

		setSeriesOptions(seriesData);

		// Show the legend and put it outside the grid, but inside the
		// plot container, shrinking the grid to accomodate the legend.
		// A value of "outside" would not shrink the grid and allow
		// the legend to overflow the container.
		super.setOption(ChartOption.legend, SubOption.show, "true");
		super.setTextOption(ChartOption.legend, SubOption.placement,
				"outsideGrid");

		// Use a category axis on the x axis and use our custom ticks.
		List<String> dates = new ArrayList<String>();
		dates.add("May");
		dates.add("June");
		dates.add("July");
		dates.add("August");

		super.setOption(ChartOption.axes, SubOption.xaxis, SubOption.renderer,
				"$.jqplot.CategoryAxisRenderer");
		// super.setOption(ChartOption.axes, SubOption.xaxis, SubOption.ticks,
		// dates);

		// Pad the y axis just a little so bars can get close to, but
		// not touch, the grid boundaries. 1.2 is the default padding.
		super.setOption(ChartOption.axes, SubOption.yaxis,
				"{pad: 1.05, tickOptions: {formatString: '$%d'}}");

		super.setBooleanOption(ChartOption.animate, true);
		super.setBooleanOption(ChartOption.animateReplot, true);

		super.setBooleanOption(ChartOption.cursor, SubOption.show, true);
		super.setTextOption(ChartOption.cursor, SubOption.tooltipLocation, "sw");
		super.setBooleanOption(ChartOption.series, SubOption.showMarker, false);

		super.setBooleanOption(ChartOption.highlighter, SubOption.showTooltip,
				true);
		super.setTextOption(ChartOption.highlighter, SubOption.tooltipLocation,
				"n");
		super.setTextOption(ChartOption.highlighter, SubOption.tooltipAxes, "y");
		super.setBooleanOption(ChartOption.highlighter, SubOption.show, true);

		List<Number> s1 = new ArrayList<Number>();
		List<Number> s2 = new ArrayList<Number>();
		List<Number> s3 = new ArrayList<Number>();

		s1.add(200);
		s1.add(600);
		s1.add(700);
		s1.add(1000);

		s2.add(460);
		s2.add(-210);
		s2.add(690);
		s2.add(820);

		s3.add(-260);
		s3.add(-440);
		s3.add(320);
		s3.add(200);

		List<List<Number>> allS = new ArrayList<List<Number>>();
		allS.add(s1);
		allS.add(s2);
		allS.add(s3);

		setData(allS);
		super.setExportEnable(true);
	}
}
