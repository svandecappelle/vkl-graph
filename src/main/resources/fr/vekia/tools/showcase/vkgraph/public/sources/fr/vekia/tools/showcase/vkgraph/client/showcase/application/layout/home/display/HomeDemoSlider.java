package fr.vekia.tools.showcase.vkgraph.client.showcase.application.layout.home.display;

import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.dom.client.Style.Position;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;

/**
 * Image slider demo for home page.
 * 
 * @author svandecappelle
 * @version 5.0.0
 */
@Singleton
public class HomeDemoSlider extends FlowPanel {

    @Inject
    public HomeDemoSlider(Provider<CodingGetShowcaseSlideshowCommand> commandSlideshowProvider, HomeScreenShots screenshots) {
        getElement().setId("jssor_1");

        this.getElement().getStyle().setWidth(Slides.WIDTH, Unit.PX);
        this.getElement().getStyle().setHeight(Slides.HEIGHT, Unit.PX);

        this.getElement().getStyle().setPosition(Position.RELATIVE);
        this.getElement().getStyle().setLeft(0, Unit.PX);
        this.getElement().getStyle().setTop(0, Unit.PX);

        Image screenshotOne = new Image(screenshots.one());
        Image screenshotTwo = new Image(screenshots.two());

        final Slides slides = new Slides();
        slides.add(new Slide("Image 1", screenshotOne));
        slides.add(new Slide("Image 2", screenshotTwo));

        this.add(new SliderLoader());
        this.add(slides);
        this.add(new BulletNavigator());
        this.add(new ButtonNavigator());

        Scheduler.get().scheduleDeferred(new ScheduledCommand() {

            @Override
            public void execute() {
                launchSlider();
            }
        });

    }

    // @formatter:off
    private native void launchSlider()/*-{
        $wnd.loadSlider();
    }-*/;
    // @formatter:on
}
