package fr.vekia.vkgraph.client;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

import com.google.gwt.core.client.Callback;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.core.client.ScriptInjector;

public class VkGraph implements EntryPoint {

    private static final List<String> deps = new ArrayList<String>();
    static {
        // <!-- JQuery dependence -->
        // <!-- deps.add("jqplot/core/jquery.min.js"); -->
        deps.add("jqplot/core/jqplot.core.min.js");
        deps.add("jqplot/core/jqplot.linearTickGenerator.min.js");
        deps.add("jqplot/core/jqplot.linearAxisRenderer.min.js");
        deps.add("jqplot/core/jqplot.axisTickRenderer.min.js");
        deps.add("jqplot/core/jqplot.axisLabelRenderer.min.js");
        deps.add("jqplot/core/jqplot.tableLegendRenderer.min.js");
        deps.add("jqplot/core/jqplot.lineRenderer.min.js");
        deps.add("jqplot/core/jqplot.markerRenderer.min.js");
        deps.add("jqplot/core/jqplot.divTitleRenderer.min.js");
        deps.add("jqplot/core/jqplot.canvasGridRenderer.min.js");
        deps.add("jqplot/core/jqplot.linePattern.min.js");
        deps.add("jqplot/core/jqplot.shadowRenderer.min.js");
        deps.add("jqplot/core/jqplot.shapeRenderer.min.js");
        deps.add("jqplot/core/jqplot.sprintf.min.js");
        deps.add("jqplot/core/jsdate.min.js");
        deps.add("jqplot/core/jqplot.themeEngine.min.js");
        deps.add("jqplot/core/jqplot.toImage.min.js");
        deps.add("jqplot/core/jqplot.effects.core.min.js");
        deps.add("jqplot/core/jqplot.effects.blind.min.js");
        deps.add("jqplot/core/jqplot.stairsRenderer.min.js");
        // deps.add("jqplot/core/jquery.jqplot.min.js");
        // <!-- PLUG-IN JQplot -->
        // <!-- Axes -->
        deps.add("jqplot/plugins/axis/jqplot.dateAxisRenderer.min.js");
        deps.add("jqplot/plugins/axis/jqplot.logAxisRenderer.min.js");
        deps.add("jqplot/plugins/axis/jqplot.canvasAxisLabelRenderer.min.js");
        deps.add("jqplot/plugins/axis/jqplot.categoryAxisRenderer.min.js");
        deps.add("jqplot/plugins/axis/jqplot.canvasAxisTickRenderer.min.js");
        deps.add("jqplot/plugins/text/jqplot.canvasTextRenderer.min.js");

        deps.add("jqplot/plugins/points/jqplot.pointLabels.min.js");
        deps.add("jqplot/plugins/cursor/jqplot.cursor.min.js");
        deps.add("jqplot/plugins/highlighter/jqplot.highlighter.min.js");
        deps.add("jqplot/plugins/dnd/jqplot.dragable.min.js");
        deps.add("jqplot/plugins/trendline/jqplot.trendline.min.js");
        // <!-- Pies -->
        deps.add("jqplot/plugins/pie/jqplot.pieRenderer.min.js");
        deps.add("jqplot/plugins/donut/jqplot.donutRenderer.min.js");
        // <!-- Block plot -->
        deps.add("jqplot/plugins/block/jqplot.blockRenderer.min.js");
        // <!-- Pyramid -->
        deps.add("jqplot/plugins/pyramid/jqplot.pyramidRenderer.min.js");
        deps.add("jqplot/plugins/pyramid/jqplot.pyramidAxisRenderer.min.js");
        deps.add("jqplot/plugins/pyramid/jqplot.pyramidGridRenderer.min.js");
        // <!-- Bubble plot -->
        deps.add("jqplot/plugins/bubble/jqplot.bubbleRenderer.min.js");
        // <!-- OHLC plot -->
        deps.add("jqplot/plugins/ohlc/jqplot.ohlcRenderer.min.js");
        // <!-- Bar chart -->
        deps.add("jqplot/plugins/bar/jqplot.barRenderer.min.js");
        // <!-- Bezier chart -->
        deps.add("jqplot/plugins/bezier/jqplot.BezierCurveRenderer.min.js");
        // <!-- Gauge chart -->
        deps.add("jqplot/plugins/gauge/jqplot.meterGaugeRenderer.min.js");
        // <!-- Horizontal / vertical lines -->
        deps.add("jqplot/plugins/overlay/jqplot.canvasOverlay.min.js");
        // <!-- Legend dynamic -->
        deps.add("jqplot/plugins/legend/jqplot.enhancedLegendRenderer.min.js");
        // <!-- Customization theme -->
        deps.add("jqplot/plugins/themes/extendedThemes.min.js");
        // <!-- Export PNG -->
        deps.add("jqplot/plugins/export/exportImg.min.js");
        deps.add("jqplot/plugins/fullscreener/fullscreener.min.js");
    }

    @Override
    public void onModuleLoad() {
        Scheduler.get().scheduleFinally(new ScheduledCommand() {

            @Override
            public void execute() {
                final Iterator<String> it = deps.iterator();
                injectDependencie(it.next(), new ScheduledCommand() {

                    @Override
                    public void execute() {
                        if (it.hasNext()) {
                            injectDependencie(it.next(), this);
                        }
                    }
                });
            }
        });
    }

    private void injectDependencie(final String dep, final ScheduledCommand command) {
        final String path = GWT.getModuleBaseURL().concat(dep);
        ScriptInjector.fromUrl(path).setWindow(ScriptInjector.TOP_WINDOW).setCallback(new Callback<Void, Exception>() {
            public void onFailure(Exception reason) {
                Logger.getLogger("VkGraph").severe("Failed to load dependencie: " + path);
                command.execute();
            }

            public void onSuccess(Void result) {
                Logger.getLogger("VkGraph").finest("Dependencie plugin loaded: " + path);
                command.execute();
            }
        }).inject();
    }

}
