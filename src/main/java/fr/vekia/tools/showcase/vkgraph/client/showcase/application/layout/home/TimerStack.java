package fr.vekia.tools.showcase.vkgraph.client.showcase.application.layout.home;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import com.google.gwt.user.client.Timer;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 23 août 2012. VklGraph version 1.2
 * @version 2.1
 */
public class TimerStack extends Timer {
    private Timer currentTimer;
    private Map<Timer, Integer> timerDuration;
    private LinkedList<Timer> timers;

    /**
     * Default constructor
     * 
     */
    public TimerStack() {
        timerDuration = new HashMap<Timer, Integer>();
        timers = new LinkedList<Timer>();
    }

    /**
     * @param timer
     * @param durationBetweenNext
     */
    public void addToStack(Timer timer, int durationBetweenNext) {
        timers.add(timer);
        timerDuration.put(timer, durationBetweenNext);
    }

    /**
     * 
     */
    private void callToNextElement() {
        currentTimer = timers.poll();
        if (currentTimer != null) {
            schedule(timerDuration.get(currentTimer));
        }
    }

    @Override
    public void run() {
        if (currentTimer == null && !timers.isEmpty()) {
            callToNextElement();
        } else if (currentTimer != null) {
            currentTimer.run();
            callToNextElement();
        }
    }
}
