/*
 * File: $URL: https://vklgraph.googlecode.com/svn/trunk/src/main/java/fr/vekia/VkGraph/client/datas/utils/DataModeler.java $
 * $Id: DataModeler.java 25 2012-08-16 14:04:01Z steeve.vandecappelle@gmail.com $
 * Licence MIT
 * 
 * Last change:
 * $Date: 2012-08-16 16:04:01 +0200 (jeu., 16 août 2012) $
 * $Author: steeve.vandecappelle@gmail.com $
 */
package fr.vekia.VkGraph.client.datas.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import fr.vekia.VkGraph.client.datas.DataGraph;
import fr.vekia.VkGraph.client.datas.DualValue;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 31 mai 2012. GWTQuery Vekia Showcase
 * @version 1.0
 * 
 *          {@inheritDoc} Utility class used to format graph data.
 */
public final class DataModeler {
    private DataModeler() {
    }

    /**
     * Convert List<#Data> to DataGraph<#Data>.
     * 
     * @param datas
     *            the data to convert.
     * @return the data converted to DataGraph.
     */
    public static <T> DataGraph<T> convert(List<T> datas) {
	DataGraph<T> output = new DataGraph<T>();
	if (!datas.isEmpty()) {
	    T element = datas.get(0);
	    if (element instanceof List<?>) {
		output.setMultiple(true);
		output.setValue(datas);
	    }
	    output.setValue(datas);
	}
	return output;
    }

    /**
     * Convert Map<#Object,#Number> to DataGraph<#DualValue>.
     * 
     * @param datas
     *            the data to convert.
     * @return the converted data.
     */
    public static DataGraph<DualValue> convert(Map<Object, Number> datas) {
	DataGraph<DualValue> output = new DataGraph<DualValue>();
	if (!datas.isEmpty()) {
	    output.setValue(convertData(datas));
	}
	return output;
    }

    /**
     * Convert Map<#Object,#Number> to List<#DualValue>.
     * 
     * @param datas
     *            the data to convert.
     * @return the converted data.
     */
    private static List<DualValue> convertData(Map<Object, Number> datas) {
	List<DualValue> output = new ArrayList<DualValue>();
	for (Entry<Object, Number> dataEntry : datas.entrySet()) {

	    if (dataEntry.getKey() instanceof Number) {
		output.add(new DualValue((Number) dataEntry.getKey(), dataEntry.getValue()));
	    } else if (dataEntry.getKey() != null) {
		output.add(new DualValue(dataEntry.getKey().toString(), dataEntry.getValue()));
	    }

	}
	return output;
    }
}
