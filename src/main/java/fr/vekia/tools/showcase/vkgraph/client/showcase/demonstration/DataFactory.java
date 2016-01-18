/*
 * File: $URL: svn+ssh://chimay/home/svn/VkGraph-showcase/VkGraph-showcase/src/main/java/fr.vekia.tools.showcase.vkgraph/client/showcase/application/components/menu/DataFactory.java $
 * $Id: DataFactory.java 42 2012-08-31 13:58:13Z svandecappelle $
 * Licence MIT
 *
 * Last change:
 * $Date: 2012-08-31 15:58:13 +0200 (ven., 31 août 2012) $
 * $Author: svandecappelle $
 */
package fr.vekia.tools.showcase.vkgraph.client.showcase.demonstration;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import fr.vekia.vkgraph.client.datas.DualValue;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 21 août 2012. VklGraph version 1.2
 * @version 2.1
 * 
 *          {@inheritDoc}
 */
public final class DataFactory {

	/**
	 * Default constructor
	 * 
	 */
	private DataFactory() {
	}

	public static List<String> getLabels() {

		List<String> labels = new LinkedList<String>();
		labels.add("Alsace");
		labels.add("Aquitaine");
		labels.add("Auvergne");
		labels.add("Basse-Normandie");
		labels.add("Bourgogne");
		labels.add("Bretagne");
		labels.add("Centre");
		labels.add("Champagne-Ardenne");
		labels.add("Corse");
		labels.add("Franche-Comté");
		labels.add("Haute-Normandie");
		labels.add("Île-de-France");
		labels.add("Languedoc-Roussillon");
		labels.add("Limousin");
		labels.add("Lorraine");
		labels.add("Midi-Pyrénées");
		labels.add("Nord-Pas-de-Calais");
		labels.add("Pays de la Loire");
		labels.add("Picardie");
		labels.add("Poitou-Charentes");
		labels.add("Provence-Alpes-Côte d'Azur");
		labels.add("Rhône-Alpes");
		return labels;
	}

	public static List<Number> getValues() {
		final List<Number> values = new LinkedList<Number>();
		values.add(1843053);
		values.add(3206137);
		values.add(1343964);
		values.add(1470880);
		values.add(1642440);
		values.add(3175064);
		values.add(2538590);
		values.add(1337953);
		values.add(305674);
		values.add(1168208);
		values.add(1832942);
		values.add(11728240);
		values.add(2610890);
		values.add(741785);
		values.add(2350112);
		values.add(2862707);
		values.add(4033197);
		values.add(3539048);
		values.add(1911157);
		values.add(1760575);
		values.add(4889053);
		values.add(6174040);
		return values;
	}

	public static List<List<Number>> getListOfValues() {
		return null;

	}

	public static List<DualValue> getListOfDualValues() {
		List<DualValue> dataOutput = new LinkedList<DualValue>();
		List<Number> values = getValues();
		int i = 0;
		for (String dataLabel : getLabels()) {
			dataOutput.add(new DualValue(dataLabel, values.get(i)));
			i += 1;
		}
		return dataOutput;
	}

	public static List<List<DualValue>> getListOfListOfDualValues() {

		List<List<DualValue>> allSeries = new ArrayList<List<DualValue>>();

		List<DualValue> regions = new LinkedList<DualValue>();
		List<DualValue> france = new LinkedList<DualValue>();

		allSeries.add(france);
		allSeries.add(regions);

		france.add(new DualValue("North", 7777296));
		france.add(new DualValue("Center", 19332972));
		france.add(new DualValue("South", 20048501));
		france.add(new DualValue("East", 5361373));
		france.add(new DualValue("West", 9945567));
		// North
		regions.add(new DualValue("Nord-Pas-de-Calais", 4033197));
		regions.add(new DualValue("Picardie", 1911157));
		regions.add(new DualValue("Haute-Normandie", 1832942));
		// Center
		regions.add(new DualValue("Île-de-France", 11728240));
		regions.add(new DualValue("Champagne-Ardenne", 1337953));
		regions.add(new DualValue("Centre", 2538590));
		regions.add(new DualValue("Bourgogne", 1642440));
		regions.add(new DualValue("Auvergne", 1343964));
		regions.add(new DualValue("Limousin", 741785));
		// South
		regions.add(new DualValue("Aquitaine", 3206137));
		regions.add(new DualValue("Midi-Pyrénées", 2862707));
		regions.add(new DualValue("Languedoc-Roussillon", 2610890));
		regions.add(new DualValue("Provence-Alpes-Côte d'Azur", 4889053));
		regions.add(new DualValue("Corse", 305674));
		regions.add(new DualValue("Rhône-Alpes", 6174040));
		// East
		regions.add(new DualValue("Alsace", 1843053));
		regions.add(new DualValue("Lorraine", 2350112));
		regions.add(new DualValue("Franche-Comté", 1168208));
		// West
		regions.add(new DualValue("Basse-Normandie", 1470880));
		regions.add(new DualValue("Pays de la Loire", 3539048));
		regions.add(new DualValue("Bretagne", 3175064));
		regions.add(new DualValue("Poitou-Charentes", 1760575));

		return allSeries;
	}
}
