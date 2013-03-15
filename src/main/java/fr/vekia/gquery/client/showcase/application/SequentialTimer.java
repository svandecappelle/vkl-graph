/*
 * File: $URL: svn+ssh://chimay/home/svn/VkGraph-showcase/VkGraph-showcase/src/main/java/fr/vekia/gquery/client/showcase/application/SequentialTimer.java $
 * $Id: SequentialTimer.java 39 2012-08-24 16:33:44Z svandecappelle $
 * Licence MIT
 *
 * Last change:
 * $Date: 2012-08-24 18:33:44 +0200 (ven., 24 août 2012) $
 * $Author: svandecappelle $
 */
package fr.vekia.gquery.client.showcase.application;

import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.Timer;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 24 août 2012. VklGraph version 1.2
 * @version 2.1
 * 
 *          {@inheritDoc}
 */
public abstract class SequentialTimer extends Timer implements Command {
    private int miliseconds;
    private Command command;

    /**
     * Default constructor
     * 
     */
    public SequentialTimer(int miliseconds) {
	this.miliseconds = miliseconds;
    }

    @Override
    public void run() {
	this.execute();
	command.execute();
    }

    /**
	 * 
	 */
    public void start(Command command) {
	this.command = command;
	schedule(this.getMiliseconds());
    }

    /**
     * @return the miliseconds
     */
    public int getMiliseconds() {
	return miliseconds;
    }
}