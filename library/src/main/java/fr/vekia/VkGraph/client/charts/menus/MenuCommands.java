/*
 * File: $URL: https://vklgraph.googlecode.com/svn/trunk/src/main/java/fr/vekia/VkGraph/client/charts/menus/MenuCommands.java $
 * $Id: MenuCommands.java 25 2012-08-16 14:04:01Z steeve.vandecappelle@gmail.com $
 * Licence MIT
 *
 * Last change:
 * $Date: 2012-08-16 16:04:01 +0200 (jeu., 16 août 2012) $
 * $Author: steeve.vandecappelle@gmail.com $
 */
package fr.vekia.VkGraph.client.charts.menus;

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
    public MenuCommands[] getSubCommands() {
	return subCommands;
    }
}
