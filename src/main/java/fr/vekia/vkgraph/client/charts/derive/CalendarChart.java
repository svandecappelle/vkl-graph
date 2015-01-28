package fr.vekia.vkgraph.client.charts.derive;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.Composite;

import fr.vekia.vkgraph.client.charts.LineChart;
import fr.vekia.vkgraph.client.charts.NumberType;
import fr.vekia.vkgraph.client.charts.RenderersEnum;
import fr.vekia.vkgraph.client.datas.CanvasOverlayObject;
import fr.vekia.vkgraph.client.datas.DualValue;
import fr.vekia.vkgraph.client.datas.PeriodCalendar;
import fr.vekia.vkgraph.client.datas.VerticalLine;
import fr.vekia.vkgraph.client.options.ChartOption;
import fr.vekia.vkgraph.client.options.SubOption;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 28 sept. 2012. VklGraph version 1.2
 * @version 2.1
 * 
 *          {@inheritDoc}
 */
public class CalendarChart extends Composite {

	private LineChart<DualValue> chart;
	private CanvasOverlayObject canvasDrawOption;

	/**
	 * Default constructor
	 * 
	 */
	public CalendarChart(Date from, Date to) {
		chart = new LineChart<DualValue>();
		canvasDrawOption = new CanvasOverlayObject();
		// xaxis
		chart.setXaxisRenderer(RenderersEnum.DateAxis);
		chart.setNumberOption(ChartOption.axes, SubOption.xaxis, SubOption.max, to.getTime(), NumberType.LONG);
		chart.setNumberOption(ChartOption.axes, SubOption.yaxis, SubOption.tickInterval, 1);

		// To fix the no data exception throwed by javascript part.
		List<DualValue> data = new ArrayList<DualValue>();
		data.add(new DualValue(from.getTime(), -1000));

		chart.setDatas(data);
		chart.setListView(true);

		chart.setBooleanOption(ChartOption.canvasOverlay, SubOption.show, true);

		chart.setOption(ChartOption.axes, SubOption.yaxis, SubOption.renderer, RenderersEnum.CategoryAxis.getValueRenderer());

		chart.setBooleanOption(ChartOption.grid, SubOption.xaxis, SubOption.show, false);
		chart.setBooleanOption(ChartOption.grid, SubOption.shadow, false);

		chart.setOption(ChartOption.axes, SubOption.xaxis, SubOption.tickRenderer, RenderersEnum.CanvasAxisTick.getValueRenderer());
		chart.setOption(ChartOption.axes, SubOption.xaxis, SubOption.labelRenderer, RenderersEnum.CanvasAxisLabel.getValueRenderer());

		chart.setOption(ChartOption.axes, SubOption.yaxis, SubOption.tickRenderer, RenderersEnum.CanvasAxisTick.getValueRenderer());
		chart.setOption(ChartOption.axes, SubOption.yaxis, SubOption.labelRenderer, RenderersEnum.CanvasAxisLabel.getValueRenderer());
		chart.setOption(ChartOption.axes, SubOption.xaxis, SubOption.tickOptions, "{angle: -30, fontFamily:'Helvetica',fontSize: '11pt', textColor: 'white'}");
		chart.setOption(ChartOption.axes, SubOption.yaxis, SubOption.tickOptions, "{showGridline: false, fontFamily:'Helvetica',fontSize: '11pt', textColor: 'white'}");

		chart.setOption(ChartOption.cursor, SubOption.constrainZoomTo, "x");

		initWidget(chart);
	}

	public void setTicks(List<String> ticks) {
		chart.setOption(ChartOption.axes, SubOption.yaxis, SubOption.ticks, ticks);
		chart.setNumberOption(ChartOption.axes, SubOption.yaxis, SubOption.min, 0, NumberType.INT);
		chart.setNumberOption(ChartOption.axes, SubOption.yaxis, SubOption.max, ticks.size(), NumberType.INT);
	}

	@Override
	public void setSize(String width, String height) {
		chart.setSize(width, height);
	}

	public void setBackgroundColor(String color) {
		chart.setOption(ChartOption.grid, SubOption.background, color);
	}

	public void setPeriodCalendar(List<PeriodCalendar> calendarPeriods) {
		for (PeriodCalendar period : calendarPeriods) {
			canvasDrawOption.addObject(period);
		}
		chart.setCanvasOverlay(canvasDrawOption);
	}

	public void addPeriodCalendar(PeriodCalendar period) {
		canvasDrawOption.addObject(period);
		chart.setCanvasOverlay(canvasDrawOption);
	}

	public void setZoomEnable(boolean isEnable) {
		chart.setBooleanOption(ChartOption.cursor, SubOption.show, isEnable);
		chart.setBooleanOption(ChartOption.cursor, SubOption.zoom, isEnable);
		chart.setBooleanOption(ChartOption.cursor, SubOption.looseZoom, isEnable);
	}

	/**
     * 
     */
	public void addTodayLine() {
		Date today = new Date();
		VerticalLine todayLine = new VerticalLine();
		todayLine.setNumberOption(SubOption.x, today.getTime(), NumberType.LONG);
		todayLine.setBooleanOption(SubOption.showTooltip, true);

		@SuppressWarnings("deprecation")
		DateTimeFormat format = DateTimeFormat.getMediumTimeFormat();
		todayLine.setOption(SubOption.tooltipFormatString, "Today" + "<br/> <dd>" + format.format(today) + "</dd>");

		canvasDrawOption.addObject(todayLine);
		chart.setCanvasOverlay(canvasDrawOption);
	}
}
