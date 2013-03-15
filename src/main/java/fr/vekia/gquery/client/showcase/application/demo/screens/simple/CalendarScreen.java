/*
 * File: $URL$
 * $Id$
 * Licence MIT
 *
 * Last change:
 * $Date$
 * $Author$
 */
package fr.vekia.gquery.client.showcase.application.demo.screens.simple;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.datepicker.client.CalendarUtil;

import fr.vekia.VkGraph.client.charts.derive.CalendarChart;
import fr.vekia.VkGraph.client.datas.PeriodCalendar;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 27 sept. 2012. VklGraph version 1.2
 * @version 2.1
 * 
 *          {@inheritDoc}
 */
public class CalendarScreen extends CalendarChart {
    @SuppressWarnings("deprecation")
    static final DateTimeFormat format = DateTimeFormat.getMediumTimeFormat();

    static Date today;
    static Date from;

    static Date periodOneFrom;
    static Date periodOneTo;
    static Date periodThreeFrom;
    static Date periodThreeTo;
    static Date periodTwoFrom;
    static Date periodTwoTo;
    static Date to;

    static {
	// DATAS:
	today = new Date();

	from = CalendarUtil.copyDate(today);
	CalendarUtil.addDaysToDate(from, -20);

	periodOneFrom = CalendarUtil.copyDate(today);
	CalendarUtil.addDaysToDate(periodOneFrom, 20);

	periodOneTo = CalendarUtil.copyDate(today);
	CalendarUtil.addDaysToDate(periodOneTo, 45);

	periodThreeFrom = CalendarUtil.copyDate(periodOneFrom);
	CalendarUtil.addDaysToDate(periodThreeFrom, -20);

	periodThreeTo = CalendarUtil.copyDate(periodOneTo);
	CalendarUtil.addDaysToDate(periodThreeTo, 5);

	periodTwoFrom = CalendarUtil.copyDate(today);
	CalendarUtil.addDaysToDate(periodTwoFrom, 2);

	periodTwoTo = CalendarUtil.copyDate(today);
	CalendarUtil.addDaysToDate(periodTwoTo, 5);

	to = CalendarUtil.copyDate(periodOneTo);
	CalendarUtil.addDaysToDate(to, 20);

    }

    /**
     * Default constructor
     * 
     */
    public CalendarScreen() {
	super(from, to);
	List<PeriodCalendar> periods = new ArrayList<PeriodCalendar>();
	periods.add(new PeriodCalendar(1f, periodOneFrom, periodOneTo, "lime", "Period 1"));
	periods.add(new PeriodCalendar(1.5f, periodTwoFrom, periodTwoTo, "orange", "Period 2"));
	periods.add(new PeriodCalendar(2f, periodTwoFrom, periodTwoTo, "red", "Period 3"));
	periods.add(new PeriodCalendar(3f, periodThreeFrom, periodThreeTo, "lightblue", "Period 4"));

	super.setSize("850px", "250px");

	List<String> ticks = new ArrayList<String>();
	ticks.add("France");
	ticks.add("Belgique");
	ticks.add("Italy");
	super.setTicks(ticks);
	super.setZoomEnable(true);
	super.setPeriodCalendar(periods);
	super.addTodayLine();
    }
}
