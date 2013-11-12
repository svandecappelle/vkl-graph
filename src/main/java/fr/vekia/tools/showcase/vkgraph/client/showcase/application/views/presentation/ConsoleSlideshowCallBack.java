/*
 * File: $URL: svn+ssh://chimay/home/svn/VkGraph-showcase/VkGraph-showcase/src/main/java/fr.vekia.tools.showcase.vkgraph/client/showcase/application/views/presentation/ConsoleSlideshowCallBack.java $
 * $Id: ConsoleSlideshowCallBack.java 42 2012-08-31 13:58:13Z svandecappelle $
 * Licence MIT
 *
 * Last change:
 * $Date: 2012-08-31 15:58:13 +0200 (ven., 31 août 2012) $
 * $Author: svandecappelle $
 */
package fr.vekia.tools.showcase.vkgraph.client.showcase.application.views.presentation;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.IsWidget;

/**
 * @author Steeve Vandecappelle (SVA)
 * @since 30 août 2012. VklGraph version 1.2
 * @version 2.1
 * 
 *          {@inheritDoc}
 */
public class ConsoleSlideshowCallBack implements AsyncCallback<String> {
	private HTML codingWidget;

	private CallbackEventController<ConsoleSlideshowCallBack, IsWidget> controller;

	/**
	 * Default constructor
	 * 
	 * @param callBackEventController
	 */
	public ConsoleSlideshowCallBack(
			CallbackEventController<ConsoleSlideshowCallBack, IsWidget> callBackEventController) {
		this.controller = callBackEventController;
	}

	@Override
	public void onFailure(Throwable caught) {
		this.controller.onError(caught);
	}

	@Override
	public void onSuccess(String code) {
		HTML codeHTML = new HTML(code);
		codeHTML.addStyleName("consoleCode");
		this.controller.pop(codeHTML);
	}

	/**
	 * @return the codingWidget
	 */
	public HTML getCodingWidget() {
		return codingWidget;
	}

}
