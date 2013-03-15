/*
 * File: $URL: svn+ssh://chimay/home/svn/VkGraph-showcase/VkGraph-showcase/src/main/java/fr/vekia/gquery/client/showcase/application/services/CodeServiceAsync.java $
 * $Id: CodeServiceAsync.java 36 2012-08-20 09:04:30Z svandecappelle $
 * Licence MIT
 * 
 * Last change:
 * $Date: 2012-08-20 11:04:30 +0200 (lun., 20 août 2012) $
 * $Author: svandecappelle $
 */
package fr.vekia.gquery.client.showcase.application.services;

import com.google.gwt.user.client.rpc.AsyncCallback;

import fr.vekia.gquery.shared.CodeUrl;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 14 mai 2012. GWTQuery Vekia Showcase
 * @version 1.0
 * 
 *          {@inheritDoc}
 */
public interface CodeServiceAsync {

    void getCode(String string, AsyncCallback<String> callback);

    /**
     * @param name
     * @param asyncCallback
     */
    void getCodeUrl(String name, AsyncCallback<CodeUrl> asyncCallback);

}
