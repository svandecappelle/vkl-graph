package fr.vekia.tools.showcase.vkgraph.client.showcase.application.ui;

import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.SimplePanel;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 28 août 2012. VklGraph version 1.2
 * @version 2.1
 */
public class Slider extends Composite {

    private SimplePanel element;

    /**
     * Default constructor
     * 
     */
    public Slider() {
        element = new SimplePanel();
        element.getElement().setId(DOM.createUniqueId());
        initWidget(element);
    }

    @Override
    protected void onAttach() {
        super.onAttach();
        this.createSlider(element.getElement().getId());
    }

    /**
     * 
     */
    private native void createSlider(String id) /*-{
                                                console.log("slider create");
                                                $wnd.jQuery(id).slider();
                                                }-*/;

}
