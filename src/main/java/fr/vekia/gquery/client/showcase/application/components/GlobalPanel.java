/*
 * File: $URL: svn+ssh://chimay/home/svn/VkGraph-showcase/VkGraph-showcase/src/main/java/fr/vekia/gquery/client/showcase/application/components/GlobalPanel.java $
 * $Id: GlobalPanel.java 52 2012-09-26 15:26:35Z svandecappelle $
 * Licence MIT
 * 
 * Last change:
 * $Date: 2012-09-26 17:26:35 +0200 (mer., 26 sept. 2012) $
 * $Author: svandecappelle $
 */
package fr.vekia.gquery.client.showcase.application.components;

import com.google.gwt.dom.client.Style.Overflow;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.DeckLayoutPanel;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

import fr.vekia.gquery.client.showcase.application.ShowcaseGlobalPanelPresenter.Display;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 23 avr. 2012. GWTQuery Vekia Showcase
 * @version 1.0
 * 
 *          {@inheritDoc}
 */
public class GlobalPanel implements Display {

    private DeckLayoutPanel tabLayout;
    private PresentationDemoPanel presentationPanel;
    private Anchor returnLbl;

    private SimplePanel containerWidget;

    /**
     * Default constructor
     * 
     */
    public GlobalPanel() {
	this.returnLbl = new Anchor("<< Retour");
	this.returnLbl.setStyleName("vkl-Anchor");
	this.containerWidget = new SimplePanel();
	tabLayout = new DeckLayoutPanel();
	tabLayout.setAnimationDuration(800);
	tabLayout.addStyleName("vkl-CenterPanel");
	presentationPanel = new PresentationDemoPanel();
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
	return returnLbl;
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

	p.add(returnLbl);
	p.setCellHeight(returnLbl, "10px");

	p.add(this.containerWidget);
	this.containerWidget.setSize("100%", "100%");

	tabLayout.setWidget(p);
	p.getElement().getParentElement().getStyle().setOverflow(Overflow.SCROLL);
    }
}
