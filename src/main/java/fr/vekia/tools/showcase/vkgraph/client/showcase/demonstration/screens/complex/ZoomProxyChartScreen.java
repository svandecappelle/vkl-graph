package fr.vekia.tools.showcase.vkgraph.client.showcase.demonstration.screens.complex;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.datepicker.client.CalendarUtil;

import fr.vekia.vkgraph.client.charts.AbstractChart;
import fr.vekia.vkgraph.client.charts.RenderersEnum;
import fr.vekia.vkgraph.client.datas.CanvasOverlayObject;
import fr.vekia.vkgraph.client.datas.DualValue;
import fr.vekia.vkgraph.client.datas.OptionSerie;
import fr.vekia.vkgraph.client.datas.Rectangle;
import fr.vekia.vkgraph.client.datas.SeriesData;
import fr.vekia.vkgraph.client.options.ChartOption;
import fr.vekia.vkgraph.client.options.SubOption;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 11 mai 2012. GWTQuery Vekia Showcase
 * @version 1.0
 */
public class ZoomProxyChartScreen extends SimplePanel {

    /**
     * Default constructor
     * 
     */
    public ZoomProxyChartScreen() {

        super();

        VerticalPanel content = new VerticalPanel();

        final AbstractChart<List<DualValue>> chart1 = new AbstractChart<List<DualValue>>();
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

        chart1.setXaxisRenderer(RenderersEnum.DateAxis);

        SeriesData seriesData = new SeriesData();
        seriesData.set(0, firstDataRendererOptions);
        seriesData.set(1, barDataRendererOptions);

        List<List<DualValue>> datas = new ArrayList<List<DualValue>>();
        List<DualValue> lineDataOne = new ArrayList<DualValue>();
        lineDataOne.add(new DualValue(this.addYearToNow(0).getTime(), 112000));
        lineDataOne.add(new DualValue(this.addYearToNow(1).getTime(), 122000));
        lineDataOne.add(new DualValue(this.addYearToNow(2).getTime(), 104000));
        lineDataOne.add(new DualValue(this.addYearToNow(3).getTime(), 99000));
        lineDataOne.add(new DualValue(this.addYearToNow(4).getTime(), 121000));
        lineDataOne.add(new DualValue(this.addYearToNow(5).getTime(), 148000));
        lineDataOne.add(new DualValue(this.addYearToNow(6).getTime(), 114000));
        lineDataOne.add(new DualValue(this.addYearToNow(7).getTime(), 133000));
        lineDataOne.add(new DualValue(this.addYearToNow(8).getTime(), 161000));
        lineDataOne.add(new DualValue(this.addYearToNow(9).getTime(), 173000));

        datas.add(lineDataOne);

        List<DualValue> lineDataTwo = new ArrayList<DualValue>();
        lineDataTwo.add(new DualValue(this.addYearToNow(0).getTime(), 10200));
        lineDataTwo.add(new DualValue(this.addYearToNow(1).getTime(), 10800));
        lineDataTwo.add(new DualValue(this.addYearToNow(2).getTime(), 11200));
        lineDataTwo.add(new DualValue(this.addYearToNow(3).getTime(), 11800));
        lineDataTwo.add(new DualValue(this.addYearToNow(4).getTime(), 12400));
        lineDataTwo.add(new DualValue(this.addYearToNow(5).getTime(), 12800));
        lineDataTwo.add(new DualValue(this.addYearToNow(6).getTime(), 13200));
        lineDataTwo.add(new DualValue(this.addYearToNow(7).getTime(), 12600));
        lineDataTwo.add(new DualValue(this.addYearToNow(8).getTime(), 13100));
        lineDataTwo.add(new DualValue(this.addYearToNow(9).getTime(), 13100));
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
        chartProxy.setXaxisRenderer(RenderersEnum.DateAxis);
        chart1.setZoomProxy(chartProxy);

        setWidget(content);

        Button fullscreen = new Button("Fullscreen");
        fullscreen.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                chart1.toggleFullscreen();
            }
        });
        content.add(fullscreen);

        CanvasOverlayObject objectsCanvas = new CanvasOverlayObject();
        Rectangle rect = new Rectangle();
        rect.setTextOption(SubOption.xmin, "2014/09/01 05:00:00");
        rect.setTextOption(SubOption.xmax, "2016/09/01 05:00:00");

        rect.setNumberOption(SubOption.ymin, 110800);
        rect.setNumberOption(SubOption.ymax, 120400);

        rect.setTextOption(SubOption.color, "rgb(100, 55, 124)");
        rect.setTextOption(SubOption.xformat, SubOption.type, "date");
        rect.setTextOption(SubOption.xformat, SubOption.format, "%Y/%m/%d");

        objectsCanvas.addObject(rect);
        chart1.setCanvasOverlay(objectsCanvas);
        chart1.setBooleanOption(ChartOption.canvasOverlay, SubOption.show, true);
        chart1.setBooleanOption(ChartOption.canvasOverlay, SubOption.bellowSeries, true);
    }

    public Date addYearToNow(int addYear) {
        // Date xaxis
        Date date = new Date();
        CalendarUtil.addDaysToDate(date, 365 * addYear);
        return date;
    }

}
