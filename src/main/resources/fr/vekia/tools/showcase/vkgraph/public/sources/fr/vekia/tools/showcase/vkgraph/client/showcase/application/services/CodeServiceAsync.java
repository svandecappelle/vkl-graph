package fr.vekia.tools.showcase.vkgraph.client.showcase.application.services;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface CodeServiceAsync {

    /**
     * GWT-RPC service asynchronous (client-side) interface
     * 
     * @see fr.vekia.tools.showcase.vkgraph.client.showcase.application.services.CodeService
     */
    void getCode(java.lang.String string, AsyncCallback<java.lang.String> callback);

    /**
     * GWT-RPC service asynchronous (client-side) interface
     * 
     * @see fr.vekia.tools.showcase.vkgraph.client.showcase.application.services.CodeService
     */
    void getCodeUrl(java.lang.String name, AsyncCallback<fr.vekia.tools.showcase.vkgraph.shared.CodeUrl> callback);

    /**
     * Utility class to get the RPC Async interface from client-side code
     */
    public static final class Util {
        private static CodeServiceAsync instance;

        public static final CodeServiceAsync getInstance() {
            if (instance == null) {
                instance = (CodeServiceAsync) GWT.create(CodeService.class);
            }
            return instance;
        }

        private Util() {
            // Utility class should not be instanciated
        }
    }
}
