package fr.vekia.tools.showcase.vkgraph.client.showcase.application.layout.home.display;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.InlineLabel;

public class ButtonNavigator extends HTML {

    public ButtonNavigator() {
        setSize("100%", "100%");

        InlineLabel left = new InlineLabel();
        left.setStylePrimaryName("jssora02l");
        left.getElement().setAttribute("data-u", "arrowleft");
        left.getElement().setAttribute("data-autocenter", "2");

        left.getElement().getStyle().setTop(45, Unit.PCT);
        left.getElement().getStyle().setLeft(8, Unit.PX);
        left.getElement().getStyle().setWidth(55, Unit.PX);
        left.getElement().getStyle().setHeight(55, Unit.PX);

        InlineLabel right = new InlineLabel();
        right.setStylePrimaryName("jssora02r");
        right.getElement().setAttribute("data-u", "arrowright");
        right.getElement().setAttribute("data-autocenter", "2");
        right.getElement().getStyle().setTop(45, Unit.PCT);
        right.getElement().getStyle().setRight(8, Unit.PX);
        right.getElement().getStyle().setWidth(55, Unit.PX);
        right.getElement().getStyle().setHeight(55, Unit.PX);

        StringBuilder builder = new StringBuilder(left.toString());
        builder.append(right.toString());
        setHTML(builder.toString());
    }
}
