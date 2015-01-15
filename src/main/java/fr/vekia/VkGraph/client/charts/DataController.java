/*
 * File: $URL: https://vklgraph.googlecode.com/svn/trunk/src/main/java/fr/vekia/VkGraph/client/charts/DataController.java $
 * $Id: DataController.java 35 2012-09-03 16:11:14Z steeve.vandecappelle@gmail.com $
 * Licence MIT
 *
 * Last change:
 * $Date: 2012-09-03 18:11:14 +0200 (lun., 03 sept. 2012) $
 * $Author: steeve.vandecappelle@gmail.com $
 */
package fr.vekia.VkGraph.client.charts;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.json.client.JSONArray;

import fr.vekia.VkGraph.client.charts.exception.ArraysSizesRefreshingInvalidException;
import fr.vekia.VkGraph.client.datas.DualValue;
import fr.vekia.VkGraph.client.datas.utils.ArrayJSONBuilder;
import fr.vekia.VkGraph.client.datas.utils.MapJSONBuilder;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 30 août 2012. VklGraph version 1.2
 * @version 2.1
 * 
 *          {@inheritDoc}
 */
public class DataController<T> {
	// ## DATAS ##
	// series data to inject into the chart. (List<Object>).
	private List<T> data;
	// series data to inject into the chart. (List<List<Object>>).
	private List<List<T>> listData;
	// Data series injected.
	private JSONArray seriesData;
	private boolean listView = false;

	private Chart<T> chart;

	/**
	 * Default constructor
	 * 
	 * @param chart2
	 * @param chartOptionner
	 */
	public DataController(Chart<T> chart) {
		this.chart = chart;
	}

	/**
	 * Set the data to list of list.
	 * 
	 * @param listData
	 *            the listData to set
	 */
	public void setListData(List<List<T>> listData) {
		int sizeDataList = 0;
		if (this.listData != null) {
			sizeDataList = this.listData.size();
		}
		this.listData = listData;

		if (this.chart.isInjected()) {
			int i = 0;

			if (sizeDataList < listData.size()) {
				throw new ArraysSizesRefreshingInvalidException();
			}

			for (List<T> list : listData) {
				JSONArray arrayData;
				List<DualValue> dataConverted = new ArrayList<DualValue>();
				if (list.get(0) instanceof DualValue) {
					ArrayJSONBuilder<T> builderData = new ArrayJSONBuilder<T>();
					builderData.setData(list);

					arrayData = builderData.getJso();
				} else {
					int j = 1;
					for (T dataValue : list) {
						dataConverted.add(new DualValue(j, (Number) dataValue));
						j += 1;
					}

					ArrayJSONBuilder<DualValue> builderData = new ArrayJSONBuilder<DualValue>();
					builderData.setData(dataConverted);
					arrayData = builderData.getJso();
				}
				this.chart.setSeries(i, arrayData);
				i += 1;
			}
			while (i < sizeDataList) {
				ArrayJSONBuilder<T> builderData = new ArrayJSONBuilder<T>();
				builderData.setData(new ArrayList<T>());
				JSONArray arrayData;
				arrayData = builderData.getJso();
				this.chart.setSeries(i, arrayData);
				i += 1;
			}
		}
	}

	/**
	 * set the data to list of T parametrized chart.
	 * 
	 * @param data
	 *            the data to set
	 */
	public void setData(List<T> data) {
		this.data = data;
		if (this.chart.isInjected()) {

			JSONArray arrayData;
			if (data.get(0) instanceof DualValue) {
				ArrayJSONBuilder<T> builderData = new ArrayJSONBuilder<T>();
				builderData.setData(data);

				arrayData = builderData.getJso();
			} else {
				List<DualValue> dataConverted = new ArrayList<DualValue>();

				int i = 1;
				for (T dataValue : data) {
					dataConverted.add(new DualValue(i, (Number) dataValue));
					i += 1;
				}

				ArrayJSONBuilder<DualValue> builderData = new ArrayJSONBuilder<DualValue>();
				builderData.setData(dataConverted);
				arrayData = builderData.getJso();
			}

			this.chart.setSeries(0, arrayData);
		}
	}

	/**
	 * Get data in simple view
	 * 
	 * @return the chart data
	 */
	public List<T> getDatas() {
		return data;
	}

	/**
	 * Get the chart data
	 * 
	 * Is used when the data are a list representation. (as example if line
	 * chart and 1 dimension. See JQplot documentation / Showcase to see more
	 * details.)
	 * 
	 * @return the data of chart needs to be displayed.
	 */
	public List<List<T>> getListData() {
		return listData;
	}

	/**
	 * Get the generated JSON options.
	 * 
	 * @return the JSON JavaScript object
	 */
	public JavaScriptObject getInjectionOptions() {
		MapJSONBuilder builder = new MapJSONBuilder();
		builder.putAllChartOption(this.chart.getChartOptionner().getOptionsMapped());
		builder.putAllChartSubOption(this.chart.getChartOptionner().getSubSubOptionsMapped());
		
		builder.putAllChartSubOptionInJavascript(this.chart.getChartOptionner().getSubSubOptionsMappedInJavascript());
		
		builder.addSeriesData(this.getSeriesData());
		return builder.getJso().getJavaScriptObject();
	}

	/**
	 * Get the generated JSON data.
	 * 
	 * @return the JSON JavaScript object
	 */
	public JavaScriptObject getInjectionData() {
		ArrayJSONBuilder<T> builderData = new ArrayJSONBuilder<T>();

		if (getDatas() != null) {
			builderData.setData(getDatas());
		} else {
			builderData.setListData(getListData());
		}
		JSONArray arrayData;
		if (getListData() == null && this.isListView()) {
			arrayData = new JSONArray();
			arrayData.set(0, builderData.getJso());
		} else {
			arrayData = builderData.getJso();
		}
		return arrayData.getJavaScriptObject();
	}

	/**
	 * 
	 * 
	 * @param isListView
	 */
	public void setListView(boolean isListView) {
		this.listView = isListView;
	}

	/**
	 * @return the listView
	 */
	public boolean isListView() {
		return listView;
	}

	/**
	 * @param seriesData
	 */
	public void setSeriesData(JSONArray seriesData) {
		this.seriesData = seriesData;
	}

	/**
	 * @return the seriesData
	 */
	public JSONArray getSeriesData() {
		return seriesData;
	}
}
