package fr.vekia.tools.showcase.vkgraph.client.showcase.application.layout.menu.presenter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.TreeItem;
import com.google.gwt.user.client.ui.UIObject;
import com.google.inject.Inject;
import com.google.inject.Singleton;

import fr.vekia.tools.showcase.vkgraph.client.showcase.application.components.events.SelectionCodeEvent;
import fr.vekia.tools.showcase.vkgraph.client.showcase.application.events.SelectionOnMenuRequiredEvent;
import fr.vekia.tools.showcase.vkgraph.client.showcase.application.events.SelectionOnMenuRequiredHandler;
import fr.vekia.tools.showcase.vkgraph.client.showcase.application.injector.ShowcaseInjector;
import fr.vekia.tools.showcase.vkgraph.client.showcase.application.layout.home.MouseDemoWidget;
import fr.vekia.tools.showcase.vkgraph.client.showcase.application.layout.menu.AbstractShowcaseTreeMenuItem;
import fr.vekia.tools.showcase.vkgraph.client.showcase.application.layout.menu.groups.complex.ComplexeTree;
import fr.vekia.tools.showcase.vkgraph.client.showcase.application.layout.menu.groups.interactive.InteractiveChart;
import fr.vekia.tools.showcase.vkgraph.client.showcase.application.layout.menu.groups.pie.PieTree;
import fr.vekia.tools.showcase.vkgraph.client.showcase.application.layout.menu.groups.plots.GeneralPlotTree;
import fr.vekia.tools.showcase.vkgraph.client.showcase.application.layout.menu.interfaces.ShowcaseMenuDisplay;
import net.customware.gwt.presenter.client.EventBus;
import net.customware.gwt.presenter.client.widget.WidgetPresenter;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 23 avr. 2012. GWTQuery Vekia Showcase
 * @version 1.0
 */
@Singleton
public class ShowcaseMenuPresenter extends WidgetPresenter<ShowcaseMenuDisplay> {

    private static final int HEADER_SIZE = 30;
    
    private Map<String, Integer> categories;
    private Map<String, AbstractShowcaseTreeMenuItem> plotsScreens;
    private HashMap<String, ArrayList<String>> plotByCategories;

    /**
     * @return the categories
     */
    public Map<String, Integer> getCategories() {
        return categories;
    }

    /**
     * @return the plotsScreens
     */
    public Map<String, AbstractShowcaseTreeMenuItem> getPlotsScreens() {
        return plotsScreens;
    }

    /**
     * Default constructor
     * 
     * @param display
     * @param eventBus
     */
    @Inject
    public ShowcaseMenuPresenter(ShowcaseMenuDisplay display, EventBus eventBus) {
        super(display, eventBus);

        categories = new HashMap<String, Integer>();
        plotsScreens = new HashMap<String, AbstractShowcaseTreeMenuItem>();
        plotByCategories = new HashMap<String, ArrayList<String>>();

        AbstractShowcaseTreeMenuItem plots = new GeneralPlotTree();

        String plotCategoryId = "Plots";
        String pieCategoryId = "PieChart";
        String interactivestCategoryId = "Interactive Charts";
        String complexCategoryId = "Complex Charts";

        categories.put(plotCategoryId, display.addElementWithHeader(plots, SafeHtmlUtils.fromString(plotCategoryId), HEADER_SIZE));
        display.getSelectionHandler(plotCategoryId).addSelectionHandler(new SelectionHandler<TreeItem>() {

            @Override
            public void onSelection(SelectionEvent<TreeItem> event) {
                AbstractShowcaseTreeMenuItem item = (AbstractShowcaseTreeMenuItem) event.getSelectedItem();
                if (item.hasScreen()) {
                    ShowcaseMenuPresenter.this.eventBus.fireEvent(event);
                }
            }
        });

        AbstractShowcaseTreeMenuItem pieCharts = new PieTree();
        categories.put(pieCategoryId, display.addElementWithHeader(pieCharts, SafeHtmlUtils.fromString(pieCategoryId), HEADER_SIZE));
        display.getSelectionHandler(pieCategoryId).addSelectionHandler(new SelectionHandler<TreeItem>() {

            @Override
            public void onSelection(SelectionEvent<TreeItem> event) {
                AbstractShowcaseTreeMenuItem item = (AbstractShowcaseTreeMenuItem) event.getSelectedItem();
                if (item.hasScreen()) {
                    ShowcaseMenuPresenter.this.eventBus.fireEvent(event);
                }
            }
        });

        AbstractShowcaseTreeMenuItem interactiveCharts = new InteractiveChart();
        categories.put(interactivestCategoryId, display.addElementWithHeader(interactiveCharts, SafeHtmlUtils.fromString(interactivestCategoryId), HEADER_SIZE));
        display.getSelectionHandler(interactivestCategoryId).addSelectionHandler(new SelectionHandler<TreeItem>() {

            @Override
            public void onSelection(SelectionEvent<TreeItem> event) {
                AbstractShowcaseTreeMenuItem item = (AbstractShowcaseTreeMenuItem) event.getSelectedItem();
                if (item.hasScreen()) {
                    ShowcaseMenuPresenter.this.eventBus.fireEvent(event);
                }
            }
        });

        AbstractShowcaseTreeMenuItem complexCharts = new ComplexeTree();
        categories.put(complexCategoryId, display.addElementWithHeader(complexCharts, SafeHtmlUtils.fromString(complexCategoryId), HEADER_SIZE));
        display.getSelectionHandler(complexCategoryId).addSelectionHandler(new SelectionHandler<TreeItem>() {

            @Override
            public void onSelection(SelectionEvent<TreeItem> event) {
                AbstractShowcaseTreeMenuItem item = (AbstractShowcaseTreeMenuItem) event.getSelectedItem();
                if (item.hasScreen()) {
                    ShowcaseMenuPresenter.this.eventBus.fireEvent(event);
                }
            }
        });
        putChildrens(plots, plotCategoryId);
        putChildrens(pieCharts, pieCategoryId);
        putChildrens(interactiveCharts, interactivestCategoryId);
        putChildrens(complexCharts, complexCategoryId);
    }

