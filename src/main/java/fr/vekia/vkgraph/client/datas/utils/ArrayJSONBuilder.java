/*
 * File: $URL: https://vklgraph.googlecode.com/svn/trunk/src/main/java/fr/vekia/VkGraph/client/datas/utils/ArrayJSONBuilder.java $
 * $Id: ArrayJSONBuilder.java 51 2012-09-27 15:52:22Z steeve.vandecappelle@gmail.com $
 * Licence MIT
 *
 * Last change:
 * $Date: 2012-09-27 17:52:22 +0200 (jeu., 27 sept. 2012) $
 * $Author: steeve.vandecappelle@gmail.com $
 */
package fr.vekia.vkgraph.client.datas.utils;

import java.util.List;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONNumber;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONString;

import fr.vekia.vkgraph.client.datas.DualValue;
import fr.vekia.vkgraph.client.datas.OhlcData;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 25 juin 2012. GWTQuery Vekia Showcase
 * @version 1.0
 * 
 *          {@inheritDoc}
 */
public class ArrayJSONBuilder<T> {

	private JSONArray jso = new JSONArray();

	/**
	 * Set the data to the JSON Array.
	 */
	public void setData(List<T> data) {
		int i = 0;
		if (data != null) {
			for (T dataElement : data) {
				if (dataElement != null) {
					if (dataElement instanceof Number) {
						jso.set(i, new JSONNumber(((Number) dataElement).doubleValue()));
					} else if (dataElement instanceof String) {
						jso.set(i, new JSONString((String) dataElement));
					} else if (dataElement instanceof DualValue) {

						JSONArray array = new JSONArray();
						if (((DualValue) dataElement).isKeyString()) {
							array.set(0, new JSONString(((DualValue) dataElement).getKeyString()));
						} else {
							array.set(0, new JSONNumber(((DualValue) dataElement).getKeyNumber().doubleValue()));
						}

						if (((DualValue) dataElement).getValue() != null) {
							array.set(1, new JSONNumber(((DualValue) dataElement).getValue().doubleValue()));
						} else {
							array.set(1, null);
						}

						jso.set(i, array);
					} else if (dataElement instanceof OhlcData) {
						JSONArray array = new JSONArray();
						array.set(0, JSONParser.parseStrict(((OhlcData) dataElement).getCategory().toString()));

						array.set(1, new JSONNumber(((Number) ((OhlcData) dataElement).getData()[0]).doubleValue()));
						array.set(2, new JSONNumber(((Number) ((OhlcData) dataElement).getData()[1]).doubleValue()));
						array.set(3, new JSONNumber(((Number) ((OhlcData) dataElement).getData()[2]).doubleValue()));

						jso.set(i, array);

					} else {
						jso.set(i, JSONParser.parseStrict(dataElement.toString()));
					}

				}
				i += 1;
			}
		}
	}

	/**
	 * Set the data 2 dimensions to the JSON Array. Like Array[][].
	 */
	public void setListData(List<List<T>> data) {
		int i = 0;
		if (data != null) {

			for (List<T> list : data) {

				ArrayJSONBuilder<T> builder = new ArrayJSONBuilder<T>();
				builder.setData(list);
				jso.set(i, builder.getJso());
				i += 1;
			}
		}
	}

	/**
	 * Get the JSON object value.
	 * 
	 * @return JSON object value.
	 */
	public JSONArray getJso() {
		return jso;
	}
}
