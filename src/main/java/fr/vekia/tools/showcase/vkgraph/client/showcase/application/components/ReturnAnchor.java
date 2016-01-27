package fr.vekia.tools.showcase.vkgraph.client.showcase.application.components;

import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.SimplePanel;

/**
 * Return anchor for history tokens return.
 * 
 * @author svandecappelle
 * @since 5.0.0
 * @version 5.0.0
 */
public class ReturnAnchor extends SimplePanel {

    private Anchor anchor;

    public ReturnAnchor() {
        this.addStyleName("return-anchor");
        this.anchor = new Anchor("<< Retour");
        this.anchor.setStyleName("vkl-Anchor");
        this.setSize("100%", "100%");
        this.add(anchor);
    }

    public Anchor getAnchor() {
        return anchor;
    }
}
