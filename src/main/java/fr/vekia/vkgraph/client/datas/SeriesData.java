package fr.vekia.vkgraph.client.datas;

import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 25 mai 2012. GWTQuery Vekia Showcase
 * @version 1.0
 * 
 *          {@inheritDoc}<br>
 *          A List of specified series render options. Used to mix graph type
 *          (Line/Area etc... ) on the same chart widget.
 */
public class SeriesData {

    private Map<Integer, OptionSerie> optionsSeries;

    /**
     * Default constructor
     * 
     */
    public SeriesData() {
        optionsSeries = new TreeMap<Integer, OptionSerie>();
    }

    /**
     * Set the serie index render option.
     */
    public void set(int indexSerie, OptionSerie options) {
        optionsSeries.put(indexSerie, options);
    }

    /**
     * Get the serie index render option.
     * 
     * @param indexSerie
     *            the serie index.
     * @return the render option.
     */
    public OptionSerie getOptionSerie(int indexSerie) {
        return optionsSeries.get(indexSerie);
    }

    /**
     * Get the series Linked with a specific Option.
     * 
     * @return the series Linked with a specific Option.
     */
    public Collection<OptionSerie> getSeriesLinked() {
        return optionsSeries.values();
    }
}
