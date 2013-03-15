/*
 * File: $URL: svn+ssh://chimay/home/svn/VkGraph-showcase/VkGraph-showcase/src/main/java/fr/vekia/gquery/server/ClassReaderServlet.java $
 * $Id: ClassReaderServlet.java 36 2012-08-20 09:04:30Z svandecappelle $
 * Licence MIT
 * 
 * Last change:
 * $Date: 2012-08-20 11:04:30 +0200 (lun., 20 août 2012) $
 * $Author: svandecappelle $
 */
package fr.vekia.gquery.server;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;
import java.util.logging.Logger;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import fr.vekia.gquery.client.showcase.application.services.CodeService;
import fr.vekia.gquery.shared.CodeUrl;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 14 mai 2012. GWTQuery Vekia Showcase
 * @version 1.0
 * 
 *          {@inheritDoc}
 */
public class ClassReaderServlet extends RemoteServiceServlet implements CodeService {

    private static final Logger LOGGER = Logger.getLogger(ClassReaderServlet.class.getName());
    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public String getCode(String className) {
	URL url = ClassReaderServlet.class.getResource("/" + className.replaceAll("\\.", "/") + ".java.html");
	File classFile = new File(url.getFile());	
	if (classFile.exists() && classFile.canRead()) {
	    try {
		return read(classFile).toString();
	    } catch (IOException e) {
		LOGGER.severe(e.getMessage());
	    }
	}
	return "Code not available yet";
    }

    /** Read the contents of the given file. */
    private StringBuilder read(File file) throws IOException {
	StringBuilder text = new StringBuilder();
	String lineSeparator = System.getProperty("line.separator");
	Scanner scanner = new Scanner(new FileInputStream(file), "UTF-8");
	try {
	    while (scanner.hasNextLine()) {
		text.append(scanner.nextLine() + lineSeparator);
	    }
	} finally {
	    scanner.close();
	}
	return text;
    }

    @Override
    public CodeUrl getCodeUrl(String className) {
	try {
	    String url = className;
	    url = url.replaceFirst("fr\\.vekia\\.gquery\\.client\\.", "");
	    url = url.replaceAll("\\.", "/");
	    url = url.concat(".java.html");
	    return new CodeUrl(url, className);
	} catch (Exception e) {
	    return null;
	}
    }
}