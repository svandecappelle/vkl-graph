package fr.vekia.vkgraph.client.charts;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 15 juin 2012. GWTQuery Vekia Showcase
 * @version 1.0
 * 
 *          {@inheritDoc}
 */
public class BarChart<T> extends AbstractChart<T> {

    /**
     * Default constructor
     * 
     */
    public BarChart() {
        super.setRenderer(RenderersEnum.Bar);
    }

    /**
     * Constructor with specifics I18n constants
     * 
     */
    public BarChart(I18nFields i18nFields) {
        super(i18nFields);
        super.setRenderer(RenderersEnum.Bar);
    }

}
