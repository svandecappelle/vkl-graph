/*
 * File: $URL: svn+ssh://chimay/home/svn/VkGraph-showcase/VkGraph.showcase/src/main/java/fr/vekia/gquery/client/showcase/application/components/menu/MenuItem.java$
 * $Id: MenuItem.java 22 2012-06-27 16:38:32Z svandecappelle $
 * Licence MIT
 * 
 * Last change:
 * $Date: 2012-06-27 18:38:32 +0200 (mer., 27 juin 2012) $
 * $Author: svandecappelle $
 */
package fr.vekia.gquery.client.showcase.application.components.menu;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 25 avr. 2012. GWTQuery Vekia Showcase
 * @version 1.0
 * 
 *          {@inheritDoc}
 */
public class MenuItem extends Composite {

    private SimplePanel layout;

    /**
     * Default constructor
     * 
     */
    public MenuItem() {
	layout = new SimplePanel();
	layout.setWidth("100%");
	initWidget(layout);
    }

    /**
     * 
     */
    public void set(Widget widget) {
	layout.setWidget(widget);
    }

}
