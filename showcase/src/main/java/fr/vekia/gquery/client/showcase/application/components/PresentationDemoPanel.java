/*
 * File: $URL: svn+ssh://chimay/home/svn/VkGraph-showcase/VkGraph-showcase/src/main/java/fr/vekia/gquery/client/showcase/application/components/PresentationDemoPanel.java $
 * $Id: PresentationDemoPanel.java 52 2012-09-26 15:26:35Z svandecappelle $
 * Licence MIT
 * 
 * Last change:
 * $Date: 2012-09-26 17:26:35 +0200 (mer., 26 sept. 2012) $
 * $Author: svandecappelle $
 */
package fr.vekia.gquery.client.showcase.application.components;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.SplitLayoutPanel;

import fr.vekia.gquery.client.showcase.application.views.presentation.Contributors;
import fr.vekia.gquery.client.showcase.application.views.presentation.ExemplePresentation;
import fr.vekia.gquery.client.showcase.application.views.presentation.Presentation;
import fr.vekia.gquery.client.showcase.application.views.presentation.Releases;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 25 avr. 2012. GWTQuery Vekia Showcase
 * @version 1.0
 * 
 *          {@inheritDoc}
 */
public class PresentationDemoPanel extends Composite {
    private Presentation presentation;

    /**
     * Default constructor
     * 
     */
    public PresentationDemoPanel() {
	LayoutPanel layout = new LayoutPanel();
	SplitLayoutPanel dock = new SplitLayoutPanel();

	dock.addWest(new Releases(), 230);
	dock.addSouth(new Contributors(), 15);
	presentation = new Presentation();
	dock.addNorth(presentation, 230);
	dock.add(new ExemplePresentation());

	layout.add(dock);
	initWidget(layout);
	setSize("100%", "100%");
    }

    public HasClickHandlers getStartAutomatedDemoHandler() {
	return presentation.getStartAutomatedDemoHandler();
    }
}
