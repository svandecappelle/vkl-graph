package fr.vekia.tools.showcase.vkgraph.client.showcase.application.layout.home.display;

import com.google.gwt.dom.client.Style.Position;
import com.google.gwt.dom.client.Style.Unit;
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
    public void onSuccess(final String code) {
        final String id = DOM.createUniqueId();
        SimplePanel codingWidget = new SimplePanel() {
            @Override
            protected void onAttach() {
                super.onAttach();
                buildCodeMirror(id, code);
            }
        };
        codingWidget.setSize(Slides.WIDTH + "px", Slides.HEIGHT + "px");
        codingWidget.getElement().getStyle().setPosition(Position.ABSOLUTE);
        codingWidget.getElement().getStyle().setLeft(0, Unit.PX);
        codingWidget.getElement().getStyle().setTop(0, Unit.PX);
        codingWidget.getElement().setId(id);
        this.controller.pop(codingWidget);
    }

    // @formatter:off
    private native void buildCodeMirror(String idHtml, String javaCode) /*-{
        $wnd.jQuery("#" + idHtml).empty();
        var height = $wnd.jQuery("#jssor_1").innerHeight();
        var width = $wnd.jQuery("#jssor_1").innerWidth();
        
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
        
        $wnd.jQuery("#" + idHtml + ">.CodeMirror").height(height + "px");
        $wnd.jQuery("#" + idHtml + ">.CodeMirror").width(width + "px");
        
    }-*/;
    
}
