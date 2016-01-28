package fr.vekia.tools.showcase.vkgraph.client.showcase.application.layout.menu;

import java.util.List;

import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.TreeItem;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 27 avr. 2012. GWTQuery Vekia Showcase
 * @version 1.0
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
                } else if (child.hasChildren()) {
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
