package fr.vekia.vkgraph.client.datas.utils;

import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONException;
import com.google.gwt.json.client.JSONNumber;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.json.client.JSONValue;

import fr.vekia.vkgraph.client.options.ChartOption;
import fr.vekia.vkgraph.client.options.SubOption;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 22 juin 2012. GWTQuery Vekia Showcase
 * @version 1.0
 * 
 *          {@inheritDoc} A JSON object Builder Utility class.
 */
public class MapJSONBuilder {

    private static final Logger LOGGER = Logger.getLogger("JSONBuilder");

    private JSONObject jso = new JSONObject();

    private static final String RGB_PATTERN = "rgb";
    private static final String RGBA_PATTERN = "rgba";
    private static final String JQPLOT_PATTERN = "$.jqplot";

    /**
     * Default constructor.
     * 
     */
    public MapJSONBuilder() {
    }

    /**
     * Store a key of JSON value.
     * 
     * @param key
     *            the JSON key
     * @param value
     *            the JSON Value.
     */
    public void store(String key, Object value) {
        if (value instanceof String) {
            dispatchString(key, (String) value);
        } else if (value instanceof JavaScriptObject) {
            dispatchJavascript(key, (JavaScriptObject) value);
        } else {
            throw new IllegalArgumentException("Type not yet supported in options");
        }
    }

    private void dispatchJavascript(String key, JavaScriptObject value) {
        jso.put(key, new JSONObject(value));
    }

    private void dispatchString(String key, String value) {
        String buildingValue = value;

        if (buildingValue.startsWith(JQPLOT_PATTERN)) {
            jso.put(key, new JSONObject(eval(buildingValue)));
        } else {
            if (buildingValue.startsWith("'")) {
                jso.put(key, new JSONString(buildingValue));
            } else if (buildingValue.startsWith("{")) {
                jso.put(key, JSONParser.parseLenient(buildingValue));
            } else if (buildingValue.startsWith("[")) {
                try {
                    jso.put(key, JSONParser.parseStrict(buildingValue));
                } catch (JSONException e) {
                    LOGGER.log(Level.FINE, "JSONParseStrict not allowed (system try another solution): ", e);
                    buildingValue = buildingValue.replaceFirst("\\[", "");
                    buildingValue = buildingValue.replaceFirst("\\]", "");

                    JSONValue arrayData;

                    if (buildingValue.contains(RGBA_PATTERN)) {
                        arrayData = createRGBColorArrayJson(buildingValue, RGBA_PATTERN);
                    } else if (buildingValue.contains(RGB_PATTERN)) {
                        arrayData = createRGBColorArrayJson(buildingValue, RGB_PATTERN);
                    } else {
                        arrayData = createStringArrayJson(buildingValue);
                    }
                    jso.put(key, arrayData);
                }

            } else {

                try {
                    jso.put(key, JSONParser.parseStrict(buildingValue));
                } catch (JSONException e) {
                    jso.put(key, new JSONString(buildingValue));
                }
            }
        }
    }

    /**
     * Create a RGB color JSON array with his String array.<br>
     * [rgb(255,255,255),rgba(156,156,156,0.4)]
     * 
     * @param value
     *            the String array representation.
     * @param pattern
     *            the RGB color pattern.
     * @return the JSONArray.
     */
    private JSONArray createRGBColorArrayJson(String value, String pattern) {
        int i = 0;
        JSONArray arrayData = new JSONArray();
        for (String stringDataValue : value.split(pattern)) {
            String savedString = stringDataValue;
            if (!stringDataValue.contains(pattern)) {
                savedString = savedString.replaceFirst("\\(", pattern + "(");
                savedString = savedString.replaceFirst("\\)\",\"", ")");
                savedString = savedString.replaceFirst("\\),", ")");
            }
            if (savedString.contains(pattern)) {
                arrayData.set(i, new JSONString(savedString));
                i += 1;
            }
        }
        return arrayData;
    }

