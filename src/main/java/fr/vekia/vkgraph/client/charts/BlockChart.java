package fr.vekia.vkgraph.client.charts;

import fr.vekia.vkgraph.client.datas.SquareValue;

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
