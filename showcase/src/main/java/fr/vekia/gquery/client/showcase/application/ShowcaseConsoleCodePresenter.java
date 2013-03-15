/*
 * File: $URL: svn+ssh://chimay/home/svn/VkGraph-showcase/VkGraph-showcase/src/main/java/fr/vekia/gquery/client/showcase/application/ShowcaseConsoleCodePresenter.java $
 * $Id: ShowcaseConsoleCodePresenter.java 38 2012-08-23 16:36:45Z svandecappelle $
 * Licence MIT
 * 
 * Last change:
 * $Date: 2012-08-23 18:36:45 +0200 (jeu., 23 août 2012) $
 * $Author: svandecappelle $
 */
package fr.vekia.gquery.client.showcase.application;

import net.customware.gwt.presenter.client.EventBus;
import net.customware.gwt.presenter.client.widget.WidgetDisplay;
import net.customware.gwt.presenter.client.widget.WidgetPresenter;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.google.inject.Singleton;

import fr.vekia.gquery.client.showcase.application.components.events.SelectionCodeEvent;
import fr.vekia.gquery.client.showcase.application.components.events.SelectionCodeHandler;
import fr.vekia.gquery.client.showcase.application.services.CodeServiceUtil;
import fr.vekia.gquery.shared.CodeUrl;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 23 avr. 2012. GWTQuery Vekia Showcase
 * @version 1.0
 * 
 *          {@inheritDoc}
 */
@Singleton
public class ShowcaseConsoleCodePresenter extends WidgetPresenter<ShowcaseConsoleCodePresenter.Display> {

    public interface Display extends WidgetDisplay {

	/**
	 * 
	 */
	void show();

	/**
	 * 
	 */
	void hide();

	/**
	 * 
	 */
	HasClickHandlers getAddShowHandler();

	/**
	 * 
	 */
	HasClickHandlers getAddHideHandler();

	/**
	 * 
	 */
	void setCode(String code);

	/**
	 * 
	 */
	void insert();

	/**
	 * @param className
	 * @param codeUrl
	 */
	void setCodeUrl(String className, String codeUrl);

	/**
	 * 
	 */
	void showOutBrowser();
    }

    /**
     * Default constructor
     * 
     * @param display
     * @param eventBus
     */
    @Inject
    public ShowcaseConsoleCodePresenter(Display display, EventBus eventBus) {
	super(display, eventBus);

	this.display.getAddShowHandler().addClickHandler(new ClickHandler() {

	    @Override
	    public void onClick(ClickEvent event) {
		ShowcaseConsoleCodePresenter.this.display.show();
	    }
	});
    }

    public void showConsole() {
	ShowcaseConsoleCodePresenter.this.display.show();
    }

    public void showConsoleOutWindow() {
	ShowcaseConsoleCodePresenter.this.display.showOutBrowser();
    }

    @Override
    protected void onBind() {
	eventBus.addHandler(SelectionCodeEvent.getType(), new SelectionCodeHandler() {

	    @Override
	    public void onSelection(SelectionCodeEvent event) {

		CodeServiceUtil.getCode(event.getSelectedItem().getClass().getName(), new AsyncCallback<String>() {

		    @Override
		    public void onSuccess(String result) {
			display.setCode(result);
		    }

		    @Override
		    public void onFailure(Throwable caught) {
			GWT.log("not able to retreive code due to: ", caught);
			display.setCode("no code available");
			consolejs(caught.getMessage());
		    }
		});

		CodeServiceUtil.getCodeUrl(event.getSelectedItem().getClass().getName(), new AsyncCallback<CodeUrl>() {

		    @Override
		    public void onSuccess(CodeUrl codeUrl) {
			GWT.log("Code url: " + codeUrl.getUrl());
			display.setCodeUrl(codeUrl.getClassName(), codeUrl.getUrl());
		    }

		    @Override
		    public void onFailure(Throwable caught) {
			GWT.log("not able to retreive code due to: ", caught);
			display.setCode("no code available");
		    }
		});

	    }
	});
    }

    private native void consolejs(String message) /*-{
	console.log(message);
    }-*/;

    @Override
    protected void onUnbind() {
    }

    @Override
    protected void onRevealDisplay() {
    }
}
