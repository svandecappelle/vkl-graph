package fr.vekia.tools.showcase.vkgraph.client.showcase.application.layout.code.display;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.Widget;

import fr.vekia.tools.showcase.vkgraph.client.showcase.application.layout.code.interfaces.ShowcaseConsoleCodeDisplay;
import fr.vekia.tools.showcase.vkgraph.client.showcase.application.widgets.JQueryDialog;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 23 avr. 2012. GWTQuery Vekia Showcase
 * @version 1.0
 */
public class ConsoleCode implements ShowcaseConsoleCodeDisplay {

    private Button buttonShow;
    private JQueryDialog box;
    private String codeUrl;
    private String className;
    private Anchor showOtherWindow;
    private FlowPanel container;

    /**
     * Default constructor
     * 
     */
    public ConsoleCode() {
        this.container = new FlowPanel();
        box = new JQueryDialog("The code", false);
        buttonShow = new Button("ShowCode");
        showOtherWindow = new Anchor("Show in other window");
        showOtherWindow.setTarget("_blank");
        buttonShow.getElement().setId("idOpener");
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
        this.showOtherWindow.setHref(GWT.getHostPageBaseURL() + getCodeUrl());
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
        RootLayoutPanel.get().setWidgetTopHeight(container, 16, Unit.PX, 45, Unit.PX);
        RootLayoutPanel.get().setWidgetRightWidth(container, 16, Unit.PX, 260, Unit.PX);
    }

    @Override
    public void showOutBrowser() {
        Window.open(GWT.getHostPageBaseURL() + getCodeUrl(), "Code for " + getClassName(), "_blank");
    }
}
