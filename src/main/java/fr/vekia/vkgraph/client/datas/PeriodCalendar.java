package fr.vekia.vkgraph.client.datas;

import java.util.Date;

import com.google.gwt.i18n.client.DateTimeFormat;

import fr.vekia.vkgraph.client.charts.NumberType;
import fr.vekia.vkgraph.client.options.SubOption;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 28 sept. 2012. VklGraph version 1.2
 * @version 2.1
 * 
 *          {@inheritDoc}
 */
public class PeriodCalendar extends HorizontalLine {
    /**
     * SerialId For serialize
     */
    private static final long serialVersionUID = 5718133709782222637L;

    @SuppressWarnings("deprecation")
    private static final DateTimeFormat DEFAULT_DATE_FORMAT = DateTimeFormat.getMediumTimeFormat();

    private static final int LINE_WIDTH = 10;

    public PeriodCalendar() {
        super();
    }

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
        super.setNumberOption(SubOption.lineWidth, LINE_WIDTH);
        super.setTextOption(SubOption.name, name);
        super.setBooleanOption(SubOption.shadow, false);
        super.setBooleanOption(SubOption.showTooltip, true);
        super.setOption(SubOption.tooltipFormatString, name + "<br/> <dd> [ " + DEFAULT_DATE_FORMAT.format(xmin) + " - " + DEFAULT_DATE_FORMAT.format(xmax) + "]</dd>");
        super.setNumberOption(SubOption.xmin, xmin.getTime(), NumberType.LONG);
        super.setNumberOption(SubOption.xmax, xmax.getTime(), NumberType.LONG);
    }
}
