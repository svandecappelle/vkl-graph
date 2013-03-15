/*
 * File: $URL: svn+ssh://chimay/home/svn/VkGraph-showcase/VkGraph-showcase/src/main/java/fr/vekia/gquery/client/showcase/application/views/presentation/Presentation.java $
 * $Id: Presentation.java 42 2012-08-31 13:58:13Z svandecappelle $
 * Licence MIT
 *
 * Last change:
 * $Date: 2012-08-31 15:58:13 +0200 (ven., 31 août 2012) $
 * $Author: svandecappelle $
 */
package fr.vekia.gquery.client.showcase.application.views.presentation;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.VerticalPanel;

import fr.vekia.gquery.client.showcase.application.animations.AnimationEnum;
import fr.vekia.gquery.client.showcase.application.animations.JqueryAnimation;

public class Presentation extends SimplePanel {
    private Button startDemoButton;

    public Presentation() {
	VerticalPanel introduction = new VerticalPanel();
	introduction.setWidth("100%");
	startDemoButton = new Button("Start automated presentation...");
	startDemoButton.getElement().setId("StartDemo-Button");
	introduction.getElement().getStyle().setPaddingRight(30, Unit.PX);
	startDemoButton.setWidth("100%");
	introduction.add(startDemoButton);
	introduction.add(new HTML("<h1>Introduction</h1>"));
	introduction.add(new HTML("<h2>Requirements</h2>"));
	introduction.add(new HTML("<dd>- A Google Web Toolkit project."));
	introduction.add(new HTML("<h2>Presentation</h2>"));
	introduction.add(new HTML("<dd>vklgraph is a GWT-based framework that integrate the JqPlot? JavaScript? Chart UI library."));
	Anchor googleCodeAhref = new Anchor("The google code project here", "http://code.google.com/p/vklgraph/");
	googleCodeAhref.setTarget("_new");
	introduction.add(googleCodeAhref);
	setWidget(introduction);
    }

    public HasClickHandlers getStartAutomatedDemoHandler() {
	return startDemoButton;
    }

    @Override
    protected void onAttach() {
	super.onAttach();
	JqueryAnimation.animate(AnimationEnum.PULSATE, startDemoButton.getElement(), 150, 2000);
    }
}
