/*
 * File: $URL: svn+ssh://chimay/home/svn/VkGraph-showcase/VkGraph-showcase/src/main/java/fr/vekia/gquery/client/showcase/application/services/CodeService.java $
 * $Id: CodeService.java 42 2012-08-31 13:58:13Z svandecappelle $
 * Licence MIT
 * 
 * Last change:
 * $Date: 2012-08-31 15:58:13 +0200 (ven., 31 août 2012) $
 * $Author: svandecappelle $
 */
package fr.vekia.gquery.client.showcase.application.services;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import fr.vekia.gquery.shared.CodeUrl;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 14 mai 2012. GWTQuery Vekia Showcase
 * @version 1.0
 * 
 *          {@inheritDoc}
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
