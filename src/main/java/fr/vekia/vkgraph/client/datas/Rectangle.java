package fr.vekia.vkgraph.client.datas;

import fr.vekia.vkgraph.client.options.SubOption;

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

	@Override
	public SubOption getType() {
		return SubOption.rectangle;
	}
}