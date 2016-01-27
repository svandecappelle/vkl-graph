package fr.vekia.tools.showcase.vkgraph.client.showcase.application.ui;

import com.google.gwt.dom.client.Style.BorderStyle;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.SimplePanel;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 29 août 2012. VklGraph version 1.2
 * @version 2.1
 */
public class ProgressBar extends Composite {
    private SimplePanel progress;
    private ProgressAnimation animation;

    /**
     * Default constructor
     * 
     */
    public ProgressBar() {
        SimplePanel container = new SimplePanel();
        progress = new SimplePanel();

        container.setWidget(progress);
        container.setSize("100%", "16px");
        container.getElement().getStyle().setBorderColor("rgba(255, 255, 255, 0.5)");
        container.getElement().getStyle().setBorderStyle(BorderStyle.SOLID);
        container.getElement().getStyle().setBorderWidth(2, Unit.PX);
        container.getElement().getStyle().setBackgroundColor("rgba(255, 255, 255, 0.3)");

        progress.setSize("0%", "16px");
        progress.getElement().getStyle().setBackgroundColor("rgba(128, 0, 0, 0.8)");
        progress.getElement().getStyle().setBorderColor("rgba(128, 0, 0, 0.8)");
        progress.getElement().getStyle().setBorderStyle(BorderStyle.SOLID);
        progress.getElement().getStyle().setBorderWidth(2, Unit.PX);
        progress.getElement().getStyle().setProperty("borderRadius", "0px 5px");
        progress.getElement().getStyle().setProperty("borderRadius", "0px 5px");

        animation = new ProgressAnimation(progress);
        initWidget(container);
    }

    public void run(int millisecond) {
        animation.run(millisecond);
    }
}
