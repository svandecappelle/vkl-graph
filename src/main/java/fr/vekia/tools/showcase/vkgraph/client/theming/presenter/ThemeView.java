/*
 * File: $URL$
 * $Id$
 * Copyright: Vekia
 *
 * Last change:
 * $Date$
 * $Author$
 */
package fr.vekia.tools.showcase.vkgraph.client.theming.presenter;

import com.google.gwt.event.dom.client.HasChangeHandlers;

import net.customware.gwt.presenter.client.widget.WidgetDisplay;

/**
 * @author svandecappelle
 * @since Dec 14, 2012. VklGraph version 1.2
 * @version 2.1
 * 
 *          {@inheritDoc}
 */
public interface ThemeView extends WidgetDisplay {

    HasChangeHandlers getChangeThemeHandler();

    String getValue();
}
