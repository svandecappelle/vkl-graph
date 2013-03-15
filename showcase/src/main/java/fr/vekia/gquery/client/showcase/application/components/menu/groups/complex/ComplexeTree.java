/*
 * File: $URL: svn+ssh://chimay/home/svn/VkGraph-showcase/VkGraph-showcase/src/main/java/fr/vekia/gquery/client/showcase/application/components/menu/groups/complex/ComplexeTree.java $
 * $Id: ComplexeTree.java 44 2012-09-05 09:32:12Z svandecappelle $
 * Licence MIT
 * 
 * Last change:
 * $Date: 2012-09-05 11:32:12 +0200 (mer., 05 sept. 2012) $
 * $Author: svandecappelle $
 */
package fr.vekia.gquery.client.showcase.application.components.menu.groups.complex;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.client.ui.IsWidget;

import fr.vekia.gquery.client.showcase.application.components.menu.AbstractShowcaseTreeMenuItem;
import fr.vekia.gquery.client.showcase.application.demo.items.complex.AnimatedComplexChartItem;
import fr.vekia.gquery.client.showcase.application.demo.items.complex.AreaChartItem;
import fr.vekia.gquery.client.showcase.application.demo.items.complex.DashBoardItem;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 11 mai 2012. GWTQuery Vekia Showcase
 * @version 1.0
 * 
 *          {@inheritDoc}
 */
public class ComplexeTree extends AbstractShowcaseTreeMenuItem {

    /**
     * Default constructor
     * 
     * @param text
     */
    public ComplexeTree() {
	super("Complex charts");
    }

    @Override
    public boolean hasChildren() {
	return true;
    }

    @Override
    public List<AbstractShowcaseTreeMenuItem> getChildrenItems() {
	List<AbstractShowcaseTreeMenuItem> childrens = new ArrayList<AbstractShowcaseTreeMenuItem>();
	childrens.add(new AnimatedComplexChartItem("Zoom Proxy - Control one plot from another"));
	childrens.add(new AreaChartItem("Mixed Chart - Mix the renderers to build a plot"));
	childrens.add(new DashBoardItem("Dashboard Chart"));
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
