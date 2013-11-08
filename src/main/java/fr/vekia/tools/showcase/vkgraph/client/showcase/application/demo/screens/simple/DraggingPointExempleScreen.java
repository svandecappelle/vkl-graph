/*
 * File: $URL: svn+ssh://chimay/home/svn/VkGraph-showcase/VkGraph-showcase/src/main/java/fr.vekia.tools.showcase.vkgraph/client/showcase/application/components/menu/groups/plots/screens/DraggingPointExempleScreen.java $
 * $Id: DraggingPointExempleScreen.java 43 2012-09-03 16:11:56Z svandecappelle $
 * Licence MIT
 * 
 * Last change:
 * $Date: 2012-09-03 18:11:56 +0200 (lun., 03 sept. 2012) $
 * $Author: svandecappelle $
 */
package fr.vekia.tools.showcase.vkgraph.client.showcase.application.demo.screens.simple;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.Random;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.InlineLabel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

import fr.vekia.VkGraph.client.charts.LineChart;
import fr.vekia.VkGraph.client.charts.events.EditedDataEvent;
import fr.vekia.VkGraph.client.charts.events.EventObject;
import fr.vekia.VkGraph.client.charts.menus.MenuCommands;
import fr.vekia.VkGraph.client.datas.OptionSerie;
import fr.vekia.VkGraph.client.datas.SeriesData;
import fr.vekia.VkGraph.client.options.ChartOption;
import fr.vekia.VkGraph.client.options.SubOption;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 28 mai 2012. GWTQuery Vekia Showcase
 * @version 1.0
 * 
 *          {@inheritDoc}
 */
public class DraggingPointExempleScreen extends SimplePanel {
    private LineChart<List<Number>> chart;

    /**
     * Default constructor
     * 
     */
    public DraggingPointExempleScreen() {

	VerticalPanel panel = new VerticalPanel();

	chart = new LineChart<List<Number>>();
	chart.setOption(ChartOption.title, "tutu");
	ArrayList<List<Number>> data = new ArrayList<List<Number>>();
	ArrayList<Number> dataLine1 = new ArrayList<Number>();
	ArrayList<Number> dataLine2 = new ArrayList<Number>();

	for (int i = 0; i < 10; i++) {
	    dataLine1.add(Random.nextInt(250));
	    dataLine2.add(dataLine1.get(i));
	}

	chart.setSize("1200px", "660px");

	data.add(dataLine1);
	data.add(dataLine2);

	chart.setDatas(data);
	chart.setExportEnable(true);
	chart.setRefreshManuallyEnable(true);
	chart.setTextOption(ChartOption.grid, SubOption.background, "white");
	chart.setBooleanOption(ChartOption.cursor, SubOption.show, true);

	SeriesData dataserie = new SeriesData();
	OptionSerie serie1 = new OptionSerie();
	OptionSerie serie2 = new OptionSerie();

	serie1.setBooleanOption(SubOption.isDragable, false);
	serie1.setBooleanOption(SubOption.trendline, SubOption.show, false);
	serie1.setBooleanOption(SubOption.showMarker, false);

	serie2.setTextOption(SubOption.dragable, SubOption.constrainTo, "y");
	serie2.setBooleanOption(SubOption.trendline, SubOption.show, true);

	dataserie.set(0, serie1);
	dataserie.set(1, serie2);

	List<String> colors = new ArrayList<String>();
	colors.add("rgba(255, 0, 0,0.4)");
	colors.add("rgba(78, 135, 194, 0.7)");

	chart.setColors(colors);
	chart.setPluginsEnable(true);
	chart.setSeriesOptions(dataserie);

	chart.bind(new EditedDataEvent() {

	    @Override
	    public void onEvent(EventObject datasOnEvent) {
		GWT.log("edited value: [" + datasOnEvent.getSeriesIndex() + "-" + datasOnEvent.getPointIndex() + "] - {" + datasOnEvent.getValue() + "}");
	    }
	});

	HorizontalPanel editorPanel = new HorizontalPanel();
	editorPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
	editorPanel.add(new InlineLabel("Background color: "));

	final TextBox gridAttribute = new TextBox();
	gridAttribute.setText("white");

	final Button replotCheckBox = new Button("New random");

	chart.addToRightClickMenu(new MenuCommands("Custom command") {

	    @Override
	    public void execute() {
		Window.alert("A custom command fired");
	    }
	});
	chart.setThemingEnable(true);
	replotCheckBox.addClickHandler(new ClickHandler() {

	    @Override
	    public void onClick(ClickEvent event) {
		List<List<Number>> dataReploted = new ArrayList<List<Number>>();

		List<Number> dataLineIdx1 = new ArrayList<Number>();
		List<Number> dataLineIdx2 = new ArrayList<Number>();

		for (int i = 0; i < 10; i++) {
		    dataLineIdx1.add(Random.nextInt(250));
		    dataLineIdx2.add(Random.nextInt(250));
		}
		dataReploted.add(dataLineIdx1);
		dataReploted.add(dataLineIdx2);

		DraggingPointExempleScreen.this.chart.setDatas(dataReploted);
		DraggingPointExempleScreen.this.chart.replot();
	    }
	});

	editorPanel.add(gridAttribute);
	editorPanel.add(replotCheckBox);

	gridAttribute.addValueChangeHandler(new ValueChangeHandler<String>() {

	    @Override
	    public void onValueChange(ValueChangeEvent<String> event) {

		DraggingPointExempleScreen.this.chart.setTextOption(ChartOption.series, SubOption.color, gridAttribute.getText());
		DraggingPointExempleScreen.this.chart.replot();
	    }
	});

	panel.add(new HTML("<h2>Try to right clic on the chart. And Change the theme on the available selection.</h2>"));
	panel.add(chart);
	panel.add(editorPanel);
	setWidget(panel);
    }

}