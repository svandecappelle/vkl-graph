package fr.vekia.tools.showcase.vkgraph.client.showcase.application.layout.home.display;

import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.resources.client.ImageResource.ImageOptions;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;

import fr.vekia.tools.showcase.vkgraph.client.showcase.application.widgets.Slideshow;
import fr.vekia.tools.showcase.vkgraph.client.showcase.demonstration.items.interactives.PyramidChartInteractiveWidget;
import fr.vekia.tools.showcase.vkgraph.client.showcase.demonstration.screens.interactives.AreaChartInteractiveWidgetScreen;
import fr.vekia.tools.showcase.vkgraph.client.showcase.demonstration.screens.simple.SimplePlotScreen;

/**
 * Image slider demo for home page.
 * 
 * @author svandecappelle
 * @version 5.0.0
 */
@Singleton
public class HomeDemoSlider extends SimplePanel {

    interface ImgRessource extends ClientBundle {
        @ImageOptions(width = 1000, height = 650)
        ImageResource screenshotOne();

        @ImageOptions(width = 1000, height = 650)
        ImageResource screenshotTwo();

        final static class Util {
            private static ImgRessource instance;

            /**
             * Default constructor
             * 
             */
            private Util() {
            }

            static final ImgRessource getInstance() {
                if (instance == null) {
                    instance = GWT.create(ImgRessource.class);
                }
                return instance;
            }
        }
    }

    @Inject
    public HomeDemoSlider(Provider<CodingGetShowcaseSlideshowCommand> commandSlideshowProvider) {
        final Slideshow slideshow = new Slideshow(Window.getClientWidth() / 2, Window.getClientHeight() / 2);
        Image screenshotOne = new Image(ImgRessource.Util.getInstance().screenshotOne());
        Image screenshotTwo = new Image(ImgRessource.Util.getInstance().screenshotTwo());

        slideshow.add(screenshotOne);
        slideshow.add(screenshotTwo);

        setWidget(slideshow);

        CallbackEventController<ConsoleSlideshowCallBack, IsWidget> callBackEventController = new CallbackEventController<ConsoleSlideshowCallBack, IsWidget>() {

            @Override
            public void onSuccess(List<IsWidget> result) {
                for (IsWidget isWidget : result) {
                    slideshow.add((Widget) isWidget);
                }
            }

            @Override
            public void onFailure(Throwable caught) {
                GWT.log("not able to retreive code due to: ", caught);
            }
        };

        final ConsoleSlideshowCallBack generalPlot = new ConsoleSlideshowCallBack(callBackEventController);
        final ConsoleSlideshowCallBack areaPlot = new ConsoleSlideshowCallBack(callBackEventController);
        final ConsoleSlideshowCallBack pyramidPlot = new ConsoleSlideshowCallBack(callBackEventController);

        callBackEventController.addTraitment(commandSlideshowProvider.get().configure(generalPlot, SimplePlotScreen.class));
        callBackEventController.addTraitment(commandSlideshowProvider.get().configure(areaPlot, AreaChartInteractiveWidgetScreen.class));
        callBackEventController.addTraitment(commandSlideshowProvider.get().configure(pyramidPlot, PyramidChartInteractiveWidget.class));

        callBackEventController.execute();
    }
}
