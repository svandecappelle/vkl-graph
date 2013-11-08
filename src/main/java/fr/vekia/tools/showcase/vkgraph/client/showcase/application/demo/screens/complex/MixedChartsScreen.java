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

	super.setBooleanOption(ChartOption.seriesDefaults, SubOption.showMarker, false);
	super.setBooleanOption(ChartOption.seriesDefaults, SubOption.pointLabels, SubOption.show, false);
	super.setBooleanOption(ChartOption.seriesDefaults, SubOption.rendererOptions, SubOption.smooth, true);

	super.setOption(ChartOption.axes, SubOption.xaxis, SubOption.renderer, RenderersEnum.CategoryAxis.getValueRenderer());
	super.setOption(ChartOption.axes, SubOption.xaxis, SubOption.tickOptions, "{angle: -30,fontFamily: 'Courier New', fontSize: '9pt'}");
	super.setOption(ChartOption.axes, SubOption.yaxis, SubOption.tickOptions, "{fontFamily: 'Courier New', fontSize: '9pt'}");
	 super.setOption(ChartOption.axes, SubOption.y2axis, SubOption.tickOptions, "{fontFamily: 'Courier New', fontSize: '9pt'}");
	 super.setOption(ChartOption.axes, SubOption.y3axis, SubOption.tickOptions, "{fontFamily: 'Courier New', fontSize: '9pt'}");

	super.setBooleanOption(ChartOption.cursor, SubOption.show, true);
	super.setTextOption(ChartOption.cursor, SubOption.tooltipLocation, "sw");

	super.setTextOption(ChartOption.legend, SubOption.location, "ne");
	super.setTextOption(ChartOption.legend, SubOption.rowSpacing, "0px");
	super.setBooleanOption(ChartOption.legend, SubOption.show, true);
	super.setOption(ChartOption.legend, SubOption.renderer, RenderersEnum.EnhancedLegendRenderer.getValueRenderer());
	super.setTextOption(ChartOption.legend, SubOption.placement, "outsideGrid");
	

	super.setBooleanOption(ChartOption.grid, SubOption.drawBorder, false);
	super.setBooleanOption(ChartOption.grid, SubOption.shadow, true);
	super.setTextOption(ChartOption.grid, SubOption.background, "white");
	super.setTextOption(ChartOption.grid, SubOption.rowSpacing, "0px");

	super.setNumberOption(ChartOption.axes, SubOption.yaxis, SubOption.pad, 1.05f, NumberType.FLOAT);
	super.setOption(ChartOption.axes, SubOption.xaxis, SubOption.labelRenderer, RenderersEnum.CanvasAxisLabel.getValueRenderer());
	super.setOption(ChartOption.axes, SubOption.xaxis, SubOption.tickRenderer, RenderersEnum.CanvasAxisTick.getValueRenderer());
	super.setOption(ChartOption.axes, SubOption.yaxis, SubOption.labelRenderer, RenderersEnum.CanvasAxisLabel.getValueRenderer());
	super.setOption(ChartOption.axes, SubOption.yaxis, SubOption.tickRenderer, RenderersEnum.CanvasAxisTick.getValueRenderer());
	super.setOption(ChartOption.axes, SubOption.y2axis, SubOption.labelRenderer, RenderersEnum.CanvasAxisLabel.getValueRenderer());
	super.setOption(ChartOption.axes, SubOption.y2axis, SubOption.tickRenderer, RenderersEnum.CanvasAxisTick.getValueRenderer());
	super.setTextOption(ChartOption.axes, SubOption.yaxis, SubOption.formatString, "%\'d");
	super.setTextOption(ChartOption.axes, SubOption.y2axis, SubOption.formatString, "%\'d");
	super.setTextOption(ChartOption.axes, SubOption.y3axis, SubOption.formatString, "%\'d");
	super.setNumberOption(ChartOption.axes, SubOption.y3axis, SubOption.max, 100);

	super.setOption(ChartOption.seriesColors, colors);

	OptionSerie electionCandidat1Line = new OptionSerie();
	OptionSerie electionCandidat2Line = new OptionSerie();
	OptionSerie populationLine = new OptionSerie();
	OptionSerie chomageLine = new OptionSerie();

	electionCandidat1Line.setTextOption(SubOption.renderer, RenderersEnum.Bar.getValueRenderer());
	electionCandidat1Line.setBooleanOption(SubOption.isDragable, false);
	electionCandidat1Line.setBooleanOption(SubOption.trendline, SubOption.show, false);
	electionCandidat1Line.setTextOption(SubOption.label, "Candidat droite");

	electionCandidat2Line.setTextOption(SubOption.renderer, RenderersEnum.Bar.getValueRenderer());
	electionCandidat2Line.setBooleanOption(SubOption.isDragable, false);
	electionCandidat2Line.setBooleanOption(SubOption.trendline, SubOption.show, false);
	electionCandidat2Line.setTextOption(SubOption.label, "Candidat gauche");

	chomageLine.setTextOption(SubOption.yaxis, "y3axis");
	chomageLine.setBooleanOption(SubOption.fill, true);
	chomageLine.setBooleanOption(SubOption.isDragable, false);
	chomageLine.setBooleanOption(SubOption.trendline, SubOption.show, false);
	chomageLine.setTextOption(SubOption.label, "Taux de chomage");

	populationLine.setTextOption(SubOption.trendline, SubOption.color, "#cccccc");
	populationLine.setBooleanOption(SubOption.isDragable, false);
	populationLine.setBooleanOption(SubOption.trendline, SubOption.show, true);
	populationLine.setTextOption(SubOption.yaxis, "y2axis");
	populationLine.setTextOption(SubOption.label, "Population active");

	SeriesData seriesDatas = new SeriesData();
	seriesDatas.set(0, electionCandidat1Line);
	seriesDatas.set(1, electionCandidat2Line);
	seriesDatas.set(2, populationLine);
	seriesDatas.set(3, chomageLine);

	super.setSeriesOptions(seriesDatas);

    }

    @SuppressWarnings("deprecation")
    private final List<List<DualValue>> getValues() {
	final List<List<DualValue>> dataValues = new ArrayList<List<DualValue>>();
	List<Date> allDate = new ArrayList<Date>();
	allDate.add(new Date(1959 - 1900, 0, 8));
	allDate.add(new Date(1969 - 1900, 3, 28));
	allDate.add(new Date(1969 - 1900, 5, 20));
	allDate.add(new Date(1974 - 1900, 3, 2));
	allDate.add(new Date(1974 - 1900, 4, 27));
	allDate.add(new Date(1981 - 1900, 4, 21));
	allDate.add(new Date(1995 - 1900, 4, 17));
	allDate.add(new Date(2007 - 1900, 4, 16));
	allDate.add(new Date(2012 - 1900, 4, 15));
	DateTimeFormat dateTimeFormat = DateTimeFormat.getShortDateFormat();
	List<String> dates = new ArrayList<String>();
	for (Date date : allDate) {
	    dates.add(dateTimeFormat.format(date));
	}
	final ArrayList<DualValue> presidentielSecondTour1 = new ArrayList<DualValue>();
	final ArrayList<DualValue> presidentielSecondTour2 = new ArrayList<DualValue>();
	final ArrayList<DualValue> populationActive = new ArrayList<DualValue>();
	final ArrayList<DualValue> chomage = new ArrayList<DualValue>();

	presidentielSecondTour1.add(new DualValue(dates.get(0), 55.80));
	presidentielSecondTour2.add(new DualValue(dates.get(0), 44.20));
	populationActive.add(new DualValue(dates.get(0), 19500000));
	chomage.add(new DualValue(dates.get(0), 2.0));

	presidentielSecondTour1.add(new DualValue(dates.get(1), 58.21));
	presidentielSecondTour2.add(new DualValue(dates.get(1), 41.79));
	populationActive.add(new DualValue(dates.get(1), 19550000));
	chomage.add(new DualValue(dates.get(1), 2.1));

	presidentielSecondTour1.add(new DualValue(dates.get(2), 50.81));
	presidentielSecondTour2.add(new DualValue(dates.get(2), 49.19));
	populationActive.add(new DualValue(dates.get(2), 19550000));
	chomage.add(new DualValue(dates.get(2), 2.1));

	presidentielSecondTour1.add(new DualValue(dates.get(3), 48.24));
	presidentielSecondTour2.add(new DualValue(dates.get(3), 51.76));
	populationActive.add(new DualValue(dates.get(3), 22000000));
	chomage.add(new DualValue(dates.get(3), 2.8));

	presidentielSecondTour1.add(new DualValue(dates.get(4), 45.98));
	presidentielSecondTour2.add(new DualValue(dates.get(4), 54.02));
	populationActive.add(new DualValue(dates.get(4), 22000000));
	chomage.add(new DualValue(dates.get(4), 2.8));

	presidentielSecondTour1.add(new DualValue(dates.get(5), 52.64));
	presidentielSecondTour2.add(new DualValue(dates.get(5), 47.36));
	populationActive.add(new DualValue(dates.get(5), 22500000));
	chomage.add(new DualValue(dates.get(5), 6.1));

	presidentielSecondTour1.add(new DualValue(dates.get(6), 82.21));
	presidentielSecondTour2.add(new DualValue(dates.get(6), 17.79));
	populationActive.add(new DualValue(dates.get(6), 25500000));
	chomage.add(new DualValue(dates.get(6), 11.5));

	presidentielSecondTour1.add(new DualValue(dates.get(7), 53.06));
	presidentielSecondTour2.add(new DualValue(dates.get(7), 46.94));
	populationActive.add(new DualValue(dates.get(7), 26000000));
	chomage.add(new DualValue(dates.get(7), 8.5));

	presidentielSecondTour1.add(new DualValue(dates.get(8), 48.36));
	presidentielSecondTour2.add(new DualValue(dates.get(8), 51.64));
	populationActive.add(new DualValue(dates.get(8), 26700000));
	chomage.add(new DualValue(dates.get(8), 10.0));

	dataValues.add(presidentielSecondTour1);
	dataValues.add(presidentielSecondTour2);
	dataValues.add(populationActive);
	dataValues.add(chomage);
	return dataValues;
    }
}
