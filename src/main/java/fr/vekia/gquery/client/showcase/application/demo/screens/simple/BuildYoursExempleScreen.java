/*
 * File: $URL$
 * $Id$
 * Copyright: Vekia
 *
 * Last change:
 * $Date$
 * $Author$
 */
package fr.vekia.gquery.client.showcase.application.demo.screens.simple;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

import fr.vekia.VkGraph.client.charts.AbstractChart;
import fr.vekia.VkGraph.client.charts.ChartUtilsFactory;
import fr.vekia.VkGraph.client.charts.RenderersEnum;
import fr.vekia.VkGraph.client.datas.DataGraph;
import fr.vekia.VkGraph.client.options.ChartOption;
import fr.vekia.VkGraph.client.options.HasType;
import fr.vekia.VkGraph.client.options.IsOption;
import fr.vekia.VkGraph.client.options.OptionType;
import fr.vekia.VkGraph.client.options.SubOption;

/**
 * @author svandecappelle
 * @since Nov 23, 20row2. Provisia version : 2.row
 * @version 2.row
 * 
 *          {@inheritDoc}
 */
public class BuildYoursExempleScreen extends Composite {

    private AbstractChart<Number> chartGeneric;
    final FlexTable optionsTable = new FlexTable();

    /**
     * Default constructor
     * 
     */
    public BuildYoursExempleScreen() {

	chartGeneric = new AbstractChart<Number>();
	optionsTable.addStyleName("gwt-DataTable");
	optionsTable.getColumnFormatter().setStyleName(0, "gwt-DataTableTitle");

	// chart static datas:
	final List<Number> datas = new ArrayList<Number>();
	datas.add(1);
	datas.add(2);
	datas.add(1);
	datas.add(2);
	datas.add(3);
	datas.add(4);
	datas.add(4);
	datas.add(7);
	datas.add(3);

	final DataGraph<Number> dataGraph = new DataGraph<Number>();
	dataGraph.setMultiple(false);
	dataGraph.setValue(datas);

	Button addButton = new Button("Add Option");
	addButton.addClickHandler(new ClickHandler() {

	    @Override
	    public void onClick(ClickEvent event) {
		int newRowId = optionsTable.getRowCount() - 2;
		optionsTable.insertRow(newRowId);
		optionsTable.setWidget(newRowId, 0, new ListChartOption(newRowId));
	    }
	});

	final ListBox optionRendererList = new ListBox();
	optionRendererList.addItem(RenderersEnum.Line.name());
	optionRendererList.addItem(RenderersEnum.Bar.name());
	optionRendererList.addItem(RenderersEnum.Pie.name());
	optionRendererList.addChangeHandler(new ChangeHandler() {

	    @Override
	    public void onChange(ChangeEvent event) {
		chartGeneric.setRenderer(RenderersEnum.valueOf(optionRendererList.getValue(optionRendererList.getSelectedIndex())));
	    }
	});

	int row = 0;
	optionsTable.setText(row, 0, "setRenderer");
	optionsTable.setWidget(row, 1, optionRendererList);
	row++;
	optionsTable.setWidget(row, 2, addButton);

	row++;

	Button applyChanges = new Button("Apply changes");

	row++;
	optionsTable.setWidget(row, 0, applyChanges);
	optionsTable.getFlexCellFormatter().setColSpan(row, 0, 3);

	row++;
	final SimplePanel chartContainer = new SimplePanel();
	optionsTable.setWidget(row, 0, chartContainer);
	optionsTable.getFlexCellFormatter().setColSpan(row, 0, 3);

	// event refresh :
	applyChanges.addClickHandler(new ClickHandler() {

	    @Override
	    public void onClick(ClickEvent event) {
		// rebuild the chart
		AbstractChart<Number> clonedChart = new AbstractChart<Number>();
		clonedChart.setDataGraph(dataGraph);

		if (chartGeneric != null) {
		    ChartUtilsFactory.cloneOptions(chartGeneric, clonedChart);
		    clonedChart.setListView(true);
		    clonedChart.setPluginsEnable(true);
		}

		chartGeneric = clonedChart;
		chartContainer.setWidget(chartGeneric);
		chartGeneric = new AbstractChart<Number>();
		ChartUtilsFactory.cloneOptions(clonedChart, chartGeneric);
	    }
	});

	initWidget(optionsTable);

    }

    private class ListChartOption extends ListBox implements HasIsOption {
	protected ChartOption option;
	private int rowId;

