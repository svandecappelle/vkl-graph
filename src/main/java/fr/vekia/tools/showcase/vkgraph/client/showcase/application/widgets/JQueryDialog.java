package fr.vekia.tools.showcase.vkgraph.client.showcase.application.widgets;

import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.SimplePanel;

/**
 * @author svandecappelle
 * @since Nov 22, 2012. VklGraph version 1.2
 * @version 2.1
 */
public class JQueryDialog extends SimplePanel {

    private static final int HEADER_HEIGHT = 35;

    private SimplePanel innerpopup;
    private SimplePanel scrollableContent = new SimplePanel();
    private String id;

    private int height;
    private int width;

    private boolean autoSize;
    private boolean sized;
    private String codeElementId;
    private String javaCode;
    protected boolean isShowing;

    /**
     * Default constructor
     * 
     */
    public JQueryDialog(String title) {
        this(title, true);
    }

    /**
     * Default constructor
     * 
     */
    public JQueryDialog(String title, boolean autoSize) {
        this.id = DOM.createUniqueId();
        this.codeElementId = DOM.createUniqueId();
        this.innerpopup = new SimplePanel();
        this.scrollableContent = new SimplePanel();
        this.scrollableContent.getElement().setId(codeElementId);

        this.innerpopup.add(this.scrollableContent);
        this.innerpopup.setTitle(title);
        this.innerpopup.getElement().setId(id);
        this.autoSize = autoSize;

        super.add(this.innerpopup);
    }

    public void setPreferedSize(int height, int width) {
        this.sized = true;
        this.height = height;
        this.width = width;
    }

    /**
     * 
     */
    public void show() {
        RootLayoutPanel.get().insert(this, 0);

        Scheduler.get().scheduleDeferred(new ScheduledCommand() {

            @Override
            public void execute() {
                if (!sized) {
                    if (autoSize) {
                        height = scrollableContent.getOffsetHeight() + HEADER_HEIGHT;
                        width = scrollableContent.getOffsetWidth();
                    } else {
                        height = Window.getClientHeight() / 2;
                        width = Window.getClientWidth() / 3;
                    }
                }
                open(id, height, width);
                isShowing = true;
                RootLayoutPanel.get().remove(JQueryDialog.this);

                if (javaCode != null) {
                    // remove header height + scroll bar bottom
                    buildCodeMirror(codeElementId, javaCode, height - HEADER_HEIGHT - 20);
                }
            }
        });
    };

    /**
     * 
     */
    public void close() {
        close(id);
        isShowing = false;
    };

    public void setCode(String javaCode) {
        this.javaCode = javaCode;
        if (isShowing()) {
            if (!sized) {
                if (autoSize) {
                    height = scrollableContent.getOffsetHeight() + HEADER_HEIGHT;
                    width = scrollableContent.getOffsetWidth();
                } else {
                    height = Window.getClientHeight() / 2;
                    width = Window.getClientWidth() / 3;
                }
            }

            buildCodeMirror(codeElementId, javaCode, height - HEADER_HEIGHT - 20);
        }
    }

    private boolean isShowing() {
        return isShowing;
    }

    /**
     * 
     */
    // @formatter:off
    private native void buildCodeMirror(String idHtml, String javaCode, int height) /*-{
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
        
        $wnd.jQuery("#" + idHtml + ">.CodeMirror").height(height + "px");
    }-*/;

    
    private native void open(String id, int height, int width) /*-{
       $wnd.jQuery("#" + id).dialog({
           show : "slide",
           hide : "explode",
           height : height,
           width : width,
           maxHeight : height
       });
    }-*/;
    
    private native void close(String id) /*-{
        $wnd.jQuery("#" + id).dialog("close");
     }-*/;
    // @formatter:on

    public void setContent(IsWidget widget) {
        this.scrollableContent.setWidget(widget);
    }

}