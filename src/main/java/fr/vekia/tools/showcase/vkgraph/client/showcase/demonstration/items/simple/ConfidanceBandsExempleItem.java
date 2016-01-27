package fr.vekia.tools.showcase.vkgraph.client.showcase.demonstration.items.simple;

import java.util.List;

import com.google.gwt.user.client.ui.IsWidget;

import fr.vekia.tools.showcase.vkgraph.client.showcase.application.components.menu.AbstractShowcaseTreeMenuItem;
import fr.vekia.tools.showcase.vkgraph.client.showcase.demonstration.screens.simple.ConfidanceBandsExempleScreen;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 14 mai 2012. GWTQuery Vekia Showcase
 * @version 1.0
 */
public class ConfidanceBandsExempleItem extends AbstractShowcaseTreeMenuItem {

    /**
     * Default constructor
     * 
     * @param text
     */
    public ConfidanceBandsExempleItem(String text) {
        super(text);
    }

    @Override
    public boolean hasChildren() {
        return false;
    }

    @Override
    public List<AbstractShowcaseTreeMenuItem> getChildrenItems() {
        return null;
    }

    @Override
    public boolean hasScreen() {
        return true;
    }

    @Override
    public IsWidget getScreen() {
        return new ConfidanceBandsExempleScreen();
    }

}