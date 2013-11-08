/*
 * File: $URL: svn+ssh://chimay/home/svn/VkGraph-showcase/VkGraph-showcase/src/main/java/fr.vekia.tools.showcase.vkgraph/client/showcase/application/animations/JqueryAnimation.java $
 * $Id: JqueryAnimation.java 42 2012-08-31 13:58:13Z svandecappelle $
 * Licence MIT
 *
 * Last change:
 * $Date: 2012-08-31 15:58:13 +0200 (ven., 31 août 2012) $
 * $Author: svandecappelle $
 */
package fr.vekia.tools.showcase.vkgraph.client.showcase.application.animations;

import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 27 août 2012. VklGraph version 1.2
 * @version 2.1
 * 
 *          {@inheritDoc}
 */
public final class JqueryAnimation {
    /**
     * Default constructor
     * 
     */
    private JqueryAnimation() {
    }

    public static void animateShow(Element element, AnimationEnum animation, int duration) {
	if (element.getId().isEmpty()) {
	    element.setId(DOM.createUniqueId());
	}
	switch (animation) {
	case EXPLODE:
	    explode("#" + element.getId(), true, duration);
	    break;
	case FADE_IN:
	    fadeIn("#" + element.getId(), duration);
	    break;
	case FADE_OUT:
	    fadeOut("#" + element.getId(), duration);
	    break;
	case FADE_TOGGLE:
	    fadeToggle("#" + element.getId(), duration);
	    break;
	case SLIDE_DOWN:
	    slideDown("#" + element.getId(), true, duration);
	    break;
	case SLIDE_TOGGLE:
	    slideToggle("#" + element.getId(), true, duration);
	    break;
	case SLIDE_UP:
	    slideUp("#" + element.getId(), true, duration);
	    break;
	default:
	    break;
	}
    }

    public static void animateHide(Element element, AnimationEnum animation, int duration) {
	if (element.getId().isEmpty()) {
	    element.setId(DOM.createUniqueId());
	}
	switch (animation) {
	case EXPLODE:
	    explode("#" + element.getId(), false, duration);
	    break;
	case FADE_IN:
	    fadeIn("#" + element.getId(), duration);
	    break;
	case FADE_OUT:
	    fadeOut("#" + element.getId(), duration);
	    break;
	case FADE_TOGGLE:
	    fadeToggle("#" + element.getId(), duration);
	    break;
	case SLIDE_DOWN:
	    slideDown("#" + element.getId(), false, duration);
	    break;
	case SLIDE_TOGGLE:
	    slideToggle("#" + element.getId(), false, duration);
	    break;
	case SLIDE_UP:
	    slideUp("#" + element.getId(), false, duration);
	    break;
	default:
	    break;
	}
    }

    private native static void explode(String id, boolean isShow, int duration) /*-{
	if (isShow) {
	    $wnd.jQuery(id).show("explode", duration);
	} else {
	    $wnd.jQuery(id).hide("explode", duration);
	}
    }-*/;

    private native static void fadeIn(String id, int duration) /*-{
	$wnd.jQuery(id).show("fade", {}, duration);
    }-*/;

    private native static void fadeOut(String id, int duration) /*-{
	$wnd.jQuery(id).hide("fade", {}, duration);
    }-*/;

    private native static void fadeToggle(String id, int duration) /*-{
	$wnd.jQuery(id).fadeToggle("" + duration, "linear");
    }-*/;

    private native static void slideUp(String id, boolean isShow, int duration) /*-{
	if (isShow) {
	    $wnd.jQuery(id).show("slide", {
		direction : "up"
	    }, duration);
	} else {
	    $wnd.jQuery(id).hide("slide", {
		direction : "up"
	    }, duration);
	}
    }-*/;

    private native static void slideDown(String id, boolean isShow, int duration) /*-{
	if (isShow) {
	    $wnd.jQuery(id).show("slide", {
		direction : "down"
	    }, duration);
	} else {
	    $wnd.jQuery(id).hide("slide", {
		direction : "down"
	    }, duration);
	}
    }-*/;

    private native static void slideToggle(String id, boolean isShow, int duration) /*-{
	if (isShow) {
	    $wnd.jQuery(id).show("slide", {
		direction : "toggle"
	    }, duration);
	} else {
	    $wnd.jQuery(id).hide("slide", {
		direction : "toggle"
	    }, duration);
	}
    }-*/;

    private native static void bounce(String id, int times, int duration) /*-{
	$wnd.jQuery(id).effect("bounce", {
	    times : times
	}, duration);
    }-*/;

    private native static void pulsate(String id, int times, int duration) /*-{
	$wnd.jQuery(id).effect("pulsate", {
	    times : times
	}, duration);

    }-*/;

    /**
     * @param animation
     */
    public static void animate(AnimationEnum animation, Element element, int times, int duration) {
	if (element.getId().isEmpty()) {
	    element.setId(DOM.createUniqueId());
	}
	switch (animation) {
	case BOUNCE:
	    bounce("#" + element.getId(), times, duration);
	    break;
	case PULSATE:
	    pulsate("#" + element.getId(), times, duration);
	    break;
	default:
	    break;
	}
    }

}
