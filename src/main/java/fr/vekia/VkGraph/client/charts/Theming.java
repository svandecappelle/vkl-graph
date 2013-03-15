/*
 * File: $URL: https://vklgraph.googlecode.com/svn/trunk/src/main/java/fr/vekia/VkGraph/client/charts/Theming.java $
 * $Id: Theming.java 34 2012-08-31 13:03:35Z steeve.vandecappelle@gmail.com $
 * Licence MIT
 *
 * Last change:
 * $Date: 2012-08-31 15:03:35 +0200 (ven., 31 août 2012) $
 * $Author: steeve.vandecappelle@gmail.com $
 */
package fr.vekia.VkGraph.client.charts;

import fr.vekia.VkGraph.client.charts.menus.MenuCommands;
import fr.vekia.VkGraph.client.charts.menus.RightClickMenuWidget;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 13 août 2012. VklGraph version 1.2
 * @version 2.1
 * 
 *          {@inheritDoc} List of currently available themes.
 */
public enum Theming {
    BLUE("blue"),
    BLACK("black"),
    OLD_SCHOOL("old_school"),
    OLD_SCHOOL_PIE("old_school_pie"),
    SALMON("salmon"),
    MODERN("modern"),
    MODERN_PIE("modern_pie"),
    GREY_SCALE("grey_scale"),
    GREY_SCALE_PIE("grey_scale_pie"),
    GABE("gabe");

    private String theme;
    private final static int LINE_THEMES_COUNT = 7;
    private final static int PIE_THEMES_COUNT = 3;

    /**
     * @return the theme name.
     */
    public String getTheme() {
	return theme;
    }

    /**
     * Default constructor.
     * 
     */
    private Theming(String theme) {
	this.theme = theme;
    }

    /**
     * @return get the available themes for chart.
     */
    public static MenuCommands[] getDefault(final Chart<?> chart, final RightClickMenuWidget menu) {
	return dispach(chart, menu);
    }

    /**
     * Return the available themes for Pie/Donut Chart.
     * 
     * @param chart
     *            the chart to set theme.
     * @param menu
     *            the right click menu.
     * @return The menu themes selector commands.
     */
    private static MenuCommands[] dispach(Chart<?> chart, RightClickMenuWidget menu) {
	MenuCommands[] output = null;
	ThemeActivator activator = new ThemeActivator(chart, menu);
	switch (chart.getRenderer()) {
	case Pie:
	case Donut:
	    output = getPieDefault(activator);
	    break;
	default:
	    output = getLineDefault(activator);
	    break;
	}
	return output;
    }

    /**
     * Return the available themes for Pie/Donut Chart.
     * 
     * @param activator
     *            the theme activator.
     * @return The menu themes selector commands.
     */
    private static MenuCommands[] getPieDefault(final ThemeActivator activator) {
	MenuCommands[] themes = new MenuCommands[PIE_THEMES_COUNT];
	int i = 0;
	themes[i] = new MenuCommands("old_school") {

	    @Override
	    public void execute() {
		activator.activate(OLD_SCHOOL_PIE);
	    }
	};
	i += 1;
	themes[i] = new MenuCommands("modern") {

	    @Override
	    public void execute() {
		activator.activate(MODERN);
	    }
	};
	i += 1;
	themes[i] = new MenuCommands("grey_scale") {

	    @Override
	    public void execute() {
		activator.activate(GREY_SCALE);
	    }
	};
	return themes;
    }

    /**
     * Return the available themes for Line Chart.
     * 
     * @param activator
     *            the theme activator.
     * @return The menu themes selector commands.
     */
    private static MenuCommands[] getLineDefault(final ThemeActivator activator) {

	MenuCommands[] themes = new MenuCommands[LINE_THEMES_COUNT];
	int i = 0;
	themes[i] = new MenuCommands("blue") {

	    @Override
	    public void execute() {
		activator.activate(BLUE);
	    }
	};
	i += 1;
	themes[i] = new MenuCommands("black") {

	    @Override
	    public void execute() {
		activator.activate(BLACK);
	    }
	};
	i += 1;
	themes[i] = new MenuCommands("area_salmon") {

	    @Override
	    public void execute() {
		activator.activate(SALMON);
	    }
	};
	i += 1;
	themes[i] = new MenuCommands("gabe") {

	    @Override
	    public void execute() {
		activator.activate(GABE);
	    }
	};
	i += 1;
	themes[i] = new MenuCommands("old_school") {

	    @Override
	    public void execute() {
		activator.activate(OLD_SCHOOL);
	    }
	};
	i += 1;
	themes[i] = new MenuCommands("modern") {

	    @Override
	    public void execute() {
		activator.activate(MODERN);
	    }
	};
	i += 1;
	themes[i] = new MenuCommands("grey_scale") {

	    @Override
	    public void execute() {
		activator.activate(GREY_SCALE);
	    }
	};
	return themes;
    }

}
