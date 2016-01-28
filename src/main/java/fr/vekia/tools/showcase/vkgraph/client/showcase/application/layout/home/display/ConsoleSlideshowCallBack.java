package fr.vekia.tools.showcase.vkgraph.client.showcase.application.layout.home.display;

import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.SimplePanel;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 30 août 2012. VklGraph version 1.2
 * @version 2.1
 */
public class ConsoleSlideshowCallBack implements AsyncCallback<String> {

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
        SimplePanel codingWidget = new SimplePanel();
        codingWidget.setHeight("100%");
        codingWidget.getElement().setId(DOM.createUniqueId());
        this.controller.pop(codingWidget);
        
        buildCodeMirror(codingWidget.getElement().getId(), code);
    }

    // @formatter:off
    private native void buildCodeMirror(String idHtml, String javaCode) /*-{
        $wnd.jQuery("#" + idHtml).empty();
        var editor = $wnd.CodeMirror($wnd.document.getElementById(idHtml), {
          value: javaCode,
          mode: "text/x-java",
          lineNumbers: true,
          styleActiveLine: true,
          matchBrackets: true,
          mode: "text/x-java",
          extraKeys: {
            "F11": function(cm) {
              cm.setOption("fullScreen", !cm.getOption("fullScreen"));
            },
            "Esc": function(cm) {
              if (cm.getOption("fullScreen")) cm.setOption("fullScreen", false);
            },
            "Alt-F": "findPersistent"
          }
        });
        
        $wnd.jQuery("#" + idHtml + ">.CodeMirror").height($wnd.jQuery("#" + idHtml).innerHeight() + "px");
    }-*/;
    
}
