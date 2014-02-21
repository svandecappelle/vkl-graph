/*
 * File: $URL$
 * $Id$
 * Copyright: Vekia
 *
 * Last change:
 * $Date$
 * $Author$
 */
package fr.vekia.VkGraph.client.datas;

/**
 * @author svandecappelle
 * @since Jan 14, 2013. VklGraph version : 2.1
 * @version 2.1
 * 
 *          {@inheritDoc}
 */
public class OhlcData implements GraphDataI {

    private Object category;
    private Object[] data;

    public OhlcData(){
        super();
    }

    /**
     * Default constructor
     * 
     */
    public OhlcData(Object key, Object... datas) {
	this.category = key;
	this.data = datas;
    }

    /**
     * @param category
     *            the category to set
     */
    public void setCategory(String category) {
	this.category = category;
    }

    /**
     * @return the category
     */
    public Object getCategory() {
	return category;
    }

    /**
     * @param data
     *            the data to set
     */
    public void setData(Object[] data) {
	this.data = data;
    }

    /**
     * @return the data
     */
    public final Object[] getData() {
	return data;
    }

    @Override
    public String toString() {
	StringBuilder dataStr = new StringBuilder();
	dataStr.append("[");
	if (category instanceof String) {
	    dataStr.append("\"" + category + "\"");
	} else {
	    dataStr.append(category);
	}
	dataStr.append(",");
	for (int i = 0; i < data.length; i++) {
	    Object arrayElement = data[i];
	    if (i == data.length - 1) {
		dataStr.append(arrayElement);
	    } else {
		dataStr.append(arrayElement + ",");
	    }
	}
	dataStr.append("]");
	return dataStr.toString();
    }
}
