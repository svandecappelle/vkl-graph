package fr.vekia.tools.showcase.vkgraph.client.showcase.application.views.presentation;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.dom.client.Style.FontWeight;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Version panel on home page.
 * 
 * @author svandecappelle
 * @version 5.0.0
 */
public class Releases extends SimplePanel {

    private static final List<String> RELEASELABEL;

    static {
        RELEASELABEL = new ArrayList<String>();
        RELEASELABEL.add("Aug 16th 2012: First stable version of VklGraph on google code. New version of Showcase. See changeslogs.");
        RELEASELABEL.add("Jul 26th 2012: Adding refresh fonction. (With replot)");
        RELEASELABEL.add("Jun 28th 2012: First project initialisation.");
    }

    public Releases() {

        VerticalPanel releasesContainer = new VerticalPanel();
        HTML releaseTitle = new HTML("<h1>Releases: </h1>");

        VerticalPanel releases = new VerticalPanel();

        releasesContainer.add(releaseTitle);

        int i = 0;
        for (String labelTxt : RELEASELABEL) {
            Label latest = new Label(labelTxt);
            if (i == 0) {
                latest.getElement().getStyle().setFontWeight(FontWeight.BOLD);
                latest.getElement().getStyle().setBackgroundColor("rgba(255, 0, 0,0.4)");
            } else if (i % 2 == 0) {
                latest.getElement().getStyle().setBackgroundColor("rgba(80, 80, 80,0.4)");
            } else {
                latest.getElement().getStyle().setBackgroundColor("rgba(150, 150, 150,0.4)");
            }
            releases.add(latest);
            i += 1;
        }

        releases.setVerticalAlignment(HasVerticalAlignment.ALIGN_TOP);
        releases.setWidth("100%");

        releasesContainer.add(releases);

        releasesContainer.addStyleName("vkl-releases");
        releasesContainer.setHeight("100%");
        releasesContainer.setWidth("100%");
        releasesContainer.setCellHeight(releases, "100%");
        setWidth("100%");
        setWidget(releasesContainer);

    }
}
