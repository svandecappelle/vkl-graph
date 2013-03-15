/*
 * File: $URL: svn+ssh://chimay/home/svn/VkGraph-showcase/VkGraph-showcase/src/main/java/fr/vekia/gquery/client/showcase/application/components/menu/groups/pie/screens/GeneralPieScreen.java $
 * $Id: GeneralPieScreen.java 22 2012-06-27 16:38:32Z svandecappelle $
 * Licence MIT
 * 
 * Last change:
 * $Date: 2012-06-27 18:38:32 +0200 (mer., 27 juin 2012) $
 * $Author: svandecappelle $
 */
package fr.vekia.gquery.client.showcase.application.demo.screens.pies;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.client.Random;

import fr.vekia.VkGraph.client.charts.PieChart;
import fr.vekia.VkGraph.client.charts.RenderersEnum;
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
public class GeneralPieScreen extends PieChart<List<DualValue>> {

    /**
     * Default constructor
     * 
     */
    public GeneralPieScreen() {
	super.setOption(ChartOption.seriesDefaults, SubOption.renderer, RenderersEnum.Pie.getValueRenderer());
	super.setBooleanOption(ChartOption.seriesDefaults, SubOption.rendererOptions, SubOption.showDataLabels, true);
	super.setBooleanOption(ChartOption.seriesDefaults, SubOption.showMarker, true);
	super.setTextOption(ChartOption.title, SubOption.text, "Title");
	super.setBooleanOption(ChartOption.legend, SubOption.show, true);

	List<String> colors = new ArrayList<String>();
	colors.add("#9ABBE3");
	colors.add("#EDECEB");
	colors.add("#8E1C68");
	colors.add("#64C6F5");
	colors.add("#E2DBBF");
	colors.add("#FE8C29");

	super.setColors(colors);
	super.setBooleanOption(ChartOption.cursor, SubOption.showTooltip, true);

	ArrayList<DualValue> valuesLineOne = new ArrayList<DualValue>();

	for (int i = 0; i < 6; i++) {
	    valuesLineOne.add(new DualValue(i, Random.nextInt(50)));
	}

	List<List<DualValue>> values = new ArrayList<List<DualValue>>();
	values.add(valuesLineOne);

	super.setDatas(values);
    }
}
