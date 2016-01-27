/*
 * File: $URL$
 * $Id$
 * Copyright: Vekia
 *
 * Last change:
 * $Date$
 * $Author$
 */
package fr.vekia.tools.showcase.vkgraph.client.showcase.activities.places;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

/**
 * @author svandecappelle
 * @since Dec 11, 2012. VklGraph version 1.2
 * @version 2.1
 * 
 *          {@inheritDoc}
 */
public class MenuPlace extends Place {
	private String menu;
	private String item;

	/**
	 * Default constructor
	 * 
	 */
	public MenuPlace(String categ, String item) {
		this.menu = categ;
		this.item = item;
	}

	/**
	 * @return the menu
	 */
	public String getMenu() {
		return menu;
	}

	/**
	 * @return the item
	 */
	public String getItem() {
		return item;
	}

	public static class Tokenizer implements PlaceTokenizer<MenuPlace> {
        @Override
        public String getToken(MenuPlace place) {
			return place.getMenu() + "-" + place.getItem();
		}

		@Override
		public MenuPlace getPlace(String token) {
			return new MenuPlace(token.split("-")[0], token.split("-")[1]);
		}
	}

}
