/*
 * File: $URL: https://vklgraph.googlecode.com/svn/trunk/src/main/java/fr/vekia/VkGraph/client/datas/PeriodCalendar.java $
 * $Id: PeriodCalendar.java 52 2012-09-28 09:44:34Z steeve.vandecappelle@gmail.com $
 * Licence MIT
 *
 * Last change:
 * $Date: 2012-09-28 11:44:34 +0200 (ven., 28 sept. 2012) $
 * $Author: steeve.vandecappelle@gmail.com $
 */
package fr.vekia.VkGraph.client.datas;

import java.util.Date;

import com.google.gwt.i18n.client.DateTimeFormat;

import fr.vekia.VkGraph.client.charts.NumberType;
import fr.vekia.VkGraph.client.options.SubOption;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 28 sept. 2012. VklGraph version 1.2
 * @version 2.1
 * 
 *          {@inheritDoc}
 */
public class PeriodCalendar extends HorizontalLine {
    @SuppressWarnings("deprecation")
    private static final DateTimeFormat format = DateTimeFormat.getMediumTimeFormat();

    /**
     * Default constructor
     * 
     */
    public PeriodCalendar(float y, Date xmin, Date xmax, String color, String name) {
	this(y, xmin, xmax, name);
	super.setTextOption(SubOption.color, color);
    }

    public PeriodCalendar(float y, Date xmin, Date xmax, String name) {
	super.setNumberOption(SubOption.y, y, NumberType.FLOAT);
	super.setNumberOption(SubOption.lineWidth, 10);
	super.setTextOption(SubOption.name, name);
	super.setBooleanOption(SubOption.shadow, false);
	super.setBooleanOption(SubOption.showTooltip, true);
	super.setOption(SubOption.tooltipFormatString, name + "<br/> <dd> [ " + format.format(xmin) + " - " + format.format(xmax) + "]</dd>");
	super.setNumberOption(SubOption.xmin, xmin.getTime(), NumberType.LONG);
	super.setNumberOption(SubOption.xmax, xmax.getTime(), NumberType.LONG);
    }
}