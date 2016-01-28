package fr.vekia.tools.showcase.vkgraph.client.showcase.application.layout.code.presenter;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.google.inject.Singleton;

import fr.vekia.tools.showcase.vkgraph.client.showcase.application.components.events.SelectionCodeEvent;
import fr.vekia.tools.showcase.vkgraph.client.showcase.application.components.events.SelectionCodeHandler;
import fr.vekia.tools.showcase.vkgraph.client.showcase.application.layout.code.interfaces.ShowcaseConsoleCodeDisplay;
import fr.vekia.tools.showcase.vkgraph.client.showcase.application.services.CodeServiceAsync;
import fr.vekia.tools.showcase.vkgraph.shared.CodeUrl;
import net.customware.gwt.presenter.client.EventBus;
import net.customware.gwt.presenter.client.widget.WidgetPresenter;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 23 avr. 2012. GWTQuery Vekia Showcase
 * @version 1.0
 */
@Singleton
public class ShowcaseConsoleCodePresenter extends WidgetPresenter<ShowcaseConsoleCodeDisplay> {

    @Inject
    private CodeServiceAsync service;

    /**
     * Default constructor
     * 
     * @param display
     * @param eventBus
     */
    @Inject
    public ShowcaseConsoleCodePresenter(ShowcaseConsoleCodeDisplay display, EventBus eventBus) {
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

                service.getCode(event.getSelectedItem().getClass().getName(), new AsyncCallback<String>() {

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

                service.getCodeUrl(event.getSelectedItem().getClass().getName(), new AsyncCallback<CodeUrl>() {

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
