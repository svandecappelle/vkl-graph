/*
 * File: $URL: svn+ssh://chimay/home/svn/VkGraph-showcase/VkGraph-showcase/src/main/java/fr.vekia.tools.showcase.vkgraph/client/showcase/application/components/Menu.java $
 * $Id: Menu.java 39 2012-08-24 16:33:44Z svandecappelle $
 * Licence MIT
 * 
 * Last change:
 * $Date: 2012-08-24 18:33:44 +0200 (ven., 24 août 2012) $
 * $Author: svandecappelle $
 */
package fr.vekia.tools.showcase.vkgraph.client.showcase.application.components;

import java.util.HashMap;
import java.util.Map;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.user.client.ui.StackLayoutPanel;
import com.google.gwt.user.client.ui.TreeItem;
import com.google.gwt.user.client.ui.UIObject;
import com.google.gwt.user.client.ui.Widget;

import fr.vekia.tools.showcase.vkgraph.client.showcase.application.ShowcaseMenuPresenter.Display;
import fr.vekia.tools.showcase.vkgraph.client.showcase.application.components.menu.AbstractShowcaseTreeMenuItem;
import fr.vekia.tools.showcase.vkgraph.client.showcase.application.components.menu.ShowcaseMenuTree;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 23 avr. 2012. GWTQuery Vekia Showcase
 * @version 1.0
 * 
 *          {@inheritDoc}
 */
public class Menu implements Display {

    private StackLayoutPanel stackLayoutPanel;
    private Map<String, ShowcaseMenuTree> menuTrees;

    /**
     * Default constructor
     * 
     */
    public Menu() {
	stackLayoutPanel = new StackLayoutPanel(Unit.PX);
	stackLayoutPanel.addStyleName("Showcase-Menu");
	menuTrees = new HashMap<String, ShowcaseMenuTree>();
	stackLayoutPanel.setHeight("100%");
    }

    @Override
    public int addElementWithHeader(AbstractShowcaseTreeMenuItem items, SafeHtml header, int headerSize) {
	ShowcaseMenuTree menuTree = new ShowcaseMenuTree(items);
	stackLayoutPanel.add(menuTree, header, headerSize);
	menuTrees.put(header.asString(), menuTree);
	return stackLayoutPanel.getWidgetIndex(menuTree);
    }

    @Override
    public Widget asWidget() {
	return stackLayoutPanel;
    }

    @Override
    public ShowcaseMenuTree getSelectionHandler(String headerText) {
	return menuTrees.get(headerText);
    }

    @Override
    public void showWidget(int index) {
	stackLayoutPanel.showWidget(index);
    }

    @Override
    public void selectTreeItem(String menuTitle, AbstractShowcaseTreeMenuItem item) {
	ShowcaseMenuTree menuTree = menuTrees.get(menuTitle);
	menuTree.getTreeWidget().setSelectedItem(item);
    }

    @Override
    public void addHeaderStyleName(String style, Integer index) {
	stackLayoutPanel.getHeaderWidget(index).addStyleName(style);
    }

    @Override
    public void removeHeaderStyleName(String style, Integer index) {
	stackLayoutPanel.getHeaderWidget(index).removeStyleName(style);
    }

    @Override
    public void addItemStyleName(String menuTitle, String itemText, String style) {
	getTreeItem(menuTitle, itemText).addStyleName(style);
    }

    @Override
    public UIObject getHeaderWidget(int index) {
	return stackLayoutPanel.getHeaderWidget(index);
    }

    @Override
    public UIObject getTreeItem(String menuTitle, String itemText) {
	ShowcaseMenuTree menuTree = menuTrees.get(menuTitle);
	return getTreeItem(menuTree.getItem(), menuTitle, itemText);
    }

    private UIObject getTreeItem(TreeItem treeItem, String menuTitle, String itemText) {
	for (int i = 0; i < treeItem.getChildCount(); i++) {
	    TreeItem treeItemChild = treeItem.getChild(i);
	    if (treeItemChild.getText().equals(itemText)) {
		return treeItemChild;
	    } else if (treeItemChild.getChildCount() > 0) {
		return getTreeItem(treeItemChild, menuTitle, itemText);
	    }
	}
	return treeItem;
    }

    @Override
    public void removeItemStyleName(String menuTitle, String itemText, String style) {
	getTreeItem(menuTitle, itemText).removeStyleName(style);
    }
}