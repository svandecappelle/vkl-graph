package fr.vekia.vkgraph.client.charts;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONValue;

import fr.vekia.vkgraph.client.datas.CanvasOverlayObject;
import fr.vekia.vkgraph.client.datas.DataGraph;
import fr.vekia.vkgraph.client.datas.DualValue;
import fr.vekia.vkgraph.client.datas.SeriesData;
import fr.vekia.vkgraph.client.datas.utils.DataModeler;
import fr.vekia.vkgraph.client.datas.utils.JavascriptConvertUtils;
import fr.vekia.vkgraph.client.options.ChartOption;
import fr.vekia.vkgraph.client.options.FunctionOption;
import fr.vekia.vkgraph.client.options.SubOption;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 4 mai 2012. GWTQuery Vekia Showcase
 * @version 1.0
 * 
 *          {@inheritDoc}
 */
public class AbstractChart<T> extends Chart<T> {

    /**
     * Default constructor.
     * 
     */
    public AbstractChart() {
        super();

        // default options:
        setBooleanOption(ChartOption.noDataIndicator, SubOption.show, true);
    }

    /**
     * Constructor with specifics I18n constants.
     * 
     */
    public AbstractChart(I18nFields i18nFields) {
        super(i18nFields);
    }

    /**
     * @param option
     * @param value
     */
    public final void setBooleanOption(ChartOption option, boolean value) {
        setOption(option, Boolean.toString(value));
    }

    /**
     * @param option
     * @param subOption
     * @param value
     */
    public final void setBooleanOption(ChartOption option, SubOption subOption, boolean value) {
        setOption(option, subOption, Boolean.toString(value));
    }

    /**
     * @param option
     * @param subOption
     * @param subSubOption
     * @param value
     */
    public final void setBooleanOption(ChartOption option, SubOption subOption, SubOption subSubOption, boolean value) {
        setOption(option, subOption, subSubOption, Boolean.toString(value));
    }

    /**
     * @param canvasoverlay
     * @param canvasDrawOption
     */
    public void setCanvasOverlay(CanvasOverlayObject canvasDrawOption) {
        if (!isInjected()) {
            setOption(ChartOption.canvasOverlay, SubOption.objects, canvasDrawOption.getJSON().toString());
        }
    }

    /**
     * Set the series colors of chart.
     * 
     * @param colors
     *            the series colors data in HEXA, RGB or RGBA.
     */
    public final void setColors(List<String> colors) {
        this.setJsonOption(ChartOption.seriesColors, JavascriptConvertUtils.optionArray(colors));
    }

    /**
     * Set the data of chart.
     * 
     * @param data
     *            the chart data.
     */
    @SuppressWarnings("unchecked")
    public final void setDataGraph(DataGraph<T> data) {
        if (data.isMultiple()) {
            super.setListData((List<List<T>>) data.getData());
        } else {
            setDatasSimpleList((List<T>) data.getData());
        }
    }

    /**
     * Set the data of chart.
     * 
     * @param datas
     *            the chart data.
     */
    public final void setDatas(List<T> datas) {
        this.setDataGraph(DataModeler.convert(datas));
    }

    /**
     * @param data
     */
    private void setDatasSimpleList(List<T> data) {
        StringBuilder dataBuffer = new StringBuilder("[");

        if (data != null && !data.isEmpty()) {
            if (!(data.get(0) instanceof DualValue)) {
                dataBuffer.append("[");
            }
            int i = 0;
            for (T number : data) {
                if (number instanceof DualValue) {
                    dataBuffer.append("[" + ((DualValue) number).getKey() + ", " + ((DualValue) number).getValue() + "]");
                } else if (number != null) {
                    dataBuffer.append(number.toString());
                } else {
                    dataBuffer.append("null");
                }

                if (i != (data.size() - 1)) {
                    dataBuffer.append(",");
                }
                i += 1;
            }

            if (!(data.get(0) instanceof DualValue)) {
                dataBuffer.append("]");
            }
        }

        dataBuffer.append("]");
        super.setData(data);
    }

    /**
     * @param canvasoverlay
     * @param objects
     * @param javaScriptObject
     */
    public final <J extends JSONValue> void setJsonOption(ChartOption chartOption, J javaScriptObject) {
        if (!isInjected()) {
            setOption(chartOption, javaScriptObject.toString());
        }
    }

    /**
     * @param canvasoverlay
     * @param objects
     * @param javaScriptObject
     */
    public final <J extends JSONValue> void setJsonOption(ChartOption chartOption, SubOption subOption, J javaScriptObject) {
        if (!isInjected()) {
            setOption(chartOption, subOption, javaScriptObject.toString());
        }
    }

