/*
 * File: $URL: https://vklgraph.googlecode.com/svn/trunk/src/main/java/fr/vekia/VkGraph/client/datas/SquareValue.java $
 * $Id: SquareValue.java 25 2012-08-16 14:04:01Z steeve.vandecappelle@gmail.com $
 * Licence MIT
 *
 * Last change:
 * $Date: 2012-08-16 16:04:01 +0200 (jeu., 16 août 2012) $
 * $Author: steeve.vandecappelle@gmail.com $
 */
package fr.vekia.VkGraph.client.datas;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 27 juil. 2012. VklGraph version 1.2
 * @version 2.1
 * 
 *          {@inheritDoc}
 */
public class SquareValue extends ComplexeValue {

    public SquareValue(){
        super();
    }

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
    public SquareValue(String label, Number x, Number y) {
	super(label, x, y);
    }

    @Override
    public String toString() {
	return "[" + getX() + "," + getY() + "," + "\"" + getLabel() + "\"" + "]";
    }
}
