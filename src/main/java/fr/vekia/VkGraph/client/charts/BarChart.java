/*
 * File: $URL: https://vklgraph.googlecode.com/svn/trunk/src/main/java/fr/vekia/VkGraph/client/charts/BarChart.java $
 * $Id: BarChart.java 31 2012-08-30 10:13:37Z steeve.vandecappelle@gmail.com $
 * Licence MIT
 *
 * Last change:
 * $Date: 2012-08-30 12:13:37 +0200 (jeu., 30 août 2012) $
 * $Author: steeve.vandecappelle@gmail.com $
 */
package fr.vekia.VkGraph.client.charts;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 15 juin 2012. GWTQuery Vekia Showcase
 * @version 1.0
 * 
 *          {@inheritDoc}
 */
public class BarChart<T> extends AbstractChart<T> {

    /**
     * Default constructor
     * 
     */
    public BarChart() {
	super.setRenderer(RenderersEnum.Bar);
    }
}
