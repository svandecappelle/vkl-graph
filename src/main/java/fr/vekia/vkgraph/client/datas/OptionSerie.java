package fr.vekia.vkgraph.client.datas;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gwt.json.client.JSONValue;

import fr.vekia.vkgraph.client.charts.ChartOptioner;
import fr.vekia.vkgraph.client.charts.NumberType;
import fr.vekia.vkgraph.client.datas.utils.ArrayJSONBuilder;
import fr.vekia.vkgraph.client.datas.utils.JavascriptConvertUtils;
import fr.vekia.vkgraph.client.options.SubOption;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 25 mai 2012. GWTQuery Vekia Showcase
 * @version 1.0
 * 
 *          {@inheritDoc} A chart specific render. You can specify all options
 *          on chart for one data series or more. Then you could create an area
 *          / line chart mixed or any other join.
 */
public class OptionSerie extends SerieOptionBean implements Serializable {
    /**
     * SerialId For serialize
     */
    private static final long serialVersionUID = -8409601771955698471L;

    private transient Map<SubOption, Map<SubOption, JSONValue>> subSubOptionsMappedWithJson;

    /**
     * Default constructor.
     * 
     */
    public OptionSerie() {
        subSubOptionsMappedWithJson = new HashMap<SubOption, Map<SubOption, JSONValue>>();
    }

    /**
     * Return the subOptions set on the series JSON Options.
     * 
     * @return the subSubOptionsMappedWithJson
     */
    public Map<SubOption, Map<SubOption, JSONValue>> getSubSubOptionsMappedWithJson() {
        return subSubOptionsMappedWithJson;
    }

    /**
     * Set a serie boolean option.
     * 
     * @param subOption
     *            the option.
     * @param value
     *            the value of option.
     */
    public void setBooleanOption(SubOption subOption, boolean value) {
        setOption(subOption, Boolean.toString(value));
    }

    /**
     * Set a boolean serie option.
     * 
     * @param subOption
     *            the option.
     * @param subSubOption
     *            the sub Option.
     * @param value
     *            the value of option.
     */
    public void setBooleanOption(SubOption subOption, SubOption subSubOption, boolean value) {
        setOption(subOption, subSubOption, Boolean.toString(value));
    }

    /**
     * Set a confidence interval for the serie. <b>IMPORTANT NOTE:<i> the value
     * is a DualValue list>list with <br>
     * list(0) = bandTop <br>
     * list(1) = bandBottom.</i></b>
     * 
     * @param value
     *            the confidence Interval value.
     */
    public void setConfidenceInterval(List<List<DualValue>> value) {
        ArrayJSONBuilder<DualValue> valuesBuilder = new ArrayJSONBuilder<DualValue>();
        valuesBuilder.setListData(value);

        this.setOption(SubOption.rendererOptions, SubOption.bandData, valuesBuilder.getJso());
    }

    /**
     * Set a serie Integer option.
     * 
     * @param subOption
     *            the option.
     * @param value
     *            the value of option.
     */
    public void setNumberOption(SubOption subOption, Number value) {
        setOption(subOption, ChartOptioner.getStringNumberValue(value, NumberType.INT));
    }

    /**
     * Set a serie Integer option.
     * 
     * @param subOption
     *            the option.
     * @param value
     *            the value of option.
     */
    public void setNumberOption(SubOption subOption, Number value, NumberType typeOfValue) {
        setOption(subOption, ChartOptioner.getStringNumberValue(value, typeOfValue));
    }

    /**
     * Set an Integer serie option.
     * 
     * @param subOption
     *            the option.
     * @param subSubOption
     *            the sub Option.
     * @param value
     *            the value of option.
     */
    public void setNumberOption(SubOption subOption, SubOption subSubOption, Number value) {
        setOption(subOption, subSubOption, ChartOptioner.getStringNumberValue(value, NumberType.INT));
    }

    /**
     * Set an Integer serie option.
     * 
     * @param subOption
     *            the option.
     * @param subSubOption
     *            the sub Option.
     * @param value
     *            the value of option.
     */
    public void setNumberOption(SubOption subOption, SubOption subSubOption, Number value, NumberType typeOfValue) {
        setOption(subOption, subSubOption, ChartOptioner.getStringNumberValue(value, typeOfValue));
    }

    /**
     * Set a serie array option.
     * 
     * @param subOption
     *            the option.
     * @param value
     *            the value of option.
     */
    public void setOption(SubOption subOption, List<String> value) {
        setOption(subOption, JavascriptConvertUtils.optionArrayStringToString(value));
    }

    /**
     * Set a serie JSO option.
     * 
     * @param subOption
     *            the option.
     * @param subSubOption
     *            the sub Option.
     * @param jso
     *            the value of JSO option.
     */
    private void setOption(SubOption subOption, SubOption subSubOption, JSONValue jso) {
        if (subSubOptionsMappedWithJson == null) {
            subSubOptionsMappedWithJson = new HashMap<SubOption, Map<SubOption, JSONValue>>();
        }

        if (subSubOptionsMappedWithJson.containsKey(subOption)) {
            subSubOptionsMappedWithJson.get(subOption).put(subSubOption, jso);
        } else {
            Map<SubOption, JSONValue> subsubOptionMapCreated = new HashMap<SubOption, JSONValue>();
            subsubOptionMapCreated.put(subSubOption, jso);
            subSubOptionsMappedWithJson.put(subOption, subsubOptionMapCreated);
        }
    }

    /**
     * Set a serie array option.
     * 
     * @param subOption
     *            the option.
     * @param subSubOption
     *            the sub Option.
     * @param value
     *            the value of option.
     */
    public void setOption(SubOption subOption, SubOption subSubOption, List<String> value) {
        setOption(subOption, subSubOption, JavascriptConvertUtils.optionArrayStringToString(value));
    }

    /**
     * Set a serie text option.
     * 
     * @param subOption
     *            the option.
     * @param value
     *            the value of option.
     */
    public void setTextOption(SubOption subOption, String value) {
        setOption(subOption, value);
    }

    /**
     * Set a serie text option.
     * 
     * @param subOption
     *            the option.
     * @param subSubOption
     *            the sub Option.
     * @param value
     *            the value of option.
     */
    public void setTextOption(SubOption subOption, SubOption subSubOption, String value) {
        setOption(subOption, subSubOption, value);
    }

    /**
     * Get options in a serialized context.
     * 
     * @return the series options.
     */
    public SerializableSeries get() {
        return new SerializableSeries(this.getOptionsMapped(), this.getSubSubOptionsMapped());
    }
}
