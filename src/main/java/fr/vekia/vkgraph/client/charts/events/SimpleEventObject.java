package fr.vekia.vkgraph.client.charts.events;

import java.util.HashMap;
import java.util.Map;

import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONValue;

/**
 * Generic group event fired from Jqplot.
 * 
 * @author Steeve Vandecappelle (SVA)
 * @since 17 août 2012. VklGraph version 1.2
 * @version 2.1
 */
public class SimpleEventObject {

    private Map<String, Object> mapValue;
    private Object value;

    /**
     * Constructor used to GWT event creation.
     */
    public SimpleEventObject() {
    }

    /**
     * Set event value if any.
     * 
     * @param value
     *            event value if any null else.
     */
    public void setValue(Object value) {
        this.value = value;
        JSONValue json = JSONParser.parseLenient(stringify(value));
        mapValue = new HashMap<String, Object>();
        for (String key : json.isObject().keySet()) {
            JSONValue valueJson = json.isObject().get(key);
            if (valueJson != null) {
                if (valueJson.isNumber() != null) {
                    mapValue.put(key, valueJson.isNumber().doubleValue());
                } else if (valueJson.isBoolean() != null) {
                    mapValue.put(key, valueJson.isBoolean().booleanValue());
                } else if (valueJson.isString() != null) {
                    mapValue.put(key, valueJson.isString().stringValue());
                }
            }
        }
    }

    /**
     * Get event value if any.
     * 
     * @return the event value if any.
     */
    public Map<String, Object> getValues() {
        return mapValue;
    }

    private native String stringify(Object obj)/*-{
                                               return JSON.stringify(obj, ['type', 'id', 'timestamp', 'data']);
                                               }-*/;
}
