package fr.vekia.tools.showcase.vkgraph.client.showcase.application.layout.home.display;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Default home page.
 * 
 * @author svandecappelle
 * @version 5.0.0
 */
public class HomePage extends SimplePanel {
    private static final Button startDemoButton = new Button("Start automated presentation...");

    public HomePage() {
        VerticalPanel introduction = new VerticalPanel();
        introduction.setWidth("100%");
        startDemoButton.getElement().setId("StartDemo-Button");
        introduction.getElement().getStyle().setPaddingRight(30, Unit.PX);
        startDemoButton.setWidth("100%");
        introduction.add(startDemoButton);
        introduction.add(new HTML("<h1>Introduction</h1>"));
        introduction.add(new HTML("<h2>Requirements</h2>"));
        introduction.add(new HTML("<dd>- A Google Web Toolkit project."));
        introduction.add(new HTML("<h2>Presentation</h2>"));
        introduction.add(new HTML("<dd>vklgraph is a GWT-based framework that integrate the JqPlot? JavaScript? Chart UI library."));
        Anchor googleCodeAhref = new Anchor("The google code project here", "http://code.google.com/p/vklgraph/");
        googleCodeAhref.setTarget("_new");
        introduction.add(googleCodeAhref);
        setWidget(introduction);
    }

    public HasClickHandlers getStartAutomatedDemoHandler() {
        return startDemoButton;
    }

}
