package fr.vekia.tools.showcase.vkgraph.client.showcase.application.layout.home.display;

import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Contributors home panel.
 * 
 * @author svandecappelle
 * @version 5.0.0
 */
public class Contributors extends SimplePanel {

    public Contributors() {

        VerticalPanel contributors = new VerticalPanel();
        contributors.add(new Label("Particular thank to Vekia's company for it's participation, on working out this project. Web site here"));

        setWidget(contributors);
    }
}
