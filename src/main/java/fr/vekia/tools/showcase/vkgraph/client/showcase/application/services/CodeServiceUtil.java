package fr.vekia.tools.showcase.vkgraph.client.showcase.application.services;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

import fr.vekia.tools.showcase.vkgraph.shared.CodeUrl;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 14 mai 2012. GWTQuery Vekia Showcase
 * @version 1.0
 */
public final class CodeServiceUtil {

    private static final CodeServiceAsync SERVICE_CODING = GWT.create(CodeService.class);

    private CodeServiceUtil() {
    }

    /**
     * @return the servicecoding
     */
    public static CodeServiceAsync getServicecoding() {
        return SERVICE_CODING;
    }

    /**
     * 
     */
    public static void getCode(String className, AsyncCallback<String> callBack) {
        SERVICE_CODING.getCode(className, callBack);
    }

    /**
     * @param name
     * @param asyncCallback
     */
    public static void getCodeUrl(String name, AsyncCallback<CodeUrl> asyncCallback) {
        SERVICE_CODING.getCodeUrl(name, asyncCallback);
    }
}
