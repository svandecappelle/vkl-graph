package fr.vekia.vkgraph.client.charts;

import fr.vekia.vkgraph.client.charts.RenderersEnum;

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
