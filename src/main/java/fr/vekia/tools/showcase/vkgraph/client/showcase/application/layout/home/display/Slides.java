package fr.vekia.tools.showcase.vkgraph.client.showcase.application.layout.home.display;

import com.google.gwt.dom.client.Style.Cursor;
import com.google.gwt.dom.client.Style.Overflow;
import com.google.gwt.dom.client.Style.Position;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.FlowPanel;

public class Slides extends FlowPanel {

    public static final double WIDTH = Window.getClientWidth() - 600;
    public static final double HEIGHT = Window.getClientHeight() - 300;

    public Slides() {
        this.getElement().setAttribute("data-u", "slides");
        this.setSize(WIDTH + "px", HEIGHT + "px");

        this.getElement().getStyle().setCursor(Cursor.DEFAULT);
        this.getElement().getStyle().setPosition(Position.RELATIVE);
        this.getElement().getStyle().setTop(0, Unit.PX);
        this.getElement().getStyle().setLeft(0, Unit.PX);
        this.getElement().getStyle().setOverflow(Overflow.HIDDEN);
    }

    public void addSlide(Slide slide) {
        this.add(slide);
    }

}
