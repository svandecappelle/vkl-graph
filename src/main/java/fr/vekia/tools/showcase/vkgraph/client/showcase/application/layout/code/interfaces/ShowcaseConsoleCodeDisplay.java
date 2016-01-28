package fr.vekia.tools.showcase.vkgraph.client.showcase.application.layout.code.interfaces;

import com.google.gwt.event.dom.client.HasClickHandlers;

import net.customware.gwt.presenter.client.widget.WidgetDisplay;

/**
 * @author svandecappelle
 *
 */
public interface ShowcaseConsoleCodeDisplay extends WidgetDisplay {

    /**
    * 
    */
    void show();

    /**
    * 
    */
    void hide();

    /**
    * 
    */
    HasClickHandlers getAddShowHandler();

    /**
    * 
    */
    HasClickHandlers getAddHideHandler();

    /**
    * 
    */
    void setCode(String code);

    /**
    * 
    */
    void insert();

    /**
     * @param className
     * @param codeUrl
     */
    void setCodeUrl(String className, String codeUrl);

    /**
    * 
    */
    void showOutBrowser();
}