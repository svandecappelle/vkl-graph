package fr.vekia.tools.showcase.vkgraph.client.showcase.application.layout.home.display;

import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.dom.client.Style.Position;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.SimplePanel;

public class SliderLoader extends FlowPanel {
    public SliderLoader() {
        getElement().setAttribute("data-u", "loading");
        getElement().getStyle().setPosition(Position.ABSOLUTE);
        getElement().getStyle().setTop(0, Unit.PX);
        getElement().getStyle().setLeft(0, Unit.PX);

        SimplePanel overlay = new SimplePanel();
        overlay.getElement().getStyle().setOpacity(0.7);
        overlay.getElement().getStyle().setPosition(Position.ABSOLUTE);
        overlay.getElement().getStyle().setDisplay(Display.BLOCK);
        overlay.getElement().getStyle().setTop(0, Unit.PX);
        overlay.getElement().getStyle().setLeft(0, Unit.PX);
        overlay.getElement().getStyle().setWidth(100, Unit.PCT);
        overlay.getElement().getStyle().setHeight(100, Unit.PCT);

        SimplePanel loadingGif = new SimplePanel();

        loadingGif.getElement().getStyle().setPosition(Position.ABSOLUTE);
        loadingGif.getElement().getStyle().setDisplay(Display.BLOCK);
        loadingGif.getElement().getStyle().setProperty("background", "url('img/loading.gif') no-repeat center center");
        loadingGif.getElement().getStyle().setTop(0, Unit.PX);
        loadingGif.getElement().getStyle().setLeft(0, Unit.PX);
        loadingGif.getElement().getStyle().setWidth(100, Unit.PCT);
        loadingGif.getElement().getStyle().setHeight(100, Unit.PCT);

        this.add(overlay);
        this.add(loadingGif);

    }
}
