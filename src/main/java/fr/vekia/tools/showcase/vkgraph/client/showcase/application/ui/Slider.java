/*
 * File: $URL: svn+ssh://chimay/home/svn/VkGraph-showcase/VkGraph-showcase/src/main/java/fr.vekia.tools.showcase.vkgraph/client/showcase/application/ui/Slider.java $
 * $Id: Slider.java 40 2012-08-30 10:12:40Z svandecappelle $
 * Licence MIT
 *
 * Last change:
 * $Date: 2012-08-30 12:12:40 +0200 (jeu., 30 août 2012) $
 * $Author: svandecappelle $
 */
package fr.vekia.tools.showcase.vkgraph.client.showcase.application.ui;

import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.SimplePanel;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 28 août 2012. VklGraph version 1.2
 * @version 2.1
 * 
 *          {@inheritDoc}
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