	/**
	 * Default constructor
	 * 
	 */
	public ListChartOption(final int rowId) {
	    this.rowId = rowId;
	    for (ChartOption option : ChartOption.values()) {
		addItem(option.name());
	    }
	    option = ChartOption.valueOf(ListChartOption.this.getValue(ListChartOption.this.getSelectedIndex()));
	    changeWidget();
	    addChangeHandler(new ChangeHandler() {

		@Override
		public void onChange(ChangeEvent event) {
		    option = ChartOption.valueOf(ListChartOption.this.getValue(ListChartOption.this.getSelectedIndex()));
		    changeWidget();
		}
	    });

	}

	private void changeWidget() {
	    BuildYoursExempleScreen.this.changeWidget(rowId, 1, option, option, null, null, this);
	}

	@Override
	public HasIsOption getParentOption() {
	    return null;
	}

	@Override
	public void setParent(HasIsOption parentOption) {
	    // nothing
	}

	@Override
	public IsOption getOption() {
	    return option;
	}
    }

    private void apply(ChartOption option, List<SubOption> subOptions, Boolean value) {
	if (subOptions != null) {
	    switch (subOptions.size()) {

	    case 1:
		chartGeneric.setBooleanOption(option, subOptions.get(0), value);
		break;
	    case 2:
		chartGeneric.setBooleanOption(option, subOptions.get(1), subOptions.get(0), value);
		break;
	    case 3:
		chartGeneric.setOption(option, subOptions.get(2), "{" + subOptions.get(1) + ": {" + subOptions.get(0) + " : " + value + " }");
		break;
	    case 4:
		chartGeneric.setBooleanOption(option, subOptions.get(0), subOptions.get(1), value);
		break;
	    default:
		break;
	    }
	} else {
	    chartGeneric.setBooleanOption(option, value);
	}
    }

    private void apply(ChartOption option, List<SubOption> subOptions, String value) {
	if (subOptions != null) {
	    switch (subOptions.size()) {
	    case 1:
		chartGeneric.setOption(option, subOptions.get(0), value);
		break;
	    case 2:
		chartGeneric.setOption(option, subOptions.get(1), subOptions.get(0), value);
		break;
	    case 3:
		chartGeneric.setOption(option, subOptions.get(2), "{" + subOptions.get(1) + ": {" + subOptions.get(0) + " : " + value + " }");
		break;
	    case 4:
		chartGeneric.setOption(option, subOptions.get(0), subOptions.get(1), value);
		break;
	    default:
		break;
	    }
	} else {
	    chartGeneric.setOption(option, value);
	}
    }

    private void apply(ChartOption option, List<SubOption> subOptions, Number value) {
	if (subOptions != null) {
	    switch (subOptions.size()) {
	    case 1:
		chartGeneric.setNumberOption(option, subOptions.get(0), value);
		break;
	    case 2:
		chartGeneric.setNumberOption(option, subOptions.get(1), subOptions.get(0), value);
		break;
	    case 3:
		chartGeneric.setOption(option, subOptions.get(2), "{" + subOptions.get(1) + ": {" + subOptions.get(0) + " : " + value + " }");
		break;
	    case 4:
		chartGeneric.setNumberOption(option, subOptions.get(0), subOptions.get(1), value);
		break;
	    default:
		break;
	    }
	} else {
	    chartGeneric.setNumberOption(option, value);
	}
    }

    private class ListSubOption extends ListBox implements HasIsOption {

	private IsOption chartOption;
	private HasIsOption parentList;
	private int rowId;
	private int nbParentOption;

	/**
	 * Default constructor
	 * 
	 * @param chartOption
	 * @param parentList
	 * 
	 */
	public ListSubOption(final int rowId, final int nbParentOption, IsOption chartOption, HasIsOption parentList) {
	    this.rowId = rowId;
	    this.nbParentOption = nbParentOption;
	    this.chartOption = chartOption;
	    this.setParent(parentList);

	    for (SubOption subOption : SubOption.values()) {
		if (subOption.getParent().contains(chartOption)) {
		    addItem(subOption.name());
		}
	    }
	    if (ListSubOption.this.getItemCount() > 0) {
		SubOption subOption = SubOption.valueOf(ListSubOption.this.getValue(ListSubOption.this.getSelectedIndex()));
		changeWidgets(subOption);
	    }
	    addChangeHandler(new ChangeHandler() {

		@Override
		public void onChange(ChangeEvent event) {
		    if (ListSubOption.this.getValue(ListSubOption.this.getSelectedIndex()) != "NONE") {
			SubOption subOption = SubOption.valueOf(ListSubOption.this.getValue(ListSubOption.this.getSelectedIndex()));
			changeWidgets(subOption);

		    } else {
		    }
		}

	    });

	}

