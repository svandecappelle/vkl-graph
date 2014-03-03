/*
 * File: $URL: https://vklgraph.googlecode.com/svn/trunk/src/main/java/fr/vekia/VkGraph/client/charts/BubbleChart.java $
 * $Id: BubbleChart.java 26 2012-08-20 10:05:52Z steeve.vandecappelle@gmail.com $
 * Licence MIT
 *
 * Last change:
 * $Date: 2012-08-20 12:05:52 +0200 (lun., 20 août 2012) $
 * $Author: steeve.vandecappelle@gmail.com $
 */
package fr.vekia.VkGraph.client.charts;

import fr.vekia.VkGraph.client.datas.BubbleValue;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 15 juin 2012. GWTQuery Vekia Showcase
 * @version 1.0
 * 
 *          {@inheritDoc}
 */
public class BubbleChart extends AbstractChart<BubbleValue> {

    /**
     * Default constructor
     * 
     */
    public BubbleChart() {
	super.setListView(true);
	super.setRenderer(RenderersEnum.Bubble);
    }


 	/**
     * Constructor with specifics I18n constants
     * 
     */
    public BubbleChart(I18nFields i18nFields) {
		super(i18nFields);
		super.setListView(true);
		super.setRenderer(RenderersEnum.Bubble);
    }    
}
