/*
 * File: $URL: svn+ssh://chimay/home/svn/VkGraph-showcase/VkGraph-showcase/src/main/java/fr.vekia.tools.showcase.vkgraph/client/showcase/application/Message.java $
 * $Id: Message.java 40 2012-08-30 10:12:40Z svandecappelle $
 * Licence MIT
 *
 * Last change:
 * $Date: 2012-08-30 12:12:40 +0200 (jeu., 30 août 2012) $
 * $Author: svandecappelle $
 */
package fr.vekia.tools.showcase.vkgraph.client.showcase.application;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.VerticalPanel;

import fr.vekia.tools.showcase.vkgraph.client.showcase.application.ui.Dialog;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 24 août 2012. VklGraph version 1.2
 * @version 2.1
 * 
 *          {@inheritDoc}
 */
public class Message extends Dialog {

    private HTML alertMessage;

    /**
     * Default constructor
     * 
     */
    public Message(String textToAlert) {
	this.alertMessage = new HTML(textToAlert);
	setWidget(alertMessage);
	setPopupAnimationStartPosition(50, Unit.PCT, 0, Unit.PX);
    }

    /**
     * Default constructor
     * 
     */
    public Message() {
	this("");
    }

    /**
     * Default constructor
     * 
     */
    public Message(boolean hasCloseButton) {
	this("", hasCloseButton);
    }

    /**
     * Default constructor
     * 
     */
    public Message(String textToAlert, boolean hasCloseButton) {
	this.alertMessage = new HTML(textToAlert);
	if (hasCloseButton) {
	    VerticalPanel panel = new VerticalPanel();

	    panel.add(alertMessage);

	    Button closeButton = new Button("close");
	    closeButton.addClickHandler(new ClickHandler() {

		@Override
		public void onClick(ClickEvent event) {
		    Message.this.hide();
		}
	    });
	    panel.add(closeButton);

	    setWidget(panel);
	} else {
	    setWidget(alertMessage);
	}
	setPopupAnimationStartPosition(50, Unit.PCT, 0, Unit.PX);
    }

    /**
     * 
     */
    public void setMessage(String message) {
	alertMessage.setHTML(message);
    }

    /**
     * Default constructor
     * 
     */
    public Message(IsWidget children) {
	setWidget(children);
	setPopupAnimationStartPosition(50, Unit.PCT, 0, Unit.PX);
    }

}