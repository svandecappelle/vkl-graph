package fr.vekia.vkgraph.client.charts;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 30 août 2012. VklGraph version 1.2
 * @version 1.3.0
 * 
 *          {@inheritDoc}
 */
public class Exporter {

	private Chart<?> chart;

	/**
	 * Default constructor
	 * 
	 * @param chart
	 */
	public Exporter(Chart<?> chart) {
		this.chart = chart;
	}

	/**
	 * Export the graph. Opening a DialogBox.
	 * 
	 */
	public void export() {
		this.download(this.chart.getId());
	}

	private final native void download(String id) /*-{
													$wnd.jQuery("#".concat(id)).jqplotSaveImage();	
													}-*/;
}
