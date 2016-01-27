package fr.vekia.tools.showcase.vkgraph.client.showcase.application;

import net.customware.gwt.presenter.client.EventBus;
import net.customware.gwt.presenter.client.widget.WidgetDisplay;
import net.customware.gwt.presenter.client.widget.WidgetPresenter;

import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.inject.Inject;
import com.google.inject.Singleton;

import fr.vekia.tools.showcase.vkgraph.client.showcase.activities.places.MenuPlace;
import fr.vekia.tools.showcase.vkgraph.client.showcase.application.components.events.SelectionCodeEvent;
import fr.vekia.tools.showcase.vkgraph.client.showcase.application.components.menu.AbstractShowcaseTreeMenuItem;
import fr.vekia.tools.showcase.vkgraph.client.showcase.application.events.StartAutomatedDemoEvent;
import fr.vekia.tools.showcase.vkgraph.client.showcase.application.injector.ShowcaseInjector;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 23 avr. 2012. GWTQuery Vekia Showcase
 * @version 1.0
 */
@Singleton
public class ShowcaseGlobalPanelPresenter extends WidgetPresenter<ShowcaseGlobalPanelPresenter.Display> {

    public interface Display extends WidgetDisplay, AcceptsOneWidget {

        HasClickHandlers getStartAutomatedDemoHandler();

        /**
         * @return
         */
        HasClickHandlers getReturnLbl();

    }

    /**
     * Default constructor
     * 
     * @param display
     * @param eventBus
     */
    @Inject
    public ShowcaseGlobalPanelPresenter(Display display, EventBus eventBus) {
        super(display, eventBus);

        display.getReturnLbl().addClickHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {
                History.back();
            }
        });
    }

    @Override
    protected void onBind() {
        registerHandler(display.getStartAutomatedDemoHandler().addClickHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {
                ShowcaseInjector.Util.getInstance().getEventBus().fireEvent(new StartAutomatedDemoEvent());
            }
        }));

        registerHandler(eventBus.addHandler(SelectionEvent.getType(), new SelectionHandler<AbstractShowcaseTreeMenuItem>() {

            @Override
            public void onSelection(final SelectionEvent<AbstractShowcaseTreeMenuItem> event) {
                historyHandle(event.getSelectedItem());
                displayScreen(event.getSelectedItem());
            }

        }));

    }

    private void historyHandle(AbstractShowcaseTreeMenuItem selectedItem) {

        if (selectedItem.hasScreen()) {
            String categ = "";

            String screen = selectedItem.getText();

            while (selectedItem.getParentItem() != null) {
                categ = selectedItem.getParentItem().getText();
                selectedItem = (AbstractShowcaseTreeMenuItem) selectedItem.getParentItem();
            }
            // create the screen and attach to DOM
            ShowcaseInjector.Util.getInstance().getPresenter().getPlaceController().goTo(new MenuPlace(categ, screen));
        }

    }

    private final void displayScreen(final AbstractShowcaseTreeMenuItem abstractShowcaseTreeMenuItem) {
        Scheduler.get().scheduleFinally(new ScheduledCommand() {

            @Override
            public void execute() {

                final IsWidget code = abstractShowcaseTreeMenuItem.getScreen();
                eventBus.fireEvent(new SelectionCodeEvent(code));
            }
        });

    }

    @Override
    protected void onUnbind() {
    }

    @Override
    protected void onRevealDisplay() {
    }
}
