package fr.vekia.vkgraph.client.charts.events;

/**
 * @author svandecappelle
 * @since Jan 22, 2013. VklGraph version : 2.1
 * @version 2.1
 * 
 *          {@inheritDoc}
 */
public class NativeEventObject extends EventObject {

    private int x;
    private int y;

    /**
     * Default constructor
     * 
     */
    public NativeEventObject() {
        super(true);
    }

    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @param x
     *            the x to set
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * @param y
     *            the y to set
     */
    public void setY(int y) {
        this.y = y;
    }

}
