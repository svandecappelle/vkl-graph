package fr.vekia.tools.showcase.vkgraph.client.theming.presenter;

import javax.inject.Singleton;

import net.customware.gwt.presenter.client.EventBus;
import net.customware.gwt.presenter.client.widget.WidgetPresenter;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.inject.Inject;

import fr.vekia.tools.showcase.vkgraph.client.showcase.application.ThemeFactory;
import fr.vekia.tools.showcase.vkgraph.client.showcase.application.ThemeFactory.Theme;

/**
 * @author svandecappelle
 * @since Dec 14, 2012. VklGraph version 1.2
 * @version 2.1
 */
@Singleton
public class ThemePresenter extends WidgetPresenter<ThemeView> {

    /**
     * Default constructor
     * 
     * @param display
     * @param eventBus
     */
    @Inject
    public ThemePresenter(ThemeView display, EventBus eventBus) {
        super(display, eventBus);
    }

    @Override
    protected void onBind() {

        this.display.getChangeThemeHandler().addChangeHandler(new ChangeHandler() {

            @Override
            public void onChange(ChangeEvent event) {
                Theme theme = Theme.valueOf(display.getValue());
                ThemeFactory.setTheme(theme);
            }
        });
    }

    @Override
    protected void onUnbind() {
        // TODO Auto-generated method stub

    }

    @Override
    protected void onRevealDisplay() {
        RootLayoutPanel.get().add(display.asWidget());
        RootLayoutPanel.get().setWidgetBottomHeight(display.asWidget(), 0, Unit.PX, 20, Unit.PX);
        RootLayoutPanel.get().setWidgetRightWidth(display.asWidget(), 0, Unit.PX, 200, Unit.PX);
    }

}
