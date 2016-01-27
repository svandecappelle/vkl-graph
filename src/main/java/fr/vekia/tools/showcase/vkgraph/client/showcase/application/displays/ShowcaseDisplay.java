package fr.vekia.tools.showcase.vkgraph.client.showcase.application.displays;

import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.SplitLayoutPanel;
import com.google.gwt.user.client.ui.Widget;

import fr.vekia.tools.showcase.vkgraph.client.showcase.application.ShowcasePresenter.Display;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 23 avr. 2012. GWTQuery Vekia Showcase
 * @version 1.0
 */
public class ShowcaseDisplay implements Display {
	private SplitLayoutPanel layout;

	/**
	 * Default constructor
	 * 
	 */
	public ShowcaseDisplay() {
		layout = new SplitLayoutPanel(14);
	}

	@Override
	public void addWest(IsWidget widget, int size) {
		layout.addWest(widget, size);
	}

	@Override
	public void addNorth(IsWidget widget, int size) {
		layout.addNorth(widget, size);
	}

	@Override
	public void addCenter(IsWidget widget) {
		layout.add(widget);
	}

	@Override
	public Widget asWidget() {
		return layout;
	}
}
