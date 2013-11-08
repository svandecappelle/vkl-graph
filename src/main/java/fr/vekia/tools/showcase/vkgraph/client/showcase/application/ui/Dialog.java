/*
 * File: $URL: svn+ssh://chimay/home/svn/VkGraph-showcase/VkGraph-showcase/src/main/java/fr.vekia.tools.showcase.vkgraph/client/showcase/application/ui/Dialog.java $
 * $Id: Dialog.java 40 2012-08-30 10:12:40Z svandecappelle $
 * Licence MIT
 *
 * Last change:
 * $Date: 2012-08-30 12:12:40 +0200 (jeu., 30 août 2012) $
 * $Author: svandecappelle $
 */
package fr.vekia.tools.showcase.vkgraph.client.showcase.application.ui;

import com.google.gwt.animation.client.Animation;
import com.google.gwt.dom.client.Style;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.UIObject;

import fr.vekia.tools.showcase.vkgraph.client.showcase.application.SequentialTimer;
import fr.vekia.tools.showcase.vkgraph.client.showcase.application.SequentialTimerStack;
import fr.vekia.tools.showcase.vkgraph.client.showcase.application.animations.AnimationEnum;
import fr.vekia.tools.showcase.vkgraph.client.showcase.application.animations.JqueryAnimation;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 28 août 2012. VklGraph version 1.2
 * @version 2.1
 * 
 *          {@inheritDoc}
 */
public class Dialog extends Animation {
    private static final int MILLESECONDS_SLOW_EVENT_DURATION = 1000;
    private static final int MILLESECONDS_DEFAULT_EVENT_DURATION = 500;
    private static final int MILLESECONDS_FAST_EVENT_DURATION = 300;

    private static final int DEFAULT_WIDGET_ANIMATION_X_END_POSITION = 50;
    private static final int DEFAULT_WIDGET_ANIMATION_Y_END_POSITION = 50;

    private DialogBox messageBox;
    private boolean notYetSet;
    private boolean resetPositionPopupToEachVisible = false;
    private AnimationEnum animationShow;
    private AnimationEnum animationHide;

    private int startX;
    private int startY;
    private int finalX;
    private int finalY;
    private int positionPercentLeft;
    private int positionPercentTop;
    private Unit unitx;
    private Unit unity;

    /**
     * Default constructor
     * 
     */
    public Dialog() {
	this("System message");
    }

    /**
     * Default constructor
     * 
     * @param string
     */
    public Dialog(String dialogTitle) {
	messageBox = new DialogBox(true, false);
	messageBox.setText(dialogTitle);
	messageBox.getElement().setId(DOM.createUniqueId());
    }

    public void show() {
	if (animationShow != null) {
	    show(animationShow);
	} else {
	    messageBox.show();
	}
    }

    public void showRelative() {
	messageBox.show();
    }

    public void center() {
	messageBox.center();
    }

    public void setAnimationShow(AnimationEnum animation) {
	this.animationShow = animation;
    }

    public void setAnimationHide(AnimationEnum animation) {
	this.animationHide = animation;
    }

    /**
     * @param x
     * @param y
     * @param milliseconds
     */
    public void scrollTo(int x, int y, int milliseconds) {
	this.finalX = x;
	this.finalY = y;

	startX = messageBox.getElement().getOffsetLeft();
	startY = messageBox.getElement().getOffsetTop();

	run(milliseconds);
    }

    @Override
    protected void onUpdate(double progress) {
	double positionX = startX + (progress * (this.finalX - startX));
	double positionY = startY + (progress * (this.finalY - startY));

	this.messageBox.getElement().getStyle().setLeft(positionX, Style.Unit.PX);
	this.messageBox.getElement().getStyle().setTop(positionY, Style.Unit.PX);
    }

    @Override
    protected void onComplete() {
	super.onComplete();
	this.messageBox.getElement().getStyle().setLeft(this.finalX, Style.Unit.PX);
	this.messageBox.getElement().getStyle().setTop(this.finalY, Style.Unit.PX);
    }

    /**
     * 
     */
    public void scrollCenter(final int milliseconds) {
	final Number positionFinalX = Window.getClientWidth() * (DEFAULT_WIDGET_ANIMATION_X_END_POSITION / 100f) - (messageBox.getOffsetHeight() / 2);
	final Number positionFinalY = Window.getClientHeight() * (DEFAULT_WIDGET_ANIMATION_Y_END_POSITION / 100f) - (messageBox.getOffsetWidth() / 2);
	scrollTo(positionFinalX.intValue(), positionFinalY.intValue(), milliseconds / 2);
    }

