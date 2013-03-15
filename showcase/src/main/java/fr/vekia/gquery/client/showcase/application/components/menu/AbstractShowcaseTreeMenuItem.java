/*
 * File: $URL: svn+ssh://chimay/home/svn/VkGraph-showcase/VkGraph-showcase/src/main/java/fr/vekia/gquery/client/showcase/application/components/menu/AbstractShowcaseTreeMenuItem.java $
 * $Id: AbstractShowcaseTreeMenuItem.java 39 2012-08-24 16:33:44Z svandecappelle $
 * Licence MIT
 * 
 * Last change:
 * $Date: 2012-08-24 18:33:44 +0200 (ven., 24 août 2012) $
 * $Author: svandecappelle $
 */
package fr.vekia.gquery.client.showcase.application.components.menu;

import java.util.List;

import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.TreeItem;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 27 avr. 2012. GWTQuery Vekia Showcase
 * @version 1.0
 * 
 *          {@inheritDoc}
 */
public abstract class AbstractShowcaseTreeMenuItem extends TreeItem {

    /**
     * Default constructor
     * 
     */
    public AbstractShowcaseTreeMenuItem(String text) {
	if (hasChildren()) {
	    for (AbstractShowcaseTreeMenuItem child : getChildrenItems()) {
		super.addItem(child);
		if (child.hasScreen()) {
		    child.addStyleName("chart-item");
		}else if(child.hasChildren()){
		    child.addStyleName("folder-tree");
		}
	    }
	}
	super.setText(text);
	this.setState(true);
    }

    public abstract boolean hasChildren();

    public abstract List<AbstractShowcaseTreeMenuItem> getChildrenItems();

    public abstract boolean hasScreen();

    public abstract IsWidget getScreen();
}
