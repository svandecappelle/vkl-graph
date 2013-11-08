/*
 * File: $URL$
 * $Id$
 * Copyright: Vekia
 *
 * Last change:
 * $Date$
 * $Author$
 */
package fr.vekia.tools.showcase.vkgraph.client.showcase.application.ui;

import com.google.gwt.event.logical.shared.HasResizeHandlers;
import com.google.gwt.event.logical.shared.ResizeEvent;
import com.google.gwt.event.logical.shared.ResizeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author svandecappelle
 * @since Nov 23, 2012. VklGraph version 1.2
 * @version 2.1
 * 
 *          {@inheritDoc}
 */
public class JQueryDialog extends Widget implements ResizeHandler, HasResizeHandlers {

    private SimplePanel p;
    private String id;
    private String idContent;

    /**
     * Default constructor
     * 
     */
    public JQueryDialog(boolean isResizable, boolean isDraggable) {
	this.p = new SimplePanel();
	this.p.getElement().setId(DOM.createUniqueId());
	this.id = this.p.getElement().getId();
	int height = Window.getClientHeight() / 2;
	int width = Window.getClientWidth() / 3;

	int x = 0;
	int y = Window.getClientWidth() - width;
	super.setElement(p.getElement());
	super.setTitle("The Dialog");

	RootLayoutPanel.get().add(p);

	this.create(id, height, width, x, y, isResizable, isDraggable);

	this.addResizeHandler(this);
    }

    /**
 * 
 */
    private native void create(String id, int height, int width, int x, int y, boolean isResizable, boolean isDraggable) /*-{
		$wnd.jQuery("#" + id).dialog({
			autoOpen : false,
			show : "blind",
			hide : "explode",
			height : height,
			width : width,
			draggable : isDraggable,
			resizable : isResizable,
			position : [ x, y ]
		});
    }-*/;

    /**
     * 
     */
    public void show() {
	this.open(id);
    };

    /**
     * 
     */
    private native void open(String id) /*-{
		$wnd.jQuery("#" + id).dialog("open");
    }-*/;

    @Override
    public void onResize(ResizeEvent event) {
	int height = DOM.getElementById(id).getOffsetHeight();
	int width = DOM.getElementById(id).getOffsetWidth();

	DOM.getElementById(idContent).getStyle().setPropertyPx("maxHeight", height);
	DOM.getElementById(idContent).getStyle().setPropertyPx("maxWidth", width);
    }

    @Override
    public HandlerRegistration addResizeHandler(ResizeHandler handler) {
	return addHandler(handler, ResizeEvent.getType());
    }

    /**
     * @param bar
     */
    public void setWidget(Widget widget) {
	if (widget.getElement().getId() == null) {
	    widget.getElement().setId(DOM.createUniqueId());
	}
	idContent = widget.getElement().getId();
	p.setWidget(widget);
    }

}
