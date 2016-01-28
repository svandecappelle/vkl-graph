package fr.vekia.tools.showcase.vkgraph.client.showcase.application.layout.home.display;

import com.google.gwt.dom.client.Style.FontWeight;
import com.google.gwt.dom.client.Style.Position;
import com.google.gwt.dom.client.Style.TextAlign;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.Label;

public class Caption extends Label {

    public Caption(String caption) {
        super(caption);
        this.getElement().setAttribute("data-u", "caption");
        this.getElement().setAttribute("data-t", "0");

        this.getElement().getStyle().setPosition(Position.ABSOLUTE);
        this.getElement().getStyle().setTop(-50, Unit.PX);
        this.getElement().getStyle().setLeft(125, Unit.PX);
        this.getElement().getStyle().setHeight(30, Unit.PX);
        this.getElement().getStyle().setBackgroundColor("rgba(27, 25, 24, 0.7)");
        this.getElement().getStyle().setFontSize(20, Unit.PX);
        this.getElement().getStyle().setColor("#FFFFFF");
        this.getElement().getStyle().setLineHeight(30, Unit.PX);
        this.getElement().getStyle().setTextAlign(TextAlign.CENTER);
        this.getElement().getStyle().setPadding(5, Unit.PX);
        this.getElement().getStyle().setPropertyPx("borderRadius", 5);
        this.getElement().getStyle().setFontWeight(FontWeight.BOLD);
    }
}
