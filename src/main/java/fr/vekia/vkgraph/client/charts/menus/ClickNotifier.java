/*
 * File: $URL: https://vklgraph.googlecode.com/svn/trunk/src/main/java/fr/vekia/VkGraph/client/charts/menus/ClickNotifier.java $
 * $Id: ClickNotifier.java 33 2012-08-30 15:42:04Z steeve.vandecappelle@gmail.com $
 * Licence MIT
 *
 * Last change:
 * $Date: 2012-08-30 17:42:04 +0200 (jeu., 30 août 2012) $
 * $Author: steeve.vandecappelle@gmail.com $
 */
package fr.vekia.vkgraph.client.charts.menus;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 16 août 2012. VklGraph version 1.2
 * @version 2.1
 * 
 *          {@inheritDoc} A complex click notifier. See
 *          {@link RightClickListener} for more details.
 */
public interface ClickNotifier {
	/**
	 * Add a click listener to the notifier.
	 * 
	 * @param listener
	 *            the click listener.
	 */
	void addClickListener(RightClickListener listener);

	/**
	 * Remove a click listener to the notifier.
	 * 
	 * @param listener
	 *            the click listener.
	 */
	void removeClickListener(RightClickListener listener);

}
