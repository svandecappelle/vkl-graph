/*
 * File: $URL: https://vklgraph.googlecode.com/svn/trunk/src/main/java/fr/vekia/VkGraph/client/charts/derive/DashboardChart.java $
 * $Id: DashboardChart.java 51 2012-09-27 15:52:22Z steeve.vandecappelle@gmail.com $
 * Licence MIT
 *
 * Last change:
 * $Date: 2012-09-27 17:52:22 +0200 (jeu., 27 sept. 2012) $
 * $Author: steeve.vandecappelle@gmail.com $
 */
package fr.vekia.vkgraph.client.charts.derive;

import java.util.List;

import com.google.gwt.user.client.ui.Composite;

import fr.vekia.vkgraph.client.charts.AbstractChart;
import fr.vekia.vkgraph.client.charts.LineChart;
import fr.vekia.vkgraph.client.charts.NumberType;
import fr.vekia.vkgraph.client.charts.RenderersEnum;
import fr.vekia.vkgraph.client.datas.CanvasOverlayObject;
import fr.vekia.vkgraph.client.datas.SeriesData;
import fr.vekia.vkgraph.client.options.ChartOption;
import fr.vekia.vkgraph.client.options.SubOption;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 6 août 2012. VklGraph version 1.2
 * @version 2.1
 * 
 *          {@inheritDoc} Represent a Chart with Date x-axis and some
 *          animations.
 */
public class DashboardChart<T> extends Composite {

	private AbstractChart<T> chart;
	private static final int TOOLTIP_OFFSET_HIGHLIGHTER = 9;
	private static final int TOOLTIP_SIZE_ADJUST = 1;
	private static final int GRIDLINE_WIDTH = 2;

	/**
	 * Default constructor.
	 * 
	 */
	public DashboardChart() {
		chart = new LineChart<T>();

		chart.setSize("800px", "600px");

		// #################
		// ### Animation ###
		// #################
		chart.setBooleanOption(ChartOption.animate, true);
		chart.setBooleanOption(ChartOption.animateReplot, true);

		// ###################
		// ### Highlighter ###
		// ###################
		chart.setBooleanOption(ChartOption.highlighter, SubOption.show, true);
		chart.setNumberOption(ChartOption.highlighter, SubOption.sizeAdjust, TOOLTIP_SIZE_ADJUST);
		chart.setNumberOption(ChartOption.highlighter, SubOption.tooltipOffset, TOOLTIP_OFFSET_HIGHLIGHTER);

		// ############
		// ### Grid ###
		// ############

		chart.setTextOption(ChartOption.grid, SubOption.gridLineColor, "#666666");
		chart.setNumberOption(ChartOption.grid, SubOption.gridLineWidth, GRIDLINE_WIDTH);

		chart.setBooleanOption(ChartOption.grid, SubOption.drawBorder, false);
		chart.setBooleanOption(ChartOption.grid, SubOption.shadow, false);

		chart.setBooleanOption(ChartOption.seriesDefaults, SubOption.showMarker, false);
		chart.setBooleanOption(ChartOption.seriesDefaults, SubOption.rendererOptions, SubOption.smooth, true);

		// ##############
		// ### Legend ###
		// ##############
		chart.setBooleanOption(ChartOption.legend, SubOption.show, true);
		chart.setOption(ChartOption.legend, SubOption.renderer, RenderersEnum.EnhancedLegendRenderer.getValueRenderer());
		chart.setTextOption(ChartOption.legend, SubOption.placement, "outsideGrid");
		chart.setTextOption(ChartOption.legend, SubOption.location, "s");

		// #############
		// ### axes ####
		// #############
		// // xaxis
		chart.setNumberOption(ChartOption.axes, SubOption.yaxis, SubOption.pad, 0);
		//
		// // #####################
		// // ### defaults axes ###
		// // #####################
		chart.setNumberOption(ChartOption.axesDefaults, SubOption.rendererOptions, SubOption.baselineWidth, 1.5f, NumberType.FLOAT);
		chart.setTextOption(ChartOption.axesDefaults, SubOption.rendererOptions, SubOption.baselineColor, "#444444");
		chart.setBooleanOption(ChartOption.axesDefaults, SubOption.rendererOptions, SubOption.drawBaseline, false);

		initWidget(chart);
	}

