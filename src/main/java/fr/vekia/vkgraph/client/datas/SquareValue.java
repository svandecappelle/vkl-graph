package fr.vekia.vkgraph.client.datas;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 27 juil. 2012. VklGraph version 1.2
 * @version 2.1
 * 
 *          {@inheritDoc}
 */
public class SquareValue extends ComplexeValue {

    /**
     * SerialId For serialize
     */
    private static final long serialVersionUID = 4028542916668463390L;

    public SquareValue() {
        super();
    }

    /**
     * Default constructor
     * 
     * @param label
     *            the UIwidget label.
     * @param x
     *            the X position on chart.
     * @param y
     *            the Y position on chart.
     */
    public SquareValue(String label, Number x, Number y) {
        super(label, x, y);
    }

    @Override
    public String toString() {
        return "[" + getX() + "," + getY() + "," + "\"" + getLabel() + "\"" + "]";
    }
}
