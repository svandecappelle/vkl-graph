/*
 * File: $URL: svn+ssh://chimay/home/svn/VkGraph-showcase/VkGraph-showcase/src/main/java/fr/vekia/gquery/client/showcase/application/ShowcaseMenuPresenter.java $
 * $Id: ShowcaseMenuPresenter.java 42 2012-08-31 13:58:13Z svandecappelle $
 * Licence MIT
 * 
 * Last change:
 * $Date: 2012-08-31 15:58:13 +0200 (ven., 31 août 2012) $
 * $Author: svandecappelle $
 */
package fr.vekia.gquery.client.showcase.application;

import java.util.HashMap;
import java.util.Map;

import net.customware.gwt.presenter.client.EventBus;
import net.customware.gwt.presenter.client.widget.WidgetDisplay;
import net.customware.gwt.presenter.client.widget.WidgetPresenter;

import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.TreeItem;
import com.google.gwt.user.client.ui.UIObject;
import com.google.inject.Inject;
import com.google.inject.Singleton;

import fr.vekia.gquery.client.showcase.application.components.menu.AbstractShowcaseTreeMenuItem;
import fr.vekia.gquery.client.showcase.application.components.menu.ShowcaseMenuTree;
import fr.vekia.gquery.client.showcase.application.components.menu.groups.complex.ComplexeTree;
import fr.vekia.gquery.client.showcase.application.components.menu.groups.interactive.InteractiveChart;
import fr.vekia.gquery.client.showcase.application.components.menu.groups.pie.PieTree;
import fr.vekia.gquery.client.showcase.application.components.menu.groups.plots.GeneralPlotTree;
import fr.vekia.gquery.client.showcase.application.events.SelectionOnMenuRequiredEvent;
import fr.vekia.gquery.client.showcase.application.events.SelectionOnMenuRequiredHandler;
import fr.vekia.gquery.client.showcase.application.injector.ShowcaseInjector;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 23 avr. 2012. GWTQuery Vekia Showcase
 * @version 1.0
 * 
 *          {@inheritDoc}
 */
@Singleton
public class ShowcaseMenuPresenter extends WidgetPresenter<WidgetDisplay> {

    public interface Display extends WidgetDisplay {

	/**
	 * @param widget
	 * @param header
	 * @param headerSize
	 */
	int addElementWithHeader(AbstractShowcaseTreeMenuItem widget, SafeHtml header, int headerSize);

	/**
	 * @param headerText
	 * @return
	 */
	ShowcaseMenuTree getSelectionHandler(String headerText);

	void showWidget(int index);

	void selectTreeItem(String menuTitle, AbstractShowcaseTreeMenuItem item);

	/**
	 * @param string
	 * @param integer
	 */
	void addHeaderStyleName(String string, Integer integer);

	/**
	 * @param string
	 * @param integer
	 */
	void removeHeaderStyleName(String string, Integer integer);

	/**
	 * @param menuTitle
	 * @param itemText
	 * @param style
	 */
	void addItemStyleName(String menuTitle, String itemText, String style);

	UIObject getHeaderWidget(int index);

	UIObject getTreeItem(String menuTitle, String itemText);

	/**
	 * @param menuToShow
	 * @param plotToShow
	 * @param string
	 */
	void removeItemStyleName(String menuToShow, String plotToShow, String string);

    }

