/*
 * File: $URL: svn+ssh://chimay/home/svn/VkGraph-showcase/VkGraph-showcase/src/main/java/fr.vekia.tools.showcase.vkgraph/client/showcase/application/components/menu/groups/complex/screens/MixedChartsScreen.java $
 * $Id: MixedChartsScreen.java 52 2012-09-26 15:26:35Z svandecappelle $
 * Licence MIT
 * 
 * Last change:
 * $Date: 2012-09-26 17:26:35 +0200 (mer., 26 sept. 2012) $
 * $Author: svandecappelle $
 */
package fr.vekia.tools.showcase.vkgraph.client.showcase.application.demo.screens.complex;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gwt.i18n.client.DateTimeFormat;

import fr.vekia.VkGraph.client.charts.AbstractChart;
import fr.vekia.VkGraph.client.charts.NumberType;
import fr.vekia.VkGraph.client.charts.RenderersEnum;
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
public class MixedChartsScreen extends AbstractChart<List<DualValue>> {

	/**
	 * Default constructor
	 * 
	 */
	public MixedChartsScreen() {
		List<String> colors = new ArrayList<String>();
		colors.add("rgba(78, 135, 194, 0.7)");
		colors.add("rgba(211, 0, 59,0.7)");
		colors.add("rgba(78, 135, 0, 0.7)");
		colors.add("rgba(235, 125, 0, 0.5)");

		super.setDatas(this.getValues());
		super.setSize("1000px", "600px");

		super.setTextOption(ChartOption.title, "Votes");

		super.setBooleanOption(ChartOption.animate, true);
		super.setBooleanOption(ChartOption.animateReplot, true);

		super.setBooleanOption(ChartOption.seriesDefaults,
				SubOption.showMarker, false);
		super.setBooleanOption(ChartOption.seriesDefaults,
				SubOption.pointLabels, SubOption.show, false);
		super.setBooleanOption(ChartOption.seriesDefaults,
				SubOption.rendererOptions, SubOption.smooth, true);

		super.setOption(ChartOption.axes, SubOption.xaxis, SubOption.renderer,
				RenderersEnum.CategoryAxis.getValueRenderer());
		super.setOption(ChartOption.axes, SubOption.xaxis,
				SubOption.tickOptions,
				"{angle: -30,fontFamily: 'Courier New', fontSize: '9pt'}");
		super.setOption(ChartOption.axes, SubOption.yaxis,
				SubOption.tickOptions,
				"{fontFamily: 'Courier New', fontSize: '9pt'}");
		super.setOption(ChartOption.axes, SubOption.y2axis,
				SubOption.tickOptions,
				"{fontFamily: 'Courier New', fontSize: '9pt'}");
		super.setOption(ChartOption.axes, SubOption.y3axis,
				SubOption.tickOptions,
				"{fontFamily: 'Courier New', fontSize: '9pt'}");

		super.setBooleanOption(ChartOption.cursor, SubOption.show, true);
		super.setTextOption(ChartOption.cursor, SubOption.tooltipLocation, "sw");

		super.setTextOption(ChartOption.legend, SubOption.location, "ne");
		super.setTextOption(ChartOption.legend, SubOption.rowSpacing, "0px");
		super.setBooleanOption(ChartOption.legend, SubOption.show, true);
		super.setOption(ChartOption.legend, SubOption.renderer,
				RenderersEnum.EnhancedLegendRenderer.getValueRenderer());
		super.setTextOption(ChartOption.legend, SubOption.placement,
				"outsideGrid");

		super.setBooleanOption(ChartOption.grid, SubOption.drawBorder, false);
		super.setBooleanOption(ChartOption.grid, SubOption.shadow, true);
		super.setTextOption(ChartOption.grid, SubOption.background, "white");
		super.setTextOption(ChartOption.grid, SubOption.rowSpacing, "0px");

		super.setNumberOption(ChartOption.axes, SubOption.yaxis, SubOption.pad,
				1.05f, NumberType.FLOAT);
		super.setOption(ChartOption.axes, SubOption.xaxis,
				SubOption.labelRenderer,
				RenderersEnum.CanvasAxisLabel.getValueRenderer());
		super.setOption(ChartOption.axes, SubOption.xaxis,
				SubOption.tickRenderer,
				RenderersEnum.CanvasAxisTick.getValueRenderer());
		super.setOption(ChartOption.axes, SubOption.yaxis,
				SubOption.labelRenderer,
				RenderersEnum.CanvasAxisLabel.getValueRenderer());
		super.setOption(ChartOption.axes, SubOption.yaxis,
				SubOption.tickRenderer,
				RenderersEnum.CanvasAxisTick.getValueRenderer());
		super.setOption(ChartOption.axes, SubOption.y2axis,
				SubOption.labelRenderer,
				RenderersEnum.CanvasAxisLabel.getValueRenderer());
		super.setOption(ChartOption.axes, SubOption.y2axis,
				SubOption.tickRenderer,
				RenderersEnum.CanvasAxisTick.getValueRenderer());
		super.setTextOption(ChartOption.axes, SubOption.yaxis,
				SubOption.formatString, "%\'d");
		super.setTextOption(ChartOption.axes, SubOption.y2axis,
				SubOption.formatString, "%\'d");

		super.setOption(ChartOption.seriesColors, colors);

		OptionSerie qtySerie = new OptionSerie();
		OptionSerie qtyFromSerie = new OptionSerie();
		OptionSerie qtyPushSerie = new OptionSerie();
		OptionSerie stockSerie = new OptionSerie();

		qtySerie.setTextOption(SubOption.renderer,
				RenderersEnum.Bar.getValueRenderer());
		qtySerie.setBooleanOption(SubOption.isDragable, false);
		qtySerie.setBooleanOption(SubOption.trendline,
				SubOption.show, false);
		qtySerie.setTextOption(SubOption.label, "Qty");

		qtyFromSerie.setTextOption(SubOption.renderer,
				RenderersEnum.Bar.getValueRenderer());
		qtyFromSerie.setBooleanOption(SubOption.isDragable, false);
		qtyFromSerie.setBooleanOption(SubOption.trendline,
				SubOption.show, false);
		qtyFromSerie.setTextOption(SubOption.label, "QtyFrom");

		stockSerie.setTextOption(SubOption.yaxis, "y2axis");
		stockSerie.setBooleanOption(SubOption.fill, true);
		stockSerie.setBooleanOption(SubOption.isDragable, false);
		stockSerie
				.setBooleanOption(SubOption.trendline, SubOption.show, false);
		stockSerie.setTextOption(SubOption.label, "Stock");
		stockSerie.setBooleanOption(SubOption.trendline,
				SubOption.show, false);

		qtyPushSerie.setTextOption(SubOption.trendline, SubOption.color,
				"#cccccc");
		qtyPushSerie.setBooleanOption(SubOption.isDragable, false);
		qtyPushSerie.setBooleanOption(SubOption.trendline, SubOption.show,
				false);
		qtyPushSerie.setTextOption(SubOption.renderer, RenderersEnum.Bar.getValueRenderer());
		qtyPushSerie.setTextOption(SubOption.label, "QtyPush");

		SeriesData seriesDatas = new SeriesData();
		seriesDatas.set(0, qtySerie);
		seriesDatas.set(1, qtyFromSerie);
		seriesDatas.set(2, qtyPushSerie);
		seriesDatas.set(3, stockSerie);

		super.setSeriesOptions(seriesDatas);

	}