    /**
     * @param canvasoverlay
     * @param objects
     * @param javaScriptObject
     */
    public final <J extends JSONValue> void setJsonOption(ChartOption chartOption, SubOption subOption, SubOption subSubOption, J javaScriptObject) {
        if (!isInjected()) {
            setOption(chartOption, subOption, subSubOption, javaScriptObject.toString());
        }
    }

    /**
     * @param option
     * @param value
     */
    public final void setNumberOption(ChartOption option, Number value, NumberType typeOfValue) {
        if (!isInjected()) {
            setOption(option, ChartOptioner.getStringNumberValue(value, typeOfValue));
        } else {
            changeProperty(value, option.name());
        }
    }

    /**
     * @param option
     * @param subOption
     * @param value
     */
    public final void setNumberOption(ChartOption option, SubOption subOption, Number value, NumberType typeOfValue) {
        if (!isInjected()) {
            setOption(option, subOption, ChartOptioner.getStringNumberValue(value, typeOfValue));
        } else {
            changeProperty(value, option.name(), subOption.name());
        }
    }

    /**
     * @param option
     * @param subOption
     * @param subSubOption
     * @param value
     */
    public final void setNumberOption(ChartOption option, SubOption subOption, SubOption subSubOption, Number value, NumberType typeOfValue) {
        if (!isInjected()) {
            setOption(option, subOption, subSubOption, ChartOptioner.getStringNumberValue(value, typeOfValue));
        } else {
            changeProperty(value, option.name(), subOption.name(), subSubOption.name());
        }
    }

    /**
     * @param option
     * @param value
     */
    public final void setNumberOption(ChartOption option, Number value) {
        if (!isInjected()) {
            setOption(option, ChartOptioner.getStringNumberValue(value, NumberType.INT));
        } else {
            changeProperty(value, option.name());
        }
    }

    /**
     * @param option
     * @param subOption
     * @param value
     */
    public final void setNumberOption(ChartOption option, SubOption subOption, Number value) {
        if (!isInjected()) {
            setOption(option, subOption, ChartOptioner.getStringNumberValue(value, NumberType.INT));
        } else {
            changeProperty(value, option.name(), subOption.name());
        }
    }

    /**
     * @param option
     * @param subOption
     * @param subSubOption
     * @param value
     */
    public final void setNumberOption(ChartOption option, SubOption subOption, SubOption subSubOption, Number value) {
        if (!isInjected()) {
            setOption(option, subOption, subSubOption, ChartOptioner.getStringNumberValue(value, NumberType.INT));
        } else {
            changeProperty(value, option.name(), subOption.name(), subSubOption.name());
        }
    }

    /**
     * @param option
     * @param value
     */
    public final void setOption(ChartOption option, List<String> value) {
        if (!isInjected()) {
            setJsonOption(option, (JSONValue) JavascriptConvertUtils.optionArray(value));
        } else {
            JSONValue array = JSONParser.parseStrict(value.toString());
            changeProperty(array.isArray(), option.name());
        }
    }

    /**
     * @param option
     * @param value
     */
    public final void setOption(ChartOption option, String value) {
        if (!isInjected()) {
            Map<SubOption, String> optionsSeries;
            if (getChartOptionner().getOptionsMapped() == null) {
                setOptionsMapped(new HashMap<ChartOption, Map<SubOption, String>>());
            }

            if (getChartOptionner().getOptionsMapped().containsKey(option)) {
                optionsSeries = getChartOptionner().getOptionsMapped().get(option);
            } else {
                optionsSeries = new HashMap<SubOption, String>();
                getChartOptionner().getOptionsMapped().put(option, optionsSeries);
            }

            optionsSeries.put(null, value);
        } else {
            changeProperty(value, option.name());
        }
    }

    /**
     * @param option
     * @param subOption
     * @param value
     */
    public final void setOption(ChartOption option, SubOption subOption, List<String> value) {
        if (!isInjected()) {
            setJsonOption(option, subOption, JavascriptConvertUtils.optionArray(value));
        } else {
            JSONValue array = JSONParser.parseStrict(value.toString());
            changeProperty(array.isArray(), option.name(), subOption.name());
        }
    }

