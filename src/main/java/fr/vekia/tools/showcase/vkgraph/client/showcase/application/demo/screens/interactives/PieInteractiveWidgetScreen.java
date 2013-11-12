/*
 * File: $URL: svn+ssh://chimay/home/svn/VkGraph-showcase/VkGraph-showcase/src/main/java/fr.vekia.tools.showcase.vkgraph/client/showcase/application/components/menu/groups/interactive/screens/PieInteractiveWidgetScreen.java $
 * $Id: PieInteractiveWidgetScreen.java 52 2012-09-26 15:26:35Z svandecappelle $
 * Licence MIT
 *
 * Last change:
 * $Date: 2012-09-26 17:26:35 +0200 (mer., 26 sept. 2012) $
 * $Author: svandecappelle $
 */
package fr.vekia.tools.showcase.vkgraph.client.showcase.application.demo.screens.interactives;

import java.util.List;

import com.google.gwt.dom.client.Style.FontWeight;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HorizontalPanel;

import fr.vekia.VkGraph.client.charts.PieChart;
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
		pieChart.setBooleanOption(ChartOption.seriesDefaults,
				SubOption.rendererOptions, SubOption.showDataLabels, true);

		pieChart.setBooleanOption(ChartOption.legend, SubOption.show, true);
		pieChart.setTextOption(ChartOption.legend, SubOption.placement,
				"outsideGrid");
		pieChart.setTextOption(ChartOption.legend, SubOption.location, "s");
		pieChart.setOption(ChartOption.legend, SubOption.renderer,
				RenderersEnum.EnhancedLegendRenderer.getValueRenderer());
		pieChart.setNumberOption(ChartOption.legend, SubOption.rendererOptions,
				SubOption.numberColumns, 5);

		final FlexTable datasTable = new FlexTable();
		datasTable.setText(0, 0, "Region");
		datasTable.setText(0, 1, "Population");
		datasTable.setText(values.size() + 1, 0, "LastFiredEvent");
		datasTable.setText(values.size() + 1, 1, "EventValue");

		pieChart.bind(new DataHighlightEvent() {

			@Override
			public void onEvent(EventObject datasOnEvent) {
				datasTable.getRowFormatter().getElement(lastIndexFired + 1)
						.getStyle().setBackgroundColor("transparent");
				datasTable.getRowFormatter().getElement(lastIndexFired + 1)
						.getStyle().setColor("white");
				datasTable.getRowFormatter().getElement(lastIndexFired + 1)
						.getStyle().setFontWeight(FontWeight.NORMAL);

				datasTable.getRowFormatter()
						.getElement(datasOnEvent.getPointIndex() + 1)
						.getStyle().setBackgroundColor("black");
				datasTable.getRowFormatter()
						.getElement(datasOnEvent.getPointIndex() + 1)
						.getStyle().setColor("aliceblue");
				datasTable.getRowFormatter()
						.getElement(datasOnEvent.getPointIndex() + 1)
						.getStyle().setFontWeight(FontWeight.BOLD);
				lastIndexFired = datasOnEvent.getPointIndex();
			}
		});
		pieChart.bind(new DataUnHighlightEvent() {

			@Override
			public void onEvent(SimpleEventObject datasOnEvent) {
				datasTable.getRowFormatter().getElement(lastIndexFired + 1)
						.getStyle().setBackgroundColor("transparent");
				datasTable.getRowFormatter().getElement(lastIndexFired + 1)
						.getStyle().setColor("white");
				datasTable.getRowFormatter().getElement(lastIndexFired + 1)
						.getStyle().setFontWeight(FontWeight.NORMAL);
			}
		});

		pieChart.bind(new DataClickEvent() {

			@Override
			public void onEvent(EventObject datasOnEvent) {
				datasTable.setText(values.size() + 2, 0, "Click");
				datasTable.setText(values.size() + 2, 1,
						datasOnEvent.toString());
			}
		});

		// The JqPlot event doesn't seems to work
		pieChart.bind(new DataRightClickEvent() {

			@Override
			public void onEvent(SimpleEventObject datasOnEvent) {
				datasTable.setText(values.size() + 2, 0, "RightClick");
				datasTable.setText(values.size() + 2, 1,
						datasOnEvent.toString());
			}
		});
		int i = 1;
		for (DualValue dataNumber : values) {
			datasTable.setText(i, 0, dataNumber.getKey());
			datasTable.setText(i, 1, dataNumber.getValue().toString());
			i += 1;
		}
		datasTable.addStyleName("gwt-DataTable");
		datasTable.getRowFormatter().setStyleName(values.size() + 2,
				"gwt-ImportantLabel");
		datasTable.getRowFormatter().setStyleName(0, "gwt-DataTableTitle");
		datasTable.getRowFormatter().setStyleName(values.size() + 1,
				"gwt-DataTableTitle");

		pieChart.setListView(true);
		add(pieChart);
		add(datasTable);
		pieChart.setResizable(true);

		datasTable.setWidth("100%");
		setCellWidth(datasTable, "100%");
	}
}
