package fr.vekia.tools.showcase.vkgraph.client;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootLayoutPanel;

import fr.vekia.vkgraph.client.charts.AbstractChart;
import fr.vekia.vkgraph.client.charts.RenderersEnum;
import fr.vekia.vkgraph.client.charts.events.DragStopEvent;
import fr.vekia.vkgraph.client.charts.events.EventObject;
import fr.vekia.vkgraph.client.datas.DualValue;
import fr.vekia.vkgraph.client.datas.OptionSerie;
import fr.vekia.vkgraph.client.datas.SeriesData;
import fr.vekia.vkgraph.client.options.ChartOption;
import fr.vekia.vkgraph.client.options.SubOption;

/**
 * @author svandecappelle
 * @since Jan 14, 2013. VklGraph version : 2.1
 * @version 2.1
 */
public class PilotGraph extends AbstractChart<List<DualValue>> {

    protected int valueModifiedIndex;
    protected int valueRoundedModified;

    /**
     * Default constructor
     * 
     */
    public PilotGraph() {
        List<List<DualValue>> datas = new ArrayList<List<DualValue>>();

        // 0 - Perm infinite
        List<DualValue> lineExtraMaxPerm = new ArrayList<DualValue>();
        lineExtraMaxPerm.add(new DualValue(-100, 6));

        lineExtraMaxPerm.add(new DualValue(1, 6));
        lineExtraMaxPerm.add(new DualValue(2, 6));
        lineExtraMaxPerm.add(new DualValue(3, 6));
        lineExtraMaxPerm.add(new DualValue(4, 6));
        lineExtraMaxPerm.add(new DualValue(5, 6));

        lineExtraMaxPerm.add(new DualValue(100, 6));

        // 1 - Max Perm
        List<DualValue> lineMaxPerm = new ArrayList<DualValue>();
        lineMaxPerm.add(new DualValue(-100, 4));

        lineMaxPerm.add(new DualValue(1, 4));
        lineMaxPerm.add(new DualValue(2, 4));
        lineMaxPerm.add(new DualValue(3, 4));
        lineMaxPerm.add(new DualValue(4, 3));
        lineMaxPerm.add(new DualValue(5, 4));

        lineMaxPerm.add(new DualValue(100, 4));

        // 2 - Target unmodifiable
        // Target:
        List<DualValue> lineCible = new ArrayList<DualValue>();
        lineCible.add(new DualValue(-100, 1));

        lineCible.add(new DualValue(1, 1));
        lineCible.add(new DualValue(2, 1));
        lineCible.add(new DualValue(3, 2));
        lineCible.add(new DualValue(4, 1));
        lineCible.add(new DualValue(5, 1));

        lineCible.add(new DualValue(100, 1));

        // 3 - merch / max
        List<DualValue> max = new ArrayList<DualValue>();
        max.add(new DualValue(-100, 8));

        max.add(new DualValue(1, 8));
        max.add(new DualValue(2, 3));
        max.add(new DualValue(3, 3));
        max.add(new DualValue(4, 3));
        max.add(new DualValue(5, 3));

        max.add(new DualValue(100, 3));

        List<DualValue> merch = new ArrayList<DualValue>();
        merch.add(new DualValue(-100, 1));

        merch.add(new DualValue(1, 1));
        merch.add(new DualValue(2, 1));
        merch.add(new DualValue(3, 1));
        merch.add(new DualValue(4, 1));
        merch.add(new DualValue(5, 1));

        merch.add(new DualValue(100, 1));

        // 4 - Target modifiable
        final List<DualValue> cibleModifiable = new ArrayList<DualValue>();
        cibleModifiable.add(new DualValue(1, 1));
        cibleModifiable.add(new DualValue(2, 1));
        cibleModifiable.add(new DualValue(3, 2));
        cibleModifiable.add(new DualValue(4, 1));
        cibleModifiable.add(new DualValue(5, 1));

        List<List<DualValue>> bandData = new ArrayList<List<DualValue>>();
        bandData.add(max);
        bandData.add(merch);

        // Merch & Max

        List<List<DualValue>> bandDataMaxPerm = new ArrayList<List<DualValue>>();
        bandDataMaxPerm.add(new ArrayList<DualValue>(lineExtraMaxPerm));
        bandDataMaxPerm.add(new ArrayList<DualValue>(lineMaxPerm));

        // Ticks x axis
        final List<String> ticks = new ArrayList<String>();
        ticks.add("XS");
        ticks.add("S");
        ticks.add("M");
        ticks.add("L");
        ticks.add("XL");

        // ############ Adding::
        // 1 perm
        datas.add(lineMaxPerm);
        // 2 merch / max based target
        datas.add(max);

        // 3 target modifiable
        datas.add(cibleModifiable);
        // 4 target
        datas.add(new ArrayList<DualValue>(lineCible));

        super.setData(datas);

        // #################################################################################################################
        // ########################################################## SERIES
        // DATAS #########################################
        // #################################################################################################################

        SeriesData sdata = new SeriesData();
        // Line stock max perm
        OptionSerie lineMaxPermOptions = new OptionSerie();
        lineMaxPermOptions.setConfidenceInterval(bandDataMaxPerm);
        lineMaxPermOptions.setOption(SubOption.rendererOptions, SubOption.bands, "{showLines: true}");
        lineMaxPermOptions.setOption(SubOption.renderer, RenderersEnum.Line.getValueRenderer());
        lineMaxPermOptions.setBooleanOption(SubOption.isDragable, false);
        lineMaxPermOptions.setBooleanOption(SubOption.showMarker, false);
        lineMaxPermOptions.setTextOption(SubOption.label, "Stock MaxiPermanent");

        lineMaxPermOptions.setBooleanOption(SubOption.rendererOptions, SubOption.smooth, true);
        sdata.set(0, lineMaxPermOptions);

        // Merch & Max
        OptionSerie serieStockMerchAndMax = new OptionSerie();
        serieStockMerchAndMax.setConfidenceInterval(bandData);
        serieStockMerchAndMax.setTextOption(SubOption.label, "Marge Merch / Max");
        serieStockMerchAndMax.setBooleanOption(SubOption.showMarker, false);
        serieStockMerchAndMax.setBooleanOption(SubOption.isDragable, false);
        serieStockMerchAndMax.setBooleanOption(SubOption.rendererOptions, SubOption.smooth, true);
        serieStockMerchAndMax.setOption(SubOption.rendererOptions, SubOption.bands, "{showLines: true}");

        sdata.set(1, serieStockMerchAndMax);

        // Target stock pilot
        OptionSerie barOptions = new OptionSerie();
        barOptions.setOption(SubOption.renderer, RenderersEnum.Bar.getValueRenderer());
        barOptions.setBooleanOption(SubOption.rendererOptions, SubOption.fillToZero, true);
        barOptions.setBooleanOption(SubOption.showMarker, false);
        barOptions.setNumberOption(SubOption.rendererOptions, SubOption.barPadding, -50);
        barOptions.setNumberOption(SubOption.rendererOptions, SubOption.barMargin, 20);
        barOptions.setNumberOption(SubOption.rendererOptions, SubOption.barWidth, 50);
        barOptions.setBooleanOption(SubOption.isDragable, true);
        barOptions.setTextOption(SubOption.dragable, SubOption.constrainTo, "y");
        barOptions.setTextOption(SubOption.dragable, SubOption.color, "rgba(255,0,0,0.4)");
        barOptions.setTextOption(SubOption.constrainTo, "y");
        barOptions.setTextOption(SubOption.label, "Stock Pilotage");
        sdata.set(2, barOptions);

        // Line target stock
        OptionSerie lineCibleOptions = new OptionSerie();
        lineCibleOptions.setOption(SubOption.renderer, RenderersEnum.Line.getValueRenderer());
        lineCibleOptions.setBooleanOption(SubOption.isDragable, false);
        lineCibleOptions.setBooleanOption(SubOption.showMarker, true);
        lineCibleOptions.setBooleanOption(SubOption.showLine, true);
        lineCibleOptions.setNumberOption(SubOption.markerOptions, SubOption.size, 15);
        lineCibleOptions.setTextOption(SubOption.markerOptions, SubOption.style, "circle");
        lineCibleOptions.setTextOption(SubOption.label, "Stock cible");
        sdata.set(3, lineCibleOptions);

        super.setSeriesOptions(sdata);

        // #################################################################################################################
        // ########################################################## AXES
        // OPTIONS #########################################
        // #################################################################################################################

        super.setOption(ChartOption.axes, SubOption.xaxis, SubOption.renderer, RenderersEnum.CategoryAxis.getValueRenderer());

        super.setNumberOption(ChartOption.axes, SubOption.yaxis, SubOption.tickInterval, 1);
        super.setNumberOption(ChartOption.axes, SubOption.yaxis, SubOption.min, 0f);
        super.setNumberOption(ChartOption.axes, SubOption.yaxis, SubOption.max, 5);
        super.setOption(ChartOption.axes, SubOption.yaxis, SubOption.tickOptions, "{formatString:'%i piece'}");

        super.setOption(ChartOption.axes, SubOption.xaxis, SubOption.tickRenderer, RenderersEnum.CanvasAxisTick.getValueRenderer());
        super.setOption(ChartOption.axes, SubOption.xaxis, SubOption.tickOptions, "fontSize: '11pt',showMark: false,showGridline: false}");
        super.setOption(ChartOption.axes, SubOption.xaxis, SubOption.labelRenderer, RenderersEnum.CanvasAxisLabel.getValueRenderer());
        super.setOption(ChartOption.axes, SubOption.xaxis, SubOption.labelsOptions, "{fontSize: '11pt'}");
        super.setTextOption(ChartOption.axes, SubOption.xaxis, SubOption.label, "Tailles");
        super.setOption(ChartOption.axes, SubOption.xaxis, SubOption.ticks, ticks);

        super.setOption(ChartOption.axes, SubOption.yaxis, SubOption.tickRenderer, RenderersEnum.CanvasAxisTick.getValueRenderer());
        super.setOption(ChartOption.axes, SubOption.yaxis, SubOption.tickOptions, "{fontSize: '11pt'}");
        super.setOption(ChartOption.axes, SubOption.yaxis, SubOption.labelRenderer, RenderersEnum.CanvasAxisLabel.getValueRenderer());
        super.setOption(ChartOption.axes, SubOption.yaxis, SubOption.labelsOptions, "{fontSize: '11pt'}");
        super.setTextOption(ChartOption.axes, SubOption.yaxis, SubOption.label, "Piece");

        // ##########################################################################################################
        // ########################################################## LEGEND
        // ########################################
        // ##########################################################################################################

        super.setBooleanOption(ChartOption.legend, SubOption.show, true);
        super.setOption(ChartOption.legend, SubOption.renderer, RenderersEnum.EnhancedLegendRenderer.getValueRenderer());

        // ###################################################################################################################
        // ########################################################## SERIES
        // Default #########################################
        // ###################################################################################################################

        super.setNumberOption(ChartOption.seriesDefaults, SubOption.lineWidth, 4.5f);
        super.setBooleanOption(ChartOption.seriesDefaults, SubOption.rendererOptions, SubOption.smooth, true);
        super.setBooleanOption(ChartOption.seriesDefaults, SubOption.shadow, false);
        super.setTextOption(ChartOption.seriesDefaults, SubOption.dragable, SubOption.constrainTo, "y");
        super.setBooleanOption(ChartOption.seriesDefaults, SubOption.trendline, SubOption.show, false);
        super.setBooleanOption(ChartOption.seriesDefaults, SubOption.showMarker, false);

        // #################################################################################################################
        // ##########################################################
        // HIGHLIGHTER ##########################################
        // #################################################################################################################

        StringBuilder formatTooltip = new StringBuilder();
        formatTooltip.append("<table>");
        formatTooltip.append("<tr><td>%i Pièce(s)</td></tr>");
        formatTooltip.append("</table>");

        StringBuilder formatBuilder = new StringBuilder();
        formatBuilder.append("function(x, y){ return 'tutu'; }");

        super.setTextOption(ChartOption.highlighter, SubOption.formatString, formatTooltip.toString());
        super.setOption(ChartOption.highlighter, SubOption.tooltipFormatCallback, formatBuilder.toString());
        super.setBooleanOption(ChartOption.highlighter, SubOption.fadeTooltip, true);
        super.setTextOption(ChartOption.highlighter, SubOption.tooltipAxes, "y");

        // #################################################################################################################
        // ########################################################## COLORS
        // ###############################################
        // #################################################################################################################

        List<String> colors = new ArrayList<String>();
        // max perm
        colors.add("rgba(200,67,56,0.9)");
        // target
        // band data confidance (max - merch)
        // band
        colors.add("rgba(176,223,100,0.6)");
        // lines
        // modifiable
        colors.add("rgba(70,113,190,1)");
        // fixed
        colors.add("rgba(200,200,200,1)");

        super.setColors(colors);

        // #################################################################################################################
        // ########################################################## DIVERS
        // DEMO ##########################################
        // #################################################################################################################

        final Label eventDataLabelValue = new Label();
        final Label eventDataLabelSerie = new Label();

        RootLayoutPanel.get().add(eventDataLabelSerie);
        RootLayoutPanel.get().add(eventDataLabelValue);

        RootLayoutPanel.get().setWidgetLeftWidth(eventDataLabelSerie, 1000, Unit.PX, 100, Unit.PX);
        RootLayoutPanel.get().setWidgetLeftWidth(eventDataLabelValue, 1000, Unit.PX, 100, Unit.PX);

        RootLayoutPanel.get().setWidgetTopHeight(eventDataLabelSerie, 10, Unit.PX, 20, Unit.PX);
        RootLayoutPanel.get().setWidgetTopHeight(eventDataLabelValue, 40, Unit.PX, 20, Unit.PX);

        // #################################################################################################################
        // ########################################################## EVENTS
        // ###############################################
        // #################################################################################################################

        super.bind(new DragStopEvent() {

            @Override
            public void onEvent(EventObject datasOnEvent) {
                if (datasOnEvent.isNative()) {
                    int x = datasOnEvent.getNative().getX();
                    int y = datasOnEvent.getNative().getY();

                    eventDataLabelSerie.setText("Serie: " + ticks.get(x - 1));

                    if (y > 0) {
                        eventDataLabelValue.setText("value: " + y);
                    }
                    PilotGraph.this.valueModifiedIndex = x;
                    PilotGraph.this.valueRoundedModified = y;

                    redrawView(cibleModifiable);
                }
            }
        });

        // #################################################################################################################
        // ########################################################## ANIMATION
        // & DRAG #####################################
        // #################################################################################################################
        super.setPluginsEnable(true);
        super.setBooleanOption(ChartOption.animate, true);
    }

    /**
     * 
     */
    protected void redrawView(List<DualValue> cibleModifiable) {
        cibleModifiable.set(valueModifiedIndex - 1, new DualValue(valueModifiedIndex, valueRoundedModified));
        setSeriesDataAfterInject(2, cibleModifiable);
    }
}
