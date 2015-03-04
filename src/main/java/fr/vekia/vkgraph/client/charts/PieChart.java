package fr.vekia.vkgraph.client.charts;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 4 mai 2012. GWTQuery Vekia Showcase
 * @version 1.0
 * 
 *          {@inheritDoc}A pie chart widget.
 */
public class PieChart<T> extends AbstractChart<T> {
    /**
     * Default constructor
     * 
     */
    public PieChart() {
        super();
        setRenderer(RenderersEnum.Pie);
    }

    /**
     * Constructor with i18n specifics
     * 
     */
    public PieChart(I18nFields i18nFields) {
        super(i18nFields);
        setRenderer(RenderersEnum.Pie);
    }

    @Override
    public void setPluginsEnable(boolean isPluginEnable) {
        throw new UnsupportedOperationException("plugins are not enable to Pyramid Charts");
    }
}
