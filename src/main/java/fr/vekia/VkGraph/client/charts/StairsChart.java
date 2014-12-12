package fr.vekia.VkGraph.client.charts;

public class StairsChart<T> extends LineChart<T> {

	/**
	 * Default constructor
	 */
	public StairsChart() {
		super.setRenderer(RenderersEnum.Stairs);
	}

	/**
	 * Constructor with specifics I18n constants
	 * 
	 */
	public StairsChart(I18nFields i18nFields) {
		super(i18nFields);
		super.setRenderer(RenderersEnum.Stairs);
	}
}
