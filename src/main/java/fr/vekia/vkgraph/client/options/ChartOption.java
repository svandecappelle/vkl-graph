package fr.vekia.vkgraph.client.options;

import java.io.Serializable;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 4 mai 2012. GWTQuery Vekia Showcase
 * @version 1.0
 * 
 *          {@inheritDoc} The chart available options.
 */
@SuppressWarnings("squid:S00115")
public enum ChartOption implements IsOption, HasType, Serializable {
    seriesColors,
    stackSeries,
    title,
    axesDefaults,
    axes,
    seriesDefaults,
    series,
    legend,
    grid,
    cursor,
    dragable(OptionType.BOOLEAN, true),
    highlighter,
    animate(OptionType.BOOLEAN),
    animateReplot(OptionType.BOOLEAN),
    defaultAxisStart,
    canvasOverlay,
    fillBetween,
    captureRightClick,
    noDataIndicator,
    background;

    private OptionType type;
    private boolean hasChildren = false;

    /**
     * Default constructor
     * 
     */
    private ChartOption() {
    }

    /**
     * Default constructor
     * 
     */
    private ChartOption(OptionType type) {
        this.type = type;
    }

    /**
     * Default constructor
     * 
     */
    private ChartOption(OptionType type, boolean hasChildren) {
        this.type = type;
        this.hasChildren = hasChildren;
    }

    /**
     * @return the type
     */
    @Override
    public OptionType getType() {
        return type;
    }

    /**
     * @return the hasChildren
     */
    @Override
    public boolean hasChildren() {
        return hasChildren;
    }
}
