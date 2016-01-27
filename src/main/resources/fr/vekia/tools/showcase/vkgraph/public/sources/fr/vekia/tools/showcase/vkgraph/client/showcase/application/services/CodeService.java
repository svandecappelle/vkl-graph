package fr.vekia.tools.showcase.vkgraph.client.showcase.application.services;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import fr.vekia.tools.showcase.vkgraph.shared.CodeUrl;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 14 mai 2012. GWTQuery Vekia Showcase
 * @version 1.0
 */
@RemoteServiceRelativePath("codingServlet")
public interface CodeService extends RemoteService {

    /**
     * @param string
     * @return
     * @throws Exception
     */
    String getCode(String string);

    CodeUrl getCodeUrl(String name);

}
