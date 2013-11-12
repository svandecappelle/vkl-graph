/*
 * File: $URL: svn+ssh://chimay/home/svn/VkGraph-showcase/VkGraph-showcase/src/main/java/fr.vekia.tools.showcase.vkgraph/client/showcase/application/events/StartAutomatedDemoEvent.java $
 * $Id: StartAutomatedDemoEvent.java 38 2012-08-23 16:36:45Z svandecappelle $
 * Licence MIT
 *
 * Last change:
 * $Date: 2012-08-23 18:36:45 +0200 (jeu., 23 août 2012) $
 * $Author: svandecappelle $
 */
package fr.vekia.tools.showcase.vkgraph.client.showcase.application.events;

import com.google.gwt.event.shared.GwtEvent;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 23 août 2012. VklGraph version 1.2
 * @version 2.1
 * 
 *          {@inheritDoc}
 */
public class StartAutomatedDemoEvent extends
		GwtEvent<StartAutomatedDemoHandler> {

	/**
	 * Default constructor
	 * 
	 * @param selectedItem
	 */
	public StartAutomatedDemoEvent() {
	}

	private static Type<StartAutomatedDemoHandler> type;

	public static Type<StartAutomatedDemoHandler> getType() {
		if (type == null) {
			type = new Type<StartAutomatedDemoHandler>();
		}
		return type;
	}

	@Override
	protected void dispatch(StartAutomatedDemoHandler handler) {
		handler.onStart(this);
	}

	@Override
	public GwtEvent.Type<StartAutomatedDemoHandler> getAssociatedType() {
		return getType();
	}
}
