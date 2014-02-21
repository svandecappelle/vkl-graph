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
 * @since Jan 16, 2013. VklGraph version : 2.1
 * @version 2.1
 * 
 *          {@inheritDoc}
 */
public class NumberData extends Number implements GraphDataI {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private Number data;

    public NumberData(){
        super();
    }

    /**
     * Default constructor
     * 
     */
    public NumberData(Number data) {
	this.data = data;
    }

    @Override
    public double doubleValue() {
	return data.doubleValue();
    }

    @Override
    public float floatValue() {
	return data.floatValue();
    }

    @Override
    public int intValue() {
	return data.intValue();
    }

    @Override
    public long longValue() {
	return data.longValue();
    }

    @Override
    public String toString() {
	return data.toString();
    }
}
