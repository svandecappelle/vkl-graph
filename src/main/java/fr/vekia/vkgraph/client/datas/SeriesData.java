/*
 * File: $URL: https://vklgraph.googlecode.com/svn/trunk/src/main/java/fr/vekia/VkGraph/client/datas/SeriesData.java $
 * $Id: SeriesData.java 25 2012-08-16 14:04:01Z steeve.vandecappelle@gmail.com $
 * Licence MIT
 * 
 * Last change:
 * $Date: 2012-08-16 16:04:01 +0200 (jeu., 16 août 2012) $
 * $Author: steeve.vandecappelle@gmail.com $
 */
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
