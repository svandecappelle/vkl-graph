package fr.vekia.vkgraph.client.charts.events;

/**
 * @author svandecappelle
 * @since Jan 18, 2013. VklGraph version : 2.1
 * @version 2.1
 * 
 *          {@inheritDoc}
 */
public abstract class DragStopEvent extends ChartEvent {
	private static final Integer DEFAULT_BINDING_PARAMS_VALUE = 4;

	/**
	 * @author Steeve Vandecappelle (SVA)
	 * @since 16 août 2012. VklGraph version 1.2
	 * @version 2.1
	 * 
	 *          {@inheritDoc}
	 */
	static final class DragStopEventType implements EventType {

		private static EventType singleton = new DragStopEventType();

		/**
		 * Default constructor.
		 * 
		 */
		private DragStopEventType() {
		}

		@Override
		public String getName() {
			return "jqplotDragStop";
		}

		/**
		 * Return the type of {@link EditedDataEvent} GWT event.
		 * 
		 * @return the GWT event type
		 */
		public static EventType getInstance() {
			return singleton;
		}

	}

	/**
	 * Default constructor
	 *
	 */
	public DragStopEvent() {
		super(true);
	}

	@Override
	public EventType getEventType() {
		return DragStopEventType.getInstance();
	}

	@Override
	public int getEventBindingParams() {
		return DEFAULT_BINDING_PARAMS_VALUE;
	}
}