    /**
     * Create a JSON array with his String array.<br>
     * [10,12]
     * 
     * @param value
     *            the String array representation.
     * @return the JSONArray.
     */
    private JSONValue createStringArrayJson(String value) {
        int i = 0;
        JSONArray arrayData = new JSONArray();
        try {
            return JSONParser.parseLenient("[" + value + "]");
        } catch (Exception e) {
            for (String stringDataValue : value.split(", ")) {
                try {
                    arrayData.set(i, new JSONNumber(Double.parseDouble(stringDataValue)));
                } catch (Exception ex) {
                    arrayData.set(i, new JSONString(stringDataValue));
                }
                i += 1;
            }
        }
        return arrayData;
    }

    /**
     * Evaluate a renderer JavascriptObject value.
     * 
     * @param value
     *            the renderer String valueRenderer
     *            {@link fr.vekia.vkgraph.client.charts.RenderersEnum#getValueRenderer()} .
     * @return the {@link JavaScriptObject} of the renderer.
     */
    private JavaScriptObject eval(String value) {
        return RendererFactory.getRendererInstance(value);
    }

    /**
     * Get the JSON String value of the key.
     * 
     * @param key
     *            the JSON key.
     * @return the Value.
     */
    public String retrieve(String key) {
        return jso.get(key).isString().stringValue();
    }

    /**
     * Put all values on the {@link JSONObject}.
     * 
     * @param map
     *            the key/value JSON objects to put.
     */
    public void putAll(Map<String, String> map) {
        for (Entry<String, String> mapEntry : map.entrySet()) {
            store(mapEntry.getKey(), mapEntry.getValue());
        }
    }

    /**
     * Get the JSON object representation instance.
     * 
     * @return the jso.
     */
    public JSONObject getJso() {
        return jso;
    }

    /**
     * Put all values on the {@link JSONObject}.
     * 
     * @param optionsMapped
     *            the key/value JSON objects to put.
     */
    public void putAllChartOption(Map<ChartOption, Map<SubOption, String>> optionsMapped) {
        if (optionsMapped != null && !optionsMapped.isEmpty()) {
            for (Entry<ChartOption, Map<SubOption, String>> mapEntry : optionsMapped.entrySet()) {
                store(mapEntry.getKey(), mapEntry.getValue());
            }
        }
    }

    /**
     * Store all keys on JSON value.
     * 
     * @param key
     *            the {@link ChartOption} key
     * @param value
     *            the JSON SubOption Values map.
     */
    private void store(ChartOption key, Map<SubOption, String> value) {
        if (value != null && !value.isEmpty()) {
            if (value.containsKey(null)) {
                store(key.name(), value.get(null));
            } else {
                MapJSONBuilder builder = new MapJSONBuilder();
                builder.putAllOptions(value);
                if (!jso.containsKey(key.name())) {
                    jso.put(key.name(), builder.getJso());
                } else {
                    for (Entry<SubOption, String> entry : value.entrySet()) {
                        try {
                            jso.get(key.name()).isObject().put(entry.getKey().name(), JSONParser.parseLenient(entry.getValue()));
                        } catch (JSONException e) {
                            jso.get(key.name()).isObject().put(entry.getKey().name(), new JSONString(entry.getValue()));
                        }
                    }

                }
            }
        }
    }

    /**
     * Store all subOption on JSON value.
     * 
     * @param value
     *            the JSON SubOption Values map.
     */
    public void putAllOptions(Map<SubOption, ?> value) {
        for (Entry<SubOption, ?> entryOptions : value.entrySet()) {
            if (entryOptions.getKey() != null && entryOptions.getValue() != null) {
                store(entryOptions.getKey().name(), entryOptions.getValue());
            }
        }
    }

