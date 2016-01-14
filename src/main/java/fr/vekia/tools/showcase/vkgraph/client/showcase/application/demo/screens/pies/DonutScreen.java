package fr.vekia.tools.showcase.vkgraph.client.showcase.application.demo.screens.pies;

import java.util.ArrayList;
import java.util.List;

import fr.vekia.vkgraph.client.charts.Donut;
import fr.vekia.vkgraph.client.datas.DualValue;
import fr.vekia.vkgraph.client.options.ChartOption;
import fr.vekia.vkgraph.client.options.SubOption;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 4 mai 2012. GWTQuery Vekia Showcase
 * @version 1.0
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
        // super.setTextOption(ChartOption.seriesDefaults,
        // SubOption.rendererOptions, SubOption.dataLabels, "value");

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
