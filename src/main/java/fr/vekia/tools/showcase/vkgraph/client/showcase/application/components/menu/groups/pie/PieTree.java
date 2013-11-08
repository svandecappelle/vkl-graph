/*
 * File: $URL: svn+ssh://chimay/home/svn/VkGraph-showcase/VkGraph-showcase/src/main/java/fr.vekia.tools.showcase.vkgraph/client/showcase/application/components/menu/groups/pie/PieTree.java $
 * $Id: PieTree.java 22 2012-06-27 16:38:32Z svandecappelle $
 * Licence MIT
 * 
 * Last change:
 * $Date: 2012-06-27 18:38:32 +0200 (mer., 27 juin 2012) $
 * $Author: svandecappelle $
 */
package fr.vekia.tools.showcase.vkgraph.client.showcase.application.components.menu.groups.pie;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.client.ui.IsWidget;

import fr.vekia.tools.showcase.vkgraph.client.showcase.application.components.menu.AbstractShowcaseTreeMenuItem;
import fr.vekia.tools.showcase.vkgraph.client.showcase.application.demo.items.pies.DonutExempleItem;
import fr.vekia.tools.showcase.vkgraph.client.showcase.application.demo.items.pies.GeneralPieExempleItem;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 4 mai 2012. GWTQuery Vekia Showcase
 * @version 1.0
 * 
 *          {@inheritDoc}
 */
public class PieTree extends AbstractShowcaseTreeMenuItem {
    /**
     * Default constructor
     * 
     */
    public PieTree() {
	super("Pies");
    }

    @Override
    public boolean hasChildren() {
	return true;
    }

    @Override
    public List<AbstractShowcaseTreeMenuItem> getChildrenItems() {
	List<AbstractShowcaseTreeMenuItem> childrens = new ArrayList<AbstractShowcaseTreeMenuItem>();
	childrens.add(new GeneralPieExempleItem("Simple pie"));
	childrens.add(new DonutExempleItem("Donut"));
	return childrens;
    }

    @Override
    public boolean hasScreen() {
	return false;
    }

    @Override
    public IsWidget getScreen() {
	return null;
    }

}