    /**
     * Store all subSubOption on JSON value.
     * 
     * @param subSubOptionsMapped
     *            the JSON subSubOption Values map.
     */
    public void putAllChartSubOption(Map<ChartOption, Map<SubOption, Map<SubOption, String>>> subSubOptionsMapped) {
        if (subSubOptionsMapped != null) {
            for (Entry<ChartOption, Map<SubOption, Map<SubOption, String>>> mapEntry : subSubOptionsMapped.entrySet()) {
                if (mapEntry.getValue() != null && !mapEntry.getValue().isEmpty()) {
                    storeSubOption(mapEntry.getKey(), mapEntry.getValue());
                }
            }
        }
    }

    /**
     * Store all chart keys on JSON value.
     * 
     * @param key
     *            the {@link ChartOption} key
     * @param value
     *            the JSON SubOption Values map.
     */
    private void storeSubOption(ChartOption key, Map<SubOption, Map<SubOption, String>> value) {
        MapJSONBuilder builder = new MapJSONBuilder();
        builder.putAllSubOptions(value);
        if (!jso.containsKey(key.name())) {
            jso.put(key.name(), builder.getJso());
        } else {
            for (Entry<SubOption, Map<SubOption, String>> subOption : value.entrySet()) {

                if (jso.get(key.name()).isObject().containsKey(subOption.getKey().name())) {
                    for (Entry<SubOption, String> subsubOptions : subOption.getValue().entrySet()) {
                        // TODO Check this test ! Should be subOption test and
                        // not subsubOption.
                        if (!jso.get(key.name()).isObject().containsKey(subsubOptions.getKey().name())) {
                            try {
                                jso.get(key.name()).isObject().get(subsubOptions.getKey().name()).isObject().put(subsubOptions.getKey().name(), JSONParser.parseLenient(subsubOptions.getValue()));
                            } catch (JSONException e) {
                                jso.get(key.name()).isObject().get(subsubOptions.getKey().name()).isObject().put(subsubOptions.getKey().name(), new JSONString(subsubOptions.getValue()));
                            }
                        } else {
                            try {
                                jso.get(key.name()).isObject().put(subsubOptions.getKey().name(), JSONParser.parseLenient(subsubOptions.getValue()));
                            } catch (JSONException e) {
                                jso.get(key.name()).isObject().put(subsubOptions.getKey().name(), new JSONString(subsubOptions.getValue()));
                            }
                        }
                    }
                } else {
                    MapJSONBuilder builder2 = new MapJSONBuilder();
                    builder2.putAllOptions(subOption.getValue());
                    jso.get(key.name()).isObject().put(subOption.getKey().name(), builder2.getJso());
                }
            }

        }
    }

    /**
     * Store all subSubOption on JSON value.
     * 
     * @param value
     *            the JSON subSubOption Values map.
     */
    public void putAllSubOptions(Map<SubOption, Map<SubOption, String>> value) {
        if (value != null) {
            for (Entry<SubOption, Map<SubOption, String>> entryOptions : value.entrySet()) {
                if (entryOptions.getValue() != null && !entryOptions.getValue().isEmpty()) {
                    MapJSONBuilder builder = new MapJSONBuilder();
                    builder.putAllOptions(entryOptions.getValue());
                    jso.put(entryOptions.getKey().name(), builder.getJso());
                }
            }
        }
    }

    /**
     * Put all series JSON array data on the JSON Value.
     * 
     * @param seriesData
     *            the series Data.
     */
    public void addSeriesData(JSONArray seriesData) {
        jso.put(ChartOption.series.name(), seriesData);
    }

    public void putAllChartSubOptionInJavascript(Map<ChartOption, Map<SubOption, Map<SubOption, JavaScriptObject>>> value) {
        if (value != null) {
            for (Entry<ChartOption, Map<SubOption, Map<SubOption, JavaScriptObject>>> entryOptions : value.entrySet()) {
                if (entryOptions.getValue() != null && !entryOptions.getValue().isEmpty()) {
                    storeSubOptionsJavascript(entryOptions.getKey(), entryOptions.getValue());
                }
            }
        }
    }

