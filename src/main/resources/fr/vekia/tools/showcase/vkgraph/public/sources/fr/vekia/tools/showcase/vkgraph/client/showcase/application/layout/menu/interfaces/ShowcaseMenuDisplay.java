package fr.vekia.tools.showcase.vkgraph.client.showcase.application.layout.menu.interfaces;

import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.user.client.ui.UIObject;

import fr.vekia.tools.showcase.vkgraph.client.showcase.application.layout.menu.AbstractShowcaseTreeMenuItem;
import fr.vekia.tools.showcase.vkgraph.client.showcase.application.layout.menu.ShowcaseMenuTree;
import net.customware.gwt.presenter.client.widget.WidgetDisplay;

public interface ShowcaseMenuDisplay extends WidgetDisplay {

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