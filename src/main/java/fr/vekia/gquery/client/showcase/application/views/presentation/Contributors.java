/*
 * File: $URL: svn+ssh://chimay/home/svn/VkGraph-showcase/VkGraph-showcase/src/main/java/fr/vekia/gquery/client/showcase/application/views/presentation/Contributors.java $
 * $Id: Contributors.java 42 2012-08-31 13:58:13Z svandecappelle $
 * Licence MIT
 *
 * Last change:
 * $Date: 2012-08-31 15:58:13 +0200 (ven., 31 août 2012) $
 * $Author: svandecappelle $
 */
package fr.vekia.gquery.client.showcase.application.views.presentation;

import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class Contributors extends SimplePanel {

    public Contributors() {

	VerticalPanel contributors = new VerticalPanel();
	contributors.add(new Label("Particular thank to Vekia's company for it's participation, on working out this project. Web site here"));

	setWidget(contributors);
    }
}
