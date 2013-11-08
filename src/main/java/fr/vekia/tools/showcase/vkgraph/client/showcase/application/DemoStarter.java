/*
 * File: $URL: svn+ssh://chimay/home/svn/VkGraph-showcase/VkGraph-showcase/src/main/java/fr.vekia.tools.showcase.vkgraph/client/showcase/application/DemoStarter.java $
 * $Id: DemoStarter.java 44 2012-09-05 09:32:12Z svandecappelle $
 * Licence MIT
 *
 * Last change:
 * $Date: 2012-09-05 11:32:12 +0200 (mer., 05 sept. 2012) $
 * $Author: svandecappelle $
 */
package fr.vekia.tools.showcase.vkgraph.client.showcase.application;

import com.google.gwt.dom.client.Style.Position;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootLayoutPanel;

import fr.vekia.tools.showcase.vkgraph.client.showcase.application.animations.AnimationEnum;
import fr.vekia.tools.showcase.vkgraph.client.showcase.application.events.SelectionOnMenuRequiredEvent;
import fr.vekia.tools.showcase.vkgraph.client.showcase.application.injector.ShowcaseInjector;
import fr.vekia.tools.showcase.vkgraph.client.showcase.application.ui.JQueryDialog;
import fr.vekia.tools.showcase.vkgraph.client.showcase.application.ui.ProgressBar;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 29 août 2012. VklGraph version 1.2
 * @version 2.1
 * 
 *          {@inheritDoc}
 */
public final class DemoStarter {
    /**
     * Default constructor
     * 
     */
    private DemoStarter() {
    }

    /**
     * 
     */
    public final static void start() {
	Window.alert("menu view");
	
	MouseDemoWidget.getInstance().activate();

	final ProgressBar bar = new ProgressBar();

	bar.getElement().getStyle().setPosition(Position.FIXED);
	RootLayoutPanel.get().add(bar);
	RootLayoutPanel.get().setWidgetBottomHeight(bar, 0, Unit.PX, 16, Unit.PX);
	RootLayoutPanel.get().setWidgetLeftWidth(bar, 0, Unit.PX, 100, Unit.PCT);

	JQueryDialog dialog = new JQueryDialog(true, true);
	dialog.setSize("150px", "40px");
	dialog.setWidget(bar);
	dialog.show();

	SequentialTimerStack timers = new SequentialTimerStack();
	final Message messageOfChart = new Message(true);
	messageOfChart.setGlassEnabled(true);
	messageOfChart.setAnimationHide(AnimationEnum.EXPLODE);
	messageOfChart.setAnimationShow(AnimationEnum.SCROLLCENTER_BOUNCE);

	timers.addToStack(new SequentialTimer(10) {

	    @Override
	    public void execute() {
		ShowcaseInjector.Util.getInstance().getEventBus().fireEvent(new SelectionOnMenuRequiredEvent("Plots", "LineChart plots"));
	    }
	});
	timers.addToStack(new SequentialTimer(2800) {

	    @Override
	    public void execute() {
		messageOfChart.setMessage("Here a simple line chart view.");
		messageOfChart.show();
	    }
	});
	timers.addToStack(new SequentialTimer(4800) {

	    @Override
	    public void execute() {
		messageOfChart.hide();
	    }
	});
	timers.addToStack(new SequentialTimer(11000) {

	    @Override
	    public void execute() {
		ShowcaseInjector.Util.getInstance().getEventBus().fireEvent(new SelectionOnMenuRequiredEvent("Plots", "Pyramid plot"));
	    }
	});
	timers.addToStack(new SequentialTimer(2800) {

	    @Override
	    public void execute() {
		messageOfChart.setMessage("Here a pyramid with mouse over events.");
		messageOfChart.show();
	    }
	});
	timers.addToStack(new SequentialTimer(4800) {

	    @Override
	    public void execute() {
		messageOfChart.hide();
	    }
	});
	timers.addToStack(new SequentialTimer(11000) {

	    @Override
	    public void execute() {
		ShowcaseInjector.Util.getInstance().getEventBus().fireEvent(new SelectionOnMenuRequiredEvent("PieChart", "Simple pie"));
	    }
	});
	timers.addToStack(new SequentialTimer(2800) {

	    @Override
	    public void execute() {
		messageOfChart.setMessage("Here a simple pie chart showing the different view of the library can produce.");
		messageOfChart.show();
	    }
	});
	timers.addToStack(new SequentialTimer(4800) {

	    @Override
	    public void execute() {
		messageOfChart.hide();
	    }
	});
	timers.addToStack(new SequentialTimer(11000) {

	    @Override
	    public void execute() {
		ShowcaseInjector.Util.getInstance().getEventBus()
			.fireEvent(new SelectionOnMenuRequiredEvent("Interactive Charts", "Bubble chart with events and drag Options"));
	    }
	});
	timers.addToStack(new SequentialTimer(2800) {

	    @Override
	    public void execute() {
		messageOfChart.setMessage("Here a Bubble chart with drag events and resizable chart capacity.");
		messageOfChart.show();
	    }
	});
	timers.addToStack(new SequentialTimer(4800) {

	    @Override
	    public void execute() {
		messageOfChart.hide();
	    }
	});
	timers.addToStack(new SequentialTimer(6000) {

	    @Override
	    public void execute() {
		ShowcaseInjector.Util.getInstance().getEventBus()
			.fireEvent(new SelectionOnMenuRequiredEvent("Complex Charts", "Zoom Proxy - Control one plot from another"));
	    }
	});
	timers.addToStack(new SequentialTimer(2800) {

	    @Override
	    public void execute() {
		messageOfChart.setMessage("Here an area whart showing a zoom controlled by a second chart.");
		messageOfChart.show();
	    }
	});
	timers.addToStack(new SequentialTimer(4800) {

	    @Override
	    public void execute() {
		messageOfChart.hide();
	    }
	});

	timers.addToStack(new SequentialTimer(6000) {

	    @Override
	    public void execute() {
		MouseDemoWidget.getInstance().desactivate();
		messageOfChart.setMessage("Now have fun with this library.");
		messageOfChart.show();
		RootLayoutPanel.get().remove(bar);
	    }
	});

	timers.run();
	bar.run(10 + 5 * 2800 + 5 * 4800 + 3 * 11000 + 2 * 6000);
	// ShowcaseInjector.Util.getInstance().getPresenter().getPlaceController().goTo(new MenuPlace("PieChart","Simple pie"));
    }
}
