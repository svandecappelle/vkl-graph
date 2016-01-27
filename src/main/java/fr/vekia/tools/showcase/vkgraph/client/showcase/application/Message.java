package fr.vekia.tools.showcase.vkgraph.client.showcase.application;

import com.google.gwt.user.client.ui.HTML;

import fr.vekia.tools.showcase.vkgraph.client.showcase.application.ui.JQueryDialog;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 24 août 2012. VklGraph version 1.2
 * @version 2.1
 */
public class Message extends JQueryDialog {

    private HTML alertMessage;

    /**
     * Default constructor.
     */
    public Message() {
        super("System message");
    }

    /**
     * Constructor initializing a message.
     * 
     * @param message
     *            message of alert box.
     */
    public Message(String message) {
        this();
        this.setMessage(message);
    }

    /**
     * Edit the message.
     * 
     * @param message
     *            message of alert box.
     */
    public void setMessage(String message) {
        this.alertMessage = new HTML(message);
        setContent(alertMessage);
    }

}