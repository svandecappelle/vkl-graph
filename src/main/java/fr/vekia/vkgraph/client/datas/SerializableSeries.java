package fr.vekia.vkgraph.client.datas;

import java.io.Serializable;
import java.util.Map;

import fr.vekia.vkgraph.client.options.SubOption;

/**
 * For allow serialization sending options.
 * 
 * @author svandecappelle
 * @since 3.0.0
 */
public class SerializableSeries extends SerieOptionBean implements Serializable {

    private static final long serialVersionUID = -4001316574748098267L;

    /**
     * Constructor for serialization.
     */
    public SerializableSeries() {
    }

    /**
     * Constructor for instanciation.
     * 
     * @param optionsMapped
     *            subOptions
     * @param subSubOptionsMapped
     *            subsuboptions.
     */
    public SerializableSeries(Map<SubOption, String> optionsMapped, Map<SubOption, Map<SubOption, String>> subSubOptionsMapped) {
        super.setOptionsMapped(optionsMapped);
        super.setSubSubOptionsMapped(subSubOptionsMapped);
    }

}
