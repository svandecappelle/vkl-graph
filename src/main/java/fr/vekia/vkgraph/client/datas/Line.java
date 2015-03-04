package fr.vekia.vkgraph.client.datas;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 5 sept. 2012. VklGraph version 1.2
 * @version 1.2.4
 * 
 *          A line Canvas object.
 */
abstract class Line extends OptionSerie implements CanvasObject {

    /**
     * SerialId For serialize
     */
    private static final long serialVersionUID = -3857924215441614165L;

    private boolean dashed = false;

    public Line() {
        super();
    }

    public void setDashed(boolean isDashed) {
        this.dashed = isDashed;
    }

    /**
     * @return the dashed
     */
    public boolean isDashed() {
        return dashed;
    }

}