package fr.vekia.tools.showcase.vkgraph.client.showcase.application.layout.home.display;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;

public interface HomeScreenShots extends ClientBundle {

    @Source("fr/vekia/tools/showcase/vkgraph/client/home/one.png")
    ImageResource one();

    @Source("fr/vekia/tools/showcase/vkgraph/client/home/two.png")
    ImageResource two();

    final static class Util {
        private static HomeScreenShots instance;

        /**
         * Default constructor
         * 
         */
        private Util() {
        }

        static final HomeScreenShots getInstance() {
            if (instance == null) {
                instance = GWT.create(HomeScreenShots.class);
            }
            return instance;
        }
    }

}