    /**
     * @param plots
     */
    private void putChildrens(AbstractShowcaseTreeMenuItem plotItem, String category) {
        for (AbstractShowcaseTreeMenuItem treeItem : plotItem.getChildrenItems()) {
            plotsScreens.put(treeItem.getText(), treeItem);
            if (!plotByCategories.containsKey(category)) {
                plotByCategories.put(category, new ArrayList<String>());
            }
            plotByCategories.get(category).add(treeItem.getText());

            if (treeItem.hasChildren()) {
                putChildrens(treeItem, category);
            }
        }
    }

    @Override
    protected void onBind() {
        eventBus.addHandler(SelectionOnMenuRequiredEvent.getType(), new SelectionOnMenuRequiredHandler() {

            @Override
            public void onSelection(SelectionOnMenuRequiredEvent event) {
                selectCategoryAnimation(event);
            }
        });
    }

    private void selectCategoryAnimation(final SelectionOnMenuRequiredEvent event) {
        Timer mouseCategorySelection = new Timer() {

            @Override
            public void run() {
                ((ShowcaseMenuDisplay) display).showWidget(categories.get(event.getMenuToShow()));
                ((ShowcaseMenuDisplay) display).addHeaderStyleName("AutomatedDemo-Focus", categories.get(event.getMenuToShow()));
                if (event.getPlotToShow() != null) {
                    selectOnTreeAnimation(event);
                }
            }
        };
        UIObject headerWidget = ((ShowcaseMenuDisplay) display).getHeaderWidget(categories.get(event.getMenuToShow()));
        MouseDemoWidget mouse = MouseDemoWidget.getInstance();
        mouse.scrollTo(headerWidget, 1000);
        mouseCategorySelection.schedule(1300);
    }

    public void selectCategory(String categName) {
        ((ShowcaseMenuDisplay) display).showWidget(categories.get(categName));
        ((ShowcaseMenuDisplay) display).addHeaderStyleName("AutomatedDemo-Focus", categories.get(categName));

    }

    public void selectItemOnShowingCategory(String itemName) {
        ((ShowcaseMenuDisplay) display).selectTreeItem(itemName, plotsScreens.get(itemName));
        ShowcaseInjector.Util.getInstance().getConsoleCodePresenter().showConsole();
        // ((Display) display).addItemStyleName(event.getMenuToShow(), itemName,
        // "AutomatedDemo-Focus");
    }

    private void selectOnTreeAnimation(final SelectionOnMenuRequiredEvent event) {
        final MouseDemoWidget mouse = MouseDemoWidget.getInstance();
        final Timer hideSelectionTree = new Timer() {

            @Override
            public void run() {
                ((ShowcaseMenuDisplay) display).removeItemStyleName(event.getMenuToShow(), event.getPlotToShow(), "AutomatedDemo-Focus");
            }
        };

        final Timer selectionTree = new Timer() {

            @Override
            public void run() {
                ((ShowcaseMenuDisplay) display).selectTreeItem(event.getMenuToShow(), plotsScreens.get(event.getPlotToShow()));
                ShowcaseInjector.Util.getInstance().getConsoleCodePresenter().showConsole();
                ((ShowcaseMenuDisplay) display).removeHeaderStyleName("AutomatedDemo-Focus", categories.get(event.getMenuToShow()));
                ((ShowcaseMenuDisplay) display).addItemStyleName(event.getMenuToShow(), event.getPlotToShow(), "AutomatedDemo-Focus");
                hideSelectionTree.schedule(3500);
            }
        };

        Timer selectiontreeMouse = new Timer() {

            @Override
            public void run() {
                UIObject treeItem = ((ShowcaseMenuDisplay) display).getTreeItem(event.getMenuToShow(), event.getPlotToShow());
                mouse.scrollTo(treeItem, 1000);
                selectionTree.schedule(1300);
            }
        };
        selectiontreeMouse.schedule(500);
    }

    @Override
    protected void onUnbind() {
    }

    @Override
    protected void onRevealDisplay() {
    }

    public void select(final AbstractShowcaseTreeMenuItem item) {
        Scheduler.get().scheduleDeferred(new ScheduledCommand() {

            @Override
            public void execute() {
                eventBus.fireEvent(new SelectionCodeEvent(item.getScreen()));
                ((ShowcaseMenuDisplay) display).showWidget(categories.get(getCategory(item.getText())));
                ((ShowcaseMenuDisplay) display).selectTreeItem(item.getText(), item);
            }
        });

    }

    protected String getCategory(String text) {

        for (Entry<String, ArrayList<String>> plotCategory : plotByCategories.entrySet()) {
            if (plotCategory.getValue().contains(text)) {
                return plotCategory.getKey();
            }
        }
        return null;
    }
}
