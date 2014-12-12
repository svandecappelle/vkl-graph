/*
 * File: $URL: https://vklgraph.googlecode.com/svn/trunk/src/main/java/fr/vekia/VkGraph/client/charts/Gauge.java $
 * $Id: Gauge.java 37 2012-09-07 07:35:08Z steeve.vandecappelle@gmail.com $
 * Licence MIT
 * 
 * Last change:
 * $Date: 2012-09-07 09:35:08 +0200 (ven., 07 sept. 2012) $
 * $Author: steeve.vandecappelle@gmail.com $
 */
package fr.vekia.VkGraph.client.charts;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 4 mai 2012. GWTQuery Vekia Showcase
 * @version 1.0
 * 
 *          {@inheritDoc} A donut chart widget.
 */
public class Gauge implements IsWidget {

	private AbstractChart<Number> gauge;

	/**
	 * Default constructor
	 * 
	 */
	public Gauge() {
		gauge = new AbstractChart<Number>() {
			@Override
			public void setPluginsEnable(boolean isPluginEnable) {
				throw new UnsupportedOperationException("plugins are not enable to Pyramid Charts");
			}
		};
		gauge.setRenderer(RenderersEnum.MeterGauge);
		gauge.setListView(true);
	}

	/**
	 * Default constructor
	 * 
	 */
	public Gauge(I18nFields i18nFields) {
		gauge = new AbstractChart<Number>(i18nFields) {
			@Override
			public void setPluginsEnable(boolean isPluginEnable) {
				throw new UnsupportedOperationException("plugins are not enable to Pyramid Charts");
			}
		};
		gauge.setRenderer(RenderersEnum.MeterGauge);
		gauge.setListView(true);
	}

	@Override
	public Widget asWidget() {
		return gauge;
	}

	public void setData(Number data) {
		List<Number> number = new ArrayList<Number>();
		number.add(data);
		gauge.setData(number);
	}

	public AbstractChart<Number> toAbstractChart() {
		return gauge;
	}

}
