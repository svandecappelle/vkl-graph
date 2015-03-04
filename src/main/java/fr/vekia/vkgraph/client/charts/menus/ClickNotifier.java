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
