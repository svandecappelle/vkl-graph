package fr.vekia.vkgraph.client.datas.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import fr.vekia.vkgraph.client.datas.DataGraph;
import fr.vekia.vkgraph.client.datas.DualValue;

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
        if (datas != null && !datas.isEmpty()) {
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
        if (datas != null && !datas.isEmpty()) {
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
        if (datas != null) {
            for (Entry<Object, Number> dataEntry : datas.entrySet()) {

                if (dataEntry.getKey() instanceof Number) {
                    output.add(new DualValue((Number) dataEntry.getKey(), dataEntry.getValue()));
                } else if (dataEntry.getKey() != null) {
                    output.add(new DualValue(dataEntry.getKey().toString(), dataEntry.getValue()));
                }

            }
        }
        return output;
    }
}
