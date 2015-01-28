package fr.vekia.vkgraph.client.datas;

import java.util.List;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 31 mai 2012. GWTQuery Vekia Showcase
 * @version 1.0
 * 
 *          {@inheritDoc} An utility class to load data on chart.
 */
@SuppressWarnings("squid:S1948")
public class DataGraph<T> {

	private List<T> data;
	private boolean multiple;

	public DataGraph() {

	}

	/**
	 * Set the DataGraph value to convert.
	 * 
	 * @param convertData
	 *            data to convert.
	 */
	public void setValue(List<T> convertData) {
		this.data = convertData;
	}

	/**
	 * Get the data.
	 * 
	 * @return the data.
	 */
	public List<T> getData() {
		return data;
	}

	/**
	 * Set the data is multi-dimension.
	 * 
	 * @param isMultiple
	 *            <code>true</code> to set multi.
	 */
	public void setMultiple(boolean isMultiple) {
		this.multiple = isMultiple;
	}

	/**
	 * Get the data is multi-dimension.
	 * 
	 * @return <code>true</code> if data are muli dimension.
	 */
	public boolean isMultiple() {
		return multiple;
	}

}
