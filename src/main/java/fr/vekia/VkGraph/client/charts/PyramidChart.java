/*
 * File: $URL: https://vklgraph.googlecode.com/svn/trunk/src/main/java/fr/vekia/VkGraph/client/charts/PyramidChart.java $
 * $Id: PyramidChart.java 35 2012-09-03 16:11:14Z steeve.vandecappelle@gmail.com $
 * Licence MIT
 *
 * Last change:
 * $Date: 2012-09-03 18:11:14 +0200 (lun., 03 sept. 2012) $
 * $Author: steeve.vandecappelle@gmail.com $
 */
package fr.vekia.VkGraph.client.charts;

import java.util.List;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 15 juin 2012. GWTQuery Vekia Showcase
 * @version 1.0
 * 
 *          {@inheritDoc}
 */
public class PyramidChart extends AbstractChart<List<Number>> {

    /**
     * Default constructor
     * 
     */
    public PyramidChart() {
        super();
        super.setRenderer(RenderersEnum.Pyramid);
    }

    /**
     * Default constructor
     * 
     */
    public PyramidChart(I18nFields i18nFields) {
        super(i18nFields);
        super.setRenderer(RenderersEnum.Pyramid);
    }

    @Override
    public void setPluginsEnable(boolean isPluginEnable) {
	throw new UnsupportedOperationException("plugins are not enable to Pyramid Charts");
    }
}
