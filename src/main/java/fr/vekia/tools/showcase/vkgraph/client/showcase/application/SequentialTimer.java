package fr.vekia.tools.showcase.vkgraph.client.showcase.application;

import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.Timer;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 24 août 2012. VklGraph version 1.2
 * @version 2.1
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