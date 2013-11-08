/*
 * File: $URL: svn+ssh://chimay/home/svn/VkGraph-showcase/VkGraph-showcase/src/main/java/fr.vekia.tools.showcase.vkgraph/client/showcase/application/components/menu/groups/plots/screens/PyramidPlotScreen.java $
 * $Id: PyramidPlotScreen.java 53 2012-09-26 15:38:21Z svandecappelle $
 * Licence MIT
 *
 * Last change:
 * $Date: 2012-09-26 17:38:21 +0200 (mer., 26 sept. 2012) $
 * $Author: svandecappelle $
 */
package fr.vekia.tools.showcase.vkgraph.client.showcase.application.demo.screens.simple;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.client.ui.SimplePanel;

import fr.vekia.VkGraph.client.charts.PyramidChart;
import fr.vekia.VkGraph.client.charts.RenderersEnum;
import fr.vekia.VkGraph.client.datas.OptionSerie;
import fr.vekia.VkGraph.client.datas.SeriesData;
import fr.vekia.VkGraph.client.options.ChartOption;
import fr.vekia.VkGraph.client.options.SubOption;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 21 août 2012. VklGraph version 1.2
 * @version 2.1
 * 
 *          {@inheritDoc}
 */
public class PyramidPlotScreen extends SimplePanel {

    /**
     * Default constructor
     * 
     */
    public PyramidPlotScreen() {
	PyramidChart chart = new PyramidChart();
	List<List<Number>> datas = new ArrayList<List<Number>>();
	
	chart.setOption(ChartOption.title, "<div style=\"float:left;width:50%;text-align:center\">Male</div><div style=\"float:right;width:50%;text-align:center\">Female</div>");
	
	datas.add(getMaleEsperence());
	datas.add(getFemaleEsperence());
	datas.add(getMale2Esperence());
	datas.add(getFemale2Esperence());

	chart.setDatas(datas);
	chart.setSize("1100px", "800px");
	chart.setNumberOption(ChartOption.seriesDefaults, SubOption.rendererOptions, SubOption.barPadding, 2);
	chart.setBooleanOption(ChartOption.seriesDefaults, SubOption.rendererOptions, SubOption.offsetBars, true);
	chart.setOption(ChartOption.seriesDefaults, SubOption.yaxis, "yaxis");
	chart.setBooleanOption(ChartOption.seriesDefaults, SubOption.shadow, false);
	chart.setOption(ChartOption.axes, SubOption.xaxis, SubOption.rendererOptions, "{baselineWidth: 2}");
	chart.setOption(ChartOption.axes, SubOption.yaxis, SubOption.label, "Age");
	chart.setOption(ChartOption.axes, SubOption.yaxis, SubOption.labelRenderer, RenderersEnum.CanvasAxisLabel.getValueRenderer());
	chart.setNumberOption(ChartOption.axes, SubOption.yaxis, SubOption.tickInterval, 5);
	chart.setBooleanOption(ChartOption.axes, SubOption.yaxis, SubOption.showMinorTicks, true);
	chart.setOption(ChartOption.axes, SubOption.yaxis, SubOption.rendererOptions, "{category:false}");
	chart.setOption(ChartOption.axes, SubOption.yaxis, SubOption.ticks, getTicks());
	chart.setOption(ChartOption.axes, SubOption.y2axis, SubOption.ticks, getTicks());
	chart.setOption(ChartOption.axes, SubOption.y2axis, SubOption.label, "Age");
	chart.setNumberOption(ChartOption.axes, SubOption.y2axis, SubOption.tickInterval, 5);
	chart.setBooleanOption(ChartOption.axes, SubOption.y2axis, SubOption.showMinorTicks, true);
	chart.setOption(ChartOption.axes, SubOption.y2axis, SubOption.rendererOptions, "{category:false}");
	chart.setNumberOption(ChartOption.defaultAxisStart, 0);

	SeriesData series = new SeriesData();
	OptionSerie maleSeries = new OptionSerie();
	OptionSerie femaleSeries = new OptionSerie();

	OptionSerie male2Series = new OptionSerie();
	OptionSerie female2Series = new OptionSerie();

	maleSeries.setOption(SubOption.rendererOptions, SubOption.side, "left");
	maleSeries.setNumberOption(SubOption.rendererOptions, SubOption.synchronizeHighlight, 1);

	femaleSeries.setOption(SubOption.rendererOptions, SubOption.side, "right");
	femaleSeries.setNumberOption(SubOption.rendererOptions, SubOption.synchronizeHighlight, 0);
	femaleSeries.setOption(SubOption.yaxis, "y2axis");

	male2Series.setOption(SubOption.rendererOptions, SubOption.side, "left");
	male2Series.setBooleanOption(SubOption.rendererOptions, SubOption.fill, false);

	female2Series.setOption(SubOption.rendererOptions, SubOption.side, "right");
	female2Series.setBooleanOption(SubOption.rendererOptions, SubOption.fill, false);
	female2Series.setOption(SubOption.yaxis, "y2axis");

	series.set(0, maleSeries);
	series.set(1, femaleSeries);
	series.set(2, male2Series);
	series.set(3, female2Series);

	chart.setSeriesOptions(series);

	List<String> colors = new ArrayList<String>();
	colors.add("#526D2C");
	colors.add("#77933C");
	colors.add("#C57225");
	colors.add("#C57225");
	chart.setColors(colors);

	setWidget(chart);
    }

