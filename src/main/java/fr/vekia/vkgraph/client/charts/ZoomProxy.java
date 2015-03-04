package fr.vekia.vkgraph.client.charts;

import com.google.gwt.core.client.JavaScriptObject;

import fr.vekia.vkgraph.client.charts.events.AttachedChartEvent;
import fr.vekia.vkgraph.client.charts.events.AttachedChartHandler;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 3 sept. 2012. VklGraph version 1.2
 * @version 2.1
 * 
 *          {@inheritDoc}
 */
public class ZoomProxy {

    public void setProxy(final Chart<?> chartTarget, final Chart<?> chartProxy) {
        if (chartProxy != null) {
            chartProxy.addAttachedChartHandler(new AttachedChartHandler() {

                @Override
                public void onAttachedChart(AttachedChartEvent itemTabSelectionEvent) {
                    if (chartProxy.getChartJavascriptObject() != null && chartTarget.getChartJavascriptObject() != chartProxy.getChartJavascriptObject()) {
                        setZoomProxy(chartTarget.getChartJavascriptObject(), chartProxy.getChartJavascriptObject());
                    }
                }
            });
            chartTarget.addAttachedChartHandler(new AttachedChartHandler() {

                @Override
                public void onAttachedChart(AttachedChartEvent itemTabSelectionEvent) {
                    if (chartProxy.getChartJavascriptObject() != null && chartTarget.getChartJavascriptObject() != chartProxy.getChartJavascriptObject()) {
                        setZoomProxy(chartTarget.getChartJavascriptObject(), chartProxy.getChartJavascriptObject());
                    }
                }
            });

        }
    }

    private native void setZoomProxy(JavaScriptObject controllerPlot, JavaScriptObject objectProxy) /*-{
                                                                                                    $wnd.jQuery.jqplot.Cursor.zoomProxy(controllerPlot, objectProxy);
                                                                                                    }-*/;
}
