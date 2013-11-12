/*
 * File: $URL: svn+ssh://chimay/home/svn/VkGraph-showcase/VkGraph-showcase/src/main/java/fr.vekia.tools.showcase.vkgraph/client/showcase/application/components/menu/groups/plots/screens/AxisRotatedExempleScreen.java $
 * $Id: AxisRotatedExempleScreen.java 41 2012-08-30 13:58:36Z svandecappelle $
 * Licence MIT
 * 
 * Last change:
 * $Date: 2012-08-30 15:58:36 +0200 (jeu., 30 août 2012) $
 * $Author: svandecappelle $
 */
package fr.vekia.tools.showcase.vkgraph.client.showcase.application.demo.screens.simple;

import java.util.ArrayList;

import fr.vekia.VkGraph.client.charts.AbstractChart;
import fr.vekia.VkGraph.client.charts.RenderersEnum;
import fr.vekia.VkGraph.client.options.ChartOption;
import fr.vekia.VkGraph.client.options.SubOption;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 14 mai 2012. GWTQuery Vekia Showcase
 * @version 1.0
 * 
 *          {@inheritDoc}
 */
public class AxisRotatedExempleScreen extends AbstractChart<Number> {

	/**
	 * Default constructor
	 * 
	 */
	public AxisRotatedExempleScreen() {

		super.setOption(ChartOption.axes, SubOption.xaxis,
				SubOption.tickOptions, "{angle: -30}");
		super.setOption(ChartOption.axes, SubOption.xaxis,
				SubOption.tickRenderer,
				RenderersEnum.CanvasAxisTick.getValueRenderer());

		super.setOption(ChartOption.axes, SubOption.xaxis,
				SubOption.labelRenderer,
				RenderersEnum.CanvasAxisLabel.getValueRenderer());
		super.setTextOption(ChartOption.axes, SubOption.xaxis, SubOption.label,
				"Core Motor Amperage");
		super.setOption(ChartOption.axes, SubOption.xaxis,
				SubOption.labelsOptions,
				"{fontFamily:'Helvetica',fontSize: '14pt'}");

		super.setOption(ChartOption.axes, SubOption.yaxis, SubOption.renderer,
				RenderersEnum.LogAxis.getValueRenderer());

		super.setOption(ChartOption.axes, SubOption.yaxis,
				SubOption.tickRenderer,
				RenderersEnum.CanvasAxisTick.getValueRenderer());
		super.setOption(ChartOption.axes, SubOption.yaxis,
				SubOption.tickOptions, "{angle: -30}");

		ArrayList<Number> datas = new ArrayList<Number>();

		datas.add(6);
		datas.add(9);
		datas.add(14);
		datas.add(19);
		datas.add(26);
		datas.add(35);
		datas.add(51);

		super.setListView(true);

		super.setDatas(datas);

	}
}