    private List<String> getTicks() {
	List<String> ticks = new ArrayList<String>();
	for (int i = 1; i < 75; i++) {
	    ticks.add("" + i);
	}
	return ticks;
    }

    private List<Number> getMaleEsperence() {
	String maleData = "0.635441, 1.066868, 0.889602, 0.816883, 1.016458, 0.916705, 0.79569, 0.970443, 1.046451, 1.335686, 0.926962, 0.936646, 0.919405, 0.722027, 0.896342, 0.993397, 0.613794, 0.916921, 0.828748, 0.43487, 0.391652, 0.517303, 0.507104, 0.336168, 0.554176, 0.691826, 0.66553, 0.686232, 0.7097, 0.356915, 0.756028, 0.430155, 0.420597, 0.608589, 0.609348, 0.83607, 0.79871, 0.63388, 0.866719, 0.711042, 1.160429, 0.439268, 0.659694, 0.468406, 0.340002, 0.996662, 0.371047, 0.638918, 0.462334, 0.467053, 0.545638, 0.463275, 0.480992, 0.515747, 0.499415, 0.287639, 0.520332, 0.443779, 0.334986, 0.43161, 0.474405, 0.179186, 0.620127, 0.219074, 0.411669, 0.495684, 0.315231, 0.275056, 0.157341, 0.113926, 0.24991, 0.128113, 0.175297, 0.103093, 0.253292, 0.988836";
	return getData(maleData);
    }

    /**
     * @param maleData
     * @return
     */
    private List<Number> getData(String dataString) {
	List<Number> data = new ArrayList<Number>();
	for (String number : dataString.split(",")) {
	    data.add(Float.parseFloat(number));
	}
	return data;
    }

    private List<Number> getFemaleEsperence() {
	String femaleData = "0.767078, 0.679554, 1.064493, 0.915063, 0.860792, 0.785728, 0.892471, 0.687886, 1.055313, 0.921839, 0.659624, 1.14516, 0.910735, 1.279864, 0.714669, 0.873929, 0.928453, 0.595752, 1.093534, 0.501142, 0.52829, 0.411606, 0.633309, 0.616121, 0.621781, 0.621598, 0.638378, 0.703724, 0.742589, 0.48523, 0.735727, 0.898816, 0.740614, 0.991105, 1.48909, 1.226996, 1.020624, 0.737742, 0.946817, 0.69129, 0.933744, 0.957472, 0.793112, 0.581121, 0.767528, 1.031739, 1.202133, 0.626926, 0.959522, 0.594303, 1.202145, 0.611707, 0.480779, 0.383338, 0.532876, 0.849878, 0.52453, 0.660183, 0.25419, 0.137567, 0.762322, 0.490294, 0.463194, 0.566921, 0.353006, 0.730591, 0.34669, 0.271638, 0.309785, 0.152756, 0.478111, 0.177234, 0.269302, 0.396318, 0.194934, 1.683044";
	return getData(femaleData);
    }

    private List<Number> getMale2Esperence() {
	String male2Data = "0.230476, 0.175917, 0.225027, 0.40564, 0.408617, 0.495873, 0.441314, 0.282774, 0.47483, 0.393433, 0.580612, 0.220204, 0.514281, 0.32985, 0.514933, 0.507871, 0.398236, 0.362535, 0.603625, 0.528885, 0.550904, 0.87645, 0.857331, 0.713371, 0.703566, 0.703473, 0.858118, 0.751679, 0.832039, 0.752134, 1.202689, 1.069239, 1.051431, 0.732728, 0.992696, 0.828825, 0.723044, 0.857868, 1.088298, 0.86951, 0.914989, 0.549574, 0.672405, 0.637425, 0.530195, 0.706179, 0.941525, 0.576152, 0.913033, 0.647477, 0.734785, 0.441276, 0.583452, 0.537074, 0.7625, 0.662768, 0.307013, 0.384606, 0.470416, 0.22771, 0.470173, 0.152773, 0.338433, 0.348797, 0.10273, 0.285215, 0.139796, 0.186955, 0.143478, 0.178882, 0.141022, 0.1435, 0.146959, 0.056583, 0.05317, 0.784258";
	return getData(male2Data);
    }

    private List<Number> getFemale2Esperence() {
	String female2Data = "0.203297, 0.298698, 0.452947, 0.783013, 0.50033, 0.53629, 0.451817, 0.69927, 0.741356, 0.545433, 0.559643, 0.334842, 0.443899, 0.437309, 0.584658, 0.451757, 0.509258, 0.73483, 0.640501, 0.698825, 0.803701, 1.018148, 1.504918, 0.701318, 0.781324, 1.792142, 0.968484, 1.3288, 1.059729, 1.079985, 2.245553, 1.080526, 1.122927, 1.512428, 1.296163, 1.047212, 0.988065, 1.239462, 1.521174, 1.05187, 1.253013, 0.983437, 1.181799, 1.090029, 0.718064, 1.578813, 1.121987, 1.010202, 1.438581, 1.051654, 1.656156, 0.732428, 0.719311, 0.742441, 0.623806, 0.643911, 0.579092, 0.472909, 0.683453, 0.39008, 0.437458, 0.464595, 0.385552, 0.520029, 0.240536, 0.457316, 0.339587, 0.203276, 0.282141, 0.19517, 0.283663, 0.12404, 0.147211, 0.141153, 0.177653, 1.193951";
	return getData(female2Data);
    }
}
