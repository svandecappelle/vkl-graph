package fr.vekia.vkgraph.client.datas.utils;

import com.google.gwt.core.client.JavaScriptObject;

import fr.vekia.vkgraph.client.charts.RenderersEnum;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 25 juin 2012. GWTQuery Vekia Showcase
 * @version 1.0
 * 
 *          {@inheritDoc} List of available JqPlots renderers.
 */
public final class RendererFactory {
    private RendererFactory() {

    }

    private static native JavaScriptObject stairs()
    /*-{
    return $wnd.jQuery.jqplot.StairsRenderer;
    }-*/;

    private static native JavaScriptObject pie()
    /*-{
    return $wnd.jQuery.jqplot.PieRenderer;
    }-*/;

    private static native JavaScriptObject donut()
    /*-{
    return $wnd.jQuery.jqplot.DonutRenderer;
    }-*/;

    private static native JavaScriptObject donutLegend()
    /*-{
    return $wnd.jQuery.jqplot.DonutLegendRenderer;
    }-*/;

    private static native JavaScriptObject bar()
    /*-{
    return $wnd.jQuery.jqplot.BarRenderer;
    }-*/;

    private static native JavaScriptObject line()
    /*-{
    return $wnd.jQuery.jqplot.LineRenderer;
    }-*/;

    private static native JavaScriptObject bubble()
    /*-{
    return $wnd.jQuery.jqplot.BubbleRenderer;
    }-*/;

    private static native JavaScriptObject bezierCurve()
    /*-{
    return $wnd.jQuery.jqplot.BezierCurveRenderer;
    }-*/;

    private static native JavaScriptObject block()
    /*-{
    return $wnd.jQuery.jqplot.BlockRenderer;
    }-*/;

    private static native JavaScriptObject canvasAxisLabel()
    /*-{
    return $wnd.jQuery.jqplot.CanvasAxisLabelRenderer;
    }-*/;

    private static native JavaScriptObject canvasAxisTick()
    /*-{
    return $wnd.jQuery.jqplot.CanvasAxisTickRenderer;
    }-*/;

    private static native JavaScriptObject categoryAxis()
    /*-{
    return $wnd.jQuery.jqplot.CategoryAxisRenderer;
    }-*/;

    private static native JavaScriptObject dateAxis()
    /*-{
    return $wnd.jQuery.jqplot.DateAxisRenderer;
    }-*/;

    private static native JavaScriptObject funnel()
    /*-{
    return $wnd.jQuery.jqplot.FunnelRenderer;
    }-*/;

    private static native JavaScriptObject meterGauge()
    /*-{
    return $wnd.jQuery.jqplot.MeterGaugeRenderer;
    }-*/;

    private static native JavaScriptObject mekko()
    /*-{
    return $wnd.jQuery.jqplot.MekkoAxisRenderer;
    }-*/;

    private static native JavaScriptObject ohlc()
    /*-{
    return $wnd.jQuery.jqplot.OHLCRenderer;
    }-*/;

    private static native JavaScriptObject logAxis()
    /*-{
    return $wnd.jQuery.jqplot.LogAxisRenderer;
    }-*/;

    private static native JavaScriptObject mekkoAxis()
    /*-{
    return $wnd.jQuery.jqplot.MekkoAxisRenderer;
    }-*/;

    private static native JavaScriptObject axisTick()
    /*-{
    return $wnd.jQuery.jqplot.AxisTickRenderer;
    }-*/;

    private static native JavaScriptObject canvasGrid()
    /*-{
    return $wnd.jQuery.jqplot.CanvasGridRenderer;
    }-*/;

    private static native JavaScriptObject divTitle()
    /*-{
    return $wnd.jQuery.jqplot.CanvasGridRenderer;
    }-*/;

    private static native JavaScriptObject linearAxis()
    /*-{
    return $wnd.jQuery.jqplot.LinearAxisRenderer;
    }-*/;

    private static native JavaScriptObject marker()
    /*-{
    return $wnd.jQuery.jqplot.MarkerRenderer;
    }-*/;

    private static native JavaScriptObject shape()
    /*-{
    return $wnd.jQuery.jqplot.shapeRenderer;
    }-*/;

    private static native JavaScriptObject shadow()
    /*-{
    return $wnd.jQuery.jqplot.shadowRenderer;
    }-*/;

    private static native JavaScriptObject axisLabel()
    /*-{
    return $wnd.jQuery.jqplot.AxisLabelRenderer;
    }-*/;

    private static native JavaScriptObject enhancedLegendRenderer()
    /*-{
    return $wnd.jQuery.jqplot.EnhancedLegendRenderer;
    }-*/;

    private static native JavaScriptObject pyramidRenderer()
    /*-{
    return $wnd.jQuery.jqplot.PyramidRenderer;
    }-*/;

    /**
     * Get the JavaScript instance of a renderer.
     * 
     * @param value
     *            renderer value renderer. see {@link RenderersEnum}.
     * @return a {@link JavaScriptObject} instance.
     */
    public static JavaScriptObject getRendererInstance(String value) {
        JavaScriptObject output = null;
        if (value != null) {

            switch (RenderersEnum.getValueWithRenderer(value)) {
            case Bar:
                output = bar();
                break;
            case BezierCurve:
                output = bezierCurve();
                break;
            case Block:
                output = block();
                break;
            case Bubble:
                output = bubble();
                break;
            case DivTitle:
                output = divTitle();
                break;
            case Marker:
                output = marker();
                break;
            case Donut:
                output = donut();
                break;
            case DonutLegend:
                output = donutLegend();
                break;
            case Funnel:
                output = funnel();
                break;
            case Line:
                output = line();
                break;
            case Mekko:
                output = mekko();
                break;
            case MeterGauge:
                output = meterGauge();
                break;
            case OHLC:
                output = ohlc();
                break;
            case Pie:
                output = pie();
                break;
            case Shadow:
                output = shadow();
                break;
            case Shape:
                output = shape();
                break;
            case CanvasGrid:
                output = canvasGrid();
                break;
            case AxisLabel:
                output = axisLabel();
                break;
            case AxisTick:
                output = axisTick();
                break;
            case CanvasAxisLabel:
                output = canvasAxisLabel();
                break;
            case CanvasAxisTick:
                output = canvasAxisTick();
                break;
            case CategoryAxis:
                output = categoryAxis();
                break;
            case DateAxis:
                output = dateAxis();
                break;
            case LinearAxis:
                output = linearAxis();
                break;
            case LogAxis:
                output = logAxis();
                break;
            case MekkoAxis:
                output = mekkoAxis();
                break;
            case EnhancedLegendRenderer:
                output = enhancedLegendRenderer();
                break;
            case Pyramid:
                output = pyramidRenderer();
                break;
            case Stairs:
                output = stairs();
                break;
            default:
                throw new IllegalArgumentException("the renderer " + value + " is not existing or not yet implemented.");
            }
        }
        return output;
    }
}
