package fr.vekia.tools.showcase.vkgraph.client.theming.view;

import com.google.gwt.event.dom.client.HasChangeHandlers;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;

import fr.vekia.tools.showcase.vkgraph.client.showcase.application.ThemeFactory.Theme;
import fr.vekia.tools.showcase.vkgraph.client.theming.presenter.ThemeView;

/**
 * @author svandecappelle
 * @since Dec 14, 2012. VklGraph version 1.2
 * @version 2.1
 */
public class ThemeViewImpl extends Composite implements ThemeView {

    private ListBox b;

    /**
     * Default constructor
     * 
     */
    public ThemeViewImpl() {
        HorizontalPanel panel = new HorizontalPanel();
        b = new ListBox();
        b.addItem("Dark", Theme.DARK.name());
        b.addItem("Clear", Theme.CLEAR.name());
        b.addItem("Professionnal", Theme.PRO.name());

        panel.add(new Label("Theme"));
        panel.add(b);

        initWidget(panel);
        panel.getElement().getStyle().setZIndex(1);
    }

    @Override
    public HasChangeHandlers getChangeThemeHandler() {
        return b;
    }

    @Override
    public String getValue() {
        return b.getValue(b.getSelectedIndex());
    }

}
