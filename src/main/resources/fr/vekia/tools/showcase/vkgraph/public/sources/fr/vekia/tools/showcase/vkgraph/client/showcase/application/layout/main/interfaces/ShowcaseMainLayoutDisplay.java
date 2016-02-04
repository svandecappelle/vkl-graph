package fr.vekia.tools.showcase.vkgraph.client.showcase.application.layout.main.interfaces;

import com.google.gwt.user.client.ui.IsWidget;

import net.customware.gwt.presenter.client.widget.WidgetDisplay;

public interface ShowcaseMainLayoutDisplay extends WidgetDisplay {

    /**
     * @param widget
     * @param size
     */
    void addWest(IsWidget widget, int size);

    /**
     * @param widget
     * @param size
     */
    void addNorth(IsWidget widget, int size);

    /**
     * @param widget
     */
    void addCenter(IsWidget widget);

}
