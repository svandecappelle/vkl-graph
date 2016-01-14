/*
 * File: $URL$
 * $Id$
 * Copyright: Vekia
 *
 * Last change:
 * $Date$
 * $Author$
 */
package fr.vekia.tools.showcase.vkgraph.client.showcase.application.components.code;

import com.google.gwt.event.logical.shared.HasResizeHandlers;
import com.google.gwt.event.logical.shared.ResizeEvent;
import com.google.gwt.event.logical.shared.ResizeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author svandecappelle
 * @since Nov 22, 2012. VklGraph version 1.2
 * @version 2.1
 * 
 *          {@inheritDoc}
 */
public class ConsoleWindow extends Widget implements ResizeHandler, HasResizeHandlers {

    /**
     * Default constructor
     * 
     */
    public ConsoleWindow() {
        int height = Window.getClientHeight() / 2;
        int width = Window.getClientWidth() / 3;

        int x = 0;
        int y = Window.getClientWidth() - width;
        super.setElement(DOM.getElementById("consoleCode"));
        super.setTitle("The code");

        super.setSize("450px", "250px");
        this.create(height, width, x, y);

        this.addResizeHandler(this);
    }

    /**
    * 
    */
    private native void create(int height, int width, int x, int y) /*-{
                                                                    $wnd.jQuery("#consoleCode").dialog({
                                                                    autoOpen : false,
                                                                    show : "blind",
                                                                    hide : "explode",
                                                                    height : height,
                                                                    width : width,
                                                                    position : [ x, y ]
                                                                    });
                                                                    }-*/;

    /**
     * 
     */
    public void show() {
        this.open();
    };

    public void setCode(String code) {
        DOM.getElementById("code").setInnerHTML(code);
    }

    /**
     * 
     */
    private native void open() /*-{
                               $wnd.jQuery("#consoleCode").dialog("open");
                               }-*/;

    @Override
    public void onResize(ResizeEvent event) {
        int height = DOM.getElementById("consoleCode").getOffsetHeight();
        int width = DOM.getElementById("consoleCode").getOffsetWidth();

        DOM.getElementById("code").getStyle().setPropertyPx("maxHeight", height);
        DOM.getElementById("code").getStyle().setPropertyPx("maxWidth", width);
    }

    @Override
    public HandlerRegistration addResizeHandler(ResizeHandler handler) {
        return addHandler(handler, ResizeEvent.getType());
    }

}