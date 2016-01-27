package fr.vekia.tools.showcase.vkgraph.client.showcase.application.components;

import com.google.gwt.dom.client.Style.Position;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.SplitLayoutPanel;

import fr.vekia.tools.showcase.vkgraph.client.showcase.application.views.presentation.Contributors;
import fr.vekia.tools.showcase.vkgraph.client.showcase.application.views.presentation.HomeDemoSlider;
import fr.vekia.tools.showcase.vkgraph.client.showcase.application.views.presentation.HomePage;
import fr.vekia.tools.showcase.vkgraph.client.showcase.application.views.presentation.Releases;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 25 avr. 2012. GWTQuery Vekia Showcase
 * @version 1.0
 */
public class PresentationDemoPanel extends Composite {
    private HomePage presentation;

    /**
     * Default constructor
     * 
     */
    public PresentationDemoPanel() {
        SimplePanel layout = new SimplePanel();
        SplitLayoutPanel dock = new SplitLayoutPanel(14);

        dock.addWest(new Releases(), 230);
        dock.addSouth(new Contributors(), 15);
        presentation = new HomePage();
        dock.addNorth(presentation, 230);
        dock.add(new HomeDemoSlider());
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
