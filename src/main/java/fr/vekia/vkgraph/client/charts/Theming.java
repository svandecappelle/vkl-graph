package fr.vekia.vkgraph.client.charts;

import java.util.ArrayList;
import java.util.List;

import fr.vekia.vkgraph.client.charts.menus.MenuCommands;
import fr.vekia.vkgraph.client.charts.menus.RightClickMenuWidget;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 13 août 2012. VklGraph version 1.2
 * @version 2.1
 * 
 *          {@inheritDoc} List of currently available themes.
 */
public enum Theming {
    GREY_SCALE("grey_scale"), GREY_SCALE_PIE("grey_scale_pie", Type.PIE), VKBASE("vkbase"), VKBASE_PIE("vkbase_pie", Type.PIE), RAINBOW("rainbow"), RAINBOW_PIE("rainbow_pie", Type.PIE), BLUE("bluealpha"), BLUE_PIE("bluealpha_pie", Type.PIE);

    protected enum Type {
        PIE, DEFAULT, BOTH;
    }

    private String theme;
    private Type chartType;
    private String themeName;

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
        this.chartType = Type.DEFAULT;
        this.themeName = super.name();
    }

    /**
     * Default constructor.
     * 
     */
    private Theming(String theme, Type chartType) {
        this.theme = theme;
        this.chartType = chartType;
        this.themeName = super.name();
    }

    public String getThemeName() {
        return themeName;
    }

    /**
     * @return get the available themes for chart.
     */
    public static MenuCommands[] getDefault(final Chart<?> chart, final RightClickMenuWidget menu) {
        return dispach(chart, menu);
    }

    protected Type getType() {
        return chartType;
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
        ThemeActivator activator = new ThemeActivator(chart, menu);
        List<MenuCommands> themes = new ArrayList<MenuCommands>();
        boolean isPieThemeRequested = chart.getRenderer() == RenderersEnum.Pie || chart.getRenderer() == RenderersEnum.Donut || chart.getRenderer() == RenderersEnum.Funnel;

        for (Theming theme : Theming.values()) {

            switch (theme.getType()) {

            case PIE:
                if (isPieThemeRequested) {
                    themes.add(buildThemeCommand(theme, activator));
                }
                break;

            case DEFAULT:
                if (!isPieThemeRequested) {
                    themes.add(buildThemeCommand(theme, activator));
                }
                break;

            case BOTH:
                themes.add(buildThemeCommand(theme, activator));
                break;

            default:
                // NOTHING by default.
                break;
            }

        }
        return themes.toArray(new MenuCommands[themes.size()]);
    }

    private static MenuCommands buildThemeCommand(final Theming theme, final ThemeActivator activator) {
        return new MenuCommands(theme.getThemeName()) {
            @Override
            public void execute() {
                activator.activate(theme);
            }
        };
    }
}
