/*
 * File: $URL: https://vklgraph.googlecode.com/svn/trunk/src/main/java/fr/vekia/VkGraph/client/options/ChartOption.java $
 * $Id: ChartOption.java 37 2012-09-07 07:35:08Z steeve.vandecappelle@gmail.com $
 * Licence MIT
 * 
 * Last change:
 * $Date: 2012-09-07 09:35:08 +0200 (ven., 07 sept. 2012) $
 * $Author: steeve.vandecappelle@gmail.com $
 */
package fr.vekia.VkGraph.client.options;

import java.io.Serializable;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 4 mai 2012. GWTQuery Vekia Showcase
 * @version 1.0
 * 
 *          {@inheritDoc} The chart available options.
 */
public enum ChartOption implements IsOption, HasType, Serializable {
    seriesColors,
    stackSeries,
    title,
    axesDefaults,
    axes,
    seriesDefaults,
    series,
    legend,
    grid,
    cursor,
    dragable(OptionType.BOOLEAN, true),
    highlighter,
    animate(OptionType.BOOLEAN),
    animateReplot(OptionType.BOOLEAN),
    defaultAxisStart,
    canvasOverlay,
    fillBetween,
    captureRightClick;

    private OptionType type;
    private boolean hasChildren = false;

    /**
     * Default constructor
     * 
     */
    private ChartOption() {
    }

    /**
     * Default constructor
     * 
     */
    private ChartOption(OptionType type) {
	this.type = type;
    }

    /**
     * Default constructor
     * 
     */
    private ChartOption(OptionType type, boolean hasChildren) {
	this.type = type;
	this.hasChildren = hasChildren;
    }

    /**
     * @return the type
     */
    public OptionType getType() {
	return type;
    }

    /**
     * @return the hasChildren
     */
    public boolean hasChildren() {
	return hasChildren;
    }
}
