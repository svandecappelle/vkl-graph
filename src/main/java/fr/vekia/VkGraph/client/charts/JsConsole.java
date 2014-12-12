/*
 * File: $URL: https://vklgraph.googlecode.com/svn/trunk/src/main/java/fr/vekia/VkGraph/client/charts/JsConsole.java $
 * $Id: JsConsole.java 34 2012-08-31 13:03:35Z steeve.vandecappelle@gmail.com $
 * Licence MIT
 *
 * Last change:
 * $Date: 2012-08-31 15:03:35 +0200 (ven., 31 août 2012) $
 * $Author: steeve.vandecappelle@gmail.com $
 */
package fr.vekia.VkGraph.client.charts;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 30 août 2012. VklGraph version 1.2
 * @version 2.1
 * 
 *          {@inheritDoc}
 */
public final class JsConsole {
	/**
	 * Default constructor
	 * 
	 */
	private JsConsole() {
	}

	/**
     * 
     */
	// @formatter:off
	public static native void warn(String errorCode, String debugParam, String message) /*-{
		console.warn("WARNING:" + errorCode + " DebugParam: " + debugParam + " - " + message);
	}-*/;
	// @formatter:on

	/**
     * 
     */
	// @formatter:off
	public static native void info(String message) /*-{
		console.log("LOG:" + message);
	}-*/;
	// @formatter:on

	/**
	 * Log a javascript object
	 * 
	 * @param javaScriptObject
	 */
	// @formatter:off
	public static native void info(JavaScriptObject javaScriptObject) /*-{
		console.log(javaScriptObject);
	}-*/;
	// @formatter:on
}
