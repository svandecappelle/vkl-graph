/*
 * File: $URL: https://vklgraph.googlecode.com/svn/trunk/src/main/java/fr/vekia/VkGraph/client/charts/Donut.java $
 * $Id: Donut.java 35 2012-09-03 16:11:14Z steeve.vandecappelle@gmail.com $
 * Licence MIT
 * 
 * Last change:
 * $Date: 2012-09-03 18:11:14 +0200 (lun., 03 sept. 2012) $
 * $Author: steeve.vandecappelle@gmail.com $
 */
package fr.vekia.VkGraph.client.charts;

import fr.vekia.VkGraph.client.options.ChartOption;
import fr.vekia.VkGraph.client.options.SubOption;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 4 mai 2012. GWTQuery Vekia Showcase
 * @version 1.0
 * 
 *          {@inheritDoc} A donut chart widget.
 */
public class Donut<T> extends PieChart<T> {
	/**
	 * Default constructor
	 * 
	 */
	public Donut() {
		super();
		super.setRenderer(RenderersEnum.Donut);
		super.setOption(ChartOption.legend, SubOption.renderer, RenderersEnum.DonutLegend.getValueRenderer());
	}

	/**
	 * Constructor with specifics I18n constants
	 * 
	 */
	public Donut(I18nFields i18nFields) {
		super(i18nFields);
		super.setRenderer(RenderersEnum.Donut);
		super.setOption(ChartOption.legend, SubOption.renderer, RenderersEnum.DonutLegend.getValueRenderer());
	}

	@Override
	public void setPluginsEnable(boolean isPluginEnable) {
		throw new UnsupportedOperationException("plugins are not enable to Donut Charts");
	}
}
