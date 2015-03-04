package fr.vekia.vkgraph.client.charts;

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
