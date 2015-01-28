/*
 * File: $URL: https://vklgraph.googlecode.com/svn/trunk/src/main/java/fr/vekia/VkGraph/client/charts/menus/RightClickMenuWidget.java $
 * $Id: RightClickMenuWidget.java 35 2012-09-03 16:11:14Z steeve.vandecappelle@gmail.com $
 * Licence MIT
 *
 * Last change:
 * $Date: 2012-09-03 18:11:14 +0200 (lun., 03 sept. 2012) $
 * $Author: steeve.vandecappelle@gmail.com $
 */
package fr.vekia.vkgraph.client.charts.menus;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.MenuItem;
import com.google.gwt.user.client.ui.MenuItemSeparator;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author Steeve Vandecappelle (SVA)
 * 
 *         A simple right click selection context menu
 * 
 */
public class RightClickMenuWidget extends SimplePanel implements RightClickListener {
	private static final int zindex = 9999999;
	private final PopupPanel popupPanel = new PopupPanel(true);
	private MenuBar popupMenuBar = new MenuBar(true);
	private RightClickListener listener;
	private boolean enableOnContextMenuBrowser;
	private Map<MenuCommands, MenuItem> items;

	/**
	 * Default constructor. <br>
	 * <i><b>Note:</b> to use this constructor, you must add this
	 * {@link RightClickMenuWidget} widget to the
	 * {@link com.google.gwt.user.client.DOM} on widget right click request
	 * place. </i>
	 * 
	 * @param widget
	 *            the widget to bind with.
	 * @param listener
	 *            the listener needs to received the right click event.
	 */
	public RightClickMenuWidget() {
		this.items = new HashMap<MenuCommands, MenuItem>();
		this.listener = this;
		popupPanel.setStylePrimaryName("vkl-RightClicSelectionMenu");
		popupPanel.getElement().getStyle().setZIndex(zindex);
		popupMenuBar.setAutoOpen(true);
		sinkEvents(Event.ONCONTEXTMENU);
	}

	/**
	 * Default constructor. <br>
	 * <i><b>Note:</b> to use this constructor, you must add this
	 * {@link RightClickMenuWidget} widget to the
	 * {@link com.google.gwt.user.client.DOM} on widget right click request
	 * place. </i>
	 * 
	 * @param widget
	 *            the widget to bind with.
	 * @param listener
	 *            the listener needs to received the right click event.
	 */
	public RightClickMenuWidget(IsWidget widget, RightClickListener listener) {
		this(widget);
		this.listener = listener;
	}

	/**
	 * Default constructor <i><b>Note:</b> to use this constructor, you must add
	 * this {@link RightClickMenuWidget} widget to the
	 * {@link com.google.gwt.user.client.DOM} on widget right click request
	 * place. </i>
	 * 
	 * @param widget
	 *            the widget to bind with.
	 */
	public RightClickMenuWidget(IsWidget widget) {
		this.listener = this;
		this.items = new HashMap<MenuCommands, MenuItem>();
		popupPanel.setStylePrimaryName("vkl-RightClicSelectionMenu");
		popupMenuBar.setAutoOpen(true);
		setWidget(widget);
		sinkEvents(Event.ONCONTEXTMENU);
	}

	@Override
	public void onBrowserEvent(Event event) {
		if (event.getTypeInt() == Event.ONCONTEXTMENU) {
			listener.onRightClick(this, event);
			if (popupPanel.getWidget() != null || enableOnContextMenuBrowser) {
				event.preventDefault();
			}
		}
	}

	/**
	 * Keep the default browser onContextMenu event behavior or not.
	 * 
	 * @param isEnable
	 *            <code>true</code> to keep the default browser behavior.
	 */
	public void setDefaultBrowserBehaviorEnable(boolean isEnable) {
		this.enableOnContextMenuBrowser = isEnable;
	}

	/**
	 * Set the menu right click widgets.
	 * 
	 * @param commands
	 *            the commands to add on menu.
	 */
	public void setMenu(List<MenuCommands> commands) {
		for (MenuCommands menuCommands : commands) {
			addToMenu(menuCommands, popupMenuBar);
		}
		popupMenuBar.setVisible(true);
		popupPanel.setWidget(popupMenuBar);
	}

	/**
	 * Set the menu right click widgets.
	 * 
	 * @param commands
	 *            the commands to add on menu.
	 */
	public void setMenu(MenuCommands... commands) {
		setMenu(Arrays.asList(commands));
	}

	/**
	 * Add a command to a Menu bar.
	 * 
	 * @param command
	 *            the command to add.
	 * @param menu
	 *            the menu to add into.
	 */
	private void addToMenu(MenuCommands command, MenuBar menu) {
		MenuItem item = new MenuItem(command.getLabel(), true, command);
		items.put(command, item);
		item.addStyleName("popup-item");
		if (command.hasClass()){
			item.addStyleName(command.getClassname());
		}
		menu.addItem(item);
		addSubMenus(command, item);
	}

	/**
	 * Add commands to the menu right click.
	 * 
	 * @param menuCommands
	 *            the commands to add.
	 */
	public void addToMenu(MenuCommands... menuCommands) {
		for (MenuCommands command : menuCommands) {
			addToMenu(command, popupMenuBar);
		}
		if (!popupMenuBar.isAttached()) {
			popupMenuBar.setVisible(true);
			popupPanel.setWidget(popupMenuBar);
		}
	}

	/**
	 * Add sub menus items to a menu.
	 * 
	 * @param item
	 *            the item to add into.
	 * @param command
	 *            the command to add.
	 * 
	 */
	private void addSubMenus(MenuCommands command, MenuItem item) {
		if (command.getSubCommands() != null) {
			MenuBar menu = new MenuBar(true);
			item.setSubMenu(menu);
			addToMenu(command.getSubCommands(), menu);
		}
	}

	/**
	 * Add sub menus items to a menu.
	 * 
	 * @param subCommands
	 *            the commands to add.
	 * @param menu
	 *            the menu to add into.
	 */
	private void addToMenu(MenuCommands[] subCommands, MenuBar menu) {
		for (MenuCommands menuCommand : subCommands) {
			MenuItem item = new MenuItem(menuCommand.getLabel(), true, menuCommand);
			items.put(menuCommand, item);
			item.addStyleName("popup-item");
			menu.addItem(item);
			addSubMenus(menuCommand, item);
		}
	}

	public void removeToMenu(MenuCommands... menuCommands) {
		for (MenuCommands command : menuCommands) {
			removeToMenu(command, popupMenuBar);
		}
	}

	/**
	 * @param command
	 * @param popupMenuBar2
	 */
	private void removeToMenu(MenuCommands command, MenuBar popupMenuBar) {
		if (popupMenuBar.getItemIndex(items.get(command)) != -1) {
			popupMenuBar.removeItem(items.get(command));
		} else {

		}
		items.remove(command);
	}

	/**
	 * Add a menu separator.
	 */
	public void addSeparator() {
		MenuItemSeparator separator = new MenuItemSeparator();
		popupMenuBar.addSeparator(separator);
	}

	@Override
	public final void onRightClick(Widget sender, NativeEvent event) {
		int x = event.getClientX();
		int y = event.getClientY();
		popupPanel.setPopupPosition(x, y);
		if (popupPanel.getWidget() != null) {
			popupPanel.show();
		}
	}

	/**
	 * Hide the pop-up right click menu.
	 */
	public void hideMenu() {
		popupPanel.hide();
	}

	/**
	 * @return
	 */
	public boolean isEmpty() {
		return items.isEmpty();
	}
}
