/*
 * File: $URL$
 * $Id$
 * Copyright: Vekia
 *
 * Last change:
 * $Date$
 * $Author$
 */
package fr.vekia.gquery.client.showcase.application;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.HeadElement;
import com.google.gwt.dom.client.Node;
import com.google.gwt.dom.client.NodeList;
import com.google.gwt.i18n.client.LocaleInfo;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.ui.RootPanel;

import fr.vekia.gquery.client.showcase.application.injector.ShowcaseInjector;

/**
 * @author svandecappelle
 * @since Dec 14, 2012. VklGraph version 1.2
 * @version 2.1
 * 
 *          {@inheritDoc}
 */
public class ThemeFactory {

    public enum Theme {
	CLEAR("clear"),
	DARK("dark"),
	PRO("pro");

	private String themeName;

	/**
	 * Default constructor
	 * 
	 */
	private Theme(String themeName) {
	    this.themeName = themeName;
	}

	/**
	 * @return the themeName
	 */
	public String getThemeName() {
	    return themeName;
	}
    }

    private static String CUR_THEME;

    public static void setTheme(Theme theme) {
	CUR_THEME = theme.getThemeName();
	updateStyleSheets();
    }

    /**
     * Update the style sheets to reflect the current theme and direction.
     */
    private static void updateStyleSheets() {
	// Generate the names of the style sheets to include
	String gwtStyleSheet = "/css/themes/" + CUR_THEME + "/" + CUR_THEME + ".css";
	if (LocaleInfo.getCurrentLocale().isRTL()) {
	    gwtStyleSheet = gwtStyleSheet.replace(".css", "_rtl.css");
	}

	// Find existing style sheets that need to be removed
	boolean styleSheetsFound = false;
	final HeadElement headElem = StyleSheetLoader.getHeadElement();
	final List<Element> toRemove = new ArrayList<Element>();
	NodeList<Node> children = headElem.getChildNodes();
	for (int i = 0; i < children.getLength(); i++) {
	    Node node = children.getItem(i);
	    if (node.getNodeType() == Node.ELEMENT_NODE) {
		Element elem = Element.as(node);
		if (elem.getTagName().equalsIgnoreCase("link") && elem.getPropertyString("rel").equalsIgnoreCase("stylesheet")) {
		    styleSheetsFound = true;
		    String href = elem.getPropertyString("href");
		    // If the correct style sheets are already loaded, then we should have
		    // nothing to remove.
		    if (!href.contains(gwtStyleSheet) && notAdependencyTheme(href)) {
			toRemove.add(elem);
		    }
		}
	    }
	}

	// Return if we already have the correct style sheets
	if (styleSheetsFound && toRemove.size() == 0) {
	    return;
	}

	// Detach the app while we manipulate the styles to avoid rendering issues

	// Remove the old style sheets
	for (Element elem : toRemove) {
	    headElem.removeChild(elem);
	}

	// Load the GWT theme style sheet
	Command callback = new Command() {
	    /**
	     * The number of style sheets that have been loaded and executed this
	     * command.
	     */
	    private int numStyleSheetsLoaded = 0;

	    public void execute() {
		// Wait until all style sheets have loaded before re-attaching the app
		numStyleSheetsLoaded++;
		if (numStyleSheetsLoaded < 2) {
		    return;
		}

		// Different themes use different background colors for the body
		// element, but IE only changes the background of the visible content
		// on the page instead of changing the background color of the entire
		// page. By changing the display style on the body element, we force
		// IE to redraw the background correctly.
		RootPanel.getBodyElement().getStyle().setProperty("display", "none");
		RootPanel.getBodyElement().getStyle().setProperty("display", "");
		ShowcaseInjector injector = ShowcaseInjector.Util.getInstance();
		ShowcasePresenter presenter = injector.getPresenter();
		presenter.revealDisplay();
		// ThemeInjector injectorTheme = ThemeInjector.Util.getInstance();
		// injectorTheme.getPresenter().revealDisplay();
	    }
	};
	StyleSheetLoader.loadStyleSheet(gwtStyleSheet, getCurrentReferenceStyleName("gwt"), callback);

	// Load the showcase specific style sheet after the GWT theme style sheet so
	// that custom styles supercede the theme styles.
	// StyleSheetLoader.loadStyleSheet(showcaseStyleSheet, getCurrentReferenceStyleName("Application"), callback);
    }

    /**
     * @param href
     * @return
     */
    private static boolean notAdependencyTheme(String href) {
	boolean isNotADependency = true;
	if (href.contains("jquery-ui-1.8.23.custom.css")) {
	    isNotADependency = false;
	} else if (href.contains("jquery.jqplot.css")) {
	    isNotADependency = false;
	} else if (href.contains("gwt/clean/clean.css")) {
	    isNotADependency = false;
	}

	return isNotADependency;
    }

    /**
     * Get the style name of the reference element defined in the current GWT
     * theme style sheet.
     * 
     * @param prefix
     *            the prefix of the reference style name
     * @return the style name
     */
    private static String getCurrentReferenceStyleName(String prefix) {
	String gwtRef = prefix + "-Reference-" + CUR_THEME;
	if (LocaleInfo.getCurrentLocale().isRTL()) {
	    gwtRef += "-rtl";
	}
	return gwtRef;
    }

    /**
     * @return
     */
    public static int getHeaderSizes() {

	if (CUR_THEME == Theme.PRO.getThemeName()) {
	    return 20;
	}

	return 20;
    }

}