    private void show(AnimationEnum animation) {
	messageBox.show();
	if (animation == AnimationEnum.SCROLLCENTER_BOUNCE) {
	    SequentialTimerStack timers = new SequentialTimerStack();
	    timers.addToStack(new SequentialTimer(10) {

		@Override
		public void execute() {
		    scrollCenter(MILLESECONDS_DEFAULT_EVENT_DURATION);
		}
	    });
	    timers.addToStack(new SequentialTimer(400) {

		@Override
		public void execute() {
		    animate(AnimationEnum.BOUNCE, 3, MILLESECONDS_FAST_EVENT_DURATION);
		}
	    });

	    timers.run();
	} else {
	    JqueryAnimation.animateShow(messageBox.getElement(), animation, MILLESECONDS_SLOW_EVENT_DURATION);
	}
    }

    private void show(UIObject objectRelativeToShow, AnimationEnum animation) {
	if (!notYetSet || resetPositionPopupToEachVisible) {
	    messageBox.showRelativeTo(objectRelativeToShow);
	    notYetSet = true;
	} else {
	    messageBox.show();
	}
	if (animation != null) {
	    JqueryAnimation.animateShow(messageBox.getElement(), animation, MILLESECONDS_SLOW_EVENT_DURATION);
	}
    }

    /**
     * @param resetPositionPopupToEachVisible
     *            the resetPositionPopupToEachVisible to set
     */
    public void setResetPositionPopupToEachVisible(boolean resetPositionPopupToEachVisible) {
	this.resetPositionPopupToEachVisible = resetPositionPopupToEachVisible;
    }

    public void setPopupAnimationStartPosition(int startxPosition, Unit unitx, int startyPosition, Unit unity) {
	this.unitx = unitx;
	this.unity = unity;

	this.positionPercentLeft = startxPosition;
	this.positionPercentTop = startyPosition;
	resetStartPosition();
    }

    private void resetStartPosition() {
	Number startx;
	Number starty;
	if (unitx == Unit.PCT) {
	    startx = Window.getClientWidth() * (positionPercentLeft / 100f) - (messageBox.getOffsetHeight() / 2);
	} else {
	    startx = positionPercentLeft;
	}
	if (unity == Unit.PCT) {
	    starty = Window.getClientHeight() * (positionPercentTop / 100f) - (messageBox.getOffsetWidth() / 2);
	} else {
	    starty = positionPercentTop;
	}

	messageBox.setPopupPosition(startx.intValue(), starty.intValue());
    }

    public void hide() {
	if (animationHide != null) {
	    hide(animationHide);
	} else {
	    messageBox.hide();
	}
    }

    private void hide(AnimationEnum animation) {
	JqueryAnimation.animateHide(messageBox.getElement(), animation, MILLESECONDS_SLOW_EVENT_DURATION);
	SequentialTimerStack timers = new SequentialTimerStack();
	timers.addToStack(new SequentialTimer(MILLESECONDS_SLOW_EVENT_DURATION + MILLESECONDS_FAST_EVENT_DURATION) {

	    @Override
	    public void execute() {
		messageBox.hide();
	    }
	});
	timers.run();
    }

    /**
     * @param buttonShow
     */
    public void showRelativeTo(UIObject objectUi) {
	messageBox.showRelativeTo(objectUi);
    }

    /**
     * @param bounce
     */
    public void animate(AnimationEnum animation, int timesToAnimation, int duration) {
	JqueryAnimation.animate(animation, messageBox.getElement(), timesToAnimation, duration);
    }

    /**
     * @param b
     */
    public void setAutoHideEnabled(boolean autoHide) {
	messageBox.setAutoHideEnabled(autoHide);
    }

    public void setGlassEnabled(boolean enabled) {
	messageBox.setGlassEnabled(enabled);
    }

    /**
     * @param container
     */
    public void setWidget(IsWidget widget) {
	messageBox.setWidget(widget);
    }

    /**
     * @param buttonShow
     */
    public void show(UIObject relativeShow) {
	show(relativeShow, animationShow);
    }
}
