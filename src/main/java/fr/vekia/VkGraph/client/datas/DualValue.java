/*
 * File: $URL: https://vklgraph.googlecode.com/svn/trunk/src/main/java/fr/vekia/VkGraph/client/datas/DualValue.java $
 * $Id: DualValue.java 36 2012-09-05 09:31:37Z steeve.vandecappelle@gmail.com $
 * Licence MIT
 * 
 * Last change:
 * $Date: 2012-09-05 11:31:37 +0200 (mer., 05 sept. 2012) $
 * $Author: steeve.vandecappelle@gmail.com $
 */
package fr.vekia.VkGraph.client.datas;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 22 mai 2012. GWTQuery Vekia Showcase
 * @version 1.0
 * 
 *          {@inheritDoc} A dual Value bean. Key/Value (Key can be a Number / String).
 *          <ul>
 *          <li>If the key is String: you should use a</li>
 *          <ul>
 *          <li>If the X-axis is a DateRenderer: You can use the 'dd/mm/yyy' format or any supported format JavaScript date.You should use the
 *          Timestamp if possible (See below)</li>
 *          <li>If the X-axis is a CategoryRenderer: The label is translated by a new category.</li>
 *          </ul>
 *          <ul>
 *          <li>If the X-axis is a DateRenderer: You can use the date timestamp. use {@link java.util.Date#getTime()}</li>
 *          </ul>
 *          </ul>
 */
public class DualValue implements GraphDataI {

    private Number keyNumber;
    private String keyString;

    private Number value;


    public DualValue(){
        super();
    }

    /**
     * Default constructor
     * 
     * @param key
     * @param value
     */
    public DualValue(Number key, Number value) {
	super();
	this.keyNumber = key;
	this.value = value;
    }

    /**
     * Default constructor
     * 
     * @param keyString
     * @param value
     */
    public DualValue(String keyString, Number value) {
	super();
	this.keyString = keyString;
	this.value = value;
    }

    /**
     * @return
     */
    public String getKey() {
	if (isKeyString()) {
	    return keyString;
	} else {
	    return keyNumber.toString();
	}
    }

    /**
     * Set the {@link Number} key.
     * 
     * @param key
     *            the number key.
     */
    public void setKey(Number key) {
	this.keyNumber = key;
    }

    /**
     * Get the Y value.
     * 
     * @return the Y value.
     */
    public Number getValue() {
	return value;
    }

    /**
     * Set the Y value.
     * 
     * @param value
     *            the Y value.
     */
    public void setValue(Number value) {
	this.value = value;
    }

    /**
     * Get the {@link String} key
     * 
     * @return the keyString.
     */
    public String getKeyString() {
	return keyString;
    }

    /**
     * Set the {@link String} key.
     * 
     * @param keyString
     *            the keyString to set
     */
    public void setKeyString(String keyString) {
	this.keyString = keyString;
    }

    /**
     * Get the {@link Number} key.
     * 
     * @return the keyNumber
     */
    public Number getKeyNumber() {
	return keyNumber;
    }

    /**
     * Return <code>true</code> if key is a {@link String}.
     */
    public boolean isKeyString() {
	return this.keyString != null;
    }

    @Override
    public String toString() {
	StringBuilder dataStr = new StringBuilder();
	dataStr.append("[");
	if (isKeyString()) {
	    dataStr.append("\"" + getKey() + "\"");
	} else {
	    dataStr.append(getKey());
	}
	dataStr.append(",");
	dataStr.append(getValue());
	dataStr.append("]");
	return dataStr.toString();

    }
}
