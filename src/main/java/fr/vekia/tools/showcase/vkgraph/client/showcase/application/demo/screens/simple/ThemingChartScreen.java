/*
 * File: $URL: svn+ssh://chimay/home/svn/VkGraph-showcase/VkGraph-showcase/src/main/java/fr.vekia.tools.showcase.vkgraph/client/showcase/application/components/menu/groups/plots/screens/ThemingChartScreen.java $
 * $Id: ThemingChartScreen.java 52 2012-09-26 15:26:35Z svandecappelle $
 * Licence MIT
 *
 * Last change:
 * $Date: 2012-09-26 17:26:35 +0200 (mer., 26 sept. 2012) $
 * $Author: svandecappelle $
 */
package fr.vekia.tools.showcase.vkgraph.client.showcase.application.demo.screens.simple;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Random;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

import fr.vekia.VkGraph.client.charts.Donut;
import fr.vekia.VkGraph.client.charts.LineChart;
import fr.vekia.VkGraph.client.charts.PieChart;
import fr.vekia.VkGraph.client.datas.DualValue;
import fr.vekia.VkGraph.client.options.ChartOption;
import fr.vekia.VkGraph.client.options.SubOption;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 14 août 2012. VklGraph version 1.2
 * @version 2.1
 * 
 *          {@inheritDoc}
 */
public class ThemingChartScreen extends SimplePanel {

    final LineChart<List<DualValue>> first;
    final PieChart<List<DualValue>> second;
    final Donut<List<DualValue>> third;

    /**
     * Default constructor
     * 
     */
    public ThemingChartScreen() {

	// FIRST CHART LINE CHART;
	first = new LineChart<List<DualValue>>();
	List<List<DualValue>> values = new ArrayList<List<DualValue>>();

	for (int i = 0; i < 10; i++) {
	    ArrayList<DualValue> valuesLineOne = new ArrayList<DualValue>();
	    for (int j = 1; j < 30; j++) {
		valuesLineOne.add(new DualValue(j, 100 + Random.nextInt(11)));
	    }
	    values.add(valuesLineOne);
	}
	first.setSize("1200px", "800px");

	first.setDatas(values);
	first.setNumberOption(ChartOption.axes, SubOption.yaxis, SubOption.min, 90);
	first.setBooleanOption(ChartOption.seriesDefaults, SubOption.showMarker, false);
	first.setBooleanOption(ChartOption.seriesDefaults, SubOption.rendererOptions, SubOption.showDataLabels, true);
	first.setTextOption(ChartOption.title, SubOption.text, "Line Chart");
	first.setBooleanOption(ChartOption.legend, SubOption.show, true);

	// SECOND CHART PIE CHART;
	second = new PieChart<List<DualValue>>();
	ArrayList<DualValue> valuesPiesSeries = new ArrayList<DualValue>();
	for (int i = 0; i < 10; i++) {
	    valuesPiesSeries.add(new DualValue(i, Random.nextInt(50)));
	}
	List<List<DualValue>> valuesPie = new ArrayList<List<DualValue>>();
	valuesPie.add(valuesPiesSeries);
	second.setDatas(valuesPie);

	second.setBooleanOption(ChartOption.seriesDefaults, SubOption.rendererOptions, SubOption.showDataLabels, true);
	second.setBooleanOption(ChartOption.seriesDefaults, SubOption.showMarker, true);
	second.setTextOption(ChartOption.title, SubOption.text, "Pie Chart");
	second.setBooleanOption(ChartOption.legend, SubOption.show, true);
	second.setSize("1200px", "800px");
	second.setBooleanOption(ChartOption.cursor, SubOption.showTooltip, true);

	// THIRD CHART DONUT CHART;
	third = new Donut<List<DualValue>>();
	ArrayList<DualValue> valuesDonutSeries = new ArrayList<DualValue>();
	for (int i = 0; i < 10; i++) {
	    valuesDonutSeries.add(new DualValue(i, Random.nextInt(50)));
	}
	List<List<DualValue>> valuesDonut = new ArrayList<List<DualValue>>();
	valuesDonut.add(valuesDonutSeries);
	third.setDatas(valuesDonut);

	third.setBooleanOption(ChartOption.seriesDefaults, SubOption.rendererOptions, SubOption.showDataLabels, true);
	third.setBooleanOption(ChartOption.seriesDefaults, SubOption.showMarker, true);
	third.setTextOption(ChartOption.title, SubOption.text, "Donut Chart");
	third.setBooleanOption(ChartOption.legend, SubOption.show, true);
	third.setSize("1200px", "800px");
	third.setBooleanOption(ChartOption.cursor, SubOption.showTooltip, true);

	VerticalPanel container = new VerticalPanel();

	container.add(getFlexTableThemeCreator());
	container.add(first);
	container.add(second);
	container.add(third);

	setWidget(container);

    }

