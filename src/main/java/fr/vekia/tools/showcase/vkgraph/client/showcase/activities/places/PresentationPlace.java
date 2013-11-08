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
 * @since Dec 12, 2012. VklGraph version 1.2
 * @version 2.1
 * 
 *          {@inheritDoc}
 */
public class PresentationPlace extends Place {

    private String token;

    /**
     * Default constructor
     * 
     * @param token
     * 
     */
    public PresentationPlace(String token) {
	this.token = token;
    }

    public static class Tokenizer implements PlaceTokenizer<PresentationPlace> {
	@Override
	public String getToken(PresentationPlace place) {
	    return "Presentation";
	}

	@Override
	public PresentationPlace getPlace(String token) {
	    return new PresentationPlace(token);
	}
    }

}
