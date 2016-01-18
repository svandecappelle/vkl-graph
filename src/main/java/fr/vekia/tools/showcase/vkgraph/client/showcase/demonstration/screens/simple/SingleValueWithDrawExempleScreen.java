package fr.vekia.tools.showcase.vkgraph.client.showcase.demonstration.screens.simple;

import java.util.ArrayList;

import fr.vekia.vkgraph.client.charts.LineChart;
import fr.vekia.vkgraph.client.charts.NumberType;
import fr.vekia.vkgraph.client.datas.CanvasOverlayObject;
import fr.vekia.vkgraph.client.datas.HorizontalLine;
import fr.vekia.vkgraph.client.datas.VerticalLine;
import fr.vekia.vkgraph.client.options.ChartOption;
import fr.vekia.vkgraph.client.options.SubOption;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 14 mai 2012. GWTQuery Vekia Showcase
 * @version 1.0
 */
public class SingleValueWithDrawExempleScreen extends LineChart<Number> {

    /**
     * Default constructor
     * 
     */
    public SingleValueWithDrawExempleScreen() {
        ArrayList<Number> data = new ArrayList<Number>();
        data.add(3);
        data.add(4);
        data.add(8);
        data.add(6);
        data.add(7);
        data.add(8);
        data.add(12);
        data.add(15);
        data.add(13);
        data.add(9);

        setSize("1400px", "660px");
        setBooleanOption(ChartOption.seriesDefaults, SubOption.showMarker, false);
        setNumberOption(ChartOption.grid, SubOption.gridLineWidth, 1.5f, NumberType.FLOAT);
        setTextOption(ChartOption.grid, SubOption.gridLineColor, "rgb(235,235,235)");
        setBooleanOption(ChartOption.grid, SubOption.drawGridlines, true);

        super.setDatas(data);
        setListView(true);

        CanvasOverlayObject canvasDrawOption = new CanvasOverlayObject();

        VerticalLine line = new VerticalLine();
        line.setNumberOption(SubOption.ymin, 0);
        line.setNumberOption(SubOption.ymax, 8);
        line.setNumberOption(SubOption.x, 3);
        line.setNumberOption(SubOption.lineWidth, 1);
        line.setTextOption(SubOption.name, "Rrrrr");
        line.setTextOption(SubOption.color, "rgb(152, 155, 124)");
        line.setBooleanOption(SubOption.shadow, false);
        line.setBooleanOption(SubOption.showTooltip, true);
        line.setOption(SubOption.tooltipFormatString, "Y=%'d");
        canvasDrawOption.addObject(line);

        HorizontalLine line2 = new HorizontalLine();
        line2.setNumberOption(SubOption.xmin, 0);
        line2.setNumberOption(SubOption.xmax, 3);
        line2.setNumberOption(SubOption.y, 8);
        line2.setNumberOption(SubOption.lineWidth, 1);
        line2.setTextOption(SubOption.name, "blaaa");
        line2.setTextOption(SubOption.color, "rgb(152, 155, 124)");
        line2.setBooleanOption(SubOption.shadow, false);
        line2.setBooleanOption(SubOption.showTooltip, true);
        line2.setOption(SubOption.tooltipFormatString, "X=%'d");
        canvasDrawOption.addObject(line2);

        VerticalLine line3 = new VerticalLine();
        line3.setDashed(true);
        line3.setNumberOption(SubOption.x, 8);
        line3.setNumberOption(SubOption.lineWidth, 4);
        line3.setTextOption(SubOption.name, "bluuu");
        line3.setTextOption(SubOption.color, "orange");
        line3.setBooleanOption(SubOption.shadow, true);
        canvasDrawOption.addObject(line3);

        setBooleanOption(ChartOption.canvasOverlay, SubOption.show, true);
        setCanvasOverlay(canvasDrawOption);

    }
}