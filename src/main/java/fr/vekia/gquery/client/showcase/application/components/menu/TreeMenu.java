/*
 * File: $URL: svn+ssh://chimay/home/svn/VkGraph-showcase/VkGraph.showcase/src/main/java/fr/vekia/gquery/client/showcase/application/components/menu/TreeMenu.java$
 * $Id: TreeMenu.java 22 2012-06-27 16:38:32Z svandecappelle $
 * Licence MIT
 * 
 * Last change:
 * $Date: 2012-06-27 18:38:32 +0200 (mer., 27 juin 2012) $
 * $Author: svandecappelle $
 */
package fr.vekia.gquery.client.showcase.application.components.menu;

import com.google.gwt.event.logical.shared.HasSelectionHandlers;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.Tree;
import com.google.gwt.user.client.ui.TreeItem;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 25 avr. 2012. GWTQuery Vekia Showcase
 * @version 1.0
 * 
 *          {@inheritDoc}
 */
public abstract class TreeMenu<T extends TreeItem> extends MenuItem implements HasSelectionHandlers<TreeItem> {

    private Tree treeWidget;

    /**
     * Default constructor
     * 
     */
    public TreeMenu() {
	super();
	treeWidget = new Tree();
	treeWidget.setWidth("100%");
	set(treeWidget);
    }

    /**
     * Default constructor
     * 
     */
    public TreeMenu(TreeItem treeItem) {
	this();
	addSection(treeItem);
    }

    /**
     * 
     */
    public final void addSection(TreeItem treeItem) {
	treeWidget.addItem(treeItem);
    }

    public static final TreeItem buildTreeItem(String titleGroup, String... items) {
	TreeItem treeGroup = new TreeItem(titleGroup);
	treeGroup.setWidth("100%");
	for (String itemsLabel : items) {
	    TreeItem item = treeGroup.addItem(itemsLabel);
	    item.setWidth("100%");
	}
	return treeGroup;

    }

    /**
     * @return the treeWidget
     */
    public Tree getTreeWidget() {
	return treeWidget;
    }

    @Override
    public HandlerRegistration addSelectionHandler(SelectionHandler<TreeItem> handler) {
	return treeWidget.addSelectionHandler(handler);
    }
}
