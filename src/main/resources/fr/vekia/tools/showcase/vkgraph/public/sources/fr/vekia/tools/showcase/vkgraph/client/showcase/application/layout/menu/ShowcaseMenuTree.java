package fr.vekia.tools.showcase.vkgraph.client.showcase.application.layout.menu;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 27 avr. 2012. GWTQuery Vekia Showcase
 * @version 1.0
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
