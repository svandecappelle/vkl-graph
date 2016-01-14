package fr.vekia.tools.showcase.vkgraph.client.showcase.application.demo.screens.simple;

import java.util.ArrayList;
import java.util.List;

import fr.vekia.vkgraph.client.charts.AbstractChart;
import fr.vekia.vkgraph.client.charts.RenderersEnum;
import fr.vekia.vkgraph.client.datas.DualValue;
import fr.vekia.vkgraph.client.datas.OptionSerie;
import fr.vekia.vkgraph.client.datas.SeriesData;
import fr.vekia.vkgraph.client.options.ChartOption;
import fr.vekia.vkgraph.client.options.SubOption;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 14 mai 2012. GWTQuery Vekia Showcase
 * @version 1.0
 */
public class ConfidanceBandsExempleScreen extends AbstractChart<DualValue> {
    /**
     * Default constructor
     * 
     */
    public ConfidanceBandsExempleScreen() {
        List<List<DualValue>> bandData = new ArrayList<List<DualValue>>();
        List<DualValue> bandOne = new ArrayList<DualValue>();
        List<DualValue> bandTwo = new ArrayList<DualValue>();

        bandOne.add(new DualValue("7/1/2011", 8));
        bandOne.add(new DualValue("7/2/2011", 9));
        bandOne.add(new DualValue("7/3/2011", 8));
        bandOne.add(new DualValue("7/4/2011", 13));
        bandOne.add(new DualValue("7/5/2011", 11));
        bandOne.add(new DualValue("7/6/2011", 13));

        bandTwo.add(new DualValue("7/1/2011", 12));
        bandTwo.add(new DualValue("7/2/2011", 13));
        bandTwo.add(new DualValue("7/3/2011", 12));
        bandTwo.add(new DualValue("7/4/2011", 17));
        bandTwo.add(new DualValue("7/5/2011", 15));
        bandTwo.add(new DualValue("7/6/2011", 17));

        bandData.add(bandOne);
        bandData.add(bandTwo);

        OptionSerie serie = new OptionSerie();
        serie.setConfidenceInterval(bandData);
        //
        SeriesData datas = new SeriesData();
        datas.set(0, serie);
        setSeriesOptions(datas);
        //
        List<DualValue> dual = new ArrayList<DualValue>();
        dual.add(new DualValue("07/01/2011", 10));
        dual.add(new DualValue("07/02/2011", 11));
        dual.add(new DualValue("07/03/2011", 10));
        dual.add(new DualValue("07/04/2011", 15));
        dual.add(new DualValue("07/05/2011", 13));
        dual.add(new DualValue("07/06/2011", 15));
        super.setDatas(dual);

        super.setListView(true);

        super.setOption(ChartOption.axes, SubOption.xaxis, SubOption.renderer, RenderersEnum.DateAxis.getValueRenderer());
    }

}