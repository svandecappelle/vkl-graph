/*
 * File: $URL: svn+ssh://chimay/home/svn/VkGraph-showcase/VkGraph-showcase/src/main/java/fr.vekia.tools.showcase.vkgraph/client/showcase/application/ui/Slideshow.java $
 * $Id: Slideshow.java 52 2012-09-26 15:26:35Z svandecappelle $
 * Licence MIT
 *
 * Last change:
 * $Date: 2012-09-26 17:26:35 +0200 (mer., 26 sept. 2012) $
 * $Author: svandecappelle $
 */
package fr.vekia.tools.showcase.vkgraph.client.showcase.application.ui;

import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 29 août 2012. VklGraph version 1.2
 * @version 2.1
 * 
 *          {@inheritDoc}
 */
public class Slideshow extends Composite {
	private FlowPanel sliderContainersWidgets;
	private FlowPanel sliderButtons;
	private int width = 800;
	private int height = 600;

	/**
	 * Default constructor
	 * 
	 */
	public Slideshow(int width, int height) {
		this();
		this.width = width;
		this.height = height;
		setSize(width + "px", height + "px");
	}

	/**
	 * Default constructor
	 * 
	 */
	public Slideshow() {

		FlowPanel sliderAll = new FlowPanel();
		FlowPanel sliderContentWrap = new FlowPanel();
		sliderContainersWidgets = new FlowPanel();
		sliderButtons = new FlowPanel();

		sliderAll.getElement().setId("sliderMain");

		sliderAll.addStyleName("bottomShadow");
		sliderContentWrap.addStyleName("sliderContentWrap");
		sliderContainersWidgets.addStyleName("contentWrap");
		sliderButtons.addStyleName("buttonsWrap");

		sliderContentWrap.add(sliderContainersWidgets);
		sliderAll.add(sliderContentWrap);
		sliderAll.add(sliderButtons);

		final Image anchor = new Image("img/pause.png");
		anchor.setSize("16px", "16px");
		anchor.getElement().getStyle().setPadding(0, Unit.PX);
		anchor.getElement().getStyle().setMargin(0, Unit.PX);
		anchor.getElement().getStyle().setMarginTop(5, Unit.PX);
		anchor.getElement().getStyle().setBackgroundColor("transparent");
		anchor.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				if (anchor.getUrl().contains("play")) {
					anchor.setUrl("img/pause.png");
				} else {
					anchor.setUrl("img/play.png");
				}
			}
		});

		anchor.addStyleName("control");
		sliderButtons.add(anchor);

		initWidget(sliderAll);
		sliderContentWrap.setSize("100%", "100%");
		setSize(width + "px", height + "px");
	}

	public void setSizeContainerPx(int width, int height) {
		this.width = width;
		this.height = height;
	}

	public void add(Widget widget) {
		widget.addStyleName("content");
		sliderContainersWidgets.add(widget);
		Anchor anchor = new Anchor();
		anchor.addStyleName("buttons");
		sliderButtons.add(anchor);
	}

	@Override
	protected void onAttach() {
		super.onAttach();
		Scheduler.get().scheduleDeferred(new ScheduledCommand() {

			@Override
			public void execute() {
				render(width, height);
			}
		});
	}

	public void redraw() {
		render(width, height);
	}

	private native void render(int width, int height)/*-{
														$wnd.jQuery('.contentWrap').liteSlider({
														content : '.content', // The panel selector. Can be a list also. eg:li
														autoplay : true, // Autoplay the slider. Values, true & false
														width : width,
														height : height,
														delay : 5, // Transition Delay. Default 3s
														buttonsClass : 'buttons', // Button's class
														activeClass : 'active', // Active class
														controlBt : '.control', // Control button selector
														playText : 'Play', // Play text
														pauseText : 'Stop' // Stop text
														});
														}-*/;
}