    private IsWidget getFlexTableThemeCreator() {
	FlexTable table = new FlexTable();
	table.setStyleName("gwt-DataTable");
	table.setSize("100%", "100%");

	final List<TextBox> colors = new ArrayList<TextBox>();

	final TextBox themeNameBox = new TextBox();
	themeNameBox.setText(DOM.createUniqueId());
	int row = 0;

	table.setText(0, 0, "theme name");
	table.setWidget(0, 1, themeNameBox);
	table.getRowFormatter().setStyleName(row, "gwt-DataTableTitle");
	row++;
	table.setText(1, 0, "Property");
	table.setText(1, 1, "Value");
	table.getRowFormatter().setStyleName(row, "gwt-DataTableTitle");
	row++;
	final TextBox backgroundGridColorBox = new TextBox();
	table.setText(row, 0, "Background Grid");
	table.setWidget(row, 1, backgroundGridColorBox);
	backgroundGridColorBox.addValueChangeHandler(new ValueChangeHandler<String>() {

	    @Override
	    public void onValueChange(ValueChangeEvent<String> event) {
		backgroundGridColorBox.getElement().getStyle().setBackgroundColor(backgroundGridColorBox.getText());
	    }
	});

	row++;

	for (int i = 0; i < 10; i++) {
	    final TextBox seriesColor = new TextBox();
	    table.setText(row, 0, "Serie " + (i + 1) + "color");
	    table.setWidget(row, 1, seriesColor);
	    colors.add(seriesColor);

	    seriesColor.addValueChangeHandler(new ValueChangeHandler<String>() {

		@Override
		public void onValueChange(ValueChangeEvent<String> event) {
		    seriesColor.getElement().getStyle().setBackgroundColor(seriesColor.getText());
		}
	    });
	    row++;
	}
	Button generate = new Button("Validate");
	generate.addClickHandler(new ClickHandler() {

	    @Override
	    public void onClick(ClickEvent event) {
		JSONObject grid = new JSONObject();
		JSONObject color = new JSONObject();
		color.put("backgroundColor", new JSONString(backgroundGridColorBox.getText()));
		grid.put("grid", color);

		JSONArray colorsArray = new JSONArray();

		int i = 0;
		for (TextBox widget : colors) {
		    if (!widget.getText().isEmpty()) {
			JSONObject colorSerie = new JSONObject();
			colorSerie.put("color", new JSONString(widget.getText()));
			colorsArray.set(i, colorSerie);
			i += 1;
		    }
		}
		grid.put("series", colorsArray);

		first.activateTheme(themeNameBox.getText(), grid.getJavaScriptObject());
	    }
	});
	row++;

	CheckBox checkBox = new CheckBox("Enable change default theme by right click");
	checkBox.addValueChangeHandler(new ValueChangeHandler<Boolean>() {

	    @Override
	    public void onValueChange(ValueChangeEvent<Boolean> event) {
		first.setThemingEnable(event.getValue());
		second.setThemingEnable(event.getValue());
		third.setThemingEnable(event.getValue());
	    }
	});
	table.setWidget(row, 0, checkBox);

	table.setWidget(row, 1, generate);

	return table;
    }
}
