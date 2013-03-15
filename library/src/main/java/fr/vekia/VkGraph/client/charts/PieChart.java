/*
 * File: $URL: https://vklgraph.googlecode.com/svn/trunk/src/main/java/fr/vekia/VkGraph/client/charts/PieChart.java $
 * $Id: PieChart.java 35 2012-09-03 16:11:14Z steeve.vandecappelle@gmail.com $
 * Licence MIT
 * 
 * Last change:
 * $Date: 2012-09-03 18:11:14 +0200 (lun., 03 sept. 2012) $
 * $Author: steeve.vandecappelle@gmail.com $
 */
package fr.vekia.VkGraph.client.charts;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 4 mai 2012. GWTQuery Vekia Showcase
 * @version 1.0
 * 
 *          {@inheritDoc}A pie chart widget.
 */
public class PieChart<T> extends AbstractChart<T> {
    /**
     * Default constructor
     * 
     */
    public PieChart() {
	setRenderer(RenderersEnum.Pie);
    }

    @Override
    public void setPluginsEnable(boolean isPluginEnable) {
	throw new UnsupportedOperationException("plugins are not enable to Pyramid Charts");
    }
}
