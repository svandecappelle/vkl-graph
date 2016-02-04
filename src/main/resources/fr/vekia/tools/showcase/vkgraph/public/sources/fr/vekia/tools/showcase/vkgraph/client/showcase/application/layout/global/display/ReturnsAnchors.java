package fr.vekia.tools.showcase.vkgraph.client.showcase.application.layout.global.display;

import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.FlowPanel;

/**
 * Return anchor for history tokens return.
 * 
 * @author svandecappelle
 * @since 5.0.0
 * @version 5.0.0
 */
public class ReturnsAnchors extends FlowPanel {

    private Anchor returnAnchor;
    private Anchor homeAnchor;

    public ReturnsAnchors() {
        this.addStyleName("return-anchor");
        this.returnAnchor = new Anchor("<< Retour");
        this.returnAnchor.setStyleName("vkl-Anchor");
        
        this.homeAnchor = new Anchor("Home page");
        this.homeAnchor.setHref("/");
        this.homeAnchor.setStyleName("vkl-Anchor");

        this.setSize("100%", "100%");
        this.add(returnAnchor);
        this.add(homeAnchor);
    }

    public Anchor getReturnAnchor() {
        return returnAnchor;
    }
}
