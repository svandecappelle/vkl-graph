package fr.vekia.vkgraph.client.datas;

/**
 * @author svandecappelle
 * @since Jan 14, 2013. VklGraph version : 2.1
 * @version 2.1
 * 
 *          {@inheritDoc}
 */
public class OhlcData implements GraphDataI {

	/**
	 * SerialId For serialize
	 */
	private static final long serialVersionUID = 3778076121269507834L;

	private String category;
	private Number[] data;

	public OhlcData() {
		super();
	}

	/**
	 * Default constructor
	 * 
	 */
	public OhlcData(String key, Number... datas) {
		this.category = key;
		this.data = datas;
	}

	/**
	 * @param category
	 *            the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * @return the category
	 */
	public Object getCategory() {
		return category;
	}

	/**
	 * @param data
	 *            the data to set
	 */
	public void setData(Number[] data) {
		this.data = data;
	}

	/**
	 * @return the data
	 */
	public final Number[] getData() {
		return data;
	}

	@Override
	public String toString() {
		StringBuilder dataStr = new StringBuilder();
		dataStr.append("[");
		if (category instanceof String) {
			dataStr.append("\"" + category + "\"");
		} else {
			dataStr.append(category);
		}
		dataStr.append(",");
		for (int i = 0; i < data.length; i++) {
			Object arrayElement = data[i];
			if (i == data.length - 1) {
				dataStr.append(arrayElement);
			} else {
				dataStr.append(arrayElement + ",");
			}
		}
		dataStr.append("]");
		return dataStr.toString();
	}
}
