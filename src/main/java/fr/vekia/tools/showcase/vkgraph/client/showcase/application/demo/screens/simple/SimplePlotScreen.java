package fr.vekia.tools.showcase.vkgraph.client.showcase.application.demo.screens.simple;

import java.util.ArrayList;

import com.google.gwt.user.client.Random;

import fr.vekia.vkgraph.client.charts.LineChart;
import fr.vekia.vkgraph.client.options.ChartOption;
import fr.vekia.vkgraph.client.options.SubOption;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 27 avr. 2012. GWTQuery Vekia Showcase
 * @version 1.0
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
        setBooleanOption(ChartOption.seriesDefaults, SubOption.showMarker, false);
        super.setDatas(data);
        super.setExportEnable(true);
        setListView(true);
    }
}
