package fr.vekia.tools.showcase.vkgraph.client.showcase.application.views.presentation;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.IsWidget;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 30 août 2012. VklGraph version 1.2
 * @version 2.1
 */
public class ConsoleSlideshowCallBack implements AsyncCallback<String> {
    private HTML codingWidget;

    private CallbackEventController<ConsoleSlideshowCallBack, IsWidget> controller;

    /**
     * Default constructor
     * 
     * @param callBackEventController
     */
    public ConsoleSlideshowCallBack(CallbackEventController<ConsoleSlideshowCallBack, IsWidget> callBackEventController) {
        this.controller = callBackEventController;
    }

    @Override
    public void onFailure(Throwable caught) {
        this.controller.onError(caught);
    }

    @Override
    public void onSuccess(String code) {
        HTML codeHTML = new HTML(code);
        codeHTML.addStyleName("consoleCode");
        this.controller.pop(codeHTML);
    }

    /**
     * @return the codingWidget
     */
    public HTML getCodingWidget() {
        return codingWidget;
    }

}
