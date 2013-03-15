/*
 * File: $URL: svn+ssh://chimay/home/svn/VkGraph-showcase/VkGraph-showcase/src/main/java/fr/vekia/gquery/client/showcase/application/components/menu/groups/plots/screens/DualValuesPlotWithOptionsExempleScreen.java $
 * $Id: DualValuesPlotWithOptionsExempleScreen.java 36 2012-08-20 09:04:30Z svandecappelle $
 * Licence MIT
 * 
 * Last change:
 * $Date: 2012-08-20 11:04:30 +0200 (lun., 20 août 2012) $
 * $Author: svandecappelle $
 */
package fr.vekia.gquery.client.showcase.application.demo.screens.simple;

import java.util.ArrayList;
import java.util.List;

import fr.vekia.VkGraph.client.charts.AbstractChart;
import fr.vekia.VkGraph.client.datas.DualValue;
import fr.vekia.VkGraph.client.options.ChartOption;
import fr.vekia.VkGraph.client.options.SubOption;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 4 mai 2012. GWTQuery Vekia Showcase
 * @version 1.0
 * 
 *          {@inheritDoc}
 */
public class DualValuesPlotWithOptionsExempleScreen extends AbstractChart<List<DualValue>> {
    /**
     * Default constructor
     * 
     */
    public DualValuesPlotWithOptionsExempleScreen() {

	super.setOption(ChartOption.title, "'Exponential Line'");

	List<String> colors = new ArrayList<String>();
	colors.add("{color:'#5FAB78'}");
	super.setOption(ChartOption.series, colors);

	ArrayList<DualValue> valuesLineTwo = new ArrayList<DualValue>();
	ArrayList<DualValue> valuesLineThree = new ArrayList<DualValue>();

	for (float i = 0; i < 5 * Math.PI; i += 0.1) {
	    valuesLineTwo.add(new DualValue(i, Math.cos(i)));
	}

	for (float i = 0; i < 5 * Math.PI; i += 0.1) {
	    valuesLineThree.add(new DualValue(i, 3 * Math.sin(i) + 1));
	}

	List<List<DualValue>> values = new ArrayList<List<DualValue>>();
	values.add(valuesLineTwo);
	values.add(valuesLineThree);

	setBooleanOption(ChartOption.seriesDefaults, SubOption.showMarker, false);

	super.setDatas(values);
    }
}
