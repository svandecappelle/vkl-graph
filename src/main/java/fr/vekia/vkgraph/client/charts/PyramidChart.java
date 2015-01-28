package fr.vekia.vkgraph.client.charts;

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
