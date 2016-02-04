package fr.vekia.tools.showcase.vkgraph.client.showcase.application.layout.global.display;

import com.google.gwt.dom.client.Style.Overflow;
import com.google.gwt.dom.client.Style.Position;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.DeckLayoutPanel;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

import fr.vekia.tools.showcase.vkgraph.client.showcase.application.layout.global.interfaces.GlobalDisplay;
import fr.vekia.tools.showcase.vkgraph.client.showcase.application.layout.home.display.PresentationDemoPanel;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 23 avr. 2012. GWTQuery Vekia Showcase
 * @version 1.0
 */
public class GlobalPanel implements GlobalDisplay {

    private DeckLayoutPanel tabLayout;
    private PresentationDemoPanel presentationPanel;
    private ReturnsAnchors returnAnchor;

    private SimplePanel containerWidget;

    /**
     * Default constructor
     * 
     */
    @Inject
    public GlobalPanel(PresentationDemoPanel presentationPanel) {
        this.returnAnchor = new ReturnsAnchors();
        this.containerWidget = new SimplePanel();
        containerWidget.getElement().getStyle().setPosition(Position.RELATIVE);
        tabLayout = new DeckLayoutPanel();
        tabLayout.setSize("100%", "100%");
        tabLayout.setAnimationDuration(800);
        tabLayout.addStyleName("vkl-CenterPanel");
        this.presentationPanel = presentationPanel;
        this.setWidget(presentationPanel);
    }

    @Override
    public Widget asWidget() {
        return tabLayout;
    }

    /**
     * 
     */
    public void removeItem(IsWidget item) {
        tabLayout.remove((Widget) item);
    }

    /**
     * @return the returnLbl
     */
    @Override
    public HasClickHandlers getReturnLbl() {
        return returnAnchor.getReturnAnchor();
    }

    @Override
    public HasClickHandlers getStartAutomatedDemoHandler() {
        return presentationPanel.getStartAutomatedDemoHandler();
    }

    @Override
    public void setWidget(IsWidget w) {
        this.containerWidget.setWidget(w);
        reinitPanel();
    }

    private final void reinitPanel() {
        VerticalPanel p = new VerticalPanel();
        p.setSize("100%", "100%");
        p.add(returnAnchor);
        p.add(this.containerWidget);
        p.setCellHeight(this.containerWidget, "100%");
        this.containerWidget.setSize("100%", "100%");

        tabLayout.setWidget(p);
        p.getElement().getParentElement().getStyle().setOverflow(Overflow.AUTO);
    }
}