/*
 * File: $URL: svn+ssh://chimay/home/svn/VkGraph-showcase/VkGraph-showcase/src/main/java/fr/vekia/gquery/shared/CodeUrl.java $
 * $Id: CodeUrl.java 36 2012-08-20 09:04:30Z svandecappelle $
 * Licence MIT
 *
 * Last change:
 * $Date: 2012-08-20 11:04:30 +0200 (lun., 20 août 2012) $
 * $Author: svandecappelle $
 */
package fr.vekia.gquery.shared;

import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 17 août 2012. VklGraph version 1.2
 * @version 2.1
 * 
 *          {@inheritDoc}
 */
public class CodeUrl implements IsSerializable {
    private String url;
    private String className;

    /**
     * Default constructor
     * 
     */
    public CodeUrl() {
    }

    /**
     * Default constructor
     * 
     * @param url
     * @param className
     */
    public CodeUrl(String url, String className) {
	super();
	this.url = url;
	this.className = className;
    }

    /**
     * @return the url
     */
    public String getUrl() {
	return url;
    }

    /**
     * @param url
     *            the url to set
     */
    public void setUrl(String url) {
	this.url = url;
    }

    /**
     * @return the className
     */
    public String getClassName() {
	return className;
    }

    /**
     * @param className
     *            the className to set
     */
    public void setClassName(String className) {
	this.className = className;
    }

}
