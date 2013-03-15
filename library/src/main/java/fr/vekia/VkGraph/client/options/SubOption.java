/*
 * File: $URL: https://vklgraph.googlecode.com/svn/trunk/src/main/java/fr/vekia/VkGraph/client/options/SubOption.java $
 * $Id: SubOption.java 51 2012-09-27 15:52:22Z steeve.vandecappelle@gmail.com $
 * Licence MIT
 * 
 * Last change:
 * $Date: 2012-09-27 17:52:22 +0200 (jeu., 27 sept. 2012) $
 * $Author: steeve.vandecappelle@gmail.com $
 */
package fr.vekia.VkGraph.client.options;

import java.util.Arrays;
import java.util.List;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 4 mai 2012. GWTQuery Vekia Showcase
 * @version 1.0
 * 
 *          {@inheritDoc} A JqPlot chart Sub option.
 */
public enum SubOption implements IsOption, HasType {
    rendererOptions(ChartOption.axesDefaults, ChartOption.seriesDefaults, ChartOption.grid),
    dragable(OptionType.BOOLEAN, ChartOption.series),
    trendline(ChartOption.seriesDefaults),
    xaxis(ChartOption.axes, ChartOption.seriesDefaults),
    yaxis(ChartOption.axes, ChartOption.seriesDefaults),
    animation(OptionType.BOOLEAN, rendererOptions),
    background(OptionType.STRING, ChartOption.grid),
    bandData(rendererOptions),
    barMargin(OptionType.NUMBER, rendererOptions),
    barPadding(OptionType.NUMBER, rendererOptions),
    barWidth(OptionType.NUMBER, rendererOptions),
    bubbleAlpha(OptionType.BOOLEAN, rendererOptions),
    bubbleGradients(OptionType.BOOLEAN, rendererOptions),
    color(OptionType.NUMBER, ChartOption.series),
    constrainTo(OptionType.STRING, SubOption.dragable),
    dataLabels(rendererOptions),
    drawBorder(ChartOption.grid),
    fill(OptionType.BOOLEAN, ChartOption.seriesDefaults),
    fillAndStroke(OptionType.BOOLEAN, ChartOption.seriesDefaults),
    fillToZero(OptionType.BOOLEAN, ChartOption.seriesDefaults),
    highlightAlpha(rendererOptions),
    highlightMouseOver(rendererOptions),
    isDragable(OptionType.BOOLEAN, ChartOption.series),
    label(ChartOption.seriesDefaults),
    labelRenderer(ChartOption.axesDefaults),
    labels(ChartOption.legend),
    labelsOptions(SubOption.xaxis, SubOption.yaxis),
    location(ChartOption.legend),
    looseZoom(OptionType.BOOLEAN, ChartOption.cursor),
    max(ChartOption.axesDefaults),
    min(ChartOption.axesDefaults),
    numberTicks(ChartOption.axesDefaults),
    numberColumns(ChartOption.legend),
    numberRows(ChartOption.legend),
    pad(ChartOption.axesDefaults),
    placement(ChartOption.legend),
    pointLabels(ChartOption.series),
    renderer(ChartOption.axesDefaults, ChartOption.seriesDefaults, ChartOption.grid),
    rowSpacing(ChartOption.legend),
    seriesToggle(rendererOptions),
    seriesToggleReplot(rendererOptions),
    shadow(ChartOption.grid, ChartOption.seriesDefaults),
    shadowAlpha(ChartOption.seriesDefaults),
    show(OptionType.BOOLEAN, ChartOption.seriesDefaults, ChartOption.axesDefaults, ChartOption.legend, ChartOption.cursor, SubOption.trendline),
    showDataLabels(OptionType.BOOLEAN, rendererOptions),
    showMarker(OptionType.BOOLEAN, ChartOption.seriesDefaults),
    showTickMarks(OptionType.BOOLEAN, ChartOption.axesDefaults),
    showTicks(OptionType.BOOLEAN, ChartOption.axesDefaults),
    showTooltip(ChartOption.cursor),
    sliceMargin(rendererOptions),
    smooth(OptionType.BOOLEAN, rendererOptions),
    startAngle(rendererOptions),
    text(OptionType.STRING, ChartOption.title),
    tickInterval(xaxis),
    tickOptions(ChartOption.axesDefaults),
    tickRenderer(ChartOption.axesDefaults),
    ticks(ChartOption.axesDefaults),
    tooltipAxes(ChartOption.highlighter),
    tooltipLocation(ChartOption.highlighter),
    x2axis(ChartOption.axes, ChartOption.seriesDefaults),
    y2axis(ChartOption.axes, ChartOption.seriesDefaults),
    x3axis(ChartOption.axes, ChartOption.seriesDefaults),
    y3axis(ChartOption.axes, ChartOption.seriesDefaults),
    drawMajorGridlines(OptionType.BOOLEAN, SubOption.xaxis, yaxis),
    showMark(SubOption.tickOptions),
    zoom(ChartOption.cursor),
    minorTicks(SubOption.rendererOptions),
    baselineWidth(ChartOption.axesDefaults),
    baselineColor(ChartOption.axesDefaults),
    useSeriesColor(ChartOption.axesDefaults),
    drawBaseline(ChartOption.axesDefaults),
    sizeAdjust(ChartOption.highlighter),
    side(SubOption.rendererOptions),
    tooltipOffset(ChartOption.highlighter),
    gridLineColor(ChartOption.grid),
    gridLineWidth(ChartOption.grid),
    offsetBars(rendererOptions),
    synchronizeHighlight(rendererOptions),
    showMinorTicks(OptionType.BOOLEAN, yaxis, xaxis),
    constrainZoomTo(ChartOption.cursor),
    formatString(ChartOption.axes),
    intervals(rendererOptions),
    intervalColors(rendererOptions),
    showTickLabels(OptionType.BOOLEAN, rendererOptions),
    labelPosition(rendererOptions),
    labelHeightAdjust(rendererOptions),
    intervalOuterRadius(rendererOptions),
    objects(ChartOption.canvasOverlay),
    verticalLine(objects),
    dashedHorizontalLine(objects),
    horizontalLine(objects),
    dashedVerticalLine(objects),
    x(verticalLine),
    y(horizontalLine),
    showTooltipPrecision(horizontalLine, verticalLine),
    name(OptionType.STRING, horizontalLine, verticalLine),
    yOffset(verticalLine),
    xOffSet(horizontalLine),
    tooltipFormatString(horizontalLine, verticalLine),
    lineWidth(verticalLine, horizontalLine),
    drawGridlines(OptionType.BOOLEAN, ChartOption.grid),
    ymin(verticalLine),
    ymax(verticalLine),
    xmax(horizontalLine),
    xmin(horizontalLine),
    plotBands(ChartOption.grid),
    yvalues(ChartOption.highlighter),
    candleStick(rendererOptions),
    series1(ChartOption.fillBetween),
    series2(ChartOption.fillBetween),
    baseSeries(ChartOption.fillBetween),
    showLabel,
    showLine,
    markerOptions,
    size,
    style,
    useAxesFormatters(ChartOption.highlighter),
    tooltipFormatCallback(ChartOption.highlighter),
    followMouse(ChartOption.cursor),
    showTooltipUnitPosition(ChartOption.cursor),
    fadeTooltip(ChartOption.highlighter),
    highlightColors(rendererOptions),
    bands(rendererOptions),
    showLines(rendererOptions),
    highlightMouseDown(rendererOptions);

    private IsOption[] parent;
    private OptionType type;
    private boolean hasChildren;

    /**
     * Default constructor. The parameter is only to create on the future a dynamic use-case documentation and throws the not accessible options.
     * 
     */
    private SubOption(IsOption... parent) {
	this.parent = parent;
    }

    /**
     * Default constructor. The parameter is only to create on the future a dynamic use-case documentation and throws the not accessible options.
     * 
     */
    private SubOption(OptionType type, IsOption... parent) {
	this.type = type;
	this.parent = parent;
    }

    /**
     * Get the parent option.
     * 
     * @return the parent the parent {@link IsOption} element
     */
    public List<IsOption> getParent() {
	return Arrays.asList(parent);
    }

    /**
     * @return the type
     */
    public OptionType getType() {
	return type;
    }

    @Override
    public boolean hasChildren() {
	return hasChildren;
    }
}