    /**
     * @param option
     * @param subOption
     * @param value
     */
    public final void setOption(ChartOption option, SubOption subOption, String value) {
        if (!isInjected()) {
            Map<SubOption, String> optionsSeries;
            if (getChartOptionner().getOptionsMapped() == null) {
                setOptionsMapped(new HashMap<ChartOption, Map<SubOption, String>>());
            }

            if (getChartOptionner().getOptionsMapped().containsKey(option)) {
                optionsSeries = getChartOptionner().getOptionsMapped().get(option);
            } else {
                optionsSeries = new HashMap<SubOption, String>();
                getChartOptionner().getOptionsMapped().put(option, optionsSeries);
            }

            // Set the option value.
            optionsSeries.put(subOption, value);
        } else {
            changeProperty(value, option.name(), subOption.name());
        }
    }

    /**
     * @param option
     * @param subOption
     * @param subSubOption
     * @param value
     */
    public final void setOption(ChartOption option, SubOption subOption, SubOption subSubOption, List<?> value) {
        if (!isInjected()) {
            setJsonOption(option, subOption, subSubOption, JavascriptConvertUtils.optionArray(value));
        } else {
            JSONValue array = JSONParser.parseStrict(value.toString());
            changeProperty(array.isArray(), option.name(), subOption.name(), subSubOption.name());
        }
    }

    /**
     * @param option
     * @param subOption
     * @param subSubOption
     * @param value
     */
    public final void setOption(ChartOption option, SubOption subOption, SubOption subSubOption, JavaScriptObject value) {
        if (!isInjected()) {
            Map<SubOption, Map<SubOption, JavaScriptObject>> optionsSeries;
            if (getChartOptionner().getSubSubOptionsMappedInJavascript() == null) {
                setSubSubOptionsMappedInJavascript(new HashMap<ChartOption, Map<SubOption, Map<SubOption, JavaScriptObject>>>());
            }

            if (getChartOptionner().getSubSubOptionsMappedInJavascript().containsKey(option)) {
                optionsSeries = getChartOptionner().getSubSubOptionsMappedInJavascript().get(option);

                if (optionsSeries.containsKey(subOption)) {
                    Map<SubOption, JavaScriptObject> subSubOptions = optionsSeries.get(subOption);
                    subSubOptions.put(subSubOption, value);
                } else {
                    Map<SubOption, JavaScriptObject> subsubOptionMapCreated = new HashMap<SubOption, JavaScriptObject>();
                    optionsSeries.put(subOption, subsubOptionMapCreated);
                    subsubOptionMapCreated.put(subSubOption, value);
                    optionsSeries.put(subOption, subsubOptionMapCreated);
                }

            } else {
                optionsSeries = new HashMap<SubOption, Map<SubOption, JavaScriptObject>>();
                getChartOptionner().getSubSubOptionsMappedInJavascript().put(option, optionsSeries);

                Map<SubOption, JavaScriptObject> subsubOptionMapCreated = new HashMap<SubOption, JavaScriptObject>();
                subsubOptionMapCreated.put(subSubOption, value);
                optionsSeries.put(subOption, subsubOptionMapCreated);
            }
        } else {
            changeProperty(value, option.name(), subOption.name(), subSubOption.name());
        }
    }

    /**
     * Set option JavaScript native object.
     * 
     * @param option
     * @param subOption
     * @param subSubOption
     * @param value
     */
    public final void setOption(ChartOption option, SubOption subOption, JavaScriptObject value) {
        if (!isInjected()) {
            Map<SubOption, JavaScriptObject> optionsSeries;
            if (getChartOptionner().getSubOptionsMappedInJavascript() == null) {
                setSubOptionsMappedInJavascript(new HashMap<ChartOption, Map<SubOption, JavaScriptObject>>());
            }

            if (getChartOptionner().getSubOptionsMappedInJavascript().containsKey(option)) {
                optionsSeries = getChartOptionner().getSubOptionsMappedInJavascript().get(option);
            } else {
                optionsSeries = new HashMap<SubOption, JavaScriptObject>();
                getChartOptionner().getSubOptionsMappedInJavascript().put(option, optionsSeries);
            }
            optionsSeries.put(subOption, value);

        } else {
            changeProperty(value, option.name(), subOption.name());
        }
    }

