package fr.vekia.tools.showcase.vkgraph.client.showcase.application.ui;

import com.google.gwt.animation.client.Animation;
import com.google.gwt.user.client.ui.UIObject;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 29 août 2012. VklGraph version 1.2
 * @version 2.1
 */
public class ProgressAnimation extends Animation {
    private UIObject composite;

    /**
     * Default constructor
     * 
     * @param progress
     * 
     */
    public ProgressAnimation(UIObject composite) {
        this.composite = composite;
    }

    @Override
    protected void onUpdate(double progress) {
        double size = (int) (progress * this.composite.getElement().getParentElement().getOffsetWidth());
        if (size == 0) {
            size = 1;
        }
        this.composite.setWidth(size + "px");

    }

}
