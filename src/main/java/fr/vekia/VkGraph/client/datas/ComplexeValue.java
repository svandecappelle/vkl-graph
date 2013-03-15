/*
 * File: $URL: https://vklgraph.googlecode.com/svn/trunk/src/main/java/fr/vekia/VkGraph/client/datas/ComplexeValue.java $
 * $Id: ComplexeValue.java 25 2012-08-16 14:04:01Z steeve.vandecappelle@gmail.com $
 * Licence MIT
 *
 * Last change:
 * $Date: 2012-08-16 16:04:01 +0200 (jeu., 16 août 2012) $
 * $Author: steeve.vandecappelle@gmail.com $
 */
package fr.vekia.VkGraph.client.datas;


/**
 * @author Steeve Vandecappelle (SVA)
 * @since 16 août 2012. VklGraph version 1.2
 * @version 2.1
 * 
 *          {@inheritDoc}
 */
public abstract class ComplexeValue implements GraphDataI{
    private String label;

    private Number x;
    private Number y;

    /**
     * Default constructor
     * 
     * @param label
     *            the UIwidget label.
     * @param x
     *            the X position on chart.
     * @param y
     *            the Y position on chart.
     */
    public ComplexeValue(String label, Number x, Number y) {
	super();
	this.label = label;
	this.x = x;
	this.y = y;
    }

    /**
     * Get the UIwidget label.
     * 
     * @return the UIwidget label.
     */
    public String getLabel() {
	return label;
    }

    /**
     * Set the UIwidget label.
     * 
     * @param label
     *            the UIwidget label.
     */
    public void setLabel(String label) {
	this.label = label;
    }

    /**
     * Get the X position on chart.
     * 
     * @return the X position on chart.
     */
    public Number getX() {
	return x;
    }

    /**
     * Set the X position on chart.
     * 
     * @param x
     *            the X position on chart.
     */
    public void setX(Number x) {
	this.x = x;
    }

    /**
     * Get the Y position on chart.
     * 
     * @return the Y position on chart.
     */
    public Number getY() {
	return y;
    }

    /**
     * Set the Y position on chart.
     * 
     * @param y
     *            the Y position on chart.
     */
    public void setY(Number y) {
	this.y = y;
    }

    @Override
    public String toString() {
	return "[" + x + "," + y + "," + "\"" + label + "\"" + "]";
    }
}
