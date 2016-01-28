package fr.vekia.tools.showcase.vkgraph.client.showcase.application.layout.home.display;

import com.google.gwt.dom.client.Style.Position;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.SplitLayoutPanel;
import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 25 avr. 2012. GWTQuery Vekia Showcase
 * @version 1.0
 */
@Singleton
public class PresentationDemoPanel extends Composite {
    private HomePage presentation;

    /**
     * Default constructor
     * 
     */
    @Inject
    public PresentationDemoPanel(HomeDemoSlider slider) {
        SimplePanel layout = new SimplePanel();
        SplitLayoutPanel dock = new SplitLayoutPanel(14);

        dock.addWest(new Releases(), 230);
        dock.addSouth(new Contributors(), 15);
        presentation = new HomePage();
        dock.addNorth(presentation, 230);
        dock.add(slider);
        layout.setSize("100%", "100%");
        dock.setSize("100%", "100%");
        layout.add(dock);
        layout.getElement().getStyle().setPosition(Position.ABSOLUTE);
        initWidget(layout);
    }

    public HasClickHandlers getStartAutomatedDemoHandler() {
        return presentation.getStartAutomatedDemoHandler();
    }
}
