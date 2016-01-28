package fr.vekia.tools.showcase.vkgraph.client.showcase.application.layout.home.display;

import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.IsWidget;

public class Slide extends FlowPanel {

    public Slide(String caption, IsWidget widget) {
        this.getElement().setAttribute("data-p", "112.50");
        this.getElement().getStyle().setDisplay(Display.NONE);
        this.add(widget);
        this.add(new Caption(caption));
    }
}
