package fr.vekia.tools.showcase.vkgraph.client.showcase.application.layout.menu;

import com.google.gwt.event.logical.shared.HasSelectionHandlers;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.user.client.ui.Tree;
import com.google.gwt.user.client.ui.TreeItem;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 25 avr. 2012. GWTQuery Vekia Showcase
 * @version 1.0
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
        TreeItem treeGroup = new TreeItem(SafeHtmlUtils.fromString(titleGroup));
        treeGroup.setWidth("100%");
        for (String itemsLabel : items) {
            TreeItem item = treeGroup.addItem(SafeHtmlUtils.fromString(itemsLabel));
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
