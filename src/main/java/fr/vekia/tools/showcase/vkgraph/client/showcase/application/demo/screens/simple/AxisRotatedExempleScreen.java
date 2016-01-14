package fr.vekia.tools.showcase.vkgraph.client.showcase.application.demo.screens.simple;

import java.util.ArrayList;

import fr.vekia.vkgraph.client.charts.AbstractChart;
import fr.vekia.vkgraph.client.charts.RenderersEnum;
import fr.vekia.vkgraph.client.options.ChartOption;
import fr.vekia.vkgraph.client.options.SubOption;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 14 mai 2012. GWTQuery Vekia Showcase
 * @version 1.0
 */
public class AxisRotatedExempleScreen extends AbstractChart<Number> {

    /**
     * Default constructor
     * 
     */
    public AxisRotatedExempleScreen() {

        super.setOption(ChartOption.axes, SubOption.xaxis, SubOption.tickOptions, "{angle: -30}");
        super.setOption(ChartOption.axes, SubOption.xaxis, SubOption.tickRenderer, RenderersEnum.CanvasAxisTick.getValueRenderer());

        super.setOption(ChartOption.axes, SubOption.xaxis, SubOption.labelRenderer, RenderersEnum.CanvasAxisLabel.getValueRenderer());
        super.setTextOption(ChartOption.axes, SubOption.xaxis, SubOption.label, "Core Motor Amperage");
        super.setOption(ChartOption.axes, SubOption.xaxis, SubOption.labelsOptions, "{fontFamily:'Helvetica',fontSize: '14pt'}");

        super.setOption(ChartOption.axes, SubOption.yaxis, SubOption.renderer, RenderersEnum.LogAxis.getValueRenderer());

        super.setOption(ChartOption.axes, SubOption.yaxis, SubOption.tickRenderer, RenderersEnum.CanvasAxisTick.getValueRenderer());
        super.setOption(ChartOption.axes, SubOption.yaxis, SubOption.tickOptions, "{angle: -30}");

        ArrayList<Number> datas = new ArrayList<Number>();

        datas.add(6);
        datas.add(9);
        datas.add(14);
        datas.add(19);
        datas.add(26);
        datas.add(35);
        datas.add(51);

        super.setListView(true);

        super.setDatas(datas);

    }
}