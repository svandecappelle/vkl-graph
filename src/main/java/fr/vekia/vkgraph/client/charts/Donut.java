package fr.vekia.vkgraph.client.charts;

import fr.vekia.vkgraph.client.options.ChartOption;
import fr.vekia.vkgraph.client.options.SubOption;

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
