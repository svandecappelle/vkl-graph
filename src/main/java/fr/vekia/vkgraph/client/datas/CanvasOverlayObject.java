package fr.vekia.vkgraph.client.datas;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;

import fr.vekia.vkgraph.client.datas.utils.MapJSONBuilder;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 5 sept. 2012. VklGraph version 1.2
 * @version 2.1
 * 
 *          {@inheritDoc}
 */
public class CanvasOverlayObject implements Serializable {

    /**
     * SerialId For serialize
     */
    private static final long serialVersionUID = -4819397730650698500L;

    private List<CanvasObject> lines;

    /**
     * Default constructor
     * 
     */
    public CanvasOverlayObject() {
        lines = new ArrayList<CanvasObject>();
    }

    /**
     * 
     */
    public void addObject(CanvasObject line) {
        lines.add(line);
    }

    /**
     * 
     */
    public void removeObject(CanvasObject line) {
        lines.remove(line);
    }

    /**
     * @return
     */
    public JSONValue getJSON() {
        JSONArray array = new JSONArray();
        int i = 0;
        for (CanvasObject objCanvas : lines) {
            MapJSONBuilder builder = new MapJSONBuilder();
            builder.putAllOptions(objCanvas.getOptionsMapped());
            builder.putAllSubOptions(objCanvas.getSubSubOptionsMapped());

            JSONObject object = new JSONObject();
            object.put(objCanvas.getType().name(), builder.getJso());

            array.set(i, object);
            i += 1;
        }

        return array;
    }
}
