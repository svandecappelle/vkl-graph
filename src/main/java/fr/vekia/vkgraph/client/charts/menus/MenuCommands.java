package fr.vekia.vkgraph.client.charts.menus;

import com.google.gwt.user.client.Command;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 16 nov. 2011. VklGraph version 1.2
 * @version 2.1
 * 
 *          {@inheritDoc} A GWT based Menu selection bean.
 */
public abstract class MenuCommands implements Command {
    private String label;
    private MenuCommands[] subCommands;
    private String className;

    /**
     * Default constructor.
     * 
     * @param label
     *            the menu label.
     */
    public MenuCommands(String label) {
        this.label = label;
    }

    /**
     * Default constructor.
     * 
     * @param label
     *            the menu label.
     */
    public MenuCommands(String label, String className) {
        this.label = label;
        this.className = className;
    }

    /**
     * Default constructor.
     * 
     * @param libelle
     *            the menu label
     * @param subCommands
     *            the list of commands under this menu. If Any.
     */
    public MenuCommands(String libelle, MenuCommands... subCommands) {
        this.label = libelle;
        this.subCommands = subCommands;
    }

    /**
     * Default constructor.
     * 
     * @param libelle
     *            the menu label
     * @param subCommands
     *            the list of commands under this menu. If Any.
     */
    public MenuCommands(String libelle, String className, MenuCommands... subCommands) {
        this.label = libelle;
        this.subCommands = subCommands;
        this.className = className;
    }

    /**
     * Get the item menu label.
     * 
     * @return the item menu label.
     */
    public String getLabel() {
        return label;
    }

    /**
     * Set the item menu label.
     * 
     * @param label
     *            the item menu label.
     */
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * Set the sub menu containing.
     * 
     * @param subCommands
     *            the subCommands to add under this menu.
     */
    public void setSubCommands(MenuCommands... subCommands) {
        this.subCommands = subCommands;
    }

    /**
     * Set the sub menu containing.
     * 
     * @return the subCommands the sub menu containing.
     */
    public final MenuCommands[] getSubCommands() {
        return subCommands;
    }

    public boolean hasClass() {
        return this.className != null;
    }

    public String getClassname() {
        return this.className;
    }
}
