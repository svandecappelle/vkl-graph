/*
 * File: $URL: svn+ssh://chimay/home/svn/VkGraph-showcase/VkGraph-showcase/src/main/java/fr.vekia.tools.showcase.vkgraph/client/showcase/application/components/menu/groups/interactive/screens/DonutInteractiveWidgetScreen.java $
 * $Id: DonutInteractiveWidgetScreen.java 52 2012-09-26 15:26:35Z svandecappelle $
 * Licence MIT
 *
 * Last change:
 * $Date: 2012-09-26 17:26:35 +0200 (mer., 26 sept. 2012) $
 * $Author: svandecappelle $
 */
package fr.vekia.tools.showcase.vkgraph.client.showcase.application.demo.screens.interactives;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.dom.client.Style;
import com.google.gwt.dom.client.Style.FontWeight;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HorizontalPanel;

import fr.vekia.VkGraph.client.charts.Donut;
import fr.vekia.VkGraph.client.charts.RenderersEnum;
import fr.vekia.VkGraph.client.charts.events.DataClickEvent;
import fr.vekia.VkGraph.client.charts.events.DataHighlightEvent;
import fr.vekia.VkGraph.client.charts.events.DataRightClickEvent;
import fr.vekia.VkGraph.client.charts.events.DataUnHighlightEvent;
import fr.vekia.VkGraph.client.charts.events.EventObject;
import fr.vekia.VkGraph.client.charts.events.SimpleEventObject;
import fr.vekia.VkGraph.client.datas.DualValue;
import fr.vekia.VkGraph.client.options.ChartOption;
import fr.vekia.VkGraph.client.options.SubOption;
import fr.vekia.tools.showcase.vkgraph.client.showcase.application.demo.DataFactory;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 17 août 2012. VklGraph version 1.2
 * @version 2.1
 * 
 *          {@inheritDoc}
 */
public class DonutInteractiveWidgetScreen extends HorizontalPanel {
    private final List<List<DualValue>> values;

    private static final int NORTH_REGION_COUNT = 3;
    private static final int SOUTH_REGION_COUNT = 6;
    private static final int EAST_REGION_COUNT = 3;
    private static final int WEST_REGION_COUNT = 4;
    private static final int CENTER_REGION_COUNT = 6;

    private List<Integer> highlightIdx;

