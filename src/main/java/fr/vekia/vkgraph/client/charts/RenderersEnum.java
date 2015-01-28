/*
 * File: $URL: https://vklgraph.googlecode.com/svn/trunk/src/main/java/fr/vekia/VkGraph/client/charts/RenderersEnum.java $
 * $Id: RenderersEnum.java 29 2012-08-22 16:29:33Z steeve.vandecappelle@gmail.com $
 * Licence MIT
 * 
 * Last change:
 * $Date: 2012-08-22 18:29:33 +0200 (mer., 22 août 2012) $
 * $Author: steeve.vandecappelle@gmail.com $
 */
package fr.vekia.vkgraph.client.charts;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 31 mai 2012. GWTQuery Vekia Showcase
 * @version 1.0
 * 
 *          {@inheritDoc} The list of the JqPlot available Renderer.
 */
@SuppressWarnings("squid:S00115")
public enum RenderersEnum {

	Stairs("$.jqplot.StairsRenderer"),
	Pie("$.jqplot.PieRenderer"),
	Donut("$.jqplot.DonutRenderer"),
	Bar("$.jqplot.BarRenderer"),
	Line("$.jqplot.LineRenderer"),
	Bubble("$.jqplot.BubbleRenderer"),
	BezierCurve("$.jqplot.BezierCurveRenderer"),
	Block("$.jqplot.BlockRenderer"),
	Funnel("$.jqplot.FunnelRenderer"),
	MeterGauge("$.jqplot.MeterGaugeRenderer"),
	Mekko("$.jqplot.MekkoAxisRenderer"),
	OHLC("$.jqplot.OHLCRenderer"),
	Pyramid("$.jqplot.PyramidRenderer"),

	CanvasAxisLabel("$.jqplot.CanvasAxisLabelRenderer"),
	CanvasAxisTick("$.jqplot.CanvasAxisTickRenderer"),
	CategoryAxis("$.jqplot.CategoryAxisRenderer"),
	DateAxis("$.jqplot.DateAxisRenderer"),
	LogAxis("$.jqplot.LogAxisRenderer"),
	MekkoAxis("$.jqplot.MekkoAxisRenderer"),
	AxisTick("$.jqplot.AxisTickRenderer"),
	CanvasGrid("$.jqplot.CanvasGridRenderer"),
	LinearAxis("$.jqplot.LinearAxisRenderer"),
	AxisLabel("$.jqplot.AxisLabelRenderer"),

	DivTitle("$.jqplot.CanvasGridRenderer"),
	Marker("$.jqplot.MarkerRenderer"),
	Shape("$.jqplot.shapeRenderer"),
	Shadow("$.jqplot.shadowRenderer"),
	EnhancedLegendRenderer("$.jqplot.EnhancedLegendRenderer"),
	DonutLegend("$.jqplot.DonutLegendRenderer");

	private String valueRenderer;

	/**
	 * Default constructor
	 * 
	 */
	private RenderersEnum(String valueRenderer) {
		this.valueRenderer = valueRenderer;
	}

	/**
	 * You need to use this method to set a renderer on charts.
	 * 
	 * @return the valueRenderer the renderer JavaScript name Value.
	 */
	public String getValueRenderer() {
		return valueRenderer;
	}

	/**
	 * Get the renderer ENUM by the JavaString name.
	 * 
	 * @param valueOfJsRenderers
	 *            the value of JavaScipt name value.
	 * @return the RenrererEnum.
	 */
	public static final RenderersEnum getValueWithRenderer(String valueOfJsRenderers) {
		for (RenderersEnum renderer : RenderersEnum.values()) {
			if (renderer.getValueRenderer().equals(valueOfJsRenderers)) {
				return renderer;
			}
		}
		throw new IllegalArgumentException("the renderer " + valueOfJsRenderers + " is not existing or not yet implemented.");
	}
}
