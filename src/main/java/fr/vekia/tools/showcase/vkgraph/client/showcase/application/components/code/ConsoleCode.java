/*
 * File: $URL: svn+ssh://chimay/home/svn/VkGraph-showcase/VkGraph-showcase/src/main/java/fr.vekia.tools.showcase.vkgraph/client/showcase/application/components/code/ConsoleCode.java $
 * $Id: ConsoleCode.java 52 2012-09-26 15:26:35Z svandecappelle $
 * Licence MIT
 * 
 * Last change:
 * $Date: 2012-09-26 17:26:35 +0200 (mer., 26 sept. 2012) $
 * $Author: svandecappelle $
 */
package fr.vekia.tools.showcase.vkgraph.client.showcase.application.components.code;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

import fr.vekia.tools.showcase.vkgraph.client.showcase.application.ShowcaseConsoleCodePresenter.Display;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 23 avr. 2012. GWTQuery Vekia Showcase
 * @version 1.0
 * 
 *          {@inheritDoc}
 */
public class ConsoleCode implements Display {

    private Button buttonShow;
    private ConsoleWindow box;
    private ScrollPanel panel;
    private String codeUrl;
    private String className;
    private Button showOtherWindow;

    /**
     * Default constructor
     * 
     */
    public ConsoleCode() {
	panel = new ScrollPanel();

	panel.setHeight((Window.getClientHeight() / 3) + "px");
	panel.setWidth((Window.getClientWidth() / 3) + "px");

	VerticalPanel container = new VerticalPanel();
	buttonShow = new Button("ShowCode");
	buttonShow.getElement().setId("idOpener");
	box = new ConsoleWindow();

	container.add(panel);

	showOtherWindow = new Button("Show in other window");
	showOtherWindow.addClickHandler(new ClickHandler() {

	    @Override
	    public void onClick(ClickEvent event) {
		Window.open(GWT.getHostPageBaseURL() + "doc/" + getCodeUrl(), "Code for " + getClassName(), "_new");
	    }
	});
    }

    /**
     * @return
     */
    protected String getCodeUrl() {
	return this.codeUrl;
    }

    /**
     * @return
     */
    @Override
    public void setCodeUrl(String className, String codeUrl) {
	this.codeUrl = codeUrl;
	this.className = className;
    }

    /**
     * @return the className
     */
    public String getClassName() {
	return className;
    }

    @Override
    public Widget asWidget() {
	return buttonShow;
    }

    @Override
    public void show() {
	box.show();
    }

    @Override
    public void hide() {
	// box.hide();
    }

    @Override
    public HasClickHandlers getAddShowHandler() {
	return buttonShow;
    }

    @Override
    public HasClickHandlers getAddHideHandler() {
	return null;
    }

    @Override
    public void setCode(String code) {
	box.setCode(code);
    }

    @Override
    public void insert() {
	if (buttonShow != null) {
	    RootLayoutPanel.get().add(buttonShow);
	    buttonShow.getElement().getStyle().setZIndex(1);
	    RootLayoutPanel.get().setWidgetTopHeight(buttonShow, 0, Unit.PX, 25, Unit.PX);
	    RootLayoutPanel.get().setWidgetRightWidth(buttonShow, 0, Unit.PX, 150, Unit.PX);

	    RootLayoutPanel.get().add(showOtherWindow);
	    showOtherWindow.getElement().getStyle().setZIndex(1);
	    RootLayoutPanel.get().setWidgetTopHeight(showOtherWindow, 0, Unit.PX, 25, Unit.PX);
	    RootLayoutPanel.get().setWidgetRightWidth(showOtherWindow, 200, Unit.PX, 150, Unit.PX);
	}
    }

    @Override
    public void showOutBrowser() {
	Window.open(GWT.getHostPageBaseURL() + "doc/" + getCodeUrl(), "Code for " + getClassName(), "_new");
    }
}