    /**
     * @param option
     * @param subOption
     * @param subSubOption
     * @param value
     */
    public final void setOption(ChartOption option, SubOption subOption, SubOption subSubOption, String value) {
        if (!isInjected()) {
            Map<SubOption, Map<SubOption, String>> optionsSeries;
            if (getChartOptionner().getSubSubOptionsMapped() == null) {
                setSubSubOptionsMapped(new HashMap<ChartOption, Map<SubOption, Map<SubOption, String>>>());
            }

            if (getChartOptionner().getSubSubOptionsMapped().containsKey(option)) {
                optionsSeries = getChartOptionner().getSubSubOptionsMapped().get(option);

                if (optionsSeries.containsKey(subOption)) {
                    Map<SubOption, String> subSubOptions = optionsSeries.get(subOption);
                    subSubOptions.put(subSubOption, value);
                } else {
                    Map<SubOption, String> subsubOptionMapCreated = new HashMap<SubOption, String>();
                    optionsSeries.put(subOption, subsubOptionMapCreated);
                    subsubOptionMapCreated.put(subSubOption, value);
                    optionsSeries.put(subOption, subsubOptionMapCreated);
                }

            } else {
                optionsSeries = new HashMap<SubOption, Map<SubOption, String>>();
                getChartOptionner().getSubSubOptionsMapped().put(option, optionsSeries);

                Map<SubOption, String> subsubOptionMapCreated = new HashMap<SubOption, String>();
                subsubOptionMapCreated.put(subSubOption, value);
                optionsSeries.put(subOption, subsubOptionMapCreated);
            }
        } else {
            changeProperty(value, option.name(), subOption.name(), subSubOption.name());
        }
    }

    /**
     * @param renderer
     */
    @Override
    public final void setRenderer(RenderersEnum renderer) {
        super.setRenderer(renderer);
        this.setSeriesDefaultOption(SubOption.renderer, renderer.getValueRenderer());
    }

    /**
     * <b>Important :</b> Could not call after injection
     * 
     * @param option
     * @param value
     */
    public final void setSeriesDefaultOption(SubOption option, String value) {
        setOption(ChartOption.seriesDefaults, option, value);
    }

    /**
     * @param seriesData
     */
    public final void setSeriesOptions(SeriesData seriesData) {
        super.setSeriesData(JavascriptConvertUtils.convert(seriesData));
    }

    /**
     * @param option
     * @param value
     */
    public final void setTextOption(ChartOption option, String value) {
        if (!isInjected()) {
            setOption(option, value);
        } else {
            changeProperty(value, option.name());
        }
    }

    /**
     * @param option
     * @param subOption
     * @param value
     */
    public final void setTextOption(ChartOption option, SubOption subOption, String value) {
        if (!isInjected()) {
            setOption(option, subOption, value);
        } else {
            changeProperty(value, option.name(), subOption.name());
        }
    }

    /**
     * @param option
     * @param subOption
     * @param subSubOption
     * @param value
     */
    public final void setTextOption(ChartOption option, SubOption subOption, SubOption subSubOption, String value) {
        if (!isInjected()) {
            setOption(option, subOption, subSubOption, value);
        } else {
            changeProperty(value, option.name(), subOption.name(), subSubOption.name());
        }
    }

    /**
     * Important note: You cannot yet edit the JavaScript function after graph is drawing
     * 
     * @param option
     *            Option-Chart
     * @param subOption
     *            SubOption
     * @param functionOption
     *            the function to call on property binding.
     */
    public void setFunctionOption(ChartOption option, SubOption subOption, FunctionOption functionOption) {
        if (!isInjected()) {
            setOption(option, subOption, JavascriptConvertUtils.toFunction(functionOption));
        }
    }

    /**
     * Important note: You cannot yet edit the JavaScript function after graph is drawing
     * 
     * @param option
     *            Option-Chart
     * @param subOption
     *            SubOption
     * @param subSubOption
     *            SubSubOption
     * @param functionOption
     *            the function to call on property binding.
     */
    public void setFunctionOption(ChartOption option, SubOption subOption, SubOption subSubOption, FunctionOption functionOption) {
        if (!isInjected()) {
            setOption(option, subOption, subSubOption, JavascriptConvertUtils.toFunction(functionOption));
        }
    }

    /**
     * Change the X axis renderer used to display the X values legend.
     * 
     * @param renderer
     *            the renderer.
     */
    public void setXaxisRenderer(RenderersEnum renderer) {
        this.setOption(ChartOption.axes, SubOption.xaxis, SubOption.renderer, renderer.getValueRenderer());
    }

    /**
     * Change the Y axis renderer used to display the Y values legend.
     * 
     * @param renderer
     *            the renderer.
     */
    public void setYaxisRenderer(RenderersEnum renderer) {
        this.setOption(ChartOption.axes, SubOption.yaxis, SubOption.renderer, renderer.getValueRenderer());
    }

}
