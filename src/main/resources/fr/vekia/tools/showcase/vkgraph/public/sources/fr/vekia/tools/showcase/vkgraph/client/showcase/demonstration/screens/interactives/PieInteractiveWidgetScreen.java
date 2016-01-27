package fr.vekia.tools.showcase.vkgraph.client.showcase.demonstration.screens.interactives;

import java.util.List;

import com.google.gwt.dom.client.Style.FontWeight;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HorizontalPanel;

import fr.vekia.tools.showcase.vkgraph.client.showcase.demonstration.DataFactory;
import fr.vekia.vkgraph.client.charts.PieChart;
import fr.vekia.vkgraph.client.charts.RenderersEnum;
import fr.vekia.vkgraph.client.charts.events.DataClickEvent;
import fr.vekia.vkgraph.client.charts.events.DataHighlightEvent;
import fr.vekia.vkgraph.client.charts.events.DataRightClickEvent;
import fr.vekia.vkgraph.client.charts.events.DataUnHighlightEvent;
import fr.vekia.vkgraph.client.charts.events.EventObject;
import fr.vekia.vkgraph.client.charts.events.SimpleEventObject;
import fr.vekia.vkgraph.client.datas.DualValue;
import fr.vekia.vkgraph.client.options.ChartOption;
import fr.vekia.vkgraph.client.options.SubOption;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 17 août 2012. VklGraph version 1.2
 * @version 2.1
 */
public class PieInteractiveWidgetScreen extends HorizontalPanel {
    private int lastIndexFired;

    /**
     * Default constructor
     * 
     */
    public PieInteractiveWidgetScreen() {

        final PieChart<DualValue> pieChart = new PieChart<DualValue>();
        pieChart.setWidth("900px");
        final List<DualValue> values = DataFactory.getListOfDualValues();
        pieChart.setDatas(values);
        pieChart.setBooleanOption(ChartOption.seriesDefaults, SubOption.rendererOptions, SubOption.showDataLabels, true);

        pieChart.setBooleanOption(ChartOption.legend, SubOption.show, true);
        pieChart.setTextOption(ChartOption.legend, SubOption.placement, "outsideGrid");
        pieChart.setTextOption(ChartOption.legend, SubOption.location, "s");
        pieChart.setOption(ChartOption.legend, SubOption.renderer, RenderersEnum.EnhancedLegendRenderer.getValueRenderer());
        pieChart.setNumberOption(ChartOption.legend, SubOption.rendererOptions, SubOption.numberColumns, 5);

        final FlexTable datasTable = new FlexTable();
        datasTable.addStyleName("gwt-DataTable");
        datasTable.setText(0, 0, "Region");
        datasTable.setText(0, 1, "Population");
        datasTable.setText(values.size() + 1, 0, "LastFiredEvent");
        datasTable.setText(values.size() + 1, 1, "EventValue");

        pieChart.bind(new DataHighlightEvent() {

            @Override
            public void onEvent(EventObject datasOnEvent) {
                datasTable.getRowFormatter().getElement(lastIndexFired + 1).getStyle().setBackgroundColor("transparent");
                datasTable.getRowFormatter().getElement(lastIndexFired + 1).getStyle().setColor("black");
                datasTable.getRowFormatter().getElement(lastIndexFired + 1).getStyle().setFontWeight(FontWeight.NORMAL);

                lastIndexFired = datasOnEvent.getPointIndex();
                datasTable.getRowFormatter().getElement(datasOnEvent.getPointIndex() + 1).getStyle().setBackgroundColor("black");
                datasTable.getRowFormatter().getElement(datasOnEvent.getPointIndex() + 1).getStyle().setColor("aliceblue");
                datasTable.getRowFormatter().getElement(datasOnEvent.getPointIndex() + 1).getStyle().setFontWeight(FontWeight.BOLD);

            }
        });
        pieChart.bind(new DataUnHighlightEvent() {

            @Override
            public void onEvent(SimpleEventObject datasOnEvent) {
                datasTable.getRowFormatter().getElement(lastIndexFired + 1).getStyle().setBackgroundColor("transparent");
                datasTable.getRowFormatter().getElement(lastIndexFired + 1).getStyle().setColor("black");
                datasTable.getRowFormatter().getElement(lastIndexFired + 1).getStyle().setFontWeight(FontWeight.NORMAL);
            }
        });

        pieChart.bind(new DataClickEvent() {

            @Override
            public void onEvent(EventObject datasOnEvent) {
                datasTable.setText(values.size() + 2, 0, "Click");
                datasTable.setText(values.size() + 2, 1, datasOnEvent.toString());
            }
        });

        // The JqPlot event doesn't seems to work
        pieChart.bind(new DataRightClickEvent() {

            @Override
            public void onEvent(SimpleEventObject datasOnEvent) {
                datasTable.setText(values.size() + 2, 0, "RightClick");
                datasTable.setText(values.size() + 2, 1, datasOnEvent.toString());
            }
        });
        int i = 1;
        for (DualValue dataNumber : values) {
            datasTable.setText(i, 0, dataNumber.getKey());
            datasTable.setText(i, 1, dataNumber.getValue().toString());

            datasTable.getCellFormatter().setStyleName(i, 0, "gwt-ImportantLabel");
            i += 1;
        }
        datasTable.addStyleName("gwt-DataTable");
        datasTable.getRowFormatter().setStyleName(0, "gwt-DataTableTitle");

        pieChart.setListView(true);
        add(pieChart);
        add(datasTable);
        pieChart.setResizable(true);

        datasTable.setWidth("100%");
        setCellWidth(datasTable, "100%");
    }
}
