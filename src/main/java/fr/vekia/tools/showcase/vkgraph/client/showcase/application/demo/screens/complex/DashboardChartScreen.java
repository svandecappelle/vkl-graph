/*
 * File: $URL: svn+ssh://chimay/home/svn/VkGraph-showcase/VkGraph-showcase/src/main/java/fr.vekia.tools.showcase.vkgraph/client/showcase/application/components/menu/groups/complex/screens/DashboardChartScreen.java $
 * $Id: DashboardChartScreen.java 32 2012-08-16 07:22:14Z svandecappelle $
 * Licence MIT
 *
 * Last change:
 * $Date: 2012-08-16 09:22:14 +0200 (jeu., 16 août 2012) $
 * $Author: svandecappelle $
 */
package fr.vekia.tools.showcase.vkgraph.client.showcase.application.demo.screens.complex;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gwt.user.client.Random;
import com.google.gwt.user.datepicker.client.CalendarUtil;

import fr.vekia.VkGraph.client.charts.RenderersEnum;
import fr.vekia.VkGraph.client.charts.derive.DashboardChart;
import fr.vekia.VkGraph.client.datas.DualValue;
import fr.vekia.VkGraph.client.datas.OptionSerie;
import fr.vekia.VkGraph.client.datas.SeriesData;
import fr.vekia.VkGraph.client.options.ChartOption;
import fr.vekia.VkGraph.client.options.SubOption;

import fr.vekia.VkGraph.client.datas.Rectangle;
import fr.vekia.VkGraph.client.datas.CanvasOverlayObject;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 27 juil. 2012. VklGraph version 1.2
 * @version 2.1
 * 
 *          {@inheritDoc}
 */
public class DashboardChartScreen extends DashboardChart<List<DualValue>> {

	/**
	 * Default constructor
	 * 
	 */
	public DashboardChartScreen() {

		// Datas chart
		List<List<DualValue>> dataLines = new ArrayList<List<DualValue>>();

		// Date xaxis
		List<Date> dates = new ArrayList<Date>();
		for (int i = 0; i < 50; i++) {
			Date date = new Date();
			CalendarUtil.addDaysToDate(date, i);
			dates.add(date);
		}

		// #############
		// ### Datas ###
		// #############

		List<DualValue> data1 = new ArrayList<DualValue>();

		// line 1
		for (Date dateXaxis : dates) {
			data1.add(new DualValue(dateXaxis.getTime(), Random.nextInt(10) + 1));
		}
		// line 2
		List<DualValue> data2 = new ArrayList<DualValue>();
		for (DualValue dualValue : data1) {
			data2.add(new DualValue(dualValue.getKeyNumber(), dualValue
					.getValue().intValue() + 1 + Random.nextInt(10)));
		}

		dataLines.add(data1);
		dataLines.add(data2);

		// Graph instances
		super.setData(dataLines);
		super.setTitle("Exemple of dashboard");
		super.setBackgroundColor("rgba(57,57,57,1.0)");

		// ##############
		// ### series ###
		// ##############
		SeriesData series = new SeriesData();

		OptionSerie serie1 = new OptionSerie();
		serie1.setBooleanOption(SubOption.fill, true);
		serie1.setTextOption(SubOption.label, "Serie 1");

		OptionSerie serie2 = new OptionSerie();
		serie2.setTextOption(SubOption.label, "Serie 2");

		series.set(0, serie1);
		series.set(1, serie2);
		super.setSeries(series);

		super.setXFormat("%b %e");
		super.setYFormat("$%'d");

		// xaxis
		super.setXaxisRenderer(RenderersEnum.DateAxis);
		// yaxis
		super.setYaxisRenderer(RenderersEnum.LogAxis);

		super.drawXGrid(true);
		super.drawYGrid(true);
		super.setExportEnable(true);


		CanvasOverlayObject objectsCanvas = new CanvasOverlayObject();
		Rectangle rect  = new Rectangle();
		rect.setTextOption(SubOption.xmin, "2014-06-27 05:00:00");
		rect.setTextOption(SubOption.xmax, "2014-07-07 05:00:00");

		rect.setNumberOption(SubOption.ymin, 2);
		rect.setNumberOption(SubOption.ymax, 15);

		rect.setTextOption(SubOption.color, "rgb(100, 55, 124)");
		rect.setBooleanOption(SubOption.showTooltip, true);
		rect.setTextOption(SubOption.tooltipFormatString, "<b><i><span style='color:red;''>Test2</span></i></b>");
		rect.setTextOption(SubOption.tooltipLocation, "s");
		rect.setTextOption(SubOption.xformat, "date");

		objectsCanvas.addObject(rect);
		super.setCanvasOverlay(objectsCanvas);
	}

}
