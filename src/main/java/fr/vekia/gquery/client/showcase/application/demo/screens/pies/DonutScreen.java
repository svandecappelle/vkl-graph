/*
 * File: $URL: svn+ssh://chimay/home/svn/VkGraph-showcase/VkGraph-showcase/src/main/java/fr/vekia/gquery/client/showcase/application/components/menu/groups/pie/screens/DonutScreen.java $
 * $Id: DonutScreen.java 52 2012-09-26 15:26:35Z svandecappelle $
 * Licence MIT
 * 
 * Last change:
 * $Date: 2012-09-26 17:26:35 +0200 (mer., 26 sept. 2012) $
 * $Author: svandecappelle $
 */
package fr.vekia.gquery.client.showcase.application.demo.screens.pies;

import java.util.ArrayList;
import java.util.List;

import fr.vekia.VkGraph.client.charts.Donut;
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
public class DonutScreen extends Donut<List<DualValue>> {
    /**
     * Default constructor
     * 
     */
    public DonutScreen() {
	super.setNumberOption(ChartOption.seriesDefaults, SubOption.rendererOptions, SubOption.sliceMargin, 3);
	super.setNumberOption(ChartOption.seriesDefaults, SubOption.rendererOptions, SubOption.startAngle, 3);
	super.setBooleanOption(ChartOption.seriesDefaults, SubOption.rendererOptions, SubOption.showDataLabels, true);
	// super.setTextOption(ChartOption.seriesDefaults, SubOption.rendererOptions, SubOption.dataLabels, "value");

	super.setBooleanOption(ChartOption.legend, SubOption.show, true);

	ArrayList<DualValue> valuesLineOne = new ArrayList<DualValue>();
	ArrayList<DualValue> valuesLineTwo = new ArrayList<DualValue>();

	valuesLineOne.add(new DualValue("A", 6));
	valuesLineOne.add(new DualValue("B", 8));
	valuesLineOne.add(new DualValue("C", 14));
	valuesLineOne.add(new DualValue("D", 21));

	valuesLineTwo.add(new DualValue("A", 8));
	valuesLineTwo.add(new DualValue("B", 12));
	valuesLineTwo.add(new DualValue("C", 6));
	valuesLineTwo.add(new DualValue("D", 6));
	// valuesLineTwo.add(new DualValue("E", 9));

	List<List<DualValue>> values = new ArrayList<List<DualValue>>();
	values.add(valuesLineOne);
	values.add(valuesLineTwo);

	super.setDatas(values);
    }
}
