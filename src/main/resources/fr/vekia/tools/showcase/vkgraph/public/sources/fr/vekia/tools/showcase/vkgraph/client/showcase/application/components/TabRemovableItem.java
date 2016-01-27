package fr.vekia.tools.showcase.vkgraph.client.showcase.application.components;

import com.google.gwt.event.dom.client.ContextMenuEvent;
import com.google.gwt.event.dom.client.ContextMenuHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.MenuItem;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.Widget;

import fr.vekia.tools.showcase.vkgraph.client.showcase.application.components.events.HasItemTabSelectionHandlers;
import fr.vekia.tools.showcase.vkgraph.client.showcase.application.components.events.ItemTabSelectionEvent;
import fr.vekia.tools.showcase.vkgraph.client.showcase.application.components.events.ItemTabSelectionHandler;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 25 avr. 2012. GWTQuery Vekia Showcase
 * @version 1.0
 */
public class TabRemovableItem implements IsWidget, HasItemTabSelectionHandlers {

    private Label label;
    private MenuTabRightClick menu;

    private class MenuTabRightClick extends PopupPanel {

        private MenuBar bar;

        /**
         * Default constructor
         * 
         */
        public MenuTabRightClick() {
            super(true, false);
            bar = new MenuBar(true);
            this.add(bar);
            this.bar.addItem(new MenuItem("Remove", new Command() {

                @Override
                public void execute() {
                    label.fireEvent(new ItemTabSelectionEvent(ItemActionSelection.DELETE));
                    hide();
                }
            }));
            this.bar.addItem(new MenuItem("Remove other items", new Command() {

                @Override
                public void execute() {
                    label.fireEvent(new ItemTabSelectionEvent(ItemActionSelection.DELETE_OTHERS));
                    hide();
                }
            }));
            this.bar.addItem(new MenuItem("Remove items on the right", new Command() {

                @Override
                public void execute() {
                    label.fireEvent(new ItemTabSelectionEvent(ItemActionSelection.DELETE_ONRIGHT));
                    hide();
                }
            }));
            this.setAnimationEnabled(true);
        }
    }

    /**
     * Default constructor
     * 
     * @param indexTab
     * 
     */
    public TabRemovableItem(String itemText) {
        label = new Label(itemText);
        menu = new MenuTabRightClick();
        label.addDomHandler(new ContextMenuHandler() {

            @Override
            public void onContextMenu(ContextMenuEvent event) {
                event.preventDefault();

                menu.showRelativeTo(label);
            }
        }, ContextMenuEvent.getType());
    }

    @Override
    public Widget asWidget() {
        return label;
    }

    @Override
    public void fireEvent(GwtEvent<?> event) {
        this.label.fireEvent(event);
    }

    @Override
    public HandlerRegistration addSelectionHandler(ItemTabSelectionHandler handler) {
        return label.addHandler(handler, ItemTabSelectionEvent.getType());
    }
}
