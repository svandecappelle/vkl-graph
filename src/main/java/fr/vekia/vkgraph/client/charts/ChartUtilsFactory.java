package fr.vekia.vkgraph.client.charts;

/**
 * @author svandecappelle
 * @since Nov 23, 2012. VklGraph version 1.2
 * @version 2.1
 * 
 *          {@inheritDoc}
 */
@SuppressWarnings("rawtypes")
public class ChartUtilsFactory {

	private Chart chart;

	/**
	 * Default constructor
	 * 
	 */
	public ChartUtilsFactory(Chart chart) {
		this.chart = chart;
	}

	/**
     * 
     */
	public void exportOptions() {
		this.chart.getChartOptionner();
	}

	public static void cloneOptions(Chart src, Chart dest) {
		dest.importOptionner(src.getChartOptionner());
	}
}
