/*
 * File: $URL: https://vklgraph.googlecode.com/svn/trunk/src/main/java/fr/vekia/VkGraph/client/charts/BlockChart.java $
 * $Id: BlockChart.java 26 2012-08-20 10:05:52Z steeve.vandecappelle@gmail.com $
 * Licence MIT
 *
 * Last change:
 * $Date: 2012-08-20 12:05:52 +0200 (lun., 20 août 2012) $
 * $Author: steeve.vandecappelle@gmail.com $
 */
package fr.vekia.VkGraph.client.charts;

import fr.vekia.VkGraph.client.datas.SquareValue;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 15 juin 2012. GWTQuery Vekia Showcase
 * @version 1.0
 * 
 *          {@inheritDoc}
 */
public class BlockChart extends AbstractChart<SquareValue> {

    /**
     * Default constructor
     * 
     */
    public BlockChart() {
	super.setListView(true);
	super.setRenderer(RenderersEnum.Block);
    }


    /**
     * Constructor with specifics I18n constants
     * 
     */
    public BlockChart(I18nFields i18nFields) {
		super(i18nFields);
		super.setListView(true);
		super.setRenderer(RenderersEnum.Block);
    }
}
