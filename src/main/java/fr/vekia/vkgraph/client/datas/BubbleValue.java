package fr.vekia.vkgraph.client.datas;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 5 déc. 2011. GWTQuery Vekia Showcase
 * @version 1.0
 * 
 *          {@inheritDoc}
 */
public class BubbleValue extends ComplexeValue {

	/**
	 * SerialId For serialize
	 */
	private static final long serialVersionUID = -6116533853962567852L;

	private Number width;

	public BubbleValue() {
		super();
	}

	/**
	 * Default constructor
	 * 
	 * @param label
	 *            the UIwidget label.
	 * @param x
	 *            the Y position on chart.
	 * @param y
	 *            the Y position on chart.
	 * @param width
	 *            the UI widget width.
	 */
	public BubbleValue(Number x, Number y, Number width, String label) {
		super(label, x, y);
		this.width = width;
	}

	/**
	 * Get the UI widget width.
	 * 
	 * @return the UI widget width.
	 */
	public Number getWidth() {
		return width;
	}

	/**
	 * Set the UI widget width.
	 * 
	 * @param width
	 *            the UI widget width.
	 */
	public void setWidth(Number width) {
		this.width = width;
	}

	@Override
	public String toString() {
		return "[" + getX() + "," + getY() + "," + getWidth() + "," + "\"" + getLabel() + "+\"" + "]";
	}
}
