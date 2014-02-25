/*
 * File: $URL: svn+ssh://chimay/home/svn/VkGraph-showcase/VkGraph-showcase/src/main/java/fr.vekia.tools.showcase.vkgraph/client/showcase/application/components/menu/groups/plots/screens/SimplePlotScreen.java $
 * $Id: SimplePlotScreen.java 45 2012-09-07 07:35:41Z svandecappelle $
 * Licence MIT
 * 
 * Last change:
 * $Date: 2012-09-07 09:35:41 +0200 (ven., 07 sept. 2012) $
 * $Author: svandecappelle $
 */
package fr.vekia.tools.showcase.vkgraph.client.showcase.application.demo.screens.simple;

import java.util.ArrayList;

import com.google.gwt.user.client.Random;

import fr.vekia.VkGraph.client.charts.LineChart;
import fr.vekia.VkGraph.client.options.ChartOption;
import fr.vekia.VkGraph.client.options.SubOption;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 27 avr. 2012. GWTQuery Vekia Showcase
 * @version 1.0
 * 
 *          {@inheritDoc}
 */
public class SimplePlotScreen extends LineChart<Number> {

	/**
	 * Default constructor
	 * 
	 */
	public SimplePlotScreen() {
		ArrayList<Number> data = new ArrayList<Number>();
		for (int i = 0; i < 120; i++) {
			data.add(Random.nextInt(250));
		}

		setSize("100%", "660px");
		setBooleanOption(ChartOption.seriesDefaults, SubOption.showMarker,
				false);
		super.setDatas(data);
		super.setExportEnable(true);
		setListView(true);
	}
}
