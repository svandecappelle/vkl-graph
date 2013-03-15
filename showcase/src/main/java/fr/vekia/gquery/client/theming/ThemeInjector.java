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

import net.customware.gwt.presenter.client.EventBus;

import com.google.gwt.core.client.GWT;
import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;

import fr.vekia.gquery.client.theming.presenter.ThemePresenter;

/**
 * @author svandecappelle
 * @since Dec 14, 2012. VklGraph version 1.2
 * @version 2.1
 * 
 *          {@inheritDoc}
 */
@GinModules(ThemeModule.class)
public interface ThemeInjector extends Ginjector {
    final class Util {

	private static ThemeInjector injector = null;

	private Util() {
	}

	/**
	 * @return the injector
	 */
	public static ThemeInjector getInstance() {
	    if (injector == null) {
		injector = GWT.create(ThemeInjector.class);
	    }

	    return injector;
	}
    }

    EventBus getEventBus();

    ThemePresenter getPresenter();
}