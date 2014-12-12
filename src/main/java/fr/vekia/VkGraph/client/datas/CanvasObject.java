/*
 * File: $URL: https://vklgraph.googlecode.com/svn/trunk/src/main/java/fr/vekia/VkGraph/client/datas/Line.java $
 * $Id: Line.java 37 2012-09-07 07:35:08Z steeve.vandecappelle@gmail.com $
 * Licence MIT
 *
 * Last change:
 * $Date: 2012-09-07 09:35:08 +0200 (ven., 07 sept. 2012) $
 * $Author: steeve.vandecappelle@gmail.com $
 */
package fr.vekia.VkGraph.client.datas;

import java.util.List;
import java.util.Map;

import com.google.gwt.json.client.JSONValue;
import fr.vekia.VkGraph.client.charts.NumberType;
import fr.vekia.VkGraph.client.options.SubOption;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 5 sept. 2012. VklGraph version 1.2
 * @version 2.1
 * 
 *          {@inheritDoc}
 */
interface CanvasObject {

	/**
	 * Return the option set on the series Options.
	 * 
	 * @return the optionsMapped
	 */
	public Map<SubOption, String> getOptionsMapped();

	/**
	 * Return the subOptions set on the series Options.
	 * 
	 * @return the subOptions
	 */
	public Map<SubOption, Map<SubOption, String>> getSubSubOptionsMapped();

	/**
	 * Return the subOptions set on the series JSON Options.
	 * 
	 * @return the subSubOptionsMappedWithJson
	 */
	public Map<SubOption, Map<SubOption, JSONValue>> getSubSubOptionsMappedWithJson();

	/**
	 * Set a serie boolean option.
	 * 
	 * @param subOption
	 *            the option.
	 * @param value
	 *            the value of option.
	 */
	public void setBooleanOption(SubOption subOption, boolean value);

	/**
	 * Set a boolean serie option.
	 * 
	 * @param subOption
	 *            the option.
	 * @param subSubOption
	 *            the sub Option.
	 * @param value
	 *            the value of option.
	 */
	public void setBooleanOption(SubOption subOption, SubOption subSubOption, boolean value);

	/**
	 * Set a confidence interval for the serie. <b>IMPORTANT NOTE:<i> the value
	 * is a DualValue list>list with <br>
	 * list(0) = bandTop <br>
	 * list(1) = bandBottom.</i></b>
	 * 
	 * @param value
	 *            the confidence Interval value.
	 */
	public void setConfidenceInterval(List<List<DualValue>> value);

	/**
	 * Set a serie Integer option.
	 * 
	 * @param subOption
	 *            the option.
	 * @param value
	 *            the value of option.
	 */
	public void setNumberOption(SubOption subOption, Number value);

	/**
	 * Set a serie Integer option.
	 * 
	 * @param subOption
	 *            the option.
	 * @param value
	 *            the value of option.
	 */
	public void setNumberOption(SubOption subOption, Number value, NumberType typeOfValue);

	/**
	 * Set an Integer serie option.
	 * 
	 * @param subOption
	 *            the option.
	 * @param subSubOption
	 *            the sub Option.
	 * @param value
	 *            the value of option.
	 */
	public void setNumberOption(SubOption subOption, SubOption subSubOption, Number value);

	/**
	 * Set an Integer serie option.
	 * 
	 * @param subOption
	 *            the option.
	 * @param subSubOption
	 *            the sub Option.
	 * @param value
	 *            the value of option.
	 */
	public void setNumberOption(SubOption subOption, SubOption subSubOption, Number value, NumberType typeOfValue);

	/**
	 * Set a serie array option.
	 * 
	 * @param subOption
	 *            the option.
	 * @param value
	 *            the value of option.
	 */
	public void setOption(SubOption subOption, List<String> value);

	/**
	 * Set a serie String option.
	 * 
	 * @param subOption
	 *            the option.
	 * @param value
	 *            the value of option.
	 */
	public void setOption(SubOption subOption, String value);

	/**
	 * Set a serie option.
	 * 
	 * @param subOption
	 *            the option.
	 * @param subSubOption
	 *            the sub Option.
	 * @param value
	 *            the value of option.
	 */
	public void setOption(SubOption subOption, SubOption subSubOption, String value);

	/**
	 * Set a serie text option.
	 * 
	 * @param subOption
	 *            the option.
	 * @param value
	 *            the value of option.
	 */
	public void setTextOption(SubOption subOption, String value);

	/**
	 * Set a serie text option.
	 * 
	 * @param subOption
	 *            the option.
	 * @param subSubOption
	 *            the sub Option.
	 * @param value
	 *            the value of option.
	 */
	public void setTextOption(SubOption subOption, SubOption subSubOption, String value);

	/**
	 * Get the type of canvas object
	 */
	public SubOption getType();
}