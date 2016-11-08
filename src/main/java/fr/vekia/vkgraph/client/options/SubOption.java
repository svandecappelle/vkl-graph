package fr.vekia.vkgraph.client.options;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/**
 * A JqPlot chart Sub option.
 * 
 * @author Steeve Vandecappelle (SVA)
 * @since 4 mai 2012. VklGraph
 * @version 1.3.0
 */
@SuppressWarnings("squid:S00115")
public enum SubOption implements IsOption, HasType, Serializable {
    rendererOptions(ChartOption.axesDefaults, ChartOption.seriesDefaults, ChartOption.grid),
    objects(ChartOption.canvasOverlay),
    dragable(OptionType.BOOLEAN, ChartOption.series),
    xaxis(ChartOption.axes, ChartOption.seriesDefaults),
    yaxis(ChartOption.axes, ChartOption.seriesDefaults),
    tickOptions(ChartOption.axesDefaults),
    line(objects),
    dashedHorizontalLine(objects),
    dashedVerticalLine(objects),
    horizontalLine(ChartOption.cursor, objects),
    verticalLine(ChartOption.cursor, objects),
    rectangle(objects),
    xformat(rectangle, verticalLine, dashedVerticalLine, horizontalLine, dashedHorizontalLine, line),
    yformat(rectangle, verticalLine, dashedVerticalLine, horizontalLine, dashedHorizontalLine, line),
    trendline(ChartOption.seriesDefaults),
    animation(OptionType.BOOLEAN, rendererOptions),
    axes(ChartOption.noDataIndicator),
    background(OptionType.STRING, ChartOption.grid),
    bandData(rendererOptions),
    bands(rendererOptions),
    barDirection(OptionType.STRING, rendererOptions),
    barMargin(OptionType.NUMBER, rendererOptions),
    barPadding(OptionType.NUMBER, rendererOptions),
    barWidth(OptionType.NUMBER, rendererOptions),
    baselineColor(ChartOption.axesDefaults),
    baselineWidth(ChartOption.axesDefaults),
    baseSeries(ChartOption.fillBetween),
    bellowSeries(ChartOption.canvasOverlay),
    border(OptionType.BOOLEAN, ChartOption.legend),
    bubbleAlpha(OptionType.BOOLEAN, rendererOptions),
    bubbleGradients(OptionType.BOOLEAN, rendererOptions),
    candleStick(rendererOptions),
    color(OptionType.NUMBER, ChartOption.series, ChartOption.background),
    constrainTo(OptionType.STRING, SubOption.dragable),
    constrainTooltipToScreen(OptionType.BOOLEAN, ChartOption.cursor),
    constrainZoomTo(ChartOption.cursor),
    dataLabels(rendererOptions),
    drawBaseline(ChartOption.axesDefaults),
    drawBorder(ChartOption.grid),
    drawGridlines(OptionType.BOOLEAN, ChartOption.grid),
    drawMajorGridlines(OptionType.BOOLEAN, SubOption.xaxis, yaxis),
    fadeTooltip(ChartOption.highlighter),
    fill(OptionType.BOOLEAN, ChartOption.seriesDefaults),
    fillAndStroke(OptionType.BOOLEAN, ChartOption.seriesDefaults),
    fillToZero(OptionType.BOOLEAN, ChartOption.seriesDefaults),
    followMouse(OptionType.BOOLEAN, ChartOption.cursor),
    fontFamily(OptionType.STRING, ChartOption.title),
    fontSize(OptionType.STRING, ChartOption.title),
    format(xformat, yformat),
    formatter(SubOption.xaxis, SubOption.yaxis),
    formatString(ChartOption.axes),
    globalTooltipFormat(OptionType.STRING, ChartOption.cursor),
    gridLineColor(ChartOption.grid),
    gridLineWidth(ChartOption.grid),
    headTooltipFormatter(ChartOption.cursor),
    headTooltipFormatString(ChartOption.cursor),
    highlightAlpha(rendererOptions),
    highlightColors(rendererOptions),
    highlightMouseDown(rendererOptions),
    highlightMouseOver(rendererOptions),
    indicator(ChartOption.noDataIndicator),
    insertHead(OptionType.BOOLEAN, ChartOption.cursor),
    intervalColors(rendererOptions),
    intervalOuterRadius(rendererOptions),
    intervals(rendererOptions),
    isDragable(OptionType.BOOLEAN, ChartOption.series),
    label(ChartOption.seriesDefaults),
    labelHeightAdjust(rendererOptions),
    labelPosition(rendererOptions),
    labelRenderer(ChartOption.axesDefaults),
    labels(ChartOption.legend),
    labelsOptions(SubOption.xaxis, SubOption.yaxis),
    linePattern(ChartOption.seriesDefaults),
    lineWidth(verticalLine, horizontalLine),
    location(ChartOption.legend),
    looseZoom(OptionType.BOOLEAN, ChartOption.cursor),
    markerOptions,
    max(ChartOption.axesDefaults),
    min(ChartOption.axesDefaults),
    minorTicks(SubOption.rendererOptions),
    name(OptionType.STRING, horizontalLine, verticalLine),
    numberColumns(ChartOption.legend),
    numberRows(ChartOption.legend),
    numberTicks(ChartOption.axesDefaults),
    offsetBars(rendererOptions),
    pad(ChartOption.axesDefaults),
    placement(ChartOption.legend),
    plotBands(ChartOption.grid),
    pointLabels(ChartOption.series),
    renderer(ChartOption.axesDefaults, ChartOption.seriesDefaults, ChartOption.grid),
    rowSpacing(ChartOption.legend),
    series1(ChartOption.fillBetween),
    series2(ChartOption.fillBetween),
    seriesToggle(rendererOptions),
    seriesToggleReplot(rendererOptions),
    shadow(ChartOption.grid, ChartOption.seriesDefaults),
    shadowAlpha(ChartOption.seriesDefaults),
    show(OptionType.BOOLEAN, ChartOption.seriesDefaults, ChartOption.axesDefaults, ChartOption.legend, ChartOption.cursor, SubOption.trendline, ChartOption.noDataIndicator),
    showCursorLegend(OptionType.BOOLEAN, ChartOption.cursor),
    showDataLabels(OptionType.BOOLEAN, rendererOptions),
    showLabel,
    showLine,
    showLines(rendererOptions),
    showMark(SubOption.tickOptions),
    showMarker(OptionType.BOOLEAN, ChartOption.seriesDefaults),
    showMinorTicks(OptionType.BOOLEAN, yaxis, xaxis),
    showTickLabels(OptionType.BOOLEAN, rendererOptions),
    showTickMarks(OptionType.BOOLEAN, ChartOption.axesDefaults),
    showTicks(OptionType.BOOLEAN, ChartOption.axesDefaults),
    showTooltip(OptionType.BOOLEAN, ChartOption.cursor),
    showTooltipDataPosition(OptionType.BOOLEAN, ChartOption.cursor),
    showTooltipPrecision(horizontalLine, verticalLine),
    showTooltipUnitPosition(ChartOption.cursor),
    showVerticalLine(OptionType.BOOLEAN, ChartOption.cursor),
    showHorizontalLine(OptionType.BOOLEAN, ChartOption.cursor),
    side(SubOption.rendererOptions),
    size,
    sizeAdjust(ChartOption.highlighter),
    sliceMargin(rendererOptions),
    smooth(OptionType.BOOLEAN, rendererOptions),
    stackedValue(OptionType.BOOLEAN, SubOption.pointLabels),
    startAngle(rendererOptions),
    style,
    synchronizeHighlight(rendererOptions),
    text(OptionType.STRING, ChartOption.title),
    textColor(OptionType.STRING, ChartOption.legend),
    tickInterval(xaxis),
    tickRenderer(ChartOption.axesDefaults),
    ticks(ChartOption.axesDefaults),
    tooltipAxes(ChartOption.highlighter),
    tooltipFormatCallback(ChartOption.highlighter),
    tooltipFormatString(horizontalLine, verticalLine),
    tooltipLocation(ChartOption.highlighter),
    tooltipOffset(ChartOption.highlighter),
    type(xformat, yformat),
    useAxesFormatters(ChartOption.highlighter),
    useSeriesColor(ChartOption.axesDefaults, ChartOption.cursor),
    useNegativeColors(OptionType.BOOLEAN, SubOption.rendererOptions),
    varyBarColor(OptionType.BOOLEAN, SubOption.rendererOptions),
    x(verticalLine),
    x2axis(ChartOption.axes, ChartOption.seriesDefaults),
    x3axis(ChartOption.axes, ChartOption.seriesDefaults),
    xmax(horizontalLine),
    xmin(horizontalLine),
    xOffSet(horizontalLine),
    y(horizontalLine),
    y2axis(ChartOption.axes, ChartOption.seriesDefaults),
    y3axis(ChartOption.axes, ChartOption.seriesDefaults),
    ymax(verticalLine),
    ymin(verticalLine),
    yOffset(verticalLine),
    yvalues(ChartOption.highlighter),
    zoom(ChartOption.cursor);

    private boolean hasChildren;
    private IsOption[] parent;
    private OptionType typeOption;

    /**
     * Default constructor. The parameter is only to create on the future a dynamic use-case documentation and throws
     * the not accessible options.
     * 
     */
    private SubOption(IsOption... parent) {
        this.parent = parent;
    }

    /**
     * Default constructor. The parameter is only to create on the future a dynamic use-case documentation and throws
     * the not accessible options.
     * 
     */
    private SubOption(OptionType type, IsOption... parent) {
        this.typeOption = type;
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

    @Override
    public OptionType getType() {
        return typeOption;
    }

    @Override
    public boolean hasChildren() {
        return hasChildren;
    }
}
