package fr.vekia.tools.showcase.vkgraph.server;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.google.inject.Singleton;

import fr.vekia.tools.showcase.vkgraph.client.showcase.application.services.CodeService;
import fr.vekia.tools.showcase.vkgraph.shared.CodeUrl;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 14 mai 2012. GWTQuery Vekia Showcase
 * @version 1.0
 */
@Singleton
public class ClassReaderServlet extends RemoteServiceServlet implements CodeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClassReaderServlet.class);
    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public String getCode(String className) {
        // LOGGER.info("get Code :::::::::::: " + className);
        // LOGGER.info("url ROOT/ " + new
        // File(".").getAbsolutePath());

        LOGGER.info("GET: " + className);
        try {

            String file = className.replaceAll("\\.", "/") + ".java";
            String completeUrl = "/showcase/sources/" + file;
            InputStream inputStream = getServletContext().getResourceAsStream(completeUrl);
            // LOGGER.info("url Ressource: " + completeUrl);
            return read(inputStream).toString();
        } catch (MalformedURLException e) {
            LOGGER.error(className + "; message except: ", e);
        } catch (IOException e) {
            LOGGER.error(className + "; message except: ", e);
        }
        return "Code not available yet";
    }

    /** Read the contents of the given file. */
    private StringBuilder read(InputStream input) throws IOException {
        StringBuilder text = new StringBuilder();
        String lineSeparator = System.getProperty("line.separator");
        Scanner scanner = new Scanner(input, "UTF-8");
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
            String file = className.replaceAll("\\.", "/") + ".html";
            String completeUrl = "showcase/sources/" + file;
            // LOGGER.info(completeUrl);
            return new CodeUrl(completeUrl, className);
        } catch (Exception e) {
            return null;
        }
    }
}
