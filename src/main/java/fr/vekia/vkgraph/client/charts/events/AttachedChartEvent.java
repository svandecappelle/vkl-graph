package fr.vekia.vkgraph.client.charts.events;

import com.google.gwt.event.shared.GwtEvent;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 3 sept. 2012. VklGraph version 1.2
 * @version 2.1
 * 
 *          {@inheritDoc}
 */
public class AttachedChartEvent extends GwtEvent<AttachedChartHandler> {

    private static Type<AttachedChartHandler> type;

    public static Type<AttachedChartHandler> getType() {
        if (type == null) {
            type = new Type<AttachedChartHandler>();
        }
        return type;
    }

    public AttachedChartEvent() {
    }

    @Override
    protected void dispatch(AttachedChartHandler handler) {
        handler.onAttachedChart(this);
    }

    @Override
    public GwtEvent.Type<AttachedChartHandler> getAssociatedType() {
        return getType();
    }
}
