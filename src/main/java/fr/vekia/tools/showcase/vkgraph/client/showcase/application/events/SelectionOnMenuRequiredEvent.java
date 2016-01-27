package fr.vekia.tools.showcase.vkgraph.client.showcase.application.events;

import com.google.gwt.event.shared.GwtEvent;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 23 août 2012. VklGraph version 1.2
 * @version 2.1
 */
public class SelectionOnMenuRequiredEvent extends GwtEvent<SelectionOnMenuRequiredHandler> {

    private String menuToShow;
    private String plotToShow;
    private int duration;

    /**
     * Default constructor
     * 
     * @param selectedItem
     */
    public SelectionOnMenuRequiredEvent(String menuToShow, String plotToShow) {
        this.menuToShow = menuToShow;
        this.plotToShow = plotToShow;
    }

    /**
     * Default constructor
     * 
     * @param selectedItem
     */
    public SelectionOnMenuRequiredEvent(String menuToShow) {
        this.menuToShow = menuToShow;
        this.plotToShow = null;
    }

    private static Type<SelectionOnMenuRequiredHandler> type;

    public static Type<SelectionOnMenuRequiredHandler> getType() {
        if (type == null) {
            type = new Type<SelectionOnMenuRequiredHandler>();
        }
        return type;
    }

    @Override
    protected void dispatch(SelectionOnMenuRequiredHandler handler) {
        handler.onSelection(this);
    }

    @Override
    public GwtEvent.Type<SelectionOnMenuRequiredHandler> getAssociatedType() {
        return getType();
    }

    /**
     * @return the menuToShow
     */
    public String getMenuToShow() {
        return menuToShow;
    }

    /**
     * @return the plotToShow
     */
    public String getPlotToShow() {
        return plotToShow;
    }

    /**
     * @return the duration
     */
    public int getDuration() {
        return duration;
    }
}
