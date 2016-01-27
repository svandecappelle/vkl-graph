package fr.vekia.tools.showcase.vkgraph.client.showcase.demonstration.screens.pies;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.client.Random;

import fr.vekia.vkgraph.client.charts.PieChart;
import fr.vekia.vkgraph.client.charts.RenderersEnum;
import fr.vekia.vkgraph.client.datas.DualValue;
import fr.vekia.vkgraph.client.options.ChartOption;
import fr.vekia.vkgraph.client.options.SubOption;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 4 mai 2012. GWTQuery Vekia Showcase
 * @version 1.0
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
