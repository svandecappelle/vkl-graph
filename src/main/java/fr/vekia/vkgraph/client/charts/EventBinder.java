package fr.vekia.vkgraph.client.charts;

import java.util.List;

import fr.vekia.vkgraph.client.charts.events.JqPlotEvent;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 30 août 2012. VklGraph version 1.2
 * @version 2.1
 * 
 *          {@inheritDoc}
 */
public class EventBinder {

    private Chart<?> chart;
    private static final int FOUR_PARAMS_EVENT = 4;
    private static final int FIVE_PARAMS_EVENT = 5;

    /**
     * Default constructor
     * 
     * @param chart
     */
    public EventBinder(Chart<?> chart) {
        this.chart = chart;
    }

    /**
     * Bind events to a chart.
     * 
     * @param bindedEvents
     */
    public void bind(List<JqPlotEvent> bindedEvents) {
        for (JqPlotEvent event : bindedEvents) {
            if (event.getEventBindingParams() == 1) {
                this.bindSimple(event, event.getEventType().getName(), "#" + chart.getId());
            } else if (event.getEventBindingParams() == FOUR_PARAMS_EVENT) {
                if (event.isNative()) {
                    this.bind4Native(event, event.getEventType().getName(), "#" + chart.getId());
                } else {
                    this.bind4(event, event.getEventType().getName(), "#" + chart.getId());
                }

            } else if (event.getEventBindingParams() == FIVE_PARAMS_EVENT) {
                this.bind5(event, event.getEventType().getName(), "#" + chart.getId());
            } else if (event.getEventBindingParams() == 0) {
                this.bindWithNoArg(event, event.getEventType().getName(), "#" + chart.getId());
            } else {
                JsConsole.warn("[W400CE]", Integer.toString(event.getEventBindingParams()), "The event cannot be binded because of invalid number of event binding params. DebugParam:\nContact a VklGraph commiter by reporting an issue.");
            }
        }
    }

    /**
     * @param event
     * @param name
     * @param string
     */
    private native void bind4Native(JqPlotEvent event, String eventName, String elementId)
    /*-{
     
    if(eventName.lastIndexOf("jqplotDragStop")!=-1){
        	var startedXDrag;
        	
        	$wnd.jQuery(elementId).bind("jqplotClick", function(ev, gridpos, datapos, neighbor, plot) {
          	var eventData = @fr.vekia.vkgraph.client.charts.events.NativeEventObject::new()();
          	var yDragStop =  Math.round(datapos.yaxis*Math.pow(10,0))/Math.pow(10,0);
          	
                eventData.@fr.vekia.vkgraph.client.charts.events.NativeEventObject::setX(I)(startedXDrag);
                eventData.@fr.vekia.vkgraph.client.charts.events.NativeEventObject::setY(I)(yDragStop);
                event.@fr.vekia.vkgraph.client.charts.events.ChartEvent::onEvent(Lfr/vekia/vkgraph/client/charts/events/EventObject;)(eventData); 
                });
                
                
                $wnd.jQuery(elementId).bind("jqplotMouseDown", function(ev, gridpos, datapos, neighbor, plot) {
          		startedXDrag = datapos.xaxis
          		startedXDrag = Math.round(startedXDrag*Math.pow(10,0))/Math.pow(10,0);
                });
        	
    
    }else{
    
    
    
    
    $wnd.jQuery(elementId).bind(eventName, function(ev, gridpos, datapos, neighbor, plot) {
    var eventData = @fr.vekia.vkgraph.client.charts.events.NativeEventObject::new()();
        eventData.@fr.vekia.vkgraph.client.charts.events.NativeEventObject::setX(I)(datapos.xaxis);
        eventData.@fr.vekia.vkgraph.client.charts.events.NativeEventObject::setY(I)(datapos.yaxis);
        event.@fr.vekia.vkgraph.client.charts.events.ChartEvent::onEvent(Lfr/vekia/vkgraph/client/charts/events/EventObject;)(eventData); 
        });
        
        }
    
     }-*/;

    /**
     * Bind 5 parameter event.
     * 
     * @param event
     * @param eventName
     * @param elementId
     */
    private native void bind5(JqPlotEvent event, String eventName, String elementId)
    /*-{
    $wnd.jQuery(elementId).bind(eventName, function(ev, seriesIndex, pointIndex, dataPoint, dataAbstr) {
        var eventData = @fr.vekia.vkgraph.client.charts.events.EventObject::new()();
        eventData.@fr.vekia.vkgraph.client.charts.events.EventObject::setSeriesIndex(I)(seriesIndex);
        eventData.@fr.vekia.vkgraph.client.charts.events.EventObject::setPointIndex(I)(pointIndex);
        eventData.@fr.vekia.vkgraph.client.charts.events.EventObject::setValue(Ljava/lang/Object;)(dataPoint);
        event.@fr.vekia.vkgraph.client.charts.events.ChartEvent::onEvent(Lfr/vekia/vkgraph/client/charts/events/EventObject;)(eventData);
    });

    }-*/;

    /**
     * Bind 0 parameter event.
     * 
     * @param event
     * @param eventName
     * @param elementId
     */
    private native void bindWithNoArg(JqPlotEvent event, String eventName, String elementId)
    /*-{

    $wnd
    	.jQuery(elementId)
    	.bind(
    		eventName,
    		function(ev) {
    		   event.@fr.vekia.vkgraph.client.charts.events.ChartEvent::onEvent(Lfr/vekia/vkgraph/client/charts/events/EventObject;)(null);
    		});

    }-*/;

    /**
     * Bind 1 parameter event.
     * 
     * @param event
     * @param eventName
     * @param elementId
     */
    private native void bindSimple(JqPlotEvent event, String eventName, String elementId)
    /*-{

    $wnd
    	.jQuery(elementId)
    	.bind(
    		eventName,
    		function(ev) {
    		    var eventData = @fr.vekia.vkgraph.client.charts.events.SimpleEventObject::new()();
    		    event.@fr.vekia.vkgraph.client.charts.events.ChartSimpleEvent::onEvent(Lfr/vekia/vkgraph/client/charts/events/SimpleEventObject;)(eventData);
    		});

    }-*/;

    /**
     * Bind 4 parameter event.
     * 
     * @param event
     * @param eventName
     * @param elementId
     */
    private native void bind4(JqPlotEvent event, String eventName, String elementId)
    /*-{

    $wnd.jQuery(elementId).bind(eventName, function(ev, seriesIndex, pointIndex, dataPoint) {
    var eventData = @fr.vekia.vkgraph.client.charts.events.EventObject::new()();
        eventData.@fr.vekia.vkgraph.client.charts.events.EventObject::setSeriesIndex(I)(seriesIndex);
        eventData.@fr.vekia.vkgraph.client.charts.events.EventObject::setPointIndex(I)(pointIndex);
        eventData.@fr.vekia.vkgraph.client.charts.events.EventObject::setValue(Ljava/lang/Object;)(dataPoint);
        event.@fr.vekia.vkgraph.client.charts.events.ChartEvent::onEvent(Lfr/vekia/vkgraph/client/charts/events/EventObject;)(eventData);
    });

    }-*/;
}
