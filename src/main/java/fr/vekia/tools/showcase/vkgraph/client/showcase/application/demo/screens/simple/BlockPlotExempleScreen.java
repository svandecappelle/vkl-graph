/*
 * File: $URL: svn+ssh://chimay/home/svn/VkGraph-showcase/VkGraph-showcase/src/main/java/fr.vekia.tools.showcase.vkgraph/client/showcase/application/components/menu/groups/plots/screens/BlockPlotExempleScreen.java $
 * $Id: BlockPlotExempleScreen.java 52 2012-09-26 15:26:35Z svandecappelle $
 * Licence MIT
 *
 * Last change:
 * $Date: 2012-09-26 17:26:35 +0200 (mer., 26 sept. 2012) $
 * $Author: svandecappelle $
 */
package fr.vekia.tools.showcase.vkgraph.client.showcase.application.demo.screens.simple;

import java.util.ArrayList;
import java.util.List;

import fr.vekia.VkGraph.client.charts.BlockChart;
import fr.vekia.VkGraph.client.datas.SquareValue;
import fr.vekia.VkGraph.client.options.ChartOption;
import fr.vekia.VkGraph.client.options.SubOption;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 27 juil. 2012. VklGraph version 1.2
 * @version 2.1
 * 
 *          {@inheritDoc}
 */
public class BlockPlotExempleScreen extends BlockChart {

    /**
     * Default constructor
     * 
     */
    public BlockPlotExempleScreen() {

	List<List<SquareValue>> datas = new ArrayList<List<SquareValue>>();

	List<SquareValue> datasL1 = new ArrayList<SquareValue>();
	datasL1.add(new SquareValue("toto", 7, 10));
	datasL1.add(new SquareValue("titi", 4, 17));
	datasL1.add(new SquareValue("tutu", 3, 7));
	datasL1.add(new SquareValue("tata", 2, 4));

	List<SquareValue> datasL2 = new ArrayList<SquareValue>();
	datasL2.add(new SquareValue("bobo", 7, 10));
	datasL2.add(new SquareValue("bibi", 6, 6));
	datasL2.add(new SquareValue("bubu", 2, 9));
	datasL2.add(new SquareValue("baba", 2, 3));

	List<SquareValue> datasL3 = new ArrayList<SquareValue>();
	datasL3.add(new SquareValue("roro", 12, 10));
	datasL3.add(new SquareValue("riri", 4, 10));
	datasL3.add(new SquareValue("ruru", 5, 7));
	datasL3.add(new SquareValue("rara", 9, 4));

	datas.add(datasL1);
	datas.add(datasL2);
	datas.add(datasL3);

	setListData(datas);

	setNumberOption(ChartOption.axes, SubOption.xaxis, SubOption.min, 0);

    }

}
