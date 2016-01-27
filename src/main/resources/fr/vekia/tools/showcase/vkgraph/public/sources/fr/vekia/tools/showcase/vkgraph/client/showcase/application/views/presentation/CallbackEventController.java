package fr.vekia.tools.showcase.vkgraph.client.showcase.application.views.presentation;

import java.util.LinkedList;
import java.util.List;

import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 30 août 2012. VklGraph version 1.2
 * @version 2.1
 * @param <B>
 */
public abstract class CallbackEventController<T extends AsyncCallback<?>, B> implements AsyncCallback<List<B>>, Command {

    private LinkedList<Command> traitment;
    private List<B> callBacksReturns;

    /**
     * Default constructor
     * 
     */
    public CallbackEventController() {
        this.traitment = new LinkedList<Command>();
        this.callBacksReturns = new LinkedList<B>();
    }

    /**
     * @param callBackPop
     * 
     */
    public void pop(B callBackPop) {
        this.traitment.poll();
        this.callBacksReturns.add(callBackPop);
        if (this.traitment.isEmpty()) {
            onSuccess(this.callBacksReturns);
        } else {
            this.execute();
        }
    }

    public void onError(Throwable exception) {
        onFailure(exception);
    }

    /**
     * @param command
     */
    public void addTraitment(Command command) {
        this.traitment.add(command);
    }

    @Override
    public void execute() {
        if (!this.traitment.isEmpty()) {
            this.traitment.getFirst().execute();
        } else {
            throw new IllegalArgumentException("Your runable stack is empty you should add some commands to run and asyncallback linked run.");
        }
    }
}
