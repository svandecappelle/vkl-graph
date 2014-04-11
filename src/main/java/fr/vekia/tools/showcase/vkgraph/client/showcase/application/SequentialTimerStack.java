/*
 * File: $URL: svn+ssh://chimay/home/svn/VkGraph-showcase/VkGraph-showcase/src/main/java/fr.vekia.tools.showcase.vkgraph/client/showcase/application/SequentialTimerStack.java $
 * $Id: SequentialTimerStack.java 39 2012-08-24 16:33:44Z svandecappelle $
 * Licence MIT
 *
 * Last change:
 * $Date: 2012-08-24 18:33:44 +0200 (ven., 24 août 2012) $
 * $Author: svandecappelle $
 */
package fr.vekia.tools.showcase.vkgraph.client.showcase.application;

import java.util.LinkedList;

import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.Timer;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 23 août 2012. VklGraph version 1.2
 * @version 2.1
 * 
 *          {@inheritDoc}
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
