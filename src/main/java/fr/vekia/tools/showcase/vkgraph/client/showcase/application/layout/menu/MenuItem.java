package fr.vekia.tools.showcase.vkgraph.client.showcase.application.layout.menu;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 25 avr. 2012. GWTQuery Vekia Showcase
 * @version 1.0
 */
public class MenuItem extends Composite {

    private SimplePanel layout;

    /**
     * Default constructor
     * 
     */
    public MenuItem() {
        layout = new SimplePanel();
        layout.setWidth("100%");
        initWidget(layout);
    }

    /**
     * 
     */
    public void set(Widget widget) {
        layout.setWidget(widget);
    }

}
