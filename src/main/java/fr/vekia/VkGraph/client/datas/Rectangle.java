/*
 * File: $URL: https://vklgraph.googlecode.com/svn/trunk/src/main/java/fr/vekia/VkGraph/client/datas/VerticalLine.java $
 * $Id: VerticalLine.java 37 2012-09-07 07:35:08Z steeve.vandecappelle@gmail.com $
 * Licence MIT
 *
 * Last change:
 * $Date: 2012-09-07 09:35:08 +0200 (ven., 07 sept. 2012) $
 * $Author: steeve.vandecappelle@gmail.com $
 */
package fr.vekia.VkGraph.client.datas;

import fr.vekia.VkGraph.client.options.SubOption;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 5 sept. 2012. VklGraph version 1.2
 * @version 1.2.4
 * 
 *          {@inheritDoc}
 */
public class Rectangle extends OptionSerie implements CanvasObject {

	/**
	 * SerialId For serialize
	 */
	private static final long serialVersionUID = 5428751539176134212L;

	public Rectangle() {

	}

	public SubOption getType() {
		return SubOption.rectangle;
	}
}