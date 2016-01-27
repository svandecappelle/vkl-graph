package fr.vekia.tools.showcase.vkgraph.client.showcase.demonstration.screens.complex;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;

import fr.vekia.tools.showcase.vkgraph.client.showcase.application.ui.JQueryDialog;
import fr.vekia.vkgraph.client.charts.AbstractChart;
import fr.vekia.vkgraph.client.charts.NumberType;
import fr.vekia.vkgraph.client.charts.RenderersEnum;
import fr.vekia.vkgraph.client.charts.events.ChartSimpleEvent;
import fr.vekia.vkgraph.client.charts.events.SimpleEventObject;
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
public class MixedChartsScreen extends FlowPanel {

    /**
     * Default constructor
     * 
     */
    public MixedChartsScreen() {

        final AbstractChart<List<DualValue>> chart = new AbstractChart<List<DualValue>>();

        List<String> colors = new ArrayList<String>();
        colors.add("rgba(78, 135, 194, 0.7)");
        colors.add("rgba(211, 0, 59,0.7)");
        colors.add("rgba(78, 135, 0, 0.7)");
        colors.add("rgba(235, 125, 0, 0.5)");

        chart.setDatas(this.getValues());
        chart.setSize("1000px", "600px");

        chart.setTextOption(ChartOption.title, "Votes");

        chart.setBooleanOption(ChartOption.animate, true);
        chart.setBooleanOption(ChartOption.animateReplot, true);

        chart.setBooleanOption(ChartOption.seriesDefaults, SubOption.showMarker, false);
        chart.setBooleanOption(ChartOption.seriesDefaults, SubOption.pointLabels, SubOption.show, false);
        chart.setBooleanOption(ChartOption.seriesDefaults, SubOption.rendererOptions, SubOption.smooth, true);

        chart.setOption(ChartOption.axes, SubOption.xaxis, SubOption.renderer, RenderersEnum.CategoryAxis.getValueRenderer());
        chart.setOption(ChartOption.axes, SubOption.xaxis, SubOption.tickOptions, "{angle: -30,fontFamily: 'Courier New', fontSize: '9pt'}");
        chart.setOption(ChartOption.axes, SubOption.yaxis, SubOption.tickOptions, "{fontFamily: 'Courier New', fontSize: '9pt'}");
        chart.setOption(ChartOption.axes, SubOption.y2axis, SubOption.tickOptions, "{fontFamily: 'Courier New', fontSize: '9pt'}");
        chart.setOption(ChartOption.axes, SubOption.y3axis, SubOption.tickOptions, "{fontFamily: 'Courier New', fontSize: '9pt'}");

        chart.setBooleanOption(ChartOption.cursor, SubOption.show, true);
        chart.setTextOption(ChartOption.cursor, SubOption.tooltipLocation, "sw");

        chart.setTextOption(ChartOption.legend, SubOption.location, "ne");
        chart.setTextOption(ChartOption.legend, SubOption.rowSpacing, "0px");
        chart.setBooleanOption(ChartOption.legend, SubOption.show, true);
        chart.setOption(ChartOption.legend, SubOption.renderer, RenderersEnum.EnhancedLegendRenderer.getValueRenderer());
        chart.setTextOption(ChartOption.legend, SubOption.placement, "outsideGrid");

        chart.setBooleanOption(ChartOption.grid, SubOption.drawBorder, false);
        chart.setBooleanOption(ChartOption.grid, SubOption.shadow, true);
        chart.setTextOption(ChartOption.grid, SubOption.background, "white");
        chart.setTextOption(ChartOption.grid, SubOption.rowSpacing, "0px");

        chart.setNumberOption(ChartOption.axes, SubOption.yaxis, SubOption.pad, 1.05f, NumberType.FLOAT);
        chart.setOption(ChartOption.axes, SubOption.xaxis, SubOption.labelRenderer, RenderersEnum.CanvasAxisLabel.getValueRenderer());
        chart.setOption(ChartOption.axes, SubOption.xaxis, SubOption.tickRenderer, RenderersEnum.CanvasAxisTick.getValueRenderer());
        chart.setOption(ChartOption.axes, SubOption.yaxis, SubOption.labelRenderer, RenderersEnum.CanvasAxisLabel.getValueRenderer());
        chart.setOption(ChartOption.axes, SubOption.yaxis, SubOption.tickRenderer, RenderersEnum.CanvasAxisTick.getValueRenderer());
        chart.setOption(ChartOption.axes, SubOption.y2axis, SubOption.labelRenderer, RenderersEnum.CanvasAxisLabel.getValueRenderer());
        chart.setOption(ChartOption.axes, SubOption.y2axis, SubOption.tickRenderer, RenderersEnum.CanvasAxisTick.getValueRenderer());
        chart.setTextOption(ChartOption.axes, SubOption.yaxis, SubOption.formatString, "%\'d");
        chart.setTextOption(ChartOption.axes, SubOption.y2axis, SubOption.formatString, "%\'d");

        chart.setOption(ChartOption.seriesColors, colors);

        OptionSerie qtySerie = new OptionSerie();
        OptionSerie qtyFromSerie = new OptionSerie();
        OptionSerie qtyPushSerie = new OptionSerie();
        OptionSerie stockSerie = new OptionSerie();

        qtySerie.setTextOption(SubOption.renderer, RenderersEnum.Bar.getValueRenderer());
        qtySerie.setBooleanOption(SubOption.isDragable, false);
        qtySerie.setBooleanOption(SubOption.trendline, SubOption.show, false);
        qtySerie.setTextOption(SubOption.label, "Qty");

        qtyFromSerie.setTextOption(SubOption.renderer, RenderersEnum.Bar.getValueRenderer());
        qtyFromSerie.setBooleanOption(SubOption.isDragable, false);
        qtyFromSerie.setBooleanOption(SubOption.trendline, SubOption.show, false);
        qtyFromSerie.setTextOption(SubOption.label, "QtyFrom");

        stockSerie.setTextOption(SubOption.yaxis, "y2axis");
        stockSerie.setBooleanOption(SubOption.fill, true);
        stockSerie.setBooleanOption(SubOption.isDragable, false);
        stockSerie.setBooleanOption(SubOption.trendline, SubOption.show, false);
        stockSerie.setTextOption(SubOption.label, "Stock");
        stockSerie.setBooleanOption(SubOption.trendline, SubOption.show, false);

        qtyPushSerie.setTextOption(SubOption.trendline, SubOption.color, "#cccccc");
        qtyPushSerie.setBooleanOption(SubOption.isDragable, false);
        qtyPushSerie.setBooleanOption(SubOption.trendline, SubOption.show, false);
        qtyPushSerie.setTextOption(SubOption.renderer, RenderersEnum.Bar.getValueRenderer());
        qtyPushSerie.setTextOption(SubOption.label, "QtyPush");

        SeriesData seriesDatas = new SeriesData();
        seriesDatas.set(0, qtySerie);
        seriesDatas.set(1, qtyFromSerie);
        seriesDatas.set(2, qtyPushSerie);
        seriesDatas.set(3, stockSerie);

        chart.setSeriesOptions(seriesDatas);

        CanvasOverlayObject objectsCanvas = new CanvasOverlayObject();
        Rectangle rect = new Rectangle();
        rect.setNumberOption(SubOption.xmin, 1);
        rect.setNumberOption(SubOption.xmax, 10);

        rect.setNumberOption(SubOption.ymin, 1);
        rect.setNumberOption(SubOption.ymax, 5);

        rect.setTextOption(SubOption.color, "rgb(100, 55, 124)");

        objectsCanvas.addObject(rect);
        chart.setCanvasOverlay(objectsCanvas);
        chart.setBooleanOption(ChartOption.canvasOverlay, SubOption.show, true);
        chart.setBooleanOption(ChartOption.canvasOverlay, SubOption.bellowSeries, true);

        chart.bind(new ChartSimpleEvent() {

            @Override
            public void onEvent(SimpleEventObject datasOnEvent) {
                JQueryDialog dialog = new JQueryDialog("Event");
                dialog.setPreferedSize(100, 200);
                Integer serieShow = Integer.valueOf(datasOnEvent.getValues().get("id").toString());
                dialog.setContent(new Label("serie showed:" + serieShow));
                dialog.show();
            }

            @Override
            public String getEventType() {
                return "jqplotSerieShow";
            }
        });

        chart.bind(new ChartSimpleEvent() {

            @Override
            public void onEvent(SimpleEventObject datasOnEvent) {
                JQueryDialog dialog = new JQueryDialog("Event");
                dialog.setPreferedSize(100, 200);
                Integer serieHide = Integer.valueOf(datasOnEvent.getValues().get("id").toString());
                dialog.setContent(new Label("serie hidden:" + serieHide));
                dialog.show();
            }

            @Override
            public String getEventType() {
                return "jqplotSerieHide";
            }
        });

        this.add(chart);
        final Button buttonHideSerie = new Button("Hide serie 1");

        buttonHideSerie.addClickHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {
                chart.hideSerie(1);
            }
        });

        final Button buttonToggleSerie2 = new Button("Toggle serie 2");

        buttonToggleSerie2.addClickHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {
                chart.toggleSerie(2);
            }
        });

        this.add(buttonHideSerie);
        this.add(buttonToggleSerie2);
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
