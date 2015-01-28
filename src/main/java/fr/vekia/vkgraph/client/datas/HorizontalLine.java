/*
 * File: $URL: https://vklgraph.googlecode.com/svn/trunk/src/main/java/fr/vekia/VkGraph/client/datas/HorizontalLine.java $
 * $Id: HorizontalLine.java 37 2012-09-07 07:35:08Z steeve.vandecappelle@gmail.com $
 * Licence MIT
 *
 * Last change:
 * $Date: 2012-09-07 09:35:08 +0200 (ven., 07 sept. 2012) $
 * $Author: steeve.vandecappelle@gmail.com $
 */
package fr.vekia.vkgraph.client.datas;

import fr.vekia.vkgraph.client.options.SubOption;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 5 sept. 2012. VklGraph version 1.2
 * @version 1.2.4
 * 
 *          {@inheritDoc}
 */
public class HorizontalLine extends Line {

	/**
	 * SerialId For serialize
	 */
	private static final long serialVersionUID = -2486515651251973303L;

	public HorizontalLine() {

	}

	public SubOption getType() {
		if (this.isDashed()) {
			return SubOption.dashedHorizontalLine;
		} else {
			return SubOption.horizontalLine;
		}
	}
}