	@Override
	public void setSize(String width, String height) {
		chart.setSize(width, height);
	}

	/**
	 * Set the graph title text on the top.
	 */
	public void setTitle(String title) {
		// ###################
		// ### graph title ###
		// ###################
		chart.setTextOption(ChartOption.title, title);
	}

	/**
	 * Set grid background color.
	 * 
	 * @param colorStringFormat
	 *            color in HEXADECIMAL, RGB or RGBA format.
	 */
	public void setBackgroundColor(String colorStringFormat) {// rgba(57,57,57,1.0)
		chart.setTextOption(ChartOption.grid, SubOption.background, colorStringFormat);
	}

	/**
	 * Set graph data.
	 * 
	 * @param datas
	 *            the graph data.
	 */
	public void setData(List<T> datas) {
		chart.setDatas(datas);
	}

	/**
	 * Set series option. For more details see {@link SeriesData}.
	 * 
	 * @param series
	 *            the specified series options.
	 */
	public void setSeries(SeriesData series) {
		chart.setSeriesOptions(series);
	}

	/**
	 * Set colors of series.
	 * 
	 * @param colors
	 *            the color in HEXADECIMAL, RGB or RGBA format.
	 */
	public void setColors(List<String> colors) {
		chart.setOption(ChartOption.seriesColors, colors);
	}

	/**
	 * Set the X axis formatter.
	 * 
	 * @param format
	 *            formatter :
	 */
	public void setXFormat(String format) {// %b %e
		chart.setOption(ChartOption.axes, SubOption.xaxis, SubOption.tickOptions, "{formatString: \"" + format + "\"}");
	}

	/**
	 * Set the Y axis formatter.
	 * 
	 * @param format
	 *            formatter :
	 */
	public void setYFormat(String format) {// $%'d
		chart.setOption(ChartOption.axes, SubOption.yaxis, SubOption.rendererOptions, "{formatString: \"" + format + "\"}");
	}

	/**
	 * Draw the X axis horizontal grid lines. <b>Default value is visible</b>.
	 * 
	 * @param isDrawing
	 *            <code>true</code> to activate the display.
	 */
	public void drawXGrid(boolean isDrawing) {
		chart.setBooleanOption(ChartOption.axes, SubOption.xaxis, SubOption.drawMajorGridlines, isDrawing);
	}

	/**
	 * Draw the Y axis vertical grid lines <b>Default value is visible</b>.
	 * 
	 * @param isDrawing
	 *            <code>true</code> to activate the display.
	 */
	public void drawYGrid(boolean isDrawing) {
		chart.setBooleanOption(ChartOption.axes, SubOption.yaxis, SubOption.drawMajorGridlines, isDrawing);
	}

	/**
	 * Enable the export in PNG format, using right click. <b>Default value is
	 * <code>false</code>.</b>
	 * 
	 * @param isEnable
	 *            <code>true</code> to enable export.
	 */
	public void setExportEnable(boolean isEnable) {
		chart.setExportEnable(isEnable);
	}

	/**
	 * Change the X axis renderer used to display the X values legend.
	 * 
	 * @param renderer
	 *            the renderer.
	 */
	public void setXaxisRenderer(RenderersEnum renderer) {
		chart.setXaxisRenderer(renderer);
	}

	/**
	 * Change the Y axis renderer used to display the Y values legend.
	 * 
	 * @param renderer
	 *            the renderer.
	 */
	public void setYaxisRenderer(RenderersEnum renderer) {
		chart.setYaxisRenderer(renderer);
	}

	/**
	 * @return the chart
	 */
	public AbstractChart<T> getChart() {
		return chart;
	}

	/**
	 * @param canvasoverlay
	 * @param canvasDrawOption
	 */
	public void setCanvasOverlay(CanvasOverlayObject canvasDrawOption) {
		chart.setCanvasOverlay(canvasDrawOption);
		chart.setBooleanOption(ChartOption.canvasOverlay, SubOption.show, true);
		chart.setBooleanOption(ChartOption.canvasOverlay, SubOption.bellowSeries, true);
	}
}
