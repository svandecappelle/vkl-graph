package fr.vekia.tools.showcase.vkgraph.client.showcase.application.events;

import com.google.gwt.event.shared.EventHandler;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 23 août 2012. VklGraph version 1.2
 * @version 2.1
 */
public interface SelectionOnMenuRequiredHandler extends EventHandler {
    /**
     * @param itemTabSelectionEvent
     */
    void onSelection(SelectionOnMenuRequiredEvent event);

}
