/*
 * File: $URL: https://vklgraph.googlecode.com/svn/trunk/src/main/java/fr/vekia/VkGraph/client/charts/exception/ArraysSizesRefreshingInvalidException.java $
 * $Id: ArraysSizesRefreshingInvalidException.java 25 2012-08-16 14:04:01Z steeve.vandecappelle@gmail.com $
 * Licence MIT
 *
 * Last change:
 * $Date: 2012-08-16 16:04:01 +0200 (jeu., 16 août 2012) $
 * $Author: steeve.vandecappelle@gmail.com $
 */
package fr.vekia.vkgraph.client.charts.exception;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 3 août 2012. VklGraph version 1.2
 * @version 2.1
 * 
 *          {@inheritDoc} Exception throwed when the refresh graph is required
 *          but the data are not valid on sizes. Typically when the graph need
 *          to be replot after data series changes and the series number to
 *          refresh is higher than the initial graph. This use case must done
 *          with a complete reinstanciation graph.
 */
public class ArraysSizesRefreshingInvalidException extends IllegalArgumentException {

	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 * 
	 */
	public ArraysSizesRefreshingInvalidException() {
		super("The size of arrays data used to refreshing jqplot chart and the series initializations are different. Create a new chart to do this action.");
	}
}
