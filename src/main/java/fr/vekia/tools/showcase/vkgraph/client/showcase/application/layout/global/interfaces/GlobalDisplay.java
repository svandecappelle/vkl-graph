package fr.vekia.tools.showcase.vkgraph.client.showcase.application.layout.global.interfaces;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

import net.customware.gwt.presenter.client.widget.WidgetDisplay;

public interface GlobalDisplay extends WidgetDisplay, AcceptsOneWidget {

        HasClickHandlers getStartAutomatedDemoHandler();

        /**
         * @return
         */
        HasClickHandlers getReturnLbl();

    }