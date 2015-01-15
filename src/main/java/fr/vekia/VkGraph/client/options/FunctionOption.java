package fr.vekia.VkGraph.client.options;

public abstract class FunctionOption {

	private Object[] arguments;

	public abstract Object onExecute(Object... arguments);

	private void init(int size) {
		this.arguments = new Object[size];
	}

	public void setArgument(int index, Object argument) {
		this.arguments[index] = argument;
	}

	private Object dispatcher() {
		return onExecute(this.arguments);
	}

	// @formatter:off
	public native Object execute(Object[] arguments)/*-{
		var argumentsSize = arguments.length;
		
		this.@fr.vekia.VkGraph.client.options.FunctionOption::init(I)(argumentsSize);
		
		for(var i=0; i<argumentsSize; ++i) {
	    	var arguement = arguments[i];
	    	this.@fr.vekia.VkGraph.client.options.FunctionOption::setArgument(ILjava/lang/Object;)(i, arguement);
	    }
		return this.@fr.vekia.VkGraph.client.options.FunctionOption::dispatcher()();
	}-*/;
	// @formatter:on
}
