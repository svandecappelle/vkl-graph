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
import com.google.gwt.user.client.ui.FlowPanel;
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
	private String codeUrl;
	private String className;
	private Button showOtherWindow;
	private FlowPanel container;
		
	/**
	 * Default constructor
	 * 
	 */
	public ConsoleCode() {
		this.container = new FlowPanel();
		box = new ConsoleWindow();
		buttonShow = new Button("ShowCode");
		showOtherWindow = new Button("Show in other window");

		buttonShow.getElement().setId("idOpener");
		showOtherWindow.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				Window.open(GWT.getHostPageBaseURL() + getCodeUrl(),
						"Code for " + getClassName(), "_new");
			}
		});

		container.add(buttonShow);
		container.add(showOtherWindow);

		container.setStylePrimaryName("Vklgetcode-Container");
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
		RootLayoutPanel.get().add(container);
		container.getElement().getStyle().setZIndex(1);
		RootLayoutPanel.get().setWidgetTopHeight(container, 6, Unit.PX,
				41, Unit.PX);
		RootLayoutPanel.get().setWidgetRightWidth(container, 10, Unit.PX,
				316, Unit.PX);
	}

	@Override
	public void showOutBrowser() {
		Window.open(GWT.getHostPageBaseURL() + getCodeUrl(), "Code for "
				+ getClassName(), "_new");
	}
}