    /**
     * Default constructor
     * 
     */
    public DonutInteractiveWidgetScreen() {
	highlightIdx = new ArrayList<Integer>();
	Donut<List<DualValue>> pieChart = new Donut<List<DualValue>>();
	pieChart.setSize("1000px", "800px");
	values = DataFactory.getListOfListOfDualValues();
	pieChart.setDatas(values);

	pieChart.setNumberOption(ChartOption.seriesDefaults, SubOption.rendererOptions, SubOption.sliceMargin, 3);
	pieChart.setNumberOption(ChartOption.seriesDefaults, SubOption.rendererOptions, SubOption.startAngle, 3);
	pieChart.setBooleanOption(ChartOption.seriesDefaults, SubOption.rendererOptions, SubOption.showDataLabels, true);
	// pieChart.setBooleanOption(ChartOption.seriesDefaults, SubOption.rendererOptions, SubOption.highlightMouseOver, false);

	pieChart.setBooleanOption(ChartOption.legend, SubOption.show, true);
	pieChart.setTextOption(ChartOption.legend, SubOption.placement, "outsideGrid");
	pieChart.setTextOption(ChartOption.legend, SubOption.location, "s");
	pieChart.setOption(ChartOption.legend, SubOption.renderer, RenderersEnum.EnhancedLegendRenderer.getValueRenderer());
	pieChart.setNumberOption(ChartOption.legend, SubOption.rendererOptions, SubOption.numberColumns, 5);

	final FlexTable datasTable = new FlexTable();
	datasTable.setText(0, 0, "Region");
	datasTable.setText(0, 1, "Population");
	datasTable.setText(values.get(1).size() + 1, 0, "LastFiredEvent");
	datasTable.setText(values.get(1).size() + 1, 1, "EventValue");

	pieChart.bind(new DataHighlightEvent() {

	    @Override
	    public void onEvent(EventObject datasOnEvent) {
		removeStyleToGrid(datasTable);
		int pointIdx = datasOnEvent.getPointIndex() + 1;
		if (datasOnEvent.getSeriesIndex() == 1) {
		    applyStyleToGrid(datasTable, pointIdx);
		} else {
		    applyStyleToGrid(datasTable, datasOnEvent.getValue());
		}
	    }

	});
	pieChart.bind(new DataUnHighlightEvent() {

	    @Override
	    public void onEvent(SimpleEventObject datasOnEvent) {
		removeStyleToGrid(datasTable);
	    }
	});

	pieChart.bind(new DataClickEvent() {

	    @Override
	    public void onEvent(EventObject datasOnEvent) {
		datasTable.setText(values.get(1).size() + 2, 0, "Click");
		datasTable.setText(values.get(1).size() + 2, 1, datasOnEvent.toString());
		int pointIdx = datasOnEvent.getPointIndex() + 1;
		removeStyleToGrid(datasTable);
		if (datasOnEvent.getSeriesIndex() == 1) {
		    applyStyleToGrid(datasTable, pointIdx);
		} else {
		    applyStyleToGrid(datasTable, datasOnEvent.getValue());
		}
	    }
	});

	// The JqPlot event doesn't seems to work
	pieChart.bind(new DataRightClickEvent() {

	    @Override
	    public void onEvent(SimpleEventObject datasOnEvent) {
		datasTable.setText(values.get(1).size() + 2, 0, "RightClick");
		datasTable.setText(values.get(1).size() + 2, 1, datasOnEvent.toString());
	    }
	});
	int i = 1;
	List<DualValue> regions = values.get(1);

	for (DualValue dataNumber : regions) {
	    datasTable.setText(i, 0, dataNumber.getKey());
	    datasTable.setText(i, 1, dataNumber.getValue().toString());
	    i += 1;
	}
	datasTable.addStyleName("gwt-DataTable");
	datasTable.getRowFormatter().setStyleName(regions.size() + 1, "gwt-DataTableTitle");
	datasTable.getRowFormatter().setStyleName(0, "gwt-DataTableTitle");
	datasTable.getRowFormatter().setStyleName(regions.size() + 2, "gwt-ImportantLabel");
	datasTable.setWidth("100%");
	
	
	pieChart.setListView(true);
	add(pieChart);
	add(datasTable);
	setCellWidth(datasTable, "100%");
	pieChart.setResizable(true);
    }

    private void applyStyleToGrid(final FlexTable table, final int pointIdx) {
	table.getRowFormatter().getElement(pointIdx).getStyle().setBackgroundColor("black");
	table.getRowFormatter().getElement(pointIdx).getStyle().setColor("aliceblue");
	table.getRowFormatter().getElement(pointIdx).getStyle().setFontWeight(FontWeight.BOLD);
	highlightIdx.add(pointIdx);
    }

    private void applyStyleToGrid(final FlexTable table, final Object eventObjectFiredValue) {
	int nbRegionToApply = 0;
	int startIdx = 0;

	if (eventObjectFiredValue.toString().contains("North")) {
	    nbRegionToApply = NORTH_REGION_COUNT;
	    startIdx = 0;
	} else if (eventObjectFiredValue.toString().contains("Center")) {
	    nbRegionToApply = CENTER_REGION_COUNT;
	    startIdx = NORTH_REGION_COUNT;
	} else if (eventObjectFiredValue.toString().contains("South")) {
	    nbRegionToApply = SOUTH_REGION_COUNT;
	    startIdx = NORTH_REGION_COUNT + CENTER_REGION_COUNT;
	} else if (eventObjectFiredValue.toString().contains("East")) {
	    nbRegionToApply = EAST_REGION_COUNT;
	    startIdx = NORTH_REGION_COUNT + CENTER_REGION_COUNT + SOUTH_REGION_COUNT;
	} else if (eventObjectFiredValue.toString().contains("West")) {
	    nbRegionToApply = WEST_REGION_COUNT;
	    startIdx = NORTH_REGION_COUNT + CENTER_REGION_COUNT + SOUTH_REGION_COUNT + EAST_REGION_COUNT;
	}

	for (int i = startIdx; i < startIdx + nbRegionToApply; i++) {
	    applyStyleToGrid(table, i + 1);
	}

    }

    private void removeStyleToGrid(final FlexTable table) {
	for (Integer index : highlightIdx) {
	    Style style = table.getRowFormatter().getElement(index).getStyle();
	    style.setBackgroundColor("transparent");
	    style.setColor("white");
	    style.setFontWeight(FontWeight.NORMAL);
	}
	highlightIdx.clear();
    }
}