    /**
     * Store all subSubOption on JSON value.
     * 
     * @param value
     *            the JSON subSubOption Values map.
     */
    public void putAllSubOptionsInJavascript(Map<SubOption, Map<SubOption, JavaScriptObject>> value) {
        if (value != null) {
            for (Entry<SubOption, Map<SubOption, JavaScriptObject>> entryOptions : value.entrySet()) {
                if (entryOptions.getValue() != null && !entryOptions.getValue().isEmpty()) {
                    MapJSONBuilder builder = new MapJSONBuilder();
                    builder.putAllOptions(entryOptions.getValue());
                    jso.put(entryOptions.getKey().name(), builder.getJso());
                }
            }
        }
    }

    /**
     * Store all chart keys on JSON value.
     * 
     * @param key
     *            the {@link ChartOption} key
     * @param value
     *            the JSON SubOption Values map.
     */
    private void storeSubOptionsJavascript(ChartOption key, Map<SubOption, Map<SubOption, JavaScriptObject>> value) {
        MapJSONBuilder builder = new MapJSONBuilder();
        builder.putAllSubOptionsInJavascript(value);
        if (!jso.containsKey(key.name())) {
            jso.put(key.name(), builder.getJso());
        } else {
            for (Entry<SubOption, Map<SubOption, JavaScriptObject>> subOption : value.entrySet()) {

                if (jso.get(key.name()).isObject().containsKey(subOption.getKey().name())) {
                    for (Entry<SubOption, JavaScriptObject> subsubOptions : subOption.getValue().entrySet()) {
                        if (!jso.get(key.name()).isObject().get(subOption.getKey().name()).isObject().containsKey(subsubOptions.getKey().name())) {
                            jso.get(key.name()).isObject().get(subOption.getKey().name()).isObject().put(subsubOptions.getKey().name(), new JSONObject(subsubOptions.getValue()));
                        } else {
                            jso.get(key.name()).isObject().put(subsubOptions.getKey().name(), new JSONObject(subsubOptions.getValue()));
                        }
                    }
                } else {
                    MapJSONBuilder builder2 = new MapJSONBuilder();
                    builder2.putAllOptions(subOption.getValue());
                    jso.get(key.name()).isObject().put(subOption.getKey().name(), builder2.getJso());
                }
            }

        }
    }

    public void putAllChartOptionInJavascript(Map<ChartOption, Map<SubOption, JavaScriptObject>> value) {
        if (value != null) {
            for (Entry<ChartOption, Map<SubOption, JavaScriptObject>> entryOptions : value.entrySet()) {
                if (entryOptions.getValue() != null && !entryOptions.getValue().isEmpty()) {
                    storeOptionsJavascript(entryOptions.getKey(), entryOptions.getValue());
                }
            }
        }
    }

    /**
     * Store all subSubOption on JSON value.
     * 
     * @param value
     *            the JSON subSubOption Values map.
     */
    public void putAllOptionsInJavascript(Map<SubOption, JavaScriptObject> value) {
        if (value != null) {
            MapJSONBuilder builder = new MapJSONBuilder();
            builder.putAllOptions(value);
        }
    }

    /**
     * Store all chart keys on JSON value.
     * 
     * @param key
     *            the {@link ChartOption} key
     * @param value
     *            the JSON SubOption Values map.
     */
    private void storeOptionsJavascript(ChartOption key, Map<SubOption, JavaScriptObject> value) {
        MapJSONBuilder builder = new MapJSONBuilder();
        builder.putAllOptionsInJavascript(value);
        if (!jso.containsKey(key.name())) {
            jso.put(key.name(), builder.getJso());
        } else {
            for (Entry<SubOption, JavaScriptObject> subOption : value.entrySet()) {
                jso.get(key.name()).isObject().put(subOption.getKey().name(), new JSONObject(subOption.getValue()));
            }
        }
    }

}
