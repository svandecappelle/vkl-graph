/*
 * File: $URL: svn+ssh://chimay/home/svn/VkGraph-showcase/VkGraph-showcase/src/main/java/fr.vekia.tools.showcase.vkgraph/client/showcase/application/components/menu/ShowcaseMenuTree.java $
 * $Id: ShowcaseMenuTree.java 38 2012-08-23 16:36:45Z svandecappelle $
 * Licence MIT
 * 
 * Last change:
 * $Date: 2012-08-23 18:36:45 +0200 (jeu., 23 août 2012) $
 * $Author: svandecappelle $
 */
package fr.vekia.tools.showcase.vkgraph.client.showcase.application.components.menu;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 27 avr. 2012. GWTQuery Vekia Showcase
 * @version 1.0
 * 
 *          {@inheritDoc}
 */
public class ShowcaseMenuTree extends TreeMenu<AbstractShowcaseTreeMenuItem> {

    private AbstractShowcaseTreeMenuItem item;

    /**
     * Default constructor
     * 
     */
    public ShowcaseMenuTree(AbstractShowcaseTreeMenuItem itemBean) {
	super(itemBean);
	super.getTreeWidget().setAnimationEnabled(true);
	this.item = itemBean;
	if (this.item.hasChildren()) {
	    this.item.addStyleName("folder-tree");
	} else if (this.item.hasScreen()) {
	    this.item.addStyleName("chart-item");
	}
    }

    /**
     * @return the item
     */
    public AbstractShowcaseTreeMenuItem getItem() {
	return item;
    }

}