	// ------------------------------

	private void changeWidgets(SubOption subOption) {
	    ListSubOption.this.chartOption = subOption;
	    BuildYoursExempleScreen.this.changeWidget(rowId, nbParentOption + 1, subOption, getOptionChart(), subOption, getAllOptions(), this);
	}

	private ChartOption getOptionChart() {
	    HasIsOption chartHasIsOption = ListSubOption.this;
	    List<SubOption> subOptions = new ArrayList<SubOption>();

	    while (chartHasIsOption.getParentOption() != null) {
		if (chartHasIsOption.getOption() instanceof SubOption) {
		    subOptions.add((SubOption) chartHasIsOption.getOption());
		}
		chartHasIsOption = chartHasIsOption.getParentOption();
	    }

	    // option Chart
	    ChartOption option = (ChartOption) chartHasIsOption.getOption();
	    return option;
	}

	private List<SubOption> getAllOptions() {
	    HasIsOption chartHasIsOption = ListSubOption.this;
	    List<SubOption> subOptions = new ArrayList<SubOption>();

	    while (chartHasIsOption.getParentOption() != null) {
		if (chartHasIsOption.getOption() instanceof SubOption) {
		    subOptions.add((SubOption) chartHasIsOption.getOption());
		}
		chartHasIsOption = chartHasIsOption.getParentOption();
	    }

	    // option Chart

	    return subOptions;
	}

	@Override
	public void setParent(HasIsOption parentOption) {
	    this.parentList = parentOption;
	}

	@Override
	public HasIsOption getParentOption() {
	    return parentList;
	}

	@Override
	public IsOption getOption() {
	    return chartOption;
	}
    }

    private interface HasIsOption {
	HasIsOption getParentOption();

	void setParent(HasIsOption parentOption);

	IsOption getOption();

    }

    private void changeWidget(final int rowId, final int columnId, final HasType type, final ChartOption optionChart, SubOption subOption,
	    final List<SubOption> allSubOptions, HasIsOption hasIsOption) {
	Widget widget = null;
	if (subOption != null && type.getType() == null) {
	    widget = new ListSubOption(rowId, columnId, subOption, hasIsOption);
	} else if (type.getType() == OptionType.BOOLEAN) {
	    if (type.hasChildren()) {
		ListSubOption listOptions = new ListSubOption(rowId, 1, hasIsOption.getOption(), hasIsOption);
		listOptions.addItem("", "NONE");

		CheckBox checkBox = new CheckBox();
		checkBox.addValueChangeHandler(new ValueChangeHandler<Boolean>() {

		    @Override
		    public void onValueChange(ValueChangeEvent<Boolean> event) {
			apply(optionChart, allSubOptions, event.getValue());
		    }

		});
	
		optionsTable.setWidget(rowId, columnId + 1, checkBox);

		
		widget = listOptions;
	    } else {

		CheckBox checkBox = new CheckBox();
		checkBox.addValueChangeHandler(new ValueChangeHandler<Boolean>() {

		    @Override
		    public void onValueChange(ValueChangeEvent<Boolean> event) {
			apply(optionChart, allSubOptions, event.getValue());
		    }

		});
		widget = checkBox;
	    }

	} else if (type.getType() == OptionType.NUMBER) {
	    TextBox box = new TextBox();
	    box.addValueChangeHandler(new ValueChangeHandler<String>() {

		@Override
		public void onValueChange(ValueChangeEvent<String> event) {
		    apply(optionChart, allSubOptions, Float.parseFloat(event.getValue()));
		}
	    });
	    widget = box;
	} else if (type.getType() == OptionType.STRING) {
	    TextBox box = new TextBox();
	    box.addValueChangeHandler(new ValueChangeHandler<String>() {

		@Override
		public void onValueChange(ValueChangeEvent<String> event) {
		    apply(optionChart, allSubOptions, event.getValue());
		}
	    });
	    widget = box;
	}
	if (widget != null) {
	    optionsTable.setWidget(rowId, columnId, widget);
	    if (!(widget instanceof ListSubOption) && optionsTable.getCellCount(rowId) > columnId + 1) {
		optionsTable.removeCells(rowId, columnId + 1, optionsTable.getCellCount(rowId) - (columnId + 1));
	    }
	}
    }
}
