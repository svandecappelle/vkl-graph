/*
 * File: $URL: https://vklgraph.googlecode.com/svn/trunk/src/main/java/fr/vekia/VkGraph/client/charts/ChartRightMenuController.java $
 * $Id: ChartRightMenuController.java 37 2012-09-07 07:35:08Z steeve.vandecappelle@gmail.com $
 * Licence MIT
 *
 * Last change:
 * $Date: 2012-09-07 09:35:08 +0200 (ven., 07 sept. 2012) $
 * $Author: steeve.vandecappelle@gmail.com $
 */
package fr.vekia.VkGraph.client.charts;

import com.google.gwt.user.client.ui.Widget;

import fr.vekia.VkGraph.client.charts.menus.MenuCommands;
import fr.vekia.VkGraph.client.charts.menus.RightClickMenuWidget;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 3 sept. 2012. VklGraph version 1.2
 * @version 2.1
 * 
 *          {@inheritDoc}
 */
public class ChartRightMenuController {
    // When export is enable. This button to export is visible.
    private RightClickMenuWidget menu;

    // true if export to PNG is effective (using right click menu).
    private boolean exportEnable;
    // true if deferred replot is effective (using right click menu).
    private boolean refreshManualEnable;
    // true if theme changing is effective (using right click menu).
    private boolean changeThemingEnable;

    private Chart<?> chart;

    private Exporter exporter;
    private MenuCommands exportCommand;

    private MenuCommands refreshCommand;

    private MenuCommands themingCommand;

    private Widget childToBind;

    private static I18nFields defaultI18nConstants = new I18nFields() {   
	    @Override
	    public String themes() {
			return "Themes";
	    }
	    
	    @Override
	    public String refresh() {
			return "Refresh";
	    }
	    
	    @Override
	    public String export() {
			return "Export";
	    }
	}; 

    public static void setDefaultI18nConstants(I18nFields fieldsI18n){
    	if(fieldsI18n!=null){
    		defaultI18nConstants = fieldsI18n;
    	}else{
    		defaultI18nConstants = new I18nFields() {   
			    @Override
			    public String themes() {
					return "Themes";
			    }
			    
			    @Override
			    public String refresh() {
					return "Refresh";
			    }
			    
			    @Override
			    public String export() {
					return "Export";
			    }
			};
		}
    }

    public ChartRightMenuController() {
		this(defaultI18nConstants);
    }

    /**
     * Default constructor
     * 
     */
    public ChartRightMenuController(I18nFields fields) {
		this.menu = new RightClickMenuWidget();
		// export to PNG.
		this.exportCommand = new MenuCommands(fields.export()) {

		    @Override
		    public void execute() {
			exporter.export();
			menu.hideMenu();
		    }
		};
		// refresh by right click only.
		this.refreshCommand = new MenuCommands(fields.refresh()) {

		    @Override
		    public void execute() {
			chart.replot();
			menu.hideMenu();
		    }
		};
		// activate the defaults themes.
		themingCommand = new MenuCommands(fields.themes()) {

		    @Override
		    public void execute() {
		    }
		};
    }

    public void activate(Chart<?> chart, Widget childToBind) {
		this.childToBind = childToBind;
		this.menu.setWidget(childToBind);
		this.chart = chart;
		this.chart.setWidget(this.menu);
		this.themingCommand.setSubCommands(Theming.getDefault(chart, menu));
    }

    /**
     * @param isEnable
     */
    public void setExportEnable(final Exporter exporter, boolean isEnable) {
		if (isEnable && !this.exportEnable) {
		    this.exportEnable = isEnable;
		    this.exporter = exporter;
		    menu.addToMenu(exportCommand);
		} else if (!isEnable && exportEnable) {
		    this.menu.removeToMenu(exportCommand);
		}
		checkMenu();
    }

    /**
     * @param command
     */
    public void addToMenu(MenuCommands command) {
		menu.addToMenu(command);
    }

    /**
     * @param isEnable
     */
    public void setRefreshManualEnable(boolean isEnable) {
		if (isEnable && !this.refreshManualEnable) {
		    this.refreshManualEnable = isEnable;
		    menu.addToMenu(refreshCommand);
		} else if (!isEnable && refreshManualEnable) {
		    this.menu.removeToMenu(refreshCommand);
		}
		checkMenu();
    }

    /**
     * @param isEnable
     */
    public void setTemingEnable(boolean isEnable) {
		if (isEnable && !this.changeThemingEnable) {
		    this.changeThemingEnable = isEnable;
		    menu.addToMenu(this.themingCommand);
		} else if (!isEnable && this.changeThemingEnable) {
		    this.menu.removeToMenu(themingCommand);
		}
		checkMenu();
    }

    /**
     * 
     */
    private void checkMenu() {
		if (this.menu.isEmpty()) {
		    this.desactivate();
		}
    }

    /**
     * 
     */
    private void desactivate() {
		this.chart.setWidget(childToBind);
		this.menu.setDefaultBrowserBehaviorEnable(true);
    }

}
