package fr.vekia.tools.showcase.vkgraph.client.showcase.application.layout.home.display;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.SimplePanel;

public class BulletNavigator extends SimplePanel {

    public BulletNavigator() {
        getElement().setAttribute("data-u", "navigator");
        setStylePrimaryName("jssorb01");
        getElement().getStyle().setBottom(16, Unit.PX);
        getElement().getStyle().setRight(16, Unit.PX);

        SimplePanel prototype = new SimplePanel();
        prototype.getElement().setAttribute("data-u", "prototype");
        prototype.setSize("12px", "12px");

        this.setWidget(prototype);

    }
}
