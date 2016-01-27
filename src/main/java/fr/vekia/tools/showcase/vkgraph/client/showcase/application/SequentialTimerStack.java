package fr.vekia.tools.showcase.vkgraph.client.showcase.application;

import java.util.LinkedList;

import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.Timer;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 23 août 2012. VklGraph version 1.2
 * @version 2.1
 */
public class SequentialTimerStack extends Timer {

    private LinkedList<SequentialTimer> timers;
    private SequentialTimer current;
    private float totalstackedSize;

    /**
     * Default constructor
     * 
     */
    public SequentialTimerStack() {
        timers = new LinkedList<SequentialTimer>();
    }

    /**
     * @param timer
     * @param durationBetweenNext
     */
    public void addToStack(SequentialTimer timer) {
        timers.add(timer);
        totalstackedSize += 1;
    }

    @Override
    public void run() {
        if (!timers.isEmpty()) {
            this.current = timers.poll();

            this.current.start(new Command() {

                @Override
                public void execute() {
                    SequentialTimerStack.this.run();
                }
            });
        }
    }

    public float getCurrentPercent() {
        if (!timers.isEmpty()) {
            return (1f - ((float) this.timers.size() / totalstackedSize)) * 100f;
        }
        return 0;
    }
}
