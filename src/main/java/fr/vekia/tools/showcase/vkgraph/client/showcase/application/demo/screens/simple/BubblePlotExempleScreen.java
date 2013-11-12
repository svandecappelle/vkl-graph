/*
 * File: $URL: svn+ssh://chimay/home/svn/VkGraph-showcase/VkGraph-showcase/src/main/java/fr.vekia.tools.showcase.vkgraph/client/showcase/application/components/menu/groups/plots/screens/BubblePlotExempleScreen.java $
 * $Id: BubblePlotExempleScreen.java 52 2012-09-26 15:26:35Z svandecappelle $
 * Licence MIT
 *
 * Last change:
 * $Date: 2012-09-26 17:26:35 +0200 (mer., 26 sept. 2012) $
 * $Author: svandecappelle $
 */
package fr.vekia.tools.showcase.vkgraph.client.showcase.application.demo.screens.simple;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.client.GWT;

import fr.vekia.VkGraph.client.charts.BubbleChart;
import fr.vekia.VkGraph.client.charts.NumberType;
import fr.vekia.VkGraph.client.charts.RenderersEnum;
import fr.vekia.VkGraph.client.charts.events.DataHighlightEvent;
import fr.vekia.VkGraph.client.charts.events.EventObject;
import fr.vekia.VkGraph.client.datas.BubbleValue;
import fr.vekia.VkGraph.client.options.ChartOption;
import fr.vekia.VkGraph.client.options.SubOption;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 5 déc. 2011. GWTQuery Vekia Showcase
 * @version 1.0
 * 
 *          {@inheritDoc}
 */
public class BubblePlotExempleScreen extends BubbleChart {

	/**
	 * Default constructor
	 * 
	 */
	public BubblePlotExempleScreen() {

		List<BubbleValue> values = new ArrayList<BubbleValue>();

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

		super.setDatas(values);

		super.setRenderer(RenderersEnum.Bubble);
		super.setBooleanOption(ChartOption.seriesDefaults,
				SubOption.rendererOptions, SubOption.bubbleGradients, true);
		super.setNumberOption(ChartOption.seriesDefaults,
				SubOption.rendererOptions, SubOption.highlightAlpha, 0.8f,
				NumberType.FLOAT);
		super.setBooleanOption(ChartOption.seriesDefaults, SubOption.shadow,
				true);
		super.setNumberOption(ChartOption.seriesDefaults,
				SubOption.shadowAlpha, 0.05f, NumberType.FLOAT);
		super.bind(new DataHighlightEvent() {

			@Override
			public void onEvent(EventObject data) {
				GWT.log(data.toString());
			}
		});
		super.setThemingEnable(true);
	}
}
