package fr.vekia.vkgraph.client.options;

public abstract class FormatterFunction extends FunctionOption {

    @Override
    public Object onExecute(Object... arguments) {
        return onFormat(arguments[0].toString(), arguments[1]);
    }

    public abstract String onFormat(String format, Object data);

}
