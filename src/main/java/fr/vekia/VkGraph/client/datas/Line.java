/*
 * File: $URL: https://vklgraph.googlecode.com/svn/trunk/src/main/java/fr/vekia/VkGraph/client/datas/Line.java $
 * $Id: Line.java 37 2012-09-07 07:35:08Z steeve.vandecappelle@gmail.com $
 * Licence MIT
 *
 * Last change:
 * $Date: 2012-09-07 09:35:08 +0200 (ven., 07 sept. 2012) $
 * $Author: steeve.vandecappelle@gmail.com $
 */
package fr.vekia.VkGraph.client.datas;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 5 sept. 2012. VklGraph version 1.2
 * @version 1.2.4
 * 
 *          A line Canvas object.
 */
abstract class Line extends OptionSerie implements CanvasObject{

    private boolean dashed = false;

    public Line(){
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