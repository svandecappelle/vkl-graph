/*
 * File: $URL: https://vklgraph.googlecode.com/svn/trunk/src/main/java/fr/vekia/VkGraph/client/datas/CanvasOverlayObject.java $
 * $Id: CanvasOverlayObject.java 37 2012-09-07 07:35:08Z steeve.vandecappelle@gmail.com $
 * Licence MIT
 *
 * Last change:
 * $Date: 2012-09-07 09:35:08 +0200 (ven., 07 sept. 2012) $
 * $Author: steeve.vandecappelle@gmail.com $
 */
package fr.vekia.VkGraph.client.datas;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;

import fr.vekia.VkGraph.client.datas.utils.MapJSONBuilder;
import fr.vekia.VkGraph.client.options.SubOption;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 5 sept. 2012. VklGraph version 1.2
 * @version 2.1
 * 
 *          {@inheritDoc}
 */
public class CanvasOverlayObject {

    List<Line> lines;

    /**
     * Default constructor
     * 
     */
    public CanvasOverlayObject() {
	lines = new ArrayList<Line>();
    }

    /**
     * 
     */
    public void addLine(Line line) {
	lines.add(line);
    }

    /**
     * 
     */
    public void removeLine(Line line) {
	lines.remove(line);
    }

    /**
     * @return
     */
    public JSONValue getJSON() {
	JSONArray array = new JSONArray();
	int i = 0;
	for (Line linesCanvas : lines) {
	    MapJSONBuilder builder = new MapJSONBuilder();
	    builder.putAllOptions(linesCanvas.getOptionsMapped());
	    builder.putAllSubOptions(linesCanvas.getSubSubOptionsMapped());

	    JSONObject object = new JSONObject();
	    if (linesCanvas instanceof HorizontalLine) {
		if (linesCanvas.isDashed()) {
		    object.put(SubOption.dashedHorizontalLine.name(), builder.getJso());
		} else {
		    object.put(SubOption.horizontalLine.name(), builder.getJso());
		}
	    } else {
		if (linesCanvas.isDashed()) {
		    object.put(SubOption.dashedVerticalLine.name(), builder.getJso());
		} else {
		    object.put(SubOption.verticalLine.name(), builder.getJso());
		}

	    }
	    array.set(i, object);
	    i += 1;
	}

	return array;
    }
}
