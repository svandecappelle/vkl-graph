package fr.vekia.vkgraph.client.datas;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import fr.vekia.vkgraph.client.options.SubOption;

/**
 * Serialized series options.
 * 
 * @author svandecappelle
 * @since 3.0.0
 */
public class SerieOptionBean implements Serializable {

    private static final long serialVersionUID = 5074576087076982613L;
    private Map<SubOption, String> optionsMapped;
    private Map<SubOption, Map<SubOption, String>> subSubOptionsMapped;

    /**
     * Public constructor
     */
    public SerieOptionBean() {
        this.optionsMapped = new HashMap<SubOption, String>();
        this.subSubOptionsMapped = new HashMap<SubOption, Map<SubOption, String>>();
    }

    /**
     * Return the option set on the series Options.
     * 
     * @return the optionsMapped
     */
    public Map<SubOption, String> getOptionsMapped() {
        return optionsMapped;
    }

    /**
     * Return the subOptions set on the series Options.
     * 
     * @return the subOptions
     */
    public Map<SubOption, Map<SubOption, String>> getSubSubOptionsMapped() {
        return subSubOptionsMapped;
    }

    /**
     * Set a serie String option.
     * 
     * @param subOption
     *            the option.
     * @param value
     *            the value of option.
     */
    public void setOption(SubOption subOption, String value) {
        optionsMapped.put(subOption, value);
    }

    /**
     * Set a serie option.
     * 
     * @param subOption
     *            the option.
     * @param subSubOption
     *            the sub Option.
     * @param value
     *            the value of option.
     */
    public void setOption(SubOption subOption, SubOption subSubOption, String value) {
        if (subSubOptionsMapped == null) {
            subSubOptionsMapped = new HashMap<SubOption, Map<SubOption, String>>();
        }

        if (subSubOptionsMapped.containsKey(subOption)) {
            subSubOptionsMapped.get(subOption).put(subSubOption, value);
        } else {
            Map<SubOption, String> subsubOptionMapCreated = new HashMap<SubOption, String>();
            subsubOptionMapCreated.put(subSubOption, value);
            subSubOptionsMapped.put(subOption, subsubOptionMapCreated);
        }
    }

    /**
     * Set option mapped map.
     * 
     * @param optionsMapped
     *            option mapped map.
     */
    public void setOptionsMapped(Map<SubOption, String> optionsMapped) {
        this.optionsMapped = optionsMapped;
    }

    /**
     * Set subsubOption mapped map.
     * 
     * @param subSubOptionsMapped
     *            subsubOption mapped map.
     */
    public void setSubSubOptionsMapped(Map<SubOption, Map<SubOption, String>> subSubOptionsMapped) {
        this.subSubOptionsMapped = subSubOptionsMapped;
    }
}
