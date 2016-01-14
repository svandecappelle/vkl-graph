package fr.vekia.tools.showcase.vkgraph.client.showcase.application.demo.screens.interactives;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.FontWeight;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HorizontalPanel;

import fr.vekia.vkgraph.client.charts.BubbleChart;
import fr.vekia.vkgraph.client.charts.events.DataClickEvent;
import fr.vekia.vkgraph.client.charts.events.DataHighlightEvent;
import fr.vekia.vkgraph.client.charts.events.DataRightClickEvent;
import fr.vekia.vkgraph.client.charts.events.DataUnHighlightEvent;
import fr.vekia.vkgraph.client.charts.events.EventObject;
import fr.vekia.vkgraph.client.charts.events.SimpleEventObject;
import fr.vekia.vkgraph.client.datas.BubbleValue;
import fr.vekia.vkgraph.client.options.ChartOption;
import fr.vekia.vkgraph.client.options.SubOption;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 17 août 2012. VklGraph version 1.2
 * @version 2.1
 */
public class BubbleInteractiveWidgetScreen extends HorizontalPanel {

    private int lastIndexFired;

    /**
     * Default constructor
     * 
     */
    public BubbleInteractiveWidgetScreen() {

        BubbleChart chart = new BubbleChart();
        // to enable drag bubble.
        // chart.setPluginsEnable(true);

        final List<BubbleValue> values = new ArrayList<BubbleValue>();
        values.add(new BubbleValue(48.50, 2.20, 11767193, "Paris"));
        values.add(new BubbleValue(39.55, 116.20, 11537036, "Pékin"));
        values.add(new BubbleValue(51.36, 0.05, 13229219, "Londres"));
        values.add(new BubbleValue(35.40, 139.45, 33413000, "Tokyo"));
        values.add(new BubbleValue(37.31, 126.58, 22173711, "Seoul"));
        values.add(new BubbleValue(39.91, 77.02, 572059, "Washington"));
        values.add(new BubbleValue(52.30, 13.25, 3400000, "Berlin"));
        values.add(new BubbleValue(21.03, 105.85, 2842000, "Hanoï"));
        values.add(new BubbleValue(41.54, 12.27, 2800000, "Rome"));
        values.add(new BubbleValue(13.45, 100.30, 9308924, "Bangkok"));
        values.add(new BubbleValue(27.71, 90.40, 11918442, "Dhâkâ"));
        values.add(new BubbleValue(34.35, 58.22, 14235106, "Buenos Aires"));
        values.add(new BubbleValue(55.45, 37.36, 14740000, "Mouscou"));
        values.add(new BubbleValue(30.02, 31.21, 16244700, "Le Caire"));
        values.add(new BubbleValue(28.35, 77.12, 17367300, "New Delhi"));
        values.add(new BubbleValue(6.16, 106.48, 18206700, "Jakarta"));
        values.add(new BubbleValue(19.26, 99.07, 22414319, "Mexico"));
        values.add(new BubbleValue(40.26, 3.42, 5500000, "Madrid"));
        values.add(new BubbleValue(1.14, 103.55, 4240000, "Singapour"));
        values.add(new BubbleValue(44.25, 26.07, 2020000, "Bucarest"));
        values.add(new BubbleValue(47.30, 19.05, 2000000, "Budapest"));
        values.add(new BubbleValue(39.91, 77.02, 2500000, "Pyongyang"));
        values.add(new BubbleValue(52.14, 21.00, 1690821, "Varsovie"));
        values.add(new BubbleValue(48.14, 16.20, 1600000, "Vienne"));

        chart.setDatas(values);
        chart.setResizable(true);
        chart.setNumberOption(ChartOption.axes, SubOption.xaxis, SubOption.min, -20);
        chart.setNumberOption(ChartOption.axes, SubOption.xaxis, SubOption.max, 70);

        chart.setNumberOption(ChartOption.axes, SubOption.yaxis, SubOption.min, -20);
        chart.setNumberOption(ChartOption.axes, SubOption.yaxis, SubOption.max, 200);

        final FlexTable datasTable = new FlexTable();
        datasTable.setText(0, 0, "Company");
        datasTable.setText(0, 1, "R value");
        datasTable.setText(values.size() + 1, 0, "LastFiredEvent");
        datasTable.setText(values.size() + 1, 1, "EventValue");

        chart.bind(new DataHighlightEvent() {

            @Override
            public void onEvent(EventObject datasOnEvent) {
                GWT.log(datasOnEvent.toString());
                datasTable.getRowFormatter().getElement(datasOnEvent.getPointIndex() + 1).getStyle().setBackgroundColor("black");
                datasTable.getRowFormatter().getElement(datasOnEvent.getPointIndex() + 1).getStyle().setColor("aliceblue");
                datasTable.getRowFormatter().getElement(datasOnEvent.getPointIndex() + 1).getStyle().setFontWeight(FontWeight.BOLD);
                lastIndexFired = datasOnEvent.getPointIndex();
            }
        });
        chart.bind(new DataUnHighlightEvent() {

            @Override
            public void onEvent(SimpleEventObject datasOnEvent) {
                datasTable.getRowFormatter().getElement(lastIndexFired + 1).getStyle().setBackgroundColor("transparent");
                datasTable.getRowFormatter().getElement(lastIndexFired + 1).getStyle().setColor("white");
                datasTable.getRowFormatter().getElement(lastIndexFired + 1).getStyle().setFontWeight(FontWeight.NORMAL);
            }
        });

        chart.bind(new DataClickEvent() {

            @Override
            public void onEvent(EventObject datasOnEvent) {
                datasTable.setText(values.size() + 2, 0, "Click");
                datasTable.setText(values.size() + 2, 1, datasOnEvent.toString());
            }
        });

        chart.bind(new DataRightClickEvent() {

            @Override
            public void onEvent(SimpleEventObject datasOnEvent) {
                datasTable.setText(values.size() + 2, 0, "RightClick");
                datasTable.setText(values.size() + 2, 1, datasOnEvent.toString());
            }
        });
        int i = 1;
        for (BubbleValue bubble : values) {
            datasTable.setText(i, 0, bubble.getLabel());
            datasTable.setText(i, 1, bubble.getWidth().toString());
            i += 1;
        }

        datasTable.getRowFormatter().setStyleName(0, "gwt-DataTableTitle");
        datasTable.addStyleName("gwt-DataTable");
        datasTable.setWidth("100%");

        add(chart);
        add(datasTable);
        setCellWidth(datasTable, "100%");
    }
}