	@SuppressWarnings("deprecation")
	private final List<List<DualValue>> getValues() {
		final List<List<DualValue>> dataValues = new ArrayList<List<DualValue>>();
		List<String> dates = new ArrayList<String>();
		dates.add("T-shirts");
		dates.add("Pantalon");
		dates.add("Layette");
		dates.add("Accessoires");
		dates.add("Sous-vêtements");
		dates.add("Chaussures");
		dates.add("Pulls");
		dates.add("Blousons");
		dates.add("Vestes");
		DateTimeFormat dateTimeFormat = DateTimeFormat.getShortDateFormat();
		
		final ArrayList<DualValue> qty = new ArrayList<DualValue>();
		final ArrayList<DualValue> qtyFrom = new ArrayList<DualValue>();
		final ArrayList<DualValue> qtyPush = new ArrayList<DualValue>();
		final ArrayList<DualValue> stock = new ArrayList<DualValue>();
		
		qty.add(new DualValue(dates.get(0), 5));
		qtyFrom.add(new DualValue(dates.get(0), 44));
		stock.add(new DualValue(dates.get(0), 10));
		qtyPush.add(new DualValue(dates.get(0), 2.0));

		qty.add(new DualValue(dates.get(1), 5));
		qtyFrom.add(new DualValue(dates.get(1), 41));
		stock.add(new DualValue(dates.get(1), 19));
		qtyPush.add(new DualValue(dates.get(1), 2));

		qty.add(new DualValue(dates.get(2), 6));
		qtyFrom.add(new DualValue(dates.get(2), 49));
		stock.add(new DualValue(dates.get(2), 11));
		qtyPush.add(new DualValue(dates.get(2), 2));

		qty.add(new DualValue(dates.get(3), 4));
		qtyFrom.add(new DualValue(dates.get(3), 51));
		stock.add(new DualValue(dates.get(3), 15));
		qtyPush.add(new DualValue(dates.get(3), 2));

		qty.add(new DualValue(dates.get(4), 4));
		qtyFrom.add(new DualValue(dates.get(4), 54));
		stock.add(new DualValue(dates.get(4), 15));
		qtyPush.add(new DualValue(dates.get(4), 3));

		qty.add(new DualValue(dates.get(5), 5));
		qtyFrom.add(new DualValue(dates.get(5), 47));
		stock.add(new DualValue(dates.get(5), 12));
		qtyPush.add(new DualValue(dates.get(5), 6));

		qty.add(new DualValue(dates.get(6), 8));
		qtyFrom.add(new DualValue(dates.get(6), 17));
		stock.add(new DualValue(dates.get(6), 9));
		qtyPush.add(new DualValue(dates.get(6), 11));

		qty.add(new DualValue(dates.get(7), 5));
		qtyFrom.add(new DualValue(dates.get(7), 46));
		stock.add(new DualValue(dates.get(7), 8));
		qtyPush.add(new DualValue(dates.get(7), 8));

		qty.add(new DualValue(dates.get(8), 4));
		qtyFrom.add(new DualValue(dates.get(8), 51));
		stock.add(new DualValue(dates.get(8), 15));
		qtyPush.add(new DualValue(dates.get(8), 10));

		dataValues.add(qty);
		dataValues.add(qtyFrom);
		dataValues.add(qtyPush);
		dataValues.add(stock);
		return dataValues;
	}
}
