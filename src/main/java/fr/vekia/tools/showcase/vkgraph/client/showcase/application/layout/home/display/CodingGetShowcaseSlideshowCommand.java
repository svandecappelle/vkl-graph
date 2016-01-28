package fr.vekia.tools.showcase.vkgraph.client.showcase.application.layout.home.display;

import com.google.gwt.user.client.Command;
import com.google.inject.Inject;

import fr.vekia.tools.showcase.vkgraph.client.showcase.application.services.CodeServiceAsync;

public class CodingGetShowcaseSlideshowCommand implements Command {

    @Inject
    private CodeServiceAsync service;

    private Class<?> classBinded;
    private ConsoleSlideshowCallBack callBack;

    /**
     * Default constructor
     * 
     */
    public CodingGetShowcaseSlideshowCommand configure(ConsoleSlideshowCallBack callBack, Class<?> classBinded) {
        this.classBinded = classBinded;
        this.callBack = callBack;
        return this;
    }

    @Override
    public void execute() {
        service.getCode(this.classBinded.getName(), callBack);
    }

}