/*
 * File: $URL: svn+ssh://chimay/home/svn/VkGraph-showcase/VkGraph-showcase/src/main/java/fr/vekia/gquery/client/showcase/application/ui/ProgressAnimation.java $
 * $Id: ProgressAnimation.java 40 2012-08-30 10:12:40Z svandecappelle $
 * Licence MIT
 *
 * Last change:
 * $Date: 2012-08-30 12:12:40 +0200 (jeu., 30 août 2012) $
 * $Author: svandecappelle $
 */
package fr.vekia.gquery.client.showcase.application.ui;

import com.google.gwt.animation.client.Animation;
import com.google.gwt.user.client.ui.UIObject;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 29 août 2012. VklGraph version 1.2
 * @version 2.1
 * 
 *          {@inheritDoc}
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
