package fr.vekia.tools.showcase.vkgraph.client.showcase.application;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.RootLayoutPanel;

import fr.vekia.tools.showcase.vkgraph.client.showcase.application.events.SelectionOnMenuRequiredEvent;
import fr.vekia.tools.showcase.vkgraph.client.showcase.application.injector.ShowcaseInjector;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 29 août 2012. VklGraph version 1.2
 * @version 2.1
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
        MouseDemoWidget.getInstance().activate();

        final Element progress = Document.get().getElementById("loading-bar");
        final Element progressTitle = Document.get().getElementById("loading-bar-title");
        final Element progressBar = Document.get().getElementById("loading-bar-bar");

        final SequentialTimerStack timers = new SequentialTimerStack();
        final Message messageOfChart = new Message();
        // messageOfChart.setGlassEnabled(true);

        timers.addToStack(new SequentialTimer(10) {

            @Override
            public void execute() {
                RootLayoutPanel.get().getElement().getStyle().setTop(3, Unit.PX);
                progress.addClassName("visible");
                progressTitle.setInnerHTML(timers.getCurrentPercent() + "%");
                progressBar.getStyle().setWidth(timers.getCurrentPercent(), Unit.PCT);
                ShowcaseInjector.Util.getInstance().getEventBus().fireEvent(new SelectionOnMenuRequiredEvent("Plots", "LineChart plots"));
            }
        });
        timers.addToStack(new SequentialTimer(2800) {

            @Override
            public void execute() {
                progressTitle.setInnerHTML(timers.getCurrentPercent() + "%");
                progressBar.getStyle().setWidth(timers.getCurrentPercent(), Unit.PCT);
                messageOfChart.setMessage("Here a simple line chart view.");
                messageOfChart.show();
            }
        });
        timers.addToStack(new SequentialTimer(4800) {

            @Override
            public void execute() {
                progressTitle.setInnerHTML(timers.getCurrentPercent() + "%");
                progressBar.getStyle().setWidth(timers.getCurrentPercent(), Unit.PCT);
                messageOfChart.close();
            }
        });
        timers.addToStack(new SequentialTimer(11000) {

            @Override
            public void execute() {
                progressTitle.setInnerHTML(timers.getCurrentPercent() + "%");
                progressBar.getStyle().setWidth(timers.getCurrentPercent(), Unit.PCT);
                ShowcaseInjector.Util.getInstance().getEventBus().fireEvent(new SelectionOnMenuRequiredEvent("Plots", "Pyramid plot"));
            }
        });
        timers.addToStack(new SequentialTimer(2800) {

            @Override
            public void execute() {
                progressTitle.setInnerHTML(timers.getCurrentPercent() + "%");
                progressBar.getStyle().setWidth(timers.getCurrentPercent(), Unit.PCT);
                messageOfChart.setMessage("Here a pyramid with mouse over events.");
                messageOfChart.show();
            }
        });
        timers.addToStack(new SequentialTimer(4800) {

            @Override
            public void execute() {
                progressTitle.setInnerHTML(timers.getCurrentPercent() + "%");
                progressBar.getStyle().setWidth(timers.getCurrentPercent(), Unit.PCT);
                messageOfChart.close();
            }
        });
        timers.addToStack(new SequentialTimer(11000) {

            @Override
            public void execute() {
                progressTitle.setInnerHTML(timers.getCurrentPercent() + "%");
                progressBar.getStyle().setWidth(timers.getCurrentPercent(), Unit.PCT);
                ShowcaseInjector.Util.getInstance().getEventBus().fireEvent(new SelectionOnMenuRequiredEvent("PieChart", "Simple pie"));
            }
        });
        timers.addToStack(new SequentialTimer(2800) {

            @Override
            public void execute() {
                progressTitle.setInnerHTML(timers.getCurrentPercent() + "%");
                progressBar.getStyle().setWidth(timers.getCurrentPercent(), Unit.PCT);
                messageOfChart.setMessage("Here a simple pie chart showing the different view of the library can produce.");
                messageOfChart.show();
            }
        });
        timers.addToStack(new SequentialTimer(4800) {

            @Override
            public void execute() {
                progressTitle.setInnerHTML(timers.getCurrentPercent() + "%");
                progressBar.getStyle().setWidth(timers.getCurrentPercent(), Unit.PCT);
                messageOfChart.close();
            }
        });
        timers.addToStack(new SequentialTimer(11000) {

            @Override
            public void execute() {
                progressTitle.setInnerHTML(timers.getCurrentPercent() + "%");
                progressBar.getStyle().setWidth(timers.getCurrentPercent(), Unit.PCT);
                ShowcaseInjector.Util.getInstance().getEventBus().fireEvent(new SelectionOnMenuRequiredEvent("Interactive Charts", "Bubble chart with events and drag Options"));
            }
        });
        timers.addToStack(new SequentialTimer(2800) {

            @Override
            public void execute() {
                progressTitle.setInnerHTML(timers.getCurrentPercent() + "%");
                progressBar.getStyle().setWidth(timers.getCurrentPercent(), Unit.PCT);
                messageOfChart.setMessage("Here a Bubble chart with drag events and resizable chart capacity.");
                messageOfChart.show();
            }
        });
        timers.addToStack(new SequentialTimer(4800) {

            @Override
            public void execute() {
                progressTitle.setInnerHTML(timers.getCurrentPercent() + "%");
                progressBar.getStyle().setWidth(timers.getCurrentPercent(), Unit.PCT);
                messageOfChart.close();
            }
        });
        timers.addToStack(new SequentialTimer(6000) {

            @Override
            public void execute() {
                progressTitle.setInnerHTML(timers.getCurrentPercent() + "%");
                progressBar.getStyle().setWidth(timers.getCurrentPercent(), Unit.PCT);
                ShowcaseInjector.Util.getInstance().getEventBus().fireEvent(new SelectionOnMenuRequiredEvent("Complex Charts", "Zoom Proxy - Control one plot from another"));
            }
        });
        timers.addToStack(new SequentialTimer(2800) {

            @Override
            public void execute() {
                progressTitle.setInnerHTML(timers.getCurrentPercent() + "%");
                progressBar.getStyle().setWidth(timers.getCurrentPercent(), Unit.PCT);
                messageOfChart.setMessage("Here an area whart showing a zoom controlled by a second chart.");
                messageOfChart.show();
            }
        });
        timers.addToStack(new SequentialTimer(4800) {

            @Override
            public void execute() {
                progressTitle.setInnerHTML(timers.getCurrentPercent() + "%");
                progressBar.getStyle().setWidth(timers.getCurrentPercent(), Unit.PCT);
                messageOfChart.close();
            }
        });

        timers.addToStack(new SequentialTimer(6000) {

            @Override
            public void execute() {
                progressTitle.setInnerHTML(timers.getCurrentPercent() + "%");
                progressBar.getStyle().setWidth(timers.getCurrentPercent(), Unit.PCT);
                MouseDemoWidget.getInstance().desactivate();
                messageOfChart.setMessage("Now have fun with this library.");
                messageOfChart.show();
                progress.removeClassName("visible");
                RootLayoutPanel.get().getElement().getStyle().setTop(0, Unit.PX);
            }
        });

        timers.run();
        // ShowcaseInjector.Util.getInstance().getPresenter().getPlaceController().goTo(new
        // MenuPlace("PieChart","Simple pie"));
    }
}
