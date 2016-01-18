package fr.vekia.tools.showcase.vkgraph.client.showcase.demonstration.screens.simple;

import java.util.ArrayList;
import java.util.List;

import fr.vekia.vkgraph.client.charts.AbstractChart;
import fr.vekia.vkgraph.client.datas.DualValue;
import fr.vekia.vkgraph.client.options.ChartOption;
import fr.vekia.vkgraph.client.options.SubOption;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 4 mai 2012. GWTQuery Vekia Showcase
 * @version 1.0
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
