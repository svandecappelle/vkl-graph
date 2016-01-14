package fr.vekia.tools.showcase.vkgraph.client.showcase.application.demo.screens.simple;

import java.util.ArrayList;
import java.util.List;

import fr.vekia.vkgraph.client.charts.AbstractChart;
import fr.vekia.vkgraph.client.datas.DualValue;
import fr.vekia.vkgraph.client.options.ChartOption;
import fr.vekia.vkgraph.client.options.SubOption;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 28 mai 2012. GWTQuery Vekia Showcase
 * @version 1.0
 */
public class BezierCurveExempleScreen extends AbstractChart<List<DualValue>> {

    /**
     * Default constructor
     * 
     */
    public BezierCurveExempleScreen() {

        List<List<DualValue>> datas = new ArrayList<List<DualValue>>();

        List<DualValue> lineOne = new ArrayList<DualValue>();
        lineOne.add(new DualValue(0, 1));
        lineOne.add(new DualValue(2, 2));
        lineOne.add(new DualValue(4, 0.5));
        lineOne.add(new DualValue(6, 0));
        datas.add(lineOne);

        List<DualValue> linetwo = new ArrayList<DualValue>();
        linetwo.add(new DualValue(0, 5));
        linetwo.add(new DualValue(2, 6));
        linetwo.add(new DualValue(4, 1));
        linetwo.add(new DualValue(6, 0.5));
        datas.add(linetwo);

        List<DualValue> linethree = new ArrayList<DualValue>();
        linethree.add(new DualValue(0, 6));
        linethree.add(new DualValue(2, 9));
        linethree.add(new DualValue(4, 8));
        linethree.add(new DualValue(6, 3));
        datas.add(linethree);

        List<DualValue> lineFour = new ArrayList<DualValue>();
        lineFour.add(new DualValue(0, 7));
        lineFour.add(new DualValue(2, 9));
        lineFour.add(new DualValue(4, 8));
        lineFour.add(new DualValue(6, 6));
        datas.add(lineFour);

        List<DualValue> lineFive = new ArrayList<DualValue>();
        lineFive.add(new DualValue(0, 8));
        lineFive.add(new DualValue(2, 9));
        lineFive.add(new DualValue(4, 8));
        lineFive.add(new DualValue(6, 8));
        datas.add(lineFive);

        setOption(ChartOption.seriesDefaults, SubOption.renderer, "$.jqplot.BezierCurveRenderer");

        setBooleanOption(ChartOption.legend, SubOption.show, true);

        setDatas(datas);
        super.setThemingEnable(true);
    }
}