    private Map<String, Integer> categories;
    private Map<String, AbstractShowcaseTreeMenuItem> plotsScreens;

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
    public ShowcaseMenuPresenter(Display display, EventBus eventBus) {
	super(display, eventBus);

	categories = new HashMap<String, Integer>();
	plotsScreens = new HashMap<String, AbstractShowcaseTreeMenuItem>();

	AbstractShowcaseTreeMenuItem plots = new GeneralPlotTree();
	
	int headerSize = ThemeFactory.getHeaderSizes();
	
	categories.put("Plots", display.addElementWithHeader(plots, SafeHtmlUtils.fromString("Plots"), headerSize));
	display.getSelectionHandler("Plots").addSelectionHandler(new SelectionHandler<TreeItem>() {

	    @Override
	    public void onSelection(SelectionEvent<TreeItem> event) {
		AbstractShowcaseTreeMenuItem item = (AbstractShowcaseTreeMenuItem) event.getSelectedItem();
		if (item.hasScreen()) {
		    ShowcaseMenuPresenter.this.eventBus.fireEvent(event);
		}
	    }
	});

	AbstractShowcaseTreeMenuItem pieCharts = new PieTree();
	categories.put("PieChart", display.addElementWithHeader(pieCharts, SafeHtmlUtils.fromString("PieChart"), headerSize));
	display.getSelectionHandler("PieChart").addSelectionHandler(new SelectionHandler<TreeItem>() {

	    @Override
	    public void onSelection(SelectionEvent<TreeItem> event) {
		AbstractShowcaseTreeMenuItem item = (AbstractShowcaseTreeMenuItem) event.getSelectedItem();
		if (item.hasScreen()) {
		    ShowcaseMenuPresenter.this.eventBus.fireEvent(event);
		}
	    }
	});

	AbstractShowcaseTreeMenuItem interactiveCharts = new InteractiveChart();
	categories.put("Interactive Charts", display.addElementWithHeader(interactiveCharts, SafeHtmlUtils.fromString("Interactive Charts"), headerSize));
	display.getSelectionHandler("Interactive Charts").addSelectionHandler(new SelectionHandler<TreeItem>() {

	    @Override
	    public void onSelection(SelectionEvent<TreeItem> event) {
		AbstractShowcaseTreeMenuItem item = (AbstractShowcaseTreeMenuItem) event.getSelectedItem();
		if (item.hasScreen()) {
		    ShowcaseMenuPresenter.this.eventBus.fireEvent(event);
		}
	    }
	});

	AbstractShowcaseTreeMenuItem complexCharts = new ComplexeTree();
	categories.put("Complex Charts", display.addElementWithHeader(complexCharts, SafeHtmlUtils.fromString("Complex Charts"), headerSize));
	display.getSelectionHandler("Complex Charts").addSelectionHandler(new SelectionHandler<TreeItem>() {

	    @Override
	    public void onSelection(SelectionEvent<TreeItem> event) {
		AbstractShowcaseTreeMenuItem item = (AbstractShowcaseTreeMenuItem) event.getSelectedItem();
		if (item.hasScreen()) {
		    ShowcaseMenuPresenter.this.eventBus.fireEvent(event);
		}
	    }
	});
	putChildrens(plots);
	putChildrens(pieCharts);
	putChildrens(interactiveCharts);
	putChildrens(complexCharts);
    }

    /**
     * @param plots
     */
    private void putChildrens(AbstractShowcaseTreeMenuItem plotItem) {
	for (AbstractShowcaseTreeMenuItem treeItem : plotItem.getChildrenItems()) {
	    plotsScreens.put(treeItem.getText(), treeItem);
	    if (treeItem.hasChildren()) {
		putChildrens(treeItem);
	    }
	}
    }

    @Override
    protected void onBind() {
	eventBus.addHandler(SelectionOnMenuRequiredEvent.getType(), new SelectionOnMenuRequiredHandler() {

	    @Override
	    public void onSelection(SelectionOnMenuRequiredEvent event) {
		Window.alert("menu view");
		selectCategoryAnimation(event);
	    }
	});
    }

    private void selectCategoryAnimation(final SelectionOnMenuRequiredEvent event) {
	Timer mouseCategorySelection = new Timer() {

	    @Override
	    public void run() {
		((Display) display).showWidget(categories.get(event.getMenuToShow()));
		((Display) display).addHeaderStyleName("AutomatedDemo-Focus", categories.get(event.getMenuToShow()));
		if (event.getPlotToShow() != null) {
		    selectOnTreeAnimation(event);
		}
	    }
	};
	UIObject headerWidget = ((Display) display).getHeaderWidget(categories.get(event.getMenuToShow()));
	MouseDemoWidget mouse = MouseDemoWidget.getInstance();
	mouse.scrollTo(headerWidget, 1000);
	mouseCategorySelection.schedule(1300);
    }

    public void selectCategory(String categName) {
	((Display) display).showWidget(categories.get(categName));
	((Display) display).addHeaderStyleName("AutomatedDemo-Focus", categories.get(categName));

    }

    public void selectItemOnShowingCategory(String itemName) {
	((Display) display).selectTreeItem(itemName, plotsScreens.get(itemName));
	ShowcaseInjector.Util.getInstance().getConsoleCodePresenter().showConsole();
	// ((Display) display).addItemStyleName(event.getMenuToShow(), itemName, "AutomatedDemo-Focus");
    }

    private void selectOnTreeAnimation(final SelectionOnMenuRequiredEvent event) {
	final MouseDemoWidget mouse = MouseDemoWidget.getInstance();
	final Timer hideSelectionTree = new Timer() {

	    @Override
	    public void run() {
		((Display) display).removeItemStyleName(event.getMenuToShow(), event.getPlotToShow(), "AutomatedDemo-Focus");
	    }
	};

	final Timer selectionTree = new Timer() {

	    @Override
	    public void run() {
		((Display) display).selectTreeItem(event.getMenuToShow(), plotsScreens.get(event.getPlotToShow()));
		ShowcaseInjector.Util.getInstance().getConsoleCodePresenter().showConsole();
		((Display) display).removeHeaderStyleName("AutomatedDemo-Focus", categories.get(event.getMenuToShow()));
		((Display) display).addItemStyleName(event.getMenuToShow(), event.getPlotToShow(), "AutomatedDemo-Focus");
		hideSelectionTree.schedule(3500);
	    }
	};

	Timer selectiontreeMouse = new Timer() {

	    @Override
	    public void run() {
		UIObject treeItem = ((Display) display).getTreeItem(event.getMenuToShow(), event.getPlotToShow());
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
}
