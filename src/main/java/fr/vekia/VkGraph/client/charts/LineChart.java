/*
 * File: $URL: https://vklgraph.googlecode.com/svn/trunk/src/main/java/fr/vekia/VkGraph/client/charts/LineChart.java $
 * $Id: LineChart.java 25 2012-08-16 14:04:01Z steeve.vandecappelle@gmail.com $
 * Licence MIT
 *
 * Last change:
 * $Date: 2012-08-16 16:04:01 +0200 (jeu., 16 août 2012) $
 * $Author: steeve.vandecappelle@gmail.com $
 */
package fr.vekia.VkGraph.client.charts;

import fr.vekia.VkGraph.client.charts.RenderersEnum;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 15 juin 2012. GWTQuery Vekia Showcase
 * @version 1.0
 * 
 *          {@inheritDoc} A line chart widget.
 */
public class LineChart<T> extends AbstractChart<T> {

	/**
	 * Default constructor
	 * 
	 */
	public LineChart() {
		super();
		super.setRenderer(RenderersEnum.Line);
	}

	/**
	 * Constructor with specifics I18n constants
	 * 
	 */
	public LineChart(I18nFields i18nFields) {
		super(i18nFields);
		super.setRenderer(RenderersEnum.Line);
	}
}
