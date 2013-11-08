/*
 * File: $URL: svn+ssh://chimay/home/svn/VkGraph-showcase/VkGraph-showcase/src/main/java/fr.vekia.tools.showcase.vkgraph/client/showcase/application/components/menu/groups/interactive/screens/LineInteractiveWidgetScreen.java $
 * $Id: LineInteractiveWidgetScreen.java 37 2012-08-22 16:29:14Z svandecappelle $
 * Licence MIT
 *
 * Last change:
 * $Date: 2012-08-22 18:29:14 +0200 (mer., 22 août 2012) $
 * $Author: svandecappelle $
 */
package fr.vekia.tools.showcase.vkgraph.client.showcase.application.demo.screens.interactives;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;

import fr.vekia.VkGraph.client.charts.LineChart;
import fr.vekia.VkGraph.client.charts.events.DataClickEvent;
import fr.vekia.VkGraph.client.charts.events.EditedDataEvent;
import fr.vekia.VkGraph.client.charts.events.EventObject;
import fr.vekia.VkGraph.client.datas.OptionSerie;
import fr.vekia.VkGraph.client.datas.SeriesData;
import fr.vekia.VkGraph.client.options.ChartOption;
import fr.vekia.VkGraph.client.options.SubOption;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 17 août 2012. VklGraph version 1.2
 * @version 2.1
 * 
 *          {@inheritDoc}
 */
public class LineInteractiveWidgetScreen extends HorizontalPanel {
    private Label eventTypeLabel;
    private Label eventDataLabelSerie;
    private Label eventDataLabelPoint;
    private Label eventDataLabelValue;

    /**
     * Default constructor
     * 
     */
    public LineInteractiveWidgetScreen() {
	eventTypeLabel = new Label();
	eventDataLabelSerie = new Label();
	eventDataLabelPoint = new Label();
	eventDataLabelValue = new Label();

	LineChart<Number> chart = new LineChart<Number>();

	List<Number> datas = new ArrayList<Number>();
	datas.add(5);
	datas.add(17);
	datas.add(9);
	datas.add(11);
	datas.add(10);
	datas.add(15);
	datas.add(17);
	datas.add(14);
	datas.add(12);
	datas.add(10);
	datas.add(8);
	datas.add(12);
	chart.setListView(true);
	chart.setDatas(datas);

	chart.bind(new DataClickEvent() {

	    @Override
	    public void onEvent(EventObject datasOnEvent) {
		eventTypeLabel.setText("click");
		eventDataLabelSerie.setText("Serie: " + datasOnEvent.getSeriesIndex());
		eventDataLabelPoint.setText("Point index: " + datasOnEvent.getPointIndex());
		eventDataLabelValue.setText("value:" + datasOnEvent.getValue());
	    }
	});

	chart.bind(new EditedDataEvent() {

	    @Override
	    public void onEvent(EventObject datasOnEvent) {
		eventTypeLabel.setText("drag");
		eventDataLabelSerie.setText("Serie: " + datasOnEvent.getSeriesIndex());
		eventDataLabelPoint.setText("Point index: " + datasOnEvent.getPointIndex());
		eventDataLabelValue.setText("value:" + datasOnEvent.getValue());
	    }
	});

	chart.setTextOption(ChartOption.seriesDefaults, SubOption.dragable, SubOption.constrainTo, "y");
	chart.setBooleanOption(ChartOption.animate, true);
	chart.setBooleanOption(ChartOption.seriesDefaults, SubOption.rendererOptions, SubOption.smooth, true);

	chart.setPluginsEnable(true);

	add(chart);
	FlexTable dataTable = new FlexTable();
	dataTable.setWidth("100%");
	add(dataTable);
	setCellWidth(dataTable, "100%");
	dataTable.getRowFormatter().setStyleName(0, "gwt-DataTableTitle");
	dataTable.setWidget(0, 0, new Label("Event fired: "));
	dataTable.setWidget(0, 1, eventTypeLabel);
	dataTable.setWidget(0, 2, new Label("Event data: "));
	dataTable.setWidget(0, 3, eventDataLabelSerie);
	dataTable.setWidget(1, 3, eventDataLabelPoint);
	dataTable.setWidget(2, 3, eventDataLabelValue);

	eventTypeLabel.setStylePrimaryName("gwt-ImportantLabel");
	eventDataLabelSerie.setStylePrimaryName("gwt-ImportantLabel");
	eventDataLabelPoint.setStylePrimaryName("gwt-ImportantLabel");
	eventDataLabelValue.setStylePrimaryName("gwt-ImportantLabel");

	dataTable.addStyleName("gwt-DataTable");

	dataTable.getFlexCellFormatter().setColSpan(0, 0, 4);

	SeriesData dataserie = new SeriesData();
	OptionSerie serie1 = new OptionSerie();

	serie1.setTextOption(SubOption.dragable, SubOption.constrainTo, "y");
	serie1.setBooleanOption(SubOption.showMarker, false);

	dataserie.set(0, serie1);

	chart.setSeriesOptions(dataserie);

	chart.setResizable(true);
    }
}
