package fr.vekia.vkgraph.client.charts.menus;

import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 16 août 2012. VklGraph version 1.2
 * @version 2.1
 * 
 *          {@inheritDoc} A right click event listener/handler.
 */
public interface RightClickListener {

	/**
	 * Called method when right click event fired from the widget to the
	 * listener.
	 * 
	 * @param sender
	 * @param event
	 */
	void onRightClick(Widget sender, NativeEvent event);

}
