package fr.vekia.vkgraph.client.charts;

import fr.vekia.vkgraph.client.datas.BubbleValue;

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
