/*
 * File: $URL$
 * $Id$
 * Copyright: Vekia
 *
 * Last change:
 * $Date$
 * $Author$
 */
package fr.vekia.gquery.client.theming;

import net.customware.gwt.presenter.client.DefaultEventBus;
import net.customware.gwt.presenter.client.EventBus;

import com.google.gwt.inject.client.AbstractGinModule;

import fr.vekia.gquery.client.theming.presenter.ThemeView;
import fr.vekia.gquery.client.theming.view.ThemeViewImpl;

/**
 * @author svandecappelle
 * @since Dec 14, 2012. VklGraph version 1.2
 * @version 2.1
 * 
 *          {@inheritDoc}
 */
public class ThemeModule extends AbstractGinModule {

    @Override
    protected void configure() {
	bind(ThemeView.class).to(ThemeViewImpl.class);
	bind(EventBus.class).to(DefaultEventBus.class);
    }

}
