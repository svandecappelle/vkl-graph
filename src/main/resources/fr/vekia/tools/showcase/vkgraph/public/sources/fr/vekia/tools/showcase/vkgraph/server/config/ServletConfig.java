package fr.vekia.tools.showcase.vkgraph.server.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;
import com.google.inject.servlet.ServletModule;

import fr.vekia.tools.showcase.vkgraph.client.showcase.application.services.CodeService;
import fr.vekia.tools.showcase.vkgraph.server.ClassReaderServlet;

/**
 * Servlets configuration injection.
 * 
 * @author svandecappelle
 * @since 2.0.0
 */
public class ServletConfig extends GuiceServletContextListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(ServletConfig.class);

    private final class Module extends ServletModule {

        @Override
        protected void configureServlets() {
            try {
                LOGGER.info("Configuring");
                // Binding
                bind(CodeService.class).to(ClassReaderServlet.class);

                // Serve
                serve("/showcase/codingServlet").with(ClassReaderServlet.class);

            } catch (Exception exception) {
                LOGGER.error("Error configuring servlets", exception);
            }
        }
    }

    @Override
    protected Injector getInjector() {
        return Guice.createInjector(new Module());
    }

}
