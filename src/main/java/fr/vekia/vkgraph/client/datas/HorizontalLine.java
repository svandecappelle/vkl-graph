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

    @Override
    public SubOption getType() {
        if (this.isDashed()) {
            return SubOption.dashedHorizontalLine;
        } else {
            return SubOption.horizontalLine;
        }
    }
}
