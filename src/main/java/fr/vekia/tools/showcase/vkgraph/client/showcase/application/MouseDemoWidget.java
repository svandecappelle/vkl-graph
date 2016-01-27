package fr.vekia.tools.showcase.vkgraph.client.showcase.application;

import com.google.gwt.animation.client.Animation;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Style;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.UIObject;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 23 août 2012. VklGraph version 1.2
 * @version 2.1
 */
public final class MouseDemoWidget extends Animation {
    private static MouseDemoWidget instance = null;
    private static final Image img = new Image("img/mouse.png");

    private final Element element;
    private int startX;
    private int startY;
    private int finalX;
    private int finalY;

    /**
     * Default constructor
     * 
     */
    private MouseDemoWidget() {
        element = img.getElement();

    }

    public static MouseDemoWidget getInstance() {
        if (instance == null) {
            instance = new MouseDemoWidget();
        }
        return instance;
    }

    public void scrollTo(int x, int y, int milliseconds) {
        this.finalX = x;
        this.finalY = y;

        startX = element.getOffsetLeft();
        startY = element.getOffsetTop();

        run(milliseconds);
    }

    public void scrollTo(UIObject object, int milliseconds) {
        if (object.isVisible()) {
            scrollTo(object.getAbsoluteLeft() + 10, object.getAbsoluteTop() + 5, milliseconds);
        }
    }

    @Override
    protected void onUpdate(double progress) {
        double positionX = startX + (progress * (this.finalX - startX));
        double positionY = startY + (progress * (this.finalY - startY));

        this.element.getStyle().setLeft(positionX, Style.Unit.PX);
        this.element.getStyle().setTop(positionY, Style.Unit.PX);
    }

    @Override
    protected void onComplete() {
        super.onComplete();
        this.element.getStyle().setLeft(this.finalX, Style.Unit.PX);
        this.element.getStyle().setTop(this.finalY, Style.Unit.PX);
    }

    public void activate() {
        RootLayoutPanel.get().add(img);
    }

    public void desactivate() {
        RootLayoutPanel.get().remove(img);

    }
}
