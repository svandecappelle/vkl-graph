package fr.vekia.vkgraph.client.options;

/**
 * Javascript function option binding.
 * 
 * @author svandecappelle
 * @since 1.3.0
 */
public abstract class FunctionOption {

    private Object[] arguments;

    public abstract Object onExecute(Object... arguments);

    protected void init(int size) {
        // this method is used by execute() JSNI native method
        this.arguments = new Object[size];
    }

    public void setArgument(int index, Object argument) {
        this.arguments[index] = argument;
    }

    private Object dispatcher() {
        return onExecute(this.arguments);
    }

    // @formatter:off
	/**
	 * On execute function from JavaScript side.
	 * Typically a formatter.
	 * 
	 * @param arguments arguments executed with.
	 * @return the Object need to return from function.
	 */
	public native Object execute(Object[] arguments)/*-{
		var argumentsSize = arguments.length;
		
		this.@fr.vekia.vkgraph.client.options.FunctionOption::init(I)(argumentsSize);
		
		for(var i=0; i<argumentsSize; ++i) {
	    	var arguement = arguments[i];
	    	this.@fr.vekia.vkgraph.client.options.FunctionOption::setArgument(ILjava/lang/Object;)(i, arguement);
	    }
		return this.@fr.vekia.vkgraph.client.options.FunctionOption::dispatcher()();
	}-*/;
	// @formatter:on
}
